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
  public RectF ClP;
  public Rect LKq;
  
  public AnimationLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164237);
    this.ClP = new RectF();
    this.LKq = new Rect();
    AppMethodBeat.o(164237);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143605);
    this.ClP = new RectF();
    this.LKq = new Rect();
    AppMethodBeat.o(143605);
  }
  
  public AnimationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143606);
    this.ClP = new RectF();
    this.LKq = new Rect();
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
        Object localObject = ViewAnimHelper.o(AnimationLayout.this, paramView2);
        final float f3 = ((ViewAnimHelper.ViewInfo)localObject).Lro.width() * 1.0F / paramViewInfo.Lro.width();
        final float f4 = ((ViewAnimHelper.ViewInfo)localObject).Lro.height() * 1.0F / paramViewInfo.Lro.height();
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
              Matrix gR;
              
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(164234);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (f1 > 1.0F) {
                  this.gR.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
                }
                for (;;)
                {
                  this.gR.mapRect(AnimationLayout.this.ClP, new RectF(AnimationLayout.this.LKq));
                  if (AnimationLayout.1.this.LKu != null) {
                    AnimationLayout.1.this.LKu.onAnimationUpdate(paramAnonymous2ValueAnimator);
                  }
                  AnimationLayout.this.invalidate();
                  AppMethodBeat.o(164234);
                  return;
                  if (f2 > 1.0F) {
                    this.gR.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
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
    paramView2 = ViewAnimHelper.o(this, paramView2);
    final float f3 = paramView2.Lro.width() * 1.0F / paramViewInfo.Lro.width();
    final float f4 = paramView2.Lro.height() * 1.0F / paramViewInfo.Lro.height();
    if (f3 > f4) {}
    for (final float f1 = f3;; f1 = 1.0F)
    {
      if (f4 > f3) {
        f2 = f4;
      }
      ViewAnimHelper.a(this, paramView1, paramViewInfo, paramAnimatorListener, new ValueAnimator.AnimatorUpdateListener()
      {
        Matrix gR;
        
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
            this.gR.setScale(1.0F - f + f4 * f / f3, 1.0F, AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
          }
          for (;;)
          {
            this.gR.mapRect(AnimationLayout.this.ClP, new RectF(AnimationLayout.this.LKq));
            AnimationLayout.this.invalidate();
            if (paramAnimatorUpdateListener != null) {
              paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
            }
            AppMethodBeat.o(143604);
            return;
            label147:
            if (f2 > 1.0F) {
              this.gR.setScale(1.0F, 1.0F - f + f3 * f / f4, AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
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
    AppMethodBeat.i(193806);
    paramView1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193804);
        Object localObject = ViewAnimHelper.o(AnimationLayout.this, paramView2);
        final float f3 = ((ViewAnimHelper.ViewInfo)localObject).Lro.width() * 1.0F / paramViewInfo.Lro.width();
        final float f4 = ((ViewAnimHelper.ViewInfo)localObject).Lro.height() * 1.0F / paramViewInfo.Lro.height();
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
              Matrix gR;
              
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(193803);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (f1 > 1.0F) {
                  this.gR.setScale(f + f4 / f3 * (1.0F - f), 1.0F, AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
                }
                for (;;)
                {
                  this.gR.mapRect(AnimationLayout.this.ClP, new RectF(AnimationLayout.this.LKq));
                  if (AnimationLayout.4.this.LKu != null) {
                    AnimationLayout.4.this.LKu.onAnimationUpdate(paramAnonymous2ValueAnimator);
                  }
                  AnimationLayout.this.invalidate();
                  AppMethodBeat.o(193803);
                  return;
                  if (f2 > 1.0F) {
                    this.gR.setScale(1.0F, f + f3 / f4 * (1.0F - f), AnimationLayout.this.LKq.centerX(), AnimationLayout.this.LKq.centerY());
                  }
                }
              }
            };; localObject = null)
        {
          ViewAnimHelper.c(localAnimationLayout, localView, localViewInfo, localAnimatorListener, (ValueAnimator.AnimatorUpdateListener)localObject);
          AppMethodBeat.o(193804);
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
      AppMethodBeat.o(193806);
      return;
    }
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(193805);
        AnimationLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
        paramView1.run();
        AppMethodBeat.o(193805);
        return true;
      }
    });
    AppMethodBeat.o(193806);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143608);
    if (this.LKq.isEmpty()) {
      paramCanvas.getClipBounds(this.LKq);
    }
    if (this.ClP.isEmpty())
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(143608);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipRect(this.ClP);
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
    this.ClP.setEmpty();
    AppMethodBeat.o(143609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.AnimationLayout
 * JD-Core Version:    0.7.0.1
 */