package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
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
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.f.a.fi;
import com.tencent.mm.f.a.fi.a;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Set;

@com.tencent.mm.kernel.k
public class SettingsUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private View ExB;
  private ProgressDialog JfW;
  private MTimerHandler JfX;
  private com.tencent.mm.an.i JfY;
  private PersonalPreference Jki;
  private com.tencent.mm.an.i Jkj;
  private a.a Jkk;
  private Dialog Jkl;
  private com.tencent.mm.ui.widget.a.d Jkm;
  private CheckBox Jkn;
  private com.tencent.mm.an.i Jko;
  private MTimerHandler cts;
  private MTimerHandler lUQ;
  private com.tencent.mm.an.i onSceneEndCallback;
  private com.tencent.mm.ui.widget.a.e qXn;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.Jki = null;
    this.JfW = null;
    this.onSceneEndCallback = null;
    this.Jkj = null;
    this.JfY = null;
    this.Jkk = new a.a()
    {
      public final void E(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158) || (paramAnonymousInt == 262164)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(ar.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == ar.a.Vuw)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.Jkl = null;
    this.lUQ = null;
    this.Jko = null;
    AppMethodBeat.o(74528);
  }
  
  private void fFY()
  {
    AppMethodBeat.i(74537);
    Object localObject = (IconPreference)this.screen.byG("settings_about_micromsg");
    boolean bool1 = Util.nullAs(Boolean.valueOf(com.tencent.mm.aa.c.aFn().dj(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262157, 266262);
    boolean bool3 = com.tencent.mm.aa.c.aFn().dk(262164, 266269);
    if (ChannelUtil.isNokiaAol)
    {
      ((IconPreference)localObject).fC("", -1);
      ((IconPreference)localObject).abe(8);
      localObject = (NormalIconNewTipPreference)this.screen.byG("settings_about_system");
      com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      ((NormalIconNewTipPreference)localObject).a(this.screen);
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject);
      bool2 = com.tencent.mm.aa.c.aFn().dk(262158, 266265);
      com.tencent.mm.plugin.newtips.a.fiR();
      bool3 = com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf);
      com.tencent.mm.cj.c.hrC();
      if ((!bool2) && (!bool3)) {
        break label276;
      }
    }
    label276:
    for (bool1 = true;; bool1 = false)
    {
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, (com.tencent.mm.plugin.newtips.a.a)localObject)) {
        break label281;
      }
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        ((IconPreference)localObject).abe(0);
        ((IconPreference)localObject).fC(getString(b.i.app_new), b.e.new_tips_bg);
        break;
      }
      if (bool2)
      {
        ((IconPreference)localObject).aak(0);
        break;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot())
      {
        ((IconPreference)localObject).aak(0);
        break;
      }
      if (bool3)
      {
        ((IconPreference)localObject).aak(0);
        break;
      }
      ((IconPreference)localObject).aak(8);
      ((IconPreference)localObject).fC("", -1);
      ((IconPreference)localObject).abe(8);
      break;
    }
    label281:
    if ((bool2) || (bool3))
    {
      ((NormalIconNewTipPreference)localObject).aak(0);
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, com.tencent.mm.plugin.newtips.a.k.GwK, true);
      AppMethodBeat.o(74537);
      return;
    }
    ((NormalIconNewTipPreference)localObject).aak(8);
    AppMethodBeat.o(74537);
  }
  
  private void fGA()
  {
    AppMethodBeat.i(74542);
    Log.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.c.mIH.abH();
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    Object localObject = new mr();
    ((mr)localObject).fKQ.status = 0;
    ((mr)localObject).fKQ.bnA = 0;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new com.tencent.mm.f.a.ae();
    ((com.tencent.mm.f.a.ae)localObject).fvH.fvI = true;
    EventCenter.instance.publish((IEvent)localObject);
    MMEntryLock.unlock("show_whatsnew");
    n.v(this, true);
    com.tencent.mm.plugin.report.service.g.adc(8);
    com.tencent.mm.kernel.h.aHF().aGX();
    localObject = new ac();
    EventCenter.instance.publish((IEvent)localObject);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.c.mIG.n((Intent)localObject, getContext());
    com.tencent.mm.platformtools.t.O(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void fGE()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.byG("settings_account_info");
    if (localIconPreference == null)
    {
      Log.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.auG(8);
    if (com.tencent.mm.aa.c.aFn().a(ar.a.Vuw, 266257))
    {
      localIconPreference.aak(0);
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhr, Boolean.FALSE)).booleanValue()) {
          break label181;
        }
        if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.fC(getString(b.i.app_new), b.e.new_tips_bg);
          localIconPreference.abe(0);
          Log.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.aak(8);
      break;
      label181:
      localIconPreference.abe(8);
      localIconPreference.fC("", -1);
    }
  }
  
  private void fGF()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.byG("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoR, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoS, Integer.valueOf(0))).intValue())
      {
        localIconPreference.aak(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.aak(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void fGG()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.byi();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.byG("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.mWk) && (locala != l.a.mWl)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.FY(bool);
      if ((locala != l.a.mWk) && (locala != l.a.mWl)) {
        break label90;
      }
    }
    label85:
    label90:
    for (int i = b.i.settings_plugins_enable;; i = b.i.settings_plugins_disable)
    {
      localSwitchKeyValuePreference.auI(i);
      AppMethodBeat.o(74539);
      return;
      bool = false;
      break;
    }
  }
  
  private void fGH()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean fGI()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.Jkl != null)
    {
      this.Jkl.show();
      AppMethodBeat.o(74543);
      return true;
    }
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.Jkl = com.tencent.mm.ui.base.h.c(this, getString(b.i.settings_logout_warning_tip), "", getString(b.i.settings_logout), getString(b.i.settings_logout_option_cancel), new SettingsUI.2(this), new SettingsUI.3(this));
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean fGJ()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(4) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.ExB == null)
    {
      this.ExB = View.inflate(getContext(), b.g.settings_close, null);
      this.Jkn = ((CheckBox)this.ExB.findViewById(b.f.settings_notify_dialog_cb));
      this.Jkn.setChecked(true);
    }
    if (this.Jkm == null) {
      this.Jkm = com.tencent.mm.ui.base.h.a(getContext(), null, this.ExB, getString(b.i.logout_menu_exit), getString(b.i.app_cancel), new SettingsUI.4(this), new SettingsUI.5(this));
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.Jkm.show();
    }
  }
  
  private void fGK()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.h.aGY();
    com.tencent.mm.an.i local19 = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = z.bcZ();
        if (ci.lvQ.Sb(paramAnonymousString)) {
          ci.lvQ.o(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.h.aGY().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.Jkj = local19;
    ((com.tencent.mm.an.t)localObject).a(282, local19);
    localObject = new s();
    com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void fGL()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.h.aGY();
    Object localObject2 = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(74519);
        Log.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.h.aGY().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousq.getType() == 255) && (((com.tencent.mm.modelsimple.u)paramAnonymousq).mad == 1))
            {
              if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4))
              {
                Intent localIntent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                localIntent.putExtra("kintent_hint", SettingsUI.this.getString(b.i.regbymobile_reg_setpwd_tip_when_logout));
                SettingsUI.this.startActivityForResult(localIntent, 0);
                AppMethodBeat.o(74518);
                return;
              }
              SettingsUI.B(SettingsUI.this);
            }
            AppMethodBeat.o(74518);
          }
        });
        AppMethodBeat.o(74519);
      }
    };
    this.JfY = ((com.tencent.mm.an.i)localObject2);
    ((com.tencent.mm.an.t)localObject1).a(255, (com.tencent.mm.an.i)localObject2);
    localObject1 = new com.tencent.mm.modelsimple.u(2);
    ((com.tencent.mm.modelsimple.u)localObject1).mad = 1;
    com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
    this.JfX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.h.aGY().a(this.Jge);
        com.tencent.mm.kernel.h.aGY().b(255, SettingsUI.q(SettingsUI.this));
        SettingsUI.r(SettingsUI.this);
        if (SettingsUI.s(SettingsUI.this) != null)
        {
          SettingsUI.s(SettingsUI.this).stopTimer();
          SettingsUI.t(SettingsUI.this);
        }
        if (SettingsUI.o(SettingsUI.this) != null) {
          SettingsUI.o(SettingsUI.this).cancel();
        }
        SettingsUI.B(SettingsUI.this);
        AppMethodBeat.o(74520);
        return false;
      }
    }, false);
    this.JfX.startTimer(3000L);
    localObject2 = getContext();
    getString(b.i.app_tip);
    this.JfW = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(b.i.wx_exit_processing_txt), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.h.aGY().a(this.Jge);
        com.tencent.mm.kernel.h.aGY().b(255, SettingsUI.q(SettingsUI.this));
        SettingsUI.r(SettingsUI.this);
        if (SettingsUI.s(SettingsUI.this) != null)
        {
          SettingsUI.s(SettingsUI.this).stopTimer();
          SettingsUI.t(SettingsUI.this);
        }
        if (SettingsUI.o(SettingsUI.this) != null) {
          SettingsUI.o(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(74521);
      }
    });
    AppMethodBeat.o(74547);
  }
  
  private void xT(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    MMEntryLock.unlock("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().aqZ();
    }
    for (;;)
    {
      com.tencent.mm.f.a.ae localae = new com.tencent.mm.f.a.ae();
      localae.fvH.fvI = false;
      EventCenter.instance.publish(localae);
      com.tencent.mm.plugin.setting.c.mIH.abF();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().aqY();
      finish();
      if (com.tencent.mm.pluginsdk.j.c.QYP != null) {
        com.tencent.mm.pluginsdk.j.c.QYP.o(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().s(-1, null);
    }
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
    setBackBtn(new SettingsUI.23(this));
    this.qXn = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.qXn.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymouso.hJO())
        {
          paramAnonymouso.aW(1, b.i.logout_menu_logout, b.h.menu_logout_single);
          paramAnonymouso.aW(2, b.i.logout_menu_exit, b.h.menu_close_wechat);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.qXn.XbB = new e.b()
    {
      public final void onDismiss() {}
    };
    this.qXn.ODU = new q.g()
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
          SettingsUI.c(SettingsUI.this);
          AppMethodBeat.o(74524);
          return;
          SettingsUI.d(SettingsUI.this);
        }
      }
    };
    setToTop(new SettingsUI.27(this));
    fGG();
    fFY();
    fGF();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.byG("settings_switch_account");
    localButtonPreference.yfJ = false;
    localButtonPreference.hG(getString(b.i.settings_switch_account), getContext().getResources().getColor(b.c.FG_0));
    localButtonPreference = (ButtonPreference)this.screen.byG("settings_logout");
    localButtonPreference.yfJ = false;
    localButtonPreference.hG(getString(b.i.settings_logout), getContext().getResources().getColor(b.c.FG_0));
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
        fGA();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.u.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.c.mIG.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.u.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      com.tencent.mm.am.q.bhz();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.am.f.O(z.bcZ(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.c.mIG.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.bbW(), 4, null);
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
      new com.tencent.mm.am.o(getContext(), (String)localObject).G(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
    com.tencent.mm.aa.c.aFn().a(this.Jkk);
    if ((Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.h.aHG().aHp().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vhp, Boolean.FALSE);
      Log.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.h.aHB())
    {
      com.tencent.mm.kernel.h.aHG().aHp().remove(this);
      com.tencent.mm.aa.c.aFn().b(this.Jkk);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.h.aGY().b(281, this.onSceneEndCallback);
    }
    if (this.JfY != null) {
      com.tencent.mm.kernel.h.aGY().b(255, this.JfY);
    }
    if (this.Jko != null) {
      com.tencent.mm.kernel.h.aGY().b(281, this.Jko);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
      com.tencent.mm.kernel.h.aHG().aHp().b(4, null);
    }
    if (6 == i)
    {
      fGG();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      fGE();
    }
    AppMethodBeat.o(74536);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHJ().postAtFrontOfQueueToWorker(new SettingsUI.12(this));
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
      com.tencent.mm.plugin.newtips.a.fiO().aap(34);
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.c.class)).aC(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.h.aHG().aHp().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vhr, Boolean.FALSE);
        Log.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.aa.c.aFn().b(ar.a.Vuw, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    boolean bool;
    if ("settings_teen_mode".equals(paramf))
    {
      bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).setScene(1);
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(1);
      paramf = new Intent();
      if (!bool) {
        com.tencent.mm.by.c.b(this, "teenmode", ".ui.SettingsTeenModeIntro", paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.by.c.b(this, "teenmode", ".ui.TeenModeVerifyPwdUI", paramf);
      }
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aH(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoR, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VoS, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoS, Integer.valueOf(i));
      }
      paramf = String.format("%s,%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(21529, paramf);
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.plugin.newtips.a.fiO().aap(31);
      com.tencent.mm.aa.c.aFn().dl(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.aa.c.aFn().dl(262145, 266243);
      com.tencent.mm.aa.c.aFn().dl(262157, 266262);
      com.tencent.mm.aa.c.aFn().dl(262164, 266269);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
      new MMHandler().postDelayed(new SettingsUI.29(this), 100L);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new com.tencent.mm.plugin.appbrand.api.g();
      paramf.appId = "wxd930c3b7cf7c92e6";
      paramf.nBq = "pages/device-list/device-list.html";
      paramf.version = 0;
      paramf.cBU = 0;
      paramf.scene = 1112;
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(getContext(), paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.az.b.isOverseasUser())
      {
        Log.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.h.a(getContext(), true, getResources().getString(b.i.settings_logout_warning_tip), "", getResources().getString(b.i.settings_logout), getString(b.i.app_cancel), new SettingsUI.13(this), null);
        AppMethodBeat.o(74540);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(8) });
      Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (ci.lvQ.bfs().size() > 1) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), ci.lvQ.bft() });
      }
      for (;;)
      {
        this.qXn.eik();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), ci.lvQ.bft() });
      }
    }
    if (paramf.equals("settings_exit"))
    {
      bool = fGJ();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = fGI();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
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
      com.tencent.mm.plugin.report.service.h.IzE.a(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
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
          com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        }
      }
    }
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
      com.tencent.mm.pluginsdk.g.cq(MMApplicationContext.getContext(), "weixin://dl/feedback");
      continue;
      if (paramf.equals("settings_switch_account"))
      {
        if (ci.lvQ.bfs().size() > 1) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), ci.lvQ.bft() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VsH, true)) {
            break label1840;
          }
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsH, Boolean.FALSE);
          com.tencent.mm.ui.base.h.a(this, getString(b.i.settings_switch_account_alert_tip), getString(b.i.settings_switch_account_alert_title), getString(b.i.app_i_known), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74526);
              SettingsUI.e(SettingsUI.this);
              AppMethodBeat.o(74526);
            }
          });
          break;
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), ci.lvQ.bft() });
        }
        label1840:
        fGH();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.byG("settings_account");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = z.bcZ();
      ((PersonalPreference)localObject1).lAx = null;
      ((PersonalPreference)localObject1).JeO = -1;
      ((PersonalPreference)localObject1).avatar = ((String)localObject2);
      if (((PersonalPreference)localObject1).wRM != null) {
        a.b.c(((PersonalPreference)localObject1).wRM, ((PersonalPreference)localObject1).avatar);
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbk, 0) != 1)
    {
      localObject1 = new fi();
      EventCenter.instance.publish((IEvent)localObject1);
      if (!((fi)localObject1).fBl.fzO)
      {
        localObject1 = this.screen.byG("settings_about_device");
        this.screen.d((Preference)localObject1);
      }
    }
    fGE();
    localObject1 = (IconSwitchKeyValuePreference)this.screen.byG("settings_teen_mode");
    boolean bool1;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.SettingsUI", "updateTeenMode Preference null");
      fGG();
      fFY();
      fGF();
      if (WeChatBrands.Business.Entries.MeSetPlugin.banned()) {
        this.screen.dz("settings_welab", true);
      }
      localObject1 = (NormalIconNewTipPreference)this.screen.byG("settings_welab");
      com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject1);
      ((NormalIconNewTipPreference)localObject1).a(this.screen);
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
      localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.c.class);
      boolean bool2 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).hcW();
      boolean bool3 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).hcX();
      boolean bool4 = ((com.tencent.mm.plugin.welab.a.a.c)localObject2).hcV();
      if ((!bool2) && ((!bool3) || (!bool4))) {
        break label601;
      }
      bool1 = true;
      label310:
      bool1 = com.tencent.mm.plugin.newtips.a.g.a(bool1, (com.tencent.mm.plugin.newtips.a.a)localObject1);
      Log.i("MicroMsg.SettingsUI", "updateWeLab :%s %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if (!bool1)
      {
        if (!bool2) {
          break label606;
        }
        ((NormalIconNewTipPreference)localObject1).abe(0);
        ((NormalIconNewTipPreference)localObject1).fC(getString(b.i.app_new), b.e.new_tips_bg);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.GwK, true);
        label398:
        if (!bool3) {
          break label628;
        }
        if (!bool4) {
          break label616;
        }
        ((NormalIconNewTipPreference)localObject1).mt(0, b.e.unread_dot_shape);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.GwK, true);
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      bool1 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      if (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gku())
      {
        this.screen.dz("settings_teen_mode", true);
        Log.i("MicroMsg.SettingsUI", "need hide teen-mode entrance");
        if (!bool1) {
          break;
        }
        Log.e("MicroMsg.SettingsUI", "already enable TeenMode, need to close it manually");
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkq();
        break;
      }
      this.screen.dz("settings_teen_mode", false);
      Log.d("MicroMsg.SettingsUI", "isTeenModeEnable :".concat(String.valueOf(bool1)));
      if (bool1) {
        ((IconSwitchKeyValuePreference)localObject1).aF(getString(b.i.setting_open));
      }
      for (;;)
      {
        ((IconSwitchKeyValuePreference)localObject1).auJ(-1);
        break;
        ((IconSwitchKeyValuePreference)localObject1).aF(getString(b.i.setting_unopen));
      }
      label601:
      bool1 = false;
      break label310;
      label606:
      ((NormalIconNewTipPreference)localObject1).abe(8);
      break label398;
      label616:
      ((NormalIconNewTipPreference)localObject1).mt(0, b.h.welab_icon_grey);
      continue;
      label628:
      ((NormalIconNewTipPreference)localObject1).mt(8, -1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */