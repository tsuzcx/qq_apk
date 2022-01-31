package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class sf
{
  private boolean a = false;
  private boolean b = false;
  private final List<ry> c = new ArrayList();
  private boolean d = true;
  private int e = -16777216;
  private float f = 10.0F;
  private float g = 0.0F;
  private rs h;
  private float i = 0.0F;
  private int j = -983041;
  private float k = 90.0F;
  
  public final rs a()
  {
    return this.h;
  }
  
  public final sf a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.k = paramFloat;
    }
    return this;
  }
  
  public final sf a(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public final sf a(rs paramrs)
  {
    if (paramrs != null) {
      this.h = paramrs;
    }
    return this;
  }
  
  public final sf a(Iterable<ry> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      ry localry = (ry)paramIterable.next();
      this.c.add(localry);
    }
    return this;
  }
  
  public final sf a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public final float b()
  {
    return this.i;
  }
  
  public final sf b(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.i = paramFloat;
    }
    return this;
  }
  
  public final sf b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public final sf b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public final int c()
  {
    return this.j;
  }
  
  public final sf c(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }
  
  public final sf c(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public final float d()
  {
    return this.k;
  }
  
  public final sf d(float paramFloat)
  {
    this.g = paramFloat;
    return this;
  }
  
  public final List<ry> e()
  {
    return this.c;
  }
  
  public final float f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.e;
  }
  
  public final float h()
  {
    return this.g;
  }
  
  public final boolean i()
  {
    return this.d;
  }
  
  public final boolean j()
  {
    return this.a;
  }
  
  public final boolean k()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sf
 * JD-Core Version:    0.7.0.1
 */