package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cct
  extends com.tencent.mm.bw.a
{
  public int MiA;
  public int MiB;
  public int MiC;
  public int MiD;
  public int MiE;
  public int MiF;
  public int MiG;
  public int dDH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MiA);
      paramVarArgs.aM(2, this.dDH);
      paramVarArgs.aM(3, this.MiB);
      paramVarArgs.aM(4, this.MiC);
      paramVarArgs.aM(5, this.MiD);
      paramVarArgs.aM(6, this.MiE);
      paramVarArgs.aM(7, this.MiF);
      paramVarArgs.aM(8, this.MiG);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MiA);
      int i = g.a.a.b.b.a.bu(2, this.dDH);
      int j = g.a.a.b.b.a.bu(3, this.MiB);
      int k = g.a.a.b.b.a.bu(4, this.MiC);
      int m = g.a.a.b.b.a.bu(5, this.MiD);
      int n = g.a.a.b.b.a.bu(6, this.MiE);
      int i1 = g.a.a.b.b.a.bu(7, this.MiF);
      int i2 = g.a.a.b.b.a.bu(8, this.MiG);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cct localcct = (cct)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localcct.MiA = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localcct.dDH = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localcct.MiB = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localcct.MiC = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localcct.MiD = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localcct.MiE = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localcct.MiF = locala.UbS.zi();
        AppMethodBeat.o(143981);
        return 0;
      }
      localcct.MiG = locala.UbS.zi();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cct
 * JD-Core Version:    0.7.0.1
 */