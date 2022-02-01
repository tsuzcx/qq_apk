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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private boolean Ek;
  private i.a yXp;
  private SnsAdLandingPageFloatView yXq;
  
  public b(i.a parama)
  {
    this.yXp = parama;
    this.Ek = false;
  }
  
  public final void dRu()
  {
    AppMethodBeat.i(197579);
    try
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = this.yXq;
      if (localSnsAdLandingPageFloatView != null)
      {
        localSnsAdLandingPageFloatView.eeU();
        AppMethodBeat.o(197579);
        return;
      }
      ad.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
      AppMethodBeat.o(197579);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197579);
    }
  }
  
  public final List<l> getAllComp()
  {
    AppMethodBeat.i(197580);
    try
    {
      if (this.yXq != null)
      {
        List localList = this.yXq.getAllComp();
        AppMethodBeat.o(197580);
        return localList;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197580);
    }
    return null;
  }
  
  public final boolean v(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    AppMethodBeat.i(197578);
    this.Ek = false;
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(197578);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.yXp;
        if ((localObject1 == null) || (!com.tencent.mm.plugin.sns.ad.e.b.m(((i.a)localObject1).zLR))) {
          continue;
        }
        localObject1 = (g)((i.a)localObject1).zLR.get(0);
        if (localObject1 == null) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ad.e.b.isEmpty(((g)localObject1).zLK)) {
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
        ((Bundle)localObject3).putString("sns_float_component_id", ((v)localObject1).zAg);
        localg = (g)this.yXp.zLR.get(0);
        if (localg == null) {}
      }
      try
      {
        ((SnsAdLandingPageFloatView)localObject2).dCk = ((Bundle)localObject3).getString("sns_float_component_id");
        ((SnsAdLandingPageFloatView)localObject2).zuQ = ((Bundle)localObject3).getString("sns_landing_pages_canvas_ext");
        ((SnsAdLandingPageFloatView)localObject2).ACf = new g();
        ((SnsAdLandingPageFloatView)localObject2).ACf.jVX = localg.jVX;
        ((SnsAdLandingPageFloatView)localObject2).ACf.zLL = true;
        ((SnsAdLandingPageFloatView)localObject2).ACf.id = 0;
        if (com.tencent.mm.plugin.sns.ad.e.b.aD(localg.zLK))
        {
          localObject3 = (x)localg.zLK.get(((SnsAdLandingPageFloatView)localObject2).dCk);
          if ((localObject3 != null) && (i.QH(((x)localObject3).type)))
          {
            ((SnsAdLandingPageFloatView)localObject2).ACe = ((v)localObject3);
            ((SnsAdLandingPageFloatView)localObject2).ACf.zLJ.add(((SnsAdLandingPageFloatView)localObject2).ACe);
            ((SnsAdLandingPageFloatView)localObject2).ACf.zLK.putAll(localg.zLK);
            if (((SnsAdLandingPageFloatView)localObject2).ACe.zAd <= 0) {
              bool = true;
            }
            ((SnsAdLandingPageFloatView)localObject2).ACj = bool;
          }
        }
        ((SnsAdLandingPageFloatView)localObject2).initView();
      }
      catch (Throwable localThrowable)
      {
        float f;
        ad.e("MicroMsg.SnsAdLandingPageFloatView", "the init from helper has something wrong!!");
        continue;
      }
      paramViewGroup.addView((View)localObject2, paramViewGroup.getChildCount() - 1, new ViewGroup.LayoutParams(-1, -1));
      this.yXq = ((SnsAdLandingPageFloatView)localObject2);
      this.Ek = true;
      f = ((v)localObject1).hF;
      paramViewGroup = this.yXq;
      if ((paramViewGroup != null) && (paramViewGroup.getChildCount() > 0))
      {
        paramViewGroup = paramViewGroup.getChildAt(0);
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.getContext();
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(((Context)localObject1).getResources().getColor(2131101236));
          ((GradientDrawable)localObject2).setCornerRadius(f);
          paramViewGroup.setBackground((Drawable)localObject2);
          paramViewGroup.setElevation(paramViewGroup.getContext().getResources().getDimension(2131167066));
        }
      }
      bool = this.Ek;
      AppMethodBeat.o(197578);
      return bool;
      localObject2 = ((g)localObject1).zLK.values().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      localObject1 = (x)((Iterator)localObject2).next();
      if ((localObject1 instanceof v))
      {
        localObject1 = (v)localObject1;
        if (((v)localObject1).zAc <= 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b
 * JD-Core Version:    0.7.0.1
 */