package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.topstory.a.b.a.a;
import com.tencent.mm.plugin.topstory.a.b.a.b;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TopStorySettingUI
  extends MMPreference
{
  private final String Abp = "unlike";
  private final String Abq = "black";
  private final String Abr = "feedback";
  private IconPreference Abs;
  private IconPreference Abt;
  private int Abu = -1;
  private int Abv = -1;
  private int Abw = -1;
  private f screen;
  
  private boolean Rm(int paramInt)
  {
    AppMethodBeat.i(125990);
    ac.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.Abw = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.Abw = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = bs.n(com.tencent.mm.plugin.topstory.a.b.a.ecz().zZj, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      z.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = bs.n(com.tencent.mm.plugin.topstory.a.b.a.ecz().zpt, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      z.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private void ecV()
  {
    AppMethodBeat.i(125986);
    this.Abv = com.tencent.mm.plugin.topstory.a.b.a.ecz().zpt.size();
    this.Abu = com.tencent.mm.plugin.topstory.a.b.a.ecz().zZj.size();
    AppMethodBeat.o(125986);
  }
  
  private void ecW()
  {
    AppMethodBeat.i(125989);
    ac.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.Abu), Integer.valueOf(this.Abv) });
    if (this.Abu <= 0)
    {
      this.Abs.setSummary("");
      if (this.Abv > 0) {
        break label110;
      }
      this.Abt.setSummary("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.Abs.setSummary(this.Abu);
      break;
      label110:
      this.Abt.setSummary(this.Abv);
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
    this.Abs = ((IconPreference)this.screen.aPN("unlike"));
    this.Abt = ((IconPreference)this.screen.aPN("black"));
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.ecz();
    paramBundle.W(paramBundle.zZk, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.ecz();
    paramBundle.X(paramBundle.zZl, 0);
    ecV();
    ecW();
    com.tencent.mm.plugin.topstory.a.b.a.ecz().zZq = new a.a()
    {
      public final void adF()
      {
        AppMethodBeat.i(125982);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125982);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.ecz().zZr = new a.b()
    {
      public final void adF()
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
    com.tencent.mm.plugin.topstory.a.b.a.ecz().zZr = null;
    com.tencent.mm.plugin.topstory.a.b.a.ecz().zZq = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125984);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      h.wUl.f(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.Abu });
      bool = Rm(1);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("black".equals(paramf))
    {
      h.wUl.f(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Abv });
      bool = Rm(2);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      h.wUl.f(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
      paramf = new StringBuilder("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    }
    try
    {
      paramf.append("&deviceName=").append(p.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "UTF-8"));
      label222:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(p.encode(Build.BRAND, "UTF-8"));
        try
        {
          label250:
          paramf.append("&deviceModel=").append(p.encode(Build.MODEL, "UTF-8"));
          label270:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          g.agP();
          paramPreference.append(com.tencent.mm.kernel.a.afE());
          paramf.append("&version=").append(com.tencent.mm.protocal.d.DIc);
          try
          {
            paramf.append("&lang=").append(p.encode(ab.eUO(), "UTF-8"));
            try
            {
              label332:
              paramf.append("&ostype=").append(p.encode(com.tencent.mm.protocal.d.DHY, "UTF-8"));
              label352:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(bs.eWc());
              paramf.append("&templateVersion=").append(z.Ul(1));
              paramf.append("#/list/4155");
              ac.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + paramf.toString());
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf.toString());
              paramPreference.putExtra("convertActivityFromTranslucent", false);
              paramPreference.putExtra("customize_status_bar_color", 0);
              paramPreference.putExtra("status_bar_style", null);
              paramPreference.putExtra("prePublishId", "wes##2##1");
              paramPreference.putExtra("KPublisherId", "wes##2##1");
              paramPreference.putExtra("preChatTYPE", 10);
              com.tencent.mm.br.d.b(ai.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
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
    ecV();
    ecW();
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