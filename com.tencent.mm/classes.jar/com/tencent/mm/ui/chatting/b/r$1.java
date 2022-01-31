package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;

final class r$1
  implements Runnable
{
  r$1(r paramr) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    r.a(this.vqB, ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(this.vqB.byx.getTalkerUserName()));
    if (r.a(this.vqB) == null) {
      return;
    }
    y.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.vqB.byx.getTalkerUserName(), Long.valueOf(r.a(this.vqB).field_createTime) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.r.1
 * JD-Core Version:    0.7.0.1
 */