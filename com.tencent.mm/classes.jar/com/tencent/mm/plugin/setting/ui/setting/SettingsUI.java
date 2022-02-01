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
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ey.a;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.y.a.a;
import java.util.ArrayList;
import java.util.Set;

@i
public class SettingsUI
  extends MMPreference
  implements n.b
{
  private aw cji;
  private aw ijv;
  private com.tencent.mm.ui.widget.a.e mIQ;
  private com.tencent.mm.ak.f onSceneEndCallback;
  private com.tencent.mm.ui.base.preference.f screen;
  private View vzq;
  private ProgressDialog yVG;
  private aw yVH;
  private com.tencent.mm.ak.f yVI;
  private PersonalPreference yZK;
  private com.tencent.mm.ak.f yZL;
  private a.a yZM;
  private Dialog yZN;
  private com.tencent.mm.ui.widget.a.d yZO;
  private CheckBox yZP;
  private com.tencent.mm.ak.f yZQ;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.yZK = null;
    this.yVG = null;
    this.onSceneEndCallback = null;
    this.yZL = null;
    this.yVI = null;
    this.yZM = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158) || (paramAnonymousInt == 262164)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(am.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == am.a.IXJ)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.yZN = null;
    this.ijv = null;
    this.yZQ = null;
    AppMethodBeat.o(74528);
  }
  
  private void dQT()
  {
    int j = 0;
    AppMethodBeat.i(74537);
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_about_micromsg");
    boolean bool1 = bu.a(Boolean.valueOf(com.tencent.mm.y.c.ahI().cI(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262157, 266262);
    boolean bool3 = com.tencent.mm.y.c.ahI().cJ(262164, 266269);
    if (k.IwL)
    {
      localIconPreference.gF("", -1);
      localIconPreference.acS(8);
      bool1 = com.tencent.mm.y.c.ahI().cJ(262158, 266265);
      localIconPreference = (IconPreference)this.screen.aXe("settings_about_system");
      if (!bool1) {
        break label270;
      }
      i = 0;
      label119:
      localIconPreference.acU(i);
      com.tencent.mm.plugin.newtips.a.dxG();
      if (!com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR)) {
        break label276;
      }
    }
    label270:
    label276:
    for (int i = j;; i = 8)
    {
      localIconPreference.acU(i);
      com.tencent.mm.cc.c.flS();
      localIconPreference.acU(8);
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        localIconPreference.acS(0);
        localIconPreference.gF(getString(2131755829), 2131233430);
        break;
      }
      if (bool2)
      {
        localIconPreference.acU(0);
        break;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot())
      {
        localIconPreference.acU(0);
        break;
      }
      if (bool3)
      {
        localIconPreference.acU(0);
        break;
      }
      localIconPreference.acU(8);
      localIconPreference.gF("", -1);
      localIconPreference.acS(8);
      break;
      i = 8;
      break label119;
    }
  }
  
  private void dRA()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_account_info");
    if (localIconPreference == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.acX(8);
    if (com.tencent.mm.y.c.ahI().a(am.a.IXJ, 266257))
    {
      localIconPreference.acU(0);
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILq, Boolean.FALSE)).booleanValue()) {
          break label181;
        }
        if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.gF(getString(2131755829), 2131233430);
          localIconPreference.acS(0);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.acU(8);
      break;
      label181:
      localIconPreference.acS(8);
      localIconPreference.gF("", -1);
    }
  }
  
  private void dRB()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISN, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISO, Integer.valueOf(0))).intValue())
      {
        localIconPreference.acU(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.acU(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void dRC()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.aTn();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.aXe("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.jgH) && (locala != l.a.jgI)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.xP(bool);
      if ((locala != l.a.jgH) && (locala != l.a.jgI)) {
        break label90;
      }
    }
    label85:
    label90:
    for (int i = 2131763357;; i = 2131763356)
    {
      localSwitchKeyValuePreference.setSummary(i);
      AppMethodBeat.o(74539);
      return;
      bool = false;
      break;
    }
  }
  
  private void dRD()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean dRE()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.yZN != null)
    {
      this.yZN.show();
      AppMethodBeat.o(74543);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.yZN = h.e(this, getString(2131763266), "", getString(2131763262), getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(99L, 145L, 1L, false);
        if ((com.tencent.mm.kernel.g.ajj() != null) && (com.tencent.mm.kernel.g.ajj().hRo != null)) {
          com.tencent.mm.kernel.g.ajj().hRo.eI(false);
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
        com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(74498);
      }
    });
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean dRF()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(4) });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.vzq == null)
    {
      this.vzq = View.inflate(getContext(), 2131495389, null);
      this.yZP = ((CheckBox)this.vzq.findViewById(2131304666));
      this.yZP.setChecked(true);
    }
    if (this.yZO == null) {
      this.yZO = h.a(getContext(), null, this.vzq, getString(2131760801), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.modelstat.c.aLY().commitNow();
          ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            com.tencent.mm.network.ad.aPD().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(74499);
            return;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.ajj() != null) && (com.tencent.mm.kernel.g.ajj().hRo != null)) {
            com.tencent.mm.kernel.g.ajj().hRo.eI(false);
          }
          paramAnonymousDialogInterface = new gz();
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(74499);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74500);
          com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(5) });
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74500);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.yZO.show();
    }
  }
  
  private void dRG()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.g.ajj();
    com.tencent.mm.ak.f local19 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = v.aAC();
        if (cd.hLa.Cc(paramAnonymousString)) {
          cd.hLa.l(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.g.ajj().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.yZL = local19;
    ((com.tencent.mm.ak.q)localObject).a(282, local19);
    localObject = new s();
    com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void dRH()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.g.ajj();
    Object localObject2 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(74519);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.g.ajj().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousn.getType() == 255) && (((u)paramAnonymousn).ioZ == 1))
            {
              if ((paramAnonymousInt2 == -3) && (paramAnonymousInt1 == 4))
              {
                Intent localIntent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                localIntent.putExtra("kintent_hint", SettingsUI.this.getString(2131762360));
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
    this.yVI = ((com.tencent.mm.ak.f)localObject2);
    ((com.tencent.mm.ak.q)localObject1).a(255, (com.tencent.mm.ak.f)localObject2);
    localObject1 = new u(2);
    ((u)localObject1).ioZ = 1;
    com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
    this.yVH = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.g.ajj().a(this.yVP);
        com.tencent.mm.kernel.g.ajj().b(255, SettingsUI.q(SettingsUI.this));
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
    this.yVH.ay(3000L, 3000L);
    localObject2 = getContext();
    getString(2131755906);
    this.yVG = h.b((Context)localObject2, getString(2131766295), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.g.ajj().a(this.yVP);
        com.tencent.mm.kernel.g.ajj().b(255, SettingsUI.q(SettingsUI.this));
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
  
  private void dRw()
  {
    AppMethodBeat.i(74542);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.c.iUA.MS();
    com.tencent.mm.kernel.g.ajR().ajA().b(this);
    Object localObject = new lk();
    ((lk)localObject).dzN.status = 0;
    ((lk)localObject).dzN.reason = 0;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new ab();
    ((ab)localObject).dlL.dlM = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    ao.aRS("show_whatsnew");
    com.tencent.mm.kernel.l.q(this, true);
    com.tencent.mm.plugin.report.service.f.OR(8);
    com.tencent.mm.kernel.g.ajQ().aji();
    localObject = new z();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    ak.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.c.iUz.p((Intent)localObject, getContext());
    t.J(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    ao.aRS("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xp();
    }
    for (;;)
    {
      ab localab = new ab();
      localab.dlL.dlM = false;
      com.tencent.mm.sdk.b.a.IvT.l(localab);
      com.tencent.mm.plugin.setting.c.iUA.MP();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xo();
      finish();
      if (com.tencent.mm.pluginsdk.i.f.Fhu != null) {
        com.tencent.mm.pluginsdk.i.f.Fhu.m(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = bu.m(paramObject, 0);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajR().ajA()) || (i <= 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.ajR().ajA().get(2, null);
      com.tencent.mm.kernel.g.ajR().ajA().get(4, null);
    }
    if (6 == i)
    {
      dRC();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      dRA();
    }
    AppMethodBeat.o(74536);
  }
  
  public int getResourceId()
  {
    return 2131951721;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74535);
    setMMTitle(2131763457);
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
    this.mIQ = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.mIQ.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymousl.fCR())
        {
          paramAnonymousl.aM(1, 2131760803, 2131690803);
          paramAnonymousl.aM(2, 2131760801, 2131690799);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.mIQ.KtV = new e.b()
    {
      public final void onDismiss() {}
    };
    this.mIQ.LfT = new n.e()
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
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SettingsUI.this.onSetToTop();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74525);
      }
    });
    dRC();
    dQT();
    dRB();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.aXe("settings_switch_account");
    localButtonPreference.JMp = false;
    localButtonPreference.gE(getString(2131763439), getContext().getResources().getColor(2131099732));
    localButtonPreference = (ButtonPreference)this.screen.aXe("settings_logout");
    localButtonPreference.JMp = false;
    localButtonPreference.gE(getString(2131763262), getContext().getResources().getColor(2131099732));
    AppMethodBeat.o(74535);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74531);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(74531);
      return;
    case 5: 
      if (paramInt2 == -1) {
        dRw();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.c.iUz.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      p.aEA();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.K(v.aAC(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.c.iUz.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.azQ(), 4, null);
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(74531);
      return;
      new com.tencent.mm.aj.n(getContext(), (String)localObject).C(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.ajR().ajA().a(this);
    com.tencent.mm.y.c.ahI().a(this.yZM);
    if ((bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.ajR().ajA().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILo, Boolean.FALSE);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.g.ajM())
    {
      com.tencent.mm.kernel.g.ajR().ajA().b(this);
      com.tencent.mm.y.c.ahI().b(this.yZM);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.ajj().b(281, this.onSceneEndCallback);
    }
    if (this.yVI != null) {
      com.tencent.mm.kernel.g.ajj().b(255, this.yVI);
    }
    if (this.yZQ != null) {
      com.tencent.mm.kernel.g.ajj().b(281, this.yZQ);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.g.ajM()) {
      com.tencent.mm.kernel.g.ajU().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.g.ajR().ajA().fuc();
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).af(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.ajR().ajA().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILq, Boolean.FALSE);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.y.c.ahI().b(am.a.IXJ, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.al(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISN, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISO, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISO, Integer.valueOf(i));
      }
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.y.c.ahI().cK(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.y.c.ahI().cK(262145, 266243);
      com.tencent.mm.y.c.ahI().cK(262157, 266262);
      com.tencent.mm.y.c.ahI().cK(262164, 266269);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.cp.d.fWU();
          AppMethodBeat.o(74527);
        }
      }, 100L);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new Intent();
      com.tencent.mm.br.d.b(getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.aw.b.aJG())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "oversea user logout");
        h.a(getContext(), true, getResources().getString(2131763266), "", getResources().getString(2131763262), getString(2131755691), new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.report.service.g.yxI.f(11545, new Object[] { Integer.valueOf(8) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (cd.hLa.aCQ().size() > 1) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), cd.hLa.aCR() });
      }
      for (;;)
      {
        this.mIQ.cPF();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), cd.hLa.aCR() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = dRF();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = dRE();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
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
      com.tencent.mm.plugin.report.service.g.yxI.f(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!k.IwL) && (com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_CN")))
      {
        paramf = getString(2131766184);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsUI", "using faq webpage");
        paramPreference = new Intent();
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("show_feedback", false);
        paramPreference.putExtra("KShowFixToolsBtn", true);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74540);
      return false;
      if (com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_HK"))
      {
        paramf = getString(2131766185);
        break;
      }
      if (com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_TW"))
      {
        paramf = getString(2131766186);
        break;
      }
      paramf = getString(2131766187);
      break;
      if (paramf.equals("settings_switch_account"))
      {
        if (cd.hLa.aCQ().size() > 1) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), cd.hLa.aCR() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IWe, true)) {
            break label1627;
          }
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWe, Boolean.FALSE);
          h.a(this, getString(2131763440), getString(2131763441), getString(2131755793), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74526);
              SettingsUI.e(SettingsUI.this);
              AppMethodBeat.o(74526);
            }
          });
          break;
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), cd.hLa.aCR() });
        }
        label1627:
        dRD();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.aXe("settings_account");
    if (localObject1 != null)
    {
      localObject2 = v.aAC();
      ((PersonalPreference)localObject1).hPl = null;
      ((PersonalPreference)localObject1).yUq = -1;
      ((PersonalPreference)localObject1).ssR = ((String)localObject2);
      if (((PersonalPreference)localObject1).rLC != null) {
        a.b.c(((PersonalPreference)localObject1).rLC, ((PersonalPreference)localObject1).ssR);
      }
    }
    localObject1 = new ey();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!((ey)localObject1).dri.dpK)
    {
      localObject1 = this.screen.aXe("settings_about_device");
      this.screen.d((Preference)localObject1);
    }
    dRA();
    dRC();
    dQT();
    dRB();
    localObject1 = (IconPreference)this.screen.aXe("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).fae())
    {
      ((IconPreference)localObject1).acS(0);
      ((IconPreference)localObject1).gF(getString(2131755829), 2131233430);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).faf()) {
        break label249;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).fad()) {
        break label238;
      }
      ((IconPreference)localObject1).jR(0, 2131234447);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      ((IconPreference)localObject1).acS(8);
      break;
      label238:
      ((IconPreference)localObject1).jR(0, 2131691455);
      continue;
      label249:
      ((IconPreference)localObject1).jR(8, -1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */