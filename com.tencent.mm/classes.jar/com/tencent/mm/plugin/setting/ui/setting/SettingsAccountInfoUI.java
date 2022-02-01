package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.aa.a;
import com.tencent.mm.autogen.a.ca;
import com.tencent.mm.autogen.a.ca.a;
import com.tencent.mm.autogen.a.uy;
import com.tencent.mm.autogen.a.uy.b;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAccountInfoUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private static final String Pro;
  private View Prp;
  private TextView Prq;
  private EditText Prr;
  private boolean Prs;
  private SparseIntArray Prt;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(299325);
    Pro = "https://" + WeChatHosts.domainString(b.i.host_weixin_qq_com) + "/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s";
    AppMethodBeat.o(299325);
  }
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.Prt = new SparseIntArray();
    this.Prt.put(0, b.i.settings_confirm_email_success_tip);
    this.Prt.put(-82, b.i.setting_unbind_qq_err_one_left);
    this.Prt.put(-83, b.i.setting_unbind_qq_err_has_unbind);
    this.Prt.put(-84, b.i.setting_unbind_qq_err_hasbinded);
    this.Prt.put(-85, b.i.setting_unbind_email_err_bindedbyother);
    this.Prt.put(-86, b.i.setting_unbind_qq_err_qmail);
    AppMethodBeat.o(74075);
  }
  
  private void gVA()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new ca();
    ((ca)localObject).publish();
    if ((((ca)localObject).hCa.hCb) && (((ca)localObject).hCa.hCc) && (((ca)localObject).hCa.hCd)) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((ca)localObject).hCa.hCb), Boolean.valueOf(((ca)localObject).hCa.hCc), Boolean.valueOf(((ca)localObject).hCa.hCd) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).eh("settings_fingerprint_title", bool);
        AppMethodBeat.o(74085);
        return;
        bool = false;
      }
    }
  }
  
  private void gVB()
  {
    AppMethodBeat.i(299318);
    this.screen.eh("settings_facedect_title", true);
    AppMethodBeat.o(299318);
  }
  
  private void gVC()
  {
    AppMethodBeat.i(299321);
    IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_more_safe");
    if (com.tencent.mm.aa.c.aYo().b(at.a.acWf, at.a.acWg))
    {
      localIconPreference.aeD(0);
      AppMethodBeat.o(299321);
      return;
    }
    localIconPreference.aeD(8);
    AppMethodBeat.o(299321);
  }
  
  private void gVx()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.bAi("settings_username");
    String str1 = z.bAM();
    String str2 = z.bAN();
    if (Util.isNullOrNil(str2))
    {
      if (au.bxb(str1)) {
        localPreference.aS(getString(b.i.settings_notset));
      }
      while ((!au.bxc(z.bAM())) && (i.aRC().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.aBq(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.aS(str1);
      }
    }
    localPreference.aS(str2);
    if (i.aRC().getInt("EnableModAlias", 0) == 0) {
      localPreference.aBq(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void gVy()
  {
    AppMethodBeat.i(74083);
    if (this.screen.bAi("settings_manage_login_device") == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.eh("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void gVz()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.bAi("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)h.baE().ban().d(6, null);
    Log.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.aS(getString(b.i.settings_bind_qq_unbind));
      localIconSwitchKeyValuePreference.aBl(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.aS(str);
    localIconSwitchKeyValuePreference.aBl(1);
    AppMethodBeat.o(74084);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(299285);
    if (ignoreSecondCalled())
    {
      AppMethodBeat.o(299285);
      return;
    }
    gVx();
    gVz();
    this.Prs = false;
    gVC();
    gVy();
    gVA();
    gVB();
    Object localObject = (PluginTextPreference)this.screen.bAi("settings_about_vusertitle");
    SelfVuserPreference localSelfVuserPreference = (SelfVuserPreference)this.screen.bAi("settings_about_vuserinfo");
    Preference localPreference = this.screen.bAi("settings_about_vuser_about");
    int i = Util.nullAsNil((Integer)h.baE().ban().d(66049, null));
    if (i != 0)
    {
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).aBo(b.i.contact_info_verify_user_title);
      if (az.a.okR != null) {}
      for (localObject = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(i), 2.0F);; localObject = null)
      {
        localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
        localSelfVuserPreference.text = ((String)h.baE().ban().d(66050, null));
        AppMethodBeat.o(299285);
        return;
      }
    }
    this.screen.e((Preference)localObject);
    this.screen.e(localSelfVuserPreference);
    this.screen.e(localPreference);
    AppMethodBeat.o(299285);
  }
  
  public boolean autoRefresh()
  {
    return true;
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_account_info;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74078);
    setMMTitle(b.i.settings_account_info);
    this.screen = getPreferenceScreen();
    this.Prp = View.inflate(this, b.g.sendrequest_dialog, null);
    this.Prq = ((TextView)this.Prp.findViewById(b.f.sendrequest_tip));
    this.Prq.setText(getString(b.i.settings_independent_password_tip));
    this.Prr = ((EditText)this.Prp.findViewById(b.f.sendrequest_content));
    this.Prr.setInputType(129);
    if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || (Util.getInt(i.aRC().getValue("VoiceprintEntry"), 0) != 1)) {
      this.screen.eh("settings_voiceprint_title", true);
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
      if (!h.baz())
      {
        Log.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_voiceprint_title");
      if ((((Boolean)h.baE().ban().get(at.a.acIM, Boolean.FALSE)).booleanValue()) && ((h.baE().ban().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.gv(getString(b.i.app_new), b.e.new_tips_bg);
        localIconPreference.afx(0);
        Log.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74076);
    super.onCreate(paramBundle);
    initView();
    h.baE().ban().add(this);
    updateView();
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    h.baE().ban().remove(this);
    AppMethodBeat.o(74077);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74081);
    gVx();
    gVz();
    gVy();
    gVA();
    AppMethodBeat.o(74081);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    z.bAM();
    if (Util.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((Util.isNullOrNil(z.bAN())) && (au.bxc(z.bAM())) && (i.aRC().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (i.aRC().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.aQ(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aQ(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format(Pro, new Object[] { LocaleUtil.getApplicationLanguage() });
      Util.jump(getContext(), paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(74080);
      return false;
      if (paramf.equals("settings_independent_password"))
      {
        paramf = new Intent();
        paramf.putExtra("kintent_hint", getString(b.i.settings_modify_password_tip));
        startActivity(RegByMobileSetPwdUI.class, paramf);
      }
      else if (paramf.equals("settings_manage_login_device"))
      {
        com.tencent.mm.br.c.ai(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = i.aRC().getValue("WeChatSafeCenterUrl");
        Log.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (Util.isNullOrNil(paramPreference)) {
          paramf = getString(b.i.wechat_securiy_center_path) + LocaleUtil.getApplicationLanguage();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
        com.tencent.mm.br.c.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((Util.getInt(i.aRC().getValue("VoiceprintEntry"), 0) == 1) && ((h.baE().ban().getInt(40, 0) & 0x20000) == 0))
        {
          h.baE().ban().set(at.a.acIM, Boolean.FALSE);
          ((IconPreference)this.screen.bAi("settings_voiceprint_title")).afx(8);
          this.screen.notifyDataSetChanged();
          Log.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        com.tencent.mm.br.c.ai(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new uy();
        paramf.hYO.context = this;
        paramf.publish();
        boolean bool = paramf.hYP.hYE;
        Log.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          aa.makeText(getContext(), getString(b.i.face_settings_not_support), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        startActivity(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        com.tencent.mm.aa.c.aYo().c(at.a.acWf, at.a.acWg);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    updateView();
    super.onResume();
    AppMethodBeat.o(74079);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI
 * JD-Core Version:    0.7.0.1
 */