package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class FixToolsUplogUI$2
  implements View.OnClickListener
{
  FixToolsUplogUI$2(FixToolsUplogUI paramFixToolsUplogUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.a(873L, 16L, 1L, false);
    paramView = new Intent(this.nRv.mController.uMN, FixToolsUpLogUploadingUI.class);
    paramView.putExtra("date", FixToolsUplogUI.access$100());
    MMWizardActivity.C(this.nRv, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.2
 * JD-Core Version:    0.7.0.1
 */