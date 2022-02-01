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
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "Landroid/animation/ValueAnimator;", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "girdLinePaint", "girdLinePath", "grepBlockPaint", "isBelongBottomBlock", "", "isBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "paint", "showGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "()Landroid/graphics/RectF;", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideCornerView", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public final class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final WxCropOperationLayout.g wzv;
  private int bgColor;
  private final Paint paint;
  private final f rTf;
  private WxCropOperationLayout.j sOp;
  private final f wyG;
  private final f wyH;
  private final f wyI;
  private final f wyJ;
  private final f wyK;
  private final f wyL;
  private final f wyM;
  private final f wyN;
  private final f wyO;
  private final Path wyP;
  private final Path wyQ;
  private final Path wyR;
  private final Path wyS;
  private final Path wyT;
  private final Path wyU;
  private final Path wyV;
  private final Paint wyW;
  private final Paint wyX;
  private final Paint wyY;
  private final Paint wyZ;
  private final Paint wza;
  private final RectF wzb;
  private final RectF wzc;
  private int wzd;
  private i wze;
  private final f wzf;
  private final View[] wzg;
  public boolean wzh;
  private final RectF wzi;
  private float wzj;
  private float wzk;
  private final RectF wzl;
  private final RectF wzm;
  private final PorterDuffXfermode wzn;
  private boolean wzo;
  private boolean wzp;
  private b wzq;
  private ValueAnimator wzr;
  private final RectF wzs;
  private final PointF wzt;
  private final PointF wzu;
  
  static
  {
    AppMethodBeat.i(199379);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "CORNER_WIDTH", "getCORNER_WIDTH()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "BLOCK_WIDTH", "getBLOCK_WIDTH()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "BOX_PADDING", "getBOX_PADDING()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "CORNER_LENGTH", "getCORNER_LENGTH()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING()F")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "_1A", "get_1A()I")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "_4A", "get_4A()I")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")), (d.l.k)w.a(new u(w.bn(WxCropOperationLayout.class), "blockDrawable", "getBlockDrawable()Landroid/graphics/drawable/Drawable;")) };
    wzv = new WxCropOperationLayout.g((byte)0);
    AppMethodBeat.o(199379);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199412);
    this.wyG = g.K((a)new WxCropOperationLayout.c(this));
    this.wyH = g.K((a)new WxCropOperationLayout.b(this));
    this.wyI = g.K((a)new WxCropOperationLayout.f(this));
    this.wyJ = g.K((a)new WxCropOperationLayout.a(this));
    this.wyK = g.K((a)new WxCropOperationLayout.d(this));
    this.wyL = g.K((a)new WxCropOperationLayout.e(this));
    this.wyM = g.K((a)new WxCropOperationLayout.k(this));
    this.wyN = g.K((a)new WxCropOperationLayout.l(this));
    this.wyO = g.K((a)new WxCropOperationLayout.m(this));
    this.rTf = g.K((a)new WxCropOperationLayout.q(this));
    this.wyP = new Path();
    this.wyQ = new Path();
    this.wyR = new Path();
    this.wyS = new Path();
    this.wyT = new Path();
    this.wyU = new Path();
    this.wyV = new Path();
    this.wyW = new Paint();
    this.wyX = new Paint();
    this.wyY = new Paint();
    this.wyZ = new Paint();
    this.wza = new Paint();
    this.wzb = new RectF();
    this.wzc = new RectF();
    this.sOp = WxCropOperationLayout.j.wzH;
    this.wzf = g.K((a)new WxCropOperationLayout.n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.wzg = paramContext;
    this.wzh = true;
    setBackgroundColor(0);
    this.wyW.setColor(-1);
    this.wyW.setStrokeWidth(getBOX_LINE_WIDTH());
    this.wyW.setStyle(Paint.Style.STROKE);
    this.wyW.setAntiAlias(true);
    this.wyX.set(this.wyW);
    this.wyX.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wyY.set(this.wyW);
    this.wyY.setStrokeWidth(getCORNER_WIDTH());
    this.wyZ.set(this.wyW);
    this.wyZ.setStrokeCap(Paint.Cap.ROUND);
    this.wyZ.setStrokeWidth(getBLOCK_WIDTH());
    this.wza.set(this.wyW);
    this.wza.setStrokeCap(Paint.Cap.ROUND);
    this.wza.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wza.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.wzi = new RectF();
    this.wzl = new RectF();
    this.wzm = new RectF();
    this.wzn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.wzs = new RectF();
    this.wzt = new PointF();
    this.wzu = new PointF();
    AppMethodBeat.o(199412);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199413);
    this.wyG = g.K((a)new WxCropOperationLayout.c(this));
    this.wyH = g.K((a)new WxCropOperationLayout.b(this));
    this.wyI = g.K((a)new WxCropOperationLayout.f(this));
    this.wyJ = g.K((a)new WxCropOperationLayout.a(this));
    this.wyK = g.K((a)new WxCropOperationLayout.d(this));
    this.wyL = g.K((a)new WxCropOperationLayout.e(this));
    this.wyM = g.K((a)new WxCropOperationLayout.k(this));
    this.wyN = g.K((a)new WxCropOperationLayout.l(this));
    this.wyO = g.K((a)new WxCropOperationLayout.m(this));
    this.rTf = g.K((a)new WxCropOperationLayout.q(this));
    this.wyP = new Path();
    this.wyQ = new Path();
    this.wyR = new Path();
    this.wyS = new Path();
    this.wyT = new Path();
    this.wyU = new Path();
    this.wyV = new Path();
    this.wyW = new Paint();
    this.wyX = new Paint();
    this.wyY = new Paint();
    this.wyZ = new Paint();
    this.wza = new Paint();
    this.wzb = new RectF();
    this.wzc = new RectF();
    this.sOp = WxCropOperationLayout.j.wzH;
    this.wzf = g.K((a)new WxCropOperationLayout.n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.wzg = paramContext;
    this.wzh = true;
    setBackgroundColor(0);
    this.wyW.setColor(-1);
    this.wyW.setStrokeWidth(getBOX_LINE_WIDTH());
    this.wyW.setStyle(Paint.Style.STROKE);
    this.wyW.setAntiAlias(true);
    this.wyX.set(this.wyW);
    this.wyX.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wyY.set(this.wyW);
    this.wyY.setStrokeWidth(getCORNER_WIDTH());
    this.wyZ.set(this.wyW);
    this.wyZ.setStrokeCap(Paint.Cap.ROUND);
    this.wyZ.setStrokeWidth(getBLOCK_WIDTH());
    this.wza.set(this.wyW);
    this.wza.setStrokeCap(Paint.Cap.ROUND);
    this.wza.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wza.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.wzi = new RectF();
    this.wzl = new RectF();
    this.wzm = new RectF();
    this.wzn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.wzs = new RectF();
    this.wzt = new PointF();
    this.wzu = new PointF();
    AppMethodBeat.o(199413);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199414);
    this.wyG = g.K((a)new WxCropOperationLayout.c(this));
    this.wyH = g.K((a)new WxCropOperationLayout.b(this));
    this.wyI = g.K((a)new WxCropOperationLayout.f(this));
    this.wyJ = g.K((a)new WxCropOperationLayout.a(this));
    this.wyK = g.K((a)new WxCropOperationLayout.d(this));
    this.wyL = g.K((a)new WxCropOperationLayout.e(this));
    this.wyM = g.K((a)new WxCropOperationLayout.k(this));
    this.wyN = g.K((a)new WxCropOperationLayout.l(this));
    this.wyO = g.K((a)new WxCropOperationLayout.m(this));
    this.rTf = g.K((a)new WxCropOperationLayout.q(this));
    this.wyP = new Path();
    this.wyQ = new Path();
    this.wyR = new Path();
    this.wyS = new Path();
    this.wyT = new Path();
    this.wyU = new Path();
    this.wyV = new Path();
    this.wyW = new Paint();
    this.wyX = new Paint();
    this.wyY = new Paint();
    this.wyZ = new Paint();
    this.wza = new Paint();
    this.wzb = new RectF();
    this.wzc = new RectF();
    this.sOp = WxCropOperationLayout.j.wzH;
    this.wzf = g.K((a)new WxCropOperationLayout.n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.wzg = paramContext;
    this.wzh = true;
    setBackgroundColor(0);
    this.wyW.setColor(-1);
    this.wyW.setStrokeWidth(getBOX_LINE_WIDTH());
    this.wyW.setStyle(Paint.Style.STROKE);
    this.wyW.setAntiAlias(true);
    this.wyX.set(this.wyW);
    this.wyX.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wyY.set(this.wyW);
    this.wyY.setStrokeWidth(getCORNER_WIDTH());
    this.wyZ.set(this.wyW);
    this.wyZ.setStrokeCap(Paint.Cap.ROUND);
    this.wyZ.setStrokeWidth(getBLOCK_WIDTH());
    this.wza.set(this.wyW);
    this.wza.setStrokeCap(Paint.Cap.ROUND);
    this.wza.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.wza.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf000000");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.wzi = new RectF();
    this.wzl = new RectF();
    this.wzm = new RectF();
    this.wzn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.wzs = new RectF();
    this.wzt = new PointF();
    this.wzu = new PointF();
    AppMethodBeat.o(199414);
  }
  
  private void dwC()
  {
    AppMethodBeat.i(199405);
    Object localObject1 = this.wzg;
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
    localObject1 = this.wzq;
    if (localObject1 != null)
    {
      ((b)localObject1).yb(false);
      AppMethodBeat.o(199405);
      return;
    }
    AppMethodBeat.o(199405);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(199383);
    float f = ((Number)this.wyJ.getValue()).floatValue();
    AppMethodBeat.o(199383);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(199381);
    float f = ((Number)this.wyH.getValue()).floatValue();
    AppMethodBeat.o(199381);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(199380);
    float f = ((Number)this.wyG.getValue()).floatValue();
    AppMethodBeat.o(199380);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(199384);
    float f = ((Number)this.wyK.getValue()).floatValue();
    AppMethodBeat.o(199384);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(199391);
    Drawable localDrawable = (Drawable)this.wzf.getValue();
    AppMethodBeat.o(199391);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(199385);
    float f = ((Number)this.wyL.getValue()).floatValue();
    AppMethodBeat.o(199385);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(199382);
    float f = ((Number)this.wyI.getValue()).floatValue();
    AppMethodBeat.o(199382);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(199386);
    float f = ((Number)this.wyM.getValue()).floatValue();
    AppMethodBeat.o(199386);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(199389);
    GestureDetector localGestureDetector = (GestureDetector)this.rTf.getValue();
    AppMethodBeat.o(199389);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(199387);
    int i = ((Number)this.wyN.getValue()).intValue();
    AppMethodBeat.o(199387);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(199388);
    int i = ((Number)this.wyO.getValue()).intValue();
    AppMethodBeat.o(199388);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(199392);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramh, "style");
    View localView = this.wzg[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.wzg[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(199392);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(199394);
    d.g.b.k.h(paramh, "style");
    View localView = this.wzg[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.wzg[paramh.value] = null;
    AppMethodBeat.o(199394);
  }
  
  public final void am(int paramInt, long paramLong)
  {
    AppMethodBeat.i(199402);
    ValueAnimator localValueAnimator = this.wzr;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.wzd, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WxCropOperationLayout.o(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.wzr = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      dwB();
      AppMethodBeat.o(199402);
      return;
      localValueAnimator = null;
    }
    dwC();
    AppMethodBeat.o(199402);
  }
  
  public final void dwA()
  {
    AppMethodBeat.i(199393);
    View[] arrayOfView = this.wzg;
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
    AppMethodBeat.o(199393);
  }
  
  public final void dwB()
  {
    AppMethodBeat.i(199404);
    this.wzd = 255;
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(2131165289);
    localObject = this.wzg;
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
    localObject = this.wzq;
    if (localObject != null)
    {
      ((b)localObject).yb(true);
      AppMethodBeat.o(199404);
      return;
    }
    AppMethodBeat.o(199404);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final b getBorderVisibilityCallback()
  {
    return this.wzq;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.wzj;
  }
  
  public final float getLimitMinHeight()
  {
    return this.wzk;
  }
  
  public final i getOnOperationCallback()
  {
    return this.wze;
  }
  
  public final WxCropOperationLayout.j getStyle()
  {
    return this.sOp;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.wzi;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(199406);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.wzr;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(199406);
      return;
    }
    AppMethodBeat.o(199406);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199409);
    d.g.b.k.h(paramMotionEvent, "event");
    if (this.sOp == WxCropOperationLayout.j.wzH)
    {
      this.wzp = false;
      this.wzo = false;
      if (this.wzb.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.wzo = true;
        paramMotionEvent = this.wze;
        if (paramMotionEvent != null) {
          paramMotionEvent.mx(true);
        }
      }
      for (;;)
      {
        if ((this.wzo) || (this.wzp)) {
          am(255, 0L);
        }
        if ((!this.wzo) && (!this.wzp)) {
          break;
        }
        AppMethodBeat.o(199409);
        return true;
        if (this.wzc.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.wzp = true;
          paramMotionEvent = this.wze;
          if (paramMotionEvent != null) {
            paramMotionEvent.mx(false);
          }
        }
      }
      AppMethodBeat.o(199409);
      return false;
    }
    AppMethodBeat.o(199409);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199399);
    d.g.b.k.h(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.wzl, null);
    paramCanvas.drawRect(this.wzl, this.paint);
    this.paint.setXfermode((Xfermode)this.wzn);
    if (WxCropOperationLayout.j.wzG == this.sOp)
    {
      paramCanvas.drawCircle(this.wzi.centerX(), this.wzi.centerY(), Math.min(this.wzi.width(), this.wzi.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if (!d.g.b.k.g(this.wzi, this.wzs))
      {
        this.wzs.set(this.wzi);
        if ((this.sOp != WxCropOperationLayout.j.wzG) && (this.sOp != WxCropOperationLayout.j.wzI)) {
          break label391;
        }
      }
    }
    for (;;)
    {
      if (this.sOp == WxCropOperationLayout.j.wzH)
      {
        this.wyX.setAlpha(this.wzd);
        this.wyW.setAlpha(this.wzd);
        if (this.wzh) {
          paramCanvas.drawPath(this.wyP, this.wyX);
        }
        paramCanvas.drawRect(this.wzm, this.wyX);
        paramCanvas.save();
        paramCanvas.translate(this.wzu.x, this.wzu.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(this.wzt.x, this.wzt.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(199399);
      return;
      if ((WxCropOperationLayout.j.wzH != this.sOp) && (WxCropOperationLayout.j.wzI != this.sOp)) {
        break;
      }
      paramCanvas.drawRect(this.wzi, this.paint);
      break;
      label391:
      i locali = this.wze;
      if (locali != null) {
        locali.f(this.wzi);
      }
      this.wzm.set(this.wzi);
      this.wzm.set(this.wzi.left + getBOX_PADDING(), this.wzi.top + getBOX_PADDING(), this.wzi.right - getBOX_PADDING(), this.wzi.bottom - getBOX_PADDING());
      float f1 = this.wzm.left + this.wzm.width() / 2.0F;
      float f2 = this.wzm.bottom;
      this.wzc.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
      this.wzt.set(this.wzm.width() / 2.0F - get_4A() / 2, this.wzm.top - get_1A() / 2);
      this.wzu.set(this.wzm.width() / 2.0F - get_4A() / 2, this.wzm.bottom - get_1A() / 2);
      f2 = this.wzm.top;
      this.wzb.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
      this.wyP.reset();
      i = 1;
      while (i <= 2)
      {
        this.wyP.moveTo(this.wzm.left + this.wzm.width() / 3.0F * i, this.wzm.top);
        this.wyP.lineTo(this.wzm.left + this.wzm.width() / 3.0F * i, this.wzm.bottom);
        this.wyP.moveTo(this.wzm.left, this.wzm.top + this.wzm.height() / 3.0F * i);
        this.wyP.lineTo(this.wzm.right, this.wzm.top + this.wzm.height() / 3.0F * i);
        i += 1;
      }
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199410);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(199410);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199398);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(199398);
      return;
    }
    am(255, 500L);
    this.wzl.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.wzi.isEmpty()) {
      this.wzi.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.wzj == 0.0F) {
      setLimitMaxHeight(this.wzl.height() / 2.0F);
    }
    if (this.wzk == 0.0F) {
      setLimitMinHeight(this.wzl.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(199398);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199411);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(199411);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199400);
    d.g.b.k.h(paramMotionEvent1, "event");
    d.g.b.k.h(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.wzo)
    {
      paramMotionEvent1 = this.wzi;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.wzi;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.wzp)
    {
      paramMotionEvent1 = this.wzi;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.wzi;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.wzi.height() > this.wzj)
    {
      paramFloat1 = this.wzj - this.wzi.height();
      paramMotionEvent1 = this.wzi;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.wzi;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.wzp) && (!this.wzo)) {
        break;
      }
      AppMethodBeat.o(199400);
      return true;
      if (this.wzi.height() < this.wzk)
      {
        paramFloat1 = this.wzk - this.wzi.height();
        paramMotionEvent1 = this.wzi;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.wzi;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(199400);
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199407);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(199407);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199408);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(199408);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199401);
    d.g.b.k.h(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.wzo) || (this.wzp))) {
      am(0, 1000L);
    }
    boolean bool = getTouchDetector().onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(199401);
    return bool;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(199395);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(199395);
  }
  
  public final void setBorderVisibilityCallback(b paramb)
  {
    this.wzq = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(199396);
    this.wzj = paramFloat;
    postInvalidate();
    AppMethodBeat.o(199396);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(199397);
    this.wzk = paramFloat;
    postInvalidate();
    AppMethodBeat.o(199397);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.wze = parami;
  }
  
  public final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(199390);
    d.g.b.k.h(paramj, "value");
    this.sOp = paramj;
    postInvalidate();
    AppMethodBeat.o(199390);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(199366);
      h localh1 = new h("TOP_LEFT", 0, 0);
      wzx = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      wzy = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      wzz = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      wzA = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      wzB = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      wzC = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      wzD = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      wzE = localh8;
      wzF = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(199366);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void f(RectF paramRectF);
    
    public abstract void mx(boolean paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class p
    implements Runnable
  {
    p(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(199377);
      int i = i;
      if (i == WxCropOperationLayout.h.wzx.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzy.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.wzL.getWidth());
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzz.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzA.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.wzL.getWidth());
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzB.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzC.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.wzL.getWidth());
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzD.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(199377);
        return;
      }
      if (i == WxCropOperationLayout.h.wzE.value)
      {
        this.wzL.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.wzL.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.wzL.getWidth());
      }
      AppMethodBeat.o(199377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */