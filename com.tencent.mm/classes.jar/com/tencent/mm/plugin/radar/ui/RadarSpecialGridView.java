package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

public final class RadarSpecialGridView
  extends RadarSpecialSmoothScrollView
{
  private RadarSpecialGridView.a nmq;
  public RadarSpecialTableLayout nmr;
  private int nms;
  private int nmt;
  
  public RadarSpecialGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext();
    g.j(paramContext, "context");
    this.nmr = new RadarSpecialTableLayout(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    paramAttributeSet = this.nmr;
    if (paramAttributeSet == null) {
      g.ahh("mTable");
    }
    paramAttributeSet.setLayoutParams((ViewGroup.LayoutParams)paramContext);
    paramContext = this.nmr;
    if (paramContext == null) {
      g.ahh("mTable");
    }
    paramContext.setStretchAllColumns(true);
    paramContext = this.nmr;
    if (paramContext == null) {
      g.ahh("mTable");
    }
    paramContext.setShrinkAllColumns(true);
    paramContext = this.nmr;
    if (paramContext == null) {
      g.ahh("mTable");
    }
    paramContext.setGravity(80);
    paramContext = this.nmr;
    if (paramContext == null) {
      g.ahh("mTable");
    }
    addView((View)paramContext);
  }
  
  public final RadarSpecialTableLayout getMTable()
  {
    RadarSpecialTableLayout localRadarSpecialTableLayout = this.nmr;
    if (localRadarSpecialTableLayout == null) {
      g.ahh("mTable");
    }
    return localRadarSpecialTableLayout;
  }
  
  public final RadarSpecialGridView.a getOnItemClickListener()
  {
    return this.nmq;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = getScrollX();
      g.j(localView, "child");
      paramInt1 = paramInt1 + localView.getWidth() - this.nmt;
      this.nmt = localView.getWidth();
      if (paramInt1 > 0)
      {
        if (getChildCount() <= 0) {
          break label146;
        }
        localView = getChildAt(0);
        paramInt2 = getScrollY();
        g.j(localView, "child");
        paramInt3 = paramInt2 + localView.getHeight() - this.nms;
        this.nms = localView.getHeight();
        paramInt2 = i;
        if (paramInt3 <= 0) {}
      }
    }
    label146:
    for (paramInt2 = paramInt3;; paramInt2 = getScrollY())
    {
      scrollTo(paramInt1, paramInt2);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = getScrollX();
      break;
    }
  }
  
  public final void setMTable(RadarSpecialTableLayout paramRadarSpecialTableLayout)
  {
    g.k(paramRadarSpecialTableLayout, "<set-?>");
    this.nmr = paramRadarSpecialTableLayout;
  }
  
  public final void setOnItemClickListener(RadarSpecialGridView.a parama)
  {
    this.nmq = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialGridView
 * JD-Core Version:    0.7.0.1
 */