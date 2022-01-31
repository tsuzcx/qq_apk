package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.h;

final class BaseChattingUIFragment$11
  implements Runnable
{
  BaseChattingUIFragment$11(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30450);
    BaseChattingUIFragment.a(this.zwS).dCa();
    BaseChattingUIFragment localBaseChattingUIFragment = this.zwS;
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.zwQ);
    localBaseChattingUIFragment.zwQ = 0;
    ab.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    AppMethodBeat.o(30450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.11
 * JD-Core Version:    0.7.0.1
 */