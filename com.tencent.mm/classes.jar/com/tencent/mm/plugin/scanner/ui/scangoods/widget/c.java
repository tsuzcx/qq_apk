package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.graphics.Canvas;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "isAnimating", "", "onViewSizeChanged", "width", "", "height", "release", "setAnimationDots", "points", "", "Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "pointCount", "([Lcom/tencent/mm/plugin/scanner/model/ScanPoint;I)V", "setDuration", "duration", "", "startAnimation", "listener", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "stopAnimation", "updateViewSize", "forceUpdateDotsCenter", "AnimationListener", "plugin-scan_release"})
public abstract interface c
{
  public abstract void a(a parama);
  
  public abstract void a(ScanPoint[] paramArrayOfScanPoint, int paramInt);
  
  public abstract void draw(Canvas paramCanvas);
  
  public abstract boolean isAnimating();
  
  public abstract void release();
  
  public abstract void setDuration(long paramLong);
  
  public abstract void stopAnimation();
  
  public abstract void v(int paramInt1, int paramInt2, boolean paramBoolean);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.c
 * JD-Core Version:    0.7.0.1
 */