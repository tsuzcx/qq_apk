package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.TextView;

public final class v
{
  static final ab qB = new ab();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      qB = new aa();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      qB = new z();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      qB = new y();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      qB = new x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      qB = new w();
      return;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    qB.a(paramTextView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.v
 * JD-Core Version:    0.7.0.1
 */