package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.sdk.platformtools.bo;

final class SettingsSearchAuthUI$3
  implements View.OnClickListener
{
  SettingsSearchAuthUI$3(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127443);
    paramView = SettingsSearchAuthUI.d(this.qJW).getFtsEditText().getEditText().getText();
    if (!bo.aa(paramView)) {
      SettingsSearchAuthUI.a(this.qJW, paramView.toString().trim());
    }
    AppMethodBeat.o(127443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.3
 * JD-Core Version:    0.7.0.1
 */