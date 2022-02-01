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
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jl;
import com.tencent.mm.ipcinvoker.c;
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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.vfs.e;
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
  private static u DDJ;
  private HashMap<String, Object> DDA;
  private Map<String, String> DDB;
  private int DDC;
  private com.tencent.mm.modelappbrand.g DDD;
  private Map<String, e> DDE;
  private Map<String, d> DDF;
  private Map<String, WidgetData> DDG;
  public boolean DDH;
  private com.tencent.mm.plugin.websearch.api.n DDI;
  private WidgetData DDK;
  private Runnable DDL;
  private String DDM;
  private volatile String DDN;
  private HashMap<String, Object> DDy;
  private HashMap<String, Object> DDz;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    DDJ = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.DDy = new HashMap();
    this.DDz = new HashMap();
    this.DDA = new HashMap();
    this.DDB = new HashMap();
    this.DDC = -1;
    this.DDE = new HashMap();
    this.DDF = new HashMap();
    this.DDG = new HashMap();
    this.DDH = true;
    this.DDN = null;
    this.context = paramContext;
    this.DDI = paramn;
    this.DDD = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class));
    if ((this.DDH) && (new e(com.tencent.mm.loader.j.b.arU(), "websearch-widget-not-use-tools").exists())) {
      this.DDH = false;
    }
    if (com.tencent.mm.sdk.platformtools.aj.cnC()) {
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
              ej localej = new ej().nF(a.b(a.this).DCO.hKC);
              localej.ehS = a.b(a.this).DCO.cQN;
              localej.ehP = 21L;
              localej.ehQ = System.currentTimeMillis();
              localej.nG(ay.iR(com.tencent.mm.sdk.platformtools.aj.getContext())).aLk();
              v.ma(30);
              paramn.eLU();
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
            a.8.this.DEj.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.DEk.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.kgm, a.8.this.DEj);
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
  
  private void aFY(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.DDG.get(paramString);
      Object localObject2 = (d)this.DDF.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new ej().nF(((WidgetData)localObject1).DCO.hKC);
        ((ej)localObject2).ehS = ((WidgetData)localObject1).DCO.cQN;
        ((ej)localObject2).ehP = 24L;
        localObject1 = ((ej)localObject2).nE(paramString);
        ((ej)localObject1).ehQ = System.currentTimeMillis();
        ((ej)localObject1).nG(ay.iR(com.tencent.mm.sdk.platformtools.aj.getContext())).aLk();
      }
      localObject1 = (View)this.DDy.get(paramString);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.DDD != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.DDD.a((String)localObject2, (View)localObject1);
      }
      this.DDy.remove(paramString);
      this.DDA.remove(paramString);
      localObject1 = (View)this.DDz.get(paramString);
      if (localObject1 != null)
      {
        this.DDI.removeView((View)localObject1);
        this.DDz.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u eMJ()
  {
    return DDJ;
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
              int j = an.vK(paramWidgetData.DCP.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = an.vK(paramWidgetData.DCP.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = an.vK(paramWidgetData.DCP.kSh);
                ((AbsoluteLayout.LayoutParams)localObject).y = an.vK(paramWidgetData.DCP.kSi);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.DCP.dJm)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = an.vK(paramWidgetData.DCP.kSh);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = an.vK(paramWidgetData.DCP.kSi);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.cd.a.fhL()), Float.valueOf(com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    com.tencent.mm.ipcinvoker.p.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.DCO == null) || (paramWidgetData.DCP == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.eMK();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.DCO.hKC });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).fv(a.2.this.DDR, 3);
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
            a.a(a.this, a.2.this.DDQ);
            a.d(a.this).put(a.2.this.DDR, a.2.this.DDQ);
            v.ma(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.DDQ.DCO.cQN), a.2.this.DDR, str1, a.2.this.DDQ.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.DDR);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.DDR, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.eMK();
                  d.b(a.2.this.DDQ);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.DDR);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.DDR, localObject2);
                  }
                  ((a.e)localObject2).DEp = ((int)a.2.this.DDQ.DCP.DDa);
                  ((a.e)localObject2).DDb = a.2.this.DDQ.DCP.DDb;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.eMJ();
                  u.Ck(a.2.this.DDQ.DCO.hKC);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)k.ds(a.2.this.DDQ.DCO.dki).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.eMJ();
                      u.aDP();
                    }
                    localObject2 = new ej().nF(a.2.this.DDQ.DCO.hKC);
                    if (bool1)
                    {
                      l = 1L;
                      ((ej)localObject2).ehT = l;
                      ((ej)localObject2).ehS = a.2.this.DDQ.DCO.cQN;
                      ((ej)localObject2).ehP = 1L;
                      localObject2 = ((ej)localObject2).nE(a.2.this.DDR);
                      ((ej)localObject2).ehQ = System.currentTimeMillis();
                      ((ej)localObject2).nG(ay.iR(com.tencent.mm.sdk.platformtools.aj.getContext())).aLk();
                      localObject2 = a.h(a.this).cw(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.z.jO(a.g(a.this)).inflate(2131494230, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, an.vK(a.2.this.DDQ.DCP.kSh), an.vK(a.2.this.DDQ.DCP.kSi)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(an.vK(a.2.this.DDQ.DCP.width), an.vK(a.2.this.DDQ.DCP.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131301515);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.DDR, localObject2);
                      a.j(a.this).put(a.2.this.DDR, localObject3);
                      a.k(a.this).put(a.2.this.DDR, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131301514);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131298824);
                      String str2 = a.2.this.DDQ.DCO.hKC + "_" + a.2.this.DDQ.DCO.DCS.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.DDH) {
                        continue;
                      }
                      a.a(a.this, "com.tencent.mm:toolsmp");
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.DDQ.DCO.duW);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.DDQ.DCO.hKC);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.DDR);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.DDQ.DCO.keN);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.DDQ.DCO.DCS);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.DDQ.DCO.bVF);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.DDQ.DCO.dki);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.DDQ.DCO.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.DDQ.DCO.DCU);
                      ((Bundle)localObject5).putString("init_data", a.2.this.DDQ.DCO.DCR);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.DDQ.DCO.cQN);
                      i = a.2.this.fLl;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", an.vK(a.2.this.DDQ.DCP.width));
                      ((Bundle)localObject5).putInt("view_init_height", an.vK(a.2.this.DDQ.DCP.height));
                      ((Bundle)localObject5).putString("query", a.2.this.DDQ.DCO.DCS);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.DDQ.DCO.DCT);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.DDQ.DCO.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.khg);
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqw, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).fLJ();
                      ((a.d)localObject1).duW = a.2.this.DDQ.DCO.duW;
                      ((a.d)localObject1).dtF = a.2.this.DDQ.DCO.DCU;
                      ((a.d)localObject1).pkgVersion = a.2.this.DDQ.DCO.version;
                      ((a.d)localObject1).kfe = str2;
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(867L, 0L, 1L, false);
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
                            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(867L, 4L, 1L, false);
                            a.eMJ();
                            u.I(a.2.this.DDQ.DCO.duW, false);
                            this.DDU.fLK();
                            this.DDU.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.DDR)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).fv(a.2.this.DDR, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.DDR) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.DDR)).DEo) {
                                break label340;
                              }
                              this.DDU.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.DDV.setVisibility(4);
                              a.c(a.this).fv(a.2.this.DDR, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.DDU.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(867L, 3L, 1L, false);
                            this.DDU.fLK();
                            this.DDU.setVisibility(4);
                            a.c(a.this).fv(a.2.this.DDR, 3);
                            a.eMJ();
                            u.I(a.2.this.DDQ.DCO.duW, false);
                            ((a.d)a.e(a.this).get(a.2.this.DDR)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(867L, 2L, 1L, false);
                            this.DDU.setVisibility(4);
                            this.DDV.setVisibility(4);
                            this.DDU.fLK();
                            a.eMJ();
                            u.I(a.2.this.DDQ.DCO.duW, true);
                            ((a.d)a.e(a.this).get(a.2.this.DDR)).isLoading = false;
                            a.c(a.this).fv(a.2.this.DDR, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new ji();
                            paramAnonymous3View.dSD = paramAnonymous3View.t("appid", a.2.this.DDQ.DCO.hKC, true);
                            paramAnonymous3View.eAg = (System.currentTimeMillis() - l);
                            if (this.DDW)
                            {
                              l = 1L;
                              paramAnonymous3View.ehT = l;
                              paramAnonymous3View.aLk();
                              paramAnonymous3View = new jl();
                              paramAnonymous3View.dPH = 4L;
                              paramAnonymous3View = paramAnonymous3View.rU(a.2.this.DDQ.DCO.hKC);
                              paramAnonymous3View.eAg = (System.currentTimeMillis() - l);
                              if (!this.DDW) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.ehT = l;
                              paramAnonymous3View.eAw = a.2.this.khg;
                              paramAnonymous3View.aLk();
                              d.eMK();
                              d.d(a.2.this.DDQ);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).fv(a.2.this.DDR, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ac)localObject6).a(new w()
                      {
                        public final void aDQ()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.DDR);
                          if (locald != null)
                          {
                            locald.DEo = true;
                            locald.isLoading = false;
                          }
                          v.ma(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ac)localObject6).a(new g(a.g(a.this)));
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.DDR, paramAnonymous3Int, paramAnonymous3t);
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
                            localn.i(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.DDR);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ac)localObject6).a(new ag()
                      {
                        public final void aDT()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.DDR, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ac)localObject6).a(new ah()
                      {
                        public final void Cp(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.DDR);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.ad()
                      {
                        public final void Co(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116579);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
                          if (!TextUtils.isEmpty(paramAnonymous3String))
                          {
                            Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymous3String))));
                            ((Intent)localObject).addFlags(268435456);
                            if (bt.aj(a.g(a.this), (Intent)localObject))
                            {
                              paramAnonymous3String = a.g(a.this);
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
                        public final void Cq(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!bt.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).aFL(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ac)localObject6).a(new ae()
                      {
                        public final void aT(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!bt.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).kE(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ac)localObject6).a(new aa()
                      {
                        public final void Cm(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.eMK();
                          d.b(a.2.this.DDQ, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.z()
                      {
                        public final void Cl(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.eMK();
                          d.c(a.2.this.DDQ, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.DDR);
                      ((Bundle)localObject1).putString("appid", a.2.this.DDQ.DCO.duW);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.DDQ.DCO.cQN);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.khg);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.DDQ.DCO.hKC);
                      u.a(a.2.this.DDR, a.2.this.DDQ.DCO.cQN, a.2.this.DDQ.DCO.duW, a.2.this.DDQ.DCO.hKC, a.2.this.khg);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.DDR);
                      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.ipcinvoker.g.ahx(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      a.a(a.this, a.2.this.DDQ, a.2.this.DDR, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
  
  public final void aFJ(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.DDF.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.duW);
      localBundle.putString("msg_id", paramString.kfe);
      localBundle.putInt("pkg_type", paramString.dtF);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().d(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void aFK(String paramString)
  {
    AppMethodBeat.i(116612);
    aFY(paramString);
    d.eMK();
    d.c(this.DDK);
    AppMethodBeat.o(116612);
  }
  
  public final void eLQ()
  {
    this.DDH = false;
  }
  
  public final void h(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.DDy.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.DEd;
          if (localp == null) {
            com.tencent.mm.sdk.platformtools.ad.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.aS(localb.getName(), localb.eMO()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).a(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.ci.a.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.DEc.equals(a.m(a.this)))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.DEc });
                a.b(a.this, null);
                a.c(a.this).a(a.7.this.DEc, false, "timeout", a.7.this.kgm);
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
    this.DDI.a(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void kD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.cd.a.fhL()), Float.valueOf(com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.DDy.get(paramString2);
          View localView2 = (View)this.DDz.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = an.vK(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = an.vK(paramString1.optInt("width"));
              a(localView1, (View)this.DDA.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = an.vK(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = an.vK(paramString1.optInt("offsetY"));
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
      Object localObject = new e(com.tencent.mm.loader.j.b.arN().replace("/data/user/0", "/data/data") + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.fOL() });
          str1.delete();
          i += 1;
        }
      }
      if (this.DDD == null) {
        break label292;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.DDy.size()) });
      localObject = new HashMap(this.DDy).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.DDy.get(str1)).getTag();
          this.DDD.Cc(str2);
          if ((View)this.DDz.get(str1) != null)
          {
            aFY(str1);
            this.DDz.remove(str1);
          }
        }
      }
      this.DDy.clear();
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", bt.n(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.DDA.clear();
    label292:
    this.DDK = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.DDD != null)
    {
      Iterator localIterator = this.DDy.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.DDy.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDE().Ca(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.DDD != null)
    {
      Iterator localIterator = this.DDy.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.DDy.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDE().Cb(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void t(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.aFW(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  final class d
  {
    boolean DEo;
    int dtF;
    String duW;
    boolean isLoading;
    String kfe;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.duW, this.kfe, Integer.valueOf(this.dtF), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int DDb;
    int DEp;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.DEp), Integer.valueOf(this.DDb) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */