package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.h.a.og;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.sdk.b.a;

final class SettingsChattingUI$3
  implements bd.a
{
  SettingsChattingUI$3(SettingsChattingUI paramSettingsChattingUI) {}
  
  public final void xA()
  {
    if (SettingsChattingUI.a(this.nUf) != null)
    {
      SettingsChattingUI.a(this.nUf).dismiss();
      SettingsChattingUI.a(this.nUf, null);
    }
    a.udP.m(new og());
  }
  
  public final boolean xz()
  {
    return SettingsChattingUI.c(this.nUf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.3
 * JD-Core Version:    0.7.0.1
 */