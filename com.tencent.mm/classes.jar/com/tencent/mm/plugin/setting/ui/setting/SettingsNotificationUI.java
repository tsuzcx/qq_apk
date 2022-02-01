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
import android.support.v4.app.v;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
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
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private boolean Ddl;
  private boolean Ddm;
  private HashMap<Integer, Integer> kbt;
  private f screen;
  private int status;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.Ddl = true;
    this.Ddm = true;
    this.kbt = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.oD(26))
    {
      if ((MIUI.ifMIUI()) && ((!MIUI.isMIUI10()) || ((MIUI.isMIUI10()) && (!MIUI.ifNotificationChannelSupportNativeActionJump()))))
      {
        Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        paramString = new Intent("android.intent.action.MAIN");
        paramString.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        paramString.putExtra("appName", MMApplicationContext.getContext().getResources().getString(2131755908));
        paramString.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(paramString, paramd);
        AppMethodBeat.o(74301);
        return;
      }
      Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
      if (v.P(getContext()).areNotificationsEnabled())
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
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramd.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void aNd(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void Xq(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private void eTo()
  {
    AppMethodBeat.i(256585);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.Ddl).append(", install ").append(c.aZU("sns")).append(", flag ");
    boolean bool;
    if ((com.tencent.mm.model.z.aUl() & 0x8000) == 0)
    {
      bool = true;
      Log.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.Ddl) {
        break label161;
      }
      this.screen.jdMethod_do("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.bmg("settings_sns_notify");
      if (localObject == null) {
        break label183;
      }
      ((Preference)localObject).OZw = false;
      this.Ddm = Util.nullAs((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(68384, null), true);
      if (!this.Ddm) {
        break label178;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      AppMethodBeat.o(256585);
      return;
      bool = false;
      break;
      label161:
      this.screen.jdMethod_do("settings_sns_notify", true);
    }
    label178:
    ((CheckBoxPreference)localObject).setChecked(false);
    label183:
    AppMethodBeat.o(256585);
  }
  
  private boolean eTp()
  {
    AppMethodBeat.i(256586);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.Ddm)
    {
      bool = true;
      this.Ddm = bool;
      if (!this.Ddm) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(68384, Boolean.valueOf(this.Ddm));
      eTo();
      AppMethodBeat.o(256586);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.h.CyF.a(14098, new Object[] { Integer.valueOf(4) });
    }
  }
  
  public int getResourceId()
  {
    return 2132017275;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(74295);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    int i;
    label116:
    label122:
    Object localObject;
    boolean bool1;
    if (com.tencent.mm.compatible.util.d.oD(26))
    {
      this.screen.jdMethod_do("settings_notification_top", true);
      this.screen.jdMethod_do("settings_notification_title", false);
      this.screen.jdMethod_do("settings_notification_sound_shake", false);
      this.screen.jdMethod_do("settings_voip_sound_and_shake", false);
      if ((com.tencent.mm.model.z.aUd() & 0x0) == 0L) {
        break label541;
      }
      i = 1;
      if (i != 0) {
        break label546;
      }
      i = 1;
      localObject = this.screen;
      if ((((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry()) && (i != 0)) {
        break label551;
      }
      bool1 = true;
      label151:
      ((f)localObject).jdMethod_do("settings_notification_finder", bool1);
      localObject = (CheckBoxPreference)this.screen.bmg("settings_notification_finder");
      ((Preference)localObject).OZw = false;
      bool1 = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getRedDotManager().daH();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject).setChecked(bool1);
      localObject = (CheckBoxPreference)this.screen.bmg("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.oD(26)) {
        break label561;
      }
      if ((!com.tencent.mm.n.g.apN()) || (!com.tencent.mm.n.g.apO())) {
        break label556;
      }
      bool1 = true;
      label266:
      ((CheckBoxPreference)localObject).setChecked(bool1);
      label272:
      ((CheckBoxPreference)this.screen.bmg("settings_new_voip_msg_notification")).setChecked(com.tencent.mm.n.g.apP());
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label820;
      }
      if (!com.tencent.mm.compatible.util.d.oD(26)) {
        break label577;
      }
      this.screen.jdMethod_do("settings_notification_sound_and_shake", false);
      this.screen.jdMethod_do("settings_sound", true);
      this.screen.jdMethod_do("settings_shake", true);
      this.screen.jdMethod_do("settings_notification_ringtone", true);
      com.tencent.mm.n.b.aqd();
      Log.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.n.b.aqc()) });
      localObject = this.screen;
      if (com.tencent.mm.n.b.aqc() != 1) {
        break label572;
      }
      bool1 = bool2;
      label404:
      ((f)localObject).jdMethod_do("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.bmg("settings_show_detail")).setChecked(com.tencent.mm.n.g.apQ());
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetNewMsgChannels.banned()) {
        this.screen.bmi("settings_notification_finder");
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
      eTo();
      AppMethodBeat.o(74295);
      return;
      this.screen.jdMethod_do("settings_notification_top", false);
      this.screen.jdMethod_do("settings_notification_title", true);
      this.screen.jdMethod_do("settings_notification_sound_shake", true);
      this.screen.jdMethod_do("settings_voip_sound_and_shake", true);
      break;
      label541:
      i = 0;
      break label116;
      label546:
      i = 0;
      break label122;
      label551:
      bool1 = false;
      break label151;
      label556:
      bool1 = false;
      break label266;
      label561:
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.n.g.apN());
      break label272;
      label572:
      bool1 = true;
      break label404;
      label577:
      localObject = (CheckBoxPreference)this.screen.bmg("settings_sound");
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.n.g.apR());
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.bmg("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.oD(26))
        {
          String str = com.tencent.mm.n.g.apX();
          if (str != com.tencent.mm.n.g.gLX) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.bmg("settings_shake")).setChecked(com.tencent.mm.n.g.apV());
        this.screen.jdMethod_do("settings_notification_sound_and_shake", true);
        this.screen.jdMethod_do("settings_special_scene_notification_title", true);
        this.screen.jdMethod_do("settings_specail_scene_sound", true);
        this.screen.jdMethod_do("settings_specail_scene_shake", true);
        this.screen.jdMethod_do("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131765515));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131765515)));
          continue;
          this.screen.bmi("settings_notification_ringtone");
        }
      }
      label820:
      this.screen.bmi("settings_show_detail");
      this.screen.bmi("settings_sound");
      this.screen.bmi("settings_notification_ringtone");
      this.screen.bmi("settings_shake");
      this.screen.bmi("settings_active_time");
      this.screen.bmi("settings_notification_sound_and_shake");
      this.screen.bmi("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = com.tencent.mm.model.z.aUc();
    if ((c.aZU("sns")) && ((com.tencent.mm.model.z.aUl() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ddl = bool;
      setMMTitle(2131765511);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    be.rY(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    com.tencent.mm.kernel.g.aAh().azQ().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.kbt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bfx();
      ((bfx)localObject).LPB = i;
      ((bfx)localObject).BsD = j;
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      Log.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.kbt.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.oD(26)) && (!com.tencent.mm.n.g.apO()))
      {
        f.a locala = new f.a(getContext());
        locala.bow(getString(2131765273)).Dq(false);
        locala.c(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void Xq(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!com.tencent.mm.n.g.apO())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  com.tencent.mm.n.g.dA(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 0L, 1L, false);
                  be.m(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.bq.a.apJ());
              AppMethodBeat.o(74290);
              return;
            }
            SettingsNotificationUI.this.initView();
            AppMethodBeat.o(74290);
          }
        }).show();
        if (!paramf.equals("settings_voip_notification_sound")) {
          break label467;
        }
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        com.tencent.mm.kernel.g.aAh().azQ().set(73217, Boolean.valueOf(bool));
        com.tencent.mm.kernel.g.aAh().azQ().set(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label459;
        }
      }
    }
    label459:
    for (long l = 8L;; l = 9L)
    {
      paramf.idkeyStat(500L, l, 1L, false);
      Log.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(74298);
      return true;
      com.tencent.mm.n.g.dA(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        be.m(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = eTp();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getRedDotManager().mS(bool);
        break;
      }
      if (!paramf.equals("settings_new_voip_msg_notification")) {
        break;
      }
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.ui.base.h.a(getContext(), false, getContext().getString(2131765507), "", getContext().getString(2131765506), getContext().getString(2131765435), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74291);
            com.tencent.mm.n.g.dB(false);
            paramAnonymousDialogInterface = new ca();
            paramAnonymousDialogInterface.nv(2);
            paramAnonymousDialogInterface.setCreateTime(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.Cy("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131765509, new Object[] { Build.MODEL }));
            bp.x(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131765509, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.nt(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 3L, 1L, false);
              be.m(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new az();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131765509, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.nt(1);
              ((l)com.tencent.mm.kernel.g.af(l.class)).aST().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.n.g.dB(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).bmg("settings_new_voip_msg_notification")).setChecked(true);
            SettingsNotificationUI.this.initView();
            be.m(false, true);
            AppMethodBeat.o(74292);
          }
        }, 2131099922, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.n.g.dB(true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 2L, 1L, false);
        be.m(false, true);
        initView();
      }
    }
    label467:
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.n.g.dD(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.n.g.dE(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 17L, 1L, false);
      }
    }
    label702:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.n.g.dC(bool);
      if (!bool)
      {
        bool = true;
        Log.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
        if (!bool) {
          break label740;
        }
        this.status |= 0x800;
        if (!bool) {
          break label755;
        }
      }
      label740:
      label755:
      for (i = 1;; i = 2)
      {
        this.kbt.put(Integer.valueOf(10), Integer.valueOf(i));
        AppMethodBeat.o(74298);
        return true;
        bool = false;
        break;
        this.status &= 0xFFFFF7FF;
        break label702;
      }
    }
    if (paramf.equals("settings_notification_ringtone"))
    {
      paramf = new Intent(getContext(), SettingsRingtoneUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      aNd(com.tencent.mm.bq.a.apJ());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.oF(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1037;
        }
        aNd(com.tencent.mm.bq.a.glD());
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        i = 0;
        break;
        label1037:
        paramf = new Intent();
        paramf.setClass(this, SettingsVoipSoundVibrateUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */