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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  implements com.tencent.mm.al.g
{
  private boolean fYH;
  private ap handler;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  c zNH;
  private f.a zTZ;
  CheckBoxPreference zUb;
  RightBelowPreference zUc;
  CheckBoxPreference zUd;
  private Dialog zUe;
  private boolean zUf;
  private IconPreference zUg;
  private Preference zUh;
  private String zUi;
  private String zUj;
  private String zUk;
  private af zUl;
  private af zUm;
  private af zUn;
  private h.a zUo;
  private eq zUp;
  private boolean zUq;
  private int zUr;
  private int zUs;
  private int zUt;
  private List<Preference> zUu;
  private boolean zUv;
  private c<nd> zUw;
  private d.a zUx;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.zUe = null;
    this.zUf = false;
    this.zUq = false;
    this.zUr = 0;
    this.zUs = 0;
    this.handler = new ap(new ap.a()
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
    this.zUt = 2;
    this.zUu = new ArrayList();
    this.zUv = false;
    this.zNH = new c() {};
    this.zUw = new c() {};
    this.zUx = new d.a()
    {
      public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new xf();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.dCH.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.dCI.dCz = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.eaY();
              AppMethodBeat.o(69748);
            }
          };
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.dCH.scene = 18;
          } else {
            paramAnonymousBundle.dCH.scene = 0;
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramaf.field_pref_url });
      if (!bt.isNullOrNil(paramaf.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.e.o(this, paramaf.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!bt.isNullOrNil(paramaf.field_tinyapp_username))
        {
          uj localuj = new uj();
          localuj.dzH.userName = paramaf.field_tinyapp_username;
          localuj.dzH.dzJ = bt.by(paramaf.field_tinyapp_path, "");
          localuj.dzH.scene = 1066;
          localuj.dzH.dzK = 0;
          com.tencent.mm.sdk.b.a.ESL.l(localuj);
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.bs.d.O(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramaf = new Intent();
          paramaf.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramaf);
          new en();
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.bs.d.b(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.bs.d.O(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void atK(String paramString)
  {
    AppMethodBeat.i(182520);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
      AppMethodBeat.o(182520);
      return;
    }
    if (paramString.contains("wc_custom_link"))
    {
      paramString = k.a(this, paramString, 10, false, null);
      this.zUd.Gga = true;
      this.zUd.setSummary(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.zUd.setSummary(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void eaU()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.g.afC();
    String str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frb, "");
    com.tencent.mm.kernel.g.afC();
    String str2 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frc, "");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
    {
      this.screen.cE("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.cE("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void eaZ()
  {
    AppMethodBeat.i(69766);
    if ((s.ecc().ecH()) || (s.ecc().ecG()))
    {
      this.screen.cE("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.ebg()) && (com.tencent.mm.plugin.wallet.b.a.ebh()))
    {
      this.zUc.setTitle(2131765632);
      this.zUc.setSummary(2131765631);
      if (locala.ctQ()) {
        this.zUc.P(getString(2131765076));
      }
      for (;;)
      {
        this.screen.cE("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.ctN()) {
          this.zUc.P(getString(2131765077));
        } else {
          this.zUc.P(getString(2131764341));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.ebg())
    {
      this.zUc.setTitle(2131765630);
      this.zUc.setSummary(2131765629);
      if (locala.ctN()) {
        this.zUc.P(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cE("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.zUc.P(getString(2131764341));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.ebh())
    {
      this.zUc.setTitle(2131765628);
      this.zUc.setSummary(2131765627);
      if (locala.ctQ()) {
        this.zUc.P(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cE("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.zUc.P(getString(2131764341));
      }
    }
    this.screen.cE("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  private void jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69755);
    this.zUg.setTitle(paramString1);
    if (!bt.isNullOrNil(paramString2))
    {
      this.screen.cE("wallet_open_auto_pay", false);
      AppMethodBeat.o(69755);
      return;
    }
    this.screen.cE("wallet_open_auto_pay", true);
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
    AppMethodBeat.o(69755);
  }
  
  private void sw(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.zUb.lG = paramBoolean;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void sx(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(localm, 0);
    this.zUq = true;
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
  
  private void sy(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.zTZ == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.cE("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.zTZ.zSe), Integer.valueOf(this.zTZ.dcG), this.zTZ.zRV });
      if ((!this.zTZ.zSe) && (bt.iY(this.zTZ.dcG, 0))) {
        break;
      }
      this.screen.cE("wallet_lucky_money_refund_way", true);
    }
    if (bt.isNullOrNil(this.zTZ.zRV))
    {
      this.screen.cE("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.aKk("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.zTZ.zRV);
    com.tencent.mm.kernel.g.afC();
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fvw, Long.valueOf(0L))).longValue() & 0x3;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (bt.aw(l, 2L))
    {
      localIconPreference.setSummary(this.zTZ.zRZ);
      label275:
      if ((paramBoolean) && (this.zTZ.zRW))
      {
        com.tencent.mm.kernel.g.afC();
        if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fvy, Boolean.FALSE)).booleanValue()) {
          break label374;
        }
        localIconPreference.XS(0);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fvy, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.cE("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.setSummary(this.zTZ.zRX);
      break label275;
      label374:
      localIconPreference.XS(8);
    }
  }
  
  private void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.zUo == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.cE("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.zUo.ntx != 0) || (!this.zUo.nsQ))
    {
      this.screen.cE("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (bt.isNullOrNil(this.zUo.zRV))
    {
      this.screen.cE("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.zUd.setTitle(this.zUo.zRV);
    atK(this.zUo.doh);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.zUd;
      paramBoolean = this.zUo.zSj;
    }
    for (;;)
    {
      localCheckBoxPreference.lG = paramBoolean;
      this.screen.cE("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.g.afC();
      int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FvJ, Integer.valueOf(0))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.zUd;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  protected int eaV()
  {
    return 2131951760;
  }
  
  protected void eaW()
  {
    AppMethodBeat.i(69759);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void eaX()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.fjk();
    if (com.tencent.mm.wallet_core.b.b(b.a.prf, false))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69760);
      return;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    AppMethodBeat.o(69760);
  }
  
  protected void eaY()
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
    if ((s.ecc().ecH()) || (s.ecc().ecG()))
    {
      this.screen.cE("wallet_modify_password", true);
      this.screen.cE("wallet_forget_password", true);
      this.screen.cE("wallet_realname_verify", false);
      this.screen.aKk("wallet_realname_verify").setSummary(2131765642);
      this.screen.cE("wallet_universal_pay_order", true);
      this.screen.cE("wallet_switch_currency", true);
      this.screen.cE("wallet_switch_category", true);
      this.screen.cE("wallet_biometric_pay", true);
      this.screen.cE("wallet_universal_pay_order", true);
      this.screen.cE("wallet_digitalcert", true);
      this.zUm = s.ecb().aug("wallet_switch_currency");
      if ((this.zUm == null) || (this.zUm.field_is_show != 1)) {
        break label688;
      }
      this.screen.cE("wallet_switch_currency", false);
      localObject1 = this.screen.aKk("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.zUm.field_pref_title);
      ((Preference)localObject1).setSummary(this.zUm.field_pref_desc);
      bool1 = false;
      this.zUn = s.ecb().aug("wallet_im_mch");
      if ((this.zUn == null) || (this.zUn.field_is_show != 1)) {
        break label707;
      }
      this.screen.cE("wallet_im_mch", false);
      localObject1 = this.screen.aKk("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.zUn.field_pref_title);
      ((Preference)localObject1).setSummary(this.zUn.field_pref_desc);
      bool2 = false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.cE("wallet_switch_category", true);
      com.tencent.mm.kernel.g.afC();
      l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(147457, Long.valueOf(0L))).longValue();
      i = 2131765234;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = 2131765233;
      this.screen.aKk("wallet_delay_transfer_date").setSummary(i);
      j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqu, 0);
      if ((!com.tencent.mm.sdk.a.b.eEQ()) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.cE("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      sy(false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.zUu == null) || (this.zUu.size() <= 0)) {
        break label793;
      }
      localObject1 = this.zUu.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.d((Preference)localObject2);
      }
      if (s.ecc().ecF())
      {
        this.screen.cE("wallet_modify_password", false);
        this.screen.cE("wallet_forget_password", false);
        this.screen.cE("wallet_realname_verify", false);
        this.screen.aKk("wallet_realname_verify").setSummary(2131765648);
        this.screen.cE("wallet_universal_pay_order", true);
        eaZ();
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.cE("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.cE("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.cE("wallet_switch_category", false);
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
      this.screen.cE("wallet_function_settings", false);
    }
    this.zUu.clear();
    label793:
    int i = this.screen.indexOf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.g.afC();
    Object localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FvM, "");
    if (!bt.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = m.a.aK(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).zSu != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).zSu;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).Ggb = true;
            ((PreferenceTitleCategory)localObject4).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dbp)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.zUu.add(localObject4);
            localObject3 = ((m.a)localObject2).zSt.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (af)((Iterator)localObject3).next();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
            WalletPasswordSettingUI.10 local10 = new WalletPasswordSettingUI.10(this, getContext());
            local10.setLayoutResource(2131494804);
            local10.setTitle(((af)localObject4).field_pref_title);
            local10.setSummary(((af)localObject4).field_pref_desc);
            local10.GfO = new Preference.b()
            {
              public final boolean dbW()
              {
                AppMethodBeat.i(187143);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.zUB);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(187143);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.zUu.add(local10);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
            continue;
            this.screen.notifyDataSetChanged();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", " parse EXTRA_Data failed :%s", new Object[] { localJSONException.getMessage() });
      }
      for (;;)
      {
        AppMethodBeat.o(69765);
        return;
        localObject3 = new PreferenceSmallCategory(getContext());
        i += 1;
        this.screen.a((Preference)localObject3, i);
        this.zUu.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).zSv != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).zSv;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).Ggb = true;
          ((PreferenceFooterCategory)localObject3).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dbp)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.zUu.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.zUu.add(localObject2);
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
    if (u.aqV()) {}
    for (String str = getString(2131765654);; str = getString(2131765653))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.e.fkz();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(eaV());
      this.zUg = ((IconPreference)this.screen.aKk("wallet_open_auto_pay"));
      this.zUh = this.screen.aKk("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.afC();
      if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkE, Boolean.TRUE)).booleanValue())
      {
        this.zUg.fW(getString(2131755829), 2131233430);
        this.zUg.XR(0);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FkE, Boolean.TRUE);
      }
      this.zUb = ((CheckBoxPreference)this.screen.aKk("wallet_fingerprint_switch"));
      this.zUc = ((RightBelowPreference)this.screen.aKk("wallet_biometric_pay"));
      this.zUd = ((CheckBoxPreference)this.screen.aKk("mobile_remit_switch"));
      eaY();
      this.screen.cE("nfc_idpay", true);
      this.screen.cE("wallet_open_auto_pay", true);
      this.screen.cE("wallet_universal_pay_order", true);
      this.screen.cE("wallet_lucky_money_refund_way", true);
      eaU();
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
      if (com.tencent.mm.plugin.wallet.b.a.ebh()) {
        com.tencent.mm.plugin.report.service.h.vKh.f(15817, new Object[] { Integer.valueOf(0) });
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
      if (!u.aqW()) {
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1477, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1813, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1724, this);
    com.tencent.mm.sdk.b.a.ESL.c(this.zNH);
    this.zUw.alive();
    this.fYH = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.zUf = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.fYH)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fvx, "");
    label356:
    int i;
    if (!bt.isNullOrNil(paramBundle))
    {
      this.zTZ = f.a.atI(paramBundle);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.zTZ });
      sy(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      s.ebW();
      boolean bool = s.ecl();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label709;
      }
      paramBundle = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FvK, "");
      if (bt.isNullOrNil(paramBundle)) {
        break label698;
      }
      this.zUo = h.a.atJ(paramBundle);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.zTZ });
      sz(false);
      com.tencent.mm.kernel.g.afC();
      this.zUt = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FvL, Integer.valueOf(2))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.zUt) });
      if (this.zUt == 0) {
        this.zUt = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.zUt);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      label453:
      com.tencent.mm.kernel.g.afC();
      long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkG, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.afC();
      i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkH, Integer.valueOf(0))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > l + i)) {
        break label717;
      }
      i = 0;
      label579:
      if (i == 0) {
        break label722;
      }
      sx(false);
      label588:
      com.tencent.mm.kernel.g.afC();
      this.zUr = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnl, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.afC();
      this.zUk = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fng, ""));
      if (!bt.isNullOrNil(this.zUk)) {
        break label899;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      if (this.zUr == 0) {
        this.screen.cE("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label698:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label356;
      label709:
      sz(false);
      break label453;
      label717:
      i = 1;
      break label579;
      label722:
      com.tencent.mm.kernel.g.afC();
      this.zUj = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkN, ""));
      this.zUl = s.ecb().aug("wallet_open_auto_pay");
      if ((this.zUl != null) && (this.zUl.field_is_show == 1) && (!bt.isNullOrNil(this.zUl.field_pref_url)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.zUi = this.zUl.field_pref_url;
        jC(this.zUl.field_pref_title, this.zUl.field_pref_url);
        break label588;
      }
      if (this.zUl == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label588;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.zUl.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bt.isNullOrNil(this.zUl.field_pref_url));
      break label588;
      label899:
      this.zUh.setTitle(this.zUk);
      aj.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.zNH);
    this.zUw.dead();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1477, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1813, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      eaW();
      com.tencent.mm.wallet_core.ui.e.aby(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.afC();
      paramf = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkW, "");
      if (!bt.isNullOrNil(paramf))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.o(getContext(), paramf, false);
        paramf = new em();
        paramf.dZv = 2L;
        paramf.dZw = 2L;
        paramf.aBj();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = s.ecc().ecS();
      if (!bt.isNullOrNil(paramf))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.o(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      eaX();
      paramf = new em();
      paramf.dZv = 2L;
      paramf.dZw = 1L;
      paramf.aBj();
      com.tencent.mm.wallet_core.ui.e.aby(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (s.ecc().ecF()) {
        if (!bt.isNullOrNil(this.zUj))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.zUj);
          paramf.putExtra("showShare", false);
          paramf.putExtra(e.m.FIC, true);
          com.tencent.mm.wallet_core.ui.e.X(getContext(), paramf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(69762);
        return true;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
        paramf = new Bundle();
        paramf.putInt("real_name_verify_mode", 0);
        paramf.putString("realname_verify_process_jump_plugin", "wallet");
        paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.zUx);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.zTZ.eaA().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new ej();
      com.tencent.mm.kernel.g.afC();
      if (bt.aw(((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fvw, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.dZl = i;
        paramf.aBj();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      if (!bt.isNullOrNil(this.zUi))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.zUi);
        paramf.putExtra("showShare", false);
        paramf.putExtra(e.m.FIC, true);
        com.tencent.mm.wallet_core.ui.e.X(getContext(), paramf);
        this.zUg.XR(8);
        AppMethodBeat.o(69762);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.zUq)
      {
        paramf = new m();
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramf, 0);
      }
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.afC();
      paramf = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frc, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(e.m.FIC, true);
      com.tencent.mm.wallet_core.ui.e.X(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.zUm);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.zUn);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.bs.d.O(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.zUp = new eq();
        this.zUp.dFd = i;
        if (this.scene != 0) {
          break label1387;
        }
        this.zUp.dZB = 2L;
        label1302:
        this.zUp.aBj();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.zUt);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramf, 0);
        if (this.zUe != null) {
          break label1406;
        }
        this.zUe = com.tencent.mm.ui.base.h.a(this, 0, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(69750);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
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
        label1387:
        if (this.scene != 1) {
          break label1302;
        }
        this.zUp.dZB = 1L;
        break label1302;
        label1406:
        this.zUe.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).efP())
    {
      finish();
      AppMethodBeat.o(69757);
      return;
    }
    eaY();
    if (this.zUv)
    {
      this.zUv = false;
      sx(false);
    }
    AppMethodBeat.o(69757);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(69768);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        eaY();
        paramString = (m)paramn;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.zSn);
        this.zUj = paramString.zSr;
        if (paramString.zSn == 1)
        {
          this.zUi = paramString.zSo;
          jC(bt.by(paramString.zSq, getString(2131765682)), paramString.zSo);
        }
        for (;;)
        {
          eaU();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.cE("wallet_open_auto_pay", true);
        }
      }
      if ((paramn instanceof aj))
      {
        this.zUk = ((aj)paramn).zWO;
        this.zUr = ((aj)paramn).zWT;
        if (this.zUr == 0)
        {
          this.screen.cE("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!bt.isNullOrNil(this.zUk)) {
          this.zUh.setTitle(this.zUk);
        }
        for (;;)
        {
          this.screen.cE("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.zTZ = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramn).eaz();
        sy(true);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.zTZ.eaA() });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fvx, this.zTZ.eaA());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramn;
        if (paramString.zSi == null)
        {
          paramString.zSi = new h.a();
          paramString.zSi.ntx = paramString.zSh.ntx;
          paramString.zSi.nty = paramString.zSh.nty;
          paramString.zSi.nsQ = paramString.zSh.nsQ;
          paramString.zSi.zSj = paramString.zSh.zSj;
          paramString.zSi.zRV = paramString.zSh.zRV;
          paramString.zSi.doh = paramString.zSh.doh;
        }
        this.zUo = paramString.zSi;
        sz(true);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.zUo.eaA() });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvK, this.zUo.eaA());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.zUe != null) && (this.zUe.isShowing())) {
          this.zUe.dismiss();
        }
        paramn = (com.tencent.mm.plugin.wallet.pwd.a.g)paramn;
        if (paramn.zSg == null)
        {
          paramn = new ddv();
          if (paramn == null)
          {
            if (!bt.isNullOrNil(paramString)) {
              break label867;
            }
            paramString = getString(2131765224);
            label649:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
          }
          paramInt1 = paramn.ntx;
          paramString = paramn.nty;
          if (paramn.CTW != null) {
            break label870;
          }
          bool1 = true;
          label694:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramn.Evu), paramn.doh });
          paramInt1 = paramn.Evu;
          paramString = paramn.doh;
          if (!bt.isNullOrNil(paramString)) {
            break label876;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label771:
          if (paramn.ntx != 0) {
            break label1011;
          }
          if (paramn.Evv == null) {
            break label947;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          l.a(getContext(), paramn.Evv, null, new l.a()
          {
            public final void dB(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void djE()
            {
              AppMethodBeat.i(163865);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int djF()
            {
              return 1149;
            }
            
            public final void djG()
            {
              AppMethodBeat.i(163866);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void djH()
            {
              AppMethodBeat.i(163867);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(69739);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.zUd;
          if (this.zUd.isChecked()) {
            break label941;
          }
        }
        label941:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.lG = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramn = paramn.zSg;
          break;
          label867:
          break label649;
          label870:
          bool1 = false;
          break label694;
          label876:
          this.zUt = paramInt1;
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvL, Integer.valueOf(paramInt1));
          this.zUo.doh = paramString;
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvK, this.zUo.eaA());
          atK(paramString);
          this.screen.notifyDataSetChanged();
          break label771;
        }
        label947:
        if (this.zUd.isChecked())
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvJ, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvJ, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1011:
        if (paramn.ntx == 416) {
          if (paramn.CTW != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramn.ntx;
            paramn = paramn.CTW;
            new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69741);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.o(69741);
              }
            };
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt1, paramn, paramString, 1012);
            paramString = this.zUd;
            if (this.zUd.isChecked()) {
              break label1287;
            }
          }
        }
        label1287:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.lG = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (bt.isNullOrNil(paramn.nty)) {}
          for (paramString = getString(2131765224);; paramString = paramn.nty)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
          if (paramn.Evv != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            l.a(getContext(), paramn.Evv, null, new l.a()
            {
              public final void dB(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void djE()
              {
                AppMethodBeat.i(163868);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int djF()
              {
                return 1149;
              }
              
              public final void djG()
              {
                AppMethodBeat.i(163869);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void djH()
              {
                AppMethodBeat.i(163870);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void djL()
              {
                AppMethodBeat.i(69742);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramn.ntx == 0) {
            break;
          }
          if (bt.isNullOrNil(paramn.nty)) {}
          for (paramString = getString(2131765224);; paramString = paramn.nty)
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
        if ((this.zUe != null) && (this.zUe.isShowing())) {
          this.zUe.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131761270);
        }
        t.makeText(localAppCompatActivity, paramn, 0).show();
        paramString = this.zUd;
        if (this.zUd.isChecked()) {
          break label1475;
        }
      }
    }
    for (;;)
    {
      paramString.lG = bool1;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69768);
      return;
      label1475:
      bool1 = false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */