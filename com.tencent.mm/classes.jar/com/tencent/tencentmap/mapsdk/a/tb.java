package com.tencent.tencentmap.mapsdk.a;

public final class tb
  extends sy
{
  private float d;
  private float e;
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(tn paramtn)
  {
    paramtn = paramtn.c();
    if (this.a)
    {
      paramtn.a((int)-this.d, (int)-this.e, this.b, this.c);
      return;
    }
    paramtn.scrollBy((int)-this.d, (int)-this.e);
  }
  
  public final void b(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tb
 * JD-Core Version:    0.7.0.1
 */