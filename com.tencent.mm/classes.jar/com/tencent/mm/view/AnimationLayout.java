package com.tencent.mm.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AnimationLayout
  extends FrameLayout
{
  public RectF MlJ;
  public Rect agFI;
  
  public AnimationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164237);
    this.MlJ = new RectF();
    this.agFI = new Rect();
    AppMethodBeat.o(164237);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143605);
    this.MlJ = new RectF();
    this.agFI = new Rect();
    AppMethodBeat.o(143605);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143606);
    this.MlJ = new RectF();
    this.agFI = new Rect();
    AppMethodBeat.o(143606);
  }
  
  public final void a(final View paramView1, final View paramView2, final ViewAnimHelper.ViewInfo paramViewInfo, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(164239);
    paramView1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(164235);
        Object localObject = ViewAnimHelper.z(AnimationLayout.this, paramView2);
        final float f3 = ((ViewAnimHelper.ViewInfo)localObject).agcX.width() * 1.0F / paramViewInfo.agcX.width();
        final float f4 = ((ViewAnimHelper.ViewInfo)localObject).agcX.height() * 1.0F / paramViewInfo.agcX.height();
        final float f1;
        final float f2;
        label86:
        AnimationLayout localAnimationLayout;
        View localView;
        ViewAnimHelper.ViewInfo localViewInfo;
        Animator.AnimatorListener localAnimatorListener;
        if (f3 > f4)
        {
          f1 = f3;
          if (f4 <= f3) {
            break label161;
          }
          f2 = f4;
          localAnimationLayout = AnimationLayout.this;
          localView = paramView1;
          localViewInfo = paramViewInfo;
          localAnimatorListener = paramAnimatorListener;
          if ((f1 <= 1.0F) && (f2 <= 1.0F)) {
            break label166;
          }
        }
        label161:
        label166:
        for (localObject = new ValueAnimator.AnimatorUpdateListener()
            {
              Matrix matrix;
              
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(164234);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (f1 > 1.0F) {
                  this.matrix.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
                }
                for (;;)
                {
                  this.matrix.mapRect(AnimationLayout.this.MlJ, new RectF(AnimationLayout.this.agFI));
                  if (AnimationLayout.1.this.agFN != null) {
                    AnimationLayout.1.this.agFN.onAnimationUpdate(paramAnonymous2ValueAnimator);
                  }
                  AnimationLayout.this.invalidate();
                  AppMethodBeat.o(164234);
                  return;
                  if (f2 > 1.0F) {
                    this.matrix.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
                  }
                }
              }
            };; localObject = null)
        {
          ViewAnimHelper.c(localAnimationLayout, localView, localViewInfo, localAnimatorListener, (ValueAnimator.AnimatorUpdateListener)localObject);
          AppMethodBeat.o(164235);
          return;
          f1 = 1.0F;
          break;
          f2 = 1.0F;
          break label86;
        }
      }
    };
    if ((getMeasuredState() & 0xFF000000) > 0)
    {
      paramView1.run();
      AppMethodBeat.o(164239);
      return;
    }
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(164236);
        AnimationLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
        paramView1.run();
        AppMethodBeat.o(164236);
        return true;
      }
    });
    AppMethodBeat.o(164239);
  }
  
  public final void a(View paramView1, View paramView2, ViewAnimHelper.ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    final float f2 = 1.0F;
    AppMethodBeat.i(143610);
    paramView2 = ViewAnimHelper.z(this, paramView2);
    final float f3 = paramView2.agcX.width() * 1.0F / paramViewInfo.agcX.width();
    final float f4 = paramView2.agcX.height() * 1.0F / paramViewInfo.agcX.height();
    if (f3 > f4) {}
    for (final float f1 = f3;; f1 = 1.0F)
    {
      if (f4 > f3) {
        f2 = f4;
      }
      ViewAnimHelper.a(this, paramView1, paramViewInfo, paramAnimatorListener, new ValueAnimator.AnimatorUpdateListener()
      {
        Matrix matrix;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(143604);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if ((f1 > 1.0F) || (f2 > 1.0F))
          {
            if (f1 <= 1.0F) {
              break label147;
            }
            this.matrix.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
          }
          for (;;)
          {
            this.matrix.mapRect(AnimationLayout.this.MlJ, new RectF(AnimationLayout.this.agFI));
            AnimationLayout.this.invalidate();
            if (paramAnimatorUpdateListener != null) {
              paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
            }
            AppMethodBeat.o(143604);
            return;
            label147:
            if (f2 > 1.0F) {
              this.matrix.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
            }
          }
        }
      });
      AppMethodBeat.o(143610);
      return;
    }
  }
  
  public final void b(final View paramView1, final View paramView2, final ViewAnimHelper.ViewInfo paramViewInfo, final Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(234666);
    paramView1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235014);
        Object localObject = ViewAnimHelper.z(AnimationLayout.this, paramView2);
        final float f3 = ((ViewAnimHelper.ViewInfo)localObject).agcX.width() * 1.0F / paramViewInfo.agcX.width();
        final float f4 = ((ViewAnimHelper.ViewInfo)localObject).agcX.height() * 1.0F / paramViewInfo.agcX.height();
        final float f1;
        final float f2;
        label86:
        AnimationLayout localAnimationLayout;
        View localView;
        ViewAnimHelper.ViewInfo localViewInfo;
        Animator.AnimatorListener localAnimatorListener;
        if (f3 > f4)
        {
          f1 = f3;
          if (f4 <= f3) {
            break label161;
          }
          f2 = f4;
          localAnimationLayout = AnimationLayout.this;
          localView = paramView1;
          localViewInfo = paramViewInfo;
          localAnimatorListener = paramAnimatorListener;
          if ((f1 <= 1.0F) && (f2 <= 1.0F)) {
            break label166;
          }
        }
        label161:
        label166:
        for (localObject = new ValueAnimator.AnimatorUpdateListener()
            {
              Matrix matrix;
              
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(234610);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (f1 > 1.0F) {
                  this.matrix.setScale(f + f4 / f3 * (1.0F - f), 1.0F, AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
                }
                for (;;)
                {
                  this.matrix.mapRect(AnimationLayout.this.MlJ, new RectF(AnimationLayout.this.agFI));
                  if (AnimationLayout.4.this.agFN != null) {
                    AnimationLayout.4.this.agFN.onAnimationUpdate(paramAnonymous2ValueAnimator);
                  }
                  AnimationLayout.this.invalidate();
                  AppMethodBeat.o(234610);
                  return;
                  if (f2 > 1.0F) {
                    this.matrix.setScale(1.0F, f + f3 / f4 * (1.0F - f), AnimationLayout.this.agFI.centerX(), AnimationLayout.this.agFI.centerY());
                  }
                }
              }
            };; localObject = null)
        {
          ViewAnimHelper.c(localAnimationLayout, localView, localViewInfo, localAnimatorListener, (ValueAnimator.AnimatorUpdateListener)localObject);
          AppMethodBeat.o(235014);
          return;
          f1 = 1.0F;
          break;
          f2 = 1.0F;
          break label86;
        }
      }
    };
    if ((getMeasuredState() & 0xFF000000) > 0)
    {
      paramView1.run();
      AppMethodBeat.o(234666);
      return;
    }
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(235009);
        AnimationLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
        paramView1.run();
        AppMethodBeat.o(235009);
        return true;
      }
    });
    AppMethodBeat.o(234666);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143608);
    if (this.agFI.isEmpty()) {
      paramCanvas.getClipBounds(this.agFI);
    }
    if (this.MlJ.isEmpty())
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(143608);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipRect(this.MlJ);
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(143608);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164238);
    super.onAttachedToWindow();
    if (getBackground() == null) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164238);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(143609);
    super.onDetachedFromWindow();
    this.MlJ.setEmpty();
    AppMethodBeat.o(143609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.AnimationLayout
 * JD-Core Version:    0.7.0.1
 */