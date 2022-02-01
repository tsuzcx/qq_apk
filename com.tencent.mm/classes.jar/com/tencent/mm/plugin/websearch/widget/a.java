package com.tencent.mm.plugin.websearch.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
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
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.autogen.mmdata.rpt.uc;
import com.tencent.mm.autogen.mmdata.rpt.uf;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.xweb.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.websearch.api.d
{
  private static com.tencent.mm.modelappbrand.u Wsz;
  private WidgetData WsA;
  private Runnable WsB;
  private String WsC;
  private volatile String WsD;
  private HashMap<String, Object> Wso;
  private HashMap<String, Object> Wsp;
  private HashMap<String, Object> Wsq;
  private Map<String, String> Wsr;
  private int Wss;
  private com.tencent.mm.modelappbrand.h Wst;
  private Map<String, e> Wsu;
  private Map<String, d> Wsv;
  private Map<String, WidgetData> Wsw;
  public boolean Wsx;
  private com.tencent.mm.plugin.websearch.api.n Wsy;
  private Context context;
  
  static
  {
    AppMethodBeat.i(116627);
    Wsz = new com.tencent.mm.modelappbrand.u();
    AppMethodBeat.o(116627);
  }
  
  public a(Context paramContext, final com.tencent.mm.plugin.websearch.api.n paramn)
  {
    AppMethodBeat.i(116608);
    this.Wso = new HashMap();
    this.Wsp = new HashMap();
    this.Wsq = new HashMap();
    this.Wsr = new HashMap();
    this.Wss = -1;
    this.Wsu = new HashMap();
    this.Wsv = new HashMap();
    this.Wsw = new HashMap();
    this.Wsx = true;
    this.WsD = null;
    this.context = paramContext;
    this.Wsy = paramn;
    this.Wst = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class));
    if ((this.Wsx) && (new com.tencent.mm.vfs.u(com.tencent.mm.loader.i.b.bmz(), "websearch-widget-not-use-tools").jKS())) {
      this.Wsx = false;
    }
    if (MMApplicationContext.isMMProcess()) {
      j.b(SupportProcessIPCService.PROCESS_NAME, new com.tencent.mm.ipcinvoker.p()
      {
        public final void onDisconnect()
        {
          AppMethodBeat.i(116577);
          if (SupportProcessIPCService.PROCESS_NAME.equals(a.a(a.this)))
          {
            com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "support process dead", new Object[0]);
            if (a.b(a.this) != null)
            {
              mn localmn = new mn().uY(a.b(a.this).Wqn.oqe);
              localmn.iKD = a.b(a.this).Wqn.serviceType;
              localmn.jbJ = 21L;
              localmn.jbK = System.currentTimeMillis();
              localmn.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
              v.rG(30);
              paramn.ipL();
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
            a.8.this.WsZ.setLayoutParams(localLayoutParams1);
            localLayoutParams2.height = i;
            a.8.this.Wta.setLayoutParams(localLayoutParams2);
            AppMethodBeat.o(116600);
          }
        });
        localValueAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(116601);
            a.a(a.this, a.8.this.rly, a.8.this.WsZ);
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
  
  private void biP(String paramString)
  {
    AppMethodBeat.i(116613);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = (WidgetData)this.Wsw.get(paramString);
      Object localObject2 = (d)this.Wsv.get(paramString);
      if ((localObject1 != null) && (localObject2 != null) && (((d)localObject2).isLoading))
      {
        localObject2 = new mn().uY(((WidgetData)localObject1).Wqn.oqe);
        ((mn)localObject2).iKD = ((WidgetData)localObject1).Wqn.serviceType;
        ((mn)localObject2).jbJ = 24L;
        localObject1 = ((mn)localObject2).uX(paramString);
        ((mn)localObject1).jbK = System.currentTimeMillis();
        ((mn)localObject1).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
      }
      localObject1 = (View)this.Wso.get(paramString);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
        AppMethodBeat.o(116613);
        return;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { ((View)localObject1).getTag().toString() });
      if (this.Wst != null)
      {
        localObject2 = (String)((View)localObject1).getTag();
        this.Wst.b((String)localObject2, (View)localObject1);
      }
      this.Wso.remove(paramString);
      this.Wsq.remove(paramString);
      localObject1 = (View)this.Wsp.get(paramString);
      if (localObject1 != null)
      {
        this.Wsy.removeView((View)localObject1);
        this.Wsp.remove(paramString);
      }
    }
    AppMethodBeat.o(116613);
  }
  
  public static com.tencent.mm.modelappbrand.u ira()
  {
    return Wsz;
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
              int j = at.DD(paramWidgetData.Wqo.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = at.DD(paramWidgetData.Wqo.width);
              a.a(a.this, localView1, (View)a.k(a.this).get(paramString), i, j, k, m, paramString);
              localObject = localView2.getLayoutParams();
              if ((localObject instanceof AbsoluteLayout.LayoutParams))
              {
                localObject = (AbsoluteLayout.LayoutParams)localObject;
                ((AbsoluteLayout.LayoutParams)localObject).x = at.DD(paramWidgetData.Wqo.sep);
                ((AbsoluteLayout.LayoutParams)localObject).y = at.DD(paramWidgetData.Wqo.ser);
                localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              while (paramWidgetData.Wqo.icp)
              {
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                AppMethodBeat.o(116597);
                return;
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = at.DD(paramWidgetData.Wqo.sep);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = at.DD(paramWidgetData.Wqo.ser);
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
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", new Object[] { Float.valueOf(com.tencent.mm.ce.c.iRA()), Float.valueOf(com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(ao.getUsingCustomContext()) });
    s.F(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116591);
        if ((paramWidgetData == null) || (paramWidgetData.Wqn == null) || (paramWidgetData.Wqo == null))
        {
          AppMethodBeat.o(116591);
          return;
        }
        d.irb();
        if (!d.a(paramWidgetData))
        {
          com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { paramWidgetData.Wqn.oqe });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116578);
              a.c(a.this).hL(a.2.this.WsH, 3);
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
            a.a(a.this, a.2.this.WsG);
            a.d(a.this).put(a.2.this.WsH, a.2.this.WsG);
            v.rG(0);
            final String str1 = "sessionid_" + System.currentTimeMillis();
            com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(a.2.this.WsG.Wqn.serviceType), a.2.this.WsH, str1, a.2.this.WsG.toString() });
            Object localObject1 = (a.d)a.e(a.this).get(a.2.this.WsH);
            if (localObject1 == null)
            {
              localObject1 = new a.d(a.this, (byte)0);
              a.e(a.this).put(a.2.this.WsH, localObject1);
            }
            for (;;)
            {
              ((a.d)localObject1).isLoading = true;
              for (;;)
              {
                boolean bool2;
                try
                {
                  d.irb();
                  d.b(a.2.this.WsG);
                  Object localObject3 = (a.e)a.f(a.this).get(a.2.this.WsH);
                  Object localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new a.e(a.this, (byte)0);
                    a.f(a.this).put(a.2.this.WsH, localObject2);
                  }
                  ((a.e)localObject2).Wtf = ((int)a.2.this.WsG.Wqo.Wqx);
                  ((a.e)localObject2).Wqy = a.2.this.WsG.Wqo.Wqy;
                  Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
                  a.ira();
                  com.tencent.mm.modelappbrand.u.KS(a.2.this.WsG.Wqn.oqe);
                  boolean bool1;
                  if (!TextUtils.isEmpty((CharSequence)m.fM(a.2.this.WsG.Wqn.hzy).get("widgetData")))
                  {
                    bool1 = true;
                    if (bool1)
                    {
                      a.ira();
                      com.tencent.mm.modelappbrand.u.bES();
                    }
                    localObject2 = new mn().uY(a.2.this.WsG.Wqn.oqe);
                    if (bool1)
                    {
                      l = 1L;
                      ((mn)localObject2).jbM = l;
                      ((mn)localObject2).iKD = a.2.this.WsG.Wqn.serviceType;
                      ((mn)localObject2).jbJ = 1L;
                      localObject2 = ((mn)localObject2).uX(a.2.this.WsH);
                      ((mn)localObject2).jbK = System.currentTimeMillis();
                      ((mn)localObject2).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
                      localObject2 = a.h(a.this).dM(a.g(a.this));
                      localObject3 = (AbsoluteLayout)com.tencent.mm.ui.af.mU(a.g(a.this)).inflate(a.f.fts_widget_layout, null);
                      ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, at.DD(a.2.this.WsG.Wqo.sep), at.DD(a.2.this.WsG.Wqo.ser)));
                      Object localObject4 = new AbsoluteLayout.LayoutParams(at.DD(a.2.this.WsG.Wqo.width), at.DD(a.2.this.WsG.Wqo.height), 0, 0);
                      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).addView((View)localObject2);
                      Object localObject5 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.e.loading_view_layout);
                      ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                      ((AbsoluteLayout)localObject3).removeView((View)localObject5);
                      ((AbsoluteLayout)localObject3).addView((View)localObject5);
                      ((View)localObject2).setTag(str1);
                      a.i(a.this).put(a.2.this.WsH, localObject2);
                      a.j(a.this).put(a.2.this.WsH, localObject3);
                      a.k(a.this).put(a.2.this.WsH, localObject5);
                      localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.e.loading_view);
                      Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(com.tencent.mm.plugin.websearch.a.e.cover_iv);
                      String str2 = a.2.this.WsG.Wqn.oqe + "_" + a.2.this.WsG.Wqn.Wqr.hashCode();
                      localObject5 = new Bundle();
                      if (!a.this.Wsx) {
                        continue;
                      }
                      a.a(a.this, ToolsMpProcessIPCService.PROCESS_NAME);
                      ((Bundle)localObject5).putString("exec_process_name", a.a(a.this));
                      ((Bundle)localObject5).putString("app_id", a.2.this.WsG.Wqn.appid);
                      ((Bundle)localObject5).putString("src_app_id", a.2.this.WsG.Wqn.oqe);
                      ((Bundle)localObject5).putString("wxa_unique_id", a.2.this.WsH);
                      ((Bundle)localObject5).putString("msg_id", str2);
                      ((Bundle)localObject5).putString("search_id", a.2.this.WsG.Wqn.mpa);
                      ((Bundle)localObject5).putString("cache_key", a.2.this.WsG.Wqn.Wqr);
                      ((Bundle)localObject5).putString("msg_title", a.2.this.WsG.Wqn.nickName);
                      ((Bundle)localObject5).putString("msg_path", a.2.this.WsG.Wqn.hzy);
                      ((Bundle)localObject5).putInt("pkg_version", a.2.this.WsG.Wqn.version);
                      ((Bundle)localObject5).putInt("msg_pkg_type", a.2.this.WsG.Wqn.tgv);
                      ((Bundle)localObject5).putString("init_data", a.2.this.WsG.Wqn.Wqq);
                      ((Bundle)localObject5).putInt("widget_type", 1);
                      ((Bundle)localObject5).putInt("service_type", a.2.this.WsG.Wqn.serviceType);
                      i = a.2.this.lyQ;
                      if (i != 201) {
                        break label2036;
                      }
                      i = 1006;
                      ((Bundle)localObject5).putInt("scene", i);
                      ((Bundle)localObject5).putInt("view_init_width", at.DD(a.2.this.WsG.Wqo.width));
                      ((Bundle)localObject5).putInt("view_init_height", at.DD(a.2.this.WsG.Wqo.height));
                      ((Bundle)localObject5).putString("query", a.2.this.WsG.Wqn.Wqr);
                      ((Bundle)localObject5).putString("preload_launch_data", a.2.this.WsG.Wqn.Wqs);
                      ((Bundle)localObject5).putString("preload_download_data", a.2.this.WsG.Wqn.downloadUrl);
                      ((Bundle)localObject5).putInt("draw_strategy", a.2.this.rms);
                      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHO, 0) != 1) {
                        break label2081;
                      }
                      bool2 = true;
                      ((Bundle)localObject5).putBoolean("use_predraw", bool2);
                      ((ThreeDotsLoadingView)localObject4).setVisibility(0);
                      ((ImageView)localObject6).setVisibility(4);
                      ((ThreeDotsLoadingView)localObject4).jFe();
                      ((a.d)localObject1).appid = a.2.this.WsG.Wqn.appid;
                      ((a.d)localObject1).hJK = a.2.this.WsG.Wqn.tgv;
                      ((a.d)localObject1).pkgVersion = a.2.this.WsG.Wqn.version;
                      ((a.d)localObject1).rks = str2;
                      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
                      l = System.currentTimeMillis();
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(867L, 0L, 1L, false);
                      localObject6 = new ab(new com.tencent.mm.modelappbrand.i()
                      {
                        public final void S(View paramAnonymous3View, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(116584);
                          com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { str1, Integer.valueOf(paramAnonymous3Int) });
                          a.a(a.this, paramAnonymous3Int);
                          switch (paramAnonymous3Int)
                          {
                          case 2: 
                          case 3: 
                          default: 
                            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(867L, 4L, 1L, false);
                            a.ira();
                            com.tencent.mm.modelappbrand.u.P(a.2.this.WsG.Wqn.appid, false);
                            this.WsK.jFf();
                            this.WsK.setVisibility(4);
                            ((a.d)a.e(a.this).get(a.2.this.WsH)).isLoading = false;
                            if (paramAnonymous3Int == 2)
                            {
                              a.c(a.this).hL(a.2.this.WsH, 4);
                              AppMethodBeat.o(116584);
                              return;
                            }
                            break;
                          case 0: 
                            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(867L, 1L, 1L, false);
                            if (a.e(a.this).get(a.2.this.WsH) != null)
                            {
                              if (!((a.d)a.e(a.this).get(a.2.this.WsH)).Wte) {
                                break label340;
                              }
                              this.WsK.setVisibility(8);
                            }
                            for (;;)
                            {
                              this.WsL.setVisibility(4);
                              a.c(a.this).hL(a.2.this.WsH, 1);
                              AppMethodBeat.o(116584);
                              return;
                              this.WsK.setVisibility(0);
                            }
                          case 1: 
                            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(867L, 3L, 1L, false);
                            this.WsK.jFf();
                            this.WsK.setVisibility(4);
                            a.c(a.this).hL(a.2.this.WsH, 3);
                            a.ira();
                            com.tencent.mm.modelappbrand.u.P(a.2.this.WsG.Wqn.appid, false);
                            ((a.d)a.e(a.this).get(a.2.this.WsH)).isLoading = false;
                            AppMethodBeat.o(116584);
                            return;
                          case 4: 
                            label340:
                            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(867L, 2L, 1L, false);
                            this.WsK.setVisibility(4);
                            this.WsL.setVisibility(4);
                            this.WsK.jFf();
                            a.ira();
                            com.tencent.mm.modelappbrand.u.P(a.2.this.WsG.Wqn.appid, true);
                            ((a.d)a.e(a.this).get(a.2.this.WsH)).isLoading = false;
                            a.c(a.this).hL(a.2.this.WsH, 2);
                            com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            paramAnonymous3View = new uc();
                            paramAnonymous3View.ipx = paramAnonymous3View.F("appid", a.2.this.WsG.Wqn.oqe, true);
                            paramAnonymous3View.jbP = (System.currentTimeMillis() - l);
                            if (this.WsM)
                            {
                              l = 1L;
                              paramAnonymous3View.jbM = l;
                              paramAnonymous3View.bMH();
                              paramAnonymous3View = new uf();
                              paramAnonymous3View.ila = 4L;
                              paramAnonymous3View = paramAnonymous3View.Ac(a.2.this.WsG.Wqn.oqe);
                              paramAnonymous3View.jbP = (System.currentTimeMillis() - l);
                              if (!this.WsM) {
                                break label802;
                              }
                            }
                            label802:
                            for (long l = 1L;; l = 2L)
                            {
                              paramAnonymous3View.jbM = l;
                              paramAnonymous3View.jFQ = a.2.this.rms;
                              paramAnonymous3View.bMH();
                              d.irb();
                              d.d(a.2.this.WsG);
                              AppMethodBeat.o(116584);
                              return;
                              l = 2L;
                              break;
                            }
                          }
                          a.c(a.this).hL(a.2.this.WsH, 3);
                          AppMethodBeat.o(116584);
                        }
                      });
                      ((ab)localObject6).a(new w()
                      {
                        public final void bET()
                        {
                          AppMethodBeat.i(116585);
                          a.d locald = (a.d)a.e(a.this).get(a.2.this.WsH);
                          if (locald != null)
                          {
                            locald.Wte = true;
                            locald.isLoading = false;
                          }
                          v.rG(33);
                          AppMethodBeat.o(116585);
                        }
                      });
                      ((ab)localObject6).a(new f(a.g(a.this)));
                      ((ab)localObject6).a(new ai()
                      {
                        public final void a(int paramAnonymous3Int, t paramAnonymous3t)
                        {
                          AppMethodBeat.i(116586);
                          a.a(a.this, a.2.this.WsH, paramAnonymous3Int, paramAnonymous3t);
                          AppMethodBeat.o(116586);
                        }
                      });
                      ((ab)localObject6).a(new ae()
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
                            localn.l(paramAnonymous3String, paramAnonymous3Boolean2, a.2.this.WsH);
                            AppMethodBeat.o(116587);
                            return;
                            label134:
                            paramAnonymous3Boolean2 = false;
                          }
                        }
                      });
                      ((ab)localObject6).a(new com.tencent.mm.modelappbrand.af()
                      {
                        public final void bEW()
                        {
                          AppMethodBeat.i(116588);
                          a.a(a.this, a.2.this.WsH, this.val$view);
                          AppMethodBeat.o(116588);
                        }
                      });
                      ((ab)localObject6).a(new ag()
                      {
                        public final void KX(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116589);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
                          a.a(a.this, paramAnonymous3String, a.2.this.WsH);
                          AppMethodBeat.o(116589);
                        }
                      });
                      ((ab)localObject6).a(new a.2.2.2(this));
                      ((ab)localObject6).a(new ah()
                      {
                        public final void KY(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116580);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymous3String });
                          paramAnonymous3String = a.c(a.this, paramAnonymous3String);
                          if (!Util.isNullOrNil(paramAnonymous3String))
                          {
                            a.c(a.this).bit(paramAnonymous3String);
                            AppMethodBeat.o(116580);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                          AppMethodBeat.o(116580);
                        }
                      });
                      ((ab)localObject6).a(new ad()
                      {
                        public final void bl(String paramAnonymous3String1, String paramAnonymous3String2)
                        {
                          AppMethodBeat.i(116581);
                          Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                          paramAnonymous3String1 = a.c(a.this, paramAnonymous3String1);
                          if (!Util.isNullOrNil(paramAnonymous3String1))
                          {
                            a.c(a.this).nS(paramAnonymous3String1, paramAnonymous3String2);
                            AppMethodBeat.o(116581);
                            return;
                          }
                          Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                          AppMethodBeat.o(116581);
                        }
                      });
                      ((ab)localObject6).a(new z()
                      {
                        public final void KU(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116582);
                          d.irb();
                          d.b(a.2.this.WsG, paramAnonymous3String);
                          AppMethodBeat.o(116582);
                        }
                      });
                      ((ab)localObject6).a(new y()
                      {
                        public final void KT(String paramAnonymous3String)
                        {
                          AppMethodBeat.i(116583);
                          d.irb();
                          d.c(a.2.this.WsG, paramAnonymous3String);
                          AppMethodBeat.o(116583);
                        }
                      });
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("id", a.2.this.WsH);
                      ((Bundle)localObject1).putString("appid", a.2.this.WsG.Wqn.appid);
                      ((Bundle)localObject1).putInt("serviceType", a.2.this.WsG.Wqn.serviceType);
                      ((Bundle)localObject1).putInt("drawStrategy", a.2.this.rms);
                      ((Bundle)localObject1).putString("srcAppid", a.2.this.WsG.Wqn.oqe);
                      com.tencent.mm.modelappbrand.u.a(a.2.this.WsH, a.2.this.WsG.Wqn.serviceType, a.2.this.WsG.Wqn.appid, a.2.this.WsG.Wqn.oqe, a.2.this.rms);
                      localObject5 = a.h(a.this).a(str1, (View)localObject2, (Bundle)localObject5, (aa)localObject6);
                      a.l(a.this).put(localObject5, a.2.this.WsH);
                      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      j.a(a.a(a.this), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      j.a(com.tencent.mm.ipcinvoker.i.aYs(), (Parcelable)localObject1, a.b.class, new com.tencent.mm.ipcinvoker.f() {});
                      a.a(a.this, a.2.this.WsG, a.2.this.WsH, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
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
  
  public final void bir(String paramString)
  {
    AppMethodBeat.i(116609);
    paramString = (d)this.Wsv.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.appid);
      localBundle.putString("msg_id", paramString.rks);
      localBundle.putInt("pkg_type", paramString.hJK);
      localBundle.putInt("pkg_version", paramString.pkgVersion);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().e(this.context, localBundle);
    }
    AppMethodBeat.o(116609);
  }
  
  public final void bis(String paramString)
  {
    AppMethodBeat.i(116612);
    biP(paramString);
    d.irb();
    d.c(this.WsA);
    AppMethodBeat.o(116612);
  }
  
  public final void i(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(116619);
    com.tencent.mm.modelappbrand.u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.Wso.get(paramString1);
    if (localView != null)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116599);
          com.tencent.mm.plugin.websearch.widget.c.b localb = new com.tencent.mm.plugin.websearch.widget.c.b(paramInt1, paramInt2, paramString2);
          com.tencent.mm.modelappbrand.p localp = this.WsT;
          if (localp == null) {
            Log.e("BaseJsapiEvent", "null JSBridgeAccessible ");
          }
          for (boolean bool = false; !bool; bool = localp.bk(localb.getName(), localb.ire()))
          {
            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { paramString1 });
            a.c(a.this).c(paramString2, false, "onTap fail: execute js event  " + paramString1, paramString1);
            AppMethodBeat.o(116599);
            return;
          }
          a.b(a.this, paramString2);
          com.tencent.mm.ci.a.C(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116598);
              if (a.7.this.WsS.equals(a.m(a.this)))
              {
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { a.7.this.WsS });
                a.b(a.this, null);
                a.c(a.this).c(a.7.this.WsS, false, "timeout", a.7.this.rly);
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
    this.Wsy.c(paramString2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(paramString1)), paramString1);
    AppMethodBeat.o(116619);
  }
  
  public final void ipJ()
  {
    this.Wsx = false;
  }
  
  public final void nR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116614);
    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", new Object[] { Float.valueOf(com.tencent.mm.ce.c.iRA()), Float.valueOf(com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(ao.getUsingCustomContext()), paramString2, paramString1 });
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          View localView1 = (View)this.Wso.get(paramString2);
          View localView2 = (View)this.Wsp.get(paramString2);
          if (localView1 != null)
          {
            AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
            AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
            if ((paramString1.has("width")) || (paramString1.has("height")))
            {
              int i = localLayoutParams1.height;
              int j = at.DD(paramString1.optInt("height"));
              int k = localLayoutParams1.width;
              int m = at.DD(paramString1.optInt("width"));
              a(localView1, (View)this.Wsq.get(paramString2), i, j, k, m, paramString2);
            }
            if (paramString1.has("offsetX")) {
              localLayoutParams2.x = at.DD(paramString1.optInt("offsetX"));
            }
            if (paramString1.has("offsetY")) {
              localLayoutParams2.y = at.DD(paramString1.optInt("offsetY"));
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
      Object localObject = new com.tencent.mm.vfs.u(com.tencent.mm.loader.i.b.bms() + "/fts_cache").a(new a.4(this, ""));
      String str1;
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          str1 = localObject[i];
          com.tencent.mm.modelappbrand.u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", new Object[] { str1.jKU() });
          str1.diJ();
          i += 1;
        }
      }
      if (this.Wst == null) {
        break label283;
      }
      Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.Wso.size()) });
      localObject = new HashMap(this.Wso).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.Wso.get(str1)).getTag();
          this.Wst.KK(str2);
          if ((View)this.Wsp.get(str1) != null)
          {
            biP(str1);
            this.Wsp.remove(str1);
          }
        }
      }
      this.Wso.clear();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", Util.stackTraceToString(localException));
      AppMethodBeat.o(116618);
      return;
    }
    this.Wsq.clear();
    label283:
    this.WsA = null;
    AppMethodBeat.o(116618);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(116617);
    if (this.Wst != null)
    {
      Iterator localIterator = this.Wso.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.Wso.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().KI(str);
        }
      }
    }
    AppMethodBeat.o(116617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(116616);
    if (this.Wst != null)
    {
      Iterator localIterator = this.Wso.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.Wso.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().KJ(str);
        }
      }
    }
    AppMethodBeat.o(116616);
  }
  
  public final void w(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116611);
    a(WidgetData.biE(paramString1), paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(116611);
  }
  
  final class d
  {
    boolean Wte;
    String appid;
    int hJK;
    boolean isLoading;
    int pkgVersion;
    String rks;
    
    private d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116606);
      String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.appid, this.rks, Integer.valueOf(this.hJK), Integer.valueOf(this.pkgVersion) });
      AppMethodBeat.o(116606);
      return str;
    }
  }
  
  final class e
  {
    int Wqy;
    int Wtf;
    
    private e() {}
    
    public final String toString()
    {
      AppMethodBeat.i(116607);
      String str = String.format("minH %d, maxH %d", new Object[] { Integer.valueOf(this.Wtf), Integer.valueOf(this.Wqy) });
      AppMethodBeat.o(116607);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */