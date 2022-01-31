package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$10
  implements Runnable
{
  e$10(e parame) {}
  
  public final void run()
  {
    int i = 0;
    y.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
    e locale = this.vhY;
    boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
    int j = WXHardCoderJNI.hcQuitChattingDelay;
    int k = WXHardCoderJNI.hcQuitChattingCPU;
    int m = WXHardCoderJNI.hcQuitChattingIO;
    if (WXHardCoderJNI.hcQuitChattingThr) {
      i = g.DS().crd();
    }
    locale.vhX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
    e.a(this.vhY).cyR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.10
 * JD-Core Version:    0.7.0.1
 */