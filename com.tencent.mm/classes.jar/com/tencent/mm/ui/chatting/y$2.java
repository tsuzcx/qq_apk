package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.c.a;

final class y$2
  implements Runnable
{
  String username = this.vmb.byx.getTalkerUserName();
  u vmc = (u)this.vmb.byx.ac(u.class);
  
  y$2(y paramy) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    if (this.vmc == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
      return;
    }
    this.vmc.adv(this.username);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.2
 * JD-Core Version:    0.7.0.1
 */