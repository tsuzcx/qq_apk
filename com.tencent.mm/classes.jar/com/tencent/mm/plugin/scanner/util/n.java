package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanViewUtils;", "", "()V", "TAG", "", "animateAlpha", "", "view", "Landroid/view/View;", "show", "", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "fromAlpha", "", "targetAlpha", "duration", "", "convertToImageCoordinate", "Landroid/graphics/PointF;", "imageView", "x", "y", "Landroid/widget/ImageView;", "imageWidth", "", "imageHeight", "filePath", "width", "height", "fitBitmapBottom", "bitmap", "Landroid/graphics/Bitmap;", "viewWidth", "viewHeight", "getBlurBitmap", "async", "callback", "Lkotlin/Function1;", "getRoundBitmap", "invertMapPoint", "matrix", "Landroid/graphics/Matrix;", "srcPoints", "", "scan-sdk_release"})
public final class n
{
  public static final n IZP;
  
  static
  {
    AppMethodBeat.i(193635);
    IZP = new n();
    AppMethodBeat.o(193635);
  }
  
  public static final PointF a(ImageView paramImageView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193634);
    if (paramImageView == null)
    {
      AppMethodBeat.o(193634);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(193634);
      return null;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    Object localObject = paramImageView.getImageMatrix();
    paramImageView = paramImageView.getDrawable();
    int i;
    label77:
    int j;
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getBounds();
      if (paramImageView == null) {
        break label202;
      }
      i = paramImageView.width();
      if (paramImageView == null) {
        break label208;
      }
      j = paramImageView.height();
      label87:
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
      AppMethodBeat.o(193634);
      return paramImageView;
      paramImageView = null;
      break;
      label202:
      i = paramInt1;
      break label77;
      label208:
      j = paramInt2;
      break label87;
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
    AppMethodBeat.i(193629);
    if (paramString == null)
    {
      paramString = new PointF(paramFloat1, paramFloat2);
      AppMethodBeat.o(193629);
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
    AppMethodBeat.o(193629);
    return paramString;
  }
  
  public static final void a(final Bitmap paramBitmap, final b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(193625);
    p.k(paramb, "callback");
    aa.f localf = new aa.f();
    localf.aaBC = null;
    ((a)new b(localf, paramBitmap, paramb)).invoke();
    AppMethodBeat.o(193625);
  }
  
  public static final void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(193624);
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
              if (paramView != null)
              {
                paramView.start();
                AppMethodBeat.o(193624);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(193624);
  }
  
  public static final void a(final View paramView, final boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(193623);
    if (paramView == null)
    {
      AppMethodBeat.o(193623);
      return;
    }
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(193623);
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(193623);
      return;
    }
    Log.v("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
    paramAnimatorListener = (Animator.AnimatorListener)new a(paramAnimatorListener, paramView, paramBoolean);
    paramView.setVisibility(0);
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label159;
      }
    }
    for (;;)
    {
      a(paramView, f1, f2, 200L, paramAnimatorListener);
      AppMethodBeat.o(193623);
      return;
      f1 = 1.0F;
      break;
      label159:
      f2 = 0.0F;
    }
  }
  
  public static boolean a(Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193615);
    p.k(paramImageView, "imageView");
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(null);
      AppMethodBeat.o(193615);
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
    AppMethodBeat.o(193615);
    return true;
  }
  
  public static Bitmap ao(Bitmap paramBitmap)
  {
    AppMethodBeat.i(193619);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        if (paramBitmap.getWidth() > paramBitmap.getHeight()) {}
        for (double d = Math.floor(paramBitmap.getWidth() / 2.0D + 0.5D);; d = Math.floor(paramBitmap.getHeight() / 2.0D + 0.5D))
        {
          paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, (float)d);
          AppMethodBeat.o(193619);
          return paramBitmap;
        }
      }
      AppMethodBeat.o(193619);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)paramBitmap, "alvinluo decodeRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(193619);
    }
    return null;
  }
  
  public static final PointF g(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193627);
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    if ((paramView instanceof g))
    {
      paramView = ((g)paramView).d(localPointF);
      AppMethodBeat.o(193627);
      return paramView;
    }
    AppMethodBeat.o(193627);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/util/ScanViewUtils$animateAlpha$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "scan-sdk_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(Animator.AnimatorListener paramAnimatorListener, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(192686);
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.IUM;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(192686);
        return;
      }
      AppMethodBeat.o(192686);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(192683);
      p.k(paramAnimator, "animation");
      Object localObject = paramView;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        localObject = this.IUM;
        if (localObject == null) {
          break;
        }
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(192683);
        return;
      }
      AppMethodBeat.o(192683);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(192687);
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.IUM;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(192687);
        return;
      }
      AppMethodBeat.o(192687);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(192680);
      p.k(paramAnimator, "animation");
      Animator.AnimatorListener localAnimatorListener = this.IUM;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(192680);
        return;
      }
      AppMethodBeat.o(192680);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<Object>
  {
    b(aa.f paramf, Bitmap paramBitmap, b paramb)
    {
      super();
    }
    
    public final Object invoke()
    {
      Object localObject2 = null;
      AppMethodBeat.i(193552);
      try
      {
        long l = System.currentTimeMillis();
        this.kyE.aaBC = BitmapUtil.fastBlurBitmap(paramBitmap, 0.1F, 10, true, 200L);
        Log.i("MicroMsg.ScanViewUtils", "alvinluo blurBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Object localObject1 = (Bitmap)this.kyE.aaBC;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((Bitmap)localObject1).getWidth());
          Bitmap localBitmap = (Bitmap)this.kyE.aaBC;
          if (localBitmap != null) {
            localObject2 = Integer.valueOf(localBitmap.getHeight());
          }
          Log.d("MicroMsg.ScanViewUtils", "alvinluo blurBitmap width: %s, height: %s", new Object[] { localObject1, localObject2 });
          localObject1 = Thread.currentThread();
          localObject2 = Looper.getMainLooper();
          p.j(localObject2, "Looper.getMainLooper()");
          if (!p.h(localObject1, ((Looper)localObject2).getThread())) {
            break label205;
          }
          localObject1 = paramb.invoke((Bitmap)this.kyE.aaBC);
          AppMethodBeat.o(193552);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)localException, "blurBitmap exception", new Object[0]);
          continue;
          locald = null;
        }
        label205:
        d locald = h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193361);
            this.IZQ.jFa.invoke((Bitmap)this.IZQ.kyE.aaBC);
            AppMethodBeat.o(193361);
          }
        });
        AppMethodBeat.o(193552);
        return locald;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.n
 * JD-Core Version:    0.7.0.1
 */