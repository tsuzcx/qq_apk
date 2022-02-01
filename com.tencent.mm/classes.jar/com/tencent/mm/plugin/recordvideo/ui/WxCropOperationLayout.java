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
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "girdLinePaint", "girdLinePath", "grepBlockPaint", "isBelongBottomBlock", "isBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "()Landroid/graphics/RectF;", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public final class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final WxCropOperationLayout.g xYE;
  private int bgColor;
  private final Paint paint;
  private j tVM;
  private final f tbc;
  private final f xXM;
  private final f xXN;
  private final f xXO;
  private final f xXP;
  private final f xXQ;
  private final f xXR;
  private final f xXS;
  private final f xXT;
  private final f xXU;
  private final Path xXV;
  private final Path xXW;
  private final Path xXX;
  private final Path xXY;
  private final Path xXZ;
  public ValueAnimator xYA;
  private final RectF xYB;
  private final PointF xYC;
  private final PointF xYD;
  private final Path xYa;
  private final Path xYb;
  private final Paint xYc;
  private final Paint xYd;
  private final Paint xYe;
  private final Paint xYf;
  private final Paint xYg;
  private final RectF xYh;
  private final RectF xYi;
  public int xYj;
  private i xYk;
  private d.g.a.a<z> xYl;
  private boolean xYm;
  private final f xYn;
  private final View[] xYo;
  public boolean xYp;
  private ValueAnimator xYq;
  private final RectF xYr;
  private float xYs;
  private float xYt;
  private final RectF xYu;
  private final RectF xYv;
  private final PorterDuffXfermode xYw;
  private boolean xYx;
  private boolean xYy;
  private com.tencent.mm.ui.widget.cropview.b xYz;
  
  static
  {
    AppMethodBeat.i(206755);
    xYE = new WxCropOperationLayout.g((byte)0);
    AppMethodBeat.o(206755);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206752);
    this.xXM = g.O((d.g.a.a)new c(this));
    this.xXN = g.O((d.g.a.a)new b(this));
    this.xXO = g.O((d.g.a.a)new f(this));
    this.xXP = g.O((d.g.a.a)new a(this));
    this.xXQ = g.O((d.g.a.a)new d(this));
    this.xXR = g.O((d.g.a.a)new e(this));
    this.xXS = g.O((d.g.a.a)new k(this));
    this.xXT = g.O((d.g.a.a)new l(this));
    this.xXU = g.O((d.g.a.a)new m(this));
    this.tbc = g.O((d.g.a.a)new s(this));
    this.xXV = new Path();
    this.xXW = new Path();
    this.xXX = new Path();
    this.xXY = new Path();
    this.xXZ = new Path();
    this.xYa = new Path();
    this.xYb = new Path();
    this.xYc = new Paint();
    this.xYd = new Paint();
    this.xYe = new Paint();
    this.xYf = new Paint();
    this.xYg = new Paint();
    this.xYh = new RectF();
    this.xYi = new RectF();
    this.tVM = j.xYQ;
    this.xYn = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.xYo = paramContext;
    this.xYp = true;
    setBackgroundColor(0);
    this.xYc.setColor(-1);
    this.xYc.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xYc.setStyle(Paint.Style.STROKE);
    this.xYc.setAntiAlias(true);
    this.xYd.set(this.xYc);
    this.xYd.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYe.set(this.xYc);
    this.xYe.setStrokeWidth(getCORNER_WIDTH());
    this.xYf.set(this.xYc);
    this.xYf.setStrokeCap(Paint.Cap.ROUND);
    this.xYf.setStrokeWidth(getBLOCK_WIDTH());
    this.xYg.set(this.xYc);
    this.xYg.setStrokeCap(Paint.Cap.ROUND);
    this.xYg.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYg.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xYr = new RectF();
    this.xYu = new RectF();
    this.xYv = new RectF();
    this.xYw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xYB = new RectF();
    this.xYC = new PointF();
    this.xYD = new PointF();
    AppMethodBeat.o(206752);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206753);
    this.xXM = g.O((d.g.a.a)new c(this));
    this.xXN = g.O((d.g.a.a)new b(this));
    this.xXO = g.O((d.g.a.a)new f(this));
    this.xXP = g.O((d.g.a.a)new a(this));
    this.xXQ = g.O((d.g.a.a)new d(this));
    this.xXR = g.O((d.g.a.a)new e(this));
    this.xXS = g.O((d.g.a.a)new k(this));
    this.xXT = g.O((d.g.a.a)new l(this));
    this.xXU = g.O((d.g.a.a)new m(this));
    this.tbc = g.O((d.g.a.a)new s(this));
    this.xXV = new Path();
    this.xXW = new Path();
    this.xXX = new Path();
    this.xXY = new Path();
    this.xXZ = new Path();
    this.xYa = new Path();
    this.xYb = new Path();
    this.xYc = new Paint();
    this.xYd = new Paint();
    this.xYe = new Paint();
    this.xYf = new Paint();
    this.xYg = new Paint();
    this.xYh = new RectF();
    this.xYi = new RectF();
    this.tVM = j.xYQ;
    this.xYn = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.xYo = paramContext;
    this.xYp = true;
    setBackgroundColor(0);
    this.xYc.setColor(-1);
    this.xYc.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xYc.setStyle(Paint.Style.STROKE);
    this.xYc.setAntiAlias(true);
    this.xYd.set(this.xYc);
    this.xYd.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYe.set(this.xYc);
    this.xYe.setStrokeWidth(getCORNER_WIDTH());
    this.xYf.set(this.xYc);
    this.xYf.setStrokeCap(Paint.Cap.ROUND);
    this.xYf.setStrokeWidth(getBLOCK_WIDTH());
    this.xYg.set(this.xYc);
    this.xYg.setStrokeCap(Paint.Cap.ROUND);
    this.xYg.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYg.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xYr = new RectF();
    this.xYu = new RectF();
    this.xYv = new RectF();
    this.xYw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xYB = new RectF();
    this.xYC = new PointF();
    this.xYD = new PointF();
    AppMethodBeat.o(206753);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206754);
    this.xXM = g.O((d.g.a.a)new c(this));
    this.xXN = g.O((d.g.a.a)new b(this));
    this.xXO = g.O((d.g.a.a)new f(this));
    this.xXP = g.O((d.g.a.a)new a(this));
    this.xXQ = g.O((d.g.a.a)new d(this));
    this.xXR = g.O((d.g.a.a)new e(this));
    this.xXS = g.O((d.g.a.a)new k(this));
    this.xXT = g.O((d.g.a.a)new l(this));
    this.xXU = g.O((d.g.a.a)new m(this));
    this.tbc = g.O((d.g.a.a)new s(this));
    this.xXV = new Path();
    this.xXW = new Path();
    this.xXX = new Path();
    this.xXY = new Path();
    this.xXZ = new Path();
    this.xYa = new Path();
    this.xYb = new Path();
    this.xYc = new Paint();
    this.xYd = new Paint();
    this.xYe = new Paint();
    this.xYf = new Paint();
    this.xYg = new Paint();
    this.xYh = new RectF();
    this.xYi = new RectF();
    this.tVM = j.xYQ;
    this.xYn = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.xYo = paramContext;
    this.xYp = true;
    setBackgroundColor(0);
    this.xYc.setColor(-1);
    this.xYc.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xYc.setStyle(Paint.Style.STROKE);
    this.xYc.setAntiAlias(true);
    this.xYd.set(this.xYc);
    this.xYd.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYe.set(this.xYc);
    this.xYe.setStrokeWidth(getCORNER_WIDTH());
    this.xYf.set(this.xYc);
    this.xYf.setStrokeCap(Paint.Cap.ROUND);
    this.xYf.setStrokeWidth(getBLOCK_WIDTH());
    this.xYg.set(this.xYc);
    this.xYg.setStrokeCap(Paint.Cap.ROUND);
    this.xYg.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xYg.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xYr = new RectF();
    this.xYu = new RectF();
    this.xYv = new RectF();
    this.xYw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xYB = new RectF();
    this.xYC = new PointF();
    this.xYD = new PointF();
    AppMethodBeat.o(206754);
  }
  
  private void dKF()
  {
    AppMethodBeat.i(206743);
    Object localObject1 = this.xYo;
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
    localObject1 = this.xYz;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject1).zb(false);
      AppMethodBeat.o(206743);
      return;
    }
    AppMethodBeat.o(206743);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(206721);
    float f = ((Number)this.xXP.getValue()).floatValue();
    AppMethodBeat.o(206721);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(206719);
    float f = ((Number)this.xXN.getValue()).floatValue();
    AppMethodBeat.o(206719);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(206718);
    float f = ((Number)this.xXM.getValue()).floatValue();
    AppMethodBeat.o(206718);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(206722);
    float f = ((Number)this.xXQ.getValue()).floatValue();
    AppMethodBeat.o(206722);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(206729);
    Drawable localDrawable = (Drawable)this.xYn.getValue();
    AppMethodBeat.o(206729);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(206723);
    float f = ((Number)this.xXR.getValue()).floatValue();
    AppMethodBeat.o(206723);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(206720);
    float f = ((Number)this.xXO.getValue()).floatValue();
    AppMethodBeat.o(206720);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(206724);
    float f = ((Number)this.xXS.getValue()).floatValue();
    AppMethodBeat.o(206724);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(206727);
    GestureDetector localGestureDetector = (GestureDetector)this.tbc.getValue();
    AppMethodBeat.o(206727);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(206725);
    int i = ((Number)this.xXT.getValue()).intValue();
    AppMethodBeat.o(206725);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(206726);
    int i = ((Number)this.xXU.getValue()).intValue();
    AppMethodBeat.o(206726);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(206730);
    p.h(paramView, "view");
    p.h(paramh, "style");
    View localView = this.xYo[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.xYo[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(206730);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(206732);
    p.h(paramh, "style");
    View localView = this.xYo[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.xYo[paramh.value] = null;
    AppMethodBeat.o(206732);
  }
  
  public final void ar(int paramInt, final long paramLong)
  {
    AppMethodBeat.i(206740);
    ValueAnimator localValueAnimator = this.xYA;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.xYj, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new p(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.xYA = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      dKE();
      AppMethodBeat.o(206740);
      return;
      localValueAnimator = null;
    }
    dKF();
    AppMethodBeat.o(206740);
  }
  
  public final void dKD()
  {
    AppMethodBeat.i(206731);
    View[] arrayOfView = this.xYo;
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
    AppMethodBeat.o(206731);
  }
  
  public final void dKE()
  {
    AppMethodBeat.i(206742);
    this.xYj = 255;
    Object localObject = getContext();
    p.g(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(2131165289);
    localObject = this.xYo;
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
        localView.animate().setStartDelay(300L).withStartAction((Runnable)new q(localView, i, localView, this, f)).alpha(1.0F).setDuration(300L).start();
      }
      j += 1;
      i += 1;
    }
    localObject = this.xYz;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject).zb(true);
      AppMethodBeat.o(206742);
      return;
    }
    AppMethodBeat.o(206742);
  }
  
  public final void dKG()
  {
    AppMethodBeat.i(206750);
    ValueAnimator localValueAnimator = this.xYq;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -14474461 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this));
    localValueAnimator.start();
    this.xYq = localValueAnimator;
    AppMethodBeat.o(206750);
  }
  
  public final void dKH()
  {
    AppMethodBeat.i(206751);
    ValueAnimator localValueAnimator = this.xYq;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -1088216285 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new r(this));
    localValueAnimator.start();
    this.xYq = localValueAnimator;
    AppMethodBeat.o(206751);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final boolean getBlockOutsideTouch()
  {
    return this.xYm;
  }
  
  public final com.tencent.mm.ui.widget.cropview.b getBorderVisibilityCallback()
  {
    return this.xYz;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.xYs;
  }
  
  public final float getLimitMinHeight()
  {
    return this.xYt;
  }
  
  public final i getOnOperationCallback()
  {
    return this.xYk;
  }
  
  public final d.g.a.a<z> getOutsideTouckListener()
  {
    return this.xYl;
  }
  
  public final j getStyle()
  {
    return this.tVM;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.xYr;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(206744);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.xYA;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.xYq;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(206744);
      return;
    }
    AppMethodBeat.o(206744);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206747);
    p.h(paramMotionEvent, "event");
    Object localObject;
    if (!this.xYr.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      localObject = this.xYl;
      if (localObject != null) {
        ((d.g.a.a)localObject).invoke();
      }
    }
    if (this.tVM == j.xYQ)
    {
      this.xYy = false;
      this.xYx = false;
      if (this.xYh.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.xYx = true;
        localObject = this.xYk;
        if (localObject != null) {
          ((i)localObject).mS(true);
        }
      }
      for (;;)
      {
        if ((this.xYx) || (this.xYy)) {
          ar(255, 0L);
        }
        if ((!this.xYx) && (!this.xYy) && ((!this.xYm) || (this.xYr.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))) {
          break;
        }
        AppMethodBeat.o(206747);
        return true;
        if (this.xYi.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.xYy = true;
          localObject = this.xYk;
          if (localObject != null) {
            ((i)localObject).mS(false);
          }
        }
      }
      AppMethodBeat.o(206747);
      return false;
    }
    AppMethodBeat.o(206747);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206737);
    p.h(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.xYu, null);
    paramCanvas.drawRect(this.xYu, this.paint);
    this.paint.setXfermode((Xfermode)this.xYw);
    if (j.xYP == this.tVM)
    {
      paramCanvas.drawCircle(this.xYr.centerX(), this.xYr.centerY(), Math.min(this.xYr.width(), this.xYr.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if ((this.tVM != j.xYP) && (this.tVM != j.xYR)) {
        break label396;
      }
    }
    for (;;)
    {
      if ((this.tVM == j.xYQ) || (this.tVM == j.xYS))
      {
        this.xYd.setAlpha(this.xYj);
        this.xYc.setAlpha(this.xYj);
        if (this.xYp) {
          paramCanvas.drawPath(this.xXV, this.xYd);
        }
        paramCanvas.drawRect(this.xYv, this.xYd);
        if (this.tVM == j.xYQ)
        {
          paramCanvas.save();
          paramCanvas.translate(this.xYD.x, this.xYD.y);
          if ((getBlockDrawable() instanceof BitmapDrawable))
          {
            getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
            getBlockDrawable().draw(paramCanvas);
          }
          paramCanvas.restore();
          paramCanvas.save();
          paramCanvas.translate(this.xYC.x, this.xYC.y);
          if ((getBlockDrawable() instanceof BitmapDrawable))
          {
            getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
            getBlockDrawable().draw(paramCanvas);
          }
          paramCanvas.restore();
        }
      }
      AppMethodBeat.o(206737);
      return;
      if ((j.xYQ != this.tVM) && (j.xYR != this.tVM) && (j.xYS != this.tVM)) {
        break;
      }
      paramCanvas.drawRect(this.xYr, this.paint);
      break;
      label396:
      if (!p.i(this.xYr, this.xYB))
      {
        this.xYB.set(this.xYr);
        i locali = this.xYk;
        if (locali != null) {
          locali.e(this.xYr);
        }
        this.xYv.set(this.xYr);
        this.xYv.set(this.xYr.left + getBOX_PADDING(), this.xYr.top + getBOX_PADDING(), this.xYr.right - getBOX_PADDING(), this.xYr.bottom - getBOX_PADDING());
        float f1 = this.xYv.left + this.xYv.width() / 2.0F;
        float f2 = this.xYv.bottom;
        this.xYi.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.xYC.set(this.xYv.width() / 2.0F - get_4A() / 2 + this.xYr.left, this.xYv.top - get_1A() / 2);
        this.xYD.set(this.xYv.width() / 2.0F - get_4A() / 2 + this.xYr.left, this.xYv.bottom - get_1A() / 2);
        f2 = this.xYv.top;
        this.xYh.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.xXV.reset();
        i = 1;
        while (i <= 2)
        {
          this.xXV.moveTo(this.xYv.left + this.xYv.width() / 3.0F * i, this.xYv.top);
          this.xXV.lineTo(this.xYv.left + this.xYv.width() / 3.0F * i, this.xYv.bottom);
          this.xXV.moveTo(this.xYv.left, this.xYv.top + this.xYv.height() / 3.0F * i);
          this.xXV.lineTo(this.xYv.right, this.xYv.top + this.xYv.height() / 3.0F * i);
          i += 1;
        }
      }
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206748);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(206748);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206736);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(206736);
      return;
    }
    ar(255, 500L);
    this.xYu.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xYr.isEmpty()) {
      this.xYr.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.xYs == 0.0F) {
      setLimitMaxHeight(this.xYu.height() / 2.0F);
    }
    if (this.xYt == 0.0F) {
      setLimitMinHeight(this.xYu.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(206736);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206749);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(206749);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206738);
    p.h(paramMotionEvent1, "event");
    p.h(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.xYx)
    {
      paramMotionEvent1 = this.xYr;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.xYr;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.xYy)
    {
      paramMotionEvent1 = this.xYr;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.xYr;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.xYr.height() > this.xYs)
    {
      paramFloat1 = this.xYs - this.xYr.height();
      paramMotionEvent1 = this.xYr;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.xYr;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.xYy) && (!this.xYx)) {
        break;
      }
      AppMethodBeat.o(206738);
      return true;
      if (this.xYr.height() < this.xYt)
      {
        paramFloat1 = this.xYt - this.xYr.height();
        paramMotionEvent1 = this.xYr;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.xYr;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(206738);
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206745);
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(206745);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206746);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(206746);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206739);
    p.h(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.xYx) || (this.xYy)))
    {
      ar(0, 1000L);
      localObject = this.xYk;
      if (localObject != null) {
        ((i)localObject).mT(this.xYx);
      }
    }
    Object localObject = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahE(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(206739);
    return bool;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(206733);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(206733);
  }
  
  public final void setBlockOutsideTouch(boolean paramBoolean)
  {
    this.xYm = paramBoolean;
  }
  
  public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.b paramb)
  {
    this.xYz = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(206734);
    this.xYs = paramFloat;
    postInvalidate();
    AppMethodBeat.o(206734);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(206735);
    this.xYt = paramFloat;
    postInvalidate();
    AppMethodBeat.o(206735);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.xYk = parami;
  }
  
  public final void setOutsideTouckListener(d.g.a.a<z> parama)
  {
    this.xYl = parama;
  }
  
  public final void setStyle(j paramj)
  {
    AppMethodBeat.i(206728);
    p.h(paramj, "value");
    this.tVM = paramj;
    postInvalidate();
    AppMethodBeat.o(206728);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(206703);
      h localh1 = new h("TOP_LEFT", 0, 0);
      xYG = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      xYH = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      xYI = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      xYJ = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      xYK = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      xYL = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      xYM = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      xYN = localh8;
      xYO = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(206703);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void e(RectF paramRectF);
    
    public abstract void mS(boolean paramBoolean);
    
    public abstract void mT(boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "", "(Ljava/lang/String;I)V", "CIRCLE", "RECT_ADJUST", "RECT_HARD", "RECT_LINE_HARD", "plugin-recordvideo_release"})
  public static enum j
  {
    static
    {
      AppMethodBeat.i(206706);
      j localj1 = new j("CIRCLE", 0);
      xYP = localj1;
      j localj2 = new j("RECT_ADJUST", 1);
      xYQ = localj2;
      j localj3 = new j("RECT_HARD", 2);
      xYR = localj3;
      j localj4 = new j("RECT_LINE_HARD", 3);
      xYS = localj4;
      xYT = new j[] { localj1, localj2, localj3, localj4 };
      AppMethodBeat.o(206706);
    }
    
    private j() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$hideInvisible$1$1"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206713);
      WxCropOperationLayout localWxCropOperationLayout = this.xYF;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(206713);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.xYF.invalidate();
      AppMethodBeat.o(206713);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
  static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    p(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206714);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(206714);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      WxCropOperationLayout.a(this.xYF, i);
      this.xYF.invalidate();
      AppMethodBeat.o(206714);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class q
    implements Runnable
  {
    q(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(206715);
      int i = i;
      if (i == WxCropOperationLayout.h.xYG.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYH.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rUC.getWidth());
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYI.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYJ.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rUC.getWidth());
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYK.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYL.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rUC.getWidth());
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYM.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(206715);
        return;
      }
      if (i == WxCropOperationLayout.h.xYN.value)
      {
        this.rUC.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.rUC.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rUC.getWidth());
      }
      AppMethodBeat.o(206715);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showInvisible$1$1"})
  static final class r
    implements ValueAnimator.AnimatorUpdateListener
  {
    r(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206716);
      WxCropOperationLayout localWxCropOperationLayout = this.xYF;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(206716);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.xYF.invalidate();
      AppMethodBeat.o(206716);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class s
    extends q
    implements d.g.a.a<GestureDetector>
  {
    s(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */