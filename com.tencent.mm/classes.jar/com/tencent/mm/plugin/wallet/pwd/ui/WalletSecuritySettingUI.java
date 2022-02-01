package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet.pwd.a.t;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.model.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private Map<String, s.a> OfK;
  private boolean Vsh;
  private WalletSecuritySettingHeaderPref Vsi;
  private IconPreference Vsj;
  private IconPreference Vsk;
  private IconPreference Vsl;
  private IconPreference Vsm;
  private IconPreference Vsn;
  private b Vso;
  private g Vsp;
  private f Vsq;
  private c Vsr;
  private a Vss;
  private ProgressDialog Vst;
  private int lCR;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.Vsh = true;
    this.lCR = 0;
    this.OfK = new HashMap();
    AppMethodBeat.o(69801);
  }
  
  private void a(String paramString, final IconPreference paramIconPreference)
  {
    AppMethodBeat.i(69817);
    if (paramIconPreference == null)
    {
      AppMethodBeat.o(69817);
      return;
    }
    r.bJZ();
    Bitmap localBitmap = com.tencent.mm.modelimage.e.Eo(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      paramIconPreference = new s.a()
      {
        public final void onLoadImageEnd(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          AppMethodBeat.i(69796);
          Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
          paramIconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), paramAnonymousBitmap);
          WalletSecuritySettingUI.e(WalletSecuritySettingUI.this).remove(paramAnonymousString1);
          AppMethodBeat.o(69796);
        }
      };
      this.OfK.put(paramString, paramIconPreference);
      r.bKd().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(69816);
    if ((this.Vst != null) && (this.Vst.isShowing())) {
      this.Vst.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void cb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69815);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(a.i.wallet_security_info_get_error));
      AppMethodBeat.o(69815);
      return;
    }
    try
    {
      this.screen = getPreferenceScreen();
      JSONObject localJSONObject;
      if (paramJSONObject.has("basic_security_item"))
      {
        localJSONObject = paramJSONObject.getJSONObject("basic_security_item");
        this.Vso = new b((byte)0);
        this.Vso.title = localJSONObject.optString("title");
        this.Vso.desc = localJSONObject.optString("desc");
        this.Vso.MpW = localJSONObject.optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.Vsp = new g((byte)0);
        this.Vsp.title = localJSONObject.optString("wallet_lock_title");
        this.Vsp.desc = localJSONObject.optString("wallet_lock_desc");
        this.Vsp.MpW = localJSONObject.getString("wallet_lock_logo_url");
        this.Vsp.status = localJSONObject.optInt("wallet_lock_status");
        this.Vsp.VsN = localJSONObject.optString("wallet_lock_status_name");
        this.Vsp.VsO = localJSONObject.optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("property_security_info");
        this.Vsq = new f((byte)0);
        this.Vsq.title = localJSONObject.optString("title", "");
        this.Vsq.desc = localJSONObject.optString("desc", "");
        this.Vsq.MpW = localJSONObject.optString("logo_url", "");
        this.Vsq.status = localJSONObject.optInt("status", 0);
        this.Vsq.VsL = localJSONObject.optString("status_name");
        this.Vsq.jumpType = localJSONObject.optInt("jump_type");
        this.Vsq.Vsy = localJSONObject.optString("jump_h5_url");
        this.Vsq.VsM = localJSONObject.optString("tinyapp_username");
        this.Vsq.Vsz = localJSONObject.optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("safe_manager_info");
        if (this.Vsr == null) {
          this.Vsr = new c();
        }
        this.Vsr.title = localJSONObject.optString("title", "");
        this.Vsr.desc = localJSONObject.optString("desc", "");
        this.Vsr.MpW = localJSONObject.optString("logo_url", "");
        this.Vsr.VsC = localJSONObject.optString("installed_status_name");
        this.Vsr.VsB = localJSONObject.optString("uninstall_status_name");
        this.Vsr.VsD = localJSONObject.optString("protected_mode_name");
        this.Vsr.Vsy = localJSONObject.optString("jump_h5_url");
        this.Vsr.kE(this);
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.Vss = new a((byte)0);
        this.Vss.icon = localJSONObject.optString("icon", "");
        this.Vss.title = localJSONObject.optString("title", "");
        this.Vss.desc = localJSONObject.optString("desc", "");
        this.Vss.switchState = localJSONObject.optInt("switch_state");
        this.Vss.Vsx = localJSONObject.optString("switch_state_info");
      }
      ae.jOT().cQ(paramJSONObject);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTS, paramJSONObject.toString());
      igY();
      iha();
      ihb();
      ihc();
      ihd();
      igZ();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(a.i.wallet_security_info_get_error));
      }
    }
    aDM();
    AppMethodBeat.o(69815);
  }
  
  private void igY()
  {
    AppMethodBeat.i(69806);
    this.Vsi = ((WalletSecuritySettingHeaderPref)this.screen.bAi("wallet_security_basic_info"));
    if (this.Vso != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.Vsi;
      String str1 = this.Vso.title;
      String str2 = this.Vso.desc;
      String str3 = this.Vso.VsA;
      localWalletSecuritySettingHeaderPref.zWm = str1;
      localWalletSecuritySettingHeaderPref.Vsd = str2;
      localWalletSecuritySettingHeaderPref.Vse = str3;
      localWalletSecuritySettingHeaderPref.updateView();
      if (Util.isNullOrNil(this.Vso.VsA))
      {
        localWalletSecuritySettingHeaderPref = this.Vsi;
        if (localWalletSecuritySettingHeaderPref.Vsc != null) {
          localWalletSecuritySettingHeaderPref.Vsc.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void igZ()
  {
    AppMethodBeat.i(69807);
    if (this.Vss == null)
    {
      this.screen.eh("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.eh("balance_privacy_info", false);
    this.Vsn = ((IconPreference)this.screen.bAi("balance_privacy_info"));
    a(this.Vss.icon, this.Vsn);
    this.Vsn.setTitle(this.Vss.title);
    this.Vsn.aS(this.Vss.Vsx);
    this.Vsn.setDesc(this.Vss.desc);
    this.Vsn.jnl();
    AppMethodBeat.o(69807);
  }
  
  private void iha()
  {
    AppMethodBeat.i(69808);
    if (this.Vsp == null)
    {
      this.screen.eh("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.eh("wallet_security_wallet_lock", false);
    this.Vsl = ((IconPreference)this.screen.bAi("wallet_security_wallet_lock"));
    a(this.Vsp.MpW, this.Vsl);
    this.Vsl.setTitle(this.Vsp.title);
    this.Vsl.aS(this.Vsp.VsN);
    this.Vsl.setDesc(this.Vsp.desc);
    this.Vsl.jnl();
    AppMethodBeat.o(69808);
  }
  
  private void ihb()
  {
    AppMethodBeat.i(69809);
    this.screen.eh("wallet_security_digital_certificate", false);
    this.Vsj = ((IconPreference)this.screen.bAi("wallet_security_digital_certificate"));
    ae.jOT();
    com.tencent.mm.kernel.h.baF();
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOe, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.eh("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (this.Vsj == null)
    {
      AppMethodBeat.o(69809);
      return;
    }
    if (!ae.jOT().jOU()) {
      this.Vsj.aBk(a.i.wallet_security_status_uninstalled);
    }
    for (;;)
    {
      a(ae.jOT().agTJ, this.Vsj);
      this.Vsj.setTitle(ae.jOT().agTH);
      this.Vsj.setDesc(ae.jOT().agTG);
      this.Vsj.jnl();
      AppMethodBeat.o(69809);
      return;
      if (!Util.isNullOrNil(ae.jOT().agTI)) {
        this.Vsj.aS(ae.jOT().agTI);
      } else {
        this.Vsj.aBk(a.i.wallet_security_status_installed);
      }
    }
  }
  
  private void ihc()
  {
    AppMethodBeat.i(69810);
    this.Vsk = ((IconPreference)this.screen.bAi("wallet_security_pay_guard"));
    if (this.Vsr == null)
    {
      this.screen.eh("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    this.screen.eh("wallet_security_pay_guard", false);
    a(this.Vsr.MpW, this.Vsk);
    this.Vsk.setTitle(this.Vsr.title);
    String str = this.Vsr.ihe();
    if (!Util.isNullOrNil(str)) {
      this.Vsk.aS(str);
    }
    this.Vsk.setDesc(this.Vsr.desc);
    this.Vsk.jnl();
    AppMethodBeat.o(69810);
  }
  
  private void ihd()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.eh("wallet_security_safety_insurance", false);
    this.Vsm = ((IconPreference)this.screen.bAi("wallet_security_safety_insurance"));
    if (this.Vsm != null) {
      this.Vsm.aBk(a.i.wallet_security_status_unopened);
    }
    if (this.Vsq == null)
    {
      this.screen.eh("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.Vsq.MpW, this.Vsm);
    this.Vsm.setTitle(this.Vsq.title);
    this.Vsm.aS(this.Vsq.VsL);
    this.Vsm.setDesc(this.Vsq.desc);
    this.Vsm.jnl();
    AppMethodBeat.o(69811);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.Vst != null) && (this.Vst.isShowing())) {
      this.Vst.dismiss();
    }
    com.tencent.mm.ui.base.k.a(this, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69795);
        WalletSecuritySettingUI.this.finish();
        AppMethodBeat.o(69795);
      }
    });
    AppMethodBeat.o(69814);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69803);
    super.initView();
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.aBe(a.m.wallet_security_setting_pref);
    }
    com.tencent.mm.kernel.h.baF();
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTS, "");
    if (!Util.isNullOrNil(str)) {
      try
      {
        cb(new JSONObject(str));
        AppMethodBeat.o(69803);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69803);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69802);
    super.onCreate(paramBundle);
    this.lCR = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new rn();
    paramBundle.iPe = 11L;
    paramBundle.jvX = 1L;
    paramBundle.jvY = this.lCR;
    paramBundle.bMH();
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69790);
        WalletSecuritySettingUI.this.finish();
        AppMethodBeat.o(69790);
        return false;
      }
    });
    if (d.rb(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
      updataStatusBarIcon(aw.isDarkMode());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.OfK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      r.bKd().b((String)localEntry.getKey(), (s.a)localEntry.getValue());
    }
    this.OfK.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new rn();
      paramf.iPe = 12L;
      paramf.jvX = 1L;
      paramf.bMH();
      com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.Vsr == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      Log.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.Vsr.getUrl() });
      com.tencent.mm.wallet_core.ui.i.di(this, this.Vsr.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).t(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.Vsq == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new rn();
      paramf.iPe = 15L;
      paramf.jvX = 1L;
      paramf.bMH();
      if (this.Vsq.jumpType == 2)
      {
        paramf = new zp();
        paramf.icM.appVersion = 0;
        paramf.icM.userName = this.Vsq.VsM;
        paramf.icM.icO = this.Vsq.Vsz;
        paramf.publish();
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.Vsq.Vsy);
        Log.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(f.s.adxf, true);
        com.tencent.mm.wallet_core.ui.i.aS(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.Vss == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.br.c.ai(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.Vsi = ((WalletSecuritySettingHeaderPref)this.screen.bAi("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.Vsi != null)
    {
      localObject1 = this.Vsi;
      localObject2 = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(315609);
          if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).Vsy)))
          {
            Log.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            AppMethodBeat.o(315609);
            return;
          }
          if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).jumpType == 1) && (!Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).Vsy)))
          {
            paramAnonymousView = new Intent();
            Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).Vsy });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).Vsy);
            paramAnonymousView.putExtra(f.s.adxf, true);
            com.tencent.mm.wallet_core.ui.i.aS(WalletSecuritySettingUI.this.getContext(), paramAnonymousView);
            AppMethodBeat.o(315609);
            return;
          }
          if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).jumpType == 2)) {
            Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).Vsz);
          }
          AppMethodBeat.o(315609);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).Vsc != null) {
        break label281;
      }
      bool = true;
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Vsf = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).Vsc != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).Vsc.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.Vsi;
      localObject2 = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(315603);
          Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
          WalletSecuritySettingUI.this.finish();
          AppMethodBeat.o(315603);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).nkq != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Vsg = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).nkq != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).nkq.setOnClickListener((View.OnClickListener)localObject2);
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(385, this);
      if (this.Vsh)
      {
        this.Vst = com.tencent.mm.ui.base.k.a(this, getString(a.i.app_waiting), false, null);
        this.Vsh = false;
      }
      bool = ((a)com.tencent.mm.kernel.h.ax(a.class)).ftq();
      localObject2 = com.tencent.mm.plugin.soter.model.b.htz();
      localObject1 = ((com.tencent.mm.plugin.soter.model.c)localObject2).RZY;
      localObject2 = ((com.tencent.mm.plugin.soter.model.c)localObject2).mXG;
      Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.kernel.h.aZW().a(new m(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(69813);
    Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof m))
    {
      paramString = ((m)paramp).VpD;
      Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      cb(paramString);
      if ((paramString != null) && (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acLW, Boolean.FALSE)).booleanValue()))
      {
        paramp = paramString.optJSONObject("dialog_info");
        if (paramp != null) {
          break label352;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramp = new e.a(this);
        View localView = LayoutInflater.from(this).inflate(a.g.wallet_switch_wallet_dialog, null, false);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(a.f.wswd_iv);
        TextView localTextView = (TextView)localView.findViewById(a.f.wswd_tv);
        localCdnImageView.iz(paramString.MRI, a.e.wallet_security_dialog_logo);
        localTextView.setText(paramString.wording);
        paramp.ND(true);
        paramp.NC(false);
        paramp.md(localView);
        paramp.bDv(paramString.title);
        if ((paramString.VsK != null) && (!Util.isNullOrNil(paramString.VsK.wul)))
        {
          paramp.bDC(paramString.VsK.wul);
          paramp.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.VsK.jump_type == 1)
              {
                com.tencent.mm.wallet_core.ui.i.o(WalletSecuritySettingUI.this.getContext(), paramString.VsK.VsH, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.VsK.jump_type == 2) {
                com.tencent.mm.wallet_core.ui.i.y(paramString.VsK.VsI, paramString.VsK.VcV, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.VsJ != null) && (!Util.isNullOrNil(paramString.VsJ.wul)))
        {
          paramp.bDD(paramString.VsJ.wul);
          paramp.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.VsJ.jump_type == 1)
              {
                com.tencent.mm.wallet_core.ui.i.o(WalletSecuritySettingUI.this.getContext(), paramString.VsJ.VsH, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.VsJ.jump_type == 2)
              {
                com.tencent.mm.wallet_core.ui.i.y(paramString.VsJ.VsI, paramString.VsJ.VcV, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramp.jHH().show();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acLW, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramp.optString("title");
      paramString.wording = paramp.optString("wording");
      paramString.MRI = paramp.optString("logo");
      paramString.VsJ = d.cc(paramp.optJSONObject("left_btn"));
      paramString.VsK = d.cc(paramp.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String Vsx;
    String desc;
    String icon;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class b
  {
    String MpW;
    String VsA;
    String Vsy;
    String Vsz;
    String desc;
    int jumpType;
    String title;
    
    private b() {}
  }
  
  final class c
  {
    String MpW;
    String VsB;
    String VsC;
    String VsD;
    String Vsy;
    String desc;
    int status;
    String title;
    
    c() {}
    
    private String nC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.Vsy).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = nC("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 2)
      {
        str = nC("qqpimsecurestatus", "runing");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = nC("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = nC("qqpimsecurestatus", "not_run");
      AppMethodBeat.o(69798);
      return str;
    }
    
    public final String ihe()
    {
      AppMethodBeat.i(315684);
      Log.d("MicroMsg.WalletSecuritySettingUI", "check status2: %s, %s", new Object[] { Integer.valueOf(this.status), Integer.valueOf(hashCode()) });
      if (this.status == 0)
      {
        str = this.VsB;
        AppMethodBeat.o(315684);
        return str;
      }
      if (this.status == 1)
      {
        str = this.VsC;
        AppMethodBeat.o(315684);
        return str;
      }
      if (this.status == 3)
      {
        AppMethodBeat.o(315684);
        return null;
      }
      String str = this.VsD;
      AppMethodBeat.o(315684);
      return str;
    }
    
    public final void kE(Context paramContext)
    {
      AppMethodBeat.i(315688);
      if (u.y(paramContext, "com.tencent.qqpimsecure"))
      {
        this.status = 3;
        com.tencent.threadpool.h.ahAA.h(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(315641);
            final boolean bool = t.igA();
            WalletSecuritySettingUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(315624);
                WalletSecuritySettingUI.c localc = WalletSecuritySettingUI.c.this;
                boolean bool = bool;
                if (WalletSecuritySettingUI.a(localc.Vsu) != null) {
                  if (!bool) {
                    break label115;
                  }
                }
                label115:
                for (localc.status = 2;; localc.status = 1)
                {
                  Log.d("MicroMsg.WalletSecuritySettingUI", "check status: %s %s", new Object[] { Integer.valueOf(localc.status), Integer.valueOf(localc.hashCode()) });
                  String str = WalletSecuritySettingUI.a(localc.Vsu).ihe();
                  if (!Util.isNullOrNil(str)) {
                    WalletSecuritySettingUI.b(localc.Vsu).aS(str);
                  }
                  WalletSecuritySettingUI.c(localc.Vsu).notifyDataSetChanged();
                  AppMethodBeat.o(315624);
                  return;
                }
              }
            });
            AppMethodBeat.o(315641);
          }
        }, "check_qq_security_status");
        AppMethodBeat.o(315688);
        return;
      }
      this.status = 0;
      AppMethodBeat.o(315688);
    }
  }
  
  static final class d
  {
    String VcV;
    String VsH;
    String VsI;
    int jump_type;
    String wul;
    
    public static d cc(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.wul = paramJSONObject.optString("button_wording");
      locald.jump_type = paramJSONObject.optInt("jump_type");
      locald.VsH = paramJSONObject.optString("jump_h5_url");
      locald.VsI = paramJSONObject.optString("tinyapp_name");
      locald.VcV = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    String MRI;
    WalletSecuritySettingUI.d VsJ;
    WalletSecuritySettingUI.d VsK;
    String title;
    String wording;
  }
  
  final class f
  {
    String MpW;
    String VsL;
    String VsM;
    String Vsy;
    String Vsz;
    String desc;
    int jumpType;
    int status;
    String title;
    
    private f() {}
  }
  
  final class g
  {
    String MpW;
    String VsN;
    boolean VsO;
    String desc;
    int status;
    String title;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */