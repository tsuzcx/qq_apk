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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AnimationLayout
  extends FrameLayout
{
  private RectF HTV;
  private Rect HTW;
  
  public AnimationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164237);
    this.HTV = new RectF();
    this.HTW = new Rect();
    AppMethodBeat.o(164237);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143605);
    this.HTV = new RectF();
    this.HTW = new Rect();
    AppMethodBeat.o(143605);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143606);
    this.HTV = new RectF();
    this.HTW = new Rect();
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
        Object localObject1 = ViewAnimHelper.m(AnimationLayout.this, paramView2);
        final float f3 = ((ViewAnimHelper.ViewInfo)localObject1).HDm.width() * 1.0F / paramViewInfo.HDm.width();
        final float f4 = ((ViewAnimHelper.ViewInfo)localObject1).HDm.height() * 1.0F / paramViewInfo.HDm.height();
        final float f1;
        final float f2;
        label86:
        AnimationLayout localAnimationLayout;
        View localView;
        Object localObject2;
        Animator.AnimatorListener localAnimatorListener;
        if (f3 > f4)
        {
          f1 = f3;
          if (f4 <= f3) {
            break label339;
          }
          f2 = f4;
          localAnimationLayout = AnimationLayout.this;
          localView = paramView1;
          localObject2 = paramViewInfo;
          localAnimatorListener = paramAnimatorListener;
          if ((f1 <= 1.0F) && (f2 <= 1.0F)) {
            break label344;
          }
        }
        label339:
        label344:
        for (localObject1 = new ValueAnimator.AnimatorUpdateListener()
            {
              Matrix dY;
              
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(164234);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (f1 > 1.0F) {
                  this.dY.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.a(AnimationLayout.this).centerX(), AnimationLayout.a(AnimationLayout.this).centerY());
                }
                for (;;)
                {
                  this.dY.mapRect(AnimationLayout.b(AnimationLayout.this), new RectF(AnimationLayout.a(AnimationLayout.this)));
                  if (AnimationLayout.1.this.HUa != null) {
                    AnimationLayout.1.this.HUa.onAnimationUpdate(paramAnonymous2ValueAnimator);
                  }
                  AnimationLayout.this.invalidate();
                  AppMethodBeat.o(164234);
                  return;
                  if (f2 > 1.0F) {
                    this.dY.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.a(AnimationLayout.this).centerX(), AnimationLayout.a(AnimationLayout.this).centerY());
                  }
                }
              }
            };; localObject1 = null)
        {
          ViewAnimHelper.ViewInfo localViewInfo = ViewAnimHelper.m(localAnimationLayout, null);
          f1 = Math.max(((ViewAnimHelper.ViewInfo)localObject2).HDm.height() * 1.0F / localViewInfo.HDm.height(), ((ViewAnimHelper.ViewInfo)localObject2).HDm.width() * 1.0F / localViewInfo.HDm.width());
          f2 = localViewInfo.HDm.centerX();
          f3 = localViewInfo.HDm.centerY();
          f4 = ((ViewAnimHelper.ViewInfo)localObject2).HDm.centerX();
          float f5 = ((ViewAnimHelper.ViewInfo)localObject2).HDm.centerY();
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).setInterpolator(new AccelerateInterpolator(1.2F));
          ((ValueAnimator)localObject2).addUpdateListener(new ViewAnimHelper.1(localAnimationLayout, f4, f2, f5, f3, f1, localView, (ValueAnimator.AnimatorUpdateListener)localObject1));
          ((ValueAnimator)localObject2).addListener(new ViewAnimHelper.2(localAnimatorListener));
          ((ValueAnimator)localObject2).setInterpolator(new LinearInterpolator());
          ((ValueAnimator)localObject2).setDuration(240L);
          ((ValueAnimator)localObject2).start();
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
    paramView2 = ViewAnimHelper.m(this, paramView2);
    final float f3 = paramView2.HDm.width() * 1.0F / paramViewInfo.HDm.width();
    final float f4 = paramView2.HDm.height() * 1.0F / paramViewInfo.HDm.height();
    if (f3 > f4) {}
    for (final float f1 = f3;; f1 = 1.0F)
    {
      if (f4 > f3) {
        f2 = f4;
      }
      ViewAnimHelper.a(this, paramView1, paramViewInfo, paramAnimatorListener, new ValueAnimator.AnimatorUpdateListener()
      {
        Matrix dY;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(143604);
          float f;
          if ((f1 > 1.0F) || (f2 > 1.0F))
          {
            f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (f1 <= 1.0F) {
              break label147;
            }
            this.dY.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.a(AnimationLayout.this).centerX(), AnimationLayout.a(AnimationLayout.this).centerY());
          }
          for (;;)
          {
            this.dY.mapRect(AnimationLayout.b(AnimationLayout.this), new RectF(AnimationLayout.a(AnimationLayout.this)));
            AnimationLayout.this.invalidate();
            if (paramAnimatorUpdateListener != null) {
              paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
            }
            AppMethodBeat.o(143604);
            return;
            label147:
            if (f2 > 1.0F) {
              this.dY.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.a(AnimationLayout.this).centerX(), AnimationLayout.a(AnimationLayout.this).centerY());
            }
          }
        }
      });
      AppMethodBeat.o(143610);
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143608);
    if (this.HTW.isEmpty()) {
      paramCanvas.getClipBounds(this.HTW);
    }
    if (this.HTV.isEmpty())
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(143608);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipRect(this.HTV);
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
    this.HTV.setEmpty();
    AppMethodBeat.o(143609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.AnimationLayout
 * JD-Core Version:    0.7.0.1
 */