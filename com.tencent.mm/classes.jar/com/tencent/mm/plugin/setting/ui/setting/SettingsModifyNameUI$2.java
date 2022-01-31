package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsModifyNameUI$2
  implements TextWatcher
{
  SettingsModifyNameUI$2(SettingsModifyNameUI paramSettingsModifyNameUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127307);
    this.qJf.enableOptionMenu(true);
    AppMethodBeat.o(127307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.2
 * JD-Core Version:    0.7.0.1
 */