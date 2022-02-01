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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "boxPaint", "Landroid/graphics/Paint;", "isBelongCenterBlock", "", "isEnableOutsideTouch", "isFullscreenMode", "maxVisibilityRect", "Landroid/graphics/RectF;", "getMaxVisibilityRect", "()Landroid/graphics/RectF;", "drawCutBoxLine", "", "canvas", "Landroid/graphics/Canvas;", "enableFullscreenMode", "enableOutsideTouch", "enable", "onDown", "event", "Landroid/view/MotionEvent;", "onScroll", "e2", "distanceX", "", "distanceY", "onTouchEvent", "showBorder", "alpha", "delay", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiEditCropOperationLayout
  extends WxCropOperationLayout
{
  public static final MultiEditCropOperationLayout.a Ush;
  private final Paint NSx;
  public boolean TMw;
  private boolean Urx;
  private final RectF Usi;
  public boolean Usj;
  
  static
  {
    AppMethodBeat.i(281759);
    Ush = new MultiEditCropOperationLayout.a((byte)0);
    AppMethodBeat.o(281759);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281744);
    this.NSx = new Paint();
    this.Usi = new RectF();
    this.NSx.setColor(-1);
    this.NSx.setAntiAlias(true);
    this.NSx.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.NSx.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(281744);
  }
  
  public MultiEditCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281753);
    this.NSx = new Paint();
    this.Usi = new RectF();
    this.NSx.setColor(-1);
    this.NSx.setAntiAlias(true);
    this.NSx.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.NSx.setStyle(Paint.Style.STROKE);
    getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
    getGridLinePaint().setAntiAlias(true);
    getGridLinePaint().setStrokeWidth(a.fromDPToPix(getContext(), 1));
    getGridLinePaint().setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(281753);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(281796);
    if (!this.TMw)
    {
      super.aR(paramInt, paramLong);
      AppMethodBeat.o(281796);
      return;
    }
    AppMethodBeat.o(281796);
  }
  
  public final RectF getMaxVisibilityRect()
  {
    return this.Usi;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281777);
    s.u(paramMotionEvent, "event");
    if (!this.TMw)
    {
      boolean bool = super.onDown(paramMotionEvent);
      AppMethodBeat.o(281777);
      return bool;
    }
    if (getStyle() == WxCropOperationLayout.j.NTk)
    {
      this.Urx = false;
      if (getVisibilityRect().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        this.Urx = true;
      }
      AppMethodBeat.o(281777);
      return true;
    }
    AppMethodBeat.o(281777);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(281786);
    s.u(paramMotionEvent1, "event");
    s.u(paramMotionEvent2, "e2");
    if (!this.TMw)
    {
      bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      AppMethodBeat.o(281786);
      return bool;
    }
    s.X("[onScroll] event=", paramMotionEvent1);
    if (this.Urx)
    {
      getVisibilityRect().offset(-paramFloat1, -paramFloat2);
      if (getVisibilityRect().top < this.Usi.top) {
        getVisibilityRect().offset(0.0F, this.Usi.top - getVisibilityRect().top);
      }
      if (getVisibilityRect().bottom > this.Usi.bottom) {
        getVisibilityRect().offset(0.0F, this.Usi.bottom - getVisibilityRect().bottom);
      }
      if (getVisibilityRect().left < this.Usi.left) {
        getVisibilityRect().offset(this.Usi.left - getVisibilityRect().left, 0.0F);
      }
      if (getVisibilityRect().right > this.Usi.right) {
        getVisibilityRect().offset(this.Usi.right - getVisibilityRect().right, 0.0F);
      }
    }
    postInvalidate();
    boolean bool = this.Urx;
    AppMethodBeat.o(281786);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281771);
    s.u(paramMotionEvent, "event");
    if (!this.TMw)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(281771);
      return bool1;
    }
    super.onTouchEvent(paramMotionEvent);
    boolean bool1 = this.Urx;
    boolean bool2 = gJJ();
    boolean bool3 = gJK();
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.Urx = false;
      setBelongTopBlock(false);
      setBelongBottomBlock(false);
    }
    if (getStyle() != WxCropOperationLayout.j.NTk)
    {
      AppMethodBeat.o(281771);
      return false;
    }
    if (this.Usj)
    {
      AppMethodBeat.o(281771);
      return bool1 | bool2 | bool3;
    }
    AppMethodBeat.o(281771);
    return true;
  }
  
  public final void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(281793);
    s.u(paramCanvas, "canvas");
    if (!this.TMw)
    {
      super.r(paramCanvas);
      AppMethodBeat.o(281793);
      return;
    }
    if ((getStyle() == WxCropOperationLayout.j.NTk) || (getStyle() == WxCropOperationLayout.j.NTm))
    {
      if (getShowGridLine()) {
        paramCanvas.drawPath(getGridLinePath(), getGridLinePaint());
      }
      paramCanvas.drawRect(getBoxRect(), this.NSx);
    }
    AppMethodBeat.o(281793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */