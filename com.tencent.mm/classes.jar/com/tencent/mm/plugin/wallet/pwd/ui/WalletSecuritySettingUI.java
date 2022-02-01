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
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private boolean Dfe;
  private WalletSecuritySettingHeaderPref Dff;
  private IconPreference Dfg;
  private IconPreference Dfh;
  private IconPreference Dfi;
  private IconPreference Dfj;
  private IconPreference Dfk;
  private Preference Dfl;
  private b Dfm;
  private g Dfn;
  private f Dfo;
  private c Dfp;
  private a Dfq;
  private ProgressDialog Dfr;
  private int fRv;
  private com.tencent.mm.ui.base.preference.f screen;
  private Map<String, r.a> ylg;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.Dfe = true;
    this.fRv = 0;
    this.ylg = new HashMap();
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
    com.tencent.mm.av.q.aIW();
    Bitmap localBitmap = com.tencent.mm.av.d.wA(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!bu.isNullOrNil(paramString))
    {
      paramIconPreference = new r.a()
      {
        public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          AppMethodBeat.i(69796);
          ae.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
          paramIconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), paramAnonymousBitmap);
          WalletSecuritySettingUI.b(WalletSecuritySettingUI.this).remove(paramAnonymousString1);
          AppMethodBeat.o(69796);
        }
      };
      this.ylg.put(paramString, paramIconPreference);
      com.tencent.mm.av.q.aJa().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69815);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(2131765825));
      AppMethodBeat.o(69815);
      return;
    }
    try
    {
      this.screen = getPreferenceScreen();
      Object localObject = paramJSONObject.getString("more_security_title");
      this.Dfl = this.screen.aXe("wallet_security_more_title");
      this.Dfl.setTitle((CharSequence)localObject);
      if (paramJSONObject.has("basic_security_item"))
      {
        localObject = paramJSONObject.getJSONObject("basic_security_item");
        this.Dfm = new b((byte)0);
        this.Dfm.title = ((JSONObject)localObject).optString("title");
        this.Dfm.desc = ((JSONObject)localObject).optString("desc");
        this.Dfm.wFJ = ((JSONObject)localObject).optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.Dfn = new g((byte)0);
        this.Dfn.title = ((JSONObject)localObject).optString("wallet_lock_title");
        this.Dfn.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
        this.Dfn.wFJ = ((JSONObject)localObject).getString("wallet_lock_logo_url");
        this.Dfn.status = ((JSONObject)localObject).optInt("wallet_lock_status");
        this.Dfn.DfI = ((JSONObject)localObject).optString("wallet_lock_status_name");
        this.Dfn.DfJ = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localObject = paramJSONObject.getJSONObject("property_security_info");
        this.Dfo = new f((byte)0);
        this.Dfo.title = ((JSONObject)localObject).optString("title", "");
        this.Dfo.desc = ((JSONObject)localObject).optString("desc", "");
        this.Dfo.wFJ = ((JSONObject)localObject).optString("logo_url", "");
        this.Dfo.status = ((JSONObject)localObject).optInt("status", 0);
        this.Dfo.DfG = ((JSONObject)localObject).optString("status_name");
        this.Dfo.jumpType = ((JSONObject)localObject).optInt("jump_type");
        this.Dfo.Dfw = ((JSONObject)localObject).optString("jump_h5_url");
        this.Dfo.DfH = ((JSONObject)localObject).optString("tinyapp_username");
        this.Dfo.Dfx = ((JSONObject)localObject).optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localObject = paramJSONObject.getJSONObject("safe_manager_info");
        this.Dfp = new c(this);
        this.Dfp.title = ((JSONObject)localObject).optString("title", "");
        this.Dfp.desc = ((JSONObject)localObject).optString("desc", "");
        this.Dfp.wFJ = ((JSONObject)localObject).optString("logo_url", "");
        this.Dfp.DfA = ((JSONObject)localObject).optString("installed_status_name");
        this.Dfp.Dfz = ((JSONObject)localObject).optString("uninstall_status_name");
        this.Dfp.DfB = ((JSONObject)localObject).optString("protected_mode_name");
        this.Dfp.Dfw = ((JSONObject)localObject).optString("jump_h5_url");
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.Dfq = new a((byte)0);
        this.Dfq.dEM = ((JSONObject)localObject).optString("icon", "");
        this.Dfq.title = ((JSONObject)localObject).optString("title", "");
        this.Dfq.desc = ((JSONObject)localObject).optString("desc", "");
        this.Dfq.switchState = ((JSONObject)localObject).optInt("switch_state");
        this.Dfq.Dfv = ((JSONObject)localObject).optString("switch_state_info");
      }
      ad.fVY().bK(paramJSONObject);
      g.ajS();
      g.ajR().ajA().set(am.a.IVK, paramJSONObject.toString());
      eId();
      eIf();
      eIg();
      eIh();
      eIi();
      eIe();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(2131765825));
      }
    }
    dismissDialog();
    AppMethodBeat.o(69815);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(69816);
    if ((this.Dfr != null) && (this.Dfr.isShowing())) {
      this.Dfr.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void eId()
  {
    AppMethodBeat.i(69806);
    this.Dff = ((WalletSecuritySettingHeaderPref)this.screen.aXe("wallet_security_basic_info"));
    if (this.Dfm != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.Dff;
      String str1 = this.Dfm.title;
      String str2 = this.Dfm.desc;
      String str3 = this.Dfm.Dfy;
      localWalletSecuritySettingHeaderPref.rtC = str1;
      localWalletSecuritySettingHeaderPref.Dfa = str2;
      localWalletSecuritySettingHeaderPref.Dfb = str3;
      localWalletSecuritySettingHeaderPref.updateView();
      if (bu.isNullOrNil(this.Dfm.Dfy))
      {
        localWalletSecuritySettingHeaderPref = this.Dff;
        if (localWalletSecuritySettingHeaderPref.DeZ != null) {
          localWalletSecuritySettingHeaderPref.DeZ.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void eIe()
  {
    AppMethodBeat.i(69807);
    if (this.Dfq == null)
    {
      this.screen.cT("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.cT("balance_privacy_info", false);
    this.Dfk = ((IconPreference)this.screen.aXe("balance_privacy_info"));
    a(this.Dfq.dEM, this.Dfk);
    this.Dfk.setTitle(this.Dfq.title);
    this.Dfk.setSummary(this.Dfq.Dfv);
    this.Dfk.setDesc(this.Dfq.desc);
    this.Dfk.fDC();
    AppMethodBeat.o(69807);
  }
  
  private void eIf()
  {
    AppMethodBeat.i(69808);
    if (this.Dfn == null)
    {
      this.screen.cT("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.cT("wallet_security_wallet_lock", false);
    this.Dfi = ((IconPreference)this.screen.aXe("wallet_security_wallet_lock"));
    a(this.Dfn.wFJ, this.Dfi);
    this.Dfi.setTitle(this.Dfn.title);
    this.Dfi.setSummary(this.Dfn.DfI);
    this.Dfi.setDesc(this.Dfn.desc);
    this.Dfi.fDC();
    AppMethodBeat.o(69808);
  }
  
  private void eIg()
  {
    AppMethodBeat.i(69809);
    this.screen.cT("wallet_security_digital_certificate", false);
    this.Dfg = ((IconPreference)this.screen.aXe("wallet_security_digital_certificate"));
    ad.fVY();
    g.ajS();
    if (((Integer)g.ajR().ajA().get(am.a.IQI, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.cT("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (this.Dfg == null)
    {
      AppMethodBeat.o(69809);
      return;
    }
    if (!ad.fVY().fVZ()) {
      this.Dfg.setSummary(2131765837);
    }
    for (;;)
    {
      a(ad.fVY().LVB, this.Dfg);
      this.Dfg.setTitle(ad.fVY().LVz);
      this.Dfg.setDesc(ad.fVY().LVy);
      this.Dfg.fDC();
      AppMethodBeat.o(69809);
      return;
      if (!bu.isNullOrNil(ad.fVY().LVA)) {
        this.Dfg.setSummary(ad.fVY().LVA);
      } else {
        this.Dfg.setSummary(2131765835);
      }
    }
  }
  
  private void eIh()
  {
    AppMethodBeat.i(69810);
    this.screen.cT("wallet_security_pay_guard", false);
    this.Dfh = ((IconPreference)this.screen.aXe("wallet_security_pay_guard"));
    if (this.Dfh != null) {
      this.Dfh.setSummary(2131765837);
    }
    if (this.Dfp == null)
    {
      this.screen.cT("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    a(this.Dfp.wFJ, this.Dfh);
    this.Dfh.setTitle(this.Dfp.title);
    IconPreference localIconPreference = this.Dfh;
    Object localObject = this.Dfp;
    if (((c)localObject).status == 0) {
      localObject = ((c)localObject).Dfz;
    }
    for (;;)
    {
      localIconPreference.setSummary((CharSequence)localObject);
      this.Dfh.setDesc(this.Dfp.desc);
      this.Dfh.fDC();
      AppMethodBeat.o(69810);
      return;
      if (((c)localObject).status == 1) {
        localObject = ((c)localObject).DfA;
      } else {
        localObject = ((c)localObject).DfB;
      }
    }
  }
  
  private void eIi()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.cT("wallet_security_safety_insurance", false);
    this.Dfj = ((IconPreference)this.screen.aXe("wallet_security_safety_insurance"));
    if (this.Dfj != null) {
      this.Dfj.setSummary(2131765838);
    }
    if (this.Dfo == null)
    {
      this.screen.cT("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.Dfo.wFJ, this.Dfj);
    this.Dfj.setTitle(this.Dfo.title);
    this.Dfj.setSummary(this.Dfo.DfG);
    this.Dfj.setDesc(this.Dfo.desc);
    this.Dfj.fDC();
    AppMethodBeat.o(69811);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.Dfr != null) && (this.Dfr.isShowing())) {
      this.Dfr.dismiss();
    }
    h.a(this, paramString, "", false, new WalletSecuritySettingUI.6(this));
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
      this.screen.addPreferencesFromResource(2131951763);
    }
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IVK, "");
    if (!bu.isNullOrNil(str)) {
      try
      {
        aV(new JSONObject(str));
        AppMethodBeat.o(69803);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69803);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69802);
    super.onCreate(paramBundle);
    this.fRv = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new hi();
    paramBundle.eeh = 11L;
    paramBundle.etC = 1L;
    paramBundle.etD = this.fRv;
    paramBundle.aLH();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.lA(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
      updataStatusBarIcon(al.isDarkMode());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.ylg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      com.tencent.mm.av.q.aJa().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
    }
    this.ylg.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    g.ajS();
    g.ajQ().gDv.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new hi();
      paramf.eeh = 12L;
      paramf.etC = 1L;
      paramf.aLH();
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.Dfp == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      ae.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.Dfp.getUrl() });
      com.tencent.mm.wallet_core.ui.f.cv(this, this.Dfp.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).e(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.Dfo == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new hi();
      paramf.eeh = 15L;
      paramf.etC = 1L;
      paramf.aLH();
      if (this.Dfo.jumpType == 2)
      {
        paramf = new vq();
        paramf.dKT.aDD = 0;
        paramf.dKT.userName = this.Dfo.DfH;
        paramf.dKT.dKV = this.Dfo.Dfx;
        com.tencent.mm.sdk.b.a.IvT.l(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.Dfo.Dfw);
        ae.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(e.m.JpI, true);
        com.tencent.mm.wallet_core.ui.f.an(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.Dfq == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.br.d.Q(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.Dff = ((WalletSecuritySettingHeaderPref)this.screen.aXe("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.Dff != null)
    {
      localObject1 = this.Dff;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69791);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (bu.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Dfw)))
          {
            ae.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 1) && (!bu.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Dfw)))
          {
            paramAnonymousView = new Intent();
            ae.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Dfw });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Dfw);
            paramAnonymousView.putExtra(e.m.JpI, true);
            com.tencent.mm.wallet_core.ui.f.an(WalletSecuritySettingUI.this.getContext(), paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69791);
            return;
            if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 2)) {
              bu.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Dfx);
            }
          }
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).DeZ != null) {
        break label281;
      }
      bool = true;
      ae.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Dfc = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).DeZ != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).DeZ.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.Dff;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).hai != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      ae.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Dfd = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).hai != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).hai.setOnClickListener((View.OnClickListener)localObject2);
      }
      g.ajS();
      g.ajQ().gDv.a(385, this);
      if (this.Dfe)
      {
        this.Dfr = h.b(this, getString(2131755936), false, null);
        this.Dfe = false;
      }
      bool = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cRT();
      localObject2 = com.tencent.mm.plugin.soter.d.d.ejm();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXb;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXc;
      ae.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      g.ajj().a(new com.tencent.mm.plugin.wallet.pwd.a.n(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69813);
    ae.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.n))
    {
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.n)paramn).DcK;
      ae.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      aV(paramString);
      if ((paramString != null) && (!((Boolean)g.ajR().ajA().get(am.a.IOA, Boolean.FALSE)).booleanValue()))
      {
        paramn = paramString.optJSONObject("dialog_info");
        if (paramn != null) {
          break label352;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramn = new d.a(this);
        View localView = LayoutInflater.from(this).inflate(2131496035, null, false);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131307100);
        TextView localTextView = (TextView)localView.findViewById(2131307101);
        localCdnImageView.gk(paramString.xcF, 2131234705);
        localTextView.setText(paramString.dyI);
        paramn.zg(true);
        paramn.zf(false);
        paramn.hd(localView);
        paramn.aZh(paramString.title);
        if ((paramString.DfF != null) && (!bu.isNullOrNil(paramString.DfF.oGe)))
        {
          paramn.aZo(paramString.DfF.oGe);
          paramn.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.DfF.uIW == 1)
              {
                com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), paramString.DfF.DfC, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.DfF.uIW == 2) {
                com.tencent.mm.wallet_core.ui.f.u(paramString.DfF.DfD, paramString.DfF.CRw, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.DfE != null) && (!bu.isNullOrNil(paramString.DfE.oGe)))
        {
          paramn.aZp(paramString.DfE.oGe);
          paramn.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.DfE.uIW == 1)
              {
                com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), paramString.DfE.DfC, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.DfE.uIW == 2)
              {
                com.tencent.mm.wallet_core.ui.f.u(paramString.DfE.DfD, paramString.DfE.CRw, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramn.fQv().show();
        g.ajR().ajA().set(am.a.IOA, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramn.optString("title");
      paramString.dyI = paramn.optString("wording");
      paramString.xcF = paramn.optString("logo");
      paramString.DfE = d.aW(paramn.optJSONObject("left_btn"));
      paramString.DfF = d.aW(paramn.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String Dfv;
    String dEM;
    String desc;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class b
  {
    String Dfw;
    String Dfx;
    String Dfy;
    String desc;
    int jumpType;
    String title;
    String wFJ;
    
    private b() {}
  }
  
  final class c
  {
    String DfA;
    String DfB;
    String Dfw;
    String Dfz;
    String desc;
    int status;
    String title;
    String wFJ;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(69797);
      if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.qqpimsecure"))
      {
        if (bu.cd(paramContext, "com.tencent.server.back.BackEngine"))
        {
          this.status = 2;
          AppMethodBeat.o(69797);
          return;
        }
        this.status = 1;
        AppMethodBeat.o(69797);
        return;
      }
      this.status = 0;
      AppMethodBeat.o(69797);
    }
    
    private String kA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.Dfw).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = kA("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = kA("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = kA("qqpimsecurestatus", "runing");
      AppMethodBeat.o(69798);
      return str;
    }
  }
  
  static final class d
  {
    String CRw;
    String DfC;
    String DfD;
    String oGe;
    int uIW;
    
    public static d aW(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.oGe = paramJSONObject.optString("button_wording");
      locald.uIW = paramJSONObject.optInt("jump_type");
      locald.DfC = paramJSONObject.optString("jump_h5_url");
      locald.DfD = paramJSONObject.optString("tinyapp_name");
      locald.CRw = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    WalletSecuritySettingUI.d DfE;
    WalletSecuritySettingUI.d DfF;
    String dyI;
    String title;
    String xcF;
  }
  
  final class f
  {
    String DfG;
    String DfH;
    String Dfw;
    String Dfx;
    String desc;
    int jumpType;
    int status;
    String title;
    String wFJ;
    
    private f() {}
  }
  
  final class g
  {
    String DfI;
    boolean DfJ;
    String desc;
    int status;
    String title;
    String wFJ;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */