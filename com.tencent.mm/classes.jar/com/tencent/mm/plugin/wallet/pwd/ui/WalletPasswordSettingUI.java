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
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.b.a.hc;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  implements com.tencent.mm.al.f
{
  c CGp;
  private f.a CMI;
  CheckBoxPreference CMK;
  RightBelowPreference CML;
  CheckBoxPreference CMM;
  private Dialog CMN;
  private boolean CMO;
  private IconPreference CMP;
  private Preference CMQ;
  private String CMR;
  private String CMS;
  private String CMT;
  private ag CMU;
  private ag CMV;
  private ag CMW;
  private h.a CMX;
  private hj CMY;
  private boolean CMZ;
  private int CNa;
  private int CNb;
  private int CNc;
  private List<Preference> CNd;
  private boolean CNe;
  private c<nu> CNf;
  private d.a CNg;
  private boolean gwX;
  private ap handler;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.CMN = null;
    this.CMO = false;
    this.CMZ = false;
    this.CNa = 0;
    this.CNb = 0;
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
    this.CNc = 2;
    this.CNd = new ArrayList();
    this.CNe = false;
    this.CGp = new c() {};
    this.CNf = new c() {};
    this.CNg = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new yk();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.dMG.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.dMH.dMy = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.eEu();
              AppMethodBeat.o(69748);
            }
          };
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.dMG.scene = 18;
          } else {
            paramAnonymousBundle.dMG.scene = 0;
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramag.field_pref_url });
      if (!bt.isNullOrNil(paramag.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.e.n(this, paramag.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!bt.isNullOrNil(paramag.field_tinyapp_username))
        {
          vm localvm = new vm();
          localvm.dJF.userName = paramag.field_tinyapp_username;
          localvm.dJF.dJH = bt.bI(paramag.field_tinyapp_path, "");
          localvm.dJF.scene = 1066;
          localvm.dJF.dJI = 0;
          com.tencent.mm.sdk.b.a.IbL.l(localvm);
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.bs.d.Q(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramag = new Intent();
          paramag.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramag);
          new hg();
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.bs.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.bs.d.Q(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void aEk(String paramString)
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
      this.CMM.JtG = true;
      this.CMM.setSummary(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.CMM.setSummary(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(199292);
    this.CMP.setTitle(paramString1);
    if ((!bt.isNullOrNil(paramString2)) || (!bt.isNullOrNil(paramString3)))
    {
      this.screen.cP("wallet_open_auto_pay", false);
      AppMethodBeat.o(199292);
      return;
    }
    this.screen.cP("wallet_open_auto_pay", true);
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(199292);
  }
  
  private void eEq()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.g.ajD();
    String str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBm, "");
    com.tencent.mm.kernel.g.ajD();
    String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBn, "");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
    {
      this.screen.cP("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.cP("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void eEv()
  {
    AppMethodBeat.i(69766);
    if ((com.tencent.mm.plugin.wallet_core.model.t.eFy().eGc()) || (com.tencent.mm.plugin.wallet_core.model.t.eFy().eGb()))
    {
      this.screen.cP("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.eEC()) && (com.tencent.mm.plugin.wallet.b.a.eED()))
    {
      this.CML.setTitle(2131765632);
      this.CML.setSummary(2131765631);
      if (locala.cPr()) {
        this.CML.P(getString(2131765076));
      }
      for (;;)
      {
        this.screen.cP("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.cPo()) {
          this.CML.P(getString(2131765077));
        } else {
          this.CML.P(getString(2131764341));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eEC())
    {
      this.CML.setTitle(2131765630);
      this.CML.setSummary(2131765629);
      if (locala.cPo()) {
        this.CML.P(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cP("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.CML.P(getString(2131764341));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.eED())
    {
      this.CML.setTitle(2131765628);
      this.CML.setSummary(2131765627);
      if (locala.cPr()) {
        this.CML.P(getString(2131764330));
      }
      for (;;)
      {
        this.screen.cP("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.CML.P(getString(2131764341));
      }
    }
    this.screen.cP("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  private void uh(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.CMK.oB = paramBoolean;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void ui(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(localm, 0);
    this.CMZ = true;
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
  
  private void uj(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.CMI == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.cP("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.CMI.CKM), Integer.valueOf(this.CMI.dlw), this.CMI.CKD });
      if ((!this.CMI.CKM) && (bt.jx(this.CMI.dlw, 0))) {
        break;
      }
      this.screen.cP("wallet_lucky_money_refund_way", true);
    }
    if (bt.isNullOrNil(this.CMI.CKD))
    {
      this.screen.cP("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.CMI.CKD);
    com.tencent.mm.kernel.g.ajD();
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFV, Long.valueOf(0L))).longValue() & 0x3;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (bt.aA(l, 2L))
    {
      localIconPreference.setSummary(this.CMI.CKH);
      label275:
      if ((paramBoolean) && (this.CMI.CKE))
      {
        com.tencent.mm.kernel.g.ajD();
        if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFX, Boolean.FALSE)).booleanValue()) {
          break label374;
        }
        localIconPreference.acn(0);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFX, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.cP("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.setSummary(this.CMI.CKF);
      break label275;
      label374:
      localIconPreference.acn(8);
    }
  }
  
  private void uk(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.CMX == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.cP("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.CMX.ozR != 0) || (!this.CMX.ozk))
    {
      this.screen.cP("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (bt.isNullOrNil(this.CMX.CKD))
    {
      this.screen.cP("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.CMM.setTitle(this.CMX.CKD);
    aEk(this.CMX.dxD);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.CMM;
      paramBoolean = this.CMX.CKR;
    }
    for (;;)
    {
      localCheckBoxPreference.oB = paramBoolean;
      this.screen.cP("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.g.ajD();
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IGi, Integer.valueOf(0))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.CMM;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  protected int eEr()
  {
    return 2131951760;
  }
  
  protected void eEs()
  {
    AppMethodBeat.i(69759);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void eEt()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.fQJ();
    if (com.tencent.mm.wallet_core.b.b(b.a.qzy, false))
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
  
  protected void eEu()
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
    if ((com.tencent.mm.plugin.wallet_core.model.t.eFy().eGc()) || (com.tencent.mm.plugin.wallet_core.model.t.eFy().eGb()))
    {
      this.screen.cP("wallet_modify_password", true);
      this.screen.cP("wallet_forget_password", true);
      this.screen.cP("wallet_realname_verify", false);
      this.screen.aVD("wallet_realname_verify").setSummary(2131765642);
      this.screen.cP("wallet_universal_pay_order", true);
      this.screen.cP("wallet_switch_currency", true);
      this.screen.cP("wallet_switch_category", true);
      this.screen.cP("wallet_biometric_pay", true);
      this.screen.cP("wallet_universal_pay_order", true);
      this.screen.cP("wallet_digitalcert", true);
      this.CMV = com.tencent.mm.plugin.wallet_core.model.t.eFx().aEI("wallet_switch_currency");
      if ((this.CMV == null) || (this.CMV.field_is_show != 1)) {
        break label688;
      }
      this.screen.cP("wallet_switch_currency", false);
      localObject1 = this.screen.aVD("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.CMV.field_pref_title);
      ((Preference)localObject1).setSummary(this.CMV.field_pref_desc);
      bool1 = false;
      this.CMW = com.tencent.mm.plugin.wallet_core.model.t.eFx().aEI("wallet_im_mch");
      if ((this.CMW == null) || (this.CMW.field_is_show != 1)) {
        break label707;
      }
      this.screen.cP("wallet_im_mch", false);
      localObject1 = this.screen.aVD("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.CMW.field_pref_title);
      ((Preference)localObject1).setSummary(this.CMW.field_pref_desc);
      bool2 = false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.cP("wallet_switch_category", true);
      com.tencent.mm.kernel.g.ajD();
      l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(147457, Long.valueOf(0L))).longValue();
      i = 2131765234;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = 2131765233;
      this.screen.aVD("wallet_delay_transfer_date").setSummary(i);
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyN, 0);
      if ((!com.tencent.mm.sdk.a.b.fjN()) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.cP("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      uj(false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.CNd == null) || (this.CNd.size() <= 0)) {
        break label793;
      }
      localObject1 = this.CNd.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.d((Preference)localObject2);
      }
      if (com.tencent.mm.plugin.wallet_core.model.t.eFy().eGa())
      {
        this.screen.cP("wallet_modify_password", false);
        this.screen.cP("wallet_forget_password", false);
        this.screen.cP("wallet_realname_verify", false);
        this.screen.aVD("wallet_realname_verify").setSummary(2131765648);
        this.screen.cP("wallet_universal_pay_order", true);
        eEv();
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.cP("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.cP("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.cP("wallet_switch_category", false);
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
      this.screen.cP("wallet_function_settings", false);
    }
    this.CNd.clear();
    label793:
    int i = this.screen.indexOf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.g.ajD();
    Object localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IGm, "");
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
          localObject2 = m.a.aT(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).CLc != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).CLc;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).JtH = true;
            ((PreferenceTitleCategory)localObject4).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dmo)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.CNd.add(localObject4);
            localObject3 = ((m.a)localObject2).CLb.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (ag)((Iterator)localObject3).next();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
            WalletPasswordSettingUI.10 local10 = new WalletPasswordSettingUI.10(this, getContext());
            local10.setLayoutResource(2131494804);
            local10.setTitle(((ag)localObject4).field_pref_title);
            local10.setSummary(((ag)localObject4).field_pref_desc);
            local10.Jtu = new Preference.b()
            {
              public final boolean dAh()
              {
                AppMethodBeat.i(199291);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.CNk);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(199291);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.CNd.add(local10);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
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
        this.CNd.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).CLd != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).CLd;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).JtH = true;
          ((PreferenceFooterCategory)localObject3).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (dmo)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.CNd.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.CNd.add(localObject2);
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
    if (u.aAB()) {}
    for (String str = getString(2131765654);; str = getString(2131765653))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.e.fRZ();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(eEr());
      this.CMP = ((IconPreference)this.screen.aVD("wallet_open_auto_pay"));
      this.CMQ = this.screen.aVD("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.ajD();
      if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuL, Boolean.TRUE)).booleanValue())
      {
        this.CMP.gx(getString(2131755829), 2131233430);
        this.CMP.acm(0);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IuL, Boolean.TRUE);
      }
      this.CMK = ((CheckBoxPreference)this.screen.aVD("wallet_fingerprint_switch"));
      this.CML = ((RightBelowPreference)this.screen.aVD("wallet_biometric_pay"));
      this.CMM = ((CheckBoxPreference)this.screen.aVD("mobile_remit_switch"));
      eEu();
      this.screen.cP("nfc_idpay", true);
      this.screen.cP("wallet_open_auto_pay", true);
      this.screen.cP("wallet_universal_pay_order", true);
      this.screen.cP("wallet_lucky_money_refund_way", true);
      eEq();
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
      if (com.tencent.mm.plugin.wallet.b.a.eED()) {
        com.tencent.mm.plugin.report.service.g.yhR.f(15817, new Object[] { Integer.valueOf(0) });
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
      if (!u.aAC()) {
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(385, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1477, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1813, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1724, this);
    com.tencent.mm.sdk.b.a.IbL.c(this.CGp);
    this.CNf.alive();
    this.gwX = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.CMO = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.gwX)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFW, "");
    label356:
    int i;
    if (!bt.isNullOrNil(paramBundle))
    {
      this.CMI = f.a.aEi(paramBundle);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.CMI });
      uj(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
      com.tencent.mm.plugin.wallet_core.model.t.eFs();
      boolean bool = com.tencent.mm.plugin.wallet_core.model.t.eFH();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label709;
      }
      paramBundle = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IGj, "");
      if (bt.isNullOrNil(paramBundle)) {
        break label698;
      }
      this.CMX = h.a.aEj(paramBundle);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.CMI });
      uk(false);
      com.tencent.mm.kernel.g.ajD();
      this.CNc = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IGk, Integer.valueOf(2))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.CNc) });
      if (this.CNc == 0) {
        this.CNc = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.CNc);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
      label453:
      com.tencent.mm.kernel.g.ajD();
      long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuN, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.ajD();
      i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuO, Integer.valueOf(0))).intValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > l + i)) {
        break label717;
      }
      i = 0;
      label579:
      if (i == 0) {
        break label722;
      }
      ui(false);
      label588:
      com.tencent.mm.kernel.g.ajD();
      this.CNa = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixs, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.ajD();
      this.CMT = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixn, ""));
      if (!bt.isNullOrNil(this.CMT)) {
        break label893;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      if (this.CNa == 0) {
        this.screen.cP("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label698:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label356;
      label709:
      uk(false);
      break label453;
      label717:
      i = 1;
      break label579;
      label722:
      com.tencent.mm.kernel.g.ajD();
      this.CMS = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuU, ""));
      this.CMU = com.tencent.mm.plugin.wallet_core.model.t.eFx().aEI("wallet_open_auto_pay");
      if ((this.CMU != null) && (this.CMU.field_is_show == 1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.CMR = this.CMU.field_pref_url;
        aO(this.CMU.field_pref_title, this.CMU.field_pref_url, this.CMU.field_tinyapp_path);
        break label588;
      }
      if (this.CMU == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label588;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.CMU.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bt.isNullOrNil(this.CMU.field_pref_url));
      break label588;
      label893:
      this.CMQ.setTitle(this.CMT);
      aj.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.CGp);
    this.CNf.dead();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(385, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1477, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1813, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      eEs();
      com.tencent.mm.wallet_core.ui.e.agr(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.ajD();
      paramf = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivd, "");
      if (!bt.isNullOrNil(paramf))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.n(getContext(), paramf, false);
        paramf = new hf();
        paramf.erT = 2L;
        paramf.erU = 2L;
        paramf.aLk();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = com.tencent.mm.plugin.wallet_core.model.t.eFy().eGn();
      if (!bt.isNullOrNil(paramf))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.e.n(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      eEt();
      paramf = new hf();
      paramf.erT = 2L;
      paramf.erU = 1L;
      paramf.aLk();
      com.tencent.mm.wallet_core.ui.e.agr(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.plugin.wallet_core.model.t.eFy().eGa()) {
        if (!bt.isNullOrNil(this.CMS))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.CMS);
          paramf.putExtra("showShare", false);
          paramf.putExtra(e.m.IVa, true);
          com.tencent.mm.wallet_core.ui.e.an(getContext(), paramf);
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
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.CNg);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.CMI.eDW().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new hc();
      com.tencent.mm.kernel.g.ajD();
      if (bt.aA(((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFV, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.dVG = i;
        paramf.aLk();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.CMU);
      this.CMP.acm(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.CMZ)
      {
        paramf = new m();
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramf, 0);
      }
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.ajD();
      paramf = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBn, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(e.m.IVa, true);
      com.tencent.mm.wallet_core.ui.e.an(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.CMV);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.CMW);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.bs.d.Q(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.CMY = new hj();
        this.CMY.dPl = i;
        if (this.scene != 0) {
          break label1323;
        }
        this.CMY.erY = 2L;
        label1238:
        this.CMY.aLk();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.CNc);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramf, 0);
        if (this.CMN != null) {
          break label1342;
        }
        this.CMN = com.tencent.mm.ui.base.h.a(this, 0, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
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
        label1323:
        if (this.scene != 1) {
          break label1238;
        }
        this.CMY.erY = 1L;
        break label1238;
        label1342:
        this.CMN.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).eJp())
    {
      finish();
      AppMethodBeat.o(69757);
      return;
    }
    eEu();
    if (this.CNe)
    {
      this.CNe = false;
      ui(false);
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
        eEu();
        paramString = (m)paramn;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.CKV);
        this.CMS = paramString.CKZ;
        this.CMU = com.tencent.mm.plugin.wallet_core.model.t.eFx().aEI("wallet_open_auto_pay");
        if ((this.CMU != null) && (this.CMU.field_is_show == 1))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.CMR = this.CMU.field_pref_url;
          aO(this.CMU.field_pref_title, this.CMU.field_pref_url, this.CMU.field_tinyapp_path);
        }
        for (;;)
        {
          eEq();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.cP("wallet_open_auto_pay", true);
        }
      }
      if ((paramn instanceof aj))
      {
        this.CMT = ((aj)paramn).CPy;
        this.CNa = ((aj)paramn).CPD;
        if (this.CNa == 0)
        {
          this.screen.cP("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!bt.isNullOrNil(this.CMT)) {
          this.CMQ.setTitle(this.CMT);
        }
        for (;;)
        {
          this.screen.cP("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.CMI = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramn).eDV();
        uj(true);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.CMI.eDW() });
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFW, this.CMI.eDW());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramn;
        if (paramString.CKQ == null)
        {
          paramString.CKQ = new h.a();
          paramString.CKQ.ozR = paramString.CKP.ozR;
          paramString.CKQ.ozS = paramString.CKP.ozS;
          paramString.CKQ.ozk = paramString.CKP.ozk;
          paramString.CKQ.CKR = paramString.CKP.CKR;
          paramString.CKQ.CKD = paramString.CKP.CKD;
          paramString.CKQ.dxD = paramString.CKP.dxD;
        }
        this.CMX = paramString.CKQ;
        uk(true);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.CMX.eDW() });
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGj, this.CMX.eDW());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.CMN != null) && (this.CMN.isShowing())) {
          this.CMN.dismiss();
        }
        paramn = (com.tencent.mm.plugin.wallet.pwd.a.g)paramn;
        if (paramn.CKO == null)
        {
          paramn = new doz();
          if (paramn == null)
          {
            if (!bt.isNullOrNil(paramString)) {
              break label904;
            }
            paramString = getString(2131765224);
            label686:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
          }
          paramInt1 = paramn.ozR;
          paramString = paramn.ozS;
          if (paramn.FTQ != null) {
            break label907;
          }
          bool1 = true;
          label731:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramn.HDg), paramn.dxD });
          paramInt1 = paramn.HDg;
          paramString = paramn.dxD;
          if (!bt.isNullOrNil(paramString)) {
            break label913;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label808:
          if (paramn.ozR != 0) {
            break label1048;
          }
          if (paramn.HDh == null) {
            break label984;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          l.a(getContext(), paramn.HDh, null, new l.a()
          {
            public final void dF(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void dIY()
            {
              AppMethodBeat.i(163865);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int dIZ()
            {
              return 1149;
            }
            
            public final void dJa()
            {
              AppMethodBeat.i(163866);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void dJb()
            {
              AppMethodBeat.i(163867);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(69739);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.CMM;
          if (this.CMM.isChecked()) {
            break label978;
          }
        }
        label904:
        label907:
        label913:
        label978:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.oB = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramn = paramn.CKO;
          break;
          break label686;
          bool1 = false;
          break label731;
          this.CNc = paramInt1;
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGk, Integer.valueOf(paramInt1));
          this.CMX.dxD = paramString;
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGj, this.CMX.eDW());
          aEk(paramString);
          this.screen.notifyDataSetChanged();
          break label808;
        }
        label984:
        if (this.CMM.isChecked())
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGi, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGi, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1048:
        if (paramn.ozR == 416) {
          if (paramn.FTQ != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramn.ozR;
            paramn = paramn.FTQ;
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
            paramString = this.CMM;
            if (this.CMM.isChecked()) {
              break label1324;
            }
          }
        }
        label1324:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.oB = bool1;
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (bt.isNullOrNil(paramn.ozS)) {}
          for (paramString = getString(2131765224);; paramString = paramn.ozS)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131761269), false, null).show();
            break;
          }
          if (paramn.HDh != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            l.a(getContext(), paramn.HDh, null, new l.a()
            {
              public final void dF(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void dIY()
              {
                AppMethodBeat.i(163868);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int dIZ()
              {
                return 1149;
              }
              
              public final void dJa()
              {
                AppMethodBeat.i(163869);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void dJb()
              {
                AppMethodBeat.i(163870);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void dJf()
              {
                AppMethodBeat.i(69742);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramn.ozR == 0) {
            break;
          }
          if (bt.isNullOrNil(paramn.ozS)) {}
          for (paramString = getString(2131765224);; paramString = paramn.ozS)
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
        if ((this.CMN != null) && (this.CMN.isShowing())) {
          this.CMN.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131761270);
        }
        com.tencent.mm.ui.base.t.makeText(localAppCompatActivity, paramn, 0).show();
        paramString = this.CMM;
        if (this.CMM.isChecked()) {
          break label1512;
        }
      }
    }
    for (;;)
    {
      paramString.oB = bool1;
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