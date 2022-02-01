package com.tencent.mm.ui.widget.cropview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "contentBaseRect", "Landroid/graphics/Rect;", "getContentBaseRect", "()Landroid/graphics/Rect;", "setContentBaseRect", "(Landroid/graphics/Rect;)V", "contentCenterRect", "getContentCenterRect", "setContentCenterRect", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "getInitFinish", "()Lkotlin/jvm/functions/Function1;", "setInitFinish", "(Lkotlin/jvm/functions/Function1;)V", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "setShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "getTmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onSingleTapUp", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CropLayout
  extends BaseCropLayout
{
  public static final CropLayout.a agcP;
  private Rect HLr;
  private float HLs;
  private final RectF NSM;
  private c UhU;
  private b agcQ;
  private float agcR;
  private float agcS;
  private float agcT;
  private float agcU;
  private boolean agcV;
  private boolean agcW;
  private final Rect agcX;
  private final Rect agcY;
  private final RectF agcZ;
  private Rect agda;
  private e agdb;
  private boolean agdc;
  private boolean agdd;
  private boolean agde;
  private boolean agdf;
  private float agdg;
  private float agdh;
  private boolean agdi;
  private final float[] agdj;
  private Animator agdk;
  private final float[] agdl;
  private boolean agdm;
  private boolean agdn;
  private Animator agdo;
  private Animator agdp;
  private Animator agdq;
  private b<? super Matrix, Boolean> agdr;
  private final float[] agds;
  private View contentView;
  private final Matrix dtZ;
  private final RectF dzQ;
  private View.OnClickListener fhU;
  private Matrix hcd;
  private float[] hpa;
  private final Rect yok;
  
  static
  {
    AppMethodBeat.i(164441);
    agcP = new CropLayout.a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.hcd = new Matrix();
    this.agcR = 0.25F;
    this.agcS = 5.0F;
    this.agcT = 1.0F;
    this.agcU = 1.0F;
    this.agcV = true;
    this.HLs = 1.0F;
    this.NSM = new RectF();
    this.agcX = new Rect();
    this.agcY = new Rect();
    this.yok = new Rect();
    this.agcZ = new RectF();
    this.agda = new Rect();
    this.HLr = new Rect();
    this.agdb = e.agdt;
    this.agdc = true;
    setBackgroundColor(getContext().getResources().getColor(17170444));
    this.dtZ = new Matrix();
    this.agdj = new float[2];
    this.agdl = new float[2];
    this.agdr = ((b)CropLayout.g.agdx);
    this.dzQ = new RectF();
    this.agds = new float[2];
    this.hpa = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.hcd = new Matrix();
    this.agcR = 0.25F;
    this.agcS = 5.0F;
    this.agcT = 1.0F;
    this.agcU = 1.0F;
    this.agcV = true;
    this.HLs = 1.0F;
    this.NSM = new RectF();
    this.agcX = new Rect();
    this.agcY = new Rect();
    this.yok = new Rect();
    this.agcZ = new RectF();
    this.agda = new Rect();
    this.HLr = new Rect();
    this.agdb = e.agdt;
    this.agdc = true;
    setBackgroundColor(getContext().getResources().getColor(17170444));
    this.dtZ = new Matrix();
    this.agdj = new float[2];
    this.agdl = new float[2];
    this.agdr = ((b)CropLayout.g.agdx);
    this.dzQ = new RectF();
    this.agds = new float[2];
    this.hpa = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.hcd = new Matrix();
    this.agcR = 0.25F;
    this.agcS = 5.0F;
    this.agcT = 1.0F;
    this.agcU = 1.0F;
    this.agcV = true;
    this.HLs = 1.0F;
    this.NSM = new RectF();
    this.agcX = new Rect();
    this.agcY = new Rect();
    this.yok = new Rect();
    this.agcZ = new RectF();
    this.agda = new Rect();
    this.HLr = new Rect();
    this.agdb = e.agdt;
    this.agdc = true;
    setBackgroundColor(getContext().getResources().getColor(17170444));
    this.dtZ = new Matrix();
    this.agdj = new float[2];
    this.agdl = new float[2];
    this.agdr = ((b)CropLayout.g.agdx);
    this.dzQ = new RectF();
    this.agds = new float[2];
    this.hpa = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void A(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.agcZ.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.agcZ.left) / this.agcZ.width();
    float f2 = (paramFloat3 - this.agcZ.top) / this.agcZ.height();
    ei(paramFloat1);
    b localb = this.agcQ;
    if (localb != null) {
      localb.s(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.agcZ.left;
    float f3 = this.agcZ.width();
    float f4 = this.agcZ.top;
    float f5 = this.agcZ.height();
    this.hcd.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    jHx();
    AppMethodBeat.o(164432);
  }
  
  private static final void a(CropLayout paramCropLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252633);
    s.u(paramCropLayout, "this$0");
    Object localObject = paramValueAnimator.getAnimatedValue("scale");
    if (localObject == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252633);
      throw paramCropLayout;
    }
    float f3 = ((Float)localObject).floatValue();
    localObject = paramValueAnimator.getAnimatedValue("transX");
    if (localObject == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252633);
      throw paramCropLayout;
    }
    float f1 = ((Float)localObject).floatValue();
    paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
    if (paramValueAnimator == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252633);
      throw paramCropLayout;
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    paramCropLayout.getMatrixValues();
    paramCropLayout.ei(f3 * 1.0F / paramCropLayout.getContentViewScale()[0]);
    f3 = paramCropLayout.getContentRectF().centerX();
    float f4 = paramCropLayout.getContentRectF().centerY();
    paramCropLayout.bn(-(f1 - f3), -(f2 - f4));
    AppMethodBeat.o(252633);
  }
  
  private static final void a(CropLayout paramCropLayout, ah.c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252614);
    s.u(paramCropLayout, "this$0");
    s.u(paramc, "$lastRotate");
    paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
    if (paramValueAnimator == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252614);
      throw paramCropLayout;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramCropLayout.eh(f - paramc.aixa);
    paramc.aixa = f;
    AppMethodBeat.o(252614);
  }
  
  private static final void a(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, ah.c paramc1, ah.c paramc2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252628);
    s.u(paramCropLayout, "this$0");
    s.u(paramc1, "$lastEdgeX");
    s.u(paramc2, "$lastEdgeY");
    if (((paramCropLayout.getScaleType() == e.agdu) && (!paramBoolean1) && (!paramBoolean2)) || ((paramCropLayout.getScaleType() == e.agdt) && ((!paramBoolean1) || (!paramBoolean2))))
    {
      localObject = paramValueAnimator.getAnimatedValue("scale");
      if (localObject == null)
      {
        paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(252628);
        throw paramCropLayout;
      }
      paramCropLayout.A(((Float)localObject).floatValue() * 1.0F / paramCropLayout.getContentViewScale()[0], paramCropLayout.getContentRectF().centerX(), paramCropLayout.getContentRectF().centerY());
    }
    Object localObject = paramValueAnimator.getAnimatedValue("transX");
    if (localObject == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252628);
      throw paramCropLayout;
    }
    float f1 = ((Float)localObject).floatValue();
    localObject = paramValueAnimator.getAnimatedValue("transY");
    if (localObject == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252628);
      throw paramCropLayout;
    }
    float f2 = ((Float)localObject).floatValue();
    localObject = paramValueAnimator.getAnimatedValue("edgeX");
    if (localObject == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252628);
      throw paramCropLayout;
    }
    float f3 = ((Float)localObject).floatValue();
    paramValueAnimator = paramValueAnimator.getAnimatedValue("edgeY");
    if (paramValueAnimator == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252628);
      throw paramCropLayout;
    }
    float f4 = ((Float)paramValueAnimator).floatValue();
    float f7 = paramc1.aixa;
    float f5 = paramc2.aixa;
    float f8 = paramCropLayout.getContentRectF().centerX();
    float f6 = paramCropLayout.getContentRectF().centerY();
    if (paramBoolean2)
    {
      f1 = -(f3 - f7);
      if (!paramBoolean1) {
        break label403;
      }
    }
    label403:
    for (f2 = -(f4 - f5);; f2 = -(f2 - f6))
    {
      paramCropLayout.bn(f1, f2);
      paramc1.aixa = f3;
      paramc2.aixa = f4;
      AppMethodBeat.o(252628);
      return;
      f1 = -(f1 - f8);
      break;
    }
  }
  
  private static final void b(CropLayout paramCropLayout, ah.c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252622);
    s.u(paramCropLayout, "this$0");
    s.u(paramc, "$lastRotate");
    paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
    if (paramValueAnimator == null)
    {
      paramCropLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(252622);
      throw paramCropLayout;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramCropLayout.eh(f - paramc.aixa);
    paramc.aixa = f;
    AppMethodBeat.o(252622);
  }
  
  private final void bn(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.agcQ;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.hcd.postTranslate(-paramFloat1, -paramFloat2);
    jHx();
    AppMethodBeat.o(164433);
  }
  
  private final void e(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      bn(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (jHs())
    {
      f = paramFloat1;
      if (jHu()) {
        f = paramFloat1 * 0.4F;
      }
      if (!jHt()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!jHv()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      bn(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private final void eh(float paramFloat)
  {
    AppMethodBeat.i(252534);
    this.dtZ.reset();
    Object localObject = this.contentView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getMatrix();
      if (localObject != null) {
        ((Matrix)localObject).invert(this.dtZ);
      }
    }
    this.agdj[0] = this.NSM.centerX();
    this.agdj[1] = this.NSM.centerY();
    this.dtZ.mapPoints(this.agdj);
    this.dtZ.getValues(this.hpa);
    this.hcd.postRotate(paramFloat);
    jHx();
    localObject = this.contentView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getMatrix();
      if (localObject != null) {
        ((Matrix)localObject).mapPoints(this.agdj);
      }
    }
    this.hcd.postTranslate(this.NSM.centerX() - this.agdj[0], this.NSM.centerY() - this.agdj[1]);
    jHx();
    AppMethodBeat.o(252534);
  }
  
  private final void ei(float paramFloat)
  {
    AppMethodBeat.i(252597);
    this.hcd.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    jHx();
    AppMethodBeat.o(252597);
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.hcd.getValues(this.hpa);
    float[] arrayOfFloat = this.hpa;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Float.isNaN(arrayOfFloat[j]))
        {
          new StringBuilder("MatrixValues Error! index=").append(i).append(" value=").append(this.hpa[i]);
          this.hpa[i] = 1.0F;
        }
      }
      else
      {
        arrayOfFloat = this.hpa;
        AppMethodBeat.o(164437);
        return arrayOfFloat;
      }
      j += 1;
      i += 1;
    }
  }
  
  private final float getRotate()
  {
    AppMethodBeat.i(164419);
    Object localObject = this.contentView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getMatrix();
      if (localObject != null) {
        ((Matrix)localObject).getValues(this.hpa);
      }
    }
    float f = -(float)Math.round(Math.atan2(this.hpa[1], this.hpa[0]) * 57.295779513082323D);
    AppMethodBeat.o(164419);
    return f;
  }
  
  private final float getRotateDegrees()
  {
    AppMethodBeat.i(164418);
    this.hcd.getValues(this.hpa);
    float f = -(float)Math.round(Math.atan2(this.hpa[1], this.hpa[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private boolean jHs()
  {
    AppMethodBeat.i(164421);
    if (this.agcZ.width() > this.NSM.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.agdm != true)) {
        this.agde = true;
      }
      this.agdm = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private final boolean jHu()
  {
    return (this.NSM.left < this.agcZ.left) || (this.NSM.right > this.agcZ.right);
  }
  
  private boolean jHv()
  {
    return (this.NSM.top < this.agcZ.top) || (this.NSM.bottom > this.agcZ.bottom);
  }
  
  private void jHw()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.agdo;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (jHA())
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.agcZ.left - this.NSM.left);
    int j = (int)(this.agcZ.top - this.NSM.top);
    int m = (int)(this.NSM.right - this.agcZ.right);
    int k = (int)(this.NSM.bottom - this.agcZ.bottom);
    if ((jHu()) && (i > 0)) {
      if (jHs())
      {
        if ((!jHv()) || (j <= 0)) {
          break label280;
        }
        if (!jHt()) {
          break label260;
        }
        label141:
        if ((i != 0) || (j != 0)) {
          break label335;
        }
        localObject = this.UhU;
        if (!(localObject instanceof d)) {
          break label329;
        }
      }
    }
    label260:
    label280:
    label329:
    for (localObject = (d)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((d)localObject).hSZ();
      }
      AppMethodBeat.o(164423);
      return;
      i = (int)(this.agcZ.centerX() - this.NSM.centerX());
      break;
      if ((jHu()) && (m > 0))
      {
        if (jHs())
        {
          i = -m;
          break;
        }
        i = (int)(this.agcZ.centerX() - this.NSM.centerX());
        break;
      }
      i = 0;
      break;
      j = (int)(this.agcZ.centerY() - this.NSM.centerY());
      break label141;
      if ((jHv()) && (k > 0))
      {
        if (jHt())
        {
          j = -k;
          break label141;
        }
        j = (int)(this.agcZ.centerY() - this.NSM.centerY());
        break label141;
      }
      j = 0;
      break label141;
    }
    label335:
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("transX", new int[] { 0, i }), PropertyValuesHolder.ofInt("transY", new int[] { 0, j }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m(this));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new n(null, this));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(160L);
    ((ValueAnimator)localObject).start();
    ah localah = ah.aiuX;
    this.agdo = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private void k(RectF paramRectF)
  {
    AppMethodBeat.i(252570);
    s.u(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.agda.width(), paramRectF.height() * 1.0F / this.agda.height());
    float f2;
    float f1;
    if (this.agcZ.height() > this.NSM.height())
    {
      f2 = this.agcZ.centerX() - this.NSM.centerX();
      f1 = this.agcZ.top - this.NSM.top;
    }
    for (;;)
    {
      this.HLs = f3;
      this.agcT = (this.agcR * this.HLs);
      this.agcU = (this.agcS * this.HLs);
      bn(f2, f1);
      A(f3, this.NSM.centerX(), this.NSM.centerY());
      this.agcZ.round(this.HLr);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.agda).append(" contentRect=").append(this.yok);
      AppMethodBeat.o(252570);
      return;
      if (this.agcZ.width() > this.NSM.width())
      {
        f2 = this.agcZ.left - this.NSM.left;
        f1 = this.agcZ.centerY() - this.NSM.centerY();
      }
      else
      {
        f2 = this.agcZ.centerX() - this.NSM.centerX();
        f1 = this.agcZ.centerY() - this.NSM.centerY();
      }
    }
  }
  
  private void l(RectF paramRectF)
  {
    AppMethodBeat.i(164426);
    s.u(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.agda.width(), paramRectF.height() * 1.0F / this.agda.height());
    float f2 = this.agcZ.centerX() - this.NSM.centerX();
    float f3 = this.agcZ.centerY() - this.NSM.centerY();
    this.HLs = f1;
    this.agcT = (this.agcR * this.HLs);
    this.agcU = (this.agcS * this.HLs);
    bn(f2, f3);
    A(f1, this.NSM.centerX(), this.NSM.centerY());
    this.agcZ.round(this.HLr);
    new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.agda).append(" contentRect=").append(this.yok);
    AppMethodBeat.o(164426);
  }
  
  private void m(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    s.u(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.agda.width(), paramRectF.height() * 1.0F / this.agda.height());
    float f2 = this.agcZ.centerX() - this.NSM.centerX();
    float f3 = this.agcZ.centerY() - this.NSM.centerY();
    this.HLs = f1;
    this.agcT = (this.agcR * this.HLs);
    this.agcU = (this.agcS * this.HLs);
    bn(f2, f3);
    A(f1, this.NSM.centerX(), this.NSM.centerY());
    this.agcZ.round(this.HLr);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.agda).append(" contentRect=").append(this.yok);
    AppMethodBeat.o(164427);
  }
  
  public final void Nw(boolean paramBoolean)
  {
    AppMethodBeat.i(164430);
    View localView = this.contentView;
    if (localView != null)
    {
      removeView(localView);
      if (paramBoolean) {
        reset();
      }
      setContentView(null);
    }
    AppMethodBeat.o(164430);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, e parame, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    s.u(paramView, "view");
    s.u(paramMatrix, "matrix");
    s.u(parame, "scaleType");
    s.u(paramb, "initFinish");
    this.agcY.set(0, 0, paramInt1, paramInt2);
    this.agdr = paramb;
    this.contentView = paramView;
    this.hcd = paramMatrix;
    this.agcV = paramMatrix.isIdentity();
    this.agcW = true;
    this.agdb = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(a<ah> parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    s.u(parama, "onAnimationEnd");
    Object localObject = this.agdp;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.agcZ.centerX();
    float f3 = this.agcZ.centerY();
    float f4 = this.HLr.exactCenterX();
    float f5 = this.HLr.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.HLs });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener(new CropLayout..ExternalSyntheticLambda0(this));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new CropLayout.o(this, parama));
    if (paramAnimatorUpdateListener != null) {
      ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    }
    ((ValueAnimator)localObject).start();
    parama = ah.aiuX;
    this.agdq = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    s.u(paramMotionEvent, "e1");
    super.ap(paramMotionEvent);
    this.agde = false;
    this.agdf = false;
    this.agdc = false;
    paramMotionEvent = this.agdk;
    boolean bool1;
    int i;
    if (paramMotionEvent == null)
    {
      bool1 = false;
      if (!bool1) {
        break label110;
      }
      i = 1;
      label53:
      if (!jHA()) {
        break label116;
      }
      i = 0;
      label63:
      if (i != 0) {
        break label718;
      }
      s.X("onTouchCancel startCenterAnim == false isFling=", Boolean.valueOf(bool1));
      if (!bool1) {
        jHw();
      }
    }
    for (;;)
    {
      this.agdi = false;
      AppMethodBeat.o(164412);
      return;
      bool1 = paramMotionEvent.isStarted();
      break;
      label110:
      i = 0;
      break label53;
      label116:
      if (i == 1)
      {
        i = 0;
        break label63;
      }
      boolean bool2 = jHs();
      boolean bool3 = jHt();
      if ((bool3) && (bool2))
      {
        i = 0;
        break label63;
      }
      paramMotionEvent = this.agdk;
      if (paramMotionEvent != null) {
        paramMotionEvent.cancel();
      }
      paramMotionEvent = this.agdp;
      if (paramMotionEvent != null) {
        paramMotionEvent.cancel();
      }
      float f2 = this.agcZ.centerX();
      float f3 = this.agcZ.centerY();
      float f4 = this.NSM.centerX();
      float f5 = this.NSM.centerY();
      float f6 = getContentViewScale()[0];
      float f1 = this.NSM.width() / this.agcZ.width();
      float f7 = this.NSM.height() / this.agcZ.height();
      label275:
      Object localObject;
      PropertyValuesHolder localPropertyValuesHolder1;
      PropertyValuesHolder localPropertyValuesHolder2;
      label388:
      PropertyValuesHolder localPropertyValuesHolder3;
      if (this.agdb == e.agdt)
      {
        f1 = Math.max(f7, f1);
        localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
        localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
        localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
        f2 = this.NSM.right - this.agcZ.right;
        f3 = this.NSM.left - this.agcZ.left;
        if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
          break label670;
        }
        f1 = f3;
        localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
        f4 = this.NSM.bottom - this.agcZ.bottom;
        f5 = this.NSM.top - this.agcZ.top;
        if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
          break label693;
        }
        f1 = f5;
      }
      for (;;)
      {
        PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
        new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
        paramMotionEvent = new ah.c();
        ah.c localc = new ah.c();
        localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
        ((ValueAnimator)localObject).addUpdateListener(new CropLayout..ExternalSyntheticLambda3(this, bool3, bool2, paramMotionEvent, localc));
        ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new l(this));
        ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        ((ValueAnimator)localObject).setDuration(160L);
        ((ValueAnimator)localObject).start();
        paramMotionEvent = ah.aiuX;
        this.agdp = ((Animator)localObject);
        i = 1;
        break;
        f1 = Math.min(f7, f1);
        break label275;
        label670:
        if ((f3 > 0.0F) && (f2 > 0.0F))
        {
          f1 = f2;
          break label388;
        }
        f1 = 0.0F;
        break label388;
        label693:
        if ((f5 > 0.0F) && (f4 > 0.0F)) {
          f1 = f4;
        } else {
          f1 = 0.0F;
        }
      }
      label718:
      s.X("onTouchCancel startCenterAnim == true isFling=", Boolean.valueOf(bool1));
    }
  }
  
  public void b(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(252742);
    s.u(paramRectF, "rectF");
    float f1 = this.NSM.bottom - this.agcZ.bottom;
    float f2 = this.NSM.top;
    float f3 = this.agcZ.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      e(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.NSM.set(paramRectF);
      AppMethodBeat.o(252742);
      return;
      if ((this.agcZ.height() <= this.NSM.height()) || (paramBoolean))
      {
        z(1.0F * this.NSM.height() / this.agcZ.height(), this.agcZ.centerX(), this.agcZ.bottom);
        e(0.0F, -(this.NSM.bottom - this.agcZ.bottom), 4);
      }
    }
  }
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164409);
    if (this.NSM.isEmpty()) {
      this.NSM.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null) {
      if (this.agcW)
      {
        setShouldLayout(false);
        if (this.agcV) {
          getMainMatrix().reset();
        }
        getContentBaseRect().set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(getContentBaseRect().exactCenterX());
        ((View)localObject).setPivotY(getContentBaseRect().exactCenterY());
        getTmpRectF().set(getContentBaseRect());
        getMainMatrix().mapRect(getTmpRectF());
        getTmpRectF().round(getContentRect());
        getContentRectF().set(getTmpRectF());
        if (this.agcV)
        {
          getMainMatrix().reset();
          localObject = getScaleType();
          switch (f.$EnumSwitchMapping$0[localObject.ordinal()])
          {
          }
          while (((Boolean)getInitFinish().invoke(getMainMatrix())).booleanValue())
          {
            jHx();
            getContentRectF().round(getContentCenterRect());
            AppMethodBeat.o(164409);
            return;
            m(getVisibilityRect());
            continue;
            l(getVisibilityRect());
            continue;
            k(getVisibilityRect());
          }
        }
        if (((Boolean)getInitFinish().invoke(getMainMatrix())).booleanValue())
        {
          jHx();
          getContentRectF().round(getContentCenterRect());
          AppMethodBeat.o(164409);
        }
      }
      else if (paramBoolean)
      {
        localObject = getScaleType();
        switch (f.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164409);
      return;
      m(getVisibilityRect());
      AppMethodBeat.o(164409);
      return;
      l(getVisibilityRect());
      AppMethodBeat.o(164409);
      return;
      k(getVisibilityRect());
    }
  }
  
  public final View.OnClickListener getClickListener()
  {
    return this.fhU;
  }
  
  protected final Rect getContentBaseRect()
  {
    return this.agda;
  }
  
  public final Rect getContentCenterRect()
  {
    return this.HLr;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.agcY;
  }
  
  public final Rect getContentRect()
  {
    return this.yok;
  }
  
  public final RectF getContentRectF()
  {
    return this.agcZ;
  }
  
  protected final View getContentView()
  {
    return this.contentView;
  }
  
  public final float[] getContentViewScale()
  {
    AppMethodBeat.i(164436);
    getMatrixValues();
    float f1 = this.hpa[0];
    float f2 = this.hpa[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(164436);
    return new float[] { f1, f1 };
  }
  
  public final float[] getContentViewTrans()
  {
    AppMethodBeat.i(164435);
    this.hcd.getValues(this.hpa);
    float f1 = this.hpa[2];
    float f2 = this.hpa[5];
    this.agds[0] = f1;
    this.agds[1] = f2;
    float[] arrayOfFloat = this.agds;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  public final b getCropLayoutTouchListener()
  {
    return this.agcQ;
  }
  
  protected final b<Matrix, Boolean> getInitFinish()
  {
    return this.agdr;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.hcd;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.agcS;
  }
  
  public final float getMaxScaleValue()
  {
    return this.agcU;
  }
  
  public final float getMinScaleFactor()
  {
    return this.agcR;
  }
  
  public final float getMinScaleValue()
  {
    return this.agcT;
  }
  
  public final c getOnChangeListener()
  {
    return this.UhU;
  }
  
  public final e getScaleType()
  {
    return this.agdb;
  }
  
  protected final RectF getTmpRectF()
  {
    return this.dzQ;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.NSM;
  }
  
  public final Rect getWidgetRect()
  {
    return this.agcX;
  }
  
  protected final boolean jHo()
  {
    return this.agcW;
  }
  
  protected final boolean jHp()
  {
    return this.agdc;
  }
  
  public final void jHq()
  {
    AppMethodBeat.i(252778);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    localValueAnimator.addUpdateListener(new CropLayout..ExternalSyntheticLambda1(this, new ah.c()));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(252778);
  }
  
  public final void jHr()
  {
    AppMethodBeat.i(252783);
    float f = -getRotateDegrees();
    s.X("[onRevertRotate] currentDegrees=", Float.valueOf(f));
    if (f == 0.0F) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(252783);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    localValueAnimator.addUpdateListener(new CropLayout..ExternalSyntheticLambda2(this, new ah.c()));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(252783);
  }
  
  protected final boolean jHt()
  {
    AppMethodBeat.i(164422);
    if (this.agcZ.height() > this.NSM.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.agdn != true)) {
        this.agdf = true;
      }
      this.agdn = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  protected final void jHx()
  {
    int j = 1;
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    float[] arrayOfFloat;
    float f;
    int i;
    if (localObject != null)
    {
      arrayOfFloat = getMatrixValues();
      f = getContentViewScale()[0];
      if (f != (1.0F / -1.0F)) {
        break label160;
      }
      i = 1;
      if (i == 0)
      {
        if (f != (1.0F / 1.0F)) {
          break label165;
        }
        i = j;
        label56:
        if ((i == 0) && (!Float.isNaN(f))) {
          break label170;
        }
      }
      s.X("return apply scale is ", Float.valueOf(f));
    }
    for (;;)
    {
      localObject = this.contentView;
      if (localObject != null)
      {
        getTmpRectF().set(getContentBaseRect());
        ((View)localObject).getMatrix().mapRect(getTmpRectF());
        getContentRectF().set(getTmpRectF());
        getTmpRectF().round(getContentRect());
      }
      localObject = this.UhU;
      if (localObject != null) {
        ((c)localObject).onChange();
      }
      AppMethodBeat.o(164434);
      return;
      label160:
      i = 0;
      break;
      label165:
      i = 0;
      break label56;
      label170:
      ((View)localObject).setRotation(getRotateDegrees());
      ((View)localObject).setPivotX(0.0F);
      ((View)localObject).setPivotY(0.0F);
      ((View)localObject).setScaleX(f);
      ((View)localObject).setScaleY(f);
      ((View)localObject).setTranslationX(arrayOfFloat[2]);
      ((View)localObject).setTranslationY(arrayOfFloat[5]);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164411);
    super.onDown(paramMotionEvent);
    paramMotionEvent = this.UhU;
    if ((paramMotionEvent instanceof d)) {}
    for (paramMotionEvent = (d)paramMotionEvent;; paramMotionEvent = null)
    {
      if (paramMotionEvent != null) {
        paramMotionEvent.hSY();
      }
      paramMotionEvent = this.agdk;
      if (paramMotionEvent != null) {
        paramMotionEvent.cancel();
      }
      paramMotionEvent = this.agdo;
      if (paramMotionEvent != null) {
        paramMotionEvent.cancel();
      }
      AppMethodBeat.o(164411);
      return true;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164420);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if (!jHz())
    {
      AppMethodBeat.o(164420);
      return false;
    }
    float f2 = 0.5F * paramFloat1;
    float f1 = 0.5F * paramFloat2;
    if ((this.agdd) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = jHu();
    boolean bool2 = jHv();
    boolean bool3 = jHs();
    boolean bool4 = jHt();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.agcZ.left < this.NSM.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.agcZ.right <= this.NSM.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.agdb == e.agdt) || (this.agdb == e.agdv))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.agcZ.top < this.NSM.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.agcZ.bottom <= this.NSM.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.agdb == e.agdt) || (this.agdb == e.agdv))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.agdk;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.agdl[0] = 0.0F;
    this.agdl[1] = 0.0F;
    f1 = this.agcZ.right;
    f2 = this.NSM.right;
    float f3 = this.NSM.left;
    float f4 = this.agcZ.left;
    if (paramFloat1 < 0.0F)
    {
      this.agdl[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.agcZ.bottom;
      f2 = this.NSM.bottom;
      f3 = this.NSM.top;
      f4 = this.agcZ.top;
      if (paramFloat2 >= 0.0F) {
        break label714;
      }
      this.agdl[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.agdl;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new CropLayout.i(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      paramMotionEvent2 = ah.aiuX;
      this.agdk = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.agdl[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label714:
      this.agdl[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.agcX.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.agcW = true;
    }
    e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164407);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164416);
    s.u(paramScaleGestureDetector, "detector");
    z(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    AppMethodBeat.o(164416);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164413);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if (jHB()) {
      e(paramFloat1, paramFloat2, 0);
    }
    AppMethodBeat.o(164413);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252750);
    s.u(paramMotionEvent, "e");
    View.OnClickListener localOnClickListener = this.fhU;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((View)this);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(252750);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    s.u(paramView, "v");
    s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.agdd = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.agdd = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.NSM.setEmpty();
    this.yok.setEmpty();
    this.agcZ.setEmpty();
    this.HLr.setEmpty();
    this.agda.setEmpty();
    this.dzQ.setEmpty();
    this.hcd = new Matrix();
    this.HLs = 1.0F;
    this.agcT = 1.0F;
    this.agcU = 1.0F;
    this.agcS = 5.0F;
    this.agcR = 0.25F;
    this.agdg = 0.0F;
    this.agdh = 0.0F;
    this.agds[0] = 0.0F;
    this.agds[1] = 0.0F;
    this.agcV = true;
    this.agcW = false;
    this.agdc = true;
    this.agdr = ((b)CropLayout.j.agdz);
    this.hpa = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.fhU = paramOnClickListener;
  }
  
  protected final void setContentBaseRect(Rect paramRect)
  {
    AppMethodBeat.i(252715);
    s.u(paramRect, "<set-?>");
    this.agda = paramRect;
    AppMethodBeat.o(252715);
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    s.u(paramRect, "<set-?>");
    this.HLr = paramRect;
    AppMethodBeat.o(164404);
  }
  
  protected final void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.agcQ = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.agdc = paramBoolean;
  }
  
  protected final void setInitFinish(b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(252807);
    s.u(paramb, "<set-?>");
    this.agdr = paramb;
    AppMethodBeat.o(252807);
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    s.u(paramMatrix, "<set-?>");
    this.hcd = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.agcS = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.agcU = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.agcR = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.agcT = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.UhU = paramc;
  }
  
  public final void setScaleType(e parame)
  {
    AppMethodBeat.i(164405);
    s.u(parame, "<set-?>");
    this.agdb = parame;
    AppMethodBeat.o(164405);
  }
  
  protected final void setShouldLayout(boolean paramBoolean)
  {
    this.agcW = paramBoolean;
  }
  
  protected final void z(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.agcT) || (getContentViewScale()[0] * paramFloat1 > this.agcU))
    {
      if (!this.agdi)
      {
        performHapticFeedback(0, 2);
        this.agdi = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      A(paramFloat1, paramFloat2, paramFloat3);
      this.agdg = paramFloat2;
      this.agdh = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onScroll(float paramFloat1, float paramFloat2);
    
    public abstract void s(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void hSY();
    
    public abstract void hSZ();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    static
    {
      AppMethodBeat.i(164380);
      agdt = new e("CENTER_CROP", 0);
      agdu = new e("CENTER_INSIDE", 1);
      agdv = new e("ALIGN_START", 2);
      agdw = new e[] { agdt, agdu, agdv };
      AppMethodBeat.o(164380);
    }
    
    private e() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float cxM;
    private float cxN;
    
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(252505);
      s.u(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(252505);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(252505);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(this.agdy, this.cxM - f1, this.cxN - f2);
      this.cxM = f1;
      this.cxN = f2;
      AppMethodBeat.o(252505);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements Animator.AnimatorListener
  {
    l(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252532);
      paramAnimator = this.agdy.getOnChangeListener();
      if ((paramAnimator instanceof CropLayout.d)) {}
      for (paramAnimator = (CropLayout.d)paramAnimator;; paramAnimator = null)
      {
        if (paramAnimator != null) {
          paramAnimator.hSZ();
        }
        AppMethodBeat.o(252532);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int EHM;
    private int Grf;
    
    m(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(252527);
      s.u(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(252527);
        throw paramValueAnimator;
      }
      int i = ((Integer)localObject).intValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(252527);
        throw paramValueAnimator;
      }
      int j = ((Integer)paramValueAnimator).intValue();
      CropLayout.b(this.agdy, i - this.Grf, j - this.EHM);
      this.Grf = i;
      this.EHM = j;
      AppMethodBeat.o(252527);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements Animator.AnimatorListener
  {
    n(Animator.AnimatorListener paramAnimatorListener, CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(252546);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.agdB;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationCancel(paramAnimator);
      }
      AppMethodBeat.o(252546);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252542);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.agdB;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationEnd(paramAnimator);
      }
      paramAnimator = jdField_this.getOnChangeListener();
      if ((paramAnimator instanceof CropLayout.d)) {}
      for (paramAnimator = (CropLayout.d)paramAnimator;; paramAnimator = null)
      {
        if (paramAnimator != null) {
          paramAnimator.hSZ();
        }
        AppMethodBeat.o(252542);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(252536);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.agdB;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(252536);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(252550);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.agdB;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(252550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */