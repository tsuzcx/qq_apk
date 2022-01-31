package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctu
  extends com.tencent.mm.bv.a
{
  public String xly;
  public long ycJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102399);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.ycJ);
      if (this.xly != null) {
        paramVarArgs.e(2, this.xly);
      }
      AppMethodBeat.o(102399);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.ycJ) + 0;
      paramInt = i;
      if (this.xly != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xly);
      }
      AppMethodBeat.o(102399);
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
      AppMethodBeat.o(102399);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ctu localctu = (ctu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102399);
        return -1;
      case 1: 
        localctu.ycJ = locala.CLY.sm();
        AppMethodBeat.o(102399);
        return 0;
      }
      localctu.xly = locala.CLY.readString();
      AppMethodBeat.o(102399);
      return 0;
    }
    AppMethodBeat.o(102399);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctu
 * JD-Core Version:    0.7.0.1
 */