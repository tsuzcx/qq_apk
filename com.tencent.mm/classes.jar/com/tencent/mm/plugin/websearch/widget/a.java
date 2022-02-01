package com.tencent.mm.plugin.websearch.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.f.b.a.qi;
import com.tencent.mm.f.b.a.ql;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a
  implements com.tencent.mm.plugin.websearch.api.d
{
  private static u PBU;
  private HashMap<String, Object> PBJ;
  private HashMap<String, Object> PBK;
  private HashMap<String, Object> PBL;
  private Map<String, String> PBM;
  private int PBN;
  private g PBO;
  private Map<String, e> PBP;
  private Map<String, d> PBQ;
  private Map<String, WidgetData> PBR;
  public boolean PBS;
  private com.tencent.mm.plugin.websearch.api.n PBT;
  private WidgetData PBV;
  private Runnable PBW;
  private String PBX;
  private volatile String PBY;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    PBU = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.PBJ = new HashMap();
    this.PBK = new HashMap();
    this.PBL = new HashMap();
    this.PBM = new HashMap();
    this.PBN = -1;
    this.PBP = new HashMap();
    this.PBQ = new HashMap();
    this.PBR = new HashMap();
    this.PBS = true;
    this.PBY = null;
    this.context = paramContext;
    this.PBT = paramn;
    this.PBO = ((g)com.tencent.mm.kernel.h.ae(g.class));
    if ((this.PBS) && (new q(com.tencent.mm.loader.j.b.aSL(), "websearch-widget-not-use-tools").ifE())) {
      this.PBS = false;
    }
    if (MMApplicationContext.isMMProcess()) {
      j.b(SupportProcessIPCService.PROCESS_NAME, new com.tencent.mm.ipcinvoker.p()
      {
        public final void aFw()
        {
          AppMethodBeat.i(116577);
          if (SupportProcessIPCService.PROCESS_NAME.equals(a.a(a.this)))
          {
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "support process dead", new Object[0]);
            if (a.b(a.this) != null)
            {
              jw localjw = new jw().AS(a.b(a.this).PzY.lyD);
              localjw.gyo = a.b(a.this).PzY.serviceType;
              localjw.gLX = 21L;
              localjw.gLY = System.currentTimeMillis();
              localjw.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
              v.rE(30);
              paramn.gQu();
            }
          }
          AppMethodBeat.o(116577);
        }
      });
    }
    AppMethodBeat.o(116608);
  }
  
  private void a(final View paramView1, final View paramView2, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final String paramString)
  {
    AppMethodBeat.i(116620);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116602);
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        if ((paramInt1 == paramInt2) && (paramInt3 == paramInt4))
        {
          AppMethodBeat.o(116602);
          return;
        }
        final ViewGroup.LayoutParams localLayoutParams1 = paramView1.getLayoutParams();
        final ViewGroup.LayoutParams localLayoutParams2 = paramView2.getLayoutParams();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
        localValueAnimator.setDuration(300L);
        localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(116600);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            localLayoutParams1.height = i;
            a.8.this.PCu.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.PCv.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.ohW, a.8.this.PCu);
            AppMethodBeat.o(116601);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationStart(Animator paramAnonymous2Animator) {}
        });
        localValueAnimator.start();
        AppMethodBeat.o(116602);
      }
    });
    AppMethodBeat.o(116620);
  }
  
  private void bje(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.PBR.get(paramString);
      Object localObject2 = (d)this.PBQ.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new jw().AS(((WidgetData)localObject1).PzY.lyD);
        ((jw)localObject2).gyo = ((WidgetData)localObject1).PzY.serviceType;
        ((jw)localObject2).gLX = 24L;
        localObject1 = ((jw)localObject2).AR(paramString);
        ((jw)localObject1).gLY = System.currentTimeMillis();
        ((jw)localObject1).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
      }
      localObject1 = (View)this.PBJ.get(paramString);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.PBO != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.PBO.a((String)localObject2, (View)localObject1);
      }
      this.PBJ.remove(paramString);
      this.PBL.remove(paramString);
      localObject1 = (View)this.PBK.get(paramString);
      if (localObject1 != null)
      {
        this.PBT.removeView((View)localObject1);
        this.PBK.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u gRJ()
  {
    return PBU;
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString)
  {
    AppMethodBeat.i(116615);
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116597);
            View localView1 = (View)a.i(a.this).get(paramString);
            View localView2 = (View)a.j(a.this).get(paramString);
            if (localView1 != null)
            {
              Object localObject = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
              int i = ((AbsoluteLayout.LayoutParams)localObject).height;
              int j = as.Dj(paramWidgetData.PzZ.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = as.Dj(paramWidgetData.PzZ.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = as.Dj(paramWidgetData.PzZ.oYQ);
                ((AbsoluteLayout.LayoutParams)localObject).y = as.Dj(paramWidgetData.PzZ.oYR);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.PzZ.fWq)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = as.Dj(paramWidgetData.PzZ.oYQ);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = as.Dj(paramWidgetData.PzZ.oYR);
                  localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
                }
              }
              localView1.setVisibility(8);
              localView2.setVisibility(8);
            }
            AppMethodBeat.o(116597);
          }
        });
      }
      AppMethodBeat.o(116615);
      return;
    }
    catch (Exception paramWidgetData)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
      AppMethodBeat.o(116615);
    }
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(116610);
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.cj.a.hrl()), Float.valueOf(com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    s.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.PzY == null) || (paramWidgetData.PzZ == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.gRK();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.PzY.lyD });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).gM(a.2.this.PCc, 3);
              AppMethodBeat.o(116578);
            }
          });
          AppMethodBeat.o(116591);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116590);
            a.a(a.this, a.2.this.PCb);
            a.d(a.this).put(a.2.this.PCc, a.2.this.PCb);
            v.rE(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.PCb.PzY.serviceType), a.2.this.PCc, str1, a.2.this.PCb.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.PCc);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.PCc, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.gRK();
                  d.b(a.2.this.PCb);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.PCc);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.PCc, localObject2);
                  }
                  ((a.e)localObject2).PCA = ((int)a.2.this.PCb.PzZ.PAi);
                  ((a.e)localObject2).PAj = a.2.this.PCb.PzZ.PAj;
                  Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.gRJ();
                  u.SQ(a.2.this.PCb.PzY.lyD);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)l.ep(a.2.this.PCb.PzY.fve).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.gRJ();
                      u.bhb();
                    }
                    localObject2 = new jw().AS(a.2.this.PCb.PzY.lyD);
                    if (bool1)
                    {
                      l = 1L;
                      ((jw)localObject2).gMa = l;
                      ((jw)localObject2).gyo = a.2.this.PCb.PzY.serviceType;
                      ((jw)localObject2).gLX = 1L;
                      localObject2 = ((jw)localObject2).AR(a.2.this.PCc);
                      ((jw)localObject2).gLY = System.currentTimeMillis();
                      ((jw)localObject2).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
                      localObject2 = a.h(a.this).cR(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.ad.kS(a.g(a.this)).inflate(com.tencent.mm.plugin.websearch.a.e.fts_widget_layout, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, as.Dj(a.2.this.PCb.PzZ.oYQ), as.Dj(a.2.this.PCb.PzZ.oYR)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(as.Dj(a.2.this.PCb.PzZ.width), as.Dj(a.2.this.PCb.PzZ.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.d.loading_view_layout);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.PCc, localObject2);
                      a.j(a.this).put(a.2.this.PCc, localObject3);
                      a.k(a.this).put(a.2.this.PCc, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.d.loading_view);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.d.cover_iv);
                      String str2 = a.2.this.PCb.PzY.lyD + "_" + a.2.this.PCb.PzY.PAc.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.PBS) {
                        continue;
                      }
                      a.a(a.this, ToolsMpProcessIPCService.PROCESS_NAME);
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.PCb.PzY.appid);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.PCb.PzY.lyD);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.PCc);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.PCb.PzY.jQi);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.PCb.PzY.PAc);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.PCb.PzY.nickName);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.PCb.PzY.fve);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.PCb.PzY.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.PCb.PzY.qbu);
                      ((Bundle)localObject5).putString("init_data", a.2.this.PCb.PzY.PAb);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.PCb.PzY.serviceType);
                      i = a.2.this.iWM;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", as.Dj(a.2.this.PCb.PzZ.width));
                      ((Bundle)localObject5).putInt("view_init_height", as.Dj(a.2.this.PCb.PzZ.height));
                      ((Bundle)localObject5).putString("query", a.2.this.PCb.PzY.PAc);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.PCb.PzY.PAd);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.PCb.PzY.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.oiQ);
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuT, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).hZX();
                      ((a.d)localObject1).appid = a.2.this.PCb.PzY.appid;
                      ((a.d)localObject1).fES = a.2.this.PCb.PzY.qbu;
                      ((a.d)localObject1).pkgVersion = a.2.this.PCb.PzY.version;
                      ((a.d)localObject1).ogO = str2;
                      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(867L, 0L, 1L, false);
                      localObject6 = new ac(new com.tencent.mm.modelappbrand.h()
                      {
                        public final void M(View paramAnonymous3View, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(116584);
                          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { str1, Integer.valueOf(paramAnonymous3Int) });
                          a.a(a.this, paramAnonymous3Int);
                          switch (paramAnonymous3Int)
                          {
                          case 2: 
                          case 3: 
                          default: 
                            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(867L, 4L, 1L, false);
                            a.gRJ();
                            u.L(a.2.this.PCb.PzY.appid, false);
                            this.PCf.hZY();
                            this.PCf.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.PCc)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).gM(a.2.this.PCc, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.PCc) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.PCc)).PCz) {
                                break label340;
                              }
                              this.PCf.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.PCg.setVisibility(4);
                              a.c(a.this).gM(a.2.this.PCc, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.PCf.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(867L, 3L, 1L, false);
                            this.PCf.hZY();
                            this.PCf.setVisibility(4);
                            a.c(a.this).gM(a.2.this.PCc, 3);
                            a.gRJ();
                            u.L(a.2.this.PCb.PzY.appid, false);
                            ((a.d)a.e(a.this).get(a.2.this.PCc)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(867L, 2L, 1L, false);
                            this.PCf.setVisibility(4);
                            this.PCg.setVisibility(4);
                            this.PCf.hZY();
                            a.gRJ();
                            u.L(a.2.this.PCb.PzY.appid, true);
                            ((a.d)a.e(a.this).get(a.2.this.PCc)).isLoading = false;
                            a.c(a.this).gM(a.2.this.PCc, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new qi();
                            paramAnonymous3View.giT = paramAnonymous3View.z("appid", a.2.this.PCb.PzY.lyD, true);
                            paramAnonymous3View.gMe = (System.currentTimeMillis() - l);
                            if (this.PCh)
                            {
                              l = 1L;
                              paramAnonymous3View.gMa = l;
                              paramAnonymous3View.bpa();
                              paramAnonymous3View = new ql();
                              paramAnonymous3View.geB = 4L;
                              paramAnonymous3View = paramAnonymous3View.Hm(a.2.this.PCb.PzY.lyD);
                              paramAnonymous3View.gMe = (System.currentTimeMillis() - l);
                              if (!this.PCh) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.gMa = l;
                              paramAnonymous3View.hjR = a.2.this.oiQ;
                              paramAnonymous3View.bpa();
                              d.gRK();
                              d.d(a.2.this.PCb);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).gM(a.2.this.PCc, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ac)localObject6).a(new w()
                      {
                        public final void bhc()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.PCc);
                          if (locald != null)
                          {
                            locald.PCz = true;
                            locald.isLoading = false;
                          }
                          v.rE(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ac)localObject6).a(new f(a.g(a.this)));
                      ((ac)localObject6).a(new aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.PCc, paramAnonymous3Int, paramAnonymous3t);
                          AppMethodBeat.o(116586);
                        }
                      });
                      ((ac)localObject6).a(new af()
                      {
                        public final void b(boolean paramAnonymous3Boolean1, String paramAnonymous3String, boolean paramAnonymous3Boolean2)
                        {
                          AppMethodBeat.i(116587);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
                          Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramAnonymous3Boolean1), paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean2) });
                          com.tencent.mm.plugin.websearch.api.n localn;
                          if (paramAnonymous3String.equals(a.m(a.this)))
                          {
                            a.b(a.this, null);
                            localn = a.c(a.this);
                            if (!paramAnonymous3Boolean1) {
                              break label134;
                            }
                          }
                          for (;;)
                          {
                            localn.h(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.PCc);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ac)localObject6).a(new ag()
                      {
                        public final void bhf()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.PCc, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ac)localObject6).a(new ah()
                      {
                        public final void SV(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.PCc);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.ad()
                      {
                        public final void SU(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116579);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
                          if (!TextUtils.isEmpty(paramAnonymous3String))
                          {
                            Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymous3String))));
                            ((Intent)localObject).addFlags(268435456);
                            if (Util.isIntentAvailable(a.g(a.this), (Intent)localObject))
                            {
                              paramAnonymous3String = a.g(a.this);
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous3String, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(116579);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onMakePhone null number");
                          AppMethodBeat.o(116579);
                        }
                      });
                      ((ac)localObject6).a(new ai()
                      {
                        public final void SW(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!Util.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).biL(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ac)localObject6).a(new ae()
                      {
                        public final void bb(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!Util.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).mg(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ac)localObject6).a(new aa()
                      {
                        public final void SS(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.gRK();
                          d.b(a.2.this.PCb, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ac)localObject6).a(new z()
                      {
                        public final void SR(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.gRK();
                          d.c(a.2.this.PCb, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.PCc);
                      ((Bundle)localObject1).putString("appid", a.2.this.PCb.PzY.appid);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.PCb.PzY.serviceType);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.oiQ);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.PCb.PzY.lyD);
                      u.a(a.2.this.PCc, a.2.this.PCb.PzY.serviceType, a.2.this.PCb.PzY.appid, a.2.this.PCb.PzY.lyD, a.2.this.oiQ);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.PCc);
                      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      j.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      j.a(i.aFr(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      a.a(a.this, a.2.this.PCb, a.2.this.PCc, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
                      a.c(a.this).addView((View)localObject3);
                      AppMethodBeat.o(116590);
                    }
                  }
                  else
                  {
                    bool1 = false;
                    continue;
                  }
                  final long l = 2L;
                  continue;
                  a.a(a.this, SupportProcessIPCService.PROCESS_NAME);
                  continue;
                  if (i != 3) {
                    break label2048;
                  }
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
                  AppMethodBeat.o(116590);
                  return;
                }
                label2036:
                int i = 1005;
                continue;
                label2048:
                if (i == 16)
                {
                  i = 1042;
                }
                else if (i == 20)
                {
                  i = 1053;
                }
                else
                {
                  i = 1000;
                  continue;
                  label2081:
                  bool2 = false;
                }
              }
            }
          }
        });
        AppMethodBeat.o(116591);
      }
    });
    AppMethodBeat.o(116610);
  }
  
  public final void biJ(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.PBQ.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.appid);
      localBundle.putString("msg_id", paramString.ogO);
      localBundle.putInt("pkg_type", paramString.fES);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((g)com.tencent.mm.kernel.h.ae(g.class)).bgR().e(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void biK(String paramString)
  {
    AppMethodBeat.i(116612);
    bje(paramString);
    d.gRK();
    d.c(this.PBV);
    AppMethodBeat.o(116612);
  }
  
  public final void gQs()
  {
    this.PBS = false;
  }
  
  public final void h(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.PBJ.get(paramString1);
    if (localView != null)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.PCo;
          if (localp == null) {
            Log.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.ba(localb.getName(), localb.gRN()))
          {
            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).b(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.co.a.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.PCn.equals(a.m(a.this)))
              {
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.PCn });
                a.b(a.this, null);
                a.c(a.this).b(a.7.this.PCn, false, "timeout", a.7.this.ohW);
              }
              AppMethodBeat.o(116598);
            }
          });
          AppMethodBeat.o(116599);
        }
      }, "tapSearchWAWidgetView");
      AppMethodBeat.o(116619);
      return;
    }
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.PBT.b(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void mf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.cj.a.hrl()), Float.valueOf(com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.PBJ.get(paramString2);
          View localView2 = (View)this.PBK.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = as.Dj(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = as.Dj(paramString1.optInt("width"));
              a(localView1, (View)this.PBL.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = as.Dj(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = as.Dj(paramString1.optInt("offsetY"));
            }
            localView2.setLayoutParams(localLayoutParams2);
            if (paramString1.has("show"))
            {
              if (!paramString1.has("show")) {
                break label356;
              }
              bool = paramString1.optBoolean("show");
              if (bool)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116614);
                return;
              }
              localView1.setVisibility(8);
              localView2.setVisibility(8);
            }
          }
        }
        AppMethodBeat.o(116614);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "the error is e");
        AppMethodBeat.o(116614);
        return;
      }
      label356:
      boolean bool = false;
    }
  }
  
  public final void onDestroy()
  {
    int i = 0;
    AppMethodBeat.i(116618);
    try
    {
      Object localObject = new q(com.tencent.mm.loader.j.b.aSE() + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.ifG() });
          str1.cFq();
          i += 1;
        }
      }
      if (this.PBO == null) {
        break label283;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.PBJ.size()) });
      localObject = new HashMap(this.PBJ).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.PBJ.get(str1)).getTag();
          this.PBO.SI(str2);
          if ((View)this.PBK.get(str1) != null)
          {
            bje(str1);
            this.PBK.remove(str1);
          }
        }
      }
      this.PBJ.clear();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", Util.stackTraceToString(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.PBL.clear();
    label283:
    this.PBV = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.PBO != null)
    {
      Iterator localIterator = this.PBJ.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.PBJ.get(str)).getTag();
          ((g)com.tencent.mm.kernel.h.ae(g.class)).bgQ().SG(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.PBO != null)
    {
      Iterator localIterator = this.PBJ.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.PBJ.get(str)).getTag();
          ((g)com.tencent.mm.kernel.h.ae(g.class)).bgQ().SH(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.biW(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  final class d
  {
    boolean PCz;
    String appid;
    int fES;
    boolean isLoading;
    String ogO;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.appid, this.ogO, Integer.valueOf(this.fES), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int PAj;
    int PCA;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.PCA), Integer.valueOf(this.PAj) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */