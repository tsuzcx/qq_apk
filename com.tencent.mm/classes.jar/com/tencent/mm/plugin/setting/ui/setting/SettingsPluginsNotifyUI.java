package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI
  extends MMPreference
{
  private f screen;
  private int state;
  
  private void Ph(int paramInt)
  {
    AppMethodBeat.i(74332);
    this.state = paramInt;
    if ((this.state == 1) || (this.state == 0))
    {
      g.ajC().ajl().set(8200, Boolean.TRUE);
      if (this.state == 1)
      {
        g.ajC().ajl().set(8201, Integer.valueOf(22));
        g.ajC().ajl().set(8208, Integer.valueOf(8));
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.plugin.setting.model.l(true, 22, 8));
      }
    }
    for (;;)
    {
      dNV();
      AppMethodBeat.o(74332);
      return;
      g.ajC().ajl().set(8201, Integer.valueOf(0));
      g.ajC().ajl().set(8208, Integer.valueOf(0));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.plugin.setting.model.l(true, 0, 0));
      continue;
      g.ajC().ajl().set(8200, Boolean.FALSE);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.plugin.setting.model.l());
    }
  }
  
  private void dNV()
  {
    AppMethodBeat.i(74331);
    this.screen.removeAll();
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131763350);
    localPreference.setKey("settings_plugings_disturb_on");
    localPreference.setLayoutResource(2131494804);
    if (this.state == 0)
    {
      localPreference.setWidgetLayoutResource(2131494878);
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131763351);
      localPreference.setKey("settings_plugings_disturb_on_night");
      localPreference.setLayoutResource(2131494804);
      if (this.state != 1) {
        break label221;
      }
      localPreference.setWidgetLayoutResource(2131494878);
      label105:
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131763349);
      localPreference.setKey("settings_plugings_disturb_off");
      localPreference.setLayoutResource(2131494804);
      if (this.state != 2) {
        break label230;
      }
      localPreference.setWidgetLayoutResource(2131494878);
    }
    for (;;)
    {
      this.screen.b(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(2131763352);
      localPreference.setLayoutResource(2131494863);
      this.screen.b(localPreference);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74331);
      return;
      localPreference.setWidgetLayoutResource(2131494879);
      break;
      label221:
      localPreference.setWidgetLayoutResource(2131494879);
      break label105;
      label230:
      localPreference.setWidgetLayoutResource(2131494879);
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74333);
    Boolean localBoolean = Boolean.valueOf(u.aAM());
    int j = u.aAW();
    int k = u.aAX();
    int i;
    if (localBoolean.booleanValue()) {
      if (j == k) {
        i = 0;
      }
    }
    for (this.state = i;; this.state = 2)
    {
      ad.d("ui.settings.SettingsPlugingsNotify", localBoolean + "st " + j + " ed " + k + "  state " + this.state);
      this.state = this.state;
      this.screen = getPreferenceScreen();
      setMMTitle(2131763353);
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
      Ph(0);
    }
    if (paramf.equals("settings_plugings_disturb_on_night")) {
      Ph(1);
    }
    if (paramf.equals("settings_plugings_disturb_off")) {
      Ph(2);
    }
    AppMethodBeat.o(74330);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74329);
    super.onResume();
    dNV();
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