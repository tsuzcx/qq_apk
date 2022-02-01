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
import com.tencent.mm.plugin.sns.ad.f.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private boolean Ek;
  private i.a znR;
  private SnsAdLandingPageFloatView znS;
  
  public b(i.a parama)
  {
    this.znR = parama;
    this.Ek = false;
  }
  
  public final void dUS()
  {
    AppMethodBeat.i(219040);
    try
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = this.znS;
      if (localSnsAdLandingPageFloatView != null)
      {
        localSnsAdLandingPageFloatView.eiB();
        AppMethodBeat.o(219040);
        return;
      }
      ae.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
      AppMethodBeat.o(219040);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219040);
    }
  }
  
  public final List<m> getAllComp()
  {
    AppMethodBeat.i(219041);
    try
    {
      if (this.znS != null)
      {
        List localList = this.znS.getAllComp();
        AppMethodBeat.o(219041);
        return localList;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219041);
    }
    return null;
  }
  
  public final boolean v(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    AppMethodBeat.i(219039);
    this.Ek = false;
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(219039);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.znR;
        if ((localObject1 == null) || (!c.m(((i.a)localObject1).AcY))) {
          continue;
        }
        localObject1 = (g)((i.a)localObject1).AcY.get(0);
        if (localObject1 == null) {
          continue;
        }
        if (!c.isEmpty(((g)localObject1).AcR)) {
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
        ((Bundle)localObject3).putString("sns_float_component_id", ((w)localObject1).zRg);
        localg = (g)this.znR.AcY.get(0);
        if (localg == null) {}
      }
      try
      {
        ((SnsAdLandingPageFloatView)localObject2).dDp = ((Bundle)localObject3).getString("sns_float_component_id");
        ((SnsAdLandingPageFloatView)localObject2).zMl = ((Bundle)localObject3).getString("sns_landing_pages_canvas_ext");
        ((SnsAdLandingPageFloatView)localObject2).ATG = new g();
        ((SnsAdLandingPageFloatView)localObject2).ATG.jZm = localg.jZm;
        ((SnsAdLandingPageFloatView)localObject2).ATG.AcS = true;
        ((SnsAdLandingPageFloatView)localObject2).ATG.id = 0;
        if (c.aJ(localg.AcR))
        {
          localObject3 = (y)localg.AcR.get(((SnsAdLandingPageFloatView)localObject2).dDp);
          if ((localObject3 != null) && (i.Ro(((y)localObject3).type)))
          {
            ((SnsAdLandingPageFloatView)localObject2).ATF = ((w)localObject3);
            ((SnsAdLandingPageFloatView)localObject2).ATG.AcQ.add(((SnsAdLandingPageFloatView)localObject2).ATF);
            ((SnsAdLandingPageFloatView)localObject2).ATG.AcR.putAll(localg.AcR);
            if (((SnsAdLandingPageFloatView)localObject2).ATF.zRc <= 0) {
              bool = true;
            }
            ((SnsAdLandingPageFloatView)localObject2).ATK = bool;
          }
        }
        ((SnsAdLandingPageFloatView)localObject2).initView();
      }
      catch (Throwable localThrowable)
      {
        float f;
        ae.e("MicroMsg.SnsAdLandingPageFloatView", "the init from helper has something wrong!!");
        continue;
      }
      paramViewGroup.addView((View)localObject2, paramViewGroup.getChildCount() - 1, new ViewGroup.LayoutParams(-1, -1));
      this.znS = ((SnsAdLandingPageFloatView)localObject2);
      this.Ek = true;
      f = ((w)localObject1).hF;
      paramViewGroup = this.znS;
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
      AppMethodBeat.o(219039);
      return bool;
      localObject2 = ((g)localObject1).AcR.values().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      localObject1 = (y)((Iterator)localObject2).next();
      if ((localObject1 instanceof w))
      {
        localObject1 = (w)localObject1;
        if (((w)localObject1).zRb <= 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b
 * JD-Core Version:    0.7.0.1
 */