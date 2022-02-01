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
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bwo;
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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.v;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@com.tencent.mm.kernel.i
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.ak.i
{
  private boolean Dar;
  private bwo Das;
  private int Dat;
  Intent Dau;
  private ProgressDialog Dav;
  private MTimerHandler Daw;
  private com.tencent.mm.ak.i Dax;
  private com.tencent.mm.plugin.updater.a.b Day;
  private f screen;
  
  public SettingsAboutMicroMsgUI()
  {
    AppMethodBeat.i(256507);
    this.Dar = false;
    this.Dat = 0;
    this.Dau = null;
    this.Dax = null;
    this.Day = new com.tencent.mm.plugin.updater.a.b()
    {
      public final void uq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(256506);
        if (paramAnonymousBoolean) {
          SettingsAboutMicroMsgUI.h(SettingsAboutMicroMsgUI.this);
        }
        AppMethodBeat.o(256506);
      }
    };
    AppMethodBeat.o(256507);
  }
  
  private void eST()
  {
    AppMethodBeat.i(164132);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017267);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.bmg("settings_about_mm_header");
    String str = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.KyO);
    Object localObject;
    if (!com.tencent.mm.protocal.d.KyR)
    {
      localObject = str;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      localObject = str + " " + com.tencent.mm.cc.h.jr(this);
    }
    localSettingsAboutMMHeaderPreference.Dak = ((String)localObject);
    int i;
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      i = Util.nullAsNil((Integer)g.aAh().azQ().get(12304, null));
      localObject = (IconPreference)this.screen.bmg("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).alD(0);
        ((IconPreference)localObject).gY(String.valueOf(i), v.aQ(getContext(), i));
      }
    }
    else
    {
      if ((ChannelUtil.updateMode & 0x1) == 0) {
        break label449;
      }
      i = 1;
      label183:
      if ((!this.Dar) || (ChannelUtil.isNokiaAol)) {
        break label454;
      }
      localObject = (IconSummaryPreference)this.screen.bmg("funtion_update");
      ((IconSummaryPreference)localObject).CZl = 0;
      str = ChannelUtil.formatVersion(null, this.Dat);
      ((IconSummaryPreference)localObject).bmk(getString(2131755915));
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).gLH();
      this.screen.bmi("funtion_check_update");
      label259:
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.screen.jdMethod_do("settings_report", true);
      }
      if (!com.tencent.mm.pluginsdk.i.c.JYn.Xl()) {
        this.screen.jdMethod_do("funtion_about_wechat", true);
      }
      if (Util.isNullOrNil((String)g.aAh().azQ().get(ar.a.ObX, null))) {
        break label713;
      }
      localObject = (IconPreference)this.screen.bmg("funtion_crowdtest_update");
      if (com.tencent.mm.y.c.axV().cP(262157, 266263)) {
        ((IconPreference)localObject).alF(0);
      }
      label362:
      if (BuildInfo.IS_FLAVOR_BLUE) {
        break label729;
      }
      this.screen.jdMethod_do("funtion_about_flavor_blue", true);
      this.screen.jdMethod_do("funtion_invite_flavor_blue", true);
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeSetAboutIntros.banned()) {
        this.screen.bmi("settings_update");
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(164132);
      return;
      ((IconPreference)localObject).alD(8);
      ((IconPreference)localObject).gY("", -1);
      break;
      label449:
      i = 0;
      break label183;
      label454:
      if (((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        localObject = (IconSummaryPreference)this.screen.bmg("funtion_update");
        ((IconSummaryPreference)localObject).CZl = 0;
        str = ChannelUtil.formatVersion(null, ((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion());
        ((IconSummaryPreference)localObject).bmk(getString(2131755915));
        ((IconSummaryPreference)localObject).setSummary(str);
        ((IconSummaryPreference)localObject).gLH();
        this.screen.bmi("funtion_check_update");
        break label259;
      }
      if ((i == 0) && (this.Das != null) && (this.Das.Mcs != 0) && (!Util.isNullOrNil(this.Das.Mct)) && (!ChannelUtil.isNokiaAol))
      {
        Log.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.Das.Mct, Integer.valueOf(this.Das.Mcu) });
        if (this.Das.Mcu != 0)
        {
          localObject = (IconSummaryPreference)this.screen.bmg("funtion_update");
          ((IconSummaryPreference)localObject).CZl = 0;
          ((IconSummaryPreference)localObject).bmk(getString(2131755915));
          this.screen.bmi("funtion_check_update");
          break label259;
        }
        this.screen.bmi("funtion_update");
        break label259;
      }
      this.screen.bmi("funtion_update");
      break label259;
      label713:
      this.screen.bmi("funtion_crowdtest_update");
      break label362;
      label729:
      localObject = (IconPreference)this.screen.bmg("funtion_about_flavor_blue");
      if (com.tencent.mm.y.c.axV().cP(262164, 266270)) {
        ((IconPreference)localObject).alF(0);
      }
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(74029);
    LinearLayout localLinearLayout = (LinearLayout)aa.jQ(getContext()).inflate(2131496242, null);
    Object localObject3 = (TextView)localLinearLayout.findViewById(2131308971);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131308970);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131308969);
    Object localObject2 = g.aAh().azQ().get(274436, "").toString();
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
    localObject1 = getString(2131762219, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    String str1 = getString(2131766959, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2 });
    String str2 = getString(2131762211, new Object[] { LocaleUtil.getApplicationLanguage(), localObject2 });
    ((TextView)localObject3).setText(String.format("<a href='%s'>%s</a>", new Object[] { str1, getString(2131762214) }));
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(2131764020) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { str2, getString(2131762210) }));
    l.p((TextView)localObject3, 1);
    l.p(localTextView1, 1);
    l.p(localTextView2, 1);
    if (((String)localObject2).equalsIgnoreCase("KR")) {
      localTextView2.setVisibility(0);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(2131299250);
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
    ((TextView)localObject1).setText(localLinearLayout.getResources().getString(2131755774, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(74029);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return 2132017267;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74033);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099650));
    setBackGroundColorResource(2131101424);
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
      int i = getContext().getResources().getDimensionPixelSize(2131165299);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(2131099650));
    }
    eST();
    AppMethodBeat.o(74033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74030);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    g.azz().a(11, this);
    if (com.tencent.mm.plugin.p.d.elq() != null)
    {
      paramBundle = com.tencent.mm.plugin.p.d.elq().elp();
      g.azz().a((q)paramBundle, 0);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 15L, 1L, true);
    }
    ((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).addManualCheckUpdateListener(this.Day);
    AppMethodBeat.o(74030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74032);
    ((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).removeManualCheckUpdateListener(this.Day);
    g.azz().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(74032);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
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
        g.aAf();
        paramf = getString(2131765632, new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(Util.nullAsNil((Integer)g.aAh().azQ().get(12304, null))) });
        if (paramf == null)
        {
          AppMethodBeat.o(74035);
          return true;
        }
        g.aAh().azQ().set(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(2131765631));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
      if (LocaleUtil.isSimplifiedChineseAppLang()) {}
      for (paramf = getString(2131765407, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });; paramf = "https://" + WeChatHosts.domainString(2131761705) + "/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
    }
    if (paramf.equals("funtion_update"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 16L, 1L, true);
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", true);
      paramPreference.putExtra("show_bottom", false);
      if (this.Dar) {
        paramf = getString(2131765408, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(this.Dat), Integer.valueOf(1) });
      }
    }
    for (;;)
    {
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      ((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickCheckUpdateRedDot();
      AppMethodBeat.o(74035);
      return true;
      if (((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        paramf = getString(2131765408, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion()), Integer.valueOf(1) });
        paramPreference.putExtra("showShare", false);
      }
      else if ((this.Das != null) && (this.Das.Mcs != 0) && (!Util.isNullOrNil(this.Das.Mct)))
      {
        paramf = this.Das.Mct;
        continue;
        if (paramf.equals("funtion_check_update"))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 17L, 1L, true);
          if (((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
          {
            ((com.tencent.mm.plugin.updater.a.a)g.ah(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(0);
            AppMethodBeat.o(74035);
            return true;
          }
          if (com.tencent.mm.plugin.p.d.elq() != null)
          {
            com.tencent.mm.plugin.p.d.elq().elo();
            if ((ChannelUtil.updateMode & 0x1) != 0)
            {
              Log.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
              paramf = Uri.parse(ChannelUtil.marketURL);
              paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
              if ((paramf == null) || (paramPreference == null) || (!Util.isIntentAvailable(getContext(), paramPreference)))
              {
                Log.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                paramf = new Intent("android.intent.action.VIEW", Uri.parse(com.tencent.mm.ui.e.OyP)).addFlags(268435456);
                paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 18L, 1L, true);
              }
              for (;;)
              {
                AppMethodBeat.o(74035);
                return true;
                Log.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 19L, 1L, true);
              }
            }
            if ((this.Das != null) && (this.Das.Mcs != 0) && (!Util.isNullOrNil(this.Das.Mct)))
            {
              paramf = this.Das.Mct;
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf);
              paramPreference.putExtra("showShare", false);
              paramPreference.putExtra("show_bottom", false);
              com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 20L, 1L, true);
              AppMethodBeat.o(74035);
              return true;
            }
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
            paramf = com.tencent.mm.plugin.p.d.elq().c(this, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(74028);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 23L, 1L, true);
                AppMethodBeat.o(74028);
              }
            });
            if (paramf == null) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 21L, 1L, true);
            }
          }
          else
          {
            AppMethodBeat.o(74035);
            return false;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 22L, 1L, true);
          paramf.update(3);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_wechat"))
        {
          paramf = new Intent();
          paramf.putExtra("from_about", true);
          com.tencent.mm.br.c.b(this, "whatsnew", ".ui.WhatsNewUI", paramf);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_report"))
        {
          paramf = "https://" + WeChatHosts.domainString(2131761742) + "/security/readtemplate?t=complaints/index";
          paramPreference = new Intent();
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_feedback", false);
          paramPreference.putExtra("rawUrl", paramf);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_quit_wechat"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131762854, 2131762853, 2131756033, 2131755917, new DialogInterface.OnClickListener()
          {
            private MTimerHandler jer = null;
            private com.tencent.mm.ak.i onSceneEndCallback = null;
            
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74023);
              com.tencent.mm.modelstat.c.bgb().commitNow();
              ((com.tencent.mm.plugin.expt.b.e)g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
              g.aAi();
              Object localObject1;
              Object localObject2;
              if (com.tencent.mm.kernel.a.qd(g.aAf().hpS))
              {
                paramAnonymousDialogInterface = g.azz();
                localObject1 = new com.tencent.mm.ak.i()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
                  {
                    AppMethodBeat.i(74020);
                    g.azz().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.onSceneEndCallback = ((com.tencent.mm.ak.i)localObject1);
                paramAnonymousDialogInterface.a(281, (com.tencent.mm.ak.i)localObject1);
                localObject1 = new ae(2);
                g.azz().a((q)localObject1, 0);
                this.jer = new MTimerHandler(new MTimerHandler.CallBack()
                {
                  public final boolean onTimerExpired()
                  {
                    AppMethodBeat.i(74021);
                    g.azz().a(this.DaB);
                    g.azz().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.jer.startTimer(5000L);
                localObject2 = (o)g.af(o.class);
                paramAnonymousDialogInterface = SettingsAboutMicroMsgUI.this.getString(2131768644);
                if (Util.isNullOrNil(((o)localObject2).beO())) {
                  break label240;
                }
                paramAnonymousDialogInterface = ((o)localObject2).beO() + "...";
              }
              label240:
              for (;;)
              {
                localObject2 = SettingsAboutMicroMsgUI.this;
                AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.getContext();
                SettingsAboutMicroMsgUI.this.getString(2131755998);
                SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject2, com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramAnonymousDialogInterface, true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(74022);
                    g.azz().a(this.DaB);
                    g.azz().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
          com.tencent.mm.y.c.axV().cQ(262157, 266263);
          paramf = (String)g.aAh().azQ().get(ar.a.ObX, null);
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_flavor_blue"))
        {
          com.tencent.mm.y.c.axV().cQ(262164, 266270);
          com.tencent.mm.y.c.axV().B(262164, false);
          paramf = getContext();
          paramPreference = new Intent(this, SettingsAboutMicroMsgFlavorBlue.class);
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(74035);
          return false;
          if (paramf.equals("funtion_invite_flavor_blue"))
          {
            paramf = new Intent();
            paramf.putExtra("title", getString(2131761072));
            paramf.putExtra("rawUrl", "https://mp.weixin.qq.com/wxawap/devwxsubscribe#wechat_redirect");
            paramf.putExtra("showShare", false);
            paramf.putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
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
    eST();
    AppMethodBeat.o(74031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74036);
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (com.tencent.mm.plugin.p.b)paramq;
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.elm());
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.ell());
    Log.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.KyO);
    if ((com.tencent.mm.plugin.p.d.zEO) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.Dat = paramString.ell();
      if ((this.Dat <= 0) || (this.Dat <= com.tencent.mm.protocal.d.KyO)) {
        break label211;
      }
      this.Dar = true;
      if (!g.aAf().azp()) {
        Log.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      }
    }
    for (;;)
    {
      this.Das = paramString.eln();
      eST();
      AppMethodBeat.o(74036);
      return;
      label211:
      this.Dar = false;
      if (!g.aAf().azp()) {
        break;
      }
      com.tencent.mm.y.c.axV().A(262145, false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI
 * JD-Core Version:    0.7.0.1
 */