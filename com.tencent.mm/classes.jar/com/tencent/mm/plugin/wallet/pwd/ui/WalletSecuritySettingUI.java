package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p.a;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private int ejF;
  private com.tencent.mm.ui.base.preference.f screen;
  private Map<String, p.a> tYo;
  private boolean ual;
  private WalletSecuritySettingHeaderPref uam;
  private IconPreference uan;
  private IconPreference uao;
  private IconPreference uap;
  private IconPreference uaq;
  private IconPreference uar;
  private Preference uas;
  private b uat;
  private WalletSecuritySettingUI.g uau;
  private WalletSecuritySettingUI.f uav;
  private WalletSecuritySettingUI.c uaw;
  private WalletSecuritySettingUI.a uax;
  private ProgressDialog uay;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(46404);
    this.ual = true;
    this.ejF = 0;
    this.tYo = new HashMap();
    AppMethodBeat.o(46404);
  }
  
  private void a(String paramString, IconPreference paramIconPreference)
  {
    AppMethodBeat.i(46420);
    if (paramIconPreference == null)
    {
      AppMethodBeat.o(46420);
      return;
    }
    o.ahB();
    Bitmap localBitmap = com.tencent.mm.at.c.lK(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(46420);
      return;
    }
    if (!bo.isNullOrNil(paramString))
    {
      paramIconPreference = new WalletSecuritySettingUI.7(this, paramIconPreference);
      this.tYo.put(paramString, paramIconPreference);
      o.ahF().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(46420);
  }
  
  private void as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46418);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(2131305609));
      AppMethodBeat.o(46418);
      return;
    }
    try
    {
      this.screen = getPreferenceScreen();
      Object localObject = paramJSONObject.getString("more_security_title");
      this.uas = this.screen.atx("wallet_security_more_title");
      this.uas.setTitle((CharSequence)localObject);
      if (paramJSONObject.has("basic_security_item"))
      {
        localObject = paramJSONObject.getJSONObject("basic_security_item");
        this.uat = new b((byte)0);
        this.uat.title = ((JSONObject)localObject).optString("title");
        this.uat.desc = ((JSONObject)localObject).optString("desc");
        this.uat.pek = ((JSONObject)localObject).optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.uau = new WalletSecuritySettingUI.g(this, (byte)0);
        this.uau.title = ((JSONObject)localObject).optString("wallet_lock_title");
        this.uau.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
        this.uau.pek = ((JSONObject)localObject).getString("wallet_lock_logo_url");
        this.uau.status = ((JSONObject)localObject).optInt("wallet_lock_status");
        this.uau.uaQ = ((JSONObject)localObject).optString("wallet_lock_status_name");
        this.uau.uaR = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localObject = paramJSONObject.getJSONObject("property_security_info");
        this.uav = new WalletSecuritySettingUI.f(this, (byte)0);
        this.uav.title = ((JSONObject)localObject).optString("title", "");
        this.uav.desc = ((JSONObject)localObject).optString("desc", "");
        this.uav.pek = ((JSONObject)localObject).optString("logo_url", "");
        this.uav.status = ((JSONObject)localObject).optInt("status", 0);
        this.uav.uaO = ((JSONObject)localObject).optString("status_name");
        this.uav.jumpType = ((JSONObject)localObject).optInt("jump_type");
        this.uav.uaD = ((JSONObject)localObject).optString("jump_h5_url");
        this.uav.uaP = ((JSONObject)localObject).optString("tinyapp_username");
        this.uav.uaE = ((JSONObject)localObject).optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localObject = paramJSONObject.getJSONObject("safe_manager_info");
        this.uaw = new WalletSecuritySettingUI.c(this, this);
        this.uaw.title = ((JSONObject)localObject).optString("title", "");
        this.uaw.desc = ((JSONObject)localObject).optString("desc", "");
        this.uaw.pek = ((JSONObject)localObject).optString("logo_url", "");
        this.uaw.uaH = ((JSONObject)localObject).optString("installed_status_name");
        this.uaw.uaG = ((JSONObject)localObject).optString("uninstall_status_name");
        this.uaw.uaI = ((JSONObject)localObject).optString("protected_mode_name");
        this.uaw.uaD = ((JSONObject)localObject).optString("jump_h5_url");
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.uax = new WalletSecuritySettingUI.a(this, (byte)0);
        this.uax.cDz = ((JSONObject)localObject).optString("icon", "");
        this.uax.title = ((JSONObject)localObject).optString("title", "");
        this.uax.desc = ((JSONObject)localObject).optString("desc", "");
        this.uax.switchState = ((JSONObject)localObject).optInt("switch_state");
        this.uax.uaC = ((JSONObject)localObject).optString("switch_state_info");
      }
      com.tencent.mm.wallet_core.c.ab.dSv().aY(paramJSONObject);
      g.RM();
      g.RL().Ru().set(ac.a.yIe, paramJSONObject.toString());
      cSN();
      cSP();
      cSQ();
      cSR();
      cSS();
      cSO();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(2131305609));
      }
    }
    dismissDialog();
    AppMethodBeat.o(46418);
  }
  
  private void cSN()
  {
    AppMethodBeat.i(46409);
    this.uam = ((WalletSecuritySettingHeaderPref)this.screen.atx("wallet_security_basic_info"));
    if (this.uat != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.uam;
      String str1 = this.uat.title;
      String str2 = this.uat.desc;
      String str3 = this.uat.uaF;
      localWalletSecuritySettingHeaderPref.mmp = str1;
      localWalletSecuritySettingHeaderPref.uah = str2;
      localWalletSecuritySettingHeaderPref.uai = str3;
      localWalletSecuritySettingHeaderPref.bJ();
      if (bo.isNullOrNil(this.uat.uaF))
      {
        localWalletSecuritySettingHeaderPref = this.uam;
        if (localWalletSecuritySettingHeaderPref.uag != null) {
          localWalletSecuritySettingHeaderPref.uag.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(46409);
  }
  
  private void cSO()
  {
    AppMethodBeat.i(46410);
    if (this.uax == null)
    {
      this.screen.cl("balance_privacy_info", true);
      AppMethodBeat.o(46410);
      return;
    }
    this.screen.cl("balance_privacy_info", false);
    this.uar = ((IconPreference)this.screen.atx("balance_privacy_info"));
    a(this.uax.cDz, this.uar);
    this.uar.setTitle(this.uax.title);
    this.uar.setSummary(this.uax.uaC);
    this.uar.setDesc(this.uax.desc);
    this.uar.dEJ();
    AppMethodBeat.o(46410);
  }
  
  private void cSP()
  {
    AppMethodBeat.i(46411);
    if (this.uau == null)
    {
      this.screen.cl("wallet_security_wallet_lock", true);
      AppMethodBeat.o(46411);
      return;
    }
    this.screen.cl("wallet_security_wallet_lock", false);
    this.uap = ((IconPreference)this.screen.atx("wallet_security_wallet_lock"));
    a(this.uau.pek, this.uap);
    this.uap.setTitle(this.uau.title);
    this.uap.setSummary(this.uau.uaQ);
    this.uap.setDesc(this.uau.desc);
    this.uap.dEJ();
    AppMethodBeat.o(46411);
  }
  
  private void cSQ()
  {
    AppMethodBeat.i(46412);
    this.screen.cl("wallet_security_digital_certificate", false);
    this.uan = ((IconPreference)this.screen.atx("wallet_security_digital_certificate"));
    com.tencent.mm.wallet_core.c.ab.dSv();
    g.RM();
    if (((Integer)g.RL().Ru().get(ac.a.yDF, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.cl("wallet_security_digital_certificate", true);
      AppMethodBeat.o(46412);
      return;
    }
    if (com.tencent.mm.wallet_core.c.ab.dSv().dSw()) {
      if (this.uan != null) {
        this.uan.setSummary(2131305619);
      }
    }
    for (;;)
    {
      a(com.tencent.mm.wallet_core.c.ab.dSv().AXt, this.uan);
      this.uan.setTitle(com.tencent.mm.wallet_core.c.ab.dSv().AXr);
      this.uan.setSummary(com.tencent.mm.wallet_core.c.ab.dSv().AXs);
      this.uan.setDesc(com.tencent.mm.wallet_core.c.ab.dSv().AXq);
      this.uan.dEJ();
      AppMethodBeat.o(46412);
      return;
      if (this.uan != null) {
        this.uan.setSummary(2131305621);
      }
    }
  }
  
  private void cSR()
  {
    AppMethodBeat.i(46413);
    this.screen.cl("wallet_security_pay_guard", false);
    this.uao = ((IconPreference)this.screen.atx("wallet_security_pay_guard"));
    if (this.uao != null) {
      this.uao.setSummary(2131305621);
    }
    if (this.uaw == null)
    {
      this.screen.cl("wallet_security_pay_guard", true);
      AppMethodBeat.o(46413);
      return;
    }
    a(this.uaw.pek, this.uao);
    this.uao.setTitle(this.uaw.title);
    IconPreference localIconPreference = this.uao;
    Object localObject = this.uaw;
    if (((WalletSecuritySettingUI.c)localObject).status == 0) {
      localObject = ((WalletSecuritySettingUI.c)localObject).uaG;
    }
    for (;;)
    {
      localIconPreference.setSummary((CharSequence)localObject);
      this.uao.setDesc(this.uaw.desc);
      this.uao.dEJ();
      AppMethodBeat.o(46413);
      return;
      if (((WalletSecuritySettingUI.c)localObject).status == 1) {
        localObject = ((WalletSecuritySettingUI.c)localObject).uaH;
      } else {
        localObject = ((WalletSecuritySettingUI.c)localObject).uaI;
      }
    }
  }
  
  private void cSS()
  {
    AppMethodBeat.i(46414);
    this.screen = getPreferenceScreen();
    this.screen.cl("wallet_security_safety_insurance", false);
    this.uaq = ((IconPreference)this.screen.atx("wallet_security_safety_insurance"));
    if (this.uaq != null) {
      this.uaq.setSummary(2131305622);
    }
    if (this.uav == null)
    {
      this.screen.cl("wallet_security_safety_insurance", true);
      AppMethodBeat.o(46414);
      return;
    }
    a(this.uav.pek, this.uaq);
    this.uaq.setTitle(this.uav.title);
    this.uaq.setSummary(this.uav.uaO);
    this.uaq.setDesc(this.uav.desc);
    this.uaq.dEJ();
    AppMethodBeat.o(46414);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(46419);
    if ((this.uay != null) && (this.uay.isShowing())) {
      this.uay.dismiss();
    }
    AppMethodBeat.o(46419);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(46417);
    if ((this.uay != null) && (this.uay.isShowing())) {
      this.uay.dismiss();
    }
    h.a(this, paramString, "", false, new WalletSecuritySettingUI.6(this));
    AppMethodBeat.o(46417);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46406);
    super.initView();
    this.screen = getPreferenceScreen();
    if (this.screen != null) {
      this.screen.addPreferencesFromResource(2131165318);
    }
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yIe, "");
    if (!bo.isNullOrNil(str)) {
      try
      {
        as(new JSONObject(str));
        AppMethodBeat.o(46406);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46406);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46405);
    super.onCreate(paramBundle);
    this.ejF = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new bt();
    paramBundle.cRI = 11L;
    paramBundle.cYT = 1L;
    paramBundle.cYU = this.ejF;
    paramBundle.ake();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.fv(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131690709));
      supportLightStatusBar();
    }
    AppMethodBeat.o(46405);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46421);
    Iterator localIterator = this.tYo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      o.ahF().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
    }
    this.tYo.clear();
    super.onDestroy();
    AppMethodBeat.o(46421);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46408);
    super.onPause();
    g.RM();
    g.RK().eHt.b(385, this);
    AppMethodBeat.o(46408);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(46415);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new bt();
      paramf.cRI = 12L;
      paramf.cYT = 1L;
      paramf.ake();
      com.tencent.mm.bq.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(46415);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.uaw == null)
      {
        AppMethodBeat.o(46415);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.uaw.getUrl() });
      com.tencent.mm.wallet_core.ui.e.bU(this, this.uaw.getUrl());
      AppMethodBeat.o(46415);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, paramf);
      AppMethodBeat.o(46415);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.uav == null)
      {
        AppMethodBeat.o(46415);
        return true;
      }
      paramf = new bt();
      paramf.cRI = 15L;
      paramf.cYT = 1L;
      paramf.ake();
      if (this.uav.jumpType == 2)
      {
        paramf = new so();
        paramf.cIQ.bDc = 0;
        paramf.cIQ.userName = this.uav.uaP;
        paramf.cIQ.cIS = this.uav.uaE;
        a.ymk.l(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(46415);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.uav.uaD);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.uax == null)
      {
        AppMethodBeat.o(46415);
        return true;
      }
      com.tencent.mm.bq.d.H(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(46415);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46407);
    super.onResume();
    this.uam = ((WalletSecuritySettingHeaderPref)this.screen.atx("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.uam != null)
    {
      localObject1 = this.uam;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(46394);
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (bo.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).uaD)))
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            AppMethodBeat.o(46394);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 1) && (!bo.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).uaD)))
          {
            paramAnonymousView = new Intent();
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).uaD });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).uaD);
            com.tencent.mm.bq.d.b(WalletSecuritySettingUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(46394);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 2)) {
            bo.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).uaE);
          }
          AppMethodBeat.o(46394);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).uag != null) {
        break label281;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).uaj = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).uag != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).uag.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.uam;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).pdI != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).uak = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).pdI != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).pdI.setOnClickListener((View.OnClickListener)localObject2);
      }
      g.RM();
      g.RK().eHt.a(385, this);
      if (this.ual)
      {
        this.uay = h.b(this, getString(2131297112), false, null);
        this.ual = false;
      }
      bool = ((com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class)).byS();
      localObject2 = com.tencent.mm.plugin.soter.d.d.cyc();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).son;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).kbP;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      g.Rc().a(new com.tencent.mm.plugin.wallet.pwd.a.l(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(46407);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46416);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.l))
    {
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.l)paramm).tYc;
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      as(paramString);
      if ((paramString != null) && (!((Boolean)g.RL().Ru().get(ac.a.yBA, Boolean.FALSE)).booleanValue()))
      {
        paramm = paramString.optJSONObject("dialog_info");
        if (paramm != null) {
          break label352;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramm = new c.a(this);
        View localView = LayoutInflater.from(this).inflate(2130971258, null, false);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131829409);
        TextView localTextView = (TextView)localView.findViewById(2131829410);
        localCdnImageView.eq(paramString.pvi, 2130840877);
        localTextView.setText(paramString.cyA);
        paramm.rH(true);
        paramm.rG(false);
        paramm.fu(localView);
        paramm.avm(paramString.title);
        if ((paramString.uaN != null) && (!bo.isNullOrNil(paramString.uaN.knU)))
        {
          paramm.avs(paramString.uaN.knU);
          paramm.a(true, new WalletSecuritySettingUI.4(this, paramString));
        }
        if ((paramString.uaM != null) && (!bo.isNullOrNil(paramString.uaM.knU)))
        {
          paramm.avt(paramString.uaM.knU);
          paramm.b(new WalletSecuritySettingUI.5(this, paramString));
        }
        paramm.aLZ().show();
        g.RL().Ru().set(ac.a.yBA, Boolean.TRUE);
      }
      AppMethodBeat.o(46416);
      return;
      label352:
      paramString = new e();
      paramString.title = paramm.optString("title");
      paramString.cyA = paramm.optString("wording");
      paramString.pvi = paramm.optString("logo");
      paramString.uaM = d.at(paramm.optJSONObject("left_btn"));
      paramString.uaN = d.at(paramm.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
  {
    String desc;
    int jumpType;
    String pek;
    String title;
    String uaD;
    String uaE;
    String uaF;
    
    private b() {}
  }
  
  static final class d
  {
    String knU;
    int pdt;
    String uaJ;
    String uaK;
    String uaL;
    
    public static d at(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(46403);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(46403);
        return null;
      }
      d locald = new d();
      locald.knU = paramJSONObject.optString("button_wording");
      locald.pdt = paramJSONObject.optInt("jump_type");
      locald.uaJ = paramJSONObject.optString("jump_h5_url");
      locald.uaK = paramJSONObject.optString("tinyapp_name");
      locald.uaL = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(46403);
      return locald;
    }
  }
  
  static final class e
  {
    String cyA;
    String pvi;
    String title;
    WalletSecuritySettingUI.d uaM;
    WalletSecuritySettingUI.d uaN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */