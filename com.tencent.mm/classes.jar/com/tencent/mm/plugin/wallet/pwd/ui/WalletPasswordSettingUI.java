package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.d.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class WalletPasswordSettingUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  c Bgb;
  private IconPreference BmA;
  private Preference BmB;
  private String BmC;
  private String BmD;
  private String BmE;
  private af BmF;
  private af BmG;
  private af BmH;
  private h.a BmI;
  private gg BmJ;
  private boolean BmK;
  private int BmL;
  private int BmM;
  private int BmN;
  private List<Preference> BmO;
  private boolean BmP;
  private c<nm> BmQ;
  private d.a BmR;
  private f.a Bmt;
  CheckBoxPreference Bmv;
  RightBelowPreference Bmw;
  CheckBoxPreference Bmx;
  private Dialog Bmy;
  private boolean Bmz;
  private boolean gdn;
  private ao handler;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.Bmy = null;
    this.Bmz = false;
    this.BmK = false;
    this.BmL = 0;
    this.BmM = 0;
    this.handler = new ao(new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(69735);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(69735);
          return false;
          WalletPasswordSettingUI.a(WalletPasswordSettingUI.this);
          continue;
          WalletPasswordSettingUI.b(WalletPasswordSettingUI.this);
          continue;
          WalletPasswordSettingUI.c(WalletPasswordSettingUI.this);
        }
      }
    });
    this.BmN = 2;
    this.BmO = new ArrayList();
    this.BmP = false;
    this.Bgb = new c() {};
    this.BmQ = new c() {};
    this.BmR = new d.a()
    {
      public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        ac.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new xq();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.dAt.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.dAu.dAl = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.equ();
              AppMethodBeat.o(69748);
            }
          };
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.dAt.scene = 18;
          } else {
            paramAnonymousBundle.dAt.scene = 0;
          }
        }
      }
    };
    AppMethodBeat.o(69753);
  }
  
  private void a(af paramaf)
  {
    AppMethodBeat.i(69763);
    switch (paramaf.field_jump_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69763);
      return;
      ac.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramaf.field_pref_url });
      if (!bs.isNullOrNil(paramaf.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.e.n(this, paramaf.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!bs.isNullOrNil(paramaf.field_tinyapp_username))
        {
          ut localut = new ut();
          localut.dxt.userName = paramaf.field_tinyapp_username;
          localut.dxt.dxv = bs.bG(paramaf.field_tinyapp_path, "");
          localut.dxt.scene = 1066;
          localut.dxt.dxw = 0;
          com.tencent.mm.sdk.b.a.GpY.l(localut);
          AppMethodBeat.o(69763);
          return;
          ac.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.br.d.N(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          ac.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramaf = new Intent();
          paramaf.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramaf);
          new gd();
          AppMethodBeat.o(69763);
          return;
          ac.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.br.d.b(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          ac.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.br.d.N(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void aH(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207264);
    this.BmA.setTitle(paramString1);
    if ((!bs.isNullOrNil(paramString2)) || (!bs.isNullOrNil(paramString3)))
    {
      this.screen.cK("wallet_open_auto_pay", false);
      AppMethodBeat.o(207264);
      return;
    }
    this.screen.cK("wallet_open_auto_pay", true);
    ac.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(207264);
  }
  
  private void azc(String paramString)
  {
    AppMethodBeat.i(182520);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
      AppMethodBeat.o(182520);
      return;
    }
    if (paramString.contains("wc_custom_link"))
    {
      paramString = k.a(this, paramString, 10, false, null);
      this.Bmx.HFP = true;
      this.Bmx.setSummary(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.Bmx.setSummary(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void eqq()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.g.agS();
    String str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOR, "");
    com.tencent.mm.kernel.g.agS();
    String str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOS, "");
    ac.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2)))
    {
      this.screen.cK("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.cK("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void eqv()
  {
    AppMethodBeat.i(69766);
    if ((s.ery().esc()) || (s.ery().esb()))
    {
      this.screen.cK("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.eqC()) && (com.tencent.mm.plugin.wallet.b.a.eqD()))
    {
      this.Bmw.setTitle(2131765632);
      this.Bmw.setSummary(2131765631);
      if (locala.cHc()) {
        this.Bmw.Q(getString(2131765076));
      }
      for (;;)
      {
        this.screen.cK("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.cGZ()) {
          this.Bmw.Q(getString(2131765077));
        } else {
          this.Bmw.Q(getString(2131764341));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eqC())
    {
      this.Bmw.setTitle(2131765630);
      this.Bmw.setSummary(2131765629);
      if (locala.cGZ()) {
        this.Bmw.Q(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cK("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Bmw.Q(getString(2131764341));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eqD())
    {
      this.Bmw.setTitle(2131765628);
      this.Bmw.setSummary(2131765627);
      if (locala.cHc()) {
        this.Bmw.Q(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cK("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Bmw.Q(getString(2131764341));
      }
    }
    this.screen.cK("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  private void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    ac.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.BmI == null)
    {
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.cK("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.BmI.nWx != 0) || (!this.BmI.nVQ))
    {
      this.screen.cK("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (bs.isNullOrNil(this.BmI.Bkp))
    {
      this.screen.cK("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.Bmx.setTitle(this.BmI.Bkp);
    azc(this.BmI.dlQ);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.Bmx;
      paramBoolean = this.BmI.BkD;
    }
    for (;;)
    {
      localCheckBoxPreference.mF = paramBoolean;
      this.screen.cK("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.g.agS();
      int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTD, Integer.valueOf(0))).intValue();
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.Bmx;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  private void tx(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.Bmv.mF = paramBoolean;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(localm, 0);
    this.BmK = true;
    if (paramBoolean) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(this, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(69738);
          if (WalletPasswordSettingUI.h(WalletPasswordSettingUI.this) != null) {
            WalletPasswordSettingUI.h(WalletPasswordSettingUI.this).dismiss();
          }
          AppMethodBeat.o(69738);
        }
      });
    }
    AppMethodBeat.o(69767);
  }
  
  private void tz(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.Bmt == null)
    {
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.cK("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.Bmt.Bky), Integer.valueOf(this.Bmt.dae), this.Bmt.Bkp });
      if ((!this.Bmt.Bky) && (bs.jl(this.Bmt.dae, 0))) {
        break;
      }
      this.screen.cK("wallet_lucky_money_refund_way", true);
    }
    if (bs.isNullOrNil(this.Bmt.Bkp))
    {
      this.screen.cK("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.aPN("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.Bmt.Bkp);
    com.tencent.mm.kernel.g.agS();
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTq, Long.valueOf(0L))).longValue() & 0x3;
    ac.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (bs.av(l, 2L))
    {
      localIconPreference.setSummary(this.Bmt.Bkt);
      label275:
      if ((paramBoolean) && (this.Bmt.Bkq))
      {
        com.tencent.mm.kernel.g.agS();
        if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTs, Boolean.FALSE)).booleanValue()) {
          break label374;
        }
        localIconPreference.aad(0);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTs, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.cK("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.setSummary(this.Bmt.Bkr);
      break label275;
      label374:
      localIconPreference.aad(8);
    }
  }
  
  protected int eqr()
  {
    return 2131951760;
  }
  
  protected void eqs()
  {
    AppMethodBeat.i(69759);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void eqt()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.fzz();
    if (com.tencent.mm.wallet_core.b.b(b.a.pUS, false))
    {
      ac.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69760);
      return;
      ac.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    AppMethodBeat.o(69760);
  }
  
  protected void equ()
  {
    AppMethodBeat.i(69765);
    boolean bool1;
    label253:
    boolean bool2;
    label339:
    long l;
    label389:
    label436:
    int j;
    if ((s.ery().esc()) || (s.ery().esb()))
    {
      this.screen.cK("wallet_modify_password", true);
      this.screen.cK("wallet_forget_password", true);
      this.screen.cK("wallet_realname_verify", false);
      this.screen.aPN("wallet_realname_verify").setSummary(2131765642);
      this.screen.cK("wallet_universal_pay_order", true);
      this.screen.cK("wallet_switch_currency", true);
      this.screen.cK("wallet_switch_category", true);
      this.screen.cK("wallet_biometric_pay", true);
      this.screen.cK("wallet_universal_pay_order", true);
      this.screen.cK("wallet_digitalcert", true);
      this.BmG = s.erx().azy("wallet_switch_currency");
      if ((this.BmG == null) || (this.BmG.field_is_show != 1)) {
        break label688;
      }
      this.screen.cK("wallet_switch_currency", false);
      localObject1 = this.screen.aPN("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.BmG.field_pref_title);
      ((Preference)localObject1).setSummary(this.BmG.field_pref_desc);
      bool1 = false;
      this.BmH = s.erx().azy("wallet_im_mch");
      if ((this.BmH == null) || (this.BmH.field_is_show != 1)) {
        break label707;
      }
      this.screen.cK("wallet_im_mch", false);
      localObject1 = this.screen.aPN("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.BmH.field_pref_title);
      ((Preference)localObject1).setSummary(this.BmH.field_pref_desc);
      bool2 = false;
      ac.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.cK("wallet_switch_category", true);
      com.tencent.mm.kernel.g.agS();
      l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(147457, Long.valueOf(0L))).longValue();
      i = 2131765234;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = 2131765233;
      this.screen.aPN("wallet_delay_transfer_date").setSummary(i);
      j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUh, 0);
      if ((!com.tencent.mm.sdk.a.b.eUk()) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.cK("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      tz(false);
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.BmO == null) || (this.BmO.size() <= 0)) {
        break label793;
      }
      localObject1 = this.BmO.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.d((Preference)localObject2);
      }
      if (s.ery().esa())
      {
        this.screen.cK("wallet_modify_password", false);
        this.screen.cK("wallet_forget_password", false);
        this.screen.cK("wallet_realname_verify", false);
        this.screen.aPN("wallet_realname_verify").setSummary(2131765648);
        this.screen.cK("wallet_universal_pay_order", true);
        eqv();
        break;
      }
      ac.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.cK("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.cK("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.cK("wallet_switch_category", false);
      break label389;
      label744:
      if ((l & 0x20) == 0L) {
        break label436;
      }
      i = 2131765232;
      break label436;
      label762:
      i = 0;
      break label485;
      label767:
      this.screen.cK("wallet_function_settings", false);
    }
    this.BmO.clear();
    label793:
    int i = this.screen.indexOf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.g.agS();
    Object localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTG, "");
    if (!bs.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = m.a.aL(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).BkO != null)
          {
            ac.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).BkO;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).HFQ = true;
            ((PreferenceTitleCategory)localObject4).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dhb)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.BmO.add(localObject4);
            localObject3 = ((m.a)localObject2).BkN.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (af)((Iterator)localObject3).next();
            ac.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
            WalletPasswordSettingUI.10 local10 = new WalletPasswordSettingUI.10(this, getContext());
            local10.setLayoutResource(2131494804);
            local10.setTitle(((af)localObject4).field_pref_title);
            local10.setSummary(((af)localObject4).field_pref_desc);
            local10.HFD = new Preference.b()
            {
              public final boolean dpE()
              {
                AppMethodBeat.i(207263);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.BmV);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(207263);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.BmO.add(local10);
            ac.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
            continue;
            this.screen.notifyDataSetChanged();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.WalletPasswordSettingUI", " parse EXTRA_Data failed :%s", new Object[] { localJSONException.getMessage() });
      }
      for (;;)
      {
        AppMethodBeat.o(69765);
        return;
        localObject3 = new PreferenceSmallCategory(getContext());
        i += 1;
        this.screen.a((Preference)localObject3, i);
        this.BmO.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).BkP != null)
        {
          ac.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).BkP;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).HFQ = true;
          ((PreferenceFooterCategory)localObject3).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dhb)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.BmO.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.BmO.add(localObject2);
        break label1341;
        this.screen.notifyDataSetChanged();
      }
      label1341:
      j += 1;
    }
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69758);
    if (u.axL()) {}
    for (String str = getString(2131765654);; str = getString(2131765653))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.e.fAP();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(eqr());
      this.BmA = ((IconPreference)this.screen.aPN("wallet_open_auto_pay"));
      this.BmB = this.screen.aPN("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.agS();
      if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIt, Boolean.TRUE)).booleanValue())
      {
        this.BmA.ga(getString(2131755829), 2131233430);
        this.BmA.aac(0);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIt, Boolean.TRUE);
      }
      this.Bmv = ((CheckBoxPreference)this.screen.aPN("wallet_fingerprint_switch"));
      this.Bmw = ((RightBelowPreference)this.screen.aPN("wallet_biometric_pay"));
      this.Bmx = ((CheckBoxPreference)this.screen.aPN("mobile_remit_switch"));
      equ();
      this.screen.cK("nfc_idpay", true);
      this.screen.cK("wallet_open_auto_pay", true);
      this.screen.cK("wallet_universal_pay_order", true);
      this.screen.cK("wallet_lucky_money_refund_way", true);
      eqq();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69747);
          WalletPasswordSettingUI.this.finish();
          AppMethodBeat.o(69747);
          return true;
        }
      });
      if (com.tencent.mm.plugin.wallet.b.a.eqD()) {
        com.tencent.mm.plugin.report.service.h.wUl.f(15817, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(69758);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69764);
    if ((paramInt1 == 65281) && (paramInt2 == -1))
    {
      if (!u.axM()) {
        break label42;
      }
      finish();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(69764);
      return;
      label42:
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69754);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1477, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1813, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1724, this);
    com.tencent.mm.sdk.b.a.GpY.c(this.Bgb);
    this.BmQ.alive();
    this.gdn = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.Bmz = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.gdn)
    {
      ac.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTr, "");
    label356:
    int i;
    if (!bs.isNullOrNil(paramBundle))
    {
      this.Bmt = f.a.aza(paramBundle);
      ac.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.Bmt });
      tz(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      s.ers();
      boolean bool = s.erH();
      ac.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label709;
      }
      paramBundle = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTE, "");
      if (bs.isNullOrNil(paramBundle)) {
        break label698;
      }
      this.BmI = h.a.azb(paramBundle);
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.Bmt });
      tA(false);
      com.tencent.mm.kernel.g.agS();
      this.BmN = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTF, Integer.valueOf(2))).intValue();
      ac.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.BmN) });
      if (this.BmN == 0) {
        this.BmN = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.BmN);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      label453:
      com.tencent.mm.kernel.g.agS();
      long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIv, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.agS();
      i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIw, Integer.valueOf(0))).intValue();
      ac.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > l + i)) {
        break label717;
      }
      i = 0;
      label579:
      if (i == 0) {
        break label722;
      }
      ty(false);
      label588:
      com.tencent.mm.kernel.g.agS();
      this.BmL = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLa, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.agS();
      this.BmE = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKV, ""));
      if (!bs.isNullOrNil(this.BmE)) {
        break label893;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      if (this.BmL == 0) {
        this.screen.cK("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label698:
      ac.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label356;
      label709:
      tA(false);
      break label453;
      label717:
      i = 1;
      break label579;
      label722:
      com.tencent.mm.kernel.g.agS();
      this.BmD = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIC, ""));
      this.BmF = s.erx().azy("wallet_open_auto_pay");
      if ((this.BmF != null) && (this.BmF.field_is_show == 1))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.BmC = this.BmF.field_pref_url;
        aH(this.BmF.field_pref_title, this.BmF.field_pref_url, this.BmF.field_tinyapp_path);
        break label588;
      }
      if (this.BmF == null)
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label588;
      }
      ac.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.BmF.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bs.isNullOrNil(this.BmF.field_pref_url));
      break label588;
      label893:
      this.BmB.setTitle(this.BmE);
      aj.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.Bgb);
    this.BmQ.dead();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1477, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1813, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      eqs();
      com.tencent.mm.wallet_core.ui.e.adR(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.agS();
      paramf = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIL, "");
      if (!bs.isNullOrNil(paramf))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.n(getContext(), paramf, false);
        paramf = new gc();
        paramf.ebn = 2L;
        paramf.ebo = 2L;
        paramf.aHZ();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = s.ery().esn();
      if (!bs.isNullOrNil(paramf))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.n(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      eqt();
      paramf = new gc();
      paramf.ebn = 2L;
      paramf.ebo = 1L;
      paramf.aHZ();
      com.tencent.mm.wallet_core.ui.e.adR(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (s.ery().esa()) {
        if (!bs.isNullOrNil(this.BmD))
        {
          ac.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.BmD);
          paramf.putExtra("showShare", false);
          paramf.putExtra(e.m.HhK, true);
          com.tencent.mm.wallet_core.ui.e.al(getContext(), paramf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(69762);
        return true;
        ac.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
        continue;
        ac.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
        paramf = new Bundle();
        paramf.putInt("real_name_verify_mode", 0);
        paramf.putString("realname_verify_process_jump_plugin", "wallet");
        paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.BmR);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.Bmt.epW().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new fz();
      com.tencent.mm.kernel.g.agS();
      if (bs.av(((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTq, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.ebd = i;
        paramf.aHZ();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.BmF);
      this.BmA.aac(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.BmK)
      {
        paramf = new m();
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramf, 0);
      }
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.agS();
      paramf = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOS, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(e.m.HhK, true);
      com.tencent.mm.wallet_core.ui.e.al(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.BmG);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.BmH);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.d.N(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.BmJ = new gg();
        this.BmJ.dCQ = i;
        if (this.scene != 0) {
          break label1323;
        }
        this.BmJ.ebt = 2L;
        label1238:
        this.BmJ.aHZ();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.BmN);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramf, 0);
        if (this.Bmy != null) {
          break label1342;
        }
        this.Bmy = com.tencent.mm.ui.base.h.a(this, 0, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(69750);
            ac.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
            AppMethodBeat.o(69750);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(69762);
        return true;
        i = 2;
        break;
        label1323:
        if (this.scene != 1) {
          break label1238;
        }
        this.BmJ.ebt = 1L;
        break label1238;
        label1342:
        this.Bmy.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).evj())
    {
      finish();
      AppMethodBeat.o(69757);
      return;
    }
    equ();
    if (this.BmP)
    {
      this.BmP = false;
      ty(false);
    }
    AppMethodBeat.o(69757);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(69768);
    ac.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        equ();
        paramString = (m)paramn;
        ac.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.BkH);
        this.BmD = paramString.BkL;
        this.BmF = s.erx().azy("wallet_open_auto_pay");
        if ((this.BmF != null) && (this.BmF.field_is_show == 1))
        {
          ac.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.BmC = this.BmF.field_pref_url;
          aH(this.BmF.field_pref_title, this.BmF.field_pref_url, this.BmF.field_tinyapp_path);
        }
        for (;;)
        {
          eqq();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.cK("wallet_open_auto_pay", true);
        }
      }
      if ((paramn instanceof aj))
      {
        this.BmE = ((aj)paramn).Bpi;
        this.BmL = ((aj)paramn).Bpn;
        if (this.BmL == 0)
        {
          this.screen.cK("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!bs.isNullOrNil(this.BmE)) {
          this.BmB.setTitle(this.BmE);
        }
        for (;;)
        {
          this.screen.cK("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          ac.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.Bmt = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramn).epV();
        tz(true);
        ac.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.Bmt.epW() });
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTr, this.Bmt.epW());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramn;
        if (paramString.BkC == null)
        {
          paramString.BkC = new h.a();
          paramString.BkC.nWx = paramString.BkB.nWx;
          paramString.BkC.nWy = paramString.BkB.nWy;
          paramString.BkC.nVQ = paramString.BkB.nVQ;
          paramString.BkC.BkD = paramString.BkB.BkD;
          paramString.BkC.Bkp = paramString.BkB.Bkp;
          paramString.BkC.dlQ = paramString.BkB.dlQ;
        }
        this.BmI = paramString.BkC;
        tA(true);
        ac.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.BmI.epW() });
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTE, this.BmI.epW());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.Bmy != null) && (this.Bmy.isShowing())) {
          this.Bmy.dismiss();
        }
        paramn = (com.tencent.mm.plugin.wallet.pwd.a.g)paramn;
        if (paramn.BkA == null)
        {
          paramn = new djk();
          if (paramn == null)
          {
            if (!bs.isNullOrNil(paramString)) {
              break label904;
            }
            paramString = getString(2131765224);
            label686:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
          }
          paramInt1 = paramn.nWx;
          paramString = paramn.nWy;
          if (paramn.EmH != null) {
            break label907;
          }
          bool1 = true;
          label731:
          ac.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramn.FSx), paramn.dlQ });
          paramInt1 = paramn.FSx;
          paramString = paramn.dlQ;
          if (!bs.isNullOrNil(paramString)) {
            break label913;
          }
          ac.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label808:
          if (paramn.nWx != 0) {
            break label1048;
          }
          if (paramn.FSy == null) {
            break label984;
          }
          ac.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          l.a(getContext(), paramn.FSy, null, new l.a()
          {
            public final void dC(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void dxG()
            {
              AppMethodBeat.i(163865);
              ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int dxH()
            {
              return 1149;
            }
            
            public final void dxI()
            {
              AppMethodBeat.i(163866);
              ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void dxJ()
            {
              AppMethodBeat.i(163867);
              ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(69739);
              ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.Bmx;
          if (this.Bmx.isChecked()) {
            break label978;
          }
        }
        label904:
        label907:
        label913:
        label978:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.mF = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramn = paramn.BkA;
          break;
          break label686;
          bool1 = false;
          break label731;
          this.BmN = paramInt1;
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTF, Integer.valueOf(paramInt1));
          this.BmI.dlQ = paramString;
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTE, this.BmI.epW());
          azc(paramString);
          this.screen.notifyDataSetChanged();
          break label808;
        }
        label984:
        if (this.Bmx.isChecked())
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTD, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTD, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1048:
        if (paramn.nWx == 416) {
          if (paramn.EmH != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramn.nWx;
            paramn = paramn.EmH;
            new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69741);
                ac.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.o(69741);
              }
            };
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt1, paramn, paramString, 1012);
            paramString = this.Bmx;
            if (this.Bmx.isChecked()) {
              break label1324;
            }
          }
        }
        label1324:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.mF = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (bs.isNullOrNil(paramn.nWy)) {}
          for (paramString = getString(2131765224);; paramString = paramn.nWy)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
          if (paramn.FSy != null)
          {
            ac.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            l.a(getContext(), paramn.FSy, null, new l.a()
            {
              public final void dC(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void dxG()
              {
                AppMethodBeat.i(163868);
                ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int dxH()
              {
                return 1149;
              }
              
              public final void dxI()
              {
                AppMethodBeat.i(163869);
                ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void dxJ()
              {
                AppMethodBeat.i(163870);
                ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void dxN()
              {
                AppMethodBeat.i(69742);
                ac.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramn.nWx == 0) {
            break;
          }
          if (bs.isNullOrNil(paramn.nWy)) {}
          for (paramString = getString(2131765224);; paramString = paramn.nWy)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
        }
      }
    }
    else
    {
      if ((paramn instanceof aj))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        ac.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
        if ((this.Bmy != null) && (this.Bmy.isShowing())) {
          this.Bmy.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
          paramn = getString(2131761270);
        }
        t.makeText(localAppCompatActivity, paramn, 0).show();
        paramString = this.Bmx;
        if (this.Bmx.isChecked()) {
          break label1512;
        }
      }
    }
    for (;;)
    {
      paramString.mF = bool1;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69768);
      return;
      label1512:
      bool1 = false;
    }
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