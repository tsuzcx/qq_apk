package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.topstory.a.b.a.a;
import com.tencent.mm.plugin.topstory.a.b.a.b;
import com.tencent.mm.plugin.topstory.e;
import com.tencent.mm.plugin.topstory.e.a;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.fuu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TopStorySettingUI
  extends MMPreference
{
  private boolean FRp = false;
  private IconPreference TKA;
  private IconPreference TKB;
  private CheckBoxPreference TKC;
  private int TKD = -1;
  private int TKE = -1;
  private int TKF = -1;
  private boolean TKG = true;
  private final String TKv = "unlike";
  private final String TKw = "black";
  private final String TKx = "feedback";
  private final String TKy = "settings_top_story_setting_recommend";
  private final String TKz = "TopStorySettingUI_settings_top_story_recommend";
  private f screen;
  
  private boolean aoR(int paramInt)
  {
    AppMethodBeat.i(125990);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.TKF = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.TKF = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      aj.f(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      aj.f(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private boolean aoS(int paramInt)
  {
    AppMethodBeat.i(271782);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.TKF = -1;
      AppMethodBeat.o(271782);
      return false;
    }
    this.TKF = paramInt;
    Object localObject = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs, ",");
      ((Intent)localObject).putExtra("k_topstory_type", 1);
      ((Intent)localObject).putExtra("k_topstory_user_list", str);
      ((Intent)localObject).setClassName(this, "com.tencent.mm.ui.contact.privacy.TopStorySettingVisibilityDetailUI");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(271782);
      return true;
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig, ",");
      ((Intent)localObject).putExtra("k_topstory_type", 2);
      ((Intent)localObject).putExtra("k_topstory_user_list", str);
      ((Intent)localObject).setClassName(this, "com.tencent.mm.ui.contact.privacy.TopStorySettingVisibilityDetailUI");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  private void eJa()
  {
    AppMethodBeat.i(125986);
    this.TKE = com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig.size();
    this.TKD = com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs.size();
    AppMethodBeat.o(125986);
  }
  
  private void hNl()
  {
    AppMethodBeat.i(125989);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.TKD), Integer.valueOf(this.TKE) });
    if (this.TKD <= 0)
    {
      this.TKA.aS("");
      if (this.TKE > 0) {
        break label110;
      }
      this.TKB.aS("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.TKA.aS(this.TKD);
      break;
      label110:
      this.TKB.aS(this.TKE);
    }
  }
  
  public int getResourceId()
  {
    return c.i.topstory_setting_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125985);
    super.onCreate(paramBundle);
    setMMTitle(getString(c.g.top_story_setting_title));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(271736);
        TopStorySettingUI.this.finish();
        AppMethodBeat.o(271736);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.TKA = ((IconPreference)this.screen.bAi("unlike"));
    this.TKB = ((IconPreference)this.screen.bAi("black"));
    this.FRp = getIntent().getBooleanExtra("intent_status_from_privacy_to_tophistory_setting", false);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.hMM();
    paramBundle.aF(paramBundle.TIt, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.hMM();
    paramBundle.aG(paramBundle.TIu, 0);
    eJa();
    hNl();
    com.tencent.mm.plugin.topstory.a.b.a.hMM().TIz = new a.a()
    {
      public final void cwC()
      {
        AppMethodBeat.i(125983);
        TopStorySettingUI.c(TopStorySettingUI.this);
        TopStorySettingUI.d(TopStorySettingUI.this);
        AppMethodBeat.o(125983);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.hMM().TIA = new a.b()
    {
      public final void cwC()
      {
        AppMethodBeat.i(271728);
        TopStorySettingUI.c(TopStorySettingUI.this);
        TopStorySettingUI.d(TopStorySettingUI.this);
        AppMethodBeat.o(271728);
      }
    };
    if (this.FRp)
    {
      this.screen.eh("feedback", true);
      this.screen.eh("not_be_seen_desc", true);
      this.screen.eh("unlike_desc", true);
      this.screen.eh("unlike_empty", true);
      this.screen.eh("black_empty", true);
      this.screen.eh("settings_top_story_setting_recommend", true);
    }
    this.TKC = ((CheckBoxPreference)this.screen.bAi("settings_top_story_setting_recommend"));
    if ((!this.FRp) && (this.TKC != null))
    {
      this.TKC.setChecked(MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("TopStorySettingUI_settings_top_story_recommend", true));
      Log.i("MicroMsg.TopStory.TopStorySettingUI", "onCreate, KEY_TOP_STORY_RECOMMEND = " + this.TKC.isChecked());
      this.TKG = this.TKC.isChecked();
      e.a(this, 0, new e.a()
      {
        public final void a(fuu paramAnonymousfuu)
        {
          boolean bool = true;
          AppMethodBeat.i(271732);
          if ((paramAnonymousfuu.state == 1) || (paramAnonymousfuu.state == 2))
          {
            Log.i("MicroMsg.TopStory.TopStorySettingUI", "init, onSuccess checkBoxRcmPreference, response.state = " + paramAnonymousfuu.state);
            CheckBoxPreference localCheckBoxPreference = TopStorySettingUI.a(TopStorySettingUI.this);
            if (paramAnonymousfuu.state == 2) {}
            for (;;)
            {
              localCheckBoxPreference.setChecked(bool);
              MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("TopStorySettingUI_settings_top_story_recommend", TopStorySettingUI.a(TopStorySettingUI.this).isChecked()).apply();
              AppMethodBeat.o(271732);
              return;
              bool = false;
            }
          }
          TopStorySettingUI.a(TopStorySettingUI.this).setChecked(TopStorySettingUI.b(TopStorySettingUI.this));
          Log.i("MicroMsg.TopStory.TopStorySettingUI", "error happen, unkonw state.");
          AppMethodBeat.o(271732);
        }
        
        public final void cjC()
        {
          AppMethodBeat.i(271733);
          Log.i("MicroMsg.TopStory.TopStorySettingUI", "init, onFail, lastRecommendSwithIsChecked = " + TopStorySettingUI.b(TopStorySettingUI.this));
          TopStorySettingUI.a(TopStorySettingUI.this).setChecked(TopStorySettingUI.b(TopStorySettingUI.this));
          AppMethodBeat.o(271733);
        }
      });
    }
    AppMethodBeat.o(125985);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125988);
    super.onDestroy();
    com.tencent.mm.plugin.topstory.a.b.a.hMM().TIA = null;
    com.tencent.mm.plugin.topstory.a.b.a.hMM().TIz = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(125984);
    paramPreference = paramPreference.mKey;
    boolean bool1;
    if ("unlike".equals(paramPreference))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.TKD });
      if (this.FRp)
      {
        bool1 = aoS(1);
        AppMethodBeat.o(125984);
        return bool1;
      }
      bool1 = aoR(1);
      AppMethodBeat.o(125984);
      return bool1;
    }
    if ("black".equals(paramPreference))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.TKE });
      if (this.FRp)
      {
        bool1 = aoS(2);
        AppMethodBeat.o(125984);
        return bool1;
      }
      bool1 = aoR(2);
      AppMethodBeat.o(125984);
      return bool1;
    }
    if ("settings_top_story_setting_recommend".equals(paramPreference)) {
      if (!((CheckBoxPreference)paramf.bAi("settings_top_story_setting_recommend")).isChecked())
      {
        bool1 = true;
        this.TKG = bool1;
        bool2 = this.TKG;
        if (this.TKG) {
          break label328;
        }
        bool1 = true;
        Log.i("MicroMsg.TopStory.TopStorySettingUI", "onPreferenceTreeClick, lastRecommendSwithIsChecked = %s, isCheck = %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (this.TKC != null) {
          break label334;
        }
        Log.i("MicroMsg.TopStory.TopStorySettingUI", "doRecommandStateAction, checkBoxRcmPreference checkBoxRcmPreference, lastRecommendSwithIsChecked = " + this.TKG);
      }
    }
    label328:
    label334:
    while (!"feedback".equals(paramPreference)) {
      for (;;)
      {
        boolean bool2;
        AppMethodBeat.o(125984);
        return false;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        if (this.TKC.isChecked()) {
          i = 2;
        }
        e.a(this, i, new e.a()
        {
          public final void a(fuu paramAnonymousfuu)
          {
            boolean bool = true;
            AppMethodBeat.i(271737);
            if ((paramAnonymousfuu.state == 1) || (paramAnonymousfuu.state == 2))
            {
              Log.i("MicroMsg.TopStory.TopStorySettingUI", "showSafeDialogCheck, onSuccess, response.state = " + paramAnonymousfuu.state);
              CheckBoxPreference localCheckBoxPreference = TopStorySettingUI.a(TopStorySettingUI.this);
              if (paramAnonymousfuu.state == 2) {}
              for (;;)
              {
                localCheckBoxPreference.setChecked(bool);
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("TopStorySettingUI_settings_top_story_recommend", TopStorySettingUI.a(TopStorySettingUI.this).isChecked()).apply();
                AppMethodBeat.o(271737);
                return;
                bool = false;
              }
            }
            TopStorySettingUI.a(TopStorySettingUI.this).setChecked(TopStorySettingUI.b(TopStorySettingUI.this));
            Log.i("MicroMsg.TopStory.TopStorySettingUI", "error happen, unkonw state.");
            AppMethodBeat.o(271737);
          }
          
          public final void cjC()
          {
            AppMethodBeat.i(271738);
            Log.i("MicroMsg.TopStory.TopStorySettingUI", "showSafeDialogCheck, onFail, lastRecommendSwithIsChecked = " + TopStorySettingUI.b(TopStorySettingUI.this));
            TopStorySettingUI.a(TopStorySettingUI.this).setChecked(TopStorySettingUI.b(TopStorySettingUI.this));
            AppMethodBeat.o(271738);
          }
        });
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
    paramf = new StringBuilder("https://" + WeChatHosts.domainString(c.g.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    try
    {
      paramf.append("&deviceName=").append(r.as(d.Yxf, "UTF-8"));
      label461:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(r.as(Build.BRAND, "UTF-8"));
        try
        {
          label489:
          paramf.append("&deviceModel=").append(r.as(q.aPo(), "UTF-8"));
          label509:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          com.tencent.mm.kernel.h.baC();
          paramPreference.append(b.aZs());
          paramf.append("&version=").append(d.Yxh);
          try
          {
            paramf.append("&lang=").append(r.as(LocaleUtil.getApplicationLanguage(), "UTF-8"));
            try
            {
              label571:
              paramf.append("&ostype=").append(r.as(d.Yxc, "UTF-8"));
              label591:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(Util.getTimeZoneOffset());
              paramf.append("&templateVersion=").append(aj.asY(1));
              paramf.append("#/list/4155");
              Log.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + paramf.toString());
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf.toString());
              paramPreference.putExtra("convertActivityFromTranslucent", false);
              paramPreference.putExtra("customize_status_bar_color", 0);
              paramPreference.putExtra("status_bar_style", null);
              paramPreference.putExtra("prePublishId", "wes##2##1");
              paramPreference.putExtra("KPublisherId", "wes##2##1");
              paramPreference.putExtra("preChatTYPE", 10);
              c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              AppMethodBeat.o(125984);
              return true;
            }
            catch (Exception paramPreference)
            {
              break label591;
            }
          }
          catch (Exception paramPreference)
          {
            break label571;
          }
        }
        catch (Exception paramPreference)
        {
          break label509;
        }
      }
      catch (Exception paramPreference)
      {
        break label489;
      }
    }
    catch (Exception paramPreference)
    {
      break label461;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125987);
    super.onResume();
    eJa();
    hNl();
    AppMethodBeat.o(125987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI
 * JD-Core Version:    0.7.0.1
 */