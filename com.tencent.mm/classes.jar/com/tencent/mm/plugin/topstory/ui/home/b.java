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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aay;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.PushProcessIPCService;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.e.10;
import com.tencent.mm.plugin.topstory.ui.c.e.16;
import com.tencent.mm.plugin.topstory.ui.c.e.18;
import com.tencent.mm.plugin.topstory.ui.c.e.19;
import com.tencent.mm.plugin.topstory.ui.c.e.2;
import com.tencent.mm.plugin.topstory.ui.c.e.20;
import com.tencent.mm.plugin.topstory.ui.c.e.21;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.threadpool.i;
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
  private int CEY;
  private long ELN;
  protected FrameLayout QQO;
  private List<c> RrK;
  protected MMActivity TJD;
  protected boolean TJE;
  protected com.tencent.mm.plugin.topstory.ui.c.c TJF;
  protected WebSearchWebView TJG;
  protected com.tencent.mm.plugin.topstory.ui.c.e TJH;
  protected View TJI;
  protected View TJJ;
  private View TJK;
  private int TJL;
  boolean TJM;
  private LinearLayout TJN;
  private TopStoryViewPager TJO;
  private View TJP;
  private int TJQ;
  private int TJR;
  private boolean TJS;
  private boolean TJT;
  private boolean TJU;
  private boolean TJV;
  private boolean TJW;
  private boolean TJX;
  protected IListener<aay> TJY;
  protected com.tencent.mm.plugin.topstory.a.d.a TJZ;
  private boolean hJi;
  protected fnt ieC;
  private Context mContext;
  private p oAk;
  protected ThreeDotsLoadingView uiD;
  protected List<com.tencent.mm.plugin.topstory.ui.d.a> yal;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(125955);
    this.yal = new ArrayList();
    this.TJL = 0;
    this.ELN = 0L;
    this.TJM = false;
    this.hJi = false;
    this.RrK = new ArrayList();
    this.CEY = -1;
    this.TJQ = -1;
    this.TJR = 0;
    this.TJS = false;
    this.TJT = false;
    this.TJU = true;
    this.TJY = new TopStoryHomeUIComponentImpl.13(this, com.tencent.mm.app.f.hfK);
    this.TJZ = new com.tencent.mm.plugin.topstory.a.d.a()
    {
      public final void a(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(125932);
        if ((paramAnonymousBoolean) && (b.this.TJH != null)) {
          b.this.TJH.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.yal.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (com.tencent.mm.plugin.topstory.ui.d.a)paramAnonymousString1.next();
          if (g.aoJ(paramAnonymousString3.TJo))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125929);
                paramAnonymousString3.dq(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125929);
              }
            });
            if ((paramAnonymousInt1 > 0) && (!b.l(b.this)))
            {
              as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh(), 107, 2, paramAnonymousString3.TJs, 0L, "");
              AppMethodBeat.o(125932);
              return;
            }
          }
        }
        AppMethodBeat.o(125932);
      }
      
      public final boolean aoI(int paramAnonymousInt)
      {
        AppMethodBeat.i(271769);
        Iterator localIterator = b.this.yal.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
          if ((locala != null) && (paramAnonymousInt == locala.TJo) && (locala.TJr > 0))
          {
            AppMethodBeat.o(271769);
            return true;
          }
        }
        AppMethodBeat.o(271769);
        return false;
      }
      
      public final void b(final int paramAnonymousInt1, String paramAnonymousString1, final String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, final String paramAnonymousString3)
      {
        AppMethodBeat.i(125930);
        if (b.this.TJH != null) {
          b.this.TJH.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3);
        }
        paramAnonymousString1 = b.this.yal.iterator();
        while (paramAnonymousString1.hasNext())
        {
          paramAnonymousString3 = (com.tencent.mm.plugin.topstory.ui.d.a)paramAnonymousString1.next();
          if (g.aoJ(paramAnonymousString3.TJo))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125925);
                paramAnonymousString3.dq(paramAnonymousInt1, paramAnonymousString2);
                AppMethodBeat.o(125925);
              }
            });
            if (!b.l(b.this)) {
              as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh(), 107, 2, paramAnonymousInt1, 0L, "");
            }
          }
        }
        AppMethodBeat.o(125930);
      }
      
      public final void b(fob paramAnonymousfob, int paramAnonymousInt)
      {
        AppMethodBeat.i(271748);
        final String str = paramAnonymousfob.msgId;
        long l = paramAnonymousfob.UGO;
        int i = paramAnonymousfob.type;
        if (b.this.TJH != null) {
          b.this.TJH.t(str, l, i);
        }
        paramAnonymousfob = b.this.yal.iterator();
        while (paramAnonymousfob.hasNext())
        {
          final com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)paramAnonymousfob.next();
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onNewRedDotReceived item.category:%s category:%s", new Object[] { Integer.valueOf(locala.TJo), Integer.valueOf(paramAnonymousInt) });
          if ((g.aoJ(locala.TJo)) && (paramAnonymousInt == 110))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125926);
                locala.dr(1, str);
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMB();
                AppMethodBeat.o(125926);
              }
            });
            if ((!b.l(b.this)) && (locala.TJs <= 0)) {
              as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV(), 107, 1, 0, 0L, "");
            }
          }
          if ((g.aoK(locala.TJo)) && (paramAnonymousInt == 100))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125927);
                locala.dr(1, str);
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMB();
                AppMethodBeat.o(125927);
              }
            });
            if ((!b.l(b.this)) && (locala.TJs <= 0)) {
              as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLZ(), 107, 1, 0, 0L, "");
            }
          }
          if ((g.aoL(locala.TJo)) && (paramAnonymousInt == 666))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(125928);
                locala.dr(1, str);
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMB();
                AppMethodBeat.o(125928);
              }
            });
            if ((!b.l(b.this)) && (locala.TJs <= 0)) {
              as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMc(), 107, 1, 0, 0L, "");
            }
          }
        }
        AppMethodBeat.o(271748);
      }
      
      public final void bK(final String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(125935);
        b.this.TJD.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271727);
            b.a(b.this, paramAnonymousString, paramAnonymousLong);
            AppMethodBeat.o(271727);
          }
        });
        AppMethodBeat.o(125935);
      }
      
      public final void hMD()
      {
        AppMethodBeat.i(271750);
        Iterator localIterator = b.this.yal.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
          if (g.aoJ(locala.TJo))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(271729);
                locala.dr(0, "");
                AppMethodBeat.o(271729);
              }
            });
            AppMethodBeat.o(271750);
            return;
          }
        }
        AppMethodBeat.o(271750);
      }
      
      public final void hME()
      {
        AppMethodBeat.i(271754);
        Iterator localIterator = b.this.yal.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
          if (g.aoK(locala.TJo))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(271731);
                locala.dr(0, "");
                AppMethodBeat.o(271731);
              }
            });
            AppMethodBeat.o(271754);
            return;
          }
        }
        AppMethodBeat.o(271754);
      }
      
      public final void hMF()
      {
        AppMethodBeat.i(271757);
        Iterator localIterator = b.this.yal.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
          if (g.aoL(locala.TJo))
          {
            b.this.TJD.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(271725);
                locala.dr(0, "");
                AppMethodBeat.o(271725);
              }
            });
            AppMethodBeat.o(271757);
            return;
          }
        }
        AppMethodBeat.o(271757);
      }
      
      public final void hv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(271762);
        com.tencent.mm.plugin.topstory.ui.c.e locale;
        JSONObject localJSONObject;
        if (b.this.TJH != null)
        {
          locale = b.this.TJH;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("params", paramAnonymousString);
          localJSONObject.put("reddotType", paramAnonymousInt);
          MMHandlerThread.postToMainThread(new e.2(locale, localJSONObject.toString()));
          AppMethodBeat.o(271762);
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
    this.oAk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(125936);
        try
        {
          MMHandlerThread.postToMainThread(new e.20(b.this.TJH));
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
    this.TJD = paramMMActivity;
    this.TJE = paramBoolean;
    AppMethodBeat.o(125955);
  }
  
  private static Bitmap a(WebSearchWebView paramWebSearchWebView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271774);
    try
    {
      long l = cn.bDw();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      paramWebSearchWebView.drawCanvas(new Canvas(localBitmap));
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (cn.bDw() - l));
      com.tencent.mm.plugin.topstory.a.a.b.hML();
      paramWebSearchWebView = localBitmap;
    }
    finally
    {
      for (;;)
      {
        paramWebSearchWebView = null;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.hML();
      }
    }
    AppMethodBeat.o(271774);
    return paramWebSearchWebView;
  }
  
  private void ahu(int paramInt)
  {
    AppMethodBeat.i(271777);
    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "setMaxCacheItemCountLimit = ".concat(String.valueOf(paramInt)));
    if (paramInt == 50)
    {
      XIPCInvoker.a(PushProcessIPCService.PROCESS_NAME, new IPCString(""), b.class, new com.tencent.mm.ipcinvoker.f() {});
      AppMethodBeat.o(271777);
      return;
    }
    XIPCInvoker.a(PushProcessIPCService.PROCESS_NAME, new IPCString(""), a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(271777);
  }
  
  private void aoO(int paramInt)
  {
    AppMethodBeat.i(271767);
    Iterator localIterator = this.yal.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
      if ((localObject != null) && (((com.tencent.mm.plugin.topstory.ui.d.a)localObject).titleTv != null))
      {
        localObject = ((com.tencent.mm.plugin.topstory.ui.d.a)localObject).titleTv;
        if (paramInt != i) {
          break label82;
        }
      }
      label82:
      for (int j = 1;; j = 0)
      {
        ((TextView)localObject).setTypeface(null, j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(271767);
  }
  
  private void bM(String paramString, long paramLong)
  {
    AppMethodBeat.i(125975);
    this.TJK.setVisibility(0);
    fob localfob = new fob();
    localfob.msgId = paramString;
    localfob.UGO = paramLong;
    as.a(localfob, 107, 5, 0, 0L, "");
    AppMethodBeat.o(125975);
  }
  
  protected static int getLayoutId()
  {
    return c.e.top_story_home_ui;
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.c.c paramc, WebSearchWebView paramWebSearchWebView, com.tencent.mm.plugin.topstory.ui.c.e parame, fnt paramfnt)
  {
    AppMethodBeat.i(271822);
    this.TJF = paramc;
    this.TJG = paramWebSearchWebView;
    this.TJH = parame;
    this.TJH.WrO = this;
    this.ieC = paramfnt;
    paramc = this.TJF;
    paramc.WrK = this;
    com.tencent.mm.kernel.h.aZW().a(2582, paramc.TPO);
    com.tencent.mm.kernel.h.aZW().a(2802, paramc.TMy);
    com.tencent.mm.kernel.h.aZW().a(2906, paramc.TPN);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.QQO.addView(this.TJG, paramc);
    this.TJG.setOverScrollMode(0);
    AppMethodBeat.o(271822);
  }
  
  public final boolean aoP(int paramInt)
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
  
  public final void bX(int paramInt, final boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject4;
      final int j;
      final c localc;
      final com.tencent.mm.plugin.topstory.ui.d.a locala;
      try
      {
        AppMethodBeat.i(125978);
        localObject4 = new StringBuilder("changeView, from ");
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = "viewpager";
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1 + ", mLastPos =" + this.TJQ + ", pos = " + paramInt + ", curpos = " + this.CEY);
          if (paramInt == this.CEY)
          {
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(125978);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
        }
        if (this.TJQ == -1)
        {
          if (paramInt == 0) {
            this.TJQ = 1;
          }
        }
        else
        {
          j = this.TJQ;
          this.CEY = paramInt;
          this.TJQ = paramInt;
          localc = (c)this.RrK.get(j);
          if (this.TJP.getParent() != ((c)this.RrK.get(j)).TKs) {
            break label473;
          }
          if (localc.TKu > 0) {
            break label451;
          }
          i = 1;
          localc.TKu = 2;
          locala = (com.tencent.mm.plugin.topstory.ui.d.a)this.yal.get(this.CEY);
          this.TJU = false;
          localObject4 = "";
          localObject1 = localObject4;
          if (g.aoK(locala.TJo))
          {
            localObject1 = localObject4;
            if (locala.TJr > 0) {
              localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMo();
            }
          }
          localObject4 = localObject1;
          if (g.aoL(locala.TJo))
          {
            localObject4 = localObject1;
            if (locala.TJr > 0) {
              localObject4 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMa();
            }
          }
          if (i == 0) {
            break label485;
          }
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(125938);
              final Bitmap localBitmap = b.b(b.this.TJG, localc.TKs.getWidth(), localc.TKs.getHeight());
              b.this.TJD.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125937);
                  if (localBitmap != null) {
                    b.7.this.TKi.TKt.setImageBitmap(localBitmap);
                  }
                  for (;;)
                  {
                    b.7.this.TKi.TKt.setVisibility(0);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(b.7.this.TKi.TKs.getWidth()), Integer.valueOf(b.7.this.TKi.TKs.getHeight()), Integer.valueOf(b.7.this.TKi.TKt.getWidth()), Integer.valueOf(b.7.this.TKi.TKt.getHeight()) });
                    if (b.this.TJG != null) {
                      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "topStoryWebView %s,%s", new Object[] { Integer.valueOf(b.this.TJG.getWidth()), Integer.valueOf(b.this.TJG.getHeight()) });
                    }
                    if (b.m(b.this).getParent() != null)
                    {
                      ((ViewGroup)b.m(b.this).getParent()).removeView(b.m(b.this));
                      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + b.7.this.TKj);
                    }
                    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ((b.c)b.g(b.this).get(b.i(b.this))).TKs.addView(b.m(b.this), localLayoutParams);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.i(b.this));
                    b.this.TJH.b(b.7.this.TKk.TJq, b.7.this.TKk.TJr, b.7.this.TKk.TJs, b.7.this.TKl, b.7.this.TKm);
                    AppMethodBeat.o(125937);
                    return;
                    b.7.this.TKi.TKt.setImageDrawable(b.this.TJD.getResources().getDrawable(c.a.BG_0));
                    b.7.this.TKi.TKu = 0;
                  }
                }
              });
              AppMethodBeat.o(125938);
            }
          }, "CaptureWebViewTask");
          if (!Util.isNullOrNil(locala.TJu)) {
            break label620;
          }
          localObject1 = locala.TJt;
          as.a(locala.TJo, this.TJL, (String)localObject1, this.ieC.mpa, paramBoolean);
          aoO(paramInt);
          AppMethodBeat.o(125978);
          continue;
        }
        if (paramInt != 1) {
          break label438;
        }
      }
      finally {}
      this.TJQ = 0;
      continue;
      label438:
      if (paramInt == 2)
      {
        this.TJQ = 1;
        continue;
        label451:
        localc.TKt.setVisibility(0);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        i = 0;
        continue;
        label473:
        localc.TKt.setVisibility(0);
        continue;
        label485:
        if (this.TJP.getParent() != null)
        {
          ((ViewGroup)this.TJP.getParent()).removeView(this.TJP);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(j)));
        }
        Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
        ((c)this.RrK.get(this.CEY)).TKs.addView(this.TJP, (ViewGroup.LayoutParams)localObject3);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.CEY);
        this.TJH.b(locala.TJq, locala.TJr, locala.TJs, (String)localObject4, paramBoolean);
        continue;
        label620:
        localObject3 = locala.TJu;
      }
    }
  }
  
  public final void bev(String paramString)
  {
    AppMethodBeat.i(125968);
    Iterator localIterator = this.RrK.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.TKt != null)
      {
        localc.TKu = 0;
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.TJX = true;
    this.TJH.bev(paramString);
    AppMethodBeat.o(125968);
  }
  
  public final void bew(String paramString)
  {
    AppMethodBeat.i(125969);
    MMHandlerThread.postToMainThread(new e.16(this.TJH, paramString));
    AppMethodBeat.o(125969);
  }
  
  public final void bex(String paramString)
  {
    AppMethodBeat.i(125970);
    MMHandlerThread.postToMainThread(new e.19(this.TJH, paramString));
    AppMethodBeat.o(125970);
  }
  
  public final void bey(String paramString)
  {
    AppMethodBeat.i(125971);
    MMHandlerThread.postToMainThread(new e.18(this.TJH, paramString));
    AppMethodBeat.o(125971);
  }
  
  public final MMActivity fWt()
  {
    return this.TJD;
  }
  
  public final Context getActivityContext()
  {
    return this.TJD;
  }
  
  public WebSearchWebView getWebView()
  {
    return this.TJG;
  }
  
  public final void hNc()
  {
    this.TJV = true;
  }
  
  public final void hNd()
  {
    AppMethodBeat.i(125967);
    this.TJW = true;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125920);
        b.this.uiD.jFf();
        b.this.TJI.setVisibility(8);
        b.this.TJG.setVisibility(0);
        AppMethodBeat.o(125920);
      }
    });
    AppMethodBeat.o(125967);
  }
  
  public final void hNe()
  {
    AppMethodBeat.i(125973);
    this.TJD.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125923);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
        b.this.TJJ.setVisibility(8);
        b.a(b.this, false);
        AppMethodBeat.o(125923);
      }
    });
    AppMethodBeat.o(125973);
  }
  
  public final void hNf()
  {
    AppMethodBeat.i(125959);
    if ((this.TJU) && (this.RrK.size() > 0))
    {
      final int i = this.CEY;
      this.TJO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125954);
          if (i == b.i(b.this))
          {
            ((b.c)b.g(b.this).get(b.i(b.this))).TKt.setVisibility(8);
            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.i(b.this));
          }
          AppMethodBeat.o(125954);
        }
      }, 100L);
      AppMethodBeat.o(125959);
      return;
    }
    this.TJU = true;
    AppMethodBeat.o(125959);
  }
  
  public final int hNg()
  {
    return this.TJR;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.c.c hNh()
  {
    return this.TJF;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.c.e hNi()
  {
    return this.TJH;
  }
  
  final void hNj()
  {
    AppMethodBeat.i(125962);
    if (this.TJH != null)
    {
      this.TJH.hOY();
      hNe();
    }
    AppMethodBeat.o(125962);
  }
  
  protected boolean hNk()
  {
    return true;
  }
  
  public final void hideVKB() {}
  
  public final void mn(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(125972);
    this.TJD.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125922);
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        int i = paramInt1;
        int j = paramInt2;
        b.this.TJJ.setBackgroundColor(i + 16777216 * j);
        b.this.TJJ.setVisibility(0);
        b.a(b.this, true);
        b.this.TJJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(125921);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            b.k(b.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125921);
          }
        });
        AppMethodBeat.o(125922);
      }
    });
    AppMethodBeat.o(125972);
  }
  
  public final void mo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125958);
    as.u("", 0, 0, paramInt1);
    String str = aj.asV(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.ieC.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.Yxf, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(q.aPo(), "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.TJD.getString(c.g.top_story_assistor), "utf8"));
      com.tencent.mm.kernel.h.baC();
      localHashMap.put("uin", com.tencent.mm.kernel.b.aZs());
      localHashMap.put("timeZone", URLEncoder.encode(Util.getTimeZoneOffset(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.Yxc);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMv());
      localHashMap.put("needCameraIcon", "0");
      label239:
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(this.TJD, paramInt1, "", str, localHashMap, this.TJD.getResources().getString(c.g.top_story_home_tab_me), this.TJD.getResources().getColor(c.a.BW_93));
      AppMethodBeat.o(125958);
      return;
    }
    catch (Exception localException)
    {
      break label239;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125979);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("key_video_play_info");
      paramIntent = paramIntent.getStringExtra("key_search_id");
      com.tencent.mm.plugin.topstory.ui.c.e locale = this.TJH;
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
    if (this.TJM)
    {
      hNj();
      AppMethodBeat.o(125961);
      return;
    }
    if (this.TJW) {
      com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiBackBtnClick", cn.bDw());
    }
    for (;;)
    {
      as.atf(19);
      if (!this.TJE) {
        break;
      }
      this.TJD.finish();
      AppMethodBeat.o(125961);
      return;
      if (this.TJV)
      {
        if (this.TJX) {
          com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiBackBtnClickWithoutH5Ready", cn.bDw());
        } else {
          com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiBackBtnClickWithoutDataReady", cn.bDw());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiBackBtnClickWithoutGetSearchData", cn.bDw());
      }
    }
    this.TJD.moveTaskToBack(true);
    AppMethodBeat.o(125961);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125956);
    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    ahu(50);
    this.mContext = this.TJD;
    this.TJD.getSupportActionBar().hide();
    this.TJT = aj.ipP();
    this.ieC = new fnt();
    Object localObject2;
    Object localObject3;
    int i;
    try
    {
      this.ieC.parseFrom(this.TJD.getIntent().getByteArrayExtra("key_context"));
      if (!Util.isNullOrNil(this.ieC.zIO))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.ieC.zIO });
        paramBundle = this.TJD.getIntent().getStringExtra("key_tabconfig");
        this.yal = com.tencent.mm.plugin.topstory.ui.d.bet(paramBundle);
        if (!this.yal.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.TJZ);
        }
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext tabConfig = %s, tabItems size = %s, isSupportVideoTab = %s", new Object[] { paramBundle, Integer.valueOf(this.yal.size()), Boolean.valueOf(this.TJT) });
        this.TJY.alive();
        com.tencent.mm.kernel.h.baD().a(this.oAk);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.b.a()
        {
          public final void bes(String paramAnonymousString)
          {
            AppMethodBeat.i(125919);
            com.tencent.mm.plugin.topstory.ui.c.e locale;
            JSONObject localJSONObject;
            if (b.this.TJH != null)
            {
              locale = b.this.TJH;
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("params", paramAnonymousString);
              MMHandlerThread.postToMainThread(new e.21(locale, localJSONObject.toString()));
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
        as.atf(17);
        this.TJP = LayoutInflater.from(this.TJD).inflate(c.e.top_story_home_webview_container, null);
        this.QQO = ((FrameLayout)this.TJP.findViewById(c.d.webview_container));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label703;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().JjV) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.ieC, true, null);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().n(this);
        this.TJI = this.TJP.findViewById(c.d.splash_view);
        this.uiD = ((ThreeDotsLoadingView)this.TJP.findViewById(c.d.loading_view));
        if ((Build.VERSION.SDK_INT >= 21) && (!MIUI.isMIUIV8()) && (!aw.isDarkMode())) {
          this.TJD.supportLightStatusBar();
        }
        localObject2 = (TextView)this.TJD.findViewById(c.d.text1);
        localObject3 = this.TJD.findViewById(c.d.actionbar_up_indicator);
        View localView = this.TJD.findViewById(c.d.top_story_profile_action_option_icon);
        this.TJK = this.TJD.findViewById(c.d.iv_tab_usr_red);
        paramBundle = this.TJD.findViewById(c.d.top_story_home_actionbar);
        this.TJJ = this.TJD.findViewById(c.d.top_story_actionbar_mask);
        this.TJO = ((TopStoryViewPager)this.TJD.findViewById(c.d.top_story_home_viewpager));
        this.TJN = ((LinearLayout)this.TJD.findViewById(c.d.top_story_home_ui_root));
        if (this.yal.isEmpty()) {
          break label2068;
        }
        j = this.TJD.getIntent().getIntExtra("key_chosetab", 0);
        localTabLayout = (TabLayout)this.TJD.findViewById(c.d.tabLayout);
        paramBundle = this.yal.iterator();
        i = 0;
        while (paramBundle.hasNext())
        {
          paramBundle.next();
          if ((this.TJT) || (!g.aoL(666))) {
            i += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      int j;
      final TabLayout localTabLayout;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.ieC.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.TJD.finish();
          continue;
          label703:
          paramBundle = new d();
          paramBundle.a(this.ieC, true, null);
          paramBundle.n(this);
        }
      }
      Object localObject4 = this.yal.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)((Iterator)localObject4).next();
        if ((this.TJT) || (!g.aoL(666)))
        {
          locala.dyQ = localTabLayout.WW();
          locala.dyQ.jw(c.e.top_story_home_ui_tabitem);
          locala.yao = locala.dyQ.dyK.findViewById(c.d.top_story_home_ui_tabitem_container);
          locala.titleTv = ((TextView)locala.dyQ.dyK.findViewById(c.d.tv_tab_title));
          locala.TJv = ((TextView)locala.dyQ.dyK.findViewById(c.d.tv_tab_red));
          locala.TJw = locala.dyQ.dyK.findViewById(c.d.red_dot_container);
          locala.TJx = locala.dyQ.dyK.findViewById(c.d.iv_tab_red);
          locala.titleTv.setText(locala.wording);
          if (i == 2)
          {
            locala.yao.setPadding((int)this.mContext.getResources().getDimension(c.b.top_story_2tab_padding), locala.yao.getPaddingTop(), (int)this.mContext.getResources().getDimension(c.b.top_story_2tab_padding), locala.yao.getPaddingBottom());
            label971:
            if (com.tencent.mm.ui.a.jhB()) {
              break label1142;
            }
            com.tencent.mm.ui.a.v(locala.titleTv, c.b.GroupTitleTextSize);
            com.tencent.mm.ui.a.v(locala.TJv, c.b.SmallerTextSize);
            label999:
            if (locala.TJs <= 0) {
              break label1217;
            }
            paramBundle = locala.TJs;
            if (locala.TJs > 99) {
              paramBundle = "99+";
            }
            locala.TJv.setText(paramBundle);
            locala.TJv.setVisibility(0);
            locala.TJx.setVisibility(8);
          }
          for (;;)
          {
            localTabLayout.a(locala.dyQ, false);
            com.tencent.mm.plugin.topstory.ui.d.a.a(locala);
            break;
            locala.yao.setPadding((int)this.mContext.getResources().getDimension(c.b.top_story_tab_padding), locala.yao.getPaddingTop(), (int)this.mContext.getResources().getDimension(c.b.top_story_tab_padding), locala.yao.getPaddingBottom());
            break label971;
            label1142:
            com.tencent.mm.ui.a.v(locala.titleTv, c.b.GroupTitleTextSize);
            com.tencent.mm.ui.a.v(locala.TJv, c.b.SmallerTextSize);
            locala.TJx.getLayoutParams().width = ((int)this.TJD.getResources().getDimension(c.b.BottomSheetTitleTextSize));
            locala.TJx.getLayoutParams().height = ((int)this.TJD.getResources().getDimension(c.b.BottomSheetTitleTextSize));
            break label999;
            label1217:
            if (locala.TJr > 0)
            {
              locala.TJv.setText("");
              locala.TJv.setVisibility(8);
              locala.TJx.setVisibility(0);
            }
          }
        }
      }
      localTabLayout.a(new com.google.android.material.tabs.a()
      {
        public final void i(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(271746);
          int i = 0;
          while (i < b.this.yal.size())
          {
            com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)b.this.yal.get(i);
            if (locala.dyQ.equals(paramAnonymouse))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + locala.wording);
              locala.titleTv.setTextColor(b.this.TJD.getResources().getColor(c.a.top_story_home_tab_selected));
              b.this.bX(i, false);
              b.e(b.this).setCurrentItem(i);
              if ((g.aoK(locala.TJo)) && (locala.TJr > 0))
              {
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMp();
                locala.dr(0, "");
              }
              if ((g.aoL(locala.TJo)) && (locala.TJr > 0))
              {
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMb();
                locala.dr(0, "");
              }
              if ((g.aoJ(locala.TJo)) && (locala.TJs <= 0) && (locala.TJr > 0))
              {
                locala.dr(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMs();
              }
              b.aoQ(locala.TJo);
              b.a(b.this, locala.TJo);
              com.tencent.mm.plugin.topstory.ui.d.a.a(locala);
              AppMethodBeat.o(271746);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(271746);
        }
        
        public final void j(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(271749);
          Iterator localIterator = b.this.yal.iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
            if (locala.dyQ.equals(paramAnonymouse))
            {
              b.b(b.this, locala.TJo);
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + locala.wording);
              locala.titleTv.setTextColor(b.this.TJD.getResources().getColor(c.a.top_story_home_tab_unselected));
              AppMethodBeat.o(271749);
              return;
            }
          }
          AppMethodBeat.o(271749);
        }
        
        public final void k(TabLayout.e paramAnonymouse)
        {
          AppMethodBeat.i(271752);
          Object localObject = b.this.yal.iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)((Iterator)localObject).next();
            if (locala.dyQ.equals(paramAnonymouse))
            {
              Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + locala.wording);
              locala.titleTv.setTextColor(b.this.TJD.getResources().getColor(c.a.top_story_home_tab_selected));
              localObject = "";
              paramAnonymouse = (TabLayout.e)localObject;
              if (g.aoK(locala.TJo))
              {
                paramAnonymouse = (TabLayout.e)localObject;
                if (locala.TJr > 0) {
                  paramAnonymouse = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMo();
                }
              }
              b.this.TJH.b(locala.TJq, locala.TJr, locala.TJs, paramAnonymouse, false);
              if ((g.aoK(locala.TJo)) && (locala.TJr > 0))
              {
                locala.dr(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMp();
              }
              if ((g.aoL(locala.TJo)) && (locala.TJr > 0))
              {
                locala.dr(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMb();
              }
              if ((g.aoJ(locala.TJo)) && (locala.TJs <= 0) && (locala.TJr > 0))
              {
                locala.dr(0, "");
                ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMs();
              }
              if (Util.isNullOrNil(locala.TJu)) {}
              for (paramAnonymouse = locala.TJt;; paramAnonymouse = locala.TJu)
              {
                as.a(locala.TJo, b.f(b.this), paramAnonymouse, b.this.ieC.mpa, false);
                b.a(b.this, locala.TJo);
                AppMethodBeat.o(271752);
                return;
              }
            }
          }
          AppMethodBeat.o(271752);
        }
      });
      this.TJO.setVisibility(0);
      i = 0;
      while (i < this.yal.size())
      {
        paramBundle = new c();
        paramBundle.TKr = LayoutInflater.from(this.TJD).inflate(c.e.top_story_home_fake_item, null);
        paramBundle.TKt = ((ImageView)paramBundle.TKr.findViewById(c.d.fake_iv));
        paramBundle.TKs = ((FrameLayout)paramBundle.TKr.findViewById(c.d.fake_layout));
        this.RrK.add(paramBundle);
        i += 1;
      }
      this.TJO.setAdapter(new androidx.viewpager.widget.a()
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
          int i = b.this.yal.size();
          AppMethodBeat.o(125947);
          return i;
        }
        
        public final Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(125948);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((b.c)b.g(b.this).get(paramAnonymousInt)).TKr.hashCode()) });
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          paramAnonymousViewGroup.addView(((b.c)b.g(b.this).get(paramAnonymousInt)).TKr, localLayoutParams);
          paramAnonymousViewGroup = ((b.c)b.g(b.this).get(paramAnonymousInt)).TKr;
          AppMethodBeat.o(125948);
          return paramAnonymousViewGroup;
        }
        
        public final boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == paramAnonymousObject;
        }
      });
      this.TJO.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(final int paramAnonymousInt)
        {
          AppMethodBeat.i(125952);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0)
          {
            if (b.h(b.this))
            {
              paramAnonymousInt = b.i(b.this);
              b.e(b.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(125950);
                  if (paramAnonymousInt == b.i(b.this))
                  {
                    ((b.c)b.g(b.this).get(b.i(b.this))).TKt.setVisibility(8);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.i(b.this));
                  }
                  AppMethodBeat.o(125950);
                }
              }, 100L);
              AppMethodBeat.o(125952);
              return;
            }
            b.j(b.this);
          }
          AppMethodBeat.o(125952);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(125951);
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramAnonymousInt)));
          b.this.bX(paramAnonymousInt, true);
          if (!localTabLayout.js(paramAnonymousInt).isSelected()) {
            localTabLayout.js(paramAnonymousInt).Xf();
          }
          AppMethodBeat.o(125951);
        }
      });
      this.TJG.afUt = new MMWebView.f()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(125953);
          b.c localc = (b.c)b.g(b.this).get(b.i(b.this));
          localc.TKu -= 1;
          AppMethodBeat.o(125953);
        }
      };
      paramBundle = this.yal.iterator();
      while (paramBundle.hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.topstory.ui.d.a)paramBundle.next();
        if (((com.tencent.mm.plugin.topstory.ui.d.a)localObject4).TJo == j)
        {
          Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "select category %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.topstory.ui.d.a)localObject4).TJo) });
          ((com.tencent.mm.plugin.topstory.ui.d.a)localObject4).dyQ.Xf();
          ((c)this.RrK.get(((com.tencent.mm.plugin.topstory.ui.d.a)localObject4).dyQ.position)).TKt.setVisibility(8);
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.js(0).Xf();
      }
      ((TextView)localObject2).setText("");
    }
    ((View)localObject3).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.this.onBackBtnClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125942);
      }
    });
    paramBundle = (ImageView)this.TJD.findViewById(c.d.actionbar_up_indicator_btn);
    paramBundle.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    paramBundle.setContentDescription(paramBundle.getResources().getString(c.g.actionbar_back_btn));
    this.uiD.jFe();
    if (hNk())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMt();
      if (Util.isNullOrNil(paramBundle))
      {
        this.TJK.setVisibility(8);
        label1649:
        localException.setVisibility(0);
        localException.setContentDescription(this.TJD.getString(c.g.top_story_home_tab_me));
        localException.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125943);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (b.b(b.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125943);
              return;
            }
            b.c(b.this);
            com.tencent.mm.plugin.topstory.ui.d.a(b.this.fWt(), b.this.ieC);
            com.tencent.mm.plugin.report.f.Ozc.b(15449, new Object[] { Integer.valueOf(0) });
            if (b.d(b.this).getVisibility() == 0)
            {
              b.d(b.this).setVisibility(8);
              paramAnonymousView = new fob();
              paramAnonymousView.msgId = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMt();
              paramAnonymousView.UGO = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMu();
              as.a(paramAnonymousView, 106, 5, 0, cn.bDw() / 1000L, "");
              ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMw();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125943);
          }
        });
        label1683:
        if (this.ieC.GRg != 0)
        {
          paramBundle = this.TJD.findViewById(c.d.action_bar_root);
          i = this.ieC.GRg;
          if ((Color.red(i) <= 200) || (Color.blue(i) <= 200) || (Color.green(i) <= 200)) {
            break label2162;
          }
          i = 1;
          label1744:
          if (i == 0) {
            break label2167;
          }
          paramBundle.setBackgroundColor(this.TJD.getResources().getColor(c.a.white));
          this.TJD.setActionbarColor(this.TJD.getResources().getColor(c.a.white));
        }
      }
    }
    for (;;)
    {
      this.TJG.setWebViewCallbackClient(new com.tencent.mm.plugin.websearch.webview.h(this.TJO, this.TJG));
      Object localObject1;
      if (this.ieC.scene == 54)
      {
        paramBundle = this.TJD.getIntent().getBundleExtra("key_extra_data");
        if (paramBundle != null)
        {
          localObject1 = new e.a(this.TJD);
          ((e.a)localObject1).b(com.tencent.mm.compatible.f.a.decodeResource(this.TJD.getResources(), c.f.dialog_successful_icon), false, 3);
          ((e.a)localObject1).NC(false);
          ((e.a)localObject1).ND(false);
          ((e.a)localObject1).bDz(this.TJD.getString(c.g.confirm_dialog_sent)).aEQ(17);
          localObject1 = ((e.a)localObject1).jHH();
          localObject2 = paramBundle.getString("_openbusinessview_app_name", "");
          localObject3 = paramBundle.getString("_openbusinessview_package_name", "");
          ((com.tencent.mm.ui.widget.a.e)localObject1).b(this.TJD.getString(c.g.confirm_dialog_back_app, new Object[] { localObject2 }), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125939);
              com.tencent.mm.plugin.report.f.Ozc.b(17080, new Object[] { Integer.valueOf(43), Integer.valueOf(1) });
              paramAnonymousDialogInterface = new WXOpenBusinessView.Resp(paramBundle);
              n.a(paramBundle, paramAnonymousDialogInterface, this.ryL);
              AppMethodBeat.o(125939);
            }
          });
          ((com.tencent.mm.ui.widget.a.e)localObject1).a(this.TJD.getString(c.g.confirm_dialog_stay_in_weixin), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125940);
              com.tencent.mm.plugin.report.f.Ozc.b(17080, new Object[] { Integer.valueOf(44), Integer.valueOf(1) });
              AppMethodBeat.o(125940);
            }
          });
          ((com.tencent.mm.ui.widget.a.e)localObject1).ayj(this.TJD.getResources().getColor(c.a.brand_text_color));
          ((com.tencent.mm.ui.widget.a.e)localObject1).show();
          com.tencent.mm.plugin.report.f.Ozc.b(17080, new Object[] { Integer.valueOf(42), Integer.valueOf(1) });
        }
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, "uiOnCreate", cn.bDw());
      AppMethodBeat.o(125956);
      return;
      label2068:
      this.TJO.setVisibility(8);
      this.TJN.addView(this.TJP, -1, -1);
      ((TextView)localObject2).setText(this.ieC.tgw);
      ((TextView)localObject2).setTextColor(-16777216);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          long l = cn.bDw();
          if (l - b.a(b.this) < 300L) {}
          try
          {
            if ((b.this.TJG != null) && (b.this.TJG.getView() != null)) {
              b.this.TJG.getView().scrollTo(b.this.TJG.getView().getScrollX(), 0);
            }
            label107:
            b.a(b.this, l);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125941);
            return;
          }
          finally
          {
            break label107;
          }
        }
      });
      break;
      bM(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMu());
      break label1649;
      ((View)localObject1).setVisibility(8);
      break label1683;
      label2162:
      i = 0;
      break label1744;
      label2167:
      paramBundle.setBackgroundColor(this.ieC.GRg);
      this.TJD.setActionbarColor(this.ieC.GRg);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(125965);
    this.TJG.afUt = null;
    try
    {
      if ((g.aoK(this.ieC.channelId)) && (this.TJH != null)) {
        com.tencent.mm.plugin.topstory.ui.c.a.a(this.TJH, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.TJG.getParent() != null) && (this.TJG.getParent().equals(this.QQO)))
      {
        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.QQO.removeView(this.TJG);
      }
    }
    catch (Exception localException)
    {
      label93:
      Object localObject;
      long l;
      break label93;
    }
    if (this.TJG != null)
    {
      this.TJG.removeJavascriptInterface("topStoryJSApi");
      this.TJG.setWebChromeClient(null);
      this.TJG.setWebViewClient(null);
      this.TJG.destroy();
    }
    localObject = this.ieC;
    l = this.TJD.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((fnt)localObject).scene), Long.valueOf(l), Integer.valueOf(((fnt)localObject).channelId), Integer.valueOf(((fnt)localObject).tBy) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiOnDestroy", cn.bDw());
    as.atf(18);
    localObject = this.TJF;
    Log.i("MicroMsg.TopStory.TopStoryWebData", "onUIDestroy");
    ((com.tencent.mm.plugin.websearch.webview.a)localObject).WrK = null;
    ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TPK.clear();
    ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TPJ.clear();
    ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TPL.clear();
    com.tencent.mm.kernel.h.aZW().b(1943, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.aZW().b(2582, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TPO);
    com.tencent.mm.kernel.h.aZW().b(2802, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TMy);
    com.tencent.mm.kernel.h.aZW().b(2906, ((com.tencent.mm.plugin.topstory.ui.c.c)localObject).TPN);
    this.TJY.dead();
    com.tencent.mm.kernel.h.baD().b(this.oAk);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.TJZ);
    ahu(-1);
    AppMethodBeat.o(125965);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125966);
    fnt localfnt = new fnt();
    try
    {
      localfnt.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.ieC.sessionId = localfnt.sessionId;
      this.ieC.hVn = localfnt.hVn;
      this.ieC.scene = localfnt.scene;
      this.ieC.hOG = localfnt.hOG;
      this.ieC.GtP = aj.gtA();
      com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiOnNewIntent", cn.bDw());
      as.atf(20);
      this.TJH.beE("onNewIntent");
      AppMethodBeat.o(125966);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.TJD.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(125964);
    com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiOnPause", cn.bDw());
    this.TJH.beE("onPause");
    if (this.TJG != null) {
      this.TJG.onPause();
    }
    this.hJi = true;
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class) != null)
    {
      int i = this.TJL;
      if (this.TJL == 0) {
        i = com.tencent.mm.plugin.topstory.ui.d.hMY();
      }
      if (g.aoK(i))
      {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class)).f(104, false, false);
        AppMethodBeat.o(125964);
        return;
      }
      if (g.aoJ(i)) {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class)).f(103, false, false);
      }
    }
    AppMethodBeat.o(125964);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(125963);
    com.tencent.mm.plugin.topstory.a.h.a(this.ieC, "uiOnResume", cn.bDw());
    this.TJH.beE("onResume");
    if (this.TJG != null) {
      this.TJG.onResume();
    }
    com.tencent.mm.xwebutil.c.jQG();
    Iterator localIterator = this.yal.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.ui.d.a locala = (com.tencent.mm.plugin.topstory.ui.d.a)localIterator.next();
      if (locala.TJs > 0)
      {
        if (g.aoJ(locala.TJo)) {
          as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh(), 107, 2, locala.TJs, 0L, "");
        }
      }
      else if (locala.TJr > 0) {
        if (g.aoJ(locala.TJo))
        {
          as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV(), 107, 1, 0, 0L, "");
        }
        else if (g.aoK(locala.TJo))
        {
          fob localfob = new fob();
          localfob.msgId = locala.TJt;
          as.a(localfob, 107, 3, 0, 0L, "");
        }
      }
    }
    this.hJi = false;
    this.TJS = false;
    AppMethodBeat.o(125963);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125976);
    try
    {
      paramBundle.putByteArray("key_context", this.ieC.toByteArray());
      Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.ieC.zIO });
      AppMethodBeat.o(125976);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(125976);
    }
  }
  
  public final void showVKB() {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements com.tencent.mm.ipcinvoker.c<IPCString, IPCString>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class b
    implements com.tencent.mm.ipcinvoker.c<IPCString, IPCString>
  {}
  
  static final class c
  {
    View TKr;
    FrameLayout TKs;
    ImageView TKt;
    int TKu = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */