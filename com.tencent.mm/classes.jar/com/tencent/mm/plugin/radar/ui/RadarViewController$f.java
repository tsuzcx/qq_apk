package com.tencent.mm.plugin.radar.ui;

import a.k;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.protocal.c.bio;
import java.util.LinkedList;

final class RadarViewController$f
  implements View.OnClickListener
{
  RadarViewController$f(RadarViewController paramRadarViewController) {}
  
  public final void onClick(View paramView)
  {
    if ((this.nnP.getRadarStatus() == e.e.nlv) || (this.nnP.getRadarStatus() == e.e.nlw))
    {
      paramView = this.nnP.getContext();
      if (paramView == null) {
        throw new k("null cannot be cast to non-null type android.app.Activity");
      }
      ((Activity)paramView).finish();
      return;
    }
    paramView = this.nnP;
    RadarViewController.c localc = RadarViewController.d(this.nnP);
    LinkedList localLinkedList = new LinkedList();
    int j = ((Object[])localc.nnR).length;
    int i = 0;
    while (i < j)
    {
      bio localbio = localc.nnR[i];
      if (localbio != null) {
        localLinkedList.add(localbio);
      }
      i += 1;
    }
    if (RadarViewController.a(paramView, localLinkedList))
    {
      RadarViewController.f(this.nnP).buU();
      RadarViewController.f(this.nnP).setVisibility(0);
      RadarViewController.c(this.nnP).buy();
      RadarViewController.a(this.nnP, e.e.nlw);
    }
    for (;;)
    {
      RadarViewController.d(this.nnP).buD();
      return;
      RadarViewController.a(this.nnP, e.e.nlv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.f
 * JD-Core Version:    0.7.0.1
 */