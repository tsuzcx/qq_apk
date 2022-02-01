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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.bh.a;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.a.ra.b;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.y.c;

public class SettingsAccountInfoUI
  extends MMPreference
  implements n.b
{
  private f screen;
  private View xrp;
  private TextView xrq;
  private EditText xrr;
  private boolean xrs;
  private SparseIntArray xrt;
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.xrt = new SparseIntArray();
    this.xrt.put(0, 2131763202);
    this.xrt.put(-82, 2131763138);
    this.xrt.put(-83, 2131763135);
    this.xrt.put(-84, 2131763136);
    this.xrt.put(-85, 2131763129);
    this.xrt.put(-86, 2131763140);
    AppMethodBeat.o(74075);
  }
  
  private void dBY()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.aPN("settings_username");
    String str1 = u.axw();
    String str2 = u.axx();
    if (bs.isNullOrNil(str2))
    {
      if (ai.aNf(str1)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!ai.aNg(u.axw())) && (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.aam(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.setSummary(str1);
      }
    }
    localPreference.setSummary(str2);
    if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0) {
      localPreference.aam(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void dBZ()
  {
    AppMethodBeat.i(74083);
    if (this.screen.aPN("settings_manage_login_device") == null)
    {
      ac.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.cK("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void dCa()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.aPN("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      ac.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(6, null);
    ac.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(2131763187));
      localIconSwitchKeyValuePreference.aai(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.aai(1);
    AppMethodBeat.o(74084);
  }
  
  private void dCb()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new bh();
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
    if ((((bh)localObject).daW.daX) && (((bh)localObject).daW.daY) && (((bh)localObject).daW.daZ)) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((bh)localObject).daW.daX), Boolean.valueOf(((bh)localObject).daW.daY), Boolean.valueOf(((bh)localObject).daW.daZ) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((f)localObject).cK("settings_fingerprint_title", bool);
        AppMethodBeat.o(74085);
        return;
        bool = false;
      }
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(74081);
    dBY();
    dCa();
    dBZ();
    dCb();
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
    this.xrp = View.inflate(this, 2131495371, null);
    this.xrq = ((TextView)this.xrp.findViewById(2131304591));
    this.xrq.setText(getString(2131763244));
    this.xrr = ((EditText)this.xrp.findViewById(2131304590));
    this.xrr.setInputType(129);
    if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) != 1) {
      this.screen.cK("settings_voiceprint_title", true);
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
      if (!com.tencent.mm.kernel.g.agM())
      {
        ac.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.aPN("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEC, Boolean.FALSE)).booleanValue()) && ((com.tencent.mm.kernel.g.agR().agA().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.fZ(getString(2131755829), 2131233430);
        localIconPreference.aab(0);
        ac.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74076);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.agR().agA().a(this);
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    com.tencent.mm.kernel.g.agR().agA().b(this);
    AppMethodBeat.o(74077);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    u.axw();
    if (bs.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bs.isNullOrNil(u.axx())) && (ai.aNg(u.axw())) && (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.aj(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aj(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[] { ab.eUO() });
      bs.bY(getContext(), paramf);
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
        d.N(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = com.tencent.mm.m.g.ZY().getValue("WeChatSafeCenterUrl");
        ac.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (bs.isNullOrNil(paramPreference)) {
          paramf = getString(2131766193) + ab.eUO();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
        d.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.agR().agA().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEC, Boolean.FALSE);
          ((IconPreference)this.screen.aPN("settings_voiceprint_title")).aab(8);
          this.screen.notifyDataSetChanged();
          ac.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        d.N(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new ra();
        paramf.dug.context = this;
        com.tencent.mm.sdk.b.a.GpY.l(paramf);
        boolean bool = paramf.duh.dtV;
        ac.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
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
        c.aeH().c(ah.a.GQM, ah.a.GQN);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    dBY();
    dCa();
    this.xrs = false;
    Object localObject = (IconPreference)this.screen.aPN("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (c.aeH().b(ah.a.GQM, ah.a.GQN))
    {
      ((IconPreference)localObject).aad(0);
      dBZ();
      dCb();
      this.screen.cK("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.aPN("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.aPN("settings_about_vuserinfo");
      localPreference = this.screen.aPN("settings_about_vuser_about");
      int i = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66049, null));
      if (i == 0) {
        break label241;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).aal(2131757895);
      if (ar.a.hny == null) {
        break label236;
      }
      localObject = BackwardSupportUtil.b.n(ar.a.hny.nR(i), 2.0F);
      label180:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.g.agR().agA().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74079);
      return;
      ((IconPreference)localObject).aad(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI
 * JD-Core Version:    0.7.0.1
 */