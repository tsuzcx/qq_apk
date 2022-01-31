package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.v;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private HashMap<Integer, Integer> guf;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(127356);
    this.guf = new HashMap();
    AppMethodBeat.o(127356);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd)
  {
    AppMethodBeat.i(127363);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.fv(26))
    {
      if ((com.tencent.mm.sdk.h.b.duO()) && ((!com.tencent.mm.sdk.h.b.duN()) || ((com.tencent.mm.sdk.h.b.duN()) && (!com.tencent.mm.sdk.h.b.duP()))))
      {
        ab.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        localIntent = new Intent("android.intent.action.MAIN");
        localIntent.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        localIntent.putExtra("appName", ah.getContext().getResources().getString(2131297005));
        localIntent.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(localIntent, paramd);
        AppMethodBeat.o(127363);
        return;
      }
      ab.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
      if (v.K(getContext()).areNotificationsEnabled())
      {
        localIntent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        localIntent.putExtra("android.provider.extra.CHANNEL_ID", com.tencent.mm.bp.a.Mt());
      }
      for (;;)
      {
        localIntent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(localIntent, paramd);
        AppMethodBeat.o(127363);
        return;
        localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      }
    }
    if (com.tencent.mm.compatible.util.d.fv(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      startActivity(localIntent);
      AppMethodBeat.o(127363);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  public int getResourceId()
  {
    return 2131165286;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(127358);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    Object localObject;
    boolean bool1;
    if (com.tencent.mm.compatible.util.d.fv(26))
    {
      this.screen.cl("settings_notification_top", true);
      this.screen.cl("settings_notification_title", false);
      this.screen.cl("settings_notification_sound_shake", false);
      this.screen.cl("settings_voip_sound_and_shake", false);
      localObject = (CheckBoxPreference)this.screen.atx("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.fv(26)) {
        break label364;
      }
      if ((!com.tencent.mm.m.f.Mx()) || (!com.tencent.mm.m.f.My())) {
        break label359;
      }
      bool1 = true;
      label130:
      ((CheckBoxPreference)localObject).vxW = bool1;
      label135:
      ((CheckBoxPreference)this.screen.atx("settings_new_voip_msg_notification")).vxW = com.tencent.mm.m.f.Mz();
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label608;
      }
      if (!com.tencent.mm.compatible.util.d.fv(26)) {
        break label379;
      }
      this.screen.cl("settings_notification_sound_and_shake", false);
      this.screen.cl("settings_sound", true);
      this.screen.cl("settings_shake", true);
      this.screen.cl("settings_notification_ringtone", true);
      com.tencent.mm.m.a.ML();
      ab.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.m.a.MK()) });
      localObject = this.screen;
      if (com.tencent.mm.m.a.MK() != 1) {
        break label374;
      }
      bool1 = bool2;
      label259:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.atx("settings_show_detail")).vxW = com.tencent.mm.m.f.MA();
    }
    for (;;)
    {
      setBackBtn(new SettingsNotificationUI.1(this));
      AppMethodBeat.o(127358);
      return;
      this.screen.cl("settings_notification_top", false);
      this.screen.cl("settings_notification_title", true);
      this.screen.cl("settings_notification_sound_shake", true);
      this.screen.cl("settings_voip_sound_and_shake", true);
      break;
      label359:
      bool1 = false;
      break label130;
      label364:
      ((CheckBoxPreference)localObject).vxW = com.tencent.mm.m.f.Mx();
      break label135;
      label374:
      bool1 = true;
      break label259;
      label379:
      localObject = (CheckBoxPreference)this.screen.atx("settings_sound");
      ((CheckBoxPreference)localObject).vxW = com.tencent.mm.m.f.MB();
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.atx("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.fv(26))
        {
          String str = com.tencent.mm.m.f.MF();
          if (str != com.tencent.mm.m.f.etD) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.atx("settings_shake")).vxW = com.tencent.mm.m.f.MD();
        this.screen.cl("settings_notification_sound_and_shake", true);
        this.screen.cl("settings_special_scene_notification_title", true);
        this.screen.cl("settings_specail_scene_sound", true);
        this.screen.cl("settings_specail_scene_shake", true);
        this.screen.cl("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131303352));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131303352)));
          continue;
          this.screen.aty("settings_notification_ringtone");
        }
      }
      label608:
      this.screen.aty("settings_show_detail");
      this.screen.aty("settings_sound");
      this.screen.aty("settings_notification_ringtone");
      this.screen.aty("settings_shake");
      this.screen.aty("settings_active_time");
      this.screen.aty("settings_notification_sound_and_shake");
      this.screen.aty("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127357);
    super.onCreate(paramBundle);
    this.status = r.Zr();
    setMMTitle(2131303350);
    AppMethodBeat.o(127357);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127362);
    super.onDestroy();
    au.kA(3);
    AppMethodBeat.o(127362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127359);
    super.onPause();
    g.RL().Ru().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.guf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aek();
      ((aek)localObject).wXn = i;
      ((aek)localObject).pKC = j;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      ab.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.guf.clear();
    AppMethodBeat.o(127359);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127361);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_new_msg_notification"))
    {
      if ((com.tencent.mm.compatible.util.d.fv(26)) && (!com.tencent.mm.m.f.My()))
      {
        e.a locala = new e.a(getContext());
        locala.avu(getString(2131303146)).rI(false);
        locala.c(new SettingsNotificationUI.2(this)).show();
      }
    }
    else
    {
      if (!paramf.equals("settings_new_voip_msg_notification")) {
        break label263;
      }
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        break label233;
      }
      com.tencent.mm.ui.base.h.a(getContext(), false, getContext().getString(2131303346), "", getContext().getString(2131303345), getContext().getString(2131303296), new SettingsNotificationUI.3(this), new SettingsNotificationUI.4(this), 2131689667, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(127361);
      return true;
      com.tencent.mm.m.f.bT(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        au.k(true, false);
        AppMethodBeat.o(127361);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 1L, 1L, false);
      }
      label233:
      com.tencent.mm.m.f.bU(true);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 2L, 1L, false);
      au.k(false, true);
      initView();
    }
    label263:
    boolean bool;
    if (paramf.equals("settings_voip_notification_sound"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      g.RL().Ru().set(73217, Boolean.valueOf(bool));
      g.RL().Ru().set(73218, Boolean.valueOf(bool));
      paramf = com.tencent.mm.plugin.report.service.h.qsU;
      if (bool) {}
      for (long l = 8L;; l = 9L)
      {
        paramf.idkeyStat(500L, l, 1L, false);
        ab.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(127361);
        return true;
      }
    }
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.m.f.bW(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(127361);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.m.f.bX(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bo.z(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(127361);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 17L, 1L, false);
      }
    }
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.m.f.bV(bool);
      if (!bool)
      {
        bool = true;
        ab.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
        if (!bool) {
          break label650;
        }
        this.status |= 0x800;
        label612:
        if (!bool) {
          break label665;
        }
      }
      label650:
      label665:
      for (int i = 1;; i = 2)
      {
        this.guf.put(Integer.valueOf(10), Integer.valueOf(i));
        AppMethodBeat.o(127361);
        return true;
        bool = false;
        break;
        this.status &= 0xFFFFF7FF;
        break label612;
      }
    }
    if (paramf.equals("settings_notification_ringtone"))
    {
      startActivity(new Intent(getContext(), SettingsRingtoneUI.class));
      AppMethodBeat.o(127361);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      a(new SettingsNotificationUI.5(this));
      AppMethodBeat.o(127361);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      startActivity(paramf);
      AppMethodBeat.o(127361);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsVoipSoundVibrateUI.class);
      startActivity(paramf);
      AppMethodBeat.o(127361);
      return true;
    }
    AppMethodBeat.o(127361);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127360);
    super.onResume();
    initView();
    AppMethodBeat.o(127360);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */