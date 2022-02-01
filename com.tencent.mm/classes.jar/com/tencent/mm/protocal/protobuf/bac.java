package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bac
  extends com.tencent.mm.bw.a
{
  public int LJQ;
  public int LJR;
  public int LJS;
  public int LJT;
  public int LJU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209626);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LJQ);
      paramVarArgs.aM(2, this.LJR);
      paramVarArgs.aM(3, this.LJS);
      paramVarArgs.aM(4, this.LJT);
      paramVarArgs.aM(5, this.LJU);
      AppMethodBeat.o(209626);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LJQ);
      int i = g.a.a.b.b.a.bu(2, this.LJR);
      int j = g.a.a.b.b.a.bu(3, this.LJS);
      int k = g.a.a.b.b.a.bu(4, this.LJT);
      int m = g.a.a.b.b.a.bu(5, this.LJU);
      AppMethodBeat.o(209626);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209626);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bac localbac = (bac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209626);
        return -1;
      case 1: 
        localbac.LJQ = locala.UbS.zi();
        AppMethodBeat.o(209626);
        return 0;
      case 2: 
        localbac.LJR = locala.UbS.zi();
        AppMethodBeat.o(209626);
        return 0;
      case 3: 
        localbac.LJS = locala.UbS.zi();
        AppMethodBeat.o(209626);
        return 0;
      case 4: 
        localbac.LJT = locala.UbS.zi();
        AppMethodBeat.o(209626);
        return 0;
      }
      localbac.LJU = locala.UbS.zi();
      AppMethodBeat.o(209626);
      return 0;
    }
    AppMethodBeat.o(209626);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bac
 * JD-Core Version:    0.7.0.1
 */