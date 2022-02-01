package com.tencent.mm.plugin.recordvideo.ui;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cropview.b;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "Landroid/animation/ValueAnimator;", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "girdLinePaint", "girdLinePath", "grepBlockPaint", "isBelongBottomBlock", "", "isBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "paint", "showGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "()Landroid/graphics/RectF;", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideCornerView", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public final class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final g Lpy;
  private j Lmq;
  private final f LoQ;
  private final f LoR;
  private final f LoS;
  private final f LoT;
  private final Path LoU;
  private final Path LoV;
  private final Path LoW;
  private final Path LoX;
  private final Path LoY;
  private final Path LoZ;
  private final Path Lpa;
  private final Paint Lpb;
  private final Paint Lpc;
  private final Paint Lpd;
  private final Paint Lpe;
  private final Paint Lpf;
  private final RectF Lpg;
  private final RectF Lph;
  private int Lpi;
  private i Lpj;
  private final f Lpk;
  private final View[] Lpl;
  public boolean Lpm;
  private float Lpn;
  private float Lpo;
  private final RectF Lpp;
  private final PorterDuffXfermode Lpq;
  private boolean Lpr;
  private boolean Lps;
  private b Lpt;
  private ValueAnimator Lpu;
  private final RectF Lpv;
  private final PointF Lpw;
  private final PointF Lpx;
  private int bgColor;
  private final Paint paint;
  private final f rFB;
  private final RectF rFV;
  private final RectF rFY;
  private final f rFs;
  private final f rFt;
  private final f rFu;
  private final f rFw;
  private final f rFx;
  
  static
  {
    AppMethodBeat.i(204260);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "CORNER_WIDTH", "getCORNER_WIDTH()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "BLOCK_WIDTH", "getBLOCK_WIDTH()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "BOX_PADDING", "getBOX_PADDING()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "CORNER_LENGTH", "getCORNER_LENGTH()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING()F")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "_1A", "get_1A()I")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "_4A", "get_4A()I")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")), (d.l.k)w.a(new u(w.bk(WxCropOperationLayout.class), "blockDrawable", "getBlockDrawable()Landroid/graphics/drawable/Drawable;")) };
    Lpy = new g((byte)0);
    AppMethodBeat.o(204260);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204293);
    this.rFs = g.E((a)new c(this));
    this.rFt = g.E((a)new b(this));
    this.rFu = g.E((a)new f(this));
    this.LoQ = g.E((a)new a(this));
    this.rFw = g.E((a)new d(this));
    this.rFx = g.E((a)new e(this));
    this.LoR = g.E((a)new k(this));
    this.LoS = g.E((a)new l(this));
    this.LoT = g.E((a)new m(this));
    this.rFB = g.E((a)new q(this));
    this.LoU = new Path();
    this.LoV = new Path();
    this.LoW = new Path();
    this.LoX = new Path();
    this.LoY = new Path();
    this.LoZ = new Path();
    this.Lpa = new Path();
    this.Lpb = new Paint();
    this.Lpc = new Paint();
    this.Lpd = new Paint();
    this.Lpe = new Paint();
    this.Lpf = new Paint();
    this.Lpg = new RectF();
    this.Lph = new RectF();
    this.Lmq = j.LpK;
    this.Lpk = g.E((a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.Lpl = paramContext;
    this.Lpm = true;
    setBackgroundColor(0);
    this.Lpb.setColor(-1);
    this.Lpb.setStrokeWidth(getBOX_LINE_WIDTH());
    this.Lpb.setStyle(Paint.Style.STROKE);
    this.Lpb.setAntiAlias(true);
    this.Lpc.set(this.Lpb);
    this.Lpc.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpd.set(this.Lpb);
    this.Lpd.setStrokeWidth(getCORNER_WIDTH());
    this.Lpe.set(this.Lpb);
    this.Lpe.setStrokeCap(Paint.Cap.ROUND);
    this.Lpe.setStrokeWidth(getBLOCK_WIDTH());
    this.Lpf.set(this.Lpb);
    this.Lpf.setStrokeCap(Paint.Cap.ROUND);
    this.Lpf.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpf.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.rFV = new RectF();
    this.rFY = new RectF();
    this.Lpp = new RectF();
    this.Lpq = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.Lpv = new RectF();
    this.Lpw = new PointF();
    this.Lpx = new PointF();
    AppMethodBeat.o(204293);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204294);
    this.rFs = g.E((a)new c(this));
    this.rFt = g.E((a)new b(this));
    this.rFu = g.E((a)new f(this));
    this.LoQ = g.E((a)new a(this));
    this.rFw = g.E((a)new d(this));
    this.rFx = g.E((a)new e(this));
    this.LoR = g.E((a)new k(this));
    this.LoS = g.E((a)new l(this));
    this.LoT = g.E((a)new m(this));
    this.rFB = g.E((a)new q(this));
    this.LoU = new Path();
    this.LoV = new Path();
    this.LoW = new Path();
    this.LoX = new Path();
    this.LoY = new Path();
    this.LoZ = new Path();
    this.Lpa = new Path();
    this.Lpb = new Paint();
    this.Lpc = new Paint();
    this.Lpd = new Paint();
    this.Lpe = new Paint();
    this.Lpf = new Paint();
    this.Lpg = new RectF();
    this.Lph = new RectF();
    this.Lmq = j.LpK;
    this.Lpk = g.E((a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.Lpl = paramContext;
    this.Lpm = true;
    setBackgroundColor(0);
    this.Lpb.setColor(-1);
    this.Lpb.setStrokeWidth(getBOX_LINE_WIDTH());
    this.Lpb.setStyle(Paint.Style.STROKE);
    this.Lpb.setAntiAlias(true);
    this.Lpc.set(this.Lpb);
    this.Lpc.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpd.set(this.Lpb);
    this.Lpd.setStrokeWidth(getCORNER_WIDTH());
    this.Lpe.set(this.Lpb);
    this.Lpe.setStrokeCap(Paint.Cap.ROUND);
    this.Lpe.setStrokeWidth(getBLOCK_WIDTH());
    this.Lpf.set(this.Lpb);
    this.Lpf.setStrokeCap(Paint.Cap.ROUND);
    this.Lpf.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpf.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.rFV = new RectF();
    this.rFY = new RectF();
    this.Lpp = new RectF();
    this.Lpq = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.Lpv = new RectF();
    this.Lpw = new PointF();
    this.Lpx = new PointF();
    AppMethodBeat.o(204294);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204295);
    this.rFs = g.E((a)new c(this));
    this.rFt = g.E((a)new b(this));
    this.rFu = g.E((a)new f(this));
    this.LoQ = g.E((a)new a(this));
    this.rFw = g.E((a)new d(this));
    this.rFx = g.E((a)new e(this));
    this.LoR = g.E((a)new k(this));
    this.LoS = g.E((a)new l(this));
    this.LoT = g.E((a)new m(this));
    this.rFB = g.E((a)new q(this));
    this.LoU = new Path();
    this.LoV = new Path();
    this.LoW = new Path();
    this.LoX = new Path();
    this.LoY = new Path();
    this.LoZ = new Path();
    this.Lpa = new Path();
    this.Lpb = new Paint();
    this.Lpc = new Paint();
    this.Lpd = new Paint();
    this.Lpe = new Paint();
    this.Lpf = new Paint();
    this.Lpg = new RectF();
    this.Lph = new RectF();
    this.Lmq = j.LpK;
    this.Lpk = g.E((a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.Lpl = paramContext;
    this.Lpm = true;
    setBackgroundColor(0);
    this.Lpb.setColor(-1);
    this.Lpb.setStrokeWidth(getBOX_LINE_WIDTH());
    this.Lpb.setStyle(Paint.Style.STROKE);
    this.Lpb.setAntiAlias(true);
    this.Lpc.set(this.Lpb);
    this.Lpc.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpd.set(this.Lpb);
    this.Lpd.setStrokeWidth(getCORNER_WIDTH());
    this.Lpe.set(this.Lpb);
    this.Lpe.setStrokeCap(Paint.Cap.ROUND);
    this.Lpe.setStrokeWidth(getBLOCK_WIDTH());
    this.Lpf.set(this.Lpb);
    this.Lpf.setStrokeCap(Paint.Cap.ROUND);
    this.Lpf.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.Lpf.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.rFV = new RectF();
    this.rFY = new RectF();
    this.Lpp = new RectF();
    this.Lpq = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.Lpv = new RectF();
    this.Lpw = new PointF();
    this.Lpx = new PointF();
    AppMethodBeat.o(204295);
  }
  
  private void fYs()
  {
    AppMethodBeat.i(204286);
    Object localObject1 = this.Lpl;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setVisibility(8);
      }
      i += 1;
    }
    localObject1 = this.Lpt;
    if (localObject1 != null)
    {
      ((b)localObject1).wT(false);
      AppMethodBeat.o(204286);
      return;
    }
    AppMethodBeat.o(204286);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(204264);
    float f = ((Number)this.LoQ.getValue()).floatValue();
    AppMethodBeat.o(204264);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(204262);
    float f = ((Number)this.rFt.getValue()).floatValue();
    AppMethodBeat.o(204262);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(204261);
    float f = ((Number)this.rFs.getValue()).floatValue();
    AppMethodBeat.o(204261);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(204265);
    float f = ((Number)this.rFw.getValue()).floatValue();
    AppMethodBeat.o(204265);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(204272);
    Drawable localDrawable = (Drawable)this.Lpk.getValue();
    AppMethodBeat.o(204272);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(204266);
    float f = ((Number)this.rFx.getValue()).floatValue();
    AppMethodBeat.o(204266);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(204263);
    float f = ((Number)this.rFu.getValue()).floatValue();
    AppMethodBeat.o(204263);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(204267);
    float f = ((Number)this.LoR.getValue()).floatValue();
    AppMethodBeat.o(204267);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(204270);
    GestureDetector localGestureDetector = (GestureDetector)this.rFB.getValue();
    AppMethodBeat.o(204270);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(204268);
    int i = ((Number)this.LoS.getValue()).intValue();
    AppMethodBeat.o(204268);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(204269);
    int i = ((Number)this.LoT.getValue()).intValue();
    AppMethodBeat.o(204269);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(204273);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramh, "style");
    View localView = this.Lpl[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.Lpl[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(204273);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(204275);
    d.g.b.k.h(paramh, "style");
    View localView = this.Lpl[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.Lpl[paramh.value] = null;
    AppMethodBeat.o(204275);
  }
  
  public final void ah(int paramInt, final long paramLong)
  {
    AppMethodBeat.i(204283);
    ValueAnimator localValueAnimator = this.Lpu;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.Lpi, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.Lpu = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      fYr();
      AppMethodBeat.o(204283);
      return;
      localValueAnimator = null;
    }
    fYs();
    AppMethodBeat.o(204283);
  }
  
  public final void fYq()
  {
    AppMethodBeat.i(204274);
    View[] arrayOfView = this.Lpl;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      if (localView != null) {
        removeView(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(204274);
  }
  
  public final void fYr()
  {
    AppMethodBeat.i(204285);
    this.Lpi = 255;
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(2131165289);
    localObject = this.Lpl;
    final int i = 0;
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      final View localView = localObject[j];
      if (localView != null)
      {
        localView.setVisibility(0);
        localView.setAlpha(0.0F);
        localView.animate().setStartDelay(300L).withStartAction((Runnable)new p(localView, i, localView, this, f)).alpha(1.0F).setDuration(300L).start();
      }
      j += 1;
      i += 1;
    }
    localObject = this.Lpt;
    if (localObject != null)
    {
      ((b)localObject).wT(true);
      AppMethodBeat.o(204285);
      return;
    }
    AppMethodBeat.o(204285);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final b getBorderVisibilityCallback()
  {
    return this.Lpt;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.Lpn;
  }
  
  public final float getLimitMinHeight()
  {
    return this.Lpo;
  }
  
  public final i getOnOperationCallback()
  {
    return this.Lpj;
  }
  
  public final j getStyle()
  {
    return this.Lmq;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.rFV;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(204287);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.Lpu;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(204287);
      return;
    }
    AppMethodBeat.o(204287);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204290);
    d.g.b.k.h(paramMotionEvent, "event");
    if (this.Lmq == j.LpK)
    {
      this.Lps = false;
      this.Lpr = false;
      if (this.Lpg.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.Lpr = true;
        paramMotionEvent = this.Lpj;
        if (paramMotionEvent != null) {
          paramMotionEvent.yV(true);
        }
      }
      for (;;)
      {
        if ((this.Lpr) || (this.Lps)) {
          ah(255, 0L);
        }
        if ((!this.Lpr) && (!this.Lps)) {
          break;
        }
        AppMethodBeat.o(204290);
        return true;
        if (this.Lph.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.Lps = true;
          paramMotionEvent = this.Lpj;
          if (paramMotionEvent != null) {
            paramMotionEvent.yV(false);
          }
        }
      }
      AppMethodBeat.o(204290);
      return false;
    }
    AppMethodBeat.o(204290);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204280);
    d.g.b.k.h(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.rFY, null);
    paramCanvas.drawRect(this.rFY, this.paint);
    this.paint.setXfermode((Xfermode)this.Lpq);
    if (j.LpJ == this.Lmq)
    {
      paramCanvas.drawCircle(this.rFV.centerX(), this.rFV.centerY(), Math.min(this.rFV.width(), this.rFV.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if (!d.g.b.k.g(this.rFV, this.Lpv))
      {
        this.Lpv.set(this.rFV);
        if ((this.Lmq != j.LpJ) && (this.Lmq != j.LpL)) {
          break label391;
        }
      }
    }
    for (;;)
    {
      if (this.Lmq == j.LpK)
      {
        this.Lpc.setAlpha(this.Lpi);
        this.Lpb.setAlpha(this.Lpi);
        if (this.Lpm) {
          paramCanvas.drawPath(this.LoU, this.Lpc);
        }
        paramCanvas.drawRect(this.Lpp, this.Lpc);
        paramCanvas.save();
        paramCanvas.translate(this.Lpx.x, this.Lpx.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(this.Lpw.x, this.Lpw.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(204280);
      return;
      if ((j.LpK != this.Lmq) && (j.LpL != this.Lmq)) {
        break;
      }
      paramCanvas.drawRect(this.rFV, this.paint);
      break;
      label391:
      i locali = this.Lpj;
      if (locali != null) {
        locali.f(this.rFV);
      }
      this.Lpp.set(this.rFV);
      this.Lpp.set(this.rFV.left + getBOX_PADDING(), this.rFV.top + getBOX_PADDING(), this.rFV.right - getBOX_PADDING(), this.rFV.bottom - getBOX_PADDING());
      float f1 = this.Lpp.left + this.Lpp.width() / 2.0F;
      float f2 = this.Lpp.bottom;
      this.Lph.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
      this.Lpw.set(this.Lpp.width() / 2.0F - get_4A() / 2, this.Lpp.top - get_1A() / 2);
      this.Lpx.set(this.Lpp.width() / 2.0F - get_4A() / 2, this.Lpp.bottom - get_1A() / 2);
      f2 = this.Lpp.top;
      this.Lpg.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
      this.LoU.reset();
      i = 1;
      while (i <= 2)
      {
        this.LoU.moveTo(this.Lpp.left + this.Lpp.width() / 3.0F * i, this.Lpp.top);
        this.LoU.lineTo(this.Lpp.left + this.Lpp.width() / 3.0F * i, this.Lpp.bottom);
        this.LoU.moveTo(this.Lpp.left, this.Lpp.top + this.Lpp.height() / 3.0F * i);
        this.LoU.lineTo(this.Lpp.right, this.Lpp.top + this.Lpp.height() / 3.0F * i);
        i += 1;
      }
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204291);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(204291);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204279);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(204279);
      return;
    }
    ah(255, 500L);
    this.rFY.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.rFV.isEmpty()) {
      this.rFV.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.Lpn == 0.0F) {
      setLimitMaxHeight(this.rFY.height() / 2.0F);
    }
    if (this.Lpo == 0.0F) {
      setLimitMinHeight(this.rFY.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(204279);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204292);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(204292);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204281);
    d.g.b.k.h(paramMotionEvent1, "event");
    d.g.b.k.h(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.Lpr)
    {
      paramMotionEvent1 = this.rFV;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.rFV;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.Lps)
    {
      paramMotionEvent1 = this.rFV;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.rFV;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.rFV.height() > this.Lpn)
    {
      paramFloat1 = this.Lpn - this.rFV.height();
      paramMotionEvent1 = this.rFV;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.rFV;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.Lps) && (!this.Lpr)) {
        break;
      }
      AppMethodBeat.o(204281);
      return true;
      if (this.rFV.height() < this.Lpo)
      {
        paramFloat1 = this.Lpo - this.rFV.height();
        paramMotionEvent1 = this.rFV;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.rFV;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(204281);
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204288);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(204288);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204289);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(204289);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204282);
    d.g.b.k.h(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.Lpr) || (this.Lps))) {
      ah(0, 1000L);
    }
    boolean bool = getTouchDetector().onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(204282);
    return bool;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(204276);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(204276);
  }
  
  public final void setBorderVisibilityCallback(b paramb)
  {
    this.Lpt = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(204277);
    this.Lpn = paramFloat;
    postInvalidate();
    AppMethodBeat.o(204277);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(204278);
    this.Lpo = paramFloat;
    postInvalidate();
    AppMethodBeat.o(204278);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.Lpj = parami;
  }
  
  public final void setStyle(j paramj)
  {
    AppMethodBeat.i(204271);
    d.g.b.k.h(paramj, "value");
    this.Lmq = paramj;
    postInvalidate();
    AppMethodBeat.o(204271);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Companion;", "", "()V", "BORDER_DELAY", "", "BORDER_DURATION", "TAG", "", "plugin-recordvideo_release"})
  public static final class g {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(204247);
      h localh1 = new h("TOP_LEFT", 0, 0);
      LpA = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      LpB = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      LpC = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      LpD = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      LpE = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      LpF = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      LpG = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      LpH = localh8;
      LpI = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(204247);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void f(RectF paramRectF);
    
    public abstract void yV(boolean paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "", "(Ljava/lang/String;I)V", "CIRCLE", "RECT_ADJUST", "RECT_HARD", "plugin-recordvideo_release"})
  public static enum j
  {
    static
    {
      AppMethodBeat.i(204250);
      j localj1 = new j("CIRCLE", 0);
      LpJ = localj1;
      j localj2 = new j("RECT_ADJUST", 1);
      LpK = localj2;
      j localj3 = new j("RECT_HARD", 2);
      LpL = localj3;
      LpM = new j[] { localj1, localj2, localj3 };
      AppMethodBeat.o(204250);
    }
    
    private j() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(204257);
      d.g.b.k.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(204257);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      WxCropOperationLayout.a(this.Lpz, i);
      this.Lpz.invalidate();
      AppMethodBeat.o(204257);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class p
    implements Runnable
  {
    p(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(204258);
      int i = i;
      if (i == WxCropOperationLayout.h.LpA.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpB.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.LpO.getWidth());
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpC.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpD.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.LpO.getWidth());
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpE.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpF.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.LpO.getWidth());
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpG.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(204258);
        return;
      }
      if (i == WxCropOperationLayout.h.LpH.value)
      {
        this.LpO.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.LpO.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.LpO.getWidth());
      }
      AppMethodBeat.o(204258);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class q
    extends d.g.b.l
    implements a<GestureDetector>
  {
    q(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */