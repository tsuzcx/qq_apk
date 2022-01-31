package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import com.tencent.mm.y.c;
import junit.framework.Assert;

public class SettingsMoreSafeUI
  extends MMPreference
  implements com.tencent.mm.ah.f, m.b
{
  private ProgressDialog dnm;
  private com.tencent.mm.ui.base.preference.f dnn;
  private SparseIntArray nTG = new SparseIntArray();
  private String nVe = null;
  private String nVf;
  
  public SettingsMoreSafeUI()
  {
    this.nTG.put(0, a.i.settings_confirm_email_success_tip);
    this.nTG.put(-82, a.i.setting_unbind_qq_err_one_left);
    this.nTG.put(-83, a.i.setting_unbind_qq_err_has_unbind);
    this.nTG.put(-84, a.i.setting_unbind_qq_err_hasbinded);
    this.nTG.put(-85, a.i.setting_unbind_email_err_bindedbyother);
    this.nTG.put(-86, a.i.setting_unbind_qq_err_qmail);
  }
  
  private void bze()
  {
    Preference localPreference = this.dnn.add("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.g.DP().Dz().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.setSummary(a.i.settings_email_addr_verified);
      return;
    }
    if (str != null)
    {
      localPreference.setSummary(a.i.settings_email_addr_not_verified);
      return;
    }
    localPreference.setSummary(a.i.setting_unbind);
  }
  
  private void bzf()
  {
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.dnn.add("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      return;
    }
    if (com.tencent.mm.sdk.platformtools.e.cqq())
    {
      this.dnn.bJ("settings_phone_security", true);
      return;
    }
    if (c.BS().a(ac.a.uyT))
    {
      localIconSwitchKeyValuePreference.Gv(0);
      return;
    }
    localIconSwitchKeyValuePreference.Gv(8);
  }
  
  private void bzg()
  {
    Preference localPreference = this.dnn.add("settings_facebook");
    if (localPreference == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      return;
    }
    if (!q.GI())
    {
      this.dnn.c(localPreference);
      return;
    }
    if (!q.GL())
    {
      localPreference.setSummary(getString(a.i.settings_bind_qq_unbind));
      return;
    }
    localPreference.setSummary((String)com.tencent.mm.kernel.g.DP().Dz().get(65826, null));
  }
  
  private void bzh()
  {
    Preference localPreference = this.dnn.add("settings_bind_qq");
    if (localPreference == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("BindQQSwitch"), 1) != 1)
      {
        this.dnn.bJ("settings_uin", true);
        return;
      }
      localPreference.setSummary(a.i.settings_bind_qq_unbind);
      return;
    }
    localPreference.setSummary(new o(i));
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    bzh();
    bze();
    bzg();
    bzf();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsMoreSafeUI", paramf + " item has been clicked!");
    if (bk.bl(paramf)) {}
    label460:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramf.equals("settings_facebook"))
          {
            Y(FacebookAuthUI.class);
            return false;
          }
          int i;
          if (paramf.equals("settings_email_addr"))
          {
            paramf = (Integer)com.tencent.mm.kernel.g.DP().Dz().get(7, null);
            i = j;
            if (paramf != null)
            {
              i = j;
              if ((paramf.intValue() & 0x2) != 0) {
                i = 1;
              }
            }
            paramf = (String)com.tencent.mm.kernel.g.DP().Dz().get(5, null);
            if ((i != 0) || (!bk.bl(paramf))) {
              startActivity(new Intent(this.mController.uMN, SettingsModifyEmailAddrUI.class));
            }
            for (;;)
            {
              return true;
              if (this.dnm != null)
              {
                com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                this.dnm.dismiss();
                this.dnm = null;
              }
              paramf = bk.aM(w.bS(this.mController.uMN), "");
              com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.settings_modify_email_addr), paramf, getString(a.i.settings_modify_email_addr_warning), 50, new SettingsMoreSafeUI.2(this));
            }
          }
          if (paramf.equals("settings_bind_qq"))
          {
            b.eUR.h(new Intent(), this);
            return true;
          }
          if (paramf.equals("settings_phone_security"))
          {
            Intent localIntent = new Intent();
            if (c.BS().a(ac.a.uyT))
            {
              i = 1;
              c.BS().b(ac.a.uyT, false);
              ((IconPreference)paramPreference).Gv(8);
              j = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyV, Integer.valueOf(0))).intValue();
              com.tencent.mm.plugin.report.service.h.nFQ.f(10939, new Object[] { Integer.valueOf(j) });
              if (!bk.bt(this, "com.tencent.server.back.BackEngine")) {
                break label460;
              }
            }
            for (paramf = getString(a.i.qqpimsecure_jump_url, new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });; paramf = getString(a.i.qqpimsecure_jump_url, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) }))
            {
              localIntent.putExtra("rawUrl", paramf);
              localIntent.putExtra("show_bottom", false);
              localIntent.putExtra("showShare", false);
              d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
              return false;
              i = 0;
              break;
            }
          }
          if (!paramf.equals("settings_delete_account")) {
            break;
          }
          paramf = new Intent();
        } while (bk.bl(this.nVe));
        paramf.putExtra("rawUrl", this.nVe + "&lang=" + x.fB(this.mController.uMN));
        paramf.putExtra("showShare", true);
        paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
        d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramf, 2);
        return false;
      } while (!paramf.equals("settings_dump_personal_data"));
      paramf = new Intent();
    } while (bk.bl(this.nVf));
    paramf.putExtra("rawUrl", this.nVf);
    paramf.putExtra("showShare", false);
    paramf.putExtra("needRedirect", false);
    paramf.putExtra("neverGetA8Key", false);
    paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramf);
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_more_safe);
    this.dnn = this.vdd;
    if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(9, Integer.valueOf(0))).intValue() == 0) {
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("BindQQSwitch"), 1) != 1)
      {
        this.dnn.bJ("settings_uin", true);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.nVe = com.tencent.mm.m.g.AA().getValue("CloseAcctUrl");
      setBackBtn(new SettingsMoreSafeUI.1(this));
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {}
    switch (paramInt2)
    {
    default: 
      return;
    }
    if ((com.tencent.mm.kernel.g.Dk() != null) && (com.tencent.mm.kernel.g.Dk().edx != null)) {
      com.tencent.mm.kernel.g.Dk().edx.bP(false);
    }
    b.eUS.tq();
    com.tencent.mm.kernel.g.DP().Dz().b(this);
    paramIntent = new jf();
    paramIntent.bRC.status = 0;
    paramIntent.bRC.aQw = 3;
    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
    paramIntent = new com.tencent.mm.h.a.y();
    paramIntent.bFX.bFY = true;
    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
    ag.Zn("show_whatsnew");
    com.tencent.mm.kernel.l.k(this, true);
    paramIntent = new Intent();
    paramIntent.addFlags(67108864);
    paramIntent.putExtra("Intro_Switch", true);
    b.eUR.q(paramIntent, this.mController.uMN);
    w.E(this, null);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.Dk().a(256, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(256, this);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    bzh();
    bze();
    bzg();
    Object localObject = com.tencent.mm.m.g.AA().getValue("ShowExportUserDataEntry");
    if (!bk.bl((String)localObject)) {
      this.nVf = ((String)localObject);
    }
    for (;;)
    {
      bzf();
      localObject = this.dnn.add("settings_about_domainmail");
      this.dnn.c((Preference)localObject);
      if (bk.bl(this.nVe))
      {
        localObject = this.dnn.add("settings_delete_account");
        this.dnn.c((Preference)localObject);
      }
      super.onResume();
      return;
      this.nVf = "";
      this.dnn.bJ("settings_dump_personal_data", true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramm.getType() != 256) || (((paramInt1 != 0) || (paramInt2 != 0)) && (b.eUS.a(this, paramInt1, paramInt2, paramString)))) {
      return;
    }
    int i = this.nTG.get(paramInt2);
    paramm = getString(a.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = paramm;
    if (i != 0) {}
    try
    {
      paramString = getString(i);
      com.tencent.mm.ui.base.h.bC(this.mController.uMN, paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[] { Integer.valueOf(i), paramString.getMessage() });
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", paramString, "", new Object[0]);
        paramString = paramm;
      }
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref_more_safe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI
 * JD-Core Version:    0.7.0.1
 */