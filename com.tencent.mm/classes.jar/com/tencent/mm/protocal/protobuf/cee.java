package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cee
  extends com.tencent.mm.bw.a
{
  public int LQC;
  public int MjJ;
  public int MjK;
  public int MjL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LQC);
      paramVarArgs.aM(2, this.MjJ);
      paramVarArgs.aM(3, this.MjK);
      paramVarArgs.aM(4, this.MjL);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LQC);
      int i = g.a.a.b.b.a.bu(2, this.MjJ);
      int j = g.a.a.b.b.a.bu(3, this.MjK);
      int k = g.a.a.b.b.a.bu(4, this.MjL);
      AppMethodBeat.o(152617);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cee localcee = (cee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localcee.LQC = locala.UbS.zi();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localcee.MjJ = locala.UbS.zi();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localcee.MjK = locala.UbS.zi();
        AppMethodBeat.o(152617);
        return 0;
      }
      localcee.MjL = locala.UbS.zi();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cee
 * JD-Core Version:    0.7.0.1
 */