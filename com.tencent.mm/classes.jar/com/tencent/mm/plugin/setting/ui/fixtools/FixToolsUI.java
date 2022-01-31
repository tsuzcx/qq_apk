package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUI
  extends MMPreference
{
  private f dnn;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("fix_tools_uplog"))
    {
      if (com.tencent.mm.plugin.setting.model.a.byG().eAp)
      {
        MMWizardActivity.C(this, new Intent(this.mController.uMN, FixToolsUpLogUploadingUI.class));
        return true;
      }
      paramf = new Intent(this.mController.uMN, FixToolsUplogUI.class);
      paramf.putExtra("entry_fix_tools_uplog", 9);
      MMWizardActivity.C(this, paramf);
      return true;
    }
    if (paramPreference.mKey.equals("fix_tools_db_recover"))
    {
      paramf = new Intent().setClassName(this.mController.uMN, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
      paramf.putExtra("scene", 2);
      this.mController.uMN.startActivity(paramf);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    setMMTitle(a.i.fix_tools);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.dnn.add("fix_tools_micromsg_header");
    String str = e.ag(this.mController.uMN, d.spa);
    paramBundle = str;
    if (d.spd) {
      paramBundle = str + " " + getString(a.i.alpha_version_alpha);
    }
    localSettingsAboutMMHeaderPreference.nSW = paramBundle;
    int i = getIntent().getIntExtra("entry_fix_tools", 2);
    h.nFQ.a(873L, i, 1L, false);
    h.nFQ.a(873L, 0L, 1L, false);
    setBackBtn(new FixToolsUI.1(this));
  }
  
  public final int xj()
  {
    return a.k.fix_tools;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI
 * JD-Core Version:    0.7.0.1
 */