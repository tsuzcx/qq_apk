package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "mAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "mBagPosX", "", "mBagPosY", "mBgAlpha", "mCanvasTranslateX", "mClipPath", "Landroid/graphics/Path;", "mContentBitmap", "mContentFromX", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mNeedTranslate", "", "mPaint", "mRectConnerRadius", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBagInfo", "bagX", "bagY", "bagRadius", "setContentStartPosX", "fromX", "setListener", "listener", "startAnimation", "duration", "interpolator", "Landroid/animation/TimeInterpolator;", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends View
{
  public static final c.a LBQ;
  private Rect bre;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private Paint vmC;
  private Bitmap vqF;
  private Path vqG;
  private Rect vqH;
  private RectF vqI;
  private int vqJ;
  int vqK;
  int vqL;
  int vqM;
  private int vqN;
  private boolean vqO;
  private int vqP;
  private AnimatorListenerAdapter vqQ;
  
  static
  {
    AppMethodBeat.i(303992);
    LBQ = new c.a((byte)0);
    AppMethodBeat.o(303992);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(303953);
    this.vqN = -1;
    this.mPaint = new Paint();
    this.vqG = new Path();
    this.vmC = new Paint();
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.vmC;
    paramContext = localPaint;
    if (localPaint == null)
    {
      s.bIx("mMaskPaint");
      paramContext = null;
    }
    paramContext.setXfermode((Xfermode)localPorterDuffXfermode);
    this.vqF = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.vqH = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.bre = new Rect(0, 0, this.mWidth, this.mHeight);
    this.vqI = new RectF();
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.left = 0.0F;
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.top = 0.0F;
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.right = this.mWidth;
    paramContext = this.vqI;
    if (paramContext == null)
    {
      s.bIx("mMaskRect");
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.bottom = this.mHeight;
      paramContext = am.aixg;
      paramContext = String.format("init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
      s.s(paramContext, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.TransformToMultiTaskFBAnimationMaskView", paramContext);
      AppMethodBeat.o(303953);
      return;
    }
  }
  
  private static final void a(c paramc, ValueAnimator paramValueAnimator)
  {
    Object localObject3 = null;
    AppMethodBeat.i(303973);
    s.u(paramc, "this$0");
    Object localObject1 = paramValueAnimator.getAnimatedValue("canvasTranslationX");
    if (localObject1 == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(303973);
      throw paramc;
    }
    paramc.vqJ = ((Integer)localObject1).intValue();
    localObject1 = paramc.vqI;
    if (localObject1 == null)
    {
      s.bIx("mMaskRect");
      localObject1 = null;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = paramValueAnimator.getAnimatedValue("translationX");
      if (localObject2 != null) {
        break;
      }
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(303973);
      throw paramc;
    }
    ((RectF)localObject1).left = ((Integer)localObject2).intValue();
    localObject1 = paramc.vqI;
    if (localObject1 == null)
    {
      s.bIx("mMaskRect");
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = paramValueAnimator.getAnimatedValue("translationY");
      if (localObject2 != null) {
        break;
      }
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(303973);
      throw paramc;
    }
    ((RectF)localObject1).top = ((Integer)localObject2).intValue();
    localObject1 = paramc.vqI;
    if (localObject1 == null)
    {
      s.bIx("mMaskRect");
      localObject1 = null;
    }
    float f1;
    float f2;
    for (;;)
    {
      RectF localRectF = paramc.vqI;
      localObject2 = localRectF;
      if (localRectF == null)
      {
        s.bIx("mMaskRect");
        localObject2 = null;
      }
      f1 = ((RectF)localObject2).left;
      f2 = paramc.mWidth;
      localObject2 = paramValueAnimator.getAnimatedValue("scaleX");
      if (localObject2 != null) {
        break;
      }
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(303973);
      throw paramc;
    }
    ((RectF)localObject1).right = (((Float)localObject2).floatValue() * f2 + f1);
    localObject1 = paramc.vqI;
    if (localObject1 == null)
    {
      s.bIx("mMaskRect");
      localObject1 = null;
      localObject2 = paramc.vqI;
      if (localObject2 != null) {
        break label385;
      }
      s.bIx("mMaskRect");
      localObject2 = localObject3;
    }
    label385:
    for (;;)
    {
      f1 = ((RectF)localObject2).top;
      f2 = paramc.mHeight;
      localObject2 = paramValueAnimator.getAnimatedValue("scaleY");
      if (localObject2 != null) {
        break label388;
      }
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(303973);
      throw paramc;
      break;
    }
    label388:
    ((RectF)localObject1).bottom = (((Float)localObject2).floatValue() * f2 + f1);
    paramValueAnimator = paramValueAnimator.getAnimatedValue("bgAlpha");
    if (paramValueAnimator == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(303973);
      throw paramc;
    }
    paramc.vqP = ((Integer)paramValueAnimator).intValue();
    paramc.postInvalidate();
    AppMethodBeat.o(303973);
  }
  
  public final void d(TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(304037);
    boolean bool;
    label36:
    Object localObject;
    if (this.vqN > 0)
    {
      bool = true;
      this.vqO = bool;
      if (this.vqN >= this.vqL) {
        break label296;
      }
      i = this.vqN;
      localObject = PropertyValuesHolder.ofInt("canvasTranslationX", new int[] { i, -this.vqN });
      i = this.vqL;
      if (this.vqO) {
        if (this.vqN >= this.vqL) {
          break label304;
        }
      }
    }
    label296:
    label304:
    for (int i = this.vqL - this.vqN;; i = this.vqN)
    {
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("translationX", new int[] { i, i }), PropertyValuesHolder.ofInt("translationY", new int[] { 0, this.vqM }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, this.vqK * 2.0F / this.mWidth }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, this.vqK * 2.0F / this.mHeight }), localObject, PropertyValuesHolder.ofInt("bgAlpha", new int[] { 255, 0 }) });
      ((ValueAnimator)localObject).setDuration(250L);
      ((ValueAnimator)localObject).setInterpolator(paramTimeInterpolator);
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda0(this));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new b(this));
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(304037);
      return;
      bool = false;
      break;
      i = this.vqL;
      break label36;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    Object localObject3 = null;
    AppMethodBeat.i(304049);
    s.u(paramCanvas, "canvas");
    Object localObject2;
    Object localObject1;
    Object localObject4;
    if (this.vqO)
    {
      paramCanvas.translate(this.vqJ, 0.0F);
      localObject2 = this.vqG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mClipPath");
        localObject1 = null;
      }
      localObject1.reset();
      localObject2 = this.vqG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mClipPath");
        localObject1 = null;
      }
      localObject4 = this.vqI;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("mMaskRect");
        localObject2 = null;
      }
      localObject1.addRoundRect((RectF)localObject2, this.vqK, this.vqK, Path.Direction.CW);
      localObject2 = this.vqG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mClipPath");
        localObject1 = null;
      }
      paramCanvas.clipPath(localObject1);
      localObject2 = this.vqF;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mContentBitmap");
        localObject1 = null;
      }
      localObject4 = this.vqH;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("mDrawRect");
        localObject2 = null;
      }
      localObject4 = this.bre;
      if (localObject4 != null) {
        break label233;
      }
      s.bIx("mDstRect");
    }
    for (;;)
    {
      paramCanvas.drawBitmap(localObject1, (Rect)localObject2, (Rect)localObject3, this.mPaint);
      AppMethodBeat.o(304049);
      return;
      paramCanvas.drawColor(Color.argb(this.vqP, 0, 0, 0));
      break;
      label233:
      localObject3 = localObject4;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304057);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(304057);
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.vqN = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.vqQ = paramAnimatorListenerAdapter;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView$startAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(c paramc) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(303981);
      s.u(paramAnimator, "animation");
      if (c.b(this.LBR) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.b(this.LBR);
        if (localAnimatorListenerAdapter != null) {
          localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        }
      }
      this.LBR.setVisibility(8);
      AppMethodBeat.o(303981);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(303986);
      s.u(paramAnimator, "animation");
      if (c.b(this.LBR) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.b(this.LBR);
        if (localAnimatorListenerAdapter != null) {
          localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        }
      }
      AppMethodBeat.o(303986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.c
 * JD-Core Version:    0.7.0.1
 */