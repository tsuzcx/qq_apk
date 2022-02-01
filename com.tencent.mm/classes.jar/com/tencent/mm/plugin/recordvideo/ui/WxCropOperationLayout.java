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
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "getBoxRect", "()Landroid/graphics/RectF;", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "grepBlockPaint", "gridLinePaint", "getGridLinePaint", "()Landroid/graphics/Paint;", "gridLinePath", "getGridLinePath", "()Landroid/graphics/Path;", "isBelongBottomBlock", "setBelongBottomBlock", "isBelongTopBlock", "setBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "getShowGridLine", "setShowGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final WxCropOperationLayout.g BZw;
  private final f BYE;
  private final f BYF;
  private final f BYG;
  private final f BYH;
  private final f BYI;
  private final f BYJ;
  private final f BYK;
  private final f BYL;
  private final f BYM;
  private final Path BYN;
  private final Path BYO;
  private final Path BYP;
  private final Path BYQ;
  private final Path BYR;
  private final Path BYS;
  private final Path BYT;
  private final Paint BYU;
  private final Paint BYV;
  private final Paint BYW;
  private final Paint BYX;
  private final Paint BYY;
  private final RectF BYZ;
  private final RectF BZa;
  public int BZb;
  private i BZc;
  private kotlin.g.a.a<x> BZd;
  private boolean BZe;
  private final f BZf;
  private final View[] BZg;
  public boolean BZh;
  private ValueAnimator BZi;
  private final RectF BZj;
  private float BZk;
  private float BZl;
  private final RectF BZm;
  private final RectF BZn;
  private final PorterDuffXfermode BZo;
  protected boolean BZp;
  protected boolean BZq;
  private com.tencent.mm.ui.widget.cropview.b BZr;
  public ValueAnimator BZs;
  private final RectF BZt;
  private final PointF BZu;
  private final PointF BZv;
  private int bgColor;
  private final Paint paint;
  private final f wbH;
  private WxCropOperationLayout.j xmW;
  
  static
  {
    AppMethodBeat.i(237571);
    BZw = new WxCropOperationLayout.g((byte)0);
    AppMethodBeat.o(237571);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237568);
    this.BYE = g.ah((kotlin.g.a.a)new c(this));
    this.BYF = g.ah((kotlin.g.a.a)new b(this));
    this.BYG = g.ah((kotlin.g.a.a)new f(this));
    this.BYH = g.ah((kotlin.g.a.a)new a(this));
    this.BYI = g.ah((kotlin.g.a.a)new d(this));
    this.BYJ = g.ah((kotlin.g.a.a)new e(this));
    this.BYK = g.ah((kotlin.g.a.a)new k(this));
    this.BYL = g.ah((kotlin.g.a.a)new l(this));
    this.BYM = g.ah((kotlin.g.a.a)new m(this));
    this.wbH = g.ah((kotlin.g.a.a)new s(this));
    this.BYN = new Path();
    this.BYO = new Path();
    this.BYP = new Path();
    this.BYQ = new Path();
    this.BYR = new Path();
    this.BYS = new Path();
    this.BYT = new Path();
    this.BYU = new Paint();
    this.BYV = new Paint();
    this.BYW = new Paint();
    this.BYX = new Paint();
    this.BYY = new Paint();
    this.BYZ = new RectF();
    this.BZa = new RectF();
    this.xmW = WxCropOperationLayout.j.BZI;
    this.BZf = g.ah((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.BZg = paramContext;
    this.BZh = true;
    setBackgroundColor(0);
    this.BYU.setColor(-1);
    this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
    this.BYU.setStyle(Paint.Style.STROKE);
    this.BYU.setAntiAlias(true);
    this.BYV.set(this.BYU);
    this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYW.set(this.BYU);
    this.BYW.setStrokeWidth(getCORNER_WIDTH());
    this.BYX.set(this.BYU);
    this.BYX.setStrokeCap(Paint.Cap.ROUND);
    this.BYX.setStrokeWidth(getBLOCK_WIDTH());
    this.BYY.set(this.BYU);
    this.BYY.setStrokeCap(Paint.Cap.ROUND);
    this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYY.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.BZj = new RectF();
    this.BZm = new RectF();
    this.BZn = new RectF();
    this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.BZt = new RectF();
    this.BZu = new PointF();
    this.BZv = new PointF();
    AppMethodBeat.o(237568);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237569);
    this.BYE = g.ah((kotlin.g.a.a)new c(this));
    this.BYF = g.ah((kotlin.g.a.a)new b(this));
    this.BYG = g.ah((kotlin.g.a.a)new f(this));
    this.BYH = g.ah((kotlin.g.a.a)new a(this));
    this.BYI = g.ah((kotlin.g.a.a)new d(this));
    this.BYJ = g.ah((kotlin.g.a.a)new e(this));
    this.BYK = g.ah((kotlin.g.a.a)new k(this));
    this.BYL = g.ah((kotlin.g.a.a)new l(this));
    this.BYM = g.ah((kotlin.g.a.a)new m(this));
    this.wbH = g.ah((kotlin.g.a.a)new s(this));
    this.BYN = new Path();
    this.BYO = new Path();
    this.BYP = new Path();
    this.BYQ = new Path();
    this.BYR = new Path();
    this.BYS = new Path();
    this.BYT = new Path();
    this.BYU = new Paint();
    this.BYV = new Paint();
    this.BYW = new Paint();
    this.BYX = new Paint();
    this.BYY = new Paint();
    this.BYZ = new RectF();
    this.BZa = new RectF();
    this.xmW = WxCropOperationLayout.j.BZI;
    this.BZf = g.ah((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.BZg = paramContext;
    this.BZh = true;
    setBackgroundColor(0);
    this.BYU.setColor(-1);
    this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
    this.BYU.setStyle(Paint.Style.STROKE);
    this.BYU.setAntiAlias(true);
    this.BYV.set(this.BYU);
    this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYW.set(this.BYU);
    this.BYW.setStrokeWidth(getCORNER_WIDTH());
    this.BYX.set(this.BYU);
    this.BYX.setStrokeCap(Paint.Cap.ROUND);
    this.BYX.setStrokeWidth(getBLOCK_WIDTH());
    this.BYY.set(this.BYU);
    this.BYY.setStrokeCap(Paint.Cap.ROUND);
    this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYY.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.BZj = new RectF();
    this.BZm = new RectF();
    this.BZn = new RectF();
    this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.BZt = new RectF();
    this.BZu = new PointF();
    this.BZv = new PointF();
    AppMethodBeat.o(237569);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237570);
    this.BYE = g.ah((kotlin.g.a.a)new c(this));
    this.BYF = g.ah((kotlin.g.a.a)new b(this));
    this.BYG = g.ah((kotlin.g.a.a)new f(this));
    this.BYH = g.ah((kotlin.g.a.a)new a(this));
    this.BYI = g.ah((kotlin.g.a.a)new d(this));
    this.BYJ = g.ah((kotlin.g.a.a)new e(this));
    this.BYK = g.ah((kotlin.g.a.a)new k(this));
    this.BYL = g.ah((kotlin.g.a.a)new l(this));
    this.BYM = g.ah((kotlin.g.a.a)new m(this));
    this.wbH = g.ah((kotlin.g.a.a)new s(this));
    this.BYN = new Path();
    this.BYO = new Path();
    this.BYP = new Path();
    this.BYQ = new Path();
    this.BYR = new Path();
    this.BYS = new Path();
    this.BYT = new Path();
    this.BYU = new Paint();
    this.BYV = new Paint();
    this.BYW = new Paint();
    this.BYX = new Paint();
    this.BYY = new Paint();
    this.BYZ = new RectF();
    this.BZa = new RectF();
    this.xmW = WxCropOperationLayout.j.BZI;
    this.BZf = g.ah((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.BZg = paramContext;
    this.BZh = true;
    setBackgroundColor(0);
    this.BYU.setColor(-1);
    this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
    this.BYU.setStyle(Paint.Style.STROKE);
    this.BYU.setAntiAlias(true);
    this.BYV.set(this.BYU);
    this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYW.set(this.BYU);
    this.BYW.setStrokeWidth(getCORNER_WIDTH());
    this.BYX.set(this.BYU);
    this.BYX.setStrokeCap(Paint.Cap.ROUND);
    this.BYX.setStrokeWidth(getBLOCK_WIDTH());
    this.BYY.set(this.BYU);
    this.BYY.setStrokeCap(Paint.Cap.ROUND);
    this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.BYY.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.BZj = new RectF();
    this.BZm = new RectF();
    this.BZn = new RectF();
    this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.BZt = new RectF();
    this.BZu = new PointF();
    this.BZv = new PointF();
    AppMethodBeat.o(237570);
  }
  
  private void eLE()
  {
    AppMethodBeat.i(237558);
    Object localObject1 = this.BZg;
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
    localObject1 = this.BZr;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject1).Df(false);
      AppMethodBeat.o(237558);
      return;
    }
    AppMethodBeat.o(237558);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(237536);
    float f = ((Number)this.BYH.getValue()).floatValue();
    AppMethodBeat.o(237536);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(237534);
    float f = ((Number)this.BYF.getValue()).floatValue();
    AppMethodBeat.o(237534);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(237533);
    float f = ((Number)this.BYE.getValue()).floatValue();
    AppMethodBeat.o(237533);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(237537);
    float f = ((Number)this.BYI.getValue()).floatValue();
    AppMethodBeat.o(237537);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(237544);
    Drawable localDrawable = (Drawable)this.BZf.getValue();
    AppMethodBeat.o(237544);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(237538);
    float f = ((Number)this.BYJ.getValue()).floatValue();
    AppMethodBeat.o(237538);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(237535);
    float f = ((Number)this.BYG.getValue()).floatValue();
    AppMethodBeat.o(237535);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(237539);
    float f = ((Number)this.BYK.getValue()).floatValue();
    AppMethodBeat.o(237539);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(237542);
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(237542);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(237540);
    int i = ((Number)this.BYL.getValue()).intValue();
    AppMethodBeat.o(237540);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(237541);
    int i = ((Number)this.BYM.getValue()).intValue();
    AppMethodBeat.o(237541);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(237545);
    p.h(paramView, "view");
    p.h(paramh, "style");
    View localView = this.BZg[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.BZg[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(237545);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(237547);
    p.h(paramh, "style");
    View localView = this.BZg[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.BZg[paramh.value] = null;
    AppMethodBeat.o(237547);
  }
  
  public void ay(int paramInt, final long paramLong)
  {
    AppMethodBeat.i(237555);
    ValueAnimator localValueAnimator = this.BZs;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.BZb, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new p(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.BZs = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      eLD();
      AppMethodBeat.o(237555);
      return;
      localValueAnimator = null;
    }
    eLE();
    AppMethodBeat.o(237555);
  }
  
  public final void eLC()
  {
    AppMethodBeat.i(237546);
    View[] arrayOfView = this.BZg;
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
    AppMethodBeat.o(237546);
  }
  
  public final void eLD()
  {
    AppMethodBeat.i(237557);
    this.BZb = 255;
    Object localObject = getContext();
    p.g(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(2131165296);
    localObject = this.BZg;
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
    localObject = this.BZr;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject).Df(true);
      AppMethodBeat.o(237557);
      return;
    }
    AppMethodBeat.o(237557);
  }
  
  public final void eLF()
  {
    AppMethodBeat.i(237566);
    ValueAnimator localValueAnimator = this.BZi;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -14474461 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this));
    localValueAnimator.start();
    this.BZi = localValueAnimator;
    AppMethodBeat.o(237566);
  }
  
  public final void eLG()
  {
    AppMethodBeat.i(237567);
    ValueAnimator localValueAnimator = this.BZi;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -1088216285 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new r(this));
    localValueAnimator.start();
    this.BZi = localValueAnimator;
    AppMethodBeat.o(237567);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final boolean getBlockOutsideTouch()
  {
    return this.BZe;
  }
  
  public final com.tencent.mm.ui.widget.cropview.b getBorderVisibilityCallback()
  {
    return this.BZr;
  }
  
  protected final RectF getBoxRect()
  {
    return this.BZn;
  }
  
  protected final Paint getGridLinePaint()
  {
    return this.BYV;
  }
  
  protected final Path getGridLinePath()
  {
    return this.BYN;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.BZk;
  }
  
  public final float getLimitMinHeight()
  {
    return this.BZl;
  }
  
  public final i getOnOperationCallback()
  {
    return this.BZc;
  }
  
  public final kotlin.g.a.a<x> getOutsideTouckListener()
  {
    return this.BZd;
  }
  
  protected final boolean getShowGridLine()
  {
    return this.BZh;
  }
  
  public final WxCropOperationLayout.j getStyle()
  {
    return this.xmW;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.BZj;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(237559);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.BZs;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.BZi;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(237559);
      return;
    }
    AppMethodBeat.o(237559);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237563);
    p.h(paramMotionEvent, "event");
    Object localObject;
    if (!this.BZj.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      localObject = this.BZd;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
    }
    if (this.xmW == WxCropOperationLayout.j.BZI)
    {
      this.BZq = false;
      this.BZp = false;
      if (this.BYZ.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.BZp = true;
        localObject = this.BZc;
        if (localObject != null) {
          ((i)localObject).pz(true);
        }
      }
      for (;;)
      {
        if ((this.BZp) || (this.BZq)) {
          ay(255, 0L);
        }
        if ((!this.BZp) && (!this.BZq) && ((!this.BZe) || (this.BZj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))) {
          break;
        }
        AppMethodBeat.o(237563);
        return true;
        if (this.BZa.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.BZq = true;
          localObject = this.BZc;
          if (localObject != null) {
            ((i)localObject).pz(false);
          }
        }
      }
      AppMethodBeat.o(237563);
      return false;
    }
    AppMethodBeat.o(237563);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237552);
    p.h(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.BZm, null);
    paramCanvas.drawRect(this.BZm, this.paint);
    this.paint.setXfermode((Xfermode)this.BZo);
    if (WxCropOperationLayout.j.BZH == this.xmW)
    {
      paramCanvas.drawCircle(this.BZj.centerX(), this.BZj.centerY(), Math.min(this.BZj.width(), this.BZj.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if ((this.xmW != WxCropOperationLayout.j.BZH) && (this.xmW != WxCropOperationLayout.j.BZJ)) {
        break label194;
      }
    }
    for (;;)
    {
      u(paramCanvas);
      AppMethodBeat.o(237552);
      return;
      if ((WxCropOperationLayout.j.BZI != this.xmW) && (WxCropOperationLayout.j.BZJ != this.xmW) && (WxCropOperationLayout.j.BZK != this.xmW)) {
        break;
      }
      paramCanvas.drawRect(this.BZj, this.paint);
      break;
      label194:
      if (!p.j(this.BZj, this.BZt))
      {
        this.BZt.set(this.BZj);
        i locali = this.BZc;
        if (locali != null) {
          locali.e(this.BZj);
        }
        this.BZn.set(this.BZj);
        this.BZn.set(this.BZj.left + getBOX_PADDING(), this.BZj.top + getBOX_PADDING(), this.BZj.right - getBOX_PADDING(), this.BZj.bottom - getBOX_PADDING());
        float f1 = this.BZn.left + this.BZn.width() / 2.0F;
        float f2 = this.BZn.bottom;
        this.BZa.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.BZu.set(this.BZn.width() / 2.0F - get_4A() / 2 + this.BZj.left, this.BZn.top - get_1A() / 2);
        this.BZv.set(this.BZn.width() / 2.0F - get_4A() / 2 + this.BZj.left, this.BZn.bottom - get_1A() / 2);
        f2 = this.BZn.top;
        this.BYZ.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.BYN.reset();
        i = 1;
        while (i <= 2)
        {
          this.BYN.moveTo(this.BZn.left + this.BZn.width() / 3.0F * i, this.BZn.top);
          this.BYN.lineTo(this.BZn.left + this.BZn.width() / 3.0F * i, this.BZn.bottom);
          this.BYN.moveTo(this.BZn.left, this.BZn.top + this.BZn.height() / 3.0F * i);
          this.BYN.lineTo(this.BZn.right, this.BZn.top + this.BZn.height() / 3.0F * i);
          i += 1;
        }
      }
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237564);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(237564);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237551);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(237551);
      return;
    }
    ay(255, 500L);
    this.BZm.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.BZj.isEmpty()) {
      this.BZj.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.BZk == 0.0F) {
      setLimitMaxHeight(this.BZm.height() / 2.0F);
    }
    if (this.BZl == 0.0F) {
      setLimitMinHeight(this.BZm.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(237551);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237565);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(237565);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237553);
    p.h(paramMotionEvent1, "event");
    p.h(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.BZp)
    {
      paramMotionEvent1 = this.BZj;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.BZj;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.BZq)
    {
      paramMotionEvent1 = this.BZj;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.BZj;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.BZj.height() > this.BZk)
    {
      paramFloat1 = this.BZk - this.BZj.height();
      paramMotionEvent1 = this.BZj;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.BZj;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.BZq) && (!this.BZp)) {
        break;
      }
      AppMethodBeat.o(237553);
      return true;
      if (this.BZj.height() < this.BZl)
      {
        paramFloat1 = this.BZl - this.BZj.height();
        paramMotionEvent1 = this.BZj;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.BZj;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(237553);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237561);
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(237561);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237562);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(237562);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237554);
    p.h(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.BZp) || (this.BZq)))
    {
      ay(0, 1000L);
      localObject = this.BZc;
      if (localObject != null) {
        ((i)localObject).pA(this.BZp);
      }
    }
    Object localObject = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.axQ(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(237554);
    return bool;
  }
  
  protected final void setBelongBottomBlock(boolean paramBoolean)
  {
    this.BZq = paramBoolean;
  }
  
  protected final void setBelongTopBlock(boolean paramBoolean)
  {
    this.BZp = paramBoolean;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(237548);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(237548);
  }
  
  public final void setBlockOutsideTouch(boolean paramBoolean)
  {
    this.BZe = paramBoolean;
  }
  
  public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.b paramb)
  {
    this.BZr = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(237549);
    this.BZk = paramFloat;
    postInvalidate();
    AppMethodBeat.o(237549);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(237550);
    this.BZl = paramFloat;
    postInvalidate();
    AppMethodBeat.o(237550);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.BZc = parami;
  }
  
  public final void setOutsideTouckListener(kotlin.g.a.a<x> parama)
  {
    this.BZd = parama;
  }
  
  protected final void setShowGridLine(boolean paramBoolean)
  {
    this.BZh = paramBoolean;
  }
  
  public final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(237543);
    p.h(paramj, "value");
    this.xmW = paramj;
    postInvalidate();
    AppMethodBeat.o(237543);
  }
  
  protected void u(Canvas paramCanvas)
  {
    AppMethodBeat.i(237560);
    p.h(paramCanvas, "canvas");
    if ((this.xmW == WxCropOperationLayout.j.BZI) || (this.xmW == WxCropOperationLayout.j.BZK))
    {
      this.BYV.setAlpha(this.BZb);
      this.BYU.setAlpha(this.BZb);
      if (this.BZh) {
        paramCanvas.drawPath(this.BYN, this.BYV);
      }
      paramCanvas.drawRect(this.BZn, this.BYV);
      if (this.xmW == WxCropOperationLayout.j.BZI)
      {
        paramCanvas.save();
        paramCanvas.translate(this.BZv.x, this.BZv.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(this.BZu.x, this.BZu.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
      }
    }
    AppMethodBeat.o(237560);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(237518);
      h localh1 = new h("TOP_LEFT", 0, 0);
      BZy = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      BZz = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      BZA = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      BZB = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      BZC = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      BZD = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      BZE = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      BZF = localh8;
      BZG = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(237518);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void e(RectF paramRectF);
    
    public abstract void pA(boolean paramBoolean);
    
    public abstract void pz(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$hideInvisible$1$1"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(237528);
      WxCropOperationLayout localWxCropOperationLayout = this.BZx;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(237528);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.BZx.invalidate();
      AppMethodBeat.o(237528);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
  static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    p(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(237529);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(237529);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      WxCropOperationLayout.a(this.BZx, i);
      this.BZx.invalidate();
      AppMethodBeat.o(237529);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class q
    implements Runnable
  {
    q(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(237530);
      int i = i;
      if (i == WxCropOperationLayout.h.BZy.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().top + f);
        this.tzy.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZz.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().top + f);
        this.tzy.setTranslationX(jdField_this.getBoxRect().right - f - this.tzy.getWidth());
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZA.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().bottom - f - localView.getHeight());
        this.tzy.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZB.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().bottom - f - localView.getHeight());
        this.tzy.setTranslationX(jdField_this.getBoxRect().right - f - this.tzy.getWidth());
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZC.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().top - f - localView.getHeight());
        this.tzy.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZD.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().top - f - localView.getHeight());
        this.tzy.setTranslationX(jdField_this.getBoxRect().right - f - this.tzy.getWidth());
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZE.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().bottom + f);
        this.tzy.setTranslationX(jdField_this.getBoxRect().left + f);
        AppMethodBeat.o(237530);
        return;
      }
      if (i == WxCropOperationLayout.h.BZF.value)
      {
        this.tzy.setTranslationY(jdField_this.getBoxRect().bottom + f);
        this.tzy.setTranslationX(jdField_this.getBoxRect().right - f - this.tzy.getWidth());
      }
      AppMethodBeat.o(237530);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showInvisible$1$1"})
  static final class r
    implements ValueAnimator.AnimatorUpdateListener
  {
    r(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(237531);
      WxCropOperationLayout localWxCropOperationLayout = this.BZx;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(237531);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.BZx.invalidate();
      AppMethodBeat.o(237531);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */