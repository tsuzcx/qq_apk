package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return 2131165241;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126884);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131299980);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.atx("fix_tools_micromsg_header");
    String str = g.au(getContext(), d.whH);
    paramBundle = str;
    if (d.whK) {
      paramBundle = str + " " + getString(2131296529);
    }
    localSettingsAboutMMHeaderPreference.qGW = paramBundle;
    int i = getIntent().getIntExtra("entry_fix_tools", 2);
    h.qsU.idkeyStat(873L, i, 1L, false);
    h.qsU.idkeyStat(873L, 0L, 1L, false);
    setBackBtn(new FixToolsUI.1(this));
    this.screen.cl("fix_tools_fts_recover", true);
    AppMethodBeat.o(126884);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126885);
    if (paramPreference.mKey.equals("fix_tools_uplog"))
    {
      if (com.tencent.mm.plugin.setting.model.a.cjQ().fQi) {
        MMWizardActivity.J(this, new Intent(getContext(), FixToolsUpLogUploadingUI.class));
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return true;
        paramf = new Intent(getContext(), FixToolsUplogUI.class);
        paramf.putExtra("entry_fix_tools_uplog", 9);
        MMWizardActivity.J(this, paramf);
      }
    }
    if (paramPreference.mKey.equals("fix_tools_db_recover"))
    {
      paramf = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
      paramf.putExtra("scene", 2);
      getContext().startActivity(paramf);
      AppMethodBeat.o(126885);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_recover"))
    {
      startActivity(new Intent(this, FixToolsFTSUI.class));
      AppMethodBeat.o(126885);
      return true;
    }
    AppMethodBeat.o(126885);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI
 * JD-Core Version:    0.7.0.1
 */