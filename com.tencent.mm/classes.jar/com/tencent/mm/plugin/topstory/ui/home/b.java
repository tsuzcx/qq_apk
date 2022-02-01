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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.ww;
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
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
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
  List<a> AuK;
  protected MMActivity BJI;
  protected boolean BJJ;
  protected com.tencent.mm.plugin.topstory.ui.webview.c BJK;
  protected TopStoryWebView BJL;
  protected com.tencent.mm.plugin.topstory.ui.webview.e BJM;
  protected View BJN;
  protected View BJO;
  protected List<d.b> BJP;
  View BJQ;
  int BJR;
  long BJS;
  boolean BJT;
  private LinearLayout BJU;
  TopStoryViewPager BJV;
  View BJW;
  int BJX;
  boolean BJY;
  boolean BJZ;
  private boolean BKa;
  private boolean BKb;
  private boolean BKc;
  protected com.tencent.mm.sdk.b.c<ww> BKd;
  protected e.a BKe;
  protected dom dMt;
  boolean dus;
  private n hWv;
  protected ThreeDotsLoadingView mQm;
  int sOZ;
  protected FrameLayout zWD;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.BJP = new ArrayList();
    this.BJR = 0;
    this.BJS = 0L;
    this.BJT = false;
    this.dus = false;
    this.AuK = new ArrayList();
    this.sOZ = -1;
    this.BJX = 0;
    this.BJY = false;
    this.BJZ = true;
    this.BKd = new com.tencent.mm.sdk.b.c() {};
    this.BKe = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.BJM != null) {
          b.this.BJM.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.BJP.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.BJI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.cj(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.dus) {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esa(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.BJM != null)) {
          b.this.BJM.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.BJP.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.BJI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                paramAnonymousString3.cj(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125927);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.dus))
            {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esa(), 107, 2, paramAnonymousString3.BJy, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void aEe(String paramAnonymousString)
      {
        AppMethodBeat.i(125934);
        com.tencent.mm.plugin.topstory.ui.webview.e locale;
        JSONObject localJSONObject;
        if (b.this.BJM != null)
        {
          locale = b.this.BJM;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          ar.f(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(125934);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ae.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramAnonymousString.getMessage());
          }
        }
      }
      
      public final void br(final String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(125931);
        if (b.this.BJM != null) {
          b.this.BJM.bv(paramAnonymousString, paramAnonymousLong);
        }
        Object localObject = b.this.BJP.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (d.b)((Iterator)localObject).next();
          if (((d.b)localObject).category == 110)
          {
            b.this.BJI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                this.BKh.ck(1, paramAnonymousString);
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.dus) && (((d.b)localObject).BJy <= 0)) {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erR(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125931);
      }
      
      public final void bs(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.BJI.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125929);
            b.this.bu(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(125929);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void eso()
      {
        AppMethodBeat.i(125933);
        Iterator localIterator = b.this.BJP.iterator();
        while (localIterator.hasNext())
        {
          final d.b localb = (d.b)localIterator.next();
          if (localb.category == 110)
          {
            b.this.BJI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                localb.ck(0, "");
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
    this.hWv = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          ar.f(new e.12(b.this.BJM));
          AppMethodBeat.o(125936);
          return;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
          AppMethodBeat.o(125936);
        }
      }
    };
    this.BJI = paramMMActivity;
    this.BJJ = paramBoolean;
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
      ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.esw();
      paramTopStoryWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramTopStoryWebView = null;
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.esw();
      }
    }
    AppMethodBeat.o(125977);
    return paramTopStoryWebView;
  }
  
  public final boolean TC(int paramInt)
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
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.c paramc, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.e parame, dom paramdom)
  {
    AppMethodBeat.i(125974);
    this.BJK = paramc;
    this.BJL = paramTopStoryWebView;
    this.BJM = parame;
    this.BJM.BPG = this;
    this.dMt = paramdom;
    paramc = this.BJK;
    paramc.BPG = this;
    com.tencent.mm.kernel.g.ajj().a(2582, paramc.BPL);
    com.tencent.mm.kernel.g.ajj().a(2802, paramc.BMw);
    com.tencent.mm.kernel.g.ajj().a(2906, paramc.BPK);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.zWD.addView(this.BJL, paramc);
    AppMethodBeat.o(125974);
  }
  
  public final void aEk(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.AuK.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.BKw != null)
      {
        locala.BKx = 0;
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.BKc = true;
    this.BJM.aEk(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void aEl(String paramString)
  {
    AppMethodBeat.i(125969);
    ar.f(new e.8(this.BJM, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void aEm(String paramString)
  {
    AppMethodBeat.i(125970);
    ar.f(new e.11(this.BJM, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void aEn(String paramString)
  {
    AppMethodBeat.i(125971);
    ar.f(new e.10(this.BJM, paramString));
    AppMethodBeat.o(125971);
  }
  
  public final void aM(int paramInt, boolean paramBoolean)
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
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.sOZ)
          {
            ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.sOZ = paramInt;
          locala = (a)this.AuK.get(i);
          if (this.BJW.getParent() == ((a)this.AuK.get(i)).BKv) {
            if (locala.BKx <= 0)
            {
              paramInt = 1;
              locala.BKx = 2;
              localb = (d.b)this.BJP.get(this.sOZ);
              this.BJZ = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.BJx > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esg();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.e.h.MqF.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.BJL, locala.BKv.getWidth(), locala.BKv.getHeight());
                  b.this.BJI.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.BKm.BKw.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.BKm.BKw.setVisibility(0);
                        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.BKm.BKv.getWidth()), Integer.valueOf(b.8.this.BKm.BKv.getHeight()), Integer.valueOf(b.8.this.BKm.BKw.getWidth()), Integer.valueOf(b.8.this.BKm.BKw.getHeight()) });
                        if (b.this.BJW.getParent() != null)
                        {
                          ((ViewGroup)b.this.BJW.getParent()).removeView(b.this.BJW);
                          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.BKn);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.AuK.get(b.this.sOZ)).BKv.addView(b.this.BJW, localLayoutParams);
                        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.sOZ);
                        b.this.BJM.m(b.8.this.BKo.BJw, b.8.this.BKo.BJx, b.8.this.BKo.BJy, b.8.this.BKp);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.BKm.BKw.setImageDrawable(b.this.BJI.getResources().getDrawable(2131099648));
                        b.8.this.BKm.BKx = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!bu.isNullOrNil(localb.BJA)) {
                break label479;
              }
              localObject1 = localb.BJz;
              label266:
              am.b(localb.category, this.BJR, (String)localObject1, this.dMt.kid, paramBoolean);
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
        locala.BKw.setVisibility(0);
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.BKw.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.BJW.getParent() != null)
        {
          ((ViewGroup)this.BJW.getParent()).removeView(this.BJW);
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((a)this.AuK.get(this.sOZ)).BKv.addView(this.BJW, (ViewGroup.LayoutParams)localObject2);
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.sOZ);
        this.BJM.m(localb.BJw, localb.BJx, localb.BJy, str1);
        break label248;
        String str2 = localb.BJA;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  final void bu(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.BJQ.setVisibility(0);
    dou localdou = new dou();
    localdou.msgId = paramString;
    localdou.HVF = paramLong;
    am.a(localdou, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final MMActivity dkN()
  {
    return this.BJI;
  }
  
  public final void esL()
  {
    this.BKa = true;
  }
  
  public final void esM()
  {
    AppMethodBeat.i(125967);
    this.BKb = true;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.mQm.fQe();
        b.this.BJN.setVisibility(8);
        b.this.BJL.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void esN()
  {
    AppMethodBeat.i(125973);
    this.BJI.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125923);
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
        b.this.BJO.setVisibility(8);
        b.this.BJT = false;
        if (b.this.BJV != null) {
          b.this.BJV.setScrollEnable(true);
        }
        AppMethodBeat.o(125923);
      }
    });
    AppMethodBeat.o(125973);
  }
  
  public final void esO()
  {
    AppMethodBeat.i(125959);
    if ((this.BJZ) && (this.AuK.size() > 0))
    {
      final int i = this.sOZ;
      this.BJV.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.this.sOZ)
          {
            ((b.a)b.this.AuK.get(b.this.sOZ)).BKw.setVisibility(8);
            ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.sOZ);
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.BJZ = true;
    AppMethodBeat.o(125959);
  }
  
  public final int esP()
  {
    return this.BJX;
  }
  
  public final void esQ()
  {
    AppMethodBeat.i(125957);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.g.ajR().ajA().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", this.dMt.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esk());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.FFD);
        localObject2 = new dom();
        ((dom)localObject2).rfA = com.tencent.mm.plugin.topstory.ui.d.esK();
        ((dom)localObject2).scene = 21;
        ((dom)localObject2).kid = "";
        ((dom)localObject2).dmf = "";
        ((dom)localObject2).sessionId = this.dMt.sessionId;
        ((dom)localObject2).dEb = this.dMt.dEb;
        ((dom)localObject2).HVp = 2;
        ((dom)localObject2).url = com.tencent.mm.plugin.topstory.a.h.m((HashMap)localObject1);
        ((dom)localObject2).GEi = "";
        ((dom)localObject2).cSM = 10802;
        ((dom)localObject2).sBn = com.tencent.mm.plugin.websearch.api.ad.UD();
        ((dom)localObject2).uRo = this.BJI.getContext().getResources().getColor(2131101179);
        Object localObject1 = new aaj();
        ((aaj)localObject1).key = "rec_category";
        ((aaj)localObject1).GrE = this.dMt.cSM;
        ((aaj)localObject1).GrF = String.valueOf(this.dMt.cSM);
        ((dom)localObject2).DTg.add(localObject1);
        com.tencent.mm.plugin.topstory.ui.d.a(ak.getContext(), (dom)localObject2, "", false);
        AppMethodBeat.o(125957);
        return;
        localException = localException;
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  final void esR()
  {
    AppMethodBeat.i(125962);
    if (this.BJM != null)
    {
      this.BJM.euB();
      esN();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean esS()
  {
    return true;
  }
  
  public final void in(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.BJI.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125922);
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        int i = paramInt1;
        int j = paramInt2;
        b.this.BJO.setBackgroundColor(i + 16777216 * j);
        b.this.BJO.setVisibility(0);
        b.this.BJT = true;
        b.this.BJO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(125921);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125921);
          }
        });
        if (b.this.BJV != null) {
          b.this.BJV.setScrollEnable(false);
        }
        AppMethodBeat.o(125922);
      }
    });
    AppMethodBeat.o(125972);
  }
  
  public final void io(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    am.p("", 0, 0, paramInt1);
    String str = com.tencent.mm.plugin.websearch.api.ad.WI(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.dMt.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.BJI.getString(2131764455), "utf8"));
      com.tencent.mm.kernel.g.ajP();
      localHashMap.put("uin", com.tencent.mm.kernel.a.aiF());
      localHashMap.put("timeZone", URLEncoder.encode(bu.fpH(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.FFD);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esk());
      label227:
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.BJI, paramInt1, "", str, localHashMap, this.BJI.getResources().getString(2131764474), this.BJI.getResources().getColor(2131099679));
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
      com.tencent.mm.plugin.topstory.ui.webview.e locale = this.BJM;
      try
      {
        ae.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", new Object[] { paramIntent, str });
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoPlayInfo", str);
        localJSONObject.put("searchId", paramIntent);
        ar.f(new e.5(locale, localJSONObject));
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
    if (this.BJT)
    {
      esR();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.BKb) {
      com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      am.WT(19);
      if (!this.BJJ) {
        break;
      }
      this.BJI.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.BKa)
      {
        if (this.BKc) {
          com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.BJI.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.BJI.getSupportActionBar().hide();
    this.dMt = new dom();
    Object localObject3;
    Object localObject2;
    label811:
    label876:
    int i;
    try
    {
      this.dMt.parseFrom(this.BJI.getIntent().getByteArrayExtra("key_context"));
      if (!bu.isNullOrNil(this.dMt.rfA))
      {
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.dMt.rfA });
        this.BJP = com.tencent.mm.plugin.topstory.ui.d.aEi(this.BJI.getIntent().getStringExtra("key_tabconfig"));
        if (!this.BJP.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.BKe);
        }
        this.BKd.alive();
        com.tencent.mm.kernel.g.ajQ().a(this.hWv);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void aEh(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.webview.e locale;
            JSONObject localJSONObject;
            if (b.this.BJM != null)
            {
              locale = b.this.BJM;
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("params", paramAnonymousString);
              ar.f(new e.13(locale, localJSONObject.toString()));
              AppMethodBeat.o(125919);
              return;
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                ae.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramAnonymousString.getMessage());
              }
            }
          }
        });
        am.WT(17);
        this.BJW = LayoutInflater.from(this.BJI).inflate(2131495789, null);
        this.zWD = ((FrameLayout)this.BJW.findViewById(2131306912));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label811;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().uNN) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.dMt, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.BJN = this.BJW.findViewById(2131305153);
        this.mQm = ((ThreeDotsLoadingView)this.BJW.findViewById(2131301514));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.abu()) && (!al.isDarkMode())) {
          this.BJI.supportLightStatusBar();
        }
        localObject3 = (TextView)this.BJI.findViewById(2131305711);
        localObject2 = this.BJI.findViewById(2131296416);
        View localView = this.BJI.findViewById(2131306021);
        this.BJQ = this.BJI.findViewById(2131301225);
        paramBundle = this.BJI.findViewById(2131306018);
        this.BJO = this.BJI.findViewById(2131306017);
        this.BJV = ((TopStoryViewPager)this.BJI.findViewById(2131306020));
        this.BJU = ((LinearLayout)this.BJI.findViewById(2131306019));
        this.BJV.setScrollEnable(false);
        if (this.BJP.isEmpty()) {
          break label1633;
        }
        localTabLayout = (TabLayout)this.BJI.findViewById(2131305596);
        localObject4 = this.BJP.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label876;
          }
          localb = (d.b)((Iterator)localObject4).next();
          localb.vj = localTabLayout.cU();
          localb.vj.ak(2131495788);
          localb.titleTv = ((TextView)localb.vj.vd.findViewById(2131306157));
          localb.uGB = localb.vj.vd.findViewById(2131305599);
          localb.BJB = ((TextView)localb.vj.vd.findViewById(2131306156));
          localb.BJC = localb.vj.vd.findViewById(2131301224);
          localb.titleTv.setText(localb.dyI);
          if (localb.BJy <= 0) {
            break;
          }
          paramBundle = localb.BJy;
          if (localb.BJy > 99) {
            paramBundle = "99+";
          }
          localb.BJB.setText(paramBundle);
          localb.BJB.setVisibility(0);
          localb.BJC.setVisibility(8);
          localTabLayout.a(localb.vj, false);
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
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.dMt.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.BJI.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.dMt, true);
          paramBundle.b(this);
          continue;
          if (localb.BJx > 0)
          {
            localb.BJB.setText("");
            localb.BJB.setVisibility(4);
            localb.BJC.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new TabLayout.c()
      {
        public final void f(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125944);
          int i = 0;
          while (i < b.this.BJP.size())
          {
            d.b localb = (d.b)b.this.BJP.get(i);
            if (localb.vj.equals(paramAnonymousf))
            {
              ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.dyI);
              localb.titleTv.setTextColor(b.this.BJI.getResources().getColor(2131101046));
              localb.uGB.setBackgroundColor(b.this.BJI.getResources().getColor(2131100711));
              b.this.aM(i, false);
              b.this.BJV.setCurrentItem(i);
              if ((localb.category == 100) && (localb.BJx > 0))
              {
                localb.ck(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esh();
              }
              i = localb.category;
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYX, Integer.valueOf(i));
              b.this.BJR = localb.category;
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
          Iterator localIterator = b.this.BJP.iterator();
          while (localIterator.hasNext())
          {
            d.b localb = (d.b)localIterator.next();
            if (localb.vj.equals(paramAnonymousf))
            {
              b.this.BJX = localb.category;
              ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.dyI);
              localb.titleTv.setTextColor(b.this.BJI.getResources().getColor(2131101047));
              localb.uGB.setBackgroundColor(b.this.BJI.getResources().getColor(2131101053));
              AppMethodBeat.o(125945);
              return;
            }
          }
          AppMethodBeat.o(125945);
        }
        
        public final void h(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125946);
          Object localObject = b.this.BJP.iterator();
          while (((Iterator)localObject).hasNext())
          {
            d.b localb = (d.b)((Iterator)localObject).next();
            if (localb.vj.equals(paramAnonymousf))
            {
              ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.dyI);
              localb.titleTv.setTextColor(b.this.BJI.getResources().getColor(2131101046));
              localb.uGB.setBackgroundColor(b.this.BJI.getResources().getColor(2131100711));
              localObject = "";
              paramAnonymousf = (TabLayout.f)localObject;
              if (localb.category == 100)
              {
                paramAnonymousf = (TabLayout.f)localObject;
                if (localb.BJx > 0) {
                  paramAnonymousf = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esg();
                }
              }
              b.this.BJM.m(localb.BJw, localb.BJx, localb.BJy, paramAnonymousf);
              if ((localb.category == 100) && (localb.BJx > 0))
              {
                localb.ck(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esh();
              }
              if (bu.isNullOrNil(localb.BJA)) {}
              for (paramAnonymousf = localb.BJz;; paramAnonymousf = localb.BJA)
              {
                am.b(localb.category, b.this.BJR, paramAnonymousf, b.this.dMt.kid, false);
                b.this.BJR = localb.category;
                AppMethodBeat.o(125946);
                return;
              }
            }
          }
          AppMethodBeat.o(125946);
        }
      });
      this.BJV.setVisibility(0);
      i = 0;
      while (i < this.BJP.size())
      {
        paramBundle = new a();
        paramBundle.BKu = LayoutInflater.from(this.BJI).inflate(2131495785, null);
        paramBundle.BKw = ((ImageView)paramBundle.BKu.findViewById(2131299755));
        paramBundle.BKv = ((FrameLayout)paramBundle.BKu.findViewById(2131299756));
        this.AuK.add(paramBundle);
        i += 1;
      }
      this.BJV.setAdapter(new android.support.v4.view.q()
      {
        public final void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(125949);
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "destroyItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousObject.hashCode()) });
          paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
          AppMethodBeat.o(125949);
        }
        
        public final int getCount()
        {
          AppMethodBeat.i(125947);
          int i = b.this.BJP.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.a)b.this.AuK.get(paramAnonymousInt)).BKu.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.a)b.this.AuK.get(paramAnonymousInt)).BKu, localLayoutParams);
          paramAnonymousViewGroup = ((b.a)b.this.AuK.get(paramAnonymousInt)).BKu;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.BJV.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.this.BJZ)
            {
              paramAnonymousInt = b.this.sOZ;
              b.this.BJV.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.this.sOZ)
                  {
                    ((b.a)b.this.AuK.get(b.this.sOZ)).BKw.setVisibility(8);
                    ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.sOZ);
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.this.BJZ = true;
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.aM(paramAnonymousInt, true);
          if (!localTabLayout.ad(paramAnonymousInt).isSelected()) {
            localTabLayout.ad(paramAnonymousInt).select();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.BJL.LoO = new MMWebView.e()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.a locala = (b.a)b.this.AuK.get(b.this.sOZ);
          locala.BKx -= 1;
          AppMethodBeat.o(125953);
        }
      };
      i = this.BJI.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.BJP.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (d.b)paramBundle.next();
        if (((d.b)localObject4).category == i) {
          ((d.b)localObject4).vj.select();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.ad(0).select();
      }
      ((TextView)localObject3).setText("");
      paramBundle = com.tencent.mm.sdk.platformtools.ad.fom();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.BJI.findViewById(2131298383).setVisibility(8);
      }
    }
    ((View)localObject2).setOnClickListener(new b.12(this));
    ((ImageView)this.BJI.findViewById(2131296417)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.mQm.fQd();
    if (esS())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esi();
      if (bu.isNullOrNil(paramBundle))
      {
        this.BJQ.setVisibility(8);
        label1264:
        localException.setVisibility(0);
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (b.this.BJY)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125943);
              return;
            }
            b.this.BJY = true;
            b.this.esQ();
            com.tencent.mm.plugin.report.e.ywz.f(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.BJQ.getVisibility() == 0)
            {
              b.this.BJQ.setVisibility(8);
              paramAnonymousView = new dou();
              paramAnonymousView.msgId = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esi();
              paramAnonymousView.HVF = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esj();
              am.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esl();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125943);
          }
        });
        label1281:
        if (this.dMt.uRo != 0)
        {
          paramBundle = this.BJI.findViewById(2131296347);
          i = this.dMt.uRo;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1726;
          }
          i = 1;
          label1342:
          if (i == 0) {
            break label1731;
          }
          paramBundle.setBackgroundColor(this.BJI.getResources().getColor(2131101179));
          this.BJI.setActionbarColor(this.BJI.getResources().getColor(2131101179));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.dMt.scene == 54)
      {
        paramBundle = this.BJI.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.BJI);
          ((d.a)localObject1).a(com.tencent.mm.compatible.e.a.decodeResource(this.BJI.getResources(), 2131690054), false, 3);
          ((d.a)localObject1).zf(false);
          ((d.a)localObject1).zg(false);
          ((d.a)localObject1).aZl(this.BJI.getString(2131757561)).afT(17);
          localObject1 = ((d.a)localObject1).fQv();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.BJI.getString(2131757557, new Object[] { localObject2 }), true, new b.9(this, paramBundle, (String)localObject3));
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.BJI.getString(2131757564), true, new b.10(this));
          ((com.tencent.mm.ui.widget.a.d)localObject1).aaX(this.BJI.getResources().getColor(2131100035));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.e.ywz.f(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.dMt, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1633:
      this.BJV.setVisibility(8);
      this.BJU.addView(this.BJW, -1, -1);
      ((TextView)localObject3).setText(this.dMt.GEi);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.11(this));
      break;
      bu(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esj());
      break label1264;
      ((View)localObject1).setVisibility(8);
      break label1281;
      label1726:
      i = 0;
      break label1342;
      label1731:
      paramBundle.setBackgroundColor(this.dMt.uRo);
      this.BJI.setActionbarColor(this.dMt.uRo);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.BJL.LoO = null;
    try
    {
      if ((this.dMt.cSM == 100) && (this.BJM != null)) {
        com.tencent.mm.plugin.topstory.ui.webview.a.a(this.BJM, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.BJL.getParent() != null) && (this.BJL.getParent().equals(this.zWD)))
      {
        ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.zWD.removeView(this.BJL);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.BJL != null) {
      this.BJL.onDestroy();
    }
    localObject = this.dMt;
    l = this.BJI.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((dom)localObject).scene), Long.valueOf(l), Integer.valueOf(((dom)localObject).cSM), Integer.valueOf(((dom)localObject).HVp) });
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiOnDestroy", System.currentTimeMillis());
    am.WT(18);
    localObject = this.BJK;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BPG = null;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BPI = null;
    com.tencent.mm.kernel.g.ajj().b(1943, (f)localObject);
    com.tencent.mm.kernel.g.ajj().b(2582, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BPL);
    com.tencent.mm.kernel.g.ajj().b(2802, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BMw);
    com.tencent.mm.kernel.g.ajj().b(2906, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BPK);
    this.BKd.dead();
    com.tencent.mm.kernel.g.ajQ().b(this.hWv);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.BKe);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    dom localdom = new dom();
    try
    {
      localdom.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.dMt.sessionId = localdom.sessionId;
      this.dMt.dEb = localdom.dEb;
      this.dMt.scene = localdom.scene;
      this.dMt.dyb = localdom.dyb;
      this.dMt.sBn = com.tencent.mm.plugin.websearch.api.ad.UD();
      com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiOnNewIntent", System.currentTimeMillis());
      am.WT(20);
      this.BJM.aEt("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.BJI.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiOnPause", System.currentTimeMillis());
    this.BJM.aEt("onPause");
    if (this.BJL != null) {
      this.BJL.onPause();
    }
    this.dus = true;
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null)
    {
      int i = this.BJR;
      if (this.BJR == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.esH();
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
    com.tencent.mm.plugin.topstory.a.i.a(this.dMt, "uiOnResume", System.currentTimeMillis());
    this.BJM.aEt("onResume");
    if (this.BJL != null) {
      this.BJL.onResume();
    }
    com.tencent.mm.cp.d.baz("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.BJP.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.BJy > 0)
      {
        if (localb.category == 110) {
          am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esa(), 107, 2, localb.BJy, 0L, "");
        }
      }
      else if (localb.BJx > 0) {
        if (localb.category == 110)
        {
          am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erR(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          dou localdou = new dou();
          localdou.msgId = localb.BJz;
          am.a(localdou, 107, 3, 0, 0L, "");
        }
      }
    }
    this.dus = false;
    this.BJY = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.dMt.toByteArray());
      ae.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.dMt.rfA });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      ae.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
  
  static final class a
  {
    View BKu;
    FrameLayout BKv;
    ImageView BKw;
    int BKx = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */