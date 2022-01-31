package com.tencent.mm.plugin.setting.ui.fixtools;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FixToolsUpLogUploadingUI$3
  implements a.a
{
  FixToolsUpLogUploadingUI$3(FixToolsUpLogUploadingUI paramFixToolsUpLogUploadingUI) {}
  
  public final void CV(int paramInt)
  {
    AppMethodBeat.i(126888);
    ab.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      h.qsU.idkeyStat(873L, 18L, 1L, false);
      FixToolsUpLogUploadingUI.c(this.qFn).setImageResource(2131231339);
      FixToolsUpLogUploadingUI.d(this.qFn).setText(2131299988);
      this.qFn.qFm.setVisibility(8);
      FixToolsUpLogUploadingUI.e(this.qFn).setVisibility(0);
      AppMethodBeat.o(126888);
      return;
    }
    if (paramInt >= 100)
    {
      h.qsU.idkeyStat(873L, 17L, 1L, false);
      FixToolsUpLogUploadingUI.c(this.qFn).setImageResource(2131231340);
      FixToolsUpLogUploadingUI.d(this.qFn).setText(2131299989);
      this.qFn.qFm.setVisibility(8);
      FixToolsUpLogUploadingUI.e(this.qFn).setVisibility(0);
      AppMethodBeat.o(126888);
      return;
    }
    this.qFn.qFm.setProgress(paramInt);
    AppMethodBeat.o(126888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI.3
 * JD-Core Version:    0.7.0.1
 */