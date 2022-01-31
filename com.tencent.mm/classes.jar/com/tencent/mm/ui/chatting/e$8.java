package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$8
  implements Runnable
{
  e$8(e parame) {}
  
  public final void run()
  {
    int i = 0;
    y.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
    e locale = this.vhY;
    boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
    int j = WXHardCoderJNI.hcEnterChattingDelay;
    int k = WXHardCoderJNI.hcEnterChattingCPU;
    int m = WXHardCoderJNI.hcEnterChattingIO;
    if (WXHardCoderJNI.hcEnterChattingThr) {
      i = g.DS().crd();
    }
    locale.vhW = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
    this.vhY.byx.euf = true;
    e.a(this.vhY).cyN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.8
 * JD-Core Version:    0.7.0.1
 */