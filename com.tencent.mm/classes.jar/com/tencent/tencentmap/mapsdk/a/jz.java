package com.tencent.tencentmap.mapsdk.a;

public class jz
  implements is
{
  private jh a = null;
  private jy b = null;
  private kt c = null;
  
  public jz(jh paramjh, kt paramkt)
  {
    this.a = paramjh;
    this.c = paramkt;
  }
  
  public void a()
  {
    if (this.b != null) {
      synchronized (this.b)
      {
        this.b.notify();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    this.a.a().a(this);
    if (this.b == null) {
      this.b = new jy(this.a, this.c);
    }
    try
    {
      this.b.start();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void d()
  {
    if (this.b != null)
    {
      this.b.b();
      a();
    }
  }
  
  public void e()
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.a().b(this);
    } while (this.b == null);
    this.b.c();
    this.b = null;
  }
  
  public void f()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jz
 * JD-Core Version:    0.7.0.1
 */