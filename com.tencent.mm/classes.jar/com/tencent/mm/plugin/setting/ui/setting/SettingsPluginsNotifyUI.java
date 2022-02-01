package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsPluginsNotifyUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  private int state;
  
  private void aiX(int paramInt)
  {
    AppMethodBeat.i(74332);
    this.state = paramInt;
    if ((this.state == 1) || (this.state == 0))
    {
      h.baE().ban().B(8200, Boolean.TRUE);
      if (this.state == 1)
      {
        h.baE().ban().B(8201, Integer.valueOf(22));
        h.baE().ban().B(8208, Integer.valueOf(8));
        ((n)h.ax(n.class)).bzz().d(new p(true, 22, 8));
      }
    }
    for (;;)
    {
      gWe();
      AppMethodBeat.o(74332);
      return;
      h.baE().ban().B(8201, Integer.valueOf(0));
      h.baE().ban().B(8208, Integer.valueOf(0));
      ((n)h.ax(n.class)).bzz().d(new p(true, 0, 0));
      continue;
      h.baE().ban().B(8200, Boolean.FALSE);
      ((n)h.ax(n.class)).bzz().d(new p());
    }
  }
  
  private void gWe()
  {
    AppMethodBeat.i(74331);
    this.screen.removeAll();
    Preference localPreference = new Preference(this);
    localPreference.setTitle(b.i.settings_plugings_disturb_on);
    localPreference.setKey("settings_plugings_disturb_on");
    localPreference.setLayoutResource(b.g.mm_preference);
    if (this.state == 0)
    {
      localPreference.aBp(b.g.mm_preference_radio_checked);
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(b.i.settings_plugings_disturb_on_night);
      localPreference.setKey("settings_plugings_disturb_on_night");
      localPreference.setLayoutResource(b.g.mm_preference);
      if (this.state != 1) {
        break label233;
      }
      localPreference.aBp(b.g.mm_preference_radio_checked);
      label111:
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(b.i.settings_plugings_disturb_off);
      localPreference.setKey("settings_plugings_disturb_off");
      localPreference.setLayoutResource(b.g.mm_preference);
      if (this.state != 2) {
        break label243;
      }
      localPreference.aBp(b.g.mm_preference_radio_checked);
    }
    for (;;)
    {
      this.screen.c(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(b.i.settings_plugings_disturb_time_tip);
      localPreference.setLayoutResource(b.g.mm_preference_info);
      this.screen.c(localPreference);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74331);
      return;
      localPreference.aBp(b.g.mm_preference_radio_unchecked);
      break;
      label233:
      localPreference.aBp(b.g.mm_preference_radio_unchecked);
      break label111;
      label243:
      localPreference.aBp(b.g.mm_preference_radio_unchecked);
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74333);
    Boolean localBoolean = Boolean.valueOf(z.bBt());
    int j = z.bBD();
    int k = z.bBE();
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
      setMMTitle(b.i.settings_plugings_disturb_title);
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74330);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_plugings_disturb_on")) {
      aiX(0);
    }
    if (paramf.equals("settings_plugings_disturb_on_night")) {
      aiX(1);
    }
    if (paramf.equals("settings_plugings_disturb_off")) {
      aiX(2);
    }
    AppMethodBeat.o(74330);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74329);
    super.onResume();
    gWe();
    AppMethodBeat.o(74329);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI
 * JD-Core Version:    0.7.0.1
 */