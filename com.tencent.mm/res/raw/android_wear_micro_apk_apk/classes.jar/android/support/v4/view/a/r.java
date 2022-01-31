package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.List;

public final class r
{
  private static final s na = new v();
  private final Object nb;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      na = new u();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      na = new t();
      return;
    }
  }
  
  public r()
  {
    this.nb = na.a(this);
  }
  
  public r(Object paramObject)
  {
    this.nb = paramObject;
  }
  
  public static e bP()
  {
    return null;
  }
  
  public static boolean bQ()
  {
    return false;
  }
  
  public static List<e> bR()
  {
    return null;
  }
  
  public static e bS()
  {
    return null;
  }
  
  public final Object bO()
  {
    return this.nb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.r
 * JD-Core Version:    0.7.0.1
 */