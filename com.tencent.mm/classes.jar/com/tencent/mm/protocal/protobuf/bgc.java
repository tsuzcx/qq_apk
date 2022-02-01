package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgc
  extends com.tencent.mm.bw.a
{
  public boolean LPO;
  public boolean LPP;
  public boolean LPQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.LPO);
      paramVarArgs.cc(2, this.LPP);
      paramVarArgs.cc(3, this.LPQ);
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(116470);
      return paramInt + 1 + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bgc localbgc = (bgc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116470);
        return -1;
      case 1: 
        localbgc.LPO = locala.UbS.yZ();
        AppMethodBeat.o(116470);
        return 0;
      case 2: 
        localbgc.LPP = locala.UbS.yZ();
        AppMethodBeat.o(116470);
        return 0;
      }
      localbgc.LPQ = locala.UbS.yZ();
      AppMethodBeat.o(116470);
      return 0;
    }
    AppMethodBeat.o(116470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgc
 * JD-Core Version:    0.7.0.1
 */