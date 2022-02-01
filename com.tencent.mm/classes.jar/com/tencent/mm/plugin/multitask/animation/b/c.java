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
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "mAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "mBagPosX", "", "mBagPosY", "mBgAlpha", "mCanvasTranslateX", "mClipPath", "Landroid/graphics/Path;", "mContentBitmap", "mContentFromX", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mNeedTranslate", "", "mPaint", "mRectConnerRadius", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBagInfo", "bagX", "bagY", "bagRadius", "setContentStartPosX", "fromX", "setListener", "listener", "startAnimation", "duration", "interpolator", "Landroid/animation/TimeInterpolator;", "Companion", "plugin-multitask_release"})
public final class c
  extends View
{
  public static final c.a Aag;
  private Rect Ky;
  int mHeight;
  private Paint mPaint;
  int mWidth;
  private Paint oZj;
  private Bitmap pcQ;
  private Path pcR;
  private Rect pcS;
  private RectF pcT;
  private int pcU;
  int pcV;
  int pcW;
  int pcX;
  int pcY;
  boolean pcZ;
  private int pda;
  private AnimatorListenerAdapter pdb;
  
  static
  {
    AppMethodBeat.i(200426);
    Aag = new c.a((byte)0);
    AppMethodBeat.o(200426);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(200425);
    this.pcY = -1;
    this.mPaint = new Paint();
    this.pcR = new Path();
    this.oZj = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.oZj;
    if (localPaint == null) {
      p.btv("mMaskPaint");
    }
    localPaint.setXfermode((Xfermode)paramContext);
    this.pcQ = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.pcS = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.Ky = new Rect(0, 0, this.mWidth, this.mHeight);
    this.pcT = new RectF();
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.left = 0.0F;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.top = 0.0F;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.right = this.mWidth;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.bottom = this.mHeight;
    paramContext = ae.SYK;
    paramContext = String.format("init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.TransformToMultiTaskFBAnimationMaskView", paramContext);
    AppMethodBeat.o(200425);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200423);
    p.h(paramCanvas, "canvas");
    if (this.pcZ) {
      paramCanvas.translate(this.pcU, 0.0F);
    }
    for (;;)
    {
      Object localObject1 = this.pcR;
      if (localObject1 == null) {
        p.btv("mClipPath");
      }
      ((Path)localObject1).reset();
      localObject1 = this.pcR;
      if (localObject1 == null) {
        p.btv("mClipPath");
      }
      Object localObject2 = this.pcT;
      if (localObject2 == null) {
        p.btv("mMaskRect");
      }
      ((Path)localObject1).addRoundRect((RectF)localObject2, this.pcV, this.pcV, Path.Direction.CW);
      localObject1 = this.pcR;
      if (localObject1 == null) {
        p.btv("mClipPath");
      }
      paramCanvas.clipPath((Path)localObject1);
      localObject1 = this.pcQ;
      if (localObject1 == null) {
        p.btv("mContentBitmap");
      }
      localObject2 = this.pcS;
      if (localObject2 == null) {
        p.btv("mDrawRect");
      }
      Rect localRect = this.Ky;
      if (localRect == null) {
        p.btv("mDstRect");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, this.mPaint);
      AppMethodBeat.o(200423);
      return;
      paramCanvas.drawColor(Color.argb(this.pda, 0, 0, 0));
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200424);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(200424);
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.pcY = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.pdb = paramAnimatorListenerAdapter;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200420);
      Object localObject1 = this.Aah;
      Object localObject2 = paramValueAnimator.getAnimatedValue("canvasTranslationX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      c.a((c)localObject1, ((Integer)localObject2).intValue());
      localObject1 = c.a(this.Aah);
      localObject2 = paramValueAnimator.getAnimatedValue("translationX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).left = ((Integer)localObject2).intValue();
      localObject1 = c.a(this.Aah);
      localObject2 = paramValueAnimator.getAnimatedValue("translationY");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).top = ((Integer)localObject2).intValue();
      localObject1 = c.a(this.Aah);
      float f1 = c.a(this.Aah).left;
      float f2 = c.b(this.Aah);
      localObject2 = paramValueAnimator.getAnimatedValue("scaleX");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).right = (((Float)localObject2).floatValue() * f2 + f1);
      localObject1 = c.a(this.Aah);
      f1 = c.a(this.Aah).top;
      f2 = c.c(this.Aah);
      localObject2 = paramValueAnimator.getAnimatedValue("scaleY");
      if (localObject2 == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      ((RectF)localObject1).bottom = (((Float)localObject2).floatValue() * f2 + f1);
      localObject1 = this.Aah;
      paramValueAnimator = paramValueAnimator.getAnimatedValue("bgAlpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200420);
        throw paramValueAnimator;
      }
      c.b((c)localObject1, ((Integer)paramValueAnimator).intValue());
      this.Aah.postInvalidate();
      AppMethodBeat.o(200420);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView$startAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200421);
      p.h(paramAnimator, "animation");
      if (c.d(this.Aah) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.d(this.Aah);
        if (localAnimatorListenerAdapter != null) {
          localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
        }
      }
      this.Aah.setVisibility(8);
      AppMethodBeat.o(200421);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200422);
      p.h(paramAnimator, "animation");
      if (c.d(this.Aah) != null)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = c.d(this.Aah);
        if (localAnimatorListenerAdapter != null)
        {
          localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
          AppMethodBeat.o(200422);
          return;
        }
      }
      AppMethodBeat.o(200422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.c
 * JD-Core Version:    0.7.0.1
 */