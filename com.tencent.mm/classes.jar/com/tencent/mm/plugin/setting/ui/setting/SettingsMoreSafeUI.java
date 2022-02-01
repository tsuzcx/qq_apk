package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class SettingsMoreSafeUI
  extends MMPreference
  implements com.tencent.mm.ak.f, n.b
{
  private ProgressDialog fOC;
  private com.tencent.mm.ui.base.preference.f screen;
  private SparseIntArray yWl;
  private String yYq;
  private String yYr;
  
  public SettingsMoreSafeUI()
  {
    AppMethodBeat.i(74264);
    this.yYq = null;
    this.yWl = new SparseIntArray();
    this.yWl.put(0, 2131763202);
    this.yWl.put(-82, 2131763138);
    this.yWl.put(-83, 2131763135);
    this.yWl.put(-84, 2131763136);
    this.yWl.put(-85, 2131763129);
    this.yWl.put(-86, 2131763140);
    AppMethodBeat.o(74264);
  }
  
  private void dRi()
  {
    AppMethodBeat.i(74271);
    Preference localPreference = this.screen.aXe("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.setSummary(2131763211);
      AppMethodBeat.o(74271);
      return;
    }
    if (str != null)
    {
      localPreference.setSummary(2131763210);
      AppMethodBeat.o(74271);
      return;
    }
    localPreference.setSummary(2131763128);
    AppMethodBeat.o(74271);
  }
  
  private void dRj()
  {
    AppMethodBeat.i(74273);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.aXe("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      ae.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      AppMethodBeat.o(74273);
      return;
    }
    if (k.fnT())
    {
      this.screen.cT("settings_phone_security", true);
      AppMethodBeat.o(74273);
      return;
    }
    if (com.tencent.mm.y.c.ahI().a(am.a.IXJ))
    {
      localIconSwitchKeyValuePreference.acU(0);
      AppMethodBeat.o(74273);
      return;
    }
    localIconSwitchKeyValuePreference.acU(8);
    AppMethodBeat.o(74273);
  }
  
  private void dRk()
  {
    AppMethodBeat.i(74274);
    Preference localPreference = this.screen.aXe("settings_facebook");
    if (localPreference == null)
    {
      ae.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      AppMethodBeat.o(74274);
      return;
    }
    if (!v.aBf())
    {
      this.screen.d(localPreference);
      AppMethodBeat.o(74274);
      return;
    }
    if (!v.aBi())
    {
      localPreference.setSummary(getString(2131763187));
      AppMethodBeat.o(74274);
      return;
    }
    localPreference.setSummary((String)com.tencent.mm.kernel.g.ajR().ajA().get(65826, null));
    AppMethodBeat.o(74274);
  }
  
  private void dRl()
  {
    AppMethodBeat.i(74275);
    Preference localPreference = this.screen.aXe("settings_bind_qq");
    if (localPreference == null)
    {
      ae.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      AppMethodBeat.o(74275);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ae.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.cT("settings_uin", true);
        AppMethodBeat.o(74275);
        return;
      }
      localPreference.setSummary(2131763187);
      AppMethodBeat.o(74275);
      return;
    }
    localPreference.setSummary(new p(i));
    AppMethodBeat.o(74275);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74272);
    dRl();
    dRi();
    dRk();
    dRj();
    AppMethodBeat.o(74272);
  }
  
  public int getResourceId()
  {
    return 2131951728;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74267);
    setMMTitle(2131763306);
    this.screen = getPreferenceScreen();
    if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(9, Integer.valueOf(0))).intValue() == 0) {
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.cT("settings_uin", true);
        ae.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.yYq = com.tencent.mm.n.g.acL().getValue("CloseAcctUrl");
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74261);
          SettingsMoreSafeUI.this.hideVKB();
          SettingsMoreSafeUI.this.finish();
          AppMethodBeat.o(74261);
          return true;
        }
      });
      AppMethodBeat.o(74267);
      return;
      ae.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74277);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74277);
      return;
      if ((com.tencent.mm.kernel.g.ajj() != null) && (com.tencent.mm.kernel.g.ajj().hRo != null)) {
        com.tencent.mm.kernel.g.ajj().hRo.eI(false);
      }
      paramIntent = new gz();
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      com.tencent.mm.plugin.setting.c.iUA.MS();
      com.tencent.mm.kernel.g.ajR().ajA().b(this);
      paramIntent = new lk();
      paramIntent.dzN.status = 0;
      paramIntent.dzN.reason = 3;
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      paramIntent = new ab();
      paramIntent.dlL.dlM = true;
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      ao.aRS("show_whatsnew");
      com.tencent.mm.kernel.l.q(this, true);
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      paramIntent.putExtra("Intro_Switch", true);
      com.tencent.mm.plugin.setting.c.iUz.p(paramIntent, getContext());
      t.J(this, null);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74265);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.ajj().a(256, this);
    AppMethodBeat.o(74265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74266);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(256, this);
    AppMethodBeat.o(74266);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74269);
    super.onPause();
    AppMethodBeat.o(74269);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74270);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.SettingsMoreSafeUI", paramf + " item has been clicked!");
    if (bu.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74270);
      return false;
    }
    if (paramf.equals("settings_facebook")) {
      startActivity(FacebookAuthUI.class);
    }
    for (;;)
    {
      AppMethodBeat.o(74270);
      return false;
      int i;
      if (paramf.equals("settings_email_addr"))
      {
        paramf = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(7, null);
        if ((paramf != null) && ((paramf.intValue() & 0x2) != 0))
        {
          i = 1;
          paramf = (String)com.tencent.mm.kernel.g.ajR().ajA().get(5, null);
          if ((i == 0) && (bu.isNullOrNil(paramf))) {
            break label241;
          }
          paramf = new Intent(getContext(), SettingsModifyEmailAddrUI.class);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(74270);
          return true;
          i = 0;
          break;
          label241:
          if (this.fOC != null)
          {
            ae.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
            this.fOC.dismiss();
            this.fOC = null;
          }
          paramf = bu.bI(t.dd(getContext()), "");
          h.a(getContext(), getString(2131763292), paramf, getString(2131763293), 50, new h.b()
          {
            public final boolean onFinish(final CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(74263);
              if (!bu.aSp(paramAnonymousCharSequence.toString()))
              {
                h.cm(SettingsMoreSafeUI.this.getContext(), SettingsMoreSafeUI.this.getString(2131764653));
                AppMethodBeat.o(74263);
                return false;
              }
              com.tencent.mm.plugin.setting.c.iUA.MM();
              paramAnonymousCharSequence = new com.tencent.mm.plugin.account.model.d(com.tencent.mm.plugin.account.model.d.jko, paramAnonymousCharSequence.toString());
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousCharSequence, 0);
              SettingsMoreSafeUI localSettingsMoreSafeUI = SettingsMoreSafeUI.this;
              AppCompatActivity localAppCompatActivity = SettingsMoreSafeUI.this.getContext();
              SettingsMoreSafeUI.this.getString(2131755906);
              SettingsMoreSafeUI.a(localSettingsMoreSafeUI, h.b(localAppCompatActivity, SettingsMoreSafeUI.this.getString(2131763188), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74262);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousCharSequence);
                  AppMethodBeat.o(74262);
                }
              }));
              AppMethodBeat.o(74263);
              return true;
            }
          });
        }
      }
      if (paramf.equals("settings_bind_qq"))
      {
        com.tencent.mm.plugin.setting.c.iUz.g(new Intent(), this);
        AppMethodBeat.o(74270);
        return true;
      }
      if (paramf.equals("settings_phone_security"))
      {
        Intent localIntent = new Intent();
        label383:
        int j;
        if (com.tencent.mm.y.c.ahI().a(am.a.IXJ))
        {
          i = 1;
          com.tencent.mm.y.c.ahI().b(am.a.IXJ, false);
          ((IconPreference)paramPreference).acU(8);
          j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXL, Integer.valueOf(0))).intValue();
          com.tencent.mm.plugin.report.service.g.yxI.f(10939, new Object[] { Integer.valueOf(j) });
          if (!bu.cd(this, "com.tencent.server.back.BackEngine")) {
            break label544;
          }
        }
        label544:
        for (paramf = getString(2131762083, new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });; paramf = getString(2131762083, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) }))
        {
          localIntent.putExtra("rawUrl", paramf);
          localIntent.putExtra("show_bottom", false);
          localIntent.putExtra("showShare", false);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          break;
          i = 0;
          break label383;
        }
      }
      if (paramf.equals("settings_delete_account"))
      {
        paramf = new Intent();
        if (!bu.isNullOrNil(this.yYq))
        {
          paramf.putExtra("rawUrl", this.yYq + "&lang=" + ad.iR(getContext()));
          paramf.putExtra("showShare", true);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf, 2);
        }
      }
      else if (paramf.equals("settings_dump_personal_data"))
      {
        paramf = new Intent();
        if (!bu.isNullOrNil(this.yYr))
        {
          paramf.putExtra("rawUrl", this.yYr);
          paramf.putExtra("showShare", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74268);
    dRl();
    dRi();
    dRk();
    Object localObject = com.tencent.mm.n.g.acL().getValue("ShowExportUserDataEntry");
    if (!bu.isNullOrNil((String)localObject)) {
      this.yYr = ((String)localObject);
    }
    for (;;)
    {
      dRj();
      localObject = this.screen.aXe("settings_about_domainmail");
      this.screen.d((Preference)localObject);
      if (bu.isNullOrNil(this.yYq))
      {
        localObject = this.screen.aXe("settings_delete_account");
        this.screen.d((Preference)localObject);
      }
      super.onResume();
      AppMethodBeat.o(74268);
      return;
      this.yYr = "";
      this.screen.cT("settings_dump_personal_data", true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(74276);
    ae.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramn.getType());
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    int i;
    if (paramn.getType() == 256)
    {
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (com.tencent.mm.plugin.setting.c.iUA.a(this, paramInt1, paramInt2, paramString)))
      {
        AppMethodBeat.o(74276);
        return;
      }
      i = this.yWl.get(paramInt2);
      paramn = getString(2131763201, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = paramn;
      if (i == 0) {}
    }
    try
    {
      paramString = getString(i);
      h.cm(getContext(), paramString);
      AppMethodBeat.o(74276);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[] { Integer.valueOf(i), paramString.getMessage() });
        ae.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", paramString, "", new Object[0]);
        paramString = paramn;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI
 * JD-Core Version:    0.7.0.1
 */