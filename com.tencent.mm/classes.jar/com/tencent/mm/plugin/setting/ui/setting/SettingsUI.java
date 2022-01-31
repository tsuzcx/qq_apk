package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.a;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.x.a.a;
import java.util.ArrayList;
import java.util.Set;

@i
public class SettingsUI
  extends MMPreference
  implements n.b
{
  private ap bAz;
  private ap fJH;
  private com.tencent.mm.ui.widget.b.d iOd;
  private View omz;
  private com.tencent.mm.ai.f onSceneEndCallback;
  private ProgressDialog qHd;
  private ap qHe;
  private com.tencent.mm.ai.f qHf;
  private PersonalPreference qKE;
  private com.tencent.mm.ai.f qKF;
  private a.a qKG;
  private Dialog qKH;
  private com.tencent.mm.ui.widget.b.c qKI;
  private CheckBox qKJ;
  private com.tencent.mm.ai.f qKK;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsUI()
  {
    AppMethodBeat.i(127592);
    this.qKE = null;
    this.qHd = null;
    this.onSceneEndCallback = null;
    this.qKF = null;
    this.qHf = null;
    this.qKG = new SettingsUI.1(this);
    this.qKH = null;
    this.fJH = null;
    this.qKK = null;
    AppMethodBeat.o(127592);
  }
  
  private void ckD()
  {
    AppMethodBeat.i(127598);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_account_info");
    if (localIconPreference == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      AppMethodBeat.o(127598);
      return;
    }
    localIconPreference.OQ(8);
    if (com.tencent.mm.x.c.PJ().a(ac.a.yJH, 266257))
    {
      localIconPreference.ON(0);
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1)
      {
        if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yys, Boolean.FALSE)).booleanValue()) {
          break label168;
        }
        if ((com.tencent.mm.kernel.g.RL().Ru().getInt(40, 0) & 0x20000) == 0)
        {
          localIconPreference.eN(getString(2131297012), 2130839787);
          localIconPreference.OL(0);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "show voiceprint dot");
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127598);
      return;
      localIconPreference.ON(8);
      break;
      label168:
      localIconPreference.OL(8);
      localIconPreference.eN("", -1);
    }
  }
  
  private void ckE()
  {
    AppMethodBeat.i(127602);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yFz, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yFA, Integer.valueOf(0))).intValue())
      {
        localIconPreference.ON(0);
        AppMethodBeat.o(127602);
        return;
      }
      localIconPreference.ON(8);
    }
    AppMethodBeat.o(127602);
  }
  
  private void ckF()
  {
    AppMethodBeat.i(127603);
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.aqq();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.screen.atx("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.gxB) && (locala != l.a.gxC)) {
        break label83;
      }
      bool = true;
      localSwitchKeyValuePreference.qL(bool);
      if ((locala != l.a.gxB) && (locala != l.a.gxC)) {
        break label88;
      }
    }
    label83:
    label88:
    for (int i = 2131303375;; i = 2131303374)
    {
      localSwitchKeyValuePreference.setSummary(i);
      AppMethodBeat.o(127603);
      return;
      bool = false;
      break;
    }
  }
  
  private void ckG()
  {
    AppMethodBeat.i(127605);
    Intent localIntent = new Intent(this, SettingsSwitchAccountUI.class);
    localIntent.putExtra("key_scene", 0);
    startActivity(localIntent);
    AppMethodBeat.o(127605);
  }
  
  private boolean ckH()
  {
    AppMethodBeat.i(127607);
    com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.qKH != null)
    {
      this.qKH.show();
      AppMethodBeat.o(127607);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.qKH = com.tencent.mm.ui.base.h.d(this, getString(2131303297), "", getString(2131303293), getString(2131303296), new SettingsUI.2(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127562);
        com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.f(SettingsUI.this) != null) {
          SettingsUI.f(SettingsUI.this).dismiss();
        }
        AppMethodBeat.o(127562);
      }
    });
    AppMethodBeat.o(127607);
    return true;
  }
  
  private boolean ckI()
  {
    AppMethodBeat.i(127608);
    com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(4) });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.omz == null)
    {
      this.omz = View.inflate(getContext(), 2130970692, null);
      this.qKJ = ((CheckBox)this.omz.findViewById(2131827610));
      this.qKJ.setChecked(true);
    }
    if (this.qKI == null) {
      this.qKI = com.tencent.mm.ui.base.h.a(getContext(), null, this.omz, getString(2131301169), getString(2131296888), new DialogInterface.OnClickListener()new SettingsUI.5
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127563);
          com.tencent.mm.modelstat.c.akw().commitNow();
          ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.c.class)).logout();
          if ((SettingsUI.h(SettingsUI.this) != null) && (SettingsUI.h(SettingsUI.this).isChecked()))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            com.tencent.mm.network.ab.any().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.i(SettingsUI.this);
            AppMethodBeat.o(127563);
            return;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.Rc() != null) && (com.tencent.mm.kernel.g.Rc().ftA != null)) {
            com.tencent.mm.kernel.g.Rc().ftA.cR(false);
          }
          paramAnonymousDialogInterface = new gk();
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousDialogInterface);
          SettingsUI.j(SettingsUI.this);
          AppMethodBeat.o(127563);
        }
      }, new SettingsUI.5(this));
    }
    for (;;)
    {
      AppMethodBeat.o(127608);
      return true;
      this.qKI.show();
    }
  }
  
  private void ckJ()
  {
    AppMethodBeat.i(127609);
    Object localObject = com.tencent.mm.kernel.g.Rc();
    SettingsUI.19 local19 = new SettingsUI.19(this);
    this.qKF = local19;
    ((p)localObject).a(282, local19);
    localObject = new com.tencent.mm.modelsimple.r();
    com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(127609);
  }
  
  private void ckK()
  {
    AppMethodBeat.i(127611);
    Object localObject1 = com.tencent.mm.kernel.g.Rc();
    Object localObject2 = new SettingsUI.20(this);
    this.qHf = ((com.tencent.mm.ai.f)localObject2);
    ((p)localObject1).a(255, (com.tencent.mm.ai.f)localObject2);
    localObject1 = new t(2);
    ((t)localObject1).fPH = 1;
    com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
    this.qHe = new ap(Looper.getMainLooper(), new SettingsUI.21(this, (t)localObject1), false);
    this.qHe.ag(3000L, 3000L);
    localObject2 = getContext();
    getString(2131297087);
    this.qHd = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131306047), false, new SettingsUI.22(this, (t)localObject1));
    AppMethodBeat.o(127611);
  }
  
  private void ckb()
  {
    int j = 0;
    AppMethodBeat.i(127601);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_about_micromsg");
    boolean bool1 = bo.a(Boolean.valueOf(com.tencent.mm.x.c.PJ().cc(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.x.c.PJ().cd(262157, 266262);
    if (com.tencent.mm.sdk.platformtools.g.ymO)
    {
      localIconPreference.eN("", -1);
      localIconPreference.OL(8);
      bool1 = com.tencent.mm.x.c.PJ().cd(262158, 266265);
      localIconPreference = (IconPreference)this.screen.atx("settings_about_system");
      if (!bool1) {
        break label215;
      }
      i = 0;
      label116:
      localIconPreference.ON(i);
      com.tencent.mm.plugin.r.a.bWU();
      if (!com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKS)) {
        break label221;
      }
    }
    label215:
    label221:
    for (int i = j;; i = 8)
    {
      localIconPreference.ON(i);
      AppMethodBeat.o(127601);
      return;
      if (bool1)
      {
        localIconPreference.OL(0);
        localIconPreference.eN(getString(2131297012), 2130839787);
        break;
      }
      if (bool2)
      {
        localIconPreference.ON(0);
        break;
      }
      localIconPreference.ON(8);
      localIconPreference.eN("", -1);
      localIconPreference.OL(8);
      break;
      i = 8;
      break label116;
    }
  }
  
  private void ckz()
  {
    AppMethodBeat.i(127606);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.b.gmP.BU();
    com.tencent.mm.kernel.g.RL().Ru().b(this);
    Object localObject = new jo();
    ((jo)localObject).cze.status = 0;
    ((jo)localObject).cze.aXG = 0;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new y();
    ((y)localObject).cne.cnf = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    aj.apl("show_whatsnew");
    com.tencent.mm.kernel.l.n(this, true);
    ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.b.gmO.p((Intent)localObject, getContext());
    w.I(this, null);
    finish();
    AppMethodBeat.o(127606);
  }
  
  private void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(127610);
    aj.apl("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IH();
    }
    for (;;)
    {
      y localy = new y();
      localy.cne.cnf = false;
      com.tencent.mm.sdk.b.a.ymk.l(localy);
      com.tencent.mm.plugin.setting.b.gmP.BR();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IG();
      finish();
      if (com.tencent.mm.pluginsdk.f.e.vMF != null) {
        com.tencent.mm.pluginsdk.f.e.vMF.l(getContext(), paramBoolean);
      }
      AppMethodBeat.o(127610);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().n(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(127600);
    int i = bo.f(paramObject, 0);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.RL().Ru()) || (i <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(127600);
      return;
    }
    if (4 == i)
    {
      com.tencent.mm.kernel.g.RL().Ru().get(2, null);
      com.tencent.mm.kernel.g.RL().Ru().get(4, null);
    }
    if (6 == i)
    {
      ckF();
      AppMethodBeat.o(127600);
      return;
    }
    if (64 == i) {
      ckD();
    }
    AppMethodBeat.o(127600);
  }
  
  public int getResourceId()
  {
    return 2131165277;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127599);
    setMMTitle(2131303475);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127586);
        SettingsUI.this.finish();
        AppMethodBeat.o(127586);
        return true;
      }
    });
    this.iOd = new com.tencent.mm.ui.widget.b.d(this, 1, false);
    this.iOd.sao = new SettingsUI.24(this);
    this.iOd.AGQ = new SettingsUI.25(this);
    this.iOd.sap = new SettingsUI.26(this);
    setToTop(new SettingsUI.27(this));
    ckF();
    ckb();
    ckE();
    ButtonPreference localButtonPreference = (ButtonPreference)this.screen.atx("settings_switch_account");
    localButtonPreference.zqu = false;
    localButtonPreference.eM(getString(2131303457), getResources().getColor(2131690322));
    localButtonPreference = (ButtonPreference)this.screen.atx("settings_logout");
    localButtonPreference.zqu = false;
    localButtonPreference.eM(getString(2131303293), getResources().getColor(2131690322));
    this.screen.cl("settings_redesign", true);
    AppMethodBeat.o(127599);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127595);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(127595);
      return;
    case 5: 
      if (paramInt2 == -1) {
        ckz();
      }
      AppMethodBeat.o(127595);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.i.c.YK());
      if (paramIntent == null)
      {
        AppMethodBeat.o(127595);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.b.gmO.a(getContext(), (Intent)localObject, 4);
      AppMethodBeat.o(127595);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(127595);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.i.c.YK());
      if (localObject == null)
      {
        AppMethodBeat.o(127595);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      o.acQ();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.E(com.tencent.mm.model.r.Zn(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.b.gmO.a(this, paramIntent, localIntent, com.tencent.mm.plugin.i.c.YK(), 4, null);
      AppMethodBeat.o(127595);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(127595);
      return;
    }
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(127595);
      return;
      new com.tencent.mm.ah.m(getContext(), (String)localObject).v(null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127593);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.RL().Ru().a(this);
    com.tencent.mm.x.c.PJ().a(this.qKG);
    if ((bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.RL().Ru().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyq, Boolean.FALSE);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
    AppMethodBeat.o(127593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127594);
    if (com.tencent.mm.kernel.g.RG())
    {
      com.tencent.mm.kernel.g.RL().Ru().b(this);
      com.tencent.mm.x.c.PJ().b(this.qKG);
    }
    if (this.onSceneEndCallback != null) {
      com.tencent.mm.kernel.g.Rc().b(281, this.onSceneEndCallback);
    }
    if (this.qHf != null) {
      com.tencent.mm.kernel.g.Rc().b(255, this.qHf);
    }
    if (this.qKK != null) {
      com.tencent.mm.kernel.g.Rc().b(281, this.qKK);
    }
    super.onDestroy();
    AppMethodBeat.o(127594);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127596);
    super.onPause();
    com.tencent.mm.kernel.g.RO().ad(new SettingsUI.12(this));
    AppMethodBeat.o(127596);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127604);
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.c.class)).D(this, paramf);
      AppMethodBeat.o(127604);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.RL().Ru().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yys, Boolean.FALSE);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.x.c.PJ().b(ac.a.yJH, 266257);
      startActivity(SettingsAccountInfoUI.class);
      AppMethodBeat.o(127604);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      getContext().startActivity(new Intent(this, SettingsPersonalInfoUI.class));
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.J(this, paramf);
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yFz, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yFA, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yFA, Integer.valueOf(i));
      }
      startActivity(new Intent(this, SettingsPrivacyUI.class));
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.x.c.PJ().ce(262158, 266265);
      startActivity(new Intent(this, SettingsAboutSystemUI.class));
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.x.c.PJ().ce(262145, 266243);
      com.tencent.mm.x.c.PJ().ce(262157, 266262);
      getContext().startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
      new ak().postDelayed(new SettingsUI.29(this), 100L);
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new Intent();
      com.tencent.mm.bq.d.b(getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramf);
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.au.b.aih())
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.h.a(getContext(), true, getResources().getString(2131303297), "", getResources().getString(2131303293), getString(2131296888), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127573);
            SettingsUI.g(SettingsUI.this);
            AppMethodBeat.o(127573);
          }
        }, null);
        AppMethodBeat.o(127604);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11545, new Object[] { Integer.valueOf(8) });
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (bx.fnO.abf().size() > 1) {
        com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), bx.fnO.abg() });
      }
      for (;;)
      {
        this.iOd.crd();
        AppMethodBeat.o(127604);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), bx.fnO.abg() });
      }
    }
    boolean bool;
    if (paramf.equals("settings_exit"))
    {
      bool = ckI();
      AppMethodBeat.o(127604);
      return bool;
    }
    if (paramf.equals("settings_logout_option"))
    {
      bool = ckH();
      AppMethodBeat.o(127604);
      return bool;
    }
    if (paramf.equals("settings_notification_preference"))
    {
      startActivity(new Intent(this, SettingsNotificationUI.class));
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_chatting"))
    {
      startActivity(SettingsChattingUI.class);
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_active_time"))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      startActivity(SettingsActiveTimeUI.class);
      AppMethodBeat.o(127604);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!com.tencent.mm.sdk.platformtools.g.ymO) && (aa.dsG().equals("zh_CN")))
      {
        paramf = getString(2131305938);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SettingsUI", "using faq webpage");
        paramPreference = new Intent();
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("show_feedback", false);
        paramPreference.putExtra("KShowFixToolsBtn", true);
        com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    label1252:
    label1259:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(127604);
        return false;
        if (aa.dsG().equals("zh_HK"))
        {
          paramf = getString(2131305939);
          break;
        }
        if (aa.dsG().equals("zh_TW"))
        {
          paramf = getString(2131305940);
          break;
        }
        paramf = getString(2131305941);
        break;
        if (!paramf.equals("settings_switch_account")) {
          break label1259;
        }
        if (bx.fnO.abf().size() > 1) {
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), bx.fnO.abg() });
        }
        for (;;)
        {
          if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yIy, true)) {
            break label1252;
          }
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIy, Boolean.FALSE);
          com.tencent.mm.ui.base.h.a(this, getString(2131303458), getString(2131303459), getString(2131296977), false, new SettingsUI.28(this));
          break;
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), bx.fnO.abg() });
        }
        ckG();
      }
    } while (!paramf.equals("settings_redesign"));
    startActivity(new Intent(this, SettingRedesign.class));
    AppMethodBeat.o(127604);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127597);
    Object localObject1 = (PersonalPreference)this.screen.atx("settings_account");
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.model.r.Zn();
      ((PersonalPreference)localObject1).frG = null;
      ((PersonalPreference)localObject1).qFZ = -1;
      ((PersonalPreference)localObject1).qGa = ((String)localObject2);
      if (((PersonalPreference)localObject1).mDc != null) {
        a.b.c(((PersonalPreference)localObject1).mDc, ((PersonalPreference)localObject1).qGa);
      }
    }
    localObject1 = new en();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!((en)localObject1).csq.cqS)
    {
      localObject1 = this.screen.atx("settings_about_device");
      this.screen.d((Preference)localObject1);
    }
    ckD();
    ckF();
    ckb();
    ckE();
    localObject1 = (IconPreference)this.screen.atx("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).dhp())
    {
      ((IconPreference)localObject1).OL(0);
      ((IconPreference)localObject1).eN(getString(2131297012), 2130839787);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).dhq()) {
        break label246;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).dho()) {
        break label235;
      }
      ((IconPreference)localObject1).hB(0, 2130840641);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      AppMethodBeat.o(127597);
      return;
      ((IconPreference)localObject1).OL(8);
      break;
      label235:
      ((IconPreference)localObject1).hB(0, 2131232248);
      continue;
      label246:
      ((IconPreference)localObject1).hB(8, -1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */