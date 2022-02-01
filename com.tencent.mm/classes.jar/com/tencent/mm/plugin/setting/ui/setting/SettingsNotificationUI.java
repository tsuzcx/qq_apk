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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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
  private HashMap<Integer, Integer> jdq;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean yYv;
  private boolean yYw;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.yYv = true;
    this.yYw = true;
    this.jdq = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.lA(26))
    {
      if ((com.tencent.mm.sdk.h.b.fqp()) && ((!com.tencent.mm.sdk.h.b.fqo()) || ((com.tencent.mm.sdk.h.b.fqo()) && (!com.tencent.mm.sdk.h.b.fqq()))))
      {
        ae.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        paramString = new Intent("android.intent.action.MAIN");
        paramString.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        paramString.putExtra("appName", ak.getContext().getResources().getString(2131755822));
        paramString.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(paramString, paramd);
        AppMethodBeat.o(74301);
        return;
      }
      ae.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
      if (android.support.v4.app.v.O(getContext()).areNotificationsEnabled())
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
    if (com.tencent.mm.compatible.util.d.lA(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramd.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void ayt(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void PN(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private void dRn()
  {
    AppMethodBeat.i(190408);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.yYv).append(", install ").append(com.tencent.mm.br.d.aJN("sns")).append(", flag ");
    boolean bool;
    if ((com.tencent.mm.model.v.aAO() & 0x8000) == 0)
    {
      bool = true;
      ae.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.yYv) {
        break label161;
      }
      this.screen.cT("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.aXe("settings_sns_notify");
      if (localObject == null) {
        break label183;
      }
      ((Preference)localObject).JOq = false;
      this.yYw = bu.a((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(68384, null), true);
      if (!this.yYw) {
        break label178;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      AppMethodBeat.o(190408);
      return;
      bool = false;
      break;
      label161:
      this.screen.cT("settings_sns_notify", true);
    }
    label178:
    ((CheckBoxPreference)localObject).setChecked(false);
    label183:
    AppMethodBeat.o(190408);
  }
  
  private boolean dRo()
  {
    AppMethodBeat.i(190409);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.yYw)
    {
      bool = true;
      this.yYw = bool;
      if (!this.yYw) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(68384, Boolean.valueOf(this.yYw));
      dRn();
      AppMethodBeat.o(190409);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.g.yxI.f(14098, new Object[] { Integer.valueOf(4) });
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
    if (com.tencent.mm.compatible.util.d.lA(26))
    {
      this.screen.cT("settings_notification_top", true);
      this.screen.cT("settings_notification_title", false);
      this.screen.cT("settings_notification_sound_shake", false);
      this.screen.cT("settings_voip_sound_and_shake", false);
      if ((com.tencent.mm.model.v.aAH() & 0x0) == 0L) {
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
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("settings_notification_finder", bool1);
      localObject = (CheckBoxPreference)this.screen.aXe("settings_notification_finder");
      ((Preference)localObject).JOq = false;
      bool1 = ((t)com.tencent.mm.kernel.g.ad(t.class)).getRedDotManager().cBv();
      ae.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject).setChecked(bool1);
      localObject = (CheckBoxPreference)this.screen.aXe("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.lA(26)) {
        break label539;
      }
      if ((!com.tencent.mm.n.f.abO()) || (!com.tencent.mm.n.f.abP())) {
        break label534;
      }
      bool1 = true;
      label266:
      ((CheckBoxPreference)localObject).setChecked(bool1);
      label272:
      ((CheckBoxPreference)this.screen.aXe("settings_new_voip_msg_notification")).setChecked(com.tencent.mm.n.f.abQ());
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label798;
      }
      if (!com.tencent.mm.compatible.util.d.lA(26)) {
        break label555;
      }
      this.screen.cT("settings_notification_sound_and_shake", false);
      this.screen.cT("settings_sound", true);
      this.screen.cT("settings_shake", true);
      this.screen.cT("settings_notification_ringtone", true);
      com.tencent.mm.n.a.ace();
      ae.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.n.a.acd()) });
      localObject = this.screen;
      if (com.tencent.mm.n.a.acd() != 1) {
        break label550;
      }
      bool1 = bool2;
      label404:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.aXe("settings_show_detail")).setChecked(com.tencent.mm.n.f.abR());
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
      dRn();
      AppMethodBeat.o(74295);
      return;
      this.screen.cT("settings_notification_top", false);
      this.screen.cT("settings_notification_title", true);
      this.screen.cT("settings_notification_sound_shake", true);
      this.screen.cT("settings_voip_sound_and_shake", true);
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
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.n.f.abO());
      break label272;
      label550:
      bool1 = true;
      break label404;
      label555:
      localObject = (CheckBoxPreference)this.screen.aXe("settings_sound");
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.n.f.abS());
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.aXe("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.lA(26))
        {
          String str = com.tencent.mm.n.f.abY();
          if (str != com.tencent.mm.n.f.ggs) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.aXe("settings_shake")).setChecked(com.tencent.mm.n.f.abW());
        this.screen.cT("settings_notification_sound_and_shake", true);
        this.screen.cT("settings_special_scene_notification_title", true);
        this.screen.cT("settings_specail_scene_sound", true);
        this.screen.cT("settings_specail_scene_shake", true);
        this.screen.cT("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131763334));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131763334)));
          continue;
          this.screen.aXf("settings_notification_ringtone");
        }
      }
      label798:
      this.screen.aXf("settings_show_detail");
      this.screen.aXf("settings_sound");
      this.screen.aXf("settings_notification_ringtone");
      this.screen.aXf("settings_shake");
      this.screen.aXf("settings_active_time");
      this.screen.aXf("settings_notification_sound_and_shake");
      this.screen.aXf("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = com.tencent.mm.model.v.aAG();
    if ((com.tencent.mm.br.d.aJN("sns")) && ((com.tencent.mm.model.v.aAO() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yYv = bool;
      setMMTitle(2131763332);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    com.tencent.mm.model.ba.ox(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    com.tencent.mm.kernel.g.ajR().ajA().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.jdq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new auo();
      ((auo)localObject).GLx = i;
      ((auo)localObject).xsz = j;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      ae.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.jdq.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.lA(26)) && (!com.tencent.mm.n.f.abP()))
      {
        f.a locala = new f.a(getContext());
        locala.aZq(getString(2131763111)).zi(false);
        locala.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void PN(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!com.tencent.mm.n.f.abP())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  com.tencent.mm.n.f.cQ(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 0L, 1L, false);
                  com.tencent.mm.model.ba.m(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.bq.a.abK());
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
        com.tencent.mm.kernel.g.ajR().ajA().set(73217, Boolean.valueOf(bool));
        com.tencent.mm.kernel.g.ajR().ajA().set(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label459;
        }
      }
    }
    label459:
    for (long l = 8L;; l = 9L)
    {
      paramf.idkeyStat(500L, l, 1L, false);
      ae.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(74298);
      return true;
      com.tencent.mm.n.f.cQ(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.model.ba.m(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = dRo();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ae.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
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
            paramAnonymousDialogInterface = new bv();
            paramAnonymousDialogInterface.kt(2);
            paramAnonymousDialogInterface.qN(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.ui("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
            bl.v(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.kr(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 3L, 1L, false);
              com.tencent.mm.model.ba.m(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new au();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.kr(1);
              ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.n.f.cR(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).aXe("settings_new_voip_msg_notification")).setChecked(true);
            SettingsNotificationUI.this.initView();
            com.tencent.mm.model.ba.m(false, true);
            AppMethodBeat.o(74292);
          }
        }, 2131099904, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.n.f.cR(true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 2L, 1L, false);
        com.tencent.mm.model.ba.m(false, true);
        initView();
      }
    }
    label467:
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.n.f.cT(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.n.f.cU(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bu.F(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 17L, 1L, false);
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
        ae.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
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
        this.jdq.put(Integer.valueOf(10), Integer.valueOf(i));
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
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      ayt(com.tencent.mm.bq.a.abK());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.lC(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1037;
        }
        ayt(com.tencent.mm.bq.a.fcs());
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
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
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