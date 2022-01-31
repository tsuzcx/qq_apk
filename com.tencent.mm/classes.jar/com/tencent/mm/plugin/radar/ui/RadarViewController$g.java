package com.tencent.mm.plugin.radar.ui;

import a.k;
import android.view.View;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class RadarViewController$g
  implements RadarSpecialGridView.a
{
  public final void e(int paramInt, final View paramView)
  {
    int j = 0;
    a.d.b.g.k(paramView, "view");
    final bio localbio = (bio)RadarViewController.d(this.nnP).nnR[paramInt];
    if (localbio == null) {
      return;
    }
    Object localObject1 = this.nnP.getRadarStatus();
    Object localObject2;
    switch (h.nmH[localObject1.ordinal()])
    {
    default: 
      paramView = RadarViewController.nnL;
      y.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.nnP.getRadarStatus() });
      return;
    case 1: 
    case 2: 
      localObject1 = g.nnt;
      localObject1 = g.b(localbio);
      if (localbio != null)
      {
        localObject2 = (CharSequence)localbio.hPY;
        if ((localObject2 != null) && (!a.h.e.X((CharSequence)localObject2))) {
          break label259;
        }
        i = 1;
        label145:
        paramInt = j;
        if (i == 0) {
          break label186;
        }
        localObject2 = (CharSequence)localbio.sUr;
        if ((localObject2 != null) && (!a.h.e.X((CharSequence)localObject2))) {
          break label264;
        }
      }
      label259:
      label264:
      for (int i = 1;; i = 0)
      {
        paramInt = j;
        if (i != 0) {
          paramInt = 1;
        }
        label186:
        if (paramInt != 0) {
          break;
        }
        localObject2 = (View)RadarViewController.d(this.nnP).nnW.get(localObject1);
        localObject1 = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.nnP), localbio);
        if ((localObject2 == null) || (localObject1 == c.e.nkE)) {
          break label323;
        }
        localObject2 = ((View)localObject2).getTag();
        if (localObject2 != null) {
          break label269;
        }
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        i = 0;
        break label145;
      }
      label269:
      ((RadarViewController.c.a)localObject2).noa.buM();
      localObject2 = new ah();
      paramView = (Runnable)new a(this, paramView, localbio, (c.e)localObject1);
      localObject1 = RadarStateView.nmO;
      ((ah)localObject2).postDelayed(paramView, RadarStateView.buN());
      return;
      label323:
      RadarViewController.g(this.nnP).a(paramView, localbio, (c.e)localObject1);
      RadarViewController.f(this.nnP).buV();
      return;
    }
    if (localbio != null)
    {
      paramView = (CharSequence)localbio.hPY;
      if ((paramView == null) || (a.h.e.X(paramView)))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label504;
        }
        paramView = (CharSequence)localbio.sUr;
        if ((paramView != null) && (!a.h.e.X(paramView))) {
          break label499;
        }
        paramInt = 1;
        label402:
        if (paramInt == 0) {
          break label504;
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        localObject2 = RadarViewController.d(this.nnP);
        if (localbio == null) {
          break label570;
        }
        paramView = g.nnt;
        localObject1 = g.b(localbio);
        paramView = (View)localObject1;
        if (RadarViewController.c(((RadarViewController.c)localObject2).nnP).nle.containsKey(localObject1))
        {
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).nnP).nle.get(localObject1);
          if (paramView == null)
          {
            throw new k("null cannot be cast to non-null type kotlin.String");
            paramInt = 0;
            break;
            label499:
            paramInt = 0;
            break label402;
            label504:
            paramInt = 0;
            continue;
          }
          paramView = (String)paramView;
        }
        if (!((RadarViewController.c)localObject2).nnS.containsKey(paramView)) {
          break label570;
        }
        paramInt = 1;
        if (paramInt != 0) {
          break label575;
        }
        RadarViewController.d(this.nnP).d(localbio);
      }
    }
    for (;;)
    {
      RadarViewController.c(this.nnP).a(localbio);
      RadarViewController.buS();
      RadarViewController.d(this.nnP).buD();
      return;
      label570:
      paramInt = 0;
      break;
      label575:
      localObject2 = RadarViewController.d(this.nnP);
      if (localbio != null)
      {
        paramView = (CharSequence)localbio.hPY;
        if ((paramView != null) && (!a.h.e.X(paramView))) {
          break label723;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label733;
        }
        paramView = (CharSequence)localbio.sUr;
        if ((paramView != null) && (!a.h.e.X(paramView))) {
          break label728;
        }
        paramInt = 1;
        label637:
        if (paramInt == 0) {
          break label733;
        }
      }
      label723:
      label728:
      label733:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label736;
        }
        paramView = g.nnt;
        if (localbio == null) {
          a.d.b.g.cUk();
        }
        localObject1 = g.b(localbio);
        paramView = (View)localObject1;
        if (!RadarViewController.c(((RadarViewController.c)localObject2).nnP).nle.containsKey(localObject1)) {
          break label743;
        }
        paramView = RadarViewController.c(((RadarViewController.c)localObject2).nnP).nle.get(localObject1);
        if (paramView != null) {
          break label738;
        }
        throw new k("null cannot be cast to non-null type kotlin.String");
        paramInt = 0;
        break;
        paramInt = 0;
        break label637;
      }
      label736:
      continue;
      label738:
      paramView = (String)paramView;
      label743:
      ((RadarViewController.c)localObject2).nnS.remove(paramView);
    }
  }
  
  static final class a
    implements Runnable
  {
    a(RadarViewController.g paramg, View paramView, bio parambio, c.e parame) {}
    
    public final void run()
    {
      RadarViewController.g(this.nof.nnP).a(paramView, localbio, this.noh);
      RadarViewController.f(this.nof.nnP).buV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.g
 * JD-Core Version:    0.7.0.1
 */