package com.tencent.mm.plugin.setting.ui.setting;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsModifyEmailAddrUI$23
  implements InputFilter
{
  SettingsModifyEmailAddrUI$23(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127285);
    if (paramCharSequence.length() <= 0)
    {
      paramCharSequence = paramSpanned.subSequence(paramInt3, paramInt4);
      AppMethodBeat.o(127285);
      return paramCharSequence;
    }
    AppMethodBeat.o(127285);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.23
 * JD-Core Version:    0.7.0.1
 */