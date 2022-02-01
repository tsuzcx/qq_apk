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
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
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
  private HashMap<Integer, Integer> iHo;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private boolean xtA;
  private boolean xtz;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.xtz = true;
    this.xtA = true;
    this.iHo = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.kZ(26))
    {
      if ((com.tencent.mm.sdk.h.b.eWK()) && ((!com.tencent.mm.sdk.h.b.eWJ()) || ((com.tencent.mm.sdk.h.b.eWJ()) && (!com.tencent.mm.sdk.h.b.eWL()))))
      {
        ac.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
        paramString = new Intent("android.intent.action.MAIN");
        paramString.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        paramString.putExtra("appName", ai.getContext().getResources().getString(2131755822));
        paramString.putExtra("packageName", getPackageName());
        com.tencent.mm.pluginsdk.permission.b.a(paramString, paramd);
        AppMethodBeat.o(74301);
        return;
      }
      ac.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
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
    if (com.tencent.mm.compatible.util.d.kZ(21))
    {
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", getPackageName());
      localIntent.putExtra("app_uid", getApplicationInfo().uid);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramd = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramd.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramd.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74301);
      return;
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.fromParts("package", getPackageName(), null));
      localIntent.addFlags(268435456);
    }
  }
  
  private void asd(String paramString)
  {
    AppMethodBeat.i(74300);
    a(new com.tencent.mm.pluginsdk.permission.d()
    {
      public final void ND(int paramAnonymousInt) {}
    }, paramString);
    AppMethodBeat.o(74300);
  }
  
  private void dCn()
  {
    AppMethodBeat.i(191054);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.xtz).append(", install ").append(com.tencent.mm.br.d.aCT("sns")).append(", flag ");
    boolean bool;
    if ((u.axI() & 0x8000) == 0)
    {
      bool = true;
      ac.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.xtz) {
        break label161;
      }
      this.screen.cK("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.aPN("settings_sns_notify");
      if (localObject == null) {
        break label183;
      }
      ((Preference)localObject).HFK = false;
      this.xtA = bs.a((Boolean)g.agR().agA().get(68384, null), true);
      if (!this.xtA) {
        break label178;
      }
      ((CheckBoxPreference)localObject).mF = true;
      AppMethodBeat.o(191054);
      return;
      bool = false;
      break;
      label161:
      this.screen.cK("settings_sns_notify", true);
    }
    label178:
    ((CheckBoxPreference)localObject).mF = false;
    label183:
    AppMethodBeat.o(191054);
  }
  
  private boolean dCo()
  {
    AppMethodBeat.i(191055);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.xtA)
    {
      bool = true;
      this.xtA = bool;
      if (!this.xtA) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      g.agR().agA().set(68384, Boolean.valueOf(this.xtA));
      dCn();
      AppMethodBeat.o(191055);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(4) });
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
    if (com.tencent.mm.compatible.util.d.kZ(26))
    {
      this.screen.cK("settings_notification_top", true);
      this.screen.cK("settings_notification_title", false);
      this.screen.cK("settings_notification_sound_shake", false);
      this.screen.cK("settings_voip_sound_and_shake", false);
      if ((u.axB() & 0x0) == 0L) {
        break label519;
      }
      i = 1;
      if (i != 0) {
        break label524;
      }
      i = 1;
      localObject = this.screen;
      if ((((l)g.ad(l.class)).showFinderEntry()) && (i != 0)) {
        break label529;
      }
      bool1 = true;
      label151:
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("settings_notification_finder", bool1);
      localObject = (CheckBoxPreference)this.screen.aPN("settings_notification_finder");
      ((Preference)localObject).HFK = false;
      bool1 = ((l)g.ad(l.class)).getRedDotManager().ctK();
      ac.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject).mF = bool1;
      localObject = (CheckBoxPreference)this.screen.aPN("settings_new_msg_notification");
      if (!com.tencent.mm.compatible.util.d.kZ(26)) {
        break label539;
      }
      if ((!com.tencent.mm.m.f.Zf()) || (!com.tencent.mm.m.f.Zg())) {
        break label534;
      }
      bool1 = true;
      label266:
      ((CheckBoxPreference)localObject).mF = bool1;
      label272:
      ((CheckBoxPreference)this.screen.aPN("settings_new_voip_msg_notification")).mF = com.tencent.mm.m.f.Zh();
      if (!((CheckBoxPreference)localObject).isChecked()) {
        break label798;
      }
      if (!com.tencent.mm.compatible.util.d.kZ(26)) {
        break label555;
      }
      this.screen.cK("settings_notification_sound_and_shake", false);
      this.screen.cK("settings_sound", true);
      this.screen.cK("settings_shake", true);
      this.screen.cK("settings_notification_ringtone", true);
      com.tencent.mm.m.a.Zv();
      ac.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.m.a.Zu()) });
      localObject = this.screen;
      if (com.tencent.mm.m.a.Zu() != 1) {
        break label550;
      }
      bool1 = bool2;
      label404:
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("settings_special_scene_notification_sound_and_shake", bool1);
      ((CheckBoxPreference)this.screen.aPN("settings_show_detail")).mF = com.tencent.mm.m.f.Zi();
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
      dCn();
      AppMethodBeat.o(74295);
      return;
      this.screen.cK("settings_notification_top", false);
      this.screen.cK("settings_notification_title", true);
      this.screen.cK("settings_notification_sound_shake", true);
      this.screen.cK("settings_voip_sound_and_shake", true);
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
      ((CheckBoxPreference)localObject).mF = com.tencent.mm.m.f.Zf();
      break label272;
      label550:
      bool1 = true;
      break label404;
      label555:
      localObject = (CheckBoxPreference)this.screen.aPN("settings_sound");
      ((CheckBoxPreference)localObject).mF = com.tencent.mm.m.f.Zj();
      if (((CheckBoxPreference)localObject).isChecked())
      {
        localObject = this.screen.aPN("settings_notification_ringtone");
        if (com.tencent.mm.compatible.util.d.kZ(26))
        {
          String str = com.tencent.mm.m.f.Zp();
          if (str != com.tencent.mm.m.f.fKJ) {
            ((Preference)localObject).setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
          }
        }
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.aPN("settings_shake")).mF = com.tencent.mm.m.f.Zn();
        this.screen.cK("settings_notification_sound_and_shake", true);
        this.screen.cK("settings_special_scene_notification_title", true);
        this.screen.cK("settings_specail_scene_sound", true);
        this.screen.cK("settings_specail_scene_shake", true);
        this.screen.cK("settings_special_scene_notification_sound_and_shake", true);
        break;
        ((Preference)localObject).setSummary(getString(2131763334));
        continue;
        if (localObject != null)
        {
          ((Preference)localObject).setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(2131763334)));
          continue;
          this.screen.aPO("settings_notification_ringtone");
        }
      }
      label798:
      this.screen.aPO("settings_show_detail");
      this.screen.aPO("settings_sound");
      this.screen.aPO("settings_notification_ringtone");
      this.screen.aPO("settings_shake");
      this.screen.aPO("settings_active_time");
      this.screen.aPO("settings_notification_sound_and_shake");
      this.screen.aPO("settings_special_scene_notification_sound_and_shake");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = u.axA();
    if ((com.tencent.mm.br.d.aCT("sns")) && ((u.axI() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xtz = bool;
      setMMTitle(2131763332);
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    ax.nU(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    g.agR().agA().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.iHo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aqc();
      ((aqc)localObject).EIY = i;
      ((aqc)localObject).vVH = j;
      ((k)g.ab(k.class)).awA().c(new j.a(23, (com.tencent.mm.bw.a)localObject));
      ac.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.iHo.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_new_msg_notification")) {
      if ((com.tencent.mm.compatible.util.d.kZ(26)) && (!com.tencent.mm.m.f.Zg()))
      {
        f.a locala = new f.a(getContext());
        locala.aRQ(getString(2131763111)).yi(false);
        locala.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(74290);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void ND(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74289);
                  if (!com.tencent.mm.m.f.Zg())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74289);
                    return;
                  }
                  com.tencent.mm.m.f.cO(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 0L, 1L, false);
                  ax.m(true, false);
                  AppMethodBeat.o(74289);
                }
              }, com.tencent.mm.bq.a.Zb());
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
        g.agR().agA().set(73217, Boolean.valueOf(bool));
        g.agR().agA().set(73218, Boolean.valueOf(bool));
        paramf = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label459;
        }
      }
    }
    label459:
    for (long l = 8L;; l = 9L)
    {
      paramf.idkeyStat(500L, l, 1L, false);
      ac.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(74298);
      return true;
      com.tencent.mm.m.f.cO(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        ax.m(true, false);
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 1L, 1L, false);
      }
      if (paramf.equals("settings_sns_notify"))
      {
        bool = dCo();
        AppMethodBeat.o(74298);
        return bool;
      }
      if (paramf.equals("settings_notification_finder"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ac.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((l)g.ad(l.class)).getRedDotManager().lt(bool);
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
            com.tencent.mm.m.f.cP(false);
            paramAnonymousDialogInterface = new bo();
            paramAnonymousDialogInterface.jT(2);
            paramAnonymousDialogInterface.oA(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.re("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
            bi.u(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((k)g.ab(k.class)).awG().aNI("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.jR(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((k)g.ab(k.class)).awG().a(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 3L, 1L, false);
              ax.m(false, true);
              AppMethodBeat.o(74291);
              return;
              paramAnonymousDialogInterface = new ap();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(2131763330, new Object[] { Build.MODEL }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.jR(1);
              ((k)g.ab(k.class)).awG().e(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.m.f.cP(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).aPN("settings_new_voip_msg_notification")).mF = true;
            SettingsNotificationUI.this.initView();
            ax.m(false, true);
            AppMethodBeat.o(74292);
          }
        }, 2131099904, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.m.f.cP(true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 2L, 1L, false);
        ax.m(false, true);
        initView();
      }
    }
    label467:
    if (paramf.equals("settings_sound"))
    {
      com.tencent.mm.m.f.cR(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.m.f.cS(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        bs.D(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 17L, 1L, false);
      }
    }
    label702:
    int i;
    if (paramf.equals("settings_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.m.f.cQ(bool);
      if (!bool)
      {
        bool = true;
        ac.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + bool + " item value = 2048 functionId = 10");
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
        this.iHo.put(Integer.valueOf(10), Integer.valueOf(i));
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_sound_and_shake"))
    {
      asd(com.tencent.mm.bq.a.Zb());
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_voip_sound_and_shake"))
    {
      if ((com.tencent.mm.compatible.util.d.lb(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        if (i == 0) {
          break label1037;
        }
        asd(com.tencent.mm.bq.a.eJQ());
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lR(0));
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