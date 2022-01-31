package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pc
  extends com.tencent.mm.bv.a
{
  public int wFN;
  public String wFO;
  public int wvk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152205);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wFN);
      paramVarArgs.aO(2, this.wvk);
      if (this.wFO != null) {
        paramVarArgs.e(3, this.wFO);
      }
      AppMethodBeat.o(152205);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wFN) + 0 + e.a.a.b.b.a.bl(2, this.wvk);
      paramInt = i;
      if (this.wFO != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wFO);
      }
      AppMethodBeat.o(152205);
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
      AppMethodBeat.o(152205);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      pc localpc = (pc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152205);
        return -1;
      case 1: 
        localpc.wFN = locala.CLY.sl();
        AppMethodBeat.o(152205);
        return 0;
      case 2: 
        localpc.wvk = locala.CLY.sl();
        AppMethodBeat.o(152205);
        return 0;
      }
      localpc.wFO = locala.CLY.readString();
      AppMethodBeat.o(152205);
      return 0;
    }
    AppMethodBeat.o(152205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pc
 * JD-Core Version:    0.7.0.1
 */