package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
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
import android.support.v4.view.q;
import android.support.v7.app.ActionBar;
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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.topstory.ui.a.e.10;
import com.tencent.mm.plugin.topstory.ui.a.e.13;
import com.tencent.mm.plugin.topstory.ui.a.e.15;
import com.tencent.mm.plugin.topstory.ui.a.e.16;
import com.tencent.mm.plugin.topstory.ui.a.e.18;
import com.tencent.mm.plugin.topstory.ui.a.e.2;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.e;
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
  List<a> EDW;
  protected FrameLayout EeM;
  TopStoryViewPager GkA;
  View GkB;
  int GkC;
  boolean GkD;
  boolean GkE;
  private boolean GkF;
  private boolean GkG;
  private boolean GkH;
  protected IListener<xx> GkI;
  protected e.a GkJ;
  protected MMActivity Gkn;
  protected boolean Gko;
  protected com.tencent.mm.plugin.topstory.ui.a.c Gkp;
  protected WebSearchWebView Gkq;
  protected com.tencent.mm.plugin.topstory.ui.a.e Gkr;
  protected View Gks;
  protected View Gkt;
  protected List<c.b> Gku;
  View Gkv;
  int Gkw;
  long Gkx;
  boolean Gky;
  private LinearLayout Gkz;
  boolean dLD;
  protected eii eel;
  private p iRt;
  protected ThreeDotsLoadingView odq;
  int uis;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.Gku = new ArrayList();
    this.Gkw = 0;
    this.Gkx = 0L;
    this.Gky = false;
    this.dLD = false;
    this.EDW = new ArrayList();
    this.uis = -1;
    this.GkC = 0;
    this.GkD = false;
    this.GkE = true;
    this.GkI = new IListener() {};
    this.GkJ = new e.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.Gkr != null) {
          b.this.Gkr.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.Gku.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (c.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Gkn.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.cA(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.this.dLD) {
              ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.Gkr != null)) {
          b.this.Gkr.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.Gku.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (c.b)paramAnonymousString1.next();
          if (paramAnonymousString3.category == 110)
          {
            b.this.Gkn.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                paramAnonymousString3.cA(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125927);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.this.dLD))
            {
              ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, paramAnonymousString3.Gkd, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final void bt(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.Gkn.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125929);
            b.this.bv(paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(125929);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void fP(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(236385);
        com.tencent.mm.plugin.topstory.ui.a.e locale;
        JSONObject localJSONObject;
        if (b.this.Gkr != null)
        {
          locale = b.this.Gkr;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          localJSONObject.put("reddotType", paramAnonymousInt);
          MMHandlerThread.postToMainThread(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(236385);
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
      
      public final void fxO()
      {
        AppMethodBeat.i(236384);
        Iterator localIterator = b.this.Gku.iterator();
        while (localIterator.hasNext())
        {
          final c.b localb = (c.b)localIterator.next();
          if (localb.category == 110)
          {
            b.this.Gkn.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                localb.cB(0, "");
                AppMethodBeat.o(125928);
              }
            });
            AppMethodBeat.o(236384);
            return;
          }
        }
        AppMethodBeat.o(236384);
      }
      
      public final void p(final String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(236383);
        if (b.this.Gkr != null) {
          b.this.Gkr.q(paramAnonymousString, paramAnonymousLong, paramAnonymousInt);
        }
        Object localObject = b.this.Gku.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (c.b)((Iterator)localObject).next();
          if (((c.b)localObject).category == 110)
          {
            b.this.Gkn.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                this.GkN.cB(1, paramAnonymousString);
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.this.dLD) && (((c.b)localObject).Gkd <= 0)) {
              ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(236383);
      }
    };
    this.iRt = new b.7(this);
    this.Gkn = paramMMActivity;
    this.Gko = paramBoolean;
    AppMethodBeat.o(125955);
  }
  
  static Bitmap a(WebSearchWebView paramWebSearchWebView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236387);
    try
    {
      long l = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      paramWebSearchWebView.drawCanvas(new Canvas(localBitmap));
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.fxU();
      paramWebSearchWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramWebSearchWebView = null;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.fxU();
      }
    }
    AppMethodBeat.o(236387);
    return paramWebSearchWebView;
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.a.c paramc, WebSearchWebView paramWebSearchWebView, com.tencent.mm.plugin.topstory.ui.a.e parame, eii parameii)
  {
    AppMethodBeat.i(236386);
    this.Gkp = paramc;
    this.Gkq = paramWebSearchWebView;
    this.Gkr = parame;
    this.Gkr.IHe = this;
    this.eel = parameii;
    paramc = this.Gkp;
    paramc.IHe = this;
    g.azz().a(2582, paramc.Gqr);
    g.azz().a(2802, paramc.Gnc);
    g.azz().a(2906, paramc.Gqq);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.EeM.addView(this.Gkq, paramc);
    AppMethodBeat.o(236386);
  }
  
  public final void aTA(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.EDW.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.Glc != null)
      {
        locala.Gld = 0;
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.GkH = true;
    this.Gkr.aTA(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void aTB(String paramString)
  {
    AppMethodBeat.i(125969);
    MMHandlerThread.postToMainThread(new e.13(this.Gkr, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void aTC(String paramString)
  {
    AppMethodBeat.i(125970);
    MMHandlerThread.postToMainThread(new e.16(this.Gkr, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void aTD(String paramString)
  {
    AppMethodBeat.i(125971);
    MMHandlerThread.postToMainThread(new e.15(this.Gkr, paramString));
    AppMethodBeat.o(125971);
  }
  
  public final boolean abS(int paramInt)
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
  
  public final void bc(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      final a locala;
      label136:
      label142:
      final c.b localb;
      try
      {
        AppMethodBeat.i(125978);
        localObject2 = new StringBuilder("changeView, from ");
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = "viewpager";
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.uis)
          {
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.uis = paramInt;
          locala = (a)this.EDW.get(i);
          if (this.GkB.getParent() == ((a)this.EDW.get(i)).Glb) {
            if (locala.Gld <= 0)
            {
              paramInt = 1;
              locala.Gld = 2;
              localb = (c.b)this.Gku.get(this.uis);
              this.GkE = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.Gkc > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
                }
              }
              if (paramInt == 0) {
                break label346;
              }
              com.tencent.f.h.RTc.b(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125938);
                  final Bitmap localBitmap = b.a(b.this.Gkq, locala.Glb.getWidth(), locala.Glb.getHeight());
                  b.this.Gkn.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(125937);
                      if (localBitmap != null) {
                        b.8.this.GkS.Glc.setImageBitmap(localBitmap);
                      }
                      for (;;)
                      {
                        b.8.this.GkS.Glc.setVisibility(0);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.8.this.GkS.Glb.getWidth()), Integer.valueOf(b.8.this.GkS.Glb.getHeight()), Integer.valueOf(b.8.this.GkS.Glc.getWidth()), Integer.valueOf(b.8.this.GkS.Glc.getHeight()) });
                        if (b.this.GkB.getParent() != null)
                        {
                          ((ViewGroup)b.this.GkB.getParent()).removeView(b.this.GkB);
                          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.8.this.GkT);
                        }
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                        ((b.a)b.this.EDW.get(b.this.uis)).Glb.addView(b.this.GkB, localLayoutParams);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.uis);
                        b.this.Gkr.m(b.8.this.GkU.Gkb, b.8.this.GkU.Gkc, b.8.this.GkU.Gkd, b.8.this.GkV);
                        AppMethodBeat.o(125937);
                        return;
                        b.8.this.GkS.Glc.setImageDrawable(b.this.Gkn.getResources().getDrawable(2131099648));
                        b.8.this.GkS.Gld = 0;
                      }
                    }
                  });
                  AppMethodBeat.o(125938);
                }
              }, "CaptureWebViewTask");
              label248:
              if (!Util.isNullOrNil(localb.Gkf)) {
                break label479;
              }
              localObject1 = localb.Gke;
              label266:
              ar.b(localb.category, this.Gkw, (String)localObject1, this.eel.hes, paramBoolean);
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
        locala.Glc.setVisibility(0);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.Glc.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.GkB.getParent() != null)
        {
          ((ViewGroup)this.GkB.getParent()).removeView(this.GkB);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((a)this.EDW.get(this.uis)).Glb.addView(this.GkB, (ViewGroup.LayoutParams)localObject2);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.uis);
        this.Gkr.m(localb.Gkb, localb.Gkc, localb.Gkd, str1);
        break label248;
        String str2 = localb.Gkf;
        break label266;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  final void bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.Gkv.setVisibility(0);
    eiq localeiq = new eiq();
    localeiq.msgId = paramString;
    localeiq.NhO = paramLong;
    ar.a(localeiq, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  public final WebSearchWebView dQg()
  {
    return this.Gkq;
  }
  
  public final MMActivity eeF()
  {
    return this.Gkn;
  }
  
  public final void fyj()
  {
    this.GkF = true;
  }
  
  public final void fyk()
  {
    AppMethodBeat.i(125967);
    this.GkG = true;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.odq.gZi();
        b.this.Gks.setVisibility(8);
        b.this.Gkq.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void fyl()
  {
    AppMethodBeat.i(125973);
    this.Gkn.runOnUiThread(new b.4(this));
    AppMethodBeat.o(125973);
  }
  
  public final void fym()
  {
    AppMethodBeat.i(125959);
    if ((this.GkE) && (this.EDW.size() > 0))
    {
      final int i = this.uis;
      this.GkA.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.this.uis)
          {
            ((b.a)b.this.EDW.get(b.this.uis)).Glc.setVisibility(8);
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.uis);
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.GkE = true;
    AppMethodBeat.o(125959);
  }
  
  public final int fyn()
  {
    return this.GkC;
  }
  
  final void fyo()
  {
    AppMethodBeat.i(125962);
    if (this.Gkr != null)
    {
      this.Gkr.fzW();
      fyl();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean fyp()
  {
    return true;
  }
  
  public final Context getActivityContext()
  {
    return this.Gkn;
  }
  
  public final void jn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.Gkn.runOnUiThread(new b.3(this, paramInt1, paramInt2));
    AppMethodBeat.o(125972);
  }
  
  public final void jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    ar.q("", 0, 0, paramInt1);
    String str = ai.afq(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.eel.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.Gkn.getString(2131766799), "utf8"));
      g.aAf();
      localHashMap.put("uin", com.tencent.mm.kernel.a.ayV());
      localHashMap.put("timeZone", URLEncoder.encode(Util.getTimeZoneOffset(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.KyK);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxG());
      label227:
      ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(this.Gkn, paramInt1, "", str, localHashMap, this.Gkn.getResources().getString(2131766818), this.Gkn.getResources().getColor(2131099689));
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
      com.tencent.mm.plugin.topstory.ui.a.e locale = this.Gkr;
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
    if (this.Gky)
    {
      fyo();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.GkG) {
      com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      ar.afB(19);
      if (!this.Gko) {
        break;
      }
      this.Gkn.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.GkF)
      {
        if (this.GkH) {
          com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.Gkn.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.Gkn.getSupportActionBar().hide();
    this.eel = new eii();
    Object localObject3;
    Object localObject2;
    label811:
    label876:
    int i;
    try
    {
      this.eel.parseFrom(this.Gkn.getIntent().getByteArrayExtra("key_context"));
      if (!Util.isNullOrNil(this.eel.sGQ))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.eel.sGQ });
        this.Gku = com.tencent.mm.plugin.topstory.ui.c.aTy(this.Gkn.getIntent().getStringExtra("key_tabconfig"));
        if (!this.Gku.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.GkJ);
        }
        this.GkI.alive();
        g.aAg().a(this.iRt);
        ((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void aTx(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.a.e locale;
            JSONObject localJSONObject;
            if (b.this.Gkr != null)
            {
              locale = b.this.Gkr;
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
        ar.afB(17);
        this.GkB = LayoutInflater.from(this.Gkn).inflate(2131496747, null);
        this.EeM = ((FrameLayout)this.GkB.findViewById(2131310385));
        if (((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label811;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().ygl) {
          ((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.eel, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.Gks = this.GkB.findViewById(2131308336);
        this.odq = ((ThreeDotsLoadingView)this.GkB.findViewById(2131303719));
        if ((Build.VERSION.SDK_INT >= 21) && (!MIUI.isMIUIV8()) && (!com.tencent.mm.ui.ao.isDarkMode())) {
          this.Gkn.supportLightStatusBar();
        }
        localObject3 = (TextView)this.Gkn.findViewById(2131308978);
        localObject2 = this.Gkn.findViewById(2131296448);
        View localView = this.Gkn.findViewById(2131309333);
        this.Gkv = this.Gkn.findViewById(2131302913);
        paramBundle = this.Gkn.findViewById(2131309329);
        this.Gkt = this.Gkn.findViewById(2131309328);
        this.GkA = ((TopStoryViewPager)this.Gkn.findViewById(2131309331));
        this.Gkz = ((LinearLayout)this.Gkn.findViewById(2131309330));
        this.GkA.setScrollEnable(false);
        if (this.Gku.isEmpty()) {
          break label1633;
        }
        localTabLayout = (TabLayout)this.Gkn.findViewById(2131308820);
        localObject4 = this.Gku.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label876;
          }
          localb = (c.b)((Iterator)localObject4).next();
          localb.vq = localTabLayout.cW();
          localb.vq.aj(2131496746);
          localb.titleTv = ((TextView)localb.vq.vk.findViewById(2131309532));
          localb.xYN = localb.vq.vk.findViewById(2131308835);
          localb.Gkg = ((TextView)localb.vq.vk.findViewById(2131309531));
          localb.Gkh = localb.vq.vk.findViewById(2131302912);
          localb.titleTv.setText(localb.dQx);
          if (localb.Gkd <= 0) {
            break;
          }
          paramBundle = localb.Gkd;
          if (localb.Gkd > 99) {
            paramBundle = "99+";
          }
          localb.Gkg.setText(paramBundle);
          localb.Gkg.setVisibility(0);
          localb.Gkh.setVisibility(8);
          localTabLayout.a(localb.vq, false);
        }
      }
    }
    catch (Exception localException)
    {
      final TabLayout localTabLayout;
      Object localObject4;
      for (;;)
      {
        c.b localb;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.eel.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.Gkn.finish();
          continue;
          paramBundle = new d();
          paramBundle.a(this.eel, true);
          paramBundle.b(this);
          continue;
          if (localb.Gkc > 0)
          {
            localb.Gkg.setText("");
            localb.Gkg.setVisibility(4);
            localb.Gkh.setVisibility(0);
          }
        }
      }
      localTabLayout.a(new TabLayout.c()
      {
        public final void i(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125944);
          int i = 0;
          while (i < b.this.Gku.size())
          {
            c.b localb = (c.b)b.this.Gku.get(i);
            if (localb.vq.equals(paramAnonymousf))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.dQx);
              localb.titleTv.setTextColor(b.this.Gkn.getResources().getColor(2131101279));
              localb.xYN.setBackgroundColor(b.this.Gkn.getResources().getColor(2131100904));
              b.this.bc(i, false);
              b.this.GkA.setCurrentItem(i);
              if ((localb.category == 100) && (localb.Gkc > 0))
              {
                localb.cB(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxD();
              }
              i = localb.category;
              g.aAh().azQ().set(ar.a.Ohu, Integer.valueOf(i));
              b.this.Gkw = localb.category;
              AppMethodBeat.o(125944);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(125944);
        }
        
        public final void j(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125945);
          Iterator localIterator = b.this.Gku.iterator();
          while (localIterator.hasNext())
          {
            c.b localb = (c.b)localIterator.next();
            if (localb.vq.equals(paramAnonymousf))
            {
              b.this.GkC = localb.category;
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.dQx);
              localb.titleTv.setTextColor(b.this.Gkn.getResources().getColor(2131101280));
              localb.xYN.setBackgroundColor(b.this.Gkn.getResources().getColor(2131101287));
              AppMethodBeat.o(125945);
              return;
            }
          }
          AppMethodBeat.o(125945);
        }
        
        public final void k(TabLayout.f paramAnonymousf)
        {
          AppMethodBeat.i(125946);
          Object localObject = b.this.Gku.iterator();
          while (((Iterator)localObject).hasNext())
          {
            c.b localb = (c.b)((Iterator)localObject).next();
            if (localb.vq.equals(paramAnonymousf))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.dQx);
              localb.titleTv.setTextColor(b.this.Gkn.getResources().getColor(2131101279));
              localb.xYN.setBackgroundColor(b.this.Gkn.getResources().getColor(2131100904));
              localObject = "";
              paramAnonymousf = (TabLayout.f)localObject;
              if (localb.category == 100)
              {
                paramAnonymousf = (TabLayout.f)localObject;
                if (localb.Gkc > 0) {
                  paramAnonymousf = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
                }
              }
              b.this.Gkr.m(localb.Gkb, localb.Gkc, localb.Gkd, paramAnonymousf);
              if ((localb.category == 100) && (localb.Gkc > 0))
              {
                localb.cB(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxD();
              }
              if (Util.isNullOrNil(localb.Gkf)) {}
              for (paramAnonymousf = localb.Gke;; paramAnonymousf = localb.Gkf)
              {
                ar.b(localb.category, b.this.Gkw, paramAnonymousf, b.this.eel.hes, false);
                b.this.Gkw = localb.category;
                AppMethodBeat.o(125946);
                return;
              }
            }
          }
          AppMethodBeat.o(125946);
        }
      });
      this.GkA.setVisibility(0);
      i = 0;
      while (i < this.Gku.size())
      {
        paramBundle = new a();
        paramBundle.Gla = LayoutInflater.from(this.Gkn).inflate(2131496743, null);
        paramBundle.Glc = ((ImageView)paramBundle.Gla.findViewById(2131300422));
        paramBundle.Glb = ((FrameLayout)paramBundle.Gla.findViewById(2131300423));
        this.EDW.add(paramBundle);
        i += 1;
      }
      this.GkA.setAdapter(new q()
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
          int i = b.this.Gku.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.a)b.this.EDW.get(paramAnonymousInt)).Gla.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.a)b.this.EDW.get(paramAnonymousInt)).Gla, localLayoutParams);
          paramAnonymousViewGroup = ((b.a)b.this.EDW.get(paramAnonymousInt)).Gla;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.GkA.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.this.GkE)
            {
              paramAnonymousInt = b.this.uis;
              b.this.GkA.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.this.uis)
                  {
                    ((b.a)b.this.EDW.get(b.this.uis)).Glc.setVisibility(8);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.uis);
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.this.GkE = true;
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.bc(paramAnonymousInt, true);
          if (!localTabLayout.ab(paramAnonymousInt).isSelected()) {
            localTabLayout.ab(paramAnonymousInt).select();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.Gkq.QDX = new MMWebView.e()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.a locala = (b.a)b.this.EDW.get(b.this.uis);
          locala.Gld -= 1;
          AppMethodBeat.o(125953);
        }
      };
      i = this.Gkn.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.Gku.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (c.b)paramBundle.next();
        if (((c.b)localObject4).category == i) {
          ((c.b)localObject4).vq.select();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.ab(0).select();
      }
      ((TextView)localObject3).setText("");
      paramBundle = LocaleUtil.getApplicationLanguage();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.Gkn.findViewById(2131298792).setVisibility(8);
      }
    }
    ((View)localObject2).setOnClickListener(new b.12(this));
    ((ImageView)this.Gkn.findViewById(2131296449)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.odq.gZh();
    if (fyp())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxE();
      if (Util.isNullOrNil(paramBundle))
      {
        this.Gkv.setVisibility(8);
        label1264:
        localException.setVisibility(0);
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (b.this.GkD)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125943);
              return;
            }
            b.this.GkD = true;
            com.tencent.mm.plugin.topstory.ui.c.a(b.this.eeF(), b.this.eel);
            com.tencent.mm.plugin.report.e.Cxv.a(15449, new Object[] { Integer.valueOf(0) });
            if (b.this.Gkv.getVisibility() == 0)
            {
              b.this.Gkv.setVisibility(8);
              paramAnonymousView = new eiq();
              paramAnonymousView.msgId = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxE();
              paramAnonymousView.NhO = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxF();
              ar.a(paramAnonymousView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxH();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125943);
          }
        });
        label1281:
        if (this.eel.wwG != 0)
        {
          paramBundle = this.Gkn.findViewById(2131296369);
          i = this.eel.wwG;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label1726;
          }
          i = 1;
          label1342:
          if (i == 0) {
            break label1731;
          }
          paramBundle.setBackgroundColor(this.Gkn.getResources().getColor(2131101424));
          this.Gkn.setActionbarColor(this.Gkn.getResources().getColor(2131101424));
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if (this.eel.scene == 54)
      {
        paramBundle = this.Gkn.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new d.a(this.Gkn);
          ((d.a)localObject1).b(com.tencent.mm.compatible.f.a.decodeResource(this.Gkn.getResources(), 2131690084), false, 3);
          ((d.a)localObject1).Dk(false);
          ((d.a)localObject1).Dl(false);
          ((d.a)localObject1).bor(this.Gkn.getString(2131757788)).aoU(17);
          localObject1 = ((d.a)localObject1).hbn();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.d)localObject1).b(this.Gkn.getString(2131757784, new Object[] { localObject2 }), true, new b.9(this, paramBundle, (String)localObject3));
          ((com.tencent.mm.ui.widget.a.d)localObject1).a(this.Gkn.getString(2131757791), true, new b.10(this));
          ((com.tencent.mm.ui.widget.a.d)localObject1).ajM(this.Gkn.getResources().getColor(2131100063));
          ((com.tencent.mm.ui.widget.a.d)localObject1).show();
          com.tencent.mm.plugin.report.e.Cxv.a(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.c.c(this.eel, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(125956);
      return;
      label1633:
      this.GkA.setVisibility(8);
      this.Gkz.addView(this.GkB, -1, -1);
      ((TextView)localObject3).setText(this.eel.nbg);
      ((TextView)localObject3).setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.11(this));
      break;
      bv(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxF());
      break label1264;
      ((View)localObject1).setVisibility(8);
      break label1281;
      label1726:
      i = 0;
      break label1342;
      label1731:
      paramBundle.setBackgroundColor(this.eel.wwG);
      this.Gkn.setActionbarColor(this.eel.wwG);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.Gkq.QDX = null;
    try
    {
      if ((this.eel.channelId == 100) && (this.Gkr != null)) {
        com.tencent.mm.plugin.topstory.ui.a.a.a(this.Gkr, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.Gkq.getParent() != null) && (this.Gkq.getParent().equals(this.EeM)))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.EeM.removeView(this.Gkq);
      }
    }
    catch (Exception localException)
    {
      label92:
      Object localObject;
      long l;
      break label92;
    }
    if (this.Gkq != null) {
      this.Gkq.onDestroy();
    }
    localObject = this.eel;
    l = this.Gkn.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((eii)localObject).scene), Long.valueOf(l), Integer.valueOf(((eii)localObject).channelId), Integer.valueOf(((eii)localObject).Nhz) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiOnDestroy", System.currentTimeMillis());
    ar.afB(18);
    localObject = this.Gkp;
    ((com.tencent.mm.plugin.websearch.webview.a)localObject).IHe = null;
    ((com.tencent.mm.plugin.topstory.ui.a.c)localObject).Gqo = null;
    g.azz().b(1943, (com.tencent.mm.ak.i)localObject);
    g.azz().b(2582, ((com.tencent.mm.plugin.topstory.ui.a.c)localObject).Gqr);
    g.azz().b(2802, ((com.tencent.mm.plugin.topstory.ui.a.c)localObject).Gnc);
    g.azz().b(2906, ((com.tencent.mm.plugin.topstory.ui.a.c)localObject).Gqq);
    this.GkI.dead();
    g.aAg().b(this.iRt);
    ((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.GkJ);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    eii localeii = new eii();
    try
    {
      localeii.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.eel.sessionId = localeii.sessionId;
      this.eel.dVO = localeii.dVO;
      this.eel.scene = localeii.scene;
      this.eel.dPI = localeii.dPI;
      this.eel.wib = ai.ait();
      com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiOnNewIntent", System.currentTimeMillis());
      ar.afB(20);
      this.Gkr.aTJ("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.Gkn.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiOnPause", System.currentTimeMillis());
    this.Gkr.aTJ("onPause");
    if (this.Gkq != null) {
      this.Gkq.onPause();
    }
    this.dLD = true;
    if (g.af(com.tencent.mm.plugin.ball.c.a.class) != null)
    {
      int i = this.Gkw;
      if (this.Gkw == 0) {
        i = com.tencent.mm.plugin.topstory.ui.c.fyf();
      }
      if (i == 100)
      {
        ((com.tencent.mm.plugin.ball.c.a)g.af(com.tencent.mm.plugin.ball.c.a.class)).d(104, false, false);
        AppMethodBeat.o(125964);
        return;
      }
      if (i == 110) {
        ((com.tencent.mm.plugin.ball.c.a)g.af(com.tencent.mm.plugin.ball.c.a.class)).d(103, false, false);
      }
    }
    AppMethodBeat.o(125964);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(125963);
    com.tencent.mm.plugin.topstory.a.i.a(this.eel, "uiOnResume", System.currentTimeMillis());
    this.Gkr.aTJ("onResume");
    if (this.Gkq != null) {
      this.Gkq.onResume();
    }
    com.tencent.mm.cr.d.bpI("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.Gku.iterator();
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localIterator.next();
      if (localb.Gkd > 0)
      {
        if (localb.category == 110) {
          ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, localb.Gkd, 0L, "");
        }
      }
      else if (localb.Gkc > 0) {
        if (localb.category == 110)
        {
          ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          eiq localeiq = new eiq();
          localeiq.msgId = localb.Gke;
          ar.a(localeiq, 107, 3, 0, 0L, "");
        }
      }
    }
    this.dLD = false;
    this.GkD = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.eel.toByteArray());
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.eel.sGQ });
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
    View Gla;
    FrameLayout Glb;
    ImageView Glc;
    int Gld = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */