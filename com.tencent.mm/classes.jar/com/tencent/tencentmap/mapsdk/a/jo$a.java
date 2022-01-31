package com.tencent.tencentmap.mapsdk.a;

public class jo$a
  implements Cloneable
{
  private float a = 3.051758E-005F;
  private float b = 4.0F;
  private int c = 3;
  private int d = 19;
  private float e;
  private int f;
  
  float a()
  {
    return this.e;
  }
  
  float a(int paramInt)
  {
    return 1.907349E-006F * (1 << paramInt - 1);
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.e = paramFloat;
    this.f = paramInt;
  }
  
  void a(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f;
  }
  
  int b()
  {
    return this.f;
  }
  
  void b(float paramFloat)
  {
    a locala = new a();
    this.c = locala.b();
    this.a = (paramFloat / locala.c());
  }
  
  float c()
  {
    return this.e / a(this.f);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  int d()
  {
    return this.c;
  }
  
  int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.e != paramObject.e) || (this.f != paramObject.f));
    return true;
  }
  
  int f()
  {
    return 20;
  }
  
  float g()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return "scale:" + this.e + ", scaleLevel:" + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jo.a
 * JD-Core Version:    0.7.0.1
 */