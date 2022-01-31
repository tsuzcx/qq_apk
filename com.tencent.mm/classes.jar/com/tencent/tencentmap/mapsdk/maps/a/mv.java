package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class mv
  implements mq, ms
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  
  protected mv(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(149342);
    this.a = Math.min(paramFloat1, paramFloat3);
    this.b = Math.min(paramFloat2, paramFloat4);
    this.c = Math.max(paramFloat1, paramFloat3);
    this.d = Math.max(paramFloat2, paramFloat4);
    AppMethodBeat.o(149342);
  }
  
  public static mv a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(149344);
    mv localmv = new mv((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4);
    AppMethodBeat.o(149344);
    return localmv;
  }
  
  public static mv a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(149345);
    mv localmv = new mv(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(149345);
    return localmv;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149350);
    if (Float.floatToIntBits(paramFloat1) == Float.floatToIntBits(paramFloat2))
    {
      AppMethodBeat.o(149350);
      return true;
    }
    AppMethodBeat.o(149350);
    return false;
  }
  
  public final mv a()
  {
    return this;
  }
  
  public final boolean a(mv parammv)
  {
    AppMethodBeat.i(149346);
    float f = Math.max(this.a, parammv.a);
    if (Math.min(this.c, parammv.c) < f)
    {
      AppMethodBeat.o(149346);
      return false;
    }
    f = Math.max(this.b, parammv.b);
    if (Math.min(this.d, parammv.d) >= f)
    {
      AppMethodBeat.o(149346);
      return true;
    }
    AppMethodBeat.o(149346);
    return false;
  }
  
  public final mq b()
  {
    return this;
  }
  
  public final mv b(mv parammv)
  {
    AppMethodBeat.i(149343);
    parammv = new mv(Math.min(this.a, parammv.a), Math.min(this.b, parammv.b), Math.max(this.c, parammv.c), Math.max(this.d, parammv.d));
    AppMethodBeat.o(149343);
    return parammv;
  }
  
  public final float c()
  {
    return this.a;
  }
  
  public final float c(mv parammv)
  {
    AppMethodBeat.i(149351);
    if (!a(parammv))
    {
      AppMethodBeat.o(149351);
      return 0.0F;
    }
    float f = a(Math.max(this.a, parammv.a), Math.max(this.b, parammv.b), Math.min(this.c, parammv.c), Math.min(this.d, parammv.d)).g();
    AppMethodBeat.o(149351);
    return f;
  }
  
  public final float d()
  {
    return this.b;
  }
  
  public final float e()
  {
    return this.c;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149349);
    if (paramObject == null)
    {
      AppMethodBeat.o(149349);
      return false;
    }
    if (!(paramObject instanceof mv))
    {
      AppMethodBeat.o(149349);
      return false;
    }
    paramObject = (mv)paramObject;
    if ((a(this.a, paramObject.a)) && (a(this.c, paramObject.c)) && (a(this.b, paramObject.b)) && (a(this.d, paramObject.d)))
    {
      AppMethodBeat.o(149349);
      return true;
    }
    AppMethodBeat.o(149349);
    return false;
  }
  
  public final float f()
  {
    return this.d;
  }
  
  public final float g()
  {
    return (this.c - this.a) * (this.d - this.b);
  }
  
  public final float h()
  {
    return (this.c - this.a) * 2.0F + (this.d - this.b) * 2.0F;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(149348);
    int i = Arrays.hashCode(new Object[] { Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d) });
    AppMethodBeat.o(149348);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149347);
    String str = "Rectangle [x1=" + this.a + ", y1=" + this.b + ", x2=" + this.c + ", y2=" + this.d + "]";
    AppMethodBeat.o(149347);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mv
 * JD-Core Version:    0.7.0.1
 */