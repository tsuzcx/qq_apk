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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fb.a;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.af;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.i.c.a;
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
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.y.a.a;
import java.util.ArrayList;
import java.util.Set;

@com.tencent.mm.kernel.i
public class SettingsUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private ProgressDialog Dav;
  private MTimerHandler Daw;
  private com.tencent.mm.ak.i Dax;
  private PersonalPreference DeC;
  private com.tencent.mm.ak.i DeD;
  private a.a DeE;
  private Dialog DeF;
  private com.tencent.mm.ui.widget.a.d DeG;
  private CheckBox DeH;
  private com.tencent.mm.ak.i DeI;
  private MTimerHandler cve;
  private MTimerHandler jer;
  private com.tencent.mm.ui.widget.a.e nVN;
  private com.tencent.mm.ak.i onSceneEndCallback;
  private com.tencent.mm.ui.base.preference.f screen;
  private View yTE;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.DeC = null;
    this.Dav = null;
    this.onSceneEndCallback = null;
    this.DeD = null;
    this.Dax = null;
    this.DeE = new a.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString)
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
        if ((paramAnonymousa != null) && (paramAnonymousa == ar.a.Ogg)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.DeF = null;
    this.jer = null;
    this.DeI = null;
    AppMethodBeat.o(74528);
  }
  
  private void eSU()
  {
    int j = 0;
    AppMethodBeat.i(74537);
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_about_micromsg");
    boolean bool1 = Util.nullAs(Boolean.valueOf(com.tencent.mm.y.c.axV().cO(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.y.c.axV().cP(262157, 266262);
    boolean bool3 = com.tencent.mm.y.c.axV().cP(262164, 266269);
    if (ChannelUtil.isNokiaAol)
    {
      localIconPreference.gY("", -1);
      localIconPreference.alD(8);
      bool1 = com.tencent.mm.y.c.axV().cP(262158, 266265);
      localIconPreference = (IconPreference)this.screen.bmg("settings_about_system");
      if (!bool1) {
        break label270;
      }
      i = 0;
      label119:
      localIconPreference.alF(i);
      com.tencent.mm.plugin.newtips.a.exo();
      if (!com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
        break label276;
      }
    }
    label270:
    label276:
    for (int i = j;; i = 8)
    {
      localIconPreference.alF(i);
      com.tencent.mm.cc.c.gvE();
      localIconPreference.alF(8);
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        localIconPreference.alD(0);
        localIconPreference.gY(getString(2131755915), 2131234232);
        break;
      }
      if (bool2)
      {
        localIconPreference.alF(0);
        break;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot())
      {
        localIconPreference.alF(0);
        break;
      }
      if (bool3)
      {
        localIconPreference.alF(0);
        break;
      }
      localIconPreference.alF(8);
      localIconPreference.gY("", -1);
      localIconPreference.alD(8);
      break;
      i = 8;
      break label119;
    }
  }
  
  private void eTB()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_account_info");
    if (localIconPreference == null)
    {
      Log.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.alI(8);
    if (com.tencent.mm.y.c.axV().a(ar.a.Ogg, 266257))
    {
      localIconPreference.alF(0);
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTr, Boolean.FALSE)).booleanValue()) {
          break label181;
        }
        if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.gY(getString(2131755915), 2131234232);
          localIconPreference.alD(0);
          Log.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.alF(8);
      break;
      label181:
      localIconPreference.alD(8);
      localIconPreference.gY("", -1);
    }
  }
  
  private void eTC()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OaP, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OaQ, Integer.valueOf(0))).intValue())
      {
        localIconPreference.alF(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.alF(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void eTD()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.bnZ();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.bmg("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.keL) && (locala != l.a.keM)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.BE(bool);
      if ((locala != l.a.keL) && (locala != l.a.keM)) {
        break label90;
      }
    }
    label85:
    label90:
    for (int i = 2131765539;; i = 2131765538)
    {
      localSwitchKeyValuePreference.setSummary(i);
      AppMethodBeat.o(74539);
      return;
      bool = false;
      break;
    }
  }
  
  private void eTE()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean eTF()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.DeF != null)
    {
      this.DeF.show();
      AppMethodBeat.o(74543);
      return true;
    }
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.DeF = com.tencent.mm.ui.base.h.c(this, getString(2131765436), "", getString(2131765432), getString(2131765435), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(3) });
        Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(99L, 145L, 1L, false);
        if ((com.tencent.mm.kernel.g.azz() != null) && (com.tencent.mm.kernel.g.azz().iMw != null)) {
          com.tencent.mm.kernel.g.azz().iMw.fz(false);
        }
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        SettingsUI.g(SettingsUI.this);
        AppMethodBeat.o(74497);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74498);
        com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(2) });
        Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(74498);
      }
    });
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean eTG()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(4) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.yTE == null)
    {
      this.yTE = View.inflate(getContext(), 2131496250, null);
      this.DeH = ((CheckBox)this.yTE.findViewById(2131307718));
      this.DeH.setChecked(true);
    }
    if (this.DeG == null) {
      this.DeG = com.tencent.mm.ui.base.h.a(getContext(), null, this.yTE, getString(2131762554), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.modelstat.c.bgb().commitNow();
          ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            Log.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(6) });
            Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            af.bke().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(74499);
            return;
          }
          Log.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(7) });
          Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.azz() != null) && (com.tencent.mm.kernel.g.azz().iMw != null)) {
            com.tencent.mm.kernel.g.azz().iMw.fz(false);
          }
          paramAnonymousDialogInterface = new hd();
          EventCenter.instance.publish(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(74499);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74500);
          com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(5) });
          Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74500);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.DeG.show();
    }
  }
  
  private void eTH()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.g.azz();
    com.tencent.mm.ak.i local19 = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = z.aTY();
        if (ch.iFO.KI(paramAnonymousString)) {
          ch.iFO.l(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.g.azz().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.DeD = local19;
    ((com.tencent.mm.ak.t)localObject).a(282, local19);
    localObject = new com.tencent.mm.modelsimple.s();
    com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void eTI()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.g.azz();
    Object localObject2 = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
      {
        AppMethodBeat.i(74519);
        Log.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.g.azz().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousq.getType() == 255) && (((u)paramAnonymousq).jkg == 1))
            {
              if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4))
              {
                Intent localIntent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                localIntent.putExtra("kintent_hint", SettingsUI.this.getString(2131764426));
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
    this.Dax = ((com.tencent.mm.ak.i)localObject2);
    ((com.tencent.mm.ak.t)localObject1).a(255, (com.tencent.mm.ak.i)localObject2);
    localObject1 = new u(2);
    ((u)localObject1).jkg = 1;
    com.tencent.mm.kernel.g.azz().a((q)localObject1, 0);
    this.Daw = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.g.azz().a(this.DaD);
        com.tencent.mm.kernel.g.azz().b(255, SettingsUI.q(SettingsUI.this));
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
    this.Daw.startTimer(3000L);
    localObject2 = getContext();
    getString(2131755998);
    this.Dav = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131768806), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.g.azz().a(this.DaD);
        com.tencent.mm.kernel.g.azz().b(255, SettingsUI.q(SettingsUI.this));
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
  
  private void eTx()
  {
    AppMethodBeat.i(74542);
    Log.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.c.jRu.Xe();
    com.tencent.mm.kernel.g.aAh().azQ().remove(this);
    Object localObject = new ma();
    ((ma)localObject).dRA.status = 0;
    ((ma)localObject).dRA.bDZ = 0;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new ad();
    ((ad)localObject).dDb.dDc = true;
    EventCenter.instance.publish((IEvent)localObject);
    MMEntryLock.unlock("show_whatsnew");
    com.tencent.mm.kernel.l.s(this, true);
    com.tencent.mm.plugin.report.service.g.Wn(8);
    com.tencent.mm.kernel.g.aAg().azy();
    localObject = new ab();
    EventCenter.instance.publish((IEvent)localObject);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.c.jRt.o((Intent)localObject, getContext());
    com.tencent.mm.platformtools.t.Q(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void uv(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    MMEntryLock.unlock("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alc();
    }
    for (;;)
    {
      ad localad = new ad();
      localad.dDb.dDc = false;
      EventCenter.instance.publish(localad);
      com.tencent.mm.plugin.setting.c.jRu.Xc();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alb();
      finish();
      if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
        com.tencent.mm.pluginsdk.i.c.JYn.n(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().r(-1, null);
    }
  }
  
  public int getResourceId()
  {
    return 2132017266;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74535);
    setMMTitle(2131765640);
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
    this.nVN = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.nVN.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymousm.gKQ())
        {
          paramAnonymousm.aS(1, 2131762556, 2131691089);
          paramAnonymousm.aS(2, 2131762554, 2131691085);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.nVN.PGl = new e.b()
    {
      public final void onDismiss() {}
    };
    this.nVN.HLY = new o.g()
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
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsUI.this.onSetToTop();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74525);
      }
    });
    eTD();
    eSU();
    eTC();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.bmg("settings_switch_account");
    localButtonPreference.OXm = false;
    localButtonPreference.gX(getString(2131765621), getContext().getResources().getColor(2131099746));
    localButtonPreference = (ButtonPreference)this.screen.bmg("settings_logout");
    localButtonPreference.OXm = false;
    localButtonPreference.gX(getString(2131765432), getContext().getResources().getColor(2131099746));
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
        eTx();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.s.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.c.jRt.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.s.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      p.aYn();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.M(z.aTY(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.c.jRt.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.aSY(), 4, null);
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
      new n(getContext(), (String)localObject).G(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.aAh().azQ().add(this);
    com.tencent.mm.y.c.axV().a(this.DeE);
    if ((Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.aAh().azQ().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTp, Boolean.FALSE);
      Log.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.g.aAc())
    {
      com.tencent.mm.kernel.g.aAh().azQ().remove(this);
      com.tencent.mm.y.c.axV().b(this.DeE);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.azz().b(281, this.onSceneEndCallback);
    }
    if (this.Dax != null) {
      com.tencent.mm.kernel.g.azz().b(255, this.Dax);
    }
    if (this.DeI != null) {
      com.tencent.mm.kernel.g.azz().b(281, this.DeI);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.g.aAh().azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.aAh().azQ().get(2, null);
      com.tencent.mm.kernel.g.aAh().azQ().get(4, null);
    }
    if (6 == i)
    {
      eTD();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      eTB();
    }
    AppMethodBeat.o(74536);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.g.aAc()) {
      com.tencent.mm.kernel.g.aAk().postAtFrontOfQueueToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.g.aAh().azQ().gBI();
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
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class)).at(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.aAh().azQ().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTr, Boolean.FALSE);
        Log.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.y.c.axV().b(ar.a.Ogg, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    boolean bool;
    if ("settings_teen_mode".equals(paramf))
    {
      bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).pl(1);
      paramf = new Intent();
      if (!bool) {
        com.tencent.mm.br.c.b(this, "teenmode", ".ui.SettingsTeenModeIntro", paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.br.c.b(this, "teenmode", ".ui.TeenModeVerifyPwdUI", paramf);
      }
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.ay(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OaP, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OaQ, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaQ, Integer.valueOf(i));
      }
      paramf = String.format("%s,%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(21529, paramf);
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.y.c.axV().cQ(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.y.c.axV().cQ(262145, 266243);
      com.tencent.mm.y.c.axV().cQ(262157, 266262);
      com.tencent.mm.y.c.axV().cQ(262164, 266269);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.cr.d.hiy();
          AppMethodBeat.o(74527);
        }
      }, 100L);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.RbS, 0) != 1)
      {
        paramf = new Intent();
        com.tencent.mm.br.c.b(getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(74540);
        return true;
        paramf = new com.tencent.mm.plugin.appbrand.api.g();
        paramf.appId = "wxd930c3b7cf7c92e6";
        paramf.kHw = "pages/device-list/device-list.html";
        paramf.version = 0;
        paramf.iOo = 0;
        paramf.scene = 1112;
        ((r)com.tencent.mm.kernel.g.af(r.class)).a(getContext(), paramf);
      }
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.aw.b.isOverseasUser())
      {
        Log.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.h.a(getContext(), true, getResources().getString(2131765436), "", getResources().getString(2131765432), getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74509);
            SettingsUI.g(SettingsUI.this);
            AppMethodBeat.o(74509);
          }
        }, null);
        AppMethodBeat.o(74540);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11545, new Object[] { Integer.valueOf(8) });
      Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (ch.iFO.aWo().size() > 1) {
        com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), ch.iFO.aWp() });
      }
      for (;;)
      {
        this.nVN.dGm();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), ch.iFO.aWp() });
      }
    }
    if (paramf.equals("settings_exit"))
    {
      bool = eTG();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = eTF();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      com.tencent.mm.plugin.report.service.h.CyF.a(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if (WeChatBrands.AppInfo.current().isMainland()) {
        if ((!ChannelUtil.isNokiaAol) && (LocaleUtil.getApplicationLanguage().equals("zh_CN")))
        {
          paramf = getString(2131768660);
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
    for (;;)
    {
      AppMethodBeat.o(74540);
      return false;
      if (LocaleUtil.getApplicationLanguage().equals("zh_HK"))
      {
        paramf = getString(2131768661);
        break;
      }
      if (LocaleUtil.getApplicationLanguage().equals("zh_TW"))
      {
        paramf = getString(2131768662);
        break;
      }
      paramf = getString(2131768663);
      break;
      com.tencent.mm.pluginsdk.g.ce(MMApplicationContext.getContext(), "weixin://dl/feedback");
      continue;
      if (paramf.equals("settings_switch_account"))
      {
        if (ch.iFO.aWo().size() > 1) {
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), ch.iFO.aWp() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oew, true)) {
            break label1856;
          }
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oew, Boolean.FALSE);
          com.tencent.mm.ui.base.h.a(this, getString(2131765622), getString(2131765623), getString(2131755874), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74526);
              SettingsUI.e(SettingsUI.this);
              AppMethodBeat.o(74526);
            }
          });
          break;
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), ch.iFO.aWp() });
        }
        label1856:
        eTE();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.bmg("settings_account");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = z.aTY();
      ((PersonalPreference)localObject1).iKs = null;
      ((PersonalPreference)localObject1).CZh = -1;
      ((PersonalPreference)localObject1).uNR = ((String)localObject2);
      if (((PersonalPreference)localObject1).tlo != null) {
        a.b.c(((PersonalPreference)localObject1).tlo, ((PersonalPreference)localObject1).uNR);
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.RbS, 0) != 1)
    {
      localObject1 = new fb();
      EventCenter.instance.publish((IEvent)localObject1);
      if (!((fb)localObject1).dIu.dGX)
      {
        localObject1 = this.screen.bmg("settings_about_device");
        this.screen.e((Preference)localObject1);
      }
    }
    eTB();
    localObject1 = (IconSwitchKeyValuePreference)this.screen.bmg("settings_teen_mode");
    if (localObject1 == null)
    {
      Log.e("MicroMsg.SettingsUI", "updateTeenMode Preference null");
      eTD();
      eSU();
      eTC();
      localObject1 = (IconPreference)this.screen.bmg("settings_welab");
      localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).gjj()) {
        break label428;
      }
      ((IconPreference)localObject1).alD(0);
      ((IconPreference)localObject1).gY(getString(2131755915), 2131234232);
      label234:
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).gjk()) {
        break label448;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).gji()) {
        break label437;
      }
      ((IconPreference)localObject1).la(0, 2131235385);
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetPlugin.banned()) {
        this.screen.jdMethod_do("settings_welab", true);
      }
      Log.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      if (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvr())
      {
        this.screen.jdMethod_do("settings_teen_mode", true);
        Log.i("MicroMsg.SettingsUI", "need hide teen-mode entrance");
        break;
      }
      this.screen.jdMethod_do("settings_teen_mode", false);
      boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
      Log.d("MicroMsg.SettingsUI", "isTeenModeEnable :".concat(String.valueOf(bool)));
      if (bool) {
        ((IconSwitchKeyValuePreference)localObject1).setSummary(getString(2131765278));
      }
      for (;;)
      {
        ((IconSwitchKeyValuePreference)localObject1).alK(-1);
        break;
        ((IconSwitchKeyValuePreference)localObject1).setSummary(getString(2131765310));
      }
      label428:
      ((IconPreference)localObject1).alD(8);
      break label234;
      label437:
      ((IconPreference)localObject1).la(0, 2131691798);
      continue;
      label448:
      ((IconPreference)localObject1).la(8, -1);
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