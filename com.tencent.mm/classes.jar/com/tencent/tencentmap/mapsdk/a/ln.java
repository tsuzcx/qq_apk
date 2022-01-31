package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ln
  extends od
  implements lz
{
  private static AtomicInteger a = new AtomicInteger(1);
  protected boolean I = false;
  protected pz J;
  private final String b = String.valueOf(a.incrementAndGet());
  
  public void a(py parampy)
  {
    if (this.J != null) {
      this.I = this.J.toString().equals(parampy.toString());
    }
    c();
  }
  
  public abstract void d();
  
  public boolean n()
  {
    return false;
  }
  
  public void t() {}
  
  public final String u()
  {
    return this.b;
  }
  
  public pz v()
  {
    return this.J;
  }
  
  public void w()
  {
    if (this.J != null) {
      this.I = false;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ln
 * JD-Core Version:    0.7.0.1
 */