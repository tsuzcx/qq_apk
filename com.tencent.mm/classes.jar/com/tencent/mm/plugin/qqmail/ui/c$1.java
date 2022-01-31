package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.h.a.jz;
import com.tencent.mm.h.a.jz.b;

final class c$1
  implements Runnable
{
  c$1(c paramc, jz paramjz) {}
  
  public final void run()
  {
    if (this.fvL.bSF.bIe) {
      c.a(this.niY);
    }
    while (c.b(this.niY) == null) {
      return;
    }
    c.b(this.niY).btJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c.1
 * JD-Core Version:    0.7.0.1
 */