package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "adMgrUrl", "", "wechatExportUrl", "getWechatExportUrl", "()Ljava/lang/String;", "wechatExportUrl$delegate", "Lkotlin/Lazy;", "getBottomView", "Landroid/view/View;", "getResourceId", "", "isCN", "", "countryCode", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "startWebViewUI", "url", "setSpannableClick", "Landroid/widget/TextView;", "onSpanClick", "Lkotlin/Function1;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingsPermissionIndexUI
  extends MMPreference
{
  private String Pva;
  private final j Pvb;
  
  public SettingsPermissionIndexUI()
  {
    AppMethodBeat.i(299351);
    this.Pva = "";
    this.Pvb = k.cm((kotlin.g.a.a)SettingsPermissionIndexUI.d.Pvf);
    AppMethodBeat.o(299351);
  }
  
  private static void a(TextView paramTextView, kotlin.g.a.b<? super View, ah> paramb)
  {
    AppMethodBeat.i(299354);
    SpannableString localSpannableString = new SpannableString(paramTextView.getText());
    localSpannableString.setSpan(new c(paramb), 0, localSpannableString.length(), 17);
    paramTextView.setText((CharSequence)localSpannableString);
    p.a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(299354);
  }
  
  private static final boolean a(SettingsPermissionIndexUI paramSettingsPermissionIndexUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(299361);
    s.u(paramSettingsPermissionIndexUI, "this$0");
    paramSettingsPermissionIndexUI.finish();
    AppMethodBeat.o(299361);
    return true;
  }
  
  private final String gVZ()
  {
    AppMethodBeat.i(299358);
    String str = (String)this.Pvb.getValue();
    AppMethodBeat.o(299358);
    return str;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final View getBottomView()
  {
    AppMethodBeat.i(299377);
    Object localObject1 = af.mU((Context)getContext()).inflate(b.g.settings_privacy_ui_bottom_view, null);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(299377);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout)localObject1;
    final ah.f localf = new ah.f();
    localf.aqH = h.baE().ban().d(274436, "").toString();
    if (Util.isNullOrNil((String)localf.aqH)) {
      localf.aqH = LocaleUtil.getCurrentCountryCode();
    }
    if ((!Util.isNullOrNil((String)localf.aqH)) && (!Util.isAllAlpha((String)localf.aqH))) {
      localf.aqH = "";
    }
    if (n.T((String)localf.aqH, "cn", true))
    {
      localObject2 = (TextView)((LinearLayout)localObject1).findViewById(b.f.settings_privacy_summary_link_tv);
      s.s(localObject2, "it");
      a((TextView)localObject2, (kotlin.g.a.b)new a(this, localf));
      ((TextView)localObject2).setVisibility(0);
    }
    Object localObject2 = ((LinearLayout)localObject1).findViewById(b.f.settings_privacy_link_tv);
    s.s(localObject2, "bottomView.findViewById<…settings_privacy_link_tv)");
    a((TextView)localObject2, (kotlin.g.a.b)new b(this, localf));
    localObject1 = (View)localObject1;
    AppMethodBeat.o(299377);
    return localObject1;
  }
  
  public final int getResourceId()
  {
    return b.k.settings_permission_index;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299385);
    super.onCreate(paramBundle);
    setMMTitle(b.i.settings_privacy_permission_index);
    setBackBtn(new SettingsPermissionIndexUI..ExternalSyntheticLambda0(this));
    h.baC();
    int i;
    if (com.tencent.mm.kernel.b.aZr() == b.a.mCd)
    {
      paramBundle = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvG, "https://ads.privacy.qq.com/ads/wxoptout.html?media_source=101001");
      s.s(paramBundle, "service(IExptService::cl…ml?media_source=101001\" )");
      this.Pva = paramBundle;
      paramBundle = (CharSequence)this.Pva;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label364;
      }
      i = 1;
      label99:
      if ((i != 0) || (!n.U(this.Pva, "http", false))) {
        getPreferenceScreen().eh("setting_privacy_personal_ad_mgr", true);
      }
      h.baC();
      if (com.tencent.mm.kernel.b.aZr() != b.a.mCe) {
        break label374;
      }
      getPreferenceScreen().eh("setting_privacy_personal_info_export", true);
      paramBundle = (CharSequence)gVZ();
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label369;
      }
      i = 1;
      label181:
      if (i != 0) {
        getPreferenceScreen().eh("setting_wechat_personal_info_export", true);
      }
    }
    for (;;)
    {
      paramBundle = new qi();
      paramBundle.ikE = 2L;
      paramBundle.bMH();
      AppMethodBeat.o(299385);
      return;
      paramBundle = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvH, "");
      s.s(paramBundle, "service(IExptService::cl…dmanage_url_android, \"\" )");
      this.Pva = paramBundle;
      Object localObject = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvI, "");
      paramBundle = h.baE().ban().bbx("");
      if (!Util.isNullOrNil(this.Pva))
      {
        s.s(localObject, "adMgrCloseCountry");
        localObject = ((String)localObject).toLowerCase();
        s.s(localObject, "(this as java.lang.String).toLowerCase()");
        localObject = (CharSequence)localObject;
        s.s(paramBundle, "regCountry");
        paramBundle = paramBundle.toLowerCase();
        s.s(paramBundle, "(this as java.lang.String).toLowerCase()");
        if (!n.a((CharSequence)localObject, (CharSequence)paramBundle, false)) {
          break;
        }
      }
      this.Pva = "";
      break;
      label364:
      i = 0;
      break label99;
      label369:
      i = 0;
      break label181;
      label374:
      getPreferenceScreen().eh("setting_wechat_personal_info_export", true);
    }
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(299390);
    s.checkNotNull(paramPreference);
    paramf = paramPreference.mKey;
    if (paramf != null) {}
    switch (paramf.hashCode())
    {
    default: 
    case 1795686324: 
    case -1179310352: 
    case 765127884: 
    case -2127957195: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(299390);
              return false;
            } while (!paramf.equals("settings_privacy_sys_permission"));
            paramf = new Intent((Context)getContext(), SettingsSystemPermissionUI.class);
            paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramf = new qi();
            paramf.ikE = 52L;
            paramf.bMH();
            AppMethodBeat.o(299390);
            return true;
          } while (!paramf.equals("setting_wechat_personal_info_export"));
          paramf = new Intent();
          paramf.putExtra("showShare", false);
          paramf.putExtra("rawUrl", gVZ());
          paramf.putExtra("show_feedback", false);
          paramf.putExtra("show_bottom", false);
          paramf.putExtra("needRedirect", false);
          paramf.putExtra("neverGetA8Key", false);
          com.tencent.mm.br.c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramf);
          paramf = new qi();
          paramf.ikE = 51L;
          paramf.bMH();
          AppMethodBeat.o(299390);
          return true;
        } while (!paramf.equals("setting_privacy_personal_info_export"));
        paramf = new Intent((Context)getContext(), SettingsPersonalInfoPreviewUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf = new qi();
        paramf.ikE = 51L;
        paramf.bMH();
        AppMethodBeat.o(299390);
        return true;
      } while (!paramf.equals("setting_privacy_personal_ad_mgr"));
      paramf = this.Pva;
      if (!Util.isNullOrNil(paramf))
      {
        paramf = w.q(paramf, new String[] { s.X("lang=", LocaleUtil.getCurrentLanguage((Context)this)) });
        s.s(paramf, "safelyUrlConcatParam(raw…tCurrentLanguage(this)}\")");
      }
      break;
    }
    for (;;)
    {
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", false);
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("show_feedback", false);
      paramPreference.putExtra("show_bottom", false);
      paramPreference.putExtra("needRedirect", false);
      paramPreference.putExtra("neverGetA8Key", false);
      com.tencent.mm.br.c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      paramf = new qi();
      paramf.ikE = 54L;
      paramf.bMH();
      AppMethodBeat.o(299390);
      return true;
      if (!paramf.equals("settings_privacy_app_permission")) {
        break;
      }
      paramf = new Intent((Context)this, SettingsAuthUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = new qi();
      paramf.ikE = 53L;
      paramf.bMH();
      AppMethodBeat.o(299390);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    a(SettingsPermissionIndexUI paramSettingsPermissionIndexUI, ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    b(SettingsPermissionIndexUI paramSettingsPermissionIndexUI, ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsPermissionIndexUI$setSpannableClick$1", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends t
  {
    c(kotlin.g.a.b<? super View, ah> paramb)
    {
      super(null);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(298933);
      s.u(paramView, "widget");
      this.Pve.invoke(paramView);
      AppMethodBeat.o(298933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPermissionIndexUI
 * JD-Core Version:    0.7.0.1
 */