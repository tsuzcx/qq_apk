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

public class SettingsVoipSoundVibrateUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131951732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74562);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.screen.cP("settings_voip_sound", false);
    ((CheckBoxPreference)this.screen.aVD("settings_voip_sound")).oB = com.tencent.mm.n.f.abS();
    this.screen.cP("settings_voip_shake", false);
    ((CheckBoxPreference)this.screen.aVD("settings_voip_shake")).oB = com.tencent.mm.n.f.abT();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74560);
        SettingsVoipSoundVibrateUI.this.hideVKB();
        SettingsVoipSoundVibrateUI.this.finish();
        AppMethodBeat.o(74560);
        return true;
      }
    });
    AppMethodBeat.o(74562);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74561);
    super.onCreate(paramBundle);
    setMMTitle(2131763506);
    AppMethodBeat.o(74561);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74566);
    super.onDestroy();
    AppMethodBeat.o(74566);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74563);
    super.onPause();
    AppMethodBeat.o(74563);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74565);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_voip_sound"))
    {
      com.tencent.mm.n.f.cX(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(74565);
      return true;
    }
    if (paramf.equals("settings_voip_shake"))
    {
      com.tencent.mm.n.f.cY(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      bt.F(this, ((CheckBoxPreference)paramPreference).isChecked());
      AppMethodBeat.o(74565);
      return true;
    }
    AppMethodBeat.o(74565);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74564);
    super.onResume();
    initView();
    AppMethodBeat.o(74564);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI
 * JD-Core Version:    0.7.0.1
 */