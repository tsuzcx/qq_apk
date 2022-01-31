package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class le
  implements a
{
  private iv a;
  private jd b;
  private b c;
  
  public le(kx paramkx, String paramString)
  {
    AppMethodBeat.i(149139);
    this.a = new lg(paramkx.i(), paramString);
    this.b = new ld(paramkx);
    this.c = new lf(paramkx.i(), paramString);
    AppMethodBeat.o(149139);
  }
  
  public iv a()
  {
    return this.a;
  }
  
  public jd b()
  {
    return this.b;
  }
  
  public b c()
  {
    return this.c;
  }
  
  public c d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.le
 * JD-Core Version:    0.7.0.1
 */