package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

public final class r
{
  static final ab kG = new ab();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      kG = new aa();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      kG = new z();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      kG = new y();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      kG = new x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      kG = new w();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      kG = new v();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      kG = new u();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      kG = new t();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      kG = new s();
      return;
    }
  }
  
  public static av a(View paramView, av paramav)
  {
    return kG.a(paramView, paramav);
  }
  
  @Deprecated
  public static void a(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    kG.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    kG.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    kG.a(paramView, paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    ab.a(paramView, parama);
  }
  
  public static void a(View paramView, n paramn)
  {
    kG.a(paramView, paramn);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    kG.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    ab.a(paramViewGroup, true);
  }
  
  @Deprecated
  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public static av b(View paramView, av paramav)
  {
    return kG.b(paramView, paramav);
  }
  
  @Deprecated
  public static void b(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void b(View paramView, Runnable paramRunnable)
  {
    kG.b(paramView, paramRunnable);
  }
  
  @Deprecated
  public static boolean b(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  @Deprecated
  public static int c(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  @Deprecated
  public static void c(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public static void c(View paramView, int paramInt)
  {
    kG.c(paramView, paramInt);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    kG.d(paramView, paramFloat);
  }
  
  public static void d(View paramView, int paramInt)
  {
    kG.d(paramView, paramInt);
  }
  
  public static boolean d(View paramView)
  {
    return ab.d(paramView);
  }
  
  public static void e(View paramView, int paramInt)
  {
    kG.e(paramView, paramInt);
  }
  
  public static boolean e(View paramView)
  {
    return kG.e(paramView);
  }
  
  public static void f(View paramView)
  {
    kG.f(paramView);
  }
  
  public static int g(View paramView)
  {
    return kG.g(paramView);
  }
  
  @Deprecated
  public static float h(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static int i(View paramView)
  {
    return kG.i(paramView);
  }
  
  public static ViewParent j(View paramView)
  {
    return kG.j(paramView);
  }
  
  @Deprecated
  public static float k(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  @Deprecated
  public static float l(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int m(View paramView)
  {
    return kG.m(paramView);
  }
  
  public static int n(View paramView)
  {
    return kG.n(paramView);
  }
  
  public static as o(View paramView)
  {
    ab localab = kG;
    if (localab.kP == null) {
      localab.kP = new WeakHashMap();
    }
    as localas2 = (as)localab.kP.get(paramView);
    as localas1 = localas2;
    if (localas2 == null)
    {
      localas1 = new as(paramView);
      localab.kP.put(paramView, localas1);
    }
    return localas1;
  }
  
  public static float p(View paramView)
  {
    return kG.p(paramView);
  }
  
  public static String q(View paramView)
  {
    return kG.q(paramView);
  }
  
  public static boolean r(View paramView)
  {
    return kG.r(paramView);
  }
  
  public static boolean s(View paramView)
  {
    return kG.s(paramView);
  }
  
  public static boolean t(View paramView)
  {
    return kG.t(paramView);
  }
  
  public static void u(View paramView)
  {
    kG.u(paramView);
  }
  
  public static boolean v(View paramView)
  {
    return kG.v(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.r
 * JD-Core Version:    0.7.0.1
 */