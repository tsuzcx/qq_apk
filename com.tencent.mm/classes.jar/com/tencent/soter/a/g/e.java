package com.tencent.soter.a.g;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d;
import com.tencent.soter.core.c.c;

public final class e
{
  public d MoB;
  public String MoC = "";
  int[] MoD;
  public c MoE;
  public String MoF = "";
  HandlerThread MoG;
  
  public static final class a
  {
    public e MoH;
    
    public a()
    {
      AppMethodBeat.i(31);
      this.MoH = new e((byte)0);
      AppMethodBeat.o(31);
    }
    
    public final a N(int... paramVarArgs)
    {
      this.MoH.MoD = paramVarArgs;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.e
 * JD-Core Version:    0.7.0.1
 */