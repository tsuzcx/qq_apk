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
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.et.a;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.y;
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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.z.a.a;
import java.util.ArrayList;
import java.util.Set;

@com.tencent.mm.kernel.i
public class SettingsUI
  extends MMPreference
  implements n.b
{
  private av cbR;
  private av hmK;
  private com.tencent.mm.ui.widget.a.e lBF;
  private com.tencent.mm.al.g onSceneEndCallback;
  private f screen;
  private View tcq;
  private ProgressDialog wfA;
  private av wfB;
  private com.tencent.mm.al.g wfC;
  private com.tencent.mm.al.g wjA;
  private a.a wjB;
  private Dialog wjC;
  private com.tencent.mm.ui.widget.a.d wjD;
  private CheckBox wjE;
  private com.tencent.mm.al.g wjF;
  private PersonalPreference wjz;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.wjz = null;
    this.wfA = null;
    this.onSceneEndCallback = null;
    this.wjA = null;
    this.wfC = null;
    this.wjB = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(ae.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == ae.a.FsT)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.wjC = null;
    this.hmK = null;
    this.wjF = null;
    AppMethodBeat.o(74528);
  }
  
  private void dnM()
  {
    int j = 0;
    AppMethodBeat.i(74537);
    IconPreference localIconPreference = (IconPreference)this.screen.aKk("settings_about_micromsg");
    boolean bool1 = bt.a(Boolean.valueOf(com.tencent.mm.z.c.adr().cI(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.z.c.adr().cJ(262157, 266262);
    if (com.tencent.mm.sdk.platformtools.i.ETz)
    {
      localIconPreference.fV("", -1);
      localIconPreference.XQ(8);
      bool1 = com.tencent.mm.z.c.adr().cJ(262158, 266265);
      localIconPreference = (IconPreference)this.screen.aKk("settings_about_system");
      if (!bool1) {
        break label206;
      }
      i = 0;
      label107:
      localIconPreference.XS(i);
      com.tencent.mm.plugin.newtips.a.cWv();
      if (!com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udR)) {
        break label212;
      }
    }
    label206:
    label212:
    for (int i = j;; i = 8)
    {
      localIconPreference.XS(i);
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        localIconPreference.XQ(0);
        localIconPreference.fV(getString(2131755829), 2131233430);
        break;
      }
      if (bool2)
      {
        localIconPreference.XS(0);
        break;
      }
      localIconPreference.XS(8);
      localIconPreference.fV("", -1);
      localIconPreference.XQ(8);
      break;
      i = 8;
      break label107;
    }
  }
  
  private void dom()
  {
    AppMethodBeat.i(74542);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.b.hYu.Lr();
    com.tencent.mm.kernel.g.afB().afk().b(this);
    Object localObject = new kr();
    ((kr)localObject).dpk.status = 0;
    ((kr)localObject).dpk.bvJ = 0;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new aa();
    ((aa)localObject).dbS.dbT = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    an.aFy("show_whatsnew");
    com.tencent.mm.kernel.l.o(this, true);
    com.tencent.mm.plugin.report.service.g.KK(8);
    com.tencent.mm.kernel.g.afA().aeR();
    localObject = new y();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.b.hYt.p((Intent)localObject, getContext());
    com.tencent.mm.platformtools.t.I(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void doq()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.aKk("settings_account_info");
    if (localIconPreference == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.XV(8);
    if (com.tencent.mm.z.c.adr().a(ae.a.FsT, 266257))
    {
      localIconPreference.XS(0);
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgN, Boolean.FALSE)).booleanValue()) {
          break label180;
        }
        if ((com.tencent.mm.kernel.g.afB().afk().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.fV(getString(2131755829), 2131233430);
          localIconPreference.XQ(0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.XS(8);
      break;
      label180:
      localIconPreference.XQ(8);
      localIconPreference.fV("", -1);
    }
  }
  
  private void dor()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.aKk("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Foi, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Foj, Integer.valueOf(0))).intValue())
      {
        localIconPreference.XS(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.XS(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void dos()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.aIL();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.aKk("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.iky) && (locala != l.a.ikz)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.vT(bool);
      if ((locala != l.a.iky) && (locala != l.a.ikz)) {
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
  
  private void dot()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean dou()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.wjC != null)
    {
      this.wjC.show();
      AppMethodBeat.o(74543);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.wjC = com.tencent.mm.ui.base.h.d(this, getString(2131763266), "", getString(2131763262), getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(99L, 145L, 1L, false);
        if ((com.tencent.mm.kernel.g.aeS() != null) && (com.tencent.mm.kernel.g.aeS().gVH != null)) {
          com.tencent.mm.kernel.g.aeS().gVH.ej(false);
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
        com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(74498);
      }
    });
    AppMethodBeat.o(74543);
    return true;
  }
  
  private boolean dov()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(4) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.tcq == null)
    {
      this.tcq = View.inflate(getContext(), 2131495389, null);
      this.wjE = ((CheckBox)this.tcq.findViewById(2131304666));
      this.wjE.setChecked(true);
    }
    if (this.wjD == null) {
      this.wjD = com.tencent.mm.ui.base.h.a(getContext(), null, this.tcq, getString(2131760801), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.modelstat.c.aBB().commitNow();
          ((com.tencent.mm.plugin.expt.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.e.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            com.tencent.mm.network.ad.aFh().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(74499);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.aeS() != null) && (com.tencent.mm.kernel.g.aeS().gVH != null)) {
            com.tencent.mm.kernel.g.aeS().gVH.ej(false);
          }
          paramAnonymousDialogInterface = new gu();
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(74499);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74500);
          com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(5) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74500);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.wjD.show();
    }
  }
  
  private void dow()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.g.aeS();
    com.tencent.mm.al.g local19 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = u.aqG();
        if (ca.gPq.uv(paramAnonymousString)) {
          ca.gPq.m(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.g.aeS().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.wjA = local19;
    ((com.tencent.mm.al.q)localObject).a(282, local19);
    localObject = new r();
    com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void dox()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.g.aeS();
    Object localObject2 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(74519);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.g.aeS().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousn.getType() == 255) && (((com.tencent.mm.modelsimple.t)paramAnonymousn).hsm == 1))
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
    this.wfC = ((com.tencent.mm.al.g)localObject2);
    ((com.tencent.mm.al.q)localObject1).a(255, (com.tencent.mm.al.g)localObject2);
    localObject1 = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject1).hsm = 1;
    com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
    this.wfB = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.g.aeS().a(this.wfH);
        com.tencent.mm.kernel.g.aeS().b(255, SettingsUI.q(SettingsUI.this));
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
    this.wfB.av(3000L, 3000L);
    localObject2 = getContext();
    getString(2131755906);
    this.wfA = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131766295), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.g.aeS().a(this.wfH);
        com.tencent.mm.kernel.g.aeS().b(255, SettingsUI.q(SettingsUI.this));
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
  
  private void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    an.aFy("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().TV();
    }
    for (;;)
    {
      aa localaa = new aa();
      localaa.dbS.dbT = false;
      com.tencent.mm.sdk.b.a.ESL.l(localaa);
      com.tencent.mm.plugin.setting.b.hYu.Lo();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().TU();
      finish();
      if (com.tencent.mm.pluginsdk.g.e.BRG != null) {
        com.tencent.mm.pluginsdk.g.e.BRG.m(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = bt.i(paramObject, 0);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.afB().afk().get(2, null);
      com.tencent.mm.kernel.g.afB().afk().get(4, null);
    }
    if (6 == i)
    {
      dos();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      doq();
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
    this.lBF = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.lBF.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymousl.eSQ())
        {
          paramAnonymousl.aI(1, 2131760803, 2131690803);
          paramAnonymousl.aI(2, 2131760801, 2131690799);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.lBF.GHn = new e.b()
    {
      public final void onDismiss() {}
    };
    this.lBF.HrY = new n.d()
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
    dos();
    dnM();
    dor();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.aKk("settings_switch_account");
    localButtonPreference.GdV = false;
    localButtonPreference.fU(getString(2131763439), ao.aD(getContext(), 2130968584));
    localButtonPreference = (ButtonPreference)this.screen.aKk("settings_logout");
    localButtonPreference.GdV = false;
    localButtonPreference.fU(getString(2131763262), ao.aD(getContext(), 2130968584));
    AppMethodBeat.o(74535);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74531);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(74531);
      return;
    case 5: 
      if (paramInt2 == -1) {
        dom();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.b.hYt.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      p.auq();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.J(u.aqG(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.b.hYt.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.apW(), 4, null);
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(74531);
      return;
      new com.tencent.mm.ak.n(getContext(), (String)localObject).D(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.afB().afk().a(this);
    com.tencent.mm.z.c.adr().a(this.wjB);
    if ((bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.afB().afk().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgL, Boolean.FALSE);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.g.afw())
    {
      com.tencent.mm.kernel.g.afB().afk().b(this);
      com.tencent.mm.z.c.adr().b(this.wjB);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.aeS().b(281, this.onSceneEndCallback);
    }
    if (this.wfC != null) {
      com.tencent.mm.kernel.g.aeS().b(255, this.wfC);
    }
    if (this.wjF != null) {
      com.tencent.mm.kernel.g.aeS().b(281, this.wjF);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.g.afw()) {
      com.tencent.mm.kernel.g.afE().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.g.afB().afk().eKy();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).P(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.afB().afk().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgN, Boolean.FALSE);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.z.c.adr().b(ae.a.FsT, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.V(this, paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Foi, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Foj, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Foj, Integer.valueOf(i));
      }
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.z.c.adr().cK(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.z.c.adr().cK(262145, 266243);
      com.tencent.mm.z.c.adr().cK(262157, 266262);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.cr.d.fkP();
          AppMethodBeat.o(74527);
        }
      }, 100L);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new Intent();
      com.tencent.mm.bs.d.b(getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramf);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.ax.b.azo())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "oversea user logout");
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
      com.tencent.mm.plugin.report.service.h.vKh.f(11545, new Object[] { Integer.valueOf(8) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (ca.gPq.asG().size() > 1) {
        com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), ca.gPq.asH() });
      }
      for (;;)
      {
        this.lBF.csG();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), ca.gPq.asH() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = dov();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = dou();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
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
      com.tencent.mm.plugin.report.service.h.vKh.f(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!com.tencent.mm.sdk.platformtools.i.ETz) && (ac.eFu().equals("zh_CN")))
      {
        paramf = getString(2131766184);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsUI", "using faq webpage");
        paramPreference = new Intent();
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("show_feedback", false);
        paramPreference.putExtra("KShowFixToolsBtn", true);
        com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74540);
      return false;
      if (ac.eFu().equals("zh_HK"))
      {
        paramf = getString(2131766185);
        break;
      }
      if (ac.eFu().equals("zh_TW"))
      {
        paramf = getString(2131766186);
        break;
      }
      paramf = getString(2131766187);
      break;
      if (paramf.equals("settings_switch_account"))
      {
        if (ca.gPq.asG().size() > 1) {
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), ca.gPq.asH() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fru, true)) {
            break label1603;
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fru, Boolean.FALSE);
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
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), ca.gPq.asH() });
        }
        label1603:
        dot();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.aKk("settings_account");
    if (localObject1 != null)
    {
      localObject2 = u.aqG();
      ((PersonalPreference)localObject1).gTB = null;
      ((PersonalPreference)localObject1).weu = -1;
      ((PersonalPreference)localObject1).qDs = ((String)localObject2);
      if (((PersonalPreference)localObject1).qkM != null) {
        a.b.c(((PersonalPreference)localObject1).qkM, ((PersonalPreference)localObject1).qDs);
      }
    }
    localObject1 = new et();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!((et)localObject1).dhm.dfO)
    {
      localObject1 = this.screen.aKk("settings_about_device");
      this.screen.d((Preference)localObject1);
    }
    doq();
    dos();
    dnM();
    dor();
    localObject1 = (IconPreference)this.screen.aKk("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).esf())
    {
      ((IconPreference)localObject1).XQ(0);
      ((IconPreference)localObject1).fV(getString(2131755829), 2131233430);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).esg()) {
        break label248;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).ese()) {
        break label237;
      }
      ((IconPreference)localObject1).jp(0, 2131234447);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      ((IconPreference)localObject1).XQ(8);
      break;
      label237:
      ((IconPreference)localObject1).jp(0, 2131691455);
      continue;
      label248:
      ((IconPreference)localObject1).jp(8, -1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */