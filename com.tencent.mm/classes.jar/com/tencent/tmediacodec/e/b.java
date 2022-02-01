package com.tencent.tmediacodec.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b ahUw;
  public boolean ahUs = true;
  public int ahUt = 1920;
  public int ahUu = 1920;
  public a ahUv = a.ahUx;
  
  static
  {
    AppMethodBeat.i(210768);
    ahUw = new b();
    AppMethodBeat.o(210768);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210779);
    String str = "[initWidth:" + this.ahUt + ", initHeight:" + this.ahUu + ", reConfigByRealFormat:" + this.ahUs + ']';
    AppMethodBeat.o(210779);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(210774);
      ahUx = new a("First", 0);
      ahUy = new a("SAME", 1);
      ahUz = new a[] { ahUx, ahUy };
      AppMethodBeat.o(210774);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmediacodec.e.b
 * JD-Core Version:    0.7.0.1
 */