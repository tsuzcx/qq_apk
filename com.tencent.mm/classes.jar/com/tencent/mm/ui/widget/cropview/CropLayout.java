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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "contentBaseRect", "Landroid/graphics/Rect;", "contentCenterRect", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onSingleTapUp", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "setContentView", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final CropLayout.a KVm;
  private c BMS;
  private b KUJ;
  private float KUK;
  private float KUL;
  private float KUM;
  private float KUN;
  private boolean KUO;
  private boolean KUP;
  private final Rect KUQ;
  private final Rect KUR;
  private final RectF KUS;
  private Rect KUT;
  private CropLayout.e KUU;
  boolean KUV;
  private boolean KUW;
  private boolean KUX;
  private boolean KUY;
  private float KUZ;
  private float KVa;
  private boolean KVb;
  private final float[] KVc;
  private Animator KVd;
  private final float[] KVe;
  private boolean KVf;
  private boolean KVg;
  private Animator KVh;
  private Animator KVi;
  private Animator KVj;
  private b<? super Matrix, Boolean> KVk;
  private final float[] KVl;
  private View.OnClickListener cMV;
  private Matrix cPS;
  private View contentView;
  private final Rect pZj;
  private final Matrix rJ;
  private Rect tLd;
  private float tLe;
  private final RectF vR;
  private float[] values;
  private final RectF xIw;
  
  static
  {
    AppMethodBeat.i(164441);
    KVm = new CropLayout.a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.cPS = new Matrix();
    this.KUK = 0.25F;
    this.KUL = 5.0F;
    this.KUM = 1.0F;
    this.KUN = 1.0F;
    this.KUO = true;
    this.tLe = 1.0F;
    this.xIw = new RectF();
    this.KUQ = new Rect();
    this.KUR = new Rect();
    this.pZj = new Rect();
    this.KUS = new RectF();
    this.KUT = new Rect();
    this.tLd = new Rect();
    this.KUU = CropLayout.e.KVn;
    this.KUV = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.KVc = new float[2];
    this.KVe = new float[2];
    this.KVk = ((b)CropLayout.f.KVr);
    this.vR = new RectF();
    this.KVl = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.cPS = new Matrix();
    this.KUK = 0.25F;
    this.KUL = 5.0F;
    this.KUM = 1.0F;
    this.KUN = 1.0F;
    this.KUO = true;
    this.tLe = 1.0F;
    this.xIw = new RectF();
    this.KUQ = new Rect();
    this.KUR = new Rect();
    this.pZj = new Rect();
    this.KUS = new RectF();
    this.KUT = new Rect();
    this.tLd = new Rect();
    this.KUU = CropLayout.e.KVn;
    this.KUV = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.KVc = new float[2];
    this.KVe = new float[2];
    this.KVk = ((b)CropLayout.f.KVr);
    this.vR = new RectF();
    this.KVl = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.cPS = new Matrix();
    this.KUK = 0.25F;
    this.KUL = 5.0F;
    this.KUM = 1.0F;
    this.KUN = 1.0F;
    this.KUO = true;
    this.tLe = 1.0F;
    this.xIw = new RectF();
    this.KUQ = new Rect();
    this.KUR = new Rect();
    this.pZj = new Rect();
    this.KUS = new RectF();
    this.KUT = new Rect();
    this.tLd = new Rect();
    this.KUU = CropLayout.e.KVn;
    this.KUV = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rJ = new Matrix();
    this.KVc = new float[2];
    this.KVe = new float[2];
    this.KVk = ((b)CropLayout.f.KVr);
    this.vR = new RectF();
    this.KVl = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void ar(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.KUJ;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.cPS.postTranslate(-paramFloat1, -paramFloat2);
    fLW();
    AppMethodBeat.o(164433);
  }
  
  private final void bY(float paramFloat)
  {
    AppMethodBeat.i(186637);
    this.cPS.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    fLW();
    AppMethodBeat.o(186637);
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
    if (fLR())
    {
      f = paramFloat1;
      if (fLT()) {
        f = paramFloat1 * 0.4F;
      }
      if (!fLS()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!fLU()) {}
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
  
  private boolean fLR()
  {
    AppMethodBeat.i(164421);
    if (this.KUS.width() > this.xIw.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.KVf != true)) {
        this.KUX = true;
      }
      this.KVf = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private boolean fLT()
  {
    return (this.xIw.left < this.KUS.left) || (this.xIw.right > this.KUS.right);
  }
  
  private boolean fLU()
  {
    return (this.xIw.top < this.KUS.top) || (this.xIw.bottom > this.KUS.bottom);
  }
  
  private void fLV()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.KVh;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.KVX)
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.KUS.left - this.xIw.left);
    int j = (int)(this.KUS.top - this.xIw.top);
    int m = (int)(this.xIw.right - this.KUS.right);
    int k = (int)(this.xIw.bottom - this.KUS.bottom);
    if ((fLT()) && (i > 0)) {
      if (fLR())
      {
        if ((!fLU()) || (j <= 0)) {
          break label287;
        }
        if (!fLS()) {
          break label267;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        c localc = this.BMS;
        localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          ((d)localObject).etq();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.KUS.centerX() - this.xIw.centerX());
          break;
          if ((fLT()) && (m > 0))
          {
            if (fLR())
            {
              i = -m;
              break;
            }
            i = (int)(this.KUS.centerX() - this.xIw.centerX());
            break;
          }
          i = 0;
          break;
          label267:
          j = (int)(this.KUS.centerY() - this.xIw.centerY());
          continue;
          label287:
          if ((fLU()) && (k > 0))
          {
            if (fLS())
            {
              j = -k;
              continue;
            }
            j = (int)(this.KUS.centerY() - this.xIw.centerY());
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
    this.KVh = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private final void fLW()
  {
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    if (localObject != null)
    {
      float[] arrayOfFloat = getMatrixValues();
      float f = getContentViewScale()[0];
      d.g.b.l locall = d.g.b.l.MLM;
      if (f != d.g.b.l.gfY())
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
      this.vR.set(this.KUT);
      ((View)localObject).getMatrix().mapRect(this.vR);
      this.KUS.set(this.vR);
      this.vR.round(this.pZj);
    }
    localObject = this.BMS;
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
    this.cPS.getValues(this.values);
    float f1 = this.values[2];
    float f2 = this.values[5];
    this.KVl[0] = f1;
    this.KVl[1] = f2;
    float[] arrayOfFloat = this.KVl;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.cPS.getValues(this.values);
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
    this.cPS.getValues(this.values);
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private void j(RectF paramRectF)
  {
    AppMethodBeat.i(186636);
    p.h(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.KUT.width(), paramRectF.height() * 1.0F / this.KUT.height());
    float f2;
    float f1;
    if (this.KUS.height() > this.xIw.height())
    {
      f2 = this.KUS.centerX() - this.xIw.centerX();
      f1 = this.KUS.top - this.xIw.top;
    }
    for (;;)
    {
      this.tLe = f3;
      this.KUM = (this.KUK * this.tLe);
      this.KUN = (this.KUL * this.tLe);
      ar(f2, f1);
      r(f3, this.xIw.centerX(), this.xIw.centerY());
      this.KUS.round(this.tLd);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.KUT).append(" contentRect=").append(this.pZj);
      AppMethodBeat.o(186636);
      return;
      if (this.KUS.width() > this.xIw.width())
      {
        f2 = this.KUS.left - this.xIw.left;
        f1 = this.KUS.centerY() - this.xIw.centerY();
      }
      else
      {
        f2 = this.KUS.centerX() - this.xIw.centerX();
        f1 = this.KUS.centerY() - this.xIw.centerY();
      }
    }
  }
  
  private void k(RectF paramRectF)
  {
    AppMethodBeat.i(164426);
    p.h(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.KUT.width(), paramRectF.height() * 1.0F / this.KUT.height());
    float f2 = this.KUS.centerX() - this.xIw.centerX();
    float f3 = this.KUS.centerY() - this.xIw.centerY();
    this.tLe = f1;
    this.KUM = (this.KUK * this.tLe);
    this.KUN = (this.KUL * this.tLe);
    ar(f2, f3);
    r(f1, this.xIw.centerX(), this.xIw.centerY());
    this.KUS.round(this.tLd);
    new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.KUT).append(" contentRect=").append(this.pZj);
    AppMethodBeat.o(164426);
  }
  
  private void l(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    p.h(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.KUT.width(), paramRectF.height() * 1.0F / this.KUT.height());
    float f2 = this.KUS.centerX() - this.xIw.centerX();
    float f3 = this.KUS.centerY() - this.xIw.centerY();
    this.tLe = f1;
    this.KUM = (this.KUK * this.tLe);
    this.KUN = (this.KUL * this.tLe);
    ar(f2, f3);
    r(f1, this.xIw.centerX(), this.xIw.centerY());
    this.KUS.round(this.tLd);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.KUT).append(" contentRect=").append(this.pZj);
    AppMethodBeat.o(164427);
  }
  
  private final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.KUS.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.KUS.left) / this.KUS.width();
    float f2 = (paramFloat3 - this.KUS.top) / this.KUS.height();
    bY(paramFloat1);
    b localb = this.KUJ;
    if (localb != null) {
      localb.l(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.KUS.left;
    float f3 = this.KUS.width();
    float f4 = this.KUS.top;
    float f5 = this.KUS.height();
    this.cPS.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    fLW();
    AppMethodBeat.o(164432);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, CropLayout.e parame, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    p.h(paramView, "view");
    p.h(paramMatrix, "matrix");
    p.h(parame, "scaleType");
    p.h(paramb, "initFinish");
    this.KUR.set(0, 0, paramInt1, paramInt2);
    this.KVk = paramb;
    this.contentView = paramView;
    this.cPS = paramMatrix;
    this.KUO = paramMatrix.isIdentity();
    this.KUP = true;
    this.KUU = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<z> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    p.h(parama, "onAnimationEnd");
    Object localObject = this.KVi;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.KUS.centerX();
    float f3 = this.KUS.centerY();
    float f4 = this.tLd.exactCenterX();
    float f5 = this.tLd.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.tLe });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new q(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new r(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    ((ValueAnimator)localObject).start();
    this.KVj = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ak(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    p.h(paramMotionEvent, "e1");
    super.ak(paramMotionEvent);
    this.KUX = false;
    this.KUY = false;
    this.KUV = false;
    paramMotionEvent = this.KVd;
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
      if (!this.KVX) {
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
        fLV();
      }
      this.KVb = false;
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
        bool2 = fLR();
        bool3 = fLS();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.KVd;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.KVi;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.KUS.centerX();
    float f3 = this.KUS.centerY();
    float f4 = this.xIw.centerX();
    float f5 = this.xIw.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.xIw.width() / this.KUS.width();
    float f7 = this.xIw.height() / this.KUS.height();
    label263:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label376:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.KUU == CropLayout.e.KVn)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.xIw.right - this.KUS.right;
      f3 = this.xIw.left - this.KUS.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label675;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.xIw.bottom - this.KUS.bottom;
      f5 = this.xIw.top - this.KUS.top;
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
      paramMotionEvent.MLS = 0.0F;
      final y.c localc = new y.c();
      localc.MLS = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new n(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.KVi = ((Animator)localObject);
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
    if (this.xIw.isEmpty()) {
      this.xIw.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.KUP)
      {
        this.KUP = false;
        if (this.KUO) {
          this.cPS.reset();
        }
        this.KUT.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.KUT.exactCenterX());
        ((View)localObject).setPivotY(this.KUT.exactCenterY());
        this.vR.set(this.KUT);
        this.cPS.mapRect(this.vR);
        this.vR.round(this.pZj);
        this.KUS.set(this.vR);
        if (this.KUO)
        {
          this.cPS.reset();
          localObject = this.KUU;
          switch (a.cpQ[localObject.ordinal()])
          {
          }
          while (((Boolean)this.KVk.invoke(this.cPS)).booleanValue())
          {
            fLW();
            this.KUS.round(this.tLd);
            AppMethodBeat.o(164409);
            return;
            l(this.xIw);
            continue;
            k(this.xIw);
            continue;
            j(this.xIw);
          }
        }
        if (((Boolean)this.KVk.invoke(this.cPS)).booleanValue())
        {
          fLW();
          this.KUS.round(this.tLd);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.KUU;
        switch (a.gnp[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        l(this.xIw);
        AppMethodBeat.o(164409);
        return;
        k(this.xIw);
        AppMethodBeat.o(164409);
        return;
        j(this.xIw);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final void fLP()
  {
    AppMethodBeat.i(186634);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    y.c localc = new y.c();
    localc.MLS = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CropLayout.j(localc, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(186634);
  }
  
  public final void fLQ()
  {
    AppMethodBeat.i(186635);
    float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(186635);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    y.c localc = new y.c();
    localc.MLS = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CropLayout.i(localc, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(186635);
  }
  
  protected final boolean fLS()
  {
    AppMethodBeat.i(164422);
    if (this.KUS.height() > this.xIw.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.KVg != true)) {
        this.KUY = true;
      }
      this.KVg = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  public final View.OnClickListener getClickListener()
  {
    return this.cMV;
  }
  
  public final Rect getContentCenterRect()
  {
    return this.tLd;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.KUR;
  }
  
  public final Rect getContentRect()
  {
    return this.pZj;
  }
  
  public final RectF getContentRectF()
  {
    return this.KUS;
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
    return this.KUJ;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cPS;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.KUL;
  }
  
  public final float getMaxScaleValue()
  {
    return this.KUN;
  }
  
  public final float getMinScaleFactor()
  {
    return this.KUK;
  }
  
  public final float getMinScaleValue()
  {
    return this.KUM;
  }
  
  public final c getOnChangeListener()
  {
    return this.BMS;
  }
  
  public final CropLayout.e getScaleType()
  {
    return this.KUU;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.xIw;
  }
  
  public final Rect getWidgetRect()
  {
    return this.KUQ;
  }
  
  public final void i(RectF paramRectF)
  {
    AppMethodBeat.i(164408);
    p.h(paramRectF, "rectF");
    float f1 = this.xIw.bottom - this.KUS.bottom;
    float f2 = this.xIw.top;
    float f3 = this.KUS.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      d(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.xIw.set(paramRectF);
      AppMethodBeat.o(164408);
      return;
      if (this.KUS.height() <= this.xIw.height())
      {
        q(1.0F * this.xIw.height() / this.KUS.height(), this.KUS.centerX(), this.KUS.bottom);
        d(0.0F, -(this.xIw.bottom - this.KUS.bottom), 4);
      }
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164411);
    super.onDown(paramMotionEvent);
    c localc = this.BMS;
    paramMotionEvent = localc;
    if (!(localc instanceof d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (d)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.etp();
    }
    paramMotionEvent = this.KVd;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.KVh;
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
    if ((this.KUW) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = fLT();
    boolean bool2 = fLU();
    boolean bool3 = fLR();
    boolean bool4 = fLS();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.KUS.left < this.xIw.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.KUS.right <= this.xIw.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.KUU == CropLayout.e.KVn) || (this.KUU == CropLayout.e.KVp))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.KUS.top < this.xIw.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.KUS.bottom <= this.xIw.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.KUU == CropLayout.e.KVn) || (this.KUU == CropLayout.e.KVp))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.KVd;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.KVe[0] = 0.0F;
    this.KVe[1] = 0.0F;
    f1 = this.KUS.right;
    f2 = this.xIw.right;
    float f3 = this.xIw.left;
    float f4 = this.KUS.left;
    if (paramFloat1 < 0.0F)
    {
      this.KVe[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.KUS.bottom;
      f2 = this.xIw.bottom;
      f3 = this.xIw.top;
      f4 = this.KUS.top;
      if (paramFloat2 >= 0.0F) {
        break label695;
      }
      this.KVe[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.KVe;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new h(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.KVd = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.KVe[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label695:
      this.KVe[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.KUQ.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.KUP = true;
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
    AppMethodBeat.i(186633);
    p.h(paramMotionEvent, "e");
    View.OnClickListener localOnClickListener = this.cMV;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((View)this);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(186633);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.KUW = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.KUW = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  protected final void q(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.KUM) || (getContentViewScale()[0] * paramFloat1 > this.KUN))
    {
      if (!this.KVb)
      {
        performHapticFeedback(0, 2);
        this.KVb = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      r(paramFloat1, paramFloat2, paramFloat3);
      this.KUZ = paramFloat2;
      this.KVa = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.xIw.setEmpty();
    this.pZj.setEmpty();
    this.KUS.setEmpty();
    this.tLd.setEmpty();
    this.KUT.setEmpty();
    this.vR.setEmpty();
    this.cPS = new Matrix();
    this.tLe = 1.0F;
    this.KUM = 1.0F;
    this.KUN = 1.0F;
    this.KUL = 5.0F;
    this.KUK = 0.25F;
    this.KUZ = 0.0F;
    this.KVa = 0.0F;
    this.KVl[0] = 0.0F;
    this.KVl[1] = 0.0F;
    this.KUO = true;
    this.KUP = false;
    this.KUV = true;
    this.KVk = ((b)CropLayout.k.KVw);
    this.values = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cMV = paramOnClickListener;
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    p.h(paramRect, "<set-?>");
    this.tLd = paramRect;
    AppMethodBeat.o(164404);
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.KUJ = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.KUV = paramBoolean;
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    p.h(paramMatrix, "<set-?>");
    this.cPS = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.KUL = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.KUN = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.KUK = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.KUM = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.BMS = paramc;
  }
  
  public final void setScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(164405);
    p.h(parame, "<set-?>");
    this.KUU = parame;
    AppMethodBeat.o(164405);
  }
  
  public final void yM(boolean paramBoolean)
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void l(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void onScroll(float paramFloat1, float paramFloat2);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"})
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void etp();
    
    public abstract void etq();
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
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
      CropLayout.a(this.KVs, this.aTL - f1, this.aTM - f2);
      this.aTL = f1;
      this.aTM = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164387);
      CropLayout.a(this.KVs);
      AppMethodBeat.o(164387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class m
    implements ValueAnimator.AnimatorUpdateListener
  {
    m(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, y.c paramc1, y.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.KVs.getScaleType() == CropLayout.e.KVo) && (!bool3) && (!bool2)) || ((this.KVs.getScaleType() == CropLayout.e.KVn) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.KVs.getContentViewScale()[0];
        CropLayout.a(this.KVs, f1, this.KVs.getContentRectF().centerX(), this.KVs.getContentRectF().centerY());
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
      float f7 = paramMotionEvent.MLS;
      float f5 = localc.MLS;
      float f8 = this.KVs.getContentRectF().centerX();
      float f6 = this.KVs.getContentRectF().centerY();
      paramValueAnimator = this.KVs;
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
        paramMotionEvent.MLS = f3;
        localc.MLS = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    n(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, y.c paramc1, y.c paramc2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(186632);
      CropLayout.c localc = this.KVs.getOnChangeListener();
      paramAnimator = localc;
      if (!(localc instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.etq();
        AppMethodBeat.o(186632);
        return;
      }
      AppMethodBeat.o(186632);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int DYR;
    private int sPW;
    
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
      CropLayout.b(this.KVs, i - this.sPW, j - this.DYR);
      this.sPW = i;
      this.DYR = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.KVC;
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
      Object localObject = this.KVC;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.KVs.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.etq();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.KVC;
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
      Animator.AnimatorListener localAnimatorListener = this.KVC;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
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
      CropLayout.c(this.KVs);
      f3 = f3 * 1.0F / this.KVs.getContentViewScale()[0];
      CropLayout.b(this.KVs, f3);
      f3 = this.KVs.getContentRectF().centerX();
      float f4 = this.KVs.getContentRectF().centerY();
      CropLayout.b(this.KVs, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    r(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164402);
      this.KVs.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164401);
          this.KVF.KVD.invoke();
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