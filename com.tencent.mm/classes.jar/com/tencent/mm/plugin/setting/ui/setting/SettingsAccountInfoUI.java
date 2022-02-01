package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.qr.b;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.z.c;

public class SettingsAccountInfoUI
  extends MMPreference
  implements n.b
{
  private f screen;
  private View wfZ;
  private TextView wga;
  private EditText wgb;
  private boolean wgc;
  private SparseIntArray wgd;
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.wgd = new SparseIntArray();
    this.wgd.put(0, 2131763202);
    this.wgd.put(-82, 2131763138);
    this.wgd.put(-83, 2131763135);
    this.wgd.put(-84, 2131763136);
    this.wgd.put(-85, 2131763129);
    this.wgd.put(-86, 2131763140);
    AppMethodBeat.o(74075);
  }
  
  private void dnQ()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.aKk("settings_username");
    String str1 = u.aqG();
    String str2 = u.aqH();
    if (bt.isNullOrNil(str2))
    {
      if (af.aHK(str1)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!af.aHL(u.aqG())) && (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.Yb(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.setSummary(str1);
      }
    }
    localPreference.setSummary(str2);
    if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0) {
      localPreference.Yb(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void dnR()
  {
    AppMethodBeat.i(74083);
    if (this.screen.aKk("settings_manage_login_device") == null)
    {
      ad.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.cE("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void dnS()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.aKk("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      ad.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(6, null);
    ad.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(2131763187));
      localIconSwitchKeyValuePreference.XX(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.XX(1);
    AppMethodBeat.o(74084);
  }
  
  private void dnT()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new bg();
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
    if ((((bg)localObject).ddy.ddz) && (((bg)localObject).ddy.ddA) && (((bg)localObject).ddy.ddB)) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((bg)localObject).ddy.ddz), Boolean.valueOf(((bg)localObject).ddy.ddA), Boolean.valueOf(((bg)localObject).ddy.ddB) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((f)localObject).cE("settings_fingerprint_title", bool);
        AppMethodBeat.o(74085);
        return;
        bool = false;
      }
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(74081);
    dnQ();
    dnS();
    dnR();
    dnT();
    AppMethodBeat.o(74081);
  }
  
  public boolean autoRefresh()
  {
    return true;
  }
  
  public int getResourceId()
  {
    return 2131951723;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74078);
    setMMTitle(2131763161);
    this.screen = getPreferenceScreen();
    this.wfZ = View.inflate(this, 2131495371, null);
    this.wga = ((TextView)this.wfZ.findViewById(2131304591));
    this.wga.setText(getString(2131763244));
    this.wgb = ((EditText)this.wfZ.findViewById(2131304590));
    this.wgb.setInputType(129);
    if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) != 1) {
      this.screen.cE("settings_voiceprint_title", true);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74074);
          SettingsAccountInfoUI.this.hideVKB();
          SettingsAccountInfoUI.this.finish();
          AppMethodBeat.o(74074);
          return true;
        }
      });
      AppMethodBeat.o(74078);
      return;
      if (!com.tencent.mm.kernel.g.afw())
      {
        ad.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.aKk("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgO, Boolean.FALSE)).booleanValue()) && ((com.tencent.mm.kernel.g.afB().afk().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.fV(getString(2131755829), 2131233430);
        localIconPreference.XQ(0);
        ad.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74076);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.afB().afk().a(this);
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    com.tencent.mm.kernel.g.afB().afk().b(this);
    AppMethodBeat.o(74077);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    u.aqG();
    if (bt.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bt.isNullOrNil(u.aqH())) && (af.aHL(u.aqG())) && (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.V(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.V(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[] { ac.eFu() });
      bt.bX(getContext(), paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(74080);
      return false;
      if (paramf.equals("settings_independent_password"))
      {
        paramf = new Intent();
        paramf.putExtra("kintent_hint", getString(2131763302));
        startActivity(RegByMobileSetPwdUI.class, paramf);
      }
      else if (paramf.equals("settings_manage_login_device"))
      {
        d.O(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = com.tencent.mm.m.g.Zd().getValue("WeChatSafeCenterUrl");
        ad.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (bt.isNullOrNil(paramPreference)) {
          paramf = getString(2131766193) + ac.eFu();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
        d.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.afB().afk().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgO, Boolean.FALSE);
          ((IconPreference)this.screen.aKk("settings_voiceprint_title")).XQ(8);
          this.screen.notifyDataSetChanged();
          ad.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        d.O(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new qr();
        paramf.dwt.context = this;
        com.tencent.mm.sdk.b.a.ESL.l(paramf);
        boolean bool = paramf.dwu.dwi;
        ad.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          t.makeText(getContext(), getString(2131758759), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        startActivity(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        c.adr().c(ae.a.FsT, ae.a.FsU);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    dnQ();
    dnS();
    this.wgc = false;
    Object localObject = (IconPreference)this.screen.aKk("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (c.adr().b(ae.a.FsT, ae.a.FsU))
    {
      ((IconPreference)localObject).XS(0);
      dnR();
      dnT();
      this.screen.cE("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.aKk("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.aKk("settings_about_vuserinfo");
      localPreference = this.screen.aKk("settings_about_vuser_about");
      int i = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(66049, null));
      if (i == 0) {
        break label241;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).Ya(2131757895);
      if (ar.a.gMY == null) {
        break label236;
      }
      localObject = BackwardSupportUtil.b.n(ar.a.gMY.nd(i), 2.0F);
      label180:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.g.afB().afk().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74079);
      return;
      ((IconPreference)localObject).XS(8);
      break;
      label236:
      localObject = null;
      break label180;
      label241:
      this.screen.d((Preference)localObject);
      this.screen.d(localSelfVuserPreference);
      this.screen.d(localPreference);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI
 * JD-Core Version:    0.7.0.1
 */