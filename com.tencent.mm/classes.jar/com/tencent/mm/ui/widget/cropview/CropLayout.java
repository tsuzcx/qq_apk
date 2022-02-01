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
import kotlin.g.b.p;
import kotlin.g.b.z.c;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "contentBaseRect", "Landroid/graphics/Rect;", "getContentBaseRect", "()Landroid/graphics/Rect;", "setContentBaseRect", "(Landroid/graphics/Rect;)V", "contentCenterRect", "getContentCenterRect", "setContentCenterRect", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentRectF", "Landroid/graphics/RectF;", "getContentRectF", "()Landroid/graphics/RectF;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "getInitFinish", "()Lkotlin/jvm/functions/Function1;", "setInitFinish", "(Lkotlin/jvm/functions/Function1;)V", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "setShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "getTmpRectF", "values", "visibilityRect", "getVisibilityRect", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onSingleTapUp", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final CropLayout.a QMC;
  private final RectF BZj;
  private c GGN;
  private b QLZ;
  private b<? super Matrix, Boolean> QMA;
  private final float[] QMB;
  private float QMa;
  private float QMb;
  private float QMc;
  private float QMd;
  private boolean QMe;
  protected boolean QMf;
  private final Rect QMg;
  private final Rect QMh;
  private final RectF QMi;
  private Rect QMj;
  private e QMk;
  boolean QMl;
  private boolean QMm;
  private boolean QMn;
  private boolean QMo;
  private float QMp;
  private float QMq;
  private boolean QMr;
  private final float[] QMs;
  private Animator QMt;
  private final float[] QMu;
  private boolean QMv;
  private boolean QMw;
  private Animator QMx;
  private Animator QMy;
  private Animator QMz;
  private View contentView;
  private View.OnClickListener dec;
  private Matrix dgW;
  private final Matrix rM;
  private final Rect rwL;
  private final RectF vY;
  private float[] values;
  private Rect xne;
  private float xnf;
  
  static
  {
    AppMethodBeat.i(164441);
    QMC = new CropLayout.a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.dgW = new Matrix();
    this.QMa = 0.25F;
    this.QMb = 5.0F;
    this.QMc = 1.0F;
    this.QMd = 1.0F;
    this.QMe = true;
    this.xnf = 1.0F;
    this.BZj = new RectF();
    this.QMg = new Rect();
    this.QMh = new Rect();
    this.rwL = new Rect();
    this.QMi = new RectF();
    this.QMj = new Rect();
    this.xne = new Rect();
    this.QMk = e.QMD;
    this.QMl = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rM = new Matrix();
    this.QMs = new float[2];
    this.QMu = new float[2];
    this.QMA = ((b)CropLayout.f.QMH);
    this.vY = new RectF();
    this.QMB = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.dgW = new Matrix();
    this.QMa = 0.25F;
    this.QMb = 5.0F;
    this.QMc = 1.0F;
    this.QMd = 1.0F;
    this.QMe = true;
    this.xnf = 1.0F;
    this.BZj = new RectF();
    this.QMg = new Rect();
    this.QMh = new Rect();
    this.rwL = new Rect();
    this.QMi = new RectF();
    this.QMj = new Rect();
    this.xne = new Rect();
    this.QMk = e.QMD;
    this.QMl = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rM = new Matrix();
    this.QMs = new float[2];
    this.QMu = new float[2];
    this.QMA = ((b)CropLayout.f.QMH);
    this.vY = new RectF();
    this.QMB = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.dgW = new Matrix();
    this.QMa = 0.25F;
    this.QMb = 5.0F;
    this.QMc = 1.0F;
    this.QMd = 1.0F;
    this.QMe = true;
    this.xnf = 1.0F;
    this.BZj = new RectF();
    this.QMg = new Rect();
    this.QMh = new Rect();
    this.rwL = new Rect();
    this.QMi = new RectF();
    this.QMj = new Rect();
    this.xne = new Rect();
    this.QMk = e.QMD;
    this.QMl = true;
    paramContext = getContext();
    p.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.rM = new Matrix();
    this.QMs = new float[2];
    this.QMu = new float[2];
    this.QMA = ((b)CropLayout.f.QMH);
    this.vY = new RectF();
    this.QMB = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void aB(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    b localb = this.QLZ;
    if (localb != null) {
      localb.onScroll(-paramFloat1, -paramFloat2);
    }
    this.dgW.postTranslate(-paramFloat1, -paramFloat2);
    hbh();
    AppMethodBeat.o(164433);
  }
  
  private final void cA(float paramFloat)
  {
    AppMethodBeat.i(204903);
    this.dgW.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    hbh();
    AppMethodBeat.o(204903);
  }
  
  private final void e(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      aB(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (hbc())
    {
      f = paramFloat1;
      if (hbe()) {
        f = paramFloat1 * 0.4F;
      }
      if (!hbd()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!hbf()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      aB(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.dgW.getValues(this.values);
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
    this.dgW.getValues(this.values);
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private boolean hbc()
  {
    AppMethodBeat.i(164421);
    if (this.QMi.width() > this.BZj.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.QMv != true)) {
        this.QMn = true;
      }
      this.QMv = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private final boolean hbe()
  {
    return (this.BZj.left < this.QMi.left) || (this.BZj.right > this.QMi.right);
  }
  
  private boolean hbf()
  {
    return (this.BZj.top < this.QMi.top) || (this.BZj.bottom > this.QMi.bottom);
  }
  
  private void hbg()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.QMx;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.QNk)
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.QMi.left - this.BZj.left);
    int j = (int)(this.QMi.top - this.BZj.top);
    int m = (int)(this.BZj.right - this.QMi.right);
    int k = (int)(this.BZj.bottom - this.QMi.bottom);
    if ((hbe()) && (i > 0)) {
      if (hbc())
      {
        if ((!hbf()) || (j <= 0)) {
          break label287;
        }
        if (!hbd()) {
          break label267;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        c localc = this.GGN;
        localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          ((d)localObject).fDk();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.QMi.centerX() - this.BZj.centerX());
          break;
          if ((hbe()) && (m > 0))
          {
            if (hbc())
            {
              i = -m;
              break;
            }
            i = (int)(this.QMi.centerX() - this.BZj.centerX());
            break;
          }
          i = 0;
          break;
          label267:
          j = (int)(this.QMi.centerY() - this.BZj.centerY());
          continue;
          label287:
          if ((hbf()) && (k > 0))
          {
            if (hbd())
            {
              j = -k;
              continue;
            }
            j = (int)(this.QMi.centerY() - this.BZj.centerY());
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
    this.QMx = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private void j(RectF paramRectF)
  {
    AppMethodBeat.i(204901);
    p.h(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.QMj.width(), paramRectF.height() * 1.0F / this.QMj.height());
    float f2;
    float f1;
    if (this.QMi.height() > this.BZj.height())
    {
      f2 = this.QMi.centerX() - this.BZj.centerX();
      f1 = this.QMi.top - this.BZj.top;
    }
    for (;;)
    {
      this.xnf = f3;
      this.QMc = (this.QMa * this.xnf);
      this.QMd = (this.QMb * this.xnf);
      aB(f2, f1);
      u(f3, this.BZj.centerX(), this.BZj.centerY());
      this.QMi.round(this.xne);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
      AppMethodBeat.o(204901);
      return;
      if (this.QMi.width() > this.BZj.width())
      {
        f2 = this.QMi.left - this.BZj.left;
        f1 = this.QMi.centerY() - this.BZj.centerY();
      }
      else
      {
        f2 = this.QMi.centerX() - this.BZj.centerX();
        f1 = this.QMi.centerY() - this.BZj.centerY();
      }
    }
  }
  
  private void k(RectF paramRectF)
  {
    AppMethodBeat.i(164426);
    p.h(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.QMj.width(), paramRectF.height() * 1.0F / this.QMj.height());
    float f2 = this.QMi.centerX() - this.BZj.centerX();
    float f3 = this.QMi.centerY() - this.BZj.centerY();
    this.xnf = f1;
    this.QMc = (this.QMa * this.xnf);
    this.QMd = (this.QMb * this.xnf);
    aB(f2, f3);
    u(f1, this.BZj.centerX(), this.BZj.centerY());
    this.QMi.round(this.xne);
    new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
    AppMethodBeat.o(164426);
  }
  
  private void l(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    p.h(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.QMj.width(), paramRectF.height() * 1.0F / this.QMj.height());
    float f2 = this.QMi.centerX() - this.BZj.centerX();
    float f3 = this.QMi.centerY() - this.BZj.centerY();
    this.xnf = f1;
    this.QMc = (this.QMa * this.xnf);
    this.QMd = (this.QMb * this.xnf);
    aB(f2, f3);
    u(f1, this.BZj.centerX(), this.BZj.centerY());
    this.QMi.round(this.xne);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
    AppMethodBeat.o(164427);
  }
  
  private final void u(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.QMi.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.QMi.left) / this.QMi.width();
    float f2 = (paramFloat3 - this.QMi.top) / this.QMi.height();
    cA(paramFloat1);
    b localb = this.QLZ;
    if (localb != null) {
      localb.o(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.QMi.left;
    float f3 = this.QMi.width();
    float f4 = this.QMi.top;
    float f5 = this.QMi.height();
    this.dgW.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    hbh();
    AppMethodBeat.o(164432);
  }
  
  public final void De(boolean paramBoolean)
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
    p.h(paramView, "view");
    p.h(paramMatrix, "matrix");
    p.h(parame, "scaleType");
    p.h(paramb, "initFinish");
    this.QMh.set(0, 0, paramInt1, paramInt2);
    this.QMA = paramb;
    this.contentView = paramView;
    this.dgW = paramMatrix;
    this.QMe = paramMatrix.isIdentity();
    this.QMf = true;
    this.QMk = parame;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<x> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    p.h(parama, "onAnimationEnd");
    Object localObject = this.QMy;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.QMi.centerX();
    float f3 = this.QMi.centerY();
    float f4 = this.xne.exactCenterX();
    float f5 = this.xne.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.xnf });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new q(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new r(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    ((ValueAnimator)localObject).start();
    this.QMz = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ad(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    p.h(paramMotionEvent, "e1");
    super.ad(paramMotionEvent);
    this.QMn = false;
    this.QMo = false;
    this.QMl = false;
    paramMotionEvent = this.QMt;
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
      if (!this.QNk) {
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
        hbg();
      }
      this.QMr = false;
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
        bool2 = hbc();
        bool3 = hbd();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.QMt;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.QMy;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.QMi.centerX();
    float f3 = this.QMi.centerY();
    float f4 = this.BZj.centerX();
    float f5 = this.BZj.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.BZj.width() / this.QMi.width();
    float f7 = this.BZj.height() / this.QMi.height();
    label263:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label376:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.QMk == e.QMD)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.BZj.right - this.QMi.right;
      f3 = this.BZj.left - this.QMi.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label675;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.BZj.bottom - this.QMi.bottom;
      f5 = this.BZj.top - this.QMi.top;
      if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
        break label698;
      }
      f1 = f5;
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
      new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
      paramMotionEvent = new z.c();
      paramMotionEvent.SYD = 0.0F;
      final z.c localc = new z.c();
      localc.SYD = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new n(this, bool3, bool2, paramMotionEvent, localc));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.QMy = ((Animator)localObject);
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
    AppMethodBeat.i(204896);
    p.h(paramRectF, "rectF");
    float f1 = this.BZj.bottom - this.QMi.bottom;
    float f2 = this.BZj.top;
    float f3 = this.QMi.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      e(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.BZj.set(paramRectF);
      AppMethodBeat.o(204896);
      return;
      if ((this.QMi.height() <= this.BZj.height()) || (paramBoolean))
      {
        t(1.0F * this.BZj.height() / this.QMi.height(), this.QMi.centerX(), this.QMi.bottom);
        e(0.0F, -(this.BZj.bottom - this.QMi.bottom), 4);
      }
    }
  }
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164409);
    if (this.BZj.isEmpty()) {
      this.BZj.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.QMf)
      {
        this.QMf = false;
        if (this.QMe) {
          this.dgW.reset();
        }
        this.QMj.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.QMj.exactCenterX());
        ((View)localObject).setPivotY(this.QMj.exactCenterY());
        this.vY.set(this.QMj);
        this.dgW.mapRect(this.vY);
        this.vY.round(this.rwL);
        this.QMi.set(this.vY);
        if (this.QMe)
        {
          this.dgW.reset();
          localObject = this.QMk;
          switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
          {
          }
          while (((Boolean)this.QMA.invoke(this.dgW)).booleanValue())
          {
            hbh();
            this.QMi.round(this.xne);
            AppMethodBeat.o(164409);
            return;
            l(this.BZj);
            continue;
            k(this.BZj);
            continue;
            j(this.BZj);
          }
        }
        if (((Boolean)this.QMA.invoke(this.dgW)).booleanValue())
        {
          hbh();
          this.QMi.round(this.xne);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.QMk;
        switch (a.haE[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        l(this.BZj);
        AppMethodBeat.o(164409);
        return;
        k(this.BZj);
        AppMethodBeat.o(164409);
        return;
        j(this.BZj);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final View.OnClickListener getClickListener()
  {
    return this.dec;
  }
  
  protected final Rect getContentBaseRect()
  {
    return this.QMj;
  }
  
  public final Rect getContentCenterRect()
  {
    return this.xne;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.QMh;
  }
  
  public final Rect getContentRect()
  {
    return this.rwL;
  }
  
  public final RectF getContentRectF()
  {
    return this.QMi;
  }
  
  protected final View getContentView()
  {
    return this.contentView;
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
  
  public final float[] getContentViewTrans()
  {
    AppMethodBeat.i(164435);
    this.dgW.getValues(this.values);
    float f1 = this.values[2];
    float f2 = this.values[5];
    this.QMB[0] = f1;
    this.QMB[1] = f2;
    float[] arrayOfFloat = this.QMB;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  public final b getCropLayoutTouchListener()
  {
    return this.QLZ;
  }
  
  protected final b<Matrix, Boolean> getInitFinish()
  {
    return this.QMA;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.dgW;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.QMb;
  }
  
  public final float getMaxScaleValue()
  {
    return this.QMd;
  }
  
  public final float getMinScaleFactor()
  {
    return this.QMa;
  }
  
  public final float getMinScaleValue()
  {
    return this.QMc;
  }
  
  public final c getOnChangeListener()
  {
    return this.GGN;
  }
  
  public final e getScaleType()
  {
    return this.QMk;
  }
  
  protected final RectF getTmpRectF()
  {
    return this.vY;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.BZj;
  }
  
  public final Rect getWidgetRect()
  {
    return this.QMg;
  }
  
  public final void hba()
  {
    AppMethodBeat.i(204899);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    z.c localc = new z.c();
    localc.SYD = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new j(localc, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(204899);
  }
  
  public final void hbb()
  {
    AppMethodBeat.i(204900);
    final float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(204900);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    z.c localc = new z.c();
    localc.SYD = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(localc, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(204900);
  }
  
  protected final boolean hbd()
  {
    AppMethodBeat.i(164422);
    if (this.QMi.height() > this.BZj.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.QMw != true)) {
        this.QMo = true;
      }
      this.QMw = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  protected final void hbh()
  {
    AppMethodBeat.i(164434);
    Object localObject = this.contentView;
    float[] arrayOfFloat;
    float f;
    if (localObject != null)
    {
      arrayOfFloat = getMatrixValues();
      f = getContentViewScale()[0];
      kotlin.g.b.l locall = kotlin.g.b.l.SYx;
      if (f != kotlin.g.b.l.hyb())
      {
        locall = kotlin.g.b.l.SYx;
        if ((f != kotlin.g.b.l.hya()) && (!Float.isNaN(f))) {
          break label136;
        }
      }
    }
    for (;;)
    {
      localObject = this.contentView;
      if (localObject != null)
      {
        this.vY.set(this.QMj);
        ((View)localObject).getMatrix().mapRect(this.vY);
        this.QMi.set(this.vY);
        this.vY.round(this.rwL);
      }
      localObject = this.GGN;
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
    c localc = this.GGN;
    paramMotionEvent = localc;
    if (!(localc instanceof d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (d)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.fDj();
    }
    paramMotionEvent = this.QMt;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.QMx;
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
    if (!this.QNj)
    {
      AppMethodBeat.o(164420);
      return false;
    }
    float f2 = 0.5F * paramFloat1;
    float f1 = 0.5F * paramFloat2;
    if ((this.QMm) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = hbe();
    boolean bool2 = hbf();
    boolean bool3 = hbc();
    boolean bool4 = hbd();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.QMi.left < this.BZj.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.QMi.right <= this.BZj.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.QMk == e.QMD) || (this.QMk == e.QMF))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.QMi.top < this.BZj.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.QMi.bottom <= this.BZj.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.QMk == e.QMD) || (this.QMk == e.QMF))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.QMt;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.QMu[0] = 0.0F;
    this.QMu[1] = 0.0F;
    f1 = this.QMi.right;
    f2 = this.BZj.right;
    float f3 = this.BZj.left;
    float f4 = this.QMi.left;
    if (paramFloat1 < 0.0F)
    {
      this.QMu[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.QMi.bottom;
      f2 = this.BZj.bottom;
      f3 = this.BZj.top;
      f4 = this.QMi.top;
      if (paramFloat2 >= 0.0F) {
        break label710;
      }
      this.QMu[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.QMu;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new h(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.QMt = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.QMu[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label710:
      this.QMu[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.QMg.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.QMf = true;
    }
    e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164407);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164416);
    p.h(paramScaleGestureDetector, "detector");
    t(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    AppMethodBeat.o(164416);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164413);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    if (this.QNl) {
      e(paramFloat1, paramFloat2, 0);
    }
    AppMethodBeat.o(164413);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204898);
    p.h(paramMotionEvent, "e");
    View.OnClickListener localOnClickListener = this.dec;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((View)this);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(204898);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164414);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      this.QMm = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.QMm = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.BZj.setEmpty();
    this.rwL.setEmpty();
    this.QMi.setEmpty();
    this.xne.setEmpty();
    this.QMj.setEmpty();
    this.vY.setEmpty();
    this.dgW = new Matrix();
    this.xnf = 1.0F;
    this.QMc = 1.0F;
    this.QMd = 1.0F;
    this.QMb = 5.0F;
    this.QMa = 0.25F;
    this.QMp = 0.0F;
    this.QMq = 0.0F;
    this.QMB[0] = 0.0F;
    this.QMB[1] = 0.0F;
    this.QMe = true;
    this.QMf = false;
    this.QMl = true;
    this.QMA = ((b)CropLayout.k.QMM);
    this.values = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.dec = paramOnClickListener;
  }
  
  protected final void setContentBaseRect(Rect paramRect)
  {
    AppMethodBeat.i(204895);
    p.h(paramRect, "<set-?>");
    this.QMj = paramRect;
    AppMethodBeat.o(204895);
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    p.h(paramRect, "<set-?>");
    this.xne = paramRect;
    AppMethodBeat.o(164404);
  }
  
  protected final void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public final void setCropLayoutTouchListener(b paramb)
  {
    this.QLZ = paramb;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.QMl = paramBoolean;
  }
  
  protected final void setInitFinish(b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(204902);
    p.h(paramb, "<set-?>");
    this.QMA = paramb;
    AppMethodBeat.o(204902);
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    p.h(paramMatrix, "<set-?>");
    this.dgW = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.QMb = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.QMd = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.QMa = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.QMc = paramFloat;
  }
  
  public final void setOnChangeListener(c paramc)
  {
    this.GGN = paramc;
  }
  
  public final void setScaleType(e parame)
  {
    AppMethodBeat.i(164405);
    p.h(parame, "<set-?>");
    this.QMk = parame;
    AppMethodBeat.o(164405);
  }
  
  protected final void setShouldLayout(boolean paramBoolean)
  {
    this.QMf = paramBoolean;
  }
  
  protected final void t(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.QMc) || (getContentViewScale()[0] * paramFloat1 > this.QMd))
    {
      if (!this.QMr)
      {
        performHapticFeedback(0, 2);
        this.QMr = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      u(paramFloat1, paramFloat2, paramFloat3);
      this.QMp = paramFloat2;
      this.QMq = paramFloat3;
    }
    AppMethodBeat.o(164417);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "", "onScale", "", "scaleFactor", "", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void o(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void onScroll(float paramFloat1, float paramFloat2);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void onChange();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChangeEnd", "", "onChangeStart", "libmmui_release"})
  public static abstract interface d
    extends CropLayout.c
  {
    public abstract void fDj();
    
    public abstract void fDk();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(164380);
      e locale1 = new e("CENTER_CROP", 0);
      QMD = locale1;
      e locale2 = new e("CENTER_INSIDE", 1);
      QME = locale2;
      e locale3 = new e("ALIGN_START", 2);
      QMF = locale3;
      QMG = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(164380);
    }
    
    private e() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float aTD;
    private float aTE;
    
    g(CropLayout paramCropLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164386);
      p.h(paramValueAnimator, "it");
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
      CropLayout.a(this.QMI, this.aTD - f1, this.aTE - f2);
      this.aTD = f1;
      this.aTE = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164387);
      CropLayout.a(this.QMI);
      AppMethodBeat.o(164387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
  static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(z.c paramc, CropLayout paramCropLayout, float paramFloat) {}
    
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
      CropLayout.a(jdField_this, f - this.QMJ.SYD);
      this.QMJ.SYD = f;
      AppMethodBeat.o(164388);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRotate$1$1"})
  static final class j
    implements ValueAnimator.AnimatorUpdateListener
  {
    j(z.c paramc, CropLayout paramCropLayout) {}
    
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
      CropLayout.a(jdField_this, f - this.QMJ.SYD);
      this.QMJ.SYD = f;
      AppMethodBeat.o(164389);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class m
    implements ValueAnimator.AnimatorUpdateListener
  {
    m(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, z.c paramc1, z.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.QMI.getScaleType() == CropLayout.e.QME) && (!bool3) && (!bool2)) || ((this.QMI.getScaleType() == CropLayout.e.QMD) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.QMI.getContentViewScale()[0];
        CropLayout.a(this.QMI, f1, this.QMI.getContentRectF().centerX(), this.QMI.getContentRectF().centerY());
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
      float f7 = paramMotionEvent.SYD;
      float f5 = localc.SYD;
      float f8 = this.QMI.getContentRectF().centerX();
      float f6 = this.QMI.getContentRectF().centerY();
      paramValueAnimator = this.QMI;
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
        paramMotionEvent.SYD = f3;
        localc.SYD = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    n(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, z.c paramc1, z.c paramc2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204894);
      CropLayout.c localc = this.QMI.getOnChangeListener();
      paramAnimator = localc;
      if (!(localc instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.fDk();
        AppMethodBeat.o(204894);
        return;
      }
      AppMethodBeat.o(204894);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int wcr;
    private int wqz;
    
    o(CropLayout paramCropLayout, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164395);
      p.h(paramValueAnimator, "it");
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
      CropLayout.b(this.QMI, i - this.wcr, j - this.wqz);
      this.wcr = i;
      this.wqz = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(CropLayout paramCropLayout, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.QMS;
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
      Object localObject = this.QMS;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.QMI.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.d)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.d)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.fDk();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      p.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.QMS;
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
      Animator.AnimatorListener localAnimatorListener = this.QMS;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
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
      CropLayout.c(this.QMI);
      f3 = f3 * 1.0F / this.QMI.getContentViewScale()[0];
      CropLayout.b(this.QMI, f3);
      f3 = this.QMI.getContentRectF().centerX();
      float f4 = this.QMI.getContentRectF().centerY();
      CropLayout.b(this.QMI, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    r(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164402);
      this.QMI.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164401);
          this.QMU.Axu.invoke();
          AppMethodBeat.o(164401);
        }
      });
      AppMethodBeat.o(164402);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */