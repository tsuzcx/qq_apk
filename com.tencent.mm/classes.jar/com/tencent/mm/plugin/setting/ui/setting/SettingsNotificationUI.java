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
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private HashMap<Integer, Integer> jax;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean yIl;
  private boolean yIm;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.yIl = true;
    this.yIm = true;
    this.jax = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.ly(26))
    {
      if ((com.tencent.mm.sdk.h.b.fmu()) && ((!com.tencent.mm.sdk.h.b.fmt()) || ((com.tencent.mm.sdk.h.b.fmt()) && (!com.tencent.mm.sdk.h.b.fmv()))))
      {
        ad.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        paramString = new Intent("android.intent.action.MAIN");
        paramString.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        paramString.putExtra("appName", aj.getContext().getResources().getString(2131755822));
        paramString.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(paramString, paramd);
        AppMethodBeat.o(74301);
        return;
      }
      ad.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
      if (v.N(getContext()).areNotificationsEnabled())
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
    if (com.tencent.mm.compatible.util.d.ly(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramd.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void axd(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void Pg(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private void dNQ()
  {
    AppMethodBeat.i(221036);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.yIl).append(", install ").append(com.tencent.mm.bs.d.aIu("sns")).append(", flag ");
    boolean bool;
    if ((u.aAy() & 0x8000) == 0)
    {
      bool = true;
      ad.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.yIl) {
        break label161;
      }
      this.screen.cP("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.aVD("settings_sns_notify");
      if (localObject == null) {
        break label183;
      }
      ((Preference)localObject).JtB = false;
      this.yIm = bt.a((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(68384, null), true);
      if (!this.yIm) {
        break label178;
      }
      ((CheckBoxPreference)localObject).oB = true;
      AppMethodBeat.o(221036);
      return;
      bool = false;
      break;
      label161:
      this.screen.cP("settings_sns_notify", true);
    }
    label178:
    ((CheckBoxPreference)localObject).oB = false;
    label183:
    AppMethodBeat.o(221036);
  }
  
  private boolean dNR()
  {
    AppMethodBeat.i(221037);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.yIm)
    {
      bool = true;
      this.yIm = bool;
      if (!this.yIm) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(68384, Boolean.valueOf(this.yIm));
      dNQ();
      AppMethodBeat.o(221037);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.g.yhR.f(14098, new Object[] { Integer.valueOf(4) });
    }
  }
  
  public int getResourceId()
  {
    return 2131951730;
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
    if (com.tencent.mm.compatible.util.d.ly(26))
    {
      this.screen.cP("settings_notification_top", true);
      this.screen.cP("settings_notification_title", false);
      this.screen.cP("settings_notification_sound_shake", false);
      this.screen.cP("settings_voip_sound_and_shake", false);
      if ((u.aAr() & 0x0) == 0L) {
        break label519;
      }
      i = 1;
      if (i != 0) {
        break label524;
      }
      i = 1;
      localObject = this.screen;
      if ((((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry()) && (i != 0)) {
        break label529;
      }
      bool1 = true;
      label151:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("settings_notification_finder", bool1);
      localObject = (CheckBoxPreference)this.screen.aVD("settings_notification_finder");
      ((Preference)localObject).JtB = false;
      bool1 = ((t)com.tencent.mm.kernel.g.ad(t.class)).getRedDotManager().czR();
      ad.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject).oB = bool1;
      localObject = (CheckBoxPreference)this.screen.aVD("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.ly(26)) {
        break label539;
      }
      if ((!com.tencent.mm.n.f.abF()) || (!com.tencent.mm.n.f.abG())) {
        break label534;
      }
      bool1 = true;
      label266:
      ((CheckBoxPreference)localObject).oB = bool1;
      label272:
      ((CheckBoxPreference)this.screen.aVD("settings_new_voip_msg_notification")).oB = com.tencent.mm.n.f.abH();
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label798;
      }
      if (!com.tencent.mm.compatible.util.d.ly(26)) {
        break label555;
      }
      this.screen.cP("settings_notification_sound_and_shake", false);
      this.screen.cP("settings_sound", true);
      this.screen.cP("settings_shake", true);
      this.screen.cP("settings_notification_ringtone", true);
      com.tencent.mm.n.a.abV();
      ad.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.n.a.abU()) });
      localObject = this.screen;
      if (com.tencent.mm.n.a.abU() != 1) {
        break label550;
      }
      bool1 = bool2;
      label404:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.aVD("settings_show_detail")).oB = com.tencent.mm.n.f.abI();
    }
    for (;;)
    {
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
      dNQ();
      AppMethodBeat.o(74295);
      return;
      this.screen.cP("settings_notification_top", false);
      this.screen.cP("settings_notification_title", true);
      this.screen.cP("settings_notification_sound_shake", true);
      this.screen.cP("settings_voip_sound_and_shake", true);
      break;
      label519:
      i = 0;
      break label116;
      label524:
      i = 0;
      break label122;
      label529:
      bool1 = false;
      break label151;
      label534:
      bool1 = false;
      break label266;
      label539:
      ((CheckBoxPreference)localObject).oB = com.tencent.mm.n.f.abF();
      break label272;
      label550:
      bool1 = true;
      break label404;
      label555:
      localObject = (CheckBoxPreference)this.screen.aVD("settings_sound");
      ((CheckBoxPreference)localObject).oB = com.tencent.mm.n.f.abJ();
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.aVD("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.ly(26))
        {
          String str = com.tencent.mm.n.f.abP();
          if (str != com.tencent.mm.n.f.gek) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.aVD("settings_shake")).oB = com.tencent.mm.n.f.abN();
        this.screen.cP("settings_notification_sound_and_shake", true);
        this.screen.cP("settings_special_scene_notification_title", true);
        this.screen.cP("settings_specail_scene_sound", true);
        this.screen.cP("settings_specail_scene_shake", true);
        this.screen.cP("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131763334));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131763334)));
          continue;
          this.screen.aVE("settings_notification_ringtone");
        }
      }
      label798:
      this.screen.aVE("settings_show_detail");
      this.screen.aVE("settings_sound");
      this.screen.aVE("settings_notification_ringtone");
      this.screen.aVE("settings_shake");
      this.screen.aVE("settings_active_time");
      this.screen.aVE("settings_notification_sound_and_shake");
      this.screen.aVE("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = u.aAq();
    if ((com.tencent.mm.bs.d.aIu("sns")) && ((u.aAy() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yIl = bool;
      setMMTitle(2131763332);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    ay.ou(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    com.tencent.mm.kernel.g.ajC().ajl().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.jax.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aty();
      ((aty)localObject).GrZ = i;
      ((aty)localObject).xcI = j;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(23, (com.tencent.mm.bx.a)localObject));
      ad.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.jax.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.ly(26)) && (!com.tencent.mm.n.f.abG()))
      {
        f.a locala = new f.a(getContext());
        locala.aXO(getString(2131763111)).yU(false);
        locala.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void Pg(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!com.tencent.mm.n.f.abG())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  com.tencent.mm.n.f.cQ(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 0L, 1L, false);
                  ay.m(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.br.a.abB());
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
        com.tencent.mm.kernel.g.ajC().ajl().set(73217, Boolean.valueOf(bool));
        com.tencent.mm.kernel.g.ajC().ajl().set(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label459;
        }
      }
    }
    label459:
    for (long l = 8L;; l = 9L)
    {
      paramf.idkeyStat(500L, l, 1L, false);
      ad.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(74298);
      return true;
      com.tencent.mm.n.f.cQ(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        ay.m(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = dNR();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ad.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((t)com.tencent.mm.kernel.g.ad(t.class)).getRedDotManager().lN(bool);
        break;
      }
      if (!paramf.equals("settings_new_voip_msg_notification")) {
        break;
      }
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        h.a(getContext(), false, getContext().getString(2131763328), "", getContext().getString(2131763327), getContext().getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74291);
            com.tencent.mm.n.f.cR(false);
            paramAnonymousDialogInterface = new bu();
            paramAnonymousDialogInterface.kr(2);
            paramAnonymousDialogInterface.qA(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.tN("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
            bj.v(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.kp(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 3L, 1L, false);
              ay.m(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new at();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.kp(1);
              ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.n.f.cR(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).aVD("settings_new_voip_msg_notification")).oB = true;
            SettingsNotificationUI.this.initView();
            ay.m(false, true);
            AppMethodBeat.o(74292);
          }
        }, 2131099904, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.n.f.cR(true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 2L, 1L, false);
        ay.m(false, true);
        initView();
      }
    }
    label467:
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.n.f.cT(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.n.f.cU(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bt.F(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 17L, 1L, false);
      }
    }
    label702:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.n.f.cS(bool);
      if (!bool)
      {
        bool = true;
        ad.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
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
        this.jax.put(Integer.valueOf(10), Integer.valueOf(i));
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      axd(com.tencent.mm.br.a.abB());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.lA(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1037;
        }
        axd(com.tencent.mm.br.a.eYE());
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */