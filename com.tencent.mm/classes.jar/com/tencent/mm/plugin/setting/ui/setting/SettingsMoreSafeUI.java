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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
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
  private SparseIntArray Dba;
  private String Ddg;
  private String Ddh;
  private ProgressDialog gtM;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsMoreSafeUI()
  {
    AppMethodBeat.i(74264);
    this.Ddg = null;
    this.Dba = new SparseIntArray();
    this.Dba.put(0, 2131765370);
    this.Dba.put(-82, 2131765304);
    this.Dba.put(-83, 2131765301);
    this.Dba.put(-84, 2131765302);
    this.Dba.put(-85, 2131765295);
    this.Dba.put(-86, 2131765306);
    AppMethodBeat.o(74264);
  }
  
  private void eTj()
  {
    AppMethodBeat.i(74271);
    Preference localPreference = this.screen.bmg("settings_email_addr");
    Assert.assertNotNull(localPreference);
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(5, null);
    Integer localInteger = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(7, null);
    if ((localInteger != null) && ((localInteger.intValue() & 0x2) != 0))
    {
      localPreference.setSummary(2131765379);
      AppMethodBeat.o(74271);
      return;
    }
    if (str != null)
    {
      localPreference.setSummary(2131765378);
      AppMethodBeat.o(74271);
      return;
    }
    localPreference.setSummary(2131765294);
    AppMethodBeat.o(74271);
  }
  
  private void eTk()
  {
    AppMethodBeat.i(74273);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.bmg("settings_phone_security");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
      AppMethodBeat.o(74273);
      return;
    }
    if (ChannelUtil.isGPVersion())
    {
      this.screen.jdMethod_do("settings_phone_security", true);
      AppMethodBeat.o(74273);
      return;
    }
    if (com.tencent.mm.y.c.axV().a(ar.a.Ogg))
    {
      localIconSwitchKeyValuePreference.alF(0);
      AppMethodBeat.o(74273);
      return;
    }
    localIconSwitchKeyValuePreference.alF(8);
    AppMethodBeat.o(74273);
  }
  
  private void eTl()
  {
    AppMethodBeat.i(74274);
    Preference localPreference = this.screen.bmg("settings_facebook");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
      AppMethodBeat.o(74274);
      return;
    }
    if ((WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned()) || (!z.aUC()))
    {
      this.screen.e(localPreference);
      AppMethodBeat.o(74274);
      return;
    }
    if (!z.aUF())
    {
      localPreference.setSummary(getString(2131765355));
      AppMethodBeat.o(74274);
      return;
    }
    localPreference.setSummary((String)com.tencent.mm.kernel.g.aAh().azQ().get(65826, null));
    AppMethodBeat.o(74274);
  }
  
  private void eTm()
  {
    AppMethodBeat.i(74275);
    Preference localPreference = this.screen.bmg("settings_bind_qq");
    if (localPreference == null)
    {
      Log.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
      AppMethodBeat.o(74275);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(9, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      Log.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) != 1) {
        this.screen.jdMethod_do("settings_uin", true);
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetSecurityQQ.banned()) {
        this.screen.e(localPreference);
      }
      AppMethodBeat.o(74275);
      return;
      localPreference.setSummary(2131765355);
      continue;
      localPreference.setSummary(new p(i));
    }
  }
  
  public int getResourceId()
  {
    return 2132017273;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74267);
    setMMTitle(2131765483);
    this.screen = getPreferenceScreen();
    if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(9, Integer.valueOf(0))).intValue() == 0) {
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) != 1)
      {
        this.screen.jdMethod_do("settings_uin", true);
        Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
      }
    }
    for (;;)
    {
      this.Ddg = com.tencent.mm.n.h.aqJ().getValue("CloseAcctUrl");
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
      if ((com.tencent.mm.kernel.g.azz() != null) && (com.tencent.mm.kernel.g.azz().iMw != null)) {
        com.tencent.mm.kernel.g.azz().iMw.fz(false);
      }
      paramIntent = new hd();
      EventCenter.instance.publish(paramIntent);
      com.tencent.mm.plugin.setting.c.jRu.Xe();
      com.tencent.mm.kernel.g.aAh().azQ().remove(this);
      paramIntent = new ma();
      paramIntent.dRA.status = 0;
      paramIntent.dRA.bDZ = 3;
      EventCenter.instance.publish(paramIntent);
      paramIntent = new ad();
      paramIntent.dDb.dDc = true;
      EventCenter.instance.publish(paramIntent);
      MMEntryLock.unlock("show_whatsnew");
      com.tencent.mm.kernel.l.s(this, true);
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      paramIntent.putExtra("Intro_Switch", true);
      com.tencent.mm.plugin.setting.c.jRt.o(paramIntent, getContext());
      com.tencent.mm.platformtools.t.Q(this, null);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74265);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.azz().a(256, this);
    AppMethodBeat.o(74265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74266);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(256, this);
    AppMethodBeat.o(74266);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74272);
    eTm();
    eTj();
    eTl();
    eTk();
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
      paramf = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(7, null);
      if ((paramf != null) && ((paramf.intValue() & 0x2) != 0))
      {
        i = 1;
        paramf = (String)com.tencent.mm.kernel.g.aAh().azQ().get(5, null);
        if ((i == 0) && (Util.isNullOrNil(paramf))) {
          break label251;
        }
        paramf = new Intent(getContext(), SettingsModifyEmailAddrUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(74270);
        return true;
        i = 0;
        break;
        label251:
        if (this.gtM != null)
        {
          Log.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
          this.gtM.dismiss();
          this.gtM = null;
        }
        paramf = Util.nullAs(com.tencent.mm.platformtools.t.dy(getContext()), "");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131765467), paramf, getString(2131765468), 50, new h.b()
        {
          public final boolean onFinish(final CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(74263);
            if (!Util.isValidEmail(paramAnonymousCharSequence.toString()))
            {
              com.tencent.mm.ui.base.h.cD(SettingsMoreSafeUI.this.getContext(), SettingsMoreSafeUI.this.getString(2131767024));
              AppMethodBeat.o(74263);
              return false;
            }
            com.tencent.mm.plugin.setting.c.jRu.WZ();
            paramAnonymousCharSequence = new com.tencent.mm.plugin.account.model.e(com.tencent.mm.plugin.account.model.e.kir, paramAnonymousCharSequence.toString());
            com.tencent.mm.kernel.g.azz().a(paramAnonymousCharSequence, 0);
            SettingsMoreSafeUI localSettingsMoreSafeUI = SettingsMoreSafeUI.this;
            AppCompatActivity localAppCompatActivity = SettingsMoreSafeUI.this.getContext();
            SettingsMoreSafeUI.this.getString(2131755998);
            SettingsMoreSafeUI.a(localSettingsMoreSafeUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, SettingsMoreSafeUI.this.getString(2131765356), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(74262);
                com.tencent.mm.kernel.g.azz().a(paramAnonymousCharSequence);
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
        com.tencent.mm.plugin.setting.c.jRt.g(new Intent(), this);
      }
      AppMethodBeat.o(74270);
      return true;
    }
    int j;
    if (paramf.equals("settings_phone_security"))
    {
      Intent localIntent = new Intent();
      if (com.tencent.mm.y.c.axV().a(ar.a.Ogg))
      {
        i = 1;
        com.tencent.mm.y.c.axV().b(ar.a.Ogg, false);
        ((IconPreference)paramPreference).alF(8);
        j = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogi, Integer.valueOf(0))).intValue();
        com.tencent.mm.plugin.report.service.h.CyF.a(10939, new Object[] { Integer.valueOf(j) });
        if (!Util.isServiceRunning(this, "com.tencent.server.back.BackEngine")) {
          break label569;
        }
        paramf = getString(2131764104, new Object[] { Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(i) });
        label511:
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("showShare", false);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74270);
      return false;
      i = 0;
      break;
      label569:
      paramf = getString(2131764104, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      break label511;
      if (paramf.equals("settings_delete_account"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.Ddg))
        {
          paramf.putExtra("rawUrl", this.Ddg + "&lang=" + LocaleUtil.getCurrentLanguage(getContext()));
          paramf.putExtra("showShare", true);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf, 2);
        }
      }
      else if (paramf.equals("settings_dump_personal_data"))
      {
        paramf = new Intent();
        if (!Util.isNullOrNil(this.Ddh))
        {
          paramf.putExtra("rawUrl", this.Ddh);
          paramf.putExtra("showShare", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74268);
    eTm();
    eTj();
    eTl();
    Object localObject = com.tencent.mm.n.h.aqJ().getValue("ShowExportUserDataEntry");
    if (!Util.isNullOrNil((String)localObject)) {
      this.Ddh = ((String)localObject);
    }
    for (;;)
    {
      eTk();
      localObject = this.screen.bmg("settings_about_domainmail");
      this.screen.e((Preference)localObject);
      if (Util.isNullOrNil(this.Ddg))
      {
        localObject = this.screen.bmg("settings_delete_account");
        this.screen.e((Preference)localObject);
      }
      super.onResume();
      AppMethodBeat.o(74268);
      return;
      this.Ddh = "";
      this.screen.jdMethod_do("settings_dump_personal_data", true);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74276);
    Log.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramq.getType());
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    int i;
    if (paramq.getType() == 256)
    {
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (com.tencent.mm.plugin.setting.c.jRu.a(this, paramInt1, paramInt2, paramString)))
      {
        AppMethodBeat.o(74276);
        return;
      }
      i = this.Dba.get(paramInt2);
      paramq = getString(2131765369, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = paramq;
      if (i == 0) {}
    }
    try
    {
      paramString = getString(i);
      com.tencent.mm.ui.base.h.cD(getContext(), paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI
 * JD-Core Version:    0.7.0.1
 */