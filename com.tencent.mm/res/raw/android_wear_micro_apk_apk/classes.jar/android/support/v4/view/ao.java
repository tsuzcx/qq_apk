package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class ao
{
  static final ar ob = new ar();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ob = new aq();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      ob = new ap();
      return;
    }
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof l)) {
      ((l)paramViewParent).f(paramInt);
    }
    while (paramInt != 0) {
      return;
    }
    ob.a(paramViewParent, paramView);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof l)) {
      ((l)paramViewParent).g(paramInt5);
    }
    while (paramInt5 != 0) {
      return;
    }
    ob.a(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof l)) {
      ((l)paramViewParent).a(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    }
    while (paramInt3 != 0) {
      return;
    }
    ob.a(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    return ob.a(paramViewParent, paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return ob.a(paramViewParent, paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof l)) {
      return ((l)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      return ob.a(paramViewParent, paramView1, paramView2, paramInt1);
    }
    return false;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof l)) {
      ((l)paramViewParent).c(paramView2, paramInt1);
    }
    while (paramInt2 != 0) {
      return;
    }
    ob.b(paramViewParent, paramView1, paramView2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ao
 * JD-Core Version:    0.7.0.1
 */