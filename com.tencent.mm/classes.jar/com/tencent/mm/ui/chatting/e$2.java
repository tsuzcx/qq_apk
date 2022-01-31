package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
    e.a(this.vhY).cyS();
    e locale = this.vhY;
    if (locale.vhX != 0)
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcQuitChattingEnable, locale.vhX);
      locale.vhX = 0;
    }
    this.vhY.byx.euf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.2
 * JD-Core Version:    0.7.0.1
 */