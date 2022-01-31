package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class sd
{
  private int a = -16777216;
  private int b = -16777216;
  private final List<ry> c = new ArrayList();
  private float d = 10.0F;
  private boolean e = true;
  private float f = 0.0F;
  
  public final sd a(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }
  
  public final sd a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public final sd a(Iterable<ry> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      ry localry = (ry)paramIterable.next();
      this.c.add(localry);
    }
    return this;
  }
  
  public final sd a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final List<ry> a()
  {
    return this.c;
  }
  
  public final float b()
  {
    return this.d;
  }
  
  public final sd b(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }
  
  public final sd b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final float e()
  {
    return this.f;
  }
  
  public final boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sd
 * JD-Core Version:    0.7.0.1
 */