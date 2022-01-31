package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.g.b;
import com.tencent.mm.g.a.br;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ClearCacheUI$3
  implements Runnable
{
  ClearCacheUI$3(ClearCacheUI paramClearCacheUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(29168);
    ab.w("MicroMsg.ClearCacheUI", "doClearCache flag %d", new Object[] { Long.valueOf(this.yUW) });
    if ((this.yUW & 1L) != 0L) {
      com.tencent.mm.vfs.e.O(com.tencent.mm.plugin.i.c.bIC(), true);
    }
    if ((this.yUW & 0x2) != 0L) {
      com.tencent.mm.vfs.e.O(b.eQS, true);
    }
    if ((this.yUW & 0x4) != 0L) {
      com.tencent.mm.vfs.e.O(com.tencent.mm.compatible.util.e.esx, true);
    }
    if ((this.yUW & 0x8) != 0L)
    {
      aw.aaz();
      com.tencent.mm.vfs.e.O(com.tencent.mm.model.c.YT(), true);
    }
    if ((this.yUW & 0x10) != 0L) {
      com.tencent.mm.vfs.e.O(com.tencent.mm.plugin.avatar.c.aSE(), true);
    }
    if ((this.yUW & 0x20) != 0L)
    {
      aw.aaz();
      com.tencent.mm.vfs.e.O(com.tencent.mm.model.c.YO(), true);
    }
    if ((this.yUW & 0x40) != 0L)
    {
      aw.aaz();
      com.tencent.mm.vfs.e.O(com.tencent.mm.model.c.getAccSnsPath(), true);
    }
    br localbr = new br();
    localbr.cpb.cpc = this.yUW;
    a.ymk.l(localbr);
    al.d(new ClearCacheUI.3.1(this));
    AppMethodBeat.o(29168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.3
 * JD-Core Version:    0.7.0.1
 */