package com.tencent.mm.plugin.websearch.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Map;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2) {}
  
  public final void run()
  {
    a.a(this.qWI.qWF, this.qWI.qWG);
    v.jdMethod_if(0);
    String str1 = "sessionid_" + System.currentTimeMillis();
    u.i("FTSSearchWidgetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", new Object[] { this.qWI.qWH, str1, this.qWI.qWG.toString() });
    Object localObject1 = (a.c)a.c(this.qWI.qWF).get(this.qWI.qWH);
    if (localObject1 == null)
    {
      localObject1 = new a.c(this.qWI.qWF, (byte)0);
      a.c(this.qWI.qWF).put(this.qWI.qWH, localObject1);
    }
    label1963:
    label1968:
    for (;;)
    {
      boolean bool;
      long l;
      int i;
      try
      {
        d.caf();
        d.b(this.qWI.qWG);
        Object localObject3 = (a.d)a.d(this.qWI.qWF).get(this.qWI.qWH);
        Object localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new a.d(this.qWI.qWF, (byte)0);
          a.d(this.qWI.qWF).put(this.qWI.qWH, localObject2);
        }
        ((a.d)localObject2).qXc = ((int)this.qWI.qWG.qVp.qVD);
        ((a.d)localObject2).qVE = this.qWI.qWG.qVp.qVE;
        com.tencent.mm.sdk.platformtools.y.i("FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.d)localObject2).toString() });
        a.cae();
        u.jA(this.qWI.qWG.qVo.dZY);
        if (TextUtils.isEmpty((CharSequence)com.tencent.luggage.j.g.bj(this.qWI.qWG.qVo.bFw).get("widgetData"))) {
          break label1963;
        }
        bool = true;
        if (bool)
        {
          a.cae();
          u.Jz();
        }
        localObject2 = new com.tencent.mm.h.b.a.r();
        ((com.tencent.mm.h.b.a.r)localObject2).cjv = this.qWI.qWG.qVo.dZY;
        if (!bool) {
          break label1968;
        }
        l = 1L;
        ((com.tencent.mm.h.b.a.r)localObject2).cjx = l;
        ((com.tencent.mm.h.b.a.r)localObject2).cjw = this.qWI.qWG.qVo.dWx;
        ((com.tencent.mm.h.b.a.r)localObject2).cjs = 1L;
        ((com.tencent.mm.h.b.a.r)localObject2).cjr = this.qWI.qWH;
        ((com.tencent.mm.h.b.a.r)localObject2).cjt = System.currentTimeMillis();
        ((com.tencent.mm.h.b.a.r)localObject2).cjy = aq.fH(ae.getContext());
        ((com.tencent.mm.h.b.a.r)localObject2).QX();
        localObject2 = a.f(this.qWI.qWF).bt(a.e(this.qWI.qWF));
        localObject3 = (AbsoluteLayout)com.tencent.mm.ui.y.gt(a.e(this.qWI.qWF)).inflate(com.tencent.mm.plugin.websearch.a.b.fts_widget_layout, null);
        ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.offsetX), com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.offsetY)));
        Object localObject5 = new AbsoluteLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.width), com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.height), 0, 0);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((AbsoluteLayout)localObject3).addView((View)localObject2);
        Object localObject4 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(a.a.loading_view_layout);
        ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((AbsoluteLayout)localObject3).removeView((View)localObject4);
        ((AbsoluteLayout)localObject3).addView((View)localObject4);
        try
        {
          ((View)localObject2).setBackgroundColor(Color.parseColor(this.qWI.qWG.qVp.fNR));
          ((View)localObject2).setTag(str1);
          a.g(this.qWI.qWF).put(this.qWI.qWH, localObject2);
          a.h(this.qWI.qWF).put(this.qWI.qWH, localObject3);
          a.i(this.qWI.qWF).put(this.qWI.qWH, localObject4);
          localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(a.a.loading_view);
          ImageView localImageView = (ImageView)((AbsoluteLayout)localObject3).findViewById(a.a.cover_iv);
          String str2 = this.qWI.qWG.qVo.dZY + "_" + this.qWI.qWG.qVo.qVt.hashCode();
          localObject5 = new Bundle();
          if (this.qWI.qWF.qWx)
          {
            a.a(this.qWI.qWF, "com.tencent.mm:tools");
            ((Bundle)localObject5).putString("exec_process_name", a.a(this.qWI.qWF));
            ((Bundle)localObject5).putString("app_id", this.qWI.qWG.qVo.bOL);
            ((Bundle)localObject5).putString("src_app_id", this.qWI.qWG.qVo.dZY);
            ((Bundle)localObject5).putString("wxa_unique_id", this.qWI.qWH);
            ((Bundle)localObject5).putString("msg_id", str2);
            ((Bundle)localObject5).putString("search_id", this.qWI.qWG.qVo.fTF);
            ((Bundle)localObject5).putString("cache_key", this.qWI.qWG.qVo.qVt);
            ((Bundle)localObject5).putString("msg_title", this.qWI.qWG.qVo.aVr);
            ((Bundle)localObject5).putString("msg_path", this.qWI.qWG.qVo.bFw);
            ((Bundle)localObject5).putInt("pkg_version", this.qWI.qWG.qVo.version);
            ((Bundle)localObject5).putInt("msg_pkg_type", this.qWI.qWG.qVo.qVv);
            ((Bundle)localObject5).putString("init_data", this.qWI.qWG.qVo.qVs);
            ((Bundle)localObject5).putInt("widget_type", 1);
            ((Bundle)localObject5).putInt("service_type", this.qWI.qWG.qVo.dWx);
            i = this.qWI.egz;
            if (i != 201) {
              break label1915;
            }
            i = 1006;
            ((Bundle)localObject5).putInt("scene", i);
            ((Bundle)localObject5).putInt("view_init_width", com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.width));
            ((Bundle)localObject5).putInt("view_init_height", com.tencent.mm.cb.a.fromDPToPix(a.e(this.qWI.qWF), this.qWI.qWG.qVp.height));
            ((Bundle)localObject5).putString("query", this.qWI.qWG.qVo.qVt);
            ((Bundle)localObject5).putString("preload_launch_data", this.qWI.qWG.qVo.qVu);
            ((Bundle)localObject5).putString("preload_download_data", this.qWI.qWG.qVo.downloadUrl);
            ((Bundle)localObject5).putInt("draw_strategy", this.qWI.fVY);
            ((ThreeDotsLoadingView)localObject4).setVisibility(0);
            localImageView.setVisibility(4);
            ((ThreeDotsLoadingView)localObject4).cKb();
            ((a.c)localObject1).bOL = this.qWI.qWG.qVo.bOL;
            ((a.c)localObject1).bOa = this.qWI.qWG.qVo.qVv;
            ((a.c)localObject1).fEN = this.qWI.qWG.qVo.version;
            ((a.c)localObject1).fTW = str2;
            com.tencent.mm.sdk.platformtools.y.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.c)localObject1).toString() });
            l = System.currentTimeMillis();
            h.nFQ.a(867L, 0L, 1L, false);
            localObject1 = new aa(new a.2.1.1(this, str1, (ThreeDotsLoadingView)localObject4, localImageView, l, bool));
            ((aa)localObject1).a(new g(a.e(this.qWI.qWF)));
            ((aa)localObject1).a(new a.2.1.4(this));
            ((aa)localObject1).a(new ad()
            {
              public final void b(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
              {
                com.tencent.mm.sdk.platformtools.y.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
                com.tencent.mm.sdk.platformtools.y.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramAnonymousBoolean1), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean2) });
                com.tencent.mm.plugin.websearch.api.r localr;
                if (paramAnonymousString.equals(a.k(a.2.1.this.qWI.qWF)))
                {
                  a.b(a.2.1.this.qWI.qWF, null);
                  localr = a.j(a.2.1.this.qWI.qWF);
                  if (!paramAnonymousBoolean1) {
                    break label124;
                  }
                }
                for (;;)
                {
                  localr.e(paramAnonymousString, paramAnonymousBoolean2, a.2.1.this.qWI.qWH);
                  return;
                  label124:
                  paramAnonymousBoolean2 = false;
                }
              }
            });
            ((aa)localObject1).a(new a.2.1.6(this));
            ((aa)localObject1).a(new a.2.1.7(this));
            ((aa)localObject1).a(new a.2.1.8(this));
            ((aa)localObject1).a(new a.2.1.9(this));
            ((aa)localObject1).a(new a.2.1.10(this));
            localObject1 = a.f(this.qWI.qWF).a(str1, (View)localObject2, (Bundle)localObject5, (z)localObject1);
            a.l(this.qWI.qWF).put(localObject1, this.qWI.qWH);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("id", this.qWI.qWH);
            ((Bundle)localObject1).putString("appid", this.qWI.qWG.qVo.bOL);
            ((Bundle)localObject1).putInt("serviceType", this.qWI.qWG.qVo.dWx);
            ((Bundle)localObject1).putInt("drawStrategy", this.qWI.fVY);
            ((Bundle)localObject1).putString("srcAppid", this.qWI.qWG.qVo.dZY);
            f.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new a.2.1.11(this));
            f.a(a.a(this.qWI.qWF), (Parcelable)localObject1, a.b.class, new a.2.1.2(this));
            f.a(com.tencent.mm.ipcinvoker.e.BV(), (Parcelable)localObject1, a.b.class, new a.2.1.3(this));
            a.a(this.qWI.qWF, this.qWI.qWG, this.qWI.qWH, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
            a.j(this.qWI.qWF).addView((View)localObject3);
            return;
          }
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.y.e("FTSSearchWidgetMgr", "the color is error : ");
          continue;
        }
        a.a(this.qWI.qWF, "com.tencent.mm:support");
      }
      catch (Exception localException1)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("FTSSearchWidgetMgr", localException1, "", new Object[0]);
        return;
      }
      continue;
      label1915:
      if (i == 3)
      {
        i = 1005;
      }
      else if (i == 16)
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
        continue;
        bool = false;
        continue;
        l = 2L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.1
 * JD-Core Version:    0.7.0.1
 */