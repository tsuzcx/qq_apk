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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView;", "Landroid/widget/RelativeLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "bgColor", "setBgColor", "(I)V", "boxPaint", "Landroid/graphics/Paint;", "boxRect", "Landroid/graphics/RectF;", "gridLinePaint", "gridLinePath", "Landroid/graphics/Path;", "isBelongCenterBlock", "", "paint", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "validRect", "visibilityRect", "xMode", "Landroid/graphics/PorterDuffXfermode;", "canRectMove", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onFling", "p0", "p1", "p2", "", "p3", "onLongPress", "onScroll", "e2", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "updateGridLinePath", "updateRect", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimelineEditorDragRectView
  extends RelativeLayout
  implements GestureDetector.OnGestureListener
{
  public static final TimelineEditorDragRectView.a Urw;
  private final j Gra;
  private RectF NSM;
  private RectF NSQ;
  private Path NSq;
  private final Paint NSx;
  private final Paint NSy;
  private boolean Urx;
  private final PorterDuffXfermode Ury;
  private int bgColor;
  private final Paint paint;
  private RectF ymw;
  
  static
  {
    AppMethodBeat.i(282161);
    Urw = new TimelineEditorDragRectView.a((byte)0);
    AppMethodBeat.o(282161);
  }
  
  public TimelineEditorDragRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282091);
    this.NSy = new Paint();
    this.NSx = new Paint();
    this.NSq = new Path();
    this.NSQ = new RectF();
    this.NSM = new RectF();
    this.ymw = new RectF();
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    paramAttributeSet = ah.aiuX;
    this.paint = paramContext;
    this.Ury = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.Gra = k.cm((kotlin.g.a.a)new b(this));
    setLayerType(1, null);
    LayoutInflater.from(getContext()).inflate(a.g.timeline_editor_half_screen_view, (ViewGroup)this, true);
    setBackgroundColor(0);
    this.NSx.setColor(-1);
    this.NSx.setAntiAlias(true);
    this.NSx.setStrokeWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
    this.NSx.setStyle(Paint.Style.STROKE);
    this.NSy.setColor(Color.parseColor("#4DFFFFFF"));
    this.NSy.setAntiAlias(true);
    this.NSy.setStrokeWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 1));
    this.NSy.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(282091);
  }
  
  public TimelineEditorDragRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282108);
    this.NSy = new Paint();
    this.NSx = new Paint();
    this.NSq = new Path();
    this.NSQ = new RectF();
    this.NSM = new RectF();
    this.ymw = new RectF();
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    paramAttributeSet = ah.aiuX;
    this.paint = paramContext;
    this.Ury = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.Gra = k.cm((kotlin.g.a.a)new b(this));
    setLayerType(1, null);
    LayoutInflater.from(getContext()).inflate(a.g.timeline_editor_half_screen_view, (ViewGroup)this, true);
    setBackgroundColor(0);
    this.NSx.setColor(-1);
    this.NSx.setAntiAlias(true);
    this.NSx.setStrokeWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
    this.NSx.setStyle(Paint.Style.STROKE);
    this.NSy.setColor(Color.parseColor("#4DFFFFFF"));
    this.NSy.setAntiAlias(true);
    this.NSy.setStrokeWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 1));
    this.NSy.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(282108);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(282132);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(282132);
    return localGestureDetector;
  }
  
  private final void hUI()
  {
    AppMethodBeat.i(282150);
    this.NSq.reset();
    int j;
    for (int i = 1;; i = j)
    {
      j = i + 1;
      this.NSq.moveTo(this.NSQ.left + this.NSQ.width() / 3.0F * i, this.NSQ.top);
      this.NSq.lineTo(this.NSQ.left + this.NSQ.width() / 3.0F * i, this.NSQ.bottom);
      this.NSq.moveTo(this.NSQ.left, this.NSQ.top + this.NSQ.height() / 3.0F * i);
      Path localPath = this.NSq;
      float f1 = this.NSQ.right;
      float f2 = this.NSQ.top;
      float f3 = this.NSQ.height() / 3.0F;
      localPath.lineTo(f1, i * f3 + f2);
      if (j > 2)
      {
        AppMethodBeat.o(282150);
        return;
      }
    }
  }
  
  private final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(282117);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(282117);
  }
  
  public final void a(RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(282172);
    s.u(paramRectF1, "visibilityRect");
    s.u(paramRectF2, "validRect");
    this.NSM = paramRectF1;
    this.ymw = paramRectF2;
    this.NSQ = paramRectF1;
    hUI();
    postInvalidate();
    AppMethodBeat.o(282172);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282200);
    s.u(paramMotionEvent, "event");
    this.Urx = false;
    if (this.NSM.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      this.Urx = true;
    }
    if (this.Urx)
    {
      if (this.NSM.width() == this.ymw.width())
      {
        i = 1;
        if (i != 0)
        {
          if (this.NSM.height() != this.ymw.height()) {
            break label115;
          }
          i = 1;
          label92:
          if (i != 0) {
            break label120;
          }
        }
      }
      label115:
      label120:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label125;
        }
        AppMethodBeat.o(282200);
        return true;
        i = 0;
        break;
        i = 0;
        break label92;
      }
    }
    label125:
    AppMethodBeat.o(282200);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(282270);
    s.u(paramCanvas, "canvas");
    paramCanvas.drawColor(this.bgColor);
    this.paint.setXfermode((Xfermode)this.Ury);
    paramCanvas.drawRect(this.NSM, this.paint);
    this.paint.setXfermode(null);
    paramCanvas.drawPath(this.NSq, this.NSy);
    paramCanvas.drawRect(this.NSQ, this.NSx);
    AppMethodBeat.o(282270);
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282251);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(282251);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(282212);
    s.u(paramMotionEvent1, "event");
    s.u(paramMotionEvent2, "e2");
    Log.d("MicroMsg.MultiCropOpLayout", s.X("[onScroll] event=", paramMotionEvent1));
    if (this.Urx)
    {
      this.NSM.offset(-paramFloat1, -paramFloat2);
      if (this.NSM.top < this.ymw.top) {
        this.NSM.offset(0.0F, this.ymw.top - this.NSM.top);
      }
      if (this.NSM.bottom > this.ymw.bottom) {
        this.NSM.offset(0.0F, this.ymw.bottom - this.NSM.bottom);
      }
      if (this.NSM.left < this.ymw.left) {
        this.NSM.offset(this.ymw.left - this.NSM.left, 0.0F);
      }
      if (this.NSM.right > this.ymw.right) {
        this.NSM.offset(this.ymw.right - this.NSM.right, 0.0F);
      }
      hUI();
    }
    postInvalidate();
    boolean bool = this.Urx;
    AppMethodBeat.o(282212);
    return bool;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282231);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(282231);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282186);
    s.u(paramMotionEvent, "event");
    super.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.Urx = false;
    }
    GestureDetector localGestureDetector = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(282186);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
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