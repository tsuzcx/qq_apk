package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvm
  extends com.tencent.mm.bw.a
{
  public int MWA;
  public int MWB;
  public int MWC;
  public int MWD;
  public int MWE;
  public int MWy;
  public int MWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MWy);
      paramVarArgs.aM(2, this.MWz);
      paramVarArgs.aM(3, this.MWA);
      paramVarArgs.aM(4, this.MWB);
      paramVarArgs.aM(5, this.MWC);
      paramVarArgs.aM(6, this.MWD);
      paramVarArgs.aM(7, this.MWE);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MWy);
      int i = g.a.a.b.b.a.bu(2, this.MWz);
      int j = g.a.a.b.b.a.bu(3, this.MWA);
      int k = g.a.a.b.b.a.bu(4, this.MWB);
      int m = g.a.a.b.b.a.bu(5, this.MWC);
      int n = g.a.a.b.b.a.bu(6, this.MWD);
      int i1 = g.a.a.b.b.a.bu(7, this.MWE);
      AppMethodBeat.o(124550);
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
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dvm localdvm = (dvm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localdvm.MWy = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localdvm.MWz = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localdvm.MWA = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localdvm.MWB = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localdvm.MWC = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localdvm.MWD = locala.UbS.zi();
        AppMethodBeat.o(124550);
        return 0;
      }
      localdvm.MWE = locala.UbS.zi();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvm
 * JD-Core Version:    0.7.0.1
 */