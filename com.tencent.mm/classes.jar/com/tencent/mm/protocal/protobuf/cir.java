package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cir
  extends com.tencent.mm.cd.a
{
  public long TpA;
  public int TpB;
  public long TpC;
  public int TpD;
  public long TpE;
  public int TpF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.TpA);
      paramVarArgs.aY(2, this.TpB);
      paramVarArgs.bm(3, this.TpC);
      paramVarArgs.aY(4, this.TpD);
      paramVarArgs.bm(5, this.TpE);
      paramVarArgs.aY(6, this.TpF);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.TpA);
      int i = g.a.a.b.b.a.bM(2, this.TpB);
      int j = g.a.a.b.b.a.p(3, this.TpC);
      int k = g.a.a.b.b.a.bM(4, this.TpD);
      int m = g.a.a.b.b.a.p(5, this.TpE);
      int n = g.a.a.b.b.a.bM(6, this.TpF);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cir localcir = (cir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localcir.TpA = locala.abFh.AN();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localcir.TpB = locala.abFh.AK();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localcir.TpC = locala.abFh.AN();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localcir.TpD = locala.abFh.AK();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localcir.TpE = locala.abFh.AN();
        AppMethodBeat.o(115845);
        return 0;
      }
      localcir.TpF = locala.abFh.AK();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */