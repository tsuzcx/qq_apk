package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cp
{
  private cz a;
  private double b;
  private float c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  
  public cp()
  {
    AppMethodBeat.i(150019);
    this.h = dg.c;
    this.a = new cz(39.984253000000002D, 116.307439D);
    this.b = 1.0D;
    this.c = 1.0F;
    this.d = -16777216;
    this.e = 0;
    this.f = 0;
    this.g = true;
    AppMethodBeat.o(150019);
  }
  
  public cp a(double paramDouble)
  {
    this.b = paramDouble;
    return this;
  }
  
  public cp a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.c = 1.0F;
      return this;
    }
    this.c = paramFloat;
    return this;
  }
  
  public cp a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public cp a(cz paramcz)
  {
    this.a = paramcz;
    return this;
  }
  
  public cp a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public cz a()
  {
    return this.a;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public cp b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public cp c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public cp d(int paramInt)
  {
    if ((paramInt < dg.a) || (paramInt > dg.c)) {
      return this;
    }
    this.h = paramInt;
    return this;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cp
 * JD-Core Version:    0.7.0.1
 */