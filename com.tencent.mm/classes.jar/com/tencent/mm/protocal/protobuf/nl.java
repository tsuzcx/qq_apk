package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nl
  extends com.tencent.mm.bw.a
{
  public int KJN;
  public int KSQ;
  public int KSR;
  public int KSS;
  public int KST;
  public int KSU;
  public int enabled;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103202);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.enabled);
      paramVarArgs.aM(2, this.KSQ);
      paramVarArgs.aM(3, this.KSR);
      paramVarArgs.aM(4, this.KSS);
      paramVarArgs.aM(5, this.KST);
      paramVarArgs.aM(6, this.KSU);
      paramVarArgs.aM(7, this.KJN);
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.enabled);
      int i = g.a.a.b.b.a.bu(2, this.KSQ);
      int j = g.a.a.b.b.a.bu(3, this.KSR);
      int k = g.a.a.b.b.a.bu(4, this.KSS);
      int m = g.a.a.b.b.a.bu(5, this.KST);
      int n = g.a.a.b.b.a.bu(6, this.KSU);
      int i1 = g.a.a.b.b.a.bu(7, this.KJN);
      AppMethodBeat.o(103202);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      nl localnl = (nl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103202);
        return -1;
      case 1: 
        localnl.enabled = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      case 2: 
        localnl.KSQ = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      case 3: 
        localnl.KSR = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      case 4: 
        localnl.KSS = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      case 5: 
        localnl.KST = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      case 6: 
        localnl.KSU = locala.UbS.zi();
        AppMethodBeat.o(103202);
        return 0;
      }
      localnl.KJN = locala.UbS.zi();
      AppMethodBeat.o(103202);
      return 0;
    }
    AppMethodBeat.o(103202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nl
 * JD-Core Version:    0.7.0.1
 */