package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class ab
{
  private static Field mG;
  private static boolean mH;
  private static Field mI;
  private static boolean mJ;
  private static WeakHashMap<View, String> mK;
  private static final AtomicInteger mL = new AtomicInteger(1);
  static Field mN;
  static boolean mO = false;
  WeakHashMap<View, as> mM = null;
  
  private static void B(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static void a(View paramView, a parama)
  {
    if (parama == null) {}
    for (parama = null;; parama = parama.lF)
    {
      paramView.setAccessibilityDelegate(parama);
      return;
    }
  }
  
  public static boolean e(View paramView)
  {
    if (mO) {}
    for (;;)
    {
      return false;
      if (mN == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        mN = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = mN.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          mO = true;
        }
        paramView = paramView;
        mO = true;
        return false;
      }
    }
    return false;
  }
  
  public float A(View paramView)
  {
    return 0.0F;
  }
  
  public av a(View paramView, av paramav)
  {
    return paramav;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(View paramView, Paint paramPaint)
  {
    paramView.setLayerType(paramView.getLayerType(), paramPaint);
    paramView.invalidate();
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView, n paramn) {}
  
  public void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
  }
  
  public void a(View paramView, String paramString)
  {
    if (mK == null) {
      mK = new WeakHashMap();
    }
    mK.put(paramView, paramString);
  }
  
  public av b(View paramView, av paramav)
  {
    return paramav;
  }
  
  public void b(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  public void d(View paramView, float paramFloat) {}
  
  public void f(View paramView, int paramInt) {}
  
  public boolean f(View paramView)
  {
    return false;
  }
  
  public void g(View paramView)
  {
    paramView.postInvalidate();
  }
  
  public void g(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      B(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        B((View)paramView);
      }
    }
  }
  
  public int h(View paramView)
  {
    return 0;
  }
  
  public void h(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      B(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        B((View)paramView);
      }
    }
  }
  
  public int j(View paramView)
  {
    return 0;
  }
  
  public ViewParent k(View paramView)
  {
    return paramView.getParent();
  }
  
  public int n(View paramView)
  {
    if (!mH) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      mG = localField;
      localField.setAccessible(true);
      label23:
      mH = true;
      if (mG != null) {
        try
        {
          int i = ((Integer)mG.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  public int o(View paramView)
  {
    if (!mJ) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      mI = localField;
      localField.setAccessible(true);
      label23:
      mJ = true;
      if (mI != null) {
        try
        {
          int i = ((Integer)mI.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  public float q(View paramView)
  {
    return 0.0F;
  }
  
  public String r(View paramView)
  {
    if (mK == null) {
      return null;
    }
    return (String)mK.get(paramView);
  }
  
  public void s(View paramView) {}
  
  public boolean t(View paramView)
  {
    return false;
  }
  
  public boolean u(View paramView)
  {
    return true;
  }
  
  public boolean v(View paramView)
  {
    if ((paramView instanceof h)) {
      return ((h)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public void w(View paramView)
  {
    if ((paramView instanceof h)) {
      ((h)paramView).stopNestedScroll();
    }
  }
  
  public boolean x(View paramView)
  {
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public float y(View paramView)
  {
    return A(paramView) + q(paramView);
  }
  
  public boolean z(View paramView)
  {
    return paramView.getWindowToken() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */