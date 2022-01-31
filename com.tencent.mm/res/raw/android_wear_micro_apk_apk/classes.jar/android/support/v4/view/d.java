package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.Gravity;

public final class d
{
  public static int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
    }
    return 0xFF7FFFFF & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.d
 * JD-Core Version:    0.7.0.1
 */