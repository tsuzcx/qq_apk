package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.d.a;

final class ChattingUIFragment$5
  implements Runnable
{
  String username;
  v zBC;
  
  ChattingUIFragment$5(ChattingUIFragment paramChattingUIFragment)
  {
    AppMethodBeat.i(30834);
    this.zBC = ((v)this.zBB.caz.ay(v.class));
    this.username = this.zBB.caz.getTalkerUserName();
    AppMethodBeat.o(30834);
  }
  
  public final void run()
  {
    AppMethodBeat.i(30835);
    long l = System.currentTimeMillis();
    if (this.zBC == null)
    {
      ab.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
      AppMethodBeat.o(30835);
      return;
    }
    this.zBC.atX(this.username);
    ab.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(30835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.5
 * JD-Core Version:    0.7.0.1
 */