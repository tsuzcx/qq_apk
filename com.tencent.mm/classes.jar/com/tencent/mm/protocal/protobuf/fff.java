package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fff
  extends com.tencent.mm.bw.a
{
  public long NAA;
  public long NAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222858);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NAz);
      paramVarArgs.bb(2, this.NAA);
      AppMethodBeat.o(222858);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.NAz);
      int i = g.a.a.b.b.a.r(2, this.NAA);
      AppMethodBeat.o(222858);
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
      AppMethodBeat.o(222858);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fff localfff = (fff)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(222858);
        return -1;
      case 1: 
        localfff.NAz = locala.UbS.zl();
        AppMethodBeat.o(222858);
        return 0;
      }
      localfff.NAA = locala.UbS.zl();
      AppMethodBeat.o(222858);
      return 0;
    }
    AppMethodBeat.o(222858);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fff
 * JD-Core Version:    0.7.0.1
 */