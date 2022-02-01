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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "girdLinePaint", "girdLinePath", "grepBlockPaint", "isBelongBottomBlock", "isBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "()Landroid/graphics/RectF;", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public final class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final WxCropOperationLayout.g xIJ;
  private int bgColor;
  private final Paint paint;
  private final f sPP;
  private WxCropOperationLayout.j tKV;
  private final f xHR;
  private final f xHS;
  private final f xHT;
  private final f xHU;
  private final f xHV;
  private final f xHW;
  private final f xHX;
  private final f xHY;
  private final f xHZ;
  private final RectF xIA;
  private final PorterDuffXfermode xIB;
  private boolean xIC;
  private boolean xID;
  private com.tencent.mm.ui.widget.cropview.b xIE;
  public ValueAnimator xIF;
  private final RectF xIG;
  private final PointF xIH;
  private final PointF xII;
  private final Path xIa;
  private final Path xIb;
  private final Path xIc;
  private final Path xId;
  private final Path xIe;
  private final Path xIf;
  private final Path xIg;
  private final Paint xIh;
  private final Paint xIi;
  private final Paint xIj;
  private final Paint xIk;
  private final Paint xIl;
  private final RectF xIm;
  private final RectF xIn;
  public int xIo;
  private i xIp;
  private d.g.a.a<z> xIq;
  private boolean xIr;
  private final f xIs;
  private final View[] xIt;
  public boolean xIu;
  private ValueAnimator xIv;
  private final RectF xIw;
  private float xIx;
  private float xIy;
  private final RectF xIz;
  
  static
  {
    AppMethodBeat.i(200494);
    xIJ = new WxCropOperationLayout.g((byte)0);
    AppMethodBeat.o(200494);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200491);
    this.xHR = g.O((d.g.a.a)new c(this));
    this.xHS = g.O((d.g.a.a)new b(this));
    this.xHT = g.O((d.g.a.a)new f(this));
    this.xHU = g.O((d.g.a.a)new a(this));
    this.xHV = g.O((d.g.a.a)new d(this));
    this.xHW = g.O((d.g.a.a)new e(this));
    this.xHX = g.O((d.g.a.a)new k(this));
    this.xHY = g.O((d.g.a.a)new l(this));
    this.xHZ = g.O((d.g.a.a)new m(this));
    this.sPP = g.O((d.g.a.a)new s(this));
    this.xIa = new Path();
    this.xIb = new Path();
    this.xIc = new Path();
    this.xId = new Path();
    this.xIe = new Path();
    this.xIf = new Path();
    this.xIg = new Path();
    this.xIh = new Paint();
    this.xIi = new Paint();
    this.xIj = new Paint();
    this.xIk = new Paint();
    this.xIl = new Paint();
    this.xIm = new RectF();
    this.xIn = new RectF();
    this.tKV = WxCropOperationLayout.j.xIV;
    this.xIs = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.xIt = paramContext;
    this.xIu = true;
    setBackgroundColor(0);
    this.xIh.setColor(-1);
    this.xIh.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xIh.setStyle(Paint.Style.STROKE);
    this.xIh.setAntiAlias(true);
    this.xIi.set(this.xIh);
    this.xIi.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIj.set(this.xIh);
    this.xIj.setStrokeWidth(getCORNER_WIDTH());
    this.xIk.set(this.xIh);
    this.xIk.setStrokeCap(Paint.Cap.ROUND);
    this.xIk.setStrokeWidth(getBLOCK_WIDTH());
    this.xIl.set(this.xIh);
    this.xIl.setStrokeCap(Paint.Cap.ROUND);
    this.xIl.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIl.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xIw = new RectF();
    this.xIz = new RectF();
    this.xIA = new RectF();
    this.xIB = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xIG = new RectF();
    this.xIH = new PointF();
    this.xII = new PointF();
    AppMethodBeat.o(200491);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200492);
    this.xHR = g.O((d.g.a.a)new c(this));
    this.xHS = g.O((d.g.a.a)new b(this));
    this.xHT = g.O((d.g.a.a)new f(this));
    this.xHU = g.O((d.g.a.a)new a(this));
    this.xHV = g.O((d.g.a.a)new d(this));
    this.xHW = g.O((d.g.a.a)new e(this));
    this.xHX = g.O((d.g.a.a)new k(this));
    this.xHY = g.O((d.g.a.a)new l(this));
    this.xHZ = g.O((d.g.a.a)new m(this));
    this.sPP = g.O((d.g.a.a)new s(this));
    this.xIa = new Path();
    this.xIb = new Path();
    this.xIc = new Path();
    this.xId = new Path();
    this.xIe = new Path();
    this.xIf = new Path();
    this.xIg = new Path();
    this.xIh = new Paint();
    this.xIi = new Paint();
    this.xIj = new Paint();
    this.xIk = new Paint();
    this.xIl = new Paint();
    this.xIm = new RectF();
    this.xIn = new RectF();
    this.tKV = WxCropOperationLayout.j.xIV;
    this.xIs = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.xIt = paramContext;
    this.xIu = true;
    setBackgroundColor(0);
    this.xIh.setColor(-1);
    this.xIh.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xIh.setStyle(Paint.Style.STROKE);
    this.xIh.setAntiAlias(true);
    this.xIi.set(this.xIh);
    this.xIi.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIj.set(this.xIh);
    this.xIj.setStrokeWidth(getCORNER_WIDTH());
    this.xIk.set(this.xIh);
    this.xIk.setStrokeCap(Paint.Cap.ROUND);
    this.xIk.setStrokeWidth(getBLOCK_WIDTH());
    this.xIl.set(this.xIh);
    this.xIl.setStrokeCap(Paint.Cap.ROUND);
    this.xIl.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIl.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xIw = new RectF();
    this.xIz = new RectF();
    this.xIA = new RectF();
    this.xIB = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xIG = new RectF();
    this.xIH = new PointF();
    this.xII = new PointF();
    AppMethodBeat.o(200492);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200493);
    this.xHR = g.O((d.g.a.a)new c(this));
    this.xHS = g.O((d.g.a.a)new b(this));
    this.xHT = g.O((d.g.a.a)new f(this));
    this.xHU = g.O((d.g.a.a)new a(this));
    this.xHV = g.O((d.g.a.a)new d(this));
    this.xHW = g.O((d.g.a.a)new e(this));
    this.xHX = g.O((d.g.a.a)new k(this));
    this.xHY = g.O((d.g.a.a)new l(this));
    this.xHZ = g.O((d.g.a.a)new m(this));
    this.sPP = g.O((d.g.a.a)new s(this));
    this.xIa = new Path();
    this.xIb = new Path();
    this.xIc = new Path();
    this.xId = new Path();
    this.xIe = new Path();
    this.xIf = new Path();
    this.xIg = new Path();
    this.xIh = new Paint();
    this.xIi = new Paint();
    this.xIj = new Paint();
    this.xIk = new Paint();
    this.xIl = new Paint();
    this.xIm = new RectF();
    this.xIn = new RectF();
    this.tKV = WxCropOperationLayout.j.xIV;
    this.xIs = g.O((d.g.a.a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.xIt = paramContext;
    this.xIu = true;
    setBackgroundColor(0);
    this.xIh.setColor(-1);
    this.xIh.setStrokeWidth(getBOX_LINE_WIDTH());
    this.xIh.setStyle(Paint.Style.STROKE);
    this.xIh.setAntiAlias(true);
    this.xIi.set(this.xIh);
    this.xIi.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIj.set(this.xIh);
    this.xIj.setStrokeWidth(getCORNER_WIDTH());
    this.xIk.set(this.xIh);
    this.xIk.setStrokeCap(Paint.Cap.ROUND);
    this.xIk.setStrokeWidth(getBLOCK_WIDTH());
    this.xIl.set(this.xIh);
    this.xIl.setStrokeCap(Paint.Cap.ROUND);
    this.xIl.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.xIl.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(this.bgColor);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    this.paint = paramContext;
    this.xIw = new RectF();
    this.xIz = new RectF();
    this.xIA = new RectF();
    this.xIB = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.xIG = new RectF();
    this.xIH = new PointF();
    this.xII = new PointF();
    AppMethodBeat.o(200493);
  }
  
  private void dHo()
  {
    AppMethodBeat.i(200482);
    Object localObject1 = this.xIt;
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
    localObject1 = this.xIE;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject1).yN(false);
      AppMethodBeat.o(200482);
      return;
    }
    AppMethodBeat.o(200482);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(200460);
    float f = ((Number)this.xHU.getValue()).floatValue();
    AppMethodBeat.o(200460);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(200458);
    float f = ((Number)this.xHS.getValue()).floatValue();
    AppMethodBeat.o(200458);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(200457);
    float f = ((Number)this.xHR.getValue()).floatValue();
    AppMethodBeat.o(200457);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(200461);
    float f = ((Number)this.xHV.getValue()).floatValue();
    AppMethodBeat.o(200461);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(200468);
    Drawable localDrawable = (Drawable)this.xIs.getValue();
    AppMethodBeat.o(200468);
    return localDrawable;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(200462);
    float f = ((Number)this.xHW.getValue()).floatValue();
    AppMethodBeat.o(200462);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(200459);
    float f = ((Number)this.xHT.getValue()).floatValue();
    AppMethodBeat.o(200459);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(200463);
    float f = ((Number)this.xHX.getValue()).floatValue();
    AppMethodBeat.o(200463);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(200466);
    GestureDetector localGestureDetector = (GestureDetector)this.sPP.getValue();
    AppMethodBeat.o(200466);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(200464);
    int i = ((Number)this.xHY.getValue()).intValue();
    AppMethodBeat.o(200464);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(200465);
    int i = ((Number)this.xHZ.getValue()).intValue();
    AppMethodBeat.o(200465);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(200469);
    p.h(paramView, "view");
    p.h(paramh, "style");
    View localView = this.xIt[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.xIt[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(200469);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(200471);
    p.h(paramh, "style");
    View localView = this.xIt[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.xIt[paramh.value] = null;
    AppMethodBeat.o(200471);
  }
  
  public final void ar(int paramInt, final long paramLong)
  {
    AppMethodBeat.i(200479);
    ValueAnimator localValueAnimator = this.xIF;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.xIo, paramInt }) });
    if (localValueAnimator != null)
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new p(this, paramLong));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.xIF = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      dHn();
      AppMethodBeat.o(200479);
      return;
      localValueAnimator = null;
    }
    dHo();
    AppMethodBeat.o(200479);
  }
  
  public final void dHm()
  {
    AppMethodBeat.i(200470);
    View[] arrayOfView = this.xIt;
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
    AppMethodBeat.o(200470);
  }
  
  public final void dHn()
  {
    AppMethodBeat.i(200481);
    this.xIo = 255;
    Object localObject = getContext();
    p.g(localObject, "context");
    final float f = ((Context)localObject).getResources().getDimension(2131165289);
    localObject = this.xIt;
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
    localObject = this.xIE;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.cropview.b)localObject).yN(true);
      AppMethodBeat.o(200481);
      return;
    }
    AppMethodBeat.o(200481);
  }
  
  public final void dHp()
  {
    AppMethodBeat.i(200489);
    ValueAnimator localValueAnimator = this.xIv;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -14474461 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this));
    localValueAnimator.start();
    this.xIv = localValueAnimator;
    AppMethodBeat.o(200489);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(200490);
    ValueAnimator localValueAnimator = this.xIv;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -1088216285 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new r(this));
    localValueAnimator.start();
    this.xIv = localValueAnimator;
    AppMethodBeat.o(200490);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final boolean getBlockOutsideTouch()
  {
    return this.xIr;
  }
  
  public final com.tencent.mm.ui.widget.cropview.b getBorderVisibilityCallback()
  {
    return this.xIE;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.xIx;
  }
  
  public final float getLimitMinHeight()
  {
    return this.xIy;
  }
  
  public final i getOnOperationCallback()
  {
    return this.xIp;
  }
  
  public final d.g.a.a<z> getOutsideTouckListener()
  {
    return this.xIq;
  }
  
  public final WxCropOperationLayout.j getStyle()
  {
    return this.tKV;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.xIw;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(200483);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.xIF;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.xIv;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(200483);
      return;
    }
    AppMethodBeat.o(200483);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200486);
    p.h(paramMotionEvent, "event");
    Object localObject;
    if (!this.xIw.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      localObject = this.xIq;
      if (localObject != null) {
        ((d.g.a.a)localObject).invoke();
      }
    }
    if (this.tKV == WxCropOperationLayout.j.xIV)
    {
      this.xID = false;
      this.xIC = false;
      if (this.xIm.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.xIC = true;
        localObject = this.xIp;
        if (localObject != null) {
          ((i)localObject).mO(true);
        }
      }
      for (;;)
      {
        if ((this.xIC) || (this.xID)) {
          ar(255, 0L);
        }
        if ((!this.xIC) && (!this.xID) && ((!this.xIr) || (this.xIw.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))) {
          break;
        }
        AppMethodBeat.o(200486);
        return true;
        if (this.xIn.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.xID = true;
          localObject = this.xIp;
          if (localObject != null) {
            ((i)localObject).mO(false);
          }
        }
      }
      AppMethodBeat.o(200486);
      return false;
    }
    AppMethodBeat.o(200486);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200476);
    p.h(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.xIz, null);
    paramCanvas.drawRect(this.xIz, this.paint);
    this.paint.setXfermode((Xfermode)this.xIB);
    if (WxCropOperationLayout.j.xIU == this.tKV)
    {
      paramCanvas.drawCircle(this.xIw.centerX(), this.xIw.centerY(), Math.min(this.xIw.width(), this.xIw.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if ((this.tKV != WxCropOperationLayout.j.xIU) && (this.tKV != WxCropOperationLayout.j.xIW)) {
        break label396;
      }
    }
    for (;;)
    {
      if ((this.tKV == WxCropOperationLayout.j.xIV) || (this.tKV == WxCropOperationLayout.j.xIX))
      {
        this.xIi.setAlpha(this.xIo);
        this.xIh.setAlpha(this.xIo);
        if (this.xIu) {
          paramCanvas.drawPath(this.xIa, this.xIi);
        }
        paramCanvas.drawRect(this.xIA, this.xIi);
        if (this.tKV == WxCropOperationLayout.j.xIV)
        {
          paramCanvas.save();
          paramCanvas.translate(this.xII.x, this.xII.y);
          if ((getBlockDrawable() instanceof BitmapDrawable))
          {
            getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
            getBlockDrawable().draw(paramCanvas);
          }
          paramCanvas.restore();
          paramCanvas.save();
          paramCanvas.translate(this.xIH.x, this.xIH.y);
          if ((getBlockDrawable() instanceof BitmapDrawable))
          {
            getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
            getBlockDrawable().draw(paramCanvas);
          }
          paramCanvas.restore();
        }
      }
      AppMethodBeat.o(200476);
      return;
      if ((WxCropOperationLayout.j.xIV != this.tKV) && (WxCropOperationLayout.j.xIW != this.tKV) && (WxCropOperationLayout.j.xIX != this.tKV)) {
        break;
      }
      paramCanvas.drawRect(this.xIw, this.paint);
      break;
      label396:
      if (!p.i(this.xIw, this.xIG))
      {
        this.xIG.set(this.xIw);
        i locali = this.xIp;
        if (locali != null) {
          locali.e(this.xIw);
        }
        this.xIA.set(this.xIw);
        this.xIA.set(this.xIw.left + getBOX_PADDING(), this.xIw.top + getBOX_PADDING(), this.xIw.right - getBOX_PADDING(), this.xIw.bottom - getBOX_PADDING());
        float f1 = this.xIA.left + this.xIA.width() / 2.0F;
        float f2 = this.xIA.bottom;
        this.xIn.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.xIH.set(this.xIA.width() / 2.0F - get_4A() / 2 + this.xIw.left, this.xIA.top - get_1A() / 2);
        this.xII.set(this.xIA.width() / 2.0F - get_4A() / 2 + this.xIw.left, this.xIA.bottom - get_1A() / 2);
        f2 = this.xIA.top;
        this.xIm.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
        this.xIa.reset();
        i = 1;
        while (i <= 2)
        {
          this.xIa.moveTo(this.xIA.left + this.xIA.width() / 3.0F * i, this.xIA.top);
          this.xIa.lineTo(this.xIA.left + this.xIA.width() / 3.0F * i, this.xIA.bottom);
          this.xIa.moveTo(this.xIA.left, this.xIA.top + this.xIA.height() / 3.0F * i);
          this.xIa.lineTo(this.xIA.right, this.xIA.top + this.xIA.height() / 3.0F * i);
          i += 1;
        }
      }
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200487);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(200487);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200475);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(200475);
      return;
    }
    ar(255, 500L);
    this.xIz.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xIw.isEmpty()) {
      this.xIw.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.xIx == 0.0F) {
      setLimitMaxHeight(this.xIz.height() / 2.0F);
    }
    if (this.xIy == 0.0F) {
      setLimitMinHeight(this.xIz.height() / 4.0F);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(200475);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200488);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(200488);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200477);
    p.h(paramMotionEvent1, "event");
    p.h(paramMotionEvent2, "e2");
    new StringBuilder("[onScroll] event=").append(paramMotionEvent1);
    if (this.xIC)
    {
      paramMotionEvent1 = this.xIw;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.xIw;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.xID)
    {
      paramMotionEvent1 = this.xIw;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.xIw;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.xIw.height() > this.xIx)
    {
      paramFloat1 = this.xIx - this.xIw.height();
      paramMotionEvent1 = this.xIw;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.xIw;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.xID) && (!this.xIC)) {
        break;
      }
      AppMethodBeat.o(200477);
      return true;
      if (this.xIw.height() < this.xIy)
      {
        paramFloat1 = this.xIy - this.xIw.height();
        paramMotionEvent1 = this.xIw;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.xIw;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(200477);
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200484);
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(200484);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200485);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(200485);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200478);
    p.h(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.xIC) || (this.xID)))
    {
      ar(0, 1000L);
      localObject = this.xIp;
      if (localObject != null) {
        ((i)localObject).mP(this.xIC);
      }
    }
    Object localObject = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahp(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(200478);
    return bool;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(200472);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(200472);
  }
  
  public final void setBlockOutsideTouch(boolean paramBoolean)
  {
    this.xIr = paramBoolean;
  }
  
  public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.b paramb)
  {
    this.xIE = paramb;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(200473);
    this.xIx = paramFloat;
    postInvalidate();
    AppMethodBeat.o(200473);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(200474);
    this.xIy = paramFloat;
    postInvalidate();
    AppMethodBeat.o(200474);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.xIp = parami;
  }
  
  public final void setOutsideTouckListener(d.g.a.a<z> parama)
  {
    this.xIq = parama;
  }
  
  public final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(200467);
    p.h(paramj, "value");
    this.tKV = paramj;
    postInvalidate();
    AppMethodBeat.o(200467);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(200442);
      h localh1 = new h("TOP_LEFT", 0, 0);
      xIL = localh1;
      h localh2 = new h("TOP_RIGHT", 1, 1);
      xIM = localh2;
      h localh3 = new h("BOTTOM_LEFT", 2, 2);
      xIN = localh3;
      h localh4 = new h("BOTTOM_RIGHT", 3, 3);
      xIO = localh4;
      h localh5 = new h("TOP_LEFT_OUT", 4, 4);
      xIP = localh5;
      h localh6 = new h("TOP_RIGHT_OUT", 5, 5);
      xIQ = localh6;
      h localh7 = new h("BOTTOM_LEFT_OUT", 6, 6);
      xIR = localh7;
      h localh8 = new h("BOTTOM_RIGHT_OUT", 7, 7);
      xIS = localh8;
      xIT = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
      AppMethodBeat.o(200442);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
  public static abstract interface i
  {
    public abstract void e(RectF paramRectF);
    
    public abstract void mO(boolean paramBoolean);
    
    public abstract void mP(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$hideInvisible$1$1"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200452);
      WxCropOperationLayout localWxCropOperationLayout = this.xIK;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200452);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.xIK.invalidate();
      AppMethodBeat.o(200452);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
  static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    p(WxCropOperationLayout paramWxCropOperationLayout, long paramLong) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200453);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200453);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      WxCropOperationLayout.a(this.xIK, i);
      this.xIK.invalidate();
      AppMethodBeat.o(200453);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
  static final class q
    implements Runnable
  {
    q(View paramView1, int paramInt, View paramView2, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(200454);
      int i = i;
      if (i == WxCropOperationLayout.h.xIL.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIM.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).top + f);
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rMp.getWidth());
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIN.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIO.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom - f - localView.getHeight());
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rMp.getWidth());
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIP.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIQ.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).top - f - localView.getHeight());
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rMp.getWidth());
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIR.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).left + f);
        AppMethodBeat.o(200454);
        return;
      }
      if (i == WxCropOperationLayout.h.xIS.value)
      {
        this.rMp.setTranslationY(WxCropOperationLayout.b(jdField_this).bottom + f);
        this.rMp.setTranslationX(WxCropOperationLayout.b(jdField_this).right - f - this.rMp.getWidth());
      }
      AppMethodBeat.o(200454);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showInvisible$1$1"})
  static final class r
    implements ValueAnimator.AnimatorUpdateListener
  {
    r(WxCropOperationLayout paramWxCropOperationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200455);
      WxCropOperationLayout localWxCropOperationLayout = this.xIK;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200455);
        throw paramValueAnimator;
      }
      localWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
      this.xIK.invalidate();
      AppMethodBeat.o(200455);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
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