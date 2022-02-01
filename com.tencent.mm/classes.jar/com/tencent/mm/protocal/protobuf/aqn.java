package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqn
  extends com.tencent.mm.cd.a
{
  public int SDK;
  public int SDL;
  public int SDM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204782);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SDK);
      paramVarArgs.aY(2, this.SDL);
      paramVarArgs.aY(3, this.SDM);
      AppMethodBeat.o(204782);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SDK);
      int i = g.a.a.b.b.a.bM(2, this.SDL);
      int j = g.a.a.b.b.a.bM(3, this.SDM);
      AppMethodBeat.o(204782);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(204782);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aqn localaqn = (aqn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(204782);
        return -1;
      case 1: 
        localaqn.SDK = locala.abFh.AK();
        AppMethodBeat.o(204782);
        return 0;
      case 2: 
        localaqn.SDL = locala.abFh.AK();
        AppMethodBeat.o(204782);
        return 0;
      }
      localaqn.SDM = locala.abFh.AK();
      AppMethodBeat.o(204782);
      return 0;
    }
    AppMethodBeat.o(204782);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqn
 * JD-Core Version:    0.7.0.1
 */