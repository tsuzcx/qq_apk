package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private i.a JDs;
  private SnsAdLandingPageFloatView JDt;
  private boolean Wp;
  
  public b(i.a parama)
  {
    this.JDs = parama;
    this.Wp = false;
  }
  
  public final boolean I(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    AppMethodBeat.i(241156);
    this.Wp = false;
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(241156);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.JDs;
        if ((localObject1 == null) || (!d.n(((i.a)localObject1).Kyx))) {
          continue;
        }
        localObject1 = (g)((i.a)localObject1).Kyx.get(0);
        if (localObject1 == null) {
          continue;
        }
        if (!d.isEmpty(((g)localObject1).Kyq)) {
          continue;
        }
      }
      catch (Throwable paramViewGroup)
      {
        Object localObject2;
        Object localObject3;
        g localg;
        continue;
        Object localObject1 = null;
        continue;
        localObject1 = null;
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = new SnsAdLandingPageFloatView(paramViewGroup.getContext());
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("sns_float_component_id", ((y)localObject1).KmB);
        localg = (g)this.JDs.Kyx.get(0);
        if (localg == null) {}
      }
      try
      {
        ((SnsAdLandingPageFloatView)localObject2).fOG = ((Bundle)localObject3).getString("sns_float_component_id");
        ((SnsAdLandingPageFloatView)localObject2).adCanvasExtXml = ((Bundle)localObject3).getString("sns_landing_pages_canvas_ext");
        ((SnsAdLandingPageFloatView)localObject2).LsR = new g();
        ((SnsAdLandingPageFloatView)localObject2).LsR.nWx = localg.nWx;
        ((SnsAdLandingPageFloatView)localObject2).LsR.Kyr = true;
        ((SnsAdLandingPageFloatView)localObject2).LsR.id = 0;
        if (d.aC(localg.Kyq))
        {
          localObject3 = (aa)localg.Kyq.get(((SnsAdLandingPageFloatView)localObject2).fOG);
          if ((localObject3 != null) && (i.agD(((aa)localObject3).type)))
          {
            ((SnsAdLandingPageFloatView)localObject2).LsQ = ((y)localObject3);
            ((SnsAdLandingPageFloatView)localObject2).LsR.Kyp.add(((SnsAdLandingPageFloatView)localObject2).LsQ);
            ((SnsAdLandingPageFloatView)localObject2).LsR.Kyq.putAll(localg.Kyq);
            if (((SnsAdLandingPageFloatView)localObject2).LsQ.Kmx <= 0) {
              bool = true;
            }
            ((SnsAdLandingPageFloatView)localObject2).LsV = bool;
          }
        }
        ((SnsAdLandingPageFloatView)localObject2).initView();
      }
      catch (Throwable localThrowable)
      {
        float f;
        Log.e("MicroMsg.SnsAdLandingPageFloatView", "the init from helper has something wrong!!");
        continue;
      }
      paramViewGroup.addView((View)localObject2, paramViewGroup.getChildCount() - 1, new ViewGroup.LayoutParams(-1, -1));
      this.JDt = ((SnsAdLandingPageFloatView)localObject2);
      this.Wp = true;
      f = ((y)localObject1).cornerRadius;
      paramViewGroup = this.JDt;
      if ((paramViewGroup != null) && (paramViewGroup.getChildCount() > 0))
      {
        paramViewGroup = paramViewGroup.getChildAt(0);
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.getContext();
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(((Context)localObject1).getResources().getColor(i.c.sns_ad_float_view_background_shadow_color));
          ((GradientDrawable)localObject2).setCornerRadius(f);
          paramViewGroup.setBackground((Drawable)localObject2);
          paramViewGroup.setElevation(paramViewGroup.getContext().getResources().getDimension(i.d.sns_ad_float_view_shadow_dimen));
        }
      }
      bool = this.Wp;
      AppMethodBeat.o(241156);
      return bool;
      localObject2 = ((g)localObject1).Kyq.values().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      localObject1 = (aa)((Iterator)localObject2).next();
      if ((localObject1 instanceof y))
      {
        localObject1 = (y)localObject1;
        if (((y)localObject1).Kmw <= 0) {}
      }
    }
  }
  
  public final void fKL()
  {
    AppMethodBeat.i(241159);
    try
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = this.JDt;
      if (localSnsAdLandingPageFloatView != null)
      {
        localSnsAdLandingPageFloatView.fZu();
        AppMethodBeat.o(241159);
        return;
      }
      Log.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
      AppMethodBeat.o(241159);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(241159);
    }
  }
  
  public final List<m> getAllComp()
  {
    AppMethodBeat.i(241164);
    try
    {
      if (this.JDt != null)
      {
        List localList = this.JDt.getAllComp();
        AppMethodBeat.o(241164);
        return localList;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(241164);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b
 * JD-Core Version:    0.7.0.1
 */