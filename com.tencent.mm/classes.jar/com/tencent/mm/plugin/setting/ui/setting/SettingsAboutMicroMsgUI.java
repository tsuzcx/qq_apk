package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.w;

@i
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private boolean qGZ = false;
  private aqy qHa;
  private int qHb = 0;
  Intent qHc = null;
  private ProgressDialog qHd;
  private ap qHe;
  private com.tencent.mm.ai.f qHf = null;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void cka()
  {
    AppMethodBeat.i(127102);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165278);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.atx("settings_about_mm_header");
    String str = com.tencent.mm.sdk.platformtools.g.au(getContext(), com.tencent.mm.protocal.d.whH);
    Object localObject = str;
    if (com.tencent.mm.protocal.d.whK) {
      localObject = str + " " + getString(2131296529);
    }
    localSettingsAboutMMHeaderPreference.qGW = ((String)localObject);
    int i;
    if (aa.dsD())
    {
      i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12304, null));
      localObject = (IconPreference)this.screen.atx("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).OL(0);
        ((IconPreference)localObject).eN(String.valueOf(i), t.iF(getContext()));
      }
    }
    else
    {
      if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) == 0) {
        break label374;
      }
      i = 1;
      label178:
      if ((!this.qGZ) || (com.tencent.mm.sdk.platformtools.g.ymO)) {
        break label379;
      }
      localObject = (IconSummaryPreference)this.screen.atx("funtion_update");
      ((IconSummaryPreference)localObject).qGf = 0;
      str = com.tencent.mm.sdk.platformtools.g.au(null, this.qHb);
      ((IconSummaryPreference)localObject).atA(getString(2131297012));
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).dEL();
      this.screen.aty("funtion_check_update");
      label252:
      if (!aa.dsD()) {
        this.screen.cl("settings_report", true);
      }
      this.screen.cl("funtion_about_wechat", true);
      if (bo.isNullOrNil((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGv, null))) {
        break label541;
      }
      localObject = (IconPreference)this.screen.atx("funtion_crowdtest_update");
      if (com.tencent.mm.x.c.PJ().cd(262157, 266263)) {
        ((IconPreference)localObject).ON(0);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127102);
      return;
      ((IconPreference)localObject).OL(8);
      ((IconPreference)localObject).eN("", -1);
      break;
      label374:
      i = 0;
      break label178;
      label379:
      if ((i == 0) && (this.qHa != null) && (this.qHa.xgl != 0) && (!bo.isNullOrNil(this.qHa.xgm)) && (!com.tencent.mm.sdk.platformtools.g.ymO))
      {
        ab.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.qHa.xgm, Integer.valueOf(this.qHa.xgn) });
        if (this.qHa.xgn != 0)
        {
          localObject = (IconSummaryPreference)this.screen.atx("funtion_update");
          ((IconSummaryPreference)localObject).qGf = 0;
          ((IconSummaryPreference)localObject).atA(getString(2131297012));
          this.screen.aty("funtion_check_update");
          break label252;
        }
        this.screen.aty("funtion_update");
        break label252;
      }
      this.screen.aty("funtion_update");
      break label252;
      label541:
      this.screen.aty("funtion_crowdtest_update");
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(127097);
    LinearLayout localLinearLayout = (LinearLayout)w.hM(getContext()).inflate(2130970686, null);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131827595);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131827596);
    Object localObject2 = com.tencent.mm.kernel.g.RL().Ru().get(274436, "").toString();
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = aa.dsF();
    }
    localObject2 = localObject1;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (!bo.apF((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(2131306182, new Object[] { aa.dsG(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { getString(2131304454), getString(2131301061) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(2131302168) }));
    j.k(localTextView1, 1);
    j.k(localTextView2, 1);
    ((TextView)localLinearLayout.findViewById(2131827597)).setText(localLinearLayout.getResources().getString(2131296897, new Object[] { Integer.valueOf(2019) }));
    AppMethodBeat.o(127097);
    return localLinearLayout;
  }
  
  public int getResourceId()
  {
    return 2131165278;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127101);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131689615));
    setBackGroundColorResource(2131689615);
    setBackBtn(new SettingsAboutMicroMsgUI.1(this));
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131427589);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(2131689615));
    }
    cka();
    AppMethodBeat.o(127101);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127098);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    com.tencent.mm.kernel.g.Rc().a(11, this);
    if (com.tencent.mm.plugin.p.d.bSu() != null)
    {
      paramBundle = com.tencent.mm.plugin.p.d.bSu().bSt();
      com.tencent.mm.kernel.g.Rc().a((m)paramBundle, 0);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 15L, 1L, true);
    }
    AppMethodBeat.o(127098);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127100);
    com.tencent.mm.kernel.g.Rc().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(127100);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127103);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update"))
    {
      if (aa.dsD())
      {
        com.tencent.mm.kernel.g.RJ();
        paramf = getString(2131303468, new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12304, null))) });
        if (paramf == null)
        {
          AppMethodBeat.o(127103);
          return true;
        }
        com.tencent.mm.kernel.g.RL().Ru().set(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(2131303467));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(127103);
        return true;
      }
      if (aa.dsD()) {}
      for (paramf = getString(2131303268, new Object[] { aa.dsG(), Integer.valueOf(com.tencent.mm.protocal.d.whH) });; paramf = "https://blog.wechat.com/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(127103);
        return true;
      }
    }
    if (paramf.equals("funtion_update"))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 16L, 1L, true);
      paramPreference = "";
      if (this.qGZ) {
        paramf = getString(2131303269, new Object[] { aa.dsG(), Integer.valueOf(this.qHb) });
      }
      for (;;)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", true);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(127103);
        return true;
        paramf = paramPreference;
        if (this.qHa != null)
        {
          paramf = paramPreference;
          if (this.qHa.xgl != 0)
          {
            paramf = paramPreference;
            if (!bo.isNullOrNil(this.qHa.xgm)) {
              paramf = this.qHa.xgm;
            }
          }
        }
      }
    }
    if (paramf.equals("funtion_check_update"))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 17L, 1L, true);
      if (com.tencent.mm.plugin.p.d.bSu() != null)
      {
        com.tencent.mm.plugin.p.d.bSu().bSs();
        if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) != 0)
        {
          ab.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
          paramf = Uri.parse(com.tencent.mm.sdk.platformtools.g.ymK);
          paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
          if ((paramf == null) || (paramPreference == null) || (!bo.k(getContext(), paramPreference)))
          {
            ab.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 18L, 1L, true);
          }
          for (;;)
          {
            AppMethodBeat.o(127103);
            return true;
            ab.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
            startActivity(paramPreference);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 19L, 1L, true);
          }
        }
        if ((this.qHa != null) && (this.qHa.xgl != 0) && (!bo.isNullOrNil(this.qHa.xgm)))
        {
          paramf = this.qHa.xgm;
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 20L, 1L, true);
          AppMethodBeat.o(127103);
          return true;
        }
        ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox()).commit();
        paramf = com.tencent.mm.plugin.p.d.bSu().c(this, new SettingsAboutMicroMsgUI.6(this));
        if (paramf == null) {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 21L, 1L, true);
        }
      }
      else
      {
        AppMethodBeat.o(127103);
        return false;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 22L, 1L, true);
      paramf.update(3);
      AppMethodBeat.o(127103);
      return true;
    }
    if (paramf.equals("funtion_about_wechat"))
    {
      com.tencent.mm.bq.d.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent());
      AppMethodBeat.o(127103);
      return true;
    }
    if (paramf.equals("settings_report"))
    {
      paramf = new Intent();
      paramf.putExtra("showShare", false);
      paramf.putExtra("show_feedback", false);
      paramf.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
      com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
      AppMethodBeat.o(127103);
      return true;
    }
    if (paramf.equals("settings_quit_wechat"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), 2131301421, 2131301420, 2131297115, 2131297014, new SettingsAboutMicroMsgUI.2(this), null);
      AppMethodBeat.o(127103);
      return true;
    }
    if (paramf.equals("funtion_crowdtest_update"))
    {
      com.tencent.mm.x.c.PJ().ce(262157, 266263);
      paramf = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGv, null);
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("showShare", false);
      paramPreference.putExtra("show_bottom", false);
      com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      AppMethodBeat.o(127103);
      return true;
    }
    AppMethodBeat.o(127103);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127099);
    super.onResume();
    cka();
    AppMethodBeat.o(127099);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127104);
    ab.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (b)paramm;
    ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.bSq());
    ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.bSp());
    ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.whH);
    if ((com.tencent.mm.plugin.p.d.oRx) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.qHb = paramString.bSp();
      if ((this.qHb <= 0) || (this.qHb <= com.tencent.mm.protocal.d.whH)) {
        break label224;
      }
      this.qGZ = true;
      if (!com.tencent.mm.kernel.g.RJ().QU()) {
        break label212;
      }
      com.tencent.mm.x.c.PJ().x(262145, true);
    }
    for (;;)
    {
      this.qHa = paramString.bSr();
      cka();
      AppMethodBeat.o(127104);
      return;
      label212:
      ab.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      continue;
      label224:
      this.qGZ = false;
      if (com.tencent.mm.kernel.g.RJ().QU()) {
        com.tencent.mm.x.c.PJ().x(262145, false);
      } else {
        ab.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
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