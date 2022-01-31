package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.ref.WeakReference;

public final class as
{
  private WeakReference<View> mg;
  Runnable mh = null;
  Runnable mi = null;
  int mj = -1;
  
  as(View paramView)
  {
    this.mg = new WeakReference(paramView);
  }
  
  private void a(final View paramView, final au paramau)
  {
    if (paramau != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramau.A(paramView);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramau.z(paramView);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramau.y(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final as a(long paramLong)
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final as a(au paramau)
  {
    View localView = (View)this.mg.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        a(localView, paramau);
      }
    }
    else {
      return this;
    }
    localView.setTag(2113929216, paramau);
    a(localView, new at(this));
    return this;
  }
  
  public final as b(float paramFloat)
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final as c(float paramFloat)
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().translationX(paramFloat);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final as d(float paramFloat)
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)this.mg.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.as
 * JD-Core Version:    0.7.0.1
 */