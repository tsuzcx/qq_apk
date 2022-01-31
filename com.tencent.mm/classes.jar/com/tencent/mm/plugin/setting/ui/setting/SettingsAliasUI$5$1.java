package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.ah.m;

final class SettingsAliasUI$5$1
  implements Runnable
{
  SettingsAliasUI$5$1(SettingsAliasUI.5 param5, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (SettingsAliasUI.h(this.nUc.nUa) != null)
    {
      SettingsAliasUI.h(this.nUc.nUa).dismiss();
      SettingsAliasUI.i(this.nUc.nUa);
    }
    SettingsAliasUI.j(this.nUc.nUa);
    if (this.bEe.getType() == 255) {
      if ((this.bEg == -3) && (this.bEf == 4)) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      Intent localIntent = new Intent(this.nUc.nUa, SettingsAliasResultUI.class);
      localIntent.putExtra("has_pwd", bool);
      this.nUc.nUa.startActivity(localIntent);
      this.nUc.nUa.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.5.1
 * JD-Core Version:    0.7.0.1
 */