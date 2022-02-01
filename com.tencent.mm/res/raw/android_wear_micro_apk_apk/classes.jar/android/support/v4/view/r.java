package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import java.util.WeakHashMap;

public final class r
{
  static final ab mC = new ab();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      mC = new aa();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      mC = new z();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      mC = new y();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mC = new x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      mC = new w();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      mC = new v();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      mC = new u();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      mC = new t();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      mC = new s();
      return;
    }
  }
  
  public static av a(View paramView, av paramav)
  {
    return mC.a(paramView, paramav);
  }
  
  @Deprecated
  public static void a(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mC.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    mC.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    mC.a(paramView, paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    ab.a(paramView, parama);
  }
  
  public static void a(View paramView, n paramn)
  {
    mC.a(paramView, paramn);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    mC.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    mC.a(paramView, paramString);
  }
  
  public static av b(View paramView, av paramav)
  {
    return mC.b(paramView, paramav);
  }
  
  @Deprecated
  public static void b(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void b(View paramView, Runnable paramRunnable)
  {
    mC.b(paramView, paramRunnable);
  }
  
  @Deprecated
  public static void c(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  @Deprecated
  public static int d(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  public static void d(View paramView, float paramFloat)
  {
    mC.d(paramView, paramFloat);
  }
  
  @Deprecated
  public static boolean d(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public static boolean e(View paramView)
  {
    return ab.e(paramView);
  }
  
  @Deprecated
  public static boolean e(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static void f(View paramView, int paramInt)
  {
    mC.f(paramView, paramInt);
  }
  
  public static boolean f(View paramView)
  {
    return mC.f(paramView);
  }
  
  public static void g(View paramView)
  {
    mC.g(paramView);
  }
  
  public static void g(View paramView, int paramInt)
  {
    mC.g(paramView, paramInt);
  }
  
  public static int h(View paramView)
  {
    return mC.h(paramView);
  }
  
  public static void h(View paramView, int paramInt)
  {
    mC.h(paramView, paramInt);
  }
  
  @Deprecated
  public static float i(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static int j(View paramView)
  {
    return mC.j(paramView);
  }
  
  public static ViewParent k(View paramView)
  {
    return mC.k(paramView);
  }
  
  @Deprecated
  public static float l(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  @Deprecated
  public static float m(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int n(View paramView)
  {
    return mC.n(paramView);
  }
  
  public static int o(View paramView)
  {
    return mC.o(paramView);
  }
  
  public static as p(View paramView)
  {
    ab localab = mC;
    if (localab.mM == null) {
      localab.mM = new WeakHashMap();
    }
    as localas2 = (as)localab.mM.get(paramView);
    as localas1 = localas2;
    if (localas2 == null)
    {
      localas1 = new as(paramView);
      localab.mM.put(paramView, localas1);
    }
    return localas1;
  }
  
  public static float q(View paramView)
  {
    return mC.q(paramView);
  }
  
  public static String r(View paramView)
  {
    return mC.r(paramView);
  }
  
  public static void s(View paramView)
  {
    mC.s(paramView);
  }
  
  public static boolean t(View paramView)
  {
    return mC.t(paramView);
  }
  
  public static boolean u(View paramView)
  {
    return mC.u(paramView);
  }
  
  public static boolean v(View paramView)
  {
    return mC.v(paramView);
  }
  
  public static void w(View paramView)
  {
    mC.w(paramView);
  }
  
  public static boolean x(View paramView)
  {
    return mC.x(paramView);
  }
  
  public static float y(View paramView)
  {
    return mC.y(paramView);
  }
  
  public static boolean z(View paramView)
  {
    return mC.z(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.r
 * JD-Core Version:    0.7.0.1
 */