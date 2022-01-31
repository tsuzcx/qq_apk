package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    this.vhY.byx.euf = true;
    e.a(this.vhY).cyM();
    y.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.1
 * JD-Core Version:    0.7.0.1
 */