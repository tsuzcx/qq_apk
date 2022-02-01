package com.tencent.soter.a.g;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d;
import com.tencent.soter.core.c.c;

public final class e
{
  public d JXJ;
  public String JXK = "";
  int[] JXL;
  public c JXM;
  public String JXN = "";
  HandlerThread JXO;
  
  public static final class a
  {
    public e JXP;
    
    public a()
    {
      AppMethodBeat.i(31);
      this.JXP = new e((byte)0);
      AppMethodBeat.o(31);
    }
    
    public final a M(int... paramVarArgs)
    {
      this.JXP.JXL = paramVarArgs;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.e
 * JD-Core Version:    0.7.0.1
 */