package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ad
{
  static final ag kU = new ag();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      kU = new af();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      kU = new ae();
      return;
    }
  }
  
  @Deprecated
  public static void b(ViewGroup paramViewGroup)
  {
    paramViewGroup.setMotionEventSplittingEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ad
 * JD-Core Version:    0.7.0.1
 */