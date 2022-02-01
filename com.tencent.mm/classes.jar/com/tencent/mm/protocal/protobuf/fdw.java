package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdw
  extends com.tencent.mm.bw.a
{
  public float LbC;
  public float LbD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.LbC);
      paramVarArgs.E(2, this.LbD);
      AppMethodBeat.o(117958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(117958);
      return paramInt + 4 + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117958);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdw localfdw = (fdw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117958);
        return -1;
      case 1: 
        localfdw.LbC = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(117958);
        return 0;
      }
      localfdw.LbD = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(117958);
      return 0;
    }
    AppMethodBeat.o(117958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdw
 * JD-Core Version:    0.7.0.1
 */