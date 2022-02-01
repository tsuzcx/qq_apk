package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ze;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.e.10;
import com.tencent.mm.plugin.topstory.ui.c.e.13;
import com.tencent.mm.plugin.topstory.ui.c.e.15;
import com.tencent.mm.plugin.topstory.ui.c.e.16;
import com.tencent.mm.plugin.topstory.ui.c.e.17;
import com.tencent.mm.plugin.topstory.ui.c.e.18;
import com.tencent.mm.plugin.topstory.ui.c.e.2;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.widget.a.d.a;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements a
{
  List<a> KRL;
  protected FrameLayout Kss;
  protected MMActivity MXb;
  protected boolean MXc;
  protected com.tencent.mm.plugin.topstory.ui.c.c MXd;
  protected WebSearchWebView MXe;
  protected com.tencent.mm.plugin.topstory.ui.c.e MXf;
  protected View MXg;
  protected View MXh;
  protected List<d.b> MXi;
  View MXj;
  int MXk;
  boolean MXl;
  private LinearLayout MXm;
  TopStoryViewPager MXn;
  View MXo;
  int MXp;
  boolean MXq;
  boolean MXr;
  private boolean MXs;
  private boolean MXt;
  private boolean MXu;
  protected IListener<ze> MXv;
  protected e.a MXw;
  boolean fEs;
  protected esk fYA;
  private p lHL;
  protected ThreeDotsLoadingView rfc;
  int yeA;
  long zGr;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.MXi = new ArrayList();
    this.MXk = 0;
    this.zGr = 0L;
    this.MXl = false;
    this.fEs = false;
    this.KRL = new ArrayList();
    this.yeA = -1;
    this.MXp = 0;
    this.MXq = false;
    this.MXr = true;
    this.MXv = new IListener() {};
    this.MXw = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.MXf != null) {
          b.this.MXf.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.MXi.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (com.tencent.mm.plugin.topstory.a.h.aju(paramAnonymousString3.MWN))
          {
            b.this.MXb.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.cB(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.fEs) {
              com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.MXf != null)) {
          b.this.MXf.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.MXi.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (com.tencent.mm.plugin.topstory.a.h.aju(paramAnonymousString3.MWN))
          {
            b.this.MXb.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                paramAnonymousString3.cB(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125928);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.fEs))
            {
              com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr(), 107, 2, paramAnonymousString3.MWR, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void b(ess paramAnonymousess, int paramAnonymousInt)
      {
        AppMethodBeat.i(206402);
        final String str = paramAnonymousess.msgId;
        long l = paramAnonymousess.Uuu;
        int i = paramAnonymousess.type;
        if (b.this.MXf != null) {
          b.this.MXf.q(str, l, i);
        }
        paramAnonymousess = b.this.MXi.iterator();
        while (paramAnonymousess.hasNext())
        {
          final d.b localb = (d.b)paramAnonymousess.next();
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onNewRedDotReceived item.category:%s category:%s", new Object[] { Integer.valueOf(localb.MWN), Integer.valueOf(paramAnonymousInt) });
          if ((com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN)) && (paramAnonymousInt == 110))
          {
            b.this.MXb.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                localb.cC(1, str);
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpH();
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.fEs) && (localb.MWR <= 0)) {
              com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj(), 107, 1, 0, 0L, "");
            }
          }
          if ((localb.MWN == 100) && (paramAnonymousInt == 100))
          {
            b.this.MXb.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                localb.cC(1, str);
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpH();
                AppMethodBeat.o(125927);
              }
            });
            if ((!b.this.fEs) && (localb.MWR <= 0)) {
              com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpm(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(206402);
      }
      
      public final void by(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.MXb.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204730);
            b.this.bA(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(204730);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void gpJ()
      {
        AppMethodBeat.i(206404);
        Iterator localIterator = b.this.MXi.iterator();
        while (localIterator.hasNext())
        {
          final d.b localb = (d.b)localIterator.next();
          if (com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN))
          {
            b.this.MXb.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125929);
                localb.cC(0, "");
                AppMethodBeat.o(125929);
              }
            });
            AppMethodBeat.o(206404);
            return;
          }
        }
        AppMethodBeat.o(206404);
      }
      
      public final void gy(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(206405);
        com.tencent.mm.plugin.topstory.ui.c.e locale;
        JSONObject localJSONObject;
        if (b.this.MXf != null)
        {
          locale = b.this.MXf;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          localJSONObject.put("reddotType", paramAnonymousInt);
          MMHandlerThread.postToMainThread(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(206405);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramAnonymousString.getMessage());
          }
        }
      }
    };
    this.lHL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          MMHandlerThread.postToMainThread(new e.17(b.this.MXf));
          AppMethodBeat.o(125936);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
          AppMethodBeat.o(125936);
        }
      }
    };
    this.MXb = paramMMActivity;
    this.MXc = paramBoolean;
    AppMethodBeat.o(125955);
  }
  
  static Bitmap a(WebSearchWebView paramWebSearchWebView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204690);
    try
    {
      long l = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      paramWebSearchWebView.drawCanvas(new Canvas(localBitmap));
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.gpP();
      paramWebSearchWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramWebSearchWebView = null;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.gpP();
      }
    }
    AppMethodBeat.o(204690);
    return paramWebSearchWebView;
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.c.c paramc, WebSearchWebView paramWebSearchWebView, com.tencent.mm.plugin.topstory.ui.c.e parame, esk paramesk)
  {
    AppMethodBeat.i(204683);
    this.MXd = paramc;
    this.MXe = paramWebSearchWebView;
    this.MXf = parame;
    this.MXf.PBs = this;
    this.fYA = paramesk;
    paramc = this.MXd;
    paramc.PBs = this;
    com.tencent.mm.kernel.h.aGY().a(2582, paramc.Ndd);
    com.tencent.mm.kernel.h.aGY().a(2802, paramc.MZP);
    com.tencent.mm.kernel.h.aGY().a(2906, paramc.Ndc);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.Kss.addView(this.MXe, paramc);
    AppMethodBeat.o(204683);
  }
  
  public final boolean ajx(int paramInt)
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
  
  final void bA(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.MXj.setVisibility(0);
    ess localess = new ess();
    localess.msgId = paramString;
    localess.Uuu = paramLong;
    com.tencent.mm.plugin.websearch.api.ar.a(localess, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final void beY(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.KRL.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.MXP != null)
      {
        locala.MXQ = 0;
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.MXu = true;
    this.MXf.beY(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void beZ(String paramString)
  {
    AppMethodBeat.i(125969);
    MMHandlerThread.postToMainThread(new e.13(this.MXf, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void bfa(String paramString)
  {
    AppMethodBeat.i(125970);
    MMHandlerThread.postToMainThread(new e.16(this.MXf, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void bfb(String paramString)
  {
    AppMethodBeat.i(125971);
    MMHandlerThread.postToMainThread(new e.15(this.MXf, paramString));
    AppMethodBeat.o(125971);
  }
  
  public final void bp(int paramInt, boolean paramBoolean)
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
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.yeA)
          {
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.yeA = paramInt;
          locala = (a)this.KRL.get(i);
          if (this.MXo.getParent() == ((a)this.KRL.get(i)).MXO) {
            if (locala.MXQ <= 0)
            {
              paramInt = 1;
              locala.MXQ = 2;
              localb = (d.b)this.MXi.get(this.yeA);
              this.MXr = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.MWN == 100)
              {
                localObject1 = localObject2;
                if (localb.MWQ > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpx();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.e.h.ZvG.d(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.MXe, locala.MXO.getWidth(), locala.MXO.getHeight());
                  b.this.MXb.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.MXF.MXP.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.MXF.MXP.setVisibility(0);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.MXF.MXO.getWidth()), Integer.valueOf(b.8.this.MXF.MXO.getHeight()), Integer.valueOf(b.8.this.MXF.MXP.getWidth()), Integer.valueOf(b.8.this.MXF.MXP.getHeight()) });
                        if (b.this.MXo.getParent() != null)
                        {
                          ((ViewGroup)b.this.MXo.getParent()).removeView(b.this.MXo);
                          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.MXG);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.KRL.get(b.this.yeA)).MXO.addView(b.this.MXo, localLayoutParams);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.yeA);
                        b.this.MXf.o(b.8.this.MXH.MWP, b.8.this.MXH.MWQ, b.8.this.MXH.MWR, b.8.this.MXI);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.MXF.MXP.setImageDrawable(b.this.MXb.getResources().getDrawable(c.a.BG_0));
                        b.8.this.MXF.MXQ = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!Util.isNullOrNil(localb.MWT)) {
                break label479;
              }
              localObject1 = localb.MWS;
              label266:
              com.tencent.mm.plugin.websearch.api.ar.a(localb.MWN, this.MXk, (String)localObject1, this.fYA.jQi, paramBoolean);
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
        locala.MXP.setVisibility(0);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.MXP.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.MXo.getParent() != null)
        {
          ((ViewGroup)this.MXo.getParent()).removeView(this.MXo);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((a)this.KRL.get(this.yeA)).MXO.addView(this.MXo, (ViewGroup.LayoutParams)localObject2);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.yeA);
        this.MXf.o(localb.MWP, localb.MWQ, localb.MWR, str1);
        break label248;
        String str2 = localb.MWT;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  public final MMActivity eOa()
  {
    return this.MXb;
  }
  
  public final WebSearchWebView esG()
  {
    return this.MXe;
  }
  
  public final Context getActivityContext()
  {
    return this.MXb;
  }
  
  public final void gqg()
  {
    this.MXs = true;
  }
  
  public final void gqh()
  {
    AppMethodBeat.i(125967);
    this.MXt = true;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.rfc.hZY();
        b.this.MXg.setVisibility(8);
        b.this.MXe.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void gqi()
  {
    AppMethodBeat.i(125973);
    this.MXb.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125923);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
        b.this.MXh.setVisibility(8);
        b.this.MXl = false;
        AppMethodBeat.o(125923);
      }
    });
    AppMethodBeat.o(125973);
  }
  
  public final void gqj()
  {
    AppMethodBeat.i(125959);
    if ((this.MXr) && (this.KRL.size() > 0))
    {
      final int i = this.yeA;
      this.MXn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.this.yeA)
          {
            ((b.a)b.this.KRL.get(b.this.yeA)).MXP.setVisibility(8);
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.yeA);
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.MXr = true;
    AppMethodBeat.o(125959);
  }
  
  public final int gqk()
  {
    return this.MXp;
  }
  
  final void gql()
  {
    AppMethodBeat.i(125962);
    if (this.MXf != null)
    {
      this.MXf.grX();
      gqi();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean gqm()
  {
    return true;
  }
  
  public final void kA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    com.tencent.mm.plugin.websearch.api.ar.u("", 0, 0, paramInt1);
    String str = ai.ane(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.fYA.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.RAB, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.MXb.getString(c.g.top_story_assistor), "utf8"));
      com.tencent.mm.kernel.h.aHE();
      localHashMap.put("uin", com.tencent.mm.kernel.b.aGq());
      localHashMap.put("timeZone", URLEncoder.encode(Util.getTimeZoneOffset(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.RAy);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpC());
      label227:
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(this.MXb, paramInt1, "", str, localHashMap, this.MXb.getResources().getString(c.g.top_story_home_tab_me), this.MXb.getResources().getColor(c.a.BW_93));
      AppMethodBeat.o(125958);
      return;
    }
    catch (Exception localException)
    {
      break label227;
    }
  }
  
  public final void kz(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.MXb.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125922);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        int i = paramInt1;
        int j = paramInt2;
        b.this.MXh.setBackgroundColor(i + 16777216 * j);
        b.this.MXh.setVisibility(0);
        b.this.MXl = true;
        b.this.MXh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(125921);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125921);
          }
        });
        if (b.this.MXn != null) {
          b.this.MXn.setScrollEnable(false);
        }
        AppMethodBeat.o(125922);
      }
    });
    AppMethodBeat.o(125972);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125979);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("key_video_play_info");
      paramIntent = paramIntent.getStringExtra("key_search_id");
      com.tencent.mm.plugin.topstory.ui.c.e locale = this.MXf;
      try
      {
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", new Object[] { paramIntent, str });
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoPlayInfo", str);
        localJSONObject.put("searchId", paramIntent);
        MMHandlerThread.postToMainThread(new e.10(locale, localJSONObject));
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
    if (this.MXl)
    {
      gql();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.MXt) {
      com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.api.ar.anp(19);
      if (!this.MXc) {
        break;
      }
      this.MXb.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.MXs)
      {
        if (this.MXu) {
          com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.MXb.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.MXb.getSupportActionBar().hide();
    this.fYA = new esk();
    Object localObject3;
    Object localObject2;
    label814:
    label882:
    int i;
    try
    {
      this.fYA.parseFrom(this.MXb.getIntent().getByteArrayExtra("key_context"));
      if (!Util.isNullOrNil(this.fYA.wmL))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.fYA.wmL });
        this.MXi = com.tencent.mm.plugin.topstory.ui.d.beW(this.MXb.getIntent().getStringExtra("key_tabconfig"));
        if (!this.MXi.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.MXw);
        }
        this.MXv.alive();
        com.tencent.mm.kernel.h.aHF().a(this.lHL);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void beV(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.c.e locale;
            JSONObject localJSONObject;
            if (b.this.MXf != null)
            {
              locale = b.this.MXf;
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("params", paramAnonymousString);
              MMHandlerThread.postToMainThread(new e.18(locale, localJSONObject.toString()));
              AppMethodBeat.o(125919);
              return;
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramAnonymousString.getMessage());
              }
            }
          }
        });
        com.tencent.mm.plugin.websearch.api.ar.anp(17);
        this.MXo = LayoutInflater.from(this.MXb).inflate(c.e.top_story_home_webview_container, null);
        this.Kss = ((FrameLayout)this.MXo.findViewById(c.d.webview_container));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label814;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().Dqn) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.fYA, true, "");
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.MXg = this.MXo.findViewById(c.d.splash_view);
        this.rfc = ((ThreeDotsLoadingView)this.MXo.findViewById(c.d.loading_view));
        if ((Build.VERSION.SDK_INT >= 21) && (!MIUI.isMIUIV8()) && (!com.tencent.mm.ui.ar.isDarkMode())) {
          this.MXb.supportLightStatusBar();
        }
        localObject3 = (TextView)this.MXb.findViewById(c.d.text1);
        localObject2 = this.MXb.findViewById(c.d.actionbar_up_indicator);
        View localView = this.MXb.findViewById(c.d.top_story_profile_action_option_icon);
        this.MXj = this.MXb.findViewById(c.d.iv_tab_usr_red);
        paramBundle = this.MXb.findViewById(c.d.top_story_home_actionbar);
        this.MXh = this.MXb.findViewById(c.d.top_story_actionbar_mask);
        this.MXn = ((TopStoryViewPager)this.MXb.findViewById(c.d.top_story_home_viewpager));
        this.MXm = ((LinearLayout)this.MXb.findViewById(c.d.top_story_home_ui_root));
        this.MXn.setScrollEnable(false);
        if (this.MXi.isEmpty()) {
          break label1653;
        }
        localTabLayout = (TabLayout)this.MXb.findViewById(c.d.tabLayout);
        localObject4 = this.MXi.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label882;
          }
          localb = (d.b)((Iterator)localObject4).next();
          localb.bFQ = localTabLayout.xz();
          localb.bFQ.gk(c.e.top_story_home_ui_tabitem);
          localb.titleTv = ((TextView)localb.bFQ.bFK.findViewById(c.d.tv_tab_title));
          localb.Dds = localb.bFQ.bFK.findViewById(c.d.tab_indicator);
          localb.MWU = ((TextView)localb.bFQ.bFK.findViewById(c.d.tv_tab_red));
          localb.MWV = localb.bFQ.bFK.findViewById(c.d.iv_tab_red);
          localb.titleTv.setText(localb.wording);
          if (localb.MWR <= 0) {
            break;
          }
          paramBundle = localb.MWR;
          if (localb.MWR > 99) {
            paramBundle = "99+";
          }
          localb.MWU.setText(paramBundle);
          localb.MWU.setVisibility(0);
          localb.MWV.setVisibility(8);
          localTabLayout.a(localb.bFQ, false);
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
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.fYA.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.MXb.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.fYA, true, "");
          paramBundle.b(this);
          continue;
          if (localb.MWQ > 0)
          {
            localb.MWU.setText("");
            localb.MWU.setVisibility(4);
            localb.MWV.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new com.google.android.material.tabs.a()
      {
        public final void i(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(203522);
          int i = 0;
          while (i < b.this.MXi.size())
          {
            d.b localb = (d.b)b.this.MXi.get(i);
            if (localb.bFQ.equals(paramAnonymouse))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.wording);
              localb.titleTv.setTextColor(b.this.MXb.getResources().getColor(c.a.top_story_home_tab_selected));
              localb.Dds.setBackgroundColor(b.this.MXb.getResources().getColor(c.a.normal_text_color));
              b.this.bp(i, false);
              b.this.MXn.setCurrentItem(i);
              if ((localb.MWN == 100) && (localb.MWQ > 0))
              {
                localb.cC(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpy();
              }
              if ((com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN)) && (localb.MWR <= 0) && (localb.MWQ > 0))
              {
                localb.cC(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpz();
              }
              i = localb.MWN;
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvK, Integer.valueOf(i));
              b.this.MXk = localb.MWN;
              AppMethodBeat.o(203522);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(203522);
        }
        
        public final void j(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(203523);
          Iterator localIterator = b.this.MXi.iterator();
          while (localIterator.hasNext())
          {
            d.b localb = (d.b)localIterator.next();
            if (localb.bFQ.equals(paramAnonymouse))
            {
              b.this.MXp = localb.MWN;
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.wording);
              localb.titleTv.setTextColor(b.this.MXb.getResources().getColor(c.a.top_story_home_tab_unselected));
              localb.Dds.setBackgroundColor(b.this.MXb.getResources().getColor(c.a.transparent));
              AppMethodBeat.o(203523);
              return;
            }
          }
          AppMethodBeat.o(203523);
        }
        
        public final void k(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(203525);
          Object localObject = b.this.MXi.iterator();
          while (((Iterator)localObject).hasNext())
          {
            d.b localb = (d.b)((Iterator)localObject).next();
            if (localb.bFQ.equals(paramAnonymouse))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.wording);
              localb.titleTv.setTextColor(b.this.MXb.getResources().getColor(c.a.top_story_home_tab_selected));
              localb.Dds.setBackgroundColor(b.this.MXb.getResources().getColor(c.a.normal_text_color));
              localObject = "";
              paramAnonymouse = (TabLayout.e)localObject;
              if (localb.MWN == 100)
              {
                paramAnonymouse = (TabLayout.e)localObject;
                if (localb.MWQ > 0) {
                  paramAnonymouse = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpx();
                }
              }
              b.this.MXf.o(localb.MWP, localb.MWQ, localb.MWR, paramAnonymouse);
              if ((localb.MWN == 100) && (localb.MWQ > 0))
              {
                localb.cC(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpy();
              }
              if ((com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN)) && (localb.MWR <= 0) && (localb.MWQ > 0))
              {
                localb.cC(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpz();
              }
              if (Util.isNullOrNil(localb.MWT)) {}
              for (paramAnonymouse = localb.MWS;; paramAnonymouse = localb.MWT)
              {
                com.tencent.mm.plugin.websearch.api.ar.a(localb.MWN, b.this.MXk, paramAnonymouse, b.this.fYA.jQi, false);
                b.this.MXk = localb.MWN;
                AppMethodBeat.o(203525);
                return;
              }
            }
          }
          AppMethodBeat.o(203525);
        }
      });
      this.MXn.setVisibility(0);
      i = 0;
      while (i < this.MXi.size())
      {
        paramBundle = new a();
        paramBundle.MXN = LayoutInflater.from(this.MXb).inflate(c.e.top_story_home_fake_item, null);
        paramBundle.MXP = ((ImageView)paramBundle.MXN.findViewById(c.d.fake_iv));
        paramBundle.MXO = ((FrameLayout)paramBundle.MXN.findViewById(c.d.fake_layout));
        this.KRL.add(paramBundle);
        i += 1;
      }
      this.MXn.setAdapter(new androidx.viewpager.widget.a()
      {
        public final void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(125949);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "destroyItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousObject.hashCode()) });
          paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
          AppMethodBeat.o(125949);
        }
        
        public final int getCount()
        {
          AppMethodBeat.i(125947);
          int i = b.this.MXi.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.a)b.this.KRL.get(paramAnonymousInt)).MXN.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.a)b.this.KRL.get(paramAnonymousInt)).MXN, localLayoutParams);
          paramAnonymousViewGroup = ((b.a)b.this.KRL.get(paramAnonymousInt)).MXN;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.MXn.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.this.MXr)
            {
              paramAnonymousInt = b.this.yeA;
              b.this.MXn.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.this.yeA)
                  {
                    ((b.a)b.this.KRL.get(b.this.yeA)).MXP.setVisibility(8);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.yeA);
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.this.MXr = true;
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.bp(paramAnonymousInt, true);
          if (!localTabLayout.gd(paramAnonymousInt).isSelected()) {
            localTabLayout.gd(paramAnonymousInt).xI();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.MXe.YcA = new MMWebView.f()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.a locala = (b.a)b.this.KRL.get(b.this.yeA);
          locala.MXQ -= 1;
          AppMethodBeat.o(125953);
        }
      };
      i = this.MXb.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.MXi.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (d.b)paramBundle.next();
        if (((d.b)localObject4).MWN == i) {
          ((d.b)localObject4).bFQ.xI();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.gd(0).xI();
      }
      ((TextView)localObject3).setText("");
      paramBundle = LocaleUtil.getApplicationLanguage();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.MXb.findViewById(c.d.cnpadding).setVisibility(8);
      }
    }
    ((View)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.this.onBackBtnClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125942);
      }
    });
    ((ImageView)this.MXb.findViewById(c.d.actionbar_up_indicator_btn)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.rfc.hZX();
    if (gqm())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpA();
      if (Util.isNullOrNil(paramBundle))
      {
        this.MXj.setVisibility(8);
        label1270:
        localException.setVisibility(0);
        localException.setContentDescription(this.MXb.getString(c.g.top_story_profile_icon));
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (b.this.MXq)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125943);
              return;
            }
            b.this.MXq = true;
            com.tencent.mm.plugin.topstory.ui.d.a(b.this.eOa(), b.this.fYA);
            com.tencent.mm.plugin.report.f.Iyx.a(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.MXj.getVisibility() == 0)
            {
              b.this.MXj.setVisibility(8);
              paramAnonymousView = new ess();
              paramAnonymousView.msgId = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpA();
              paramAnonymousView.Uuu = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpB();
              com.tencent.mm.plugin.websearch.api.ar.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpD();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125943);
          }
        });
        label1301:
        if (this.fYA.BkW != 0)
        {
          paramBundle = this.MXb.findViewById(c.d.action_bar_root);
          i = this.fYA.BkW;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1746;
          }
          i = 1;
          label1362:
          if (i == 0) {
            break label1751;
          }
          paramBundle.setBackgroundColor(this.MXb.getResources().getColor(c.a.white));
          this.MXb.setActionbarColor(this.MXb.getResources().getColor(c.a.white));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.fYA.scene == 54)
      {
        paramBundle = this.MXb.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.MXb);
          ((d.a)localObject1).b(com.tencent.mm.compatible.f.a.decodeResource(this.MXb.getResources(), c.f.dialog_successful_icon), false, 3);
          ((d.a)localObject1).HG(false);
          ((d.a)localObject1).HH(false);
          ((d.a)localObject1).bBg(this.MXb.getString(c.g.confirm_dialog_sent)).ayi(17);
          localObject1 = ((d.a)localObject1).icu();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.MXb.getString(c.g.confirm_dialog_back_app, new Object[] { localObject2 }), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125939);
              com.tencent.mm.plugin.report.f.Iyx.a(17080, new Object[] { Integer.valueOf(43), Integer.valueOf(1) });
              paramAnonymousDialogInterface = new WXOpenBusinessView.Resp(paramBundle);
              o.a(paramBundle, paramAnonymousDialogInterface, this.ovr);
              AppMethodBeat.o(125939);
            }
          });
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.MXb.getString(c.g.confirm_dialog_stay_in_weixin), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125940);
              com.tencent.mm.plugin.report.f.Iyx.a(17080, new Object[] { Integer.valueOf(44), Integer.valueOf(1) });
              AppMethodBeat.o(125940);
            }
          });
          ((com.tencent.mm.ui.widget.a.d)localObject1).ase(this.MXb.getResources().getColor(c.a.brand_text_color));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.f.Iyx.a(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1653:
      this.MXn.setVisibility(8);
      this.MXm.addView(this.MXo, -1, -1);
      ((TextView)localObject3).setText(this.fYA.qbv);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          long l = System.currentTimeMillis();
          if (l - b.this.zGr < 300L) {}
          try
          {
            if ((b.this.MXe != null) && (b.this.MXe.getView() != null)) {
              b.this.MXe.getView().scrollTo(b.this.MXe.getView().getScrollX(), 0);
            }
            label107:
            b.this.zGr = l;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125941);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            break label107;
          }
        }
      });
      break;
      bA(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpB());
      break label1270;
      ((View)localObject1).setVisibility(8);
      break label1301;
      label1746:
      i = 0;
      break label1362;
      label1751:
      paramBundle.setBackgroundColor(this.fYA.BkW);
      this.MXb.setActionbarColor(this.fYA.BkW);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.MXe.YcA = null;
    try
    {
      if ((this.fYA.channelId == 100) && (this.MXf != null)) {
        com.tencent.mm.plugin.topstory.ui.c.a.a(this.MXf, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.MXe.getParent() != null) && (this.MXe.getParent().equals(this.Kss)))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.Kss.removeView(this.MXe);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.MXe != null) {
      this.MXe.onDestroy();
    }
    localObject = this.fYA;
    l = this.MXb.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((esk)localObject).scene), Long.valueOf(l), Integer.valueOf(((esk)localObject).channelId), Integer.valueOf(((esk)localObject).Uuf) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiOnDestroy", System.currentTimeMillis());
    com.tencent.mm.plugin.websearch.api.ar.anp(18);
    localObject = this.MXd;
    ((com.tencent.mm.plugin.websearch.webview.a)localObject).PBs = null;
    ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).Nda = null;
    com.tencent.mm.kernel.h.aGY().b(1943, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.kernel.h.aGY().b(2582, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).Ndd);
    com.tencent.mm.kernel.h.aGY().b(2802, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).MZP);
    com.tencent.mm.kernel.h.aGY().b(2906, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).Ndc);
    this.MXv.dead();
    com.tencent.mm.kernel.h.aHF().b(this.lHL);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.MXw);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    esk localesk = new esk();
    try
    {
      localesk.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.fYA.sessionId = localesk.sessionId;
      this.fYA.fPs = localesk.fPs;
      this.fYA.scene = localesk.scene;
      this.fYA.fIY = localesk.fIY;
      this.fYA.ARR = ai.anV();
      com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiOnNewIntent", System.currentTimeMillis());
      com.tencent.mm.plugin.websearch.api.ar.anp(20);
      this.MXf.bfh("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.MXb.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiOnPause", System.currentTimeMillis());
    this.MXf.bfh("onPause");
    if (this.MXe != null) {
      this.MXe.onPause();
    }
    this.fEs = true;
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class) != null)
    {
      int i = this.MXk;
      if (this.MXk == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.gqc();
      }
      if (i == 100)
      {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class)).f(104, false, false);
        AppMethodBeat.o(125964);
        return;
      }
      if (com.tencent.mm.plugin.topstory.a.h.aju(i)) {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class)).f(103, false, false);
      }
    }
    AppMethodBeat.o(125964);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(125963);
    com.tencent.mm.plugin.topstory.a.i.a(this.fYA, "uiOnResume", System.currentTimeMillis());
    this.MXf.bfh("onResume");
    if (this.MXe != null) {
      this.MXe.onResume();
    }
    com.tencent.mm.xwebutil.c.bCF("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.MXi.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.MWR > 0)
      {
        if (com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN)) {
          com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr(), 107, 2, localb.MWR, 0L, "");
        }
      }
      else if (localb.MWQ > 0) {
        if (com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN))
        {
          com.tencent.mm.plugin.websearch.api.ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj(), 107, 1, 0, 0L, "");
        }
        else if (localb.MWN == 100)
        {
          ess localess = new ess();
          localess.msgId = localb.MWS;
          com.tencent.mm.plugin.websearch.api.ar.a(localess, 107, 3, 0, 0L, "");
        }
      }
    }
    this.fEs = false;
    this.MXq = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.fYA.toByteArray());
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.fYA.wmL });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
  
  static final class a
  {
    View MXN;
    FrameLayout MXO;
    ImageView MXP;
    int MXQ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */