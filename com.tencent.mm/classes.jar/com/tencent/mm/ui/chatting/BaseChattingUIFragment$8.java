package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseChattingUIFragment$8
  implements Runnable
{
  BaseChattingUIFragment$8(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30447);
    ab.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    AppMethodBeat.o(30447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.8
 * JD-Core Version:    0.7.0.1
 */