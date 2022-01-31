package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
{
  private final int a;
  private final int b;
  private final mn c;
  private final ml d;
  
  public mc(int paramInt1, int paramInt2, ml paramml, mn parammn)
  {
    AppMethodBeat.i(149281);
    if ((parammn == null) || (paramml == null) || (paramInt2 <= 2) || (paramInt1 <= 0) || (paramInt1 >= paramInt2))
    {
      paramml = new IllegalArgumentException();
      AppMethodBeat.o(149281);
      throw paramml;
    }
    this.d = paramml;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = parammn;
    AppMethodBeat.o(149281);
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final mn c()
  {
    return this.c;
  }
  
  public final ml d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mc
 * JD-Core Version:    0.7.0.1
 */