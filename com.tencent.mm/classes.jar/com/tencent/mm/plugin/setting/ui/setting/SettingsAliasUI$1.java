package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;

final class SettingsAliasUI$1
  implements TextWatcher
{
  SettingsAliasUI$1(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SettingsAliasUI localSettingsAliasUI = this.nUa;
    a locala = new a();
    if ((paramCharSequence.length() < 6) || (paramCharSequence.length() > 20))
    {
      locala.aox = localSettingsAliasUI.getString(a.i.verify_account_tip);
      locala.bKg = false;
      if (!locala.bKg) {
        break label337;
      }
      this.nUa.enableOptionMenu(true);
      SettingsAliasUI.a(this.nUa).setTextColor(this.nUa.getResources().getColorStateList(a.c.hint_text_color));
    }
    for (;;)
    {
      SettingsAliasUI.a(this.nUa).setText(locala.aox);
      SettingsAliasUI.b(this.nUa).setText(this.nUa.getString(a.i.app_account, new Object[] { paramCharSequence }));
      return;
      if (!bk.m(paramCharSequence.charAt(0)))
      {
        locala.aox = localSettingsAliasUI.getString(a.i.verify_account_err_start);
        locala.bKg = false;
        break;
      }
      paramInt1 = paramCharSequence.length() - 1;
      for (;;)
      {
        if (paramInt1 <= 0) {
          break label315;
        }
        char c = paramCharSequence.charAt(paramInt1);
        if ((!bk.m(c)) && (c != '-') && (c != '_') && (!bk.n(c)))
        {
          if (Character.isSpace(c))
          {
            locala.aox = localSettingsAliasUI.getString(a.i.verify_account_err_space);
            locala.bKg = false;
            break;
          }
          if (bk.l(c))
          {
            locala.aox = localSettingsAliasUI.getString(a.i.verify_account_err_chinese);
            locala.bKg = false;
            break;
          }
          locala.aox = localSettingsAliasUI.getString(a.i.verify_account_tip);
          locala.bKg = false;
          break;
        }
        paramInt1 -= 1;
      }
      label315:
      locala.aox = localSettingsAliasUI.getString(a.i.modify_username_detail);
      locala.bKg = true;
      break;
      label337:
      this.nUa.enableOptionMenu(false);
      SettingsAliasUI.a(this.nUa).setTextColor(this.nUa.getResources().getColorStateList(a.c.settings_alias_warning));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.1
 * JD-Core Version:    0.7.0.1
 */