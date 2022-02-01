package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private boolean JiP;
  private boolean JiQ;
  private HashMap<Integer, Integer> mSR;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.JiP = true;
    this.JiQ = true;
    this.mSR = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private static boolean Hh(long paramLong)
  {
    AppMethodBeat.i(263944);
    if ((com.tencent.mm.model.z.bde() & paramLong) != 0L)
    {
      AppMethodBeat.o(263944);
      return true;
    }
    AppMethodBeat.o(263944);
    return false;
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.qV(26))
    {
      if ((MIUI.ifMIUI()) && ((!MIUI.isMIUI10()) || ((MIUI.isMIUI10()) && (!MIUI.ifNotificationChannelSupportNativeActionJump()))))
      {
        Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        paramString = new Intent("android.intent.action.MAIN");
        paramString.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        paramString.putExtra("appName", MMApplicationContext.getContext().getResources().getString(b.i.app_name));
        paramString.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(paramString, paramd);
        AppMethodBeat.o(74301);
        return;
      }
      Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
      if (androidx.core.app.h.M(getContext()).gs())
      {
        localIntent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        localIntent.putExtra("android.provider.extra.CHANNEL_ID", paramString);
      }
      for (;;)
      {
        localIntent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(localIntent, paramd);
        AppMethodBeat.o(74301);
        return;
        localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      }
    }
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramd.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void aXM(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void aep(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private void fGs()
  {
    AppMethodBeat.i(263946);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.JiP).append(", install ").append(c.blP("sns")).append(", flag ");
    boolean bool;
    if ((com.tencent.mm.model.z.bdn() & 0x8000) == 0)
    {
      bool = true;
      Log.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.JiP) {
        break label164;
      }
      this.screen.dz("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.byG("settings_sns_notify");
      if (localObject == null) {
        break label186;
      }
      ((Preference)localObject).WsF = false;
      this.JiQ = Util.nullAs((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(68384, null), true);
      if (!this.JiQ) {
        break label181;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      AppMethodBeat.o(263946);
      return;
      bool = false;
      break;
      label164:
      this.screen.dz("settings_sns_notify", true);
    }
    label181:
    ((CheckBoxPreference)localObject).setChecked(false);
    label186:
    AppMethodBeat.o(263946);
  }
  
  private boolean fGt()
  {
    AppMethodBeat.i(263947);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.JiQ)
    {
      bool = true;
      this.JiQ = bool;
      if (!this.JiQ) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(68384, Boolean.valueOf(this.JiQ));
      fGs();
      AppMethodBeat.o(263947);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(4) });
    }
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_notification;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(74295);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.auC(getResourceId());
    int i;
    label113:
    Object localObject1;
    label142:
    label229:
    Object localObject2;
    if (com.tencent.mm.compatible.util.d.qV(26))
    {
      this.screen.dz("settings_notification_top", true);
      this.screen.dz("settings_notification_title", false);
      this.screen.dz("settings_notification_sound_shake", false);
      this.screen.dz("settings_voip_sound_and_shake", false);
      if (Hh(34359738368L)) {
        break label1033;
      }
      i = 1;
      localObject1 = this.screen;
      if ((((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry()) && (i != 0)) {
        break label1038;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_notification_finder", bool1);
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_notification_finder");
      ((Preference)localObject1).WsF = false;
      bool1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().dqI();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      if (Hh(70368744177664L)) {
        break label1043;
      }
      bool1 = true;
      Log.i("MicroMsg.SettingsNotificationUI", "openNearBy " + ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeI() + " " + bool1);
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_notification_finder_nearby");
      if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeH()) {
        break label1048;
      }
      ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.find_friends_by_nearby_title));
      label336:
      localObject2 = this.screen;
      if ((((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeI()) && (bool1)) {
        break label1069;
      }
      bool1 = true;
      label370:
      ((com.tencent.mm.ui.base.preference.f)localObject2).dz("settings_notification_finder_nearby", bool1);
      ((Preference)localObject1).WsF = false;
      bool1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().dqJ();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_nearby : initState = ".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      if (Hh(9007199254740992L)) {
        break label1074;
      }
      bool1 = true;
      label440:
      boolean bool4 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeH();
      boolean bool3 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().dqK();
      Log.i("MicroMsg.SettingsNotificationUI", "openFinderLive:" + bool1 + " hitEnableFinderLiveTest:" + bool4 + " isEnableShowFinderLiveEntranceRedDot:" + bool3);
      localObject1 = this.screen;
      if ((bool4) && (bool1)) {
        break label1079;
      }
      bool1 = true;
      label543:
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_notification_finder_live", bool1);
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_notification_finder_live");
      ((Preference)localObject1).WsF = false;
      ((CheckBoxPreference)localObject1).setChecked(bool3);
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.qV(26)) {
        break label1089;
      }
      if ((!g.awg()) || (!g.awh())) {
        break label1084;
      }
      bool1 = true;
      label624:
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      label630:
      ((CheckBoxPreference)this.screen.byG("settings_new_voip_msg_notification")).setChecked(g.awi());
      if (!((CheckBoxPreference)localObject1).isChecked()) {
        break label1348;
      }
      if (!com.tencent.mm.compatible.util.d.qV(26)) {
        break label1105;
      }
      this.screen.dz("settings_notification_sound_and_shake", false);
      this.screen.dz("settings_sound", true);
      this.screen.dz("settings_shake", true);
      this.screen.dz("settings_notification_ringtone", true);
      com.tencent.mm.n.b.aww();
      Log.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.n.b.awv()) });
      localObject1 = this.screen;
      if (com.tencent.mm.n.b.awv() != 1) {
        break label1100;
      }
      bool1 = false;
      label762:
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.byG("settings_show_detail")).setChecked(g.awj());
      label795:
      if (WeChatBrands.Business.Entries.MeSetNewMsgChannels.banned()) {
        this.screen.byI("settings_notification_finder");
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74288);
          SettingsNotificationUI.this.hideVKB();
          SettingsNotificationUI.this.finish();
          AppMethodBeat.o(74288);
          return true;
        }
      });
      fGs();
      if ((!this.screen.byH("settings_sns_notify")) && (!this.screen.byH("settings_notification_finder_nearby")) && (!this.screen.byH("settings_notification_finder")) && (!this.screen.byH("settings_notification_finder_live"))) {
        break label1442;
      }
      i = 1;
      label895:
      localObject1 = this.screen;
      if (i != 0) {
        break label1447;
      }
    }
    label1033:
    label1038:
    label1043:
    label1048:
    label1442:
    label1447:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_notification_title", bool1);
      localObject1 = this.screen;
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_notification_tips", bool1);
      ((PreferenceFooterCategory)this.screen.byG("settings_notification_tips")).WsU = true;
      AppMethodBeat.o(74295);
      return;
      this.screen.dz("settings_notification_top", false);
      this.screen.dz("settings_notification_title", true);
      this.screen.dz("settings_notification_sound_shake", true);
      this.screen.dz("settings_voip_sound_and_shake", true);
      break;
      i = 0;
      break label113;
      bool1 = false;
      break label142;
      bool1 = false;
      break label229;
      ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.nearby_live_friend_title));
      break label336;
      label1069:
      bool1 = false;
      break label370;
      label1074:
      bool1 = false;
      break label440;
      label1079:
      bool1 = false;
      break label543;
      label1084:
      bool1 = false;
      break label624;
      label1089:
      ((CheckBoxPreference)localObject1).setChecked(g.awg());
      break label630;
      label1100:
      bool1 = true;
      break label762;
      label1105:
      localObject1 = (CheckBoxPreference)this.screen.byG("settings_sound");
      ((CheckBoxPreference)localObject1).setChecked(g.awk());
      if (((CheckBoxPreference)localObject1).isChecked())
      {
        localObject1 = this.screen.byG("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.qV(26))
        {
          localObject2 = g.awq();
          if (localObject2 != g.jwm) {
            ((Preference)localObject1).aF(RingtoneManager.getRingtone(this, Uri.parse((String)localObject2)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.byG("settings_shake")).setChecked(g.awo());
        this.screen.dz("settings_notification_sound_and_shake", true);
        this.screen.dz("settings_special_scene_notification_title", true);
        this.screen.dz("settings_specail_scene_sound", true);
        this.screen.dz("settings_specail_scene_shake", true);
        this.screen.dz("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject1).aF(getString(b.i.settings_notification_ringtone_sys));
        continue;
        if (localObject1 != null)
        {
          ((Preference)localObject1).aF(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(b.i.settings_notification_ringtone_sys)));
          continue;
          this.screen.byI("settings_notification_ringtone");
        }
      }
      label1348:
      this.screen.byI("settings_show_detail");
      this.screen.byI("settings_sound");
      this.screen.byI("settings_notification_ringtone");
      this.screen.byI("settings_shake");
      this.screen.byI("settings_active_time");
      this.screen.byI("settings_notification_sound_and_shake");
      this.screen.byI("settings_special_scene_notification_sound_and_shake");
      break label795;
      i = 0;
      break label895;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = com.tencent.mm.model.z.bdd();
    if ((c.blP("sns")) && ((com.tencent.mm.model.z.bdn() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.JiP = bool;
      setMMTitle(b.i.settings_notification);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    bf.uV(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(this.status));
    Iterator localIterator = this.mSR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bmy();
      ((bmy)localObject).SXP = i;
      ((bmy)localObject).HmX = j;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, (com.tencent.mm.cd.a)localObject));
      Log.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.mSR.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.qV(26)) && (!g.awh()))
      {
        f.a locala = new f.a(getContext());
        locala.bBl(getString(b.i.setting_notification_sys_notification_disable_warning)).HL(false);
        locala.c(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void aep(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!g.awh())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  g.ea(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 0L, 1L, false);
                  bf.q(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.bx.a.awc());
              AppMethodBeat.o(74290);
              return;
            }
            SettingsNotificationUI.this.initView();
            AppMethodBeat.o(74290);
          }
        }).show();
        if (!paramf.equals("settings_voip_notification_sound")) {
          break label659;
        }
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        com.tencent.mm.kernel.h.aHG().aHp().i(73217, Boolean.valueOf(bool));
        com.tencent.mm.kernel.h.aHG().aHp().i(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label651;
        }
      }
    }
    label651:
    for (long l = 8L;; l = 9L)
    {
      paramf.idkeyStat(500L, l, 1L, false);
      Log.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(74298);
      return true;
      g.ea(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        bf.q(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = fGt();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().ok(bool);
        break;
      }
      if (paramf.equals("settings_notification_finder_live"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_live isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().om(bool);
        break;
      }
      if (paramf.equals("settings_notification_finder_nearby"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_nearby isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().ol(bool);
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(22479, new Object[] { Long.valueOf(cm.bfE()), Integer.valueOf(1) });
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(22479, new Object[] { Long.valueOf(cm.bfE()), Integer.valueOf(0) });
        break;
      }
      if (!paramf.equals("settings_new_voip_msg_notification")) {
        break;
      }
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.ui.base.h.a(getContext(), false, getContext().getString(b.i.settings_new_voip_msg_close_tips), "", getContext().getString(b.i.settings_new_voip_msg_close_confirm), getContext().getString(b.i.settings_logout_option_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74291);
            g.eb(false);
            paramAnonymousDialogInterface = new ca();
            paramAnonymousDialogInterface.pJ(2);
            paramAnonymousDialogInterface.setCreateTime(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.Jm("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
            bq.z(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.pH(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 3L, 1L, false);
              bf.q(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new az();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.pH(1);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            g.eb(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).byG("settings_new_voip_msg_notification")).setChecked(true);
            SettingsNotificationUI.this.initView();
            bf.q(false, true);
            AppMethodBeat.o(74292);
          }
        }, b.c.alert_btn_color_warn, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        g.eb(true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 2L, 1L, false);
        bf.q(false, true);
        initView();
      }
    }
    label659:
    if (paramf.equals("settings_sound"))
    {
      g.ed(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      g.ee(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 17L, 1L, false);
      }
    }
    label894:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      g.ec(bool);
      if (!bool)
      {
        bool = true;
        Log.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
        if (!bool) {
          break label932;
        }
        this.status |= 0x800;
        if (!bool) {
          break label947;
        }
      }
      label932:
      label947:
      for (i = 1;; i = 2)
      {
        this.mSR.put(Integer.valueOf(10), Integer.valueOf(i));
        AppMethodBeat.o(74298);
        return true;
        bool = false;
        break;
        this.status &= 0xFFFFF7FF;
        break label894;
      }
    }
    if (paramf.equals("settings_notification_ringtone"))
    {
      paramf = new Intent(getContext(), SettingsRingtoneUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      aXM(com.tencent.mm.bx.a.awc());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.qX(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1229;
        }
        aXM(com.tencent.mm.bx.a.hfu());
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        i = 0;
        break;
        label1229:
        paramf = new Intent();
        paramf.setClass(this, SettingsVoipSoundVibrateUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(74298);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74297);
    super.onResume();
    initView();
    AppMethodBeat.o(74297);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */