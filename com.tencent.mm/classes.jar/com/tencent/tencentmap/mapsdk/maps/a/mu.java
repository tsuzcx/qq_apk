package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class mu
  implements mq
{
  private final mv a;
  
  protected mu(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149334);
    this.a = mv.a(paramFloat1, paramFloat2, paramFloat1, paramFloat2);
    AppMethodBeat.o(149334);
  }
  
  public static mu a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(149335);
    mu localmu = new mu((float)paramDouble1, (float)paramDouble2);
    AppMethodBeat.o(149335);
    return localmu;
  }
  
  public final mv a()
  {
    return this.a;
  }
  
  public final boolean a(mv parammv)
  {
    AppMethodBeat.i(149336);
    boolean bool = this.a.a(parammv);
    AppMethodBeat.o(149336);
    return bool;
  }
  
  public final float b()
  {
    AppMethodBeat.i(149337);
    float f = this.a.c();
    AppMethodBeat.o(149337);
    return f;
  }
  
  public final float c()
  {
    AppMethodBeat.i(149338);
    float f = this.a.d();
    AppMethodBeat.o(149338);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149340);
    if (paramObject == null)
    {
      AppMethodBeat.o(149340);
      return false;
    }
    if (!(paramObject instanceof mu))
    {
      AppMethodBeat.o(149340);
      return false;
    }
    paramObject = (mu)paramObject;
    if ((this.a == paramObject.a()) || ((this.a != null) && (this.a.equals(paramObject.a()))))
    {
      AppMethodBeat.o(149340);
      return true;
    }
    AppMethodBeat.o(149340);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(149339);
    int i = Arrays.hashCode(new Object[] { this.a });
    AppMethodBeat.o(149339);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149341);
    String str = "Point [x=" + b() + ", y=" + c() + "]";
    AppMethodBeat.o(149341);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mu
 * JD-Core Version:    0.7.0.1
 */