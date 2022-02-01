package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.w;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@k
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements i
{
  private boolean JfS;
  private cee JfT;
  private int JfU;
  Intent JfV;
  private ProgressDialog JfW;
  private MTimerHandler JfX;
  private i JfY;
  private com.tencent.mm.plugin.updater.a.b JfZ;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsAboutMicroMsgUI()
  {
    AppMethodBeat.i(264742);
    this.JfS = false;
    this.JfU = 0;
    this.JfV = null;
    this.JfY = null;
    this.JfZ = new com.tencent.mm.plugin.updater.a.b()
    {
      public final void xO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(263198);
        if (paramAnonymousBoolean) {
          SettingsAboutMicroMsgUI.h(SettingsAboutMicroMsgUI.this);
        }
        AppMethodBeat.o(263198);
      }
    };
    AppMethodBeat.o(264742);
  }
  
  private void fFX()
  {
    AppMethodBeat.i(164132);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.auC(b.k.settings_pref_about_micromsg);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.byG("settings_about_mm_header");
    Object localObject1;
    Object localObject2;
    int i;
    if ((com.tencent.mm.protocal.d.RAD >= 671088896) && (com.tencent.mm.protocal.d.RAD <= 671089151))
    {
      localObject1 = "8.0.1";
      if (!com.tencent.mm.protocal.d.RAG)
      {
        localObject2 = localObject1;
        if (!BuildInfo.IS_FLAVOR_BLUE) {}
      }
      else
      {
        localObject2 = (String)localObject1 + " " + com.tencent.mm.cj.h.kv(this);
      }
      localSettingsAboutMMHeaderPreference.JfL = ((String)localObject2);
      if (LocaleUtil.isSimplifiedChineseAppLang())
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12304, null));
        localObject1 = (IconPreference)this.screen.byG("settings_update");
        if (i <= 0) {
          break label458;
        }
        ((IconPreference)localObject1).abe(0);
        ((IconPreference)localObject1).fC(String.valueOf(i), w.bj(getContext(), i));
      }
      label182:
      if ((ChannelUtil.updateMode & 0x1) == 0) {
        break label475;
      }
      i = 1;
      label192:
      if ((!this.JfS) || (ChannelUtil.isNokiaAol)) {
        break label480;
      }
      localObject1 = (IconSummaryPreference)this.screen.byG("funtion_update");
      ((IconSummaryPreference)localObject1).GRI = 0;
      localObject2 = ChannelUtil.formatVersion(null, this.JfU);
      ((IconSummaryPreference)localObject1).fC(getString(b.i.app_new), b.e.new_tips_bg);
      ((IconSummaryPreference)localObject1).aF((CharSequence)localObject2);
      ((IconSummaryPreference)localObject1).hKL();
      this.screen.byI("funtion_check_update");
      label271:
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.screen.dz("settings_report", true);
      }
      if (!com.tencent.mm.pluginsdk.j.c.QYP.abN()) {
        this.screen.dz("funtion_about_wechat", true);
      }
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqa, null))) {
        break label745;
      }
      localObject1 = (IconPreference)this.screen.byG("funtion_crowdtest_update");
      if (com.tencent.mm.aa.c.aFn().dk(262157, 266263)) {
        ((IconPreference)localObject1).aak(0);
      }
      label374:
      if (BuildInfo.IS_FLAVOR_BLUE) {
        break label761;
      }
      this.screen.dz("funtion_about_flavor_blue", true);
      this.screen.dz("funtion_invite_flavor_blue", true);
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetAboutIntros.banned()) {
        this.screen.byI("settings_update");
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(164132);
      return;
      localObject1 = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.RAD);
      break;
      label458:
      ((IconPreference)localObject1).abe(8);
      ((IconPreference)localObject1).fC("", -1);
      break label182;
      label475:
      i = 0;
      break label192;
      label480:
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        localObject1 = (IconSummaryPreference)this.screen.byG("funtion_update");
        ((IconSummaryPreference)localObject1).GRI = 0;
        localObject2 = ChannelUtil.formatVersion(null, ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion());
        ((IconSummaryPreference)localObject1).fC(getString(b.i.app_new), b.e.new_tips_bg);
        ((IconSummaryPreference)localObject1).aF((CharSequence)localObject2);
        ((IconSummaryPreference)localObject1).hKL();
        this.screen.byI("funtion_check_update");
        break label271;
      }
      if ((i == 0) && (this.JfT != null) && (this.JfT.TlR != 0) && (!Util.isNullOrNil(this.JfT.TlS)) && (!ChannelUtil.isNokiaAol))
      {
        Log.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.JfT.TlS, Integer.valueOf(this.JfT.TlT) });
        if (this.JfT.TlT != 0)
        {
          localObject1 = (IconSummaryPreference)this.screen.byG("funtion_update");
          ((IconSummaryPreference)localObject1).GRI = 0;
          ((IconSummaryPreference)localObject1).fC(getString(b.i.app_new), b.e.new_tips_bg);
          this.screen.byI("funtion_check_update");
          break label271;
        }
        this.screen.byI("funtion_update");
        break label271;
      }
      this.screen.byI("funtion_update");
      break label271;
      label745:
      this.screen.byI("funtion_crowdtest_update");
      break label374;
      label761:
      localObject1 = (IconPreference)this.screen.byG("funtion_about_flavor_blue");
      if (com.tencent.mm.aa.c.aFn().dk(262164, 266270)) {
        ((IconPreference)localObject1).aak(0);
      }
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(74029);
    LinearLayout localLinearLayout = (LinearLayout)ad.kS(getContext()).inflate(b.g.settings_about_micromsg_footer, null);
    Object localObject3 = (TextView)localLinearLayout.findViewById(b.f.terms_of_service);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(b.f.terms_of_privacy);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(b.f.terms_of_lbs);
    Object localObject2 = com.tencent.mm.kernel.h.aHG().aHp().b(274436, "").toString();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = LocaleUtil.getCurrentCountryCode();
    }
    localObject2 = localObject1;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (!Util.isAllAlpha((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(b.i.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    String str1 = getString(b.i.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2 });
    String str2 = getString(b.i.lbs_term_url, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2 });
    ((TextView)localObject3).setText(String.format("<a href='%s'>%s</a>", new Object[] { str1, getString(b.i.license_detail) }));
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(b.i.privacy_detail) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { str2, getString(b.i.lbs_term) }));
    l.q((TextView)localObject3, 1);
    l.q(localTextView1, 1);
    l.q(localTextView2, 1);
    if (((String)localObject2).equalsIgnoreCase("KR")) {
      localTextView2.setVisibility(0);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(b.f.copyright_desc_tv);
    int i = 2020;
    try
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(BuildInfo.TIME);
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).setTime((Date)localObject2);
      int j = ((Calendar)localObject3).get(1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SettingsAboutMicroMsgUI", localException, "", new Object[0]);
      }
    }
    ((TextView)localObject1).setText(localLinearLayout.getResources().getString(b.i.app_copyright, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(74029);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_about_micromsg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74033);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(b.c.BG_2));
    setNavigationbarColor(getContext().getResources().getColor(b.c.BG_2));
    setBackGroundColorResource(b.c.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74019);
        SettingsAboutMicroMsgUI.this.hideVKB();
        SettingsAboutMicroMsgUI.this.finish();
        AppMethodBeat.o(74019);
        return true;
      }
    });
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(b.d.Edge_3A);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(b.c.BG_2));
    }
    fFX();
    AppMethodBeat.o(74033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74030);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    com.tencent.mm.kernel.h.aGY().a(11, this);
    if (com.tencent.mm.plugin.y.d.eUZ() != null)
    {
      paramBundle = com.tencent.mm.plugin.y.d.eUZ().eUY();
      com.tencent.mm.kernel.h.aGY().a((q)paramBundle, 0);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 15L, 1L, true);
    }
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).addManualCheckUpdateListener(this.JfZ);
    AppMethodBeat.o(74030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74032);
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).removeManualCheckUpdateListener(this.JfZ);
    com.tencent.mm.kernel.h.aGY().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(74032);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74035);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    Log.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    Log.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update"))
    {
      if (LocaleUtil.isSimplifiedChineseAppLang())
      {
        com.tencent.mm.kernel.h.aHE();
        int i = com.tencent.mm.kernel.b.getUin();
        int j = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12304, null));
        paramf = getString(b.i.settings_system_notice_url, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (paramf == null)
        {
          AppMethodBeat.o(74035);
          return true;
        }
        com.tencent.mm.kernel.h.aHG().aHp().i(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(b.i.settings_system_notice));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
      if (LocaleUtil.isSimplifiedChineseAppLang()) {}
      for (paramf = getString(b.i.settings_funtion_update_cv_url, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(com.tencent.mm.protocal.d.RAD) });; paramf = "https://" + WeChatHosts.domainString(b.i.host_blog_wechat_com) + "/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
    }
    if (paramf.equals("funtion_update"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 16L, 1L, true);
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", true);
      paramPreference.putExtra("show_bottom", false);
      if (this.JfS) {
        paramf = getString(b.i.settings_funtion_update_nv_url, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(this.JfU), Integer.valueOf(1) });
      }
    }
    for (;;)
    {
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).clickCheckUpdateRedDot();
      AppMethodBeat.o(74035);
      return true;
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        paramf = getString(b.i.settings_funtion_update_nv_url, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion()), Integer.valueOf(1) });
        paramPreference.putExtra("showShare", false);
      }
      else if ((this.JfT != null) && (this.JfT.TlR != 0) && (!Util.isNullOrNil(this.JfT.TlS)))
      {
        paramf = this.JfT.TlS;
        continue;
        if (paramf.equals("funtion_check_update"))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 17L, 1L, true);
          if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
          {
            ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(0);
            AppMethodBeat.o(74035);
            return true;
          }
          if (com.tencent.mm.plugin.y.d.eUZ() != null)
          {
            com.tencent.mm.plugin.y.d.eUZ().eUX();
            if ((ChannelUtil.updateMode & 0x1) != 0)
            {
              Log.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
              paramf = Uri.parse(ChannelUtil.marketURL);
              paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
              if ((paramf == null) || (paramPreference == null) || (!Util.isIntentAvailable(getContext(), paramPreference)))
              {
                Log.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                paramf = new Intent("android.intent.action.VIEW", Uri.parse(com.tencent.mm.ui.f.VRS)).addFlags(268435456);
                paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
                com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 18L, 1L, true);
              }
              for (;;)
              {
                AppMethodBeat.o(74035);
                return true;
                Log.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
                com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 19L, 1L, true);
              }
            }
            if ((this.JfT != null) && (this.JfT.TlR != 0) && (!Util.isNullOrNil(this.JfT.TlS)))
            {
              paramf = this.JfT.TlS;
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf);
              paramPreference.putExtra("showShare", false);
              paramPreference.putExtra("show_bottom", false);
              com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 20L, 1L, true);
              AppMethodBeat.o(74035);
              return true;
            }
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
            paramf = com.tencent.mm.plugin.y.d.eUZ().b(this, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(74028);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 23L, 1L, true);
                AppMethodBeat.o(74028);
              }
            });
            if (paramf == null) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 21L, 1L, true);
            }
          }
          else
          {
            AppMethodBeat.o(74035);
            return false;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 22L, 1L, true);
          paramf.update(3);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_wechat"))
        {
          paramf = new Intent();
          paramf.putExtra("from_about", true);
          com.tencent.mm.by.c.b(this, "whatsnew", ".ui.WhatsNewUI", paramf);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_report"))
        {
          paramf = "https://" + WeChatHosts.domainString(b.i.host_support_weixin_qq_com) + "/security/readtemplate?t=complaints/index";
          paramPreference = new Intent();
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_feedback", false);
          paramPreference.putExtra("rawUrl", paramf);
          com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_quit_wechat"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), b.i.main_exit_warning, b.i.main_exit_title, b.i.app_yes, b.i.app_no, new DialogInterface.OnClickListener()
          {
            private MTimerHandler lUQ = null;
            private i onSceneEndCallback = null;
            
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74023);
              com.tencent.mm.modelstat.c.bpr().iq();
              ((e)com.tencent.mm.kernel.h.ae(e.class)).dbv();
              com.tencent.mm.kernel.h.aHH();
              Object localObject1;
              Object localObject2;
              if (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN))
              {
                paramAnonymousDialogInterface = com.tencent.mm.kernel.h.aGY();
                localObject1 = new i()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
                  {
                    AppMethodBeat.i(74020);
                    com.tencent.mm.kernel.h.aGY().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
                    SettingsAboutMicroMsgUI.2.b(SettingsAboutMicroMsgUI.2.this);
                    if (SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this) != null)
                    {
                      SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this).stopTimer();
                      SettingsAboutMicroMsgUI.2.d(SettingsAboutMicroMsgUI.2.this);
                    }
                    if (SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this) != null) {
                      SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this).dismiss();
                    }
                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                    AppMethodBeat.o(74020);
                  }
                };
                this.onSceneEndCallback = ((i)localObject1);
                paramAnonymousDialogInterface.a(281, (i)localObject1);
                localObject1 = new ae(2);
                com.tencent.mm.kernel.h.aGY().a((q)localObject1, 0);
                this.lUQ = new MTimerHandler(new MTimerHandler.CallBack()
                {
                  public final boolean onTimerExpired()
                  {
                    AppMethodBeat.i(74021);
                    com.tencent.mm.kernel.h.aGY().a(this.Jgc);
                    com.tencent.mm.kernel.h.aGY().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
                    SettingsAboutMicroMsgUI.2.b(SettingsAboutMicroMsgUI.2.this);
                    if (SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this) != null)
                    {
                      SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this).stopTimer();
                      SettingsAboutMicroMsgUI.2.d(SettingsAboutMicroMsgUI.2.this);
                    }
                    if (SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this) != null) {
                      SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this).dismiss();
                    }
                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                    AppMethodBeat.o(74021);
                    return false;
                  }
                }, false);
                this.lUQ.startTimer(5000L);
                localObject2 = (o)com.tencent.mm.kernel.h.ae(o.class);
                paramAnonymousDialogInterface = SettingsAboutMicroMsgUI.this.getString(b.i.webwx_logout_processing_txt);
                if (Util.isNullOrNil(((o)localObject2).bod())) {
                  break label242;
                }
                paramAnonymousDialogInterface = ((o)localObject2).bod() + "...";
              }
              label242:
              for (;;)
              {
                localObject2 = SettingsAboutMicroMsgUI.this;
                AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.getContext();
                SettingsAboutMicroMsgUI.this.getString(b.i.app_tip);
                SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject2, com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramAnonymousDialogInterface, true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(74022);
                    com.tencent.mm.kernel.h.aGY().a(this.Jgc);
                    com.tencent.mm.kernel.h.aGY().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
                    SettingsAboutMicroMsgUI.2.b(SettingsAboutMicroMsgUI.2.this);
                    if (SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this) != null)
                    {
                      SettingsAboutMicroMsgUI.2.c(SettingsAboutMicroMsgUI.2.this).stopTimer();
                      SettingsAboutMicroMsgUI.2.d(SettingsAboutMicroMsgUI.2.this);
                    }
                    if (SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this) != null) {
                      SettingsAboutMicroMsgUI.a(SettingsAboutMicroMsgUI.this).dismiss();
                    }
                    AppMethodBeat.o(74022);
                  }
                }));
                AppMethodBeat.o(74023);
                return;
                SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                AppMethodBeat.o(74023);
                return;
              }
            }
          }, null);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_crowdtest_update"))
        {
          com.tencent.mm.aa.c.aFn().dl(262157, 266263);
          paramf = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqa, null);
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_flavor_blue"))
        {
          com.tencent.mm.aa.c.aFn().dl(262164, 266270);
          com.tencent.mm.aa.c.aFn().D(262164, false);
          paramf = getContext();
          paramPreference = new Intent(this, SettingsAboutMicroMsgFlavorBlue.class);
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(74035);
          return false;
          if (paramf.equals("funtion_invite_flavor_blue"))
          {
            paramf = new Intent();
            paramf.putExtra("title", getString(b.i.funtion_invite_flavor_blue));
            paramf.putExtra("rawUrl", "https://mp.weixin.qq.com/wxawap/devwxsubscribe#wechat_redirect");
            paramf.putExtra("showShare", false);
            paramf.putExtra("show_bottom", false);
            com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
          }
        }
      }
      else
      {
        paramf = "";
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74031);
    super.onResume();
    fFX();
    AppMethodBeat.o(74031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74036);
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (com.tencent.mm.plugin.y.b)paramq;
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.eUV());
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.eUU());
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.RAD);
    if ((com.tencent.mm.plugin.y.d.FjN) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.JfU = paramString.eUU();
      if ((this.JfU <= 0) || (this.JfU <= com.tencent.mm.protocal.d.RAD)) {
        break label211;
      }
      this.JfS = true;
      if (!com.tencent.mm.kernel.h.aHE().aGM()) {
        Log.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      }
    }
    for (;;)
    {
      this.JfT = paramString.eUW();
      fFX();
      AppMethodBeat.o(74036);
      return;
      label211:
      this.JfS = false;
      if (!com.tencent.mm.kernel.h.aHE().aGM()) {
        break;
      }
      com.tencent.mm.aa.c.aFn().C(262145, false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI
 * JD-Core Version:    0.7.0.1
 */