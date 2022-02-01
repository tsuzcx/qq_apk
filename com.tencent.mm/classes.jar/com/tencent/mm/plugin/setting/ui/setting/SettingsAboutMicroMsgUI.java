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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.z;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@i
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean yVC;
  private bkf yVD;
  private int yVE;
  Intent yVF;
  private ProgressDialog yVG;
  private aw yVH;
  private com.tencent.mm.ak.f yVI;
  private com.tencent.mm.plugin.updater.a.b yVK;
  
  public SettingsAboutMicroMsgUI()
  {
    AppMethodBeat.i(190339);
    this.yVC = false;
    this.yVE = 0;
    this.yVF = null;
    this.yVI = null;
    this.yVK = new com.tencent.mm.plugin.updater.a.b()
    {
      public final void qV(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(190338);
        if (paramAnonymousBoolean) {
          SettingsAboutMicroMsgUI.h(SettingsAboutMicroMsgUI.this);
        }
        AppMethodBeat.o(190338);
      }
    };
    AppMethodBeat.o(190339);
  }
  
  private void dQS()
  {
    AppMethodBeat.i(164132);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951722);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aXe("settings_about_mm_header");
    String str = com.tencent.mm.sdk.platformtools.k.aD(getContext(), com.tencent.mm.protocal.d.FFH);
    Object localObject;
    if (!com.tencent.mm.protocal.d.FFK)
    {
      localObject = str;
      if (!j.IS_FLAVOR_BLUE) {}
    }
    else
    {
      localObject = str + " " + com.tencent.mm.cc.g.ix(this);
    }
    localSettingsAboutMMHeaderPreference.yVv = ((String)localObject);
    int i;
    if (ad.foj())
    {
      i = bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(12304, null));
      localObject = (IconPreference)this.screen.aXe("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).acS(0);
        ((IconPreference)localObject).gF(String.valueOf(i), com.tencent.mm.ui.tools.u.aP(getContext(), i));
      }
    }
    else
    {
      if ((com.tencent.mm.sdk.platformtools.k.cSO & 0x1) == 0) {
        break label414;
      }
      i = 1;
      label183:
      if ((!this.yVC) || (com.tencent.mm.sdk.platformtools.k.IwL)) {
        break label419;
      }
      localObject = (IconSummaryPreference)this.screen.aXe("funtion_update");
      ((IconSummaryPreference)localObject).yUv = 0;
      str = com.tencent.mm.sdk.platformtools.k.aD(null, this.yVE);
      ((IconSummaryPreference)localObject).aXh(getString(2131755829));
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).fDE();
      this.screen.aXf("funtion_check_update");
      label259:
      if (!ad.foj()) {
        this.screen.cT("settings_report", true);
      }
      if (!com.tencent.mm.pluginsdk.i.f.Fhu.MZ()) {
        this.screen.cT("funtion_about_wechat", true);
      }
      if (bu.isNullOrNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITJ, null))) {
        break label678;
      }
      localObject = (IconPreference)this.screen.aXe("funtion_crowdtest_update");
      if (com.tencent.mm.y.c.ahI().cJ(262157, 266263)) {
        ((IconPreference)localObject).acU(0);
      }
      label362:
      if (j.IS_FLAVOR_BLUE) {
        break label694;
      }
      this.screen.cT("funtion_about_flavor_blue", true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(164132);
      return;
      ((IconPreference)localObject).acS(8);
      ((IconPreference)localObject).gF("", -1);
      break;
      label414:
      i = 0;
      break label183;
      label419:
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        localObject = (IconSummaryPreference)this.screen.aXe("funtion_update");
        ((IconSummaryPreference)localObject).yUv = 0;
        str = com.tencent.mm.sdk.platformtools.k.aD(null, ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion());
        ((IconSummaryPreference)localObject).aXh(getString(2131755829));
        ((IconSummaryPreference)localObject).setSummary(str);
        ((IconSummaryPreference)localObject).fDE();
        this.screen.aXf("funtion_check_update");
        break label259;
      }
      if ((i == 0) && (this.yVD != null) && (this.yVD.GXD != 0) && (!bu.isNullOrNil(this.yVD.GXE)) && (!com.tencent.mm.sdk.platformtools.k.IwL))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.yVD.GXE, Integer.valueOf(this.yVD.GXF) });
        if (this.yVD.GXF != 0)
        {
          localObject = (IconSummaryPreference)this.screen.aXe("funtion_update");
          ((IconSummaryPreference)localObject).yUv = 0;
          ((IconSummaryPreference)localObject).aXh(getString(2131755829));
          this.screen.aXf("funtion_check_update");
          break label259;
        }
        this.screen.aXf("funtion_update");
        break label259;
      }
      this.screen.aXf("funtion_update");
      break label259;
      label678:
      this.screen.aXf("funtion_crowdtest_update");
      break label362;
      label694:
      localObject = (IconPreference)this.screen.aXe("funtion_about_flavor_blue");
      if (com.tencent.mm.y.c.ahI().cJ(262164, 266270)) {
        ((IconPreference)localObject).acU(0);
      }
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(74029);
    LinearLayout localLinearLayout = (LinearLayout)z.jV(getContext()).inflate(2131495381, null);
    Object localObject3 = (TextView)localLinearLayout.findViewById(2131305704);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131305703);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131305702);
    Object localObject2 = com.tencent.mm.kernel.g.ajR().ajA().get(274436, "").toString();
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2)) {
      localObject1 = ad.fol();
    }
    localObject2 = localObject1;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (!bu.aSn((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(2131760685, new Object[] { ad.fom(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    String str1 = getString(2131764600, new Object[] { ad.fom(), localObject2 });
    String str2 = getString(2131760678, new Object[] { ad.fom(), localObject2 });
    ((TextView)localObject3).setText(String.format("<a href='%s'>%s</a>", new Object[] { str1, getString(2131760681) }));
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(2131762010) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { str2, getString(2131760677) }));
    com.tencent.mm.pluginsdk.ui.span.k.o((TextView)localObject3, 1);
    com.tencent.mm.pluginsdk.ui.span.k.o(localTextView1, 1);
    com.tencent.mm.pluginsdk.ui.span.k.o(localTextView2, 1);
    if (((String)localObject2).equalsIgnoreCase("KR")) {
      localTextView2.setVisibility(0);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(2131298794);
    int i = 2020;
    try
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(j.TIME);
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).setTime((Date)localObject2);
      int j = ((Calendar)localObject3).get(1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SettingsAboutMicroMsgUI", localException, "", new Object[0]);
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
    dQS();
    AppMethodBeat.o(74033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74030);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    com.tencent.mm.kernel.g.ajj().a(11, this);
    if (com.tencent.mm.plugin.q.d.drw() != null)
    {
      paramBundle = com.tencent.mm.plugin.q.d.drw().drv();
      com.tencent.mm.kernel.g.ajj().a((n)paramBundle, 0);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 15L, 1L, true);
    }
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).addManualCheckUpdateListener(this.yVK);
    AppMethodBeat.o(74030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74032);
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).removeManualCheckUpdateListener(this.yVK);
    com.tencent.mm.kernel.g.ajj().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(74032);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74035);
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update"))
    {
      if (ad.foj())
      {
        com.tencent.mm.kernel.g.ajP();
        paramf = getString(2131763450, new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(12304, null))) });
        if (paramf == null)
        {
          AppMethodBeat.o(74035);
          return true;
        }
        com.tencent.mm.kernel.g.ajR().ajA().set(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(2131763449));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
      if (ad.foj()) {}
      for (paramf = getString(2131763237, new Object[] { ad.fom(), Integer.valueOf(com.tencent.mm.protocal.d.FFH) });; paramf = "https://blog.wechat.com/")
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
    }
    if (paramf.equals("funtion_update"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 16L, 1L, true);
      paramPreference = new Intent();
      paramPreference.putExtra("showShare", true);
      paramPreference.putExtra("show_bottom", false);
      if (this.yVC) {
        paramf = getString(2131763238, new Object[] { ad.fom(), Integer.valueOf(this.yVE) });
      }
    }
    for (;;)
    {
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickCheckUpdateRedDot();
      AppMethodBeat.o(74035);
      return true;
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasCheckUpdateTabRedDot())
      {
        paramf = getString(2131763238, new Object[] { ad.fom(), Integer.valueOf(((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).getUpdateVersion()) });
        paramPreference.putExtra("showShare", false);
      }
      else if ((this.yVD != null) && (this.yVD.GXD != 0) && (!bu.isNullOrNil(this.yVD.GXE)))
      {
        paramf = this.yVD.GXE;
        continue;
        if (paramf.equals("funtion_check_update"))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 17L, 1L, true);
          if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
          {
            ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(0);
            AppMethodBeat.o(74035);
            return true;
          }
          if (com.tencent.mm.plugin.q.d.drw() != null)
          {
            com.tencent.mm.plugin.q.d.drw().dru();
            if ((com.tencent.mm.sdk.platformtools.k.cSO & 0x1) != 0)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
              paramf = Uri.parse(com.tencent.mm.sdk.platformtools.k.IwH);
              paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
              if ((paramf == null) || (paramPreference == null) || (!bu.aj(getContext(), paramPreference)))
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                paramf = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
                paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 18L, 1L, true);
              }
              for (;;)
              {
                AppMethodBeat.o(74035);
                return true;
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 19L, 1L, true);
              }
            }
            if ((this.yVD != null) && (this.yVD.GXD != 0) && (!bu.isNullOrNil(this.yVD.GXE)))
            {
              paramf = this.yVD.GXE;
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf);
              paramPreference.putExtra("showShare", false);
              paramPreference.putExtra("show_bottom", false);
              com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 20L, 1L, true);
              AppMethodBeat.o(74035);
              return true;
            }
            ak.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bu.aRi()).commit();
            paramf = com.tencent.mm.plugin.q.d.drw().c(this, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(74028);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 23L, 1L, true);
                AppMethodBeat.o(74028);
              }
            });
            if (paramf == null) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 21L, 1L, true);
            }
          }
          else
          {
            AppMethodBeat.o(74035);
            return false;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 22L, 1L, true);
          paramf.update(3);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_wechat"))
        {
          com.tencent.mm.br.d.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent());
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_report"))
        {
          paramf = new Intent();
          paramf.putExtra("showShare", false);
          paramf.putExtra("show_feedback", false);
          paramf.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("settings_quit_wechat"))
        {
          h.a(getContext(), 2131761068, 2131761067, 2131755939, 2131755831, new DialogInterface.OnClickListener()
          {
            private aw ijv = null;
            private com.tencent.mm.ak.f onSceneEndCallback = null;
            
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74023);
              com.tencent.mm.modelstat.c.aLY().commitNow();
              ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
              com.tencent.mm.kernel.g.ajS();
              if (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe))
              {
                paramAnonymousDialogInterface = com.tencent.mm.kernel.g.ajj();
                Object localObject = new com.tencent.mm.ak.f()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
                  {
                    AppMethodBeat.i(74020);
                    com.tencent.mm.kernel.g.ajj().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.onSceneEndCallback = ((com.tencent.mm.ak.f)localObject);
                paramAnonymousDialogInterface.a(281, (com.tencent.mm.ak.f)localObject);
                paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.ae(2);
                com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
                this.ijv = new aw(new aw.a()
                {
                  public final boolean onTimerExpired()
                  {
                    AppMethodBeat.i(74021);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.ajj().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
                this.ijv.ay(5000L, 5000L);
                localObject = SettingsAboutMicroMsgUI.this;
                AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.getContext();
                SettingsAboutMicroMsgUI.this.getString(2131755906);
                SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject, h.b(localAppCompatActivity, SettingsAboutMicroMsgUI.this.getString(2131766171), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(74022);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.ajj().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
          com.tencent.mm.y.c.ahI().cK(262157, 266263);
          paramf = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITJ, null);
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          AppMethodBeat.o(74035);
          return true;
        }
        if (paramf.equals("funtion_about_flavor_blue"))
        {
          com.tencent.mm.y.c.ahI().cK(262164, 266270);
          com.tencent.mm.y.c.ahI().x(262164, false);
          paramf = getContext();
          paramPreference = new Intent(this, SettingsAboutMicroMsgFlavorBlue.class);
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    dQS();
    AppMethodBeat.o(74031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74036);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (com.tencent.mm.plugin.q.b)paramn;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.drs());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.drr());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.FFH);
    if ((com.tencent.mm.plugin.q.d.wkm) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.yVE = paramString.drr();
      if ((this.yVE <= 0) || (this.yVE <= com.tencent.mm.protocal.d.FFH)) {
        break label224;
      }
      this.yVC = true;
      if (!com.tencent.mm.kernel.g.ajP().aiZ()) {
        break label212;
      }
      com.tencent.mm.y.c.ahI().w(262145, true);
    }
    for (;;)
    {
      this.yVD = paramString.drt();
      dQS();
      AppMethodBeat.o(74036);
      return;
      label212:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      continue;
      label224:
      this.yVC = false;
      if (com.tencent.mm.kernel.g.ajP().aiZ()) {
        com.tencent.mm.y.c.ahI().w(262145, false);
      } else {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
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