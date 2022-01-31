package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.d.a;

final class r$1
  implements Runnable
{
  r$1(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(31440);
    long l = System.currentTimeMillis();
    r.a(this.zGh, ((j)g.E(j.class)).bPQ().Tm(this.zGh.caz.getTalkerUserName()));
    if (r.a(this.zGh) == null)
    {
      AppMethodBeat.o(31440);
      return;
    }
    ab.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.zGh.caz.getTalkerUserName(), Long.valueOf(r.a(this.zGh).field_createTime) });
    AppMethodBeat.o(31440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r.1
 * JD-Core Version:    0.7.0.1
 */