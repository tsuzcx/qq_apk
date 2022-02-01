package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqc
  extends com.tencent.mm.bw.a
{
  public long MvU;
  public long MvV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MvU);
      paramVarArgs.bb(2, this.MvV);
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.MvU);
      int i = g.a.a.b.b.a.r(2, this.MvV);
      AppMethodBeat.o(134247);
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
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cqc localcqc = (cqc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134247);
        return -1;
      case 1: 
        localcqc.MvU = locala.UbS.zl();
        AppMethodBeat.o(134247);
        return 0;
      }
      localcqc.MvV = locala.UbS.zl();
      AppMethodBeat.o(134247);
      return 0;
    }
    AppMethodBeat.o(134247);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */