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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
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
  implements com.tencent.mm.ak.g
{
  private boolean Bnh;
  private WalletSecuritySettingHeaderPref Bni;
  private IconPreference Bnj;
  private IconPreference Bnk;
  private IconPreference Bnl;
  private IconPreference Bnm;
  private IconPreference Bnn;
  private Preference Bno;
  private b Bnp;
  private g Bnq;
  private f Bnr;
  private c Bns;
  private a Bnt;
  private ProgressDialog Bnu;
  private int fwc;
  private f screen;
  private Map<String, p.a> wHG;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.Bnh = true;
    this.fwc = 0;
    this.wHG = new HashMap();
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
    o.aFw();
    Bitmap localBitmap = c.te(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!bs.isNullOrNil(paramString))
    {
      paramIconPreference = new p.a()
      {
        public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          AppMethodBeat.i(69796);
          ac.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
          paramIconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), paramAnonymousBitmap);
          WalletSecuritySettingUI.b(WalletSecuritySettingUI.this).remove(paramAnonymousString1);
          AppMethodBeat.o(69796);
        }
      };
      this.wHG.put(paramString, paramIconPreference);
      o.aFA().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void aN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69815);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(2131765825));
      AppMethodBeat.o(69815);
      return;
    }
    try
    {
      this.screen = getPreferenceScreen();
      Object localObject = paramJSONObject.getString("more_security_title");
      this.Bno = this.screen.aPN("wallet_security_more_title");
      this.Bno.setTitle((CharSequence)localObject);
      if (paramJSONObject.has("basic_security_item"))
      {
        localObject = paramJSONObject.getJSONObject("basic_security_item");
        this.Bnp = new b((byte)0);
        this.Bnp.title = ((JSONObject)localObject).optString("title");
        this.Bnp.desc = ((JSONObject)localObject).optString("desc");
        this.Bnp.vkI = ((JSONObject)localObject).optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.Bnq = new g((byte)0);
        this.Bnq.title = ((JSONObject)localObject).optString("wallet_lock_title");
        this.Bnq.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
        this.Bnq.vkI = ((JSONObject)localObject).getString("wallet_lock_logo_url");
        this.Bnq.status = ((JSONObject)localObject).optInt("wallet_lock_status");
        this.Bnq.BnL = ((JSONObject)localObject).optString("wallet_lock_status_name");
        this.Bnq.BnM = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localObject = paramJSONObject.getJSONObject("property_security_info");
        this.Bnr = new f((byte)0);
        this.Bnr.title = ((JSONObject)localObject).optString("title", "");
        this.Bnr.desc = ((JSONObject)localObject).optString("desc", "");
        this.Bnr.vkI = ((JSONObject)localObject).optString("logo_url", "");
        this.Bnr.status = ((JSONObject)localObject).optInt("status", 0);
        this.Bnr.BnJ = ((JSONObject)localObject).optString("status_name");
        this.Bnr.jumpType = ((JSONObject)localObject).optInt("jump_type");
        this.Bnr.Bnz = ((JSONObject)localObject).optString("jump_h5_url");
        this.Bnr.BnK = ((JSONObject)localObject).optString("tinyapp_username");
        this.Bnr.BnA = ((JSONObject)localObject).optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localObject = paramJSONObject.getJSONObject("safe_manager_info");
        this.Bns = new c(this);
        this.Bns.title = ((JSONObject)localObject).optString("title", "");
        this.Bns.desc = ((JSONObject)localObject).optString("desc", "");
        this.Bns.vkI = ((JSONObject)localObject).optString("logo_url", "");
        this.Bns.BnD = ((JSONObject)localObject).optString("installed_status_name");
        this.Bns.BnC = ((JSONObject)localObject).optString("uninstall_status_name");
        this.Bns.BnE = ((JSONObject)localObject).optString("protected_mode_name");
        this.Bns.Bnz = ((JSONObject)localObject).optString("jump_h5_url");
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.Bnt = new a((byte)0);
        this.Bnt.drM = ((JSONObject)localObject).optString("icon", "");
        this.Bnt.title = ((JSONObject)localObject).optString("title", "");
        this.Bnt.desc = ((JSONObject)localObject).optString("desc", "");
        this.Bnt.switchState = ((JSONObject)localObject).optInt("switch_state");
        this.Bnt.Bny = ((JSONObject)localObject).optString("switch_state_info");
      }
      ad.fAs().bB(paramJSONObject);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOQ, paramJSONObject.toString());
      eqw();
      eqy();
      eqz();
      eqA();
      eqB();
      eqx();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(2131765825));
      }
    }
    dismissDialog();
    AppMethodBeat.o(69815);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(69816);
    if ((this.Bnu != null) && (this.Bnu.isShowing())) {
      this.Bnu.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void eqA()
  {
    AppMethodBeat.i(69810);
    this.screen.cK("wallet_security_pay_guard", false);
    this.Bnk = ((IconPreference)this.screen.aPN("wallet_security_pay_guard"));
    if (this.Bnk != null) {
      this.Bnk.setSummary(2131765837);
    }
    if (this.Bns == null)
    {
      this.screen.cK("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    a(this.Bns.vkI, this.Bnk);
    this.Bnk.setTitle(this.Bns.title);
    IconPreference localIconPreference = this.Bnk;
    Object localObject = this.Bns;
    if (((c)localObject).status == 0) {
      localObject = ((c)localObject).BnC;
    }
    for (;;)
    {
      localIconPreference.setSummary((CharSequence)localObject);
      this.Bnk.setDesc(this.Bns.desc);
      this.Bnk.fjl();
      AppMethodBeat.o(69810);
      return;
      if (((c)localObject).status == 1) {
        localObject = ((c)localObject).BnD;
      } else {
        localObject = ((c)localObject).BnE;
      }
    }
  }
  
  private void eqB()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.cK("wallet_security_safety_insurance", false);
    this.Bnm = ((IconPreference)this.screen.aPN("wallet_security_safety_insurance"));
    if (this.Bnm != null) {
      this.Bnm.setSummary(2131765838);
    }
    if (this.Bnr == null)
    {
      this.screen.cK("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.Bnr.vkI, this.Bnm);
    this.Bnm.setTitle(this.Bnr.title);
    this.Bnm.setSummary(this.Bnr.BnJ);
    this.Bnm.setDesc(this.Bnr.desc);
    this.Bnm.fjl();
    AppMethodBeat.o(69811);
  }
  
  private void eqw()
  {
    AppMethodBeat.i(69806);
    this.Bni = ((WalletSecuritySettingHeaderPref)this.screen.aPN("wallet_security_basic_info"));
    if (this.Bnp != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.Bni;
      String str1 = this.Bnp.title;
      String str2 = this.Bnp.desc;
      String str3 = this.Bnp.BnB;
      localWalletSecuritySettingHeaderPref.qBH = str1;
      localWalletSecuritySettingHeaderPref.Bnd = str2;
      localWalletSecuritySettingHeaderPref.Bne = str3;
      localWalletSecuritySettingHeaderPref.cL();
      if (bs.isNullOrNil(this.Bnp.BnB))
      {
        localWalletSecuritySettingHeaderPref = this.Bni;
        if (localWalletSecuritySettingHeaderPref.Bnc != null) {
          localWalletSecuritySettingHeaderPref.Bnc.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void eqx()
  {
    AppMethodBeat.i(69807);
    if (this.Bnt == null)
    {
      this.screen.cK("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.cK("balance_privacy_info", false);
    this.Bnn = ((IconPreference)this.screen.aPN("balance_privacy_info"));
    a(this.Bnt.drM, this.Bnn);
    this.Bnn.setTitle(this.Bnt.title);
    this.Bnn.setSummary(this.Bnt.Bny);
    this.Bnn.setDesc(this.Bnt.desc);
    this.Bnn.fjl();
    AppMethodBeat.o(69807);
  }
  
  private void eqy()
  {
    AppMethodBeat.i(69808);
    if (this.Bnq == null)
    {
      this.screen.cK("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.cK("wallet_security_wallet_lock", false);
    this.Bnl = ((IconPreference)this.screen.aPN("wallet_security_wallet_lock"));
    a(this.Bnq.vkI, this.Bnl);
    this.Bnl.setTitle(this.Bnq.title);
    this.Bnl.setSummary(this.Bnq.BnL);
    this.Bnl.setDesc(this.Bnq.desc);
    this.Bnl.fjl();
    AppMethodBeat.o(69808);
  }
  
  private void eqz()
  {
    AppMethodBeat.i(69809);
    this.screen.cK("wallet_security_digital_certificate", false);
    this.Bnj = ((IconPreference)this.screen.aPN("wallet_security_digital_certificate"));
    ad.fAs();
    com.tencent.mm.kernel.g.agS();
    if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJS, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.cK("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (ad.fAs().fAt()) {
      if (this.Bnj != null) {
        this.Bnj.setSummary(2131765835);
      }
    }
    for (;;)
    {
      a(ad.fAs().JFI, this.Bnj);
      this.Bnj.setTitle(ad.fAs().JFG);
      this.Bnj.setSummary(ad.fAs().JFH);
      this.Bnj.setDesc(ad.fAs().JFF);
      this.Bnj.fjl();
      AppMethodBeat.o(69809);
      return;
      if (this.Bnj != null) {
        this.Bnj.setSummary(2131765837);
      }
    }
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.Bnu != null) && (this.Bnu.isShowing())) {
      this.Bnu.dismiss();
    }
    h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
      this.screen.addPreferencesFromResource(2131951763);
    }
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOQ, "");
    if (!bs.isNullOrNil(str)) {
      try
      {
        aN(new JSONObject(str));
        AppMethodBeat.o(69803);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69803);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69802);
    super.onCreate(paramBundle);
    this.fwc = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new gd();
    paramBundle.dNx = 11L;
    paramBundle.ebp = 1L;
    paramBundle.ebq = this.fwc;
    paramBundle.aHZ();
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
    if (com.tencent.mm.compatible.util.d.kZ(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
      updataStatusBarIcon(aj.DT());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.wHG.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      o.aFA().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
    }
    this.wHG.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new gd();
      paramf.dNx = 12L;
      paramf.ebp = 1L;
      paramf.aHZ();
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.Bns == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      ac.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.Bns.getUrl() });
      com.tencent.mm.wallet_core.ui.e.cp(this, this.Bns.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).c(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.Bnr == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new gd();
      paramf.dNx = 15L;
      paramf.ebp = 1L;
      paramf.aHZ();
      if (this.Bnr.jumpType == 2)
      {
        paramf = new ut();
        paramf.dxt.aBM = 0;
        paramf.dxt.userName = this.Bnr.BnK;
        paramf.dxt.dxv = this.Bnr.BnA;
        com.tencent.mm.sdk.b.a.GpY.l(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.Bnr.Bnz);
        ac.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(e.m.HhK, true);
        com.tencent.mm.wallet_core.ui.e.al(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.Bnt == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.br.d.N(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.Bni = ((WalletSecuritySettingHeaderPref)this.screen.aPN("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.Bni != null)
    {
      localObject1 = this.Bni;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69791);
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (bs.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Bnz)))
          {
            ac.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 1) && (!bs.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Bnz)))
          {
            paramAnonymousView = new Intent();
            ac.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Bnz });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).Bnz);
            paramAnonymousView.putExtra(e.m.HhK, true);
            com.tencent.mm.wallet_core.ui.e.al(WalletSecuritySettingUI.this.getContext(), paramAnonymousView);
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 2)) {
            bs.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).BnA);
          }
          AppMethodBeat.o(69791);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).Bnc != null) {
        break label281;
      }
      bool = true;
      ac.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Bnf = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).Bnc != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).Bnc.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.Bni;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69792);
          ac.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
          WalletSecuritySettingUI.this.finish();
          AppMethodBeat.o(69792);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).gDM != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      ac.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).Bng = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).gDM != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).gDM.setOnClickListener((View.OnClickListener)localObject2);
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
      if (this.Bnh)
      {
        this.Bnu = h.b(this, getString(2131755936), false, null);
        this.Bnh = false;
      }
      bool = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cGZ();
      localObject2 = com.tencent.mm.plugin.soter.d.d.dTq();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).znE;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).znF;
      ac.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.wallet.pwd.a.n(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69813);
    ac.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.n))
    {
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.n)paramn).BkQ;
      ac.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      aN(paramString);
      if ((paramString != null) && (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHL, Boolean.FALSE)).booleanValue()))
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
        localCdnImageView.fE(paramString.vFL, 2131234705);
        localTextView.setText(paramString.dlQ);
        paramn.yg(true);
        paramn.yf(false);
        paramn.gH(localView);
        paramn.aRH(paramString.title);
        if ((paramString.BnI != null) && (!bs.isNullOrNil(paramString.BnI.nWi)))
        {
          paramn.aRO(paramString.BnI.nWi);
          paramn.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.BnI.vjP == 1)
              {
                com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.getContext(), paramString.BnI.BnF, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.BnI.vjP == 2) {
                com.tencent.mm.wallet_core.ui.e.v(paramString.BnI.BnG, paramString.BnI.AZF, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.BnH != null) && (!bs.isNullOrNil(paramString.BnH.nWi)))
        {
          paramn.aRP(paramString.BnH.nWi);
          paramn.c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.BnH.vjP == 1)
              {
                com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.getContext(), paramString.BnH.BnF, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.BnH.vjP == 2)
              {
                com.tencent.mm.wallet_core.ui.e.v(paramString.BnH.BnG, paramString.BnH.AZF, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramn.fvp().show();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHL, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramn.optString("title");
      paramString.dlQ = paramn.optString("wording");
      paramString.vFL = paramn.optString("logo");
      paramString.BnH = d.aO(paramn.optJSONObject("left_btn"));
      paramString.BnI = d.aO(paramn.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String Bny;
    String desc;
    String drM;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class b
  {
    String BnA;
    String BnB;
    String Bnz;
    String desc;
    int jumpType;
    String title;
    String vkI;
    
    private b() {}
  }
  
  final class c
  {
    String BnC;
    String BnD;
    String BnE;
    String Bnz;
    String desc;
    int status;
    String title;
    String vkI;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(69797);
      if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.qqpimsecure"))
      {
        if (bs.bX(paramContext, "com.tencent.server.back.BackEngine"))
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
    
    private String jZ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.Bnz).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = jZ("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = jZ("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = jZ("qqpimsecurestatus", "runing");
      AppMethodBeat.o(69798);
      return str;
    }
  }
  
  static final class d
  {
    String AZF;
    String BnF;
    String BnG;
    String nWi;
    int vjP;
    
    public static d aO(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.nWi = paramJSONObject.optString("button_wording");
      locald.vjP = paramJSONObject.optInt("jump_type");
      locald.BnF = paramJSONObject.optString("jump_h5_url");
      locald.BnG = paramJSONObject.optString("tinyapp_name");
      locald.AZF = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    WalletSecuritySettingUI.d BnH;
    WalletSecuritySettingUI.d BnI;
    String dlQ;
    String title;
    String vFL;
  }
  
  final class f
  {
    String BnA;
    String BnJ;
    String BnK;
    String Bnz;
    String desc;
    int jumpType;
    int status;
    String title;
    String vkI;
    
    private f() {}
  }
  
  final class g
  {
    String BnL;
    boolean BnM;
    String desc;
    int status;
    String title;
    String vkI;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */