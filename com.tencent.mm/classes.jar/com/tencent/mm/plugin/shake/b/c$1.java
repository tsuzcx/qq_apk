package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    if ((this.nYM.nYK != null) && (this.nYM.nYL != null)) {
      this.nYM.nYK.removeCallbacks(this.nYM.nYL);
    }
    if (this.nYM.nYI != null) {
      au.Dk().c(this.nYM.nYI);
    }
    if ((this.nYM.nYH != null) && (this.nYM.nYH.ccD != null)) {
      this.nYM.nYI = new a(this.nYM.nYH.ccD);
    }
    if (this.nYM.nYI != null) {
      au.Dk().a(this.nYM.nYI, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c.1
 * JD-Core Version:    0.7.0.1
 */