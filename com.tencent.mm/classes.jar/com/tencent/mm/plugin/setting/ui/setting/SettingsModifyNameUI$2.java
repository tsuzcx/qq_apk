package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;

final class SettingsModifyNameUI$2
  implements TextWatcher
{
  SettingsModifyNameUI$2(SettingsModifyNameUI paramSettingsModifyNameUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.nVa.enableOptionMenu(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.2
 * JD-Core Version:    0.7.0.1
 */