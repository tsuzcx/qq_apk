package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ad
{
  static final ag mQ = new ag();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      mQ = new af();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      mQ = new ae();
      return;
    }
  }
  
  public static boolean a(ViewGroup paramViewGroup)
  {
    return mQ.a(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ad
 * JD-Core Version:    0.7.0.1
 */