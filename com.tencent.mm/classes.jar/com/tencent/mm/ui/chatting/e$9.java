package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$9
  implements Runnable
{
  e$9(e parame) {}
  
  public final void run()
  {
    e.a(this.vhY).cyO();
    e locale = this.vhY;
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcEnterChattingEnable, locale.vhW);
    locale.vhW = 0;
    y.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.9
 * JD-Core Version:    0.7.0.1
 */