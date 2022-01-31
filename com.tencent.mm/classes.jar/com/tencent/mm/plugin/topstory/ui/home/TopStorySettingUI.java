package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;

public class TopStorySettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private com.tencent.mm.ui.base.preference.f screen;
  private final String tgR = "unlike";
  private final String tgS = "black";
  private final String tgT = "feedback";
  private IconPreference tgU;
  private IconPreference tgV;
  private int tgW = -1;
  private int tgX = -1;
  private String tgY = "";
  private String tgZ = "";
  private int tha = -1;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private boolean Gy(int paramInt)
  {
    AppMethodBeat.i(1632);
    ab.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.tha = -1;
      AppMethodBeat.o(1632);
      return false;
    }
    this.tha = paramInt;
    if (paramInt == 1) {
      paramInt = 1;
    }
    while (((paramInt != 0) && (this.tgW < 0)) || ((paramInt == 0) && (this.tgX < 0))) {
      if (!bDC())
      {
        com.tencent.mm.ui.base.h.b(this, getString(2131304358), "", true);
        AppMethodBeat.o(1632);
        return false;
        paramInt = 0;
      }
      else
      {
        if (paramInt != 0)
        {
          localObject = new c(3);
          g.RK().eHt.a((m)localObject, 0);
        }
        for (;;)
        {
          this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131304357), true, new TopStorySettingUI.2(this));
          ab.i("MicroMsg.TopStory.TopStorySettingUI", "wait for data");
          AppMethodBeat.o(1632);
          return false;
          localObject = new c(1);
          g.RK().eHt.a((m)localObject, 0);
        }
      }
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Object localObject = new Intent();
    if (paramInt != 0)
    {
      ((Intent)localObject).putExtra("k_topstory_type", 1);
      ((Intent)localObject).putExtra("k_topstory_user_list", this.tgY);
      com.tencent.mm.plugin.websearch.api.aa.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", (Intent)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(1632);
      return true;
      ((Intent)localObject).putExtra("k_topstory_type", 2);
      ((Intent)localObject).putExtra("k_topstory_user_list", this.tgZ);
      com.tencent.mm.plugin.websearch.api.aa.d(this, ".ui.home.TopStorySettingVisibilityDetailUI", (Intent)localObject);
    }
  }
  
  private static boolean bDB()
  {
    AppMethodBeat.i(1633);
    int i = g.Rc().adt();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(1633);
      return true;
    }
    AppMethodBeat.o(1633);
    return false;
  }
  
  private static boolean bDC()
  {
    AppMethodBeat.i(1634);
    if (((com.tencent.mm.kernel.b.h)g.RI().Rj()).SD())
    {
      boolean bool = bDB();
      AppMethodBeat.o(1634);
      return bool;
    }
    if (at.isConnected(ah.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(1634);
      return true;
    }
    AppMethodBeat.o(1634);
    return false;
  }
  
  private void cIR()
  {
    AppMethodBeat.i(1630);
    ab.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", new Object[] { Integer.valueOf(this.tgW), Integer.valueOf(this.tgX) });
    if (this.tgW <= 0)
    {
      this.tgU.setSummary("");
      if (this.tgX > 0) {
        break label112;
      }
      this.tgV.setSummary("");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(1630);
      return;
      this.tgU.setSummary(this.tgW);
      break;
      label112:
      this.tgV.setSummary(this.tgX);
    }
  }
  
  public int getResourceId()
  {
    return 2131165306;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1627);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131296408));
    setBackBtn(new TopStorySettingUI.1(this));
    this.screen = getPreferenceScreen();
    this.tgU = ((IconPreference)this.screen.atx("unlike"));
    this.tgV = ((IconPreference)this.screen.atx("black"));
    g.Rc().a(2748, this);
    AppMethodBeat.o(1627);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1629);
    super.onDestroy();
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.Rc().b(2748, this);
    AppMethodBeat.o(1629);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(1626);
    paramf = paramPreference.mKey;
    boolean bool;
    if ("unlike".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.tgW });
      bool = Gy(1);
      AppMethodBeat.o(1626);
      return bool;
    }
    if ("black".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.tgX });
      bool = Gy(2);
      AppMethodBeat.o(1626);
      return bool;
    }
    if ("feedback".equals(paramf))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(18), Integer.valueOf(2), "0" });
      paramf = new StringBuilder("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
    }
    try
    {
      paramf.append("&deviceName=").append(q.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "UTF-8"));
      label225:
      paramf.append("&imei=");
      try
      {
        paramf.append("&deviceBrand=").append(q.encode(Build.BRAND, "UTF-8"));
        try
        {
          label253:
          paramf.append("&deviceModel=").append(q.encode(Build.MODEL, "UTF-8"));
          label273:
          paramf.append("&from=settingPage");
          paramPreference = paramf.append("&uin=");
          g.RJ();
          paramPreference.append(a.QC());
          paramf.append("&version=").append(com.tencent.mm.protocal.d.whH);
          try
          {
            paramf.append("&lang=").append(q.encode(com.tencent.mm.sdk.platformtools.aa.dsG(), "UTF-8"));
            try
            {
              label335:
              paramf.append("&ostype=").append(q.encode(com.tencent.mm.protocal.d.whD, "UTF-8"));
              label355:
              paramf.append("&scene=32");
              paramf.append("&timeZone=").append(bo.dtS());
              paramf.append("&templateVersion=").append(com.tencent.mm.plugin.websearch.api.aa.Jn(1));
              paramf.append("#/list/4155");
              ab.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + paramf.toString());
              paramPreference = new Intent();
              paramPreference.putExtra("rawUrl", paramf.toString());
              paramPreference.putExtra("convertActivityFromTranslucent", false);
              paramPreference.putExtra("customize_status_bar_color", 0);
              paramPreference.putExtra("status_bar_style", null);
              paramPreference.putExtra("prePublishId", "wes##2##1");
              paramPreference.putExtra("KPublisherId", "wes##2##1");
              paramPreference.putExtra("preChatTYPE", 10);
              com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              AppMethodBeat.o(1626);
              return true;
              AppMethodBeat.o(1626);
              return false;
            }
            catch (Exception paramPreference)
            {
              break label355;
            }
          }
          catch (Exception paramPreference)
          {
            break label335;
          }
        }
        catch (Exception paramPreference)
        {
          break label273;
        }
      }
      catch (Exception paramPreference)
      {
        break label253;
      }
    }
    catch (Exception paramPreference)
    {
      break label225;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(1628);
    super.onResume();
    this.tgW = -1;
    this.tgX = -1;
    this.tgY = "";
    this.tgZ = "";
    cIR();
    c localc1 = new c(1);
    c localc2 = new c(3);
    g.RK().eHt.a(localc1, 0);
    g.RK().eHt.a(localc2, 0);
    ab.i("MicroMsg.TopStory.TopStorySettingUI", "onResume doscene");
    AppMethodBeat.o(1628);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1631);
    ab.i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      paramInt1 = 1;
    }
    ajd localajd;
    while ((paramm instanceof c))
    {
      paramm = (c)paramm;
      paramInt2 = paramm.type;
      if (paramInt1 == 0)
      {
        ab.i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd fail, type:%s", new Object[] { Integer.valueOf(paramInt2) });
        if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
          com.tencent.mm.ui.base.h.b(this, getString(2131304358), "", true);
        }
        AppMethodBeat.o(1631);
        return;
        paramInt1 = 0;
      }
      else
      {
        paramString = (ajc)paramm.rr.fsW.fta;
        if (paramString.wrp.isEmpty())
        {
          if (paramInt2 == 3) {
            this.tgW = 0;
          }
          for (;;)
          {
            cIR();
            AppMethodBeat.o(1631);
            return;
            if (paramm.type == 1) {
              this.tgX = 0;
            }
          }
        }
        if (paramInt2 != 3) {
          break label355;
        }
        paramm = new StringBuilder();
        this.tgW = 0;
        paramString = paramString.wrp.iterator();
        while (paramString.hasNext())
        {
          localajd = (ajd)paramString.next();
          this.tgW += 1;
          paramm.append(localajd.Username).append(",");
        }
        this.tgY = paramm.toString();
      }
    }
    for (;;)
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
        Gy(this.tha);
      }
      cIR();
      AppMethodBeat.o(1631);
      return;
      label355:
      if (paramInt2 == 1)
      {
        paramm = new StringBuilder();
        this.tgX = 0;
        paramString = paramString.wrp.iterator();
        while (paramString.hasNext())
        {
          localajd = (ajd)paramString.next();
          this.tgX += 1;
          paramm.append(localajd.Username).append(",");
        }
        this.tgZ = paramm.toString();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI
 * JD-Core Version:    0.7.0.1
 */