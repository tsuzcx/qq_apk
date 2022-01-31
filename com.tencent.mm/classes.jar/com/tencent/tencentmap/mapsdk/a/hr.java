package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;

public abstract class hr
{
  protected long a;
  protected long b;
  protected hr.a c;
  private boolean d;
  private boolean e;
  private Interpolator f;
  
  private long c()
  {
    return SystemClock.uptimeMillis();
  }
  
  public void a()
  {
    if (!this.d)
    {
      if ((!this.e) && (this.c != null)) {
        this.c.a();
      }
      return;
    }
    float f1 = (float)(c() - this.b) / (float)this.a;
    if (f1 > 1.0F)
    {
      this.d = false;
      a(1.0F, this.f);
      if (this.c != null) {
        this.c.a();
      }
      this.e = true;
      return;
    }
    a(f1, this.f);
  }
  
  protected abstract void a(float paramFloat, Interpolator paramInterpolator);
  
  public boolean b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hr
 * JD-Core Version:    0.7.0.1
 */