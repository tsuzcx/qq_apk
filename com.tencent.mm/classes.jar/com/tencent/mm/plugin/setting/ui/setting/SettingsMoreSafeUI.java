package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.c;
import junit.framework.Assert;

public class SettingsMoreSafeUI
  extends MMPreference
  implements com.tencent.mm.ai.f, n.b
{
  private ProgressDialog eeN;
  private SparseIntArray qHG;
  private String qJj;
  private String qJk;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsMoreSafeUI()
  {
    AppMethodBeat.i(127327);
    this.qJj = null;
    this.qHG = new SparseIntArray();
    this.qHG.put(0, 2131303234);
    this.qHG.put(-82, 2131303172);
    this.qHG.put(-83, 2131303169);
    this.qHG.put(-84, 2131303170);
    this.qHG.put(-85, 2131303163);
    this.qHG.put(-86, 2131303174);
    AppMethodBeat.o(127327);
  }
  
  private void cko()
  {
    AppMethodBeat.i(127334);
    Preference localPreference = this.screen.atx("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.g.RL().Ru().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.setSummary(2131303242);
      AppMethodBeat.o(127334);
      return;
    }
    if (str != null)
    {
      localPreference.setSummary(2131303241);
      AppMethodBeat.o(127334);
      return;
    }
    localPreference.setSummary(2131303162);
    AppMethodBeat.o(127334);
  }
  
  private void ckp()
  {
    AppMethodBeat.i(127336);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.atx("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      ab.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      AppMethodBeat.o(127336);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.g.dsn())
    {
      this.screen.cl("settings_phone_security", true);
      AppMethodBeat.o(127336);
      return;
    }
    if (c.PJ().a(ac.a.yJH))
    {
      localIconSwitchKeyValuePreference.ON(0);
      AppMethodBeat.o(127336);
      return;
    }
    localIconSwitchKeyValuePreference.ON(8);
    AppMethodBeat.o(127336);
  }
  
  private void ckq()
  {
    AppMethodBeat.i(127337);
    Preference localPreference = this.screen.atx("settings_facebook");
    if (localPreference == null)
    {
      ab.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      AppMethodBeat.o(127337);
      return;
    }
    if (!r.ZM())
    {
      this.screen.d(localPreference);
      AppMethodBeat.o(127337);
      return;
    }
    if (!r.ZP())
    {
      localPreference.setSummary(getString(2131303219));
      AppMethodBeat.o(127337);
      return;
    }
    localPreference.setSummary((String)com.tencent.mm.kernel.g.RL().Ru().get(65826, null));
    AppMethodBeat.o(127337);
  }
  
  private void ckr()
  {
    AppMethodBeat.i(127338);
    Preference localPreference = this.screen.atx("settings_bind_qq");
    if (localPreference == null)
    {
      ab.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      AppMethodBeat.o(127338);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ab.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.cl("settings_uin", true);
        AppMethodBeat.o(127338);
        return;
      }
      localPreference.setSummary(2131303219);
      AppMethodBeat.o(127338);
      return;
    }
    localPreference.setSummary(new com.tencent.mm.a.p(i));
    AppMethodBeat.o(127338);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(127335);
    ckr();
    cko();
    ckq();
    ckp();
    AppMethodBeat.o(127335);
  }
  
  public int getResourceId()
  {
    return 2131165284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127330);
    setMMTitle(2131303326);
    this.screen = getPreferenceScreen();
    if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(9, Integer.valueOf(0))).intValue() == 0) {
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.cl("settings_uin", true);
        ab.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.qJj = com.tencent.mm.m.g.Nq().getValue("CloseAcctUrl");
      setBackBtn(new SettingsMoreSafeUI.1(this));
      AppMethodBeat.o(127330);
      return;
      ab.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127340);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(127340);
      return;
      if ((com.tencent.mm.kernel.g.Rc() != null) && (com.tencent.mm.kernel.g.Rc().ftA != null)) {
        com.tencent.mm.kernel.g.Rc().ftA.cR(false);
      }
      paramIntent = new gk();
      com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      b.gmP.BU();
      com.tencent.mm.kernel.g.RL().Ru().b(this);
      paramIntent = new jo();
      paramIntent.cze.status = 0;
      paramIntent.cze.aXG = 3;
      com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      paramIntent = new y();
      paramIntent.cne.cnf = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      aj.apl("show_whatsnew");
      l.n(this, true);
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      paramIntent.putExtra("Intro_Switch", true);
      b.gmO.p(paramIntent, getContext());
      w.I(this, null);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127328);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.Rc().a(256, this);
    AppMethodBeat.o(127328);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127329);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(256, this);
    AppMethodBeat.o(127329);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127332);
    super.onPause();
    AppMethodBeat.o(127332);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(127333);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.SettingsMoreSafeUI", paramf + " item has been clicked!");
    if (bo.isNullOrNil(paramf))
    {
      AppMethodBeat.o(127333);
      return false;
    }
    if (paramf.equals("settings_facebook")) {
      startActivity(FacebookAuthUI.class);
    }
    for (;;)
    {
      AppMethodBeat.o(127333);
      return false;
      int i;
      if (paramf.equals("settings_email_addr"))
      {
        paramf = (Integer)com.tencent.mm.kernel.g.RL().Ru().get(7, null);
        i = j;
        if (paramf != null)
        {
          i = j;
          if ((paramf.intValue() & 0x2) != 0) {
            i = 1;
          }
        }
        paramf = (String)com.tencent.mm.kernel.g.RL().Ru().get(5, null);
        if ((i != 0) || (!bo.isNullOrNil(paramf))) {
          startActivity(new Intent(getContext(), SettingsModifyEmailAddrUI.class));
        }
        for (;;)
        {
          AppMethodBeat.o(127333);
          return true;
          if (this.eeN != null)
          {
            ab.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
            this.eeN.dismiss();
            this.eeN = null;
          }
          paramf = bo.bf(w.cz(getContext()), "");
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131303312), paramf, getString(2131303313), 50, new SettingsMoreSafeUI.2(this));
        }
      }
      if (paramf.equals("settings_bind_qq"))
      {
        b.gmO.g(new Intent(), this);
        AppMethodBeat.o(127333);
        return true;
      }
      if (paramf.equals("settings_phone_security"))
      {
        Intent localIntent = new Intent();
        if (c.PJ().a(ac.a.yJH))
        {
          i = 1;
          label318:
          c.PJ().b(ac.a.yJH, false);
          ((IconPreference)paramPreference).ON(8);
          j = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJJ, Integer.valueOf(0))).intValue();
          com.tencent.mm.plugin.report.service.h.qsU.e(10939, new Object[] { Integer.valueOf(j) });
          if (!bo.bG(this, "com.tencent.server.back.BackEngine")) {
            break label479;
          }
        }
        label479:
        for (paramf = getString(2131306208, new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });; paramf = getString(2131306208, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) }))
        {
          localIntent.putExtra("rawUrl", paramf);
          localIntent.putExtra("show_bottom", false);
          localIntent.putExtra("showShare", false);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          break;
          i = 0;
          break label318;
        }
      }
      if (paramf.equals("settings_delete_account"))
      {
        paramf = new Intent();
        if (!bo.isNullOrNil(this.qJj))
        {
          paramf.putExtra("rawUrl", this.qJj + "&lang=" + aa.gP(getContext()));
          paramf.putExtra("showShare", true);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf, 2);
        }
      }
      else if (paramf.equals("settings_dump_personal_data"))
      {
        paramf = new Intent();
        if (!bo.isNullOrNil(this.qJk))
        {
          paramf.putExtra("rawUrl", this.qJk);
          paramf.putExtra("showShare", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127331);
    ckr();
    cko();
    ckq();
    Object localObject = com.tencent.mm.m.g.Nq().getValue("ShowExportUserDataEntry");
    if (!bo.isNullOrNil((String)localObject)) {
      this.qJk = ((String)localObject);
    }
    for (;;)
    {
      ckp();
      localObject = this.screen.atx("settings_about_domainmail");
      this.screen.d((Preference)localObject);
      if (bo.isNullOrNil(this.qJj))
      {
        localObject = this.screen.atx("settings_delete_account");
        this.screen.d((Preference)localObject);
      }
      super.onResume();
      AppMethodBeat.o(127331);
      return;
      this.qJk = "";
      this.screen.cl("settings_dump_personal_data", true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(127339);
    ab.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    int i;
    if (paramm.getType() == 256)
    {
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (b.gmP.a(this, paramInt1, paramInt2, paramString)))
      {
        AppMethodBeat.o(127339);
        return;
      }
      i = this.qHG.get(paramInt2);
      paramm = getString(2131303233, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = paramm;
      if (i == 0) {}
    }
    try
    {
      paramString = getString(i);
      com.tencent.mm.ui.base.h.bO(getContext(), paramString);
      AppMethodBeat.o(127339);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[] { Integer.valueOf(i), paramString.getMessage() });
        ab.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", paramString, "", new Object[0]);
        paramString = paramm;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI
 * JD-Core Version:    0.7.0.1
 */