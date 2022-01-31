package com.tencent.mm.ui.chatting.b;

import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.c.a;

final class n$1
  implements Runnable
{
  n$1(n paramn) {}
  
  public final void run()
  {
    n.1.1 local1 = new n.1.1(this);
    if (this.vpW.byx.getListView() != null) {
      this.vpW.byx.getListView().setOnDragListener(local1);
    }
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.b.b.n)this.vpW.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class)).cEq();
    if (localChatFooter != null)
    {
      localChatFooter.setOnDragListener(local1);
      localChatFooter.setEditTextOnDragListener(local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.n.1
 * JD-Core Version:    0.7.0.1
 */