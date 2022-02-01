package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsNotificationUI
  extends MMPreference
{
  private boolean PuW;
  private boolean PuX;
  private HashMap<Integer, Integer> pPy;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  
  public SettingsNotificationUI()
  {
    AppMethodBeat.i(74293);
    this.PuW = true;
    this.PuX = true;
    this.pPy = new HashMap();
    AppMethodBeat.o(74293);
  }
  
  private static void CP(boolean paramBoolean)
  {
    AppMethodBeat.i(299162);
    long l = z.bAR();
    cas localcas;
    if (paramBoolean)
    {
      l &= 0xFFFFFFFF;
      com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(l));
      localcas = new cas();
      localcas.aajJ = 70;
      if (!paramBoolean) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 2)
    {
      localcas.NkL = i;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, localcas));
      AppMethodBeat.o(299162);
      return;
      l |= 0x0;
      break;
    }
  }
  
  private void a(com.tencent.mm.pluginsdk.permission.d paramd, String paramString)
  {
    AppMethodBeat.i(74301);
    Intent localIntent = new Intent();
    if (com.tencent.mm.compatible.util.d.rb(26))
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
      if (i.X(getContext()).DB())
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
    localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
    localIntent.putExtra("app_package", getPackageName());
    localIntent.putExtra("app_uid", getApplicationInfo().uid);
    localIntent.addFlags(268435456);
    paramd = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramd.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramd.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74301);
  }
  
  private void aVE(String paramString)
  {
    AppMethodBeat.i(299121);
    this.screen.bAi(paramString).aS(com.tencent.mm.k.b.J(this, com.tencent.mm.k.b.aQQ()));
    AppMethodBeat.o(299121);
  }
  
  private void c(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(299144);
    Log.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + paramBoolean + " item value = " + paramLong + " functionId = " + paramInt);
    if (paramBoolean)
    {
      this.status = ((int)(this.status | paramLong));
      if (!paramBoolean) {
        break label116;
      }
    }
    label116:
    for (int i = 1;; i = 2)
    {
      this.pPy.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(299144);
      return;
      this.status = ((int)(this.status & (0xFFFFFFFF ^ paramLong)));
      break;
    }
  }
  
  private void gVX()
  {
    AppMethodBeat.i(299129);
    Object localObject = new StringBuilder("isSnsOpenEntrance ").append(this.PuW).append(", install ").append(com.tencent.mm.br.c.blq("sns")).append(", flag ");
    boolean bool;
    if ((z.bBf() & 0x8000) == 0)
    {
      bool = true;
      Log.i("MicroMsg.SettingsNotificationUI", bool);
      if (!this.PuW) {
        break label164;
      }
      this.screen.eh("settings_sns_notify", false);
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)this.screen.bAi("settings_sns_notify");
      if (localObject == null) {
        break label186;
      }
      ((Preference)localObject).adZV = false;
      this.PuX = Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(68384, null), true);
      if (!this.PuX) {
        break label181;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      AppMethodBeat.o(299129);
      return;
      bool = false;
      break;
      label164:
      this.screen.eh("settings_sns_notify", true);
    }
    label181:
    ((CheckBoxPreference)localObject).setChecked(false);
    label186:
    AppMethodBeat.o(299129);
  }
  
  private boolean gVY()
  {
    AppMethodBeat.i(299137);
    getDefaultSharedPreferences();
    boolean bool;
    if (!this.PuX)
    {
      bool = true;
      this.PuX = bool;
      if (!this.PuX) {
        break label88;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(14098, new Object[] { Integer.valueOf(3) });
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().B(68384, Boolean.valueOf(this.PuX));
      gVX();
      AppMethodBeat.o(299137);
      return true;
      bool = false;
      break;
      label88:
      com.tencent.mm.plugin.report.service.h.OAn.b(14098, new Object[] { Integer.valueOf(4) });
    }
  }
  
  private static boolean ju(long paramLong)
  {
    AppMethodBeat.i(299113);
    if ((z.bAR() & paramLong) != 0L)
    {
      AppMethodBeat.o(299113);
      return true;
    }
    AppMethodBeat.o(299113);
    return false;
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_notification;
  }
  
  public void initView()
  {
    boolean bool2 = false;
    AppMethodBeat.i(74295);
    if (ignoreSecondCalled())
    {
      AppMethodBeat.o(74295);
      return;
    }
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.aBe(getResourceId());
    this.screen.eh("settings_new_msg_show_detail", false);
    Object localObject1;
    label211:
    label217:
    Object localObject2;
    label283:
    label324:
    label345:
    label494:
    int i;
    if (com.tencent.mm.compatible.util.d.rb(26))
    {
      this.screen.eh("settings_new_msg_title", true);
      this.screen.eh("settings_new_msg_notification_sound", true);
      this.screen.eh("settings_new_msg_notification_ringtone", true);
      this.screen.eh("settings_new_msg_notification_shake", true);
      this.screen.eh("setting_news_notification", false);
      this.screen.eh("settings_special_scene_notification_sound_and_shake", false);
      this.screen.eh("settings_new_msg_notification_channel_sound", false);
      localObject1 = (CheckBoxPreference)this.screen.bAi("settings_new_msg_notification_switch");
      if (!com.tencent.mm.compatible.util.d.rb(26)) {
        break label1478;
      }
      if ((!com.tencent.mm.k.h.aQF()) || (!com.tencent.mm.k.h.aQG())) {
        break label1473;
      }
      bool1 = true;
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      if (!((CheckBoxPreference)localObject1).isChecked()) {
        break label1606;
      }
      if (!com.tencent.mm.compatible.util.d.rb(26)) {
        break label1511;
      }
      this.screen.eh("setting_news_notification", false);
      Log.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(com.tencent.mm.k.b.aQV()) });
      localObject2 = this.screen;
      if (com.tencent.mm.k.b.aQV() == 1) {
        break label1489;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject2).eh("settings_special_scene_notification_sound_and_shake", bool1);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUJ, 1) != 1) {
        break label1494;
      }
      aVE("settings_new_msg_notification_channel_sound");
      ((CheckBoxPreference)this.screen.bAi("settings_new_msg_show_detail")).setChecked(com.tencent.mm.k.h.aQI());
      if (!com.tencent.mm.compatible.util.d.rc(26)) {
        break label1721;
      }
      this.screen.bAi("settings_ringtone_title").setTitle(b.i.setting_ringtone_title_only_voip);
      this.screen.eh("settings_voip_notification_both_shake_and_sound", true);
      this.screen.eh("setting_voip_notification", true);
      ((CheckBoxPreference)this.screen.bAi("settings_voip_sound")).setChecked(com.tencent.mm.k.h.aQT());
      ((CheckBoxPreference)this.screen.bAi("settings_voip_shake")).setChecked(com.tencent.mm.k.h.aQU());
      ((CheckBoxPreference)this.screen.bAi("settings_notification_hear_ringtone_when_call_me")).setChecked(com.tencent.mm.k.h.aQJ());
      if ((!com.tencent.mm.plugin.ringtone.i.a.gOJ()) && (!com.tencent.mm.plugin.ringtone.i.a.gOG()) && (!com.tencent.mm.plugin.ringtone.i.a.gOI())) {
        break label1812;
      }
      this.screen.eh("settings_notification_hear_ringtone_when_call_me", false);
      ((CheckBoxPreference)this.screen.bAi("settings_new_voip_msg_invite_notification")).setChecked(com.tencent.mm.k.h.aQH());
      if (!com.tencent.mm.k.h.aQH())
      {
        this.screen.eh("settings_voip_shake", true);
        this.screen.eh("settings_voip_sound", true);
        this.screen.eh("settings_voip_notification_both_shake_and_sound", true);
        this.screen.eh("setting_voip_notification", true);
        if (!((CheckBoxPreference)localObject1).isChecked())
        {
          this.screen.eh("settings_notification_sound_shake", true);
          this.screen.eh("settings_ringtone_title", true);
        }
      }
      if (ju(34359738368L)) {
        break label1829;
      }
      i = 1;
      label624:
      localObject1 = this.screen;
      if ((((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry()) && (i != 0)) {
        break label1834;
      }
      bool1 = true;
      label653:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_notification_finder", bool1);
      localObject1 = this.screen;
      if ((((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry()) && (i != 0) && (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acZN, false))) {
        break label1839;
      }
      bool1 = true;
      label710:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_finder_app_push_notification", bool1);
      localObject1 = (CheckBoxPreference)this.screen.bAi("settings_finder_app_push_notification");
      ((Preference)localObject1).adZV = false;
      if ((z.bAR() & 0x0) != 0L) {
        break label1844;
      }
      bool1 = true;
      label759:
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      localObject1 = (CheckBoxPreference)this.screen.bAi("settings_notification_finder");
      ((Preference)localObject1).adZV = false;
      bool1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      if (ju(70368744177664L)) {
        break label1849;
      }
      bool1 = true;
      label840:
      Log.i("MicroMsg.SettingsNotificationUI", "openNearBy " + ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgF() + " " + bool1);
      localObject1 = (CheckBoxPreference)this.screen.bAi("settings_notification_finder_nearby");
      if (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgE()) {
        break label1854;
      }
      ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.find_friends_by_nearby_title));
      label947:
      localObject2 = this.screen;
      if ((((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgF()) && (bool1)) {
        break label1875;
      }
      bool1 = true;
      label981:
      ((com.tencent.mm.ui.base.preference.f)localObject2).eh("settings_notification_finder_nearby", bool1);
      ((Preference)localObject1).adZV = false;
      bool1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZt();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_nearby : initState = ".concat(String.valueOf(bool1)));
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      if (ju(9007199254740992L)) {
        break label1880;
      }
      bool1 = true;
      label1051:
      boolean bool4 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgE();
      boolean bool3 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZv();
      Log.i("MicroMsg.SettingsNotificationUI", "openFinderLive:" + bool1 + " hitEnableFinderLiveTest:" + bool4 + " isEnableShowFinderLiveEntranceRedDot:" + bool3);
      localObject1 = this.screen;
      if ((bool4) && (bool1)) {
        break label1885;
      }
      bool1 = true;
      label1154:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_notification_finder_live", bool1);
      localObject1 = (CheckBoxPreference)this.screen.bAi("settings_notification_finder_live");
      ((Preference)localObject1).adZV = false;
      ((CheckBoxPreference)localObject1).setChecked(bool3);
      if (WeChatBrands.Business.Entries.MeSetNewMsgChannels.banned()) {
        this.screen.bAk("settings_notification_finder");
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
      gVX();
      if ((!this.screen.bAj("settings_sns_notify")) && (!this.screen.bAj("settings_notification_finder_nearby")) && (!this.screen.bAj("settings_notification_finder")) && (!this.screen.bAj("settings_notification_finder_live"))) {
        break label1890;
      }
      i = 1;
      label1296:
      localObject1 = this.screen;
      if (i != 0) {
        break label1895;
      }
    }
    label1473:
    label1478:
    label1489:
    label1494:
    label1880:
    label1885:
    label1890:
    label1895:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_update_notify_title", bool1);
      localObject1 = this.screen;
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_notification_tips", bool1);
      ((PreferenceFooterCategory)this.screen.bAi("settings_notification_tips")).aeal = true;
      AppMethodBeat.o(74295);
      return;
      this.screen.eh("settings_new_msg_title", false);
      this.screen.eh("settings_new_msg_notification_sound", false);
      this.screen.eh("settings_new_msg_notification_ringtone", false);
      this.screen.eh("settings_new_msg_notification_shake", false);
      this.screen.eh("setting_news_notification", true);
      this.screen.eh("settings_special_scene_notification_sound_and_shake", true);
      this.screen.eh("settings_new_msg_notification_channel_sound", true);
      break;
      bool1 = false;
      break label211;
      ((CheckBoxPreference)localObject1).setChecked(com.tencent.mm.k.h.aQF());
      break label217;
      bool1 = false;
      break label283;
      this.screen.eh("settings_new_msg_notification_channel_sound", true);
      break label324;
      label1511:
      localObject2 = (CheckBoxPreference)this.screen.bAi("settings_new_msg_notification_sound");
      ((CheckBoxPreference)localObject2).setChecked(com.tencent.mm.k.h.aQL());
      if (((CheckBoxPreference)localObject2).isChecked())
      {
        this.screen.eh("settings_new_msg_notification_ringtone", false);
        aVE("settings_new_msg_notification_ringtone");
      }
      for (;;)
      {
        ((CheckBoxPreference)this.screen.bAi("settings_new_msg_notification_shake")).setChecked(com.tencent.mm.k.h.aQN());
        break;
        this.screen.eh("settings_new_msg_notification_ringtone", true);
      }
      this.screen.eh("settings_new_msg_show_detail", true);
      this.screen.eh("settings_new_msg_title", true);
      this.screen.eh("settings_new_msg_notification_sound", true);
      this.screen.eh("settings_new_msg_notification_ringtone", true);
      this.screen.eh("settings_new_msg_notification_shake", true);
      this.screen.eh("setting_news_notification", true);
      this.screen.eh("settings_special_scene_notification_sound_and_shake", true);
      this.screen.eh("settings_new_msg_notification_channel_sound", true);
      break label345;
      if (com.tencent.mm.compatible.util.d.rc(29))
      {
        this.screen.eh("setting_voip_notification", true);
        ((CheckBoxPreference)this.screen.bAi("settings_voip_notification_both_shake_and_sound")).setChecked(com.tencent.mm.k.h.aQT());
      }
      for (;;)
      {
        this.screen.eh("settings_voip_shake", true);
        this.screen.eh("settings_voip_sound", true);
        break;
        this.screen.eh("settings_voip_notification_both_shake_and_sound", true);
      }
      this.screen.eh("settings_notification_hear_ringtone_when_call_me", true);
      break label494;
      i = 0;
      break label624;
      bool1 = false;
      break label653;
      bool1 = false;
      break label710;
      bool1 = false;
      break label759;
      bool1 = false;
      break label840;
      ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.nearby_live_friend_title));
      break label947;
      bool1 = false;
      break label981;
      bool1 = false;
      break label1051;
      bool1 = false;
      break label1154;
      i = 0;
      break label1296;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74294);
    super.onCreate(paramBundle);
    this.status = z.bAQ();
    if ((com.tencent.mm.br.c.blq("sns")) && ((z.bBf() & 0x8000) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.PuW = bool;
      com.tencent.mm.k.b.aQW();
      setMMTitle(b.i.settings_notification);
      initView();
      AppMethodBeat.o(74294);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74299);
    super.onDestroy();
    bf.vg(3);
    AppMethodBeat.o(74299);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74296);
    super.onPause();
    com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(this.status));
    Iterator localIterator = this.pPy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new cas();
      ((cas)localObject).aajJ = i;
      ((cas)localObject).NkL = j;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      Log.d("MicroMsg.SettingsNotificationUI", "switch  " + i + " " + j);
    }
    this.pPy.clear();
    AppMethodBeat.o(74296);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74298);
    paramf = paramPreference.mKey;
    boolean bool;
    if (paramf.equals("settings_sns_notify"))
    {
      bool = gVY();
      AppMethodBeat.o(74298);
      return bool;
    }
    if (paramf.equals("settings_notification_finder"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", new Object[] { Boolean.valueOf(bool) });
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().pN(bool);
      if (!paramf.equals("settings_sound")) {
        break label582;
      }
      com.tencent.mm.k.h.eP(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        break label565;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 10L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(74298);
      return true;
      if (paramf.equals("settings_notification_finder_live"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_live isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().pP(bool);
        break;
      }
      if (paramf.equals("settings_finder_app_push_notification"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_finder_app_push_notification isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          k.a(getContext(), false, getContext().getString(b.i.settings_finder_app_push_close_tips), "", getContext().getString(b.i.settings_new_voip_msg_close_confirm), getContext().getString(b.i.settings_logout_option_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(298814);
              SettingsNotificationUI.CQ(false);
              AppMethodBeat.o(298814);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74291);
              ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).bAi("settings_finder_app_push_notification")).setChecked(true);
              SettingsNotificationUI.CQ(true);
              SettingsNotificationUI.this.initView();
              AppMethodBeat.o(74291);
            }
          });
          break;
        }
        CP(true);
        break;
      }
      if (paramf.equals("settings_notification_finder_nearby"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder_nearby isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().pO(bool);
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(22479, new Object[] { Long.valueOf(com.tencent.mm.model.cn.bDw()), Integer.valueOf(1) });
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(22479, new Object[] { Long.valueOf(com.tencent.mm.model.cn.bDw()), Integer.valueOf(0) });
        break;
      }
      if (paramf.equals("settings_voip_notification_both_shake_and_sound"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        com.tencent.mm.k.h.eV(bool);
        com.tencent.mm.k.h.eU(bool);
        initView();
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
      }
      if (paramf.equals("settings_voip_shake"))
      {
        com.tencent.mm.k.h.eV(((CheckBoxPreference)paramPreference).isChecked());
        initView();
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
      }
      if (!paramf.equals("settings_voip_sound")) {
        break;
      }
      com.tencent.mm.k.h.eU(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      AppMethodBeat.o(74298);
      return true;
      label565:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 11L, 1L, false);
    }
    label582:
    if (paramf.equals("settings_shake"))
    {
      com.tencent.mm.k.h.eR(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 17L, 1L, false);
      }
    }
    if (paramf.equals("settings_special_scene_notification_sound_and_shake"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSpecialSceneNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_new_msg_notification_switch"))
    {
      if ((com.tencent.mm.compatible.util.d.rb(26)) && (!com.tencent.mm.k.h.aQG()))
      {
        paramf = new g.a(getContext());
        paramf.bDE(getString(b.i.setting_notification_sys_notification_disable_warning)).NF(false);
        paramf.c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(298824);
            if (paramAnonymousBoolean)
            {
              SettingsNotificationUI.a(SettingsNotificationUI.this, new com.tencent.mm.pluginsdk.permission.d()
              {
                public final void aiW(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(299400);
                  if (!com.tencent.mm.k.h.aQG())
                  {
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(299400);
                    return;
                  }
                  com.tencent.mm.k.h.eM(true);
                  SettingsNotificationUI.this.initView();
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 0L, 1L, false);
                  bf.v(true, false);
                  AppMethodBeat.o(299400);
                }
              }, com.tencent.mm.bq.a.aQB());
              AppMethodBeat.o(298824);
              return;
            }
            SettingsNotificationUI.this.initView();
            AppMethodBeat.o(298824);
          }
        }).show();
        AppMethodBeat.o(74298);
        return true;
      }
      com.tencent.mm.k.h.eM(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 0L, 1L, false);
      }
      for (;;)
      {
        bf.v(true, false);
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 1L, 1L, false);
      }
    }
    if (paramf.equals("settings_new_voip_msg_invite_notification"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        k.a(getContext(), false, getContext().getString(b.i.settings_new_voip_msg_close_tips), "", getContext().getString(b.i.settings_new_voip_msg_close_confirm), getContext().getString(b.i.settings_logout_option_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74292);
            com.tencent.mm.k.h.eN(false);
            paramAnonymousDialogInterface = new cc();
            paramAnonymousDialogInterface.pI(2);
            paramAnonymousDialogInterface.setCreateTime(System.currentTimeMillis());
            paramAnonymousDialogInterface.setType(1);
            paramAnonymousDialogInterface.BS("weixin");
            paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { q.aPo() }));
            br.B(paramAnonymousDialogInterface);
            paramAnonymousDialogInterface = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("weixin");
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { q.aPo() }));
              paramAnonymousDialogInterface.pG(paramAnonymousDialogInterface.field_unReadCount + 1);
              ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(paramAnonymousDialogInterface, "weixin");
            }
            for (;;)
            {
              SettingsNotificationUI.this.initView();
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 3L, 1L, false);
              bf.v(false, true);
              AppMethodBeat.o(74292);
              return;
              paramAnonymousDialogInterface = new bb();
              paramAnonymousDialogInterface.setContent(SettingsNotificationUI.this.getContext().getString(b.i.settings_new_voip_msg_weixin_close_tips, new Object[] { q.aPo() }));
              paramAnonymousDialogInterface.setUsername("weixin");
              paramAnonymousDialogInterface.pG(1);
              ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().h(paramAnonymousDialogInterface);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(298810);
            com.tencent.mm.k.h.eN(true);
            ((CheckBoxPreference)SettingsNotificationUI.a(SettingsNotificationUI.this).bAi("settings_new_voip_msg_invite_notification")).setChecked(true);
            SettingsNotificationUI.this.initView();
            bf.v(false, true);
            AppMethodBeat.o(298810);
          }
        }, b.c.alert_btn_color_warn, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.k.h.eN(true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 2L, 1L, false);
        bf.v(false, true);
        initView();
      }
    }
    if (paramf.equals("settings_new_msg_show_detail"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.k.h.eO(bool);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        c(bool, 2048L, 10);
        AppMethodBeat.o(74298);
        return true;
      }
    }
    if (paramf.equals("setting_news_notification")) {
      a(new com.tencent.mm.pluginsdk.permission.d()
      {
        public final void aiW(int paramAnonymousInt)
        {
          AppMethodBeat.i(298831);
          if (!com.tencent.mm.k.h.aQG())
          {
            SettingsNotificationUI.this.initView();
            AppMethodBeat.o(298831);
            return;
          }
          com.tencent.mm.k.h.eM(true);
          SettingsNotificationUI.this.initView();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 0L, 1L, false);
          bf.v(true, false);
          AppMethodBeat.o(298831);
        }
      }, com.tencent.mm.bq.a.aQB());
    }
    if (paramf.equals("setting_voip_notification")) {
      a(new com.tencent.mm.pluginsdk.permission.d()
      {
        public final void aiW(int paramAnonymousInt)
        {
          AppMethodBeat.i(298833);
          if (!com.tencent.mm.k.h.aQG())
          {
            SettingsNotificationUI.this.initView();
            AppMethodBeat.o(298833);
            return;
          }
          com.tencent.mm.k.h.eM(true);
          SettingsNotificationUI.this.initView();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 0L, 1L, false);
          bf.v(true, false);
          AppMethodBeat.o(298833);
        }
      }, com.tencent.mm.plugin.ringtone.d.aUv(""));
    }
    if ((paramf.equals("settings_new_msg_notification_channel_sound")) || (paramf.equals("settings_new_msg_notification_ringtone")))
    {
      paramf = new Intent(getContext(), SettingMessageRingtoneUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingWechatRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingWechatRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74298);
      return true;
    }
    if (paramf.equals("settings_notification_ringtone")) {
      PluginRingtone.enterRingtoneSettingUI(this, 1);
    }
    if (paramf.equals("settings_notification_hear_ringtone_when_call_me"))
    {
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      com.tencent.mm.k.h.eQ(bool);
      c(bool, 1073741824L, 71);
    }
    if (paramf.equals("settings_new_msg_notification_sound"))
    {
      com.tencent.mm.k.h.eP(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 10L, 1L, false);
      }
      for (;;)
      {
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 11L, 1L, false);
      }
    }
    if (paramf.equals("settings_new_msg_notification_shake"))
    {
      com.tencent.mm.k.h.eR(((CheckBoxPreference)paramPreference).isChecked());
      initView();
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 16L, 1L, false);
      }
      for (;;)
      {
        Util.shake(this, ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(74298);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 17L, 1L, false);
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