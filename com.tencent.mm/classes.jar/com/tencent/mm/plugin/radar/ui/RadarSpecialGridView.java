package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mOldChildHeight", "", "mOldChildWidth", "mTable", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "getMTable", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "setMTable", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;)V", "computeScrollX", "computeScrollY", "initGridView", "", "onLayout", "changed", "", "l", "t", "r", "b", "reset", "OnItemClickListener", "plugin-radar_release"})
public final class RadarSpecialGridView
  extends RadarSpecialSmoothScrollView
{
  private RadarSpecialGridView.a pRF;
  public RadarSpecialTableLayout pRG;
  private int pRH;
  private int pRI;
  
  public RadarSpecialGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103007);
    paramContext = getContext();
    j.p(paramContext, "context");
    this.pRG = new RadarSpecialTableLayout(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    paramAttributeSet = this.pRG;
    if (paramAttributeSet == null) {
      j.ays("mTable");
    }
    paramAttributeSet.setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramContext = this.pRG;
    if (paramContext == null) {
      j.ays("mTable");
    }
    paramContext.setStretchAllColumns(true);
    paramContext = this.pRG;
    if (paramContext == null) {
      j.ays("mTable");
    }
    paramContext.setShrinkAllColumns(true);
    paramContext = this.pRG;
    if (paramContext == null) {
      j.ays("mTable");
    }
    paramContext.setGravity(80);
    paramContext = this.pRG;
    if (paramContext == null) {
      j.ays("mTable");
    }
    addView((View)paramContext);
    AppMethodBeat.o(103007);
  }
  
  public final RadarSpecialTableLayout getMTable()
  {
    AppMethodBeat.i(103004);
    RadarSpecialTableLayout localRadarSpecialTableLayout = this.pRG;
    if (localRadarSpecialTableLayout == null) {
      j.ays("mTable");
    }
    AppMethodBeat.o(103004);
    return localRadarSpecialTableLayout;
  }
  
  public final RadarSpecialGridView.a getOnItemClickListener()
  {
    return this.pRF;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(103006);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = getScrollX();
      j.p(localView, "child");
      paramInt1 = paramInt1 + localView.getWidth() - this.pRI;
      this.pRI = localView.getWidth();
      if (paramInt1 > 0)
      {
        if (getChildCount() <= 0) {
          break label156;
        }
        localView = getChildAt(0);
        paramInt2 = getScrollY();
        j.p(localView, "child");
        paramInt3 = paramInt2 + localView.getHeight() - this.pRH;
        this.pRH = localView.getHeight();
        paramInt2 = i;
        if (paramInt3 <= 0) {}
      }
    }
    label156:
    for (paramInt2 = paramInt3;; paramInt2 = getScrollY())
    {
      scrollTo(paramInt1, paramInt2);
      AppMethodBeat.o(103006);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = getScrollX();
      break;
    }
  }
  
  public final void setMTable(RadarSpecialTableLayout paramRadarSpecialTableLayout)
  {
    AppMethodBeat.i(103005);
    j.q(paramRadarSpecialTableLayout, "<set-?>");
    this.pRG = paramRadarSpecialTableLayout;
    AppMethodBeat.o(103005);
  }
  
  public final void setOnItemClickListener(RadarSpecialGridView.a parama)
  {
    this.pRF = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialGridView
 * JD-Core Version:    0.7.0.1
 */