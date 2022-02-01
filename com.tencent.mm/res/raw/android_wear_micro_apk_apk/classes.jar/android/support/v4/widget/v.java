package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.TextView;

public final class v
{
  static final ac sp = new ac();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 27) {}
    for (int i = 1; i != 0; i = 0)
    {
      sp = new ab();
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      sp = new aa();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      sp = new z();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      sp = new y();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      sp = new x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      sp = new w();
      return;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    sp.a(paramTextView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.v
 * JD-Core Version:    0.7.0.1
 */