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
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private int fsv;
  private f screen;
  private Map<String, p.a> vxB;
  private boolean zUN;
  private WalletSecuritySettingHeaderPref zUO;
  private IconPreference zUP;
  private IconPreference zUQ;
  private IconPreference zUR;
  private IconPreference zUS;
  private IconPreference zUT;
  private Preference zUU;
  private b zUV;
  private g zUW;
  private f zUX;
  private c zUY;
  private a zUZ;
  private ProgressDialog zVa;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.zUN = true;
    this.fsv = 0;
    this.vxB = new HashMap();
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
    o.ayE();
    Bitmap localBitmap = c.pT(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!bt.isNullOrNil(paramString))
    {
      paramIconPreference = new p.a()
      {
        public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          AppMethodBeat.i(69796);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
          paramIconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), paramAnonymousBitmap);
          WalletSecuritySettingUI.b(WalletSecuritySettingUI.this).remove(paramAnonymousString1);
          AppMethodBeat.o(69796);
        }
      };
      this.vxB.put(paramString, paramIconPreference);
      o.ayI().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void aM(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69815);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(2131765825));
      AppMethodBeat.o(69815);
      return;
    }
    try
    {
      this.screen = getPreferenceScreen();
      Object localObject = paramJSONObject.getString("more_security_title");
      this.zUU = this.screen.aKk("wallet_security_more_title");
      this.zUU.setTitle((CharSequence)localObject);
      if (paramJSONObject.has("basic_security_item"))
      {
        localObject = paramJSONObject.getJSONObject("basic_security_item");
        this.zUV = new b((byte)0);
        this.zUV.title = ((JSONObject)localObject).optString("title");
        this.zUV.desc = ((JSONObject)localObject).optString("desc");
        this.zUV.dct = ((JSONObject)localObject).optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.zUW = new g((byte)0);
        this.zUW.title = ((JSONObject)localObject).optString("wallet_lock_title");
        this.zUW.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
        this.zUW.dct = ((JSONObject)localObject).getString("wallet_lock_logo_url");
        this.zUW.status = ((JSONObject)localObject).optInt("wallet_lock_status");
        this.zUW.zVr = ((JSONObject)localObject).optString("wallet_lock_status_name");
        this.zUW.zVs = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localObject = paramJSONObject.getJSONObject("property_security_info");
        this.zUX = new f((byte)0);
        this.zUX.title = ((JSONObject)localObject).optString("title", "");
        this.zUX.desc = ((JSONObject)localObject).optString("desc", "");
        this.zUX.dct = ((JSONObject)localObject).optString("logo_url", "");
        this.zUX.status = ((JSONObject)localObject).optInt("status", 0);
        this.zUX.zVp = ((JSONObject)localObject).optString("status_name");
        this.zUX.jumpType = ((JSONObject)localObject).optInt("jump_type");
        this.zUX.zVf = ((JSONObject)localObject).optString("jump_h5_url");
        this.zUX.zVq = ((JSONObject)localObject).optString("tinyapp_username");
        this.zUX.zVg = ((JSONObject)localObject).optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localObject = paramJSONObject.getJSONObject("safe_manager_info");
        this.zUY = new c(this);
        this.zUY.title = ((JSONObject)localObject).optString("title", "");
        this.zUY.desc = ((JSONObject)localObject).optString("desc", "");
        this.zUY.dct = ((JSONObject)localObject).optString("logo_url", "");
        this.zUY.zVj = ((JSONObject)localObject).optString("installed_status_name");
        this.zUY.zVi = ((JSONObject)localObject).optString("uninstall_status_name");
        this.zUY.zVk = ((JSONObject)localObject).optString("protected_mode_name");
        this.zUY.zVf = ((JSONObject)localObject).optString("jump_h5_url");
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.zUZ = new a((byte)0);
        this.zUZ.dub = ((JSONObject)localObject).optString("icon", "");
        this.zUZ.title = ((JSONObject)localObject).optString("title", "");
        this.zUZ.desc = ((JSONObject)localObject).optString("desc", "");
        this.zUZ.switchState = ((JSONObject)localObject).optInt("switch_state");
        this.zUZ.zVe = ((JSONObject)localObject).optString("switch_state_info");
      }
      com.tencent.mm.wallet_core.c.ad.fkc().bA(paramJSONObject);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fra, paramJSONObject.toString());
      eba();
      ebc();
      ebd();
      ebe();
      ebf();
      ebb();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(2131765825));
      }
    }
    dismissDialog();
    AppMethodBeat.o(69815);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(69816);
    if ((this.zVa != null) && (this.zVa.isShowing())) {
      this.zVa.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void eba()
  {
    AppMethodBeat.i(69806);
    this.zUO = ((WalletSecuritySettingHeaderPref)this.screen.aKk("wallet_security_basic_info"));
    if (this.zUV != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.zUO;
      String str1 = this.zUV.title;
      String str2 = this.zUV.desc;
      String str3 = this.zUV.zVh;
      localWalletSecuritySettingHeaderPref.pTa = str1;
      localWalletSecuritySettingHeaderPref.zUJ = str2;
      localWalletSecuritySettingHeaderPref.zUK = str3;
      localWalletSecuritySettingHeaderPref.cE();
      if (bt.isNullOrNil(this.zUV.zVh))
      {
        localWalletSecuritySettingHeaderPref = this.zUO;
        if (localWalletSecuritySettingHeaderPref.zUI != null) {
          localWalletSecuritySettingHeaderPref.zUI.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void ebb()
  {
    AppMethodBeat.i(69807);
    if (this.zUZ == null)
    {
      this.screen.cE("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.cE("balance_privacy_info", false);
    this.zUT = ((IconPreference)this.screen.aKk("balance_privacy_info"));
    a(this.zUZ.dub, this.zUT);
    this.zUT.setTitle(this.zUZ.title);
    this.zUT.setSummary(this.zUZ.zVe);
    this.zUT.setDesc(this.zUZ.desc);
    this.zUT.eTz();
    AppMethodBeat.o(69807);
  }
  
  private void ebc()
  {
    AppMethodBeat.i(69808);
    if (this.zUW == null)
    {
      this.screen.cE("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.cE("wallet_security_wallet_lock", false);
    this.zUR = ((IconPreference)this.screen.aKk("wallet_security_wallet_lock"));
    a(this.zUW.dct, this.zUR);
    this.zUR.setTitle(this.zUW.title);
    this.zUR.setSummary(this.zUW.zVr);
    this.zUR.setDesc(this.zUW.desc);
    this.zUR.eTz();
    AppMethodBeat.o(69808);
  }
  
  private void ebd()
  {
    AppMethodBeat.i(69809);
    this.screen.cE("wallet_security_digital_certificate", false);
    this.zUP = ((IconPreference)this.screen.aKk("wallet_security_digital_certificate"));
    com.tencent.mm.wallet_core.c.ad.fkc();
    com.tencent.mm.kernel.g.afC();
    if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fmd, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.cE("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (com.tencent.mm.wallet_core.c.ad.fkc().fkd()) {
      if (this.zUP != null) {
        this.zUP.setSummary(2131765835);
      }
    }
    for (;;)
    {
      a(com.tencent.mm.wallet_core.c.ad.fkc().Ieg, this.zUP);
      this.zUP.setTitle(com.tencent.mm.wallet_core.c.ad.fkc().Iee);
      this.zUP.setSummary(com.tencent.mm.wallet_core.c.ad.fkc().Ief);
      this.zUP.setDesc(com.tencent.mm.wallet_core.c.ad.fkc().Ied);
      this.zUP.eTz();
      AppMethodBeat.o(69809);
      return;
      if (this.zUP != null) {
        this.zUP.setSummary(2131765837);
      }
    }
  }
  
  private void ebe()
  {
    AppMethodBeat.i(69810);
    this.screen.cE("wallet_security_pay_guard", false);
    this.zUQ = ((IconPreference)this.screen.aKk("wallet_security_pay_guard"));
    if (this.zUQ != null) {
      this.zUQ.setSummary(2131765837);
    }
    if (this.zUY == null)
    {
      this.screen.cE("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    a(this.zUY.dct, this.zUQ);
    this.zUQ.setTitle(this.zUY.title);
    IconPreference localIconPreference = this.zUQ;
    Object localObject = this.zUY;
    if (((c)localObject).status == 0) {
      localObject = ((c)localObject).zVi;
    }
    for (;;)
    {
      localIconPreference.setSummary((CharSequence)localObject);
      this.zUQ.setDesc(this.zUY.desc);
      this.zUQ.eTz();
      AppMethodBeat.o(69810);
      return;
      if (((c)localObject).status == 1) {
        localObject = ((c)localObject).zVj;
      } else {
        localObject = ((c)localObject).zVk;
      }
    }
  }
  
  private void ebf()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.cE("wallet_security_safety_insurance", false);
    this.zUS = ((IconPreference)this.screen.aKk("wallet_security_safety_insurance"));
    if (this.zUS != null) {
      this.zUS.setSummary(2131765838);
    }
    if (this.zUX == null)
    {
      this.screen.cE("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.zUX.dct, this.zUS);
    this.zUS.setTitle(this.zUX.title);
    this.zUS.setSummary(this.zUX.zVp);
    this.zUS.setDesc(this.zUX.desc);
    this.zUS.eTz();
    AppMethodBeat.o(69811);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.zVa != null) && (this.zVa.isShowing())) {
      this.zVa.dismiss();
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
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fra, "");
    if (!bt.isNullOrNil(str)) {
      try
      {
        aM(new JSONObject(str));
        AppMethodBeat.o(69803);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69803);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69802);
    super.onCreate(paramBundle);
    this.fsv = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new en();
    paramBundle.dMW = 11L;
    paramBundle.dZx = 1L;
    paramBundle.dZy = this.fsv;
    paramBundle.aBj();
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
    if (com.tencent.mm.compatible.util.d.lf(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
      updataStatusBarIcon(ai.Eq());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.vxB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      o.ayI().b((String)localEntry.getKey(), (p.a)localEntry.getValue());
    }
    this.vxB.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new en();
      paramf.dMW = 12L;
      paramf.dZx = 1L;
      paramf.aBj();
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.zUY == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.zUY.getUrl() });
      com.tencent.mm.wallet_core.ui.e.cp(this, this.zUY.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.zUX == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new en();
      paramf.dMW = 15L;
      paramf.dZx = 1L;
      paramf.aBj();
      if (this.zUX.jumpType == 2)
      {
        paramf = new uj();
        paramf.dzH.aAS = 0;
        paramf.dzH.userName = this.zUX.zVq;
        paramf.dzH.dzJ = this.zUX.zVg;
        com.tencent.mm.sdk.b.a.ESL.l(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.zUX.zVf);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(e.m.FIC, true);
        com.tencent.mm.wallet_core.ui.e.X(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.zUZ == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.bs.d.O(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.zUO = ((WalletSecuritySettingHeaderPref)this.screen.aKk("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.zUO != null)
    {
      localObject1 = this.zUO;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69791);
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (bt.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).zVf)))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 1) && (!bt.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).zVf)))
          {
            paramAnonymousView = new Intent();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).zVf });
            paramAnonymousView.putExtra("rawUrl", WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).zVf);
            paramAnonymousView.putExtra(e.m.FIC, true);
            com.tencent.mm.wallet_core.ui.e.X(WalletSecuritySettingUI.this.getContext(), paramAnonymousView);
            AppMethodBeat.o(69791);
            return;
          }
          if ((WalletSecuritySettingUI.a(WalletSecuritySettingUI.this) != null) && (WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).jumpType == 2)) {
            bt.isNullOrNil(WalletSecuritySettingUI.a(WalletSecuritySettingUI.this).zVg);
          }
          AppMethodBeat.o(69791);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).zUI != null) {
        break label281;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).zUL = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).zUI != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).zUI.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.zUO;
      localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69792);
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
          WalletSecuritySettingUI.this.finish();
          AppMethodBeat.o(69792);
        }
      };
      if (((WalletSecuritySettingHeaderPref)localObject1).ubf != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).zUM = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).ubf != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).ubf.setOnClickListener((View.OnClickListener)localObject2);
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(385, this);
      if (this.zUN)
      {
        this.zVa = h.b(this, getString(2131755936), false, null);
        this.zUN = false;
      }
      bool = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).ctN();
      localObject2 = com.tencent.mm.plugin.soter.d.d.dEQ();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaF;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaG;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.kernel.g.aeS().a(new com.tencent.mm.plugin.wallet.pwd.a.n(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69813);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.n))
    {
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.n)paramn).zSw;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      aM(paramString);
      if ((paramString != null) && (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjW, Boolean.FALSE)).booleanValue()))
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
        localCdnImageView.fz(paramString.uwS, 2131234705);
        localTextView.setText(paramString.doh);
        paramn.wY(true);
        paramn.wX(false);
        paramn.gs(localView);
        paramn.aMf(paramString.title);
        if ((paramString.zVo != null) && (!bt.isNullOrNil(paramString.zVo.nti)))
        {
          paramn.aMm(paramString.zVo.nti);
          paramn.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.zVo.uaQ == 1)
              {
                com.tencent.mm.wallet_core.ui.e.o(WalletSecuritySettingUI.this.getContext(), paramString.zVo.zVl, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.zVo.uaQ == 2) {
                com.tencent.mm.wallet_core.ui.e.v(paramString.zVo.zVm, paramString.zVo.zHt, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.zVn != null) && (!bt.isNullOrNil(paramString.zVn.nti)))
        {
          paramn.aMn(paramString.zVn.nti);
          paramn.c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.zVn.uaQ == 1)
              {
                com.tencent.mm.wallet_core.ui.e.o(WalletSecuritySettingUI.this.getContext(), paramString.zVn.zVl, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.zVn.uaQ == 2)
              {
                com.tencent.mm.wallet_core.ui.e.v(paramString.zVn.zVm, paramString.zVn.zHt, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramn.fft().show();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjW, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramn.optString("title");
      paramString.doh = paramn.optString("wording");
      paramString.uwS = paramn.optString("logo");
      paramString.zVn = d.aN(paramn.optJSONObject("left_btn"));
      paramString.zVo = d.aN(paramn.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String desc;
    String dub;
    int switchState;
    String title;
    String zVe;
    
    private a() {}
  }
  
  final class b
  {
    String dct;
    String desc;
    int jumpType;
    String title;
    String zVf;
    String zVg;
    String zVh;
    
    private b() {}
  }
  
  final class c
  {
    String dct;
    String desc;
    int status;
    String title;
    String zVf;
    String zVi;
    String zVj;
    String zVk;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(69797);
      if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.qqpimsecure"))
      {
        if (bt.bW(paramContext, "com.tencent.server.back.BackEngine"))
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
    
    private String jD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.zVf).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = jD("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = jD("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = jD("qqpimsecurestatus", "runing");
      AppMethodBeat.o(69798);
      return str;
    }
  }
  
  static final class d
  {
    String nti;
    int uaQ;
    String zHt;
    String zVl;
    String zVm;
    
    public static d aN(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.nti = paramJSONObject.optString("button_wording");
      locald.uaQ = paramJSONObject.optInt("jump_type");
      locald.zVl = paramJSONObject.optString("jump_h5_url");
      locald.zVm = paramJSONObject.optString("tinyapp_name");
      locald.zHt = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    String doh;
    String title;
    String uwS;
    WalletSecuritySettingUI.d zVn;
    WalletSecuritySettingUI.d zVo;
  }
  
  final class f
  {
    String dct;
    String desc;
    int jumpType;
    int status;
    String title;
    String zVf;
    String zVg;
    String zVp;
    String zVq;
    
    private f() {}
  }
  
  final class g
  {
    String dct;
    String desc;
    int status;
    String title;
    String zVr;
    boolean zVs;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */