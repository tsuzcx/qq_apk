package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMWizardActivity;

final class FixToolsUplogUI$2
  implements View.OnClickListener
{
  FixToolsUplogUI$2(FixToolsUplogUI paramFixToolsUplogUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126895);
    h.qsU.idkeyStat(873L, 16L, 1L, false);
    paramView = new Intent(this.qFt.getContext(), FixToolsUpLogUploadingUI.class);
    paramView.putExtra("date", FixToolsUplogUI.access$100());
    MMWizardActivity.J(this.qFt, paramView);
    AppMethodBeat.o(126895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.2
 * JD-Core Version:    0.7.0.1
 */