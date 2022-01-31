package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fu
  implements gf
{
  private int a;
  private int b;
  private final int c;
  private final float d;
  
  public fu()
  {
    this(2500, 1, 1.0F);
  }
  
  public fu(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(gi paramgi)
  {
    AppMethodBeat.i(147963);
    this.b += 1;
    this.a = ((int)(this.a + this.a * this.d));
    if (!c())
    {
      AppMethodBeat.o(147963);
      throw paramgi;
    }
    AppMethodBeat.o(147963);
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected boolean c()
  {
    return this.b <= this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fu
 * JD-Core Version:    0.7.0.1
 */