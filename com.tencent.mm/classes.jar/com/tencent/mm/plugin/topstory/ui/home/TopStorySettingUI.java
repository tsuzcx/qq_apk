package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.topstory.a.b.a.a;
import com.tencent.mm.plugin.topstory.a.b.a.b;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TopStorySettingUI
  extends MMPreference
{
  private boolean ArN = false;
  private final String MXR = "unlike";
  private final String MXS = "black";
  private final String MXT = "feedback";
  private IconPreference MXU;
  private IconPreference MXV;
  private int MXW = -1;
  private int MXX = -1;
  private int MXY = -1;
  private f screen;
  
  private boolean ajy(int paramInt)
  {
    AppMethodBeat.i(125990);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.MXY = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.MXY = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private boolean ajz(int paramInt)
  {
    AppMethodBeat.i(204393);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.MXY = -1;
      AppMethodBeat.o(204393);
      return false;
    }
    this.MXY = paramInt;
    Object localObject = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO, ",");
      ((Intent)localObject).putExtra("k_topstory_type", 1);
      ((Intent)localObject).putExtra("k_topstory_user_list", str);
      ((Intent)localObject).setClassName(this, "com.tencent.mm.ui.contact.privacy.TopStorySettingVisibilityDetailUI");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(204393);
      return true;
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy, ",");
      ((Intent)localObject).putExtra("k_topstory_type", 2);
      ((Intent)localObject).putExtra("k_topstory_user_list", str);
      ((Intent)localObject).setClassName(this, "com.tencent.mm.ui.contact.privacy.TopStorySettingVisibilityDetailUI");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/topstory/ui/home/TopStorySettingUI", "goDetailPrivacySettingUI", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  private void gqn()
  {
    AppMethodBeat.i(125986);
    this.MXX = com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy.size();
    this.MXW = com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO.size();
    AppMethodBeat.o(125986);
  }
  
  private void gqo()
  {
    AppMethodBeat.i(125989);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.MXW), Integer.valueOf(this.MXX) });
    if (this.MXW <= 0)
    {
      this.MXU.aF("");
      if (this.MXX > 0) {
        break label110;
      }
      this.MXV.aF("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.MXU.aF(this.MXW);
      break;
      label110:
      this.MXV.aF(this.MXX);
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
        AppMethodBeat.i(125981);
        TopStorySettingUI.this.finish();
        AppMethodBeat.o(125981);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.MXU = ((IconPreference)this.screen.byG("unlike"));
    this.MXV = ((IconPreference)this.screen.byG("black"));
    this.ArN = getIntent().getBooleanExtra("intent_status_from_privacy_to_tophistory_setting", false);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.gpQ();
    paramBundle.an(paramBundle.MVP, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.gpQ();
    paramBundle.ao(paramBundle.MVQ, 0);
    gqn();
    gqo();
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVV = new a.a()
    {
      public final void bWp()
      {
        AppMethodBeat.i(125982);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125982);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVW = new a.b()
    {
      public final void bWp()
      {
        AppMethodBeat.i(125983);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125983);
      }
    };
    if (this.ArN)
    {
      this.screen.dz("feedback", true);
      this.screen.dz("not_be_seen_desc", true);
      this.screen.dz("unlike_desc", true);
      this.screen.dz("unlike_empty", true);
      this.screen.dz("black_empty", true);
    }
    AppMethodBeat.o(125985);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125988);
    super.onDestroy();
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVW = null;
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVV = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125984);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.MXW });
      if (this.ArN)
      {
        bool = ajz(1);
        AppMethodBeat.o(125984);
        return bool;
      }
      bool = ajy(1);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("black".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.MXX });
      if (this.ArN)
      {
        bool = ajz(2);
        AppMethodBeat.o(125984);
        return bool;
      }
      bool = ajy(2);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
      paramf = new StringBuilder("https://" + WeChatHosts.domainString(c.g.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    }
    try
    {
      paramf.append("&deviceName=").append(q.an(d.RAB, "UTF-8"));
      label292:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(q.an(Build.BRAND, "UTF-8"));
        try
        {
          label320:
          paramf.append("&deviceModel=").append(q.an(Build.MODEL, "UTF-8"));
          label340:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          com.tencent.mm.kernel.h.aHE();
          paramPreference.append(b.aGq());
          paramf.append("&version=").append(d.RAD);
          try
          {
            paramf.append("&lang=").append(q.an(LocaleUtil.getApplicationLanguage(), "UTF-8"));
            try
            {
              label402:
              paramf.append("&ostype=").append(q.an(d.RAy, "UTF-8"));
              label422:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(Util.getTimeZoneOffset());
              paramf.append("&templateVersion=").append(ai.anh(1));
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
              AppMethodBeat.o(125984);
              return false;
            }
            catch (Exception paramPreference)
            {
              break label422;
            }
          }
          catch (Exception paramPreference)
          {
            break label402;
          }
        }
        catch (Exception paramPreference)
        {
          break label340;
        }
      }
      catch (Exception paramPreference)
      {
        break label320;
      }
    }
    catch (Exception paramPreference)
    {
      break label292;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125987);
    super.onResume();
    gqn();
    gqo();
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