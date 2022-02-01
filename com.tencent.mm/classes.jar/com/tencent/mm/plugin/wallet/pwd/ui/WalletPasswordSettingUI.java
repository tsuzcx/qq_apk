package com.tencent.mm.plugin.wallet.pwd.ui;

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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.acv;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.cr;
import com.tencent.mm.autogen.a.cr.b;
import com.tencent.mm.autogen.a.qx;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.mmdata.rpt.rj;
import com.tencent.mm.autogen.mmdata.rpt.rm;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.autogen.mmdata.rpt.rq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.g;
import com.tencent.mm.plugin.wallet.pwd.a.h.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fpj;
import com.tencent.mm.protocal.protobuf.fpt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.j.b;
import com.tencent.mm.wallet_core.e.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class WalletPasswordSettingUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  IListener VkP;
  private String VrA;
  private String VrB;
  private String VrC;
  private af VrD;
  private af VrE;
  private af VrF;
  private h.a VrG;
  private rq VrH;
  private boolean VrI;
  private int VrJ;
  private int VrK;
  private int VrL;
  private List<Preference> VrM;
  private boolean VrN;
  private boolean VrO;
  private IListener<qx> VrP;
  private e.a VrQ;
  private f.a Vrr;
  CheckBoxPreference Vrt;
  RightBelowPreference Vru;
  CheckBoxPreference Vrv;
  private Dialog Vrw;
  private boolean Vrx;
  private IconPreference Vry;
  private Preference Vrz;
  private MMHandler handler;
  private boolean mxV;
  private int scene;
  private com.tencent.mm.ui.base.preference.f screen;
  private Dialog tipDialog;
  
  public WalletPasswordSettingUI()
  {
    AppMethodBeat.i(69753);
    this.Vrw = null;
    this.Vrx = false;
    this.VrI = false;
    this.VrJ = 0;
    this.VrK = 0;
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
    this.VrL = 2;
    this.VrM = new ArrayList();
    this.VrN = false;
    this.VrO = false;
    this.VkP = new IListener(com.tencent.mm.app.f.hfK) {};
    this.VrP = new IListener(com.tencent.mm.app.f.hfK) {};
    this.VrQ = new e.a()
    {
      public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69749);
        Log.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
        paramAnonymousBundle = new acz();
        if (paramAnonymousInt == -1) {
          paramAnonymousBundle.igq.scene = 17;
        }
        for (;;)
        {
          paramAnonymousBundle.igr.igh = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69748);
              WalletPasswordSettingUI.this.igW();
              AppMethodBeat.o(69748);
            }
          };
          paramAnonymousBundle.publish();
          AppMethodBeat.o(69749);
          return null;
          if (paramAnonymousInt == 0) {
            paramAnonymousBundle.igq.scene = 18;
          } else {
            paramAnonymousBundle.igq.scene = 0;
          }
        }
      }
    };
    AppMethodBeat.o(69753);
  }
  
  private void HB(boolean paramBoolean)
  {
    AppMethodBeat.i(69761);
    getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.Vrt.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(69761);
  }
  
  private void HC(boolean paramBoolean)
  {
    AppMethodBeat.i(69767);
    com.tencent.mm.plugin.wallet.pwd.a.l locall = new com.tencent.mm.plugin.wallet.pwd.a.l();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(locall, 0);
    this.VrI = true;
    if (paramBoolean) {
      this.tipDialog = com.tencent.mm.wallet_core.ui.l.a(this, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(315601);
          if (WalletPasswordSettingUI.h(WalletPasswordSettingUI.this) != null) {
            WalletPasswordSettingUI.h(WalletPasswordSettingUI.this).dismiss();
          }
          AppMethodBeat.o(315601);
        }
      });
    }
    AppMethodBeat.o(69767);
  }
  
  private void HD(boolean paramBoolean)
  {
    AppMethodBeat.i(69769);
    if (this.Vrr == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
      this.screen.eh("wallet_lucky_money_refund_way", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69769);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", new Object[] { Boolean.valueOf(this.Vrr.CGI), Integer.valueOf(this.Vrr.hAV), this.Vrr.Vpa });
      if ((!this.Vrr.CGI) && (Util.isEqual(this.Vrr.hAV, 0))) {
        break;
      }
      this.screen.eh("wallet_lucky_money_refund_way", true);
    }
    if (Util.isNullOrNil(this.Vrr.Vpa))
    {
      this.screen.eh("wallet_lucky_money_refund_way", true);
      AppMethodBeat.o(69769);
      return;
    }
    IconPreference localIconPreference = (IconPreference)this.screen.bAi("wallet_lucky_money_refund_way");
    localIconPreference.setTitle(this.Vrr.Vpa);
    com.tencent.mm.kernel.h.baF();
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue() & 0x3;
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", new Object[] { Long.toBinaryString(l) });
    if (Util.isEqual(l, 2L))
    {
      localIconPreference.aS(this.Vrr.Vpd);
      label267:
      if ((paramBoolean) && (this.Vrr.hJQ))
      {
        com.tencent.mm.kernel.h.baF();
        if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZf, Boolean.FALSE)).booleanValue()) {
          break label365;
        }
        localIconPreference.aeD(0);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZf, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.screen.eh("wallet_lucky_money_refund_way", false);
      break;
      localIconPreference.aS(this.Vrr.Vpb);
      break label267;
      label365:
      localIconPreference.aeD(8);
    }
  }
  
  private void HE(boolean paramBoolean)
  {
    AppMethodBeat.i(69770);
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.VrG == null)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
      this.screen.eh("mobile_remit_switch", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69770);
      return;
    }
    if ((this.VrG.wuz != 0) || (!this.VrG.wtT))
    {
      this.screen.eh("mobile_remit_switch", true);
      AppMethodBeat.o(69770);
      return;
    }
    if (Util.isNullOrNil(this.VrG.Vpa))
    {
      this.screen.eh("mobile_remit_switch", false);
      AppMethodBeat.o(69770);
      return;
    }
    this.Vrv.setTitle(this.VrG.Vpa);
    bgr(this.VrG.wording);
    CheckBoxPreference localCheckBoxPreference;
    if (paramBoolean)
    {
      localCheckBoxPreference = this.Vrv;
      paramBoolean = this.VrG.Vpm;
    }
    for (;;)
    {
      localCheckBoxPreference.setChecked(paramBoolean);
      this.screen.eh("mobile_remit_switch", false);
      break;
      com.tencent.mm.kernel.h.baF();
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZr, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", new Object[] { Integer.valueOf(i) });
      localCheckBoxPreference = this.Vrv;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
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
      Log.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", new Object[] { paramaf.field_pref_url });
      if (!Util.isNullOrNil(paramaf.field_pref_url))
      {
        com.tencent.mm.wallet_core.ui.i.o(this, paramaf.field_pref_url, false);
        AppMethodBeat.o(69763);
        return;
        if (!Util.isNullOrNil(paramaf.field_tinyapp_username))
        {
          zp localzp = new zp();
          localzp.icM.userName = paramaf.field_tinyapp_username;
          localzp.icM.icO = Util.nullAs(paramaf.field_tinyapp_path, "");
          localzp.icM.scene = 1066;
          localzp.icM.icP = 0;
          localzp.publish();
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
          com.tencent.mm.br.c.ai(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
          paramaf = new Intent();
          paramaf.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramaf);
          new rn();
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
          com.tencent.mm.br.c.g(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(69763);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
          com.tencent.mm.br.c.ai(this, "honey_pay", ".ui.HoneyPayMainUI");
        }
      }
    }
  }
  
  private void asa(int paramInt)
  {
    AppMethodBeat.i(315638);
    Log.i("MicroMsg.WalletPasswordSettingUI", "clickMobileRemitSwitch");
    g localg = new g(paramInt, this.VrL);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(localg, 0);
    if (this.Vrw == null)
    {
      this.Vrw = k.a(this, 0, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(315661);
          Log.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
          AppMethodBeat.o(315661);
        }
      });
      AppMethodBeat.o(315638);
      return;
    }
    this.Vrw.show();
    AppMethodBeat.o(315638);
  }
  
  private void bgr(String paramString)
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
      paramString = com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, 10, false, null);
      this.Vrv.aeaa = true;
      this.Vrv.aS(paramString);
      AppMethodBeat.o(182520);
      return;
    }
    this.Vrv.aS(paramString);
    AppMethodBeat.o(182520);
  }
  
  private void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(315619);
    this.Vry.setTitle(paramString1);
    if ((!Util.isNullOrNil(paramString2)) || (!Util.isNullOrNil(paramString3)))
    {
      this.screen.eh("wallet_open_auto_pay", false);
      AppMethodBeat.o(315619);
      return;
    }
    this.screen.eh("wallet_open_auto_pay", true);
    Log.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
    AppMethodBeat.o(315619);
  }
  
  private void igS()
  {
    AppMethodBeat.i(69756);
    com.tencent.mm.kernel.h.baF();
    String str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTT, "");
    com.tencent.mm.kernel.h.baF();
    String str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTU, "");
    Log.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (u.iiC().ijf()))
    {
      this.screen.eh("wallet_password_setting_un_reg", false);
      AppMethodBeat.o(69756);
      return;
    }
    this.screen.eh("wallet_password_setting_un_reg", true);
    AppMethodBeat.o(69756);
  }
  
  private void igX()
  {
    AppMethodBeat.i(69766);
    if ((u.iiC().ijh()) || (u.iiC().ijg()))
    {
      this.screen.eh("wallet_biometric_pay", true);
      AppMethodBeat.o(69766);
      return;
    }
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if ((com.tencent.mm.plugin.wallet.b.a.ihi()) && (com.tencent.mm.plugin.wallet.b.a.ihj()))
    {
      this.Vru.setTitle(a.i.wallet_password_setting_ui_biometric_multi_support_title);
      this.Vru.aBk(a.i.wallet_password_setting_ui_biometric_multi_support_summary);
      if (locala.ftt()) {
        this.Vru.at(getString(a.i.wallet_biometric_pay_status_faceid_open));
      }
      for (;;)
      {
        this.screen.eh("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        if (locala.ftq()) {
          this.Vru.at(getString(a.i.wallet_biometric_pay_status_fingerprint_open));
        } else {
          this.Vru.at(getString(a.i.switch_uncheck_desc));
        }
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.ihi())
    {
      this.Vru.setTitle(a.i.wallet_password_setting_ui_biometric_fingerprint_support_title);
      this.Vru.aBk(a.i.wallet_password_setting_ui_biometric_fingerprint_support_summary);
      if (locala.ftq()) {
        this.Vru.at(getString(a.i.switch_check_desc));
      }
      for (;;)
      {
        this.screen.eh("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Vru.at(getString(a.i.switch_uncheck_desc));
      }
    }
    if (com.tencent.mm.plugin.wallet.b.a.ihj())
    {
      this.Vru.setTitle(a.i.wallet_password_setting_ui_biometric_faceid_support_title);
      this.Vru.aBk(a.i.wallet_password_setting_ui_biometric_faceid_support_summary);
      if (locala.ftt()) {
        this.Vru.at(getString(a.i.switch_check_desc));
      }
      for (;;)
      {
        this.screen.eh("wallet_biometric_pay", false);
        AppMethodBeat.o(69766);
        return;
        this.Vru.at(getString(a.i.switch_uncheck_desc));
      }
    }
    this.screen.eh("wallet_biometric_pay", true);
    AppMethodBeat.o(69766);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  protected int igT()
  {
    return a.m.wallet_password_setting_pref;
  }
  
  protected void igU()
  {
    AppMethodBeat.i(69759);
    Bundle localBundle = new Bundle();
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startModifyPwdUseCase(this, localBundle);
    AppMethodBeat.o(69759);
  }
  
  protected void igV()
  {
    AppMethodBeat.i(69760);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.b.jNX();
    Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(this, localBundle);
    AppMethodBeat.o(69760);
  }
  
  protected void igW()
  {
    AppMethodBeat.i(69765);
    boolean bool1;
    label253:
    boolean bool2;
    label339:
    long l;
    if ((u.iiC().ijh()) || (u.iiC().ijg()))
    {
      this.screen.eh("wallet_modify_password", true);
      this.screen.eh("wallet_forget_password", true);
      this.screen.eh("wallet_realname_verify", false);
      this.screen.bAi("wallet_realname_verify").aBk(a.i.wallet_password_setting_ui_go_realname_verify_now);
      this.screen.eh("wallet_universal_pay_order", true);
      this.screen.eh("wallet_switch_currency", true);
      this.screen.eh("wallet_switch_category", true);
      this.screen.eh("wallet_biometric_pay", true);
      this.screen.eh("wallet_universal_pay_order", true);
      this.screen.eh("wallet_digitalcert", true);
      this.VrE = u.iiB().bgW("wallet_switch_currency");
      if ((this.VrE == null) || (this.VrE.field_is_show != 1)) {
        break label647;
      }
      this.screen.eh("wallet_switch_currency", false);
      localObject1 = this.screen.bAi("wallet_switch_currency");
      ((Preference)localObject1).setTitle(this.VrE.field_pref_title);
      ((Preference)localObject1).aS(this.VrE.field_pref_desc);
      bool1 = false;
      this.VrF = u.iiB().bgW("wallet_im_mch");
      if ((this.VrF == null) || (this.VrF.field_is_show != 1)) {
        break label666;
      }
      this.screen.eh("wallet_im_mch", false);
      localObject1 = this.screen.bAi("wallet_im_mch");
      ((Preference)localObject1).setTitle(this.VrF.field_pref_title);
      ((Preference)localObject1).aS(this.VrF.field_pref_desc);
      bool2 = false;
      Log.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label686;
      }
      this.screen.eh("wallet_switch_category", true);
      label389:
      com.tencent.mm.kernel.h.baF();
      l = ((Long)com.tencent.mm.kernel.h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
      i = a.i.wallet_delay_transfer_setting_realtime_text;
      if ((0x10 & l) == 0L) {
        break label703;
      }
      i = a.i.wallet_delay_transfer_setting_2h_text;
    }
    Object localObject2;
    for (;;)
    {
      this.screen.bAi("wallet_delay_transfer_date").aBk(i);
      this.screen.eh("wallet_function_settings", false);
      HD(false);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
      if ((this.VrM == null) || (this.VrM.size() <= 0)) {
        break label730;
      }
      localObject1 = this.VrM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Preference)((Iterator)localObject1).next();
        this.screen.e((Preference)localObject2);
      }
      if (u.iiC().ijf())
      {
        this.screen.eh("wallet_modify_password", false);
        this.screen.eh("wallet_forget_password", false);
        this.screen.eh("wallet_realname_verify", false);
        this.screen.bAi("wallet_realname_verify").aBk(a.i.wallet_password_setting_ui_realname_verify_done);
        this.screen.eh("wallet_universal_pay_order", true);
        igX();
        break;
      }
      Log.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
      break;
      label647:
      this.screen.eh("wallet_switch_currency", true);
      bool1 = true;
      break label253;
      label666:
      this.screen.eh("wallet_im_mch", true);
      bool2 = true;
      break label339;
      label686:
      this.screen.eh("wallet_switch_category", false);
      break label389;
      label703:
      if ((l & 0x20) != 0L) {
        i = a.i.wallet_delay_transfer_setting_24h_text;
      }
    }
    this.VrM.clear();
    label730:
    int i = this.screen.cs("wallet_lucky_money_refund_way");
    com.tencent.mm.kernel.h.baF();
    Object localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZv, "");
    if (!Util.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      int j;
      Object localObject3;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = com.tencent.mm.plugin.wallet.pwd.a.l.a.bZ(((JSONArray)localObject1).getJSONObject(j));
          if (((com.tencent.mm.plugin.wallet.pwd.a.l.a)localObject2).VpB != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
            localObject3 = ((com.tencent.mm.plugin.wallet.pwd.a.l.a)localObject2).VpB;
            Object localObject4 = new PreferenceTitleCategory(getContext());
            ((Preference)localObject4).aeab = true;
            ((PreferenceTitleCategory)localObject4).setTitle(n.a(getContext(), (fmp)localObject3, null));
            i += 1;
            this.screen.a((Preference)localObject4, i);
            this.VrM.add(localObject4);
            localObject3 = ((com.tencent.mm.plugin.wallet.pwd.a.l.a)localObject2).VpA.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label1134;
            }
            localObject4 = (af)((Iterator)localObject3).next();
            Log.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
            WalletPasswordSettingUI.11 local11 = new WalletPasswordSettingUI.11(this, getContext());
            local11.setLayoutResource(a.g.mm_preference);
            local11.setTitle(((af)localObject4).field_pref_title);
            local11.aS(((af)localObject4).field_pref_desc);
            local11.adZO = new Preference.b()
            {
              public final boolean gAW()
              {
                AppMethodBeat.i(315662);
                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.VrU);
                WalletPasswordSettingUI.i(WalletPasswordSettingUI.this);
                AppMethodBeat.o(315662);
                return true;
              }
            };
            i += 1;
            this.screen.a(local11, i);
            this.VrM.add(local11);
            Log.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", new Object[] { ((af)localObject4).field_pref_key });
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
        this.VrM.add(localObject3);
        break;
        label1134:
        if (((com.tencent.mm.plugin.wallet.pwd.a.l.a)localObject2).VpC != null)
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
          localObject2 = ((com.tencent.mm.plugin.wallet.pwd.a.l.a)localObject2).VpC;
          localObject3 = new PreferenceFooterCategory(getContext());
          ((Preference)localObject3).aeab = true;
          ((PreferenceFooterCategory)localObject3).setTitle(n.a(getContext(), (fmp)localObject2, null));
          i += 1;
          this.screen.a((Preference)localObject3, i);
          this.VrM.add(localObject3);
          break label1278;
        }
        i += 1;
        localObject2 = new PreferenceSmallCategory(getContext());
        this.screen.a((Preference)localObject2, i);
        this.VrM.add(localObject2);
        break label1278;
        this.screen.notifyDataSetChanged();
      }
      label1278:
      j += 1;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(69758);
    if (z.bBi()) {}
    for (String str = getString(a.i.wallet_password_setting_ui_title_payu);; str = getString(a.i.wallet_password_setting_ui_title))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.i.jPs();
      this.screen = getPreferenceScreen();
      this.screen.aBe(igT());
      this.Vry = ((IconPreference)this.screen.bAi("wallet_open_auto_pay"));
      this.Vrz = this.screen.bAi("wallet_delay_transfer_date");
      com.tencent.mm.kernel.h.baF();
      if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acME, Boolean.TRUE)).booleanValue())
      {
        this.Vry.iP(getString(a.i.app_new), a.e.new_tips_bg);
        this.Vry.aBf(0);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acME, Boolean.TRUE);
      }
      this.Vrt = ((CheckBoxPreference)this.screen.bAi("wallet_fingerprint_switch"));
      this.Vru = ((RightBelowPreference)this.screen.bAi("wallet_biometric_pay"));
      this.Vrv = ((CheckBoxPreference)this.screen.bAi("mobile_remit_switch"));
      igW();
      this.screen.eh("nfc_idpay", true);
      this.screen.eh("wallet_open_auto_pay", true);
      this.screen.eh("wallet_universal_pay_order", true);
      this.screen.eh("wallet_lucky_money_refund_way", true);
      igS();
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
      if (com.tencent.mm.plugin.wallet.b.a.ihj()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15817, new Object[] { Integer.valueOf(0) });
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
      if (!z.bBj()) {
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1477, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1813, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1724, this);
    this.VkP.alive();
    this.VrP.alive();
    this.mxV = getIntent().getBooleanExtra("key_is_from_system", false);
    this.scene = getIntent().getIntExtra("key_enter_scene", 0);
    this.Vrx = getIntent().getBooleanExtra("key_default_show_currency", false);
    if (this.mxV)
    {
      Log.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZe, "");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.Vrr = f.a.bgo(paramBundle);
      Log.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", new Object[] { this.Vrr });
      HD(false);
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.f();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
      u.iiw();
      boolean bool = u.iiL();
      Log.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label583;
      }
      paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZs, "");
      if (Util.isNullOrNil(paramBundle)) {
        break label572;
      }
      this.VrG = h.a.bgp(paramBundle);
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", new Object[] { this.Vrr });
      label353:
      HE(false);
      com.tencent.mm.kernel.h.baF();
      this.VrL = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZt, Integer.valueOf(2))).intValue();
      Log.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", new Object[] { Integer.valueOf(this.VrL) });
      if (this.VrL == 0) {
        this.VrL = 2;
      }
      paramBundle = new com.tencent.mm.plugin.wallet.pwd.a.h(this.VrL);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
      label450:
      if (!com.tencent.mm.plugin.wallet.pwd.a.l.dgl()) {
        break label591;
      }
      HC(false);
      label461:
      com.tencent.mm.kernel.h.baF();
      this.VrJ = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPo, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.baF();
      this.VrC = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPi, ""));
      if (!Util.isNullOrNil(this.VrC)) {
        break label763;
      }
      ak.a(true, null);
    }
    for (;;)
    {
      if (this.VrJ == 0) {
        this.screen.eh("wallet_delay_transfer_date", true);
      }
      AppMethodBeat.o(69754);
      return;
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
      break;
      label572:
      Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
      break label353;
      label583:
      HE(false);
      break label450;
      label591:
      com.tencent.mm.kernel.h.baF();
      this.VrB = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMN, ""));
      this.VrD = u.iiB().bgW("wallet_open_auto_pay");
      if ((this.VrD != null) && (this.VrD.field_is_show == 1))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.VrA = this.VrD.field_pref_url;
        bl(this.VrD.field_pref_title, this.VrD.field_pref_url, this.VrD.field_tinyapp_path);
        break label461;
      }
      if (this.VrD == null)
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break label461;
      }
      Log.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.VrD.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + Util.isNullOrNil(this.VrD.field_pref_url));
      break label461;
      label763:
      this.Vrz.setTitle(this.VrC);
      ak.a(true, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69771);
    super.onDestroy();
    this.VkP.dead();
    this.VrP.dead();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1477, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1813, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1724, this);
    AppMethodBeat.o(69771);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69762);
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      igU();
      com.tencent.mm.wallet_core.ui.i.aGA(24);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_forget_password".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.h.baF();
      paramf = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMW, "");
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.i.o(getContext(), paramf, false);
        paramf = new rm();
        paramf.jvV = 2L;
        paramf.jvW = 2L;
        paramf.bMH();
        AppMethodBeat.o(69762);
        return true;
      }
      paramf = u.iiC().iju();
      if (!Util.isNullOrNil(paramf))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
        com.tencent.mm.wallet_core.ui.i.o(this, paramf, false);
        AppMethodBeat.o(69762);
        return true;
      }
      igV();
      paramf = new rm();
      paramf.jvV = 2L;
      paramf.jvW = 1L;
      paramf.bMH();
      com.tencent.mm.wallet_core.ui.i.aGA(25);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_realname_verify".equals(paramPreference.mKey))
    {
      if (u.iiC().ijf()) {
        if (!Util.isNullOrNil(this.VrB))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.VrB);
          paramf.putExtra("showShare", false);
          paramf.putExtra(f.s.adxf, true);
          com.tencent.mm.wallet_core.ui.i.aS(getContext(), paramf);
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
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, this.VrQ);
      }
    }
    int i;
    if ("wallet_lucky_money_refund_way".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
      paramf.putExtra("key_hb_refund_config", this.Vrr.igw().toString());
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new rj();
      com.tencent.mm.kernel.h.baF();
      if (Util.isEqual(((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue() & 0x3, 2L)) {}
      for (i = 2;; i = 1)
      {
        paramf.iyh = i;
        paramf.bMH();
        AppMethodBeat.o(69762);
        return true;
      }
    }
    if ("wallet_biometric_pay".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletBiometricPaySettingsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_open_auto_pay".equals(paramPreference.mKey))
    {
      a(this.VrD);
      this.Vry.aBf(8);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_digitalcert".equals(paramPreference.mKey))
    {
      if (!this.VrI)
      {
        paramf = new com.tencent.mm.plugin.wallet.pwd.a.l();
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramf, 0);
      }
      com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
    {
      paramf = new Intent(this, WalletDelayTransferSettingUI.class);
      paramf.putExtra("key_scene", 2);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_password_setting_un_reg".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.h.baF();
      paramf = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTU, "");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra(f.s.adxf, true);
      com.tencent.mm.wallet_core.ui.i.aS(getContext(), localIntent);
    }
    if ("wallet_switch_currency".equals(paramPreference.mKey))
    {
      a(this.VrE);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_im_mch".equals(paramPreference.mKey))
    {
      a(this.VrF);
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_universal_pay_order".equals(paramPreference.mKey))
    {
      paramf = new Intent(getContext(), WalletUniversalPayOrderUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("wallet_function_settings".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.c.ai(getContext(), "mall", ".ui.MallFunctionSettingsUI");
      AppMethodBeat.o(69762);
      return true;
    }
    if ("mobile_remit_switch".equals(paramPreference.mKey))
    {
      boolean bool;
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.is_new_user ：%s", new Object[] { Boolean.valueOf(this.VrG.Vpn) });
        if (this.VrG.Vpn)
        {
          this.VrO = false;
          if ((Util.isNullOrNil(this.VrG.Vpp)) || (Util.isNullOrNil(this.VrG.Vpo)))
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", "showProtocalBottomDialog do not have wording");
            paramf = this.Vrv;
            if (!this.Vrv.isChecked())
            {
              bool = true;
              paramf.setChecked(bool);
              this.screen.notifyDataSetChanged();
              i = 1;
              label1318:
              this.VrH = new rq();
              this.VrH.ikE = i;
              if (this.scene != 0) {
                break label1476;
              }
              this.VrH.jwa = 2L;
            }
          }
        }
      }
      for (;;)
      {
        this.VrH.bMH();
        AppMethodBeat.o(69762);
        return true;
        bool = false;
        break;
        com.tencent.mm.plugin.report.service.h.OAn.b(24835, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        agfT = new j.b()
        {
          public final void cm(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(315659);
            Log.i("MicroMsg.WalletPasswordSettingUI", "showProtocalBottomDialog click next");
            com.tencent.mm.plugin.report.service.h.OAn.b(24835, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
            WalletPasswordSettingUI.j(WalletPasswordSettingUI.this).Vpn = false;
            WalletPasswordSettingUI.k(WalletPasswordSettingUI.this);
            WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, this.VrV);
            AppMethodBeat.o(315659);
          }
          
          public final void onCancel()
          {
            boolean bool = true;
            AppMethodBeat.i(315660);
            Log.i("MicroMsg.WalletPasswordSettingUI", "showProtocalBottomDialog click cancel");
            com.tencent.mm.plugin.report.service.h.OAn.b(24835, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
            WalletPasswordSettingUI.k(WalletPasswordSettingUI.this);
            CheckBoxPreference localCheckBoxPreference = WalletPasswordSettingUI.this.Vrv;
            if (!WalletPasswordSettingUI.this.Vrv.isChecked()) {}
            for (;;)
            {
              localCheckBoxPreference.setChecked(bool);
              WalletPasswordSettingUI.l(WalletPasswordSettingUI.this).notifyDataSetChanged();
              AppMethodBeat.o(315660);
              return;
              bool = false;
            }
          }
        }
        {
          public final void dismiss()
          {
            AppMethodBeat.i(315657);
            CheckBoxPreference localCheckBoxPreference;
            if (!WalletPasswordSettingUI.m(WalletPasswordSettingUI.this))
            {
              localCheckBoxPreference = WalletPasswordSettingUI.this.Vrv;
              if (WalletPasswordSettingUI.this.Vrv.isChecked()) {
                break label61;
              }
            }
            label61:
            for (boolean bool = true;; bool = false)
            {
              localCheckBoxPreference.setChecked(bool);
              WalletPasswordSettingUI.l(WalletPasswordSettingUI.this).notifyDataSetChanged();
              AppMethodBeat.o(315657);
              return;
            }
          }
        };
        i = 1;
        break label1318;
        asa(1);
        i = 1;
        break label1318;
        i = 2;
        asa(2);
        break label1318;
        label1476:
        if (this.scene == 1) {
          this.VrH.jwa = 1L;
        }
      }
    }
    AppMethodBeat.o(69762);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69757);
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).imB()) {
      finish();
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new ae(null, 1), 0);
      AppMethodBeat.o(69757);
      return;
      igW();
      if (this.VrN)
      {
        this.VrN = false;
        HC(false);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(69768);
    Log.i("MicroMsg.WalletPasswordSettingUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ae))
      {
        igW();
        igS();
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.l))
      {
        igW();
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.l)paramp;
        Log.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.Vpu);
        this.VrB = paramString.Vpy;
        this.VrD = u.iiB().bgW("wallet_open_auto_pay");
        if ((this.VrD != null) && (this.VrD.field_is_show == 1))
        {
          Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
          this.VrA = this.VrD.field_pref_url;
          bl(this.VrD.field_pref_title, this.VrD.field_pref_url, this.VrD.field_tinyapp_path);
        }
        for (;;)
        {
          igS();
          if (this.tipDialog != null) {
            this.tipDialog.dismiss();
          }
          AppMethodBeat.o(69768);
          return;
          this.screen.eh("wallet_open_auto_pay", true);
        }
      }
      if ((paramp instanceof ak))
      {
        this.VrC = ((ak)paramp).Vyo;
        this.VrJ = ((ak)paramp).Vyu;
        if (this.VrJ == 0)
        {
          this.screen.eh("wallet_delay_transfer_date", true);
          AppMethodBeat.o(69768);
          return;
        }
        if (!Util.isNullOrNil(this.VrC)) {
          this.Vrz.setTitle(this.VrC);
        }
        for (;;)
        {
          this.screen.eh("wallet_delay_transfer_date", false);
          AppMethodBeat.o(69768);
          return;
          Log.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        this.Vrr = ((com.tencent.mm.plugin.wallet.pwd.a.f)paramp).igv();
        HD(true);
        Log.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", new Object[] { this.Vrr.igw() });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZe, this.Vrr.igw());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.h)paramp;
        if (paramString.Vpl == null)
        {
          paramString.Vpl = new h.a();
          paramString.Vpl.wuz = paramString.Vpk.wuz;
          paramString.Vpl.wuA = paramString.Vpk.wuA;
          paramString.Vpl.wtT = paramString.Vpk.wtT;
          paramString.Vpl.Vpm = paramString.Vpk.Vpm;
          paramString.Vpl.Vpa = paramString.Vpk.Vpa;
          paramString.Vpl.wording = paramString.Vpk.wording;
          paramString.Vpl.Vpn = paramString.Vpk.Vpn;
          if (paramString.Vpk.abPD != null)
          {
            paramString.Vpl.Vpo = paramString.Vpk.abPD.wording;
            paramString.Vpl.Vpp = paramString.Vpk.abPD.title;
            paramString.Vpl.Vpq = paramString.Vpk.abPD.link;
          }
        }
        this.VrG = paramString.Vpl;
        HE(true);
        Log.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", new Object[] { this.VrG.igw() });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZs, this.VrG.igw());
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof g))
      {
        if ((this.Vrw != null) && (this.Vrw.isShowing())) {
          this.Vrw.dismiss();
        }
        paramp = (g)paramp;
        if (paramp.Vpj == null)
        {
          paramp = new fpj();
          if (paramp == null)
          {
            if (!Util.isNullOrNil(paramString)) {
              break label1003;
            }
            paramString = getString(a.i.wallet_data_err);
            label784:
            k.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          }
          paramInt1 = paramp.wuz;
          paramString = paramp.wuA;
          if (paramp.Zgn != null) {
            break label1006;
          }
          bool1 = true;
          label830:
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool1), Integer.valueOf(paramp.abPm), paramp.wording });
          paramInt1 = paramp.abPm;
          paramString = paramp.wording;
          if (!Util.isNullOrNil(paramString)) {
            break label1012;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
          label907:
          if (paramp.wuz != 0) {
            break label1147;
          }
          if (paramp.abPn == null) {
            break label1083;
          }
          Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
          com.tencent.mm.wallet_core.model.l.a(getContext(), paramp.abPn, null, new com.tencent.mm.wallet_core.model.l.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(315604);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
              WalletPasswordSettingUI.this.finish();
              AppMethodBeat.o(315604);
            }
            
            public final void gLQ()
            {
              AppMethodBeat.i(315602);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
              AppMethodBeat.o(315602);
            }
            
            public final int gLR()
            {
              return 1149;
            }
            
            public final void gLS()
            {
              AppMethodBeat.i(315608);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
              AppMethodBeat.o(315608);
            }
            
            public final void gLT()
            {
              AppMethodBeat.i(315610);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
              AppMethodBeat.o(315610);
            }
            
            public final void go(Object paramAnonymousObject)
            {
              AppMethodBeat.i(315605);
              Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
              AppMethodBeat.o(315605);
            }
          });
          paramString = this.Vrv;
          if (this.Vrv.isChecked()) {
            break label1077;
          }
        }
        label1077:
        for (bool1 = bool2;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          paramp = paramp.Vpj;
          break;
          label1003:
          break label784;
          label1006:
          bool1 = false;
          break label830;
          label1012:
          this.VrL = paramInt1;
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZt, Integer.valueOf(paramInt1));
          this.VrG.wording = paramString;
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZs, this.VrG.igw());
          bgr(paramString);
          this.screen.notifyDataSetChanged();
          break label907;
        }
        label1083:
        if (this.Vrv.isChecked())
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZr, Integer.valueOf(1));
          AppMethodBeat.o(69768);
          return;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZr, Integer.valueOf(0));
        AppMethodBeat.o(69768);
        return;
        label1147:
        if (paramp.wuz == 416) {
          if (paramp.Zgn != null)
          {
            paramString = new Bundle();
            paramString.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
            paramString.putString("realname_verify_process_jump_plugin", "wallet");
            paramInt1 = paramp.wuz;
            paramp = paramp.Zgn;
            new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(315600);
                Log.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.o(315600);
              }
            };
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt1, paramp, paramString, 1012);
            paramString = this.Vrv;
            if (this.Vrv.isChecked()) {
              break label1425;
            }
          }
        }
        label1425:
        for (bool1 = bool3;; bool1 = false)
        {
          paramString.setChecked(bool1);
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(69768);
          return;
          if (Util.isNullOrNil(paramp.wuA)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramp.wuA)
          {
            k.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            break;
          }
          if (paramp.abPn != null)
          {
            Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
            com.tencent.mm.wallet_core.model.l.a(getContext(), paramp.abPn, null, new com.tencent.mm.wallet_core.model.l.a()
            {
              public final void dJE()
              {
                AppMethodBeat.i(315665);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(315665);
              }
              
              public final void gLQ()
              {
                AppMethodBeat.i(315663);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                AppMethodBeat.o(315663);
              }
              
              public final int gLR()
              {
                return 1149;
              }
              
              public final void gLS()
              {
                AppMethodBeat.i(315672);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                AppMethodBeat.o(315672);
              }
              
              public final void gLT()
              {
                AppMethodBeat.i(315673);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                AppMethodBeat.o(315673);
              }
              
              public final void go(Object paramAnonymousObject)
              {
                AppMethodBeat.i(315666);
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                AppMethodBeat.o(315666);
              }
            });
            break;
          }
          if (paramp.wuz == 0) {
            break;
          }
          if (Util.isNullOrNil(paramp.wuA)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramp.wuA)
          {
            k.a(this, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            break;
          }
        }
      }
    }
    else
    {
      if ((paramp instanceof ak))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pwd.a.f))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
        AppMethodBeat.o(69768);
        return;
      }
      if ((paramp instanceof g))
      {
        Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
        if ((this.Vrw != null) && (this.Vrw.isShowing())) {
          this.Vrw.dismiss();
        }
        AppCompatActivity localAppCompatActivity = getContext();
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.mobile_remit_data_err);
        }
        aa.makeText(localAppCompatActivity, paramp, 0).show();
        paramString = this.Vrv;
        if (this.Vrv.isChecked()) {
          break label1613;
        }
      }
    }
    for (;;)
    {
      paramString.setChecked(bool1);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(69768);
      return;
      label1613:
      bool1 = false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315676);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.c.class);
    AppMethodBeat.o(315676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */