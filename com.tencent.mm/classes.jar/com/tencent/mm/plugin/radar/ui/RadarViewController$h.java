package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
public final class RadarViewController$h
  implements RadarSpecialGridView.a
{
  public final void f(int paramInt, View paramView)
  {
    int j = 0;
    AppMethodBeat.i(103100);
    j.q(paramView, "view");
    brg localbrg = (brg)RadarViewController.d(this.pTd).pTf[paramInt];
    if (localbrg == null)
    {
      AppMethodBeat.o(103100);
      return;
    }
    Object localObject1 = this.pTd.getRadarStatus();
    Object localObject2;
    switch (h.pRV[localObject1.ordinal()])
    {
    default: 
      ab.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.pTd.getRadarStatus() });
      AppMethodBeat.o(103100);
      return;
    case 1: 
    case 2: 
      localObject1 = g.pSH;
      localObject1 = g.b(localbrg);
      if (localbrg != null)
      {
        localObject2 = (CharSequence)localbrg.jJA;
        if ((localObject2 != null) && (!m.ap((CharSequence)localObject2))) {
          break label279;
        }
        i = 1;
        label158:
        paramInt = j;
        if (i == 0) {
          break label199;
        }
        localObject2 = (CharSequence)localbrg.wSo;
        if ((localObject2 != null) && (!m.ap((CharSequence)localObject2))) {
          break label284;
        }
      }
      label279:
      label284:
      for (int i = 1;; i = 0)
      {
        paramInt = j;
        if (i != 0) {
          paramInt = 1;
        }
        label199:
        if (paramInt != 0) {
          break;
        }
        localObject2 = (View)RadarViewController.d(this.pTd).pTk.get(localObject1);
        localObject1 = e.a(RadarViewController.c(this.pTd), localbrg);
        if ((localObject2 == null) || (localObject1 == c.e.pPU)) {
          break label348;
        }
        localObject2 = ((View)localObject2).getTag();
        if (localObject2 != null) {
          break label289;
        }
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(103100);
        throw paramView;
        i = 0;
        break label158;
      }
      label289:
      ((RadarViewController.c.a)localObject2).pTo.ceY();
      localObject2 = new ak();
      paramView = (Runnable)new RadarViewController.h.a(this, paramView, localbrg, (c.e)localObject1);
      localObject1 = RadarStateView.pSc;
      ((ak)localObject2).postDelayed(paramView, RadarStateView.ceZ());
      AppMethodBeat.o(103100);
      return;
      label348:
      RadarViewController.g(this.pTd).a(paramView, localbrg, (c.e)localObject1);
      RadarViewController.f(this.pTd).cfh();
      AppMethodBeat.o(103100);
      return;
    }
    if (localbrg != null)
    {
      paramView = (CharSequence)localbrg.jJA;
      if ((paramView == null) || (m.ap(paramView)))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label541;
        }
        paramView = (CharSequence)localbrg.wSo;
        if ((paramView != null) && (!m.ap(paramView))) {
          break label536;
        }
        paramInt = 1;
        label432:
        if (paramInt == 0) {
          break label541;
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
        localObject2 = RadarViewController.d(this.pTd);
        if (localbrg == null) {
          break label612;
        }
        paramView = g.pSH;
        localObject1 = g.b(localbrg);
        paramView = (View)localObject1;
        if (RadarViewController.c(((RadarViewController.c)localObject2).pTd).pQt.containsKey(localObject1))
        {
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).pTd).pQt.get(localObject1);
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(103100);
            throw paramView;
            paramInt = 0;
            break;
            label536:
            paramInt = 0;
            break label432;
            label541:
            paramInt = 0;
            continue;
          }
          paramView = (String)paramView;
        }
        if (!((RadarViewController.c)localObject2).pTg.containsKey(paramView)) {
          break label612;
        }
        paramInt = 1;
        if (paramInt != 0) {
          break label617;
        }
        RadarViewController.d(this.pTd).d(localbrg);
      }
    }
    for (;;)
    {
      RadarViewController.c(this.pTd).a(localbrg);
      RadarViewController.cfe();
      RadarViewController.d(this.pTd).aPD();
      AppMethodBeat.o(103100);
      return;
      label612:
      paramInt = 0;
      break;
      label617:
      localObject2 = RadarViewController.d(this.pTd);
      if (localbrg != null)
      {
        paramView = (CharSequence)localbrg.jJA;
        if ((paramView != null) && (!m.ap(paramView))) {
          break label772;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label782;
        }
        paramView = (CharSequence)localbrg.wSo;
        if ((paramView != null) && (!m.ap(paramView))) {
          break label777;
        }
        paramInt = 1;
        label679:
        if (paramInt == 0) {
          break label782;
        }
      }
      label772:
      label777:
      label782:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label785;
        }
        paramView = g.pSH;
        if (localbrg == null) {
          j.ebi();
        }
        localObject1 = g.b(localbrg);
        paramView = (View)localObject1;
        if (!RadarViewController.c(((RadarViewController.c)localObject2).pTd).pQt.containsKey(localObject1)) {
          break label792;
        }
        paramView = RadarViewController.c(((RadarViewController.c)localObject2).pTd).pQt.get(localObject1);
        if (paramView != null) {
          break label787;
        }
        paramView = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(103100);
        throw paramView;
        paramInt = 0;
        break;
        paramInt = 0;
        break label679;
      }
      label785:
      continue;
      label787:
      paramView = (String)paramView;
      label792:
      ((RadarViewController.c)localObject2).pTg.remove(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.h
 * JD-Core Version:    0.7.0.1
 */