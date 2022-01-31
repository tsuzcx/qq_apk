package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public long iHc;
  public String name;
  public long startTime;
  public a ysD;
  public long ysE;
  
  public e(String paramString)
  {
    this.name = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52590);
    String str = this.name + " " + this.ysD + " " + this.ysE + " " + this.startTime + " " + this.iHc;
    AppMethodBeat.o(52590);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(52589);
      ysF = new a("WAITING", 0);
      ysG = new a("RUNNING", 1);
      ysH = new a("FINISH", 2);
      ysI = new a[] { ysF, ysG, ysH };
      AppMethodBeat.o(52589);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.e
 * JD-Core Version:    0.7.0.1
 */