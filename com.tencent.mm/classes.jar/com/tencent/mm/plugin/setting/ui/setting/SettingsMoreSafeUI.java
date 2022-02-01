package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.hk;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.model.e;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class SettingsMoreSafeUI
  extends MMPreference
  implements i, MStorageEx.IOnStorageChange
{
  private SparseIntArray JgB;
  private String JiJ;
  private String JiK;
  private ProgressDialog iXX;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsMoreSafeUI()
  {
    AppMethodBeat.i(74264);
    this.JiJ = null;
    this.JgB = new SparseIntArray();
    this.JgB.put(0, b.i.settings_confirm_email_success_tip);
    this.JgB.put(-82, b.i.setting_unbind_qq_err_one_left);
    this.JgB.put(-83, b.i.setting_unbind_qq_err_has_unbind);
    this.JgB.put(-84, b.i.setting_unbind_qq_err_hasbinded);
    this.JgB.put(-85, b.i.setting_unbind_email_err_bindedbyother);
    this.JgB.put(-86, b.i.setting_unbind_qq_err_qmail);
    AppMethodBeat.o(74264);
  }
  
  private void fGn()
  {
    AppMethodBeat.i(74271);
    Preference localPreference = this.screen.byG("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.auI(b.i.settings_email_addr_verified);
      AppMethodBeat.o(74271);
      return;
    }
    if (str != null)
    {
      localPreference.auI(b.i.settings_email_addr_not_verified);
      AppMethodBeat.o(74271);
      return;
    }
    localPreference.auI(b.i.setting_unbind);
    AppMethodBeat.o(74271);
  }
  
  private void fGo()
  {
    AppMethodBeat.i(74273);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.byG("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      AppMethodBeat.o(74273);
      return;
    }
    if (ChannelUtil.isGPVersion())
    {
      this.screen.dz("settings_phone_security", true);
      AppMethodBeat.o(74273);
      return;
    }
    if (com.tencent.mm.aa.c.aFn().a(ar.a.Vuw))
    {
      localIconSwitchKeyValuePreference.aak(0);
      AppMethodBeat.o(74273);
      return;
    }
    localIconSwitchKeyValuePreference.aak(8);
    AppMethodBeat.o(74273);
  }
  
  private void fGp()
  {
    AppMethodBeat.i(74274);
    Preference localPreference = this.screen.byG("settings_facebook");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      AppMethodBeat.o(74274);
      return;
    }
    if ((WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned()) || (!z.bdE()))
    {
      this.screen.d(localPreference);
      AppMethodBeat.o(74274);
      return;
    }
    if (!z.bdH())
    {
      localPreference.aF(getString(b.i.settings_bind_qq_unbind));
      AppMethodBeat.o(74274);
      return;
    }
    localPreference.aF((String)com.tencent.mm.kernel.h.aHG().aHp().b(65826, null));
    AppMethodBeat.o(74274);
  }
  
  private void fGq()
  {
    AppMethodBeat.i(74275);
    Preference localPreference = this.screen.byG("settings_bind_qq");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      AppMethodBeat.o(74275);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      Log.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("BindQQSwitch"), 1) != 1) {
        this.screen.dz("settings_uin", true);
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetSecurityQQ.banned()) {
        this.screen.d(localPreference);
      }
      AppMethodBeat.o(74275);
      return;
      localPreference.auI(b.i.settings_bind_qq_unbind);
      continue;
      localPreference.aF(new p(i));
    }
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
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, Integer.valueOf(0))).intValue() == 0) {
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.dz("settings_uin", true);
        Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.JiJ = com.tencent.mm.n.h.axc().getValue("CloseAcctUrl");
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
      if ((com.tencent.mm.kernel.h.aGY() != null) && (com.tencent.mm.kernel.h.aGY().lCD != null)) {
        com.tencent.mm.kernel.h.aGY().lCD.gk(false);
      }
      paramIntent = new hk();
      EventCenter.instance.publish(paramIntent);
      com.tencent.mm.plugin.setting.c.mIH.abH();
      com.tencent.mm.kernel.h.aHG().aHp().remove(this);
      paramIntent = new mr();
      paramIntent.fKQ.status = 0;
      paramIntent.fKQ.bnA = 3;
      EventCenter.instance.publish(paramIntent);
      paramIntent = new ae();
      paramIntent.fvH.fvI = true;
      EventCenter.instance.publish(paramIntent);
      MMEntryLock.unlock("show_whatsnew");
      n.v(this, true);
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      paramIntent.putExtra("Intro_Switch", true);
      com.tencent.mm.plugin.setting.c.mIG.n(paramIntent, getContext());
      com.tencent.mm.platformtools.t.O(this, null);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74265);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.h.aGY().a(256, this);
    AppMethodBeat.o(74265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74266);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(256, this);
    AppMethodBeat.o(74266);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74272);
    fGq();
    fGn();
    fGp();
    fGo();
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
        startActivity(FacebookAuthUI.class);
      }
      AppMethodBeat.o(74270);
      return true;
    }
    int i;
    if (paramf.equals("settings_email_addr"))
    {
      paramf = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7, null);
      if ((paramf != null) && ((paramf.intValue() & 0x2) != 0))
      {
        i = 1;
        paramf = (String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null);
        if ((i == 0) && (Util.isNullOrNil(paramf))) {
          break label251;
        }
        paramf = new Intent(getContext(), SettingsModifyEmailAddrUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(74270);
        return true;
        i = 0;
        break;
        label251:
        if (this.iXX != null)
        {
          Log.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
          this.iXX.dismiss();
          this.iXX = null;
        }
        paramf = Util.nullAs(com.tencent.mm.platformtools.t.dv(getContext()), "");
        com.tencent.mm.ui.base.h.a(getContext(), getString(b.i.settings_modify_email_addr), paramf, getString(b.i.settings_modify_email_addr_warning), 50, new h.b()
        {
          public final boolean onFinish(final CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(74263);
            if (!Util.isValidEmail(paramAnonymousCharSequence.toString()))
            {
              com.tencent.mm.ui.base.h.cO(SettingsMoreSafeUI.this.getContext(), SettingsMoreSafeUI.this.getString(b.i.verify_email_err_tip));
              AppMethodBeat.o(74263);
              return false;
            }
            com.tencent.mm.plugin.setting.c.mIH.abC();
            paramAnonymousCharSequence = new e(e.mZR, paramAnonymousCharSequence.toString());
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousCharSequence, 0);
            SettingsMoreSafeUI localSettingsMoreSafeUI = SettingsMoreSafeUI.this;
            AppCompatActivity localAppCompatActivity = SettingsMoreSafeUI.this.getContext();
            SettingsMoreSafeUI.this.getString(b.i.app_tip);
            SettingsMoreSafeUI.a(localSettingsMoreSafeUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, SettingsMoreSafeUI.this.getString(b.i.settings_binding), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(74262);
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousCharSequence);
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
        com.tencent.mm.plugin.setting.c.mIG.g(new Intent(), this);
      }
      AppMethodBeat.o(74270);
      return true;
    }
    int j;
    if (paramf.equals("settings_phone_security"))
    {
      Intent localIntent = new Intent();
      if (com.tencent.mm.aa.c.aFn().a(ar.a.Vuw))
      {
        i = 1;
        com.tencent.mm.aa.c.aFn().b(ar.a.Vuw, false);
        ((IconPreference)paramPreference).aak(8);
        j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vuy, Integer.valueOf(0))).intValue();
        com.tencent.mm.plugin.report.service.h.IzE.a(10939, new Object[] { Integer.valueOf(j) });
        if (!Util.isServiceRunning(this, "com.tencent.server.back.BackEngine")) {
          break label569;
        }
        paramf = getString(b.i.qqpimsecure_jump_url, new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });
        label511:
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("showShare", false);
        com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74270);
      return false;
      i = 0;
      break;
      label569:
      paramf = getString(b.i.qqpimsecure_jump_url, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      break label511;
      if (paramf.equals("settings_delete_account"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.JiJ))
        {
          paramf.putExtra("rawUrl", this.JiJ + "&lang=" + LocaleUtil.getCurrentLanguage(getContext()));
          paramf.putExtra("showShare", true);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
          com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf, 2);
        }
      }
      else if (paramf.equals("settings_dump_personal_data"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.JiK))
        {
          paramf.putExtra("rawUrl", this.JiK);
          paramf.putExtra("showShare", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
          com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74268);
    fGq();
    fGn();
    fGp();
    Object localObject = com.tencent.mm.n.h.axc().getValue("ShowExportUserDataEntry");
    if (!Util.isNullOrNil((String)localObject)) {
      this.JiK = ((String)localObject);
    }
    for (;;)
    {
      fGo();
      localObject = this.screen.byG("settings_about_domainmail");
      this.screen.d((Preference)localObject);
      if (Util.isNullOrNil(this.JiJ))
      {
        localObject = this.screen.byG("settings_delete_account");
        this.screen.d((Preference)localObject);
      }
      super.onResume();
      AppMethodBeat.o(74268);
      return;
      this.JiK = "";
      this.screen.dz("settings_dump_personal_data", true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74276);
    Log.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramq.getType());
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    int i;
    if (paramq.getType() == 256)
    {
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (com.tencent.mm.plugin.setting.c.mIH.a(this, paramInt1, paramInt2, paramString)))
      {
        AppMethodBeat.o(74276);
        return;
      }
      i = this.JgB.get(paramInt2);
      paramq = getString(b.i.settings_confirm_email_fail_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = paramq;
      if (i == 0) {}
    }
    try
    {
      paramString = getString(i);
      com.tencent.mm.ui.base.h.cO(getContext(), paramString);
      AppMethodBeat.o(74276);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[] { Integer.valueOf(i), paramString.getMessage() });
        Log.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", paramString, "", new Object[0]);
        paramString = paramq;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI
 * JD-Core Version:    0.7.0.1
 */