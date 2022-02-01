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
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ex.a;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
import com.tencent.mm.z.a.a;
import java.util.ArrayList;
import java.util.Set;

@i
public class SettingsUI
  extends MMPreference
  implements n.b
{
  private av cjg;
  private av igC;
  private com.tencent.mm.ui.widget.a.e mDL;
  private com.tencent.mm.al.f onSceneEndCallback;
  private com.tencent.mm.ui.base.preference.f screen;
  private View vnl;
  private ProgressDialog yFx;
  private av yFy;
  private com.tencent.mm.al.f yFz;
  private PersonalPreference yJA;
  private com.tencent.mm.al.f yJB;
  private a.a yJC;
  private Dialog yJD;
  private com.tencent.mm.ui.widget.a.d yJE;
  private CheckBox yJF;
  private com.tencent.mm.al.f yJG;
  
  public SettingsUI()
  {
    AppMethodBeat.i(74528);
    this.yJA = null;
    this.yFx = null;
    this.onSceneEndCallback = null;
    this.yJB = null;
    this.yFz = null;
    this.yJC = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(74495);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 262158)) {
          SettingsUI.a(SettingsUI.this);
        }
        AppMethodBeat.o(74495);
      }
      
      public final void b(al.a paramAnonymousa)
      {
        AppMethodBeat.i(74496);
        if ((paramAnonymousa != null) && (paramAnonymousa == al.a.IDj)) {
          SettingsUI.b(SettingsUI.this);
        }
        AppMethodBeat.o(74496);
      }
    };
    this.yJD = null;
    this.igC = null;
    this.yJG = null;
    AppMethodBeat.o(74528);
  }
  
  private void dNZ()
  {
    AppMethodBeat.i(74542);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.b.iRH.MX();
    com.tencent.mm.kernel.g.ajC().ajl().b(this);
    Object localObject = new lj();
    ((lj)localObject).dyI.status = 0;
    ((lj)localObject).dyI.reason = 0;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new ab();
    ((ab)localObject).dkJ.dkK = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    an.aQv("show_whatsnew");
    com.tencent.mm.kernel.l.q(this, true);
    com.tencent.mm.plugin.report.service.f.Ol(8);
    com.tencent.mm.kernel.g.ajB().aiT();
    localObject = new z();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.b.iRG.p((Intent)localObject, getContext());
    com.tencent.mm.platformtools.t.I(this, null);
    finish();
    AppMethodBeat.o(74542);
  }
  
  private void dNw()
  {
    int j = 0;
    AppMethodBeat.i(74537);
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("settings_about_micromsg");
    boolean bool1 = bt.a(Boolean.valueOf(com.tencent.mm.z.c.aht().cI(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.z.c.aht().cJ(262157, 266262);
    if (j.IcA)
    {
      localIconPreference.gw("", -1);
      localIconPreference.acl(8);
      bool1 = com.tencent.mm.z.c.aht().cJ(262158, 266265);
      localIconPreference = (IconPreference)this.screen.aVD("settings_about_system");
      if (!bool1) {
        break label256;
      }
      i = 0;
      label117:
      localIconPreference.acn(i);
      com.tencent.mm.plugin.newtips.a.duq();
      if (!com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsi)) {
        break label262;
      }
    }
    label256:
    label262:
    for (int i = j;; i = 8)
    {
      localIconPreference.acn(i);
      com.tencent.mm.cd.c.fia();
      localIconPreference.acn(8);
      AppMethodBeat.o(74537);
      return;
      if (bool1)
      {
        localIconPreference.acl(0);
        localIconPreference.gw(getString(2131755829), 2131233430);
        break;
      }
      if (bool2)
      {
        localIconPreference.acn(0);
        break;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot())
      {
        localIconPreference.acn(0);
        break;
      }
      localIconPreference.acn(8);
      localIconPreference.gw("", -1);
      localIconPreference.acl(8);
      break;
      i = 8;
      break label117;
    }
  }
  
  private void dOd()
  {
    AppMethodBeat.i(74534);
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("settings_account_info");
    if (localIconPreference == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(74534);
      return;
    }
    localIconPreference.acq(8);
    if (com.tencent.mm.z.c.aht().a(al.a.IDj, 266257))
    {
      localIconPreference.acn(0);
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IqU, Boolean.FALSE)).booleanValue()) {
          break label179;
        }
        if ((com.tencent.mm.kernel.g.ajC().ajl().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.gw(getString(2131755829), 2131233430);
          localIconPreference.acl(0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74534);
      return;
      localIconPreference.acn(8);
      break;
      label179:
      localIconPreference.acl(8);
      localIconPreference.gw("", -1);
    }
  }
  
  private void dOe()
  {
    AppMethodBeat.i(74538);
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyp, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyq, Integer.valueOf(0))).intValue())
      {
        localIconPreference.acn(0);
        AppMethodBeat.o(74538);
        return;
      }
      localIconPreference.acn(8);
    }
    AppMethodBeat.o(74538);
  }
  
  private void dOf()
  {
    AppMethodBeat.i(74539);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.aSO();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.aVD("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.jdO) && (locala != l.a.jdP)) {
        break label85;
      }
      bool = true;
      localSwitchKeyValuePreference.xI(bool);
      if ((locala != l.a.jdO) && (locala != l.a.jdP)) {
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
  
  private void dOg()
  {
    AppMethodBeat.i(74541);
    Object localObject = new Intent(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).putExtra("key_scene", 0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74541);
  }
  
  private boolean dOh()
  {
    AppMethodBeat.i(74543);
    com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.yJD != null)
    {
      this.yJD.show();
      AppMethodBeat.o(74543);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.yJD = h.e(this, getString(2131763266), "", getString(2131763262), getString(2131763265), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74497);
        com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(99L, 145L, 1L, false);
        if ((com.tencent.mm.kernel.g.aiU() != null) && (com.tencent.mm.kernel.g.aiU().hOv != null)) {
          com.tencent.mm.kernel.g.aiU().hOv.eG(false);
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
        com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(2) });
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
  
  private boolean dOi()
  {
    AppMethodBeat.i(74544);
    com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(4) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.vnl == null)
    {
      this.vnl = View.inflate(getContext(), 2131495389, null);
      this.yJF = ((CheckBox)this.vnl.findViewById(2131304666));
      this.yJF.setChecked(true);
    }
    if (this.yJE == null) {
      this.yJE = h.a(getContext(), null, this.vnl, getString(2131760801), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74499);
          com.tencent.mm.modelstat.c.aLB().commitNow();
          ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            com.tencent.mm.network.ad.aPf().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(74499);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.aiU() != null) && (com.tencent.mm.kernel.g.aiU().hOv != null)) {
            com.tencent.mm.kernel.g.aiU().hOv.eG(false);
          }
          paramAnonymousDialogInterface = new gy();
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(74499);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74500);
          com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(5) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
          AppMethodBeat.o(74500);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(74544);
      return true;
      this.yJE.show();
    }
  }
  
  private void dOj()
  {
    AppMethodBeat.i(74545);
    Object localObject = com.tencent.mm.kernel.g.aiU();
    com.tencent.mm.al.f local19 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(74517);
        paramAnonymousString = u.aAm();
        if (cb.hIi.BA(paramAnonymousString)) {
          cb.hIi.l(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74516);
            com.tencent.mm.kernel.g.aiU().b(282, SettingsUI.v(SettingsUI.this));
            SettingsUI.y(SettingsUI.this);
            AppMethodBeat.o(74516);
          }
        });
        AppMethodBeat.o(74517);
      }
    };
    this.yJB = local19;
    ((com.tencent.mm.al.q)localObject).a(282, local19);
    localObject = new r();
    com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(74545);
  }
  
  private void dOk()
  {
    AppMethodBeat.i(74547);
    Object localObject1 = com.tencent.mm.kernel.g.aiU();
    Object localObject2 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(74519);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsUI", "onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74518);
            com.tencent.mm.kernel.g.aiU().b(255, SettingsUI.q(SettingsUI.this));
            SettingsUI.r(SettingsUI.this);
            if (SettingsUI.s(SettingsUI.this) != null)
            {
              SettingsUI.s(SettingsUI.this).stopTimer();
              SettingsUI.t(SettingsUI.this);
            }
            if (SettingsUI.o(SettingsUI.this) != null) {
              SettingsUI.o(SettingsUI.this).dismiss();
            }
            if ((paramAnonymousn.getType() == 255) && (((com.tencent.mm.modelsimple.t)paramAnonymousn).imf == 1))
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
    this.yFz = ((com.tencent.mm.al.f)localObject2);
    ((com.tencent.mm.al.q)localObject1).a(255, (com.tencent.mm.al.f)localObject2);
    localObject1 = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject1).imf = 1;
    com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
    this.yFy = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74520);
        com.tencent.mm.kernel.g.aiU().a(this.yFG);
        com.tencent.mm.kernel.g.aiU().b(255, SettingsUI.q(SettingsUI.this));
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
    this.yFy.az(3000L, 3000L);
    localObject2 = getContext();
    getString(2131755906);
    this.yFx = h.b((Context)localObject2, getString(2131766295), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(74521);
        com.tencent.mm.kernel.g.aiU().a(this.yFG);
        com.tencent.mm.kernel.g.aiU().b(255, SettingsUI.q(SettingsUI.this));
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
  
  private void qS(boolean paramBoolean)
  {
    AppMethodBeat.i(74546);
    an.aQv("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xh();
    }
    for (;;)
    {
      ab localab = new ab();
      localab.dkJ.dkK = false;
      com.tencent.mm.sdk.b.a.IbL.l(localab);
      com.tencent.mm.plugin.setting.b.iRH.MU();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xg();
      finish();
      if (com.tencent.mm.pluginsdk.i.f.EOZ != null) {
        com.tencent.mm.pluginsdk.i.f.EOZ.m(getContext(), paramBoolean);
      }
      AppMethodBeat.o(74546);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74536);
    int i = bt.m(paramObject, 0);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajC().ajl()) || (i <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74536);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.ajC().ajl().get(2, null);
      com.tencent.mm.kernel.g.ajC().ajl().get(4, null);
    }
    if (6 == i)
    {
      dOf();
      AppMethodBeat.o(74536);
      return;
    }
    if (64 == i) {
      dOd();
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
    this.mDL = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.mDL.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(74523);
        if (paramAnonymousl.fyP())
        {
          paramAnonymousl.aL(1, 2131760803, 2131690803);
          paramAnonymousl.aL(2, 2131760801, 2131690799);
        }
        AppMethodBeat.o(74523);
      }
    };
    this.mDL.JXC = new e.b()
    {
      public final void onDismiss() {}
    };
    this.mDL.KJz = new n.e()
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SettingsUI.this.onSetToTop();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74525);
      }
    });
    dOf();
    dNw();
    dOe();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.aVD("settings_switch_account");
    localButtonPreference.JrA = false;
    localButtonPreference.gv(getString(2131763439), getContext().getResources().getColor(2131099732));
    localButtonPreference = (ButtonPreference)this.screen.aVD("settings_logout");
    localButtonPreference.JrA = false;
    localButtonPreference.gv(getString(2131763262), getContext().getResources().getColor(2131099732));
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
        dNZ();
      }
      AppMethodBeat.o(74531);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azA());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.b.iRG.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(74531);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azA());
      if (localObject == null)
      {
        AppMethodBeat.o(74531);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      p.aEk();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.K(u.aAm(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.b.iRG.a(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.azA(), 4, null);
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
      new com.tencent.mm.ak.n(getContext(), (String)localObject).E(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.ajC().ajl().a(this);
    com.tencent.mm.z.c.aht().a(this.yJC);
    if ((bt.getInt(com.tencent.mm.n.g.acA().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.ajC().ajl().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqS, Boolean.FALSE);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(74529);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74530);
    if (com.tencent.mm.kernel.g.ajx())
    {
      com.tencent.mm.kernel.g.ajC().ajl().b(this);
      com.tencent.mm.z.c.aht().b(this.yJC);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.aiU().b(281, this.onSceneEndCallback);
    }
    if (this.yFz != null) {
      com.tencent.mm.kernel.g.aiU().b(255, this.yFz);
    }
    if (this.yJG != null) {
      com.tencent.mm.kernel.g.aiU().b(281, this.yJG);
    }
    super.onDestroy();
    AppMethodBeat.o(74530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74532);
    super.onPause();
    if (com.tencent.mm.kernel.g.ajx()) {
      com.tencent.mm.kernel.g.ajF().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74508);
          com.tencent.mm.kernel.g.ajC().ajl().fqc();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
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
      if ((bt.getInt(com.tencent.mm.n.g.acA().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.ajC().ajl().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqU, Boolean.FALSE);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.z.c.aht().b(al.a.IDj, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      paramf = getContext();
      paramPreference = new Intent(this, SettingsPersonalInfoUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mq(0));
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
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyp, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iyq, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iyq, Integer.valueOf(i));
      }
      paramf = new Intent(this, SettingsPrivacyUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.z.c.aht().cK(262158, 266265);
      paramf = new Intent(this, SettingsAboutSystemUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.z.c.aht().cK(262145, 266243);
      com.tencent.mm.z.c.aht().cK(262157, 266262);
      paramf = getContext();
      paramPreference = new Intent(this, SettingsAboutMicroMsgUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74527);
          com.tencent.mm.cq.d.fSu();
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
      if (com.tencent.mm.ax.b.aJo())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "oversea user logout");
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
      com.tencent.mm.plugin.report.service.g.yhR.f(11545, new Object[] { Integer.valueOf(8) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (cb.hIi.aCA().size() > 1) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), cb.hIi.aCB() });
      }
      for (;;)
      {
        this.mDL.cMW();
        AppMethodBeat.o(74540);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), cb.hIi.aCB() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = dOi();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = dOh();
      AppMethodBeat.o(74540);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      paramf = new Intent(this, SettingsNotificationUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
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
      com.tencent.mm.plugin.report.service.g.yhR.f(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(74540);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!j.IcA) && (ac.fks().equals("zh_CN")))
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
      if (ac.fks().equals("zh_HK"))
      {
        paramf = getString(2131766185);
        break;
      }
      if (ac.fks().equals("zh_TW"))
      {
        paramf = getString(2131766186);
        break;
      }
      paramf = getString(2131766187);
      break;
      if (paramf.equals("settings_switch_account"))
      {
        if (cb.hIi.aCA().size() > 1) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), cb.hIi.aCB() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IBF, true)) {
            break label1621;
          }
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBF, Boolean.FALSE);
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
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), cb.hIi.aCB() });
        }
        label1621:
        dOg();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74533);
    Object localObject1 = (PersonalPreference)this.screen.aVD("settings_account");
    if (localObject1 != null)
    {
      localObject2 = u.aAm();
      ((PersonalPreference)localObject1).hMs = null;
      ((PersonalPreference)localObject1).yEl = -1;
      ((PersonalPreference)localObject1).sjU = ((String)localObject2);
      if (((PersonalPreference)localObject1).rDr != null) {
        a.b.c(((PersonalPreference)localObject1).rDr, ((PersonalPreference)localObject1).sjU);
      }
    }
    localObject1 = new ex();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!((ex)localObject1).dqd.doF)
    {
      localObject1 = this.screen.aVD("settings_about_device");
      this.screen.d((Preference)localObject1);
    }
    dOd();
    dOf();
    dNw();
    dOe();
    localObject1 = (IconPreference)this.screen.aVD("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).eWs())
    {
      ((IconPreference)localObject1).acl(0);
      ((IconPreference)localObject1).gw(getString(2131755829), 2131233430);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).eWt()) {
        break label248;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).eWr()) {
        break label237;
      }
      ((IconPreference)localObject1).jN(0, 2131234447);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(74533);
      return;
      ((IconPreference)localObject1).acl(8);
      break;
      label237:
      ((IconPreference)localObject1).jN(0, 2131691455);
      continue;
      label248:
      ((IconPreference)localObject1).jN(8, -1);
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