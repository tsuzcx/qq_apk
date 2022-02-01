package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsSpecialSceneNotificationUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return b.k.settings_pref_notification_special_scene;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74428);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.auC(getResourceId());
    this.screen.dz("settings_specail_scene_sound", false);
    ((CheckBoxPreference)this.screen.byG("settings_specail_scene_sound")).setChecked(g.awr());
    this.screen.dz("settings_specail_scene_shake", false);
    ((CheckBoxPreference)this.screen.byG("settings_specail_scene_shake")).setChecked(g.aws());
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
    setMMTitle(b.i.settings_specail_scene_notification_sound_and_shake_title);
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
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74431);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_specail_scene_sound"))
    {
      g.ef(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(74431);
      return true;
    }
    if (paramf.equals("settings_specail_scene_shake"))
    {
      g.eg(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI
 * JD-Core Version:    0.7.0.1
 */