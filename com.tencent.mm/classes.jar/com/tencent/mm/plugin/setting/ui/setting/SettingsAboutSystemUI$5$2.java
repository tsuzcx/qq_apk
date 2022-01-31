package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;

final class SettingsAboutSystemUI$5$2
  implements bd.a
{
  SettingsAboutSystemUI$5$2(SettingsAboutSystemUI.5 param5) {}
  
  public final void xA()
  {
    if (SettingsAboutSystemUI.c(this.nTx.nTp) != null)
    {
      SettingsAboutSystemUI.c(this.nTx.nTp).dismiss();
      SettingsAboutSystemUI.a(this.nTx.nTp, null);
    }
  }
  
  public final boolean xz()
  {
    return SettingsAboutSystemUI.b(this.nTx.nTp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.5.2
 * JD-Core Version:    0.7.0.1
 */