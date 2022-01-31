package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bc.a;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.oz.b;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.x.c;

public class SettingsAccountInfoUI
  extends MMPreference
  implements n.b
{
  private View qHC;
  private TextView qHD;
  private EditText qHE;
  private boolean qHF;
  private SparseIntArray qHG;
  private f screen;
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(127143);
    this.qHG = new SparseIntArray();
    this.qHG.put(0, 2131303234);
    this.qHG.put(-82, 2131303172);
    this.qHG.put(-83, 2131303169);
    this.qHG.put(-84, 2131303170);
    this.qHG.put(-85, 2131303163);
    this.qHG.put(-86, 2131303174);
    AppMethodBeat.o(127143);
  }
  
  private void ckf()
  {
    AppMethodBeat.i(127150);
    Preference localPreference = this.screen.atx("settings_username");
    String str = r.Zo();
    if (bo.isNullOrNil(str))
    {
      str = r.Zn();
      if (ad.ari(str)) {
        localPreference.setSummary(getString(2131303357));
      }
      for (;;)
      {
        if (!ad.arj(r.Zn())) {
          localPreference.OW(8);
        }
        AppMethodBeat.o(127150);
        return;
        localPreference.setSummary(str);
      }
    }
    localPreference.setSummary(str);
    localPreference.OW(8);
    AppMethodBeat.o(127150);
  }
  
  private void ckg()
  {
    AppMethodBeat.i(127151);
    if (this.screen.atx("settings_manage_login_device") == null)
    {
      ab.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(127151);
      return;
    }
    this.screen.cl("settings_manage_login_device", false);
    AppMethodBeat.o(127151);
  }
  
  private void ckh()
  {
    AppMethodBeat.i(127152);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.atx("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      ab.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(127152);
      return;
    }
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, null);
    ab.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(2131303219));
      localIconSwitchKeyValuePreference.OS(0);
      AppMethodBeat.o(127152);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.OS(1);
    AppMethodBeat.o(127152);
  }
  
  private void cki()
  {
    boolean bool = true;
    AppMethodBeat.i(127153);
    Object localObject = new bc();
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    if ((((bc)localObject).coA.coB) && (((bc)localObject).coA.coC) && (((bc)localObject).coA.coD)) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((bc)localObject).coA.coB), Boolean.valueOf(((bc)localObject).coA.coC), Boolean.valueOf(((bc)localObject).coA.coD) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((f)localObject).cl("settings_fingerprint_title", bool);
        AppMethodBeat.o(127153);
        return;
        bool = false;
      }
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(127149);
    ckf();
    ckh();
    ckg();
    cki();
    AppMethodBeat.o(127149);
  }
  
  public boolean autoRefresh()
  {
    return true;
  }
  
  public int getResourceId()
  {
    return 2131165279;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127146);
    setMMTitle(2131303194);
    this.screen = getPreferenceScreen();
    this.qHC = View.inflate(this, 2130970676, null);
    this.qHD = ((TextView)this.qHC.findViewById(2131827574));
    this.qHD.setText(getString(2131303275));
    this.qHE = ((EditText)this.qHC.findViewById(2131827575));
    this.qHE.setInputType(129);
    if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) != 1) {
      this.screen.cl("settings_voiceprint_title", true);
    }
    for (;;)
    {
      setBackBtn(new SettingsAccountInfoUI.1(this));
      AppMethodBeat.o(127146);
      return;
      if (!com.tencent.mm.kernel.g.RG())
      {
        ab.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(127146);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyt, Boolean.FALSE)).booleanValue()) && ((com.tencent.mm.kernel.g.RL().Ru().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.eN(getString(2131297012), 2130839787);
        localIconPreference.OL(0);
        ab.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127144);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.RL().Ru().a(this);
    AppMethodBeat.o(127144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127145);
    super.onDestroy();
    com.tencent.mm.kernel.g.RL().Ru().b(this);
    AppMethodBeat.o(127145);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127148);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    r.Zn();
    if (bo.isNullOrNil(paramf))
    {
      AppMethodBeat.o(127148);
      return false;
    }
    if ((paramf.equals("settings_username")) && (bo.isNullOrNil(r.Zo())) && (ad.arj(r.Zn()))) {
      startActivity(SettingsAliasUI.class);
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.J(this, paramf);
      AppMethodBeat.o(127148);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[] { aa.dsG() });
      bo.M(getContext(), paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(127148);
      return false;
      if (paramf.equals("settings_independent_password"))
      {
        paramf = new Intent();
        paramf.putExtra("kintent_hint", getString(2131303322));
        startActivity(RegByMobileSetPwdUI.class, paramf);
      }
      else if (paramf.equals("settings_manage_login_device"))
      {
        d.H(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = com.tencent.mm.m.g.Nq().getValue("WeChatSafeCenterUrl");
        ab.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (bo.isNullOrNil(paramPreference)) {
          paramf = getString(2131305946) + aa.dsG();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
        d.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.RL().Ru().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyt, Boolean.FALSE);
          ((IconPreference)this.screen.atx("settings_voiceprint_title")).OL(8);
          this.screen.notifyDataSetChanged();
          ab.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        d.H(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new oz();
        paramf.cFI.context = this;
        com.tencent.mm.sdk.b.a.ymk.l(paramf);
        boolean bool = paramf.cFJ.cFy;
        ab.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          t.makeText(getContext(), getString(2131299602), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        startActivity(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        c.PJ().c(ac.a.yJH, ac.a.yJI);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127147);
    ckf();
    ckh();
    this.qHF = false;
    Object localObject = (IconPreference)this.screen.atx("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (c.PJ().b(ac.a.yJH, ac.a.yJI))
    {
      ((IconPreference)localObject).ON(0);
      ckg();
      cki();
      this.screen.cl("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.atx("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.atx("settings_about_vuserinfo");
      localPreference = this.screen.atx("settings_about_vuser_about");
      int i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(66049, null));
      if (i == 0) {
        break label240;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).OV(2131298827);
      if (ao.a.flK == null) {
        break label235;
      }
      localObject = BackwardSupportUtil.b.k(ao.a.flK.kx(i), 2.0F);
      label179:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.g.RL().Ru().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(127147);
      return;
      ((IconPreference)localObject).ON(8);
      break;
      label235:
      localObject = null;
      break label179;
      label240:
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