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
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.y.c;
import d.v;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "contentBaseRect", "Landroid/graphics/Rect;", "contentCenterRect", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onSingleTapUp", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "setContentView", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final CropLayout.a LrK;
  private c Cer;
  private final float[] LrA;
  private Animator LrB;
  private final float[] LrC;
  private boolean LrD;
  private boolean LrE;
  private Animator LrF;
  private Animator LrG;
  private Animator LrH;
  private b<? super Matrix, Boolean> LrI;
  private final float[] LrJ;
  private b Lrh;
  private float Lri;
  private float Lrj;
  private float Lrk;
  private float Lrl;
  private boolean Lrm;
  private boolean Lrn;
  private final Rect Lro;
  private final Rect Lrp;
  private final RectF Lrq;
  private Rect Lrr;
  private e Lrs;
  boolean Lrt;
  private boolean Lru;
  private boolean Lrv;
  private boolean Lrw;
  private float Lrx;
  private float Lry;
  private boolean Lrz;
  private View.OnClickListener cNE;
  private Matrix cQC;
  private View contentView;
  private final Rect qfO;
  private final Matrix rJ;
  private Rect tVU;
  private float tVV;
  private final RectF vR;
  private float[] values;
  private final RectF xYr;
  
  static
  {
    AppMethodBeat.i(164441);
    LrK = new CropLayout.a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.cQC = new Matrix();
    this.Lri = 0.25F;
    this.Lrj = 5.0F;
    this.Lrk = 1.0F;
    this.Lrl = 1.0F;
    this.Lrm = true;
    this.tVV = 1.0F;
    this.xYr = new RectF();
    this.Lro = new Rect();
    this.Lrp = new Rect();
    this.qfO = new Rect();
    this.Lrq = new RectF();
    this.Lrr = new Rect();
    this.tVU = new Rect();
    this.Lrs = e.LrL;
    this.Lrt = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.LrA = new float[2];
    this.LrC = new float[2];
    this.LrI = ((b)CropLayout.f.LrP);
    this.vR = new RectF();
    this.LrJ = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.cQC = new Matrix();
    this.Lri = 0.25F;
    this.Lrj = 5.0F;
    this.Lrk = 1.0F;
    this.Lrl = 1.0F;
    this.Lrm = true;
    this.tVV = 1.0F;
    this.xYr = new RectF();
    this.Lro = new Rect();
    this.Lrp = new Rect();
    this.qfO = new Rect();
    this.Lrq = new RectF();
    this.Lrr = new Rect();
    this.tVU = new Rect();
    this.Lrs = e.LrL;
    this.Lrt = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.LrA = new float[2];
    this.LrC = new float[2];
    this.LrI = ((b)CropLayout.f.LrP);
    this.vR = new RectF();
    this.LrJ = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.cQC = new Matrix();
    this.Lri = 0.25F;
    this.Lrj = 5.0F;
    this.Lrk = 1.0F;
    this.Lrl = 1.0F;
    this.Lrm = true;
    this.tVV = 1.0F;
    this.xYr = new RectF();
    this.Lro = new Rect();
    this.Lrp = new Rect();
    this.qfO = new Rect();
    this.Lrq = new RectF();
    this.Lrr = new Rect();
    this.tVU = new Rect();
    this.Lrs = e.LrL;
    this.Lrt = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.LrA = new float[2];
    this.LrC = new float[2];
    this.LrI = ((b)CropLayout.f.LrP);
    this.vR = new RectF();
    this.LrJ = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void ar(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.Lrh;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.cQC.postTranslate(-paramFloat1, -paramFloat2);
    fQq();
    AppMethodBeat.o(164433);
  }
  
  private final void bW(float paramFloat)
  {
    AppMethodBeat.i(193894);
    this.cQC.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    fQq();
    AppMethodBeat.o(193894);
  }
  
  private final void d(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      ar(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (fQl())
    {
      f = paramFloat1;
      if (fQn()) {
        f = paramFloat1 * 0.4F;
      }
      if (!fQm()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!fQo()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      ar(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private boolean fQl()
  {
    AppMethodBeat.i(164421);
    if (this.Lrq.width() > this.xYr.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.LrD != true)) {
        this.Lrv = true;
      }
      this.LrD = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private boolean fQn()
  {
    return (this.xYr.left < this.Lrq.left) || (this.xYr.right > this.Lrq.right);
  }
  
  private boolean fQo()
  {
    return (this.xYr.top < this.Lrq.top) || (this.xYr.bottom > this.Lrq.bottom);
  }
  
  private void fQp()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.LrF;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.Lsv)
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.Lrq.left - this.xYr.left);
    int j = (int)(this.Lrq.top - this.xYr.top);
    int m = (int)(this.xYr.right - this.Lrq.right);
    int k = (int)(this.xYr.bottom - this.Lrq.bottom);
    if ((fQn()) && (i > 0)) {
      if (fQl())
      {
        if ((!fQo()) || (j <= 0)) {
          break label287;
        }
        if (!fQm()) {
          break label267;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        c localc = this.Cer;
        localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          ((d)localObject).ewX();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.Lrq.centerX() - this.xYr.centerX());
          break;
          if ((fQn()) && (m > 0))
          {
            if (fQl())
            {
              i = -m;
              break;
            }
            i = (int)(this.Lrq.centerX() - this.xYr.centerX());
            break;
          }
          i = 0;
          break;
          label267:
          j = (int)(this.Lrq.centerY() - this.xYr.centerY());
          continue;
          label287:
          if ((fQo()) && (k > 0))
          {
            if (fQm())
            {
              j = -k;
              continue;
            }
            j = (int)(this.Lrq.centerY() - this.xYr.centerY());
            continue;
          }
          j = 0;
          continue;
        }
        AppMethodBeat.o(164423);
        return;
      }
    }
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("transX", new int[] { 0, i }), PropertyValuesHolder.ofInt("transY", new int[] { 0, j }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new p(this));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(160L);
    ((ValueAnimator)localObject).start();
    this.LrF = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private final void fQq()
  {
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    if (localObject != null)
    {
      float[] arrayOfFloat = getMatrixValues();
      float f = getContentViewScale()[0];
      d.g.b.l locall = d.g.b.l.NiP;
      if (f != d.g.b.l.gkA())
      {
        ((View)localObject).setRotation(getRotateDegrees());
        ((View)localObject).setPivotX(0.0F);
        ((View)localObject).setPivotY(0.0F);
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
        ((View)localObject).setTranslationX(arrayOfFloat[2]);
        ((View)localObject).setTranslationY(arrayOfFloat[5]);
      }
    }
    localObject = this.contentView;
    if (localObject != null)
    {
      this.vR.set(this.Lrr);
      ((View)localObject).getMatrix().mapRect(this.vR);
      this.Lrq.set(this.vR);
      this.vR.round(this.qfO);
    }
    localObject = this.Cer;
    if (localObject != null)
    {
      ((c)localObject).onChange();
      AppMethodBeat.o(164434);
      return;
    }
    AppMethodBeat.o(164434);
  }
  
  private final float[] getContentViewTrans()
  {
    AppMethodBeat.i(164435);
    this.cQC.getValues(this.values);
    float f1 = this.values[2];
    float f2 = this.values[5];
    this.LrJ[0] = f1;
    this.LrJ[1] = f2;
    float[] arrayOfFloat = this.LrJ;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.cQC.getValues(this.values);
    float[] arrayOfFloat = this.values;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Float.isNaN(arrayOfFloat[j]))
        {
          new StringBuilder("MatrixValues Error! index=").append(i).append(" value=").append(this.values[i]);
          this.values[i] = 1.0F;
        }
      }
      else
      {
        arrayOfFloat = this.values;
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
        ((Matrix)localObject).getValues(this.values);
      }
    }
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164419);
    return f;
  }
  
  private final float getRotateDegrees()
  {
    AppMethodBeat.i(164418);
    this.cQC.getValues(this.values);
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private void j(RectF paramRectF)
  {
    AppMethodBeat.i(193893);
    p.h(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.Lrr.width(), paramRectF.height() * 1.0F / this.Lrr.height());
    float f2;
    float f1;
    if (this.Lrq.height() > this.xYr.height())
    {
      f2 = this.Lrq.centerX() - this.xYr.centerX();
      f1 = this.Lrq.top - this.xYr.top;
    }
    for (;;)
    {
      this.tVV = f3;
      this.Lrk = (this.Lri * this.tVV);
      this.Lrl = (this.Lrj * this.tVV);
      ar(f2, f1);
      r(f3, this.xYr.centerX(), this.xYr.centerY());
      this.Lrq.round(this.tVU);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.Lrr).append(" contentRect=").append(this.qfO);
      AppMethodBeat.o(193893);
      return;
      if (this.Lrq.width() > this.xYr.width())
      {
        f2 = this.Lrq.left - this.xYr.left;
        f1 = this.Lrq.centerY() - this.xYr.centerY();
      }
      else
      {
        f2 = this.Lrq.centerX() - this.xYr.centerX();
        f1 = this.Lrq.centerY() - this.xYr.centerY();
      }
    }
  }
  
  private void k(RectF paramRectF)
  {
    AppMethodBeat.i(164426);
    p.h(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.Lrr.width(), paramRectF.height() * 1.0F / this.Lrr.height());
    float f2 = this.Lrq.centerX() - this.xYr.centerX();
    float f3 = this.Lrq.centerY() - this.xYr.centerY();
    this.tVV = f1;
    this.Lrk = (this.Lri * this.tVV);
    this.Lrl = (this.Lrj * this.tVV);
    ar(f2, f3);
    r(f1, this.xYr.centerX(), this.xYr.centerY());
    this.Lrq.round(this.tVU);
    new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.Lrr).append(" contentRect=").append(this.qfO);
    AppMethodBeat.o(164426);
  }
  
  private void l(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    p.h(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.Lrr.width(), paramRectF.height() * 1.0F / this.Lrr.height());
    float f2 = this.Lrq.centerX() - this.xYr.centerX();
    float f3 = this.Lrq.centerY() - this.xYr.centerY();
    this.tVV = f1;
    this.Lrk = (this.Lri * this.tVV);
    this.Lrl = (this.Lrj * this.tVV);
    ar(f2, f3);
    r(f1, this.xYr.centerX(), this.xYr.centerY());
    this.Lrq.round(this.tVU);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.Lrr).append(" contentRect=").append(this.qfO);
    AppMethodBeat.o(164427);
  }
  
  private final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.Lrq.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.Lrq.left) / this.Lrq.width();
    float f2 = (paramFloat3 - this.Lrq.top) / this.Lrq.height();
    bW(paramFloat1);
    b localb = this.Lrh;
    if (localb != null) {
      localb.l(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.Lrq.left;
    float f3 = this.Lrq.width();
    float f4 = this.Lrq.top;
    float f5 = this.Lrq.height();
    this.cQC.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    fQq();
    AppMethodBeat.o(164432);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, e parame, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    p.h(paramView, "view");
    p.h(paramMatrix, "matrix");
    p.h(parame, "scaleType");
    p.h(paramb, "initFinish");
    this.Lrp.set(0, 0, paramInt1, paramInt2);
    this.LrI = paramb;
    this.contentView = paramView;
    this.cQC = paramMatrix;
    this.Lrm = paramMatrix.isIdentity();
    this.Lrn = true;
    this.Lrs = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<z> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    p.h(parama, "onAnimationEnd");
    Object localObject = this.LrG;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.Lrq.centerX();
    float f3 = this.Lrq.centerY();
    float f4 = this.tVU.exactCenterX();
    float f5 = this.tVU.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.tVV });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new q(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new r(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    ((ValueAnimator)localObject).start();
    this.LrH = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ai(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    p.h(paramMotionEvent, "e1");
    super.ai(paramMotionEvent);
    this.Lrv = false;
    this.Lrw = false;
    this.Lrt = false;
    paramMotionEvent = this.LrB;
    boolean bool1;
    int i;
    if (paramMotionEvent != null)
    {
      bool1 = paramMotionEvent.isStarted();
      if (!bool1) {
        break label98;
      }
      i = 1;
      label56:
      if (!this.Lsv) {
        break label104;
      }
      i = 0;
    }
    label98:
    label104:
    final boolean bool2;
    final boolean bool3;
    for (;;)
    {
      if ((i == 0) && (!bool1)) {
        fQp();
      }
      this.Lrz = false;
      AppMethodBeat.o(164412);
      return;
      bool1 = false;
      break;
      i = 0;
      break label56;
      if (i == 1)
      {
        i = 0;
      }
      else
      {
        bool2 = fQl();
        bool3 = fQm();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.LrB;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.LrG;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.Lrq.centerX();
    float f3 = this.Lrq.centerY();
    float f4 = this.xYr.centerX();
    float f5 = this.xYr.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.xYr.width() / this.Lrq.width();
    float f7 = this.xYr.height() / this.Lrq.height();
    label263:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label376:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.Lrs == e.LrL)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.xYr.right - this.Lrq.right;
      f3 = this.xYr.left - this.Lrq.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label675;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.xYr.bottom - this.Lrq.bottom;
      f5 = this.xYr.top - this.Lrq.top;
      if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
        break label698;
      }
      f1 = f5;
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
      new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
      paramMotionEvent = new y.c();
      paramMotionEvent.NiV = 0.0F;
      final y.c localc = new y.c();
      localc.NiV = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new n(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.LrG = ((Animator)localObject);
      i = 1;
      break;
      f1 = Math.min(f7, f1);
      break label263;
      label675:
      if ((f3 > 0.0F) && (f2 > 0.0F))
      {
        f1 = f2;
        break label376;
      }
      f1 = 0.0F;
      break label376;
      label698:
      if ((f5 > 0.0F) && (f4 > 0.0F)) {
        f1 = f4;
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  public final void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164409);
    if (this.xYr.isEmpty()) {
      this.xYr.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.Lrn)
      {
        this.Lrn = false;
        if (this.Lrm) {
          this.cQC.reset();
        }
        this.Lrr.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.Lrr.exactCenterX());
        ((View)localObject).setPivotY(this.Lrr.exactCenterY());
        this.vR.set(this.Lrr);
        this.cQC.mapRect(this.vR);
        this.vR.round(this.qfO);
        this.Lrq.set(this.vR);
        if (this.Lrm)
        {
          this.cQC.reset();
          localObject = this.Lrs;
          switch (a.cqt[localObject.ordinal()])
          {
          }
          while (((Boolean)this.LrI.invoke(this.cQC)).booleanValue())
          {
            fQq();
            this.Lrq.round(this.tVU);
            AppMethodBeat.o(164409);
            return;
            l(this.xYr);
            continue;
            k(this.xYr);
            continue;
            j(this.xYr);
          }
        }
        if (((Boolean)this.LrI.invoke(this.cQC)).booleanValue())
        {
          fQq();
          this.Lrq.round(this.tVU);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.Lrs;
        switch (a.gpL[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        l(this.xYr);
        AppMethodBeat.o(164409);
        return;
        k(this.xYr);
        AppMethodBeat.o(164409);
        return;
        j(this.xYr);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final void fQj()
  {
    AppMethodBeat.i(193891);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    y.c localc = new y.c();
    localc.NiV = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new j(localc, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(193891);
  }
  
  public final void fQk()
  {
    AppMethodBeat.i(193892);
    final float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(193892);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    y.c localc = new y.c();
    localc.NiV = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(localc, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(193892);
  }
  
  protected final boolean fQm()
  {
    AppMethodBeat.i(164422);
    if (this.Lrq.height() > this.xYr.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.LrE != true)) {
        this.Lrw = true;
      }
      this.LrE = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  public final View.OnClickListener getClickListener()
  {
    return this.cNE;
  }
  
  public final Rect getContentCenterRect()
  {
    return this.tVU;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.Lrp;
  }
  
  public final Rect getContentRect()
  {
    return this.qfO;
  }
  
  public final RectF getContentRectF()
  {
    return this.Lrq;
  }
  
  public final float[] getContentViewScale()
  {
    AppMethodBeat.i(164436);
    getMatrixValues();
    float f1 = this.values[0];
    float f2 = this.values[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(164436);
    return new float[] { f1, f1 };
  }
  
  public final b getCropLayoutTouchListener()
  {
    return this.Lrh;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cQC;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.Lrj;
  }
  
  public final float getMaxScaleValue()
  {
    return this.Lrl;
  }
  
  public final float getMinScaleFactor()
  {
    return this.Lri;
  }
  
  public final float getMinScaleValue()
  {
    return this.Lrk;
  }
  
  public final c getOnChangeListener()
  {
    return this.Cer;
  }
  
  public final e getScaleType()
  {
    return this.Lrs;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.xYr;
  }
  
  public final Rect getWidgetRect()
  {
    return this.Lro;
  }
  
  public final void i(RectF paramRectF)
  {
    AppMethodBeat.i(164408);
    p.h(paramRectF, "rectF");
    float f1 = this.xYr.bottom - this.Lrq.bottom;
    float f2 = this.xYr.top;
    float f3 = this.Lrq.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      d(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.xYr.set(paramRectF);
      AppMethodBeat.o(164408);
      return;
      if (this.Lrq.height() <= this.xYr.height())
      {
        q(1.0F * this.xYr.height() / this.Lrq.height(), this.Lrq.centerX(), this.Lrq.bottom);
        d(0.0F, -(this.xYr.bottom - this.Lrq.bottom), 4);
      }
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164411);
    super.onDown(paramMotionEvent);
    c localc = this.Cer;
    paramMotionEvent = localc;
    if (!(localc instanceof d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (d)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.ewW();
    }
    paramMotionEvent = this.LrB;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.LrF;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    AppMethodBeat.o(164411);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164420);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    float f2 = 0.5F * paramFloat1;
    float f1 = 0.5F * paramFloat2;
    if ((this.Lru) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = fQn();
    boolean bool2 = fQo();
    boolean bool3 = fQl();
    boolean bool4 = fQm();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.Lrq.left < this.xYr.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.Lrq.right <= this.xYr.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.Lrs == e.LrL) || (this.Lrs == e.LrN))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.Lrq.top < this.xYr.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.Lrq.bottom <= this.xYr.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.Lrs == e.LrL) || (this.Lrs == e.LrN))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.LrB;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.LrC[0] = 0.0F;
    this.LrC[1] = 0.0F;
    f1 = this.Lrq.right;
    f2 = this.xYr.right;
    float f3 = this.xYr.left;
    float f4 = this.Lrq.left;
    if (paramFloat1 < 0.0F)
    {
      this.LrC[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.Lrq.bottom;
      f2 = this.xYr.bottom;
      f3 = this.xYr.top;
      f4 = this.Lrq.top;
      if (paramFloat2 >= 0.0F) {
        break label695;
      }
      this.LrC[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.LrC;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new h(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.LrB = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.LrC[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label695:
      this.LrC[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.Lro.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.Lrn = true;
    }
    e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164407);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164416);
    p.h(paramScaleGestureDetector, "detector");
    q(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    AppMethodBeat.o(164416);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164413);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    d(paramFloat1, paramFloat2, 0);
    AppMethodBeat.o(164413);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193890);
    p.h(paramMotionEvent, "e");
    View.OnClickListener localOnClickListener = this.cNE;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((View)this);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(193890);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.Lru = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.Lru = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  protected final void q(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.Lrk) || (getContentViewScale()[0] * paramFloat1 > this.Lrl))
    {
      if (!this.Lrz)
      {
        performHapticFeedback(0, 2);
        this.Lrz = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      r(paramFloat1, paramFloat2, paramFloat3);
      this.Lrx = paramFloat2;
      this.Lry = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.xYr.setEmpty();
    this.qfO.setEmpty();
    this.Lrq.setEmpty();
    this.tVU.setEmpty();
    this.Lrr.setEmpty();
    this.vR.setEmpty();
    this.cQC = new Matrix();
    this.tVV = 1.0F;
    this.Lrk = 1.0F;
    this.Lrl = 1.0F;
    this.Lrj = 5.0F;
    this.Lri = 0.25F;
    this.Lrx = 0.0F;
    this.Lry = 0.0F;
    this.LrJ[0] = 0.0F;
    this.LrJ[1] = 0.0F;
    this.Lrm = true;
    this.Lrn = false;
    this.Lrt = true;
    this.LrI = ((b)CropLayout.k.LrU);
    this.values = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cNE = paramOnClickListener;
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    p.h(paramRect, "<set-?>");
    this.tVU = paramRect;
    AppMethodBeat.o(164404);
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.Lrh = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.Lrt = paramBoolean;
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    p.h(paramMatrix, "<set-?>");
    this.cQC = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.Lrj = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.Lrl = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.Lri = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.Lrk = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.Cer = paramc;
  }
  
  public final void setScaleType(e parame)
  {
    AppMethodBeat.i(164405);
    p.h(parame, "<set-?>");
    this.Lrs = parame;
    AppMethodBeat.o(164405);
  }
  
  public final void za(boolean paramBoolean)
  {
    AppMethodBeat.i(164430);
    View localView = this.contentView;
    if (localView != null)
    {
      removeView(localView);
      if (paramBoolean) {
        reset();
      }
      this.contentView = null;
      AppMethodBeat.o(164430);
      return;
    }
    AppMethodBeat.o(164430);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void l(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void onScroll(float paramFloat1, float paramFloat2);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"})
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void ewW();
    
    public abstract void ewX();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(164380);
      e locale1 = new e("CENTER_CROP", 0);
      LrL = locale1;
      e locale2 = new e("CENTER_INSIDE", 1);
      LrM = locale2;
      e locale3 = new e("ALIGN_START", 2);
      LrN = locale3;
      LrO = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(164380);
    }
    
    private e() {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float aTL;
    private float aTM;
    
    g(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164386);
      p.h(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164386);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164386);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(this.LrQ, this.aTL - f1, this.aTM - f2);
      this.aTL = f1;
      this.aTM = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164387);
      CropLayout.a(this.LrQ);
      AppMethodBeat.o(164387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
  static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(y.c paramc, CropLayout paramCropLayout, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164388);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164388);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(jdField_this, f - this.LrR.NiV);
      this.LrR.NiV = f;
      AppMethodBeat.o(164388);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRotate$1$1"})
  static final class j
    implements ValueAnimator.AnimatorUpdateListener
  {
    j(y.c paramc, CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164389);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164389);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(jdField_this, f - this.LrR.NiV);
      this.LrR.NiV = f;
      AppMethodBeat.o(164389);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class m
    implements ValueAnimator.AnimatorUpdateListener
  {
    m(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, y.c paramc1, y.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.LrQ.getScaleType() == CropLayout.e.LrM) && (!bool3) && (!bool2)) || ((this.LrQ.getScaleType() == CropLayout.e.LrL) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.LrQ.getContentViewScale()[0];
        CropLayout.a(this.LrQ, f1, this.LrQ.getContentRectF().centerX(), this.LrQ.getContentRectF().centerY());
      }
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("transY");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f2 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("edgeX");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f3 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("edgeY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f4 = ((Float)paramValueAnimator).floatValue();
      float f7 = paramMotionEvent.NiV;
      float f5 = localc.NiV;
      float f8 = this.LrQ.getContentRectF().centerX();
      float f6 = this.LrQ.getContentRectF().centerY();
      paramValueAnimator = this.LrQ;
      if (bool2)
      {
        f1 = -(f3 - f7);
        if (!bool3) {
          break label407;
        }
      }
      label407:
      for (f2 = -(f4 - f5);; f2 = -(f2 - f6))
      {
        CropLayout.b(paramValueAnimator, f1, f2);
        paramMotionEvent.NiV = f3;
        localc.NiV = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    n(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, y.c paramc1, y.c paramc2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(193889);
      CropLayout.c localc = this.LrQ.getOnChangeListener();
      paramAnimator = localc;
      if (!(localc instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.ewX();
        AppMethodBeat.o(193889);
        return;
      }
      AppMethodBeat.o(193889);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int EqT;
    private int tbj;
    
    o(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164395);
      p.h(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(164395);
        throw paramValueAnimator;
      }
      int i = ((Integer)localObject).intValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(164395);
        throw paramValueAnimator;
      }
      int j = ((Integer)paramValueAnimator).intValue();
      CropLayout.b(this.LrQ, i - this.tbj, j - this.EqT);
      this.tbj = i;
      this.EqT = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Lsa;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(164398);
        return;
      }
      AppMethodBeat.o(164398);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164397);
      p.h(paramAnimator, "animation");
      Object localObject = this.Lsa;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.LrQ.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.ewX();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Lsa;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(164396);
        return;
      }
      AppMethodBeat.o(164396);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(164399);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Lsa;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
  static final class q
    implements ValueAnimator.AnimatorUpdateListener
  {
    q(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164400);
      Object localObject = paramValueAnimator.getAnimatedValue("scale");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f3 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      CropLayout.c(this.LrQ);
      f3 = f3 * 1.0F / this.LrQ.getContentViewScale()[0];
      CropLayout.b(this.LrQ, f3);
      f3 = this.LrQ.getContentRectF().centerX();
      float f4 = this.LrQ.getContentRectF().centerY();
      CropLayout.b(this.LrQ, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    r(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164402);
      this.LrQ.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164401);
          this.Lsd.Lsb.invoke();
          AppMethodBeat.o(164401);
        }
      });
      AppMethodBeat.o(164402);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */