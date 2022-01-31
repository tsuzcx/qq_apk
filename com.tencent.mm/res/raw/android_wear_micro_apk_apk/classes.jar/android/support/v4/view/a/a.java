package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a
{
  private static final d mq = new d();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      mq = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      mq = new b();
      return;
    }
  }
  
  @Deprecated
  public static aa a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new aa(paramAccessibilityEvent);
  }
  
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    mq.a(paramAccessibilityEvent, paramInt);
  }
  
  public static int b(AccessibilityEvent paramAccessibilityEvent)
  {
    return mq.b(paramAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.a
 * JD-Core Version:    0.7.0.1
 */