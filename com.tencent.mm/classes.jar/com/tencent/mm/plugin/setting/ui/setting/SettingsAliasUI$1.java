package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SettingsAliasUI$1
  implements TextWatcher
{
  SettingsAliasUI$1(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127184);
    SettingsAliasUI localSettingsAliasUI = this.qIa;
    a locala = new a();
    if ((paramCharSequence.length() < 6) || (paramCharSequence.length() > 20))
    {
      locala.errMsg = localSettingsAliasUI.getString(2131304492);
      locala.crA = false;
      if (!locala.crA) {
        break label339;
      }
      this.qIa.enableOptionMenu(true);
      SettingsAliasUI.a(this.qIa).setTextColor(this.qIa.getResources().getColorStateList(2131690168));
    }
    for (;;)
    {
      SettingsAliasUI.a(this.qIa).setText(locala.errMsg);
      SettingsAliasUI.b(this.qIa).setText(this.qIa.getString(2131296536, new Object[] { paramCharSequence }));
      AppMethodBeat.o(127184);
      return;
      if (!bo.C(paramCharSequence.charAt(0)))
      {
        locala.errMsg = localSettingsAliasUI.getString(2131304490);
        locala.crA = false;
        break;
      }
      paramInt1 = paramCharSequence.length() - 1;
      for (;;)
      {
        if (paramInt1 <= 0) {
          break label318;
        }
        char c = paramCharSequence.charAt(paramInt1);
        if ((!bo.C(c)) && (c != '-') && (c != '_') && (!bo.D(c)))
        {
          if (Character.isSpace(c))
          {
            locala.errMsg = localSettingsAliasUI.getString(2131304489);
            locala.crA = false;
            break;
          }
          if (bo.B(c))
          {
            locala.errMsg = localSettingsAliasUI.getString(2131304487);
            locala.crA = false;
            break;
          }
          locala.errMsg = localSettingsAliasUI.getString(2131304492);
          locala.crA = false;
          break;
        }
        paramInt1 -= 1;
      }
      label318:
      locala.errMsg = localSettingsAliasUI.getString(2131301618);
      locala.crA = true;
      break;
      label339:
      this.qIa.enableOptionMenu(false);
      SettingsAliasUI.a(this.qIa).setTextColor(this.qIa.getResources().getColorStateList(2131690445));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.1
 * JD-Core Version:    0.7.0.1
 */