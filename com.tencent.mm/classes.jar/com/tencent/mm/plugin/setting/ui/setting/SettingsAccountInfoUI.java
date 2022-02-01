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
import com.tencent.mm.aa.a;
import com.tencent.mm.f.a.br;
import com.tencent.mm.f.a.br.a;
import com.tencent.mm.f.a.tj;
import com.tencent.mm.f.a.tj.b;
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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;

public class SettingsAccountInfoUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private static final String Jgw;
  private boolean JgA;
  private SparseIntArray JgB;
  private View Jgx;
  private TextView Jgy;
  private EditText Jgz;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(263249);
    Jgw = "https://" + WeChatHosts.domainString(b.i.host_weixin_qq_com) + "/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s";
    AppMethodBeat.o(263249);
  }
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.JgB = new SparseIntArray();
    this.JgB.put(0, b.i.settings_confirm_email_success_tip);
    this.JgB.put(-82, b.i.setting_unbind_qq_err_one_left);
    this.JgB.put(-83, b.i.setting_unbind_qq_err_has_unbind);
    this.JgB.put(-84, b.i.setting_unbind_qq_err_hasbinded);
    this.JgB.put(-85, b.i.setting_unbind_email_err_bindedbyother);
    this.JgB.put(-86, b.i.setting_unbind_qq_err_qmail);
    AppMethodBeat.o(74075);
  }
  
  private void fGd()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.byG("settings_username");
    String str1 = z.bcZ();
    String str2 = z.bda();
    if (Util.isNullOrNil(str2))
    {
      if (as.bvU(str1)) {
        localPreference.aF(getString(b.i.settings_notset));
      }
      while ((!as.bvV(z.bcZ())) && (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.auO(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.aF(str1);
      }
    }
    localPreference.aF(str2);
    if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0) {
      localPreference.auO(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void fGe()
  {
    AppMethodBeat.i(74083);
    if (this.screen.byG("settings_manage_login_device") == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.dz("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void fGf()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.byG("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
    Log.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.aF(getString(b.i.settings_bind_qq_unbind));
      localIconSwitchKeyValuePreference.auJ(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.aF(str);
    localIconSwitchKeyValuePreference.auJ(1);
    AppMethodBeat.o(74084);
  }
  
  private void fGg()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new br();
    EventCenter.instance.publish((IEvent)localObject);
    if ((((br)localObject).fxv.fxw) && (((br)localObject).fxv.fxx) && (((br)localObject).fxv.fxy)) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((br)localObject).fxv.fxw), Boolean.valueOf(((br)localObject).fxv.fxx), Boolean.valueOf(((br)localObject).fxv.fxy) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).dz("settings_fingerprint_title", bool);
        AppMethodBeat.o(74085);
        return;
        bool = false;
      }
    }
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
    this.Jgx = View.inflate(this, b.g.sendrequest_dialog, null);
    this.Jgy = ((TextView)this.Jgx.findViewById(b.f.sendrequest_tip));
    this.Jgy.setText(getString(b.i.settings_independent_password_tip));
    this.Jgz = ((EditText)this.Jgx.findViewById(b.f.sendrequest_content));
    this.Jgz.setInputType(129);
    if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || (Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) != 1)) {
      this.screen.dz("settings_voiceprint_title", true);
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
      if (!com.tencent.mm.kernel.h.aHB())
      {
        Log.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.byG("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhs, Boolean.FALSE)).booleanValue()) && ((com.tencent.mm.kernel.h.aHG().aHp().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.fC(getString(b.i.app_new), b.e.new_tips_bg);
        localIconPreference.abe(0);
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
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    AppMethodBeat.o(74077);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74081);
    fGd();
    fGf();
    fGe();
    fGg();
    AppMethodBeat.o(74081);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    z.bcZ();
    if (Util.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((Util.isNullOrNil(z.bda())) && (as.bvV(z.bcZ())) && (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.aH(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.aH(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format(Jgw, new Object[] { LocaleUtil.getApplicationLanguage() });
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
        com.tencent.mm.by.c.ad(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = com.tencent.mm.n.h.axc().getValue("WeChatSafeCenterUrl");
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
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
        com.tencent.mm.by.c.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.h.aHG().aHp().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vhs, Boolean.FALSE);
          ((IconPreference)this.screen.byG("settings_voiceprint_title")).abe(8);
          this.screen.notifyDataSetChanged();
          Log.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        com.tencent.mm.by.c.ad(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new tj();
        paramf.fSQ.context = this;
        EventCenter.instance.publish(paramf);
        boolean bool = paramf.fSR.fSG;
        Log.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          w.makeText(getContext(), getString(b.i.face_settings_not_support), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        startActivity(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        com.tencent.mm.aa.c.aFn().c(ar.a.Vuw, ar.a.Vux);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    fGd();
    fGf();
    this.JgA = false;
    Object localObject = (IconPreference)this.screen.byG("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (com.tencent.mm.aa.c.aFn().b(ar.a.Vuw, ar.a.Vux))
    {
      ((IconPreference)localObject).aak(0);
      fGe();
      fGg();
      this.screen.dz("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.byG("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.byG("settings_about_vuserinfo");
      localPreference = this.screen.byG("settings_about_vuser_about");
      int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(66049, null));
      if (i == 0) {
        break label241;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).auM(b.i.contact_info_verify_user_title);
      if (az.a.ltt == null) {
        break label236;
      }
      localObject = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(i), 2.0F);
      label180:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74079);
      return;
      ((IconPreference)localObject).aak(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI
 * JD-Core Version:    0.7.0.1
 */