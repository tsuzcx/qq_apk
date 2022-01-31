package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.h;

final class BaseChattingUIFragment$3
  implements Runnable
{
  BaseChattingUIFragment$3(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30442);
    ab.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    BaseChattingUIFragment.a(this.zwS).dCe();
    BaseChattingUIFragment localBaseChattingUIFragment = this.zwS;
    if (localBaseChattingUIFragment.zwR != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, localBaseChattingUIFragment.zwR);
      localBaseChattingUIFragment.zwR = 0;
    }
    this.zwS.caz.bSe = false;
    AppMethodBeat.o(30442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.3
 * JD-Core Version:    0.7.0.1
 */