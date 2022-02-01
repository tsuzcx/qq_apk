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
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(gRF=p.class)
public class s
  extends a
  implements p
{
  @TargetApi(11)
  public final void fjK()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((am)this.dom.bh(am.class)).gQZ();
    boolean bool2 = ((am)this.dom.bh(am.class)).gRa();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(35279);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            boolean bool = false;
            switch (paramAnonymous2DragEvent.getAction())
            {
            default: 
              Log.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(35276);
              return bool;
              bool = true;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
              continue;
              bool = true;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
              continue;
              bool = true;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
              continue;
              bool = true;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
              continue;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
              paramAnonymous2View = paramAnonymous2DragEvent.getClipData();
              if (paramAnonymous2View != null)
              {
                int k = paramAnonymous2View.getItemCount();
                int i = 0;
                if (i < k)
                {
                  paramAnonymous2DragEvent = paramAnonymous2View.getItemAt(i);
                  if (paramAnonymous2DragEvent == null) {
                    Log.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (paramAnonymous2DragEvent.getIntent() != null)
                    {
                      localObject = s.this.dom.Pwc;
                      paramAnonymous2DragEvent = paramAnonymous2DragEvent.getIntent();
                      paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2DragEvent);
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2DragEvent.axQ(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((MMFragment)localObject).startActivity((Intent)paramAnonymous2DragEvent.pG(0));
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (paramAnonymous2DragEvent.getUri() != null)
                    {
                      localObject = new t(s.this.dom.Pwc.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((t)localObject).fileType != 0) && (((t)localObject).filePath != null)) {}
                      switch (((t)localObject).fileType)
                      {
                      default: 
                        ((com.tencent.mm.ui.chatting.d.b.b)s.this.dom.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a((t)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((t)localObject).filePath;
                        bool = z.f(paramAnonymous2DragEvent, s.this.dom.getTalkerUserName(), true);
                        localObject = (an)s.this.dom.bh(an.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((an)localObject).T(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((av)s.this.dom.bh(av.class)).aK((Intent)localObject);
                        continue;
                        Log.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((aq)s.this.dom.bh(aq.class)).bmO(paramAnonymous2DragEvent.getText().toString());
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
        if (s.this.dom.getListView() != null) {
          s.this.dom.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((u)s.this.dom.bh(u.class)).gPO();
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
  
  public final void gIl()
  {
    AppMethodBeat.i(35280);
    fjK();
    AppMethodBeat.o(35280);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35281);
    gPM();
    AppMethodBeat.o(35281);
  }
  
  @TargetApi(11)
  public final void gPM()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.dom.getListView() != null) {
      this.dom.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((u)this.dom.bh(u.class)).gPO();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.s
 * JD-Core Version:    0.7.0.1
 */