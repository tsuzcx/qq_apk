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
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.s;

@com.tencent.mm.ui.chatting.d.a.a(fJv=o.class)
public class r
  extends a
  implements o
{
  @TargetApi(11)
  public final void ehi()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((aj)this.cXJ.bh(aj.class)).fIP();
    boolean bool2 = ((aj)this.cXJ.bh(aj.class)).fIQ();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(35279);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ae.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            boolean bool = false;
            switch (paramAnonymous2DragEvent.getAction())
            {
            default: 
              ae.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(35276);
              return bool;
              bool = true;
              ae.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
              continue;
              bool = true;
              ae.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
              continue;
              bool = true;
              ae.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
              continue;
              bool = true;
              ae.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
              continue;
              ae.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
              paramAnonymous2View = paramAnonymous2DragEvent.getClipData();
              if (paramAnonymous2View != null)
              {
                int k = paramAnonymous2View.getItemCount();
                int i = 0;
                if (i < k)
                {
                  paramAnonymous2DragEvent = paramAnonymous2View.getItemAt(i);
                  if (paramAnonymous2DragEvent == null) {
                    ae.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (paramAnonymous2DragEvent.getIntent() != null)
                    {
                      localObject = r.this.cXJ.Kkd;
                      paramAnonymous2DragEvent = paramAnonymous2DragEvent.getIntent();
                      paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2DragEvent);
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2DragEvent.ahE(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((MMFragment)localObject).startActivity((Intent)paramAnonymous2DragEvent.mt(0));
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (paramAnonymous2DragEvent.getUri() != null)
                    {
                      localObject = new com.tencent.mm.pluginsdk.ui.tools.r(r.this.cXJ.Kkd.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((com.tencent.mm.pluginsdk.ui.tools.r)localObject).fileType != 0) && (((com.tencent.mm.pluginsdk.ui.tools.r)localObject).filePath != null)) {}
                      switch (((com.tencent.mm.pluginsdk.ui.tools.r)localObject).fileType)
                      {
                      default: 
                        ((com.tencent.mm.ui.chatting.d.b.b)r.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a((com.tencent.mm.pluginsdk.ui.tools.r)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((com.tencent.mm.pluginsdk.ui.tools.r)localObject).filePath;
                        bool = v.f(paramAnonymous2DragEvent, r.this.cXJ.getTalkerUserName(), true);
                        localObject = (ak)r.this.cXJ.bh(ak.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((ak)localObject).R(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((as)r.this.cXJ.bh(as.class)).aD((Intent)localObject);
                        continue;
                        ae.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((an)r.this.cXJ.bh(an.class)).aXJ(paramAnonymous2DragEvent.getText().toString());
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
        if (r.this.cXJ.getListView() != null) {
          r.this.cXJ.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((s)r.this.cXJ.bh(s.class)).fHF();
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
  
  public final void fAt()
  {
    AppMethodBeat.i(35280);
    ehi();
    AppMethodBeat.o(35280);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35281);
    fHD();
    AppMethodBeat.o(35281);
  }
  
  @TargetApi(11)
  public final void fHD()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      ae.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.cXJ.getListView() != null) {
      this.cXJ.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((s)this.cXJ.bh(s.class)).fHF();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.r
 * JD-Core Version:    0.7.0.1
 */