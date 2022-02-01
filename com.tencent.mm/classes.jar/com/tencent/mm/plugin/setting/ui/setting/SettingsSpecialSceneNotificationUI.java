package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsSpecialSceneNotificationUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131951731;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74428);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.screen.cE("settings_specail_scene_sound", false);
    ((CheckBoxPreference)this.screen.aKk("settings_specail_scene_sound")).lG = com.tencent.mm.m.f.Yt();
    this.screen.cE("settings_specail_scene_shake", false);
    ((CheckBoxPreference)this.screen.aKk("settings_specail_scene_shake")).lG = com.tencent.mm.m.f.Yu();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74426);
        SettingsSpecialSceneNotificationUI.this.hideVKB();
        SettingsSpecialSceneNotificationUI.this.finish();
        AppMethodBeat.o(74426);
        return true;
      }
    });
    AppMethodBeat.o(74428);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74427);
    super.onCreate(paramBundle);
    setMMTitle(2131763433);
    AppMethodBeat.o(74427);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74432);
    super.onDestroy();
    AppMethodBeat.o(74432);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74429);
    super.onPause();
    AppMethodBeat.o(74429);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74431);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_specail_scene_sound"))
    {
      com.tencent.mm.m.f.cU(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(74431);
      return true;
    }
    if (paramf.equals("settings_specail_scene_shake"))
    {
      com.tencent.mm.m.f.cV(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      bt.C(this, ((CheckBoxPreference)paramPreference).isChecked());
      AppMethodBeat.o(74431);
      return true;
    }
    AppMethodBeat.o(74431);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74430);
    super.onResume();
    initView();
    AppMethodBeat.o(74430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI
 * JD-Core Version:    0.7.0.1
 */