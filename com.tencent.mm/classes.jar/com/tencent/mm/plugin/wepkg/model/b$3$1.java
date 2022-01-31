package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString) {}
  
  public final void run()
  {
    if (bk.bl(this.rPa))
    {
      if (e.Vh(com.tencent.mm.plugin.wepkg.utils.d.Vp(this.rPb.rOZ)))
      {
        com.tencent.mm.plugin.wepkg.b.d.cjN().US(this.rPb.rOZ);
        b.cjM().US(this.rPb.rOZ);
        y.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg success. pkgid:%s", new Object[] { this.rPb.rOZ });
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg fail. pkgid:%s", new Object[] { this.rPb.rOZ });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b.3.1
 * JD-Core Version:    0.7.0.1
 */