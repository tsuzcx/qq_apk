package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anw
  extends com.tencent.mm.bw.a
{
  public int LzC = 0;
  public long endTime = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.startTime);
      paramVarArgs.bb(2, this.endTime);
      paramVarArgs.aM(3, this.LzC);
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.startTime);
      int i = g.a.a.b.b.a.r(2, this.endTime);
      int j = g.a.a.b.b.a.bu(3, this.LzC);
      AppMethodBeat.o(122489);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      anw localanw = (anw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122489);
        return -1;
      case 1: 
        localanw.startTime = locala.UbS.zl();
        AppMethodBeat.o(122489);
        return 0;
      case 2: 
        localanw.endTime = locala.UbS.zl();
        AppMethodBeat.o(122489);
        return 0;
      }
      localanw.LzC = locala.UbS.zi();
      AppMethodBeat.o(122489);
      return 0;
    }
    AppMethodBeat.o(122489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anw
 * JD-Core Version:    0.7.0.1
 */