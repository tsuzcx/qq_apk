package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingRedesign
  extends MMPreference
{
  private boolean qGO;
  private f screen;
  
  private void refresh()
  {
    AppMethodBeat.i(127077);
    if (this.qGO != ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).getBoolean("dark_actionbar", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Intro_Need_Clear_Top ", true);
      b.gmO.p(localIntent, getContext());
    }
    AppMethodBeat.o(127077);
  }
  
  public int getResourceId()
  {
    return 2131165270;
  }
  
  public void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(127075);
    setMMTitle("Redesign");
    this.screen = getPreferenceScreen();
    this.qGO = ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).getBoolean("dark_actionbar", false);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("redesign_actionbar");
    if (localCheckBoxPreference != null)
    {
      if (!this.qGO) {
        bool = true;
      }
      localCheckBoxPreference.vxW = bool;
    }
    setBackBtn(new SettingRedesign.1(this));
    AppMethodBeat.o(127075);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127074);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127074);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127078);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      refresh();
      AppMethodBeat.o(127078);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127078);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127076);
    if (paramPreference.mKey.equals("redesign_actionbar"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        break label81;
      }
      ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
    }
    for (;;)
    {
      AppMethodBeat.o(127076);
      return false;
      label81:
      ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingRedesign
 * JD-Core Version:    0.7.0.1
 */