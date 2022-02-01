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
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.q.b;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@com.tencent.mm.kernel.i
public class SettingsAboutMicroMsgUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private f screen;
  private boolean xqM = false;
  private bff xqN;
  private int xqO = 0;
  Intent xqP = null;
  private ProgressDialog xqQ;
  private au xqR;
  private com.tencent.mm.ak.g xqS = null;
  
  private void dBS()
  {
    AppMethodBeat.i(164132);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951722);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aPN("settings_about_mm_header");
    String str = com.tencent.mm.sdk.platformtools.i.aA(getContext(), com.tencent.mm.protocal.d.DIc);
    Object localObject = str;
    if (com.tencent.mm.protocal.d.DIf) {
      localObject = str + " " + getString(2131755263);
    }
    localSettingsAboutMMHeaderPreference.xqK = ((String)localObject);
    int i;
    if (ab.eUL())
    {
      i = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(12304, null));
      localObject = (IconPreference)this.screen.aPN("settings_update");
      if (i > 0)
      {
        ((IconPreference)localObject).aab(0);
        ((IconPreference)localObject).fZ(String.valueOf(i), u.aM(getContext(), i));
      }
    }
    else
    {
      if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x1) == 0) {
        break label389;
      }
      i = 1;
      label179:
      if ((!this.xqM) || (com.tencent.mm.sdk.platformtools.i.GqM)) {
        break label394;
      }
      localObject = (IconSummaryPreference)this.screen.aPN("funtion_update");
      ((IconSummaryPreference)localObject).xpN = 0;
      str = com.tencent.mm.sdk.platformtools.i.aA(null, this.xqO);
      ((IconSummaryPreference)localObject).aPQ(getString(2131755829));
      ((IconSummaryPreference)localObject).setSummary(str);
      ((IconSummaryPreference)localObject).fjn();
      this.screen.aPO("funtion_check_update");
      label254:
      if (!ab.eUL()) {
        this.screen.cK("settings_report", true);
      }
      if (!com.tencent.mm.pluginsdk.g.e.DjW.Lw()) {
        this.screen.cK("funtion_about_wechat", true);
      }
      if (bs.isNullOrNil((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMU, null))) {
        break label557;
      }
      localObject = (IconPreference)this.screen.aPN("funtion_crowdtest_update");
      if (com.tencent.mm.y.c.aeH().cH(262157, 266263)) {
        ((IconPreference)localObject).aad(0);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(164132);
      return;
      ((IconPreference)localObject).aab(8);
      ((IconPreference)localObject).fZ("", -1);
      break;
      label389:
      i = 0;
      break label179;
      label394:
      if ((i == 0) && (this.xqN != null) && (this.xqN.EUD != 0) && (!bs.isNullOrNil(this.xqN.EUE)) && (!com.tencent.mm.sdk.platformtools.i.GqM))
      {
        ac.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[] { this.xqN.EUE, Integer.valueOf(this.xqN.EUF) });
        if (this.xqN.EUF != 0)
        {
          localObject = (IconSummaryPreference)this.screen.aPN("funtion_update");
          ((IconSummaryPreference)localObject).xpN = 0;
          ((IconSummaryPreference)localObject).aPQ(getString(2131755829));
          this.screen.aPO("funtion_check_update");
          break label254;
        }
        this.screen.aPO("funtion_update");
        break label254;
      }
      this.screen.aPO("funtion_update");
      break label254;
      label557:
      this.screen.aPO("funtion_crowdtest_update");
    }
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(74029);
    LinearLayout localLinearLayout = (LinearLayout)z.jD(getContext()).inflate(2131495381, null);
    Object localObject3 = (TextView)localLinearLayout.findViewById(2131305704);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131305703);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131305702);
    Object localObject2 = com.tencent.mm.kernel.g.agR().agA().get(274436, "").toString();
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = ab.eUN();
    }
    localObject2 = localObject1;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (!bs.aLk((String)localObject1)) {
        localObject2 = "";
      }
    }
    localObject1 = getString(2131760685, new Object[] { ab.eUO(), localObject2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    String str1 = getString(2131764600, new Object[] { ab.eUO(), localObject2 });
    String str2 = getString(2131760678, new Object[] { ab.eUO(), localObject2 });
    ((TextView)localObject3).setText(String.format("<a href='%s'>%s</a>", new Object[] { str1, getString(2131760681) }));
    localTextView1.setText(String.format("<a href='%s'>%s</a>", new Object[] { localObject1, getString(2131762010) }));
    localTextView2.setText(String.format("<a href='%s'>%s</a>", new Object[] { str2, getString(2131760677) }));
    k.m((TextView)localObject3, 1);
    k.m(localTextView1, 1);
    k.m(localTextView2, 1);
    if (((String)localObject2).equalsIgnoreCase("KR")) {
      localTextView2.setVisibility(0);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(2131298794);
    int i = 2020;
    try
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(com.tencent.mm.sdk.platformtools.h.TIME);
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).setTime((Date)localObject2);
      int j = ((Calendar)localObject3).get(1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.SettingsAboutMicroMsgUI", localException, "", new Object[0]);
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
    setActionbarColor(ao.aJ(getContext(), 2130968579));
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
      getListView().setBackgroundColor(ao.aJ(getContext(), 2130968579));
    }
    dBS();
    AppMethodBeat.o(74033);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74030);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    com.tencent.mm.kernel.g.agi().a(11, this);
    if (com.tencent.mm.plugin.q.d.dfa() != null)
    {
      paramBundle = com.tencent.mm.plugin.q.d.dfa().deZ();
      com.tencent.mm.kernel.g.agi().a((n)paramBundle, 0);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 15L, 1L, true);
    }
    AppMethodBeat.o(74030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74032);
    com.tencent.mm.kernel.g.agi().b(11, this);
    super.onDestroy();
    AppMethodBeat.o(74032);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74035);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    ac.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    ac.i("MicroMsg.SettingsAboutMicroMsgUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_update"))
    {
      if (ab.eUL())
      {
        com.tencent.mm.kernel.g.agP();
        paramf = getString(2131763450, new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(12304, null))) });
        if (paramf == null)
        {
          AppMethodBeat.o(74035);
          return true;
        }
        com.tencent.mm.kernel.g.agR().agA().set(12304, Integer.valueOf(0));
        paramPreference = new Intent();
        paramPreference.putExtra("title", getString(2131763449));
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", false);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
      }
      if (ab.eUL()) {}
      for (paramf = getString(2131763237, new Object[] { ab.eUO(), Integer.valueOf(com.tencent.mm.protocal.d.DIc) });; paramf = "https://blog.wechat.com/")
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
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 16L, 1L, true);
      paramPreference = "";
      if (this.xqM) {
        paramf = getString(2131763238, new Object[] { ab.eUO(), Integer.valueOf(this.xqO) });
      }
      for (;;)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("showShare", true);
        paramPreference.putExtra("show_bottom", false);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        AppMethodBeat.o(74035);
        return true;
        paramf = paramPreference;
        if (this.xqN != null)
        {
          paramf = paramPreference;
          if (this.xqN.EUD != 0)
          {
            paramf = paramPreference;
            if (!bs.isNullOrNil(this.xqN.EUE)) {
              paramf = this.xqN.EUE;
            }
          }
        }
      }
    }
    if (paramf.equals("funtion_check_update"))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 17L, 1L, true);
      if (com.tencent.mm.plugin.q.d.dfa() != null)
      {
        com.tencent.mm.plugin.q.d.dfa().deY();
        if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x1) != 0)
        {
          ac.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
          paramf = Uri.parse(com.tencent.mm.sdk.platformtools.i.GqI);
          paramPreference = new Intent("android.intent.action.VIEW", paramf).addFlags(268435456);
          if ((paramf == null) || (paramPreference == null) || (!bs.ah(getContext(), paramPreference)))
          {
            ac.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
            paramf = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
            paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 18L, 1L, true);
          }
          for (;;)
          {
            AppMethodBeat.o(74035);
            return true;
            ac.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
            paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 19L, 1L, true);
          }
        }
        if ((this.xqN != null) && (this.xqN.EUD != 0) && (!bs.isNullOrNil(this.xqN.EUE)))
        {
          paramf = this.xqN.EUE;
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          paramPreference.putExtra("show_bottom", false);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 20L, 1L, true);
          AppMethodBeat.o(74035);
          return true;
        }
        ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx()).commit();
        paramf = com.tencent.mm.plugin.q.d.dfa().c(this, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(74028);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 23L, 1L, true);
            AppMethodBeat.o(74028);
          }
        });
        if (paramf == null) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 21L, 1L, true);
        }
      }
      else
      {
        AppMethodBeat.o(74035);
        return false;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 22L, 1L, true);
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
      com.tencent.mm.ui.base.h.b(getContext(), 2131761068, 2131761067, 2131755939, 2131755831, new DialogInterface.OnClickListener()
      {
        private au hNn = null;
        private com.tencent.mm.ak.g onSceneEndCallback = null;
        
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74023);
          com.tencent.mm.modelstat.c.aIr().commitNow();
          ((com.tencent.mm.plugin.expt.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.e.class)).logout();
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN))
          {
            paramAnonymousDialogInterface = com.tencent.mm.kernel.g.agi();
            Object localObject = new com.tencent.mm.ak.g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(74020);
                com.tencent.mm.kernel.g.agi().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
            this.onSceneEndCallback = ((com.tencent.mm.ak.g)localObject);
            paramAnonymousDialogInterface.a(281, (com.tencent.mm.ak.g)localObject);
            paramAnonymousDialogInterface = new ad(2);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
            this.hNn = new au(new au.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(74021);
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.agi().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
            this.hNn.au(5000L, 5000L);
            localObject = SettingsAboutMicroMsgUI.this;
            AppCompatActivity localAppCompatActivity = SettingsAboutMicroMsgUI.this.getContext();
            SettingsAboutMicroMsgUI.this.getString(2131755906);
            SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject, com.tencent.mm.ui.base.h.b(localAppCompatActivity, SettingsAboutMicroMsgUI.this.getString(2131766171), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(74022);
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.agi().b(281, SettingsAboutMicroMsgUI.2.a(SettingsAboutMicroMsgUI.2.this));
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
      com.tencent.mm.y.c.aeH().cI(262157, 266263);
      paramf = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMU, null);
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      paramPreference.putExtra("showShare", false);
      paramPreference.putExtra("show_bottom", false);
      com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      AppMethodBeat.o(74035);
      return true;
    }
    AppMethodBeat.o(74035);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74031);
    super.onResume();
    dBS();
    AppMethodBeat.o(74031);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74036);
    ac.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt2 + " errType " + paramInt1);
    paramString = (b)paramn;
    ac.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + paramString.deW());
    ac.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + paramString.deV());
    ac.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.DIc);
    if ((com.tencent.mm.plugin.q.d.uVa) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      this.xqO = paramString.deV();
      if ((this.xqO <= 0) || (this.xqO <= com.tencent.mm.protocal.d.DIc)) {
        break label224;
      }
      this.xqM = true;
      if (!com.tencent.mm.kernel.g.agP().afY()) {
        break label212;
      }
      com.tencent.mm.y.c.aeH().w(262145, true);
    }
    for (;;)
    {
      this.xqN = paramString.deX();
      dBS();
      AppMethodBeat.o(74036);
      return;
      label212:
      ac.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
      continue;
      label224:
      this.xqM = false;
      if (com.tencent.mm.kernel.g.agP().afY()) {
        com.tencent.mm.y.c.aeH().w(262145, false);
      } else {
        ac.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
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