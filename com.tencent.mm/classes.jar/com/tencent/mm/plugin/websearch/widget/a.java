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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.jk;
import com.tencent.mm.g.b.a.jn;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a
  implements com.tencent.mm.plugin.websearch.api.d
{
  private static u DVH;
  private int DVA;
  private com.tencent.mm.modelappbrand.g DVB;
  private Map<String, e> DVC;
  private Map<String, d> DVD;
  private Map<String, WidgetData> DVE;
  public boolean DVF;
  private com.tencent.mm.plugin.websearch.api.n DVG;
  private WidgetData DVI;
  private Runnable DVJ;
  private String DVK;
  private volatile String DVL;
  private HashMap<String, Object> DVw;
  private HashMap<String, Object> DVx;
  private HashMap<String, Object> DVy;
  private Map<String, String> DVz;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    DVH = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.DVw = new HashMap();
    this.DVx = new HashMap();
    this.DVy = new HashMap();
    this.DVz = new HashMap();
    this.DVA = -1;
    this.DVC = new HashMap();
    this.DVD = new HashMap();
    this.DVE = new HashMap();
    this.DVF = true;
    this.DVL = null;
    this.context = paramContext;
    this.DVG = paramn;
    this.DVB = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class));
    if ((this.DVF) && (new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asj(), "websearch-widget-not-use-tools").exists())) {
      this.DVF = false;
    }
    if (ak.cpe()) {
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
              el localel = new el().oa(a.b(a.this).DUM.hNv);
              localel.ejC = a.b(a.this).DUM.cRx;
              localel.ejz = 21L;
              localel.ejA = System.currentTimeMillis();
              localel.ob(az.iW(ak.getContext())).aLH();
              v.md(30);
              paramn.ePD();
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
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116602);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            a.8.this.DWh.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.DWi.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.kjC, a.8.this.DWh);
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
  
  private void aHs(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.DVE.get(paramString);
      Object localObject2 = (d)this.DVD.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new el().oa(((WidgetData)localObject1).DUM.hNv);
        ((el)localObject2).ejC = ((WidgetData)localObject1).DUM.cRx;
        ((el)localObject2).ejz = 24L;
        localObject1 = ((el)localObject2).nZ(paramString);
        ((el)localObject1).ejA = System.currentTimeMillis();
        ((el)localObject1).ob(az.iW(ak.getContext())).aLH();
      }
      localObject1 = (View)this.DVw.get(paramString);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.DVB != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.DVB.a((String)localObject2, (View)localObject1);
      }
      this.DVw.remove(paramString);
      this.DVy.remove(paramString);
      localObject1 = (View)this.DVx.get(paramString);
      if (localObject1 != null)
      {
        this.DVG.removeView((View)localObject1);
        this.DVx.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u eQu()
  {
    return DVH;
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString)
  {
    AppMethodBeat.i(116615);
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        ar.f(new Runnable()
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
              int j = an.vP(paramWidgetData.DUN.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = an.vP(paramWidgetData.DUN.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = an.vP(paramWidgetData.DUN.kVQ);
                ((AbsoluteLayout.LayoutParams)localObject).y = an.vP(paramWidgetData.DUN.kVR);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.DUN.dKA)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = an.vP(paramWidgetData.DUN.kVQ);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = an.vP(paramWidgetData.DUN.kVR);
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
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
      AppMethodBeat.o(116615);
    }
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(116610);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.cc.a.flD()), Float.valueOf(com.tencent.mm.cb.a.getDensity(ak.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    com.tencent.mm.ipcinvoker.p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.DUM == null) || (paramWidgetData.DUN == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.eQv();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.DUM.hNv });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).fG(a.2.this.DVP, 3);
              AppMethodBeat.o(116578);
            }
          });
          AppMethodBeat.o(116591);
          return;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116590);
            a.a(a.this, a.2.this.DVO);
            a.d(a.this).put(a.2.this.DVP, a.2.this.DVO);
            v.md(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.DVO.DUM.cRx), a.2.this.DVP, str1, a.2.this.DVO.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.DVP);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.DVP, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.eQv();
                  d.b(a.2.this.DVO);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.DVP);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.DVP, localObject2);
                  }
                  ((a.e)localObject2).DWn = ((int)a.2.this.DVO.DUN.DUY);
                  ((a.e)localObject2).DUZ = a.2.this.DVO.DUN.DUZ;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.eQu();
                  u.CM(a.2.this.DVO.DUM.hNv);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)com.tencent.luggage.h.k.du(a.2.this.DVO.DUM.dlk).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.eQu();
                      u.aEf();
                    }
                    localObject2 = new el().oa(a.2.this.DVO.DUM.hNv);
                    if (bool1)
                    {
                      l = 1L;
                      ((el)localObject2).ejD = l;
                      ((el)localObject2).ejC = a.2.this.DVO.DUM.cRx;
                      ((el)localObject2).ejz = 1L;
                      localObject2 = ((el)localObject2).nZ(a.2.this.DVP);
                      ((el)localObject2).ejA = System.currentTimeMillis();
                      ((el)localObject2).ob(az.iW(ak.getContext())).aLH();
                      localObject2 = a.h(a.this).cy(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.z.jV(a.g(a.this)).inflate(2131494230, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, an.vP(a.2.this.DVO.DUN.kVQ), an.vP(a.2.this.DVO.DUN.kVR)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(an.vP(a.2.this.DVO.DUN.width), an.vP(a.2.this.DVO.DUN.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131301515);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.DVP, localObject2);
                      a.j(a.this).put(a.2.this.DVP, localObject3);
                      a.k(a.this).put(a.2.this.DVP, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131301514);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131298824);
                      String str2 = a.2.this.DVO.DUM.hNv + "_" + a.2.this.DVO.DUM.DUQ.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.DVF) {
                        continue;
                      }
                      a.a(a.this, "com.tencent.mm:toolsmp");
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.DVO.DUM.dwb);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.DVO.DUM.hNv);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.DVP);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.DVO.DUM.kid);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.DVO.DUM.DUQ);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.DVO.DUM.bVF);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.DVO.DUM.dlk);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.DVO.DUM.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.DVO.DUM.DUS);
                      ((Bundle)localObject5).putString("init_data", a.2.this.DVO.DUM.DUP);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.DVO.DUM.cRx);
                      i = a.2.this.fNp;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", an.vP(a.2.this.DVO.DUN.width));
                      ((Bundle)localObject5).putInt("view_init_height", an.vP(a.2.this.DVO.DUN.height));
                      ((Bundle)localObject5).putString("query", a.2.this.DVO.DUM.DUQ);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.DVO.DUM.DUR);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.DVO.DUM.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.kkw);
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxe, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).fQd();
                      ((a.d)localObject1).dwb = a.2.this.DVO.DUM.dwb;
                      ((a.d)localObject1).duK = a.2.this.DVO.DUM.DUS;
                      ((a.d)localObject1).pkgVersion = a.2.this.DVO.DUM.version;
                      ((a.d)localObject1).kiu = str2;
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(867L, 0L, 1L, false);
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
                            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(867L, 4L, 1L, false);
                            a.eQu();
                            u.I(a.2.this.DVO.DUM.dwb, false);
                            this.DVS.fQe();
                            this.DVS.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.DVP)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).fG(a.2.this.DVP, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.DVP) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.DVP)).DWm) {
                                break label340;
                              }
                              this.DVS.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.DVT.setVisibility(4);
                              a.c(a.this).fG(a.2.this.DVP, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.DVS.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(867L, 3L, 1L, false);
                            this.DVS.fQe();
                            this.DVS.setVisibility(4);
                            a.c(a.this).fG(a.2.this.DVP, 3);
                            a.eQu();
                            u.I(a.2.this.DVO.DUM.dwb, false);
                            ((a.d)a.e(a.this).get(a.2.this.DVP)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(867L, 2L, 1L, false);
                            this.DVS.setVisibility(4);
                            this.DVT.setVisibility(4);
                            this.DVS.fQe();
                            a.eQu();
                            u.I(a.2.this.DVO.DUM.dwb, true);
                            ((a.d)a.e(a.this).get(a.2.this.DVP)).isLoading = false;
                            a.c(a.this).fG(a.2.this.DVP, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new jk();
                            paramAnonymous3View.dTT = paramAnonymous3View.t("appid", a.2.this.DVO.DUM.hNv, true);
                            paramAnonymous3View.eBP = (System.currentTimeMillis() - l);
                            if (this.DVU)
                            {
                              l = 1L;
                              paramAnonymous3View.ejD = l;
                              paramAnonymous3View.aLH();
                              paramAnonymous3View = new jn();
                              paramAnonymous3View.dQX = 4L;
                              paramAnonymous3View = paramAnonymous3View.sp(a.2.this.DVO.DUM.hNv);
                              paramAnonymous3View.eBP = (System.currentTimeMillis() - l);
                              if (!this.DVU) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.ejD = l;
                              paramAnonymous3View.eCf = a.2.this.kkw;
                              paramAnonymous3View.aLH();
                              d.eQv();
                              d.d(a.2.this.DVO);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).fG(a.2.this.DVP, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.w()
                      {
                        public final void aEg()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.DVP);
                          if (locald != null)
                          {
                            locald.DWm = true;
                            locald.isLoading = false;
                          }
                          v.md(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ac)localObject6).a(new g(a.g(a.this)));
                      ((ac)localObject6).a(new aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.DVP, paramAnonymous3Int, paramAnonymous3t);
                          AppMethodBeat.o(116586);
                        }
                      });
                      ((ac)localObject6).a(new af()
                      {
                        public final void b(boolean paramAnonymous3Boolean1, String paramAnonymous3String, boolean paramAnonymous3Boolean2)
                        {
                          AppMethodBeat.i(116587);
                          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramAnonymous3Boolean1), paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean2) });
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
                            localn.i(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.DVP);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ac)localObject6).a(new ag()
                      {
                        public final void aEj()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.DVP, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ac)localObject6).a(new ah()
                      {
                        public final void CR(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.DVP);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ac)localObject6).a(new ad()
                      {
                        public final void CQ(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116579);
                          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
                          if (!TextUtils.isEmpty(paramAnonymous3String))
                          {
                            Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymous3String))));
                            ((Intent)localObject).addFlags(268435456);
                            if (bu.aj(a.g(a.this), (Intent)localObject))
                            {
                              paramAnonymous3String = a.g(a.this);
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(116579);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onMakePhone null number");
                          AppMethodBeat.o(116579);
                        }
                      });
                      ((ac)localObject6).a(new ai()
                      {
                        public final void CS(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!bu.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).aHf(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.ae()
                      {
                        public final void aT(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!bu.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).kL(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ac)localObject6).a(new aa()
                      {
                        public final void CO(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.eQv();
                          d.b(a.2.this.DVO, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.z()
                      {
                        public final void CN(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.eQv();
                          d.c(a.2.this.DVO, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.DVP);
                      ((Bundle)localObject1).putString("appid", a.2.this.DVO.DUM.dwb);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.DVO.DUM.cRx);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.kkw);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.DVO.DUM.hNv);
                      u.a(a.2.this.DVP, a.2.this.DVO.DUM.cRx, a.2.this.DVO.DUM.dwb, a.2.this.DVO.DUM.hNv, a.2.this.kkw);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.DVP);
                      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.ipcinvoker.g.ahM(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      a.a(a.this, a.2.this.DVO, a.2.this.DVP, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
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
  
  public final void aHd(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.DVD.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.dwb);
      localBundle.putString("msg_id", paramString.kiu);
      localBundle.putInt("pkg_type", paramString.duK);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().d(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void aHe(String paramString)
  {
    AppMethodBeat.i(116612);
    aHs(paramString);
    d.eQv();
    d.c(this.DVI);
    AppMethodBeat.o(116612);
  }
  
  public final void ePz()
  {
    this.DVF = false;
  }
  
  public final void h(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.DVw.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.DWb;
          if (localp == null) {
            com.tencent.mm.sdk.platformtools.ae.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.aS(localb.getName(), localb.eQz()))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).a(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.ch.a.w(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.DWa.equals(a.m(a.this)))
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.DWa });
                a.b(a.this, null);
                a.c(a.this).a(a.7.this.DWa, false, "timeout", a.7.this.kjC);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.DVG.a(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void kK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.cc.a.flD()), Float.valueOf(com.tencent.mm.cb.a.getDensity(ak.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.DVw.get(paramString2);
          View localView2 = (View)this.DVx.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = an.vP(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = an.vP(paramString1.optInt("width"));
              a(localView1, (View)this.DVy.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = an.vP(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = an.vP(paramString1.optInt("offsetY"));
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "the error is e");
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
      Object localObject = new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asc().replace("/data/user/0", "/data/data") + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.fTi() });
          str1.delete();
          i += 1;
        }
      }
      if (this.DVB == null) {
        break label292;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.DVw.size()) });
      localObject = new HashMap(this.DVw).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.DVw.get(str1)).getTag();
          this.DVB.CE(str2);
          if ((View)this.DVx.get(str1) != null)
          {
            aHs(str1);
            this.DVx.remove(str1);
          }
        }
      }
      this.DVw.clear();
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", bu.o(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.DVy.clear();
    label292:
    this.DVI = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.DVB != null)
    {
      Iterator localIterator = this.DVw.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.DVw.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDU().CC(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.DVB != null)
    {
      Iterator localIterator = this.DVw.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.DVw.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDU().CD(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.aHq(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  final class d
  {
    boolean DWm;
    int duK;
    String dwb;
    boolean isLoading;
    String kiu;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.dwb, this.kiu, Integer.valueOf(this.duK), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int DUZ;
    int DWn;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.DWn), Integer.valueOf(this.DUZ) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */