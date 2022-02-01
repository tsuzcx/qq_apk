package android.support.v4.view.a;

import android.os.Build.VERSION;

public final class f
{
  private final Object oU;
  
  public f()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.oU = new h(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.oU = new g(this);
      return;
    }
    this.oU = null;
  }
  
  public f(Object paramObject)
  {
    this.oU = paramObject;
  }
  
  public final Object bY()
  {
    return this.oU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.f
 * JD-Core Version:    0.7.0.1
 */