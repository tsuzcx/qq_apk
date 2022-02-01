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
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
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
  implements com.tencent.mm.al.f
{
  private IconPreference CNA;
  private IconPreference CNB;
  private IconPreference CNC;
  private Preference CND;
  private WalletSecuritySettingUI.b CNE;
  private g CNF;
  private f CNG;
  private c CNH;
  private a CNI;
  private ProgressDialog CNJ;
  private boolean CNw;
  private WalletSecuritySettingHeaderPref CNx;
  private IconPreference CNy;
  private IconPreference CNz;
  private int fPp;
  private com.tencent.mm.ui.base.preference.f screen;
  private Map<String, r.a> xVn;
  
  public WalletSecuritySettingUI()
  {
    AppMethodBeat.i(69801);
    this.CNw = true;
    this.fPp = 0;
    this.xVn = new HashMap();
    AppMethodBeat.o(69801);
  }
  
  private void a(String paramString, IconPreference paramIconPreference)
  {
    AppMethodBeat.i(69817);
    if (paramIconPreference == null)
    {
      AppMethodBeat.o(69817);
      return;
    }
    com.tencent.mm.aw.q.aIE();
    Bitmap localBitmap = com.tencent.mm.aw.d.vT(paramString);
    if (localBitmap != null)
    {
      paramIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
      AppMethodBeat.o(69817);
      return;
    }
    if (!bt.isNullOrNil(paramString))
    {
      paramIconPreference = new WalletSecuritySettingUI.7(this, paramIconPreference);
      this.xVn.put(paramString, paramIconPreference);
      com.tencent.mm.aw.q.aII().a(paramString, paramIconPreference);
    }
    AppMethodBeat.o(69817);
  }
  
  private void aV(JSONObject paramJSONObject)
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
      this.CND = this.screen.aVD("wallet_security_more_title");
      this.CND.setTitle((CharSequence)localObject);
      if (paramJSONObject.has("basic_security_item"))
      {
        localObject = paramJSONObject.getJSONObject("basic_security_item");
        this.CNE = new WalletSecuritySettingUI.b(this, (byte)0);
        this.CNE.title = ((JSONObject)localObject).optString("title");
        this.CNE.desc = ((JSONObject)localObject).optString("desc");
        this.CNE.wqa = ((JSONObject)localObject).optString("logo_url");
      }
      if (paramJSONObject.has("wallet_lock_info"))
      {
        localObject = paramJSONObject.getJSONObject("wallet_lock_info");
        this.CNF = new g((byte)0);
        this.CNF.title = ((JSONObject)localObject).optString("wallet_lock_title");
        this.CNF.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
        this.CNF.wqa = ((JSONObject)localObject).getString("wallet_lock_logo_url");
        this.CNF.status = ((JSONObject)localObject).optInt("wallet_lock_status");
        this.CNF.COa = ((JSONObject)localObject).optString("wallet_lock_status_name");
        this.CNF.COb = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
      }
      if (paramJSONObject.has("property_security_info"))
      {
        localObject = paramJSONObject.getJSONObject("property_security_info");
        this.CNG = new f((byte)0);
        this.CNG.title = ((JSONObject)localObject).optString("title", "");
        this.CNG.desc = ((JSONObject)localObject).optString("desc", "");
        this.CNG.wqa = ((JSONObject)localObject).optString("logo_url", "");
        this.CNG.status = ((JSONObject)localObject).optInt("status", 0);
        this.CNG.CNY = ((JSONObject)localObject).optString("status_name");
        this.CNG.jumpType = ((JSONObject)localObject).optInt("jump_type");
        this.CNG.CNO = ((JSONObject)localObject).optString("jump_h5_url");
        this.CNG.CNZ = ((JSONObject)localObject).optString("tinyapp_username");
        this.CNG.CNP = ((JSONObject)localObject).optString("tinyapp_path");
      }
      if (paramJSONObject.has("safe_manager_info"))
      {
        localObject = paramJSONObject.getJSONObject("safe_manager_info");
        this.CNH = new c(this);
        this.CNH.title = ((JSONObject)localObject).optString("title", "");
        this.CNH.desc = ((JSONObject)localObject).optString("desc", "");
        this.CNH.wqa = ((JSONObject)localObject).optString("logo_url", "");
        this.CNH.CNS = ((JSONObject)localObject).optString("installed_status_name");
        this.CNH.CNR = ((JSONObject)localObject).optString("uninstall_status_name");
        this.CNH.CNT = ((JSONObject)localObject).optString("protected_mode_name");
        this.CNH.CNO = ((JSONObject)localObject).optString("jump_h5_url");
      }
      if (paramJSONObject.has("balance_privacy_info"))
      {
        localObject = paramJSONObject.getJSONObject("balance_privacy_info");
        this.CNI = new a((byte)0);
        this.CNI.dDH = ((JSONObject)localObject).optString("icon", "");
        this.CNI.title = ((JSONObject)localObject).optString("title", "");
        this.CNI.desc = ((JSONObject)localObject).optString("desc", "");
        this.CNI.switchState = ((JSONObject)localObject).optInt("switch_state");
        this.CNI.CNN = ((JSONObject)localObject).optString("switch_state_info");
      }
      com.tencent.mm.wallet_core.c.ad.fRC().bK(paramJSONObject);
      g.ajD();
      g.ajC().ajl().set(al.a.IBl, paramJSONObject.toString());
      eEw();
      eEy();
      eEz();
      eEA();
      eEB();
      eEx();
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
    if ((this.CNJ != null) && (this.CNJ.isShowing())) {
      this.CNJ.dismiss();
    }
    AppMethodBeat.o(69816);
  }
  
  private void eEA()
  {
    AppMethodBeat.i(69810);
    this.screen.cP("wallet_security_pay_guard", false);
    this.CNz = ((IconPreference)this.screen.aVD("wallet_security_pay_guard"));
    if (this.CNz != null) {
      this.CNz.setSummary(2131765837);
    }
    if (this.CNH == null)
    {
      this.screen.cP("wallet_security_pay_guard", true);
      AppMethodBeat.o(69810);
      return;
    }
    a(this.CNH.wqa, this.CNz);
    this.CNz.setTitle(this.CNH.title);
    IconPreference localIconPreference = this.CNz;
    Object localObject = this.CNH;
    if (((c)localObject).status == 0) {
      localObject = ((c)localObject).CNR;
    }
    for (;;)
    {
      localIconPreference.setSummary((CharSequence)localObject);
      this.CNz.setDesc(this.CNH.desc);
      this.CNz.fzA();
      AppMethodBeat.o(69810);
      return;
      if (((c)localObject).status == 1) {
        localObject = ((c)localObject).CNS;
      } else {
        localObject = ((c)localObject).CNT;
      }
    }
  }
  
  private void eEB()
  {
    AppMethodBeat.i(69811);
    this.screen = getPreferenceScreen();
    this.screen.cP("wallet_security_safety_insurance", false);
    this.CNB = ((IconPreference)this.screen.aVD("wallet_security_safety_insurance"));
    if (this.CNB != null) {
      this.CNB.setSummary(2131765838);
    }
    if (this.CNG == null)
    {
      this.screen.cP("wallet_security_safety_insurance", true);
      AppMethodBeat.o(69811);
      return;
    }
    a(this.CNG.wqa, this.CNB);
    this.CNB.setTitle(this.CNG.title);
    this.CNB.setSummary(this.CNG.CNY);
    this.CNB.setDesc(this.CNG.desc);
    this.CNB.fzA();
    AppMethodBeat.o(69811);
  }
  
  private void eEw()
  {
    AppMethodBeat.i(69806);
    this.CNx = ((WalletSecuritySettingHeaderPref)this.screen.aVD("wallet_security_basic_info"));
    if (this.CNE != null)
    {
      WalletSecuritySettingHeaderPref localWalletSecuritySettingHeaderPref = this.CNx;
      String str1 = this.CNE.title;
      String str2 = this.CNE.desc;
      String str3 = this.CNE.CNQ;
      localWalletSecuritySettingHeaderPref.rlx = str1;
      localWalletSecuritySettingHeaderPref.CNs = str2;
      localWalletSecuritySettingHeaderPref.CNt = str3;
      localWalletSecuritySettingHeaderPref.updateView();
      if (bt.isNullOrNil(this.CNE.CNQ))
      {
        localWalletSecuritySettingHeaderPref = this.CNx;
        if (localWalletSecuritySettingHeaderPref.CNr != null) {
          localWalletSecuritySettingHeaderPref.CNr.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(69806);
  }
  
  private void eEx()
  {
    AppMethodBeat.i(69807);
    if (this.CNI == null)
    {
      this.screen.cP("balance_privacy_info", true);
      AppMethodBeat.o(69807);
      return;
    }
    this.screen.cP("balance_privacy_info", false);
    this.CNC = ((IconPreference)this.screen.aVD("balance_privacy_info"));
    a(this.CNI.dDH, this.CNC);
    this.CNC.setTitle(this.CNI.title);
    this.CNC.setSummary(this.CNI.CNN);
    this.CNC.setDesc(this.CNI.desc);
    this.CNC.fzA();
    AppMethodBeat.o(69807);
  }
  
  private void eEy()
  {
    AppMethodBeat.i(69808);
    if (this.CNF == null)
    {
      this.screen.cP("wallet_security_wallet_lock", true);
      AppMethodBeat.o(69808);
      return;
    }
    this.screen.cP("wallet_security_wallet_lock", false);
    this.CNA = ((IconPreference)this.screen.aVD("wallet_security_wallet_lock"));
    a(this.CNF.wqa, this.CNA);
    this.CNA.setTitle(this.CNF.title);
    this.CNA.setSummary(this.CNF.COa);
    this.CNA.setDesc(this.CNF.desc);
    this.CNA.fzA();
    AppMethodBeat.o(69808);
  }
  
  private void eEz()
  {
    AppMethodBeat.i(69809);
    this.screen.cP("wallet_security_digital_certificate", false);
    this.CNy = ((IconPreference)this.screen.aVD("wallet_security_digital_certificate"));
    com.tencent.mm.wallet_core.c.ad.fRC();
    g.ajD();
    if (((Integer)g.ajC().ajl().get(al.a.Iwk, Integer.valueOf(0))).intValue() > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.screen.cP("wallet_security_digital_certificate", true);
      AppMethodBeat.o(69809);
      return;
    }
    if (this.CNy == null)
    {
      AppMethodBeat.o(69809);
      return;
    }
    if (!com.tencent.mm.wallet_core.c.ad.fRC().fRD()) {
      this.CNy.setSummary(2131765837);
    }
    for (;;)
    {
      a(com.tencent.mm.wallet_core.c.ad.fRC().LyM, this.CNy);
      this.CNy.setTitle(com.tencent.mm.wallet_core.c.ad.fRC().LyK);
      this.CNy.setDesc(com.tencent.mm.wallet_core.c.ad.fRC().LyJ);
      this.CNy.fzA();
      AppMethodBeat.o(69809);
      return;
      if (!bt.isNullOrNil(com.tencent.mm.wallet_core.c.ad.fRC().LyL)) {
        this.CNy.setSummary(com.tencent.mm.wallet_core.c.ad.fRC().LyL);
      } else {
        this.CNy.setSummary(2131765835);
      }
    }
  }
  
  private void onError(String paramString)
  {
    AppMethodBeat.i(69814);
    if ((this.CNJ != null) && (this.CNJ.isShowing())) {
      this.CNJ.dismiss();
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
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IBl, "");
    if (!bt.isNullOrNil(str)) {
      try
      {
        aV(new JSONObject(str));
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
    this.fPp = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new hg();
    paramBundle.ecM = 11L;
    paramBundle.erV = 1L;
    paramBundle.erW = this.fPp;
    paramBundle.aLk();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.ly(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
      updataStatusBarIcon(al.isDarkMode());
    }
    AppMethodBeat.o(69802);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69818);
    Iterator localIterator = this.xVn.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      com.tencent.mm.aw.q.aII().b((String)localEntry.getKey(), (r.a)localEntry.getValue());
    }
    this.xVn.clear();
    super.onDestroy();
    AppMethodBeat.o(69818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69805);
    super.onPause();
    g.ajD();
    g.ajB().gAO.b(385, this);
    AppMethodBeat.o(69805);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69812);
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new hg();
      paramf.ecM = 12L;
      paramf.erV = 1L;
      paramf.aLk();
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      AppMethodBeat.o(69812);
      return true;
    }
    if ("wallet_security_pay_guard".equals(paramPreference.mKey))
    {
      if (this.CNH == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.CNH.getUrl() });
      com.tencent.mm.wallet_core.ui.e.cu(this, this.CNH.getUrl());
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
      if (this.CNG == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      paramf = new hg();
      paramf.ecM = 15L;
      paramf.erV = 1L;
      paramf.aLk();
      if (this.CNG.jumpType == 2)
      {
        paramf = new vm();
        paramf.dJF.aDD = 0;
        paramf.dJF.userName = this.CNG.CNZ;
        paramf.dJF.dJH = this.CNG.CNP;
        com.tencent.mm.sdk.b.a.IbL.l(paramf);
      }
      for (;;)
      {
        AppMethodBeat.o(69812);
        return true;
        paramf = new Intent();
        paramf.putExtra("rawUrl", this.CNG.CNO);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
        paramf.putExtra(e.m.IVa, true);
        com.tencent.mm.wallet_core.ui.e.an(getContext(), paramf);
      }
    }
    if ("balance_privacy_info".equals(paramPreference.mKey))
    {
      if (this.CNI == null)
      {
        AppMethodBeat.o(69812);
        return true;
      }
      com.tencent.mm.bs.d.Q(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
    }
    AppMethodBeat.o(69812);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69804);
    super.onResume();
    this.CNx = ((WalletSecuritySettingHeaderPref)this.screen.aVD("wallet_security_basic_info"));
    Object localObject1;
    Object localObject2;
    if (this.CNx != null)
    {
      localObject1 = this.CNx;
      localObject2 = new WalletSecuritySettingUI.2(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).CNr != null) {
        break label281;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).CNu = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).CNr != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).CNr.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.CNx;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).gXw != null) {
        break label286;
      }
    }
    label281:
    label286:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).CNv = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).gXw != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).gXw.setOnClickListener((View.OnClickListener)localObject2);
      }
      g.ajD();
      g.ajB().gAO.a(385, this);
      if (this.CNw)
      {
        this.CNJ = h.b(this, getString(2131755936), false, null);
        this.CNw = false;
      }
      bool = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cPo();
      localObject2 = com.tencent.mm.plugin.soter.d.d.efE();
      localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFy;
      localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFz;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      g.aiU().a(new com.tencent.mm.plugin.wallet.pwd.a.n(bool, (String)localObject1, (String)localObject2), 0);
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
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.n)paramn).CLe;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      aV(paramString);
      if ((paramString != null) && (!((Boolean)g.ajC().ajl().get(al.a.Iud, Boolean.FALSE)).booleanValue()))
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
        localCdnImageView.gb(paramString.wMR, 2131234705);
        localTextView.setText(paramString.dxD);
        paramn.yS(true);
        paramn.yR(false);
        paramn.gY(localView);
        paramn.aXF(paramString.title);
        if ((paramString.CNX != null) && (!bt.isNullOrNil(paramString.CNX.ozC)))
        {
          paramn.aXM(paramString.CNX.ozC);
          paramn.a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69793);
              if (paramString.CNX.uxt == 1)
              {
                com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.getContext(), paramString.CNX.CNU, true);
                AppMethodBeat.o(69793);
                return;
              }
              if (paramString.CNX.uxt == 2) {
                com.tencent.mm.wallet_core.ui.e.v(paramString.CNX.CNV, paramString.CNX.CzR, 0, 1000);
              }
              AppMethodBeat.o(69793);
            }
          });
        }
        if ((paramString.CNW != null) && (!bt.isNullOrNil(paramString.CNW.ozC)))
        {
          paramn.aXN(paramString.CNW.ozC);
          paramn.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69794);
              if (paramString.CNW.uxt == 1)
              {
                com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.getContext(), paramString.CNW.CNU, true);
                AppMethodBeat.o(69794);
                return;
              }
              if (paramString.CNW.uxt == 2)
              {
                com.tencent.mm.wallet_core.ui.e.v(paramString.CNW.CNV, paramString.CNW.CzR, 0, 1000);
                AppMethodBeat.o(69794);
                return;
              }
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(69794);
            }
          });
        }
        paramn.fMb().show();
        g.ajC().ajl().set(al.a.Iud, Boolean.TRUE);
      }
      AppMethodBeat.o(69813);
      return;
      label352:
      paramString = new e();
      paramString.title = paramn.optString("title");
      paramString.dxD = paramn.optString("wording");
      paramString.wMR = paramn.optString("logo");
      paramString.CNW = d.aW(paramn.optJSONObject("left_btn"));
      paramString.CNX = d.aW(paramn.optJSONObject("right_btn"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    String CNN;
    String dDH;
    String desc;
    int switchState;
    String title;
    
    private a() {}
  }
  
  final class c
  {
    String CNO;
    String CNR;
    String CNS;
    String CNT;
    String desc;
    int status;
    String title;
    String wqa;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(69797);
      if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.qqpimsecure"))
      {
        if (bt.cc(paramContext, "com.tencent.server.back.BackEngine"))
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
    
    private String kt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(69799);
      paramString1 = Uri.parse(this.CNO).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
      AppMethodBeat.o(69799);
      return paramString1;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(69798);
      if (this.status == 0)
      {
        str = kt("qqpimsecurestatus", "not_installed");
        AppMethodBeat.o(69798);
        return str;
      }
      if (this.status == 1)
      {
        str = kt("qqpimsecurestatus", "not_run");
        AppMethodBeat.o(69798);
        return str;
      }
      String str = kt("qqpimsecurestatus", "runing");
      AppMethodBeat.o(69798);
      return str;
    }
  }
  
  static final class d
  {
    String CNU;
    String CNV;
    String CzR;
    String ozC;
    int uxt;
    
    public static d aW(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(69800);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(69800);
        return null;
      }
      d locald = new d();
      locald.ozC = paramJSONObject.optString("button_wording");
      locald.uxt = paramJSONObject.optInt("jump_type");
      locald.CNU = paramJSONObject.optString("jump_h5_url");
      locald.CNV = paramJSONObject.optString("tinyapp_name");
      locald.CzR = paramJSONObject.optString("tinyapp_path");
      AppMethodBeat.o(69800);
      return locald;
    }
  }
  
  static final class e
  {
    WalletSecuritySettingUI.d CNW;
    WalletSecuritySettingUI.d CNX;
    String dxD;
    String title;
    String wMR;
  }
  
  final class f
  {
    String CNO;
    String CNP;
    String CNY;
    String CNZ;
    String desc;
    int jumpType;
    int status;
    String title;
    String wqa;
    
    private f() {}
  }
  
  final class g
  {
    String COa;
    boolean COb;
    String desc;
    int status;
    String title;
    String wqa;
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */