package com.tencent.mm.ui.chatting.d;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.s;

@com.tencent.mm.ui.chatting.d.a.a(fFo=o.class)
public class r
  extends a
  implements o
{
  @TargetApi(11)
  public final void edB()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((ai)this.cWM.bh(ai.class)).fEM();
    boolean bool2 = ((ai)this.cWM.bh(ai.class)).fEN();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(35279);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ad.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35279);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35277);
        View.OnDragListener local1 = new View.OnDragListener()
        {
          public final boolean onDrag(View paramAnonymous2View, DragEvent paramAnonymous2DragEvent)
          {
            AppMethodBeat.i(35276);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            boolean bool = false;
            switch (paramAnonymous2DragEvent.getAction())
            {
            default: 
              ad.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(35276);
              return bool;
              bool = true;
              ad.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
              continue;
              bool = true;
              ad.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
              continue;
              bool = true;
              ad.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
              continue;
              bool = true;
              ad.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
              continue;
              ad.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
              paramAnonymous2View = paramAnonymous2DragEvent.getClipData();
              if (paramAnonymous2View != null)
              {
                int k = paramAnonymous2View.getItemCount();
                int i = 0;
                if (i < k)
                {
                  paramAnonymous2DragEvent = paramAnonymous2View.getItemAt(i);
                  if (paramAnonymous2DragEvent == null) {
                    ad.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (paramAnonymous2DragEvent.getIntent() != null)
                    {
                      localObject = r.this.cWM.JOR;
                      paramAnonymous2DragEvent = paramAnonymous2DragEvent.getIntent();
                      paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2DragEvent);
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2DragEvent.ahp(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((MMFragment)localObject).startActivity((Intent)paramAnonymous2DragEvent.mq(0));
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (paramAnonymous2DragEvent.getUri() != null)
                    {
                      localObject = new com.tencent.mm.pluginsdk.ui.tools.r(r.this.cWM.JOR.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((com.tencent.mm.pluginsdk.ui.tools.r)localObject).fileType != 0) && (((com.tencent.mm.pluginsdk.ui.tools.r)localObject).filePath != null)) {}
                      switch (((com.tencent.mm.pluginsdk.ui.tools.r)localObject).fileType)
                      {
                      default: 
                        ((com.tencent.mm.ui.chatting.d.b.b)r.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a((com.tencent.mm.pluginsdk.ui.tools.r)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((com.tencent.mm.pluginsdk.ui.tools.r)localObject).filePath;
                        bool = u.f(paramAnonymous2DragEvent, r.this.cWM.getTalkerUserName(), true);
                        localObject = (aj)r.this.cWM.bh(aj.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((aj)localObject).R(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((ar)r.this.cWM.bh(ar.class)).aC((Intent)localObject);
                        continue;
                        ad.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((am)r.this.cWM.bh(am.class)).aWi(paramAnonymous2DragEvent.getText().toString());
                    }
                  }
                }
                bool = true;
              }
              else
              {
                bool = true;
              }
            }
          }
        };
        if (r.this.cWM.getListView() != null) {
          r.this.cWM.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((s)r.this.cWM.bh(s.class)).fDC();
        if (localChatFooter != null)
        {
          localChatFooter.setOnDragListener(local1);
          localChatFooter.setEditTextOnDragListener(local1);
        }
        AppMethodBeat.o(35277);
      }
    }.run();
    AppMethodBeat.o(35279);
  }
  
  @TargetApi(11)
  public final void fDA()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      ad.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.cWM.getListView() != null) {
      this.cWM.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((s)this.cWM.bh(s.class)).fDC();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35280);
    edB();
    AppMethodBeat.o(35280);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35281);
    fDA();
    AppMethodBeat.o(35281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.r
 * JD-Core Version:    0.7.0.1
 */