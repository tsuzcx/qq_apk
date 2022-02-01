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
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
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
  private i.a Dud;
  private SnsAdLandingPageFloatView Due;
  private boolean Et;
  
  public b(i.a parama)
  {
    this.Dud = parama;
    this.Et = false;
  }
  
  public final boolean C(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    AppMethodBeat.i(202010);
    this.Et = false;
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(202010);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.Dud;
        if ((localObject1 == null) || (!c.o(((i.a)localObject1).Elq))) {
          continue;
        }
        localObject1 = (g)((i.a)localObject1).Elq.get(0);
        if (localObject1 == null) {
          continue;
        }
        if (!c.isEmpty(((g)localObject1).Elj)) {
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
        ((Bundle)localObject3).putString("sns_float_component_id", ((x)localObject1).DZi);
        localg = (g)this.Dud.Elq.get(0);
        if (localg == null) {}
      }
      try
      {
        ((SnsAdLandingPageFloatView)localObject2).dVe = ((Bundle)localObject3).getString("sns_float_component_id");
        ((SnsAdLandingPageFloatView)localObject2).adCanvasExtXml = ((Bundle)localObject3).getString("sns_landing_pages_canvas_ext");
        ((SnsAdLandingPageFloatView)localObject2).Fem = new g();
        ((SnsAdLandingPageFloatView)localObject2).Fem.lco = localg.lco;
        ((SnsAdLandingPageFloatView)localObject2).Fem.Elk = true;
        ((SnsAdLandingPageFloatView)localObject2).Fem.id = 0;
        if (c.aI(localg.Elj))
        {
          localObject3 = (z)localg.Elj.get(((SnsAdLandingPageFloatView)localObject2).dVe);
          if ((localObject3 != null) && (i.Zm(((z)localObject3).type)))
          {
            ((SnsAdLandingPageFloatView)localObject2).Fel = ((x)localObject3);
            ((SnsAdLandingPageFloatView)localObject2).Fem.Eli.add(((SnsAdLandingPageFloatView)localObject2).Fel);
            ((SnsAdLandingPageFloatView)localObject2).Fem.Elj.putAll(localg.Elj);
            if (((SnsAdLandingPageFloatView)localObject2).Fel.DZe <= 0) {
              bool = true;
            }
            ((SnsAdLandingPageFloatView)localObject2).Feq = bool;
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
      this.Due = ((SnsAdLandingPageFloatView)localObject2);
      this.Et = true;
      f = ((x)localObject1).hH;
      paramViewGroup = this.Due;
      if ((paramViewGroup != null) && (paramViewGroup.getChildCount() > 0))
      {
        paramViewGroup = paramViewGroup.getChildAt(0);
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.getContext();
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(((Context)localObject1).getResources().getColor(2131101099));
          ((GradientDrawable)localObject2).setCornerRadius(f);
          paramViewGroup.setBackground((Drawable)localObject2);
          paramViewGroup.setElevation(paramViewGroup.getContext().getResources().getDimension(2131166951));
        }
      }
      bool = this.Et;
      AppMethodBeat.o(202010);
      return bool;
      localObject2 = ((g)localObject1).Elj.values().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      localObject1 = (z)((Iterator)localObject2).next();
      if ((localObject1 instanceof x))
      {
        localObject1 = (x)localObject1;
        if (((x)localObject1).DZd <= 0) {}
      }
    }
  }
  
  public final void eXl()
  {
    AppMethodBeat.i(202011);
    try
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = this.Due;
      if (localSnsAdLandingPageFloatView != null)
      {
        localSnsAdLandingPageFloatView.flb();
        AppMethodBeat.o(202011);
        return;
      }
      Log.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
      AppMethodBeat.o(202011);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202011);
    }
  }
  
  public final List<m> getAllComp()
  {
    AppMethodBeat.i(202012);
    try
    {
      if (this.Due != null)
      {
        List localList = this.Due.getAllComp();
        AppMethodBeat.o(202012);
        return localList;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202012);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b
 * JD-Core Version:    0.7.0.1
 */