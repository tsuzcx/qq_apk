package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.rz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.f;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;

public class b
  implements a
{
  protected byb cbF;
  protected ThreeDotsLoadingView him;
  protected FrameLayout oGO;
  protected MMActivity pDR;
  protected boolean pDS;
  protected com.tencent.mm.plugin.topstory.ui.webview.b pDT;
  protected TopStoryWebView pDU;
  protected com.tencent.mm.plugin.topstory.ui.webview.d pDV;
  protected View pDW;
  private boolean pDX;
  private boolean pDY;
  private boolean pDZ;
  protected c<rz> pEa = new b.5(this);
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.pDR = paramMMActivity;
    this.pDS = paramBoolean;
  }
  
  public final void PK(String paramString)
  {
    this.pDZ = true;
    this.pDV.PK(paramString);
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.b paramb, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.d paramd, byb parambyb)
  {
    this.pDT = paramb;
    this.pDU = paramTopStoryWebView;
    this.pDV = paramd;
    this.pDV.pIe = this;
    this.cbF = parambyb;
    this.pDT.pIe = this;
    paramb = new FrameLayout.LayoutParams(-1, -1);
    this.oGO.addView(this.pDU, paramb);
  }
  
  public final void bNk()
  {
    this.pDX = true;
  }
  
  public final void bNl()
  {
    this.pDY = true;
    ai.d(new b.4(this));
  }
  
  protected final void bNm()
  {
    if (this.pDY) {
      com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      ao.BG(19);
      if (!this.pDS) {
        break;
      }
      this.pDR.finish();
      return;
      if (this.pDX)
      {
        if (this.pDZ) {
          com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.pDR.moveTaskToBack(true);
  }
  
  protected boolean bNn()
  {
    return true;
  }
  
  public final MMActivity bfn()
  {
    return this.pDR;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onCreate");
    this.cbF = new byb();
    try
    {
      this.cbF.aH(this.pDR.getIntent().getByteArrayExtra("key_context"));
      if (!bk.bl(this.cbF.tNY))
      {
        y.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.cbF.tNY });
        this.pEa.cqo();
        ao.BG(17);
        this.pDR.setBackBtn(new b.1(this));
        this.oGO = ((FrameLayout)this.pDR.findViewById(b.d.webview_container));
        if (((com.tencent.mm.plugin.topstory.ui.a)g.t(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr() == null) {
          break label440;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.a)g.t(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().pEh) {
          ((com.tencent.mm.plugin.topstory.ui.a)g.t(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().b(this.cbF);
        }
        ((com.tencent.mm.plugin.topstory.ui.a)g.t(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().a(this);
        this.pDW = this.pDR.findViewById(b.d.splash_view);
        this.him = ((ThreeDotsLoadingView)this.pDR.findViewById(b.d.loading_view));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.g.b.zL()))
        {
          this.pDR.getWindow().setStatusBarColor(this.pDR.getResources().getColor(b.a.websearch_bg));
          this.pDR.czk();
        }
        this.pDR.setMMTitle(this.cbF.tOb);
        this.pDR.oX(-16777216);
        this.pDR.czn();
        this.pDR.ta(Color.parseColor("#F2F2F2"));
        this.him.cKb();
        if (bNn()) {
          this.pDR.addIconOptionMenu(0, b.f.actionbar_icon_dark_search, new b.2(this));
        }
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          this.pDR.setTitleBarDoubleClickListener(new b.3(this));
          label356:
          com.tencent.mm.plugin.topstory.ui.d.c(this.cbF, "uiOnCreate", System.currentTimeMillis());
          return;
          localException = localException;
          y.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", localException, "initData use intent", new Object[0]);
          if (paramBundle != null)
          {
            try
            {
              this.cbF.aH(paramBundle.getByteArray("key_context"));
            }
            catch (IOException paramBundle)
            {
              y.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
            }
            continue;
            y.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Fail");
            this.pDR.finish();
          }
        }
        label440:
        paramBundle = new d();
        paramBundle.b(this.cbF);
        paramBundle.a(this);
      }
      catch (Throwable paramBundle)
      {
        break label356;
      }
    }
  }
  
  protected final void onDestroy()
  {
    try
    {
      if ((this.pDU.getParent() != null) && (this.pDU.getParent().equals(this.oGO)))
      {
        y.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.oGO.removeView(this.pDU);
      }
      label46:
      if (this.pDU != null) {
        this.pDU.onDestroy();
      }
      Object localObject = this.cbF;
      long l = this.pDR.czu();
      if (l > 0L)
      {
        localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((byb)localObject).scene), Long.valueOf(l), Integer.valueOf(((byb)localObject).bvj), Integer.valueOf(((byb)localObject).tOa) });
        y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
        com.tencent.mm.plugin.report.service.h.nFQ.aC(15018, (String)localObject);
      }
      com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiOnDestroy", System.currentTimeMillis());
      ao.BG(18);
      localObject = this.pDT;
      ((com.tencent.mm.plugin.topstory.ui.webview.b)localObject).pIe = null;
      ((com.tencent.mm.plugin.topstory.ui.webview.b)localObject).pIg = null;
      g.Dk().b(1943, (f)localObject);
      this.pEa.dead();
      return;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    byb localbyb = new byb();
    try
    {
      localbyb.aH(paramIntent.getByteArrayExtra("key_context"));
      this.cbF.bIB = localbyb.bIB;
      this.cbF.bVp = localbyb.bVp;
      this.cbF.scene = localbyb.scene;
      this.cbF.lJQ = localbyb.lJQ;
      this.cbF.tOc = aa.boM();
      com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiOnNewIntent", System.currentTimeMillis());
      ao.BG(20);
      this.pDV.PQ("onNewIntent");
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.pDR.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiOnPause", System.currentTimeMillis());
    this.pDV.PQ("onPause");
    if (this.pDU != null) {
      this.pDU.onPause();
    }
  }
  
  protected final void onResume()
  {
    com.tencent.mm.plugin.topstory.a.h.a(this.cbF, "uiOnResume", System.currentTimeMillis());
    this.pDV.PQ("onResume");
    if (this.pDU != null) {
      this.pDU.onResume();
    }
    com.tencent.mm.cl.b.aft("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      paramBundle.putByteArray("key_context", this.cbF.toByteArray());
      y.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.cbF.tNY });
      return;
    }
    catch (IOException paramBundle)
    {
      y.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
    }
  }
  
  public final boolean zv(int paramInt)
  {
    if (paramInt == 4)
    {
      bNm();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */