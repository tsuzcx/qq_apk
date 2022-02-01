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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aay;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.f.a.ci;
import com.tencent.mm.f.a.ci.b;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.nr;
import com.tencent.mm.f.b.a.nu;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.f.b.a.ny;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.m.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.etw;
import com.tencent.mm.protocal.protobuf.eug;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class WalletPasswordSettingUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private List<Preference> OCA;
  private boolean OCB;
  private IListener<pk> OCC;
  private d.a OCD;
  private f.a OCf;
  CheckBoxPreference OCh;
  RightBelowPreference OCi;
  CheckBoxPreference OCj;
  private Dialog OCk;
  private boolean OCl;
  private IconPreference OCm;
  private Preference OCn;
  private String OCo;
  private String OCp;
  private String OCq;
  private ah OCr;
  private ah OCs;
  private ah OCt;
  private h.a OCu;
  private ny OCv;
  private boolean OCw;
  private int OCx;
  private int OCy;
  private int OCz;
  IListener OvC;
  private MMHandler handler;
  private boolean jYb;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.OCk = null;
    this.OCl = false;
    this.OCw = false;
    this.OCx = 0;
    this.OCy = 0;
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
    this.OCz = 2;
    this.OCA = new ArrayList();
    this.OCB = false;
    this.OvC = new IListener() {};
    this.OCC = new IListener() {};
    this.OCD = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        Log.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new abc();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.gah.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.gai.fZZ = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.gHR();
              AppMethodBeat.o(69748);
            }
          };
          EventCenter.instance.publish(paramAnonymousBundle);
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.gah.scene = 18;
          } else {
            paramAnonymousBundle.gah.scene = 0;
          }
        }
      }
    };
    AppMethodBeat.o(69753);
  }
  
  private void BW(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.OCh.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void BX(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    m localm = new m();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(localm, 0);
    this.OCw = true;
    if (paramBoolean) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(this, false, new DialogInterface.OnCancelListener()
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
  
  private void BY(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.OCf == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.dz("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.OCf.Dlq), Integer.valueOf(this.OCf.fwx), this.OCf.OzR });
      if ((!this.OCf.Dlq) && (Util.isEqual(this.OCf.fwx, 0))) {
        break;
      }
      this.screen.dz("wallet_lucky_money_refund_way", true);
    }
    if (Util.isNullOrNil(this.OCf.OzR))
    {
      this.screen.dz("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.byG("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.OCf.OzR);
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue() & 0x3;
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (Util.isEqual(l, 2L))
    {
      localIconPreference.aF(this.OCf.OzU);
      label266:
      if ((paramBoolean) && (this.OCf.fEY))
      {
        com.tencent.mm.kernel.h.aHH();
        if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxt, Boolean.FALSE)).booleanValue()) {
          break label364;
        }
        localIconPreference.aak(0);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxt, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.dz("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.aF(this.OCf.OzS);
      break label266;
      label364:
      localIconPreference.aak(8);
    }
  }
  
  private void BZ(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.OCu == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.dz("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.OCu.tqa != 0) || (!this.OCu.tpu))
    {
      this.screen.dz("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (Util.isNullOrNil(this.OCu.OzR))
    {
      this.screen.dz("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.OCj.setTitle(this.OCu.OzR);
    bgL(this.OCu.wording);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.OCj;
      paramBoolean = this.OCu.OAd;
    }
    for (;;)
    {
      localCheckBoxPreference.setChecked(paramBoolean);
      this.screen.dz("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.h.aHH();
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxE, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.OCj;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  private void a(ah paramah)
  {
    AppMethodBeat.i(69763);
    switch (paramah.field_jump_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69763);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramah.field_pref_url });
      if (!Util.isNullOrNil(paramah.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.g.o(this, paramah.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!Util.isNullOrNil(paramah.field_tinyapp_username))
        {
          xw localxw = new xw();
          localxw.fWN.userName = paramah.field_tinyapp_username;
          localxw.fWN.fWP = Util.nullAs(paramah.field_tinyapp_path, "");
          localxw.fWN.scene = 1066;
          localxw.fWN.fWQ = 0;
          EventCenter.instance.publish(localxw);
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.by.c.ad(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramah = new Intent();
          paramah.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.by.c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramah);
          new nv();
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.by.c.f(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.by.c.ad(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void aT(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(277344);
    this.OCm.setTitle(paramString1);
    if ((!Util.isNullOrNil(paramString2)) || (!Util.isNullOrNil(paramString3)))
    {
      this.screen.dz("wallet_open_auto_pay", false);
      AppMethodBeat.o(277344);
      return;
    }
    this.screen.dz("wallet_open_auto_pay", true);
    Log.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(277344);
  }
  
  private void bgL(String paramString)
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
      this.OCj.WsK = true;
      this.OCj.aF(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.OCj.aF(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void gHN()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.h.aHH();
    String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vso, "");
    com.tencent.mm.kernel.h.aHH();
    String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsp, "");
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (u.gJo().gJQ()))
    {
      this.screen.dz("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.dz("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void gHS()
  {
    AppMethodBeat.i(69766);
    if ((u.gJo().gJS()) || (u.gJo().gJR()))
    {
      this.screen.dz("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.gIe()) && (com.tencent.mm.plugin.wallet.b.a.gIf()))
    {
      this.OCi.setTitle(a.i.wallet_password_setting_ui_biometric_multi_support_title);
      this.OCi.auI(a.i.wallet_password_setting_ui_biometric_multi_support_summary);
      if (locala.eoq()) {
        this.OCi.ag(getString(a.i.wallet_biometric_pay_status_faceid_open));
      }
      for (;;)
      {
        this.screen.dz("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.eon()) {
          this.OCi.ag(getString(a.i.wallet_biometric_pay_status_fingerprint_open));
        } else {
          this.OCi.ag(getString(a.i.switch_uncheck_desc));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.gIe())
    {
      this.OCi.setTitle(a.i.wallet_password_setting_ui_biometric_fingerprint_support_title);
      this.OCi.auI(a.i.wallet_password_setting_ui_biometric_fingerprint_support_summary);
      if (locala.eon()) {
        this.OCi.ag(getString(a.i.switch_check_desc));
      }
      for (;;)
      {
        this.screen.dz("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.OCi.ag(getString(a.i.switch_uncheck_desc));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.gIf())
    {
      this.OCi.setTitle(a.i.wallet_password_setting_ui_biometric_faceid_support_title);
      this.OCi.auI(a.i.wallet_password_setting_ui_biometric_faceid_support_summary);
      if (locala.eoq()) {
        this.OCi.ag(getString(a.i.switch_check_desc));
      }
      for (;;)
      {
        this.screen.dz("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.OCi.ag(getString(a.i.switch_uncheck_desc));
      }
    }
    this.screen.dz("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  protected int gHO()
  {
    return a.m.wallet_password_setting_pref;
  }
  
  protected void gHP()
  {
    AppMethodBeat.i(69759);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLc, false))
    {
      Bundle localBundle = new Bundle();
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startModifyPwdUseCase(this, localBundle);
      AppMethodBeat.o(69759);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    AppMethodBeat.o(69759);
  }
  
  protected void gHQ()
  {
    int i = 0;
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.b(b.a.vGX, false))
    {
      Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
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
  
  protected void gHR()
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
    if ((u.gJo().gJS()) || (u.gJo().gJR()))
    {
      this.screen.dz("wallet_modify_password", true);
      this.screen.dz("wallet_forget_password", true);
      this.screen.dz("wallet_realname_verify", false);
      this.screen.byG("wallet_realname_verify").auI(a.i.wallet_password_setting_ui_go_realname_verify_now);
      this.screen.dz("wallet_universal_pay_order", true);
      this.screen.dz("wallet_switch_currency", true);
      this.screen.dz("wallet_switch_category", true);
      this.screen.dz("wallet_biometric_pay", true);
      this.screen.dz("wallet_universal_pay_order", true);
      this.screen.dz("wallet_digitalcert", true);
      this.OCs = u.gJn().bhm("wallet_switch_currency");
      if ((this.OCs == null) || (this.OCs.field_is_show != 1)) {
        break label688;
      }
      this.screen.dz("wallet_switch_currency", false);
      localObject1 = this.screen.byG("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.OCs.field_pref_title);
      ((Preference)localObject1).aF(this.OCs.field_pref_desc);
      bool1 = false;
      this.OCt = u.gJn().bhm("wallet_im_mch");
      if ((this.OCt == null) || (this.OCt.field_is_show != 1)) {
        break label707;
      }
      this.screen.dz("wallet_im_mch", false);
      localObject1 = this.screen.byG("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.OCt.field_pref_title);
      ((Preference)localObject1).aF(this.OCt.field_pref_desc);
      bool2 = false;
      Log.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label727;
      }
      this.screen.dz("wallet_switch_category", true);
      com.tencent.mm.kernel.h.aHH();
      l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
      i = a.i.wallet_delay_transfer_setting_realtime_text;
      if ((0x10 & l) == 0L) {
        break label744;
      }
      i = a.i.wallet_delay_transfer_setting_2h_text;
      this.screen.byG("wallet_delay_transfer_date").auI(i);
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGd, 1);
      if ((!CrashReportFactory.hasDebuger()) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label762;
      }
      i = 1;
      label485:
      if ((j != 0) || (i != 0)) {
        break label767;
      }
      this.screen.dz("wallet_function_settings", true);
    }
    Object localObject2;
    for (;;)
    {
      BY(false);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.OCA == null) || (this.OCA.size() <= 0)) {
        break label793;
      }
      localObject1 = this.OCA.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.d((Preference)localObject2);
      }
      if (u.gJo().gJQ())
      {
        this.screen.dz("wallet_modify_password", false);
        this.screen.dz("wallet_forget_password", false);
        this.screen.dz("wallet_realname_verify", false);
        this.screen.byG("wallet_realname_verify").auI(a.i.wallet_password_setting_ui_realname_verify_done);
        this.screen.dz("wallet_universal_pay_order", true);
        gHS();
        break;
      }
      Log.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label688:
      this.screen.dz("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label707:
      this.screen.dz("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label727:
      this.screen.dz("wallet_switch_category", false);
      break label389;
      label744:
      if ((l & 0x20) == 0L) {
        break label436;
      }
      i = a.i.wallet_delay_transfer_setting_24h_text;
      break label436;
      label762:
      i = 0;
      break label485;
      label767:
      this.screen.dz("wallet_function_settings", false);
    }
    this.OCA.clear();
    label793:
    int i = this.screen.bf("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.h.aHH();
    Object localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxI, "");
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
          localObject2 = m.a.bE(((JSONArray)localObject1).getJSONObject(j));
          if (((m.a)localObject2).OAo != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((m.a)localObject2).OAo;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).WsL = true;
            ((PreferenceTitleCategory)localObject4).setTitle(k.a(getContext(), (erh)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.OCA.add(localObject4);
            localObject3 = ((m.a)localObject2).OAn.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1197;
            }
            localObject4 = (ah)((Iterator)localObject3).next();
            Log.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ah)localObject4).field_pref_key });
            Preference local10 = new Preference(getContext())
            {
              public final void onBindView(View paramAnonymousView)
              {
                AppMethodBeat.i(277485);
                super.onBindView(paramAnonymousView);
                if (this.Wsy != null) {
                  paramAnonymousView.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(272271);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      WalletPasswordSettingUI.10.this.Wsy.fpI();
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(272271);
                    }
                  });
                }
                AppMethodBeat.o(277485);
              }
            };
            local10.setLayoutResource(a.g.mm_preference);
            local10.setTitle(((ah)localObject4).field_pref_title);
            local10.aF(((ah)localObject4).field_pref_desc);
            local10.Wsy = new Preference.b()
            {
              public final boolean fpI()
              {
                AppMethodBeat.i(247280);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.OCH);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(247280);
                return true;
              }
            };
            i += 1;
            this.screen.a(local10, i);
            this.OCA.add(local10);
            Log.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((ah)localObject4).field_pref_key });
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
        this.OCA.add(localObject3);
        break;
        label1197:
        if (((m.a)localObject2).OAp != null)
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((m.a)localObject2).OAp;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).WsL = true;
          ((PreferenceFooterCategory)localObject3).setTitle(k.a(getContext(), (erh)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.OCA.add(localObject3);
          break label1341;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.OCA.add(localObject2);
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
    if (z.bdq()) {}
    for (String str = getString(a.i.wallet_password_setting_ui_title_payu);; str = getString(a.i.wallet_password_setting_ui_title))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.g.iju();
      this.screen = getPreferenceScreen();
      this.screen.auC(gHO());
      this.OCm = ((IconPreference)this.screen.byG("wallet_open_auto_pay"));
      this.OCn = this.screen.byG("wallet_delay_transfer_date");
      com.tencent.mm.kernel.h.aHH();
      if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlk, Boolean.TRUE)).booleanValue())
      {
        this.OCm.hI(getString(a.i.app_new), a.e.new_tips_bg);
        this.OCm.auD(0);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vlk, Boolean.TRUE);
      }
      this.OCh = ((CheckBoxPreference)this.screen.byG("wallet_fingerprint_switch"));
      this.OCi = ((RightBelowPreference)this.screen.byG("wallet_biometric_pay"));
      this.OCj = ((CheckBoxPreference)this.screen.byG("mobile_remit_switch"));
      gHR();
      this.screen.dz("nfc_idpay", true);
      this.screen.dz("wallet_open_auto_pay", true);
      this.screen.dz("wallet_universal_pay_order", true);
      this.screen.dz("wallet_lucky_money_refund_way", true);
      gHN();
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
      if (com.tencent.mm.plugin.wallet.b.a.gIf()) {
        com.tencent.mm.plugin.report.service.h.IzE.a(15817, new Object[] { Integer.valueOf(0) });
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
      if (!z.bdr()) {
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
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1477, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1813, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1724, this);
    EventCenter.instance.addListener(this.OvC);
    this.OCC.alive();
    this.jYb = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.OCl = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.jYb)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxs, "");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.OCf = f.a.bgI(paramBundle);
      Log.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.OCf });
      BY(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
      u.gJi();
      boolean bool = u.gJx();
      Log.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label588;
      }
      paramBundle = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxF, "");
      if (Util.isNullOrNil(paramBundle)) {
        break label577;
      }
      this.OCu = h.a.bgJ(paramBundle);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.OCf });
      label358:
      BZ(false);
      com.tencent.mm.kernel.h.aHH();
      this.OCz = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxG, Integer.valueOf(2))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.OCz) });
      if (this.OCz == 0) {
        this.OCz = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.OCz);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
      label455:
      if (!m.eqj()) {
        break label596;
      }
      BX(false);
      label466:
      com.tencent.mm.kernel.h.aHH();
      this.OCx = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnT, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.aHH();
      this.OCq = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnN, ""));
      if (!Util.isNullOrNil(this.OCq)) {
        break label768;
      }
      ak.a(true, null);
    }
    for (;;)
    {
      if (this.OCx == 0) {
        this.screen.dz("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label577:
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label358;
      label588:
      BZ(false);
      break label455;
      label596:
      com.tencent.mm.kernel.h.aHH();
      this.OCp = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlt, ""));
      this.OCr = u.gJn().bhm("wallet_open_auto_pay");
      if ((this.OCr != null) && (this.OCr.field_is_show == 1))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.OCo = this.OCr.field_pref_url;
        aT(this.OCr.field_pref_title, this.OCr.field_pref_url, this.OCr.field_tinyapp_path);
        break label466;
      }
      if (this.OCr == null)
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label466;
      }
      Log.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.OCr.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + Util.isNullOrNil(this.OCr.field_pref_url));
      break label466;
      label768:
      this.OCn.setTitle(this.OCq);
      ak.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    EventCenter.instance.removeListener(this.OvC);
    this.OCC.dead();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1477, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1813, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      gHP();
      com.tencent.mm.wallet_core.ui.g.azK(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.h.aHH();
      paramf = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlC, "");
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.g.o(getContext(), paramf, false);
        paramf = new nu();
        paramf.hal = 2L;
        paramf.ham = 2L;
        paramf.bpa();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = u.gJo().gKd();
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.g.o(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      gHQ();
      paramf = new nu();
      paramf.hal = 2L;
      paramf.ham = 1L;
      paramf.bpa();
      com.tencent.mm.wallet_core.ui.g.azK(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (u.gJo().gJQ()) {
        if (!Util.isNullOrNil(this.OCp))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.OCp);
          paramf.putExtra("showShare", false);
          paramf.putExtra(f.r.VSX, true);
          com.tencent.mm.wallet_core.ui.g.aJ(getContext(), paramf);
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
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.OCD);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.OCf.gHs().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new nr();
      com.tencent.mm.kernel.h.aHH();
      if (Util.isEqual(((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.goH = i;
        paramf.bpa();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.OCr);
      this.OCm.auD(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.OCw)
      {
        paramf = new m();
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramf, 0);
      }
      com.tencent.mm.by.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf.putExtra("key_scene", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.h.aHH();
      paramf = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsp, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(f.r.VSX, true);
      com.tencent.mm.wallet_core.ui.g.aJ(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.OCs);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.OCt);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.by.c.ad(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        i = 1;
        this.OCv = new ny();
        this.OCv.gef = i;
        if (this.scene != 0) {
          break label1333;
        }
        this.OCv.haq = 2L;
        label1248:
        this.OCv.bpa();
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.g(i, this.OCz);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramf, 0);
        if (this.OCk != null) {
          break label1352;
        }
        this.OCk = com.tencent.mm.ui.base.h.a(this, 0, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
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
        label1333:
        if (this.scene != 1) {
          break label1248;
        }
        this.OCv.haq = 1L;
        break label1248;
        label1352:
        this.OCk.show();
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).gNm()) {
      finish();
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new ae(null, 1), 0);
      AppMethodBeat.o(69757);
      return;
      gHR();
      if (this.OCB)
      {
        this.OCB = false;
        BX(false);
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
      if ((paramq instanceof ae))
      {
        gHR();
        gHN();
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof m))
      {
        gHR();
        paramString = (m)paramq;
        Log.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.OAh);
        this.OCp = paramString.OAl;
        this.OCr = u.gJn().bhm("wallet_open_auto_pay");
        if ((this.OCr != null) && (this.OCr.field_is_show == 1))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.OCo = this.OCr.field_pref_url;
          aT(this.OCr.field_pref_title, this.OCr.field_pref_url, this.OCr.field_tinyapp_path);
        }
        for (;;)
        {
          gHN();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.dz("wallet_open_auto_pay", true);
        }
      }
      if ((paramq instanceof ak))
      {
        this.OCq = ((ak)paramq).OIC;
        this.OCx = ((ak)paramq).OII;
        if (this.OCx == 0)
        {
          this.screen.dz("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!Util.isNullOrNil(this.OCq)) {
          this.OCn.setTitle(this.OCq);
        }
        for (;;)
        {
          this.screen.dz("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.OCf = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramq).gHr();
        BY(true);
        Log.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.OCf.gHs() });
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxs, this.OCf.gHs());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramq;
        if (paramString.OAc == null)
        {
          paramString.OAc = new h.a();
          paramString.OAc.tqa = paramString.OAb.tqa;
          paramString.OAc.tqb = paramString.OAb.tqb;
          paramString.OAc.tpu = paramString.OAb.tpu;
          paramString.OAc.OAd = paramString.OAb.OAd;
          paramString.OAc.OzR = paramString.OAb.OzR;
          paramString.OAc.wording = paramString.OAb.wording;
        }
        this.OCu = paramString.OAc;
        BZ(true);
        Log.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.OCu.gHs() });
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxF, this.OCu.gHs());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
      {
        if ((this.OCk != null) && (this.OCk.isShowing())) {
          this.OCk.dismiss();
        }
        paramq = (com.tencent.mm.plugin.wallet.pwd.a.g)paramq;
        if (paramq.OAa == null)
        {
          paramq = new etw();
          if (paramq == null)
          {
            if (!Util.isNullOrNil(paramString)) {
              break label928;
            }
            paramString = getString(a.i.wallet_data_err);
            label709:
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          }
          paramInt1 = paramq.tqa;
          paramString = paramq.tqb;
          if (paramq.Sih != null) {
            break label931;
          }
          bool1 = true;
          label755:
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramq.UvH), paramq.wording });
          paramInt1 = paramq.UvH;
          paramString = paramq.wording;
          if (!Util.isNullOrNil(paramString)) {
            break label937;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label832:
          if (paramq.tqa != 0) {
            break label1072;
          }
          if (paramq.UvI == null) {
            break label1008;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), paramq.UvI, null, new l.a()
          {
            public final void dS(Object paramAnonymousObject)
            {
              AppMethodBeat.i(69740);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(69740);
            }
            
            public final void fAe()
            {
              AppMethodBeat.i(163865);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(163865);
            }
            
            public final int fAf()
            {
              return 1149;
            }
            
            public final void fAg()
            {
              AppMethodBeat.i(163866);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(163866);
            }
            
            public final void fAh()
            {
              AppMethodBeat.i(163867);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(163867);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(69739);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(69739);
            }
          });
          paramString = this.OCj;
          if (this.OCj.isChecked()) {
            break label1002;
          }
        }
        label928:
        label931:
        label937:
        label1002:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramq = paramq.OAa;
          break;
          break label709;
          bool1 = false;
          break label755;
          this.OCz = paramInt1;
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxG, Integer.valueOf(paramInt1));
          this.OCu.wording = paramString;
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxF, this.OCu.gHs());
          bgL(paramString);
          this.screen.notifyDataSetChanged();
          break label832;
        }
        label1008:
        if (this.OCj.isChecked())
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxE, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxE, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1072:
        if (paramq.tqa == 416) {
          if (paramq.Sih != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramq.tqa;
            paramq = paramq.Sih;
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
            paramString = this.OCj;
            if (this.OCj.isChecked()) {
              break label1350;
            }
          }
        }
        label1350:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (Util.isNullOrNil(paramq.tqb)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramq.tqb)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            break;
          }
          if (paramq.UvI != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            com.tencent.mm.wallet_core.c.l.a(getContext(), paramq.UvI, null, new l.a()
            {
              public final void dS(Object paramAnonymousObject)
              {
                AppMethodBeat.i(69743);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(69743);
              }
              
              public final void fAe()
              {
                AppMethodBeat.i(163868);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(163868);
              }
              
              public final int fAf()
              {
                return 1149;
              }
              
              public final void fAg()
              {
                AppMethodBeat.i(163869);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(163869);
              }
              
              public final void fAh()
              {
                AppMethodBeat.i(163870);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(163870);
              }
              
              public final void fAl()
              {
                AppMethodBeat.i(69742);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69742);
              }
            });
            break;
          }
          if (paramq.tqa == 0) {
            break;
          }
          if (Util.isNullOrNil(paramq.tqb)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramq.tqb)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            break;
          }
        }
      }
    }
    else
    {
      if ((paramq instanceof ak))
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
        if ((this.OCk != null) && (this.OCk.isShowing())) {
          this.OCk.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.mobile_remit_data_err);
        }
        w.makeText(localAppCompatActivity, paramq, 0).show();
        paramString = this.OCj;
        if (this.OCj.isChecked()) {
          break label1538;
        }
      }
    }
    for (;;)
    {
      paramString.setChecked(bool1);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69768);
      return;
      label1538:
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