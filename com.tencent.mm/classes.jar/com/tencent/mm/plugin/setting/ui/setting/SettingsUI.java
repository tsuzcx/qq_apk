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
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.eu.a;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.z;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.y.a.a;
import java.util.ArrayList;
import java.util.Set;

@com.tencent.mm.kernel.i
public class SettingsUI
  extends MMPreference
  implements n.b
{
  private au bYO;
  private au hNn;
  private com.tencent.mm.ui.widget.a.e mdB;
  private com.tencent.mm.ak.g onSceneEndCallback;
  private f screen;
  private View ukF;
  private ProgressDialog xqQ;
  private au xqR;
  private com.tencent.mm.ak.g xqS;
  private PersonalPreference xuP;
  private com.tencent.mm.ak.g xuQ;
  private a.a xuR;
  private Dialog xuS;
  private com.tencent.mm.ui.widget.a.d xuT;
  private CheckBox xuU;
  private com.tencent.mm.ak.g xuV;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.xuP = null;
    this.xqQ = null;
    this.onSceneEndCallback = null;
    this.xuQ = null;
    this.xqS = null;
    this.xuR = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(ah.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == ah.a.GQM)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.xuS = null;
    this.hNn = null;
    this.xuV = null;
    AppMethodBeat.o(74528);
  }
  
  private void dBT()
  {
    int j = 0;
    AppMethodBeat.i(74537);
    IconPreference localIconPreference = (IconPreference)this.screen.aPN("settings_about_micromsg");
    boolean bool1 = bs.a(Boolean.valueOf(com.tencent.mm.y.c.aeH().cG(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.y.c.aeH().cH(262157, 266262);
    if (com.tencent.mm.sdk.platformtools.i.GqM)
    {
      localIconPreference.fZ("", -1);
      localIconPreference.aab(8);
      bool1 = com.tencent.mm.y.c.aeH().cH(262158, 266265);
      localIconPreference = (IconPreference)this.screen.aPN("settings_about_system");
      if (!bool1) {
        break label206;
      }
      i = 0;
      label107:
      localIconPreference.aad(i);
      com.tencent.mm.plugin.newtips.a.dke();
      if (!com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmQ)) {
        break label212;
      }
    }
    label206:
    label212:
    for (int i = j;; i = 8)
    {
      localIconPreference.aad(i);
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        localIconPreference.aab(0);
        localIconPreference.fZ(getString(2131755829), 2131233430);
        break;
      }
      if (bool2)
      {
        localIconPreference.aad(0);
        break;
      }
      localIconPreference.aad(8);
      localIconPreference.fZ("", -1);
      localIconPreference.aab(8);
      break;
      i = 8;
      break label107;
    }
  }
  
  private void dCA()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.aPN("settings_account_info");
    if (localIconPreference == null)
    {
      ac.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.aag(8);
    if (com.tencent.mm.y.c.aeH().a(ah.a.GQM, 266257))
    {
      localIconPreference.aad(0);
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEB, Boolean.FALSE)).booleanValue()) {
          break label180;
        }
        if ((com.tencent.mm.kernel.g.agR().agA().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.fZ(getString(2131755829), 2131233430);
          localIconPreference.aab(0);
          ac.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.aad(8);
      break;
      label180:
      localIconPreference.aab(8);
      localIconPreference.fZ("", -1);
    }
  }
  
  private void dCB()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.aPN("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLX, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLY, Integer.valueOf(0))).intValue())
      {
        localIconPreference.aad(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.aad(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void dCC()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.aPC();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.aPN("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.iKF) && (locala != l.a.iKG)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.wX(bool);
      if ((locala != l.a.iKF) && (locala != l.a.iKG)) {
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
  
  private void dCD()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean dCE()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(1) });
    ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.xuS != null)
    {
      this.xuS.show();
      AppMethodBeat.o(74543);
      return true;
    }
    ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.xuS = com.tencent.mm.ui.base.h.d(this, getString(2131763266), "", getString(2131763262), getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(3) });
        ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(99L, 145L, 1L, false);
        if ((com.tencent.mm.kernel.g.agi() != null) && (com.tencent.mm.kernel.g.agi().hwg != null)) {
          com.tencent.mm.kernel.g.agi().hwg.eE(false);
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
        com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(2) });
        ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(74498);
      }
    });
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean dCF()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(4) });
    ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.ukF == null)
    {
      this.ukF = View.inflate(getContext(), 2131495389, null);
      this.xuU = ((CheckBox)this.ukF.findViewById(2131304666));
      this.xuU.setChecked(true);
    }
    if (this.xuT == null) {
      this.xuT = com.tencent.mm.ui.base.h.a(getContext(), null, this.ukF, getString(2131760801), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.modelstat.c.aIr().commitNow();
          ((com.tencent.mm.plugin.expt.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.e.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            ac.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(6) });
            ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            com.tencent.mm.network.ad.aLY().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(74499);
            return;
          }
          ac.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(7) });
          ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.agi() != null) && (com.tencent.mm.kernel.g.agi().hwg != null)) {
            com.tencent.mm.kernel.g.agi().hwg.eE(false);
          }
          paramAnonymousDialogInterface = new gv();
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(74499);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74500);
          com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(5) });
          ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74500);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.xuT.show();
    }
  }
  
  private void dCG()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.g.agi();
    com.tencent.mm.ak.g local19 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = u.axw();
        if (ca.hpQ.yB(paramAnonymousString)) {
          ca.hpQ.m(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.g.agi().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.xuQ = local19;
    ((com.tencent.mm.ak.q)localObject).a(282, local19);
    localObject = new r();
    com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void dCH()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.g.agi();
    Object localObject2 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(74519);
        ac.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.g.agi().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousn.getType() == 255) && (((com.tencent.mm.modelsimple.t)paramAnonymousn).hSO == 1))
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
    this.xqS = ((com.tencent.mm.ak.g)localObject2);
    ((com.tencent.mm.ak.q)localObject1).a(255, (com.tencent.mm.ak.g)localObject2);
    localObject1 = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject1).hSO = 1;
    com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
    this.xqR = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.g.agi().a(this.xqX);
        com.tencent.mm.kernel.g.agi().b(255, SettingsUI.q(SettingsUI.this));
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
    this.xqR.au(3000L, 3000L);
    localObject2 = getContext();
    getString(2131755906);
    this.xqQ = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131766295), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.g.agi().a(this.xqX);
        com.tencent.mm.kernel.g.agi().b(255, SettingsUI.q(SettingsUI.this));
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
  
  private void dCw()
  {
    AppMethodBeat.i(74542);
    ac.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.b.iyy.Lp();
    com.tencent.mm.kernel.g.agR().agA().b(this);
    Object localObject = new la();
    ((la)localObject).dmU.status = 0;
    ((la)localObject).dmU.reason = 0;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new com.tencent.mm.g.a.ab();
    ((com.tencent.mm.g.a.ab)localObject).cZr.cZs = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    am.aKP("show_whatsnew");
    com.tencent.mm.kernel.l.o(this, true);
    com.tencent.mm.plugin.report.service.g.MJ(8);
    com.tencent.mm.kernel.g.agQ().agh();
    localObject = new z();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    ai.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.b.iyx.p((Intent)localObject, getContext());
    com.tencent.mm.platformtools.t.J(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void qq(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    am.aKP("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().UQ();
    }
    for (;;)
    {
      com.tencent.mm.g.a.ab localab = new com.tencent.mm.g.a.ab();
      localab.cZr.cZs = false;
      com.tencent.mm.sdk.b.a.GpY.l(localab);
      com.tencent.mm.plugin.setting.b.iyy.Lm();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().UP();
      finish();
      if (com.tencent.mm.pluginsdk.g.e.DjW != null) {
        com.tencent.mm.pluginsdk.g.e.DjW.m(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.agR().agA()) || (i <= 0))
    {
      ac.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.agR().agA().get(2, null);
      com.tencent.mm.kernel.g.agR().agA().get(4, null);
    }
    if (6 == i)
    {
      dCC();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      dCA();
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
    this.mdB = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.mdB.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymousl.fiA())
        {
          paramAnonymousl.aJ(1, 2131760803, 2131690803);
          paramAnonymousl.aJ(2, 2131760801, 2131690799);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.mdB.Ihj = new e.b()
    {
      public final void onDismiss() {}
    };
    this.mdB.ISv = new n.d()
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
        SettingsUI.this.onSetToTop();
        AppMethodBeat.o(74525);
      }
    });
    dCC();
    dBT();
    dCB();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.aPN("settings_switch_account");
    localButtonPreference.HDK = false;
    localButtonPreference.fY(getString(2131763439), com.tencent.mm.ui.ao.aJ(getContext(), 2130968584));
    localButtonPreference = (ButtonPreference)this.screen.aPN("settings_logout");
    localButtonPreference.HDK = false;
    localButtonPreference.fY(getString(2131763262), com.tencent.mm.ui.ao.aJ(getContext(), 2130968584));
    AppMethodBeat.o(74535);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74531);
    ac.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(74531);
      return;
    case 5: 
      if (paramInt2 == -1) {
        dCw();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.b.iyx.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      p.aBh();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.K(u.axw(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.b.iyx.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.awL(), 4, null);
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
      ac.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(74531);
      return;
      new com.tencent.mm.aj.n(getContext(), (String)localObject).F(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.agR().agA().a(this);
    com.tencent.mm.y.c.aeH().a(this.xuR);
    if ((bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.agR().agA().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEz, Boolean.FALSE);
      ac.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.kernel.g.agR().agA().b(this);
      com.tencent.mm.y.c.aeH().b(this.xuR);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.agi().b(281, this.onSceneEndCallback);
    }
    if (this.xqS != null) {
      com.tencent.mm.kernel.g.agi().b(255, this.xqS);
    }
    if (this.xuV != null) {
      com.tencent.mm.kernel.g.agi().b(281, this.xuV);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.g.agM()) {
      com.tencent.mm.kernel.g.agU().aA(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.g.agR().agA().faa();
          AppMethodBeat.o(74508);
        }
      });
    }
    AppMethodBeat.o(74532);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74540);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).ad(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.agR().agA().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEB, Boolean.FALSE);
        ac.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.y.c.aeH().b(ah.a.GQM, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aj(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLX, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLY, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLY, Integer.valueOf(i));
      }
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.y.c.aeH().cI(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.y.c.aeH().cI(262145, 266243);
      com.tencent.mm.y.c.aeH().cI(262157, 266262);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      new com.tencent.mm.sdk.platformtools.ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.cq.d.fBf();
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
      if (com.tencent.mm.aw.b.aGf())
      {
        ac.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.h.a(getContext(), true, getResources().getString(2131763266), "", getResources().getString(2131763262), getString(2131755691), new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.report.service.h.wUl.f(11545, new Object[] { Integer.valueOf(8) });
      ac.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (ca.hpQ.azx().size() > 1) {
        com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), ca.hpQ.azy() });
      }
      for (;;)
      {
        this.mdB.cED();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), ca.hpQ.azy() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = dCF();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = dCE();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
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
      com.tencent.mm.plugin.report.service.h.wUl.f(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!com.tencent.mm.sdk.platformtools.i.GqM) && (com.tencent.mm.sdk.platformtools.ab.eUO().equals("zh_CN")))
      {
        paramf = getString(2131766184);
        ac.d("MicroMsg.SettingsUI", "using faq webpage");
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
      if (com.tencent.mm.sdk.platformtools.ab.eUO().equals("zh_HK"))
      {
        paramf = getString(2131766185);
        break;
      }
      if (com.tencent.mm.sdk.platformtools.ab.eUO().equals("zh_TW"))
      {
        paramf = getString(2131766186);
        break;
      }
      paramf = getString(2131766187);
      break;
      if (paramf.equals("settings_switch_account"))
      {
        if (ca.hpQ.azx().size() > 1) {
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), ca.hpQ.azy() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GPk, true)) {
            break label1603;
          }
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPk, Boolean.FALSE);
          com.tencent.mm.ui.base.h.a(this, getString(2131763440), getString(2131763441), getString(2131755793), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74526);
              SettingsUI.e(SettingsUI.this);
              AppMethodBeat.o(74526);
            }
          });
          break;
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), ca.hpQ.azy() });
        }
        label1603:
        dCD();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.aPN("settings_account");
    if (localObject1 != null)
    {
      localObject2 = u.axw();
      ((PersonalPreference)localObject1).hua = null;
      ((PersonalPreference)localObject1).xpI = -1;
      ((PersonalPreference)localObject1).ruB = ((String)localObject2);
      if (((PersonalPreference)localObject1).qTo != null) {
        a.b.c(((PersonalPreference)localObject1).qTo, ((PersonalPreference)localObject1).ruB);
      }
    }
    localObject1 = new eu();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!((eu)localObject1).deH.ddj)
    {
      localObject1 = this.screen.aPN("settings_about_device");
      this.screen.d((Preference)localObject1);
    }
    dCA();
    dCC();
    dBT();
    dCB();
    localObject1 = (IconPreference)this.screen.aPN("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).eHz())
    {
      ((IconPreference)localObject1).aab(0);
      ((IconPreference)localObject1).fZ(getString(2131755829), 2131233430);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).eHA()) {
        break label248;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).eHy()) {
        break label237;
      }
      ((IconPreference)localObject1).jB(0, 2131234447);
    }
    for (;;)
    {
      ac.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      ((IconPreference)localObject1).aab(8);
      break;
      label237:
      ((IconPreference)localObject1).jB(0, 2131691455);
      continue;
      label248:
      ((IconPreference)localObject1).jB(8, -1);
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