package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ba;
import com.tencent.mm.h.a.ba.a;
import com.tencent.mm.h.a.ny;
import com.tencent.mm.h.a.ny.b;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.c;

public class SettingsAccountInfoUI
  extends MMPreference
  implements m.b
{
  private f dnn;
  private View nTC;
  private TextView nTD;
  private EditText nTE;
  private boolean nTF;
  private SparseIntArray nTG = new SparseIntArray();
  
  public SettingsAccountInfoUI()
  {
    this.nTG.put(0, a.i.settings_confirm_email_success_tip);
    this.nTG.put(-82, a.i.setting_unbind_qq_err_one_left);
    this.nTG.put(-83, a.i.setting_unbind_qq_err_has_unbind);
    this.nTG.put(-84, a.i.setting_unbind_qq_err_hasbinded);
    this.nTG.put(-85, a.i.setting_unbind_email_err_bindedbyother);
    this.nTG.put(-86, a.i.setting_unbind_qq_err_qmail);
  }
  
  private void byV()
  {
    Preference localPreference = this.dnn.add("settings_username");
    String str = q.Gk();
    if (bk.bl(str))
    {
      str = q.Gj();
      if (ad.aaX(str))
      {
        localPreference.setSummary(getString(a.i.settings_notset));
        return;
      }
      localPreference.setSummary(str);
      return;
    }
    localPreference.setSummary(str);
  }
  
  private void byW()
  {
    if (this.dnn.add("settings_manage_login_device") == null)
    {
      y.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      return;
    }
    this.dnn.bJ("settings_manage_login_device", false);
  }
  
  private void byX()
  {
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.dnn.add("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      y.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      return;
    }
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(6, null);
    y.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(a.i.settings_bind_qq_unbind));
      localIconSwitchKeyValuePreference.GA(0);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.GA(1);
  }
  
  private void byY()
  {
    boolean bool = true;
    Object localObject = new ba();
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    if ((((ba)localObject).bHm.bHn) && (((ba)localObject).bHm.bHo) && (((ba)localObject).bHm.bHp)) {}
    for (int i = 1;; i = 0)
    {
      y.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((ba)localObject).bHm.bHn), Boolean.valueOf(((ba)localObject).bHm.bHo), Boolean.valueOf(((ba)localObject).bHm.bHp) });
      localObject = this.dnn;
      if (i == 0) {}
      for (;;)
      {
        ((f)localObject).bJ("settings_fingerprint_title", bool);
        return;
        bool = false;
      }
    }
  }
  
  public final boolean XI()
  {
    return true;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    byV();
    byX();
    byW();
    byY();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    q.Gj();
    if (bk.bl(paramf)) {
      return false;
    }
    if ((paramf.equals("settings_username")) && (bk.bl(q.Gk())) && (ad.aaY(q.Gj()))) {
      Y(SettingsAliasUI.class);
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.C(this, paramf);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[] { x.cqJ() });
      bk.I(this.mController.uMN, paramf);
    }
    for (;;)
    {
      return false;
      if (paramf.equals("settings_independent_password"))
      {
        paramf = new Intent();
        paramf.putExtra("kintent_hint", getString(a.i.settings_modify_password_tip));
        a(RegByMobileSetPwdUI.class, paramf);
      }
      else if (paramf.equals("settings_manage_login_device"))
      {
        d.x(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramf = getString(a.i.wechat_securiy_center_path);
        paramf = paramf + x.cqJ();
        paramPreference = this.mController.uMN;
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
        d.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.DP().Dz().getInt(40, 0) & 0x20000) == 0))
        {
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uox, Boolean.valueOf(false));
          ((IconPreference)this.dnn.add("settings_voiceprint_title")).Gt(8);
          this.dnn.notifyDataSetChanged();
          y.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        d.x(this.mController.uMN, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new ny();
        paramf.bXK.context = this;
        com.tencent.mm.sdk.b.a.udP.m(paramf);
        boolean bool = paramf.bXL.bXC;
        y.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          com.tencent.mm.ui.base.s.makeText(this.mController.uMN, getString(a.i.face_settings_not_support), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        Y(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        c.BS().c(ac.a.uyT, ac.a.uyU);
        Y(SettingsMoreSafeUI.class);
      }
    }
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_account_info);
    this.dnn = this.vdd;
    this.nTC = View.inflate(this, a.g.sendrequest_dialog, null);
    this.nTD = ((TextView)this.nTC.findViewById(a.f.sendrequest_tip));
    this.nTD.setText(getString(a.i.settings_independent_password_tip));
    this.nTE = ((EditText)this.nTC.findViewById(a.f.sendrequest_content));
    this.nTE.setInputType(129);
    if (bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) != 1) {
      this.dnn.bJ("settings_voiceprint_title", true);
    }
    for (;;)
    {
      setBackBtn(new SettingsAccountInfoUI.1(this));
      return;
      if (!com.tencent.mm.kernel.g.DK())
      {
        y.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_voiceprint_title");
      if ((((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uox, Boolean.valueOf(true))).booleanValue()) && ((com.tencent.mm.kernel.g.DP().Dz().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.dD(getString(a.i.app_new), a.e.new_tips_bg);
        localIconPreference.Gt(0);
        y.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
        this.dnn.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.DP().Dz().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.DP().Dz().b(this);
  }
  
  protected void onResume()
  {
    byV();
    byX();
    this.nTF = false;
    Object localObject = (IconPreference)this.dnn.add("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (c.BS().b(ac.a.uyT, ac.a.uyU))
    {
      ((IconPreference)localObject).Gv(0);
      byW();
      byY();
      this.dnn.bJ("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.dnn.add("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.dnn.add("settings_about_vuserinfo");
      localPreference = this.dnn.add("settings_about_vuser_about");
      int i = bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(66049, null));
      if (i == 0) {
        break label228;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).GC(a.i.contact_info_verify_user_title);
      if (am.a.dVA == null) {
        break label223;
      }
      localObject = BackwardSupportUtil.b.e(am.a.dVA.hL(i), 2.0F);
      label173:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)com.tencent.mm.kernel.g.DP().Dz().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      return;
      ((IconPreference)localObject).Gv(8);
      break;
      label223:
      localObject = null;
      break label173;
      label228:
      this.dnn.c((Preference)localObject);
      this.dnn.c(localSelfVuserPreference);
      this.dnn.c(localPreference);
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref_account_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI
 * JD-Core Version:    0.7.0.1
 */