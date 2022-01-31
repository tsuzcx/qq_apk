package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.sdk.platformtools.bk;

final class SettingsSearchAuthUI$3
  implements View.OnClickListener
{
  SettingsSearchAuthUI$3(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = SettingsSearchAuthUI.d(this.nVN).getFtsEditText().getEditText().getText();
    if (!bk.L(paramView)) {
      SettingsSearchAuthUI.a(this.nVN, paramView.toString().trim());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.3
 * JD-Core Version:    0.7.0.1
 */