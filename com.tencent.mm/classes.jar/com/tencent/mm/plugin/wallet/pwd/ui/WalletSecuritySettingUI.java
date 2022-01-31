package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import org.json.JSONObject;

public class WalletSecuritySettingUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private int drX = 0;
  private boolean qpP = true;
  private WalletSecuritySettingHeaderPref qpQ;
  private IconPreference qpR;
  private IconPreference qpS;
  private IconPreference qpT;
  private IconPreference qpU;
  private Preference qpV;
  private WalletSecuritySettingUI.a qpW;
  private d qpX;
  private WalletSecuritySettingUI.c qpY;
  private b qpZ;
  private ProgressDialog qqa;
  
  private void a(String paramString, IconPreference paramIconPreference)
  {
    if (paramIconPreference == null) {}
    do
    {
      return;
      o.OI();
      Bitmap localBitmap = c.jK(paramString);
      if (localBitmap != null)
      {
        paramIconPreference.drawable = new BitmapDrawable(this.mController.uMN.getResources(), localBitmap);
        return;
      }
    } while (bk.bl(paramString));
    o.OM().a(paramString, new WalletSecuritySettingUI.5(this, paramIconPreference));
  }
  
  private void aj(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
      onError(getString(a.i.wallet_security_info_get_error));
      return;
    }
    for (;;)
    {
      try
      {
        this.dnn = this.vdd;
        localObject = paramJSONObject.getString("more_security_title");
        this.qpV = this.dnn.add("wallet_security_more_title");
        this.qpV.setTitle((CharSequence)localObject);
        if (paramJSONObject.has("basic_security_item"))
        {
          localObject = paramJSONObject.getJSONObject("basic_security_item");
          this.qpW = new WalletSecuritySettingUI.a(this, (byte)0);
          this.qpW.title = ((JSONObject)localObject).optString("title");
          this.qpW.desc = ((JSONObject)localObject).optString("desc");
          this.qpW.mEi = ((JSONObject)localObject).optString("logo_url");
        }
        if (paramJSONObject.has("wallet_lock_info"))
        {
          localObject = paramJSONObject.getJSONObject("wallet_lock_info");
          this.qpX = new d((byte)0);
          this.qpX.title = ((JSONObject)localObject).optString("wallet_lock_title");
          this.qpX.desc = ((JSONObject)localObject).optString("wallet_lock_desc");
          this.qpX.mEi = ((JSONObject)localObject).getString("wallet_lock_logo_url");
          this.qpX.status = ((JSONObject)localObject).optInt("wallet_lock_status");
          this.qpX.qql = ((JSONObject)localObject).optString("wallet_lock_status_name");
          this.qpX.qqm = ((JSONObject)localObject).optBoolean("is_open_touch_pay", false);
        }
        if (paramJSONObject.has("property_security_info"))
        {
          localObject = paramJSONObject.getJSONObject("property_security_info");
          this.qpY = new WalletSecuritySettingUI.c(this, (byte)0);
          this.qpY.title = ((JSONObject)localObject).optString("title", "");
          this.qpY.desc = ((JSONObject)localObject).optString("desc", "");
          this.qpY.mEi = ((JSONObject)localObject).optString("logo_url", "");
          this.qpY.status = ((JSONObject)localObject).optInt("status", 0);
          this.qpY.qqj = ((JSONObject)localObject).optString("status_name");
          this.qpY.jumpType = ((JSONObject)localObject).optInt("jump_type");
          this.qpY.qqd = ((JSONObject)localObject).optString("jump_h5_url");
          this.qpY.qqk = ((JSONObject)localObject).optString("tinyapp_username");
          this.qpY.qqe = ((JSONObject)localObject).optString("tinyapp_path");
        }
        if (paramJSONObject.has("safe_manager_info"))
        {
          localObject = paramJSONObject.getJSONObject("safe_manager_info");
          this.qpZ = new b(this);
          this.qpZ.title = ((JSONObject)localObject).optString("title", "");
          this.qpZ.desc = ((JSONObject)localObject).optString("desc", "");
          this.qpZ.mEi = ((JSONObject)localObject).optString("logo_url", "");
          this.qpZ.qqh = ((JSONObject)localObject).optString("installed_status_name");
          this.qpZ.qqg = ((JSONObject)localObject).optString("uninstall_status_name");
          this.qpZ.qqi = ((JSONObject)localObject).optString("protected_mode_name");
          this.qpZ.qqd = ((JSONObject)localObject).optString("jump_h5_url");
        }
        com.tencent.mm.wallet_core.c.y.cMH().aC(paramJSONObject);
        g.DQ();
        g.DP().Dz().c(ac.a.uxU, paramJSONObject.toString());
        this.qpQ = ((WalletSecuritySettingHeaderPref)this.dnn.add("wallet_security_basic_info"));
        if (this.qpW != null)
        {
          paramJSONObject = this.qpQ;
          localObject = this.qpW.title;
          String str1 = this.qpW.desc;
          String str2 = this.qpW.qqf;
          paramJSONObject.jRT = ((String)localObject);
          paramJSONObject.qpL = str1;
          paramJSONObject.qpM = str2;
          paramJSONObject.aZ();
          if (bk.bl(this.qpW.qqf))
          {
            paramJSONObject = this.qpQ;
            if (paramJSONObject.qpK != null) {
              paramJSONObject.qpK.setVisibility(8);
            }
          }
        }
        if (this.qpX != null) {
          continue;
        }
        this.dnn.bJ("wallet_security_wallet_lock", true);
        this.dnn.bJ("wallet_security_digital_certificate", false);
        this.qpR = ((IconPreference)this.dnn.add("wallet_security_digital_certificate"));
        com.tencent.mm.wallet_core.c.y.cMH();
        g.DQ();
        if (((Integer)g.DP().Dz().get(ac.a.utC, Integer.valueOf(0))).intValue() <= 0) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", paramJSONObject, "", new Object[0]);
        onError(getString(a.i.wallet_security_info_get_error));
        continue;
        int i = 0;
        continue;
        if (!com.tencent.mm.wallet_core.c.y.cMH().cMI()) {
          continue;
        }
        if (this.qpR == null) {
          continue;
        }
        this.qpR.setSummary(a.i.wallet_security_status_installed);
        a(com.tencent.mm.wallet_core.c.y.cMH().wAV, this.qpR);
        this.qpR.setTitle(com.tencent.mm.wallet_core.c.y.cMH().wAT);
        this.qpR.setSummary(com.tencent.mm.wallet_core.c.y.cMH().wAU);
        this.qpR.setDesc(com.tencent.mm.wallet_core.c.y.cMH().wAS);
        this.qpR.cBu();
        continue;
        if (this.qpR == null) {
          continue;
        }
        this.qpR.setSummary(a.i.wallet_security_status_uninstalled);
        continue;
        a(this.qpZ.mEi, this.qpS);
        this.qpS.setTitle(this.qpZ.title);
        Object localObject = this.qpS;
        paramJSONObject = this.qpZ;
        if (paramJSONObject.status != 0) {
          continue;
        }
        paramJSONObject = paramJSONObject.qqg;
        ((IconPreference)localObject).setSummary(paramJSONObject);
        this.qpS.setDesc(this.qpZ.desc);
        this.qpS.cBu();
        continue;
        if (paramJSONObject.status != 1) {
          continue;
        }
        paramJSONObject = paramJSONObject.qqh;
        continue;
        paramJSONObject = paramJSONObject.qqi;
        continue;
        a(this.qpY.mEi, this.qpU);
        this.qpU.setTitle(this.qpY.title);
        this.qpU.setSummary(this.qpY.qqj);
        this.qpU.setDesc(this.qpY.desc);
        this.qpU.cBu();
        continue;
      }
      if (i != 0) {
        continue;
      }
      this.dnn.bJ("wallet_security_digital_certificate", true);
      this.dnn.bJ("wallet_security_pay_guard", false);
      this.qpS = ((IconPreference)this.dnn.add("wallet_security_pay_guard"));
      if (this.qpS != null) {
        this.qpS.setSummary(a.i.wallet_security_status_uninstalled);
      }
      if (this.qpZ != null) {
        continue;
      }
      this.dnn.bJ("wallet_security_pay_guard", true);
      this.dnn = this.vdd;
      this.dnn.bJ("wallet_security_safety_insurance", false);
      this.qpU = ((IconPreference)this.dnn.add("wallet_security_safety_insurance"));
      if (this.qpU != null) {
        this.qpU.setSummary(a.i.wallet_security_status_unopened);
      }
      if (this.qpY != null) {
        continue;
      }
      this.dnn.bJ("wallet_security_safety_insurance", true);
      this.dnn.notifyDataSetChanged();
      if ((this.qqa == null) || (!this.qqa.isShowing())) {
        break;
      }
      this.qqa.dismiss();
      return;
      this.dnn.bJ("wallet_security_wallet_lock", false);
      this.qpT = ((IconPreference)this.dnn.add("wallet_security_wallet_lock"));
      a(this.qpX.mEi, this.qpT);
      this.qpT.setTitle(this.qpX.title);
      this.qpT.setSummary(this.qpX.qql);
      this.qpT.setDesc(this.qpX.desc);
      this.qpT.cBu();
    }
  }
  
  private void onError(String paramString)
  {
    if ((this.qqa != null) && (this.qqa.isShowing())) {
      this.qqa.dismiss();
    }
    h.a(this, paramString, "", false, new WalletSecuritySettingUI.4(this));
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool = false;
    if ("wallet_security_digital_certificate".equals(paramPreference.mKey))
    {
      paramf = new aa();
      paramf.ckr = 12L;
      paramf.cks = 1L;
      paramf.QX();
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
      bool = true;
    }
    do
    {
      return bool;
      if ("wallet_security_pay_guard".equals(paramPreference.mKey))
      {
        if (this.qpZ == null) {
          return true;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[] { this.qpZ.getUrl() });
        com.tencent.mm.wallet_core.ui.e.bH(this, this.qpZ.getUrl());
        return true;
      }
      if ("wallet_security_wallet_lock".equals(paramPreference.mKey))
      {
        paramf = new Intent();
        ((com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, paramf);
        return true;
      }
    } while (!"wallet_security_safety_insurance".equals(paramPreference.mKey));
    if (this.qpY == null) {
      return true;
    }
    paramf = new aa();
    paramf.ckr = 15L;
    paramf.cks = 1L;
    paramf.QX();
    if (this.qpY.jumpType == 2)
    {
      paramf = new rc();
      paramf.caq.cau = 0;
      paramf.caq.userName = this.qpY.qqk;
      paramf.caq.cas = this.qpY.qqe;
      a.udP.m(paramf);
    }
    for (;;)
    {
      return true;
      paramf = new Intent();
      paramf.putExtra("rawUrl", this.qpY.qqd);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[] { paramf.getStringExtra("rawUrl") });
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
    }
  }
  
  protected final void initView()
  {
    super.initView();
    this.dnn = this.vdd;
    if (this.dnn != null) {
      this.dnn.addPreferencesFromResource(a.l.wallet_security_setting_pref);
    }
    g.DQ();
    String str = (String)g.DP().Dz().get(ac.a.uxU, "");
    if (!bk.bl(str)) {}
    try
    {
      aj(new JSONObject(str));
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", localException, "", new Object[0]);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.drX = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    paramBundle = new aa();
    paramBundle.ckr = 11L;
    paramBundle.cks = 1L;
    paramBundle.ckt = this.drX;
    paramBundle.QX();
    initView();
    setBackBtn(new WalletSecuritySettingUI.1(this));
    if (com.tencent.mm.compatible.util.d.gF(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
      czk();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    g.DQ();
    g.DO().dJT.b(385, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.qpQ = ((WalletSecuritySettingHeaderPref)this.dnn.add("wallet_security_basic_info"));
    Object localObject2;
    if (this.qpQ != null)
    {
      localObject1 = this.qpQ;
      localObject2 = new WalletSecuritySettingUI.2(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).qpK != null) {
        break label285;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).qpN = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).qpK != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).qpK.setOnClickListener((View.OnClickListener)localObject2);
      }
      localObject1 = this.qpQ;
      localObject2 = new WalletSecuritySettingUI.3(this);
      if (((WalletSecuritySettingHeaderPref)localObject1).hJw != null) {
        break label290;
      }
      bool = true;
      label116:
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", new Object[] { Boolean.valueOf(bool) });
      ((WalletSecuritySettingHeaderPref)localObject1).qpO = ((View.OnClickListener)localObject2);
      if (((WalletSecuritySettingHeaderPref)localObject1).hJw != null) {
        ((WalletSecuritySettingHeaderPref)localObject1).hJw.setOnClickListener((View.OnClickListener)localObject2);
      }
    }
    g.DQ();
    g.DO().dJT.a(385, this);
    if (this.qpP)
    {
      this.qqa = h.b(this, getString(a.i.app_waiting), false, null);
      this.qpP = false;
    }
    boolean bool = ((k)g.r(k.class)).aSw();
    Object localObject1 = ae.cqS();
    if (localObject1 != null)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("cpu_id", null);
      localObject1 = ((SharedPreferences)localObject1).getString("uid", null);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      g.Dk().a(new com.tencent.mm.plugin.wallet.pwd.a.e(bool, (String)localObject2, (String)localObject1), 0);
      return;
      label285:
      bool = false;
      break;
      label290:
      bool = false;
      break label116;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.e))
    {
      paramString = ((com.tencent.mm.plugin.wallet.pwd.a.e)paramm).qop;
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[] { paramString });
      aj(paramString);
    }
  }
  
  public final int xj()
  {
    return -1;
  }
  
  private final class b
  {
    String desc;
    String mEi;
    String qqd;
    String qqg;
    String qqh;
    String qqi;
    int status;
    String title;
    
    b(Context paramContext)
    {
      if (com.tencent.mm.pluginsdk.model.app.p.o(paramContext, "com.tencent.qqpimsecure"))
      {
        if (bk.bt(paramContext, "com.tencent.server.back.BackEngine"))
        {
          this.status = 2;
          return;
        }
        this.status = 1;
        return;
      }
      this.status = 0;
    }
    
    private String fj(String paramString1, String paramString2)
    {
      return Uri.parse(this.qqd).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
    }
    
    public final String getUrl()
    {
      if (this.status == 0) {
        return fj("qqpimsecurestatus", "not_installed");
      }
      if (this.status == 1) {
        return fj("qqpimsecurestatus", "not_run");
      }
      return fj("qqpimsecurestatus", "runing");
    }
  }
  
  private final class d
  {
    String desc;
    String mEi;
    String qql;
    boolean qqm;
    int status;
    String title;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI
 * JD-Core Version:    0.7.0.1
 */