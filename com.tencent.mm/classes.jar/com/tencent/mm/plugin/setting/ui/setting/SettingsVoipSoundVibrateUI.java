package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsVoipSoundVibrateUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131165288;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127626);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.screen.cl("settings_voip_sound", false);
    ((CheckBoxPreference)this.screen.atx("settings_voip_sound")).vxW = com.tencent.mm.m.f.MI();
    this.screen.cl("settings_voip_shake", false);
    ((CheckBoxPreference)this.screen.atx("settings_voip_shake")).vxW = com.tencent.mm.m.f.MJ();
    setBackBtn(new SettingsVoipSoundVibrateUI.1(this));
    AppMethodBeat.o(127626);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127625);
    super.onCreate(paramBundle);
    setMMTitle(2131303524);
    AppMethodBeat.o(127625);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127630);
    super.onDestroy();
    AppMethodBeat.o(127630);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127627);
    super.onPause();
    AppMethodBeat.o(127627);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127629);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_voip_sound"))
    {
      com.tencent.mm.m.f.ca(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(127629);
      return true;
    }
    if (paramf.equals("settings_voip_shake"))
    {
      com.tencent.mm.m.f.cb(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      bo.z(this, ((CheckBoxPreference)paramPreference).isChecked());
      AppMethodBeat.o(127629);
      return true;
    }
    AppMethodBeat.o(127629);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127628);
    super.onResume();
    initView();
    AppMethodBeat.o(127628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI
 * JD-Core Version:    0.7.0.1
 */