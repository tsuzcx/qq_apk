package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a
{
  @Deprecated
  public static i a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new i(paramAccessibilityEvent);
  }
  
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.a
 * JD-Core Version:    0.7.0.1
 */