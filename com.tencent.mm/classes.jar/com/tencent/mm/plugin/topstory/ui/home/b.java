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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ws;
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
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
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
  List<b.a> Ady;
  boolean BsA;
  private boolean BsB;
  private boolean BsC;
  private boolean BsD;
  protected com.tencent.mm.sdk.b.c<ws> BsE;
  protected e.a BsF;
  protected MMActivity Bsj;
  protected boolean Bsk;
  protected com.tencent.mm.plugin.topstory.ui.webview.c Bsl;
  protected TopStoryWebView Bsm;
  protected com.tencent.mm.plugin.topstory.ui.webview.e Bsn;
  protected View Bso;
  protected View Bsp;
  protected List<d.b> Bsq;
  View Bsr;
  int Bss;
  long Bst;
  boolean Bsu;
  private LinearLayout Bsv;
  TopStoryViewPager Bsw;
  View Bsx;
  int Bsy;
  boolean Bsz;
  protected dnp dLe;
  boolean dtm;
  private n hTD;
  protected ThreeDotsLoadingView mLk;
  int sEa;
  protected FrameLayout zFx;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.Bsq = new ArrayList();
    this.Bss = 0;
    this.Bst = 0L;
    this.Bsu = false;
    this.dtm = false;
    this.Ady = new ArrayList();
    this.sEa = -1;
    this.Bsy = 0;
    this.Bsz = false;
    this.BsA = true;
    this.BsE = new com.tencent.mm.sdk.b.c() {};
    this.BsF = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.Bsn != null) {
          b.this.Bsn.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.Bsq.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Bsj.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.cj(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.dtm) {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.Bsn != null)) {
          b.this.Bsn.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.Bsq.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Bsj.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                paramAnonymousString3.cj(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125927);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.dtm))
            {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot(), 107, 2, paramAnonymousString3.BrZ, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void aCL(String paramAnonymousString)
      {
        AppMethodBeat.i(125934);
        com.tencent.mm.plugin.topstory.ui.webview.e locale;
        JSONObject localJSONObject;
        if (b.this.Bsn != null)
        {
          locale = b.this.Bsn;
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
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramAnonymousString.getMessage());
          }
        }
      }
      
      public final void bq(final String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(125931);
        if (b.this.Bsn != null) {
          b.this.Bsn.bu(paramAnonymousString, paramAnonymousLong);
        }
        Object localObject = b.this.Bsq.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (d.b)((Iterator)localObject).next();
          if (((d.b)localObject).category == 110)
          {
            b.this.Bsj.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                this.BsJ.ck(1, paramAnonymousString);
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.dtm) && (((d.b)localObject).BrZ <= 0)) {
              am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125931);
      }
      
      public final void br(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.Bsj.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125929);
            b.this.bt(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(125929);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void eoH()
      {
        AppMethodBeat.i(125933);
        Iterator localIterator = b.this.Bsq.iterator();
        while (localIterator.hasNext())
        {
          final d.b localb = (d.b)localIterator.next();
          if (localb.category == 110)
          {
            b.this.Bsj.runOnUiThread(new Runnable()
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
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          aq.f(new e.12(b.this.Bsn));
          AppMethodBeat.o(125936);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
          AppMethodBeat.o(125936);
        }
      }
    };
    this.Bsj = paramMMActivity;
    this.Bsk = paramBoolean;
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.eoP();
      paramTopStoryWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramTopStoryWebView = null;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.eoP();
      }
    }
    AppMethodBeat.o(125977);
    return paramTopStoryWebView;
  }
  
  public final boolean SV(int paramInt)
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
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.c paramc, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.e parame, dnp paramdnp)
  {
    AppMethodBeat.i(125974);
    this.Bsl = paramc;
    this.Bsm = paramTopStoryWebView;
    this.Bsn = parame;
    this.Bsn.Byi = this;
    this.dLe = paramdnp;
    paramc = this.Bsl;
    paramc.Byi = this;
    com.tencent.mm.kernel.g.aiU().a(2582, paramc.Byn);
    com.tencent.mm.kernel.g.aiU().a(2802, paramc.BuY);
    com.tencent.mm.kernel.g.aiU().a(2906, paramc.Bym);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.zFx.addView(this.Bsm, paramc);
    AppMethodBeat.o(125974);
  }
  
  public final void aCR(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.Ady.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.BsY != null)
      {
        locala.BsZ = 0;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.BsD = true;
    this.Bsn.aCR(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void aCS(String paramString)
  {
    AppMethodBeat.i(125969);
    aq.f(new e.8(this.Bsn, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void aCT(String paramString)
  {
    AppMethodBeat.i(125970);
    aq.f(new e.11(this.Bsn, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void aCU(String paramString)
  {
    AppMethodBeat.i(125971);
    aq.f(new e.10(this.Bsn, paramString));
    AppMethodBeat.o(125971);
  }
  
  public final void aJ(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      final b.a locala;
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.sEa)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.sEa = paramInt;
          locala = (b.a)this.Ady.get(i);
          if (this.Bsx.getParent() == ((b.a)this.Ady.get(i)).BsX) {
            if (locala.BsZ <= 0)
            {
              paramInt = 1;
              locala.BsZ = 2;
              localb = (d.b)this.Bsq.get(this.sEa);
              this.BsA = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.BrY > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoz();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.e.h.LTJ.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.Bsm, locala.BsX.getWidth(), locala.BsX.getHeight());
                  b.this.Bsj.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.BsO.BsY.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.BsO.BsY.setVisibility(0);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.BsO.BsX.getWidth()), Integer.valueOf(b.8.this.BsO.BsX.getHeight()), Integer.valueOf(b.8.this.BsO.BsY.getWidth()), Integer.valueOf(b.8.this.BsO.BsY.getHeight()) });
                        if (b.this.Bsx.getParent() != null)
                        {
                          ((ViewGroup)b.this.Bsx.getParent()).removeView(b.this.Bsx);
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.BsP);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.Ady.get(b.this.sEa)).BsX.addView(b.this.Bsx, localLayoutParams);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.sEa);
                        b.this.Bsn.m(b.8.this.BsQ.BrX, b.8.this.BsQ.BrY, b.8.this.BsQ.BrZ, b.8.this.BsR);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.BsO.BsY.setImageDrawable(b.this.Bsj.getResources().getDrawable(2131099648));
                        b.8.this.BsO.BsZ = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!bt.isNullOrNil(localb.Bsb)) {
                break label479;
              }
              localObject1 = localb.Bsa;
              label266:
              am.b(localb.category, this.Bss, (String)localObject1, this.dLe.keN, paramBoolean);
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
        locala.BsY.setVisibility(0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.BsY.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.Bsx.getParent() != null)
        {
          ((ViewGroup)this.Bsx.getParent()).removeView(this.Bsx);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((b.a)this.Ady.get(this.sEa)).BsX.addView(this.Bsx, (ViewGroup.LayoutParams)localObject2);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.sEa);
        this.Bsn.m(localb.BrX, localb.BrY, localb.BrZ, str1);
        break label248;
        String str2 = localb.Bsb;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  final void bt(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.Bsr.setVisibility(0);
    dnx localdnx = new dnx();
    localdnx.msgId = paramString;
    localdnx.HBS = paramLong;
    am.a(localdnx, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final MMActivity dhO()
  {
    return this.Bsj;
  }
  
  public final void epe()
  {
    this.BsB = true;
  }
  
  public final void epf()
  {
    AppMethodBeat.i(125967);
    this.BsC = true;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.mLk.fLK();
        b.this.Bso.setVisibility(8);
        b.this.Bsm.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void epg()
  {
    AppMethodBeat.i(125973);
    this.Bsj.runOnUiThread(new b.4(this));
    AppMethodBeat.o(125973);
  }
  
  public final void eph()
  {
    AppMethodBeat.i(125959);
    if ((this.BsA) && (this.Ady.size() > 0))
    {
      int i = this.sEa;
      this.Bsw.postDelayed(new b.18(this, i), 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.BsA = true;
    AppMethodBeat.o(125959);
  }
  
  public final int epi()
  {
    return this.Bsy;
  }
  
  public final void epj()
  {
    AppMethodBeat.i(125957);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.g.ajC().ajl().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", this.dLe.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoD());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.Fnf);
        localObject2 = new dnp();
        ((dnp)localObject2).qXu = com.tencent.mm.plugin.topstory.ui.d.epd();
        ((dnp)localObject2).scene = 21;
        ((dnp)localObject2).keN = "";
        ((dnp)localObject2).dld = "";
        ((dnp)localObject2).sessionId = this.dLe.sessionId;
        ((dnp)localObject2).dCW = this.dLe.dCW;
        ((dnp)localObject2).HBC = 2;
        ((dnp)localObject2).url = com.tencent.mm.plugin.topstory.a.h.l((HashMap)localObject1);
        ((dnp)localObject2).Glg = "";
        ((dnp)localObject2).cSc = 10802;
        ((dnp)localObject2).srd = com.tencent.mm.plugin.websearch.api.ad.Ux();
        ((dnp)localObject2).uFB = this.Bsj.getContext().getResources().getColor(2131101179);
        Object localObject1 = new aag();
        ((aag)localObject1).key = "rec_category";
        ((aag)localObject1).FZe = this.dLe.cSc;
        ((aag)localObject1).FZf = String.valueOf(this.dLe.cSc);
        ((dnp)localObject2).DBj.add(localObject1);
        com.tencent.mm.plugin.topstory.ui.d.a(aj.getContext(), (dnp)localObject2, "", false);
        AppMethodBeat.o(125957);
        return;
        localException = localException;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  final void epk()
  {
    AppMethodBeat.i(125962);
    if (this.Bsn != null)
    {
      this.Bsn.eqU();
      epg();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean epl()
  {
    return true;
  }
  
  public final void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.Bsj.runOnUiThread(new b.3(this, paramInt1, paramInt2));
    AppMethodBeat.o(125972);
  }
  
  public final void il(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    am.p("", 0, 0, paramInt1);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wb(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.dLe.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.Bsj.getString(2131764455), "utf8"));
      com.tencent.mm.kernel.g.ajA();
      localHashMap.put("uin", com.tencent.mm.kernel.a.aiq());
      localHashMap.put("timeZone", URLEncoder.encode(bt.flM(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.Fnf);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoD());
      label227:
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.Bsj, paramInt1, "", str, localHashMap, this.Bsj.getResources().getString(2131764474), this.Bsj.getResources().getColor(2131099679));
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
      com.tencent.mm.plugin.topstory.ui.webview.e locale = this.Bsn;
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", new Object[] { paramIntent, str });
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
    if (this.Bsu)
    {
      epk();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.BsC) {
      com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      am.Wm(19);
      if (!this.Bsk) {
        break;
      }
      this.Bsj.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.BsB)
      {
        if (this.BsD) {
          com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.Bsj.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.Bsj.getSupportActionBar().hide();
    this.dLe = new dnp();
    Object localObject3;
    Object localObject2;
    label811:
    label876:
    int i;
    try
    {
      this.dLe.parseFrom(this.Bsj.getIntent().getByteArrayExtra("key_context"));
      if (!bt.isNullOrNil(this.dLe.qXu))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.dLe.qXu });
        this.Bsq = com.tencent.mm.plugin.topstory.ui.d.aCP(this.Bsj.getIntent().getStringExtra("key_tabconfig"));
        if (!this.Bsq.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.BsF);
        }
        this.BsE.alive();
        com.tencent.mm.kernel.g.ajB().a(this.hTD);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void aCO(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.webview.e locale;
            JSONObject localJSONObject;
            if (b.this.Bsn != null)
            {
              locale = b.this.Bsn;
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
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramAnonymousString.getMessage());
              }
            }
          }
        });
        am.Wm(17);
        this.Bsx = LayoutInflater.from(this.Bsj).inflate(2131495789, null);
        this.zFx = ((FrameLayout)this.Bsx.findViewById(2131306912));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label811;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().uCi) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.dLe, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.Bso = this.Bsx.findViewById(2131305153);
        this.mLk = ((ThreeDotsLoadingView)this.Bsx.findViewById(2131301514));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.abl()) && (!al.isDarkMode())) {
          this.Bsj.supportLightStatusBar();
        }
        localObject3 = (TextView)this.Bsj.findViewById(2131305711);
        localObject2 = this.Bsj.findViewById(2131296416);
        View localView = this.Bsj.findViewById(2131306021);
        this.Bsr = this.Bsj.findViewById(2131301225);
        paramBundle = this.Bsj.findViewById(2131306018);
        this.Bsp = this.Bsj.findViewById(2131306017);
        this.Bsw = ((TopStoryViewPager)this.Bsj.findViewById(2131306020));
        this.Bsv = ((LinearLayout)this.Bsj.findViewById(2131306019));
        this.Bsw.setScrollEnable(false);
        if (this.Bsq.isEmpty()) {
          break label1633;
        }
        localTabLayout = (TabLayout)this.Bsj.findViewById(2131305596);
        localObject4 = this.Bsq.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label876;
          }
          localb = (d.b)((Iterator)localObject4).next();
          localb.vj = localTabLayout.cU();
          localb.vj.ak(2131495788);
          localb.titleTv = ((TextView)localb.vj.vd.findViewById(2131306157));
          localb.uvc = localb.vj.vd.findViewById(2131305599);
          localb.Bsc = ((TextView)localb.vj.vd.findViewById(2131306156));
          localb.Bsd = localb.vj.vd.findViewById(2131301224);
          localb.titleTv.setText(localb.dxD);
          if (localb.BrZ <= 0) {
            break;
          }
          paramBundle = localb.BrZ;
          if (localb.BrZ > 99) {
            paramBundle = "99+";
          }
          localb.Bsc.setText(paramBundle);
          localb.Bsc.setVisibility(0);
          localb.Bsd.setVisibility(8);
          localTabLayout.a(localb.vj, false);
        }
      }
    }
    catch (Exception localException)
    {
      TabLayout localTabLayout;
      Object localObject4;
      for (;;)
      {
        d.b localb;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.dLe.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.Bsj.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.dLe, true);
          paramBundle.b(this);
          continue;
          if (localb.BrY > 0)
          {
            localb.Bsc.setText("");
            localb.Bsc.setVisibility(4);
            localb.Bsd.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new TabLayout.c()
      {
        public final void f(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125944);
          int i = 0;
          while (i < b.this.Bsq.size())
          {
            d.b localb = (d.b)b.this.Bsq.get(i);
            if (localb.vj.equals(paramAnonymousf))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.dxD);
              localb.titleTv.setTextColor(b.this.Bsj.getResources().getColor(2131101046));
              localb.uvc.setBackgroundColor(b.this.Bsj.getResources().getColor(2131100711));
              b.this.aJ(i, false);
              b.this.Bsw.setCurrentItem(i);
              if ((localb.category == 100) && (localb.BrY > 0))
              {
                localb.ck(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoA();
              }
              i = localb.category;
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEx, Integer.valueOf(i));
              b.this.Bss = localb.category;
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
          Iterator localIterator = b.this.Bsq.iterator();
          while (localIterator.hasNext())
          {
            d.b localb = (d.b)localIterator.next();
            if (localb.vj.equals(paramAnonymousf))
            {
              b.this.Bsy = localb.category;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.dxD);
              localb.titleTv.setTextColor(b.this.Bsj.getResources().getColor(2131101047));
              localb.uvc.setBackgroundColor(b.this.Bsj.getResources().getColor(2131101053));
              AppMethodBeat.o(125945);
              return;
            }
          }
          AppMethodBeat.o(125945);
        }
        
        public final void h(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125946);
          Object localObject = b.this.Bsq.iterator();
          while (((Iterator)localObject).hasNext())
          {
            d.b localb = (d.b)((Iterator)localObject).next();
            if (localb.vj.equals(paramAnonymousf))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.dxD);
              localb.titleTv.setTextColor(b.this.Bsj.getResources().getColor(2131101046));
              localb.uvc.setBackgroundColor(b.this.Bsj.getResources().getColor(2131100711));
              localObject = "";
              paramAnonymousf = (TabLayout.f)localObject;
              if (localb.category == 100)
              {
                paramAnonymousf = (TabLayout.f)localObject;
                if (localb.BrY > 0) {
                  paramAnonymousf = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoz();
                }
              }
              b.this.Bsn.m(localb.BrX, localb.BrY, localb.BrZ, paramAnonymousf);
              if ((localb.category == 100) && (localb.BrY > 0))
              {
                localb.ck(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoA();
              }
              if (bt.isNullOrNil(localb.Bsb)) {}
              for (paramAnonymousf = localb.Bsa;; paramAnonymousf = localb.Bsb)
              {
                am.b(localb.category, b.this.Bss, paramAnonymousf, b.this.dLe.keN, false);
                b.this.Bss = localb.category;
                AppMethodBeat.o(125946);
                return;
              }
            }
          }
          AppMethodBeat.o(125946);
        }
      });
      this.Bsw.setVisibility(0);
      i = 0;
      while (i < this.Bsq.size())
      {
        paramBundle = new b.a();
        paramBundle.BsW = LayoutInflater.from(this.Bsj).inflate(2131495785, null);
        paramBundle.BsY = ((ImageView)paramBundle.BsW.findViewById(2131299755));
        paramBundle.BsX = ((FrameLayout)paramBundle.BsW.findViewById(2131299756));
        this.Ady.add(paramBundle);
        i += 1;
      }
      this.Bsw.setAdapter(new b.15(this));
      this.Bsw.addOnPageChangeListener(new b.16(this, localTabLayout));
      this.Bsm.KSq = new b.17(this);
      i = this.Bsj.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.Bsq.iterator();
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
      paramBundle = ac.fks();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.Bsj.findViewById(2131298383).setVisibility(8);
      }
    }
    ((View)localObject2).setOnClickListener(new b.12(this));
    ((ImageView)this.Bsj.findViewById(2131296417)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.mLk.fLJ();
    if (epl())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoB();
      if (bt.isNullOrNil(paramBundle))
      {
        this.Bsr.setVisibility(8);
        label1264:
        localException.setVisibility(0);
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (b.this.Bsz)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125943);
              return;
            }
            b.this.Bsz = true;
            b.this.epj();
            com.tencent.mm.plugin.report.e.ygI.f(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.Bsr.getVisibility() == 0)
            {
              b.this.Bsr.setVisibility(8);
              paramAnonymousView = new dnx();
              paramAnonymousView.msgId = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoB();
              paramAnonymousView.HBS = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoC();
              am.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoE();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125943);
          }
        });
        label1281:
        if (this.dLe.uFB != 0)
        {
          paramBundle = this.Bsj.findViewById(2131296347);
          i = this.dLe.uFB;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1726;
          }
          i = 1;
          label1342:
          if (i == 0) {
            break label1731;
          }
          paramBundle.setBackgroundColor(this.Bsj.getResources().getColor(2131101179));
          this.Bsj.setActionbarColor(this.Bsj.getResources().getColor(2131101179));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.dLe.scene == 54)
      {
        paramBundle = this.Bsj.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.Bsj);
          ((d.a)localObject1).a(com.tencent.mm.compatible.e.a.decodeResource(this.Bsj.getResources(), 2131690054), false, 3);
          ((d.a)localObject1).yR(false);
          ((d.a)localObject1).yS(false);
          ((d.a)localObject1).aXJ(this.Bsj.getString(2131757561)).afk(17);
          localObject1 = ((d.a)localObject1).fMb();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.Bsj.getString(2131757557, new Object[] { localObject2 }), true, new b.9(this, paramBundle, (String)localObject3));
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.Bsj.getString(2131757564), true, new b.10(this));
          ((com.tencent.mm.ui.widget.a.d)localObject1).aar(this.Bsj.getResources().getColor(2131100035));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.e.ygI.f(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1633:
      this.Bsw.setVisibility(8);
      this.Bsv.addView(this.Bsx, -1, -1);
      ((TextView)localObject3).setText(this.dLe.Glg);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.11(this));
      break;
      bt(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoC());
      break label1264;
      ((View)localObject1).setVisibility(8);
      break label1281;
      label1726:
      i = 0;
      break label1342;
      label1731:
      paramBundle.setBackgroundColor(this.dLe.uFB);
      this.Bsj.setActionbarColor(this.dLe.uFB);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.Bsm.KSq = null;
    try
    {
      if ((this.dLe.cSc == 100) && (this.Bsn != null)) {
        com.tencent.mm.plugin.topstory.ui.webview.a.a(this.Bsn, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.Bsm.getParent() != null) && (this.Bsm.getParent().equals(this.zFx)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.zFx.removeView(this.Bsm);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.Bsm != null) {
      this.Bsm.onDestroy();
    }
    localObject = this.dLe;
    l = this.Bsj.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((dnp)localObject).scene), Long.valueOf(l), Integer.valueOf(((dnp)localObject).cSc), Integer.valueOf(((dnp)localObject).HBC) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiOnDestroy", System.currentTimeMillis());
    am.Wm(18);
    localObject = this.Bsl;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Byi = null;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Byk = null;
    com.tencent.mm.kernel.g.aiU().b(1943, (f)localObject);
    com.tencent.mm.kernel.g.aiU().b(2582, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Byn);
    com.tencent.mm.kernel.g.aiU().b(2802, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).BuY);
    com.tencent.mm.kernel.g.aiU().b(2906, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Bym);
    this.BsE.dead();
    com.tencent.mm.kernel.g.ajB().b(this.hTD);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.BsF);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    dnp localdnp = new dnp();
    try
    {
      localdnp.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.dLe.sessionId = localdnp.sessionId;
      this.dLe.dCW = localdnp.dCW;
      this.dLe.scene = localdnp.scene;
      this.dLe.dwW = localdnp.dwW;
      this.dLe.srd = com.tencent.mm.plugin.websearch.api.ad.Ux();
      com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiOnNewIntent", System.currentTimeMillis());
      am.Wm(20);
      this.Bsn.aDa("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.Bsj.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiOnPause", System.currentTimeMillis());
    this.Bsn.aDa("onPause");
    if (this.Bsm != null) {
      this.Bsm.onPause();
    }
    this.dtm = true;
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null)
    {
      int i = this.Bss;
      if (this.Bss == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.epa();
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
    com.tencent.mm.plugin.topstory.a.i.a(this.dLe, "uiOnResume", System.currentTimeMillis());
    this.Bsn.aDa("onResume");
    if (this.Bsm != null) {
      this.Bsm.onResume();
    }
    com.tencent.mm.cq.d.aYW("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.Bsq.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.BrZ > 0)
      {
        if (localb.category == 110) {
          am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot(), 107, 2, localb.BrZ, 0L, "");
        }
      }
      else if (localb.BrY > 0) {
        if (localb.category == 110)
        {
          am.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          dnx localdnx = new dnx();
          localdnx.msgId = localb.Bsa;
          am.a(localdnx, 107, 3, 0, 0L, "");
        }
      }
    }
    this.dtm = false;
    this.Bsz = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.dLe.toByteArray());
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.dLe.qXu });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */