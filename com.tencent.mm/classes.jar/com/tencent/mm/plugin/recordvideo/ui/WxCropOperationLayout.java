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
import com.tencent.mm.plugin.recordvideo.b.c;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "getBoxRect", "()Landroid/graphics/RectF;", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "grepBlockPaint", "gridLinePaint", "getGridLinePaint", "()Landroid/graphics/Paint;", "gridLinePath", "getGridLinePath", "()Landroid/graphics/Path;", "isBelongBottomBlock", "setBelongBottomBlock", "isBelongTopBlock", "setBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "getShowGridLine", "setShowGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final g HWl;
  private final f AOG;
  private j BZo;
  private final f HVA;
  private final f HVB;
  private final Path HVC;
  private final Path HVD;
  private final Path HVE;
  private final Path HVF;
  private final Path HVG;
  private final Path HVH;
  private final Path HVI;
  private final Paint HVJ;
  private final Paint HVK;
  private final Paint HVL;
  private final Paint HVM;
  private final Paint HVN;
  private final RectF HVO;
  private final RectF HVP;
  public int HVQ;
  private i HVR;
  private kotlin.g.a.a<x> HVS;
  private boolean HVT;
  private final f HVU;
  private final View[] HVV;
  public boolean HVW;
  private ValueAnimator HVX;
  private final RectF HVY;
  private float HVZ;
  private final f HVt;
  private final f HVu;
  private final f HVv;
  private final f HVw;
  private final f HVx;
  private final f HVy;
  private final f HVz;
  private float HWa;
  private final RectF HWb;
  private final RectF HWc;
  private final PorterDuffXfermode HWd;
  private boolean HWe;
  private boolean HWf;
  private com.tencent.mm.ui.widget.cropview.b HWg;
  public ValueAnimator HWh;
  private final RectF HWi;
  private final PointF HWj;
  private final PointF HWk;
  private int bgColor;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(228915);
    HWl = new g((byte)0);
    AppMethodBeat.o(228915);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(228896);
    this.HVt = g.ar((kotlin.g.a.a)new c(this));
    this.HVu = g.ar((kotlin.g.a.a)new b(this));
    this.HVv = g.ar((kotlin.g.a.a)new f(this));
    this.HVw = g.ar((kotlin.g.a.a)new a(this));
    this.HVx = g.ar((kotlin.g.a.a)new d(this));
    this.HVy = g.ar((kotlin.g.a.a)new e(this));
    this.HVz = g.ar((kotlin.g.a.a)new k(this));
    this.HVA = g.ar((kotlin.g.a.a)new l(this));
    this.HVB = g.ar((kotlin.g.a.a)new m(this));
    this.AOG = g.ar((kotlin.g.a.a)new s(this));
    this.HVC = new Path();
    this.HVD = new Path();
    this.HVE = new Path();
    this.HVF = new Path();
    this.HVG = new Path();
    this.HVH = new Path();
    this.HVI = new Path();
    this.HVJ = new Paint();
    this.HVK = new Paint();
    this.HVL = new Paint();
    this.HVM = new Paint();
    this.HVN = new Paint();
    this.HVO = new RectF();
    this.HVP = new RectF();
    this.BZo = j.HWx;
    this.HVU = g.ar((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.HVV = paramContext;
    this.HVW = true;
    setBackgroundColor(0);
    this.HVJ.setColor(-1);
    this.HVJ.setStrokeWidth(getBOX_LINE_WIDTH());
    this.HVJ.setStyle(Paint.Style.STROKE);
    this.HVJ.setAntiAlias(true);
    this.HVK.set(this.HVJ);
    this.HVK.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVL.set(this.HVJ);
    this.HVL.setStrokeWidth(getCORNER_WIDTH());
    this.HVM.set(this.HVJ);
    this.HVM.setStrokeCap(Paint.Cap.ROUND);
    this.HVM.setStrokeWidth(getBLOCK_WIDTH());
    this.HVN.set(this.HVJ);
    this.HVN.setStrokeCap(Paint.Cap.ROUND);
    this.HVN.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVN.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.HVY = new RectF();
    this.HWb = new RectF();
    this.HWc = new RectF();
    this.HWd = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.HWi = new RectF();
    this.HWj = new PointF();
    this.HWk = new PointF();
    AppMethodBeat.o(228896);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228912);
    this.HVt = g.ar((kotlin.g.a.a)new c(this));
    this.HVu = g.ar((kotlin.g.a.a)new b(this));
    this.HVv = g.ar((kotlin.g.a.a)new f(this));
    this.HVw = g.ar((kotlin.g.a.a)new a(this));
    this.HVx = g.ar((kotlin.g.a.a)new d(this));
    this.HVy = g.ar((kotlin.g.a.a)new e(this));
    this.HVz = g.ar((kotlin.g.a.a)new k(this));
    this.HVA = g.ar((kotlin.g.a.a)new l(this));
    this.HVB = g.ar((kotlin.g.a.a)new m(this));
    this.AOG = g.ar((kotlin.g.a.a)new s(this));
    this.HVC = new Path();
    this.HVD = new Path();
    this.HVE = new Path();
    this.HVF = new Path();
    this.HVG = new Path();
    this.HVH = new Path();
    this.HVI = new Path();
    this.HVJ = new Paint();
    this.HVK = new Paint();
    this.HVL = new Paint();
    this.HVM = new Paint();
    this.HVN = new Paint();
    this.HVO = new RectF();
    this.HVP = new RectF();
    this.BZo = j.HWx;
    this.HVU = g.ar((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.HVV = paramContext;
    this.HVW = true;
    setBackgroundColor(0);
    this.HVJ.setColor(-1);
    this.HVJ.setStrokeWidth(getBOX_LINE_WIDTH());
    this.HVJ.setStyle(Paint.Style.STROKE);
    this.HVJ.setAntiAlias(true);
    this.HVK.set(this.HVJ);
    this.HVK.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVL.set(this.HVJ);
    this.HVL.setStrokeWidth(getCORNER_WIDTH());
    this.HVM.set(this.HVJ);
    this.HVM.setStrokeCap(Paint.Cap.ROUND);
    this.HVM.setStrokeWidth(getBLOCK_WIDTH());
    this.HVN.set(this.HVJ);
    this.HVN.setStrokeCap(Paint.Cap.ROUND);
    this.HVN.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVN.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.HVY = new RectF();
    this.HWb = new RectF();
    this.HWc = new RectF();
    this.HWd = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.HWi = new RectF();
    this.HWj = new PointF();
    this.HWk = new PointF();
    AppMethodBeat.o(228912);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228914);
    this.HVt = g.ar((kotlin.g.a.a)new c(this));
    this.HVu = g.ar((kotlin.g.a.a)new b(this));
    this.HVv = g.ar((kotlin.g.a.a)new f(this));
    this.HVw = g.ar((kotlin.g.a.a)new a(this));
    this.HVx = g.ar((kotlin.g.a.a)new d(this));
    this.HVy = g.ar((kotlin.g.a.a)new e(this));
    this.HVz = g.ar((kotlin.g.a.a)new k(this));
    this.HVA = g.ar((kotlin.g.a.a)new l(this));
    this.HVB = g.ar((kotlin.g.a.a)new m(this));
    this.AOG = g.ar((kotlin.g.a.a)new s(this));
    this.HVC = new Path();
    this.HVD = new Path();
    this.HVE = new Path();
    this.HVF = new Path();
    this.HVG = new Path();
    this.HVH = new Path();
    this.HVI = new Path();
    this.HVJ = new Paint();
    this.HVK = new Paint();
    this.HVL = new Paint();
    this.HVM = new Paint();
    this.HVN = new Paint();
    this.HVO = new RectF();
    this.HVP = new RectF();
    this.BZo = j.HWx;
    this.HVU = g.ar((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.HVV = paramContext;
    this.HVW = true;
    setBackgroundColor(0);
    this.HVJ.setColor(-1);
    this.HVJ.setStrokeWidth(getBOX_LINE_WIDTH());
    this.HVJ.setStyle(Paint.Style.STROKE);
    this.HVJ.setAntiAlias(true);
    this.HVK.set(this.HVJ);
    this.HVK.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVL.set(this.HVJ);
    this.HVL.setStrokeWidth(getCORNER_WIDTH());
    this.HVM.set(this.HVJ);
    this.HVM.setStrokeCap(Paint.Cap.ROUND);
    this.HVM.setStrokeWidth(getBLOCK_WIDTH());
    this.HVN.set(this.HVJ);
    this.HVN.setStrokeCap(Paint.Cap.ROUND);
    this.HVN.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.HVN.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.HVY = new RectF();
    this.HWb = new RectF();
    this.HWc = new RectF();
    this.HWd = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.HWi = new RectF();
    this.HWj = new PointF();
    this.HWk = new PointF();
    AppMethodBeat.o(228914);
  }
  
  private void fxZ()
  {
    AppMethodBeat.i(228855);
    Object localObject1 = this.HVV;
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
    localObject1 = this.HWg;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject1).HB(false);
      AppMethodBeat.o(228855);
      return;
    }
    AppMethodBeat.o(228855);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(228746);
    float f = ((Number)this.HVw.getValue()).floatValue();
    AppMethodBeat.o(228746);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(228743);
    float f = ((Number)this.HVu.getValue()).floatValue();
    AppMethodBeat.o(228743);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(228741);
    float f = ((Number)this.HVt.getValue()).floatValue();
    AppMethodBeat.o(228741);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(228749);
    float f = ((Number)this.HVx.getValue()).floatValue();
    AppMethodBeat.o(228749);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(228769);
    Drawable localDrawable = (Drawable)this.HVU.getValue();
    AppMethodBeat.o(228769);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(228751);
    float f = ((Number)this.HVy.getValue()).floatValue();
    AppMethodBeat.o(228751);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(228745);
    float f = ((Number)this.HVv.getValue()).floatValue();
    AppMethodBeat.o(228745);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(228752);
    float f = ((Number)this.HVz.getValue()).floatValue();
    AppMethodBeat.o(228752);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(228758);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(228758);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(228754);
    int i = ((Number)this.HVA.getValue()).intValue();
    AppMethodBeat.o(228754);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(228756);
    int i = ((Number)this.HVB.getValue()).intValue();
    AppMethodBeat.o(228756);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(228780);
    p.k(paramView, "view");
    p.k(paramh, "style");
    View localView = this.HVV[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.HVV[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(228780);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(228787);
    p.k(paramh, "style");
    View localView = this.HVV[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.HVV[paramh.value] = null;
    AppMethodBeat.o(228787);
  }
  
  public void aK(int paramInt, final long paramLong)
  {
    AppMethodBeat.i(228848);
    ValueAnimator localValueAnimator = this.HWh;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.HVQ, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new p(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.HWh = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      fxY();
      AppMethodBeat.o(228848);
      return;
      localValueAnimator = null;
    }
    fxZ();
    AppMethodBeat.o(228848);
  }
  
  public final void fxV()
  {
    AppMethodBeat.i(228784);
    View[] arrayOfView = this.HVV;
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
    AppMethodBeat.o(228784);
  }
  
  protected final boolean fxW()
  {
    return this.HWe;
  }
  
  protected final boolean fxX()
  {
    return this.HWf;
  }
  
  public final void fxY()
  {
    AppMethodBeat.i(228852);
    this.HVQ = 255;
    Object localObject = getContext();
    p.j(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(b.c.Edge_2A);
    localObject = this.HVV;
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
    localObject = this.HWg;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject).HB(true);
      AppMethodBeat.o(228852);
      return;
    }
    AppMethodBeat.o(228852);
  }
  
  public final void fya()
  {
    AppMethodBeat.i(228878);
    ValueAnimator localValueAnimator = this.HVX;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -14474461 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this));
    localValueAnimator.start();
    this.HVX = localValueAnimator;
    AppMethodBeat.o(228878);
  }
  
  public final void fyb()
  {
    AppMethodBeat.i(228879);
    ValueAnimator localValueAnimator = this.HVX;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -1088216285 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new r(this));
    localValueAnimator.start();
    this.HVX = localValueAnimator;
    AppMethodBeat.o(228879);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final boolean getBlockOutsideTouch()
  {
    return this.HVT;
  }
  
  public final com.tencent.mm.ui.widget.cropview.b getBorderVisibilityCallback()
  {
    return this.HWg;
  }
  
  protected final RectF getBoxRect()
  {
    return this.HWc;
  }
  
  protected final Paint getGridLinePaint()
  {
    return this.HVK;
  }
  
  protected final Path getGridLinePath()
  {
    return this.HVC;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.HVZ;
  }
  
  public final float getLimitMinHeight()
  {
    return this.HWa;
  }
  
  public final i getOnOperationCallback()
  {
    return this.HVR;
  }
  
  public final kotlin.g.a.a<x> getOutsideTouckListener()
  {
    return this.HVS;
  }
  
  protected final boolean getShowGridLine()
  {
    return this.HVW;
  }
  
  public final j getStyle()
  {
    return this.BZo;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.HVY;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(228860);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.HWh;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.HVX;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(228860);
      return;
    }
    AppMethodBeat.o(228860);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228872);
    p.k(paramMotionEvent, "event");
    Object localObject;
    if (!this.HVY.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      localObject = this.HVS;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
    }
    if (this.BZo == j.HWx)
    {
      this.HWf = false;
      this.HWe = false;
      if (this.HVO.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.HWe = true;
        localObject = this.HVR;
        if (localObject != null) {
          ((i)localObject).rU(true);
        }
      }
      for (;;)
      {
        if ((this.HWe) || (this.HWf)) {
          aK(255, 0L);
        }
        if ((!this.HWe) && (!this.HWf) && ((!this.HVT) || (this.HVY.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))) {
          break;
        }
        AppMethodBeat.o(228872);
        return true;
        if (this.HVP.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.HWf = true;
          localObject = this.HVR;
          if (localObject != null) {
            ((i)localObject).rU(false);
          }
        }
      }
      AppMethodBeat.o(228872);
      return false;
    }
    AppMethodBeat.o(228872);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(228822);
    p.k(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.HWb, null);
    paramCanvas.drawRect(this.HWb, this.paint);
    this.paint.setXfermode((Xfermode)this.HWd);
    if (j.HWw == this.BZo)
    {
      paramCanvas.drawCircle(this.HVY.centerX(), this.HVY.centerY(), Math.min(this.HVY.width(), this.HVY.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if ((this.BZo != j.HWw) && (this.BZo != j.HWy)) {
        break label194;
      }
    }
    for (;;)
    {
      w(paramCanvas);
      AppMethodBeat.o(228822);
      return;
      if ((j.HWx != this.BZo) && (j.HWy != this.BZo) && (j.HWz != this.BZo)) {
        break;
      }
      paramCanvas.drawRect(this.HVY, this.paint);
      break;
      label194:
      if (!p.h(this.HVY, this.HWi))
      {
        this.HWi.set(this.HVY);
        i locali = this.HVR;
        if (locali != null) {
          locali.e(this.HVY);
        }
        this.HWc.set(this.HVY);
        this.HWc.set(this.HVY.left + getBOX_PADDING(), this.HVY.top + getBOX_PADDING(), this.HVY.right - getBOX_PADDING(), this.HVY.bottom - getBOX_PADDING());
        float f1 = this.HWc.left + this.HWc.width() / 2.0F;
        float f2 = this.HWc.bottom;
        this.HVP.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.HWj.set(this.HWc.width() / 2.0F - get_4A() / 2 + this.HVY.left, this.HWc.top - get_1A() / 2);
        this.HWk.set(this.HWc.width() / 2.0F - get_4A() / 2 + this.HVY.left, this.HWc.bottom - get_1A() / 2);
        f2 = this.HWc.top;
        this.HVO.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.HVC.reset();
        i = 1;
        while (i <= 2)
        {
          this.HVC.moveTo(this.HWc.left + this.HWc.width() / 3.0F * i, this.HWc.top);
          this.HVC.lineTo(this.HWc.left + this.HWc.width() / 3.0F * i, this.HWc.bottom);
          this.HVC.moveTo(this.HWc.left, this.HWc.top + this.HWc.height() / 3.0F * i);
          this.HVC.lineTo(this.HWc.right, this.HWc.top + this.HWc.height() / 3.0F * i);
          i += 1;
        }
      }
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(228874);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    AppMethodBeat.o(228874);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(228801);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(228801);
      return;
    }
    aK(255, 500L);
    this.HWb.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.HVY.isEmpty()) {
      this.HVY.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.HVZ == 0.0F) {
      setLimitMaxHeight(this.HWb.height() / 2.0F);
    }
    if (this.HWa == 0.0F) {
      setLimitMinHeight(this.HWb.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(228801);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228876);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    p.k(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(228876);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(228839);
    p.k(paramMotionEvent1, "event");
    p.k(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.HWe)
    {
      paramMotionEvent1 = this.HVY;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.HVY;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.HWf)
    {
      paramMotionEvent1 = this.HVY;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.HVY;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.HVY.height() > this.HVZ)
    {
      paramFloat1 = this.HVZ - this.HVY.height();
      paramMotionEvent1 = this.HVY;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.HVY;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.HWf) && (!this.HWe)) {
        break;
      }
      AppMethodBeat.o(228839);
      return true;
      if (this.HVY.height() < this.HWa)
      {
        paramFloat1 = this.HWa - this.HVY.height();
        paramMotionEvent1 = this.HVY;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.HVY;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(228839);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228867);
    p.k(paramMotionEvent, "e");
    AppMethodBeat.o(228867);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228868);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    p.k(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(228868);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228843);
    p.k(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.HWe) || (this.HWf)))
    {
      aK(0, 1000L);
      localObject = this.HVR;
      if (localObject != null) {
        ((i)localObject).rV(this.HWe);
      }
    }
    Object localObject = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aFh(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(228843);
    return bool;
  }
  
  protected final void setBelongBottomBlock(boolean paramBoolean)
  {
    this.HWf = paramBoolean;
  }
  
  protected final void setBelongTopBlock(boolean paramBoolean)
  {
    this.HWe = paramBoolean;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(228790);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(228790);
  }
  
  public final void setBlockOutsideTouch(boolean paramBoolean)
  {
    this.HVT = paramBoolean;
  }
  
  public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.b paramb)
  {
    this.HWg = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(228794);
    this.HVZ = paramFloat;
    postInvalidate();
    AppMethodBeat.o(228794);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(228797);
    this.HWa = paramFloat;
    postInvalidate();
    AppMethodBeat.o(228797);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.HVR = parami;
  }
  
  public final void setOutsideTouckListener(kotlin.g.a.a<x> parama)
  {
    this.HVS = parama;
  }
  
  protected final void setShowGridLine(boolean paramBoolean)
  {
    this.HVW = paramBoolean;
  }
  
  public final void setStyle(j paramj)
  {
    AppMethodBeat.i(228765);
    p.k(paramj, "value");
    this.BZo = paramj;
    postInvalidate();
    AppMethodBeat.o(228765);
  }
  
  protected void w(Canvas paramCanvas)
  {
    AppMethodBeat.i(228866);
    p.k(paramCanvas, "canvas");
    if ((this.BZo == j.HWx) || (this.BZo == j.HWz))
    {
      this.HVK.setAlpha(this.HVQ);
      this.HVJ.setAlpha(this.HVQ);
      if (this.HVW) {
        paramCanvas.drawPath(this.HVC, this.HVK);
      }
      paramCanvas.drawRect(this.HWc, this.HVK);
      if (this.BZo == j.HWx)
      {
        paramCanvas.save();
        paramCanvas.translate(this.HWk.x, this.HWk.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(this.HWj.x, this.HWj.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
      }
    }
    AppMethodBeat.o(228866);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Companion;", "", "()V", "BORDER_DELAY", "", "BORDER_DURATION", "TAG", "", "plugin-recordvideo_release"})
  public static final class g {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(228225);
      h localh1 = new h("TOP_LEFT", 0, 0);
      HWn = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      HWo = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      HWp = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      HWq = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      HWr = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      HWs = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      HWt = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      HWu = localh8;
      HWv = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(228225);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void e(RectF paramRectF);
    
    public abstract void rU(boolean paramBoolean);
    
    public abstract void rV(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "", "(Ljava/lang/String;I)V", "CIRCLE", "RECT_ADJUST", "RECT_HARD", "RECT_LINE_HARD", "plugin-recordvideo_release"})
  public static enum j
  {
    static
    {
      AppMethodBeat.i(224113);
      j localj1 = new j("CIRCLE", 0);
      HWw = localj1;
      j localj2 = new j("RECT_ADJUST", 1);
      HWx = localj2;
      j localj3 = new j("RECT_HARD", 2);
      HWy = localj3;
      j localj4 = new j("RECT_LINE_HARD", 3);
      HWz = localj4;
      HWA = new j[] { localj1, localj2, localj3, localj4 };
      AppMethodBeat.o(224113);
    }
    
    private j() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$hideInvisible$1$1"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(221941);
      WxCropOperationLayout localWxCropOperationLayout = this.HWm;
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(221941);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.HWm.invalidate();
      AppMethodBeat.o(221941);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
  static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    p(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(224843);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(224843);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      WxCropOperationLayout.a(this.HWm, i);
      this.HWm.invalidate();
      AppMethodBeat.o(224843);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class q
    implements Runnable
  {
    q(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(218489);
      int i = i;
      if (i == WxCropOperationLayout.h.HWn.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().top + f);
        this.kJS.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWo.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().top + f);
        this.kJS.setTranslationX(jdField_this.getBoxRect().right - f - this.kJS.getWidth());
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWp.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().bottom - f - localView.getHeight());
        this.kJS.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWq.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().bottom - f - localView.getHeight());
        this.kJS.setTranslationX(jdField_this.getBoxRect().right - f - this.kJS.getWidth());
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWr.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().top - f - localView.getHeight());
        this.kJS.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWs.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().top - f - localView.getHeight());
        this.kJS.setTranslationX(jdField_this.getBoxRect().right - f - this.kJS.getWidth());
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWt.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().bottom + f);
        this.kJS.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(218489);
        return;
      }
      if (i == WxCropOperationLayout.h.HWu.value)
      {
        this.kJS.setTranslationY(jdField_this.getBoxRect().bottom + f);
        this.kJS.setTranslationX(jdField_this.getBoxRect().right - f - this.kJS.getWidth());
      }
      AppMethodBeat.o(218489);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showInvisible$1$1"})
  static final class r
    implements ValueAnimator.AnimatorUpdateListener
  {
    r(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(219922);
      WxCropOperationLayout localWxCropOperationLayout = this.HWm;
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(219922);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.HWm.invalidate();
      AppMethodBeat.o(219922);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    s(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */