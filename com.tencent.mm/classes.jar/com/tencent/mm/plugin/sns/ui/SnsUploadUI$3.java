package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.b.c;

final class SnsUploadUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsUploadUI$3(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(145653);
    if (this.sbR.isFinishing())
    {
      AppMethodBeat.o(145653);
      return false;
    }
    if (System.currentTimeMillis() - SnsUploadUI.n(this.sbR) < 500L)
    {
      AppMethodBeat.o(145653);
      return false;
    }
    if (SnsUploadUI.g(this.sbR) == 9)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzV, "");
      SnsUploadUI.h(this.sbR);
      if (this.gFg[0] == 0) {
        break label178;
      }
      this.gFg[0] = false;
    }
    for (;;)
    {
      SnsUploadUI.a(this.sbR, System.currentTimeMillis());
      com.tencent.mm.plugin.report.service.g.Cx(22);
      paramMenuItem = c.d(SnsUploadUI.f(this.sbR)).QS(com.tencent.mm.m.b.MR());
      paramMenuItem.AyD = true;
      paramMenuItem.a(new SnsUploadUI.3.1(this));
      AppMethodBeat.o(145653);
      return false;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzU, "");
      break;
      label178:
      com.tencent.mm.plugin.normsg.a.b.pgQ.fD("ce_sns_upload", "<SnsUpload>");
      paramMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.b.pgQ.a("ce_sns_upload", paramMenuItem);
      com.tencent.mm.plugin.normsg.a.b.pgQ.Wa("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.3
 * JD-Core Version:    0.7.0.1
 */