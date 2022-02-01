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
import com.tencent.mm.g.a.vz;
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
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  protected TopStoryWebView AaA;
  protected com.tencent.mm.plugin.topstory.ui.webview.e AaB;
  protected View AaC;
  protected View AaD;
  protected List<d.b> AaE;
  View AaF;
  int AaG;
  long AaH;
  boolean AaI;
  private LinearLayout AaJ;
  TopStoryViewPager AaK;
  View AaL;
  int AaM;
  boolean AaN;
  boolean AaO;
  private boolean AaP;
  private boolean AaQ;
  private boolean AaR;
  protected com.tencent.mm.sdk.b.c<vz> AaS;
  protected e.a AaT;
  protected MMActivity Aax;
  protected boolean Aay;
  protected com.tencent.mm.plugin.topstory.ui.webview.c Aaz;
  boolean dhO;
  protected dia dyS;
  private n hBi;
  protected ThreeDotsLoadingView mkI;
  int rJc;
  List<a> yMc;
  protected FrameLayout yoC;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.AaE = new ArrayList();
    this.AaG = 0;
    this.AaH = 0L;
    this.AaI = false;
    this.dhO = false;
    this.yMc = new ArrayList();
    this.rJc = -1;
    this.AaM = 0;
    this.AaN = false;
    this.AaO = true;
    this.AaS = new com.tencent.mm.sdk.b.c() {};
    this.AaT = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.AaB != null) {
          b.this.AaB.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.AaE.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Aax.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.cc(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.dhO) {
              com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.AaB != null)) {
          b.this.AaB.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.AaE.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (d.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Aax.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                paramAnonymousString3.cc(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125927);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.dhO))
            {
              com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc(), 107, 2, paramAnonymousString3.Aan, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(125934);
        com.tencent.mm.plugin.topstory.ui.webview.e locale;
        JSONObject localJSONObject;
        if (b.this.AaB != null)
        {
          locale = b.this.AaB;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          ap.f(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(125934);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramAnonymousString.getMessage());
          }
        }
      }
      
      public final void bn(final String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(125931);
        if (b.this.AaB != null) {
          b.this.AaB.br(paramAnonymousString, paramAnonymousLong);
        }
        Object localObject = b.this.AaE.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (d.b)((Iterator)localObject).next();
          if (((d.b)localObject).category == 110)
          {
            b.this.Aax.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                this.AaX.cd(1, paramAnonymousString);
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.dhO) && (((d.b)localObject).Aan <= 0)) {
              com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125931);
      }
      
      public final void bo(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.Aax.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125929);
            b.this.bq(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(125929);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void ecq()
      {
        AppMethodBeat.i(125933);
        Iterator localIterator = b.this.AaE.iterator();
        while (localIterator.hasNext())
        {
          final d.b localb = (d.b)localIterator.next();
          if (localb.category == 110)
          {
            b.this.Aax.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                localb.cd(0, "");
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
    this.hBi = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          ap.f(new e.12(b.this.AaB));
          AppMethodBeat.o(125936);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
          AppMethodBeat.o(125936);
        }
      }
    };
    this.Aax = paramMMActivity;
    this.Aay = paramBoolean;
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
      ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.ecy();
      paramTopStoryWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramTopStoryWebView = null;
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.ecy();
      }
    }
    AppMethodBeat.o(125977);
    return paramTopStoryWebView;
  }
  
  public final boolean Rl(int paramInt)
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
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.c paramc, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.e parame, dia paramdia)
  {
    AppMethodBeat.i(125974);
    this.Aaz = paramc;
    this.AaA = paramTopStoryWebView;
    this.AaB = parame;
    this.AaB.Agw = this;
    this.dyS = paramdia;
    paramc = this.Aaz;
    paramc.Agw = this;
    com.tencent.mm.kernel.g.agi().a(2582, paramc.AgB);
    com.tencent.mm.kernel.g.agi().a(2802, paramc.Adn);
    com.tencent.mm.kernel.g.agi().a(2906, paramc.AgA);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.yoC.addView(this.AaA, paramc);
    AppMethodBeat.o(125974);
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
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
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.rJc)
          {
            ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.rJc = paramInt;
          locala = (a)this.yMc.get(i);
          if (this.AaL.getParent() == ((a)this.yMc.get(i)).Abm) {
            if (locala.Abo <= 0)
            {
              paramInt = 1;
              locala.Abo = 2;
              localb = (d.b)this.AaE.get(this.rJc);
              this.AaO = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.Aam > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eci();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.e.h.JZN.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.AaA, locala.Abm.getWidth(), locala.Abm.getHeight());
                  b.this.Aax.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.Abd.Abn.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.Abd.Abn.setVisibility(0);
                        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.Abd.Abm.getWidth()), Integer.valueOf(b.8.this.Abd.Abm.getHeight()), Integer.valueOf(b.8.this.Abd.Abn.getWidth()), Integer.valueOf(b.8.this.Abd.Abn.getHeight()) });
                        if (b.this.AaL.getParent() != null)
                        {
                          ((ViewGroup)b.this.AaL.getParent()).removeView(b.this.AaL);
                          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.Abe);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.yMc.get(b.this.rJc)).Abm.addView(b.this.AaL, localLayoutParams);
                        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.rJc);
                        b.this.AaB.l(b.8.this.Abf.Aal, b.8.this.Abf.Aam, b.8.this.Abf.Aan, b.8.this.Abg);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.Abd.Abn.setImageDrawable(b.this.Aax.getResources().getDrawable(2131099648));
                        b.8.this.Abd.Abo = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!bs.isNullOrNil(localb.Aap)) {
                break label479;
              }
              localObject1 = localb.Aao;
              label266:
              com.tencent.mm.plugin.websearch.api.ai.b(localb.category, this.AaG, (String)localObject1, this.dyS.jKB, paramBoolean);
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
        locala.Abn.setVisibility(0);
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.Abn.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.AaL.getParent() != null)
        {
          ((ViewGroup)this.AaL.getParent()).removeView(this.AaL);
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((a)this.yMc.get(this.rJc)).Abm.addView(this.AaL, (ViewGroup.LayoutParams)localObject2);
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.rJc);
        this.AaB.l(localb.Aal, localb.Aam, localb.Aan, str1);
        break label248;
        String str2 = localb.Aap;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  public final void axM(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.yMc.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.Abn != null)
      {
        locala.Abo = 0;
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.AaR = true;
    this.AaB.axM(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void axN(String paramString)
  {
    AppMethodBeat.i(125969);
    ap.f(new e.8(this.AaB, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void axO(String paramString)
  {
    AppMethodBeat.i(125970);
    ap.f(new e.11(this.AaB, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void axP(String paramString)
  {
    AppMethodBeat.i(125971);
    ap.f(new e.10(this.AaB, paramString));
    AppMethodBeat.o(125971);
  }
  
  final void bq(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.AaF.setVisibility(0);
    dii localdii = new dii();
    localdii.dtG = paramString;
    localdii.FRm = paramLong;
    com.tencent.mm.plugin.websearch.api.ai.a(localdii, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final MMActivity cYC()
  {
    return this.Aax;
  }
  
  public final void ecN()
  {
    this.AaP = true;
  }
  
  public final void ecO()
  {
    AppMethodBeat.i(125967);
    this.AaQ = true;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.mkI.fuX();
        b.this.AaC.setVisibility(8);
        b.this.AaA.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void ecP()
  {
    AppMethodBeat.i(125973);
    this.Aax.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125923);
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
        b.this.AaD.setVisibility(8);
        b.this.AaI = false;
        if (b.this.AaK != null) {
          b.this.AaK.setScrollEnable(true);
        }
        AppMethodBeat.o(125923);
      }
    });
    AppMethodBeat.o(125973);
  }
  
  public final void ecQ()
  {
    AppMethodBeat.i(125959);
    if ((this.AaO) && (this.yMc.size() > 0))
    {
      final int i = this.rJc;
      this.AaK.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.this.rJc)
          {
            ((b.a)b.this.yMc.get(b.this.rJc)).Abn.setVisibility(8);
            ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.rJc);
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.AaO = true;
    AppMethodBeat.o(125959);
  }
  
  public final int ecR()
  {
    return this.AaM;
  }
  
  public final void ecS()
  {
    AppMethodBeat.i(125957);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.g.agR().agA().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", this.dyS.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecm());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.DHY);
        localObject2 = new dia();
        ((dia)localObject2).qox = com.tencent.mm.plugin.topstory.ui.d.ecM();
        ((dia)localObject2).scene = 21;
        ((dia)localObject2).jKB = "";
        ((dia)localObject2).cZL = "";
        ((dia)localObject2).sessionId = this.dyS.sessionId;
        ((dia)localObject2).drf = this.dyS.drf;
        ((dia)localObject2).FQW = 2;
        ((dia)localObject2).url = com.tencent.mm.plugin.topstory.a.h.l((HashMap)localObject1);
        ((dia)localObject2).EDw = "";
        ((dia)localObject2).cGY = 10802;
        ((dia)localObject2).rzt = z.dkv();
        ((dia)localObject2).tCS = this.Aax.getContext().getResources().getColor(2131101179);
        Object localObject1 = new yh();
        ((yh)localObject1).key = "rec_category";
        ((yh)localObject1).ErV = this.dyS.cGY;
        ((yh)localObject1).ErW = String.valueOf(this.dyS.cGY);
        ((dia)localObject2).BYq.add(localObject1);
        com.tencent.mm.plugin.topstory.ui.d.a(com.tencent.mm.sdk.platformtools.ai.getContext(), (dia)localObject2, "", false);
        AppMethodBeat.o(125957);
        return;
        localException = localException;
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  final void ecT()
  {
    AppMethodBeat.i(125962);
    if (this.AaB != null)
    {
      this.AaB.eeD();
      ecP();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean ecU()
  {
    return true;
  }
  
  public final void hU(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.Aax.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125922);
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        int i = paramInt1;
        int j = paramInt2;
        b.this.AaD.setBackgroundColor(i + 16777216 * j);
        b.this.AaD.setVisibility(0);
        b.this.AaI = true;
        b.this.AaD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(125921);
            b.a(b.this);
            AppMethodBeat.o(125921);
          }
        });
        if (b.this.AaK != null) {
          b.this.AaK.setScrollEnable(false);
        }
        AppMethodBeat.o(125922);
      }
    });
    AppMethodBeat.o(125972);
  }
  
  public final void hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    com.tencent.mm.plugin.websearch.api.ai.p("", 0, 0, paramInt1);
    String str = z.Ui(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.dyS.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.Aax.getString(2131764455), "utf8"));
      com.tencent.mm.kernel.g.agP();
      localHashMap.put("uin", com.tencent.mm.kernel.a.afE());
      localHashMap.put("timeZone", URLEncoder.encode(bs.eWc(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.DHY);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecm());
      label227:
      ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.Aax, paramInt1, "", str, localHashMap, this.Aax.getResources().getString(2131764474), this.Aax.getResources().getColor(2131099679));
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
      com.tencent.mm.plugin.topstory.ui.webview.e locale = this.AaB;
      try
      {
        ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", new Object[] { paramIntent, str });
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoPlayInfo", str);
        localJSONObject.put("searchId", paramIntent);
        ap.f(new e.5(locale, localJSONObject));
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
    if (this.AaI)
    {
      ecT();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.AaQ) {
      com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.api.ai.Ut(19);
      if (!this.Aay) {
        break;
      }
      this.Aax.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.AaP)
      {
        if (this.AaR) {
          com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.Aax.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.Aax.getSupportActionBar().hide();
    this.dyS = new dia();
    Object localObject3;
    Object localObject2;
    label803:
    label868:
    int i;
    try
    {
      this.dyS.parseFrom(this.Aax.getIntent().getByteArrayExtra("key_context"));
      if (!bs.isNullOrNil(this.dyS.qox))
      {
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.dyS.qox });
        this.AaE = com.tencent.mm.plugin.topstory.ui.d.axK(this.Aax.getIntent().getStringExtra("key_tabconfig"));
        if (!this.AaE.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.AaT);
        }
        this.AaS.alive();
        com.tencent.mm.kernel.g.agQ().a(this.hBi);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void axJ(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.webview.e locale;
            JSONObject localJSONObject;
            if (b.this.AaB != null)
            {
              locale = b.this.AaB;
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("params", paramAnonymousString);
              ap.f(new e.13(locale, localJSONObject.toString()));
              AppMethodBeat.o(125919);
              return;
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramAnonymousString.getMessage());
              }
            }
          }
        });
        com.tencent.mm.plugin.websearch.api.ai.Ut(17);
        this.AaL = LayoutInflater.from(this.Aax).inflate(2131495789, null);
        this.yoC = ((FrameLayout)this.AaL.findViewById(2131306912));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label803;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().tzz) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.dyS, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.AaC = this.AaL.findViewById(2131305153);
        this.mkI = ((ThreeDotsLoadingView)this.AaL.findViewById(2131301514));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.YJ()) && (!aj.DT())) {
          this.Aax.supportLightStatusBar();
        }
        localObject3 = (TextView)this.Aax.findViewById(2131305711);
        localObject2 = this.Aax.findViewById(2131296416);
        View localView = this.Aax.findViewById(2131306021);
        this.AaF = this.Aax.findViewById(2131301225);
        paramBundle = this.Aax.findViewById(2131306018);
        this.AaD = this.Aax.findViewById(2131306017);
        this.AaK = ((TopStoryViewPager)this.Aax.findViewById(2131306020));
        this.AaJ = ((LinearLayout)this.Aax.findViewById(2131306019));
        if (this.AaE.isEmpty()) {
          break label1625;
        }
        localTabLayout = (TabLayout)this.Aax.findViewById(2131305596);
        localObject4 = this.AaE.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label868;
          }
          localb = (d.b)((Iterator)localObject4).next();
          localb.tq = localTabLayout.cE();
          localb.tq.ak(2131495788);
          localb.titleTv = ((TextView)localb.tq.tk.findViewById(2131306157));
          localb.tvN = localb.tq.tk.findViewById(2131305599);
          localb.Aaq = ((TextView)localb.tq.tk.findViewById(2131306156));
          localb.Aar = localb.tq.tk.findViewById(2131301224);
          localb.titleTv.setText(localb.dlQ);
          if (localb.Aan <= 0) {
            break;
          }
          paramBundle = localb.Aan;
          if (localb.Aan > 99) {
            paramBundle = "99+";
          }
          localb.Aaq.setText(paramBundle);
          localb.Aaq.setVisibility(0);
          localb.Aar.setVisibility(8);
          localTabLayout.a(localb.tq, false);
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
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.dyS.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.Aax.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.dyS, true);
          paramBundle.b(this);
          continue;
          if (localb.Aam > 0)
          {
            localb.Aaq.setText("");
            localb.Aaq.setVisibility(4);
            localb.Aar.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new TabLayout.c()
      {
        public final void f(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125944);
          int i = 0;
          while (i < b.this.AaE.size())
          {
            d.b localb = (d.b)b.this.AaE.get(i);
            if (localb.tq.equals(paramAnonymousf))
            {
              ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.dlQ);
              localb.titleTv.setTextColor(b.this.Aax.getResources().getColor(2131101046));
              localb.tvN.setBackgroundColor(b.this.Aax.getResources().getColor(2131100711));
              b.this.aE(i, false);
              b.this.AaK.setCurrentItem(i);
              if ((localb.category == 100) && (localb.Aam > 0))
              {
                localb.cd(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecj();
              }
              i = localb.category;
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRT, Integer.valueOf(i));
              b.this.AaG = localb.category;
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
          Iterator localIterator = b.this.AaE.iterator();
          while (localIterator.hasNext())
          {
            d.b localb = (d.b)localIterator.next();
            if (localb.tq.equals(paramAnonymousf))
            {
              b.this.AaM = localb.category;
              ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.dlQ);
              localb.titleTv.setTextColor(b.this.Aax.getResources().getColor(2131101047));
              localb.tvN.setBackgroundColor(b.this.Aax.getResources().getColor(2131101053));
              AppMethodBeat.o(125945);
              return;
            }
          }
          AppMethodBeat.o(125945);
        }
        
        public final void h(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125946);
          Object localObject = b.this.AaE.iterator();
          while (((Iterator)localObject).hasNext())
          {
            d.b localb = (d.b)((Iterator)localObject).next();
            if (localb.tq.equals(paramAnonymousf))
            {
              ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.dlQ);
              localb.titleTv.setTextColor(b.this.Aax.getResources().getColor(2131101046));
              localb.tvN.setBackgroundColor(b.this.Aax.getResources().getColor(2131100711));
              localObject = "";
              paramAnonymousf = (TabLayout.f)localObject;
              if (localb.category == 100)
              {
                paramAnonymousf = (TabLayout.f)localObject;
                if (localb.Aam > 0) {
                  paramAnonymousf = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eci();
                }
              }
              b.this.AaB.l(localb.Aal, localb.Aam, localb.Aan, paramAnonymousf);
              if ((localb.category == 100) && (localb.Aam > 0))
              {
                localb.cd(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecj();
              }
              if (bs.isNullOrNil(localb.Aap)) {}
              for (paramAnonymousf = localb.Aao;; paramAnonymousf = localb.Aap)
              {
                com.tencent.mm.plugin.websearch.api.ai.b(localb.category, b.this.AaG, paramAnonymousf, b.this.dyS.jKB, false);
                b.this.AaG = localb.category;
                AppMethodBeat.o(125946);
                return;
              }
            }
          }
          AppMethodBeat.o(125946);
        }
      });
      this.AaK.setVisibility(0);
      i = 0;
      while (i < this.AaE.size())
      {
        paramBundle = new a();
        paramBundle.Abl = LayoutInflater.from(this.Aax).inflate(2131495785, null);
        paramBundle.Abn = ((ImageView)paramBundle.Abl.findViewById(2131299755));
        paramBundle.Abm = ((FrameLayout)paramBundle.Abl.findViewById(2131299756));
        this.yMc.add(paramBundle);
        i += 1;
      }
      this.AaK.setAdapter(new android.support.v4.view.q()
      {
        public final void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(125949);
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "destroyItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousObject.hashCode()) });
          paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
          AppMethodBeat.o(125949);
        }
        
        public final int getCount()
        {
          AppMethodBeat.i(125947);
          int i = b.this.AaE.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.a)b.this.yMc.get(paramAnonymousInt)).Abl.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.a)b.this.yMc.get(paramAnonymousInt)).Abl, localLayoutParams);
          paramAnonymousViewGroup = ((b.a)b.this.yMc.get(paramAnonymousInt)).Abl;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.AaK.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.this.AaO)
            {
              paramAnonymousInt = b.this.rJc;
              b.this.AaK.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.this.rJc)
                  {
                    ((b.a)b.this.yMc.get(b.this.rJc)).Abn.setVisibility(8);
                    ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.rJc);
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.this.AaO = true;
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.aE(paramAnonymousInt, true);
          if (!localTabLayout.ad(paramAnonymousInt).isSelected()) {
            localTabLayout.ad(paramAnonymousInt).select();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.AaA.Jbj = new MMWebView.e()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.a locala = (b.a)b.this.yMc.get(b.this.rJc);
          locala.Abo -= 1;
          AppMethodBeat.o(125953);
        }
      };
      i = this.Aax.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.AaE.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (d.b)paramBundle.next();
        if (((d.b)localObject4).category == i) {
          ((d.b)localObject4).tq.select();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.ad(0).select();
      }
      ((TextView)localObject3).setText("");
      paramBundle = ab.eUO();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.Aax.findViewById(2131298383).setVisibility(8);
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
    ((ImageView)this.Aax.findViewById(2131296417)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.mkI.fuW();
    if (ecU())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eck();
      label1334:
      if (bs.isNullOrNil(paramBundle))
      {
        this.AaF.setVisibility(8);
        label1256:
        localException.setVisibility(0);
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            if (b.this.AaN)
            {
              AppMethodBeat.o(125943);
              return;
            }
            b.this.AaN = true;
            b.this.ecS();
            com.tencent.mm.plugin.report.e.wTc.f(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.AaF.getVisibility() == 0)
            {
              b.this.AaF.setVisibility(8);
              paramAnonymousView = new dii();
              paramAnonymousView.dtG = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eck();
              paramAnonymousView.FRm = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecl();
              com.tencent.mm.plugin.websearch.api.ai.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecn();
            }
            AppMethodBeat.o(125943);
          }
        });
        label1273:
        if (this.dyS.tCS != 0)
        {
          paramBundle = this.Aax.findViewById(2131296347);
          i = this.dyS.tCS;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1718;
          }
          i = 1;
          if (i == 0) {
            break label1723;
          }
          paramBundle.setBackgroundColor(this.Aax.getResources().getColor(2131101179));
          this.Aax.setActionbarColor(this.Aax.getResources().getColor(2131101179));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.dyS.scene == 54)
      {
        paramBundle = this.Aax.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.Aax);
          ((d.a)localObject1).a(com.tencent.mm.compatible.e.a.decodeResource(this.Aax.getResources(), 2131690054), false, 3);
          ((d.a)localObject1).yf(false);
          ((d.a)localObject1).yg(false);
          ((d.a)localObject1).aRL(this.Aax.getString(2131757561)).acL(17);
          localObject1 = ((d.a)localObject1).fvp();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.Aax.getString(2131757557, new Object[] { localObject2 }), true, new b.9(this, paramBundle, (String)localObject3));
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.Aax.getString(2131757564), true, new b.10(this));
          ((com.tencent.mm.ui.widget.a.d)localObject1).Ym(this.Aax.getResources().getColor(2131100035));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.e.wTc.f(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1625:
      this.AaK.setVisibility(8);
      this.AaJ.addView(this.AaL, -1, -1);
      ((TextView)localObject3).setText(this.dyS.EDw);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.11(this));
      break;
      bq(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecl());
      break label1256;
      ((View)localObject1).setVisibility(8);
      break label1273;
      label1718:
      i = 0;
      break label1334;
      label1723:
      paramBundle.setBackgroundColor(this.dyS.tCS);
      this.Aax.setActionbarColor(this.dyS.tCS);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.AaA.Jbj = null;
    try
    {
      if ((this.dyS.cGY == 100) && (this.AaB != null)) {
        com.tencent.mm.plugin.topstory.ui.webview.a.a(this.AaB, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.AaA.getParent() != null) && (this.AaA.getParent().equals(this.yoC)))
      {
        ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.yoC.removeView(this.AaA);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.AaA != null) {
      this.AaA.onDestroy();
    }
    localObject = this.dyS;
    l = this.Aax.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((dia)localObject).scene), Long.valueOf(l), Integer.valueOf(((dia)localObject).cGY), Integer.valueOf(((dia)localObject).FQW) });
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiOnDestroy", System.currentTimeMillis());
    com.tencent.mm.plugin.websearch.api.ai.Ut(18);
    localObject = this.Aaz;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Agw = null;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Agy = null;
    com.tencent.mm.kernel.g.agi().b(1943, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.kernel.g.agi().b(2582, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).AgB);
    com.tencent.mm.kernel.g.agi().b(2802, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).Adn);
    com.tencent.mm.kernel.g.agi().b(2906, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).AgA);
    this.AaS.dead();
    com.tencent.mm.kernel.g.agQ().b(this.hBi);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.AaT);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    dia localdia = new dia();
    try
    {
      localdia.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.dyS.sessionId = localdia.sessionId;
      this.dyS.drf = localdia.drf;
      this.dyS.scene = localdia.scene;
      this.dyS.dlj = localdia.dlj;
      this.dyS.rzt = z.dkv();
      com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiOnNewIntent", System.currentTimeMillis());
      com.tencent.mm.plugin.websearch.api.ai.Ut(20);
      this.AaB.axV("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.Aax.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiOnPause", System.currentTimeMillis());
    this.AaB.axV("onPause");
    if (this.AaA != null) {
      this.AaA.onPause();
    }
    this.dhO = true;
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null)
    {
      int i = this.AaG;
      if (this.AaG == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.ecJ();
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
    com.tencent.mm.plugin.topstory.a.i.a(this.dyS, "uiOnResume", System.currentTimeMillis());
    this.AaB.axV("onResume");
    if (this.AaA != null) {
      this.AaA.onResume();
    }
    com.tencent.mm.cq.d.aSW("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.AaE.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.Aan > 0)
      {
        if (localb.category == 110) {
          com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc(), 107, 2, localb.Aan, 0L, "");
        }
      }
      else if (localb.Aam > 0) {
        if (localb.category == 110)
        {
          com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          dii localdii = new dii();
          localdii.dtG = localb.Aao;
          com.tencent.mm.plugin.websearch.api.ai.a(localdii, 107, 3, 0, 0L, "");
        }
      }
    }
    this.dhO = false;
    this.AaN = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.dyS.toByteArray());
      ac.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.dyS.qox });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
  
  static final class a
  {
    View Abl;
    FrameLayout Abm;
    ImageView Abn;
    int Abo = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */