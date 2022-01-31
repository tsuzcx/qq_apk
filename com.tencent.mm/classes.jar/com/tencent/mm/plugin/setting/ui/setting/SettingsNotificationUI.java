package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private HashMap<Integer, Integer> fcv = new HashMap();
  private int status;
  
  private void bzj()
  {
    Preference localPreference = this.dnn.add("settings_notification_ringtone");
    if (localPreference != null) {
      localPreference.setSummary(this.dnD.getString("settings.ringtone.name", getString(a.i.settings_notification_ringtone_sys)));
    }
    this.dnn.notifyDataSetChanged();
  }
  
  private boolean iF(boolean paramBoolean)
  {
    Preference localPreference1 = this.dnn.add("settings_sound");
    Preference localPreference2 = this.dnn.add("settings_shake");
    Preference localPreference3 = this.dnn.add("settings_show_detail");
    if (localPreference1 != null) {
      localPreference1.setEnabled(paramBoolean);
    }
    if (localPreference2 != null) {
      localPreference2.setEnabled(paramBoolean);
    }
    if (localPreference3 != null) {
      localPreference3.setEnabled(paramBoolean);
    }
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_new_msg_notification"))
    {
      com.tencent.mm.m.f.bu(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 0L, 1L, false);
      }
      for (;;)
      {
        iF(((CheckBoxPreference)paramPreference).isChecked());
        as.j(true, false);
        return true;
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 1L, 1L, false);
      }
    }
    if (paramf.equals("settings_new_voip_msg_notification"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, false, this.mController.uMN.getString(a.i.settings_new_voip_msg_close_tips), "", this.mController.uMN.getString(a.i.settings_new_voip_msg_close_confirm), this.mController.uMN.getString(a.i.settings_logout_option_cancel), new SettingsNotificationUI.2(this), new SettingsNotificationUI.3(this), a.c.alert_btn_color_warn, 0);
      }
      for (;;)
      {
        initView();
        return true;
        com.tencent.mm.m.f.bv(true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 2L, 1L, false);
        as.j(false, true);
      }
    }
    boolean bool;
    if (paramf.equals("settings_voip_notification_sound"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      g.DP().Dz().o(73217, Boolean.valueOf(bool));
      g.DP().Dz().o(73218, Boolean.valueOf(bool));
      paramf = com.tencent.mm.plugin.report.service.h.nFQ;
      if (bool) {}
      for (long l = 8L;; l = 9L)
      {
        paramf.a(500L, l, 1L, false);
        y.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
        return true;
      }
    }
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.m.f.by(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 10L, 1L, false);
      }
      for (;;)
      {
        return true;
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.m.f.bz(((CheckBoxPreference)paramPreference).isChecked());
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bk.v(this, ((CheckBoxPreference)paramPreference).isChecked());
        return true;
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 17L, 1L, false);
      }
    }
    label528:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.m.f.bw(bool);
      if (!bool)
      {
        bool = true;
        y.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
        if (!bool) {
          break label560;
        }
        this.status |= 0x800;
        if (!bool) {
          break label575;
        }
      }
      label560:
      label575:
      for (i = 1;; i = 2)
      {
        this.fcv.put(Integer.valueOf(10), Integer.valueOf(i));
        return true;
        bool = false;
        break;
        this.status &= 0xFFFFF7FF;
        break label528;
      }
    }
    if (paramf.equals("settings_notification_ringtone"))
    {
      startActivity(new Intent(this.mController.uMN, SettingsRingtoneUI.class));
      return true;
    }
    if (paramf.equals("settings_active_time"))
    {
      startActivity(new Intent(this, SettingsActiveTimeUI.class));
      return true;
    }
    int j;
    int k;
    if (paramf.equals("settings_plugings_notify"))
    {
      paramf = new LinkedList();
      paramf.add(getString(a.i.settings_plugings_disturb_on));
      paramf.add(getString(a.i.settings_plugings_disturb_on_night));
      paramf.add(getString(a.i.settings_plugings_disturb_off));
      paramPreference = Boolean.valueOf(q.GF());
      j = q.GO();
      k = q.GP();
      if (!paramPreference.booleanValue()) {
        break label833;
      }
      if (j != k) {
        break label828;
      }
      i = 0;
    }
    for (;;)
    {
      y.d("MicroMsg.SettingsNotificationUI", paramPreference + "st " + j + " ed " + k + "  state " + i);
      paramPreference = this.mController.uMN;
      String str = getString(a.i.settings_plugings_disturb_title);
      getString(a.i.settings_plugings_disturb_time_tip);
      com.tencent.mm.ui.base.h.a(paramPreference, str, paramf, i, new SettingsNotificationUI.4(this, i));
      return false;
      label828:
      i = 1;
      continue;
      label833:
      i = 2;
    }
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_notification);
    this.dnn = this.vdd;
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(a.k.settings_pref_notification);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("settings_new_msg_notification");
    if (com.tencent.mm.m.f.zQ()) {
      localCheckBoxPreference1.rHo = true;
    }
    iF(localCheckBoxPreference1.isChecked());
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.dnn.add("settings_new_voip_msg_notification");
    if (com.tencent.mm.m.f.zR()) {
      localCheckBoxPreference2.rHo = true;
    }
    if (localCheckBoxPreference1.isChecked())
    {
      localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("settings_sound");
      if (com.tencent.mm.m.f.zT())
      {
        localCheckBoxPreference1.rHo = true;
        bzj();
        localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("settings_shake");
        if (com.tencent.mm.m.f.zV()) {
          localCheckBoxPreference1.rHo = true;
        }
        localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("settings_show_detail");
        if (com.tencent.mm.m.f.zS()) {
          localCheckBoxPreference1.rHo = true;
        }
      }
    }
    for (;;)
    {
      setBackBtn(new SettingsNotificationUI.1(this));
      return;
      this.dnn.ade("settings_notification_ringtone");
      break;
      this.dnn.ade("settings_show_detail");
      this.dnn.ade("settings_sound");
      this.dnn.ade("settings_notification_ringtone");
      this.dnn.ade("settings_shake");
      this.dnn.ade("settings_active_time");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.status = q.Gn();
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    as.hO(3);
  }
  
  protected void onPause()
  {
    super.onPause();
    g.DP().Dz().o(7, Integer.valueOf(this.status));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new zr();
      ((zr)localObject).sYS = i;
      ((zr)localObject).nfn = j;
      ((j)g.r(j.class)).Fv().b(new i.a(23, (a)localObject));
      y.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.fcv.clear();
  }
  
  public void onResume()
  {
    super.onResume();
    bzj();
  }
  
  public final int xj()
  {
    return a.k.settings_pref_notification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */