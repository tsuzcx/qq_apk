package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.chatting.c.h;

final class BaseChattingUIFragment$10
  implements Runnable
{
  BaseChattingUIFragment$10(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(30449);
    ab.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    BaseChattingUIFragment localBaseChattingUIFragment = this.zwS;
    boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
    int j = WXHardCoderJNI.hcEnterChattingDelay;
    int k = WXHardCoderJNI.hcEnterChattingCPU;
    int m = WXHardCoderJNI.hcEnterChattingIO;
    if (WXHardCoderJNI.hcEnterChattingThr) {
      i = g.RO().dtc();
    }
    localBaseChattingUIFragment.zwQ = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
    this.zwS.caz.bSe = true;
    BaseChattingUIFragment.a(this.zwS).dBZ();
    AppMethodBeat.o(30449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.10
 * JD-Core Version:    0.7.0.1
 */