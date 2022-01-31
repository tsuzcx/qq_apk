package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI
  extends MMPreference
{
  private f screen;
  private int state;
  
  private void Df(int paramInt)
  {
    AppMethodBeat.i(127396);
    this.state = paramInt;
    if ((this.state == 1) || (this.state == 0))
    {
      g.RL().Ru().set(8200, Boolean.TRUE);
      if (this.state == 1)
      {
        g.RL().Ru().set(8201, Integer.valueOf(22));
        g.RL().Ru().set(8208, Integer.valueOf(8));
        ((j)g.E(j.class)).Yz().c(new k(true, 22, 8));
      }
    }
    for (;;)
    {
      ckv();
      AppMethodBeat.o(127396);
      return;
      g.RL().Ru().set(8201, Integer.valueOf(0));
      g.RL().Ru().set(8208, Integer.valueOf(0));
      ((j)g.E(j.class)).Yz().c(new k(true, 0, 0));
      continue;
      g.RL().Ru().set(8200, Boolean.FALSE);
      ((j)g.E(j.class)).Yz().c(new k());
    }
  }
  
  private void ckv()
  {
    AppMethodBeat.i(127395);
    this.screen.removeAll();
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131303368);
    localPreference.setKey("settings_plugings_disturb_on");
    localPreference.setLayoutResource(2130970179);
    if (this.state == 0)
    {
      localPreference.setWidgetLayoutResource(2130970249);
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131303369);
      localPreference.setKey("settings_plugings_disturb_on_night");
      localPreference.setLayoutResource(2130970179);
      if (this.state != 1) {
        break label221;
      }
      localPreference.setWidgetLayoutResource(2130970249);
      label105:
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131303367);
      localPreference.setKey("settings_plugings_disturb_off");
      localPreference.setLayoutResource(2130970179);
      if (this.state != 2) {
        break label230;
      }
      localPreference.setWidgetLayoutResource(2130970249);
    }
    for (;;)
    {
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131303370);
      localPreference.setLayoutResource(2130970236);
      this.screen.b(localPreference);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127395);
      return;
      localPreference.setWidgetLayoutResource(2130970250);
      break;
      label221:
      localPreference.setWidgetLayoutResource(2130970250);
      break label105;
      label230:
      localPreference.setWidgetLayoutResource(2130970250);
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127397);
    g.RM();
    Boolean localBoolean = Boolean.valueOf(bo.e((Boolean)g.RL().Ru().get(8200, null)));
    g.RM();
    int j = bo.a((Integer)g.RL().Ru().get(8201, null), 22);
    g.RM();
    int k = bo.a((Integer)g.RL().Ru().get(8208, null), 8);
    int i;
    if (localBoolean.booleanValue()) {
      if (j == k) {
        i = 0;
      }
    }
    for (this.state = i;; this.state = 2)
    {
      ab.d("ui.settings.SettingsPlugingsNotify", localBoolean + "st " + j + " ed " + k + "  state " + this.state);
      this.state = this.state;
      this.screen = getPreferenceScreen();
      setMMTitle(2131303371);
      setBackBtn(new SettingsPluginsNotifyUI.1(this));
      AppMethodBeat.o(127397);
      return;
      i = 1;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127391);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127391);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127394);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_plugings_disturb_on")) {
      Df(0);
    }
    if (paramf.equals("settings_plugings_disturb_on_night")) {
      Df(1);
    }
    if (paramf.equals("settings_plugings_disturb_off")) {
      Df(2);
    }
    AppMethodBeat.o(127394);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127393);
    super.onResume();
    ckv();
    AppMethodBeat.o(127393);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI
 * JD-Core Version:    0.7.0.1
 */