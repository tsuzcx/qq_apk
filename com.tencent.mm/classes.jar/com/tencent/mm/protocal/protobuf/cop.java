package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cop
  extends com.tencent.mm.bw.a
{
  public int AXb;
  public int MuL;
  public int MuM;
  public int MuN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MuL);
      paramVarArgs.aM(2, this.MuM);
      paramVarArgs.aM(3, this.MuN);
      paramVarArgs.aM(4, this.AXb);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MuL);
      int i = g.a.a.b.b.a.bu(2, this.MuM);
      int j = g.a.a.b.b.a.bu(3, this.MuN);
      int k = g.a.a.b.b.a.bu(4, this.AXb);
      AppMethodBeat.o(116472);
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
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cop localcop = (cop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localcop.MuL = locala.UbS.zi();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localcop.MuM = locala.UbS.zi();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localcop.MuN = locala.UbS.zi();
        AppMethodBeat.o(116472);
        return 0;
      }
      localcop.AXb = locala.UbS.zi();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */