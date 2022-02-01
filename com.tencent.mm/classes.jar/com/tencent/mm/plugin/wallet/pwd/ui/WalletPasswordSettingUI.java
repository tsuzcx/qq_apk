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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ce.b;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.b.a.kv;
import com.tencent.mm.g.b.a.ky;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.a.d;
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
  implements com.tencent.mm.ak.i
{
  IListener HDJ;
  private lc HKA;
  private boolean HKB;
  private int HKC;
  private int HKD;
  private int HKE;
  private List<Preference> HKF;
  private boolean HKG;
  private IListener<on> HKH;
  private d.a HKI;
  private f.a HKk;
  CheckBoxPreference HKm;
  RightBelowPreference HKn;
  CheckBoxPreference HKo;
  private Dialog HKp;
  private boolean HKq;
  private IconPreference HKr;
  private Preference HKs;
  private String HKt;
  private String HKu;
  private String HKv;
  private ag HKw;
  private ag HKx;
  private ag HKy;
  private h.a HKz;
  private MMHandler handler;
  private boolean hmr;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.HKp = null;
    this.HKq = false;
    this.HKB = false;
    this.HKC = 0;
    this.HKD = 0;
    this.handler = new MMHandler(new MMHandler.Callback()
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
    this.HKE = 2;
    this.HKF = new ArrayList();
    this.HKG = false;
    this.HDJ = new IListener() {};
    this.HKH = new IListener() {};
    this.HKI = new d.a()
    {
      public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        Log.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new zv();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.efR.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.efS.efJ = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.fPn();
              AppMethodBeat.o(69748);
            }
          };
          EventCenter.instance.publish(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.efR.scene = 18;
          } else {
            paramAnonymousBundle.efR.scene = 0;
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
      Log.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramag.field_pref_url });
      if (!Util.isNullOrNil(paramag.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.f.o(this, paramag.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!Util.isNullOrNil(paramag.field_tinyapp_username))
        {
          wq localwq = new wq();
          localwq.ecI.userName = paramag.field_tinyapp_username;
          localwq.ecI.ecK = Util.nullAs(paramag.field_tinyapp_path, "");
          localwq.ecI.scene = 1066;
          localwq.ecI.ecL = 0;
          EventCenter.instance.publish(localwq);
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          c.V(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramag = new Intent();
          paramag.putExtra("wallet_lock_jsapi_scene", 1);
          c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramag);
          new kz();
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          c.d(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          c.V(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void aVc(String paramString)
  {
    AppMethodBeat.i(182520);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
      AppMethodBeat.o(182520);
      return;
    }
    if (paramString.contains("wc_custom_link"))
    {
      paramString = com.tencent.mm.pluginsdk.ui.span.l.a(this, paramString, 10, false, null);
      this.HKo.OZB = true;
      this.HKo.setSummary(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.HKo.setSummary(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void aZ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214093);
    this.HKr.setTitle(paramString1);
    if ((!Util.isNullOrNil(paramString2)) || (!Util.isNullOrNil(paramString3)))
    {
      this.screen.jdMethod_do("wallet_open_auto_pay", false);
      AppMethodBeat.o(214093);
      return;
    }
    this.screen.jdMethod_do("wallet_open_auto_pay", true);
    Log.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(214093);
  }
  
  private void fPj()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.g.aAi();
    String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oed, "");
    com.tencent.mm.kernel.g.aAi();
    String str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oee, "");
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()))
    {
      this.screen.jdMethod_do("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.jdMethod_do("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void fPo()
  {
    AppMethodBeat.i(69766);
    if ((com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm()) || (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRl()))
    {
      this.screen.jdMethod_do("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.fPB()) && (com.tencent.mm.plugin.wallet.b.a.fPC()))
    {
      this.HKn.setTitle(2131768085);
      this.HKn.setSummary(2131768084);
      if (locala.dJR()) {
        this.HKn.S(getString(2131767519));
      }
      for (;;)
      {
        this.screen.jdMethod_do("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.dJO()) {
          this.HKn.S(getString(2131767520));
        } else {
          this.HKn.S(getString(2131766600));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.fPB())
    {
      this.HKn.setTitle(2131768083);
      this.HKn.setSummary(2131768082);
      if (locala.dJO()) {
        this.HKn.S(getString(2131766589));
      }
      for (;;)
      {
        this.screen.jdMethod_do("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.HKn.S(getString(2131766600));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.fPC())
    {
      this.HKn.setTitle(2131768081);
      this.HKn.setSummary(2131768080);
      if (locala.dJR()) {
        this.HKn.S(getString(2131766589));
      }
      for (;;)
      {
        this.screen.jdMethod_do("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.HKn.S(getString(2131766600));
      }
    }
    this.screen.jdMethod_do("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  private void yb(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.HKm.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(localm, 0);
    this.HKB = true;
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
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.HKk == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.jdMethod_do("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.HKk.HIg), Integer.valueOf(this.HKk.dDN), this.HKk.HHX });
      if ((!this.HKk.HIg) && (Util.isEqual(this.HKk.dDN, 0))) {
        break;
      }
      this.screen.jdMethod_do("wallet_lucky_money_refund_way", true);
    }
    if (Util.isNullOrNil(this.HKk.HHX))
    {
      this.screen.jdMethod_do("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.HKk.HHX);
    com.tencent.mm.kernel.g.aAi();
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojb, Long.valueOf(0L))).longValue() & 0x3;
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (Util.isEqual(l, 2L))
    {
      localIconPreference.setSummary(this.HKk.HIb);
      label275:
      if ((paramBoolean) && (this.HKk.HHY))
      {
        com.tencent.mm.kernel.g.aAi();
        if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojd, Boolean.FALSE)).booleanValue()) {
          break label374;
        }
        localIconPreference.alF(0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojd, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.jdMethod_do("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.setSummary(this.HKk.HHZ);
      break label275;
      label374:
      localIconPreference.alF(8);
    }
  }
  
  private void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.HKz == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.jdMethod_do("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.HKz.pTZ != 0) || (!this.HKz.pTt))
    {
      this.screen.jdMethod_do("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (Util.isNullOrNil(this.HKz.HHX))
    {
      this.screen.jdMethod_do("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.HKo.setTitle(this.HKz.HHX);
    aVc(this.HKz.dQx);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.HKo;
      paramBoolean = this.HKz.HIl;
    }
    for (;;)
    {
      localCheckBoxPreference.setChecked(paramBoolean);
      this.screen.jdMethod_do("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.g.aAi();
      int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojo, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.HKo;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  protected int fPk()
  {
    return 2132017305;
  }
  
  protected void fPl()
  {
    AppMethodBeat.i(69759);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scH, false))
    {
      Bundle localBundle = new Bundle();
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startModifyPwdUseCase(this, localBundle);
      AppMethodBeat.o(69759);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void fPm()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.b(b.a.rZV, false))
    {
      Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69760);
      return;
      Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    AppMethodBeat.o(69760);
  }
  
  protected void fPn()
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
    if ((com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm()) || (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRl()))
    {
      this.screen.jdMethod_do("wallet_modify_password", true);
      this.screen.jdMethod_do("wallet_forget_password", true);
      this.screen.jdMethod_do("wallet_realname_verify", false);
      this.screen.bmg("wallet_realname_verify").setSummary(2131768095);
      this.screen.jdMethod_do("wallet_universal_pay_order", true);
      this.screen.jdMethod_do("wallet_switch_currency", true);
      this.screen.jdMethod_do("wallet_switch_category", true);
      this.screen.jdMethod_do("wallet_biometric_pay", true);
      this.screen.jdMethod_do("wallet_universal_pay_order", true);
      this.screen.jdMethod_do("wallet_digitalcert", true);
      this.HKx = com.tencent.mm.plugin.wallet_core.model.t.fQH().aVD("wallet_switch_currency");
      if ((this.HKx == null) || (this.HKx.field_is_show != 1)) {
        break label688;
      }
      this.screen.jdMethod_do("wallet_switch_currency", false);
      localObject1 = this.screen.bmg("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.HKx.field_pref_title);
      ((Preference)localObject1).setSummary(this.HKx.field_pref_desc);
      bool1 = false;
      this.HKy = com.tencent.mm.plugin.wallet_core.model.t.fQH().aVD("wallet_im_mch");
      if ((this.HKy == null) || (this.HKy.field_is_show != 1)) {
        break label707;
      }
      this.screen.jdMethod_do("wallet_im_mch", false);
      localObject1 = this.screen.bmg("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.HKy.field_pref_title);
      ((Preference)localObject1).setSummary(this.HKy.field_pref_desc);
      bool2 = false;
      Log.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.jdMethod_do("wallet_switch_category", true);
      com.tencent.mm.kernel.g.aAi();
      l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(147457, Long.valueOf(0L))).longValue();
      i = 2131767677;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = 2131767676;
      this.screen.bmg("wallet_delay_transfer_date").setSummary(i);
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZg, 1);
      if ((!CrashReportFactory.hasDebuger()) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.jdMethod_do("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      yd(false);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.HKF == null) || (this.HKF.size() <= 0)) {
        break label793;
      }
      localObject1 = this.HKF.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.e((Preference)localObject2);
      }
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk())
      {
        this.screen.jdMethod_do("wallet_modify_password", false);
        this.screen.jdMethod_do("wallet_forget_password", false);
        this.screen.jdMethod_do("wallet_realname_verify", false);
        this.screen.bmg("wallet_realname_verify").setSummary(2131768101);
        this.screen.jdMethod_do("wallet_universal_pay_order", true);
        fPo();
        break;
      }
      Log.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.jdMethod_do("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.jdMethod_do("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.jdMethod_do("wallet_switch_category", false);
      break label389;
      label744:
      if ((l & 0x20) == 0L) {
        break label436;
      }
      i = 2131767675;
      break label436;
      label762:
      i = 0;
      break label485;
      label767:
      this.screen.jdMethod_do("wallet_function_settings", false);
    }
    this.HKF.clear();
    label793:
    int i = this.screen.indexOf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.g.aAi();
    Object localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojs, "");
    if (!Util.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = m.a.bt(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).HIw != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).HIw;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).OZC = true;
            ((PreferenceTitleCategory)localObject4).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (ehf)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.HKF.add(localObject4);
            localObject3 = ((m.a)localObject2).HIv.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (ag)((Iterator)localObject3).next();
            Log.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
            WalletPasswordSettingUI.10 local10 = new WalletPasswordSettingUI.10(this, getContext());
            local10.setLayoutResource(2131495538);
            local10.setTitle(((ag)localObject4).field_pref_title);
            local10.setSummary(((ag)localObject4).field_pref_desc);
            local10.OZp = new Preference.b()
            {
              public final boolean a(Preference paramAnonymousPreference)
              {
                AppMethodBeat.i(214092);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.HKM);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(214092);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.HKF.add(local10);
            Log.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ag)localObject4).field_pref_key });
            continue;
            this.screen.notifyDataSetChanged();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.WalletPasswordSettingUI", " parse EXTRA_Data failed :%s", new Object[] { localJSONException.getMessage() });
      }
      for (;;)
      {
        AppMethodBeat.o(69765);
        return;
        localObject3 = new PreferenceSmallCategory(getContext());
        i += 1;
        this.screen.a((Preference)localObject3, i);
        this.HKF.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).HIx != null)
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).HIx;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).OZC = true;
          ((PreferenceFooterCategory)localObject3).setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), (ehf)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.HKF.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.HKF.add(localObject2);
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
    if (z.aUo()) {}
    for (String str = getString(2131768107);; str = getString(2131768106))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.f.hhT();
      this.screen = getPreferenceScreen();
      this.screen.addPreferencesFromResource(fPk());
      this.HKr = ((IconPreference)this.screen.bmg("wallet_open_auto_pay"));
      this.HKs = this.screen.bmg("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.aAi();
      if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXk, Boolean.TRUE)).booleanValue())
      {
        this.HKr.gZ(getString(2131755915), 2131234232);
        this.HKr.alE(0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXk, Boolean.TRUE);
      }
      this.HKm = ((CheckBoxPreference)this.screen.bmg("wallet_fingerprint_switch"));
      this.HKn = ((RightBelowPreference)this.screen.bmg("wallet_biometric_pay"));
      this.HKo = ((CheckBoxPreference)this.screen.bmg("mobile_remit_switch"));
      fPn();
      this.screen.jdMethod_do("nfc_idpay", true);
      this.screen.jdMethod_do("wallet_open_auto_pay", true);
      this.screen.jdMethod_do("wallet_universal_pay_order", true);
      this.screen.jdMethod_do("wallet_lucky_money_refund_way", true);
      fPj();
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
      if (com.tencent.mm.plugin.wallet.b.a.fPC()) {
        com.tencent.mm.plugin.report.service.h.CyF.a(15817, new Object[] { Integer.valueOf(0) });
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
      if (!z.aUp()) {
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
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(385, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1477, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1813, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1724, this);
    EventCenter.instance.addListener(this.HDJ);
    this.HKH.alive();
    this.hmr = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.HKq = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.hmr)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojc, "");
    label356:
    int i;
    if (!Util.isNullOrNil(paramBundle))
    {
      this.HKk = f.a.aUZ(paramBundle);
      Log.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.HKk });
      yd(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramBundle, 0);
      com.tencent.mm.plugin.wallet_core.model.t.fQC();
      boolean bool = com.tencent.mm.plugin.wallet_core.model.t.fQR();
      Log.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label709;
      }
      paramBundle = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojp, "");
      if (Util.isNullOrNil(paramBundle)) {
        break label698;
      }
      this.HKz = h.a.aVa(paramBundle);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.HKk });
      ye(false);
      com.tencent.mm.kernel.g.aAi();
      this.HKE = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojq, Integer.valueOf(2))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.HKE) });
      if (this.HKE == 0) {
        this.HKE = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.HKE);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramBundle, 0);
      label453:
      com.tencent.mm.kernel.g.aAi();
      long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXm, Long.valueOf(0L))).longValue();
      com.tencent.mm.kernel.g.aAi();
      i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXn, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
      if ((l <= 0L) || (new Date().getTime() / 1000L > l + i)) {
        break label717;
      }
      i = 0;
      label579:
      if (i == 0) {
        break label722;
      }
      yc(false);
      label588:
      com.tencent.mm.kernel.g.aAi();
      this.HKC = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZS, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.aAi();
      this.HKv = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZN, ""));
      if (!Util.isNullOrNil(this.HKv)) {
        break label893;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      if (this.HKC == 0) {
        this.screen.jdMethod_do("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label698:
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label356;
      label709:
      ye(false);
      break label453;
      label717:
      i = 1;
      break label579;
      label722:
      com.tencent.mm.kernel.g.aAi();
      this.HKu = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXt, ""));
      this.HKw = com.tencent.mm.plugin.wallet_core.model.t.fQH().aVD("wallet_open_auto_pay");
      if ((this.HKw != null) && (this.HKw.field_is_show == 1))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.HKt = this.HKw.field_pref_url;
        aZ(this.HKw.field_pref_title, this.HKw.field_pref_url, this.HKw.field_tinyapp_path);
        break label588;
      }
      if (this.HKw == null)
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label588;
      }
      Log.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.HKw.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + Util.isNullOrNil(this.HKw.field_pref_url));
      break label588;
      label893:
      this.HKs.setTitle(this.HKv);
      aj.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    EventCenter.instance.removeListener(this.HDJ);
    this.HKH.dead();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1477, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1813, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      fPl();
      com.tencent.mm.wallet_core.ui.f.aqm(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.aAi();
      paramf = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXC, "");
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.f.o(getContext(), paramf, false);
        paramf = new ky();
        paramf.eXG = 2L;
        paramf.eXH = 2L;
        paramf.bfK();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRx();
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.f.o(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      fPm();
      paramf = new ky();
      paramf.eXG = 2L;
      paramf.eXH = 1L;
      paramf.bfK();
      com.tencent.mm.wallet_core.ui.f.aqm(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()) {
        if (!Util.isNullOrNil(this.HKu))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.HKu);
          paramf.putExtra("showShare", false);
          paramf.putExtra(e.p.OzJ, true);
          com.tencent.mm.wallet_core.ui.f.aA(getContext(), paramf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(69762);
        return true;
        Log.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
        continue;
        Log.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
        paramf = new Bundle();
        paramf.putInt("real_name_verify_mode", 0);
        paramf.putString("realname_verify_process_jump_plugin", "wallet");
        paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.HKI);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.HKk.fON().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new kv();
      com.tencent.mm.kernel.g.aAi();
      if (Util.isEqual(((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojb, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.esA = i;
        paramf.bfK();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.HKw);
      this.HKr.alE(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.HKB)
      {
        paramf = new m();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramf, 0);
      }
      c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.g.aAi();
      paramf = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oee, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(e.p.OzJ, true);
      com.tencent.mm.wallet_core.ui.f.aA(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.HKx);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.HKy);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      c.V(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.HKA = new lc();
        this.HKA.ejA = i;
        if (this.scene != 0) {
          break label1323;
        }
        this.HKA.eXL = 2L;
        label1238:
        this.HKA.bfK();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.HKE);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramf, 0);
        if (this.HKp != null) {
          break label1342;
        }
        this.HKp = com.tencent.mm.ui.base.h.a(this, 0, 2131821007, getString(2131762446), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(69750);
            Log.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
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
        this.HKA.eXL = 1L;
        break label1238;
        label1342:
        this.HKp.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).fUG()) {
      finish();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(new ad(null, 1), 0);
      AppMethodBeat.o(69757);
      return;
      fPn();
      if (this.HKG)
      {
        this.HKG = false;
        yc(false);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(69768);
    Log.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ad))
      {
        fPn();
        fPj();
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof m))
      {
        fPn();
        paramString = (m)paramq;
        Log.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.HIp);
        this.HKu = paramString.HIt;
        this.HKw = com.tencent.mm.plugin.wallet_core.model.t.fQH().aVD("wallet_open_auto_pay");
        if ((this.HKw != null) && (this.HKw.field_is_show == 1))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.HKt = this.HKw.field_pref_url;
          aZ(this.HKw.field_pref_title, this.HKw.field_pref_url, this.HKw.field_tinyapp_path);
        }
        for (;;)
        {
          fPj();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.jdMethod_do("wallet_open_auto_pay", true);
        }
      }
      if ((paramq instanceof aj))
      {
        this.HKv = ((aj)paramq).HQv;
        this.HKC = ((aj)paramq).HQA;
        if (this.HKC == 0)
        {
          this.screen.jdMethod_do("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!Util.isNullOrNil(this.HKv)) {
          this.HKs.setTitle(this.HKv);
        }
        for (;;)
        {
          this.screen.jdMethod_do("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.HKk = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramq).fOM();
        yd(true);
        Log.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.HKk.fON() });
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojc, this.HKk.fON());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramq;
        if (paramString.HIk == null)
        {
          paramString.HIk = new h.a();
          paramString.HIk.pTZ = paramString.HIj.pTZ;
          paramString.HIk.pUa = paramString.HIj.pUa;
          paramString.HIk.pTt = paramString.HIj.pTt;
          paramString.HIk.HIl = paramString.HIj.HIl;
          paramString.HIk.HHX = paramString.HIj.HHX;
          paramString.HIk.dQx = paramString.HIj.dQx;
        }
        this.HKz = paramString.HIk;
        ye(true);
        Log.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.HKz.fON() });
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojp, this.HKz.fON());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.HKp != null) && (this.HKp.isShowing())) {
          this.HKp.dismiss();
        }
        paramq = (com.tencent.mm.plugin.wallet.pwd.a.g)paramq;
        if (paramq.HIi == null)
        {
          paramq = new ejs();
          if (paramq == null)
          {
            if (!Util.isNullOrNil(paramString)) {
              break label927;
            }
            paramString = getString(2131767667);
            label709:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131763095), false, null).show();
          }
          paramInt1 = paramq.pTZ;
          paramString = paramq.pUa;
          if (paramq.LgT != null) {
            break label930;
          }
          bool1 = true;
          label754:
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramq.NiZ), paramq.dQx });
          paramInt1 = paramq.NiZ;
          paramString = paramq.dQx;
          if (!Util.isNullOrNil(paramString)) {
            break label936;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label831:
          if (paramq.pTZ != 0) {
            break label1071;
          }
          if (paramq.Nja == null) {
            break label1007;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), paramq.Nja, null, new l.a()
          {
            public final void dP(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void eNp()
            {
              AppMethodBeat.i(163865);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int eNq()
            {
              return 1149;
            }
            
            public final void eNr()
            {
              AppMethodBeat.i(163866);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void eNs()
            {
              AppMethodBeat.i(163867);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(69739);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.HKo;
          if (this.HKo.isChecked()) {
            break label1001;
          }
        }
        label927:
        label930:
        label936:
        label1001:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramq = paramq.HIi;
          break;
          break label709;
          bool1 = false;
          break label754;
          this.HKE = paramInt1;
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojq, Integer.valueOf(paramInt1));
          this.HKz.dQx = paramString;
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojp, this.HKz.fON());
          aVc(paramString);
          this.screen.notifyDataSetChanged();
          break label831;
        }
        label1007:
        if (this.HKo.isChecked())
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojo, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojo, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1071:
        if (paramq.pTZ == 416) {
          if (paramq.LgT != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramq.pTZ;
            paramq = paramq.LgT;
            new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69741);
                Log.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.o(69741);
              }
            };
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt1, paramq, paramString, 1012);
            paramString = this.HKo;
            if (this.HKo.isChecked()) {
              break label1347;
            }
          }
        }
        label1347:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (Util.isNullOrNil(paramq.pUa)) {}
          for (paramString = getString(2131767667);; paramString = paramq.pUa)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131763095), false, null).show();
            break;
          }
          if (paramq.Nja != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            com.tencent.mm.wallet_core.c.l.a(getContext(), paramq.Nja, null, new l.a()
            {
              public final void dP(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void eNp()
              {
                AppMethodBeat.i(163868);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int eNq()
              {
                return 1149;
              }
              
              public final void eNr()
              {
                AppMethodBeat.i(163869);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void eNs()
              {
                AppMethodBeat.i(163870);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void eNw()
              {
                AppMethodBeat.i(69742);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramq.pTZ == 0) {
            break;
          }
          if (Util.isNullOrNil(paramq.pUa)) {}
          for (paramString = getString(2131767667);; paramString = paramq.pUa)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(2131763095), false, null).show();
            break;
          }
        }
      }
    }
    else
    {
      if ((paramq instanceof aj))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
        if ((this.HKp != null) && (this.HKp.isShowing())) {
          this.HKp.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131763096);
        }
        u.makeText(localAppCompatActivity, paramq, 0).show();
        paramString = this.HKo;
        if (this.HKo.isChecked()) {
          break label1535;
        }
      }
    }
    for (;;)
    {
      paramString.setChecked(bool1);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69768);
      return;
      label1535:
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