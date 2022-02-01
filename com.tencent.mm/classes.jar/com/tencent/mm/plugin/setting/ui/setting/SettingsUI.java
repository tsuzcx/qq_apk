package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ah;
import com.tencent.mm.autogen.a.ft;
import com.tencent.mm.autogen.a.ft.a;
import com.tencent.mm.autogen.a.hv;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.Set;

@com.tencent.mm.kernel.k
public class SettingsUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private View Kql;
  private ProgressDialog PqL;
  private MTimerHandler PqM;
  private com.tencent.mm.am.h PqN;
  private PersonalPreference PwJ;
  private com.tencent.mm.am.h PwK;
  private a.a PwL;
  private com.tencent.mm.ui.widget.a.e PwM;
  private CheckBox PwN;
  private com.tencent.mm.am.h PwO;
  private MTimerHandler eln;
  private MTimerHandler oNL;
  private com.tencent.mm.am.h onSceneEndCallback;
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.widget.a.f ucS;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.PwJ = null;
    this.PqL = null;
    this.onSceneEndCallback = null;
    this.PwK = null;
    this.PqN = null;
    this.PwL = new a.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158) || (paramAnonymousInt == 262164)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(at.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == at.a.acWf)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.oNL = null;
    this.PwO = null;
    AppMethodBeat.o(74528);
  }
  
  private void CS(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    MMEntryLock.unlock("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().aKW();
    }
    for (;;)
    {
      ah localah = new ah();
      localah.hAc.hAd = false;
      localah.publish();
      com.tencent.mm.plugin.setting.c.pFo.aDA();
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().aKV();
      finish();
      if (com.tencent.mm.pluginsdk.platformtools.c.XUP != null) {
        com.tencent.mm.pluginsdk.platformtools.c.XUP.o(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().s(-1, null);
    }
  }
  
  private void gVs()
  {
    AppMethodBeat.i(74537);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_about_micromsg");
    boolean bool2 = Util.nullAs(Boolean.valueOf(com.tencent.mm.aa.c.aYo().dV(262145, 266243)), false);
    boolean bool3 = com.tencent.mm.aa.c.aYo().dW(262157, 266262);
    boolean bool4 = com.tencent.mm.aa.c.aYo().dW(262164, 266269);
    if (!bool2) {
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
    }
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    if ((bool2) || (bool3) || (bool4))
    {
      bool1 = true;
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference))
      {
        if (!bool2) {
          break label257;
        }
        localNormalIconNewTipPreference.afx(0);
        localNormalIconNewTipPreference.gv(getString(b.i.app_new), b.e.new_tips_bg);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsL, true);
      }
      label154:
      localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_about_system");
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      bool2 = com.tencent.mm.aa.c.aYo().dW(262158, 266265);
      com.tencent.mm.plugin.newtips.a.gti();
      bool3 = com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Mse);
      bool4 = com.tencent.mm.ce.e.iRQ();
      if ((!bool2) && (!bool3) && (!bool4)) {
        break label366;
      }
    }
    label257:
    label366:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference)) {
        break label371;
      }
      AppMethodBeat.o(74537);
      return;
      bool1 = false;
      break;
      if (bool3)
      {
        localNormalIconNewTipPreference.aeD(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        break label154;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot())
      {
        localNormalIconNewTipPreference.aeD(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        break label154;
      }
      if (bool4)
      {
        localNormalIconNewTipPreference.aeD(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        break label154;
      }
      localNormalIconNewTipPreference.aeD(8);
      localNormalIconNewTipPreference.gv("", -1);
      localNormalIconNewTipPreference.afx(8);
      break label154;
    }
    label371:
    if ((bool2) || (bool3) || (bool4))
    {
      localNormalIconNewTipPreference.aeD(0);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
      AppMethodBeat.o(74537);
      return;
    }
    localNormalIconNewTipPreference.aeD(8);
    AppMethodBeat.o(74537);
  }
  
  private void gWj()
  {
    AppMethodBeat.i(74542);
    Log.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.c.pFo.aDD();
    com.tencent.mm.kernel.h.baE().ban().remove(this);
    Object localObject = new ny();
    ((ny)localObject).hQx.status = 0;
    ((ny)localObject).hQx.reason = 0;
    ((ny)localObject).publish();
    localObject = new ah();
    ((ah)localObject).hAc.hAd = true;
    ((ah)localObject).publish();
    MMEntryLock.unlock("show_whatsnew");
    n.w(this, true);
    com.tencent.mm.plugin.report.service.g.ahy(8);
    com.tencent.mm.kernel.h.baD().aZV();
    new com.tencent.mm.autogen.a.af().publish();
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.c.pFn.n((Intent)localObject, getContext());
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void gWm()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_account_info");
    if (localIconPreference == null)
    {
      Log.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.aBi(8);
    if (com.tencent.mm.aa.c.aYo().a(at.a.acWf, 266257))
    {
      localIconPreference.aeD(0);
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIL, Boolean.FALSE)).booleanValue()) {
          break label181;
        }
        if ((com.tencent.mm.kernel.h.baE().ban().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.gv(getString(b.i.app_new), b.e.new_tips_bg);
          localIconPreference.afx(0);
          Log.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.aeD(8);
      break;
      label181:
      localIconPreference.afx(8);
      localIconPreference.gv("", -1);
    }
  }
  
  private void gWn()
  {
    int k = 0;
    AppMethodBeat.i(299408);
    IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_about_privacy");
    int i;
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQn, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQo, Integer.valueOf(0))).intValue()) {
        localIconPreference.aeD(0);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvA, 1) != 0) {
        break label248;
      }
      i = 1;
      label106:
      if (i != 0) {
        this.screen.eh("settings_permission_index", true);
      }
      com.tencent.mm.kernel.h.baC();
      if (com.tencent.mm.kernel.b.aZr() != b.a.mCe) {
        break label253;
      }
      i = 1;
      label139:
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvB, 1) != 0) {
        break label258;
      }
    }
    label258:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        this.screen.eh("settings_privacy_personal_list", true);
      }
      j = k;
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvD, 1) == 0) {
        j = 1;
      }
      if ((i != 0) || (j != 0)) {
        this.screen.eh("settings_privacy_third_party_list", true);
      }
      AppMethodBeat.o(299408);
      return;
      localIconPreference.aeD(8);
      break;
      label248:
      i = 0;
      break label106;
      label253:
      i = 0;
      break label139;
    }
  }
  
  private void gWo()
  {
    AppMethodBeat.i(74539);
    i.a locala = com.tencent.mm.plugin.account.friend.model.i.bWW();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.bAi("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != i.a.pSQ) && (locala != i.a.pSR)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.LK(bool);
      if ((locala != i.a.pSQ) && (locala != i.a.pSR)) {
        break label90;
      }
    }
    label85:
    label90:
    for (int i = b.i.settings_plugins_enable;; i = b.i.settings_plugins_disable)
    {
      localSwitchKeyValuePreference.aBk(i);
      AppMethodBeat.o(74539);
      return;
      bool = false;
      break;
    }
  }
  
  private void gWp()
  {
    AppMethodBeat.i(299419);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.bAi("settings_teen_mode");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsUI", "updateTeenMode Preference null");
      AppMethodBeat.o(299419);
      return;
    }
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEt())
    {
      this.screen.eh("settings_teen_mode", true);
      Log.i("MicroMsg.SettingsUI", "need hide teen-mode entrance");
      if (bool)
      {
        Log.e("MicroMsg.SettingsUI", "already enable TeenMode, need to close it manually");
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEp();
      }
      AppMethodBeat.o(299419);
      return;
    }
    this.screen.eh("settings_teen_mode", false);
    Log.d("MicroMsg.SettingsUI", "isTeenModeEnable :".concat(String.valueOf(bool)));
    if (bool) {
      localIconSwitchKeyValuePreference.aS(getString(b.i.setting_open));
    }
    localIconSwitchKeyValuePreference.aBl(-1);
    AppMethodBeat.o(299419);
  }
  
  private void gWq()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private void gWr()
  {
    AppMethodBeat.i(299444);
    com.tencent.mm.ui.base.k.a(getContext(), getString(b.i.logout_menu_set_alias), null, getString(b.i.create_alias), getString(b.i.app_cancel), true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        paramAnonymousDialogInterface = new Intent(SettingsUI.this.getContext(), SettingsModifyAliasUI.class);
        paramAnonymousDialogInterface.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.aQ(SettingsUI.this.getContext(), paramAnonymousDialogInterface);
        AppMethodBeat.o(74497);
      }
    }, null);
    AppMethodBeat.o(299444);
  }
  
  private boolean gWs()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(3) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(99L, 145L, 1L, false);
    if ((com.tencent.mm.kernel.h.aZW() != null) && (com.tencent.mm.kernel.h.aZW().oun != null)) {
      com.tencent.mm.kernel.h.aZW().oun.hb(false);
    }
    gWu();
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean gWt()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(4) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.Kql == null)
    {
      this.Kql = View.inflate(getContext(), b.g.settings_close, null);
      this.PwN = ((CheckBox)this.Kql.findViewById(b.f.settings_notify_dialog_cb));
      this.PwN.setChecked(true);
    }
    if (this.PwM == null) {
      this.PwM = com.tencent.mm.ui.base.k.a(getContext(), null, this.Kql, getString(b.i.logout_menu_exit), getString(b.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74498);
          com.tencent.mm.modelstat.c.bMY().FY();
          ((com.tencent.mm.plugin.expt.b.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.f.class)).dHR();
          if ((SettingsUI.g(SettingsUI.this) != null) && (SettingsUI.g(SettingsUI.this).isChecked()))
          {
            Log.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(6) });
            Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            ag.bRr().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.h(SettingsUI.this);
            AppMethodBeat.o(74498);
            return;
          }
          Log.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(7) });
          Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.h.aZW() != null) && (com.tencent.mm.kernel.h.aZW().oun != null)) {
            com.tencent.mm.kernel.h.aZW().oun.hb(false);
          }
          new hv().publish();
          SettingsUI.i(SettingsUI.this);
          AppMethodBeat.o(74498);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(5) });
          Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74499);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.PwM.show();
    }
  }
  
  private void gWu()
  {
    AppMethodBeat.i(299473);
    com.tencent.mm.kernel.h.baC();
    Log.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.b.getUin()) });
    new hv().publish();
    com.tencent.mm.modelstat.c.bMY().FY();
    ((com.tencent.mm.plugin.expt.b.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.f.class)).dHR();
    Object localObject = com.tencent.mm.kernel.h.aZW();
    com.tencent.mm.am.h local8 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final p paramAnonymousp)
      {
        AppMethodBeat.i(298869);
        Log.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousp.getType());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(299139);
            com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
            SettingsUI.q(SettingsUI.this);
            if (SettingsUI.r(SettingsUI.this) != null)
            {
              SettingsUI.r(SettingsUI.this).stopTimer();
              SettingsUI.s(SettingsUI.this);
            }
            if (SettingsUI.n(SettingsUI.this) != null) {
              SettingsUI.n(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousp.getType() == 255) && (((v)paramAnonymousp).oST == 2))
            {
              if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4))
              {
                Intent localIntent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                localIntent.putExtra("kintent_hint", SettingsUI.this.getString(b.i.regbymobile_reg_setpwd_tip_when_logout));
                SettingsUI.this.startActivityForResult(localIntent, 5);
                AppMethodBeat.o(299139);
                return;
              }
              SettingsUI.t(SettingsUI.this);
            }
            AppMethodBeat.o(299139);
          }
        });
        AppMethodBeat.o(298869);
      }
    };
    this.PqN = local8;
    ((com.tencent.mm.am.s)localObject).a(255, local8);
    localObject = new v(2);
    ((v)localObject).oST = 2;
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    this.PqM = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(298860);
        com.tencent.mm.kernel.h.aZW().a(this.PqW);
        com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
        SettingsUI.q(SettingsUI.this);
        if (SettingsUI.r(SettingsUI.this) != null)
        {
          SettingsUI.r(SettingsUI.this).stopTimer();
          SettingsUI.s(SettingsUI.this);
        }
        if (SettingsUI.n(SettingsUI.this) != null) {
          SettingsUI.n(SettingsUI.this).cancel();
        }
        SettingsUI.t(SettingsUI.this);
        AppMethodBeat.o(298860);
        return false;
      }
    }, false);
    this.PqM.startTimer(12000L);
    getString(b.i.app_tip);
    this.PqL = com.tencent.mm.ui.base.k.a(this, getString(b.i.wx_logout_processing_txt), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(299387);
        com.tencent.mm.kernel.h.aZW().a(this.PqW);
        com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
        SettingsUI.q(SettingsUI.this);
        if (SettingsUI.r(SettingsUI.this) != null)
        {
          SettingsUI.r(SettingsUI.this).stopTimer();
          SettingsUI.s(SettingsUI.this);
        }
        if (SettingsUI.n(SettingsUI.this) != null) {
          SettingsUI.n(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(299387);
      }
    });
    if (com.tencent.mm.kernel.h.baz())
    {
      localObject = com.tencent.mm.modelavatar.d.Lz(z.bAM());
      bg.okT.JD((String)localObject);
    }
    AppMethodBeat.o(299473);
  }
  
  private void gWv()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.h.aZW();
    com.tencent.mm.am.h local18 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(299279);
        paramAnonymousString = z.bAM();
        if (cj.ono.Kd(paramAnonymousString)) {
          cj.ono.s(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298861);
            com.tencent.mm.kernel.h.aZW().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(298861);
          }
        });
        AppMethodBeat.o(299279);
      }
    };
    this.PwK = local18;
    ((com.tencent.mm.am.s)localObject).a(282, local18);
    localObject = new com.tencent.mm.modelsimple.t();
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void gWw()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.h.aZW();
    Object localObject2 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final p paramAnonymousp)
      {
        AppMethodBeat.i(74517);
        Log.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousp.getType());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
            SettingsUI.q(SettingsUI.this);
            if (SettingsUI.r(SettingsUI.this) != null)
            {
              SettingsUI.r(SettingsUI.this).stopTimer();
              SettingsUI.s(SettingsUI.this);
            }
            if (SettingsUI.n(SettingsUI.this) != null) {
              SettingsUI.n(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousp.getType() == 255) && (((v)paramAnonymousp).oST == 1))
            {
              if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4))
              {
                Intent localIntent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                localIntent.putExtra("kintent_hint", SettingsUI.this.getString(b.i.regbymobile_reg_setpwd_tip_when_logout));
                SettingsUI.this.startActivityForResult(localIntent, 0);
                AppMethodBeat.o(74516);
                return;
              }
              SettingsUI.B(SettingsUI.this);
            }
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.PqN = ((com.tencent.mm.am.h)localObject2);
    ((com.tencent.mm.am.s)localObject1).a(255, (com.tencent.mm.am.h)localObject2);
    localObject1 = new v(2);
    ((v)localObject1).oST = 1;
    com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
    this.PqM = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(299209);
        com.tencent.mm.kernel.h.aZW().a(this.PqW);
        com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
        SettingsUI.q(SettingsUI.this);
        if (SettingsUI.r(SettingsUI.this) != null)
        {
          SettingsUI.r(SettingsUI.this).stopTimer();
          SettingsUI.s(SettingsUI.this);
        }
        if (SettingsUI.n(SettingsUI.this) != null) {
          SettingsUI.n(SettingsUI.this).cancel();
        }
        SettingsUI.B(SettingsUI.this);
        AppMethodBeat.o(299209);
        return false;
      }
    }, false);
    this.PqM.startTimer(3000L);
    localObject2 = getContext();
    getString(b.i.app_tip);
    this.PqL = com.tencent.mm.ui.base.k.a((Context)localObject2, getString(b.i.wx_exit_processing_txt), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(299272);
        com.tencent.mm.kernel.h.aZW().a(this.PqW);
        com.tencent.mm.kernel.h.aZW().b(255, SettingsUI.p(SettingsUI.this));
        SettingsUI.q(SettingsUI.this);
        if (SettingsUI.r(SettingsUI.this) != null)
        {
          SettingsUI.r(SettingsUI.this).stopTimer();
          SettingsUI.s(SettingsUI.this);
        }
        if (SettingsUI.n(SettingsUI.this) != null) {
          SettingsUI.n(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(299272);
      }
    });
    AppMethodBeat.o(74547);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74535);
    setMMTitle(b.i.settings_title);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74522);
        SettingsUI.this.finish();
        AppMethodBeat.o(74522);
        return true;
      }
    });
    this.ucS = new com.tencent.mm.ui.widget.a.f(this, 1, false);
    this.ucS.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymouss.jmw())
        {
          paramAnonymouss.bx(1, b.i.logout_menu_logout, b.h.menu_logout_single);
          paramAnonymouss.bx(2, b.i.logout_menu_exit, b.h.menu_close_wechat);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.ucS.aeLi = new f.b()
    {
      public final void onDismiss() {}
    };
    this.ucS.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(74524);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74524);
          return;
          if ((com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) != 0) && (z.bAT()) && (Util.isNullOrNil(z.bAN())))
          {
            SettingsUI.c(SettingsUI.this);
            AppMethodBeat.o(74524);
            return;
          }
          SettingsUI.d(SettingsUI.this);
          AppMethodBeat.o(74524);
          return;
          SettingsUI.e(SettingsUI.this);
        }
      }
    };
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SettingsUI.this.onSetToTop();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74525);
      }
    });
    gWo();
    gVs();
    gWn();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.bAi("settings_switch_account");
    localButtonPreference.DWD = false;
    localButtonPreference.iN(getString(b.i.settings_switch_account), getContext().getResources().getColor(b.c.FG_0));
    localButtonPreference = (ButtonPreference)this.screen.bAi("settings_logout");
    localButtonPreference.DWD = false;
    localButtonPreference.iN(getString(b.i.settings_logout), getContext().getResources().getColor(b.c.FG_0));
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zxo, 0) == 0) {
      this.screen.eh("settings_active_time", true);
    }
    AppMethodBeat.o(74535);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74531);
    Log.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(74531);
      return;
    case 5: 
      if (paramInt2 == -1) {
        gWj();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.t.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.c.pFn.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.t.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      com.tencent.mm.modelavatar.q.bFp();
      localIntent.putExtra("CropImage_OutputPath", AvatarStorage.R(z.bAM(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.c.pFn.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.bzL(), null);
      AppMethodBeat.o(74531);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(74531);
      return;
    }
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null) {
      Log.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(74531);
      return;
      new o(getContext(), (String)localObject, false).L(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      finish();
      AppMethodBeat.o(74529);
      return;
    }
    initView();
    com.tencent.mm.kernel.h.baE().ban().add(this);
    com.tencent.mm.aa.c.aYo().a(this.PwL);
    if ((Util.getInt(com.tencent.mm.k.i.aRC().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.h.baE().ban().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIJ, Boolean.FALSE);
      Log.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.h.baz())
    {
      com.tencent.mm.kernel.h.baE().ban().remove(this);
      com.tencent.mm.aa.c.aYo().b(this.PwL);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.h.aZW().b(281, this.onSceneEndCallback);
    }
    if (this.PqN != null) {
      com.tencent.mm.kernel.h.aZW().b(255, this.PqN);
    }
    if (this.PwO != null) {
      com.tencent.mm.kernel.h.aZW().b(281, this.PwO);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.baE().ban()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.h.baE().ban().d(2, null);
      com.tencent.mm.kernel.h.baE().ban().d(4, null);
    }
    if (6 == i) {
      gWo();
    }
    for (;;)
    {
      if (paramObject == at.a.acQt) {
        gWp();
      }
      AppMethodBeat.o(74536);
      return;
      if (64 == i) {
        gWm();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baH().postAtFrontOfQueueToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.h.baE().ban().iZy();
          AppMethodBeat.o(74508);
        }
      });
    }
    AppMethodBeat.o(74532);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74540);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      com.tencent.mm.plugin.newtips.a.gtf().aeI(34);
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.c.class)).aL(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((Util.getInt(com.tencent.mm.k.i.aRC().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.h.baE().ban().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIL, Boolean.FALSE);
        Log.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.aa.c.aYo().b(at.a.acWf, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_teen_mode".equals(paramf))
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kh(this);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_care_mode".equals(paramf))
    {
      paramf = new Intent(this, SettingsCareModeIntro.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetCareMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetCareMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aQ(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQn, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQo, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQo, Integer.valueOf(i));
      }
      paramf = String.format("%s,%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(21529, paramf);
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.plugin.newtips.a.gtf().aeI(31);
      com.tencent.mm.aa.c.aYo().dX(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.aa.c.aYo().dX(262145, 266243);
      com.tencent.mm.aa.c.aYo().dX(262157, 266262);
      com.tencent.mm.aa.c.aYo().dX(262164, 266269);
      com.tencent.mm.plugin.newtips.a.gtf().aeI(38);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.xwebutil.c.jQE();
          AppMethodBeat.o(74527);
        }
      }, 100L);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new com.tencent.mm.plugin.appbrand.api.g();
      paramf.appId = "wxd930c3b7cf7c92e6";
      paramf.qAF = "pages/device-list/device-list.html";
      paramf.version = 0;
      paramf.euz = 0;
      paramf.scene = 1112;
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(getContext(), paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.au.b.isOverseasUser())
      {
        Log.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.k.a(getContext(), true, getResources().getString(b.i.settings_logout_warning_tip), "", getResources().getString(b.i.settings_logout), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(299380);
            SettingsUI.u(SettingsUI.this);
            AppMethodBeat.o(299380);
          }
        }, null);
        AppMethodBeat.o(74540);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11545, new Object[] { Integer.valueOf(8) });
      Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (cj.ono.bDj().size() > 1) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), cj.ono.bDk(), cj.ono.bDl(), com.tencent.mm.compatible.deviceinfo.q.aPg() });
      }
      for (;;)
      {
        this.ucS.dDn();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), cj.ono.bDk(), cj.ono.bDl(), com.tencent.mm.compatible.deviceinfo.q.aPg() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = gWt();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = gWs();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_chatting"))
    {
      startActivity(SettingsChattingUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_active_time"))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if (WeChatBrands.AppInfo.current().isMainland()) {
        if ((!ChannelUtil.isNokiaAol) && (LocaleUtil.getApplicationLanguage().equals("zh_CN")))
        {
          paramf = getString(b.i.wechat_faq_url);
          Log.d("MicroMsg.SettingsUI", "using faq webpage");
          paramPreference = new Intent();
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("show_feedback", false);
          paramPreference.putExtra("KShowFixToolsBtn", true);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        }
      }
    }
    label1918:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74540);
        return false;
        if (LocaleUtil.getApplicationLanguage().equals("zh_HK"))
        {
          paramf = getString(b.i.wechat_faq_url_cht);
          break;
        }
        if (LocaleUtil.getApplicationLanguage().equals("zh_TW"))
        {
          paramf = getString(b.i.wechat_faq_url_cht_tw);
          break;
        }
        paramf = getString(b.i.wechat_faq_url_en);
        break;
        com.tencent.mm.pluginsdk.g.cB(MMApplicationContext.getContext(), "weixin://dl/feedback");
        continue;
        if (!paramf.equals("settings_switch_account")) {
          break label1994;
        }
        if (cj.ono.bDj().size() > 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), cj.ono.bDk(), cj.ono.bDl(), com.tencent.mm.compatible.deviceinfo.q.aPg() });
        }
        for (;;)
        {
          if ((com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) == 0) || (!z.bAT()) || (!Util.isNullOrNil(z.bAN()))) {
            break label1918;
          }
          gWr();
          break;
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), cj.ono.bDk(), cj.ono.bDl(), com.tencent.mm.compatible.deviceinfo.q.aPg() });
        }
        if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acUm, true))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acUm, Boolean.FALSE);
          com.tencent.mm.ui.base.k.a(this, getString(b.i.settings_switch_account_alert_tip), getString(b.i.settings_switch_account_alert_title), getString(b.i.app_i_known), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74526);
              SettingsUI.f(SettingsUI.this);
              AppMethodBeat.o(74526);
            }
          });
        }
        else
        {
          gWq();
        }
      }
      if (paramf.equals("settings_permission_index"))
      {
        paramf = new Intent(this, SettingsPermissionIndexUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(74540);
        return true;
      }
      if (paramf.equals("settings_privacy_personal_list"))
      {
        paramf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvC, "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=datalist/personal");
        if (!Util.isNullOrNil(paramf))
        {
          paramPreference = com.tencent.mm.plugin.report.service.l.OAV;
          com.tencent.mm.plugin.report.service.l.gOa();
          paramPreference = new Intent();
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("show_feedback", false);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("needRedirect", false);
          paramPreference.putExtra("neverGetA8Key", false);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        }
        AppMethodBeat.o(74540);
        return true;
      }
    } while (!paramf.equals("settings_privacy_third_party_list"));
    label1994:
    paramf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvE, "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=datalist/shared");
    if (!Util.isNullOrNil(paramf))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", false);
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("show_feedback", false);
      paramPreference.putExtra("show_bottom", false);
      paramPreference.putExtra("needRedirect", false);
      paramPreference.putExtra("neverGetA8Key", false);
      com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
    }
    AppMethodBeat.o(74540);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.bAi("settings_account");
    if (localObject1 != null)
    {
      localObject2 = z.bAM();
      ((PersonalPreference)localObject1).orY = null;
      ((PersonalPreference)localObject1).Ppk = -1;
      ((PersonalPreference)localObject1).avatar = ((String)localObject2);
      if (((PersonalPreference)localObject1).Aop != null) {
        a.b.g(((PersonalPreference)localObject1).Aop, ((PersonalPreference)localObject1).avatar);
      }
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuF, 0) != 1)
    {
      localObject1 = new ft();
      ((ft)localObject1).publish();
      if (!((ft)localObject1).hGa.hEn)
      {
        localObject1 = this.screen.bAi("settings_about_device");
        this.screen.e((Preference)localObject1);
      }
    }
    gWm();
    gWp();
    gWo();
    gVs();
    gWn();
    if ((WeChatBrands.Business.Entries.MeSetPlugin.banned()) || (ab.bBX())) {
      this.screen.eh("settings_welab", true);
    }
    localObject1 = (NormalIconNewTipPreference)this.screen.bAi("settings_welab");
    com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject1);
    ((NormalIconNewTipPreference)localObject1).a(this.screen);
    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.c.class);
    boolean bool2 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).iDE();
    boolean bool3 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).iDF();
    boolean bool4 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).iDD();
    boolean bool1;
    if ((bool2) || ((bool3) && (bool4)))
    {
      bool1 = true;
      bool1 = com.tencent.mm.plugin.newtips.a.g.a(bool1, (com.tencent.mm.plugin.newtips.a.a)localObject1);
      Log.i("MicroMsg.SettingsUI", "updateWeLab :%s %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if (!bool1)
      {
        if (!bool2) {
          break label447;
        }
        ((NormalIconNewTipPreference)localObject1).afx(0);
        ((NormalIconNewTipPreference)localObject1).gv(getString(b.i.app_new), b.e.new_tips_bg);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        label374:
        if (!bool3) {
          break label469;
        }
        if (!bool4) {
          break label457;
        }
        ((NormalIconNewTipPreference)localObject1).on(0, b.e.unread_dot_shape);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsK, true);
      }
      label402:
      if (!com.tencent.mm.ce.b.iRq()) {
        break label480;
      }
      this.screen.eh("settings_care_mode", true);
    }
    for (;;)
    {
      Log.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      bool1 = false;
      break;
      label447:
      ((NormalIconNewTipPreference)localObject1).afx(8);
      break label374;
      label457:
      ((NormalIconNewTipPreference)localObject1).on(0, b.h.welab_icon_grey);
      break label402;
      label469:
      ((NormalIconNewTipPreference)localObject1).on(8, -1);
      break label402;
      label480:
      this.screen.eh("settings_care_mode", false);
      localObject1 = this.screen.bAi("settings_care_mode");
      if (com.tencent.mm.ce.b.iRp()) {
        ((Preference)localObject1).aS(getString(b.i.setting_open));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */