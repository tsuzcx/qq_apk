package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

class ab
{
  private static Field kK;
  private static boolean kL;
  private static Field kM;
  private static boolean kN;
  private static WeakHashMap<View, String> kO;
  private static Method kQ;
  static Field kR;
  static boolean kS = false;
  WeakHashMap<View, as> kP = null;
  
  public static void a(View paramView, a parama)
  {
    if (parama == null) {}
    for (parama = null;; parama = parama.jI)
    {
      paramView.setAccessibilityDelegate(parama);
      return;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (kQ == null) {}
    try
    {
      kQ = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      kQ.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          kQ.invoke(paramViewGroup, new Object[] { Boolean.valueOf(true) });
          return;
        }
        catch (IllegalAccessException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (IllegalArgumentException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (InvocationTargetException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public static boolean d(View paramView)
  {
    if (kS) {}
    for (;;)
    {
      return false;
      if (kR == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        kR = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = kR.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          kS = true;
        }
        paramView = paramView;
        kS = true;
        return false;
      }
    }
    return false;
  }
  
  private static void w(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
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
  
  public av b(View paramView, av paramav)
  {
    return paramav;
  }
  
  public void b(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  public void c(View paramView, int paramInt) {}
  
  public void d(View paramView, float paramFloat) {}
  
  public void d(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      w(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        w((View)paramView);
      }
    }
  }
  
  public void e(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      w(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        w((View)paramView);
      }
    }
  }
  
  public boolean e(View paramView)
  {
    return false;
  }
  
  public void f(View paramView)
  {
    paramView.postInvalidate();
  }
  
  public int g(View paramView)
  {
    return 0;
  }
  
  public int i(View paramView)
  {
    return 0;
  }
  
  public ViewParent j(View paramView)
  {
    return paramView.getParent();
  }
  
  public int m(View paramView)
  {
    if (!kL) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      kK = localField;
      localField.setAccessible(true);
      label23:
      kL = true;
      if (kK != null) {
        try
        {
          int i = ((Integer)kK.get(paramView)).intValue();
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
  
  public int n(View paramView)
  {
    if (!kN) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      kM = localField;
      localField.setAccessible(true);
      label23:
      kN = true;
      if (kM != null) {
        try
        {
          int i = ((Integer)kM.get(paramView)).intValue();
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
  
  public float p(View paramView)
  {
    return 0.0F;
  }
  
  public String q(View paramView)
  {
    if (kO == null) {
      return null;
    }
    return (String)kO.get(paramView);
  }
  
  public boolean r(View paramView)
  {
    return false;
  }
  
  public boolean s(View paramView)
  {
    return true;
  }
  
  public boolean t(View paramView)
  {
    if ((paramView instanceof h)) {
      return ((h)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public void u(View paramView)
  {
    if ((paramView instanceof h)) {
      ((h)paramView).stopNestedScroll();
    }
  }
  
  public boolean v(View paramView)
  {
    return paramView.getWindowToken() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */