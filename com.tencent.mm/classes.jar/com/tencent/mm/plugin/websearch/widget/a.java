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
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.ni;
import com.tencent.mm.g.b.a.nl;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.f;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a
  implements com.tencent.mm.plugin.websearch.api.d
{
  private static u IHy;
  private Runnable IHA;
  private String IHB;
  private volatile String IHC;
  private HashMap<String, Object> IHn;
  private HashMap<String, Object> IHo;
  private HashMap<String, Object> IHp;
  private Map<String, String> IHq;
  private int IHr;
  private com.tencent.mm.modelappbrand.g IHs;
  private Map<String, e> IHt;
  private Map<String, d> IHu;
  private Map<String, WidgetData> IHv;
  public boolean IHw;
  private com.tencent.mm.plugin.websearch.api.n IHx;
  private WidgetData IHz;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    IHy = new u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.IHn = new HashMap();
    this.IHo = new HashMap();
    this.IHp = new HashMap();
    this.IHq = new HashMap();
    this.IHr = -1;
    this.IHt = new HashMap();
    this.IHu = new HashMap();
    this.IHv = new HashMap();
    this.IHw = true;
    this.IHC = null;
    this.context = paramContext;
    this.IHx = paramn;
    this.IHs = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class));
    if ((this.IHw) && (new o(com.tencent.mm.loader.j.b.aKJ(), "websearch-widget-not-use-tools").exists())) {
      this.IHw = false;
    }
    if (MMApplicationContext.isMMProcess()) {
      com.tencent.mm.ipcinvoker.h.a(SupportProcessIPCService.dkO, new com.tencent.mm.ipcinvoker.n()
      {
        public final void onDisconnect()
        {
          AppMethodBeat.i(116577);
          if (SupportProcessIPCService.dkO.equals(a.a(a.this)))
          {
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "support process dead", new Object[0]);
            if (a.b(a.this) != null)
            {
              hr localhr = new hr().vt(a.b(a.this).IFG.iIA);
              localhr.eBS = a.b(a.this).IFG.serviceType;
              localhr.eMi = 21L;
              localhr.eMj = System.currentTimeMillis();
              localhr.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
              v.pl(30);
              paramn.fXJ();
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
            a.8.this.IHY.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.IHZ.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.lnl, a.8.this.IHY);
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
  
  private void aXs(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.IHv.get(paramString);
      Object localObject2 = (d)this.IHu.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new hr().vt(((WidgetData)localObject1).IFG.iIA);
        ((hr)localObject2).eBS = ((WidgetData)localObject1).IFG.serviceType;
        ((hr)localObject2).eMi = 24L;
        localObject1 = ((hr)localObject2).vs(paramString);
        ((hr)localObject1).eMj = System.currentTimeMillis();
        ((hr)localObject1).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
      }
      localObject1 = (View)this.IHn.get(paramString);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.IHs != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.IHs.a((String)localObject2, (View)localObject1);
      }
      this.IHn.remove(paramString);
      this.IHp.remove(paramString);
      localObject1 = (View)this.IHo.get(paramString);
      if (localObject1 != null)
      {
        this.IHx.removeView((View)localObject1);
        this.IHo.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static u fYT()
  {
    return IHy;
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
              int j = as.zE(paramWidgetData.IFH.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = as.zE(paramWidgetData.IFH.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = as.zE(paramWidgetData.IFH.maZ);
                ((AbsoluteLayout.LayoutParams)localObject).y = as.zE(paramWidgetData.IFH.mba);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.IFH.eco)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = as.zE(paramWidgetData.IFH.maZ);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = as.zE(paramWidgetData.IFH.mba);
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
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.cc.a.gvp()), Float.valueOf(com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()) });
    com.tencent.mm.ipcinvoker.p.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.IFG == null) || (paramWidgetData.IFH == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.fYU();
        if (!d.a(paramWidgetData))
        {
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.IFG.iIA });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).gd(a.2.this.IHG, 3);
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
            a.a(a.this, a.2.this.IHF);
            a.d(a.this).put(a.2.this.IHG, a.2.this.IHF);
            v.pl(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.IHF.IFG.serviceType), a.2.this.IHG, str1, a.2.this.IHF.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.IHG);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.IHG, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.fYU();
                  d.b(a.2.this.IHF);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.IHG);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.IHG, localObject2);
                  }
                  ((a.e)localObject2).IIe = ((int)a.2.this.IHF.IFH.IFR);
                  ((a.e)localObject2).IFS = a.2.this.IHF.IFH.IFS;
                  Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.fYT();
                  u.Lx(a.2.this.IHF.IFG.iIA);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)l.dN(a.2.this.IHF.IFG.dCx).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.fYT();
                      u.aXS();
                    }
                    localObject2 = new hr().vt(a.2.this.IHF.IFG.iIA);
                    if (bool1)
                    {
                      l = 1L;
                      ((hr)localObject2).eMl = l;
                      ((hr)localObject2).eBS = a.2.this.IHF.IFG.serviceType;
                      ((hr)localObject2).eMi = 1L;
                      localObject2 = ((hr)localObject2).vs(a.2.this.IHG);
                      ((hr)localObject2).eMj = System.currentTimeMillis();
                      ((hr)localObject2).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                      localObject2 = a.h(a.this).cU(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.aa.jQ(a.g(a.this)).inflate(2131494786, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, as.zE(a.2.this.IHF.IFH.maZ), as.zE(a.2.this.IHF.IFH.mba)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(as.zE(a.2.this.IHF.IFH.width), as.zE(a.2.this.IHF.IFH.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131303720);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.IHG, localObject2);
                      a.j(a.this).put(a.2.this.IHG, localObject3);
                      a.k(a.this).put(a.2.this.IHG, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131303719);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131299289);
                      String str2 = a.2.this.IHF.IFG.iIA + "_" + a.2.this.IHF.IFG.IFK.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.IHw) {
                        continue;
                      }
                      a.a(a.this, ToolsMpProcessIPCService.dkO);
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.IHF.IFG.dNI);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.IHF.IFG.iIA);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.IHG);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.IHF.IFG.hes);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.IHF.IFG.IFK);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.IHF.IFG.nickName);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.IHF.IFG.dCx);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.IHF.IFG.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.IHF.IFG.nbf);
                      ((Bundle)localObject5).putString("init_data", a.2.this.IHF.IFG.IFJ);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.IHF.IFG.serviceType);
                      i = a.2.this.gsA;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", as.zE(a.2.this.IHF.IFH.width));
                      ((Bundle)localObject5).putInt("view_init_height", as.zE(a.2.this.IHF.IFH.height));
                      ((Bundle)localObject5).putString("query", a.2.this.IHF.IFG.IFK);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.IHF.IFG.IFL);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.IHF.IFG.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.loh);
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOR, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).gZh();
                      ((a.d)localObject1).dNI = a.2.this.IHF.IFG.dNI;
                      ((a.d)localObject1).dMe = a.2.this.IHF.IFG.nbf;
                      ((a.d)localObject1).pkgVersion = a.2.this.IHF.IFG.version;
                      ((a.d)localObject1).lmc = str2;
                      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(867L, 0L, 1L, false);
                      localObject6 = new ac(new com.tencent.mm.modelappbrand.h()
                      {
                        public final void L(View paramAnonymous3View, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(116584);
                          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { str1, Integer.valueOf(paramAnonymous3Int) });
                          a.a(a.this, paramAnonymous3Int);
                          switch (paramAnonymous3Int)
                          {
                          case 2: 
                          case 3: 
                          default: 
                            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(867L, 4L, 1L, false);
                            a.fYT();
                            u.J(a.2.this.IHF.IFG.dNI, false);
                            this.IHJ.gZi();
                            this.IHJ.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.IHG)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).gd(a.2.this.IHG, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.IHG) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.IHG)).IId) {
                                break label340;
                              }
                              this.IHJ.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.IHK.setVisibility(4);
                              a.c(a.this).gd(a.2.this.IHG, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.IHJ.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(867L, 3L, 1L, false);
                            this.IHJ.gZi();
                            this.IHJ.setVisibility(4);
                            a.c(a.this).gd(a.2.this.IHG, 3);
                            a.fYT();
                            u.J(a.2.this.IHF.IFG.dNI, false);
                            ((a.d)a.e(a.this).get(a.2.this.IHG)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(867L, 2L, 1L, false);
                            this.IHJ.setVisibility(4);
                            this.IHK.setVisibility(4);
                            this.IHJ.gZi();
                            a.fYT();
                            u.J(a.2.this.IHF.IFG.dNI, true);
                            ((a.d)a.e(a.this).get(a.2.this.IHG)).isLoading = false;
                            a.c(a.this).gd(a.2.this.IHG, 2);
                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new ni();
                            paramAnonymous3View.enR = paramAnonymous3View.x("appid", a.2.this.IHF.IFG.iIA, true);
                            paramAnonymous3View.eMp = (System.currentTimeMillis() - l);
                            if (this.IHL)
                            {
                              l = 1L;
                              paramAnonymous3View.eMl = l;
                              paramAnonymous3View.bfK();
                              paramAnonymous3View = new nl();
                              paramAnonymous3View.ejW = 4L;
                              paramAnonymous3View = paramAnonymous3View.AA(a.2.this.IHF.IFG.iIA);
                              paramAnonymous3View.eMp = (System.currentTimeMillis() - l);
                              if (!this.IHL) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.eMl = l;
                              paramAnonymous3View.fgF = a.2.this.loh;
                              paramAnonymous3View.bfK();
                              d.fYU();
                              d.d(a.2.this.IHF);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).gd(a.2.this.IHG, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ac)localObject6).a(new w()
                      {
                        public final void aXT()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.IHG);
                          if (locald != null)
                          {
                            locald.IId = true;
                            locald.isLoading = false;
                          }
                          v.pl(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ac)localObject6).a(new g(a.g(a.this)));
                      ((ac)localObject6).a(new aj()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.IHG, paramAnonymous3Int, paramAnonymous3t);
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
                            localn.i(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.IHG);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ac)localObject6).a(new ag()
                      {
                        public final void aXW()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.IHG, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ac)localObject6).a(new ah()
                      {
                        public final void LC(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.IHG);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ac)localObject6).a(new ad()
                      {
                        public final void LB(String paramAnonymous3String)
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
                              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous3String, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
                        public final void LD(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!Util.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).aXa(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ac)localObject6).a(new ae()
                      {
                        public final void aX(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!Util.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).lH(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ac)localObject6).a(new com.tencent.mm.modelappbrand.aa()
                      {
                        public final void Lz(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.fYU();
                          d.b(a.2.this.IHF, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ac)localObject6).a(new z()
                      {
                        public final void Ly(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.fYU();
                          d.c(a.2.this.IHF, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.IHG);
                      ((Bundle)localObject1).putString("appid", a.2.this.IHF.IFG.dNI);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.IHF.IFG.serviceType);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.loh);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.IHF.IFG.iIA);
                      u.a(a.2.this.IHG, a.2.this.IHF.IFG.serviceType, a.2.this.IHF.IFG.dNI, a.2.this.IHF.IFG.iIA, a.2.this.loh);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (ab)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.IHG);
                      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.ipcinvoker.g.axZ(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.d() {});
                      a.a(a.this, a.2.this.IHF, a.2.this.IHG, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
                  a.a(a.this, SupportProcessIPCService.dkO);
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
  
  public final void aWY(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.IHu.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.dNI);
      localBundle.putString("msg_id", paramString.lmc);
      localBundle.putInt("pkg_type", paramString.dMe);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().d(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void aWZ(String paramString)
  {
    AppMethodBeat.i(116612);
    aXs(paramString);
    d.fYU();
    d.c(this.IHz);
    AppMethodBeat.o(116612);
  }
  
  public final void fXF()
  {
    this.IHw = false;
  }
  
  public final void g(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.IHn.get(paramString1);
    if (localView != null)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.IHS;
          if (localp == null) {
            Log.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.aW(localb.getName(), localb.fYY()))
          {
            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).b(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.ch.a.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.IHR.equals(a.m(a.this)))
              {
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.IHR });
                a.b(a.this, null);
                a.c(a.this).b(a.7.this.IHR, false, "timeout", a.7.this.lnl);
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
    this.IHx.b(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void lG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.cc.a.gvp()), Float.valueOf(com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.IHn.get(paramString2);
          View localView2 = (View)this.IHo.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = as.zE(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = as.zE(paramString1.optInt("width"));
              a(localView1, (View)this.IHp.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = as.zE(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = as.zE(paramString1.optInt("offsetY"));
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
      Object localObject = new o(com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data") + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.hes() });
          str1.delete();
          i += 1;
        }
      }
      if (this.IHs == null) {
        break label292;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.IHn.size()) });
      localObject = new HashMap(this.IHn).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.IHn.get(str1)).getTag();
          this.IHs.Lp(str2);
          if ((View)this.IHo.get(str1) != null)
          {
            aXs(str1);
            this.IHo.remove(str1);
          }
        }
      }
      this.IHn.clear();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", Util.stackTraceToString(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.IHp.clear();
    label292:
    this.IHz = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.IHs != null)
    {
      Iterator localIterator = this.IHn.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.IHn.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().Ln(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.IHs != null)
    {
      Iterator localIterator = this.IHn.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.IHn.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().Lo(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.aXl(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  final class d
  {
    boolean IId;
    int dMe;
    String dNI;
    boolean isLoading;
    String lmc;
    int pkgVersion;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.dNI, this.lmc, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int IFS;
    int IIe;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.IIe), Integer.valueOf(this.IFS) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */