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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.s.p;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Map;

final class a$2$2
  implements Runnable
{
  a$2$2(a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(91391);
    a.a(this.uLU.uLR, this.uLU.uLS);
    a.d(this.uLU.uLR).put(this.uLU.uLT, this.uLU.uLS);
    v.kS(0);
    String str1 = "sessionid_" + System.currentTimeMillis();
    u.i("FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", new Object[] { Integer.valueOf(this.uLU.uLS.uKA.fmF), this.uLU.uLT, str1, this.uLU.uLS.toString() });
    Object localObject1 = (a.d)a.e(this.uLU.uLR).get(this.uLU.uLT);
    if (localObject1 == null)
    {
      localObject1 = new a.d(this.uLU.uLR, (byte)0);
      a.e(this.uLU.uLR).put(this.uLU.uLT, localObject1);
    }
    for (;;)
    {
      ((a.d)localObject1).isLoading = true;
      for (;;)
      {
        int i;
        boolean bool2;
        try
        {
          d.dab();
          d.b(this.uLU.uLS);
          Object localObject3 = (a.e)a.f(this.uLU.uLR).get(this.uLU.uLT);
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new a.e(this.uLU.uLR, (byte)0);
            a.f(this.uLU.uLR).put(this.uLU.uLT, localObject2);
          }
          ((a.e)localObject2).uMr = ((int)this.uLU.uLS.uKB.uKP);
          ((a.e)localObject2).uKQ = this.uLU.uLS.uKB.uKQ;
          com.tencent.mm.sdk.platformtools.ab.i("FTSSearchWidgetMgr", "update widgetSize %s", new Object[] { ((a.e)localObject2).toString() });
          a.daa();
          u.qp(this.uLU.uLS.uKA.fqf);
          boolean bool1;
          long l;
          Object localObject5;
          Object localObject4;
          if (!TextUtils.isEmpty((CharSequence)com.tencent.luggage.g.h.ch(this.uLU.uLS.uKA.cmG).get("widgetData")))
          {
            bool1 = true;
            if (bool1)
            {
              a.daa();
              u.acx();
            }
            localObject2 = new af().fB(this.uLU.uLS.uKA.fqf);
            if (!bool1) {
              continue;
            }
            l = 1L;
            ((af)localObject2).cUm = l;
            ((af)localObject2).cUl = this.uLU.uLS.uKA.fmF;
            ((af)localObject2).cUh = 1L;
            localObject2 = ((af)localObject2).fA(this.uLU.uLT);
            ((af)localObject2).cUi = System.currentTimeMillis();
            ((af)localObject2).fC(at.gU(ah.getContext())).ake();
            localObject2 = a.h(this.uLU.uLR).bX(a.g(this.uLU.uLR));
            localObject3 = (AbsoluteLayout)w.hM(a.g(this.uLU.uLR)).inflate(2130969684, null);
            ((AbsoluteLayout)localObject3).setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, p.pQ(this.uLU.uLS.uKB.offsetX), p.pQ(this.uLU.uLS.uKB.offsetY)));
            localObject5 = new AbsoluteLayout.LayoutParams(p.pQ(this.uLU.uLS.uKB.width), p.pQ(this.uLU.uLS.uKB.height), 0, 0);
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
            ((AbsoluteLayout)localObject3).addView((View)localObject2);
            localObject4 = (FrameLayout)((AbsoluteLayout)localObject3).findViewById(2131824418);
            ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
            ((AbsoluteLayout)localObject3).removeView((View)localObject4);
            ((AbsoluteLayout)localObject3).addView((View)localObject4);
          }
          try
          {
            ((View)localObject2).setBackgroundColor(Color.parseColor(this.uLU.uLS.uKB.hhh));
            ((View)localObject2).setTag(str1);
            a.i(this.uLU.uLR).put(this.uLU.uLT, localObject2);
            a.j(this.uLU.uLR).put(this.uLU.uLT, localObject3);
            a.k(this.uLU.uLR).put(this.uLU.uLT, localObject4);
            localObject4 = (ThreeDotsLoadingView)((AbsoluteLayout)localObject3).findViewById(2131821346);
            Object localObject6 = (ImageView)((AbsoluteLayout)localObject3).findViewById(2131821891);
            String str2 = this.uLU.uLS.uKA.fqf + "_" + this.uLU.uLS.uKA.uKF.hashCode();
            localObject5 = new Bundle();
            if (this.uLU.uLR.uLJ)
            {
              a.a(this.uLU.uLR, "com.tencent.mm:tools");
              ((Bundle)localObject5).putString("exec_process_name", a.a(this.uLU.uLR));
              ((Bundle)localObject5).putString("app_id", this.uLU.uLS.uKA.cwc);
              ((Bundle)localObject5).putString("src_app_id", this.uLU.uLS.uKA.fqf);
              ((Bundle)localObject5).putString("wxa_unique_id", this.uLU.uLT);
              ((Bundle)localObject5).putString("msg_id", str2);
              ((Bundle)localObject5).putString("search_id", this.uLU.uLS.uKA.hng);
              ((Bundle)localObject5).putString("cache_key", this.uLU.uLS.uKA.uKF);
              ((Bundle)localObject5).putString("msg_title", this.uLU.uLS.uKA.blZ);
              ((Bundle)localObject5).putString("msg_path", this.uLU.uLS.uKA.cmG);
              ((Bundle)localObject5).putInt("pkg_version", this.uLU.uLS.uKA.version);
              ((Bundle)localObject5).putInt("msg_pkg_type", this.uLU.uLS.uKA.uKH);
              ((Bundle)localObject5).putString("init_data", this.uLU.uLS.uKA.uKE);
              ((Bundle)localObject5).putInt("widget_type", 1);
              ((Bundle)localObject5).putInt("service_type", this.uLU.uLS.uKA.fmF);
              i = this.uLU.fwD;
              if (i != 201) {
                break label2070;
              }
              i = 1006;
              ((Bundle)localObject5).putInt("scene", i);
              ((Bundle)localObject5).putInt("view_init_width", p.pQ(this.uLU.uLS.uKB.width));
              ((Bundle)localObject5).putInt("view_init_height", p.pQ(this.uLU.uLS.uKB.height));
              ((Bundle)localObject5).putString("query", this.uLU.uLS.uKA.uKF);
              ((Bundle)localObject5).putString("preload_launch_data", this.uLU.uLS.uKA.uKG);
              ((Bundle)localObject5).putString("preload_download_data", this.uLU.uLS.uKA.downloadUrl);
              ((Bundle)localObject5).putInt("draw_strategy", this.uLU.hpB);
              if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRV, 0) != 1) {
                break label2115;
              }
              bool2 = true;
              ((Bundle)localObject5).putBoolean("use_predraw", bool2);
              ((ThreeDotsLoadingView)localObject4).setVisibility(0);
              ((ImageView)localObject6).setVisibility(4);
              ((ThreeDotsLoadingView)localObject4).dOV();
              ((a.d)localObject1).cwc = this.uLU.uLS.uKA.cwc;
              ((a.d)localObject1).cvs = this.uLU.uLS.uKA.uKH;
              ((a.d)localObject1).gXf = this.uLU.uLS.uKA.version;
              ((a.d)localObject1).hny = str2;
              com.tencent.mm.sdk.platformtools.ab.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[] { ((a.d)localObject1).toString() });
              l = System.currentTimeMillis();
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(867L, 0L, 1L, false);
              localObject6 = new ac(new a.2.2.9(this, str1, (ThreeDotsLoadingView)localObject4, (ImageView)localObject6, l, bool1));
              ((ac)localObject6).a(new a.2.2.10(this));
              ((ac)localObject6).a(new g(a.g(this.uLU.uLR)));
              ((ac)localObject6).a(new a.2.2.11(this));
              ((ac)localObject6).a(new a.2.2.12(this));
              ((ac)localObject6).a(new a.2.2.13(this, (View)localObject2));
              ((ac)localObject6).a(new a.2.2.14(this));
              ((ac)localObject6).a(new a.2.2.2(this));
              ((ac)localObject6).a(new ai()
              {
                public final void qv(String paramAnonymousString)
                {
                  AppMethodBeat.i(91381);
                  com.tencent.mm.sdk.platformtools.ab.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramAnonymousString });
                  paramAnonymousString = a.c(a.2.2.this.uLU.uLR, paramAnonymousString);
                  if (!bo.isNullOrNil(paramAnonymousString))
                  {
                    a.c(a.2.2.this.uLU.uLR).agq(paramAnonymousString);
                    AppMethodBeat.o(91381);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ab.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                  AppMethodBeat.o(91381);
                }
              });
              ((ac)localObject6).a(new ae()
              {
                public final void au(String paramAnonymousString1, String paramAnonymousString2)
                {
                  AppMethodBeat.i(91382);
                  com.tencent.mm.sdk.platformtools.ab.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2 });
                  paramAnonymousString1 = a.c(a.2.2.this.uLU.uLR, paramAnonymousString1);
                  if (!bo.isNullOrNil(paramAnonymousString1))
                  {
                    a.c(a.2.2.this.uLU.uLR).hh(paramAnonymousString1, paramAnonymousString2);
                    AppMethodBeat.o(91382);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ab.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                  AppMethodBeat.o(91382);
                }
              });
              ((ac)localObject6).a(new aa()
              {
                public final void qr(String paramAnonymousString)
                {
                  AppMethodBeat.i(91383);
                  d.dab();
                  d.b(a.2.2.this.uLU.uLS, paramAnonymousString);
                  AppMethodBeat.o(91383);
                }
              });
              ((ac)localObject6).a(new a.2.2.6(this));
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("id", this.uLU.uLT);
              ((Bundle)localObject1).putString("appid", this.uLU.uLS.uKA.cwc);
              ((Bundle)localObject1).putInt("serviceType", this.uLU.uLS.uKA.fmF);
              ((Bundle)localObject1).putInt("drawStrategy", this.uLU.hpB);
              ((Bundle)localObject1).putString("srcAppid", this.uLU.uLS.uKA.fqf);
              u.a(this.uLU.uLT, this.uLU.uLS.uKA.fmF, this.uLU.uLS.uKA.cwc, this.uLU.uLS.uKA.fqf, this.uLU.hpB);
              localObject5 = a.h(this.uLU.uLR).a(str1, (View)localObject2, (Bundle)localObject5, (com.tencent.mm.modelappbrand.ab)localObject6);
              a.l(this.uLU.uLR).put(localObject5, this.uLU.uLT);
              f.a("com.tencent.mm", (Parcelable)localObject1, a.b.class, new a.2.2.1(this));
              f.a(a.a(this.uLU.uLR), (Parcelable)localObject1, a.b.class, new a.2.2.7(this));
              f.a(com.tencent.mm.ipcinvoker.e.PM(), (Parcelable)localObject1, a.b.class, new a.2.2.8(this));
              a.a(this.uLU.uLR, this.uLU.uLS, this.uLU.uLT, str1, (View)localObject2, (AbsoluteLayout)localObject3, (ThreeDotsLoadingView)localObject4);
              a.c(this.uLU.uLR).addView((View)localObject3);
              AppMethodBeat.o(91391);
              return;
              bool1 = false;
              continue;
              l = 2L;
            }
          }
          catch (Exception localException2)
          {
            com.tencent.mm.sdk.platformtools.ab.e("FTSSearchWidgetMgr", "the color is error : ");
            continue;
          }
          a.a(this.uLU.uLR, "com.tencent.mm:support");
        }
        catch (Exception localException1)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("FTSSearchWidgetMgr", localException1, "", new Object[0]);
          AppMethodBeat.o(91391);
          return;
        }
        continue;
        label2070:
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
          label2115:
          bool2 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.2
 * JD-Core Version:    0.7.0.1
 */