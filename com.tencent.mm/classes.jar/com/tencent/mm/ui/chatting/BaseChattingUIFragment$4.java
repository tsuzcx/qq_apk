package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.h;

final class BaseChattingUIFragment$4
  implements Runnable
{
  BaseChattingUIFragment$4(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30443);
    this.zwS.caz.bSe = true;
    BaseChattingUIFragment.a(this.zwS).dBY();
    ab.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    AppMethodBeat.o(30443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.4
 * JD-Core Version:    0.7.0.1
 */