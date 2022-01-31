package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsSpecialSceneNotificationUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131165287;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127492);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.screen.cl("settings_specail_scene_sound", false);
    ((CheckBoxPreference)this.screen.atx("settings_specail_scene_sound")).vxW = com.tencent.mm.m.f.MG();
    this.screen.cl("settings_specail_scene_shake", false);
    ((CheckBoxPreference)this.screen.atx("settings_specail_scene_shake")).vxW = com.tencent.mm.m.f.MH();
    setBackBtn(new SettingsSpecialSceneNotificationUI.1(this));
    AppMethodBeat.o(127492);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127491);
    super.onCreate(paramBundle);
    setMMTitle(2131303451);
    AppMethodBeat.o(127491);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127496);
    super.onDestroy();
    AppMethodBeat.o(127496);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127493);
    super.onPause();
    AppMethodBeat.o(127493);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127495);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_specail_scene_sound"))
    {
      com.tencent.mm.m.f.bY(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(127495);
      return true;
    }
    if (paramf.equals("settings_specail_scene_shake"))
    {
      com.tencent.mm.m.f.bZ(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      bo.z(this, ((CheckBoxPreference)paramPreference).isChecked());
      AppMethodBeat.o(127495);
      return true;
    }
    AppMethodBeat.o(127495);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127494);
    super.onResume();
    initView();
    AppMethodBeat.o(127494);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI
 * JD-Core Version:    0.7.0.1
 */