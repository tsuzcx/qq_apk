package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanViewUtils;", "", "()V", "TAG", "", "animateAlpha", "", "view", "Landroid/view/View;", "show", "", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "fromAlpha", "", "targetAlpha", "duration", "", "convertToImageCoordinate", "Landroid/graphics/PointF;", "imageView", "x", "y", "Landroid/widget/ImageView;", "imageWidth", "", "imageHeight", "filePath", "width", "height", "fitBitmapBottom", "bitmap", "Landroid/graphics/Bitmap;", "viewWidth", "viewHeight", "getBlurBitmap", "async", "callback", "Lkotlin/Function1;", "getRoundBitmap", "invertMapPoint", "matrix", "Landroid/graphics/Matrix;", "srcPoints", "", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p PjH;
  
  static
  {
    AppMethodBeat.i(314186);
    PjH = new p();
    AppMethodBeat.o(314186);
  }
  
  public static final PointF a(ImageView paramImageView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314182);
    if (paramImageView == null)
    {
      AppMethodBeat.o(314182);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(314182);
      return null;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    Object localObject = paramImageView.getImageMatrix();
    paramImageView = paramImageView.getDrawable();
    int i;
    label71:
    int j;
    if (paramImageView == null)
    {
      paramImageView = null;
      if (paramImageView != null) {
        break label197;
      }
      i = paramInt1;
      if (paramImageView != null) {
        break label206;
      }
      j = paramInt2;
      label79:
      if (localObject != null) {
        break label215;
      }
      paramImageView = null;
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramImageView.x /= i;
        paramImageView.y /= j;
        Log.i("MicroMsg.ScanViewUtils", "alvinluo convertScreenToImageCoordinate screenCoordinate x: %s, y: %s, imageCoordinate: %s, imageWidth: %s, imageHeight: %s, show: %s, %s", new Object[] { Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), paramImageView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      }
      AppMethodBeat.o(314182);
      return paramImageView;
      paramImageView = paramImageView.getBounds();
      break;
      label197:
      i = paramImageView.width();
      break label71;
      label206:
      j = paramImageView.height();
      break label79;
      label215:
      paramImageView = new Matrix();
      if (!((Matrix)localObject).invert(paramImageView))
      {
        Log.e("MicroMsg.ScanViewUtils", "invertMapPoint invert matrix failed");
        paramImageView = null;
      }
      else
      {
        localObject = new float[2];
        paramImageView.mapPoints((float[])localObject, arrayOfFloat);
        paramImageView = new PointF(localObject[0], localObject[1]);
      }
    }
  }
  
  public static final PointF a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(314173);
    if (paramString == null)
    {
      paramString = new PointF(paramFloat1, paramFloat2);
      AppMethodBeat.o(314173);
      return paramString;
    }
    float f = paramFloat1;
    if (paramInt1 > 0) {
      f = paramFloat1 / paramInt1;
    }
    paramFloat1 = paramFloat2;
    if (paramInt2 > 0) {
      paramFloat1 = paramFloat2 / paramInt2;
    }
    paramString = new PointF(f, paramFloat1);
    AppMethodBeat.o(314173);
    return paramString;
  }
  
  public static final void a(Bitmap paramBitmap, b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(314161);
    s.u(paramb, "callback");
    ((a)new p.b(new ah.f(), paramBitmap, paramb)).invoke();
    AppMethodBeat.o(314161);
  }
  
  public static final void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(314157);
    Log.v("MicroMsg.ScanViewUtils", "alvinluo animateAlpha view: %s, fromAlpha: %s, targetAlpha: %s", new Object[] { paramView, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramView != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setListener(null);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.setUpdateListener(null);
          if (localViewPropertyAnimator != null) {
            localViewPropertyAnimator.cancel();
          }
        }
      }
    }
    if (paramView != null) {
      paramView.setAlpha(paramFloat1);
    }
    if (paramView != null)
    {
      paramView = paramView.animate();
      if (paramView != null)
      {
        paramView = paramView.alpha(paramFloat2);
        if (paramView != null)
        {
          paramView = paramView.setDuration(paramLong);
          if (paramView != null)
          {
            paramView = paramView.setInterpolator((TimeInterpolator)new LinearInterpolator());
            if (paramView != null)
            {
              paramView = paramView.setListener(paramAnimatorListener);
              if (paramView != null) {
                paramView.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(314157);
  }
  
  public static final void a(final View paramView, final boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(314152);
    if (paramView == null)
    {
      AppMethodBeat.o(314152);
      return;
    }
    int i;
    if (paramBoolean)
    {
      if (paramView.getAlpha() == 0.0F) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
        AppMethodBeat.o(314152);
        return;
      }
    }
    if (!paramBoolean)
    {
      if (paramView.getAlpha() == 1.0F) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
        AppMethodBeat.o(314152);
        return;
      }
    }
    Log.v("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
    paramAnimatorListener = (Animator.AnimatorListener)new a(paramAnimatorListener, paramView, paramBoolean);
    paramView.setVisibility(0);
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label187;
      }
    }
    for (;;)
    {
      a(paramView, f1, f2, 200L, paramAnimatorListener);
      AppMethodBeat.o(314152);
      return;
      f1 = 1.0F;
      break;
      label187:
      f2 = 0.0F;
    }
  }
  
  public static boolean a(Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314142);
    s.u(paramImageView, "imageView");
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(null);
      AppMethodBeat.o(314142);
      return false;
    }
    paramImageView.setImageBitmap(paramBitmap);
    Matrix localMatrix1 = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix2 = paramImageView.getImageMatrix();
    float f1 = 1.0F * paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 - paramBitmap.getHeight() * f1;
    Log.d("MicroMsg.ScanViewUtils", "alvinluo fitBitmapBottom bitmap: %d, %d, scale: %f, translationY: %f, width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localMatrix2.postScale(f1, f1);
    localMatrix2.postTranslate(0.0F, f2);
    localMatrix1.set(localMatrix2);
    paramImageView.setImageMatrix(localMatrix1);
    AppMethodBeat.o(314142);
    return true;
  }
  
  public static Bitmap aD(Bitmap paramBitmap)
  {
    AppMethodBeat.i(314145);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        if (paramBitmap.getWidth() > paramBitmap.getHeight()) {}
        for (double d = Math.floor(paramBitmap.getWidth() / 2.0D + 0.5D);; d = Math.floor(paramBitmap.getHeight() / 2.0D + 0.5D))
        {
          paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, (float)d);
          AppMethodBeat.o(314145);
          return paramBitmap;
        }
      }
      AppMethodBeat.o(314145);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)paramBitmap, "alvinluo decodeRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(314145);
    }
    return null;
  }
  
  public static final PointF f(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(314168);
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    if ((paramView instanceof i))
    {
      paramView = ((i)paramView).c(localPointF);
      AppMethodBeat.o(314168);
      return paramView;
    }
    AppMethodBeat.o(314168);
    return null;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/util/ScanViewUtils$animateAlpha$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(Animator.AnimatorListener paramAnimatorListener, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(314088);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.PdD;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationCancel(paramAnimator);
      }
      AppMethodBeat.o(314088);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314082);
      s.u(paramAnimator, "animation");
      Object localObject = paramView;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        localObject = this.PdD;
        if (localObject != null) {
          ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        }
        AppMethodBeat.o(314082);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(314092);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.PdD;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(314092);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(314077);
      s.u(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.PdD;
      if (localAnimatorListener != null) {
        localAnimatorListener.onAnimationStart(paramAnimator);
      }
      AppMethodBeat.o(314077);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.p
 * JD-Core Version:    0.7.0.1
 */