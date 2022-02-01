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
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
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
  private boolean LpY;
  private HashMap<Integer, Integer> ihg;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean wiv;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.wiv = true;
    this.LpY = true;
    this.ihg = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.lf(26))
    {
      if ((com.tencent.mm.sdk.h.b.eHp()) && ((!com.tencent.mm.sdk.h.b.eHo()) || ((com.tencent.mm.sdk.h.b.eHo()) && (!com.tencent.mm.sdk.h.b.eHq()))))
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
      if (v.M(getContext()).areNotificationsEnabled())
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
    if (com.tencent.mm.compatible.util.d.lf(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramd.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void amU(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void LD(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private boolean fYA()
  {
    AppMethodBeat.i(197138);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.LpY)
    {
      bool = true;
      this.LpY = bool;
      if (!this.LpY) {
        break label86;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      g.afB().afk().set(68384, Boolean.valueOf(this.LpY));
      fYz();
      AppMethodBeat.o(197138);
      return true;
      bool = false;
      break;
      label86:
      com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(4) });
    }
  }
  
  private void fYz()
  {
    AppMethodBeat.i(197137);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.wiv).append(", install ").append(com.tencent.mm.bs.d.axB("sns")).append(", flag ");
    boolean bool;
    if ((u.aqS() & 0x8000) == 0)
    {
      bool = true;
      ad.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.wiv) {
        break label164;
      }
      this.screen.cE("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.aKk("settings_sns_notify");
      if (localObject == null) {
        break label186;
      }
      ((Preference)localObject).GfV = false;
      this.LpY = bt.a((Boolean)g.afB().afk().get(68384, null), true);
      if (!this.LpY) {
        break label181;
      }
      ((CheckBoxPreference)localObject).lG = true;
      AppMethodBeat.o(197137);
      return;
      bool = false;
      break;
      label164:
      this.screen.cE("settings_sns_notify", true);
    }
    label181:
    ((CheckBoxPreference)localObject).lG = false;
    label186:
    AppMethodBeat.o(197137);
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
    if (com.tencent.mm.compatible.util.d.lf(26))
    {
      this.screen.cE("settings_notification_top", true);
      this.screen.cE("settings_notification_title", false);
      this.screen.cE("settings_notification_sound_shake", false);
      this.screen.cE("settings_voip_sound_and_shake", false);
      if ((u.aqL() & 0x0) == 0L) {
        break label519;
      }
      i = 1;
      if (i != 0) {
        break label524;
      }
      i = 1;
      localObject = this.screen;
      if ((((j)g.ad(j.class)).showFinderEntry()) && (i != 0)) {
        break label529;
      }
      bool1 = true;
      label151:
      ((com.tencent.mm.ui.base.preference.f)localObject).cE("settings_notification_finder", bool1);
      localObject = (CheckBoxPreference)this.screen.aKk("settings_notification_finder");
      ((Preference)localObject).GfV = false;
      bool1 = ((j)g.ad(j.class)).getRedDotManager().fSK();
      ad.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject).lG = bool1;
      localObject = (CheckBoxPreference)this.screen.aKk("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.lf(26)) {
        break label539;
      }
      if ((!com.tencent.mm.m.f.Yi()) || (!com.tencent.mm.m.f.Yj())) {
        break label534;
      }
      bool1 = true;
      label266:
      ((CheckBoxPreference)localObject).lG = bool1;
      label272:
      ((CheckBoxPreference)this.screen.aKk("settings_new_voip_msg_notification")).lG = com.tencent.mm.m.f.Yk();
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label798;
      }
      if (!com.tencent.mm.compatible.util.d.lf(26)) {
        break label555;
      }
      this.screen.cE("settings_notification_sound_and_shake", false);
      this.screen.cE("settings_sound", true);
      this.screen.cE("settings_shake", true);
      this.screen.cE("settings_notification_ringtone", true);
      com.tencent.mm.m.a.Yy();
      ad.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.m.a.Yx()) });
      localObject = this.screen;
      if (com.tencent.mm.m.a.Yx() != 1) {
        break label550;
      }
      bool1 = bool2;
      label404:
      ((com.tencent.mm.ui.base.preference.f)localObject).cE("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.aKk("settings_show_detail")).lG = com.tencent.mm.m.f.Yl();
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
      fYz();
      AppMethodBeat.o(74295);
      return;
      this.screen.cE("settings_notification_top", false);
      this.screen.cE("settings_notification_title", true);
      this.screen.cE("settings_notification_sound_shake", true);
      this.screen.cE("settings_voip_sound_and_shake", true);
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
      ((CheckBoxPreference)localObject).lG = com.tencent.mm.m.f.Yi();
      break label272;
      label550:
      bool1 = true;
      break label404;
      label555:
      localObject = (CheckBoxPreference)this.screen.aKk("settings_sound");
      ((CheckBoxPreference)localObject).lG = com.tencent.mm.m.f.Ym();
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.aKk("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.lf(26))
        {
          String str = com.tencent.mm.m.f.Ys();
          if (str != com.tencent.mm.m.f.fHc) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.aKk("settings_shake")).lG = com.tencent.mm.m.f.Yq();
        this.screen.cE("settings_notification_sound_and_shake", true);
        this.screen.cE("settings_special_scene_notification_title", true);
        this.screen.cE("settings_specail_scene_sound", true);
        this.screen.cE("settings_specail_scene_shake", true);
        this.screen.cE("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131763334));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131763334)));
          continue;
          this.screen.aKl("settings_notification_ringtone");
        }
      }
      label798:
      this.screen.aKl("settings_show_detail");
      this.screen.aKl("settings_sound");
      this.screen.aKl("settings_notification_ringtone");
      this.screen.aKl("settings_shake");
      this.screen.aKl("settings_active_time");
      this.screen.aKl("settings_notification_sound_and_shake");
      this.screen.aKl("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = u.aqK();
    if ((com.tencent.mm.bs.d.axB("sns")) && ((u.aqS() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.wiv = bool;
      setMMTitle(2131763332);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    ax.ng(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    g.afB().afk().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.ihg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new amy();
      ((amy)localObject).DnY = i;
      ((amy)localObject).uMR = j;
      ((k)g.ab(k.class)).apL().c(new j.a(23, (com.tencent.mm.bx.a)localObject));
      ad.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.ihg.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.lf(26)) && (!com.tencent.mm.m.f.Yj()))
      {
        f.a locala = new f.a(getContext());
        locala.aMo(getString(2131763111)).wZ(false);
        locala.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void LD(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!com.tencent.mm.m.f.Yj())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  com.tencent.mm.m.f.cP(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 0L, 1L, false);
                  ax.l(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.br.a.Ye());
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
        g.afB().afk().set(73217, Boolean.valueOf(bool));
        g.afB().afk().set(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.h.vKh;
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
      com.tencent.mm.m.f.cP(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        ax.l(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = fYA();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ad.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((j)g.ad(j.class)).getRedDotManager().yA(bool);
        break;
      }
      if (!paramf.equals("settings_new_voip_msg_notification")) {
        break;
      }
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.ui.base.h.a(getContext(), false, getContext().getString(2131763328), "", getContext().getString(2131763327), getContext().getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74291);
            com.tencent.mm.m.f.cQ(false);
            paramAnonymousDialogInterface = new bl();
            paramAnonymousDialogInterface.jV(2);
            paramAnonymousDialogInterface.kY(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.nY("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
            bi.u(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((k)g.ab(k.class)).apR().aIn("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.jT(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((k)g.ab(k.class)).apR().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 3L, 1L, false);
              ax.l(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new am();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.jT(1);
              ((k)g.ab(k.class)).apR().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.m.f.cQ(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).aKk("settings_new_voip_msg_notification")).lG = true;
            SettingsNotificationUI.this.initView();
            ax.l(false, true);
            AppMethodBeat.o(74292);
          }
        }, 2131099904, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.m.f.cQ(true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 2L, 1L, false);
        ax.l(false, true);
        initView();
      }
    }
    label467:
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.m.f.cS(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.m.f.cT(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bt.C(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 17L, 1L, false);
      }
    }
    label702:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.m.f.cR(bool);
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
        this.ihg.put(Integer.valueOf(10), Integer.valueOf(i));
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      amU(com.tencent.mm.br.a.Ye());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.lh(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1037;
        }
        amU(com.tencent.mm.br.a.eux());
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI
 * JD-Core Version:    0.7.0.1
 */