package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.w.b;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.q;

@com.tencent.mm.kernel.j
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private boolean nSZ = false;
  private all nTa;
  private int nTb = 0;
  Intent nTc = null;
  private ProgressDialog nTd;
  private am nTe;
  private com.tencent.mm.ah.f nTf = null;
  
  private void byQ()
  {
    this.dnn = this.vdd;
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(a.k.settings_pref_about_micromsg);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.dnn.add("settings_about_mm_header");
    String str = com.tencent.mm.sdk.platformtools.e.ag(this.mController.uMN, com.tencent.mm.protocal.d.spa);
    Object localObject = str;
    if (com.tencent.mm.protocal.d.spd) {
      localObject = str + " " + getString(a.i.alpha_version_alpha);
    }
    localSettingsAboutMMHeaderPreference.nSW = ((String)localObject);
    int i;
    if (x.cqG())
    {
      i = bk.g((Integer)g.DP().Dz().get(12304, null));
      localObject = (IconPreference)this.dnn.add("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).Gt(0);
        ((IconPreference)localObject).dD(String.valueOf(i), q.hh(this.mController.uMN));
      }
    }
    else
    {
      if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) == 0) {
        break label404;
      }
      i = 1;
      label181:
      if ((!this.nSZ) || (com.tencent.mm.sdk.platformtools.e.uen)) {
        break label409;
      }
      localObject = (IconSummaryPreference)this.dnn.add("funtion_update");
      ((IconSummaryPreference)localObject).nSi = 0;
      str = com.tencent.mm.sdk.platformtools.e.ag(null, this.nTb);
      ((IconSummaryPreference)localObject).dD(getString(a.i.app_new), a.e.new_tips_bg);
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).vcI = 0;
      if (((IconSummaryPreference)localObject).vcJ != null) {
        ((IconSummaryPreference)localObject).vcJ.setVisibility(((IconSummaryPreference)localObject).vcI);
      }
      this.dnn.ade("funtion_check_update");
      label278:
      if (!x.cqG()) {
        this.dnn.bJ("settings_report", true);
      }
      com.tencent.mm.pluginsdk.f.e.rVK.tw();
      this.dnn.bJ("funtion_about_wechat", true);
      if (bk.bl((String)g.DP().Dz().get(ac.a.uwn, null))) {
        break label575;
      }
      localObject = (IconPreference)this.dnn.add("funtion_crowdtest_update");
      if (com.tencent.mm.y.c.BS().bc(262157, 266263)) {
        ((IconPreference)localObject).Gv(0);
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      ((IconPreference)localObject).Gt(8);
      ((IconPreference)localObject).dD("", -1);
      break;
      label404:
      i = 0;
      break label181;
      label409:
      if ((i == 0) && (this.nTa != null) && (this.nTa.thx != 0) && (!bk.bl(this.nTa.thy)) && (!com.tencent.mm.sdk.platformtools.e.uen))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.nTa.thy, Integer.valueOf(this.nTa.thz) });
        if (this.nTa.thz != 0)
        {
          localObject = (IconSummaryPreference)this.dnn.add("funtion_update");
          ((IconSummaryPreference)localObject).nSi = 0;
          ((IconSummaryPreference)localObject).dD(getString(a.i.app_new), a.e.new_tips_bg);
          this.dnn.ade("funtion_check_update");
          break label278;
        }
        this.dnn.ade("funtion_update");
        break label278;
      }
      this.dnn.ade("funtion_update");
      break label278;
      label575:
      this.dnn.ade("funtion_crowdtest_update");
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update")) {
      if (x.cqG())
      {
        g.DN();
        int i = com.tencent.mm.kernel.a.CK();
        int j = bk.g((Integer)g.DP().Dz().get(12304, null));
        paramf = getString(a.i.settings_system_notice_url, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (paramf != null) {}
      }
    }
    do
    {
      return true;
      g.DP().Dz().o(12304, Integer.valueOf(0));
      paramPreference = new Intent();
      paramPreference.putExtra("title", getString(a.i.settings_system_notice));
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
      return true;
      if (x.cqG()) {}
      for (paramf = getString(a.i.settings_funtion_update_cv_url, new Object[] { x.cqJ(), Integer.valueOf(com.tencent.mm.protocal.d.spa) });; paramf = "https://blog.wechat.com/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
        return true;
      }
      if (paramf.equals("funtion_update"))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 16L, 1L, true);
        paramPreference = "";
        if (this.nSZ) {
          paramf = getString(a.i.settings_funtion_update_nv_url, new Object[] { x.cqJ(), Integer.valueOf(this.nTb) });
        }
        for (;;)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", true);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
          return true;
          paramf = paramPreference;
          if (this.nTa != null)
          {
            paramf = paramPreference;
            if (this.nTa.thx != 0)
            {
              paramf = paramPreference;
              if (!bk.bl(this.nTa.thy)) {
                paramf = this.nTa.thy;
              }
            }
          }
        }
      }
      if (paramf.equals("funtion_check_update"))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 17L, 1L, true);
        if (com.tencent.mm.plugin.w.d.bkt() != null)
        {
          com.tencent.mm.plugin.w.d.bkt().bkr();
          if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) != 0)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
            paramf = Uri.parse(com.tencent.mm.sdk.platformtools.e.uej);
            paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
            if ((paramf == null) || (paramPreference == null) || (!bk.i(this.mController.uMN, paramPreference)))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
              startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
              com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 18L, 1L, true);
              return true;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
            startActivity(paramPreference);
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 19L, 1L, true);
            return true;
          }
          if ((this.nTa != null) && (this.nTa.thx != 0) && (!bk.bl(this.nTa.thy)))
          {
            paramf = this.nTa.thy;
            paramPreference = new Intent();
            paramPreference.putExtra("rawUrl", paramf);
            paramPreference.putExtra("showShare", false);
            paramPreference.putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 20L, 1L, true);
            return true;
          }
          ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX()).commit();
          paramf = com.tencent.mm.plugin.w.d.bkt().a(this, new SettingsAboutMicroMsgUI.6(this));
          if (paramf == null) {
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 21L, 1L, true);
          }
        }
        else
        {
          return false;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 22L, 1L, true);
        paramf.update(3);
        return true;
      }
    } while (paramf.equals("funtion_about_wechat"));
    if (paramf.equals("settings_report"))
    {
      paramf = new Intent();
      paramf.putExtra("showShare", false);
      paramf.putExtra("show_feedback", false);
      paramf.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
      com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramf);
      return true;
    }
    if (paramf.equals("settings_quit_wechat"))
    {
      com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.main_exit_warning, a.i.main_exit_title, a.i.app_yes, a.i.app_no, new DialogInterface.OnClickListener()
      {
        private com.tencent.mm.ah.f eBv = null;
        private am etU = null;
        
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          com.tencent.mm.modelstat.c.Rn().commitNow();
          g.DQ();
          if (com.tencent.mm.kernel.a.hw(g.DN().dJB))
          {
            paramAnonymousDialogInterface = g.Dk();
            Object localObject = new SettingsAboutMicroMsgUI.2.1(this);
            this.eBv = ((com.tencent.mm.ah.f)localObject);
            paramAnonymousDialogInterface.a(281, (com.tencent.mm.ah.f)localObject);
            paramAnonymousDialogInterface = new ac(2);
            g.Dk().a(paramAnonymousDialogInterface, 0);
            this.etU = new am(new SettingsAboutMicroMsgUI.2.2(this, paramAnonymousDialogInterface), false);
            this.etU.S(5000L, 5000L);
            localObject = SettingsAboutMicroMsgUI.this;
            AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.mController.uMN;
            SettingsAboutMicroMsgUI.this.getString(a.i.app_tip);
            SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject, com.tencent.mm.ui.base.h.b(localAppCompatActivity, SettingsAboutMicroMsgUI.this.getString(a.i.webwx_logout_processing_txt), true, new SettingsAboutMicroMsgUI.2.3(this, paramAnonymousDialogInterface)));
            return;
          }
          SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
        }
      }, null);
      return true;
    }
    if (paramf.equals("funtion_crowdtest_update"))
    {
      com.tencent.mm.y.c.BS().bd(262157, 266263);
      paramf = (String)g.DP().Dz().get(ac.a.uwn, null);
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("showShare", false);
      paramPreference.putExtra("show_bottom", false);
      com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
      return true;
    }
    return false;
  }
  
  public final View byP()
  {
    LinearLayout localLinearLayout = (LinearLayout)com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(a.g.settings_about_micromsg_footer, null);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.f.terms_of_service);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.f.terms_of_privacy);
    Object localObject2 = g.DP().Dz().get(274436, "").toString();
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = x.cqI();
    }
    localObject2 = localObject1;
    if (!bk.bl((String)localObject1))
    {
      localObject2 = localObject1;
      if (!bk.ZA((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(a.i.license_read_url, new Object[] { x.cqJ(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { getString(a.i.url_agreement), getString(a.i.license_detail) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(a.i.privacy_detail) }));
    com.tencent.mm.pluginsdk.ui.d.j.h(localTextView1, 1);
    com.tencent.mm.pluginsdk.ui.d.j.h(localTextView2, 1);
    ((TextView)localLinearLayout.findViewById(a.f.copyright_desc_tv)).setText(localLinearLayout.getResources().getString(a.i.app_copyright, new Object[] { Integer.valueOf(2018) }));
    return localLinearLayout;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_what_new);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SettingsAboutMicroMsgUI.this.XM();
        SettingsAboutMicroMsgUI.this.finish();
        return true;
      }
    });
    byQ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czo();
    initView();
    g.Dk().a(11, this);
    if (com.tencent.mm.plugin.w.d.bkt() != null)
    {
      paramBundle = com.tencent.mm.plugin.w.d.bkt().bks();
      g.Dk().a((m)paramBundle, 0);
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 15L, 1L, true);
    }
  }
  
  public void onDestroy()
  {
    g.Dk().b(11, this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    byQ();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (b)paramm;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.bkp());
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.bko());
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.spa);
    if ((com.tencent.mm.plugin.w.d.mrJ) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.nTb = paramString.bko();
      if ((this.nTb <= 0) || (this.nTb <= com.tencent.mm.protocal.d.spa)) {
        break label212;
      }
      this.nSZ = true;
      if (!g.DN().Dc()) {
        break label200;
      }
      com.tencent.mm.y.c.BS().v(262145, true);
    }
    for (;;)
    {
      this.nTa = paramString.bkq();
      byQ();
      return;
      label200:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      continue;
      label212:
      this.nSZ = false;
      if (g.DN().Dc()) {
        com.tencent.mm.y.c.BS().v(262145, false);
      } else {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      }
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref_about_micromsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI
 * JD-Core Version:    0.7.0.1
 */