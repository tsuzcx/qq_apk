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
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TopStorySettingUI
  extends MMPreference
{
  private f screen;
  private final String yNA = "feedback";
  private IconPreference yNB;
  private IconPreference yNC;
  private int yND = -1;
  private int yNE = -1;
  private int yNF = -1;
  private final String yNy = "unlike";
  private final String yNz = "black";
  
  private boolean Pg(int paramInt)
  {
    AppMethodBeat.i(125990);
    ad.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.yNF = -1;
      AppMethodBeat.o(125990);
      return false;
    }
    this.yNF = paramInt;
    Intent localIntent = new Intent();
    String str;
    if (paramInt == 1)
    {
      str = bt.n(com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLq, ",");
      localIntent.putExtra("k_topstory_type", 1);
      localIntent.putExtra("k_topstory_user_list", str);
      aa.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(125990);
      return true;
      str = bt.n(com.tencent.mm.plugin.topstory.a.b.a.dNZ().yct, ",");
      localIntent.putExtra("k_topstory_type", 2);
      localIntent.putExtra("k_topstory_user_list", str);
      aa.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", localIntent);
    }
  }
  
  private void dOu()
  {
    AppMethodBeat.i(125986);
    this.yNE = com.tencent.mm.plugin.topstory.a.b.a.dNZ().yct.size();
    this.yND = com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLq.size();
    AppMethodBeat.o(125986);
  }
  
  private void dOv()
  {
    AppMethodBeat.i(125989);
    ad.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.yND), Integer.valueOf(this.yNE) });
    if (this.yND <= 0)
    {
      this.yNB.setSummary("");
      if (this.yNE > 0) {
        break label110;
      }
      this.yNC.setSummary("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(125989);
      return;
      this.yNB.setSummary(this.yND);
      break;
      label110:
      this.yNC.setSummary(this.yNE);
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
    this.yNB = ((IconPreference)this.screen.aKk("unlike"));
    this.yNC = ((IconPreference)this.screen.aKk("black"));
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.dNZ();
    paramBundle.T(paramBundle.yLr, 0);
    paramBundle = com.tencent.mm.plugin.topstory.a.b.a.dNZ();
    paramBundle.U(paramBundle.yLs, 0);
    dOu();
    dOv();
    com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLx = new a.a()
    {
      public final void acz()
      {
        AppMethodBeat.i(125982);
        TopStorySettingUI.a(TopStorySettingUI.this);
        TopStorySettingUI.b(TopStorySettingUI.this);
        AppMethodBeat.o(125982);
      }
    };
    com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLy = new a.b()
    {
      public final void acz()
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
    com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLy = null;
    com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLx = null;
    AppMethodBeat.o(125988);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125984);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      h.vKh.f(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.yND });
      bool = Pg(1);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("black".equals(paramf))
    {
      h.vKh.f(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.yNE });
      bool = Pg(2);
      AppMethodBeat.o(125984);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      h.vKh.f(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
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
          g.afz();
          paramPreference.append(com.tencent.mm.kernel.a.aeo());
          paramf.append("&version=").append(com.tencent.mm.protocal.d.CpK);
          try
          {
            paramf.append("&lang=").append(p.encode(ac.eFu(), "UTF-8"));
            try
            {
              label332:
              paramf.append("&ostype=").append(p.encode(com.tencent.mm.protocal.d.CpG, "UTF-8"));
              label352:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(bt.eGH());
              paramf.append("&templateVersion=").append(aa.Sb(1));
              paramf.append("#/list/4155");
              ad.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + paramf.toString());
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf.toString());
              paramPreference.putExtra("convertActivityFromTranslucent", false);
              paramPreference.putExtra("customize_status_bar_color", 0);
              paramPreference.putExtra("status_bar_style", null);
              paramPreference.putExtra("prePublishId", "wes##2##1");
              paramPreference.putExtra("KPublisherId", "wes##2##1");
              paramPreference.putExtra("preChatTYPE", 10);
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
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
    dOu();
    dOv();
    AppMethodBeat.o(125987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI
 * JD-Core Version:    0.7.0.1
 */