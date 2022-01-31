package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class beh
  extends com.tencent.mm.bv.a
{
  public long xtV;
  public long xtW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140667);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xtV);
      paramVarArgs.am(2, this.xtW);
      AppMethodBeat.o(140667);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.xtV);
      int i = e.a.a.b.b.a.p(2, this.xtW);
      AppMethodBeat.o(140667);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(140667);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      beh localbeh = (beh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(140667);
        return -1;
      case 1: 
        localbeh.xtV = locala.CLY.sm();
        AppMethodBeat.o(140667);
        return 0;
      }
      localbeh.xtW = locala.CLY.sm();
      AppMethodBeat.o(140667);
      return 0;
    }
    AppMethodBeat.o(140667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beh
 * JD-Core Version:    0.7.0.1
 */