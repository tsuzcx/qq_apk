package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chn
  extends com.tencent.mm.bv.a
{
  public String nul;
  public int xNY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56529);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xNY);
      if (this.nul != null) {
        paramVarArgs.e(2, this.nul);
      }
      AppMethodBeat.o(56529);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xNY) + 0;
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nul);
      }
      AppMethodBeat.o(56529);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56529);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      chn localchn = (chn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56529);
        return -1;
      case 1: 
        localchn.xNY = locala.CLY.sl();
        AppMethodBeat.o(56529);
        return 0;
      }
      localchn.nul = locala.CLY.readString();
      AppMethodBeat.o(56529);
      return 0;
    }
    AppMethodBeat.o(56529);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chn
 * JD-Core Version:    0.7.0.1
 */