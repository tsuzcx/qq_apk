package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "boxPaint", "Landroid/graphics/Paint;", "isBelongCenterBlock", "", "isEnableOutsideTouch", "isFullscreenMode", "maxVisibilityRect", "Landroid/graphics/RectF;", "getMaxVisibilityRect", "()Landroid/graphics/RectF;", "drawCutBoxLine", "", "canvas", "Landroid/graphics/Canvas;", "enableFullscreenMode", "enableOutsideTouch", "enable", "onDown", "event", "Landroid/view/MotionEvent;", "onScroll", "e2", "distanceX", "", "distanceY", "onTouchEvent", "showBorder", "alpha", "delay", "", "Companion", "plugin-vlog_release"})
public final class MultiEditCropOperationLayout
  extends WxCropOperationLayout
{
  public static final a NGd;
  private final Paint HVJ;
  public boolean MZN;
  private boolean NFn;
  private final RectF NGb;
  public boolean NGc;
  
  static
  {
    AppMethodBeat.i(235046);
    NGd = new a((byte)0);
    AppMethodBeat.o(235046);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235043);
    this.HVJ = new Paint();
    this.NGb = new RectF();
    this.HVJ.setColor(-1);
    this.HVJ.setAntiAlias(true);
    this.HVJ.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.HVJ.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(235043);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235045);
    this.HVJ = new Paint();
    this.NGb = new RectF();
    this.HVJ.setColor(-1);
    this.HVJ.setAntiAlias(true);
    this.HVJ.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.HVJ.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(235045);
  }
  
  public final void aK(int paramInt, long paramLong)
  {
    AppMethodBeat.i(235040);
    if (!this.MZN)
    {
      super.aK(paramInt, paramLong);
      AppMethodBeat.o(235040);
      return;
    }
    AppMethodBeat.o(235040);
  }
  
  public final RectF getMaxVisibilityRect()
  {
    return this.NGb;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235033);
    p.k(paramMotionEvent, "event");
    if (!this.MZN)
    {
      boolean bool = super.onDown(paramMotionEvent);
      AppMethodBeat.o(235033);
      return bool;
    }
    if (getStyle() == WxCropOperationLayout.j.HWx)
    {
      this.NFn = false;
      if (getVisibilityRect().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        this.NFn = true;
      }
      AppMethodBeat.o(235033);
      return true;
    }
    AppMethodBeat.o(235033);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235036);
    p.k(paramMotionEvent1, "event");
    p.k(paramMotionEvent2, "e2");
    if (!this.MZN)
    {
      bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      AppMethodBeat.o(235036);
      return bool;
    }
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.NFn)
    {
      getVisibilityRect().offset(-paramFloat1, -paramFloat2);
      if (getVisibilityRect().top < this.NGb.top) {
        getVisibilityRect().offset(0.0F, this.NGb.top - getVisibilityRect().top);
      }
      if (getVisibilityRect().bottom > this.NGb.bottom) {
        getVisibilityRect().offset(0.0F, this.NGb.bottom - getVisibilityRect().bottom);
      }
      if (getVisibilityRect().left < this.NGb.left) {
        getVisibilityRect().offset(this.NGb.left - getVisibilityRect().left, 0.0F);
      }
      if (getVisibilityRect().right > this.NGb.right) {
        getVisibilityRect().offset(this.NGb.right - getVisibilityRect().right, 0.0F);
      }
    }
    postInvalidate();
    boolean bool = this.NFn;
    AppMethodBeat.o(235036);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235031);
    p.k(paramMotionEvent, "event");
    if (!this.MZN)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(235031);
      return bool1;
    }
    super.onTouchEvent(paramMotionEvent);
    boolean bool1 = this.NFn;
    boolean bool2 = fxW();
    boolean bool3 = fxX();
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.NFn = false;
      setBelongTopBlock(false);
      setBelongBottomBlock(false);
    }
    if (getStyle() != WxCropOperationLayout.j.HWx)
    {
      AppMethodBeat.o(235031);
      return false;
    }
    if (this.NGc)
    {
      AppMethodBeat.o(235031);
      return bool1 | bool2 | bool3;
    }
    AppMethodBeat.o(235031);
    return true;
  }
  
  public final void w(Canvas paramCanvas)
  {
    AppMethodBeat.i(235038);
    p.k(paramCanvas, "canvas");
    if (!this.MZN)
    {
      super.w(paramCanvas);
      AppMethodBeat.o(235038);
      return;
    }
    if ((getStyle() == WxCropOperationLayout.j.HWx) || (getStyle() == WxCropOperationLayout.j.HWz))
    {
      if (getShowGridLine()) {
        paramCanvas.drawPath(getGridLinePath(), getGridLinePaint());
      }
      paramCanvas.drawRect(getBoxRect(), this.HVJ);
    }
    AppMethodBeat.o(235038);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */