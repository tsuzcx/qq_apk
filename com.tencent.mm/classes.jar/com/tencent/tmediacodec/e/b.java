package com.tencent.tmediacodec.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b ZPv;
  public boolean ZPr = true;
  public int ZPs = 1920;
  public int ZPt = 1920;
  public a ZPu = a.ZPw;
  
  static
  {
    AppMethodBeat.i(224576);
    ZPv = new b();
    AppMethodBeat.o(224576);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224574);
    String str = "[initWidth:" + this.ZPs + ", initHeight:" + this.ZPt + ", reConfigByRealFormat:" + this.ZPr + ']';
    AppMethodBeat.o(224574);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(224569);
      ZPw = new a("First", 0);
      ZPx = new a("SAME", 1);
      ZPy = new a[] { ZPw, ZPx };
      AppMethodBeat.o(224569);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmediacodec.e.b
 * JD-Core Version:    0.7.0.1
 */