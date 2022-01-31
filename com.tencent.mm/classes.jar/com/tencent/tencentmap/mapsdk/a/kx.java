package com.tencent.tencentmap.mapsdk.a;

public class kx<E>
{
  private int a;
  private volatile Object[] b;
  private volatile int c;
  private volatile int d;
  
  public kx(int paramInt)
  {
    this.a = paramInt;
    this.b = new Object[paramInt];
    this.d = 0;
    this.c = 0;
  }
  
  private void e()
  {
    this.d = 0;
    this.c = 0;
  }
  
  public E a()
  {
    if (d()) {
      return null;
    }
    this.c %= this.a;
    Object localObject = this.b[this.c];
    this.b[this.c] = null;
    this.c += 1;
    return localObject;
  }
  
  public boolean a(E paramE)
  {
    if (c()) {
      return false;
    }
    this.d %= this.a;
    Object[] arrayOfObject = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfObject[i] = paramE;
    return true;
  }
  
  public void b()
  {
    e();
    int i = 0;
    while (i < this.b.length)
    {
      this.b[i] = null;
      i += 1;
    }
  }
  
  public boolean c()
  {
    return (this.d + 1) % this.a == this.c;
  }
  
  public boolean d()
  {
    return this.d == this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kx
 * JD-Core Version:    0.7.0.1
 */