package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private Map<String, r.a> IiZ;
  private boolean OCT;
  private WalletSecuritySettingHeaderPref OCU;
  private IconPreference OCV;
  private IconPreference OCW;
  private IconPreference OCX;
  private IconPreference OCY;
  private IconPreference OCZ;
  private b ODa;
  private g ODb;
  private f ODc;
  private c ODd;
  private a ODe;
  private ProgressDialog ODf;
  private int jaR;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.OCT = true;
    this.jaR = 0;
    this.IiZ = new HashMap();
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
    com.tencent.mm.ay.q.bmg();
    Bitmap localBitmap = com.tencent.mm.ay.d.LI(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      paramIconPreference = new r.a()
      {
        public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          AppMethodBeat.i(69796);
          Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
          paramIconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), paramAnonymousBitmap);
          WalletSecuritySettingUI.e(WalletSecuritySettingUI.this).remove(paramAnonymousString1);
          AppMethodBeat.o(69796);
        }
      };
      this.IiZ.put(paramString, paramIconPreference);
      com.tencent.mm.ay.q.bmk().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void bG(JSONObject paramJSONObject)
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
        this.ODa = new b((byte)0);
        this.ODa.title = localJSONObject.optString("title");
        this.ODa.desc = localJSONObject.optString("desc");
        this.ODa.GtW = localJSONObject.optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.ODb = new g((byte)0);
        this.ODb.title = localJSONObject.optString("wallet_lock_title");
        this.ODb.desc = localJSONObject.optString("wallet_lock_desc");
        this.ODb.GtW = localJSONObject.getString("wallet_lock_logo_url");
        this.ODb.status = localJSONObject.optInt("wallet_lock_status");
        this.ODb.ODz = localJSONObject.optString("wallet_lock_status_name");
        this.ODb.ODA = localJSONObject.optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("property_security_info");
        this.ODc = new f((byte)0);
        this.ODc.title = localJSONObject.optString("title", "");
        this.ODc.desc = localJSONObject.optString("desc", "");
        this.ODc.GtW = localJSONObject.optString("logo_url", "");
        this.ODc.status = localJSONObject.optInt("status", 0);
        this.ODc.ODx = localJSONObject.optString("status_name");
        this.ODc.jumpType = localJSONObject.optInt("jump_type");
        this.ODc.ODk = localJSONObject.optString("jump_h5_url");
        this.ODc.ODy = localJSONObject.optString("tinyapp_username");
        this.ODc.ODl = localJSONObject.optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("safe_manager_info");
        if (this.ODd == null) {
          this.ODd = new c();
        }
        this.ODd.title = localJSONObject.optString("title", "");
        this.ODd.desc = localJSONObject.optString("desc", "");
        this.ODd.GtW = localJSONObject.optString("logo_url", "");
        this.ODd.ODo = localJSONObject.optString("installed_status_name");
        this.ODd.ODn = localJSONObject.optString("uninstall_status_name");
        this.ODd.ODp = localJSONObject.optString("protected_mode_name");
        this.ODd.ODk = localJSONObject.optString("jump_h5_url");
        this.ODd.iN(this);
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.ODe = new a((byte)0);
        this.ODe.icon = localJSONObject.optString("icon", "");
        this.ODe.title = localJSONObject.optString("title", "");
        this.ODe.desc = localJSONObject.optString("desc", "");
        this.ODe.switchState = localJSONObject.optInt("switch_state");
        this.ODe.ODj = localJSONObject.optString("switch_state_info");
      }
      ad.iiX().cv(paramJSONObject);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsn, paramJSONObject.toString());
      gHT();
      gHV();
      gHW();
      gHX();
      gHY();
      gHU();
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
    dismissDialog();
    AppMethodBeat.o(69815);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(69816);
    if ((this.ODf != null) && (this.ODf.isShowing())) {
      this.ODf.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void gHT()
  {
    AppMethodBeat.i(69806);
    this.OCU = ((WalletSecuritySettingHeaderPref)this.screen.byG("wallet_security_basic_info"));
    if (this.ODa != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.OCU;
      String str1 = this.ODa.title;
      String str2 = this.ODa.desc;
      String str3 = this.ODa.ODm;
      localWalletSecuritySettingHeaderPref.wAb = str1;
      localWalletSecuritySettingHeaderPref.OCP = str2;
      localWalletSecuritySettingHeaderPref.OCQ = str3;
      localWalletSecuritySettingHeaderPref.updateView();
      if (Util.isNullOrNil(this.ODa.ODm))
      {
        localWalletSecuritySettingHeaderPref = this.OCU;
        if (localWalletSecuritySettingHeaderPref.OCO != null) {
          localWalletSecuritySettingHeaderPref.OCO.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void gHU()
  {
    AppMethodBeat.i(69807);
    if (this.ODe == null)
    {
      this.screen.dz("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.dz("balance_privacy_info", false);
    this.OCZ = ((IconPreference)this.screen.byG("balance_privacy_info"));
    a(this.ODe.icon, this.OCZ);
    this.OCZ.setTitle(this.ODe.title);
    this.OCZ.aF(this.ODe.ODj);
    this.OCZ.setDesc(this.ODe.desc);
    this.OCZ.hKI();
    AppMethodBeat.o(69807);
  }
  
  private void gHV()
  {
    AppMethodBeat.i(69808);
    if (this.ODb == null)
    {
      this.screen.dz("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.dz("wallet_security_wallet_lock", false);
    this.OCX = ((IconPreference)this.screen.byG("wallet_security_wallet_lock"));
    a(this.ODb.GtW, this.OCX);
    this.OCX.setTitle(this.ODb.title);
    this.OCX.aF(this.ODb.ODz);
    this.OCX.setDesc(this.ODb.desc);
    this.OCX.hKI();
    AppMethodBeat.o(69808);
  }
  
  private void gHW()
  {
    AppMethodBeat.i(69809);
    this.screen.dz("wallet_security_digital_certificate", false);
    this.OCV = ((IconPreference)this.screen.byG("wallet_security_digital_certificate"));
    ad.iiX();
    com.tencent.mm.kernel.h.aHH();
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmJ, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.dz("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (this.OCV == null)
    {
      AppMethodBeat.o(69809);
      return;
    }
    if (!ad.iiX().iiY()) {
      this.OCV.auI(a.i.wallet_security_status_uninstalled);
    }
    for (;;)
    {
      a(ad.iiX().YVP, this.OCV);
      this.OCV.setTitle(ad.iiX().YVN);
      this.OCV.setDesc(ad.iiX().YVM);
      this.OCV.hKI();
      AppMethodBeat.o(69809);
      return;
      if (!Util.isNullOrNil(ad.iiX().YVO)) {
        this.OCV.aF(ad.iiX().YVO);
      } else {
        this.OCV.auI(a.i.wallet_security_status_installed);
      }
    }
  }
  
  private void gHX()
  {
    AppMethodBeat.i(69810);
    this.OCW = ((IconPreference)this.screen.byG("wallet_security_pay_guard"));
    if (this.ODd == null)
    {
      this.screen.dz("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    this.screen.dz("wallet_security_pay_guard", false);
    a(this.ODd.GtW, this.OCW);
    this.OCW.setTitle(this.ODd.title);
    String str = this.ODd.gHZ();
    if (!Util.isNullOrNil(str)) {
      this.OCW.aF(str);
    }
    this.OCW.setDesc(this.ODd.desc);
    this.OCW.hKI();
    AppMethodBeat.o(69810);
  }
  
  private void gHY()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.dz("wallet_security_safety_insurance", false);
    this.OCY = ((IconPreference)this.screen.byG("wallet_security_safety_insurance"));
    if (this.OCY != null) {
      this.OCY.auI(a.i.wallet_security_status_unopened);
    }
    if (this.ODc == null)
    {
      this.screen.dz("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.ODc.GtW, this.OCY);
    this.OCY.setTitle(this.ODc.title);
    this.OCY.aF(this.ODc.ODx);
    this.OCY.setDesc(this.ODc.desc);
    this.OCY.hKI();
    AppMethodBeat.o(69811);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.ODf != null) && (this.ODf.isShowing())) {
      this.ODf.dismiss();
    }
    com.tencent.mm.ui.base.h.a(this, paramString, "", false, new WalletSecuritySettingUI.6(this));
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
      this.screen.auC(a.m.wallet_security_setting_pref);
    }
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsn, "");
    if (!Util.isNullOrNil(str)) {
      try
      {
        bG(new JSONObject(str));
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
    this.jaR = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new nv();
    paramBundle.gCd = 11L;
    paramBundle.han = 1L;
    paramBundle.hao = this.jaR;
    paramBundle.bpa();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.qV(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
      updataStatusBarIcon(ar.isDarkMode());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.IiZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      com.tencent.mm.ay.q.bmk().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
    }
    this.IiZ.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new nv();
      paramf.gCd = 12L;
      paramf.han = 1L;
      paramf.bpa();
      com.tencent.mm.by.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.ODd == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      Log.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.ODd.getUrl() });
      g.cZ(this, this.ODd.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).n(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.ODc == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new nv();
      paramf.gCd = 15L;
      paramf.han = 1L;
      paramf.bpa();
      if (this.ODc.jumpType == 2)
      {
        paramf = new xw();
        paramf.fWN.appVersion = 0;
        paramf.fWN.userName = this.ODc.ODy;
        paramf.fWN.fWP = this.ODc.ODl;
        EventCenter.instance.publish(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.ODc.ODk);
        Log.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(f.r.VSX, true);
        g.aJ(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.ODe == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.by.c.ad(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.OCU = ((WalletSecuritySettingHeaderPref)this.screen.byG("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.OCU != null)
    {
      localObject1 = this.OCU;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69791);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).ODk)))
          {
            Log.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).jumpType == 1) && (!Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).ODk)))
          {
            paramAnonymousView = new Intent();
            Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).ODk });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).ODk);
            paramAnonymousView.putExtra(f.r.VSX, true);
            g.aJ(WalletSecuritySettingUI.this.getContext(), paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69791);
            return;
            if ((WalletSecuritySettingUI.d(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).jumpType == 2)) {
              Util.isNullOrNil(WalletSecuritySettingUI.d(WalletSecuritySettingUI.this).ODl);
            }
          }
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).OCO != null) {
        break label281;
      }
      bool = true;
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).OCR = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).OCO != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).OCO.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.OCU;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).kHA != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).OCS = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).kHA != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).kHA.setOnClickListener((View.OnClickListener)localObject2);
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
      if (this.OCT)
      {
        this.ODf = com.tencent.mm.ui.base.h.a(this, getString(a.i.app_waiting), false, null);
        this.OCT = false;
      }
      bool = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).eon();
      localObject2 = com.tencent.mm.plugin.soter.d.d.gai();
      localObject1 = ((e)localObject2).Lwz;
      localObject2 = ((e)localObject2).ktM;
      Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.kernel.h.aGY().a(new n(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(69813);
    Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof n))
    {
      paramString = ((n)paramq).OAq;
      Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      bG(paramString);
      if ((paramString != null) && (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VkC, Boolean.FALSE)).booleanValue()))
      {
        paramq = paramString.optJSONObject("dialog_info");
        if (paramq != null) {
          break label352;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramq = new d.a(this);
        View localView = LayoutInflater.from(this).inflate(a.g.wallet_switch_wallet_dialog, null, false);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(a.f.wswd_iv);
        TextView localTextView = (TextView)localView.findViewById(a.f.wswd_tv);
        localCdnImageView.hr(paramString.GUf, a.e.wallet_security_dialog_logo);
        localTextView.setText(paramString.wording);
        paramq.HH(true);
        paramq.HG(false);
        paramq.iI(localView);
        paramq.bBc(paramString.title);
        if ((paramString.ODw != null) && (!Util.isNullOrNil(paramString.ODw.tpM)))
        {
          paramq.bBj(paramString.ODw.tpM);
          paramq.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.ODw.jump_type == 1)
              {
                g.o(WalletSecuritySettingUI.this.getContext(), paramString.ODw.ODt, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.ODw.jump_type == 2) {
                g.v(paramString.ODw.ODu, paramString.ODw.Oof, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.ODv != null) && (!Util.isNullOrNil(paramString.ODv.tpM)))
        {
          paramq.bBk(paramString.ODv.tpM);
          paramq.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.ODv.jump_type == 1)
              {
                g.o(WalletSecuritySettingUI.this.getContext(), paramString.ODv.ODt, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.ODv.jump_type == 2)
              {
                g.v(paramString.ODv.ODu, paramString.ODv.Oof, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramq.icu().show();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VkC, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramq.optString("title");
      paramString.wording = paramq.optString("wording");
      paramString.GUf = paramq.optString("logo");
      paramString.ODv = d.bH(paramq.optJSONObject("left_btn"));
      paramString.ODw = d.bH(paramq.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String ODj;
    String desc;
    String icon;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class b
  {
    String GtW;
    String ODk;
    String ODl;
    String ODm;
    String desc;
    int jumpType;
    String title;
    
    private b() {}
  }
  
  final class c
  {
    String GtW;
    String ODk;
    String ODn;
    String ODo;
    String ODp;
    String desc;
    int status;
    String title;
    
    c() {}
    
    private String lQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.ODk).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String gHZ()
    {
      AppMethodBeat.i(269043);
      Log.d("MicroMsg.WalletSecuritySettingUI", "check status2: %s, %s", new Object[] { Integer.valueOf(this.status), Integer.valueOf(hashCode()) });
      if (this.status == 0)
      {
        str = this.ODn;
        AppMethodBeat.o(269043);
        return str;
      }
      if (this.status == 1)
      {
        str = this.ODo;
        AppMethodBeat.o(269043);
        return str;
      }
      if (this.status == 3)
      {
        AppMethodBeat.o(269043);
        return null;
      }
      String str = this.ODp;
      AppMethodBeat.o(269043);
      return str;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = lQ("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 2)
      {
        str = lQ("qqpimsecurestatus", "runing");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = lQ("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = lQ("qqpimsecurestatus", "not_run");
      AppMethodBeat.o(69798);
      return str;
    }
    
    public final void iN(Context paramContext)
    {
      AppMethodBeat.i(269044);
      if (com.tencent.mm.pluginsdk.model.app.q.u(paramContext, "com.tencent.qqpimsecure"))
      {
        this.status = 3;
        com.tencent.e.h.ZvG.e(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186487);
            final boolean bool = u.gHv();
            WalletSecuritySettingUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(248977);
                WalletSecuritySettingUI.c localc = WalletSecuritySettingUI.c.this;
                boolean bool = bool;
                if (WalletSecuritySettingUI.a(localc.ODg) != null) {
                  if (!bool) {
                    break label115;
                  }
                }
                label115:
                for (localc.status = 2;; localc.status = 1)
                {
                  Log.d("MicroMsg.WalletSecuritySettingUI", "check status: %s %s", new Object[] { Integer.valueOf(localc.status), Integer.valueOf(localc.hashCode()) });
                  String str = WalletSecuritySettingUI.a(localc.ODg).gHZ();
                  if (!Util.isNullOrNil(str)) {
                    WalletSecuritySettingUI.b(localc.ODg).aF(str);
                  }
                  WalletSecuritySettingUI.c(localc.ODg).notifyDataSetChanged();
                  AppMethodBeat.o(248977);
                  return;
                }
              }
            });
            AppMethodBeat.o(186487);
          }
        }, "check_qq_security_status");
        AppMethodBeat.o(269044);
        return;
      }
      this.status = 0;
      AppMethodBeat.o(269044);
    }
  }
  
  static final class d
  {
    String ODt;
    String ODu;
    String Oof;
    int jump_type;
    String tpM;
    
    public static d bH(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.tpM = paramJSONObject.optString("button_wording");
      locald.jump_type = paramJSONObject.optInt("jump_type");
      locald.ODt = paramJSONObject.optString("jump_h5_url");
      locald.ODu = paramJSONObject.optString("tinyapp_name");
      locald.Oof = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    String GUf;
    WalletSecuritySettingUI.d ODv;
    WalletSecuritySettingUI.d ODw;
    String title;
    String wording;
  }
  
  final class f
  {
    String GtW;
    String ODk;
    String ODl;
    String ODx;
    String ODy;
    String desc;
    int jumpType;
    int status;
    String title;
    
    private f() {}
  }
  
  final class g
  {
    String GtW;
    boolean ODA;
    String ODz;
    String desc;
    int status;
    String title;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */