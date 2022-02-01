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
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.bm.a;
import com.tencent.mm.g.a.si;
import com.tencent.mm.g.a.si.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
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
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.a;

public class SettingsAccountInfoUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private static final String DaV;
  private View DaW;
  private TextView DaX;
  private EditText DaY;
  private boolean DaZ;
  private SparseIntArray Dba;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(256510);
    DaV = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s";
    AppMethodBeat.o(256510);
  }
  
  public SettingsAccountInfoUI()
  {
    AppMethodBeat.i(74075);
    this.Dba = new SparseIntArray();
    this.Dba.put(0, 2131765370);
    this.Dba.put(-82, 2131765304);
    this.Dba.put(-83, 2131765301);
    this.Dba.put(-84, 2131765302);
    this.Dba.put(-85, 2131765295);
    this.Dba.put(-86, 2131765306);
    AppMethodBeat.o(74075);
  }
  
  private void eSZ()
  {
    AppMethodBeat.i(74082);
    Preference localPreference = this.screen.bmg("settings_username");
    String str1 = z.aTY();
    String str2 = z.aTZ();
    if (Util.isNullOrNil(str2))
    {
      if (as.bjx(str1)) {
        localPreference.setSummary(getString(2131765520));
      }
      while ((!as.bjy(z.aTY())) && (h.aqJ().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.alO(8);
        AppMethodBeat.o(74082);
        return;
        localPreference.setSummary(str1);
      }
    }
    localPreference.setSummary(str2);
    if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
      localPreference.alO(8);
    }
    AppMethodBeat.o(74082);
  }
  
  private void eTa()
  {
    AppMethodBeat.i(74083);
    if (this.screen.bmg("settings_manage_login_device") == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
      AppMethodBeat.o(74083);
      return;
    }
    this.screen.jdMethod_do("settings_manage_login_device", false);
    AppMethodBeat.o(74083);
  }
  
  private void eTb()
  {
    AppMethodBeat.i(74084);
    IconSwitchKeyValuePreference localIconSwitchKeyValuePreference = (IconSwitchKeyValuePreference)this.screen.bmg("settings_mobile");
    if (localIconSwitchKeyValuePreference == null)
    {
      Log.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
      AppMethodBeat.o(74084);
      return;
    }
    String str = (String)g.aAh().azQ().get(6, null);
    Log.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      localIconSwitchKeyValuePreference.setSummary(getString(2131765355));
      localIconSwitchKeyValuePreference.alK(0);
      AppMethodBeat.o(74084);
      return;
    }
    localIconSwitchKeyValuePreference.setSummary(str);
    localIconSwitchKeyValuePreference.alK(1);
    AppMethodBeat.o(74084);
  }
  
  private void eTc()
  {
    boolean bool = true;
    AppMethodBeat.i(74085);
    Object localObject = new bm();
    EventCenter.instance.publish((IEvent)localObject);
    if ((((bm)localObject).dEH.dEI) && (((bm)localObject).dEH.dEJ) && (((bm)localObject).dEH.dEK)) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[] { Boolean.valueOf(((bm)localObject).dEH.dEI), Boolean.valueOf(((bm)localObject).dEH.dEJ), Boolean.valueOf(((bm)localObject).dEH.dEK) });
      localObject = this.screen;
      if (i == 0) {}
      for (;;)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("settings_fingerprint_title", bool);
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
    return 2132017268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74078);
    setMMTitle(2131765329);
    this.screen = getPreferenceScreen();
    this.DaW = View.inflate(this, 2131496232, null);
    this.DaX = ((TextView)this.DaW.findViewById(2131307637));
    this.DaX.setText(getString(2131765414));
    this.DaY = ((EditText)this.DaW.findViewById(2131307636));
    this.DaY.setInputType(129);
    if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || (Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) != 1)) {
      this.screen.jdMethod_do("settings_voiceprint_title", true);
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
      if (!g.aAc())
      {
        Log.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
        AppMethodBeat.o(74078);
        return;
      }
      IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_voiceprint_title");
      if ((((Boolean)g.aAh().azQ().get(ar.a.NTs, Boolean.FALSE)).booleanValue()) && ((g.aAh().azQ().getInt(40, 0) & 0x20000) == 0))
      {
        localIconPreference.gY(getString(2131755915), 2131234232);
        localIconPreference.alD(0);
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
    g.aAh().azQ().add(this);
    AppMethodBeat.o(74076);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74077);
    super.onDestroy();
    g.aAh().azQ().remove(this);
    AppMethodBeat.o(74077);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74081);
    eSZ();
    eTb();
    eTa();
    eTc();
    AppMethodBeat.o(74081);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74080);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAccountInfoUI", paramf + " item has been clicked!");
    z.aTY();
    if (Util.isNullOrNil(paramf))
    {
      AppMethodBeat.o(74080);
      return false;
    }
    if (paramf.equals("settings_username"))
    {
      if ((Util.isNullOrNil(z.aTZ())) && (as.bjy(z.aTY())) && (h.aqJ().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74080);
        return true;
      }
      if (h.aqJ().getInt("EnableModAlias", 0) != 0)
      {
        paramPreference = new Intent(this, SettingsAliasUI.class);
        paramPreference.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.ay(this, paramPreference);
      }
    }
    if (paramf.equals("settings_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.ay(this, paramf);
      AppMethodBeat.o(74080);
      return true;
    }
    if (paramf.equals("settings_about_vuser_about"))
    {
      paramf = String.format(DaV, new Object[] { LocaleUtil.getApplicationLanguage() });
      Util.jump(getContext(), paramf);
    }
    for (;;)
    {
      AppMethodBeat.o(74080);
      return false;
      if (paramf.equals("settings_independent_password"))
      {
        paramf = new Intent();
        paramf.putExtra("kintent_hint", getString(2131765477));
        startActivity(RegByMobileSetPwdUI.class, paramf);
      }
      else if (paramf.equals("settings_manage_login_device"))
      {
        com.tencent.mm.br.c.V(this, "account", ".security.ui.MySafeDeviceListUI");
      }
      else if (paramf.equals("settings_security_center"))
      {
        paramPreference = h.aqJ().getValue("WeChatSafeCenterUrl");
        Log.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", new Object[] { paramPreference });
        paramf = paramPreference;
        if (Util.isNullOrNil(paramPreference)) {
          paramf = getString(2131768669) + LocaleUtil.getApplicationLanguage();
        }
        paramPreference = getContext();
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramf);
        localIntent.putExtra("showShare", true);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        com.tencent.mm.br.c.b(paramPreference, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      }
      else if (paramf.equals("settings_voiceprint_title"))
      {
        if ((Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) == 1) && ((g.aAh().azQ().getInt(40, 0) & 0x20000) == 0))
        {
          g.aAh().azQ().set(ar.a.NTs, Boolean.FALSE);
          ((IconPreference)this.screen.bmg("settings_voiceprint_title")).alD(8);
          this.screen.notifyDataSetChanged();
          Log.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
        }
        com.tencent.mm.br.c.V(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
      }
      else if (paramf.equals("settings_facedect_title"))
      {
        paramf = new si();
        paramf.dYX.context = this;
        EventCenter.instance.publish(paramf);
        boolean bool = paramf.dYY.dYN;
        Log.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u.makeText(getContext(), getString(2131759080), 0).show();
        }
      }
      else if (paramf.equals("settings_trust_friend"))
      {
        startActivity(SettingsTrustFriendUI.class);
      }
      else if (paramf.equals("settings_more_safe"))
      {
        com.tencent.mm.y.c.axV().c(ar.a.Ogg, ar.a.Ogh);
        startActivity(SettingsMoreSafeUI.class);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74079);
    eSZ();
    eTb();
    this.DaZ = false;
    Object localObject = (IconPreference)this.screen.bmg("settings_more_safe");
    SelfVuserPreference localSelfVuserPreference;
    Preference localPreference;
    if (com.tencent.mm.y.c.axV().b(ar.a.Ogg, ar.a.Ogh))
    {
      ((IconPreference)localObject).alF(0);
      eTa();
      eTc();
      this.screen.jdMethod_do("settings_facedect_title", true);
      localObject = (PluginTextPreference)this.screen.bmg("settings_about_vusertitle");
      localSelfVuserPreference = (SelfVuserPreference)this.screen.bmg("settings_about_vuserinfo");
      localPreference = this.screen.bmg("settings_about_vuser_about");
      int i = Util.nullAsNil((Integer)g.aAh().azQ().get(66049, null));
      if (i == 0) {
        break label241;
      }
      ((PluginTextPreference)localObject).visibility = 8;
      ((PluginTextPreference)localObject).alN(2131758135);
      if (ay.a.iDs == null) {
        break label236;
      }
      localObject = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(i), 2.0F);
      label180:
      localSelfVuserPreference.drawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localSelfVuserPreference.text = ((String)g.aAh().azQ().get(66050, null));
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74079);
      return;
      ((IconPreference)localObject).alF(8);
      break;
      label236:
      localObject = null;
      break label180;
      label241:
      this.screen.e((Preference)localObject);
      this.screen.e(localSelfVuserPreference);
      this.screen.e(localPreference);
    }
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