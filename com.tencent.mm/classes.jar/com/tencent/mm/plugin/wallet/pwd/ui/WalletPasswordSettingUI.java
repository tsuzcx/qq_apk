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
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
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
  implements com.tencent.mm.ak.f
{
  c CXV;
  private String DeA;
  private String DeB;
  private ag DeC;
  private ag DeD;
  private ag DeE;
  private h.a DeF;
  private hl DeG;
  private boolean DeH;
  private int DeI;
  private int DeJ;
  private int DeK;
  private List<Preference> DeL;
  private boolean DeM;
  private c<nv> DeN;
  private d.a DeO;
  private f.a Deq;
  CheckBoxPreference Des;
  RightBelowPreference Det;
  CheckBoxPreference Deu;
  private Dialog Dev;
  private boolean Dew;
  private IconPreference Dex;
  private Preference Dey;
  private String Dez;
  private boolean gzE;
  private aq handler;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.Dev = null;
    this.Dew = false;
    this.DeH = false;
    this.DeI = 0;
    this.DeJ = 0;
    this.handler = new aq(new aq.a()
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
    this.DeK = 2;
    this.DeL = new ArrayList();
    this.DeM = false;
    this.CXV = new c() {};
    this.DeN = new c() {};
    this.DeO = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        ae.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new yq();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.dNW.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.dNX.dNO = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.eIb();
              AppMethodBeat.o(69748);
            }
          };
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.dNW.scene = 18;
          } else {
            paramAnonymousBundle.dNW.scene = 0;
          }
        }
      }
    };
    AppMethodBeat.o(69753);
  }
  
  private void a(ag paramag)
  {
    AppMethodBeat.i(69763);
    switch (paramag.field_jump_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69763);
      return;
      ae.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramag.field_pref_url });
      if (!bu.isNullOrNil(paramag.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.f.o(this, paramag.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!bu.isNullOrNil(paramag.field_tinyapp_username))
        {
          vq localvq = new vq();
          localvq.dKT.userName = paramag.field_tinyapp_username;
          localvq.dKT.dKV = bu.bI(paramag.field_tinyapp_path, "");
          localvq.dKT.scene = 1066;
          localvq.dKT.dKW = 0;
          com.tencent.mm.sdk.b.a.IvT.l(localvq);
          AppMethodBeat.o(69763);
          return;
          ae.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.br.d.Q(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          ae.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramag = new Intent();
          paramag.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramag);
          new hi();
          AppMethodBeat.o(69763);
          return;
          ae.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.br.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          ae.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.br.d.Q(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void aFD(String paramString)
  {
    AppMethodBeat.i(182520);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
      AppMethodBeat.o(182520);
      return;
    }
    if (paramString.contains("wc_custom_link"))
    {
      paramString = k.a(this, paramString, 10, false, null);
      this.Deu.JOv = true;
      this.Deu.setSummary(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.Deu.setSummary(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(190156);
    this.Dex.setTitle(paramString1);
    if ((!bu.isNullOrNil(paramString2)) || (!bu.isNullOrNil(paramString3)))
    {
      this.screen.cT("wallet_open_auto_pay", false);
      AppMethodBeat.o(190156);
      return;
    }
    this.screen.cT("wallet_open_auto_pay", true);
    ae.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(190156);
  }
  
  private void eHX()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.g.ajS();
    String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVL, "");
    com.tencent.mm.kernel.g.ajS();
    String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVM, "");
    ae.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2)))
    {
      this.screen.cT("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.cT("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void eIc()
  {
    AppMethodBeat.i(69766);
    if ((com.tencent.mm.plugin.wallet_core.model.t.eJf().eJJ()) || (com.tencent.mm.plugin.wallet_core.model.t.eJf().eJI()))
    {
      this.screen.cT("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.eIj()) && (com.tencent.mm.plugin.wallet.b.a.eIk()))
    {
      this.Det.setTitle(2131765632);
      this.Det.setSummary(2131765631);
      if (locala.cRW()) {
        this.Det.O(getString(2131765076));
      }
      for (;;)
      {
        this.screen.cT("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.cRT()) {
          this.Det.O(getString(2131765077));
        } else {
          this.Det.O(getString(2131764341));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eIj())
    {
      this.Det.setTitle(2131765630);
      this.Det.setSummary(2131765629);
      if (locala.cRT()) {
        this.Det.O(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cT("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Det.O(getString(2131764341));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eIk())
    {
      this.Det.setTitle(2131765628);
      this.Det.setSummary(2131765627);
      if (locala.cRW()) {
        this.Det.O(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cT("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Det.O(getString(2131764341));
      }
    }
    this.screen.cT("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  private void up(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.Des.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void uq(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(localm, 0);
    this.DeH = true;
    if (paramBoolean) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(this, false, new DialogInterface.OnCancelListener()
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
  
  private void ur(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.Deq == null)
    {
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.cT("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.Deq.Dcs), Integer.valueOf(this.Deq.dmy), this.Deq.Dcj });
      if ((!this.Deq.Dcs) && (bu.jB(this.Deq.dmy, 0))) {
        break;
      }
      this.screen.cT("wallet_lucky_money_refund_way", true);
    }
    if (bu.isNullOrNil(this.Deq.Dcj))
    {
      this.screen.cT("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.Deq.Dcj);
    com.tencent.mm.kernel.g.ajS();
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jav, Long.valueOf(0L))).longValue() & 0x3;
    ae.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (bu.az(l, 2L))
    {
      localIconPreference.setSummary(this.Deq.Dcn);
      label275:
      if ((paramBoolean) && (this.Deq.Dck))
      {
        com.tencent.mm.kernel.g.ajS();
        if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jax, Boolean.FALSE)).booleanValue()) {
          break label374;
        }
        localIconPreference.acU(0);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jax, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.cT("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.setSummary(this.Deq.Dcl);
      break label275;
      label374:
      localIconPreference.acU(8);
    }
  }
  
  private void us(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    ae.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.DeF == null)
    {
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.cT("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.DeF.oGt != 0) || (!this.DeF.oFM))
    {
      this.screen.cT("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (bu.isNullOrNil(this.DeF.Dcj))
    {
      this.screen.cT("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.Deu.setTitle(this.DeF.Dcj);
    aFD(this.DeF.dyI);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.Deu;
      paramBoolean = this.DeF.Dcx;
    }
    for (;;)
    {
      localCheckBoxPreference.setChecked(paramBoolean);
      this.screen.cT("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.g.ajS();
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JaI, Integer.valueOf(0))).intValue();
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.Deu;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  protected int eHY()
  {
    return 2131951760;
  }
  
  protected void eHZ()
  {
    AppMethodBeat.i(69759);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void eIa()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.fVf();
    if (com.tencent.mm.wallet_core.b.b(b.a.qGE, false))
    {
      ae.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69760);
      return;
      ae.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    AppMethodBeat.o(69760);
  }
  
  protected void eIb()
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
    if ((com.tencent.mm.plugin.wallet_core.model.t.eJf().eJJ()) || (com.tencent.mm.plugin.wallet_core.model.t.eJf().eJI()))
    {
      this.screen.cT("wallet_modify_password", true);
      this.screen.cT("wallet_forget_password", true);
      this.screen.cT("wallet_realname_verify", false);
      this.screen.aXe("wallet_realname_verify").setSummary(2131765642);
      this.screen.cT("wallet_universal_pay_order", true);
      this.screen.cT("wallet_switch_currency", true);
      this.screen.cT("wallet_switch_category", true);
      this.screen.cT("wallet_biometric_pay", true);
      this.screen.cT("wallet_universal_pay_order", true);
      this.screen.cT("wallet_digitalcert", true);
      this.DeD = com.tencent.mm.plugin.wallet_core.model.t.eJe().aGc("wallet_switch_currency");
      if ((this.DeD == null) || (this.DeD.field_is_show != 1)) {
        break label688;
      }
      this.screen.cT("wallet_switch_currency", false);
      localObject1 = this.screen.aXe("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.DeD.field_pref_title);
      ((Preference)localObject1).setSummary(this.DeD.field_pref_desc);
      bool1 = false;
      this.DeE = com.tencent.mm.plugin.wallet_core.model.t.eJe().aGc("wallet_im_mch");
      if ((this.DeE == null) || (this.DeE.field_is_show != 1)) {
        break label707;
      }
      this.screen.cT("wallet_im_mch", false);
      localObject1 = this.screen.aXe("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.DeE.field_pref_title);
      ((Preference)localObject1).setSummary(this.DeE.field_pref_desc);
      bool2 = false;
      ae.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.cT("wallet_switch_category", true);
      com.tencent.mm.kernel.g.ajS();
      l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(147457, Long.valueOf(0L))).longValue();
      i = 2131765234;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = 2131765233;
      this.screen.aXe("wallet_delay_transfer_date").setSummary(i);
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFT, 0);
      if ((!com.tencent.mm.sdk.a.b.fnF()) && (!j.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.cT("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      ur(false);
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.DeL == null) || (this.DeL.size() <= 0)) {
        break label793;
      }
      localObject1 = this.DeL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.d((Preference)localObject2);
      }
      if (com.tencent.mm.plugin.wallet_core.model.t.eJf().eJH())
      {
        this.screen.cT("wallet_modify_password", false);
        this.screen.cT("wallet_forget_password", false);
        this.screen.cT("wallet_realname_verify", false);
        this.screen.aXe("wallet_realname_verify").setSummary(2131765648);
        this.screen.cT("wallet_universal_pay_order", true);
        eIc();
        break;
      }
      ae.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.cT("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.cT("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.cT("wallet_switch_category", false);
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
      this.screen.cT("wallet_function_settings", false);
    }
    this.DeL.clear();
    label793:
    int i = this.screen.indexOf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.g.ajS();
    Object localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JaM, "");
    if (!bu.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = m.a.aT(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).DcI != null)
          {
            ae.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).DcI;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).JOw = true;
            ((PreferenceTitleCategory)localObject4).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dnl)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.DeL.add(localObject4);
            localObject3 = ((m.a)localObject2).DcH.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (ag)((Iterator)localObject3).next();
            ae.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
            WalletPasswordSettingUI.10 local10 = new WalletPasswordSettingUI.10(this, getContext());
            local10.setLayoutResource(2131494804);
            local10.setTitle(((ag)localObject4).field_pref_title);
            local10.setSummary(((ag)localObject4).field_pref_desc);
            local10.JOj = new Preference.b()
            {
              public final boolean dDy()
              {
                AppMethodBeat.i(190155);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.DeS);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(190155);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.DeL.add(local10);
            ae.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
            continue;
            this.screen.notifyDataSetChanged();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        ae.e("MicroMsg.WalletPasswordSettingUI", " parse EXTRA_Data failed :%s", new Object[] { localJSONException.getMessage() });
      }
      for (;;)
      {
        AppMethodBeat.o(69765);
        return;
        localObject3 = new PreferenceSmallCategory(getContext());
        i += 1;
        this.screen.a((Preference)localObject3, i);
        this.DeL.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).DcJ != null)
        {
          ae.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).DcJ;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).JOw = true;
          ((PreferenceFooterCategory)localObject3).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dnl)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.DeL.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.DeL.add(localObject2);
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
    if (v.aAR()) {}
    for (String str = getString(2131765654);; str = getString(2131765653))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.f.fWv();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(eHY());
      this.Dex = ((IconPreference)this.screen.aXe("wallet_open_auto_pay"));
      this.Dey = this.screen.aXe("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.ajS();
      if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPj, Boolean.TRUE)).booleanValue())
      {
        this.Dex.gG(getString(2131755829), 2131233430);
        this.Dex.acT(0);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPj, Boolean.TRUE);
      }
      this.Des = ((CheckBoxPreference)this.screen.aXe("wallet_fingerprint_switch"));
      this.Det = ((RightBelowPreference)this.screen.aXe("wallet_biometric_pay"));
      this.Deu = ((CheckBoxPreference)this.screen.aXe("mobile_remit_switch"));
      eIb();
      this.screen.cT("nfc_idpay", true);
      this.screen.cT("wallet_open_auto_pay", true);
      this.screen.cT("wallet_universal_pay_order", true);
      this.screen.cT("wallet_lucky_money_refund_way", true);
      eHX();
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
      if (com.tencent.mm.plugin.wallet.b.a.eIk()) {
        com.tencent.mm.plugin.report.service.g.yxI.f(15817, new Object[] { Integer.valueOf(0) });
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
      if (!v.aAS()) {
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(385, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1477, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1813, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1724, this);
    com.tencent.mm.sdk.b.a.IvT.c(this.CXV);
    this.DeN.alive();
    this.gzE = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.Dew = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.gzE)
    {
      ae.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jaw, "");
    label356:
    int i;
    if (!bu.isNullOrNil(paramBundle))
    {
      this.Deq = f.a.aFB(paramBundle);
      ae.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.Deq });
      ur(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      com.tencent.mm.plugin.wallet_core.model.t.eIZ();
      boolean bool = com.tencent.mm.plugin.wallet_core.model.t.eJo();
      ae.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label709;
      }
      paramBundle = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JaJ, "");
      if (bu.isNullOrNil(paramBundle)) {
        break label698;
      }
      this.DeF = h.a.aFC(paramBundle);
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.Deq });
      us(false);
      com.tencent.mm.kernel.g.ajS();
      this.DeK = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JaK, Integer.valueOf(2))).intValue();
      ae.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.DeK) });
      if (this.DeK == 0) {
        this.DeK = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.DeK);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      label453:
      com.tencent.mm.kernel.g.ajS();
      long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPl, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.ajS();
      i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPm, Integer.valueOf(0))).intValue();
      ae.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > l + i)) {
        break label717;
      }
      i = 0;
      label579:
      if (i == 0) {
        break label722;
      }
      uq(false);
      label588:
      com.tencent.mm.kernel.g.ajS();
      this.DeI = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRQ, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.ajS();
      this.DeB = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRL, ""));
      if (!bu.isNullOrNil(this.DeB)) {
        break label893;
      }
      com.tencent.mm.plugin.wallet_core.c.aj.a(true, null);
    }
    for (;;)
    {
      if (this.DeI == 0) {
        this.screen.cT("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label698:
      ae.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label356;
      label709:
      us(false);
      break label453;
      label717:
      i = 1;
      break label579;
      label722:
      com.tencent.mm.kernel.g.ajS();
      this.DeA = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPs, ""));
      this.DeC = com.tencent.mm.plugin.wallet_core.model.t.eJe().aGc("wallet_open_auto_pay");
      if ((this.DeC != null) && (this.DeC.field_is_show == 1))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.Dez = this.DeC.field_pref_url;
        aO(this.DeC.field_pref_title, this.DeC.field_pref_url, this.DeC.field_tinyapp_path);
        break label588;
      }
      if (this.DeC == null)
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label588;
      }
      ae.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.DeC.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bu.isNullOrNil(this.DeC.field_pref_url));
      break label588;
      label893:
      this.Dey.setTitle(this.DeB);
      com.tencent.mm.plugin.wallet_core.c.aj.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.CXV);
    this.DeN.dead();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1477, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1813, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      eHZ();
      com.tencent.mm.wallet_core.ui.f.aha(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.ajS();
      paramf = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPB, "");
      if (!bu.isNullOrNil(paramf))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.f.o(getContext(), paramf, false);
        paramf = new hh();
        paramf.etA = 2L;
        paramf.etB = 2L;
        paramf.aLH();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = com.tencent.mm.plugin.wallet_core.model.t.eJf().eJU();
      if (!bu.isNullOrNil(paramf))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.f.o(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      eIa();
      paramf = new hh();
      paramf.etA = 2L;
      paramf.etB = 1L;
      paramf.aLH();
      com.tencent.mm.wallet_core.ui.f.aha(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.plugin.wallet_core.model.t.eJf().eJH()) {
        if (!bu.isNullOrNil(this.DeA))
        {
          ae.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.DeA);
          paramf.putExtra("showShare", false);
          paramf.putExtra(e.m.JpI, true);
          com.tencent.mm.wallet_core.ui.f.an(getContext(), paramf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(69762);
        return true;
        ae.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
        continue;
        ae.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
        paramf = new Bundle();
        paramf.putInt("real_name_verify_mode", 0);
        paramf.putString("realname_verify_process_jump_plugin", "wallet");
        paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.DeO);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.Deq.eHD().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new he();
      com.tencent.mm.kernel.g.ajS();
      if (bu.az(((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jav, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.dWW = i;
        paramf.aLH();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.DeC);
      this.Dex.acT(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.DeH)
      {
        paramf = new m();
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramf, 0);
      }
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.ajS();
      paramf = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVM, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(e.m.JpI, true);
      com.tencent.mm.wallet_core.ui.f.an(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.DeD);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.DeE);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.d.Q(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.DeG = new hl();
        this.DeG.dQB = i;
        if (this.scene != 0) {
          break label1323;
        }
        this.DeG.etF = 2L;
        label1238:
        this.DeG.aLH();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.DeK);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramf, 0);
        if (this.Dev != null) {
          break label1342;
        }
        this.Dev = com.tencent.mm.ui.base.h.a(this, 0, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(69750);
            ae.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
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
        this.DeG.etF = 1L;
        break label1238;
        label1342:
        this.Dev.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).eMX())
    {
      finish();
      AppMethodBeat.o(69757);
      return;
    }
    eIb();
    if (this.DeM)
    {
      this.DeM = false;
      uq(false);
    }
    AppMethodBeat.o(69757);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(69768);
    ae.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        eIb();
        paramString = (m)paramn;
        ae.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.DcB);
        this.DeA = paramString.DcF;
        this.DeC = com.tencent.mm.plugin.wallet_core.model.t.eJe().aGc("wallet_open_auto_pay");
        if ((this.DeC != null) && (this.DeC.field_is_show == 1))
        {
          ae.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.Dez = this.DeC.field_pref_url;
          aO(this.DeC.field_pref_title, this.DeC.field_pref_url, this.DeC.field_tinyapp_path);
        }
        for (;;)
        {
          eHX();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.cT("wallet_open_auto_pay", true);
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
      {
        this.DeB = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhc;
        this.DeI = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhh;
        if (this.DeI == 0)
        {
          this.screen.cT("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!bu.isNullOrNil(this.DeB)) {
          this.Dey.setTitle(this.DeB);
        }
        for (;;)
        {
          this.screen.cT("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          ae.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.Deq = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramn).eHC();
        ur(true);
        ae.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.Deq.eHD() });
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jaw, this.Deq.eHD());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramn;
        if (paramString.Dcw == null)
        {
          paramString.Dcw = new h.a();
          paramString.Dcw.oGt = paramString.Dcv.oGt;
          paramString.Dcw.oGu = paramString.Dcv.oGu;
          paramString.Dcw.oFM = paramString.Dcv.oFM;
          paramString.Dcw.Dcx = paramString.Dcv.Dcx;
          paramString.Dcw.Dcj = paramString.Dcv.Dcj;
          paramString.Dcw.dyI = paramString.Dcv.dyI;
        }
        this.DeF = paramString.Dcw;
        us(true);
        ae.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.DeF.eHD() });
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaJ, this.DeF.eHD());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.Dev != null) && (this.Dev.isShowing())) {
          this.Dev.dismiss();
        }
        paramn = (com.tencent.mm.plugin.wallet.pwd.a.g)paramn;
        if (paramn.Dcu == null)
        {
          paramn = new dpw();
          if (paramn == null)
          {
            if (!bu.isNullOrNil(paramString)) {
              break label904;
            }
            paramString = getString(2131765224);
            label686:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
          }
          paramInt1 = paramn.oGt;
          paramString = paramn.oGu;
          if (paramn.Gmp != null) {
            break label907;
          }
          bool1 = true;
          label731:
          ae.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramn.HWT), paramn.dyI });
          paramInt1 = paramn.HWT;
          paramString = paramn.dyI;
          if (!bu.isNullOrNil(paramString)) {
            break label913;
          }
          ae.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label808:
          if (paramn.oGt != 0) {
            break label1048;
          }
          if (paramn.HWU == null) {
            break label984;
          }
          ae.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          l.a(getContext(), paramn.HWU, null, new l.a()
          {
            public final void dG(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void dMp()
            {
              AppMethodBeat.i(163865);
              ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int dMq()
            {
              return 1149;
            }
            
            public final void dMr()
            {
              AppMethodBeat.i(163866);
              ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void dMs()
            {
              AppMethodBeat.i(163867);
              ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(69739);
              ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.Deu;
          if (this.Deu.isChecked()) {
            break label978;
          }
        }
        label904:
        label907:
        label913:
        label978:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramn = paramn.Dcu;
          break;
          break label686;
          bool1 = false;
          break label731;
          this.DeK = paramInt1;
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaK, Integer.valueOf(paramInt1));
          this.DeF.dyI = paramString;
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaJ, this.DeF.eHD());
          aFD(paramString);
          this.screen.notifyDataSetChanged();
          break label808;
        }
        label984:
        if (this.Deu.isChecked())
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaI, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaI, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1048:
        if (paramn.oGt == 416) {
          if (paramn.Gmp != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramn.oGt;
            paramn = paramn.Gmp;
            new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69741);
                ae.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.o(69741);
              }
            };
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt1, paramn, paramString, 1012);
            paramString = this.Deu;
            if (this.Deu.isChecked()) {
              break label1324;
            }
          }
        }
        label1324:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (bu.isNullOrNil(paramn.oGu)) {}
          for (paramString = getString(2131765224);; paramString = paramn.oGu)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
          if (paramn.HWU != null)
          {
            ae.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            l.a(getContext(), paramn.HWU, null, new l.a()
            {
              public final void dG(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void dMp()
              {
                AppMethodBeat.i(163868);
                ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int dMq()
              {
                return 1149;
              }
              
              public final void dMr()
              {
                AppMethodBeat.i(163869);
                ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void dMs()
              {
                AppMethodBeat.i(163870);
                ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void dMw()
              {
                AppMethodBeat.i(69742);
                ae.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramn.oGt == 0) {
            break;
          }
          if (bu.isNullOrNil(paramn.oGu)) {}
          for (paramString = getString(2131765224);; paramString = paramn.oGu)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
        }
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        ae.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
        if ((this.Dev != null) && (this.Dev.isShowing())) {
          this.Dev.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = getString(2131761270);
        }
        com.tencent.mm.ui.base.t.makeText(localAppCompatActivity, paramn, 0).show();
        paramString = this.Deu;
        if (this.Deu.isChecked()) {
          break label1512;
        }
      }
    }
    for (;;)
    {
      paramString.setChecked(bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */