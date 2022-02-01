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
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.plugin.websearch.api.c
{
  private static u CaL;
  private HashMap<String, Object> CaA;
  private HashMap<String, Object> CaB;
  private HashMap<String, Object> CaC;
  private Map<String, String> CaD;
  private int CaE;
  private com.tencent.mm.modelappbrand.g CaF;
  private Map<String, e> CaG;
  private Map<String, d> CaH;
  private Map<String, WidgetData> CaI;
  public boolean CaJ;
  private m CaK;
  private WidgetData CaM;
  private Runnable CaN;
  private String CaO;
  private volatile String CaP;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    CaL = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final m paramm)
  {
    AppMethodBeat.i(116608);
    this.CaA = new HashMap();
    this.CaB = new HashMap();
    this.CaC = new HashMap();
    this.CaD = new HashMap();
    this.CaE = -1;
    this.CaG = new HashMap();
    this.CaH = new HashMap();
    this.CaI = new HashMap();
    this.CaJ = true;
    this.CaP = null;
    this.context = paramContext;
    this.CaK = paramm;
    this.CaF = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class));
    if ((this.CaJ) && (new e(com.tencent.mm.loader.j.b.aph(), "websearch-widget-not-use-tools").exists())) {
      this.CaJ = false;
    }
    if (com.tencent.mm.sdk.platformtools.ai.ciE()) {
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
              do localdo = new do().ly(a.b(a.this).BZS.hsk);
              localdo.dSn = a.b(a.this).BZS.cFI;
              localdo.dSk = 21L;
              localdo.dSl = System.currentTimeMillis();
              localdo.lz(ax.iH(com.tencent.mm.sdk.platformtools.ai.getContext())).aHZ();
              v.lA(30);
              paramm.exg();
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
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116602);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            a.8.this.Cbl.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.Cbm.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.jMb, a.8.this.Cbl);
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
  
  private void aAE(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.CaI.get(paramString);
      Object localObject2 = (d)this.CaH.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new do().ly(((WidgetData)localObject1).BZS.hsk);
        ((do)localObject2).dSn = ((WidgetData)localObject1).BZS.cFI;
        ((do)localObject2).dSk = 24L;
        localObject1 = ((do)localObject2).lx(paramString);
        ((do)localObject1).dSl = System.currentTimeMillis();
        ((do)localObject1).lz(ax.iH(com.tencent.mm.sdk.platformtools.ai.getContext())).aHZ();
      }
      localObject1 = (View)this.CaA.get(paramString);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.CaF != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.CaF.a((String)localObject2, (View)localObject1);
      }
      this.CaA.remove(paramString);
      this.CaC.remove(paramString);
      localObject1 = (View)this.CaB.get(paramString);
      if (localObject1 != null)
      {
        this.CaK.removeView((View)localObject1);
        this.CaB.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u exS()
  {
    return CaL;
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString)
  {
    AppMethodBeat.i(116615);
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        ap.f(new Runnable()
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
              int j = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.kwc);
                ((AbsoluteLayout.LayoutParams)localObject).y = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.kwd);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.BZT.dxa)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.kwc);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.plugin.websearch.api.aj.Uu(paramWidgetData.BZT.kwd);
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
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
      AppMethodBeat.o(116615);
    }
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(116610);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.cd.a.eSs()), Float.valueOf(com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.ai.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    com.tencent.mm.ipcinvoker.p.B(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.BZS == null) || (paramWidgetData.BZT == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.exT();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.BZS.hsk });
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).eY(a.2.this.CaT, 3);
              AppMethodBeat.o(116578);
            }
          });
          AppMethodBeat.o(116591);
          return;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116590);
            a.a(a.this, a.2.this.CaS);
            a.d(a.this).put(a.2.this.CaT, a.2.this.CaS);
            v.lA(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.CaS.BZS.cFI), a.2.this.CaT, str1, a.2.this.CaS.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.CaT);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.CaT, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.exT();
                  d.b(a.2.this.CaS);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.CaT);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.CaT, localObject2);
                  }
                  ((a.e)localObject2).Cbr = ((int)a.2.this.CaS.BZT.Caf);
                  ((a.e)localObject2).Cag = a.2.this.CaS.BZT.Cag;
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.exS();
                  u.zl(a.2.this.CaS.BZS.hsk);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)k.cq(a.2.this.CaS.BZS.cYQ).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.exS();
                      u.aAM();
                    }
                    localObject2 = new do().ly(a.2.this.CaS.BZS.hsk);
                    if (bool1)
                    {
                      l = 1L;
                      ((do)localObject2).dSo = l;
                      ((do)localObject2).dSn = a.2.this.CaS.BZS.cFI;
                      ((do)localObject2).dSk = 1L;
                      localObject2 = ((do)localObject2).lx(a.2.this.CaT);
                      ((do)localObject2).dSl = System.currentTimeMillis();
                      ((do)localObject2).lz(ax.iH(com.tencent.mm.sdk.platformtools.ai.getContext())).aHZ();
                      localObject2 = a.h(a.this).cz(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.z.jD(a.g(a.this)).inflate(2131494230, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.kwc), com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.kwd)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.width), com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131301515);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.CaT, localObject2);
                      a.j(a.this).put(a.2.this.CaT, localObject3);
                      a.k(a.this).put(a.2.this.CaT, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131301514);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131298824);
                      String str2 = a.2.this.CaS.BZS.hsk + "_" + a.2.this.CaS.BZS.BZX.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.CaJ) {
                        continue;
                      }
                      a.a(a.this, "com.tencent.mm:toolsmp");
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.CaS.BZS.djj);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.CaS.BZS.hsk);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.CaT);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.CaS.BZS.jKB);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.CaS.BZS.BZX);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.CaS.BZS.bLs);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.CaS.BZS.cYQ);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.CaS.BZS.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.CaS.BZS.BZZ);
                      ((Bundle)localObject5).putString("init_data", a.2.this.CaS.BZS.BZW);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.CaS.BZS.cFI);
                      i = a.2.this.fsL;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.width));
                      ((Bundle)localObject5).putInt("view_init_height", com.tencent.mm.plugin.websearch.api.aj.Uu(a.2.this.CaS.BZT.height));
                      ((Bundle)localObject5).putString("query", a.2.this.CaS.BZS.BZX);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.CaS.BZS.BZY);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.CaS.BZS.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.jMV);
                      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMF, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).fuW();
                      ((a.d)localObject1).djj = a.2.this.CaS.BZS.djj;
                      ((a.d)localObject1).dib = a.2.this.CaS.BZS.BZZ;
                      ((a.d)localObject1).pkgVersion = a.2.this.CaS.BZS.version;
                      ((a.d)localObject1).jKT = str2;
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(867L, 0L, 1L, false);
                      localObject6 = new com.tencent.mm.modelappbrand.ac(new com.tencent.mm.modelappbrand.h()
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
                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(867L, 4L, 1L, false);
                            a.exS();
                            u.I(a.2.this.CaS.BZS.djj, false);
                            this.CaW.fuX();
                            this.CaW.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.CaT)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).eY(a.2.this.CaT, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.CaT) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.CaT)).Cbq) {
                                break label340;
                              }
                              this.CaW.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.CaX.setVisibility(4);
                              a.c(a.this).eY(a.2.this.CaT, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.CaW.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(867L, 3L, 1L, false);
                            this.CaW.fuX();
                            this.CaW.setVisibility(4);
                            a.c(a.this).eY(a.2.this.CaT, 3);
                            a.exS();
                            u.I(a.2.this.CaS.BZS.djj, false);
                            ((a.d)a.e(a.this).get(a.2.this.CaT)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(867L, 2L, 1L, false);
                            this.CaW.setVisibility(4);
                            this.CaX.setVisibility(4);
                            this.CaW.fuX();
                            a.exS();
                            u.I(a.2.this.CaS.BZS.djj, true);
                            ((a.d)a.e(a.this).get(a.2.this.CaT)).isLoading = false;
                            a.c(a.this).eY(a.2.this.CaT, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new ie();
                            paramAnonymous3View.dFy = paramAnonymous3View.t("appid", a.2.this.CaS.BZS.hsk, true);
                            paramAnonymous3View.ejg = (System.currentTimeMillis() - l);
                            if (this.CaY)
                            {
                              l = 1L;
                              paramAnonymous3View.dSo = l;
                              paramAnonymous3View.aHZ();
                              paramAnonymous3View = new ih();
                              paramAnonymous3View.dCS = 4L;
                              paramAnonymous3View = paramAnonymous3View.pn(a.2.this.CaS.BZS.hsk);
                              paramAnonymous3View.ejg = (System.currentTimeMillis() - l);
                              if (!this.CaY) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.dSo = l;
                              paramAnonymous3View.ejw = a.2.this.jMV;
                              paramAnonymous3View.aHZ();
                              d.exT();
                              d.d(a.2.this.CaS);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).eY(a.2.this.CaT, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new w()
                      {
                        public final void aAN()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.CaT);
                          if (locald != null)
                          {
                            locald.Cbq = true;
                            locald.isLoading = false;
                          }
                          v.lA(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new g(a.g(a.this)));
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new com.tencent.mm.modelappbrand.aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.CaT, paramAnonymous3Int, paramAnonymous3t);
                          AppMethodBeat.o(116586);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new af()
                      {
                        public final void b(boolean paramAnonymous3Boolean1, String paramAnonymous3String, boolean paramAnonymous3Boolean2)
                        {
                          AppMethodBeat.i(116587);
                          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
                          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramAnonymous3Boolean1), paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean2) });
                          m localm;
                          if (paramAnonymous3String.equals(a.m(a.this)))
                          {
                            a.b(a.this, null);
                            localm = a.c(a.this);
                            if (!paramAnonymous3Boolean1) {
                              break label134;
                            }
                          }
                          for (;;)
                          {
                            localm.i(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.CaT);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new ag()
                      {
                        public final void aAQ()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.CaT, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new ah()
                      {
                        public final void zq(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.CaT);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new ad()
                      {
                        public final void zp(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116579);
                          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
                          if (!TextUtils.isEmpty(paramAnonymous3String))
                          {
                            Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymous3String))));
                            ((Intent)localObject).addFlags(268435456);
                            if (bs.ah(a.g(a.this), (Intent)localObject))
                            {
                              paramAnonymous3String = a.g(a.this);
                              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(116579);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onMakePhone null number");
                          AppMethodBeat.o(116579);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new com.tencent.mm.modelappbrand.ai()
                      {
                        public final void zr(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!bs.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).aAr(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new ae()
                      {
                        public final void aS(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!bs.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).kg(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new aa()
                      {
                        public final void zn(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.exT();
                          d.b(a.2.this.CaS, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((com.tencent.mm.modelappbrand.ac)localObject6).a(new com.tencent.mm.modelappbrand.z()
                      {
                        public final void zm(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.exT();
                          d.c(a.2.this.CaS, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.CaT);
                      ((Bundle)localObject1).putString("appid", a.2.this.CaS.BZS.djj);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.CaS.BZS.cFI);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.jMV);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.CaS.BZS.hsk);
                      u.a(a.2.this.CaT, a.2.this.CaS.BZS.cFI, a.2.this.CaS.BZS.djj, a.2.this.CaS.BZS.hsk, a.2.this.jMV);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.CaT);
                      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.ipcinvoker.g.aeL(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      a.a(a.this, a.2.this.CaS, a.2.this.CaT, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
                  com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
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
  
  public final void aAp(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.CaH.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.djj);
      localBundle.putString("msg_id", paramString.jKT);
      localBundle.putInt("pkg_type", paramString.dib);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().d(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void aAq(String paramString)
  {
    AppMethodBeat.i(116612);
    aAE(paramString);
    d.exT();
    d.c(this.CaM);
    AppMethodBeat.o(116612);
  }
  
  public final void exc()
  {
    this.CaJ = false;
  }
  
  public final void i(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.CaA.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.Cbf;
          if (localp == null) {
            com.tencent.mm.sdk.platformtools.ac.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.aR(localb.getName(), localb.exX()))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
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
              if (a.7.this.Cbe.equals(a.m(a.this)))
              {
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.Cbe });
                a.b(a.this, null);
                a.c(a.this).a(a.7.this.Cbe, false, "timeout", a.7.this.jMb);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.CaK.a(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void kf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.cd.a.eSs()), Float.valueOf(com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.ai.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.CaA.get(paramString2);
          View localView2 = (View)this.CaB.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = com.tencent.mm.plugin.websearch.api.aj.Uu(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = com.tencent.mm.plugin.websearch.api.aj.Uu(paramString1.optInt("width"));
              a(localView1, (View)this.CaC.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = com.tencent.mm.plugin.websearch.api.aj.Uu(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = com.tencent.mm.plugin.websearch.api.aj.Uu(paramString1.optInt("offsetY"));
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
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "the error is e");
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
      Object localObject = new e(com.tencent.mm.loader.j.b.apa().replace("/data/user/0", "/data/data") + "/fts_cache").a(new com.tencent.mm.vfs.g()
      {
        public final boolean accept(e paramAnonymouse)
        {
          AppMethodBeat.i(177342);
          if (q.B(paramAnonymouse.fxV()).equals(this.Cbb))
          {
            AppMethodBeat.o(177342);
            return false;
          }
          AppMethodBeat.o(177342);
          return true;
        }
      });
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.fxW() });
          str1.delete();
          i += 1;
        }
      }
      if (this.CaF == null) {
        break label292;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.CaA.size()) });
      localObject = new HashMap(this.CaA).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.CaA.get(str1)).getTag();
          this.CaF.zd(str2);
          if ((View)this.CaB.get(str1) != null)
          {
            aAE(str1);
            this.CaB.remove(str1);
          }
        }
      }
      this.CaA.clear();
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", bs.m(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.CaC.clear();
    label292:
    this.CaM = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.CaF != null)
    {
      Iterator localIterator = this.CaA.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.CaA.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAB().zb(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.CaF != null)
    {
      Iterator localIterator = this.CaA.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.CaA.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAB().zc(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void t(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.aAC(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  final class d
  {
    boolean Cbq;
    int dib;
    String djj;
    boolean isLoading;
    String jKT;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.djj, this.jKT, Integer.valueOf(this.dib), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int Cag;
    int Cbr;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.Cbr), Integer.valueOf(this.Cag) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */