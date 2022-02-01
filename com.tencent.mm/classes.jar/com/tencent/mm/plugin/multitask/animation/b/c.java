package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "mAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "mBagPosX", "", "mBagPosY", "mBgAlpha", "mCanvasTranslateX", "mClipPath", "Landroid/graphics/Path;", "mContentBitmap", "mContentFromX", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mNeedTranslate", "", "mPaint", "mRectConnerRadius", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBagInfo", "bagX", "bagY", "bagRadius", "setContentStartPosX", "fromX", "setListener", "listener", "startAnimation", "duration", "interpolator", "Landroid/animation/TimeInterpolator;", "Companion", "plugin-multitask_release"})
public final class c
  extends View
{
  public static final c.a FFW;
  private Rect KV;
  int mHeight;
  private Paint mPaint;
  int mWidth;
  private Paint sbk;
  private Bitmap seS;
  private Path seT;
  private Rect seU;
  private RectF seV;
  private int seW;
  int seX;
  int seY;
  int seZ;
  int sfa;
  boolean sfb;
  private int sfc;
  private AnimatorListenerAdapter sfd;
  
  static
  {
    AppMethodBeat.i(249120);
    FFW = new c.a((byte)0);
    AppMethodBeat.o(249120);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(249119);
    this.sfa = -1;
    this.mPaint = new Paint();
    this.seT = new Path();
    this.sbk = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.sbk;
    if (localPaint == null) {
      p.bGy("mMaskPaint");
    }
    localPaint.setXfermode((Xfermode)paramContext);
    this.seS = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.seU = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.KV = new Rect(0, 0, this.mWidth, this.mHeight);
    this.seV = new RectF();
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.left = 0.0F;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.top = 0.0F;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.right = this.mWidth;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.bottom = this.mHeight;
    paramContext = af.aaBG;
    paramContext = String.format("init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
    p.j(paramContext, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.TransformToMultiTaskFBAnimationMaskView", paramContext);
    AppMethodBeat.o(249119);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(249117);
    p.k(paramCanvas, "canvas");
    if (this.sfb) {
      paramCanvas.translate(this.seW, 0.0F);
    }
    for (;;)
    {
      Object localObject1 = this.seT;
      if (localObject1 == null) {
        p.bGy("mClipPath");
      }
      ((Path)localObject1).reset();
      localObject1 = this.seT;
      if (localObject1 == null) {
        p.bGy("mClipPath");
      }
      Object localObject2 = this.seV;
      if (localObject2 == null) {
        p.bGy("mMaskRect");
      }
      ((Path)localObject1).addRoundRect((RectF)localObject2, this.seX, this.seX, Path.Direction.CW);
      localObject1 = this.seT;
      if (localObject1 == null) {
        p.bGy("mClipPath");
      }
      paramCanvas.clipPath((Path)localObject1);
      localObject1 = this.seS;
      if (localObject1 == null) {
        p.bGy("mContentBitmap");
      }
      localObject2 = this.seU;
      if (localObject2 == null) {
        p.bGy("mDrawRect");
      }
      Rect localRect = this.KV;
      if (localRect == null) {
        p.bGy("mDstRect");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, this.mPaint);
      AppMethodBeat.o(249117);
      return;
      paramCanvas.drawColor(Color.argb(this.sfc, 0, 0, 0));
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249118);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(249118);
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.sfa = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.sfd = paramAnimatorListenerAdapter;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(249171);
      Object localObject1 = this.FFX;
      Object localObject2 = paramValueAnimator.getAnimatedValue("canvasTranslationX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      c.a((c)localObject1, ((Integer)localObject2).intValue());
      localObject1 = c.a(this.FFX);
      localObject2 = paramValueAnimator.getAnimatedValue("translationX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).left = ((Integer)localObject2).intValue();
      localObject1 = c.a(this.FFX);
      localObject2 = paramValueAnimator.getAnimatedValue("translationY");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).top = ((Integer)localObject2).intValue();
      localObject1 = c.a(this.FFX);
      float f1 = c.a(this.FFX).left;
      float f2 = c.b(this.FFX);
      localObject2 = paramValueAnimator.getAnimatedValue("scaleX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).right = (((Float)localObject2).floatValue() * f2 + f1);
      localObject1 = c.a(this.FFX);
      f1 = c.a(this.FFX).top;
      f2 = c.c(this.FFX);
      localObject2 = paramValueAnimator.getAnimatedValue("scaleY");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).bottom = (((Float)localObject2).floatValue() * f2 + f1);
      localObject1 = this.FFX;
      paramValueAnimator = paramValueAnimator.getAnimatedValue("bgAlpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(249171);
        throw paramValueAnimator;
      }
      c.b((c)localObject1, ((Integer)paramValueAnimator).intValue());
      this.FFX.postInvalidate();
      AppMethodBeat.o(249171);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView$startAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(249141);
      p.k(paramAnimator, "animation");
      if (c.d(this.FFX) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.d(this.FFX);
        if (localAnimatorListenerAdapter != null) {
          localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        }
      }
      this.FFX.setVisibility(8);
      AppMethodBeat.o(249141);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(249143);
      p.k(paramAnimator, "animation");
      if (c.d(this.FFX) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.d(this.FFX);
        if (localAnimatorListenerAdapter != null)
        {
          localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
          AppMethodBeat.o(249143);
          return;
        }
      }
      AppMethodBeat.o(249143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.c
 * JD-Core Version:    0.7.0.1
 */