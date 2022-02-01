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
import d.g.b.v.b;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerAnimator", "Landroid/animation/Animator;", "contentBaseRect", "Landroid/graphics/Rect;", "contentCenterRect", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentOriginalRect", "getContentOriginalRect", "contentRect", "getContentRect", "contentView", "Landroid/view/View;", "cropLayoutTouchListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "getCropLayoutTouchListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setCropLayoutTouchListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;)V", "edgeAnimation", "fixTrans", "", "flingAnimator", "hasMorePoint", "", "initFinish", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "matrix", "initScale", "", "isChangeToOverHorizontal", "isChangeToOverVertical", "isFirstCancelOrUp", "()Z", "setFirstCancelOrUp", "(Z)V", "isHasHaptic", "isLastOverHorizontal", "isLastOverVertical", "isShouldCalculateMatrix", "isShouldLayout", "lastFocusX", "lastFocusY", "mainMatrix", "getMainMatrix", "()Landroid/graphics/Matrix;", "setMainMatrix", "(Landroid/graphics/Matrix;)V", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "minScaleValue", "getMinScaleValue", "setMinScaleValue", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "point", "revertAnimator", "scaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "tmpArray", "tmpMatrix", "tmpRectF", "Landroid/graphics/RectF;", "values", "visibilityRect", "getVisibilityRect", "()Landroid/graphics/RectF;", "widgetRect", "getWidgetRect", "alignStart", "", "widget", "isWithAnimation", "calculateLayout", "changed", "left", "top", "right", "bottom", "centerCrop", "centerInside", "checkMatrixValues", "fixOverTrans", "distanceX", "distanceY", "getContentViewScale", "getContentViewTrans", "getMatrixValues", "getRotate", "getRotateDegrees", "isOverEdgeHorizontal", "isOverEdgeVertical", "isOverHorizontal", "isOverVertical", "mapMatrix", "onChangeVisibilityRect", "rectF", "isHard", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDown", "onFling", "e1", "e2", "offsetX", "offsetY", "onLayout", "onRevertRotate", "onRotate", "degrees", "onRotateImpl", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleImpl", "scaleFactor", "focusX", "focusY", "onScroll", "onScrollImpl", "source", "onTouch", "v", "event", "onTouchCancel", "removeContentView", "isNeedReset", "reset", "setContentView", "view", "width", "height", "startCenterAnim", "startEdgeAnimation", "listener", "Landroid/animation/Animator$AnimatorListener;", "startRevertAnimation", "onAnimationEnd", "Lkotlin/Function0;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transformScale", "transformScroll", "transX", "transY", "transformScrollAtom", "Companion", "CropLayoutTouchListener", "OnChangeListener", "OnChangeStartEndListener", "ScaleType", "libmmui_release"})
public class CropLayout
  extends BaseCropLayout
{
  public static final a HDH;
  private boolean HDA;
  private boolean HDB;
  private Animator HDC;
  private Animator HDD;
  private Animator HDE;
  private b<? super Matrix, Boolean> HDF;
  private final float[] HDG;
  private b HDf;
  private float HDg;
  private float HDh;
  private float HDi;
  private float HDj;
  private boolean HDk;
  private boolean HDl;
  private final Rect HDm;
  private final Rect HDn;
  private Rect HDo;
  private c HDp;
  boolean HDq;
  private boolean HDr;
  private boolean HDs;
  private boolean HDt;
  private float HDu;
  private float HDv;
  private boolean HDw;
  private final float[] HDx;
  private Animator HDy;
  private final float[] HDz;
  private CropLayout.p LDh;
  private Matrix cHF;
  private View contentView;
  private final Matrix oQ;
  private final Rect oSt;
  private final RectF rFV;
  private Rect rGK;
  private float rGL;
  private final RectF sZ;
  private float[] values;
  
  static
  {
    AppMethodBeat.i(164441);
    HDH = new a((byte)0);
    AppMethodBeat.o(164441);
  }
  
  public CropLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164438);
    this.cHF = new Matrix();
    this.HDg = 0.25F;
    this.HDh = 5.0F;
    this.HDi = 1.0F;
    this.HDj = 1.0F;
    this.HDk = true;
    this.rGL = 1.0F;
    this.rFV = new RectF();
    this.HDm = new Rect();
    this.HDn = new Rect();
    this.oSt = new Rect();
    this.HDo = new Rect();
    this.rGK = new Rect();
    this.HDp = c.HDI;
    this.HDq = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.oQ = new Matrix();
    this.HDx = new float[2];
    this.HDz = new float[2];
    this.HDF = ((b)d.HDM);
    this.sZ = new RectF();
    this.HDG = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164438);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164439);
    this.cHF = new Matrix();
    this.HDg = 0.25F;
    this.HDh = 5.0F;
    this.HDi = 1.0F;
    this.HDj = 1.0F;
    this.HDk = true;
    this.rGL = 1.0F;
    this.rFV = new RectF();
    this.HDm = new Rect();
    this.HDn = new Rect();
    this.oSt = new Rect();
    this.HDo = new Rect();
    this.rGK = new Rect();
    this.HDp = c.HDI;
    this.HDq = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.oQ = new Matrix();
    this.HDx = new float[2];
    this.HDz = new float[2];
    this.HDF = ((b)d.HDM);
    this.sZ = new RectF();
    this.HDG = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164439);
  }
  
  public CropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164440);
    this.cHF = new Matrix();
    this.HDg = 0.25F;
    this.HDh = 5.0F;
    this.HDi = 1.0F;
    this.HDj = 1.0F;
    this.HDk = true;
    this.rGL = 1.0F;
    this.rFV = new RectF();
    this.HDm = new Rect();
    this.HDn = new Rect();
    this.oSt = new Rect();
    this.HDo = new Rect();
    this.rGK = new Rect();
    this.HDp = c.HDI;
    this.HDq = true;
    paramContext = getContext();
    k.g(paramContext, "context");
    setBackgroundColor(paramContext.getResources().getColor(17170444));
    this.oQ = new Matrix();
    this.HDx = new float[2];
    this.HDz = new float[2];
    this.HDF = ((b)d.HDM);
    this.sZ = new RectF();
    this.HDG = new float[2];
    this.values = new float[9];
    AppMethodBeat.o(164440);
  }
  
  private final void aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164433);
    CropLayout.p localp = this.LDh;
    if (localp != null) {
      localp.onScroll(-paramFloat1, -paramFloat2);
    }
    this.cHF.postTranslate(-paramFloat1, -paramFloat2);
    ffp();
    AppMethodBeat.o(164433);
  }
  
  private final void cc(float paramFloat)
  {
    AppMethodBeat.i(203960);
    this.cHF.postScale(paramFloat, paramFloat, 0.0F, 0.0F);
    ffp();
    AppMethodBeat.o(203960);
  }
  
  private final void d(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(164415);
    if (paramInt == 4)
    {
      aj(paramFloat1, paramFloat2);
      AppMethodBeat.o(164415);
      return;
    }
    float f;
    if (ffk())
    {
      f = paramFloat1;
      if (ffm()) {
        f = paramFloat1 * 0.4F;
      }
      if (!ffl()) {
        break label90;
      }
      paramFloat1 = paramFloat2;
      if (!ffn()) {}
    }
    label90:
    for (paramFloat1 = paramFloat2 * 0.4F;; paramFloat1 = 0.0F)
    {
      aj(f, paramFloat1);
      AppMethodBeat.o(164415);
      return;
      f = 0.0F;
      break;
    }
  }
  
  private boolean ffk()
  {
    AppMethodBeat.i(164421);
    if (this.oSt.width() > this.rFV.width()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.HDA != true)) {
        this.HDs = true;
      }
      this.HDA = bool;
      AppMethodBeat.o(164421);
      return bool;
    }
  }
  
  private boolean ffm()
  {
    return (this.rFV.left < this.oSt.left) || (this.rFV.right > this.oSt.right);
  }
  
  private boolean ffn()
  {
    return (this.rFV.top < this.oSt.top) || (this.rFV.bottom > this.oSt.bottom);
  }
  
  private void ffo()
  {
    AppMethodBeat.i(164423);
    Object localObject = this.HDC;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.HEu)
    {
      AppMethodBeat.o(164423);
      return;
    }
    int i = (int)(this.oSt.left - this.rFV.left);
    int j = (int)(this.oSt.top - this.rFV.top);
    int m = (int)(this.rFV.right - this.oSt.right);
    int k = (int)(this.rFV.bottom - this.oSt.bottom);
    if ((ffm()) && (i > 0)) {
      if (ffk())
      {
        if ((!ffn()) || (j <= 0)) {
          break label294;
        }
        if (!ffl()) {
          break label273;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0))
      {
        b localb = this.HDf;
        localObject = localb;
        if (!(localb instanceof CropLayout.q)) {
          localObject = null;
        }
        localObject = (CropLayout.q)localObject;
        if (localObject != null)
        {
          ((CropLayout.q)localObject).fZk();
          AppMethodBeat.o(164423);
          return;
          i = (int)(this.oSt.centerX() - this.rFV.centerX());
          break;
          if ((ffm()) && (m > 0))
          {
            if (ffk())
            {
              i = -m;
              break;
            }
            i = (int)(this.oSt.centerX() - this.rFV.centerX());
            break;
          }
          i = 0;
          break;
          label273:
          j = (int)(this.oSt.centerY() - this.rFV.centerY());
          continue;
          label294:
          if ((ffn()) && (k > 0))
          {
            if (ffl())
            {
              j = -k;
              continue;
            }
            j = (int)(this.oSt.centerY() - this.rFV.centerY());
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
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new m(this));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(160L);
    ((ValueAnimator)localObject).start();
    this.HDC = ((Animator)localObject);
    AppMethodBeat.o(164423);
  }
  
  private final void ffp()
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
      this.sZ.set(this.HDo);
      ((View)localObject).getMatrix().mapRect(this.sZ);
      this.sZ.round(this.oSt);
    }
    localObject = this.HDf;
    if (localObject != null)
    {
      ((b)localObject).onChange();
      AppMethodBeat.o(164434);
      return;
    }
    AppMethodBeat.o(164434);
  }
  
  private final float[] getContentViewTrans()
  {
    AppMethodBeat.i(164435);
    this.cHF.getValues(this.values);
    float f1 = this.values[2];
    float f2 = this.values[5];
    this.HDG[0] = f1;
    this.HDG[1] = f2;
    float[] arrayOfFloat = this.HDG;
    AppMethodBeat.o(164435);
    return arrayOfFloat;
  }
  
  private final float[] getMatrixValues()
  {
    AppMethodBeat.i(164437);
    this.cHF.getValues(this.values);
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
    this.cHF.getValues(this.values);
    float f = -(float)Math.round(Math.atan2(this.values[1], this.values[0]) * 57.295779513082323D);
    AppMethodBeat.o(164418);
    return f;
  }
  
  private void h(RectF paramRectF)
  {
    AppMethodBeat.i(190963);
    k.h(paramRectF, "widget");
    float f3 = Math.max(paramRectF.width() * 1.0F / this.HDo.width(), paramRectF.height() * 1.0F / this.HDo.height());
    float f2;
    float f1;
    if (this.oSt.height() > this.rFV.height())
    {
      f2 = this.oSt.centerX() - this.rFV.centerX();
      f1 = this.oSt.top - this.rFV.top;
    }
    for (;;)
    {
      this.rGL = f3;
      this.HDi = (this.HDg * this.rGL);
      this.HDj = (this.HDh * this.rGL);
      aj(f2, f1);
      p(f3, this.rFV.centerX(), this.rFV.centerY());
      this.rGK.set(this.oSt);
      new StringBuilder("[alignStart] scale=").append(f3).append(" offsetX=").append(f2).append(" offsetY=").append(f1).append(" contentBaseRect=").append(this.HDo).append(" contentRect=").append(this.oSt);
      AppMethodBeat.o(190963);
      return;
      if (this.oSt.width() > this.rFV.width())
      {
        f2 = this.oSt.left - this.rFV.left;
        f1 = this.oSt.centerY() - this.rFV.centerY();
      }
      else
      {
        f2 = this.oSt.centerX() - this.rFV.centerX();
        f1 = this.oSt.centerY() - this.rFV.centerY();
      }
    }
  }
  
  private void j(RectF paramRectF)
  {
    AppMethodBeat.i(164427);
    k.h(paramRectF, "widget");
    float f1 = Math.min(paramRectF.width() * 1.0F / this.HDo.width(), paramRectF.height() * 1.0F / this.HDo.height());
    float f2 = this.oSt.exactCenterX() - this.rFV.centerX();
    float f3 = this.oSt.exactCenterY() - this.rFV.centerY();
    this.rGL = f1;
    this.HDi = (this.HDg * this.rGL);
    this.HDj = (this.HDh * this.rGL);
    aj(f2, f3);
    p(f1, this.rFV.centerX(), this.rFV.centerY());
    this.rGK.set(this.oSt);
    new StringBuilder("[centerInside] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.HDo).append(" contentRect=").append(this.oSt);
    AppMethodBeat.o(164427);
  }
  
  private final void p(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164432);
    if (this.oSt.isEmpty())
    {
      AppMethodBeat.o(164432);
      return;
    }
    float f1 = (paramFloat2 - this.oSt.left) / this.oSt.width();
    float f2 = (paramFloat3 - this.oSt.top) / this.oSt.height();
    cc(paramFloat1);
    CropLayout.p localp = this.LDh;
    if (localp != null) {
      localp.b(paramFloat1, paramFloat2, paramFloat3);
    }
    paramFloat1 = this.oSt.left;
    float f3 = this.oSt.width();
    float f4 = this.oSt.top;
    float f5 = this.oSt.height();
    this.cHF.postTranslate(paramFloat2 - (f1 * f3 + paramFloat1), paramFloat3 - (f2 * f5 + f4));
    ffp();
    AppMethodBeat.o(164432);
  }
  
  public final void a(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(203959);
    k.h(paramRectF, "widget");
    float f1 = Math.max(paramRectF.width() * 1.0F / this.HDo.width(), paramRectF.height() * 1.0F / this.HDo.height());
    float f2 = this.oSt.exactCenterX() - this.rFV.centerX();
    float f3 = this.oSt.exactCenterY() - this.rFV.centerY();
    this.rGL = f1;
    this.HDi = (this.HDg * this.rGL);
    this.HDj = (this.HDh * this.rGL);
    if (!paramBoolean)
    {
      aj(f2, f3);
      p(f1, this.rFV.centerX(), this.rFV.centerY());
      this.rGK.set(this.oSt);
    }
    for (;;)
    {
      new StringBuilder("[centerCrop] scale=").append(f1).append(" offsetX=").append(f2).append(" offsetY=").append(f3).append(" contentBaseRect=").append(this.HDo).append(" contentRect=").append(this.oSt);
      AppMethodBeat.o(203959);
      return;
      a((a)new CropLayout.r(this), null);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, Matrix paramMatrix, c paramc, b<? super Matrix, Boolean> paramb)
  {
    AppMethodBeat.i(164428);
    k.h(paramView, "view");
    k.h(paramMatrix, "matrix");
    k.h(paramc, "scaleType");
    k.h(paramb, "initFinish");
    this.HDn.set(0, 0, paramInt1, paramInt2);
    this.HDF = paramb;
    this.contentView = paramView;
    this.cHF = paramMatrix;
    this.HDk = paramMatrix.isIdentity();
    this.HDl = true;
    this.HDp = paramc;
    removeView(paramView);
    addView(paramView, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
    AppMethodBeat.o(164428);
  }
  
  public final void a(final a<y> parama, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(164425);
    k.h(parama, "onAnimationEnd");
    Object localObject = this.HDD;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    getMatrixValues();
    float f1 = getContentViewScale()[0];
    float f2 = this.oSt.exactCenterX();
    float f3 = this.oSt.exactCenterY();
    float f4 = this.rGK.exactCenterX();
    float f5 = this.rGK.exactCenterY();
    localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f1, this.rGL });
    localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("percent", new float[] { 0.0F, 1.0F }), localObject, PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 }), PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 }) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new n(this, parama, paramAnimatorUpdateListener));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new CropLayout.o(this, parama, paramAnimatorUpdateListener));
    if (paramAnimatorUpdateListener != null) {
      ((ValueAnimator)localObject).addUpdateListener(paramAnimatorUpdateListener);
    }
    ((ValueAnimator)localObject).start();
    this.HDE = ((Animator)localObject);
    AppMethodBeat.o(164425);
  }
  
  public void ai(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164412);
    k.h(paramMotionEvent, "e1");
    super.ai(paramMotionEvent);
    this.HDs = false;
    this.HDt = false;
    this.HDq = false;
    paramMotionEvent = this.HDy;
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
      if (!this.HEu) {
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
        ffo();
      }
      this.HDw = false;
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
        bool2 = ffk();
        bool3 = ffl();
        if ((!bool3) || (!bool2)) {
          break label144;
        }
        i = 0;
      }
    }
    label144:
    paramMotionEvent = this.HDy;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.HDD;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    float f2 = this.oSt.exactCenterX();
    float f3 = this.oSt.exactCenterY();
    float f4 = this.rFV.centerX();
    float f5 = this.rFV.centerY();
    float f6 = getContentViewScale()[0];
    float f1 = this.rFV.width() / this.oSt.width();
    float f7 = this.rFV.height() / this.oSt.height();
    label265:
    Object localObject;
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    label380:
    PropertyValuesHolder localPropertyValuesHolder3;
    if (this.HDp == c.HDI)
    {
      f1 = Math.max(f7, f1);
      localObject = PropertyValuesHolder.ofFloat("scale", new float[] { f6, f1 * f6 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("transX", new float[] { f2, f4 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("transY", new float[] { f3, f5 });
      f2 = this.rFV.right - this.oSt.right;
      f3 = this.rFV.left - this.oSt.left;
      if ((f3 >= 0.0F) || (f2 >= 0.0F)) {
        break label681;
      }
      f1 = f3;
      localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("edgeX", new float[] { 0.0F, f1 });
      f4 = this.rFV.bottom - this.oSt.bottom;
      f5 = this.rFV.top - this.oSt.top;
      if ((f5 >= 0.0F) || (f4 >= 0.0F)) {
        break label704;
      }
      f1 = f5;
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat("edgeY", new float[] { 0.0F, f1 });
      new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f3).append(" edgeRight=").append(f2).append(" edgeTop=").append(f5).append(" edgeBottom=").append(f4);
      paramMotionEvent = new v.b();
      paramMotionEvent.Jht = 0.0F;
      final v.b localb = new v.b();
      localb.Jht = 0.0F;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new k(this, bool3, bool2, paramMotionEvent, localb));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new CropLayout.s(this, bool3, bool2, paramMotionEvent, localb));
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(160L);
      ((ValueAnimator)localObject).start();
      this.HDD = ((Animator)localObject);
      i = 1;
      break;
      f1 = Math.min(f7, f1);
      break label265;
      label681:
      if ((f3 > 0.0F) && (f2 > 0.0F))
      {
        f1 = f2;
        break label380;
      }
      f1 = 0.0F;
      break label380;
      label704:
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
    if (this.rFV.isEmpty()) {
      this.rFV.set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    Object localObject = this.contentView;
    if (localObject != null)
    {
      if (this.HDl)
      {
        this.HDl = false;
        this.HDo.set(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom());
        ((View)localObject).setPivotX(this.HDo.exactCenterX());
        ((View)localObject).setPivotY(this.HDo.exactCenterY());
        this.sZ.set(this.HDo);
        this.cHF.mapRect(this.sZ);
        this.sZ.round(this.oSt);
        if (this.HDk)
        {
          this.cHF.reset();
          localObject = this.HDp;
          switch (a.ciE[localObject.ordinal()])
          {
          }
          while (((Boolean)this.HDF.aA(this.cHF)).booleanValue())
          {
            ffp();
            this.rGK.set(this.oSt);
            AppMethodBeat.o(164409);
            return;
            j(this.rFV);
            continue;
            a(this.rFV, false);
            continue;
            h(this.rFV);
          }
        }
        if (((Boolean)this.HDF.aA(this.cHF)).booleanValue())
        {
          ffp();
          this.rGK.set(this.oSt);
        }
        AppMethodBeat.o(164409);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.HDp;
        switch (a.fPQ[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(164409);
        return;
        j(this.rFV);
        AppMethodBeat.o(164409);
        return;
        a(this.rFV, false);
        AppMethodBeat.o(164409);
        return;
        h(this.rFV);
      }
    }
    AppMethodBeat.o(164409);
  }
  
  public final void ffi()
  {
    AppMethodBeat.i(190961);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, -90.0F }) });
    v.b localb = new v.b();
    localb.Jht = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(localb, this));
    localValueAnimator.setDuration((110.0F * (Math.abs(-90.0F) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(190961);
  }
  
  public final void ffj()
  {
    AppMethodBeat.i(190962);
    final float f = -getRotateDegrees();
    if (f == 0.0F)
    {
      AppMethodBeat.o(190962);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("rotate", new float[] { 0.0F, f }) });
    v.b localb = new v.b();
    localb.Jht = 0.0F;
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(localb, this, f));
    localValueAnimator.setDuration((110.0F * (Math.abs(f) / 90.0F)));
    localValueAnimator.start();
    AppMethodBeat.o(190962);
  }
  
  protected final boolean ffl()
  {
    AppMethodBeat.i(164422);
    if (this.oSt.height() > this.rFV.height()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.HDB != true)) {
        this.HDt = true;
      }
      this.HDB = bool;
      AppMethodBeat.o(164422);
      return bool;
    }
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(164408);
    k.h(paramRectF, "rectF");
    float f1 = this.rFV.bottom - this.oSt.bottom;
    float f2 = this.rFV.top;
    float f3 = this.oSt.top;
    if ((f1 > 0.0F) && (f1 <= f2 - f3)) {
      d(0.0F, -f1, 4);
    }
    for (;;)
    {
      this.rFV.set(paramRectF);
      AppMethodBeat.o(164408);
      return;
      if (this.oSt.height() <= this.rFV.height())
      {
        o(1.0F * this.rFV.height() / this.oSt.height(), this.oSt.exactCenterX(), this.oSt.bottom);
        d(0.0F, -(this.rFV.bottom - this.oSt.bottom), 4);
      }
    }
  }
  
  public final Rect getContentCenterRect()
  {
    return this.rGK;
  }
  
  public final Rect getContentOriginalRect()
  {
    return this.HDn;
  }
  
  public final Rect getContentRect()
  {
    return this.oSt;
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
  
  public final CropLayout.p getCropLayoutTouchListener()
  {
    return this.LDh;
  }
  
  public final Matrix getMainMatrix()
  {
    return this.cHF;
  }
  
  public final float getMaxScaleFactor()
  {
    return this.HDh;
  }
  
  public final float getMaxScaleValue()
  {
    return this.HDj;
  }
  
  public final float getMinScaleFactor()
  {
    return this.HDg;
  }
  
  public final float getMinScaleValue()
  {
    return this.HDi;
  }
  
  public final b getOnChangeListener()
  {
    return this.HDf;
  }
  
  public final c getScaleType()
  {
    return this.HDp;
  }
  
  public final RectF getVisibilityRect()
  {
    return this.rFV;
  }
  
  public final Rect getWidgetRect()
  {
    return this.HDm;
  }
  
  protected final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(164417);
    if ((getContentViewScale()[0] * paramFloat1 < this.HDi) || (getContentViewScale()[0] * paramFloat1 > this.HDj))
    {
      if (!this.HDw)
      {
        performHapticFeedback(0, 2);
        this.HDw = true;
      }
      AppMethodBeat.o(164417);
      return;
    }
    if (this.contentView != null)
    {
      p(paramFloat1, paramFloat2, paramFloat3);
      this.HDu = paramFloat2;
      this.HDv = paramFloat3;
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
    b localb = this.HDf;
    paramMotionEvent = localb;
    if (!(localb instanceof CropLayout.q)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (CropLayout.q)paramMotionEvent;
    if (paramMotionEvent != null) {
      paramMotionEvent.fZj();
    }
    paramMotionEvent = this.HDy;
    if (paramMotionEvent != null) {
      paramMotionEvent.cancel();
    }
    paramMotionEvent = this.HDC;
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
    if ((this.HDr) || ((Math.abs(f2) < 1000.0F) && (Math.abs(f1) < 1000.0F)))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    boolean bool1 = ffm();
    boolean bool2 = ffn();
    boolean bool3 = ffk();
    boolean bool4 = ffl();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(164420);
      return false;
    }
    if ((this.oSt.left < this.rFV.left) || (f2 <= 0.0F))
    {
      paramFloat1 = f2;
      if (this.oSt.right <= this.rFV.left)
      {
        paramFloat1 = f2;
        if (f2 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.HDp == c.HDI) || (this.HDp == c.HDK))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat1 = 0.0F;
    }
    if ((this.oSt.top < this.rFV.top) || (f1 <= 0.0F))
    {
      paramFloat2 = f1;
      if (this.oSt.bottom <= this.rFV.bottom)
      {
        paramFloat2 = f1;
        if (f1 >= 0.0F) {}
      }
    }
    else
    {
      if ((this.HDp == c.HDI) || (this.HDp == c.HDK))
      {
        AppMethodBeat.o(164420);
        return false;
      }
      paramFloat2 = 0.0F;
    }
    paramMotionEvent1 = this.HDy;
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.cancel();
    }
    this.HDz[0] = 0.0F;
    this.HDz[1] = 0.0F;
    f1 = this.oSt.right;
    f2 = this.rFV.right;
    float f3 = this.rFV.left;
    float f4 = this.oSt.left;
    if (paramFloat1 < 0.0F)
    {
      this.HDz[0] = (-Math.min(Math.abs(paramFloat1), Math.abs(f1 - f2)));
      f1 = this.oSt.bottom;
      f2 = this.rFV.bottom;
      f3 = this.rFV.top;
      f4 = this.oSt.top;
      if (paramFloat2 >= 0.0F) {
        break label703;
      }
      this.HDz[1] = (-Math.min(Math.abs(paramFloat2), Math.abs(f1 - f2)));
    }
    for (;;)
    {
      paramMotionEvent1 = this.HDz;
      new StringBuilder("[onFling] velocityX=").append(paramFloat1).append(" velocityY=").append(paramFloat2).append("  fixTransX=").append(paramMotionEvent1[0]).append(" fixTransY=").append(paramMotionEvent1[1]).append(" isOverEdgeHorizontal=").append(bool1).append(" isOverEdgeVertical=").append(bool2).append(" isOverHorizontal=").append(bool3).append(" isOverVertical=").append(bool4);
      paramMotionEvent1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transX", new float[] { 0.0F, paramMotionEvent1[0] }), PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, paramMotionEvent1[1] }) });
      paramMotionEvent1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this));
      paramMotionEvent1.addListener((Animator.AnimatorListener)new CropLayout.f(this));
      paramMotionEvent1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramMotionEvent1.setDuration(400L);
      paramMotionEvent1.start();
      this.HDy = ((Animator)paramMotionEvent1);
      AppMethodBeat.o(164420);
      return true;
      this.HDz[0] = Math.min(Math.abs(paramFloat1), Math.abs(f3 - f4));
      break;
      label703:
      this.HDz[1] = Math.min(Math.abs(paramFloat2), Math.abs(f3 - f4));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164407);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.HDm.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.HDl = true;
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
      this.HDr = false;
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      this.HDr = true;
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(164414);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164406);
    this.rFV.setEmpty();
    this.oSt.setEmpty();
    this.rGK.setEmpty();
    this.HDo.setEmpty();
    this.sZ.setEmpty();
    this.cHF = new Matrix();
    this.rGL = 1.0F;
    this.HDi = 1.0F;
    this.HDj = 1.0F;
    this.HDh = 5.0F;
    this.HDg = 0.25F;
    this.HDu = 0.0F;
    this.HDv = 0.0F;
    this.HDG[0] = 0.0F;
    this.HDG[1] = 0.0F;
    this.HDk = true;
    this.HDl = false;
    this.HDq = true;
    this.HDF = ((b)i.HDR);
    this.values = new float[9];
    AppMethodBeat.o(164406);
  }
  
  public final void setContentCenterRect(Rect paramRect)
  {
    AppMethodBeat.i(164404);
    k.h(paramRect, "<set-?>");
    this.rGK = paramRect;
    AppMethodBeat.o(164404);
  }
  
  public final void setCropLayoutTouchListener(CropLayout.p paramp)
  {
    this.LDh = paramp;
  }
  
  protected final void setFirstCancelOrUp(boolean paramBoolean)
  {
    this.HDq = paramBoolean;
  }
  
  public final void setMainMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(164403);
    k.h(paramMatrix, "<set-?>");
    this.cHF = paramMatrix;
    AppMethodBeat.o(164403);
  }
  
  public final void setMaxScaleFactor(float paramFloat)
  {
    this.HDh = paramFloat;
  }
  
  public final void setMaxScaleValue(float paramFloat)
  {
    this.HDj = paramFloat;
  }
  
  public final void setMinScaleFactor(float paramFloat)
  {
    this.HDg = paramFloat;
  }
  
  public final void setMinScaleValue(float paramFloat)
  {
    this.HDi = paramFloat;
  }
  
  public final void setOnChangeListener(b paramb)
  {
    this.HDf = paramb;
  }
  
  public final void setScaleType(c paramc)
  {
    AppMethodBeat.i(164405);
    k.h(paramc, "<set-?>");
    this.HDp = paramc;
    AppMethodBeat.o(164405);
  }
  
  public final void wS(boolean paramBoolean)
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$Companion;", "", "()V", "DEFAULT_MAX_SCALE", "", "DEFAULT_MIN_SCALE", "EDGE_DURATION", "", "FLING_DAMPING", "FLING_DURATION", "OVER_SCROLL_DAMPING", "REVERT_DURATION", "ROTATE_DURATION", "TAG", "", "TYPE_VISIBILITY_RECT_CHANGE", "", "libmmui_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "", "onChange", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void onChange();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "ALIGN_START", "libmmui_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(164380);
      c localc1 = new c("CENTER_CROP", 0);
      HDI = localc1;
      c localc2 = new c("CENTER_INSIDE", 1);
      HDJ = localc2;
      c localc3 = new c("ALIGN_START", 2);
      HDK = localc3;
      HDL = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(164380);
    }
    
    private c() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    public static final d HDM;
    
    static
    {
      AppMethodBeat.i(164385);
      HDM = new d();
      AppMethodBeat.o(164385);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/ui/widget/cropview/CropLayout$onFling$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float qXK;
    private float seQ;
    
    e(CropLayout paramCropLayout) {}
    
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
      CropLayout.a(this.HDN, this.qXK - f1, this.seQ - f2);
      this.qXK = f1;
      this.seQ = f2;
      AppMethodBeat.o(164386);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRevertRotate$1$1"})
  static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    g(v.b paramb, CropLayout paramCropLayout, float paramFloat) {}
    
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
      CropLayout.a(jdField_this, f - this.HDO.Jht);
      this.HDO.Jht = f;
      AppMethodBeat.o(164388);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$onRotate$1$1"})
  static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(v.b paramb, CropLayout paramCropLayout) {}
    
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
      CropLayout.a(jdField_this, f - this.HDO.Jht);
      this.HDO.Jht = f;
      AppMethodBeat.o(164389);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class i
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    public static final i HDR;
    
    static
    {
      AppMethodBeat.i(164391);
      HDR = new i();
      AppMethodBeat.o(164391);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class j
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    public static final j HDS;
    
    static
    {
      AppMethodBeat.i(164393);
      HDS = new j();
      AppMethodBeat.o(164393);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startCenterAnim$1$1"})
  static final class k
    implements ValueAnimator.AnimatorUpdateListener
  {
    k(CropLayout paramCropLayout, boolean paramBoolean1, boolean paramBoolean2, v.b paramb1, v.b paramb2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164394);
      if (((this.HDN.getScaleType() == CropLayout.c.HDJ) && (!bool3) && (!bool2)) || ((this.HDN.getScaleType() == CropLayout.c.HDI) && ((!bool3) || (!bool2))))
      {
        localObject = paramValueAnimator.getAnimatedValue("scale");
        if (localObject == null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(164394);
          throw paramValueAnimator;
        }
        f1 = ((Float)localObject).floatValue() * 1.0F / this.HDN.getContentViewScale()[0];
        CropLayout.a(this.HDN, f1, this.HDN.getContentRect().exactCenterX(), this.HDN.getContentRect().exactCenterY());
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
      float f7 = paramMotionEvent.Jht;
      float f5 = localb.Jht;
      float f8 = this.HDN.getContentRect().exactCenterX();
      float f6 = this.HDN.getContentRect().exactCenterY();
      paramValueAnimator = this.HDN;
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
        paramMotionEvent.Jht = f3;
        localb.Jht = f4;
        AppMethodBeat.o(164394);
        return;
        f1 = -(f1 - f8);
        break;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "lastY", "getLastY", "setLastY", "onAnimationUpdate", "", "it", "Landroid/animation/ValueAnimator;", "libmmui_release"})
  public static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int BcY;
    private int BcZ;
    
    l(CropLayout paramCropLayout) {}
    
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
      CropLayout.b(this.HDN, i - this.BcZ, j - this.BcY);
      this.BcZ = i;
      this.BcY = j;
      AppMethodBeat.o(164395);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/ui/widget/cropview/CropLayout$startEdgeAnimation$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    m(CropLayout paramCropLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164398);
      k.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.HDX;
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
      Object localObject = this.HDX;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      localObject = this.HDN.getOnChangeListener();
      paramAnimator = (Animator)localObject;
      if (!(localObject instanceof CropLayout.q)) {
        paramAnimator = null;
      }
      paramAnimator = (CropLayout.q)paramAnimator;
      if (paramAnimator != null)
      {
        paramAnimator.fZk();
        AppMethodBeat.o(164397);
        return;
      }
      AppMethodBeat.o(164397);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(164396);
      k.h(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.HDX;
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
      Animator.AnimatorListener localAnimatorListener = this.HDX;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(164399);
        return;
      }
      AppMethodBeat.o(164399);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/widget/cropview/CropLayout$startRevertAnimation$2$1"})
  static final class n
    implements ValueAnimator.AnimatorUpdateListener
  {
    n(CropLayout paramCropLayout, a parama, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
    
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
      CropLayout.d(this.HDN);
      f3 = f3 * 1.0F / this.HDN.getContentViewScale()[0];
      CropLayout.b(this.HDN, f3);
      f3 = this.HDN.getContentRect().exactCenterX();
      float f4 = this.HDN.getContentRect().exactCenterY();
      CropLayout.b(this.HDN, -(f1 - f3), -(f2 - f4));
      AppMethodBeat.o(164400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.CropLayout
 * JD-Core Version:    0.7.0.1
 */