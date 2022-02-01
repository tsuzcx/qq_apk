package com.tencent.mm.plugin.websearch.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a
  implements com.tencent.mm.plugin.websearch.api.c
{
  private static u AIu;
  private HashMap<String, Object> AIj;
  private HashMap<String, Object> AIk;
  private HashMap<String, Object> AIl;
  private Map<String, String> AIm;
  private int AIn;
  private com.tencent.mm.modelappbrand.g AIo;
  private Map<String, e> AIp;
  private Map<String, d> AIq;
  private Map<String, WidgetData> AIr;
  public boolean AIs;
  private com.tencent.mm.plugin.websearch.api.n AIt;
  private WidgetData AIv;
  private Runnable AIw;
  private String AIx;
  private volatile String AIy;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    AIu = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.AIj = new HashMap();
    this.AIk = new HashMap();
    this.AIl = new HashMap();
    this.AIm = new HashMap();
    this.AIn = -1;
    this.AIp = new HashMap();
    this.AIq = new HashMap();
    this.AIr = new HashMap();
    this.AIs = true;
    this.AIy = null;
    this.context = paramContext;
    this.AIt = paramn;
    this.AIo = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class));
    if ((this.AIs) && (new e(com.tencent.mm.loader.j.b.aih(), "websearch-widget-not-use-tools").exists())) {
      this.AIs = false;
    }
    if (com.tencent.mm.sdk.platformtools.aj.cbv()) {
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm:support", new com.tencent.mm.ipcinvoker.n()
      {
        public final void onDisconnect()
        {
          AppMethodBeat.i(116577);
          if ("com.tencent.mm:support".equals(a.a(a.this)))
          {
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "support process dead", new Object[0]);
            if (a.b(a.this) != null)
            {
              ca localca = new ca().iI(a.b(a.this).AHB.gRK);
              localca.dQy = a.b(a.this).AHB.cIB;
              localca.dQv = 21L;
              localca.dQw = System.currentTimeMillis();
              localca.iJ(ay.iw(com.tencent.mm.sdk.platformtools.aj.getContext())).aBj();
              v.lI(30);
              paramn.ehM();
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
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116602);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            a.8.this.AIU.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.AIV.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.jlO, a.8.this.AIU);
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
  
  private void avm(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.AIr.get(paramString);
      Object localObject2 = (d)this.AIq.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new ca().iI(((WidgetData)localObject1).AHB.gRK);
        ((ca)localObject2).dQy = ((WidgetData)localObject1).AHB.cIB;
        ((ca)localObject2).dQv = 24L;
        localObject1 = ((ca)localObject2).iH(paramString);
        ((ca)localObject1).dQw = System.currentTimeMillis();
        ((ca)localObject1).iJ(ay.iw(com.tencent.mm.sdk.platformtools.aj.getContext())).aBj();
      }
      localObject1 = (View)this.AIj.get(paramString);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.AIo != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.AIo.a((String)localObject2, (View)localObject1);
      }
      this.AIj.remove(paramString);
      this.AIl.remove(paramString);
      localObject1 = (View)this.AIk.get(paramString);
      if (localObject1 != null)
      {
        this.AIt.removeView((View)localObject1);
        this.AIk.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u eiy()
  {
    return AIu;
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString)
  {
    AppMethodBeat.i(116615);
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        aq.f(new Runnable()
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
              int j = al.Sl(paramWidgetData.AHC.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = al.Sl(paramWidgetData.AHC.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = al.Sl(paramWidgetData.AHC.jVq);
                ((AbsoluteLayout.LayoutParams)localObject).y = al.Sl(paramWidgetData.AHC.jVr);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.AHC.dzo)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = al.Sl(paramWidgetData.AHC.jVq);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = al.Sl(paramWidgetData.AHC.jVr);
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
      AppMethodBeat.o(116615);
    }
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(116610);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.ce.a.eCY()), Float.valueOf(com.tencent.mm.cd.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    com.tencent.mm.ipcinvoker.p.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.AHB == null) || (paramWidgetData.AHC == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.eiz();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.AHB.gRK });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).eQ(a.2.this.AIC, 3);
              AppMethodBeat.o(116578);
            }
          });
          AppMethodBeat.o(116591);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116590);
            a.a(a.this, a.2.this.AIB);
            a.d(a.this).put(a.2.this.AIC, a.2.this.AIB);
            v.lI(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.AIB.AHB.cIB), a.2.this.AIC, str1, a.2.this.AIB.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.AIC);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.AIC, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.eiz();
                  d.b(a.2.this.AIB);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.AIC);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.AIC, localObject2);
                  }
                  ((a.e)localObject2).AJa = ((int)a.2.this.AIB.AHC.AHO);
                  ((a.e)localObject2).AHP = a.2.this.AIB.AHC.AHP;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.eiy();
                  u.vf(a.2.this.AIB.AHB.gRK);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)k.cB(a.2.this.AIB.AHB.dbu).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.eiy();
                      u.atV();
                    }
                    localObject2 = new ca().iI(a.2.this.AIB.AHB.gRK);
                    if (bool1)
                    {
                      l = 1L;
                      ((ca)localObject2).dQz = l;
                      ((ca)localObject2).dQy = a.2.this.AIB.AHB.cIB;
                      ((ca)localObject2).dQv = 1L;
                      localObject2 = ((ca)localObject2).iH(a.2.this.AIC);
                      ((ca)localObject2).dQw = System.currentTimeMillis();
                      ((ca)localObject2).iJ(ay.iw(com.tencent.mm.sdk.platformtools.aj.getContext())).aBj();
                      localObject2 = a.h(a.this).cq(a.g(a.this));
                      localObject3 = (AbsoluteLayout)y.js(a.g(a.this)).inflate(2131494230, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, al.Sl(a.2.this.AIB.AHC.jVq), al.Sl(a.2.this.AIB.AHC.jVr)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(al.Sl(a.2.this.AIB.AHC.width), al.Sl(a.2.this.AIB.AHC.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131301515);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.AIC, localObject2);
                      a.j(a.this).put(a.2.this.AIC, localObject3);
                      a.k(a.this).put(a.2.this.AIC, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131301514);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131298824);
                      String str2 = a.2.this.AIB.AHB.gRK + "_" + a.2.this.AIB.AHB.AHG.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.AIs) {
                        continue;
                      }
                      a.a(a.this, "com.tencent.mm:toolsmp");
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.AIB.AHB.dlB);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.AIB.AHB.gRK);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.AIC);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.AIB.AHB.jko);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.AIB.AHB.AHG);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.AIB.AHB.bNK);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.AIB.AHB.dbu);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.AIB.AHB.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.AIB.AHB.AHI);
                      ((Bundle)localObject5).putString("init_data", a.2.this.AIB.AHB.AHF);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.AIB.AHB.cIB);
                      i = a.2.this.fpl;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", al.Sl(a.2.this.AIB.AHC.width));
                      ((Bundle)localObject5).putInt("view_init_height", al.Sl(a.2.this.AIB.AHC.height));
                      ((Bundle)localObject5).putString("query", a.2.this.AIB.AHB.AHG);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.AIB.AHB.AHH);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.AIB.AHB.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.jmI);
                      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjo, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).ffb();
                      ((a.d)localObject1).dlB = a.2.this.AIB.AHB.dlB;
                      ((a.d)localObject1).dkC = a.2.this.AIB.AHB.AHI;
                      ((a.d)localObject1).pkgVersion = a.2.this.AIB.AHB.version;
                      ((a.d)localObject1).jkG = str2;
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(867L, 0L, 1L, false);
                      localObject6 = new ac(new com.tencent.mm.modelappbrand.h()
                      {
                        public final void N(View paramAnonymous3View, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(116584);
                          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { str1, Integer.valueOf(paramAnonymous3Int) });
                          a.a(a.this, paramAnonymous3Int);
                          switch (paramAnonymous3Int)
                          {
                          case 2: 
                          case 3: 
                          default: 
                            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(867L, 4L, 1L, false);
                            a.eiy();
                            u.H(a.2.this.AIB.AHB.dlB, false);
                            this.AIF.ffc();
                            this.AIF.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.AIC)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).eQ(a.2.this.AIC, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.AIC) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.AIC)).AIZ) {
                                break label340;
                              }
                              this.AIF.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.AIG.setVisibility(4);
                              a.c(a.this).eQ(a.2.this.AIC, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.AIF.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(867L, 3L, 1L, false);
                            this.AIF.ffc();
                            this.AIF.setVisibility(4);
                            a.c(a.this).eQ(a.2.this.AIC, 3);
                            a.eiy();
                            u.H(a.2.this.AIB.AHB.dlB, false);
                            ((a.d)a.e(a.this).get(a.2.this.AIC)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(867L, 2L, 1L, false);
                            this.AIF.setVisibility(4);
                            this.AIG.setVisibility(4);
                            this.AIF.ffc();
                            a.eiy();
                            u.H(a.2.this.AIB.AHB.dlB, true);
                            ((a.d)a.e(a.this).get(a.2.this.AIC)).isLoading = false;
                            a.c(a.this).eQ(a.2.this.AIC, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new gm();
                            paramAnonymous3View.dHL = paramAnonymous3View.t("appid", a.2.this.AIB.AHB.gRK, true);
                            paramAnonymous3View.eha = (System.currentTimeMillis() - l);
                            if (this.AIH)
                            {
                              l = 1L;
                              paramAnonymous3View.dQz = l;
                              paramAnonymous3View.aBj();
                              paramAnonymous3View = new gp();
                              paramAnonymous3View.dFf = 4L;
                              paramAnonymous3View = paramAnonymous3View.mi(a.2.this.AIB.AHB.gRK);
                              paramAnonymous3View.eha = (System.currentTimeMillis() - l);
                              if (!this.AIH) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.dQz = l;
                              paramAnonymous3View.ehq = a.2.this.jmI;
                              paramAnonymous3View.aBj();
                              d.eiz();
                              d.d(a.2.this.AIB);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).eQ(a.2.this.AIC, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ac)localObject6).a(new w()
                      {
                        public final void atW()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.AIC);
                          if (locald != null)
                          {
                            locald.AIZ = true;
                            locald.isLoading = false;
                          }
                          v.lI(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ac)localObject6).a(new g(a.g(a.this)));
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.AIC, paramAnonymous3Int, paramAnonymous3t);
                          AppMethodBeat.o(116586);
                        }
                      });
                      ((ac)localObject6).a(new af()
                      {
                        public final void b(boolean paramAnonymous3Boolean1, String paramAnonymous3String, boolean paramAnonymous3Boolean2)
                        {
                          AppMethodBeat.i(116587);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramAnonymous3Boolean1), paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean2) });
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
                            localn.i(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.AIC);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ac)localObject6).a(new ag()
                      {
                        public final void atZ()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.AIC, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ac)localObject6).a(new ah()
                      {
                        public final void vk(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.AIC);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.ad()
                      {
                        public final void vj(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116579);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
                          if (!TextUtils.isEmpty(paramAnonymous3String))
                          {
                            Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymous3String))));
                            ((Intent)localObject).addFlags(268435456);
                            if (bt.T(a.g(a.this), (Intent)localObject))
                            {
                              paramAnonymous3String = a.g(a.this);
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(116579);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onMakePhone null number");
                          AppMethodBeat.o(116579);
                        }
                      });
                      ((ac)localObject6).a(new ai()
                      {
                        public final void vl(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!bt.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).ava(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ac)localObject6).a(new ae()
                      {
                        public final void aK(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!bt.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).jK(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ac)localObject6).a(new aa()
                      {
                        public final void vh(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.eiz();
                          d.b(a.2.this.AIB, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ac)localObject6).a(new z()
                      {
                        public final void vg(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.eiz();
                          d.c(a.2.this.AIB, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.AIC);
                      ((Bundle)localObject1).putString("appid", a.2.this.AIB.AHB.dlB);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.AIB.AHB.cIB);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.jmI);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.AIB.AHB.gRK);
                      u.a(a.2.this.AIC, a.2.this.AIB.AHB.cIB, a.2.this.AIB.AHB.dlB, a.2.this.AIB.AHB.gRK, a.2.this.jmI);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.AIC);
                      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.ipcinvoker.g.adv(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      a.a(a.this, a.2.this.AIB, a.2.this.AIC, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
                  a.a(a.this, "com.tencent.mm:support");
                  continue;
                  if (i != 3) {
                    break label2048;
                  }
                }
                catch (Exception localException)
                {
                  com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
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
  
  public final void auY(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.AIq.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.dlB);
      localBundle.putString("msg_id", paramString.jkG);
      localBundle.putInt("pkg_type", paramString.dkC);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().d(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void auZ(String paramString)
  {
    AppMethodBeat.i(116612);
    avm(paramString);
    d.eiz();
    d.c(this.AIv);
    AppMethodBeat.o(116612);
  }
  
  public final void ehI()
  {
    this.AIs = false;
  }
  
  public final void g(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.AIj.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.AIO;
          if (localp == null) {
            com.tencent.mm.sdk.platformtools.ad.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.aJ(localb.getName(), localb.eiD()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).a(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.cj.a.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.AIN.equals(a.m(a.this)))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.AIN });
                a.b(a.this, null);
                a.c(a.this).a(a.7.this.AIN, false, "timeout", a.7.this.jlO);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.AIt.a(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.ce.a.eCY()), Float.valueOf(com.tencent.mm.cd.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.AIj.get(paramString2);
          View localView2 = (View)this.AIk.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = al.Sl(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = al.Sl(paramString1.optInt("width"));
              a(localView1, (View)this.AIl.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = al.Sl(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = al.Sl(paramString1.optInt("offsetY"));
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "the error is e");
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
      Object localObject = new e(com.tencent.mm.loader.j.b.aia().replace("/data/user/0", "/data/data") + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.fhV() });
          str1.delete();
          i += 1;
        }
      }
      if (this.AIo == null) {
        break label292;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.AIj.size()) });
      localObject = new HashMap(this.AIj).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.AIj.get(str1)).getTag();
          this.AIo.uX(str2);
          if ((View)this.AIk.get(str1) != null)
          {
            avm(str1);
            this.AIk.remove(str1);
          }
        }
      }
      this.AIj.clear();
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", bt.m(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.AIl.clear();
    label292:
    this.AIv = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.AIo != null)
    {
      Iterator localIterator = this.AIj.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.AIj.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().uV(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.AIo != null)
    {
      Iterator localIterator = this.AIj.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.AIj.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().uW(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void t(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.avk(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  final class d
  {
    boolean AIZ;
    int dkC;
    String dlB;
    boolean isLoading;
    String jkG;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.dlB, this.jkG, Integer.valueOf(this.dkC), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int AHP;
    int AJa;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.AJa), Integer.valueOf(this.AHP) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */