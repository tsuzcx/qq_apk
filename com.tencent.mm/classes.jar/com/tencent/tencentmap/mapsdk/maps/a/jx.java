package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.tencentmap.mapsdk.a.ax;
import com.tencent.tencentmap.mapsdk.a.cu;
import com.tencent.tencentmap.mapsdk.a.cv;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class jx
  extends ax
  implements km
{
  private static AtomicInteger a = new AtomicInteger(1);
  protected boolean I = false;
  protected cv J;
  private final String b = String.valueOf(a.incrementAndGet());
  
  public final String A()
  {
    return this.b;
  }
  
  public cv B()
  {
    return this.J;
  }
  
  public void C()
  {
    if (this.J != null) {
      this.I = false;
    }
    c();
  }
  
  public void a(cu paramcu)
  {
    if (this.J != null) {
      this.I = this.J.toString().equals(paramcu.toString());
    }
    c();
  }
  
  public abstract void d();
  
  public boolean r()
  {
    return false;
  }
  
  public boolean y()
  {
    return false;
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jx
 * JD-Core Version:    0.7.0.1
 */