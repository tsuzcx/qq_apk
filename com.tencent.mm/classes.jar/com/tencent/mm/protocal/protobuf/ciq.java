package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ciq
  extends com.tencent.mm.bw.a
{
  public long MnD;
  public long MnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MnD);
      paramVarArgs.bb(2, this.MnE);
      AppMethodBeat.o(207496);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.MnD);
      int i = g.a.a.b.b.a.r(2, this.MnE);
      AppMethodBeat.o(207496);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(207496);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ciq localciq = (ciq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207496);
        return -1;
      case 1: 
        localciq.MnD = locala.UbS.zl();
        AppMethodBeat.o(207496);
        return 0;
      }
      localciq.MnE = locala.UbS.zl();
      AppMethodBeat.o(207496);
      return 0;
    }
    AppMethodBeat.o(207496);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciq
 * JD-Core Version:    0.7.0.1
 */