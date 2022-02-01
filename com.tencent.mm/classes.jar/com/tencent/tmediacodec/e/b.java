package com.tencent.tmediacodec.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b SmK;
  public boolean SmG = true;
  public int SmH = 1920;
  public int SmI = 1920;
  public a SmJ = a.SmL;
  
  static
  {
    AppMethodBeat.i(190176);
    SmK = new b();
    AppMethodBeat.o(190176);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190175);
    String str = "[initWidth:" + this.SmH + ", initHeight:" + this.SmI + ", reConfigByRealFormat:" + this.SmG + ']';
    AppMethodBeat.o(190175);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(190174);
      SmL = new a("First", 0);
      SmM = new a("SAME", 1);
      SmN = new a[] { SmL, SmM };
      AppMethodBeat.o(190174);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmediacodec.e.b
 * JD-Core Version:    0.7.0.1
 */