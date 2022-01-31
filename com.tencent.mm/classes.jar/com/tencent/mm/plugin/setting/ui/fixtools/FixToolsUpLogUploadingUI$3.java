package com.tencent.mm.plugin.setting.ui.fixtools;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class FixToolsUpLogUploadingUI$3
  implements a.a
{
  FixToolsUpLogUploadingUI$3(FixToolsUpLogUploadingUI paramFixToolsUpLogUploadingUI) {}
  
  public final void xa(int paramInt)
  {
    y.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      h.nFQ.a(873L, 18L, 1L, false);
      FixToolsUpLogUploadingUI.c(this.nRp).setImageResource(a.h.fix_tools_failed);
      FixToolsUpLogUploadingUI.d(this.nRp).setText(a.i.fix_tools_uplog_fail);
      this.nRp.nRo.setVisibility(8);
      FixToolsUpLogUploadingUI.e(this.nRp).setVisibility(0);
      return;
    }
    if (paramInt >= 100)
    {
      h.nFQ.a(873L, 17L, 1L, false);
      FixToolsUpLogUploadingUI.c(this.nRp).setImageResource(a.h.fix_tools_finish);
      FixToolsUpLogUploadingUI.d(this.nRp).setText(a.i.fix_tools_uplog_success);
      this.nRp.nRo.setVisibility(8);
      FixToolsUpLogUploadingUI.e(this.nRp).setVisibility(0);
      return;
    }
    this.nRp.nRo.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.3
 * JD-Core Version:    0.7.0.1
 */