package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.h;

final class e$5
  implements Runnable
{
  e$5(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
    e.a(this.vhY).cyQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.5
 * JD-Core Version:    0.7.0.1
 */