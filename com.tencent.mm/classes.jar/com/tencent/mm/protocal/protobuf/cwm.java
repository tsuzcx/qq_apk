package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cwm
  extends com.tencent.mm.bv.a
{
  public b jJh;
  public long yeA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28717);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.yeA);
      if (this.jJh != null) {
        paramVarArgs.c(2, this.jJh);
      }
      AppMethodBeat.o(28717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.yeA) + 0;
      paramInt = i;
      if (this.jJh != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.jJh);
      }
      AppMethodBeat.o(28717);
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
      AppMethodBeat.o(28717);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cwm localcwm = (cwm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28717);
        return -1;
      case 1: 
        localcwm.yeA = locala.CLY.sm();
        AppMethodBeat.o(28717);
        return 0;
      }
      localcwm.jJh = locala.CLY.eqS();
      AppMethodBeat.o(28717);
      return 0;
    }
    AppMethodBeat.o(28717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwm
 * JD-Core Version:    0.7.0.1
 */