package com.tencent.mm.plugin.radar.ui;

import a.l;
import a.v;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.protocal.protobuf.brg;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarViewController$f
  implements View.OnClickListener
{
  RadarViewController$f(RadarViewController paramRadarViewController) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103097);
    if ((this.pTd.getRadarStatus() == e.e.pQK) || (this.pTd.getRadarStatus() == e.e.pQL))
    {
      paramView = this.pTd.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(103097);
        throw paramView;
      }
      ((Activity)paramView).finish();
      AppMethodBeat.o(103097);
      return;
    }
    paramView = this.pTd;
    RadarViewController.c localc = RadarViewController.d(this.pTd);
    LinkedList localLinkedList = new LinkedList();
    int j = localc.pTf.length;
    int i = 0;
    while (i < j)
    {
      brg localbrg = localc.pTf[i];
      if (localbrg != null) {
        localLinkedList.add(localbrg);
      }
      i += 1;
    }
    if (RadarViewController.a(paramView, localLinkedList))
    {
      RadarViewController.f(this.pTd).cfg();
      RadarViewController.f(this.pTd).setVisibility(0);
      RadarViewController.c(this.pTd).ceM();
      RadarViewController.a(this.pTd, e.e.pQL);
    }
    for (;;)
    {
      RadarViewController.d(this.pTd).aPD();
      AppMethodBeat.o(103097);
      return;
      RadarViewController.a(this.pTd, e.e.pQK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.f
 * JD-Core Version:    0.7.0.1
 */