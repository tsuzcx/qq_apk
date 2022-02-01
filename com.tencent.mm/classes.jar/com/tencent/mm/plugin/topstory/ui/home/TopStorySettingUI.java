package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.topstory.a.b.a.a;
import com.tencent.mm.plugin.topstory.a.b.a.b;
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
  private final String Gle = "unlike";
  private final String Glf = "black";
  private final String Glg = "feedback";
  private IconPreference Glh;
  private IconPreference Gli;
  private int Glj = -1;
  private int Glk = -1;
  private int Gll = -1;
  private f screen;
  
  private boolean abT(int paramInt)
  {
    AppMethodBeat.i(125990);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.Gll = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.Gll = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = Util.listToString(com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private void fyq()
  {
    AppMethodBeat.i(125986);
    this.Glk = com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN.size();
    this.Glj = com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd.size();
    AppMethodBeat.o(125986);
  }
  
  private void fyr()
  {
    AppMethodBeat.i(125989);
    Log.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.Glj), Integer.valueOf(this.Glk) });
    if (this.Glj <= 0)
    {
      this.Glh.setSummary("");
      if (this.Glk > 0) {
        break label110;
      }
      this.Gli.setSummary("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.Glh.setSummary(this.Glj);
      break;
      label110:
      this.Gli.setSummary(this.Glk);
    }
  }
  
  public int getResourceId()
  {
    return 2132017295;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125985);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131755153));
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
    this.Glh = ((IconPreference)this.screen.bmg("unlike"));
    this.Gli = ((IconPreference)this.screen.bmg("black"));
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.fxV();
    paramBundle.ae(paramBundle.Gje, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.fxV();
    paramBundle.af(paramBundle.Gjf, 0);
    fyq();
    fyr();
    com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjk = new a.a()
    {
      public final void awp()
      {
        AppMethodBeat.i(125982);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125982);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjl = new a.b()
    {
      public final void awp()
      {
        AppMethodBeat.i(125983);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125983);
      }
    };
    AppMethodBeat.o(125985);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125988);
    super.onDestroy();
    com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjl = null;
    com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjk = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125984);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      h.CyF.a(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.Glj });
      bool = abT(1);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("black".equals(paramf))
    {
      h.CyF.a(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Glk });
      bool = abT(2);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      h.CyF.a(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
      paramf = new StringBuilder("https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    }
    try
    {
      paramf.append("&deviceName=").append(q.encode(d.DEVICE_NAME, "UTF-8"));
      label247:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(q.encode(Build.BRAND, "UTF-8"));
        try
        {
          label275:
          paramf.append("&deviceModel=").append(q.encode(Build.MODEL, "UTF-8"));
          label295:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          g.aAf();
          paramPreference.append(com.tencent.mm.kernel.a.ayV());
          paramf.append("&version=").append(d.KyO);
          try
          {
            paramf.append("&lang=").append(q.encode(LocaleUtil.getApplicationLanguage(), "UTF-8"));
            try
            {
              label357:
              paramf.append("&ostype=").append(q.encode(d.KyK, "UTF-8"));
              label377:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(Util.getTimeZoneOffset());
              paramf.append("&templateVersion=").append(ai.aft(1));
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
              break label377;
            }
          }
          catch (Exception paramPreference)
          {
            break label357;
          }
        }
        catch (Exception paramPreference)
        {
          break label295;
        }
      }
      catch (Exception paramPreference)
      {
        break label275;
      }
    }
    catch (Exception paramPreference)
    {
      break label247;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125987);
    super.onResume();
    fyq();
    fyr();
    AppMethodBeat.o(125987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI
 * JD-Core Version:    0.7.0.1
 */