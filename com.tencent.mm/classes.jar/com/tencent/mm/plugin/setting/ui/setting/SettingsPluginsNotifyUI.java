package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI
  extends MMPreference
{
  private f dnn;
  private int state;
  
  private void bzl()
  {
    this.dnn.removeAll();
    Preference localPreference = new Preference(this);
    localPreference.setTitle(a.i.settings_plugings_disturb_on);
    localPreference.setKey("settings_plugings_disturb_on");
    localPreference.setLayoutResource(a.g.mm_preference);
    if (this.state == 0)
    {
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      this.dnn.a(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(a.i.settings_plugings_disturb_on_night);
      localPreference.setKey("settings_plugings_disturb_on_night");
      localPreference.setLayoutResource(a.g.mm_preference);
      if (this.state != 1) {
        break label223;
      }
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      label106:
      this.dnn.a(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(a.i.settings_plugings_disturb_off);
      localPreference.setKey("settings_plugings_disturb_off");
      localPreference.setLayoutResource(a.g.mm_preference);
      if (this.state != 2) {
        break label233;
      }
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
    }
    for (;;)
    {
      this.dnn.a(localPreference);
      localPreference = new Preference(this);
      localPreference.setTitle(a.i.settings_plugings_disturb_time_tip);
      localPreference.setLayoutResource(a.g.mm_preference_info);
      this.dnn.a(localPreference);
      this.dnn.notifyDataSetChanged();
      return;
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break;
      label223:
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break label106;
      label233:
      localPreference.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
    }
  }
  
  private void xh(int paramInt)
  {
    this.state = paramInt;
    if ((this.state == 1) || (this.state == 0))
    {
      g.DP().Dz().o(8200, Boolean.valueOf(true));
      if (this.state == 1)
      {
        g.DP().Dz().o(8201, Integer.valueOf(22));
        g.DP().Dz().o(8208, Integer.valueOf(8));
        ((j)g.r(j.class)).Fv().b(new k(true, 22, 8));
      }
    }
    for (;;)
    {
      bzl();
      return;
      g.DP().Dz().o(8201, Integer.valueOf(0));
      g.DP().Dz().o(8208, Integer.valueOf(0));
      ((j)g.r(j.class)).Fv().b(new k(true, 0, 0));
      continue;
      g.DP().Dz().o(8200, Boolean.valueOf(false));
      ((j)g.r(j.class)).Fv().b(new k());
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_plugings_disturb_on")) {
      xh(0);
    }
    if (paramf.equals("settings_plugings_disturb_on_night")) {
      xh(1);
    }
    if (paramf.equals("settings_plugings_disturb_off")) {
      xh(2);
    }
    return false;
  }
  
  protected final void initView()
  {
    Boolean localBoolean = Boolean.valueOf(q.GF());
    int j = q.GO();
    int k = q.GP();
    int i;
    if (localBoolean.booleanValue()) {
      if (j == k) {
        i = 0;
      }
    }
    for (this.state = i;; this.state = 2)
    {
      y.d("ui.settings.SettingsPlugingsNotify", localBoolean + "st " + j + " ed " + k + "  state " + this.state);
      this.state = this.state;
      this.dnn = this.vdd;
      setMMTitle(a.i.settings_plugings_disturb_title);
      setBackBtn(new SettingsPluginsNotifyUI.1(this));
      return;
      i = 1;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onResume()
  {
    super.onResume();
    bzl();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI
 * JD-Core Version:    0.7.0.1
 */