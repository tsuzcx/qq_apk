package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;

final class e$7
  implements Runnable
{
  e$7(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU) });
    if ((this.vhY.GJ(16)) && (!this.vhY.GJ(8))) {
      throw new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { this.vhY.vhR, Boolean.valueOf(this.vhY.vhU), Boolean.valueOf(this.vhY.byx.euf), Boolean.valueOf(this.vhY.isFinishing()), Boolean.valueOf(this.vhY.GJ(2)) }));
    }
    this.vhY.byx.euf = false;
    e.b(this.vhY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.7
 * JD-Core Version:    0.7.0.1
 */