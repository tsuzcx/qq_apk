package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.c;
import android.support.design.widget.TabLayout.f;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.e.10;
import com.tencent.mm.plugin.topstory.ui.webview.e.11;
import com.tencent.mm.plugin.topstory.ui.webview.e.12;
import com.tencent.mm.plugin.topstory.ui.webview.e.13;
import com.tencent.mm.plugin.topstory.ui.webview.e.2;
import com.tencent.mm.plugin.topstory.ui.webview.e.5;
import com.tencent.mm.plugin.topstory.ui.webview.e.8;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.MMWebView.e;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.widget.a.d.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements a
{
  protected dcn dBe;
  boolean dkt;
  private n haH;
  protected ThreeDotsLoadingView lIL;
  int qNE;
  protected FrameLayout xbN;
  List<a> xzo;
  protected MMActivity yMG;
  protected boolean yMH;
  protected com.tencent.mm.plugin.topstory.ui.webview.c yMI;
  protected TopStoryWebView yMJ;
  protected com.tencent.mm.plugin.topstory.ui.webview.e yMK;
  protected View yML;
  protected View yMM;
  protected List<d.b> yMN;
  View yMO;
  int yMP;
  long yMQ;
  boolean yMR;
  private LinearLayout yMS;
  TopStoryViewPager yMT;
  View yMU;
  int yMV;
  boolean yMW;
  boolean yMX;
  private boolean yMY;
  private boolean yMZ;
  private boolean yNa;
  protected com.tencent.mm.sdk.b.c<vo> yNb;
  protected e.a yNc;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.yMN = new ArrayList();
    this.yMP = 0;
    this.yMQ = 0L;
    this.yMR = false;
    this.dkt = false;
    this.xzo = new ArrayList();
    this.qNE = -1;
    this.yMV = 0;
    this.yMW = false;
    this.yMX = true;
    this.yNb = new com.tencent.mm.sdk.b.c() {};
    this.yNc = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.yMK != null) {
          b.this.yMK.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.yMN.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.yMG.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.bY(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.dkt) {
              ak.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNC(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.yMK != null)) {
          b.this.yMK.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.yMN.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.yMG.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                paramAnonymousString3.bY(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125927);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.dkt))
            {
              ak.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNC(), 107, 2, paramAnonymousString3.yMw, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void asx(String paramAnonymousString)
      {
        AppMethodBeat.i(125934);
        com.tencent.mm.plugin.topstory.ui.webview.e locale;
        JSONObject localJSONObject;
        if (b.this.yMK != null)
        {
          locale = b.this.yMK;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          aq.f(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(125934);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramAnonymousString.getMessage());
          }
        }
      }
      
      public final void bl(final String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(125931);
        if (b.this.yMK != null) {
          b.this.yMK.bp(paramAnonymousString, paramAnonymousLong);
        }
        Object localObject = b.this.yMN.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (d.b)((Iterator)localObject).next();
          if (((d.b)localObject).category == 110)
          {
            b.this.yMG.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                this.yNg.bZ(1, paramAnonymousString);
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.dkt) && (((d.b)localObject).yMw <= 0)) {
              ak.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNt(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125931);
      }
      
      public final void bm(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.yMG.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125929);
            b.this.bo(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(125929);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void dNQ()
      {
        AppMethodBeat.i(125933);
        Iterator localIterator = b.this.yMN.iterator();
        while (localIterator.hasNext())
        {
          final d.b localb = (d.b)localIterator.next();
          if (localb.category == 110)
          {
            b.this.yMG.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                localb.bZ(0, "");
                AppMethodBeat.o(125928);
              }
            });
            AppMethodBeat.o(125933);
            return;
          }
        }
        AppMethodBeat.o(125933);
      }
    };
    this.haH = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          aq.f(new e.12(b.this.yMK));
          AppMethodBeat.o(125936);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
          AppMethodBeat.o(125936);
        }
      }
    };
    this.yMG = paramMMActivity;
    this.yMH = paramBoolean;
    AppMethodBeat.o(125955);
  }
  
  static Bitmap a(TopStoryWebView paramTopStoryWebView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125977);
    try
    {
      long l = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      paramTopStoryWebView.drawCanvas(new Canvas(localBitmap));
      ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.dNY();
      paramTopStoryWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramTopStoryWebView = null;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.dNY();
      }
    }
    AppMethodBeat.o(125977);
    return paramTopStoryWebView;
  }
  
  public final boolean Pf(int paramInt)
  {
    AppMethodBeat.i(125960);
    if (paramInt == 4)
    {
      onBackBtnClick();
      AppMethodBeat.o(125960);
      return true;
    }
    AppMethodBeat.o(125960);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.c paramc, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.e parame, dcn paramdcn)
  {
    AppMethodBeat.i(125974);
    this.yMI = paramc;
    this.yMJ = paramTopStoryWebView;
    this.yMK = parame;
    this.yMK.ySH = this;
    this.dBe = paramdcn;
    paramc = this.yMI;
    paramc.ySH = this;
    com.tencent.mm.kernel.g.aeS().a(2582, paramc.ySM);
    com.tencent.mm.kernel.g.aeS().a(2802, paramc.yPw);
    com.tencent.mm.kernel.g.aeS().a(2906, paramc.ySL);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.xbN.addView(this.yMJ, paramc);
    AppMethodBeat.o(125974);
  }
  
  public final void aB(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      final a locala;
      label136:
      label142:
      final d.b localb;
      try
      {
        AppMethodBeat.i(125978);
        localObject2 = new StringBuilder("changeView, from ");
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = "viewpager";
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.qNE)
          {
            ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.qNE = paramInt;
          locala = (a)this.xzo.get(i);
          if (this.yMU.getParent() == ((a)this.xzo.get(i)).yNv) {
            if (locala.yNx <= 0)
            {
              paramInt = 1;
              locala.yNx = 2;
              localb = (d.b)this.yMN.get(this.qNE);
              this.yMX = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.yMv > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNI();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.e.h.Iye.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.yMJ, locala.yNv.getWidth(), locala.yNv.getHeight());
                  b.this.yMG.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.yNm.yNw.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.yNm.yNw.setVisibility(0);
                        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.yNm.yNv.getWidth()), Integer.valueOf(b.8.this.yNm.yNv.getHeight()), Integer.valueOf(b.8.this.yNm.yNw.getWidth()), Integer.valueOf(b.8.this.yNm.yNw.getHeight()) });
                        if (b.this.yMU.getParent() != null)
                        {
                          ((ViewGroup)b.this.yMU.getParent()).removeView(b.this.yMU);
                          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.yNn);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.xzo.get(b.this.qNE)).yNv.addView(b.this.yMU, localLayoutParams);
                        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.qNE);
                        b.this.yMK.k(b.8.this.yNo.yMu, b.8.this.yNo.yMv, b.8.this.yNo.yMw, b.8.this.yNp);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.yNm.yNw.setImageDrawable(b.this.yMG.getResources().getDrawable(2131099648));
                        b.8.this.yNm.yNx = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!bt.isNullOrNil(localb.yMy)) {
                break label479;
              }
              localObject1 = localb.yMx;
              label266:
              ak.b(localb.category, this.yMP, (String)localObject1, this.dBe.jko, paramBoolean);
              AppMethodBeat.o(125978);
              continue;
              i = 0;
            }
          }
        }
      }
      finally {}
      label346:
      label479:
      do
      {
        break;
        locala.yNw.setVisibility(0);
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.yNw.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.yMU.getParent() != null)
        {
          ((ViewGroup)this.yMU.getParent()).removeView(this.yMU);
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((a)this.xzo.get(this.qNE)).yNv.addView(this.yMU, (ViewGroup.LayoutParams)localObject2);
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.qNE);
        this.yMK.k(localb.yMu, localb.yMv, localb.yMw, str1);
        break label248;
        String str2 = localb.yMy;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.xzo.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.yNw != null)
      {
        locala.yNx = 0;
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.yNa = true;
    this.yMK.asD(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void asE(String paramString)
  {
    AppMethodBeat.i(125969);
    aq.f(new e.8(this.yMK, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void asF(String paramString)
  {
    AppMethodBeat.i(125970);
    aq.f(new e.11(this.yMK, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void asG(String paramString)
  {
    AppMethodBeat.i(125971);
    aq.f(new e.10(this.yMK, paramString));
    AppMethodBeat.o(125971);
  }
  
  final void bo(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.yMO.setVisibility(0);
    dcv localdcv = new dcv();
    localdcv.dvT = paramString;
    localdcv.Eul = paramLong;
    ak.a(localdcv, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final MMActivity cKW()
  {
    return this.yMG;
  }
  
  public final void dOm()
  {
    this.yMY = true;
  }
  
  public final void dOn()
  {
    AppMethodBeat.i(125967);
    this.yMZ = true;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.lIL.ffc();
        b.this.yML.setVisibility(8);
        b.this.yMJ.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void dOo()
  {
    AppMethodBeat.i(125973);
    this.yMG.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125923);
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
        b.this.yMM.setVisibility(8);
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.XM())) {
          b.this.yMG.getWindow().setStatusBarColor(b.this.yMG.getResources().getColor(2131099679));
        }
        b.this.yMR = false;
        if (b.this.yMT != null) {
          b.this.yMT.setScrollEnable(true);
        }
        AppMethodBeat.o(125923);
      }
    });
    AppMethodBeat.o(125973);
  }
  
  public final void dOp()
  {
    AppMethodBeat.i(125959);
    if ((this.yMX) && (this.xzo.size() > 0))
    {
      final int i = this.qNE;
      this.yMT.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.this.qNE)
          {
            ((b.a)b.this.xzo.get(b.this.qNE)).yNw.setVisibility(8);
            ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.qNE);
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.yMX = true;
    AppMethodBeat.o(125959);
  }
  
  public final int dOq()
  {
    return this.yMV;
  }
  
  public final void dOr()
  {
    AppMethodBeat.i(125957);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.g.afB().afk().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", this.dBe.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNM());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.CpG);
        localObject2 = new dcn();
        ((dcn)localObject2).qwV = com.tencent.mm.plugin.topstory.ui.d.dOl();
        ((dcn)localObject2).scene = 21;
        ((dcn)localObject2).jko = "";
        ((dcn)localObject2).dcm = "";
        ((dcn)localObject2).sessionId = this.dBe.sessionId;
        ((dcn)localObject2).dtw = this.dBe.dtw;
        ((dcn)localObject2).EtU = 2;
        ((dcn)localObject2).url = com.tencent.mm.plugin.topstory.a.h.k((HashMap)localObject1);
        ((dcn)localObject2).EtV = "";
        ((dcn)localObject2).cJR = 10802;
        ((dcn)localObject2).qGK = aa.cWN();
        ((dcn)localObject2).svd = this.yMG.getContext().getResources().getColor(2131101179);
        Object localObject1 = new xp();
        ((xp)localObject1).key = "rec_category";
        ((xp)localObject1).CZi = this.dBe.cJR;
        ((xp)localObject1).CZj = String.valueOf(this.dBe.cJR);
        ((dcn)localObject2).AFX.add(localObject1);
        com.tencent.mm.plugin.topstory.ui.d.a(aj.getContext(), (dcn)localObject2, "", false);
        AppMethodBeat.o(125957);
        return;
        localException = localException;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  final void dOs()
  {
    AppMethodBeat.i(125962);
    if (this.yMK != null)
    {
      this.yMK.dQe();
      dOo();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean dOt()
  {
    return true;
  }
  
  public final void hK(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.yMG.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125922);
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        int i = paramInt1 + 16777216 * paramInt2;
        b.this.yMM.setBackgroundColor(i);
        b.this.yMM.setVisibility(0);
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.XM())) {
          b.this.yMG.getWindow().setStatusBarColor(am.o(i, b.this.yMG.getResources().getColor(2131099679)));
        }
        b.this.yMR = true;
        b.this.yMM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(125921);
            b.a(b.this);
            AppMethodBeat.o(125921);
          }
        });
        if (b.this.yMT != null) {
          b.this.yMT.setScrollEnable(false);
        }
        AppMethodBeat.o(125922);
      }
    });
    AppMethodBeat.o(125972);
  }
  
  public final void hL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    ak.p("", 0, 0, paramInt1);
    String str = aa.RY(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.dBe.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.yMG.getString(2131764455), "utf8"));
      com.tencent.mm.kernel.g.afz();
      localHashMap.put("uin", com.tencent.mm.kernel.a.aeo());
      localHashMap.put("timeZone", URLEncoder.encode(bt.eGH(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.CpG);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNM());
      label227:
      ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.yMG, paramInt1, "", str, localHashMap, this.yMG.getResources().getString(2131764474), this.yMG.getResources().getColor(2131099679));
      AppMethodBeat.o(125958);
      return;
    }
    catch (Exception localException)
    {
      break label227;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125979);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("key_video_play_info");
      paramIntent = paramIntent.getStringExtra("key_search_id");
      com.tencent.mm.plugin.topstory.ui.webview.e locale = this.yMK;
      try
      {
        ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", new Object[] { paramIntent, str });
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoPlayInfo", str);
        localJSONObject.put("searchId", paramIntent);
        aq.f(new e.5(locale, localJSONObject));
        AppMethodBeat.o(125979);
        return;
      }
      catch (Exception paramIntent) {}
    }
    AppMethodBeat.o(125979);
  }
  
  protected final void onBackBtnClick()
  {
    AppMethodBeat.i(125961);
    if (this.yMR)
    {
      dOs();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.yMZ) {
      com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      ak.Sk(19);
      if (!this.yMH) {
        break;
      }
      this.yMG.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.yMY)
      {
        if (this.yNa) {
          com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.yMG.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.yMG.getSupportActionBar().hide();
    this.dBe = new dcn();
    Object localObject3;
    Object localObject2;
    label826:
    label891:
    int i;
    try
    {
      this.dBe.parseFrom(this.yMG.getIntent().getByteArrayExtra("key_context"));
      if (!bt.isNullOrNil(this.dBe.qwV))
      {
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.dBe.qwV });
        this.yMN = com.tencent.mm.plugin.topstory.ui.d.asB(this.yMG.getIntent().getStringExtra("key_tabconfig"));
        if (!this.yMN.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.yNc);
        }
        this.yNb.alive();
        com.tencent.mm.kernel.g.afA().a(this.haH);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void asA(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.webview.e locale;
            JSONObject localJSONObject;
            if (b.this.yMK != null)
            {
              locale = b.this.yMK;
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("params", paramAnonymousString);
              aq.f(new e.13(locale, localJSONObject.toString()));
              AppMethodBeat.o(125919);
              return;
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramAnonymousString.getMessage());
              }
            }
          }
        });
        ak.Sk(17);
        this.yMU = LayoutInflater.from(this.yMG).inflate(2131495789, null);
        this.xbN = ((FrameLayout)this.yMU.findViewById(2131306912));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label826;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().srI) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.dBe, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.yML = this.yMU.findViewById(2131305153);
        this.lIL = ((ThreeDotsLoadingView)this.yMU.findViewById(2131301514));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.XM()))
        {
          this.yMG.getWindow().setStatusBarColor(this.yMG.getResources().getColor(2131099679));
          if (!ai.Eq()) {
            this.yMG.supportLightStatusBar();
          }
        }
        localObject3 = (TextView)this.yMG.findViewById(2131305711);
        localObject2 = this.yMG.findViewById(2131296416);
        View localView = this.yMG.findViewById(2131306021);
        this.yMO = this.yMG.findViewById(2131301225);
        paramBundle = this.yMG.findViewById(2131306018);
        this.yMM = this.yMG.findViewById(2131306017);
        this.yMT = ((TopStoryViewPager)this.yMG.findViewById(2131306020));
        this.yMS = ((LinearLayout)this.yMG.findViewById(2131306019));
        if (this.yMN.isEmpty()) {
          break label1648;
        }
        localTabLayout = (TabLayout)this.yMG.findViewById(2131305596);
        localObject4 = this.yMN.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label891;
          }
          localb = (d.b)((Iterator)localObject4).next();
          localb.sr = localTabLayout.cx();
          localb.sr.ak(2131495788);
          localb.titleTv = ((TextView)localb.sr.sk.findViewById(2131306157));
          localb.snU = localb.sr.sk.findViewById(2131305599);
          localb.yMz = ((TextView)localb.sr.sk.findViewById(2131306156));
          localb.yMA = localb.sr.sk.findViewById(2131301224);
          localb.titleTv.setText(localb.doh);
          if (localb.yMw <= 0) {
            break;
          }
          paramBundle = localb.yMw;
          if (localb.yMw > 99) {
            paramBundle = "99+";
          }
          localb.yMz.setText(paramBundle);
          localb.yMz.setVisibility(0);
          localb.yMA.setVisibility(8);
          localTabLayout.a(localb.sr, false);
        }
      }
    }
    catch (Exception localException)
    {
      final TabLayout localTabLayout;
      Object localObject4;
      for (;;)
      {
        d.b localb;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.dBe.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.yMG.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.dBe, true);
          paramBundle.b(this);
          continue;
          if (localb.yMv > 0)
          {
            localb.yMz.setText("");
            localb.yMz.setVisibility(4);
            localb.yMA.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new TabLayout.c()
      {
        public final void f(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125944);
          int i = 0;
          while (i < b.this.yMN.size())
          {
            d.b localb = (d.b)b.this.yMN.get(i);
            if (localb.sr.equals(paramAnonymousf))
            {
              ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.doh);
              localb.titleTv.setTextColor(b.this.yMG.getResources().getColor(2131101046));
              localb.snU.setBackgroundColor(b.this.yMG.getResources().getColor(2131100711));
              b.this.aB(i, false);
              b.this.yMT.setCurrentItem(i);
              if ((localb.category == 100) && (localb.yMv > 0))
              {
                localb.bZ(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNJ();
              }
              i = localb.category;
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtZ, Integer.valueOf(i));
              b.this.yMP = localb.category;
              AppMethodBeat.o(125944);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(125944);
        }
        
        public final void g(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125945);
          Iterator localIterator = b.this.yMN.iterator();
          while (localIterator.hasNext())
          {
            d.b localb = (d.b)localIterator.next();
            if (localb.sr.equals(paramAnonymousf))
            {
              b.this.yMV = localb.category;
              ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.doh);
              localb.titleTv.setTextColor(b.this.yMG.getResources().getColor(2131101047));
              localb.snU.setBackgroundColor(b.this.yMG.getResources().getColor(2131101053));
              AppMethodBeat.o(125945);
              return;
            }
          }
          AppMethodBeat.o(125945);
        }
        
        public final void h(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125946);
          Object localObject = b.this.yMN.iterator();
          while (((Iterator)localObject).hasNext())
          {
            d.b localb = (d.b)((Iterator)localObject).next();
            if (localb.sr.equals(paramAnonymousf))
            {
              ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.doh);
              localb.titleTv.setTextColor(b.this.yMG.getResources().getColor(2131101046));
              localb.snU.setBackgroundColor(b.this.yMG.getResources().getColor(2131100711));
              localObject = "";
              paramAnonymousf = (TabLayout.f)localObject;
              if (localb.category == 100)
              {
                paramAnonymousf = (TabLayout.f)localObject;
                if (localb.yMv > 0) {
                  paramAnonymousf = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNI();
                }
              }
              b.this.yMK.k(localb.yMu, localb.yMv, localb.yMw, paramAnonymousf);
              if ((localb.category == 100) && (localb.yMv > 0))
              {
                localb.bZ(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNJ();
              }
              if (bt.isNullOrNil(localb.yMy)) {}
              for (paramAnonymousf = localb.yMx;; paramAnonymousf = localb.yMy)
              {
                ak.b(localb.category, b.this.yMP, paramAnonymousf, b.this.dBe.jko, false);
                b.this.yMP = localb.category;
                AppMethodBeat.o(125946);
                return;
              }
            }
          }
          AppMethodBeat.o(125946);
        }
      });
      this.yMT.setVisibility(0);
      i = 0;
      while (i < this.yMN.size())
      {
        paramBundle = new a();
        paramBundle.yNu = LayoutInflater.from(this.yMG).inflate(2131495785, null);
        paramBundle.yNw = ((ImageView)paramBundle.yNu.findViewById(2131299755));
        paramBundle.yNv = ((FrameLayout)paramBundle.yNu.findViewById(2131299756));
        this.xzo.add(paramBundle);
        i += 1;
      }
      this.yMT.setAdapter(new android.support.v4.view.q()
      {
        public final void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(125949);
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "destroyItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousObject.hashCode()) });
          paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
          AppMethodBeat.o(125949);
        }
        
        public final int getCount()
        {
          AppMethodBeat.i(125947);
          int i = b.this.yMN.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.a)b.this.xzo.get(paramAnonymousInt)).yNu.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.a)b.this.xzo.get(paramAnonymousInt)).yNu, localLayoutParams);
          paramAnonymousViewGroup = ((b.a)b.this.xzo.get(paramAnonymousInt)).yNu;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.yMT.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.this.yMX)
            {
              paramAnonymousInt = b.this.qNE;
              b.this.yMT.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.this.qNE)
                  {
                    ((b.a)b.this.xzo.get(b.this.qNE)).yNw.setVisibility(8);
                    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.qNE);
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.this.yMX = true;
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.aB(paramAnonymousInt, true);
          if (!localTabLayout.ad(paramAnonymousInt).isSelected()) {
            localTabLayout.ad(paramAnonymousInt).select();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.yMJ.HAM = new MMWebView.e()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.a locala = (b.a)b.this.xzo.get(b.this.qNE);
          locala.yNx -= 1;
          AppMethodBeat.o(125953);
        }
      };
      i = this.yMG.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.yMN.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (d.b)paramBundle.next();
        if (((d.b)localObject4).category == i) {
          ((d.b)localObject4).sr.select();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.ad(0).select();
      }
      ((TextView)localObject3).setText("");
      paramBundle = ac.eFu();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.yMG.findViewById(2131298383).setVisibility(8);
      }
    }
    ((View)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125942);
        b.this.onBackBtnClick();
        AppMethodBeat.o(125942);
      }
    });
    ((ImageView)this.yMG.findViewById(2131296417)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.lIL.ffb();
    if (dOt())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNK();
      if (bt.isNullOrNil(paramBundle))
      {
        this.yMO.setVisibility(8);
        label1279:
        localException.setVisibility(0);
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            if (b.this.yMW)
            {
              AppMethodBeat.o(125943);
              return;
            }
            b.this.yMW = true;
            b.this.dOr();
            com.tencent.mm.plugin.report.e.vIY.f(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.yMO.getVisibility() == 0)
            {
              b.this.yMO.setVisibility(8);
              paramAnonymousView = new dcv();
              paramAnonymousView.dvT = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNK();
              paramAnonymousView.Eul = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNL();
              ak.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNN();
            }
            AppMethodBeat.o(125943);
          }
        });
        label1296:
        if (this.dBe.svd != 0)
        {
          paramBundle = this.yMG.findViewById(2131296347);
          i = this.dBe.svd;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1741;
          }
          i = 1;
          label1357:
          if (i == 0) {
            break label1746;
          }
          paramBundle.setBackgroundColor(this.yMG.getResources().getColor(2131101179));
          this.yMG.setActionbarColor(this.yMG.getResources().getColor(2131101179));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.dBe.scene == 54)
      {
        paramBundle = this.yMG.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.yMG);
          ((d.a)localObject1).a(com.tencent.mm.compatible.e.a.decodeResource(this.yMG.getResources(), 2131690054), false, 3);
          ((d.a)localObject1).wX(false);
          ((d.a)localObject1).wY(false);
          ((d.a)localObject1).aMj(this.yMG.getString(2131757561)).aaA(17);
          localObject1 = ((d.a)localObject1).fft();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.yMG.getString(2131757557, new Object[] { localObject2 }), true, new b.9(this, paramBundle, (String)localObject3));
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.yMG.getString(2131757564), true, new b.10(this));
          ((com.tencent.mm.ui.widget.a.d)localObject1).Wd(this.yMG.getResources().getColor(2131100035));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.e.vIY.f(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.dBe, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1648:
      this.yMT.setVisibility(8);
      this.yMS.addView(this.yMU, -1, -1);
      ((TextView)localObject3).setText(this.dBe.EtV);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.11(this));
      break;
      bo(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNL());
      break label1279;
      ((View)localObject1).setVisibility(8);
      break label1296;
      label1741:
      i = 0;
      break label1357;
      label1746:
      paramBundle.setBackgroundColor(this.dBe.svd);
      this.yMG.setActionbarColor(this.dBe.svd);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.yMJ.HAM = null;
    try
    {
      if ((this.dBe.cJR == 100) && (this.yMK != null)) {
        com.tencent.mm.plugin.topstory.ui.webview.a.a(this.yMK, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.yMJ.getParent() != null) && (this.yMJ.getParent().equals(this.xbN)))
      {
        ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.xbN.removeView(this.yMJ);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.yMJ != null) {
      this.yMJ.onDestroy();
    }
    localObject = this.dBe;
    l = this.yMG.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((dcn)localObject).scene), Long.valueOf(l), Integer.valueOf(((dcn)localObject).cJR), Integer.valueOf(((dcn)localObject).EtU) });
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiOnDestroy", System.currentTimeMillis());
    ak.Sk(18);
    localObject = this.yMI;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).ySH = null;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).ySJ = null;
    com.tencent.mm.kernel.g.aeS().b(1943, (com.tencent.mm.al.g)localObject);
    com.tencent.mm.kernel.g.aeS().b(2582, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).ySM);
    com.tencent.mm.kernel.g.aeS().b(2802, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).yPw);
    com.tencent.mm.kernel.g.aeS().b(2906, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).ySL);
    this.yNb.dead();
    com.tencent.mm.kernel.g.afA().b(this.haH);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.yNc);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    dcn localdcn = new dcn();
    try
    {
      localdcn.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.dBe.sessionId = localdcn.sessionId;
      this.dBe.dtw = localdcn.dtw;
      this.dBe.scene = localdcn.scene;
      this.dBe.dnB = localdcn.dnB;
      this.dBe.qGK = aa.cWN();
      com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiOnNewIntent", System.currentTimeMillis());
      ak.Sk(20);
      this.yMK.asM("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.yMG.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiOnPause", System.currentTimeMillis());
    this.yMK.asM("onPause");
    if (this.yMJ != null) {
      this.yMJ.onPause();
    }
    this.dkt = true;
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null)
    {
      int i = this.yMP;
      if (this.yMP == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.dOi();
      }
      if (i == 100)
      {
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(104, false, false);
        AppMethodBeat.o(125964);
        return;
      }
      if (i == 110) {
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(103, false, false);
      }
    }
    AppMethodBeat.o(125964);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(125963);
    com.tencent.mm.plugin.topstory.a.i.a(this.dBe, "uiOnResume", System.currentTimeMillis());
    this.yMK.asM("onResume");
    if (this.yMJ != null) {
      this.yMJ.onResume();
    }
    com.tencent.mm.cr.d.aNt("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.yMN.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.yMw > 0)
      {
        if (localb.category == 110) {
          ak.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNC(), 107, 2, localb.yMw, 0L, "");
        }
      }
      else if (localb.yMv > 0) {
        if (localb.category == 110)
        {
          ak.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNt(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          dcv localdcv = new dcv();
          localdcv.dvT = localb.yMx;
          ak.a(localdcv, 107, 3, 0, 0L, "");
        }
      }
    }
    this.dkt = false;
    this.yMW = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.dBe.toByteArray());
      ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.dBe.qwV });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
  
  static final class a
  {
    View yNu;
    FrameLayout yNv;
    ImageView yNw;
    int yNx = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */