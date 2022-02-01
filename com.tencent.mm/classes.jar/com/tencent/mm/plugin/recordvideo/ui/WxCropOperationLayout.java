package com.tencent.mm.plugin.recordvideo.ui;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "getBoxRect", "()Landroid/graphics/RectF;", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "grepBlockPaint", "gridLinePaint", "getGridLinePaint", "()Landroid/graphics/Paint;", "gridLinePath", "getGridLinePath", "()Landroid/graphics/Path;", "isBelongBottomBlock", "setBelongBottomBlock", "isBelongTopBlock", "setBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "getShowGridLine", "setShowGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WxCropOperationLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  public static final WxCropOperationLayout.g NSg;
  private final j Gra;
  private WxCropOperationLayout.j HLk;
  private final Paint NSA;
  private final Paint NSB;
  private final RectF NSC;
  private final RectF NSD;
  public int NSE;
  private i NSF;
  private kotlin.g.a.a<ah> NSG;
  private boolean NSH;
  private final j NSI;
  private final View[] NSJ;
  public boolean NSK;
  private ValueAnimator NSL;
  private final RectF NSM;
  private float NSN;
  private float NSO;
  private final RectF NSP;
  private final RectF NSQ;
  private final PorterDuffXfermode NSR;
  private boolean NSS;
  private boolean NST;
  private com.tencent.mm.ui.widget.cropview.a NSU;
  public ValueAnimator NSV;
  private final RectF NSW;
  private final PointF NSX;
  private final PointF NSY;
  private final j NSh;
  private final j NSi;
  private final j NSj;
  private final j NSk;
  private final j NSl;
  private final j NSm;
  private final j NSn;
  private final j NSo;
  private final j NSp;
  private final Path NSq;
  private final Path NSr;
  private final Path NSs;
  private final Path NSt;
  private final Path NSu;
  private final Path NSv;
  private final Path NSw;
  private final Paint NSx;
  private final Paint NSy;
  private final Paint NSz;
  private int bgColor;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(279875);
    NSg = new WxCropOperationLayout.g((byte)0);
    AppMethodBeat.o(279875);
  }
  
  public WxCropOperationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(279774);
    this.NSh = k.cm((kotlin.g.a.a)new c(this));
    this.NSi = k.cm((kotlin.g.a.a)new b(this));
    this.NSj = k.cm((kotlin.g.a.a)new f(this));
    this.NSk = k.cm((kotlin.g.a.a)new a(this));
    this.NSl = k.cm((kotlin.g.a.a)new d(this));
    this.NSm = k.cm((kotlin.g.a.a)new e(this));
    this.NSn = k.cm((kotlin.g.a.a)new k(this));
    this.NSo = k.cm((kotlin.g.a.a)new l(this));
    this.NSp = k.cm((kotlin.g.a.a)new m(this));
    this.Gra = k.cm((kotlin.g.a.a)new o(this));
    this.NSq = new Path();
    this.NSr = new Path();
    this.NSs = new Path();
    this.NSt = new Path();
    this.NSu = new Path();
    this.NSv = new Path();
    this.NSw = new Path();
    this.NSx = new Paint();
    this.NSy = new Paint();
    this.NSz = new Paint();
    this.NSA = new Paint();
    this.NSB = new Paint();
    this.NSC = new RectF();
    this.NSD = new RectF();
    this.HLk = WxCropOperationLayout.j.NTk;
    this.NSI = k.cm((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.NSJ = paramContext;
    this.NSK = true;
    setBackgroundColor(0);
    this.NSx.setColor(-1);
    this.NSx.setStrokeWidth(getBOX_LINE_WIDTH());
    this.NSx.setStyle(Paint.Style.STROKE);
    this.NSx.setAntiAlias(true);
    this.NSy.set(this.NSx);
    this.NSy.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSz.set(this.NSx);
    this.NSz.setStrokeWidth(getCORNER_WIDTH());
    this.NSA.set(this.NSx);
    this.NSA.setStrokeCap(Paint.Cap.ROUND);
    this.NSA.setStrokeWidth(getBLOCK_WIDTH());
    this.NSB.set(this.NSx);
    this.NSB.setStrokeCap(Paint.Cap.ROUND);
    this.NSB.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSB.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(getBgColor());
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    ah localah = ah.aiuX;
    this.paint = paramContext;
    this.NSM = new RectF();
    this.NSP = new RectF();
    this.NSQ = new RectF();
    this.NSR = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.NSW = new RectF();
    this.NSX = new PointF();
    this.NSY = new PointF();
    AppMethodBeat.o(279774);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279783);
    this.NSh = k.cm((kotlin.g.a.a)new c(this));
    this.NSi = k.cm((kotlin.g.a.a)new b(this));
    this.NSj = k.cm((kotlin.g.a.a)new f(this));
    this.NSk = k.cm((kotlin.g.a.a)new a(this));
    this.NSl = k.cm((kotlin.g.a.a)new d(this));
    this.NSm = k.cm((kotlin.g.a.a)new e(this));
    this.NSn = k.cm((kotlin.g.a.a)new k(this));
    this.NSo = k.cm((kotlin.g.a.a)new l(this));
    this.NSp = k.cm((kotlin.g.a.a)new m(this));
    this.Gra = k.cm((kotlin.g.a.a)new o(this));
    this.NSq = new Path();
    this.NSr = new Path();
    this.NSs = new Path();
    this.NSt = new Path();
    this.NSu = new Path();
    this.NSv = new Path();
    this.NSw = new Path();
    this.NSx = new Paint();
    this.NSy = new Paint();
    this.NSz = new Paint();
    this.NSA = new Paint();
    this.NSB = new Paint();
    this.NSC = new RectF();
    this.NSD = new RectF();
    this.HLk = WxCropOperationLayout.j.NTk;
    this.NSI = k.cm((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    int i = 0;
    while (i < 8)
    {
      paramContext[i] = null;
      i += 1;
    }
    this.NSJ = paramContext;
    this.NSK = true;
    setBackgroundColor(0);
    this.NSx.setColor(-1);
    this.NSx.setStrokeWidth(getBOX_LINE_WIDTH());
    this.NSx.setStyle(Paint.Style.STROKE);
    this.NSx.setAntiAlias(true);
    this.NSy.set(this.NSx);
    this.NSy.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSz.set(this.NSx);
    this.NSz.setStrokeWidth(getCORNER_WIDTH());
    this.NSA.set(this.NSx);
    this.NSA.setStrokeCap(Paint.Cap.ROUND);
    this.NSA.setStrokeWidth(getBLOCK_WIDTH());
    this.NSB.set(this.NSx);
    this.NSB.setStrokeCap(Paint.Cap.ROUND);
    this.NSB.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSB.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(getBgColor());
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    paramAttributeSet = ah.aiuX;
    this.paint = paramContext;
    this.NSM = new RectF();
    this.NSP = new RectF();
    this.NSQ = new RectF();
    this.NSR = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.NSW = new RectF();
    this.NSX = new PointF();
    this.NSY = new PointF();
    AppMethodBeat.o(279783);
  }
  
  public WxCropOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279793);
    this.NSh = k.cm((kotlin.g.a.a)new c(this));
    this.NSi = k.cm((kotlin.g.a.a)new b(this));
    this.NSj = k.cm((kotlin.g.a.a)new f(this));
    this.NSk = k.cm((kotlin.g.a.a)new a(this));
    this.NSl = k.cm((kotlin.g.a.a)new d(this));
    this.NSm = k.cm((kotlin.g.a.a)new e(this));
    this.NSn = k.cm((kotlin.g.a.a)new k(this));
    this.NSo = k.cm((kotlin.g.a.a)new l(this));
    this.NSp = k.cm((kotlin.g.a.a)new m(this));
    this.Gra = k.cm((kotlin.g.a.a)new o(this));
    this.NSq = new Path();
    this.NSr = new Path();
    this.NSs = new Path();
    this.NSt = new Path();
    this.NSu = new Path();
    this.NSv = new Path();
    this.NSw = new Path();
    this.NSx = new Paint();
    this.NSy = new Paint();
    this.NSz = new Paint();
    this.NSA = new Paint();
    this.NSB = new Paint();
    this.NSC = new RectF();
    this.NSD = new RectF();
    this.HLk = WxCropOperationLayout.j.NTk;
    this.NSI = k.cm((kotlin.g.a.a)new n(this));
    paramContext = new View[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      paramContext[paramInt] = null;
      paramInt += 1;
    }
    this.NSJ = paramContext;
    this.NSK = true;
    setBackgroundColor(0);
    this.NSx.setColor(-1);
    this.NSx.setStrokeWidth(getBOX_LINE_WIDTH());
    this.NSx.setStyle(Paint.Style.STROKE);
    this.NSx.setAntiAlias(true);
    this.NSy.set(this.NSx);
    this.NSy.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSz.set(this.NSx);
    this.NSz.setStrokeWidth(getCORNER_WIDTH());
    this.NSA.set(this.NSx);
    this.NSA.setStrokeCap(Paint.Cap.ROUND);
    this.NSA.setStrokeWidth(getBLOCK_WIDTH());
    this.NSB.set(this.NSx);
    this.NSB.setStrokeCap(Paint.Cap.ROUND);
    this.NSB.setStrokeWidth(getBOX_GIRD_WIDTH());
    this.NSB.setColor(-7829368);
    this.bgColor = Color.parseColor("#bf232323");
    paramContext = new Paint();
    paramContext.setDither(false);
    paramContext.setColor(getBgColor());
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setFilterBitmap(true);
    paramAttributeSet = ah.aiuX;
    this.paint = paramContext;
    this.NSM = new RectF();
    this.NSP = new RectF();
    this.NSQ = new RectF();
    this.NSR = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.NSW = new RectF();
    this.NSX = new PointF();
    this.NSY = new PointF();
    AppMethodBeat.o(279793);
  }
  
  private static final void a(int paramInt, View paramView1, WxCropOperationLayout paramWxCropOperationLayout, float paramFloat, View paramView2)
  {
    AppMethodBeat.i(279865);
    s.u(paramView1, "$it");
    s.u(paramWxCropOperationLayout, "this$0");
    if (paramInt == h.NTa.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().top + paramFloat);
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().left + paramFloat);
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTb.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().top + paramFloat);
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().right - paramFloat - paramView1.getWidth());
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTc.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().bottom - paramFloat - paramView2.getHeight());
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().left + paramFloat);
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTd.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().bottom - paramFloat - paramView2.getHeight());
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().right - paramFloat - paramView1.getWidth());
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTe.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().top - paramFloat - paramView2.getHeight());
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().left + paramFloat);
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTf.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().top - paramFloat - paramView2.getHeight());
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().right - paramFloat - paramView1.getWidth());
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTg.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().bottom + paramFloat);
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().left + paramFloat);
      AppMethodBeat.o(279865);
      return;
    }
    if (paramInt == h.NTh.value)
    {
      paramView1.setTranslationY(paramWxCropOperationLayout.getBoxRect().bottom + paramFloat);
      paramView1.setTranslationX(paramWxCropOperationLayout.getBoxRect().right - paramFloat - paramView1.getWidth());
    }
    AppMethodBeat.o(279865);
  }
  
  private static final void a(WxCropOperationLayout paramWxCropOperationLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(279859);
    s.u(paramWxCropOperationLayout, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramWxCropOperationLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(279859);
      throw paramWxCropOperationLayout;
    }
    paramWxCropOperationLayout.NSE = ((Integer)paramValueAnimator).intValue();
    paramWxCropOperationLayout.invalidate();
    AppMethodBeat.o(279859);
  }
  
  private static final void b(WxCropOperationLayout paramWxCropOperationLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(279870);
    s.u(paramWxCropOperationLayout, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramWxCropOperationLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(279870);
      throw paramWxCropOperationLayout;
    }
    paramWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
    paramWxCropOperationLayout.invalidate();
    AppMethodBeat.o(279870);
  }
  
  private static final void c(WxCropOperationLayout paramWxCropOperationLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(279873);
    s.u(paramWxCropOperationLayout, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramWxCropOperationLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(279873);
      throw paramWxCropOperationLayout;
    }
    paramWxCropOperationLayout.setBgColor(((Integer)paramValueAnimator).intValue());
    paramWxCropOperationLayout.invalidate();
    AppMethodBeat.o(279873);
  }
  
  private void gJM()
  {
    AppMethodBeat.i(279850);
    Object localObject1 = this.NSJ;
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
    localObject1 = this.NSU;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.cropview.a)localObject1).Nx(false);
    }
    AppMethodBeat.o(279850);
  }
  
  private final float getBLOCK_WIDTH()
  {
    AppMethodBeat.i(279811);
    float f = ((Number)this.NSk.getValue()).floatValue();
    AppMethodBeat.o(279811);
    return f;
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(279801);
    float f = ((Number)this.NSi.getValue()).floatValue();
    AppMethodBeat.o(279801);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(279797);
    float f = ((Number)this.NSh.getValue()).floatValue();
    AppMethodBeat.o(279797);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(279816);
    float f = ((Number)this.NSl.getValue()).floatValue();
    AppMethodBeat.o(279816);
    return f;
  }
  
  private final Drawable getBlockDrawable()
  {
    AppMethodBeat.i(279841);
    Object localObject = this.NSI.getValue();
    s.s(localObject, "<get-blockDrawable>(...)");
    localObject = (Drawable)localObject;
    AppMethodBeat.o(279841);
    return localObject;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(279820);
    float f = ((Number)this.NSm.getValue()).floatValue();
    AppMethodBeat.o(279820);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(279807);
    float f = ((Number)this.NSj.getValue()).floatValue();
    AppMethodBeat.o(279807);
    return f;
  }
  
  private final float getTOUCH_BLOCK_PADDING()
  {
    AppMethodBeat.i(279823);
    float f = ((Number)this.NSn.getValue()).floatValue();
    AppMethodBeat.o(279823);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(279837);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(279837);
    return localGestureDetector;
  }
  
  private final int get_1A()
  {
    AppMethodBeat.i(279826);
    int i = ((Number)this.NSo.getValue()).intValue();
    AppMethodBeat.o(279826);
    return i;
  }
  
  private final int get_4A()
  {
    AppMethodBeat.i(279831);
    int i = ((Number)this.NSp.getValue()).intValue();
    AppMethodBeat.o(279831);
    return i;
  }
  
  public final void a(View paramView, h paramh)
  {
    AppMethodBeat.i(279936);
    s.u(paramView, "view");
    s.u(paramh, "style");
    View localView = this.NSJ[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.NSJ[paramh.value] = paramView;
    addView(paramView);
    AppMethodBeat.o(279936);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(279948);
    s.u(paramh, "style");
    View localView = this.NSJ[paramh.value];
    if (localView != null) {
      removeView(localView);
    }
    this.NSJ[paramh.value] = null;
    AppMethodBeat.o(279948);
  }
  
  public void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(280038);
    ValueAnimator localValueAnimator = this.NSV;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    new StringBuilder("[animBorder] alpha=").append(paramInt).append(" delay=").append(paramLong);
    localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { this.NSE, paramInt }) });
    if (localValueAnimator == null) {
      localValueAnimator = null;
    }
    for (;;)
    {
      this.NSV = localValueAnimator;
      if (paramInt != 0) {
        break;
      }
      gJL();
      AppMethodBeat.o(280038);
      return;
      localValueAnimator.addUpdateListener(new WxCropOperationLayout..ExternalSyntheticLambda1(this));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramLong);
      localValueAnimator.start();
      ah localah = ah.aiuX;
    }
    gJM();
    AppMethodBeat.o(280038);
  }
  
  public final void gJI()
  {
    AppMethodBeat.i(279943);
    View[] arrayOfView = this.NSJ;
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
    AppMethodBeat.o(279943);
  }
  
  protected final boolean gJJ()
  {
    return this.NSS;
  }
  
  protected final boolean gJK()
  {
    return this.NST;
  }
  
  public final void gJL()
  {
    AppMethodBeat.i(280046);
    this.NSE = 255;
    float f = getContext().getResources().getDimension(b.c.Edge_2A);
    Object localObject = this.NSJ;
    int i = 0;
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      View localView = localObject[j];
      if (localView != null)
      {
        localView.setVisibility(0);
        localView.setAlpha(0.0F);
        localView.animate().setStartDelay(300L).withStartAction(new WxCropOperationLayout..ExternalSyntheticLambda3(i, localView, this, f, localView)).alpha(1.0F).setDuration(300L).start();
      }
      j += 1;
      i += 1;
    }
    localObject = this.NSU;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.cropview.a)localObject).Nx(true);
    }
    AppMethodBeat.o(280046);
  }
  
  public final void gJN()
  {
    AppMethodBeat.i(280100);
    ValueAnimator localValueAnimator = this.NSL;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -14474461 });
    localValueAnimator.addUpdateListener(new WxCropOperationLayout..ExternalSyntheticLambda2(this));
    localValueAnimator.start();
    ah localah = ah.aiuX;
    this.NSL = localValueAnimator;
    AppMethodBeat.o(280100);
  }
  
  public final void gJO()
  {
    AppMethodBeat.i(280107);
    ValueAnimator localValueAnimator = this.NSL;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofArgb(new int[] { this.bgColor, -1088216285 });
    localValueAnimator.addUpdateListener(new WxCropOperationLayout..ExternalSyntheticLambda0(this));
    localValueAnimator.start();
    ah localah = ah.aiuX;
    this.NSL = localValueAnimator;
    AppMethodBeat.o(280107);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final boolean getBlockOutsideTouch()
  {
    return this.NSH;
  }
  
  public final com.tencent.mm.ui.widget.cropview.a getBorderVisibilityCallback()
  {
    return this.NSU;
  }
  
  protected final RectF getBoxRect()
  {
    return this.NSQ;
  }
  
  protected final Paint getGridLinePaint()
  {
    return this.NSy;
  }
  
  protected final Path getGridLinePath()
  {
    return this.NSq;
  }
  
  public final float getLimitMaxHeight()
  {
    return this.NSN;
  }
  
  public final float getLimitMinHeight()
  {
    return this.NSO;
  }
  
  public final i getOnOperationCallback()
  {
    return this.NSF;
  }
  
  public final kotlin.g.a.a<ah> getOutsideTouckListener()
  {
    return this.NSG;
  }
  
  protected final boolean getShowGridLine()
  {
    return this.NSK;
  }
  
  public final WxCropOperationLayout.j getStyle()
  {
    return this.HLk;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.NSM;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(280048);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.NSV;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.NSL;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    AppMethodBeat.o(280048);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280079);
    s.u(paramMotionEvent, "event");
    Object localObject;
    if (!this.NSM.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      localObject = this.NSG;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
    }
    if (this.HLk == WxCropOperationLayout.j.NTk)
    {
      this.NST = false;
      this.NSS = false;
      if (this.NSC.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.NSS = true;
        localObject = this.NSF;
        if (localObject != null) {
          ((i)localObject).vS(true);
        }
      }
      for (;;)
      {
        if ((this.NSS) || (this.NST)) {
          aR(255, 0L);
        }
        if ((!this.NSS) && (!this.NST) && ((!this.NSH) || (this.NSM.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))) {
          break;
        }
        AppMethodBeat.o(280079);
        return true;
        if (this.NSD.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.NST = true;
          localObject = this.NSF;
          if (localObject != null) {
            ((i)localObject).vS(false);
          }
        }
      }
      AppMethodBeat.o(280079);
      return false;
    }
    AppMethodBeat.o(280079);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280002);
    s.u(paramCanvas, "canvas");
    int i = paramCanvas.saveLayer(this.NSP, null);
    paramCanvas.drawRect(this.NSP, this.paint);
    this.paint.setXfermode((Xfermode)this.NSR);
    if (WxCropOperationLayout.j.NTj == this.HLk)
    {
      paramCanvas.drawCircle(this.NSM.centerX(), this.NSM.centerY(), Math.min(this.NSM.width(), this.NSM.height()) / 2.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      if ((this.HLk != WxCropOperationLayout.j.NTj) && (this.HLk != WxCropOperationLayout.j.NTl)) {
        break label194;
      }
    }
    label194:
    while (s.p(this.NSM, this.NSW))
    {
      r(paramCanvas);
      AppMethodBeat.o(280002);
      return;
      if ((WxCropOperationLayout.j.NTk != this.HLk) && (WxCropOperationLayout.j.NTl != this.HLk) && (WxCropOperationLayout.j.NTm != this.HLk)) {
        break;
      }
      paramCanvas.drawRect(this.NSM, this.paint);
      break;
    }
    this.NSW.set(this.NSM);
    Object localObject = this.NSF;
    if (localObject != null) {
      ((i)localObject).f(this.NSM);
    }
    this.NSQ.set(this.NSM);
    this.NSQ.set(this.NSM.left + getBOX_PADDING(), this.NSM.top + getBOX_PADDING(), this.NSM.right - getBOX_PADDING(), this.NSM.bottom - getBOX_PADDING());
    float f1 = this.NSQ.left + this.NSQ.width() / 2.0F;
    float f2 = this.NSQ.bottom;
    this.NSD.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, getTOUCH_BLOCK_PADDING() * 2.0F + f1, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
    this.NSX.set(this.NSQ.width() / 2.0F - get_4A() / 2 + this.NSM.left, this.NSQ.top - get_1A() / 2);
    this.NSY.set(this.NSQ.width() / 2.0F - get_4A() / 2 + this.NSM.left, this.NSQ.bottom - get_1A() / 2);
    f2 = this.NSQ.top;
    this.NSC.set(f1 - getTOUCH_BLOCK_PADDING() * 2.0F, f2 - getTOUCH_BLOCK_PADDING() * 1.5F, f1 + getTOUCH_BLOCK_PADDING() * 2.0F, f2 + getTOUCH_BLOCK_PADDING() * 1.5F);
    this.NSq.reset();
    int j;
    for (i = 1;; i = j)
    {
      j = i + 1;
      this.NSq.moveTo(this.NSQ.left + this.NSQ.width() / 3.0F * i, this.NSQ.top);
      this.NSq.lineTo(this.NSQ.left + this.NSQ.width() / 3.0F * i, this.NSQ.bottom);
      this.NSq.moveTo(this.NSQ.left, this.NSQ.top + this.NSQ.height() / 3.0F * i);
      localObject = this.NSq;
      f1 = this.NSQ.right;
      f2 = this.NSQ.top;
      float f3 = this.NSQ.height() / 3.0F;
      ((Path)localObject).lineTo(f1, i * f3 + f2);
      if (j > 2) {
        break;
      }
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280086);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    AppMethodBeat.o(280086);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    AppMethodBeat.i(279989);
    if (!paramBoolean)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(279989);
      return;
    }
    aR(255, 500L);
    this.NSP.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.NSM.isEmpty()) {
      this.NSM.set(paramInt1, getHeight() / 4 + paramInt2, paramInt3, paramInt4 - getHeight() / 4);
    }
    if (this.NSN == 0.0F)
    {
      i = 1;
      if (i != 0) {
        setLimitMaxHeight(this.NSP.height() / 2.0F);
      }
      if (this.NSO != 0.0F) {
        break label186;
      }
    }
    label186:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        setLimitMinHeight(this.NSP.height() / 4.0F);
      }
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(279989);
      return;
      i = 0;
      break;
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280095);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    s.u(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(280095);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280025);
    s.u(paramMotionEvent1, "event");
    s.u(paramMotionEvent2, "e2");
    s.X("[onScroll] event=", paramMotionEvent1);
    if (this.NSS)
    {
      paramMotionEvent1 = this.NSM;
      paramMotionEvent1.top -= paramFloat2;
      paramMotionEvent1 = this.NSM;
      paramMotionEvent1.bottom += paramFloat2;
    }
    if (this.NST)
    {
      paramMotionEvent1 = this.NSM;
      paramMotionEvent1.top += paramFloat2;
      paramMotionEvent1 = this.NSM;
      paramMotionEvent1.bottom -= paramFloat2;
    }
    if (this.NSM.height() > this.NSN)
    {
      paramFloat1 = this.NSN - this.NSM.height();
      paramMotionEvent1 = this.NSM;
      paramMotionEvent1.top -= paramFloat1 / 2.0F;
      paramMotionEvent1 = this.NSM;
      paramFloat2 = paramMotionEvent1.bottom;
      paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
    }
    for (;;)
    {
      postInvalidate();
      if ((!this.NST) && (!this.NSS)) {
        break;
      }
      AppMethodBeat.o(280025);
      return true;
      if (this.NSM.height() < this.NSO)
      {
        paramFloat1 = this.NSO - this.NSM.height();
        paramMotionEvent1 = this.NSM;
        paramMotionEvent1.top -= paramFloat1 / 2.0F;
        paramMotionEvent1 = this.NSM;
        paramFloat2 = paramMotionEvent1.bottom;
        paramMotionEvent1.bottom = (paramFloat1 / 2.0F + paramFloat2);
      }
    }
    AppMethodBeat.o(280025);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280062);
    s.u(paramMotionEvent, "e");
    AppMethodBeat.o(280062);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280067);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    s.u(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(280067);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280029);
    s.u(paramMotionEvent, "event");
    if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && ((this.NSS) || (this.NST)))
    {
      aR(0, 1000L);
      localObject = this.NSF;
      if (localObject != null) {
        ((i)localObject).vT(this.NSS);
      }
    }
    Object localObject = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aYi(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(280029);
    return bool;
  }
  
  protected void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(280054);
    s.u(paramCanvas, "canvas");
    if ((this.HLk == WxCropOperationLayout.j.NTk) || (this.HLk == WxCropOperationLayout.j.NTm))
    {
      this.NSy.setAlpha(this.NSE);
      this.NSx.setAlpha(this.NSE);
      if (this.NSK) {
        paramCanvas.drawPath(this.NSq, this.NSy);
      }
      paramCanvas.drawRect(this.NSQ, this.NSy);
      if (this.HLk == WxCropOperationLayout.j.NTk)
      {
        paramCanvas.save();
        paramCanvas.translate(this.NSY.x, this.NSY.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(this.NSX.x, this.NSX.y);
        if ((getBlockDrawable() instanceof BitmapDrawable))
        {
          getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
          getBlockDrawable().draw(paramCanvas);
        }
        paramCanvas.restore();
      }
    }
    AppMethodBeat.o(280054);
  }
  
  protected final void setBelongBottomBlock(boolean paramBoolean)
  {
    this.NST = paramBoolean;
  }
  
  protected final void setBelongTopBlock(boolean paramBoolean)
  {
    this.NSS = paramBoolean;
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(279955);
    this.paint.setColor(paramInt);
    this.bgColor = paramInt;
    AppMethodBeat.o(279955);
  }
  
  public final void setBlockOutsideTouch(boolean paramBoolean)
  {
    this.NSH = paramBoolean;
  }
  
  public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.a parama)
  {
    this.NSU = parama;
  }
  
  public final void setLimitMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(279968);
    this.NSN = paramFloat;
    postInvalidate();
    AppMethodBeat.o(279968);
  }
  
  public final void setLimitMinHeight(float paramFloat)
  {
    AppMethodBeat.i(279975);
    this.NSO = paramFloat;
    postInvalidate();
    AppMethodBeat.o(279975);
  }
  
  public final void setOnOperationCallback(i parami)
  {
    this.NSF = parami;
  }
  
  public final void setOutsideTouckListener(kotlin.g.a.a<ah> parama)
  {
    this.NSG = parama;
  }
  
  protected final void setShowGridLine(boolean paramBoolean)
  {
    this.NSK = paramBoolean;
  }
  
  public final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(279915);
    s.u(paramj, "value");
    this.HLk = paramj;
    postInvalidate();
    AppMethodBeat.o(279915);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Float>
  {
    a(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Float>
  {
    b(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Float>
  {
    c(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Float>
  {
    d(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Float>
  {
    e(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Float>
  {
    f(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum h
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(279788);
      NTa = new h("TOP_LEFT", 0, 0);
      NTb = new h("TOP_RIGHT", 1, 1);
      NTc = new h("BOTTOM_LEFT", 2, 2);
      NTd = new h("BOTTOM_RIGHT", 3, 3);
      NTe = new h("TOP_LEFT_OUT", 4, 4);
      NTf = new h("TOP_RIGHT_OUT", 5, 5);
      NTg = new h("BOTTOM_LEFT_OUT", 6, 6);
      NTh = new h("BOTTOM_RIGHT_OUT", 7, 7);
      NTi = new h[] { NTa, NTb, NTc, NTd, NTe, NTf, NTg, NTh };
      AppMethodBeat.o(279788);
    }
    
    private h(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface i
  {
    public abstract void f(RectF paramRectF);
    
    public abstract void vS(boolean paramBoolean);
    
    public abstract void vT(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Float>
  {
    k(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<Integer>
  {
    l(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<Integer>
  {
    m(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<Drawable>
  {
    n(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<GestureDetector>
  {
    o(WxCropOperationLayout paramWxCropOperationLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
 * JD-Core Version:    0.7.0.1
 */