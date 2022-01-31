package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.websearch.api.f
{
  private static u qWz = new u();
  private Context context;
  private WidgetData qWA;
  private Runnable qWB;
  private String qWC;
  private volatile String qWD = null;
  private HashMap<String, Object> qWp = new HashMap();
  private HashMap<String, Object> qWq = new HashMap();
  private HashMap<String, Object> qWr = new HashMap();
  private Map<String, String> qWs = new HashMap();
  private int qWt = -1;
  private com.tencent.mm.modelappbrand.e qWu;
  private Map<String, a.d> qWv = new HashMap();
  private Map<String, a.c> qWw = new HashMap();
  public boolean qWx = true;
  private r qWy;
  
  public a(Context paramContext, r paramr)
  {
    this.context = paramContext;
    this.qWy = paramr;
    this.qWu = ((com.tencent.mm.modelappbrand.e)g.r(com.tencent.mm.modelappbrand.e.class));
    if ((this.qWx) && (new File(com.tencent.mm.compatible.util.e.bkH, "websearch-widget-not-use-tools").exists())) {
      this.qWx = false;
    }
    if (ae.cqV()) {
      com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new a.1(this, paramr));
    }
  }
  
  private void RB(String paramString)
  {
    View localView;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localView = (View)this.qWp.get(paramString);
      if (localView != null) {
        break label43;
      }
      y.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[] { paramString });
    }
    label43:
    do
    {
      return;
      y.i("FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[] { localView.getTag().toString() });
      if (this.qWu != null)
      {
        String str = (String)localView.getTag();
        this.qWu.b(str, localView);
      }
      this.qWp.remove(paramString);
      this.qWr.remove(paramString);
      localView = (View)this.qWq.get(paramString);
    } while (localView == null);
    this.qWy.removeView(localView);
    this.qWq.remove(paramString);
  }
  
  private void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ai.d(new a.6(this, paramInt1, paramInt2, paramInt3, paramInt4, paramView1, paramView2));
  }
  
  public static u cae()
  {
    return qWz;
  }
  
  public final void Ro(String paramString)
  {
    paramString = (a.c)this.qWw.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", paramString.bOL);
      localBundle.putString("msg_id", paramString.fTW);
      localBundle.putInt("pkg_type", paramString.bOa);
      localBundle.putInt("pkg_version", paramString.fEN);
      ((com.tencent.mm.modelappbrand.e)g.r(com.tencent.mm.modelappbrand.e.class)).Jn().d(this.context, localBundle);
    }
  }
  
  public final void Rp(String paramString)
  {
    RB(paramString);
    d.caf();
    d.c(this.qWA);
  }
  
  public final void a(final WidgetData paramWidgetData, final String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0) {
        ai.d(new Runnable()
        {
          public final void run()
          {
            View localView1 = (View)a.g(a.this).get(paramString);
            View localView2 = (View)a.h(a.this).get(paramString);
            Object localObject;
            if (localView1 != null)
            {
              localObject = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
              int i = ((AbsoluteLayout.LayoutParams)localObject).height;
              int j = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.height);
              int k = ((AbsoluteLayout.LayoutParams)localObject).width;
              int m = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.width);
              a.a(a.this, localView1, (View)a.i(a.this).get(paramString), i, j, k, m);
              localObject = localView2.getLayoutParams();
              if (!(localObject instanceof AbsoluteLayout.LayoutParams)) {
                break label278;
              }
              localObject = (AbsoluteLayout.LayoutParams)localObject;
              ((AbsoluteLayout.LayoutParams)localObject).x = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.offsetX);
              ((AbsoluteLayout.LayoutParams)localObject).y = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.offsetY);
              localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            try
            {
              for (;;)
              {
                if (!TextUtils.isEmpty(paramWidgetData.qVp.fNR)) {
                  localView1.setBackgroundColor(Color.parseColor(paramWidgetData.qVp.fNR));
                }
                if (!paramWidgetData.qVp.qVF) {
                  break;
                }
                localView1.setVisibility(0);
                localView2.setVisibility(0);
                return;
                label278:
                if ((localObject instanceof ViewGroup.MarginLayoutParams))
                {
                  localObject = (ViewGroup.MarginLayoutParams)localObject;
                  ((ViewGroup.MarginLayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.offsetX);
                  ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(a.e(a.this), paramWidgetData.qVp.offsetY);
                  localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                y.e("FTSSearchWidgetMgr", bk.j(localException));
              }
              localView1.setVisibility(8);
              localView2.setVisibility(8);
            }
          }
        });
      }
      return;
    }
    catch (Exception paramWidgetData)
    {
      y.printErrStackTrace("FTSSearchWidgetMgr", paramWidgetData, "", new Object[0]);
    }
  }
  
  public final void a(WidgetData paramWidgetData, String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mm.ipcinvoker.l.n(new a.2(this, paramWidgetData, paramString, paramInt2, paramInt1));
  }
  
  public final void bZk()
  {
    this.qWx = false;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    u.v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    View localView = (View)this.qWp.get(paramString1);
    if (localView != null)
    {
      com.tencent.mm.sdk.f.e.post(new a.5(this, paramInt1, paramInt2, paramString2, this.qWu.bN(localView), paramString1), "tapSearchWAWidgetView");
      return;
    }
    y.i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[] { paramString1 });
    this.qWy.a(paramString2, false, "onTap fail: can not find Widget by widgetId " + paramString1, paramString1);
  }
  
  public final void fn(String paramString1, String paramString2)
  {
    y.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", new Object[] { paramString2, paramString1 });
    View localView1;
    View localView2;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          return;
        }
        localView1 = (View)this.qWp.get(paramString2);
        localView2 = (View)this.qWq.get(paramString2);
        if (localView1 == null) {
          return;
        }
        AbsoluteLayout.LayoutParams localLayoutParams1 = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
        AbsoluteLayout.LayoutParams localLayoutParams2 = (AbsoluteLayout.LayoutParams)localView2.getLayoutParams();
        if ((paramString1.has("width")) || (paramString1.has("height")))
        {
          int i = localLayoutParams1.height;
          int j = com.tencent.mm.cb.a.fromDPToPix(this.context, paramString1.optInt("height"));
          int k = localLayoutParams1.width;
          int m = com.tencent.mm.cb.a.fromDPToPix(this.context, paramString1.optInt("width"));
          a(localView1, (View)this.qWr.get(paramString2), i, j, k, m);
        }
        if (paramString1.has("offsetX")) {
          localLayoutParams2.x = com.tencent.mm.cb.a.fromDPToPix(this.context, paramString1.optInt("offsetX"));
        }
        if (paramString1.has("offsetY")) {
          localLayoutParams2.y = com.tencent.mm.cb.a.fromDPToPix(this.context, paramString1.optInt("offsetY"));
        }
        localView2.setLayoutParams(localLayoutParams2);
        boolean bool = paramString1.has("backgroundColor");
        if (bool) {}
        try
        {
          localView1.setBackgroundColor(Color.parseColor(paramString1.getString("backgroundColor")));
          if (!paramString1.has("show")) {
            return;
          }
          if (paramString1.has("show"))
          {
            bool = paramString1.optBoolean("show");
            if (!bool) {
              break;
            }
            localView1.setVisibility(0);
            localView2.setVisibility(0);
            return;
          }
        }
        catch (Exception paramString2)
        {
          y.e("FTSSearchWidgetMgr", bk.j(paramString2));
          continue;
        }
        bool = false;
      }
      catch (Exception paramString1)
      {
        y.e("FTSSearchWidgetMgr", "the error is e");
        return;
      }
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  public final void n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(WidgetData.Rz(paramString1), paramString2, paramInt1, paramInt2);
  }
  
  public final void onDestroy()
  {
    try
    {
      if (this.qWu == null) {
        break label166;
      }
      y.i("FTSSearchWidgetMgr", "remove all widget count %d", new Object[] { Integer.valueOf(this.qWp.size()) });
      Iterator localIterator = new HashMap(this.qWp).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if ((str1 != null) && (str1.length() > 0))
        {
          String str2 = (String)((View)this.qWp.get(str1)).getTag();
          this.qWu.ju(str2);
          if ((View)this.qWq.get(str1) != null)
          {
            RB(str1);
            this.qWq.remove(str1);
          }
        }
      }
      this.qWp.clear();
    }
    catch (Exception localException)
    {
      y.e("FTSSearchWidgetMgr", bk.j(localException));
      return;
    }
    this.qWr.clear();
    label166:
    this.qWA = null;
  }
  
  public final void onPause()
  {
    if (this.qWu != null)
    {
      Iterator localIterator = this.qWp.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.qWp.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.e)g.r(com.tencent.mm.modelappbrand.e.class)).Jm().js(str);
        }
      }
    }
  }
  
  public final void onResume()
  {
    if (this.qWu != null)
    {
      Iterator localIterator = this.qWp.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.length() > 0))
        {
          str = (String)((View)this.qWp.get(str)).getTag();
          ((com.tencent.mm.modelappbrand.e)g.r(com.tencent.mm.modelappbrand.e.class)).Jm().jt(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a
 * JD-Core Version:    0.7.0.1
 */