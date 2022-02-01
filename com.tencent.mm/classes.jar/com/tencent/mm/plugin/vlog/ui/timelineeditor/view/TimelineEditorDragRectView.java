package com.tencent.mm.plugin.vlog.ui.timelineeditor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView;", "Landroid/widget/RelativeLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "bgColor", "setBgColor", "(I)V", "boxPaint", "Landroid/graphics/Paint;", "boxRect", "Landroid/graphics/RectF;", "gridLinePaint", "gridLinePath", "Landroid/graphics/Path;", "isBelongCenterBlock", "", "paint", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "validRect", "visibilityRect", "xMode", "Landroid/graphics/PorterDuffXfermode;", "canRectMove", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onFling", "p0", "p1", "p2", "", "p3", "onLongPress", "onScroll", "e2", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "updateGridLinePath", "updateRect", "Companion", "plugin-vlog_release"})
public final class TimelineEditorDragRectView
  extends RelativeLayout
  implements GestureDetector.OnGestureListener
{
  public static final a NFp;
  private final f AOG;
  private Path HVC;
  private final Paint HVJ;
  private final Paint HVK;
  private RectF HVY;
  private RectF HWc;
  private boolean NFn;
  private final PorterDuffXfermode NFo;
  private int bgColor;
  private final Paint paint;
  private RectF vav;
  
  static
  {
    AppMethodBeat.i(244470);
    NFp = new a((byte)0);
    AppMethodBeat.o(244470);
  }
  
  public TimelineEditorDragRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(244466);
    this.HVK = new Paint();
    this.HVJ = new Paint();
    this.HVC = new Path();
    this.HWc = new RectF();
    this.HVY = new RectF();
    this.vav = new RectF();
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.NFo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.AOG = g.ar((kotlin.g.a.a)new b(this));
    setLayerType(1, null);
    LayoutInflater.from(getContext()).inflate(a.g.timeline_editor_half_screen_view, (ViewGroup)this, true);
    setBackgroundColor(0);
    this.HVJ.setColor(-1);
    this.HVJ.setAntiAlias(true);
    this.HVJ.setStrokeWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 2));
    this.HVJ.setStyle(Paint.Style.STROKE);
    this.HVK.setColor(Color.parseColor("#4DFFFFFF"));
    this.HVK.setAntiAlias(true);
    this.HVK.setStrokeWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 1));
    this.HVK.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(244466);
  }
  
  public TimelineEditorDragRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(244467);
    this.HVK = new Paint();
    this.HVJ = new Paint();
    this.HVC = new Path();
    this.HWc = new RectF();
    this.HVY = new RectF();
    this.vav = new RectF();
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.NFo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.AOG = g.ar((kotlin.g.a.a)new b(this));
    setLayerType(1, null);
    LayoutInflater.from(getContext()).inflate(a.g.timeline_editor_half_screen_view, (ViewGroup)this, true);
    setBackgroundColor(0);
    this.HVJ.setColor(-1);
    this.HVJ.setAntiAlias(true);
    this.HVJ.setStrokeWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 2));
    this.HVJ.setStyle(Paint.Style.STROKE);
    this.HVK.setColor(Color.parseColor("#4DFFFFFF"));
    this.HVK.setAntiAlias(true);
    this.HVK.setStrokeWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 1));
    this.HVK.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(244467);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(244452);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(244452);
    return localGestureDetector;
  }
  
  private final void gwL()
  {
    AppMethodBeat.i(244455);
    this.HVC.reset();
    int i = 1;
    while (i <= 2)
    {
      this.HVC.moveTo(this.HWc.left + this.HWc.width() / 3.0F * i, this.HWc.top);
      this.HVC.lineTo(this.HWc.left + this.HWc.width() / 3.0F * i, this.HWc.bottom);
      this.HVC.moveTo(this.HWc.left, this.HWc.top + this.HWc.height() / 3.0F * i);
      this.HVC.lineTo(this.HWc.right, this.HWc.top + this.HWc.height() / 3.0F * i);
      i += 1;
    }
    AppMethodBeat.o(244455);
  }
  
  private final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(244450);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(244450);
  }
  
  public final void a(RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(244454);
    p.k(paramRectF1, "visibilityRect");
    p.k(paramRectF2, "validRect");
    this.HVY = paramRectF1;
    this.vav = paramRectF2;
    this.HWc = paramRectF1;
    gwL();
    postInvalidate();
    AppMethodBeat.o(244454);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(244458);
    p.k(paramMotionEvent, "event");
    this.NFn = false;
    if (this.HVY.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      this.NFn = true;
    }
    if (this.NFn)
    {
      if ((this.HVY.width() != this.vav.width()) || (this.HVY.height() != this.vav.height())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244458);
        return true;
      }
    }
    AppMethodBeat.o(244458);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(244463);
    p.k(paramCanvas, "canvas");
    paramCanvas.drawColor(this.bgColor);
    this.paint.setXfermode((Xfermode)this.NFo);
    paramCanvas.drawRect(this.HVY, this.paint);
    this.paint.setXfermode(null);
    paramCanvas.drawPath(this.HVC, this.HVK);
    paramCanvas.drawRect(this.HWc, this.HVJ);
    AppMethodBeat.o(244463);
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(244461);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(244461);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(244459);
    p.k(paramMotionEvent1, "event");
    p.k(paramMotionEvent2, "e2");
    Log.d("MicroMsg.MultiCropOpLayout", "[onScroll] event=".concat(String.valueOf(paramMotionEvent1)));
    if (this.NFn)
    {
      this.HVY.offset(-paramFloat1, -paramFloat2);
      if (this.HVY.top < this.vav.top) {
        this.HVY.offset(0.0F, this.vav.top - this.HVY.top);
      }
      if (this.HVY.bottom > this.vav.bottom) {
        this.HVY.offset(0.0F, this.vav.bottom - this.HVY.bottom);
      }
      if (this.HVY.left < this.vav.left) {
        this.HVY.offset(this.vav.left - this.HVY.left, 0.0F);
      }
      if (this.HVY.right > this.vav.right) {
        this.HVY.offset(this.vav.right - this.HVY.right, 0.0F);
      }
      gwL();
    }
    postInvalidate();
    boolean bool = this.NFn;
    AppMethodBeat.o(244459);
    return bool;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(244460);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(244460);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(244457);
    p.k(paramMotionEvent, "event");
    super.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.NFn = false;
    }
    GestureDetector localGestureDetector = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(244457);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    b(TimelineEditorDragRectView paramTimelineEditorDragRectView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.view.TimelineEditorDragRectView
 * JD-Core Version:    0.7.0.1
 */