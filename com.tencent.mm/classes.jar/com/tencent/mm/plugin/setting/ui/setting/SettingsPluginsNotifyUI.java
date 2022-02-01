package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.setting.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI
  extends MMPreference
{
  private f screen;
  private int state;
  
  private void Xr(int paramInt)
  {
    AppMethodBeat.i(74332);
    this.state = paramInt;
    if ((this.state == 1) || (this.state == 0))
    {
      g.aAh().azQ().set(8200, Boolean.TRUE);
      if (this.state == 1)
      {
        g.aAh().azQ().set(8201, Integer.valueOf(22));
        g.aAh().azQ().set(8208, Integer.valueOf(8));
        ((l)g.af(l.class)).aSM().d(new n(true, 22, 8));
      }
    }
    for (;;)
    {
      eTt();
      AppMethodBeat.o(74332);
      return;
      g.aAh().azQ().set(8201, Integer.valueOf(0));
      g.aAh().azQ().set(8208, Integer.valueOf(0));
      ((l)g.af(l.class)).aSM().d(new n(true, 0, 0));
      continue;
      g.aAh().azQ().set(8200, Boolean.FALSE);
      ((l)g.af(l.class)).aSM().d(new n());
    }
  }
  
  private void eTt()
  {
    AppMethodBeat.i(74331);
    this.screen.removeAll();
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131765532);
    localPreference.setKey("settings_plugings_disturb_on");
    localPreference.setLayoutResource(2131495538);
    if (this.state == 0)
    {
      localPreference.setWidgetLayoutResource(2131495615);
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131765533);
      localPreference.setKey("settings_plugings_disturb_on_night");
      localPreference.setLayoutResource(2131495538);
      if (this.state != 1) {
        break label221;
      }
      localPreference.setWidgetLayoutResource(2131495615);
      label105:
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131765531);
      localPreference.setKey("settings_plugings_disturb_off");
      localPreference.setLayoutResource(2131495538);
      if (this.state != 2) {
        break label230;
      }
      localPreference.setWidgetLayoutResource(2131495615);
    }
    for (;;)
    {
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131765534);
      localPreference.setLayoutResource(2131495599);
      this.screen.c(localPreference);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74331);
      return;
      localPreference.setWidgetLayoutResource(2131495616);
      break;
      label221:
      localPreference.setWidgetLayoutResource(2131495616);
      break label105;
      label230:
      localPreference.setWidgetLayoutResource(2131495616);
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74333);
    Boolean localBoolean = Boolean.valueOf(z.aUz());
    int j = z.aUJ();
    int k = z.aUK();
    int i;
    if (localBoolean.booleanValue()) {
      if (j == k) {
        i = 0;
      }
    }
    for (this.state = i;; this.state = 2)
    {
      Log.d("ui.settings.SettingsPlugingsNotify", localBoolean + "st " + j + " ed " + k + "  state " + this.state);
      this.state = this.state;
      this.screen = getPreferenceScreen();
      setMMTitle(2131765535);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74327);
          SettingsPluginsNotifyUI.this.hideVKB();
          SettingsPluginsNotifyUI.this.finish();
          AppMethodBeat.o(74327);
          return true;
        }
      });
      AppMethodBeat.o(74333);
      return;
      i = 1;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74328);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74328);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74330);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_plugings_disturb_on")) {
      Xr(0);
    }
    if (paramf.equals("settings_plugings_disturb_on_night")) {
      Xr(1);
    }
    if (paramf.equals("settings_plugings_disturb_off")) {
      Xr(2);
    }
    AppMethodBeat.o(74330);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74329);
    super.onResume();
    eTt();
    AppMethodBeat.o(74329);
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