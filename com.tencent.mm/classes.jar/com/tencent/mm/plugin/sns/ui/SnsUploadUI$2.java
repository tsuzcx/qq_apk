package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.b;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.a.c;

final class SnsUploadUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsUploadUI$2(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (this.pjp.isFinishing()) {}
    while (System.currentTimeMillis() - SnsUploadUI.n(this.pjp) < 500L) {
      return false;
    }
    if (SnsUploadUI.g(this.pjp) == 9)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upV, "");
    }
    for (;;)
    {
      SnsUploadUI.h(this.pjp);
      SnsUploadUI.a(this.pjp, System.currentTimeMillis());
      com.tencent.mm.plugin.report.service.g.wI(22);
      paramMenuItem = c.d(SnsUploadUI.f(this.pjp)).Ig(b.Ac());
      paramMenuItem.wfM = true;
      paramMenuItem.a(new SnsUploadUI.2.1(this));
      return false;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upU, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.2
 * JD-Core Version:    0.7.0.1
 */