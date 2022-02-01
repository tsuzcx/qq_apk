package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mOldChildHeight", "", "mOldChildWidth", "mTable", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "getMTable", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "setMTable", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;)V", "computeScrollX", "computeScrollY", "initGridView", "", "onLayout", "changed", "", "l", "t", "r", "b", "reset", "OnItemClickListener", "plugin-radar_release"})
public final class RadarSpecialGridView
  extends RadarSpecialSmoothScrollView
{
  private a wcq;
  public RadarSpecialTableLayout wcr;
  private int wcs;
  private int wct;
  
  public RadarSpecialGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138653);
    paramContext = getContext();
    k.g(paramContext, "context");
    this.wcr = new RadarSpecialTableLayout(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    paramAttributeSet = this.wcr;
    if (paramAttributeSet == null) {
      k.aVY("mTable");
    }
    paramAttributeSet.setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramContext = this.wcr;
    if (paramContext == null) {
      k.aVY("mTable");
    }
    paramContext.setStretchAllColumns(true);
    paramContext = this.wcr;
    if (paramContext == null) {
      k.aVY("mTable");
    }
    paramContext.setShrinkAllColumns(true);
    paramContext = this.wcr;
    if (paramContext == null) {
      k.aVY("mTable");
    }
    paramContext.setGravity(80);
    paramContext = this.wcr;
    if (paramContext == null) {
      k.aVY("mTable");
    }
    addView((View)paramContext);
    AppMethodBeat.o(138653);
  }
  
  public final RadarSpecialTableLayout getMTable()
  {
    AppMethodBeat.i(138650);
    RadarSpecialTableLayout localRadarSpecialTableLayout = this.wcr;
    if (localRadarSpecialTableLayout == null) {
      k.aVY("mTable");
    }
    AppMethodBeat.o(138650);
    return localRadarSpecialTableLayout;
  }
  
  public final a getOnItemClickListener()
  {
    return this.wcq;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(138652);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = getScrollX();
      k.g(localView, "child");
      paramInt1 = paramInt1 + localView.getWidth() - this.wct;
      this.wct = localView.getWidth();
      if (paramInt1 > 0)
      {
        if (getChildCount() <= 0) {
          break label156;
        }
        localView = getChildAt(0);
        paramInt2 = getScrollY();
        k.g(localView, "child");
        paramInt3 = paramInt2 + localView.getHeight() - this.wcs;
        this.wcs = localView.getHeight();
        paramInt2 = i;
        if (paramInt3 <= 0) {}
      }
    }
    label156:
    for (paramInt2 = paramInt3;; paramInt2 = getScrollY())
    {
      scrollTo(paramInt1, paramInt2);
      AppMethodBeat.o(138652);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = getScrollX();
      break;
    }
  }
  
  public final void setMTable(RadarSpecialTableLayout paramRadarSpecialTableLayout)
  {
    AppMethodBeat.i(138651);
    k.h(paramRadarSpecialTableLayout, "<set-?>");
    this.wcr = paramRadarSpecialTableLayout;
    AppMethodBeat.o(138651);
  }
  
  public final void setOnItemClickListener(a parama)
  {
    this.wcq = parama;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static abstract interface a
  {
    public abstract void b(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialGridView
 * JD-Core Version:    0.7.0.1
 */