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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@com.tencent.mm.kernel.i
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean yFA;
  private com.tencent.mm.plugin.updater.a.b yFB;
  private boolean yFt;
  private bjn yFu;
  private int yFv;
  Intent yFw;
  private ProgressDialog yFx;
  private av yFy;
  private com.tencent.mm.al.f yFz;
  
  public SettingsAboutMicroMsgUI()
  {
    AppMethodBeat.i(220968);
    this.yFt = false;
    this.yFv = 0;
    this.yFw = null;
    this.yFz = null;
    this.yFB = new com.tencent.mm.plugin.updater.a.b()
    {
      public final void qO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(220967);
        if (paramAnonymousBoolean) {
          SettingsAboutMicroMsgUI.h(SettingsAboutMicroMsgUI.this);
        }
        AppMethodBeat.o(220967);
      }
    };
    AppMethodBeat.o(220968);
  }
  
  private void dNv()
  {
    AppMethodBeat.i(164132);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951722);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aVD("settings_about_mm_header");
    String str = j.aD(getContext(), com.tencent.mm.protocal.d.Fnj);
    Object localObject;
    if (!com.tencent.mm.protocal.d.Fnm)
    {
      localObject = str;
      if (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_BLUE) {}
    }
    else
    {
      localObject = str + " " + com.tencent.mm.cd.g.is(this);
    }
    localSettingsAboutMMHeaderPreference.yFq = ((String)localObject);
    int i;
    if (ac.fkp())
    {
      i = bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12304, null));
      localObject = (IconPreference)this.screen.aVD("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).acl(0);
        ((IconPreference)localObject).gw(String.valueOf(i), u.aP(getContext(), i));
      }
    }
    else
    {
      if ((j.cSe & 0x1) == 0) {
        break label394;
      }
      i = 1;
      label183:
      if ((!this.yFt) || (j.IcA)) {
        break label399;
      }
      localObject = (IconSummaryPreference)this.screen.aVD("funtion_update");
      ((IconSummaryPreference)localObject).yEq = 0;
      str = j.aD(null, this.yFv);
      ((IconSummaryPreference)localObject).aVG(getString(2131755829));
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).fzC();
      this.screen.aVE("funtion_check_update");
      label259:
      if (!ac.fkp()) {
        this.screen.cP("settings_report", true);
      }
      if (!com.tencent.mm.pluginsdk.i.f.EOZ.Ne()) {
        this.screen.cP("funtion_about_wechat", true);
      }
      if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izl, null))) {
        break label658;
      }
      localObject = (IconPreference)this.screen.aVD("funtion_crowdtest_update");
      if (com.tencent.mm.z.c.aht().cJ(262157, 266263)) {
        ((IconPreference)localObject).acn(0);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(164132);
      return;
      ((IconPreference)localObject).acl(8);
      ((IconPreference)localObject).gw("", -1);
      break;
      label394:
      i = 0;
      break label183;
      label399:
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        localObject = (IconSummaryPreference)this.screen.aVD("funtion_update");
        ((IconSummaryPreference)localObject).yEq = 0;
        str = j.aD(null, ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion());
        ((IconSummaryPreference)localObject).aVG(getString(2131755829));
        ((IconSummaryPreference)localObject).setSummary(str);
        ((IconSummaryPreference)localObject).fzC();
        this.screen.aVE("funtion_check_update");
        break label259;
      }
      if ((i == 0) && (this.yFu != null) && (this.yFu.GEa != 0) && (!bt.isNullOrNil(this.yFu.GEb)) && (!j.IcA))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.yFu.GEb, Integer.valueOf(this.yFu.GEc) });
        if (this.yFu.GEc != 0)
        {
          localObject = (IconSummaryPreference)this.screen.aVD("funtion_update");
          ((IconSummaryPreference)localObject).yEq = 0;
          ((IconSummaryPreference)localObject).aVG(getString(2131755829));
          this.screen.aVE("funtion_check_update");
          break label259;
        }
        this.screen.aVE("funtion_update");
        break label259;
      }
      this.screen.aVE("funtion_update");
      break label259;
      label658:
      this.screen.aVE("funtion_crowdtest_update");
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(74029);
    LinearLayout localLinearLayout = (LinearLayout)z.jO(getContext()).inflate(2131495381, null);
    Object localObject3 = (TextView)localLinearLayout.findViewById(2131305704);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131305703);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131305702);
    Object localObject2 = com.tencent.mm.kernel.g.ajC().ajl().get(274436, "").toString();
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = ac.fkr();
    }
    localObject2 = localObject1;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (!bt.aQQ((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(2131760685, new Object[] { ac.fks(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    String str1 = getString(2131764600, new Object[] { ac.fks(), localObject2 });
    String str2 = getString(2131760678, new Object[] { ac.fks(), localObject2 });
    ((TextView)localObject3).setText(String.format("<a href='%s'>%s</a>", new Object[] { str1, getString(2131760681) }));
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(2131762010) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { str2, getString(2131760677) }));
    k.n((TextView)localObject3, 1);
    k.n(localTextView1, 1);
    k.n(localTextView2, 1);
    if (((String)localObject2).equalsIgnoreCase("KR")) {
      localTextView2.setVisibility(0);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(2131298794);
    int i = 2020;
    try
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(com.tencent.mm.sdk.platformtools.i.TIME);
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).setTime((Date)localObject2);
      int j = ((Calendar)localObject3).get(1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SettingsAboutMicroMsgUI", localException, "", new Object[0]);
      }
    }
    ((TextView)localObject1).setText(localLinearLayout.getResources().getString(2131755703, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(74029);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return 2131951722;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74033);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099650));
    setBackGroundColorResource(2131101179);
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
      int i = getContext().getResources().getDimensionPixelSize(2131165292);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(2131099650));
    }
    dNv();
    AppMethodBeat.o(74033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74030);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    com.tencent.mm.kernel.g.aiU().a(11, this);
    if (com.tencent.mm.plugin.q.d.doy() != null)
    {
      paramBundle = com.tencent.mm.plugin.q.d.doy().dox();
      com.tencent.mm.kernel.g.aiU().a((n)paramBundle, 0);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 15L, 1L, true);
    }
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).addManualCheckUpdateListener(this.yFB);
    AppMethodBeat.o(74030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74032);
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).removeManualCheckUpdateListener(this.yFB);
    if (this.yFA) {
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickCheckUpdateRedDot();
    }
    com.tencent.mm.kernel.g.aiU().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(74032);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74035);
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update"))
    {
      if (ac.fkp())
      {
        com.tencent.mm.kernel.g.ajA();
        paramf = getString(2131763450, new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12304, null))) });
        if (paramf == null)
        {
          AppMethodBeat.o(74035);
          return true;
        }
        com.tencent.mm.kernel.g.ajC().ajl().set(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(2131763449));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
      if (ac.fkp()) {}
      for (paramf = getString(2131763237, new Object[] { ac.fks(), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });; paramf = "https://blog.wechat.com/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
    }
    if (paramf.equals("funtion_update"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 16L, 1L, true);
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", true);
      paramPreference.putExtra("show_bottom", false);
      if (this.yFt) {
        paramf = getString(2131763238, new Object[] { ac.fks(), Integer.valueOf(this.yFv) });
      }
    }
    for (;;)
    {
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      this.yFA = true;
      AppMethodBeat.o(74035);
      return true;
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        paramf = getString(2131763238, new Object[] { ac.fks(), Integer.valueOf(((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion()) });
        paramPreference.putExtra("showShare", false);
      }
      else if ((this.yFu != null) && (this.yFu.GEa != 0) && (!bt.isNullOrNil(this.yFu.GEb)))
      {
        paramf = this.yFu.GEb;
        continue;
        if (paramf.equals("funtion_check_update"))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 17L, 1L, true);
          if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
          {
            ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(0);
            AppMethodBeat.o(74035);
            return true;
          }
          if (com.tencent.mm.plugin.q.d.doy() != null)
          {
            com.tencent.mm.plugin.q.d.doy().dow();
            if ((j.cSe & 0x1) != 0)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
              paramf = Uri.parse(j.Icw);
              paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
              if ((paramf == null) || (paramPreference == null) || (!bt.aj(getContext(), paramPreference)))
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                paramf = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
                paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 18L, 1L, true);
              }
              for (;;)
              {
                AppMethodBeat.o(74035);
                return true;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 19L, 1L, true);
              }
            }
            if ((this.yFu != null) && (this.yFu.GEa != 0) && (!bt.isNullOrNil(this.yFu.GEb)))
            {
              paramf = this.yFu.GEb;
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf);
              paramPreference.putExtra("showShare", false);
              paramPreference.putExtra("show_bottom", false);
              com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 20L, 1L, true);
              AppMethodBeat.o(74035);
              return true;
            }
            aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ()).commit();
            paramf = com.tencent.mm.plugin.q.d.doy().c(this, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(74028);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 23L, 1L, true);
                AppMethodBeat.o(74028);
              }
            });
            if (paramf == null) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 21L, 1L, true);
            }
          }
          else
          {
            AppMethodBeat.o(74035);
            return false;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 22L, 1L, true);
          paramf.update(3);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_wechat"))
        {
          com.tencent.mm.bs.d.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent());
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_report"))
        {
          paramf = new Intent();
          paramf.putExtra("showShare", false);
          paramf.putExtra("show_feedback", false);
          paramf.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
          com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_quit_wechat"))
        {
          h.a(getContext(), 2131761068, 2131761067, 2131755939, 2131755831, new DialogInterface.OnClickListener()
          {
            private av igC = null;
            private com.tencent.mm.al.f onSceneEndCallback = null;
            
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74023);
              com.tencent.mm.modelstat.c.aLB().commitNow();
              ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
              com.tencent.mm.kernel.g.ajD();
              if (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx))
              {
                paramAnonymousDialogInterface = com.tencent.mm.kernel.g.aiU();
                Object localObject = new com.tencent.mm.al.f()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
                  {
                    AppMethodBeat.i(74020);
                    com.tencent.mm.kernel.g.aiU().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.onSceneEndCallback = ((com.tencent.mm.al.f)localObject);
                paramAnonymousDialogInterface.a(281, (com.tencent.mm.al.f)localObject);
                paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.ad(2);
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
                this.igC = new av(new av.a()
                {
                  public final boolean onTimerExpired()
                  {
                    AppMethodBeat.i(74021);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.aiU().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.igC.az(5000L, 5000L);
                localObject = SettingsAboutMicroMsgUI.this;
                AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.getContext();
                SettingsAboutMicroMsgUI.this.getString(2131755906);
                SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject, h.b(localAppCompatActivity, SettingsAboutMicroMsgUI.this.getString(2131766171), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(74022);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.aiU().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
              }
              SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
              AppMethodBeat.o(74023);
            }
          }, null);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_crowdtest_update"))
        {
          com.tencent.mm.z.c.aht().cK(262157, 266263);
          paramf = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izl, null);
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        AppMethodBeat.o(74035);
        return false;
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
    dNv();
    AppMethodBeat.o(74031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74036);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (com.tencent.mm.plugin.q.b)paramn;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.dou());
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.dot());
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.Fnj);
    if ((com.tencent.mm.plugin.q.d.vYi) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.yFv = paramString.dot();
      if ((this.yFv <= 0) || (this.yFv <= com.tencent.mm.protocal.d.Fnj)) {
        break label224;
      }
      this.yFt = true;
      if (!com.tencent.mm.kernel.g.ajA().aiK()) {
        break label212;
      }
      com.tencent.mm.z.c.aht().w(262145, true);
    }
    for (;;)
    {
      this.yFu = paramString.dov();
      dNv();
      AppMethodBeat.o(74036);
      return;
      label212:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      continue;
      label224:
      this.yFt = false;
      if (com.tencent.mm.kernel.g.ajA().aiK()) {
        com.tencent.mm.z.c.aht().w(262145, false);
      } else {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI
 * JD-Core Version:    0.7.0.1
 */