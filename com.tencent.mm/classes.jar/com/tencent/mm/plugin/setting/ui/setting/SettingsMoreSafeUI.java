package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ah;
import com.tencent.mm.autogen.a.hv;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.model.e;
import com.tencent.mm.plugin.account.ui.MMFBAuthUI;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class SettingsMoreSafeUI
  extends MMPreference
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange
{
  private SparseIntArray Prt;
  private String PuQ;
  private String PuR;
  private ProgressDialog lzP;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsMoreSafeUI()
  {
    AppMethodBeat.i(74264);
    this.PuQ = null;
    this.Prt = new SparseIntArray();
    this.Prt.put(0, b.i.settings_confirm_email_success_tip);
    this.Prt.put(-82, b.i.setting_unbind_qq_err_one_left);
    this.Prt.put(-83, b.i.setting_unbind_qq_err_has_unbind);
    this.Prt.put(-84, b.i.setting_unbind_qq_err_hasbinded);
    this.Prt.put(-85, b.i.setting_unbind_email_err_bindedbyother);
    this.Prt.put(-86, b.i.setting_unbind_qq_err_qmail);
    AppMethodBeat.o(74264);
  }
  
  private void dNn()
  {
    AppMethodBeat.i(298864);
    if (ignoreSecondCalled())
    {
      AppMethodBeat.o(298864);
      return;
    }
    gVU();
    gVR();
    gVT();
    gVV();
    gVS();
    Preference localPreference = this.screen.bAi("settings_about_domainmail");
    this.screen.e(localPreference);
    if (Util.isNullOrNil(this.PuQ))
    {
      localPreference = this.screen.bAi("settings_delete_account");
      this.screen.e(localPreference);
    }
    AppMethodBeat.o(298864);
  }
  
  private void gVR()
  {
    AppMethodBeat.i(74271);
    Preference localPreference = this.screen.bAi("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.baE().ban().d(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.aBk(b.i.settings_email_addr_verified);
      AppMethodBeat.o(74271);
      return;
    }
    if (str != null)
    {
      localPreference.aBk(b.i.settings_email_addr_not_verified);
      AppMethodBeat.o(74271);
      return;
    }
    localPreference.aBk(b.i.setting_unbind);
    AppMethodBeat.o(74271);
  }
  
  private void gVS()
  {
    AppMethodBeat.i(74273);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.bAi("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      AppMethodBeat.o(74273);
      return;
    }
    if ((ChannelUtil.isGPVersion()) || (ab.bBX()))
    {
      this.screen.eh("settings_phone_security", true);
      AppMethodBeat.o(74273);
      return;
    }
    if (com.tencent.mm.aa.c.aYo().a(at.a.acWf))
    {
      localIconSwitchKeyValuePreference.aeD(0);
      AppMethodBeat.o(74273);
      return;
    }
    localIconSwitchKeyValuePreference.aeD(8);
    AppMethodBeat.o(74273);
  }
  
  private void gVT()
  {
    AppMethodBeat.i(74274);
    Preference localPreference = this.screen.bAi("settings_facebook");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      AppMethodBeat.o(74274);
      return;
    }
    if ((WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned()) || (!z.bBw()))
    {
      this.screen.e(localPreference);
      AppMethodBeat.o(74274);
      return;
    }
    if (!z.bBz())
    {
      localPreference.aS(getString(b.i.settings_bind_qq_unbind));
      AppMethodBeat.o(74274);
      return;
    }
    localPreference.aS((String)com.tencent.mm.kernel.h.baE().ban().d(65826, null));
    AppMethodBeat.o(74274);
  }
  
  private void gVU()
  {
    AppMethodBeat.i(74275);
    Preference localPreference = this.screen.bAi("settings_bind_qq");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      AppMethodBeat.o(74275);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      Log.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (Util.getInt(i.aRC().getValue("BindQQSwitch"), 1) != 1) {
        this.screen.eh("settings_uin", true);
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetSecurityQQ.banned()) {
        this.screen.e(localPreference);
      }
      AppMethodBeat.o(74275);
      return;
      localPreference.aBk(b.i.settings_bind_qq_unbind);
      continue;
      localPreference.aS(new com.tencent.mm.b.p(i));
    }
  }
  
  private void gVV()
  {
    AppMethodBeat.i(298887);
    String str = i.aRC().getValue("ShowExportUserDataEntry");
    if (!Util.isNullOrNil(str))
    {
      this.PuR = str;
      AppMethodBeat.o(298887);
      return;
    }
    this.PuR = "";
    this.screen.eh("settings_dump_personal_data", true);
    AppMethodBeat.o(298887);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_more_safe;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74267);
    setMMTitle(b.i.settings_more_safe);
    this.screen = getPreferenceScreen();
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, Integer.valueOf(0))).intValue() == 0) {
      if (Util.getInt(i.aRC().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.eh("settings_uin", true);
        Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.PuQ = i.aRC().getValue("CloseAcctUrl");
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
      Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
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
      if ((com.tencent.mm.kernel.h.aZW() != null) && (com.tencent.mm.kernel.h.aZW().oun != null)) {
        com.tencent.mm.kernel.h.aZW().oun.hb(false);
      }
      new hv().publish();
      com.tencent.mm.plugin.setting.c.pFo.aDD();
      com.tencent.mm.kernel.h.baE().ban().remove(this);
      paramIntent = new ny();
      paramIntent.hQx.status = 0;
      paramIntent.hQx.reason = 3;
      paramIntent.publish();
      paramIntent = new ah();
      paramIntent.hAc.hAd = true;
      paramIntent.publish();
      MMEntryLock.unlock("show_whatsnew");
      n.w(this, true);
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      paramIntent.putExtra("Intro_Switch", true);
      com.tencent.mm.plugin.setting.c.pFn.n(paramIntent, getContext());
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74265);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.h.aZW().a(256, this);
    dNn();
    AppMethodBeat.o(74265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74266);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(256, this);
    AppMethodBeat.o(74266);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74272);
    gVU();
    gVR();
    gVT();
    gVS();
    AppMethodBeat.o(74272);
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
    Log.i("MicroMsg.SettingsMoreSafeUI", paramf + " item has been clicked!");
    if (Util.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74270);
      return false;
    }
    if (paramf.equals("settings_facebook"))
    {
      if (WeChatBrands.Business.Entries.MeSetSecurityFacebook.checkAvailable(this)) {
        startActivity(MMFBAuthUI.class);
      }
      AppMethodBeat.o(74270);
      return true;
    }
    int i;
    if (paramf.equals("settings_email_addr"))
    {
      paramf = (Integer)com.tencent.mm.kernel.h.baE().ban().d(7, null);
      if ((paramf != null) && ((paramf.intValue() & 0x2) != 0))
      {
        i = 1;
        paramf = (String)com.tencent.mm.kernel.h.baE().ban().d(5, null);
        if ((i == 0) && (Util.isNullOrNil(paramf))) {
          break label251;
        }
        paramf = new Intent(getContext(), SettingsModifyEmailAddrUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(74270);
        return true;
        i = 0;
        break;
        label251:
        if (this.lzP != null)
        {
          Log.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
          this.lzP.dismiss();
          this.lzP = null;
        }
        k.a(getContext(), getString(b.i.settings_modify_email_addr), "", getString(b.i.settings_modify_email_addr_warning), 50, new k.b()
        {
          public final boolean onFinish(final CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(74263);
            if (!Util.isValidEmail(paramAnonymousCharSequence.toString()))
            {
              k.cZ(SettingsMoreSafeUI.this.getContext(), SettingsMoreSafeUI.this.getString(b.i.verify_email_err_tip));
              AppMethodBeat.o(74263);
              return false;
            }
            com.tencent.mm.plugin.setting.c.pFo.aDx();
            paramAnonymousCharSequence = new e(e.pWA, paramAnonymousCharSequence.toString());
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousCharSequence, 0);
            SettingsMoreSafeUI localSettingsMoreSafeUI = SettingsMoreSafeUI.this;
            AppCompatActivity localAppCompatActivity = SettingsMoreSafeUI.this.getContext();
            SettingsMoreSafeUI.this.getString(b.i.app_tip);
            SettingsMoreSafeUI.a(localSettingsMoreSafeUI, k.a(localAppCompatActivity, SettingsMoreSafeUI.this.getString(b.i.settings_binding), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(74262);
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousCharSequence);
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
      if (WeChatBrands.Business.Entries.MeSetSecurityQQ.checkAvailable(this)) {
        com.tencent.mm.plugin.setting.c.pFn.g(new Intent(), this);
      }
      AppMethodBeat.o(74270);
      return true;
    }
    if (paramf.equals("settings_phone_security"))
    {
      com.tencent.mm.aa.c.aYo().b(at.a.acWf, false);
      ((IconPreference)paramPreference).aeD(8);
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWh, Integer.valueOf(0))).intValue();
      com.tencent.mm.plugin.report.service.h.OAn.b(10939, new Object[] { Integer.valueOf(i) });
      paramf = new Intent();
      paramf.putExtra("rawUrl", "https://sdi.3g.qq.com/v/2021111918295911309");
      com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(74270);
      return false;
      if (paramf.equals("settings_delete_account"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.PuQ))
        {
          paramf.putExtra("rawUrl", this.PuQ + "&lang=" + LocaleUtil.getCurrentLanguage(getContext()));
          paramf.putExtra("showShare", true);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf, 2);
        }
      }
      else if (paramf.equals("settings_dump_personal_data"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.PuR))
        {
          paramf.putExtra("rawUrl", this.PuR);
          paramf.putExtra("showShare", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74268);
    dNn();
    super.onResume();
    AppMethodBeat.o(74268);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(74276);
    Log.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramp.getType());
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    int i;
    if (paramp.getType() == 256)
    {
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (com.tencent.mm.plugin.setting.c.pFo.a(this, paramInt1, paramInt2, paramString)))
      {
        AppMethodBeat.o(74276);
        return;
      }
      i = this.Prt.get(paramInt2);
      paramp = getString(b.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = paramp;
      if (i == 0) {}
    }
    try
    {
      paramString = getString(i);
      k.cZ(getContext(), paramString);
      AppMethodBeat.o(74276);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[] { Integer.valueOf(i), paramString.getMessage() });
        Log.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", paramString, "", new Object[0]);
        paramString = paramp;
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