package com.tencent.tencentmap.mapsdk.a;

public class iv
{
  public static final iv g = new iv(1, null);
  public static final iv h = new iv(2, null, true);
  public static final iv i = new iv(104, null);
  public int a;
  public double[] b;
  public long c = -1L;
  public boolean d = false;
  public boolean e;
  public Runnable f;
  private iw j;
  
  public iv() {}
  
  public iv(int paramInt, double[] paramArrayOfDouble)
  {
    this(paramInt, paramArrayOfDouble, false);
  }
  
  public iv(int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramArrayOfDouble;
    this.e = paramBoolean;
  }
  
  public iv(Runnable paramRunnable)
  {
    this.a = 6;
    this.f = paramRunnable;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean a(ix.a parama)
  {
    if (this.j != null) {
      this.j.a();
    }
    boolean bool = a();
    parama.a(this);
    return bool;
  }
  
  public void b()
  {
    if (this.j != null) {
      this.j.b();
    }
  }
  
  public void c()
  {
    if (this.j != null) {
      this.j.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.iv
 * JD-Core Version:    0.7.0.1
 */