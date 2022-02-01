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
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.aa.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "contentBaseRect", "Landroid/graphics/Rect;", "getContentBaseRect", "()Landroid/graphics/Rect;", "setContentBaseRect", "(Landroid/graphics/Rect;)V", "contentCenterRect", "getContentCenterRect", "setContentCenterRect", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "getInitFinish", "()Lkotlin/jvm/functions/Function1;", "setInitFinish", "(Lkotlin/jvm/functions/Function1;)V", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "setShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "getTmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onSingleTapUp", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final a Ylu;
  private Rect BZw;
  private float BZx;
  private final RectF HVY;
  private c NuA;
  private b YkR;
  private float YkS;
  private float YkT;
  private float YkU;
  private float YkV;
  private boolean YkW;
  private boolean YkX;
  private final Rect YkY;
  private final Rect YkZ;
  private final RectF Yla;
  private Rect Ylb;
  private e Ylc;
  private boolean Yld;
  private boolean Yle;
  private boolean Ylf;
  private boolean Ylg;
  private float Ylh;
  private float Yli;
  private boolean Ylj;
  private final float[] Ylk;
  private Animator Yll;
  private final float[] Ylm;
  private boolean Yln;
  private boolean Ylo;
  private Animator Ylp;
  private Animator Ylq;
  private Animator Ylr;
  private b<? super Matrix, Boolean> Yls;
  private final float[] Ylt;
  private final Matrix bAX;
  private final RectF bGR;
  private View contentView;
  private View.OnClickListener dig;
  private Matrix eYD;
  private float[] fkN;
  private final Rect vcr;
  
  static
  {
    AppMethodBeat.i(164441);
    Ylu = new a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.eYD = new Matrix();
    this.YkS = 0.25F;
    this.YkT = 5.0F;
    this.YkU = 1.0F;
    this.YkV = 1.0F;
    this.YkW = true;
    this.BZx = 1.0F;
    this.HVY = new RectF();
    this.YkY = new Rect();
    this.YkZ = new Rect();
    this.vcr = new Rect();
    this.Yla = new RectF();
    this.Ylb = new Rect();
    this.BZw = new Rect();
    this.Ylc = e.Ylv;
    this.Yld = true;
    paramContext = getContext();
    p.j(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.bAX = new Matrix();
    this.Ylk = new float[2];
    this.Ylm = new float[2];
    this.Yls = ((b)f.Ylz);
    this.bGR = new RectF();
    this.Ylt = new float[2];
    this.fkN = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.eYD = new Matrix();
    this.YkS = 0.25F;
    this.YkT = 5.0F;
    this.YkU = 1.0F;
    this.YkV = 1.0F;
    this.YkW = true;
    this.BZx = 1.0F;
    this.HVY = new RectF();
    this.YkY = new Rect();
    this.YkZ = new Rect();
    this.vcr = new Rect();
    this.Yla = new RectF();
    this.Ylb = new Rect();
    this.BZw = new Rect();
    this.Ylc = e.Ylv;
    this.Yld = true;
    paramContext = getContext();
    p.j(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.bAX = new Matrix();
    this.Ylk = new float[2];
    this.Ylm = new float[2];
    this.Yls = ((b)f.Ylz);
    this.bGR = new RectF();
    this.Ylt = new float[2];
    this.fkN = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.eYD = new Matrix();
    this.YkS = 0.25F;
    this.YkT = 5.0F;
    this.YkU = 1.0F;
    this.YkV = 1.0F;
    this.YkW = true;
    this.BZx = 1.0F;
    this.HVY = new RectF();
    this.YkY = new Rect();
    this.YkZ = new Rect();
    this.vcr = new Rect();
    this.Yla = new RectF();
    this.Ylb = new Rect();
    this.BZw = new Rect();
    this.Ylc = e.Ylv;
    this.Yld = true;
    paramContext = getContext();
    p.j(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.bAX = new Matrix();
    this.Ylk = new float[2];
    this.Ylm = new float[2];
    this.Yls = ((b)f.Ylz);
    this.bGR = new RectF();
    this.Ylt = new float[2];
    this.fkN = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void aJ(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.YkR;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.eYD.postTranslate(-paramFloat1, -paramFloat2);
    icj();
    AppMethodBeat.o(164433);
  }
  
  private final void cU(float paramFloat)
  {
    AppMethodBeat.i(212141);
    this.eYD.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    icj();
    AppMethodBeat.o(212141);
  }
  
  private final void f(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      aJ(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (ice())
    {
      f = paramFloat1;
      if (icg()) {
        f = paramFloat1 * 0.4F;
      }
      if (!icf()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!ich()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      aJ(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.eYD.getValues(this.fkN);
    float[] arrayOfFloat = this.fkN;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Float.isNaN(arrayOfFloat[j]))
        {
          new StringBuilder("MatrixValues Error! index=").append(i).append(" value=").append(this.fkN[i]);
          this.fkN[i] = 1.0F;
        }
      }
      else
      {
        arrayOfFloat = this.fkN;
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
        ((Matrix)localObject).getValues(this.fkN);
      }
    }
    float f = -(float)Math.round(Math.atan2(this.fkN[1], this.fkN[0]) * 57.295779513082323D);
    AppMethodBeat.o(164419);
    return f;
  }
  
  private final float getRotateDegrees()
  {
    AppMethodBeat.i(164418);
    this.eYD.getValues(this.fkN);
    float f = -(float)Math.round(Math.atan2(this.fkN[1], this.fkN[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private boolean ice()
  {
    AppMethodBeat.i(164421);
    if (this.Yla.width() > this.HVY.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.Yln != true)) {
        this.Ylf = true;
      }
      this.Yln = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private final boolean icg()
  {
    return (this.HVY.left < this.Yla.left) || (this.HVY.right > this.Yla.right);
  }
  
  private boolean ich()
  {
    return (this.HVY.top < this.Yla.top) || (this.HVY.bottom > this.Yla.bottom);
  }
  
  private void ici()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.Ylp;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (icm())
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.Yla.left - this.HVY.left);
    int j = (int)(this.Yla.top - this.HVY.top);
    int m = (int)(this.HVY.right - this.Yla.right);
    int k = (int)(this.HVY.bottom - this.Yla.bottom);
    if ((icg()) && (i > 0)) {
      if (ice())
      {
        if ((!ich()) || (j <= 0)) {
          break label287;
        }
        if (!icf()) {
          break label267;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        c localc = this.NuA;
        localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          ((d)localObject).gvj();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.Yla.centerX() - this.HVY.centerX());
          break;
          if ((icg()) && (m > 0))
          {
            if (ice())
            {
              i = -m;
              break;
            }
            i = (int)(this.Yla.centerX() - this.HVY.centerX());
            break;
          }
          i = 0;
          break;
          label267:
          j = (int)(this.Yla.centerY() - this.HVY.centerY());
          continue;
          label287:
          if ((ich()) && (k > 0))
          {
            if (icf())
            {
              j = -k;
              continue;
            }
            j = (int)(this.Yla.centerY() - this.HVY.centerY());
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
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new o(this, null));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new p(this, null));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(160L);
    ((ValueAnimator)localObject).start();
    this.Ylp = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private void k(RectF paramRectF)
  {
    AppMethodBeat.i(212134);
    p.k(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.Ylb.width(), paramRectF.height() * 1.0F / this.Ylb.height());
    float f2;
    float f1;
    if (this.Yla.height() > this.HVY.height())
    {
      f2 = this.Yla.centerX() - this.HVY.centerX();
      f1 = this.Yla.top - this.HVY.top;
    }
    for (;;)
    {
      this.BZx = f3;
      this.YkU = (this.YkS * this.BZx);
      this.YkV = (this.YkT * this.BZx);
      aJ(f2, f1);
      v(f3, this.HVY.centerX(), this.HVY.centerY());
      this.Yla.round(this.BZw);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.Ylb).append(" contentRect=").append(this.vcr);
      AppMethodBeat.o(212134);
      return;
      if (this.Yla.width() > this.HVY.width())
      {
        f2 = this.Yla.left - this.HVY.left;
        f1 = this.Yla.centerY() - this.HVY.centerY();
      }
      else
      {
        f2 = this.Yla.centerX() - this.HVY.centerX();
        f1 = this.Yla.centerY() - this.HVY.centerY();
      }
    }
  }
  
  private void l(RectF paramRectF)
  {
    AppMethodBeat.i(164426);
    p.k(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.Ylb.width(), paramRectF.height() * 1.0F / this.Ylb.height());
    float f2 = this.Yla.centerX() - this.HVY.centerX();
    float f3 = this.Yla.centerY() - this.HVY.centerY();
    this.BZx = f1;
    this.YkU = (this.YkS * this.BZx);
    this.YkV = (this.YkT * this.BZx);
    aJ(f2, f3);
    v(f1, this.HVY.centerX(), this.HVY.centerY());
    this.Yla.round(this.BZw);
    new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.Ylb).append(" contentRect=").append(this.vcr);
    AppMethodBeat.o(164426);
  }
  
  private void m(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    p.k(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.Ylb.width(), paramRectF.height() * 1.0F / this.Ylb.height());
    float f2 = this.Yla.centerX() - this.HVY.centerX();
    float f3 = this.Yla.centerY() - this.HVY.centerY();
    this.BZx = f1;
    this.YkU = (this.YkS * this.BZx);
    this.YkV = (this.YkT * this.BZx);
    aJ(f2, f3);
    v(f1, this.HVY.centerX(), this.HVY.centerY());
    this.Yla.round(this.BZw);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.Ylb).append(" contentRect=").append(this.vcr);
    AppMethodBeat.o(164427);
  }
  
  private final void v(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.Yla.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.Yla.left) / this.Yla.width();
    float f2 = (paramFloat3 - this.Yla.top) / this.Yla.height();
    cU(paramFloat1);
    b localb = this.YkR;
    if (localb != null) {
      localb.p(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.Yla.left;
    float f3 = this.Yla.width();
    float f4 = this.Yla.top;
    float f5 = this.Yla.height();
    this.eYD.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    icj();
    AppMethodBeat.o(164432);
  }
  
  public final void HA(boolean paramBoolean)
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
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, e parame, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    p.k(paramView, "view");
    p.k(paramMatrix, "matrix");
    p.k(parame, "scaleType");
    p.k(paramb, "initFinish");
    this.YkZ.set(0, 0, paramInt1, paramInt2);
    this.Yls = paramb;
    this.contentView = paramView;
    this.eYD = paramMatrix;
    this.YkW = paramMatrix.isIdentity();
    this.YkX = true;
    this.Ylc = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<x> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    p.k(parama, "onAnimationEnd");
    Object localObject = this.Ylq;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.Yla.centerX();
    float f3 = this.Yla.centerY();
    float f4 = this.BZw.exactCenterX();
    float f5 = this.BZw.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.BZx });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new q(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new r(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    ((ValueAnimator)localObject).start();
    this.Ylr = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void am(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    p.k(paramMotionEvent, "e1");
    super.am(paramMotionEvent);
    this.Ylf = false;
    this.Ylg = false;
    this.Yld = false;
    paramMotionEvent = this.Yll;
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
      if (!icm()) {
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
        ici();
      }
      this.Ylj = false;
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
        bool2 = ice();
        bool3 = icf();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.Yll;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.Ylq;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.Yla.centerX();
    float f3 = this.Yla.centerY();
    float f4 = this.HVY.centerX();
    float f5 = this.HVY.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.HVY.width() / this.Yla.width();
    float f7 = this.HVY.height() / this.Yla.height();
    label263:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label376:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.Ylc == e.Ylv)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.HVY.right - this.Yla.right;
      f3 = this.HVY.left - this.Yla.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label675;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.HVY.bottom - this.Yla.bottom;
      f5 = this.HVY.top - this.Yla.top;
      if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
        break label698;
      }
      f1 = f5;
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
      new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
      paramMotionEvent = new aa.c();
      paramMotionEvent.aaBz = 0.0F;
      final aa.c localc = new aa.c();
      localc.aaBz = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new n(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.Ylq = ((Animator)localObject);
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
  
  public void b(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(212084);
    p.k(paramRectF, "rectF");
    float f1 = this.HVY.bottom - this.Yla.bottom;
    float f2 = this.HVY.top;
    float f3 = this.Yla.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      f(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.HVY.set(paramRectF);
      AppMethodBeat.o(212084);
      return;
      if ((this.Yla.height() <= this.HVY.height()) || (paramBoolean))
      {
        u(1.0F * this.HVY.height() / this.Yla.height(), this.Yla.centerX(), this.Yla.bottom);
        f(0.0F, -(this.HVY.bottom - this.Yla.bottom), 4);
      }
    }
  }
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164409);
    if (this.HVY.isEmpty()) {
      this.HVY.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.YkX)
      {
        this.YkX = false;
        if (this.YkW) {
          this.eYD.reset();
        }
        this.Ylb.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.Ylb.exactCenterX());
        ((View)localObject).setPivotY(this.Ylb.exactCenterY());
        this.bGR.set(this.Ylb);
        this.eYD.mapRect(this.bGR);
        this.bGR.round(this.vcr);
        this.Yla.set(this.bGR);
        if (this.YkW)
        {
          this.eYD.reset();
          localObject = this.Ylc;
          switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
          {
          }
          while (((Boolean)this.Yls.invoke(this.eYD)).booleanValue())
          {
            icj();
            this.Yla.round(this.BZw);
            AppMethodBeat.o(164409);
            return;
            m(this.HVY);
            continue;
            l(this.HVY);
            continue;
            k(this.HVY);
          }
        }
        if (((Boolean)this.Yls.invoke(this.eYD)).booleanValue())
        {
          icj();
          this.Yla.round(this.BZw);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.Ylc;
        switch (a.jLJ[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        m(this.HVY);
        AppMethodBeat.o(164409);
        return;
        l(this.HVY);
        AppMethodBeat.o(164409);
        return;
        k(this.HVY);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final View.OnClickListener getClickListener()
  {
    return this.dig;
  }
  
  protected final Rect getContentBaseRect()
  {
    return this.Ylb;
  }
  
  public final Rect getContentCenterRect()
  {
    return this.BZw;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.YkZ;
  }
  
  public final Rect getContentRect()
  {
    return this.vcr;
  }
  
  public final RectF getContentRectF()
  {
    return this.Yla;
  }
  
  protected final View getContentView()
  {
    return this.contentView;
  }
  
  public final float[] getContentViewScale()
  {
    AppMethodBeat.i(164436);
    getMatrixValues();
    float f1 = this.fkN[0];
    float f2 = this.fkN[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(164436);
    return new float[] { f1, f1 };
  }
  
  public final float[] getContentViewTrans()
  {
    AppMethodBeat.i(164435);
    this.eYD.getValues(this.fkN);
    float f1 = this.fkN[2];
    float f2 = this.fkN[5];
    this.Ylt[0] = f1;
    this.Ylt[1] = f2;
    float[] arrayOfFloat = this.Ylt;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  public final b getCropLayoutTouchListener()
  {
    return this.YkR;
  }
  
  protected final b<Matrix, Boolean> getInitFinish()
  {
    return this.Yls;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.eYD;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.YkT;
  }
  
  public final float getMaxScaleValue()
  {
    return this.YkV;
  }
  
  public final float getMinScaleFactor()
  {
    return this.YkS;
  }
  
  public final float getMinScaleValue()
  {
    return this.YkU;
  }
  
  public final c getOnChangeListener()
  {
    return this.NuA;
  }
  
  public final e getScaleType()
  {
    return this.Ylc;
  }
  
  protected final RectF getTmpRectF()
  {
    return this.bGR;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.HVY;
  }
  
  public final Rect getWidgetRect()
  {
    return this.YkY;
  }
  
  protected final boolean ica()
  {
    return this.YkX;
  }
  
  protected final boolean icb()
  {
    return this.Yld;
  }
  
  public final void icc()
  {
    AppMethodBeat.i(212110);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    aa.c localc = new aa.c();
    localc.aaBz = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new j(localc, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(212110);
  }
  
  public final void icd()
  {
    AppMethodBeat.i(212113);
    final float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(212113);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    aa.c localc = new aa.c();
    localc.aaBz = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(localc, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(212113);
  }
  
  protected final boolean icf()
  {
    AppMethodBeat.i(164422);
    if (this.Yla.height() > this.HVY.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.Ylo != true)) {
        this.Ylg = true;
      }
      this.Ylo = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  protected final void icj()
  {
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    float[] arrayOfFloat;
    float f;
    if (localObject != null)
    {
      arrayOfFloat = getMatrixValues();
      f = getContentViewScale()[0];
      kotlin.g.b.l locall = kotlin.g.b.l.aaBt;
      if (f != kotlin.g.b.l.iCm())
      {
        locall = kotlin.g.b.l.aaBt;
        if ((f != kotlin.g.b.l.iCl()) && (!Float.isNaN(f))) {
          break label136;
        }
      }
    }
    for (;;)
    {
      localObject = this.contentView;
      if (localObject != null)
      {
        this.bGR.set(this.Ylb);
        ((View)localObject).getMatrix().mapRect(this.bGR);
        this.Yla.set(this.bGR);
        this.bGR.round(this.vcr);
      }
      localObject = this.NuA;
      if (localObject == null) {
        break;
      }
      ((c)localObject).onChange();
      AppMethodBeat.o(164434);
      return;
      label136:
      ((View)localObject).setRotation(getRotateDegrees());
      ((View)localObject).setPivotX(0.0F);
      ((View)localObject).setPivotY(0.0F);
      ((View)localObject).setScaleX(f);
      ((View)localObject).setScaleY(f);
      ((View)localObject).setTranslationX(arrayOfFloat[2]);
      ((View)localObject).setTranslationY(arrayOfFloat[5]);
    }
    AppMethodBeat.o(164434);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164411);
    super.onDown(paramMotionEvent);
    c localc = this.NuA;
    paramMotionEvent = localc;
    if (!(localc instanceof d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (d)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.gvi();
    }
    paramMotionEvent = this.Yll;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.Ylp;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    AppMethodBeat.o(164411);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164420);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    if (!icl())
    {
      AppMethodBeat.o(164420);
      return false;
    }
    float f2 = 0.5F * paramFloat1;
    float f1 = 0.5F * paramFloat2;
    if ((this.Yle) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = icg();
    boolean bool2 = ich();
    boolean bool3 = ice();
    boolean bool4 = icf();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.Yla.left < this.HVY.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.Yla.right <= this.HVY.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.Ylc == e.Ylv) || (this.Ylc == e.Ylx))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.Yla.top < this.HVY.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.Yla.bottom <= this.HVY.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.Ylc == e.Ylv) || (this.Ylc == e.Ylx))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.Yll;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.Ylm[0] = 0.0F;
    this.Ylm[1] = 0.0F;
    f1 = this.Yla.right;
    f2 = this.HVY.right;
    float f3 = this.HVY.left;
    float f4 = this.Yla.left;
    if (paramFloat1 < 0.0F)
    {
      this.Ylm[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.Yla.bottom;
      f2 = this.HVY.bottom;
      f3 = this.HVY.top;
      f4 = this.Yla.top;
      if (paramFloat2 >= 0.0F) {
        break label710;
      }
      this.Ylm[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.Ylm;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new h(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.Yll = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.Ylm[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label710:
      this.Ylm[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.YkY.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.YkX = true;
    }
    e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164407);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164416);
    p.k(paramScaleGestureDetector, "detector");
    u(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    AppMethodBeat.o(164416);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164413);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    if (icn()) {
      f(paramFloat1, paramFloat2, 0);
    }
    AppMethodBeat.o(164413);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212090);
    p.k(paramMotionEvent, "e");
    View.OnClickListener localOnClickListener = this.dig;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((View)this);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(212090);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    p.k(paramView, "v");
    p.k(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.Yle = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.Yle = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.HVY.setEmpty();
    this.vcr.setEmpty();
    this.Yla.setEmpty();
    this.BZw.setEmpty();
    this.Ylb.setEmpty();
    this.bGR.setEmpty();
    this.eYD = new Matrix();
    this.BZx = 1.0F;
    this.YkU = 1.0F;
    this.YkV = 1.0F;
    this.YkT = 5.0F;
    this.YkS = 0.25F;
    this.Ylh = 0.0F;
    this.Yli = 0.0F;
    this.Ylt[0] = 0.0F;
    this.Ylt[1] = 0.0F;
    this.YkW = true;
    this.YkX = false;
    this.Yld = true;
    this.Yls = ((b)k.YlE);
    this.fkN = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.dig = paramOnClickListener;
  }
  
  protected final void setContentBaseRect(Rect paramRect)
  {
    AppMethodBeat.i(212054);
    p.k(paramRect, "<set-?>");
    this.Ylb = paramRect;
    AppMethodBeat.o(212054);
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    p.k(paramRect, "<set-?>");
    this.BZw = paramRect;
    AppMethodBeat.o(164404);
  }
  
  protected final void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.YkR = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.Yld = paramBoolean;
  }
  
  protected final void setInitFinish(b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(212137);
    p.k(paramb, "<set-?>");
    this.Yls = paramb;
    AppMethodBeat.o(212137);
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    p.k(paramMatrix, "<set-?>");
    this.eYD = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.YkT = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.YkV = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.YkS = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.YkU = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.NuA = paramc;
  }
  
  public final void setScaleType(e parame)
  {
    AppMethodBeat.i(164405);
    p.k(parame, "<set-?>");
    this.Ylc = parame;
    AppMethodBeat.o(164405);
  }
  
  protected final void setShouldLayout(boolean paramBoolean)
  {
    this.YkX = paramBoolean;
  }
  
  protected final void u(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.YkU) || (getContentViewScale()[0] * paramFloat1 > this.YkV))
    {
      if (!this.Ylj)
      {
        performHapticFeedback(0, 2);
        this.Ylj = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      v(paramFloat1, paramFloat2, paramFloat3);
      this.Ylh = paramFloat2;
      this.Yli = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$Companion;", "", "()V", "DEFAULT_MAX_SCALE", "", "DEFAULT_MIN_SCALE", "EDGE_DURATION", "", "FLING_DAMPING", "FLING_DURATION", "OVER_SCROLL_DAMPING", "REVERT_DURATION", "ROTATE_DURATION", "TAG", "", "TYPE_VISIBILITY_RECT_CHANGE", "", "libmmui_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void onScroll(float paramFloat1, float paramFloat2);
    
    public abstract void p(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"})
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void gvi();
    
    public abstract void gvj();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(164380);
      e locale1 = new e("CENTER_CROP", 0);
      Ylv = locale1;
      e locale2 = new e("CENTER_INSIDE", 1);
      Ylw = locale2;
      e locale3 = new e("ALIGN_START", 2);
      Ylx = locale3;
      Yly = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(164380);
    }
    
    private e() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class f
    extends q
    implements b<Matrix, Boolean>
  {
    public static final f Ylz;
    
    static
    {
      AppMethodBeat.i(164385);
      Ylz = new f();
      AppMethodBeat.o(164385);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float aCa;
    private float aCb;
    
    g(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164386);
      p.k(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164386);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164386);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(this.YlA, this.aCa - f1, this.aCb - f2);
      this.aCa = f1;
      this.aCb = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164387);
      CropLayout.a(this.YlA);
      AppMethodBeat.o(164387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
  static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(aa.c paramc, CropLayout paramCropLayout, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164388);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164388);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(jdField_this, f - this.YlB.aaBz);
      this.YlB.aaBz = f;
      AppMethodBeat.o(164388);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRotate$1$1"})
  static final class j
    implements ValueAnimator.AnimatorUpdateListener
  {
    j(aa.c paramc, CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164389);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("rotate");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164389);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      CropLayout.a(jdField_this, f - this.YlB.aaBz);
      this.YlB.aaBz = f;
      AppMethodBeat.o(164389);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends q
    implements b<Matrix, Boolean>
  {
    public static final k YlE;
    
    static
    {
      AppMethodBeat.i(164391);
      YlE = new k();
      AppMethodBeat.o(164391);
    }
    
    k()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class l
    extends q
    implements b<Matrix, Boolean>
  {
    public static final l YlF;
    
    static
    {
      AppMethodBeat.i(164393);
      YlF = new l();
      AppMethodBeat.o(164393);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class m
    implements ValueAnimator.AnimatorUpdateListener
  {
    m(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, aa.c paramc1, aa.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.YlA.getScaleType() == CropLayout.e.Ylw) && (!bool3) && (!bool2)) || ((this.YlA.getScaleType() == CropLayout.e.Ylv) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.YlA.getContentViewScale()[0];
        CropLayout.a(this.YlA, f1, this.YlA.getContentRectF().centerX(), this.YlA.getContentRectF().centerY());
      }
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("transY");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f2 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("edgeX");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f3 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("edgeY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164394);
        throw paramValueAnimator;
      }
      float f4 = ((Float)paramValueAnimator).floatValue();
      float f7 = paramMotionEvent.aaBz;
      float f5 = localc.aaBz;
      float f8 = this.YlA.getContentRectF().centerX();
      float f6 = this.YlA.getContentRectF().centerY();
      paramValueAnimator = this.YlA;
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
        paramMotionEvent.aaBz = f3;
        localc.aaBz = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    n(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, aa.c paramc1, aa.c paramc2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204667);
      CropLayout.c localc = this.YlA.getOnChangeListener();
      paramAnimator = localc;
      if (!(localc instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.gvj();
        AppMethodBeat.o(204667);
        return;
      }
      AppMethodBeat.o(204667);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int AOM;
    private int zDE;
    
    o(CropLayout paramCropLayout, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164395);
      p.k(paramValueAnimator, "it");
      Object localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(164395);
        throw paramValueAnimator;
      }
      int i = ((Integer)localObject).intValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(164395);
        throw paramValueAnimator;
      }
      int j = ((Integer)paramValueAnimator).intValue();
      CropLayout.b(this.YlA, i - this.AOM, j - this.zDE);
      this.AOM = i;
      this.zDE = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(CropLayout paramCropLayout, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.YlK;
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
      p.k(paramAnimator, "animation");
      Object localObject = this.YlK;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.YlA.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.gvj();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.YlK;
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
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.YlK;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
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
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f3 = ((Float)localObject).floatValue();
      localObject = paramValueAnimator.getAnimatedValue("transX");
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f1 = ((Float)localObject).floatValue();
      paramValueAnimator = paramValueAnimator.getAnimatedValue("transY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164400);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      CropLayout.c(this.YlA);
      f3 = f3 * 1.0F / this.YlA.getContentViewScale()[0];
      CropLayout.b(this.YlA, f3);
      f3 = this.YlA.getContentRectF().centerX();
      float f4 = this.YlA.getContentRectF().centerY();
      CropLayout.b(this.YlA, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    r(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164402);
      this.YlA.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164401);
          this.YlM.Goj.invoke();
          AppMethodBeat.o(164401);
        }
      });
      AppMethodBeat.o(164402);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */