package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.c.a;
import java.util.Date;

public class WalletPasswordSettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private boolean eDD;
  private Dialog gKM;
  private ak handler;
  private com.tencent.mm.ui.base.preference.f screen;
  c tTv;
  private f.a tZI;
  CheckBoxPreference tZK;
  RightBelowPreference tZL;
  private boolean tZM;
  private IconPreference tZN;
  private Preference tZO;
  private String tZP;
  private String tZQ;
  private String tZR;
  private af tZS;
  private af tZT;
  private af tZU;
  private boolean tZV;
  private int tZW;
  private int tZX;
  private c.a tZY;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(46361);
    this.tZM = false;
    this.tZV = false;
    this.tZW = 0;
    this.tZX = 0;
    this.handler = new ak(new WalletPasswordSettingUI.1(this));
    this.tTv = new c() {};
    this.tZY = new c.a()
    {
      public final Intent p(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(46356);
        ab.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new vf();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.cLJ.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.cLK.cLC = new WalletPasswordSettingUI.7.1(this);
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousBundle);
          AppMethodBeat.o(46356);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.cLJ.scene = 18;
          } else {
            paramAnonymousBundle.cLJ.scene = 0;
          }
        }
      }
    };
    AppMethodBeat.o(46361);
  }
  
  private void a(af paramaf)
  {
    AppMethodBeat.i(46371);
    switch (paramaf.field_jump_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(46371);
      return;
      ab.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramaf.field_pref_url });
      if (!bo.isNullOrNil(paramaf.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.e.m(this, paramaf.field_pref_url, false);
        AppMethodBeat.o(46371);
        return;
        if (!bo.isNullOrNil(paramaf.field_tinyapp_username))
        {
          so localso = new so();
          localso.cIQ.userName = paramaf.field_tinyapp_username;
          localso.cIQ.cIS = bo.bf(paramaf.field_tinyapp_path, "");
          localso.cIQ.scene = 1066;
          localso.cIQ.cIT = 0;
          com.tencent.mm.sdk.b.a.ymk.l(localso);
          AppMethodBeat.o(46371);
          return;
          ab.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(46371);
          return;
          ab.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramaf = new Intent();
          paramaf.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramaf);
          new bt();
          AppMethodBeat.o(46371);
          return;
          ab.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(46371);
          return;
          ab.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          d.H(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void cSI()
  {
    AppMethodBeat.i(46364);
    com.tencent.mm.kernel.g.RM();
    String str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIf, "");
    com.tencent.mm.kernel.g.RM();
    String str2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIg, "");
    ab.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)))
    {
      this.screen.cl("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(46364);
      return;
    }
    this.screen.cl("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(46364);
  }
  
  private void gZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46363);
    this.tZN.setTitle(paramString1);
    if (!bo.isNullOrNil(paramString2))
    {
      this.screen.cl("wallet_open_auto_pay", false);
      AppMethodBeat.o(46363);
      return;
    }
    this.screen.cl("wallet_open_auto_pay", true);
    ab.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
    AppMethodBeat.o(46363);
  }
  
  private void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(46369);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.tZK.vxW = paramBoolean;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(46369);
  }
  
  private void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(46374);
    k localk = new k();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(localk, 0);
    this.tZV = true;
    if (paramBoolean) {
      this.gKM = com.tencent.mm.wallet_core.ui.g.a(this, false, new WalletPasswordSettingUI.4(this));
    }
    AppMethodBeat.o(46374);
  }
  
  private void nE(boolean paramBoolean)
  {
    AppMethodBeat.i(142387);
    if (this.tZI == null)
    {
      ab.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.cl("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(142387);
      return;
    }
    ab.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.tZI.tXR), Integer.valueOf(this.tZI.cnK), this.tZI.tXI });
    if ((this.tZI.tXR) || (!bo.hl(this.tZI.cnK, 0)))
    {
      this.screen.cl("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(142387);
      return;
    }
    if (bo.isNullOrNil(this.tZI.tXI))
    {
      this.screen.cl("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(142387);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.atx("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.tZI.tXI);
    com.tencent.mm.kernel.g.RM();
    long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLV, Long.valueOf(0L))).longValue() & 0x3;
    ab.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (bo.ah(l, 2L))
    {
      localIconPreference.setSummary(this.tZI.tXM);
      if ((paramBoolean) && (this.tZI.tXJ))
      {
        com.tencent.mm.kernel.g.RM();
        if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLX, Boolean.FALSE)).booleanValue()) {
          break label369;
        }
        localIconPreference.ON(0);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLX, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.cl("wallet_lucky_money_refund_way", false);
      AppMethodBeat.o(142387);
      return;
      localIconPreference.setSummary(this.tZI.tXK);
      break;
      label369:
      localIconPreference.ON(8);
    }
  }
  
  protected int cSJ()
  {
    return 2131165315;
  }
  
  protected void cSK()
  {
    AppMethodBeat.i(46367);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(46367);
  }
  
  protected void cSL()
  {
    AppMethodBeat.i(46368);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    AppMethodBeat.o(46368);
  }
  
  protected void cSM()
  {
    AppMethodBeat.i(46373);
    Object localObject;
    boolean bool1;
    label243:
    boolean bool2;
    label328:
    label377:
    long l;
    int i;
    if ((t.cTN().cUn()) || (t.cTN().cUm()))
    {
      this.screen.cl("wallet_modify_password", true);
      this.screen.cl("wallet_forget_password", true);
      this.screen.cl("wallet_realname_verify", false);
      this.screen.atx("wallet_realname_verify").setSummary(2131305428);
      this.screen.cl("wallet_universal_pay_order", true);
      this.screen.cl("wallet_switch_currency", true);
      this.screen.cl("wallet_switch_category", true);
      this.screen.cl("wallet_biometric_pay", true);
      this.screen.cl("wallet_universal_pay_order", true);
      this.screen.cl("wallet_digitalcert", true);
      this.tZT = t.cTM().afx("wallet_switch_currency");
      if ((this.tZT == null) || (this.tZT.field_is_show != 1)) {
        break label908;
      }
      this.screen.cl("wallet_switch_currency", false);
      localObject = this.screen.atx("wallet_switch_currency");
      ((Preference)localObject).setTitle(this.tZT.field_pref_title);
      ((Preference)localObject).setSummary(this.tZT.field_pref_desc);
      bool1 = false;
      this.tZU = t.cTM().afx("wallet_im_mch");
      if ((this.tZU == null) || (this.tZU.field_is_show != 1)) {
        break label926;
      }
      this.screen.cl("wallet_im_mch", false);
      localObject = this.screen.atx("wallet_im_mch");
      ((Preference)localObject).setTitle(this.tZU.field_pref_title);
      ((Preference)localObject).setSummary(this.tZU.field_pref_desc);
      bool2 = false;
      ab.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label945;
      }
      this.screen.cl("wallet_switch_category", true);
      com.tencent.mm.kernel.g.RM();
      l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(147457, Long.valueOf(0L))).longValue();
      i = 2131305042;
      if ((0x10 & l) == 0L) {
        break label961;
      }
      i = 2131305041;
      label424:
      this.screen.atx("wallet_delay_transfer_date").setSummary(i);
      int j = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWb, 0);
      if ((!com.tencent.mm.sdk.a.b.dsf()) && (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)) {
        break label979;
      }
      i = 1;
      label473:
      if ((j != 0) || (i != 0)) {
        break label984;
      }
      this.screen.cl("wallet_function_settings", true);
    }
    for (;;)
    {
      nE(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(46373);
      return;
      if (t.cTN().cUl())
      {
        this.screen.cl("wallet_modify_password", false);
        this.screen.cl("wallet_forget_password", false);
        this.screen.cl("wallet_realname_verify", false);
        this.screen.atx("wallet_realname_verify").setSummary(2131305434);
        this.screen.cl("wallet_universal_pay_order", true);
        if ((t.cTN().cUn()) || (t.cTN().cUm()))
        {
          this.screen.cl("wallet_biometric_pay", true);
          break;
        }
        localObject = (l)com.tencent.mm.kernel.g.E(l.class);
        if ((com.tencent.mm.plugin.wallet.b.a.cST()) && (com.tencent.mm.plugin.wallet.b.a.cSU()))
        {
          this.tZL.setTitle(2131305418);
          this.tZL.setSummary(2131305417);
          if (((l)localObject).byV())
          {
            this.tZL.J(getString(2131304889));
            break;
          }
          if (((l)localObject).byS())
          {
            this.tZL.J(getString(2131304890));
            break;
          }
          this.tZL.J(getString(2131304223));
          break;
        }
        if (com.tencent.mm.plugin.wallet.b.a.cST())
        {
          this.tZL.setTitle(2131305416);
          this.tZL.setSummary(2131305415);
          if (((l)localObject).byS())
          {
            this.tZL.J(getString(2131304212));
            break;
          }
          this.tZL.J(getString(2131304223));
          break;
        }
        if (com.tencent.mm.plugin.wallet.b.a.cSU())
        {
          this.tZL.setTitle(2131305414);
          this.tZL.setSummary(2131305413);
          if (((l)localObject).byV())
          {
            this.tZL.J(getString(2131304212));
            break;
          }
          this.tZL.J(getString(2131304223));
          break;
        }
        this.screen.cl("wallet_biometric_pay", true);
        break;
      }
      ab.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label908:
      this.screen.cl("wallet_switch_currency", true);
      bool1 = true;
      break label243;
      label926:
      this.screen.cl("wallet_im_mch", true);
      bool2 = true;
      break label328;
      label945:
      this.screen.cl("wallet_switch_category", false);
      break label377;
      label961:
      if ((l & 0x20) == 0L) {
        break label424;
      }
      i = 2131305040;
      break label424;
      label979:
      i = 0;
      break label473;
      label984:
      this.screen.cl("wallet_function_settings", false);
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46366);
    if (r.ZB()) {}
    for (String str = getString(2131305440);; str = getString(2131305439))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.e.dSS();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(cSJ());
      this.tZN = ((IconPreference)this.screen.atx("wallet_open_auto_pay"));
      this.tZO = this.screen.atx("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.RM();
      if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCi, Boolean.TRUE)).booleanValue())
      {
        this.tZN.eO(getString(2131297012), 2130839787);
        this.tZN.OM(0);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCi, Boolean.TRUE);
      }
      this.tZK = ((CheckBoxPreference)this.screen.atx("wallet_fingerprint_switch"));
      this.tZL = ((RightBelowPreference)this.screen.atx("wallet_biometric_pay"));
      cSM();
      this.screen.cl("nfc_idpay", true);
      this.screen.cl("wallet_open_auto_pay", true);
      this.screen.cl("wallet_universal_pay_order", true);
      this.screen.cl("wallet_lucky_money_refund_way", true);
      cSI();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(46354);
          WalletPasswordSettingUI.this.finish();
          AppMethodBeat.o(46354);
          return true;
        }
      });
      if (com.tencent.mm.plugin.wallet.b.a.cSU()) {
        com.tencent.mm.plugin.report.service.h.qsU.e(15817, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(46366);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46372);
    if ((paramInt1 == 65281) && (paramInt2 == -1))
    {
      if (!r.ZC()) {
        break label41;
      }
      finish();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(46372);
      return;
      label41:
      finish();
      ou localou = new ou();
      localou.cFt.context = getContext();
      com.tencent.mm.sdk.b.a.ymk.l(localou);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46362);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(385, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1477, this);
    com.tencent.mm.sdk.b.a.ymk.c(this.tTv);
    this.eDD = getIntent().getBooleanExtra("key_is_from_system", false);
    this.tZM = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.eDD)
    {
      ab.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yOZ, "");
    int i;
    if (!bo.isNullOrNil(paramBundle))
    {
      this.tZI = f.a.afe(paramBundle);
      ab.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.tZI });
      nE(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramBundle, 0);
      com.tencent.mm.kernel.g.RM();
      long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCk, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.RM();
      i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCl, Integer.valueOf(0))).intValue();
      ab.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > i + l)) {
        break label454;
      }
      i = 0;
      label336:
      if (i == 0) {
        break label459;
      }
      nD(false);
      label345:
      com.tencent.mm.kernel.g.RM();
      this.tZW = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEF, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.RM();
      this.tZR = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEA, ""));
      if (!bo.isNullOrNil(this.tZR)) {
        break label636;
      }
      ah.a(true, null);
    }
    for (;;)
    {
      if (this.tZW == 0) {
        this.screen.cl("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(46362);
      return;
      ab.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label454:
      i = 1;
      break label336;
      label459:
      com.tencent.mm.kernel.g.RM();
      this.tZQ = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCr, ""));
      this.tZS = t.cTM().afx("wallet_open_auto_pay");
      if ((this.tZS != null) && (this.tZS.field_is_show == 1) && (!bo.isNullOrNil(this.tZS.field_pref_url)))
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.tZP = this.tZS.field_pref_url;
        gZ(this.tZS.field_pref_title, this.tZS.field_pref_url);
        break label345;
      }
      if (this.tZS == null)
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label345;
      }
      ab.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.tZS.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bo.isNullOrNil(this.tZS.field_pref_url));
      break label345;
      label636:
      this.tZO.setTitle(this.tZR);
      ah.a(false, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46376);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.tTv);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(385, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1477, this);
    AppMethodBeat.o(46376);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(46370);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      cSK();
      com.tencent.mm.wallet_core.ui.e.RX(24);
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.RM();
      paramf = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCA, "");
      if (!bo.isNullOrNil(paramf))
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
        paramf = new bs();
        paramf.cYR = 2L;
        paramf.cYS = 2L;
        paramf.ake();
        AppMethodBeat.o(46370);
        return true;
      }
      paramf = t.cTN().cUy();
      if (!bo.isNullOrNil(paramf))
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.m(this, paramf, false);
        AppMethodBeat.o(46370);
        return true;
      }
      cSL();
      paramf = new bs();
      paramf.cYR = 2L;
      paramf.cYS = 1L;
      paramf.ake();
      com.tencent.mm.wallet_core.ui.e.RX(25);
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (t.cTN().cUl()) {
        if (!bo.isNullOrNil(this.tZQ))
        {
          ab.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.tZQ);
          paramf.putExtra("showShare", false);
          d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(46370);
        return true;
        ab.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
        continue;
        ab.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
        paramf = new Bundle();
        paramf.putInt("real_name_verify_mode", 0);
        paramf.putString("realname_verify_process_jump_plugin", "wallet");
        paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.tZY);
      }
    }
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.tZI.cSo().toString());
      startActivity(paramf);
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      startActivity(new Intent(this, WalletBiometricPaySettingsUI.class));
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      if (!bo.isNullOrNil(this.tZP))
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.tZP);
        paramf.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
        this.tZN.OM(8);
        AppMethodBeat.o(46370);
        return true;
      }
      ab.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.tZV)
      {
        paramf = new k();
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramf, 0);
      }
      d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.RM();
      paramf = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIg, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.tZT);
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.tZU);
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      startActivity(new Intent(getContext(), WalletUniversalPayOrderUI.class));
      AppMethodBeat.o(46370);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      d.H(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(46370);
      return true;
    }
    AppMethodBeat.o(46370);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46365);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).cXv())
    {
      finish();
      AppMethodBeat.o(46365);
      return;
    }
    cSM();
    AppMethodBeat.o(46365);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46375);
    ab.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof k))
      {
        cSM();
        paramString = (k)paramm;
        ab.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.tXW);
        this.tZQ = paramString.tYa;
        if (paramString.tXW == 1)
        {
          this.tZP = paramString.tXX;
          gZ(bo.bf(paramString.tXZ, getString(2131305468)), paramString.tXX);
        }
        for (;;)
        {
          cSI();
          if (this.gKM != null) {
            this.gKM.dismiss();
          }
          AppMethodBeat.o(46375);
          return;
          this.screen.cl("wallet_open_auto_pay", true);
        }
      }
      if ((paramm instanceof ah))
      {
        this.tZR = ((ah)paramm).ucg;
        this.tZW = ((ah)paramm).ucl;
        if (this.tZW == 0)
        {
          this.screen.cl("wallet_delay_transfer_date", true);
          AppMethodBeat.o(46375);
          return;
        }
        if (!bo.isNullOrNil(this.tZR)) {
          this.tZO.setTitle(this.tZR);
        }
        for (;;)
        {
          this.screen.cl("wallet_delay_transfer_date", false);
          AppMethodBeat.o(46375);
          return;
          ab.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.tZI = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramm).cSn();
        nE(true);
        ab.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.tZI.cSo() });
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yOZ, this.tZI.cSo());
        AppMethodBeat.o(46375);
      }
    }
    else
    {
      if ((paramm instanceof ah))
      {
        ab.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(46375);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.f)) {
        ab.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
      }
    }
    AppMethodBeat.o(46375);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */