package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingCustomModeUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return b.k.settings_custommode_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298655);
    setMMTitle(getString(b.i.settings_custom_mode));
    this.screen = getPreferenceScreen();
    AppMethodBeat.o(298655);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298644);
    super.onCreate(paramBundle);
    initView();
    Log.d("MicroMsg.SettingCustomModeUI", "hide care mode:%s", new Object[] { Boolean.valueOf(b.iRq()) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298781);
        SettingCustomModeUI.this.finish();
        AppMethodBeat.o(298781);
        return true;
      }
    });
    AppMethodBeat.o(298644);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(298658);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_teen_mode"))
    {
      AppMethodBeat.o(298658);
      return true;
    }
    if (paramf.equals("settings_care_mode"))
    {
      paramf = new Intent(this, SettingsCareModeIntro.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingCustomModeUI", "goToCareMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingCustomModeUI", "goToCareMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(298658);
      return true;
    }
    AppMethodBeat.o(298658);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(298649);
    super.onResume();
    Preference localPreference = this.screen.bAi("settings_care_mode");
    if (b.iRp())
    {
      localPreference.aS(getString(b.i.setting_open));
      AppMethodBeat.o(298649);
      return;
    }
    localPreference.aS(getString(b.i.setting_unopen));
    AppMethodBeat.o(298649);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingCustomModeUI
 * JD-Core Version:    0.7.0.1
 */