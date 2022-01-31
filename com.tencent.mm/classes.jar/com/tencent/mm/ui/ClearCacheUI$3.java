package com.tencent.mm.ui;

import com.tencent.mm.h.a.bp;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class ClearCacheUI$3
  implements Runnable
{
  ClearCacheUI$3(ClearCacheUI paramClearCacheUI, long paramLong) {}
  
  public final void run()
  {
    y.w("MicroMsg.ClearCacheUI", "doClearCache flag %d", new Object[] { Long.valueOf(this.uHL) });
    if ((this.uHL & 1L) != 0L) {
      com.tencent.mm.vfs.e.K(com.tencent.mm.plugin.n.c.bbu(), true);
    }
    if ((this.uHL & 0x2) != 0L) {
      com.tencent.mm.vfs.e.K(com.tencent.mm.as.a.g.b.erZ, true);
    }
    if ((this.uHL & 0x4) != 0L) {
      com.tencent.mm.vfs.e.K(com.tencent.mm.compatible.util.e.dzJ, true);
    }
    if ((this.uHL & 0x8) != 0L)
    {
      au.Hx();
      com.tencent.mm.vfs.e.K(com.tencent.mm.model.c.FP(), true);
    }
    if ((this.uHL & 0x10) != 0L) {
      com.tencent.mm.vfs.e.K(com.tencent.mm.plugin.avatar.b.atg(), true);
    }
    if ((this.uHL & 0x20) != 0L)
    {
      au.Hx();
      com.tencent.mm.vfs.e.K(com.tencent.mm.model.c.FK(), true);
    }
    if ((this.uHL & 0x40) != 0L)
    {
      au.Hx();
      com.tencent.mm.vfs.e.K(com.tencent.mm.model.c.getAccSnsPath(), true);
    }
    bp localbp = new bp();
    localbp.bHM.bHN = this.uHL;
    a.udP.m(localbp);
    ai.d(new ClearCacheUI.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.3
 * JD-Core Version:    0.7.0.1
 */