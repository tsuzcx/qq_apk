package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dap
  extends com.tencent.mm.cd.a
{
  public long THU;
  public boolean THV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.THU);
      paramVarArgs.co(2, this.THV);
      AppMethodBeat.o(205539);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.THU);
      int i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(205539);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205539);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dap localdap = (dap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(205539);
        return -1;
      case 1: 
        localdap.THU = locala.abFh.AN();
        AppMethodBeat.o(205539);
        return 0;
      }
      localdap.THV = locala.abFh.AB();
      AppMethodBeat.o(205539);
      return 0;
    }
    AppMethodBeat.o(205539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dap
 * JD-Core Version:    0.7.0.1
 */