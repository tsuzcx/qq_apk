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
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private boolean NE;
  private l.a PUr;
  private SnsAdLandingPageFloatView PUs;
  
  public b(l.a parama)
  {
    this.PUr = parama;
    this.NE = false;
  }
  
  public final boolean S(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    AppMethodBeat.i(310860);
    this.NE = false;
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(310860);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.PUr;
        if ((localObject1 == null) || (!d.B(((l.a)localObject1).QXz))) {
          continue;
        }
        localObject1 = (h)((l.a)localObject1).QXz.get(0);
        if (localObject1 == null) {
          continue;
        }
        if (!d.isEmpty(((h)localObject1).QXj)) {
          continue;
        }
      }
      finally
      {
        Object localObject2;
        Object localObject4;
        h localh;
        continue;
        Object localObject1 = null;
        continue;
        localObject1 = null;
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = new SnsAdLandingPageFloatView(paramViewGroup.getContext());
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("sns_float_component_id", ((y)localObject1).QKG);
        localh = (h)this.PUr.QXz.get(0);
        if (localh == null) {}
      }
      try
      {
        ((SnsAdLandingPageFloatView)localObject2).hUz = ((Bundle)localObject4).getString("sns_float_component_id");
        ((SnsAdLandingPageFloatView)localObject2).adCanvasExtXml = ((Bundle)localObject4).getString("sns_landing_pages_canvas_ext");
        ((SnsAdLandingPageFloatView)localObject2).RWh = new h();
        ((SnsAdLandingPageFloatView)localObject2).RWh.qWk = localh.qWk;
        ((SnsAdLandingPageFloatView)localObject2).RWh.QXk = true;
        ((SnsAdLandingPageFloatView)localObject2).RWh.id = 0;
        if (d.aT(localh.QXj))
        {
          localObject4 = (aa)localh.QXj.get(((SnsAdLandingPageFloatView)localObject2).hUz);
          if ((localObject4 != null) && (l.alw(((aa)localObject4).type)))
          {
            ((SnsAdLandingPageFloatView)localObject2).RWg = ((y)localObject4);
            ((SnsAdLandingPageFloatView)localObject2).RWh.QXi.add(((SnsAdLandingPageFloatView)localObject2).RWg);
            ((SnsAdLandingPageFloatView)localObject2).RWh.QXj.putAll(localh.QXj);
            if (((SnsAdLandingPageFloatView)localObject2).RWg.QKC <= 0) {
              bool = true;
            }
            ((SnsAdLandingPageFloatView)localObject2).RWl = bool;
          }
        }
        ((SnsAdLandingPageFloatView)localObject2).initView();
      }
      finally
      {
        float f;
        Log.e("MicroMsg.SnsAdLandingPageFloatView", "the init from helper has something wrong!!");
        continue;
      }
      paramViewGroup.addView((View)localObject2, paramViewGroup.getChildCount() - 1, new ViewGroup.LayoutParams(-1, -1));
      this.PUs = ((SnsAdLandingPageFloatView)localObject2);
      this.NE = true;
      f = ((y)localObject1).cornerRadius;
      paramViewGroup = this.PUs;
      if ((paramViewGroup != null) && (paramViewGroup.getChildCount() > 0))
      {
        paramViewGroup = paramViewGroup.getChildAt(0);
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.getContext();
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(((Context)localObject1).getResources().getColor(b.c.sns_ad_float_view_background_shadow_color));
          ((GradientDrawable)localObject2).setCornerRadius(f);
          paramViewGroup.setBackground((Drawable)localObject2);
          paramViewGroup.setElevation(paramViewGroup.getContext().getResources().getDimension(b.d.sns_ad_float_view_shadow_dimen));
        }
      }
      bool = this.NE;
      AppMethodBeat.o(310860);
      return bool;
      localObject2 = ((h)localObject1).QXj.values().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      localObject1 = (aa)((Iterator)localObject2).next();
      if ((localObject1 instanceof y))
      {
        localObject1 = (y)localObject1;
        if (((y)localObject1).QKB <= 0) {}
      }
    }
  }
  
  public final List<n> getAllComp()
  {
    AppMethodBeat.i(310876);
    try
    {
      if (this.PUs != null)
      {
        List localList = this.PUs.getAllComp();
        return localList;
      }
    }
    finally
    {
      AppMethodBeat.o(310876);
    }
    return null;
  }
  
  public final void hba()
  {
    AppMethodBeat.i(310866);
    try
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = this.PUs;
      if (localSnsAdLandingPageFloatView != null)
      {
        localSnsAdLandingPageFloatView.hsJ();
        return;
      }
      Log.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
      return;
    }
    finally
    {
      AppMethodBeat.o(310866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b
 * JD-Core Version:    0.7.0.1
 */