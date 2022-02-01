package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.c.b.q;

@com.tencent.mm.ui.chatting.c.a.a(eYT=m.class)
public class p
  extends a
  implements m
{
  @TargetApi(11)
  public final void dCM()
  {
    AppMethodBeat.i(35279);
    boolean bool1 = ((ae)this.cOd.be(ae.class)).eYw();
    boolean bool2 = ((ae)this.cOd.be(ae.class)).eYx();
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
            boolean bool = false;
            switch (paramAnonymous2DragEvent.getAction())
            {
            default: 
              ad.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
            }
            for (;;)
            {
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
                    Object localObject;
                    if (paramAnonymous2DragEvent.getIntent() != null)
                    {
                      localObject = p.this.cOd.GzJ;
                      paramAnonymous2DragEvent = paramAnonymous2DragEvent.getIntent();
                      paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymous2DragEvent);
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2DragEvent.adn(), "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((MMFragment)localObject).startActivity((Intent)paramAnonymous2DragEvent.lS(0));
                      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/DragDropComponent$1$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (paramAnonymous2DragEvent.getUri() != null)
                    {
                      localObject = new r(p.this.cOd.GzJ.getContext(), paramAnonymous2DragEvent.getUri());
                      if ((((r)localObject).fileType != 0) && (((r)localObject).filePath != null)) {}
                      switch (((r)localObject).fileType)
                      {
                      default: 
                        ((b)p.this.cOd.be(b.class)).a((r)localObject);
                        break;
                      case 3: 
                        paramAnonymous2DragEvent = ((r)localObject).filePath;
                        bool = u.f(paramAnonymous2DragEvent, p.this.cOd.getTalkerUserName(), true);
                        localObject = (af)p.this.cOd.be(af.class);
                        if (bool) {}
                        for (int j = 1;; j = 0)
                        {
                          ((af)localObject).Q(j, 0, paramAnonymous2DragEvent);
                          break;
                        }
                      case 4: 
                        localObject = new Intent();
                        ((Intent)localObject).setData(paramAnonymous2DragEvent.getUri());
                        ((an)p.this.cOd.be(an.class)).aw((Intent)localObject);
                        continue;
                        ad.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                        break;
                      }
                    }
                    else if ((paramAnonymous2DragEvent.getText() != null) && (paramAnonymous2DragEvent.getText().length() > 0))
                    {
                      ((ai)p.this.cOd.be(ai.class)).aKM(paramAnonymous2DragEvent.getText().toString());
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
        if (p.this.cOd.getListView() != null) {
          p.this.cOd.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((q)p.this.cOd.be(q.class)).eXs();
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
  
  public final void eQB()
  {
    AppMethodBeat.i(35280);
    dCM();
    AppMethodBeat.o(35280);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35281);
    eXq();
    AppMethodBeat.o(35281);
  }
  
  @TargetApi(11)
  public final void eXq()
  {
    AppMethodBeat.i(35278);
    if (Build.VERSION.SDK_INT < 11)
    {
      ad.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(35278);
      return;
    }
    if (this.cOd.getListView() != null) {
      this.cOd.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((q)this.cOd.be(q.class)).eXs();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(35278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.p
 * JD-Core Version:    0.7.0.1
 */