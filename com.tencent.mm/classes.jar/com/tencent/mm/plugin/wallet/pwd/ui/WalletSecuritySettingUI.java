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
import com.tencent.mm.ak.t;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.u;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.p;
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
  implements com.tencent.mm.ak.i
{
  private Map<String, r.a> Cmg;
  private boolean HKY;
  private WalletSecuritySettingHeaderPref HKZ;
  private IconPreference HLa;
  private IconPreference HLb;
  private IconPreference HLc;
  private IconPreference HLd;
  private IconPreference HLe;
  private WalletSecuritySettingUI.b HLf;
  private g HLg;
  private f HLh;
  private c HLi;
  private a HLj;
  private ProgressDialog HLk;
  private int gwE;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.HKY = true;
    this.gwE = 0;
    this.Cmg = new HashMap();
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
    com.tencent.mm.av.q.bcQ();
    Bitmap localBitmap = com.tencent.mm.av.d.EP(paramString);
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
      this.Cmg.put(paramString, paramIconPreference);
      com.tencent.mm.av.q.bcU().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void bv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69815);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(2131768278));
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
        this.HLf = new WalletSecuritySettingUI.b(this, (byte)0);
        this.HLf.title = localJSONObject.optString("title");
        this.HLf.desc = localJSONObject.optString("desc");
        this.HLf.AAU = localJSONObject.optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.HLg = new g((byte)0);
        this.HLg.title = localJSONObject.optString("wallet_lock_title");
        this.HLg.desc = localJSONObject.optString("wallet_lock_desc");
        this.HLg.AAU = localJSONObject.getString("wallet_lock_logo_url");
        this.HLg.status = localJSONObject.optInt("wallet_lock_status");
        this.HLg.HLE = localJSONObject.optString("wallet_lock_status_name");
        this.HLg.HLF = localJSONObject.optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("property_security_info");
        this.HLh = new f((byte)0);
        this.HLh.title = localJSONObject.optString("title", "");
        this.HLh.desc = localJSONObject.optString("desc", "");
        this.HLh.AAU = localJSONObject.optString("logo_url", "");
        this.HLh.status = localJSONObject.optInt("status", 0);
        this.HLh.HLC = localJSONObject.optString("status_name");
        this.HLh.jumpType = localJSONObject.optInt("jump_type");
        this.HLh.HLp = localJSONObject.optString("jump_h5_url");
        this.HLh.HLD = localJSONObject.optString("tinyapp_username");
        this.HLh.HLq = localJSONObject.optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("safe_manager_info");
        if (this.HLi == null) {
          this.HLi = new c();
        }
        this.HLi.title = localJSONObject.optString("title", "");
        this.HLi.desc = localJSONObject.optString("desc", "");
        this.HLi.AAU = localJSONObject.optString("logo_url", "");
        this.HLi.HLt = localJSONObject.optString("installed_status_name");
        this.HLi.HLs = localJSONObject.optString("uninstall_status_name");
        this.HLi.HLu = localJSONObject.optString("protected_mode_name");
        this.HLi.HLp = localJSONObject.optString("jump_h5_url");
        this.HLi.hJ(this);
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localJSONObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.HLj = new a((byte)0);
        this.HLj.icon = localJSONObject.optString("icon", "");
        this.HLj.title = localJSONObject.optString("title", "");
        this.HLj.desc = localJSONObject.optString("desc", "");
        this.HLj.switchState = localJSONObject.optInt("switch_state");
        this.HLj.HLo = localJSONObject.optString("switch_state_info");
      }
      ad.hhv().ck(paramJSONObject);
      g.aAi();
      g.aAh().azQ().set(ar.a.Oec, paramJSONObject.toString());
      fPp();
      fPr();
      fPs();
      fPt();
      fPu();
      fPq();
      this.screen.notifyDataSetChanged();
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(2131768278));
      }
    }
    dismissDialog();
    AppMethodBeat.o(69815);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(69816);
    if ((this.HLk != null) && (this.HLk.isShowing())) {
      this.HLk.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void fPp()
  {
    AppMethodBeat.i(69806);
    this.HKZ = ((WalletSecuritySettingHeaderPref)this.screen.bmg("wallet_security_basic_info"));
    if (this.HLf != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.HKZ;
      String str1 = this.HLf.title;
      String str2 = this.HLf.desc;
      String str3 = this.HLf.HLr;
      localWalletSecuritySettingHeaderPref.sUf = str1;
      localWalletSecuritySettingHeaderPref.HKU = str2;
      localWalletSecuritySettingHeaderPref.HKV = str3;
      localWalletSecuritySettingHeaderPref.updateView();
      if (Util.isNullOrNil(this.HLf.HLr))
      {
        localWalletSecuritySettingHeaderPref = this.HKZ;
        if (localWalletSecuritySettingHeaderPref.HKT != null) {
          localWalletSecuritySettingHeaderPref.HKT.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void fPq()
  {
    AppMethodBeat.i(69807);
    if (this.HLj == null)
    {
      this.screen.jdMethod_do("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.jdMethod_do("balance_privacy_info", false);
    this.HLe = ((IconPreference)this.screen.bmg("balance_privacy_info"));
    a(this.HLj.icon, this.HLe);
    this.HLe.setTitle(this.HLj.title);
    this.HLe.setSummary(this.HLj.HLo);
    this.HLe.setDesc(this.HLj.desc);
    this.HLe.gLF();
    AppMethodBeat.o(69807);
  }
  
  private void fPr()
  {
    AppMethodBeat.i(69808);
    if (this.HLg == null)
    {
      this.screen.jdMethod_do("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.jdMethod_do("wallet_security_wallet_lock", false);
    this.HLc = ((IconPreference)this.screen.bmg("wallet_security_wallet_lock"));
    a(this.HLg.AAU, this.HLc);
    this.HLc.setTitle(this.HLg.title);
    this.HLc.setSummary(this.HLg.HLE);
    this.HLc.setDesc(this.HLg.desc);
    this.HLc.gLF();
    AppMethodBeat.o(69808);
  }
  
  private void fPs()
  {
    AppMethodBeat.i(69809);
    this.screen.jdMethod_do("wallet_security_digital_certificate", false);
    this.HLa = ((IconPreference)this.screen.bmg("wallet_security_digital_certificate"));
    ad.hhv();
    g.aAi();
    if (((Integer)g.aAh().azQ().get(ar.a.NYJ, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.jdMethod_do("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (this.HLa == null)
    {
      AppMethodBeat.o(69809);
      return;
    }
    if (!ad.hhv().hhw()) {
      this.HLa.setSummary(2131768290);
    }
    for (;;)
    {
      a(ad.hhv().Rur, this.HLa);
      this.HLa.setTitle(ad.hhv().Rup);
      this.HLa.setDesc(ad.hhv().Ruo);
      this.HLa.gLF();
      AppMethodBeat.o(69809);
      return;
      if (!Util.isNullOrNil(ad.hhv().Ruq)) {
        this.HLa.setSummary(ad.hhv().Ruq);
      } else {
        this.HLa.setSummary(2131768288);
      }
    }
  }
  
  private void fPt()
  {
    AppMethodBeat.i(69810);
    this.HLb = ((IconPreference)this.screen.bmg("wallet_security_pay_guard"));
    if (this.HLi == null)
    {
      this.screen.jdMethod_do("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    this.screen.jdMethod_do("wallet_security_pay_guard", false);
    a(this.HLi.AAU, this.HLb);
    this.HLb.setTitle(this.HLi.title);
    String str = this.HLi.fPv();
    if (!Util.isNullOrNil(str)) {
      this.HLb.setSummary(str);
    }
    this.HLb.setDesc(this.HLi.desc);
    this.HLb.gLF();
    AppMethodBeat.o(69810);
  }
  
  private void fPu()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.jdMethod_do("wallet_security_safety_insurance", false);
    this.HLd = ((IconPreference)this.screen.bmg("wallet_security_safety_insurance"));
    if (this.HLd != null) {
      this.HLd.setSummary(2131768291);
    }
    if (this.HLh == null)
    {
      this.screen.jdMethod_do("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.HLh.AAU, this.HLd);
    this.HLd.setTitle(this.HLh.title);
    this.HLd.setSummary(this.HLh.HLC);
    this.HLd.setDesc(this.HLh.desc);
    this.HLd.gLF();
    AppMethodBeat.o(69811);
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.HLk != null) && (this.HLk.isShowing())) {
      this.HLk.dismiss();
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
      this.screen.addPreferencesFromResource(2132017308);
    }
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.Oec, "");
    if (!Util.isNullOrNil(str)) {
      try
      {
        bv(new JSONObject(str));
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
    this.gwE = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new kz();
    paramBundle.eEH = 11L;
    paramBundle.eXI = 1L;
    paramBundle.eXJ = this.gwE;
    paramBundle.bfK();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.oD(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131101424));
      updataStatusBarIcon(com.tencent.mm.ui.ao.isDarkMode());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.Cmg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      com.tencent.mm.av.q.bcU().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
    }
    this.Cmg.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    g.aAi();
    g.aAg().hqi.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new kz();
      paramf.eEH = 12L;
      paramf.eXI = 1L;
      paramf.bfK();
      c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.HLi == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      Log.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.HLi.getUrl() });
      com.tencent.mm.wallet_core.ui.f.cO(this, this.HLi.getUrl());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      ((com.tencent.mm.plugin.walletlock.a.b)g.af(com.tencent.mm.plugin.walletlock.a.b.class)).j(this, paramf);
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_safety_insurance".equals(paramPreference.mKey))
    {
      if (this.HLh == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new kz();
      paramf.eEH = 15L;
      paramf.eXI = 1L;
      paramf.bfK();
      if (this.HLh.jumpType == 2)
      {
        paramf = new wq();
        paramf.ecI.appVersion = 0;
        paramf.ecI.userName = this.HLh.HLD;
        paramf.ecI.ecK = this.HLh.HLq;
        EventCenter.instance.publish(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.HLh.HLp);
        Log.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(e.p.OzJ, true);
        com.tencent.mm.wallet_core.ui.f.aA(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.HLj == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      c.V(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.HKZ = ((WalletSecuritySettingHeaderPref)this.screen.bmg("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.HKZ != null)
    {
      localObject1 = this.HKZ;
      localObject2 = new WalletSecuritySettingUI.2(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).HKT != null) {
        break label281;
      }
      bool = true;
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).HKW = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).HKT != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).HKT.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.HKZ;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).hTd != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).HKX = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).hTd != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).hTd.setOnClickListener((View.OnClickListener)localObject2);
      }
      g.aAi();
      g.aAg().hqi.a(385, this);
      if (this.HKY)
      {
        this.HLk = com.tencent.mm.ui.base.h.a(this, getString(2131756029), false, null);
        this.HKY = false;
      }
      bool = ((a)g.af(a.class)).dJO();
      localObject2 = com.tencent.mm.plugin.soter.d.d.flM();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).FhU;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).hFF;
      Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      g.azz().a(new n(bool, (String)localObject1, (String)localObject2), 0);
      AppMethodBeat.o(69804);
      return;
      bool = false;
      break;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(69813);
    Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof n))
    {
      paramString = ((n)paramq).HIy;
      Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      bv(paramString);
      if ((paramString != null) && (!((Boolean)g.aAh().azQ().get(ar.a.NWC, Boolean.FALSE)).booleanValue()))
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
        View localView = LayoutInflater.from(this).inflate(2131497015, null, false);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131310626);
        TextView localTextView = (TextView)localView.findViewById(2131310627);
        localCdnImageView.gI(paramString.Bah, 2131235667);
        localTextView.setText(paramString.dQx);
        paramq.Dl(true);
        paramq.Dk(false);
        paramq.hs(localView);
        paramq.bon(paramString.title);
        if ((paramString.HLB != null) && (!Util.isNullOrNil(paramString.HLB.pTK)))
        {
          paramq.bou(paramString.HLB.pTK);
          paramq.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.HLB.uSc == 1)
              {
                com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), paramString.HLB.HLy, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.HLB.uSc == 2) {
                com.tencent.mm.wallet_core.ui.f.u(paramString.HLB.HLz, paramString.HLB.Hws, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.HLA != null) && (!Util.isNullOrNil(paramString.HLA.pTK)))
        {
          paramq.bov(paramString.HLA.pTK);
          paramq.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.HLA.uSc == 1)
              {
                com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), paramString.HLA.HLy, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.HLA.uSc == 2)
              {
                com.tencent.mm.wallet_core.ui.f.u(paramString.HLA.HLz, paramString.HLA.Hws, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramq.hbn().show();
        g.aAh().azQ().set(ar.a.NWC, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramq.optString("title");
      paramString.dQx = paramq.optString("wording");
      paramString.Bah = paramq.optString("logo");
      paramString.HLA = d.bw(paramq.optJSONObject("left_btn"));
      paramString.HLB = d.bw(paramq.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String HLo;
    String desc;
    String icon;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class c
  {
    String AAU;
    String HLp;
    String HLs;
    String HLt;
    String HLu;
    String desc;
    int status;
    String title;
    
    c() {}
    
    private String lt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.HLp).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String fPv()
    {
      AppMethodBeat.i(214097);
      Log.d("MicroMsg.WalletSecuritySettingUI", "check status2: %s, %s", new Object[] { Integer.valueOf(this.status), Integer.valueOf(hashCode()) });
      if (this.status == 0)
      {
        str = this.HLs;
        AppMethodBeat.o(214097);
        return str;
      }
      if (this.status == 1)
      {
        str = this.HLt;
        AppMethodBeat.o(214097);
        return str;
      }
      if (this.status == 3)
      {
        AppMethodBeat.o(214097);
        return null;
      }
      String str = this.HLu;
      AppMethodBeat.o(214097);
      return str;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = lt("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 2)
      {
        str = lt("qqpimsecurestatus", "runing");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = lt("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = lt("qqpimsecurestatus", "not_run");
      AppMethodBeat.o(69798);
      return str;
    }
    
    public final void hJ(Context paramContext)
    {
      AppMethodBeat.i(214098);
      if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.qqpimsecure"))
      {
        this.status = 3;
        com.tencent.f.h.RTc.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214096);
            final boolean bool = u.fOQ();
            WalletSecuritySettingUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(214095);
                WalletSecuritySettingUI.c localc = WalletSecuritySettingUI.c.this;
                boolean bool = bool;
                if (WalletSecuritySettingUI.a(localc.HLl) != null) {
                  if (!bool) {
                    break label115;
                  }
                }
                label115:
                for (localc.status = 2;; localc.status = 1)
                {
                  Log.d("MicroMsg.WalletSecuritySettingUI", "check status: %s %s", new Object[] { Integer.valueOf(localc.status), Integer.valueOf(localc.hashCode()) });
                  String str = WalletSecuritySettingUI.a(localc.HLl).fPv();
                  if (!Util.isNullOrNil(str)) {
                    WalletSecuritySettingUI.b(localc.HLl).setSummary(str);
                  }
                  WalletSecuritySettingUI.c(localc.HLl).notifyDataSetChanged();
                  AppMethodBeat.o(214095);
                  return;
                }
              }
            });
            AppMethodBeat.o(214096);
          }
        }, "check_qq_security_status");
        AppMethodBeat.o(214098);
        return;
      }
      this.status = 0;
      AppMethodBeat.o(214098);
    }
  }
  
  static final class d
  {
    String HLy;
    String HLz;
    String Hws;
    String pTK;
    int uSc;
    
    public static d bw(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.pTK = paramJSONObject.optString("button_wording");
      locald.uSc = paramJSONObject.optInt("jump_type");
      locald.HLy = paramJSONObject.optString("jump_h5_url");
      locald.HLz = paramJSONObject.optString("tinyapp_name");
      locald.Hws = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    String Bah;
    WalletSecuritySettingUI.d HLA;
    WalletSecuritySettingUI.d HLB;
    String dQx;
    String title;
  }
  
  final class f
  {
    String AAU;
    String HLC;
    String HLD;
    String HLp;
    String HLq;
    String desc;
    int jumpType;
    int status;
    String title;
    
    private f() {}
  }
  
  final class g
  {
    String AAU;
    String HLE;
    boolean HLF;
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