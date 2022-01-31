package com.tencent.mm.ui.chatting.c;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.z;

@com.tencent.mm.ui.chatting.c.a.a(dJy=l.class)
public class n
  extends a
  implements l
{
  @TargetApi(11)
  public final void cwA()
  {
    AppMethodBeat.i(31389);
    boolean bool1 = ((z)this.caz.ay(z.class)).dJb();
    boolean bool2 = ((z)this.caz.ay(z.class)).dJc();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(31389);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ab.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(31389);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31387);
        n.1.1 local1 = new n.1.1(this);
        if (n.this.caz.getListView() != null) {
          n.this.caz.getListView().setOnDragListener(local1);
        }
        ChatFooter localChatFooter = ((o)n.this.caz.ay(o.class)).dIg();
        if (localChatFooter != null)
        {
          localChatFooter.setOnDragListener(local1);
          localChatFooter.setEditTextOnDragListener(local1);
        }
        AppMethodBeat.o(31387);
      }
    }.run();
    AppMethodBeat.o(31389);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31390);
    cwA();
    AppMethodBeat.o(31390);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31391);
    dIe();
    AppMethodBeat.o(31391);
  }
  
  @TargetApi(11)
  public final void dIe()
  {
    AppMethodBeat.i(31388);
    if (Build.VERSION.SDK_INT < 11)
    {
      ab.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      AppMethodBeat.o(31388);
      return;
    }
    if (this.caz.getListView() != null) {
      this.caz.getListView().setOnDragListener(null);
    }
    ChatFooter localChatFooter = ((o)this.caz.ay(o.class)).dIg();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(null);
      localChatFooter.setEditTextOnDragListener(null);
    }
    AppMethodBeat.o(31388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.n
 * JD-Core Version:    0.7.0.1
 */