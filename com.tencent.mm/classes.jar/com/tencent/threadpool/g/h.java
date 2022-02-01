package com.tencent.threadpool.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.g.a.b;

public final class h
{
  public static b ahBK;
  
  public static b b(com.tencent.threadpool.a parama)
  {
    AppMethodBeat.i(183339);
    if (parama.ahzQ != null)
    {
      parama = parama.ahzQ;
      AppMethodBeat.o(183339);
      return parama;
    }
    int i = Math.max(1, parama.ahzN / 2);
    int j = Math.max(1, i / 3);
    switch (1.ahBL[parama.ahzR.ordinal()])
    {
    default: 
      parama = new d();
      AppMethodBeat.o(183339);
      return parama;
    case 1: 
      parama = new e(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 2: 
      parama = new c(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 3: 
      parama = new f(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 4: 
      parama = new i(i);
      AppMethodBeat.o(183339);
      return parama;
    }
    parama = new a(j, j);
    AppMethodBeat.o(183339);
    return parama;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(183338);
      ahBM = new a("FS_POLICY", 0);
      ahBN = new a("LINEAR_POLICY", 1);
      ahBO = new a("CONST_POLICY", 2);
      ahBP = new a("THROW_POLICY", 3);
      ahBQ = new a("BLOCK_INVOKER_POLICY", 4);
      ahBR = new a("DEFAULT", 5);
      ahBS = new a[] { ahBM, ahBN, ahBO, ahBP, ahBQ, ahBR };
      AppMethodBeat.o(183338);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g.h
 * JD-Core Version:    0.7.0.1
 */