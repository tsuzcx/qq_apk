package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AutoPlayViewPager
  extends ViewPager
{
  private static final String TAG = "AutoPlayViewPager";
  private ValueAnimator animator;
  private boolean autoCarousel = false;
  protected int mLastOffset = 0;
  private ViewPagerControlView pagerControlView;
  protected int scrollTime = 1000;
  protected int scrollTimeInterval = 4000;
  
  public AutoPlayViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoPlayViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void bindViewPagerControlView(ViewPagerControlView paramViewPagerControlView, boolean paramBoolean)
  {
    this.pagerControlView = paramViewPagerControlView;
    this.autoCarousel = paramBoolean;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195486);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(195486);
      return bool;
      pauseAutoPlay();
      continue;
      startAutoPlay();
    }
  }
  
  public void pauseAutoPlay()
  {
    AppMethodBeat.i(195482);
    if (this.autoCarousel)
    {
      if (this.animator != null)
      {
        this.animator.pause();
        AppMethodBeat.o(195482);
        return;
      }
      Log.e("AutoPlayViewPager", "animator is null when pauseAutoPlay");
    }
    AppMethodBeat.o(195482);
  }
  
  public void scrollToNextPage()
  {
    AppMethodBeat.i(195472);
    if (isFakeDragging())
    {
      AppMethodBeat.o(195472);
      return;
    }
    beginFakeDrag();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, getWidth() });
    localValueAnimator.setDuration(this.scrollTime);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(204084);
        if (AutoPlayViewPager.this.isFakeDragging())
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          AutoPlayViewPager.this.fakeDragBy(AutoPlayViewPager.this.mLastOffset - i);
          AutoPlayViewPager.this.mLastOffset = i;
        }
        AppMethodBeat.o(204084);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(265502);
        super.onAnimationEnd(paramAnonymousAnimator);
        if (AutoPlayViewPager.this.isFakeDragging())
        {
          AutoPlayViewPager.this.endFakeDrag();
          AutoPlayViewPager.this.mLastOffset = 0;
          AutoPlayViewPager.this.startAutoPlay();
        }
        AppMethodBeat.o(265502);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(195472);
  }
  
  public void setScrollTime(int paramInt)
  {
    this.scrollTime = paramInt;
  }
  
  public void setScrollTimeInterval(int paramInt)
  {
    this.scrollTimeInterval = paramInt;
  }
  
  public void startAutoPlay()
  {
    AppMethodBeat.i(195480);
    if (this.autoCarousel)
    {
      if (this.animator == null)
      {
        this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.animator.setDuration(this.scrollTimeInterval);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(266004);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            AutoPlayViewPager.this.pagerControlView.progress = f;
            AutoPlayViewPager.this.pagerControlView.invalidate();
            AppMethodBeat.o(266004);
          }
        });
        this.animator.addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(204874);
            super.onAnimationEnd(paramAnonymousAnimator);
            AutoPlayViewPager.this.scrollToNextPage();
            AppMethodBeat.o(204874);
          }
        });
      }
      this.animator.start();
      AppMethodBeat.o(195480);
      return;
    }
    this.pagerControlView.progress = 1.0F;
    this.pagerControlView.invalidate();
    AppMethodBeat.o(195480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager
 * JD-Core Version:    0.7.0.1
 */