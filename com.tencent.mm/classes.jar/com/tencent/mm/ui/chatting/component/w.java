package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.chatting.component.api.ay;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.component.api.s;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.transmit.SelectNoSupportUI;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=s.class)
public class w
  extends a
  implements s
{
  public final void hqq()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((au)this.hlc.cm(au.class)).jty();
    boolean bool2 = ((au)this.hlc.cm(au.class)).jtz();
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
                  paramAnonymous2DragEvent.setClass(w.this.hlc.aezO.getContext(), SelectNoSupportUI.class);
                  paramAnonymous2DragEvent.putExtra("sharePictureTo", "friend");
                  paramAnonymous2DragEvent.addFlags(268435456).addFlags(67108864);
                  paramAnonymous2View = w.this.hlc;
                  paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymous2DragEvent);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, paramAnonymous2DragEvent.aYi(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2View.startActivity((Intent)paramAnonymous2DragEvent.sb(0));
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
                      localObject = new u(w.this.hlc.aezO.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((u)localObject).fileType != 0) && (((u)localObject).filePath != null)) {}
                      switch (((u)localObject).fileType)
                      {
                      default: 
                        ((com.tencent.mm.ui.chatting.component.api.b)w.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.b.class)).a((u)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((u)localObject).filePath;
                        bool = z.h(paramAnonymous2DragEvent, w.this.hlc.getTalkerUserName(), true);
                        localObject = (av)w.this.hlc.cm(av.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((av)localObject).ab(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((be)w.this.hlc.cm(be.class)).bd((Intent)localObject);
                        continue;
                        Log.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((ay)w.this.hlc.cm(ay.class)).bAS(paramAnonymous2DragEvent.getText().toString());
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
        if (w.this.hlc.getListView() != null) {
          w.this.hlc.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((x)w.this.hlc.cm(x.class)).jsd();
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
  
  public final void jjg()
  {
    AppMethodBeat.i(35280);
    hqq();
    AppMethodBeat.o(35280);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35281);
    jrX();
    AppMethodBeat.o(35281);
  }
  
  public final void jrX()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.hlc.getListView() != null) {
      this.hlc.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((x)this.hlc.cm(x.class)).jsd();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.w
 * JD-Core Version:    0.7.0.1
 */