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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.g.b.v.c;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "contentBaseRect", "Landroid/graphics/Rect;", "contentCenterRect", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDown", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "setContentView", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final CropLayout.a Jee;
  private c AsK;
  private b JdB;
  private float JdC;
  private float JdD;
  private float JdE;
  private float JdF;
  private boolean JdG;
  private boolean JdH;
  private final Rect JdI;
  private final Rect JdJ;
  private final RectF JdK;
  private Rect JdL;
  private e JdM;
  boolean JdN;
  private boolean JdO;
  private boolean JdP;
  private boolean JdQ;
  private float JdR;
  private float JdS;
  private boolean JdT;
  private final float[] JdU;
  private Animator JdV;
  private final float[] JdW;
  private boolean JdX;
  private boolean JdY;
  private Animator JdZ;
  private Animator Jea;
  private Animator Jeb;
  private b<? super Matrix, Boolean> Jec;
  private final float[] Jed;
  private Matrix cEN;
  private View contentView;
  private final Matrix pP;
  private final Rect pvE;
  private Rect sOx;
  private float sOy;
  private final RectF tY;
  private float[] values;
  private final RectF wzi;
  
  static
  {
    AppMethodBeat.i(164441);
    Jee = new CropLayout.a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.cEN = new Matrix();
    this.JdC = 0.25F;
    this.JdD = 5.0F;
    this.JdE = 1.0F;
    this.JdF = 1.0F;
    this.JdG = true;
    this.sOy = 1.0F;
    this.wzi = new RectF();
    this.JdI = new Rect();
    this.JdJ = new Rect();
    this.pvE = new Rect();
    this.JdK = new RectF();
    this.JdL = new Rect();
    this.sOx = new Rect();
    this.JdM = e.Jef;
    this.JdN = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.pP = new Matrix();
    this.JdU = new float[2];
    this.JdW = new float[2];
    this.Jec = ((b)CropLayout.g.Jek);
    this.tY = new RectF();
    this.Jed = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.cEN = new Matrix();
    this.JdC = 0.25F;
    this.JdD = 5.0F;
    this.JdE = 1.0F;
    this.JdF = 1.0F;
    this.JdG = true;
    this.sOy = 1.0F;
    this.wzi = new RectF();
    this.JdI = new Rect();
    this.JdJ = new Rect();
    this.pvE = new Rect();
    this.JdK = new RectF();
    this.JdL = new Rect();
    this.sOx = new Rect();
    this.JdM = e.Jef;
    this.JdN = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.pP = new Matrix();
    this.JdU = new float[2];
    this.JdW = new float[2];
    this.Jec = ((b)CropLayout.g.Jek);
    this.tY = new RectF();
    this.Jed = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.cEN = new Matrix();
    this.JdC = 0.25F;
    this.JdD = 5.0F;
    this.JdE = 1.0F;
    this.JdF = 1.0F;
    this.JdG = true;
    this.sOy = 1.0F;
    this.wzi = new RectF();
    this.JdI = new Rect();
    this.JdJ = new Rect();
    this.pvE = new Rect();
    this.JdK = new RectF();
    this.JdL = new Rect();
    this.sOx = new Rect();
    this.JdM = e.Jef;
    this.JdN = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.pP = new Matrix();
    this.JdU = new float[2];
    this.JdW = new float[2];
    this.Jec = ((b)CropLayout.g.Jek);
    this.tY = new RectF();
    this.Jed = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.JdB;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.cEN.postTranslate(-paramFloat1, -paramFloat2);
    fvl();
    AppMethodBeat.o(164433);
  }
  
  private final void bT(float paramFloat)
  {
    AppMethodBeat.i(197313);
    this.cEN.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    fvl();
    AppMethodBeat.o(197313);
  }
  
  private final void d(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      an(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (fvg())
    {
      f = paramFloat1;
      if (fvi()) {
        f = paramFloat1 * 0.4F;
      }
      if (!fvh()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!fvj()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      an(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private boolean fvg()
  {
    AppMethodBeat.i(164421);
    if (this.JdK.width() > this.wzi.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.JdX != true)) {
        this.JdP = true;
      }
      this.JdX = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private boolean fvi()
  {
    return (this.wzi.left < this.JdK.left) || (this.wzi.right > this.JdK.right);
  }
  
  private boolean fvj()
  {
    return (this.wzi.top < this.JdK.top) || (this.wzi.bottom > this.JdK.bottom);
  }
  
  private void fvk()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.JdZ;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.JeO)
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.JdK.left - this.wzi.left);
    int j = (int)(this.JdK.top - this.wzi.top);
    int m = (int)(this.wzi.right - this.JdK.right);
    int k = (int)(this.wzi.bottom - this.JdK.bottom);
    if ((fvi()) && (i > 0)) {
      if (fvg())
      {
        if ((!fvj()) || (j <= 0)) {
          break label287;
        }
        if (!fvh()) {
          break label267;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        c localc = this.AsK;
        localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          ((d)localObject).egk();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.JdK.centerX() - this.wzi.centerX());
          break;
          if ((fvi()) && (m > 0))
          {
            if (fvg())
            {
              i = -m;
              break;
            }
            i = (int)(this.JdK.centerX() - this.wzi.centerX());
            break;
          }
          i = 0;
          break;
          label267:
          j = (int)(this.JdK.centerY() - this.wzi.centerY());
          continue;
          label287:
          if ((fvj()) && (k > 0))
          {
            if (fvh())
            {
              j = -k;
              continue;
            }
            j = (int)(this.JdK.centerY() - this.wzi.centerY());
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
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new p(this));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new q(this));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(160L);
    ((ValueAnimator)localObject).start();
    this.JdZ = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private final void fvl()
  {
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    if (localObject != null)
    {
      float[] arrayOfFloat = getMatrixValues();
      float f = getContentViewScale()[0];
      ((View)localObject).setRotation(getRotateDegrees());
      ((View)localObject).setPivotX(0.0F);
      ((View)localObject).setPivotY(0.0F);
      ((View)localObject).setScaleX(f);
      ((View)localObject).setScaleY(f);
      ((View)localObject).setTranslationX(arrayOfFloat[2]);
      ((View)localObject).setTranslationY(arrayOfFloat[5]);
    }
    localObject = this.contentView;
    if (localObject != null)
    {
      this.tY.set(this.JdL);
      ((View)localObject).getMatrix().mapRect(this.tY);
      this.JdK.set(this.tY);
      this.tY.round(this.pvE);
    }
    localObject = this.AsK;
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
    this.cEN.getValues(this.values);
    float f1 = this.values[2];
    float f2 = this.values[5];
    this.Jed[0] = f1;
    this.Jed[1] = f2;
    float[] arrayOfFloat = this.Jed;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.cEN.getValues(this.values);
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
    this.cEN.getValues(this.values);
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private void h(RectF paramRectF)
  {
    AppMethodBeat.i(197311);
    k.h(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.JdL.width(), paramRectF.height() * 1.0F / this.JdL.height());
    float f2;
    float f1;
    if (this.JdK.height() > this.wzi.height())
    {
      f2 = this.JdK.centerX() - this.wzi.centerX();
      f1 = this.JdK.top - this.wzi.top;
    }
    for (;;)
    {
      this.sOy = f3;
      this.JdE = (this.JdC * this.sOy);
      this.JdF = (this.JdD * this.sOy);
      an(f2, f1);
      p(f3, this.wzi.centerX(), this.wzi.centerY());
      this.JdK.round(this.sOx);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.JdL).append(" contentRect=").append(this.pvE);
      AppMethodBeat.o(197311);
      return;
      if (this.JdK.width() > this.wzi.width())
      {
        f2 = this.JdK.left - this.wzi.left;
        f1 = this.JdK.centerY() - this.wzi.centerY();
      }
      else
      {
        f2 = this.JdK.centerX() - this.wzi.centerX();
        f1 = this.JdK.centerY() - this.wzi.centerY();
      }
    }
  }
  
  private void i(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    k.h(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.JdL.width(), paramRectF.height() * 1.0F / this.JdL.height());
    float f2 = this.JdK.centerX() - this.wzi.centerX();
    float f3 = this.JdK.centerY() - this.wzi.centerY();
    this.sOy = f1;
    this.JdE = (this.JdC * this.sOy);
    this.JdF = (this.JdD * this.sOy);
    an(f2, f3);
    p(f1, this.wzi.centerX(), this.wzi.centerY());
    this.JdK.round(this.sOx);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.JdL).append(" contentRect=").append(this.pvE);
    AppMethodBeat.o(164427);
  }
  
  private final void p(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.JdK.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.JdK.left) / this.JdK.width();
    float f2 = (paramFloat3 - this.JdK.top) / this.JdK.height();
    bT(paramFloat1);
    b localb = this.JdB;
    if (localb != null) {
      localb.l(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.JdK.left;
    float f3 = this.JdK.width();
    float f4 = this.JdK.top;
    float f5 = this.JdK.height();
    this.cEN.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    fvl();
    AppMethodBeat.o(164432);
  }
  
  public final void a(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(197312);
    k.h(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.JdL.width(), paramRectF.height() * 1.0F / this.JdL.height());
    float f2 = this.JdK.centerX() - this.wzi.centerX();
    float f3 = this.JdK.centerY() - this.wzi.centerY();
    this.sOy = f1;
    this.JdE = (this.JdC * this.sOy);
    this.JdF = (this.JdD * this.sOy);
    if (!paramBoolean)
    {
      an(f2, f3);
      p(f1, this.wzi.centerX(), this.wzi.centerY());
      this.JdK.round(this.sOx);
    }
    for (;;)
    {
      new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.JdL).append(" contentRect=").append(this.pvE);
      AppMethodBeat.o(197312);
      return;
      a((a)new f(this), null);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, e parame, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    k.h(paramView, "view");
    k.h(paramMatrix, "matrix");
    k.h(parame, "scaleType");
    k.h(paramb, "initFinish");
    this.JdJ.set(0, 0, paramInt1, paramInt2);
    this.Jec = paramb;
    this.contentView = paramView;
    this.cEN = paramMatrix;
    this.JdG = paramMatrix.isIdentity();
    this.JdH = true;
    this.JdM = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<y> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    k.h(parama, "onAnimationEnd");
    Object localObject = this.Jea;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.JdK.centerX();
    float f3 = this.JdK.centerY();
    float f4 = this.sOx.exactCenterX();
    float f5 = this.sOx.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.sOy });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new r(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new s(this, parama, paramAnimatorUpdateListener));
    if (paramAnimatorUpdateListener != null) {
      ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    }
    ((ValueAnimator)localObject).start();
    this.Jeb = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ai(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    k.h(paramMotionEvent, "e1");
    super.ai(paramMotionEvent);
    this.JdP = false;
    this.JdQ = false;
    this.JdN = false;
    paramMotionEvent = this.JdV;
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
      if (!this.JeO) {
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
        fvk();
      }
      this.JdT = false;
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
        bool2 = fvg();
        bool3 = fvh();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.JdV;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.Jea;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.JdK.centerX();
    float f3 = this.JdK.centerY();
    float f4 = this.wzi.centerX();
    float f5 = this.wzi.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.wzi.width() / this.JdK.width();
    float f7 = this.wzi.height() / this.JdK.height();
    label263:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label376:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.JdM == e.Jef)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.wzi.right - this.JdK.right;
      f3 = this.wzi.left - this.JdK.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label675;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.wzi.bottom - this.JdK.bottom;
      f5 = this.wzi.top - this.JdK.top;
      if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
        break label698;
      }
      f1 = f5;
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
      new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
      paramMotionEvent = new v.c();
      paramMotionEvent.KUN = 0.0F;
      final v.c localc = new v.c();
      localc.KUN = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new n(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new o(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.Jea = ((Animator)localObject);
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
  
  public final void f(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164409);
    if (this.wzi.isEmpty()) {
      this.wzi.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.JdH)
      {
        this.JdH = false;
        if (this.JdG) {
          this.cEN.reset();
        }
        this.JdL.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.JdL.exactCenterX());
        ((View)localObject).setPivotY(this.JdL.exactCenterY());
        this.tY.set(this.JdL);
        this.cEN.mapRect(this.tY);
        this.tY.round(this.pvE);
        this.JdK.set(this.tY);
        if (this.JdG)
        {
          this.cEN.reset();
          localObject = this.JdM;
          switch (a.cfA[localObject.ordinal()])
          {
          }
          while (((Boolean)this.Jec.ay(this.cEN)).booleanValue())
          {
            fvl();
            this.JdK.round(this.sOx);
            AppMethodBeat.o(164409);
            return;
            i(this.wzi);
            continue;
            a(this.wzi, false);
            continue;
            h(this.wzi);
          }
        }
        if (((Boolean)this.Jec.ay(this.cEN)).booleanValue())
        {
          fvl();
          this.JdK.round(this.sOx);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.JdM;
        switch (a.fTL[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        i(this.wzi);
        AppMethodBeat.o(164409);
        return;
        a(this.wzi, false);
        AppMethodBeat.o(164409);
        return;
        h(this.wzi);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final void fve()
  {
    AppMethodBeat.i(197309);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    v.c localc = new v.c();
    localc.KUN = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new k(localc, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(197309);
  }
  
  public final void fvf()
  {
    AppMethodBeat.i(197310);
    final float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(197310);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    v.c localc = new v.c();
    localc.KUN = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new j(localc, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(197310);
  }
  
  protected final boolean fvh()
  {
    AppMethodBeat.i(164422);
    if (this.JdK.height() > this.wzi.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.JdY != true)) {
        this.JdQ = true;
      }
      this.JdY = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(164408);
    k.h(paramRectF, "rectF");
    float f1 = this.wzi.bottom - this.JdK.bottom;
    float f2 = this.wzi.top;
    float f3 = this.JdK.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      d(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.wzi.set(paramRectF);
      AppMethodBeat.o(164408);
      return;
      if (this.JdK.height() <= this.wzi.height())
      {
        o(1.0F * this.wzi.height() / this.JdK.height(), this.JdK.centerX(), this.JdK.bottom);
        d(0.0F, -(this.wzi.bottom - this.JdK.bottom), 4);
      }
    }
  }
  
  public final Rect getContentCenterRect()
  {
    return this.sOx;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.JdJ;
  }
  
  public final Rect getContentRect()
  {
    return this.pvE;
  }
  
  public final RectF getContentRectF()
  {
    return this.JdK;
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
    return this.JdB;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cEN;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.JdD;
  }
  
  public final float getMaxScaleValue()
  {
    return this.JdF;
  }
  
  public final float getMinScaleFactor()
  {
    return this.JdC;
  }
  
  public final float getMinScaleValue()
  {
    return this.JdE;
  }
  
  public final c getOnChangeListener()
  {
    return this.AsK;
  }
  
  public final e getScaleType()
  {
    return this.JdM;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.wzi;
  }
  
  public final Rect getWidgetRect()
  {
    return this.JdI;
  }
  
  protected final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.JdE) || (getContentViewScale()[0] * paramFloat1 > this.JdF))
    {
      if (!this.JdT)
      {
        performHapticFeedback(0, 2);
        this.JdT = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      p(paramFloat1, paramFloat2, paramFloat3);
      this.JdR = paramFloat2;
      this.JdS = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164410);
    boolean bool = super.onDoubleTap(paramMotionEvent);
    AppMethodBeat.o(164410);
    return bool;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164411);
    super.onDown(paramMotionEvent);
    c localc = this.AsK;
    paramMotionEvent = localc;
    if (!(localc instanceof d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (d)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.egj();
    }
    paramMotionEvent = this.JdV;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.JdZ;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    AppMethodBeat.o(164411);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164420);
    k.h(paramMotionEvent1, "e1");
    k.h(paramMotionEvent2, "e2");
    float f2 = 0.5F * paramFloat1;
    float f1 = 0.5F * paramFloat2;
    if ((this.JdO) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = fvi();
    boolean bool2 = fvj();
    boolean bool3 = fvg();
    boolean bool4 = fvh();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.JdK.left < this.wzi.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.JdK.right <= this.wzi.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.JdM == e.Jef) || (this.JdM == e.Jeh))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.JdK.top < this.wzi.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.JdK.bottom <= this.wzi.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.JdM == e.Jef) || (this.JdM == e.Jeh))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.JdV;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.JdW[0] = 0.0F;
    this.JdW[1] = 0.0F;
    f1 = this.JdK.right;
    f2 = this.wzi.right;
    float f3 = this.wzi.left;
    float f4 = this.JdK.left;
    if (paramFloat1 < 0.0F)
    {
      this.JdW[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.JdK.bottom;
      f2 = this.wzi.bottom;
      f3 = this.wzi.top;
      f4 = this.JdK.top;
      if (paramFloat2 >= 0.0F) {
        break label695;
      }
      this.JdW[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.JdW;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new i(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.JdV = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.JdW[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label695:
      this.JdW[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.JdI.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.JdH = true;
    }
    f(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164407);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164416);
    k.h(paramScaleGestureDetector, "detector");
    o(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    AppMethodBeat.o(164416);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164413);
    k.h(paramMotionEvent1, "e1");
    k.h(paramMotionEvent2, "e2");
    d(paramFloat1, paramFloat2, 0);
    AppMethodBeat.o(164413);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    k.h(paramView, "v");
    k.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.JdO = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.JdO = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.wzi.setEmpty();
    this.pvE.setEmpty();
    this.JdK.setEmpty();
    this.sOx.setEmpty();
    this.JdL.setEmpty();
    this.tY.setEmpty();
    this.cEN = new Matrix();
    this.sOy = 1.0F;
    this.JdE = 1.0F;
    this.JdF = 1.0F;
    this.JdD = 5.0F;
    this.JdC = 0.25F;
    this.JdR = 0.0F;
    this.JdS = 0.0F;
    this.Jed[0] = 0.0F;
    this.Jed[1] = 0.0F;
    this.JdG = true;
    this.JdH = false;
    this.JdN = true;
    this.Jec = ((b)CropLayout.l.Jeo);
    this.values = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    k.h(paramRect, "<set-?>");
    this.sOx = paramRect;
    AppMethodBeat.o(164404);
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.JdB = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.JdN = paramBoolean;
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    k.h(paramMatrix, "<set-?>");
    this.cEN = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.JdD = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.JdF = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.JdC = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.JdE = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.AsK = paramc;
  }
  
  public final void setScaleType(e parame)
  {
    AppMethodBeat.i(164405);
    k.h(parame, "<set-?>");
    this.JdM = parame;
    AppMethodBeat.o(164405);
  }
  
  public final void ya(boolean paramBoolean)
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void l(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void onScroll(float paramFloat1, float paramFloat2);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"})
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void egj();
    
    public abstract void egk();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(164380);
      e locale1 = new e("CENTER_CROP", 0);
      Jef = locale1;
      e locale2 = new e("CENTER_INSIDE", 1);
      Jeg = locale2;
      e locale3 = new e("ALIGN_START", 2);
      Jeh = locale3;
      Jei = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(164380);
    }
    
    private e() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
  {
    f(CropLayout paramCropLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float rYu;
    private float tmJ;
    
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164386);
      k.h(paramValueAnimator, "it");
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
      CropLayout.a(this.Jej, this.rYu - f1, this.tmJ - f2);
      this.rYu = f1;
      this.tmJ = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164387);
      CropLayout.a(this.Jej);
      AppMethodBeat.o(164387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
  static final class j
    implements ValueAnimator.AnimatorUpdateListener
  {
    j(v.c paramc, CropLayout paramCropLayout, float paramFloat) {}
    
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
      CropLayout.a(jdField_this, f - this.Jel.KUN);
      this.Jel.KUN = f;
      AppMethodBeat.o(164388);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRotate$1$1"})
  static final class k
    implements ValueAnimator.AnimatorUpdateListener
  {
    k(v.c paramc, CropLayout paramCropLayout) {}
    
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
      CropLayout.a(jdField_this, f - this.Jel.KUN);
      this.Jel.KUN = f;
      AppMethodBeat.o(164389);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class n
    implements ValueAnimator.AnimatorUpdateListener
  {
    n(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, v.c paramc1, v.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.Jej.getScaleType() == CropLayout.e.Jeg) && (!bool3) && (!bool2)) || ((this.Jej.getScaleType() == CropLayout.e.Jef) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.Jej.getContentViewScale()[0];
        CropLayout.a(this.Jej, f1, this.Jej.getContentRectF().centerX(), this.Jej.getContentRectF().centerY());
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
      float f7 = paramMotionEvent.KUN;
      float f5 = localc.KUN;
      float f8 = this.Jej.getContentRectF().centerX();
      float f6 = this.Jej.getContentRectF().centerY();
      paramValueAnimator = this.Jej;
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
        paramMotionEvent.KUN = f3;
        localc.KUN = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class o
    implements Animator.AnimatorListener
  {
    o(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, v.c paramc1, v.c paramc2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(197308);
      CropLayout.c localc = this.Jej.getOnChangeListener();
      paramAnimator = localc;
      if (!(localc instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.egk();
        AppMethodBeat.o(197308);
        return;
      }
      AppMethodBeat.o(197308);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int Cvk;
    private int rTm;
    
    p(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164395);
      k.h(paramValueAnimator, "it");
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
      CropLayout.b(this.Jej, i - this.rTm, j - this.Cvk);
      this.rTm = i;
      this.Cvk = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class q
    implements Animator.AnimatorListener
  {
    q(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      k.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Jeu;
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
      k.h(paramAnimator, "animation");
      Object localObject = this.Jeu;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.Jej.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.egk();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      k.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Jeu;
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
      k.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.Jeu;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
  static final class r
    implements ValueAnimator.AnimatorUpdateListener
  {
    r(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
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
      CropLayout.c(this.Jej);
      f3 = f3 * 1.0F / this.Jej.getContentViewScale()[0];
      CropLayout.b(this.Jej, f3);
      f3 = this.Jej.getContentRectF().centerX();
      float f4 = this.Jej.getContentRectF().centerY();
      CropLayout.b(this.Jej, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class s
    implements Animator.AnimatorListener
  {
    s(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164402);
      this.Jej.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164401);
          this.Jex.Jev.invoke();
          AppMethodBeat.o(164401);
        }
      });
      AppMethodBeat.o(164402);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */