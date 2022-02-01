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
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.transmit.SelectNoSupportUI;

@com.tencent.mm.ui.chatting.d.a.a(hRc=p.class)
public class t
  extends a
  implements p
{
  @TargetApi(11)
  public final void fXV()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((an)this.fgR.bC(an.class)).hQw();
    boolean bool2 = ((an)this.fgR.bC(an.class)).hQx();
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            boolean bool;
            switch (paramAnonymous2DragEvent.getAction())
            {
            default: 
              Log.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
              bool = false;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(35276);
              return bool;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
              bool = true;
              continue;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
              bool = true;
              continue;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
              bool = true;
              continue;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
              bool = true;
              continue;
              Log.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
              paramAnonymous2View = paramAnonymous2DragEvent.getClipData();
              if (paramAnonymous2View != null)
              {
                int k = paramAnonymous2View.getItemCount();
                if (k > 9)
                {
                  paramAnonymous2DragEvent = new Intent();
                  paramAnonymous2DragEvent.setClass(t.this.fgR.WQv.getContext(), SelectNoSupportUI.class);
                  paramAnonymous2DragEvent.putExtra("sharePictureTo", "friend");
                  paramAnonymous2DragEvent.addFlags(268435456).addFlags(67108864);
                  paramAnonymous2View = t.this.fgR;
                  paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymous2DragEvent);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, paramAnonymous2DragEvent.aFh(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2View.startActivity((Intent)paramAnonymous2DragEvent.sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2View, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                  AppMethodBeat.o(35276);
                  return true;
                }
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
                    if (paramAnonymous2DragEvent.getUri() != null)
                    {
                      localObject = new v(t.this.fgR.WQv.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((v)localObject).fileType != 0) && (((v)localObject).filePath != null)) {}
                      switch (((v)localObject).fileType)
                      {
                      default: 
                        ((com.tencent.mm.ui.chatting.d.b.b)t.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.b.class)).a((v)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((v)localObject).filePath;
                        bool = z.f(paramAnonymous2DragEvent, t.this.fgR.getTalkerUserName(), true);
                        localObject = (ao)t.this.fgR.bC(ao.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((ao)localObject).R(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((aw)t.this.fgR.bC(aw.class)).aI((Intent)localObject);
                        continue;
                        Log.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((ar)t.this.fgR.bC(ar.class)).bzp(paramAnonymous2DragEvent.getText().toString());
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
        if (t.this.fgR.getListView() != null) {
          t.this.fgR.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((u)t.this.fgR.bC(u.class)).hPj();
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
  
  public final void hGV()
  {
    AppMethodBeat.i(35280);
    fXV();
    AppMethodBeat.o(35280);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35281);
    hPg();
    AppMethodBeat.o(35281);
  }
  
  @TargetApi(11)
  public final void hPg()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.fgR.getListView() != null) {
      this.fgR.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((u)this.fgR.bC(u.class)).hPj();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.t
 * JD-Core Version:    0.7.0.1
 */