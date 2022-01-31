package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

class x
  extends w
{
  private static ThreadLocal<Rect> kH;
  
  private static Rect bt()
  {
    if (kH == null) {
      kH = new ThreadLocal();
    }
    Rect localRect2 = (Rect)kH.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      kH.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  public final av a(View paramView, av paramav)
  {
    paramav = (WindowInsets)av.a(paramav);
    WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramav);
    paramView = paramav;
    if (localWindowInsets != paramav) {
      paramView = new WindowInsets(localWindowInsets);
    }
    return av.n(paramView);
  }
  
  public final void a(View paramView, final n paramn)
  {
    if (paramn == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
    {
      public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        paramAnonymousWindowInsets = av.n(paramAnonymousWindowInsets);
        return (WindowInsets)av.a(paramn.a(paramAnonymousView, paramAnonymousWindowInsets));
      }
    });
  }
  
  public final av b(View paramView, av paramav)
  {
    paramav = (WindowInsets)av.a(paramav);
    WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramav);
    paramView = paramav;
    if (localWindowInsets != paramav) {
      paramView = new WindowInsets(localWindowInsets);
    }
    return av.n(paramView);
  }
  
  public final void d(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public void d(View paramView, int paramInt)
  {
    Rect localRect = bt();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      super.d(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void e(View paramView, int paramInt)
  {
    Rect localRect = bt();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      super.e(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final float p(View paramView)
  {
    return paramView.getElevation();
  }
  
  public final String q(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  public final boolean t(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public final void u(View paramView)
  {
    paramView.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.x
 * JD-Core Version:    0.7.0.1
 */