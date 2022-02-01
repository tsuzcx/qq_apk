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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "boxPaint", "Landroid/graphics/Paint;", "isBelongCenterBlock", "", "isEnableOutsideTouch", "isFullscreenMode", "maxVisibilityRect", "Landroid/graphics/RectF;", "getMaxVisibilityRect", "()Landroid/graphics/RectF;", "drawCutBoxLine", "", "canvas", "Landroid/graphics/Canvas;", "enableFullscreenMode", "enableOutsideTouch", "enable", "onDown", "event", "Landroid/view/MotionEvent;", "onScroll", "e2", "distanceX", "", "distanceY", "onTouchEvent", "showBorder", "alpha", "delay", "", "Companion", "plugin-vlog_release"})
public final class MultiEditCropOperationLayout
  extends WxCropOperationLayout
{
  public static final MultiEditCropOperationLayout.a GQn;
  private final Paint BYU;
  private final RectF GQk;
  private boolean GQl;
  public boolean GQm;
  public boolean Gna;
  
  static
  {
    AppMethodBeat.i(192185);
    GQn = new MultiEditCropOperationLayout.a((byte)0);
    AppMethodBeat.o(192185);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192183);
    this.BYU = new Paint();
    this.GQk = new RectF();
    this.BYU.setColor(-1);
    this.BYU.setAntiAlias(true);
    this.BYU.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.BYU.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(192183);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192184);
    this.BYU = new Paint();
    this.GQk = new RectF();
    this.BYU.setColor(-1);
    this.BYU.setAntiAlias(true);
    this.BYU.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.BYU.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(192184);
  }
  
  public final void ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192182);
    if (!this.Gna)
    {
      super.ay(paramInt, paramLong);
      AppMethodBeat.o(192182);
      return;
    }
    AppMethodBeat.o(192182);
  }
  
  public final RectF getMaxVisibilityRect()
  {
    return this.GQk;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192179);
    p.h(paramMotionEvent, "event");
    if (!this.Gna)
    {
      boolean bool = super.onDown(paramMotionEvent);
      AppMethodBeat.o(192179);
      return bool;
    }
    if (getStyle() == WxCropOperationLayout.j.BZI)
    {
      this.GQl = false;
      if (getVisibilityRect().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        this.GQl = true;
      }
      AppMethodBeat.o(192179);
      return true;
    }
    AppMethodBeat.o(192179);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192180);
    p.h(paramMotionEvent1, "event");
    p.h(paramMotionEvent2, "e2");
    if (!this.Gna)
    {
      bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      AppMethodBeat.o(192180);
      return bool;
    }
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.GQl)
    {
      getVisibilityRect().offset(-paramFloat1, -paramFloat2);
      if (getVisibilityRect().top < this.GQk.top) {
        getVisibilityRect().offset(0.0F, this.GQk.top - getVisibilityRect().top);
      }
      if (getVisibilityRect().bottom > this.GQk.bottom) {
        getVisibilityRect().offset(0.0F, this.GQk.bottom - getVisibilityRect().bottom);
      }
      if (getVisibilityRect().left < this.GQk.left) {
        getVisibilityRect().offset(this.GQk.left - getVisibilityRect().left, 0.0F);
      }
      if (getVisibilityRect().right > this.GQk.right) {
        getVisibilityRect().offset(this.GQk.right - getVisibilityRect().right, 0.0F);
      }
    }
    postInvalidate();
    boolean bool = this.GQl;
    AppMethodBeat.o(192180);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192178);
    p.h(paramMotionEvent, "event");
    if (!this.Gna)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192178);
      return bool1;
    }
    super.onTouchEvent(paramMotionEvent);
    boolean bool1 = this.GQl;
    boolean bool2 = this.BZp;
    boolean bool3 = this.BZq;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.GQl = false;
      setBelongTopBlock(false);
      setBelongBottomBlock(false);
    }
    if (getStyle() != WxCropOperationLayout.j.BZI)
    {
      AppMethodBeat.o(192178);
      return false;
    }
    if (this.GQm)
    {
      AppMethodBeat.o(192178);
      return bool1 | bool2 | bool3;
    }
    AppMethodBeat.o(192178);
    return true;
  }
  
  public final void u(Canvas paramCanvas)
  {
    AppMethodBeat.i(192181);
    p.h(paramCanvas, "canvas");
    if (!this.Gna)
    {
      super.u(paramCanvas);
      AppMethodBeat.o(192181);
      return;
    }
    if ((getStyle() == WxCropOperationLayout.j.BZI) || (getStyle() == WxCropOperationLayout.j.BZK))
    {
      if (getShowGridLine()) {
        paramCanvas.drawPath(getGridLinePath(), getGridLinePaint());
      }
      paramCanvas.drawRect(getBoxRect(), this.BYU);
    }
    AppMethodBeat.o(192181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */