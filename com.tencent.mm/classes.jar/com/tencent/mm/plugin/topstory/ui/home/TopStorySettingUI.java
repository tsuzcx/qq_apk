package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.topstory.a.b.a.a;
import com.tencent.mm.plugin.topstory.a.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TopStorySettingUI
  extends MMPreference
{
  private final String BKA = "feedback";
  private IconPreference BKB;
  private IconPreference BKC;
  private int BKD = -1;
  private int BKE = -1;
  private int BKF = -1;
  private final String BKy = "unlike";
  private final String BKz = "black";
  private f screen;
  
  private boolean TD(int paramInt)
  {
    AppMethodBeat.i(125990);
    ae.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.BKF = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.BKF = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = bu.m(com.tencent.mm.plugin.topstory.a.b.a.esx().BIu, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      com.tencent.mm.plugin.websearch.api.ad.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = bu.m(com.tencent.mm.plugin.topstory.a.b.a.esx().AYQ, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      com.tencent.mm.plugin.websearch.api.ad.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private void esT()
  {
    AppMethodBeat.i(125986);
    this.BKE = com.tencent.mm.plugin.topstory.a.b.a.esx().AYQ.size();
    this.BKD = com.tencent.mm.plugin.topstory.a.b.a.esx().BIu.size();
    AppMethodBeat.o(125986);
  }
  
  private void esU()
  {
    AppMethodBeat.i(125989);
    ae.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.BKD), Integer.valueOf(this.BKE) });
    if (this.BKD <= 0)
    {
      this.BKB.setSummary("");
      if (this.BKE > 0) {
        break label110;
      }
      this.BKC.setSummary("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.BKB.setSummary(this.BKD);
      break;
      label110:
      this.BKC.setSummary(this.BKE);
    }
  }
  
  public int getResourceId()
  {
    return 2131951750;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125985);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131755135));
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
    this.BKB = ((IconPreference)this.screen.aXe("unlike"));
    this.BKC = ((IconPreference)this.screen.aXe("black"));
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.esx();
    paramBundle.ab(paramBundle.BIv, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.esx();
    paramBundle.ac(paramBundle.BIw, 0);
    esT();
    esU();
    com.tencent.mm.plugin.topstory.a.b.a.esx().BIB = new a.a()
    {
      public final void agz()
      {
        AppMethodBeat.i(125982);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125982);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.esx().BIC = new a.b()
    {
      public final void agz()
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
    com.tencent.mm.plugin.topstory.a.b.a.esx().BIC = null;
    com.tencent.mm.plugin.topstory.a.b.a.esx().BIB = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125984);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.BKD });
      bool = TD(1);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("black".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.BKE });
      bool = TD(2);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
      paramf = new StringBuilder("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    }
    try
    {
      paramf.append("&deviceName=").append(q.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "UTF-8"));
      label222:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(q.encode(Build.BRAND, "UTF-8"));
        try
        {
          label250:
          paramf.append("&deviceModel=").append(q.encode(Build.MODEL, "UTF-8"));
          label270:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          com.tencent.mm.kernel.g.ajP();
          paramPreference.append(com.tencent.mm.kernel.a.aiF());
          paramf.append("&version=").append(com.tencent.mm.protocal.d.FFH);
          try
          {
            paramf.append("&lang=").append(q.encode(com.tencent.mm.sdk.platformtools.ad.fom(), "UTF-8"));
            try
            {
              label332:
              paramf.append("&ostype=").append(q.encode(com.tencent.mm.protocal.d.FFD, "UTF-8"));
              label352:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(bu.fpH());
              paramf.append("&templateVersion=").append(com.tencent.mm.plugin.websearch.api.ad.WL(1));
              paramf.append("#/list/4155");
              ae.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + paramf.toString());
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf.toString());
              paramPreference.putExtra("convertActivityFromTranslucent", false);
              paramPreference.putExtra("customize_status_bar_color", 0);
              paramPreference.putExtra("status_bar_style", null);
              paramPreference.putExtra("prePublishId", "wes##2##1");
              paramPreference.putExtra("KPublisherId", "wes##2##1");
              paramPreference.putExtra("preChatTYPE", 10);
              com.tencent.mm.br.d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              AppMethodBeat.o(125984);
              return true;
              AppMethodBeat.o(125984);
              return false;
            }
            catch (Exception paramPreference)
            {
              break label352;
            }
          }
          catch (Exception paramPreference)
          {
            break label332;
          }
        }
        catch (Exception paramPreference)
        {
          break label270;
        }
      }
      catch (Exception paramPreference)
      {
        break label250;
      }
    }
    catch (Exception paramPreference)
    {
      break label222;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125987);
    super.onResume();
    esT();
    esU();
    AppMethodBeat.o(125987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI
 * JD-Core Version:    0.7.0.1
 */