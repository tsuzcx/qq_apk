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
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.rm.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
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
  private View yWh;
  private TextView yWi;
  private EditText yWj;
  private boolean yWk;
  private SparseIntArray yWl;
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.yWl = new SparseIntArray();
    this.yWl.put(0, 2131763202);
    this.yWl.put(-82, 2131763138);
    this.yWl.put(-83, 2131763135);
    this.yWl.put(-84, 2131763136);
    this.yWl.put(-85, 2131763129);
    this.yWl.put(-86, 2131763140);
    AppMethodBeat.o(74075);
  }
  
  private void dQY()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.aXe("settings_username");
    String str1 = v.aAC();
    String str2 = v.aAD();
    if (bu.isNullOrNil(str2))
    {
      if (an.aUy(str1)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!an.aUz(v.aAC())) && (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.ade(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.setSummary(str1);
      }
    }
    localPreference.setSummary(str2);
    if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0) {
      localPreference.ade(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void dQZ()
  {
    AppMethodBeat.i(74083);
    if (this.screen.aXe("settings_manage_login_device") == null)
    {
      ae.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.cT("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void dRa()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.aXe("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      ae.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(6, null);
    ae.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(2131763187));
      localIconSwitchKeyValuePreference.acZ(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.acZ(1);
    AppMethodBeat.o(74084);
  }
  
  private void dRb()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new bk();
    com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
    if ((((bk)localObject).dns.dnt) && (((bk)localObject).dns.dnu) && (((bk)localObject).dns.dnv)) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((bk)localObject).dns.dnt), Boolean.valueOf(((bk)localObject).dns.dnu), Boolean.valueOf(((bk)localObject).dns.dnv) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((f)localObject).cT("settings_fingerprint_title", bool);
        AppMethodBeat.o(74085);
        return;
        bool = false;
      }
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(74081);
    dQY();
    dRa();
    dQZ();
    dRb();
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
    this.yWh = View.inflate(this, 2131495371, null);
    this.yWi = ((TextView)this.yWh.findViewById(2131304591));
    this.yWi.setText(getString(2131763244));
    this.yWj = ((EditText)this.yWh.findViewById(2131304590));
    this.yWj.setInputType(129);
    if (bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) != 1) {
      this.screen.cT("settings_voiceprint_title", true);
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
      if (!com.tencent.mm.kernel.g.ajM())
      {
        ae.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILr, Boolean.FALSE)).booleanValue()) && ((com.tencent.mm.kernel.g.ajR().ajA().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.gF(getString(2131755829), 2131233430);
        localIconPreference.acS(0);
        ae.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74076);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.ajR().ajA().a(this);
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajR().ajA().b(this);
    AppMethodBeat.o(74077);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    v.aAC();
    if (bu.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bu.isNullOrNil(v.aAD())) && (an.aUz(v.aAC())) && (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.al(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.al(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[] { ad.fom() });
      bu.ce(getContext(), paramf);
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
        d.Q(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = com.tencent.mm.n.g.acL().getValue("WeChatSafeCenterUrl");
        ae.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (bu.isNullOrNil(paramPreference)) {
          paramf = getString(2131766193) + ad.fom();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
        d.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.ajR().ajA().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILr, Boolean.FALSE);
          ((IconPreference)this.screen.aXe("settings_voiceprint_title")).acS(8);
          this.screen.notifyDataSetChanged();
          ae.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        d.Q(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new rm();
        paramf.dHm.context = this;
        com.tencent.mm.sdk.b.a.IvT.l(paramf);
        boolean bool = paramf.dHn.dHb;
        ae.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
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
        c.ahI().c(am.a.IXJ, am.a.IXK);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    dQY();
    dRa();
    this.yWk = false;
    Object localObject = (IconPreference)this.screen.aXe("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (c.ahI().b(am.a.IXJ, am.a.IXK))
    {
      ((IconPreference)localObject).acU(0);
      dQZ();
      dRb();
      this.screen.cT("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.aXe("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.aXe("settings_about_vuserinfo");
      localPreference = this.screen.aXe("settings_about_vuser_about");
      int i = bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(66049, null));
      if (i == 0) {
        break label241;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).adc(2131757895);
      if (au.a.hII == null) {
        break label236;
      }
      localObject = BackwardSupportUtil.b.p(au.a.hII.ou(i), 2.0F);
      label180:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74079);
      return;
      ((IconPreference)localObject).acU(8);
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