package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bxq
  extends com.tencent.mm.bv.a
{
  public long xCj;
  public String xHR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124350);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xHR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(124350);
        throw paramVarArgs;
      }
      if (this.xHR != null) {
        paramVarArgs.e(1, this.xHR);
      }
      paramVarArgs.am(2, this.xCj);
      AppMethodBeat.o(124350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xHR == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.xHR) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xCj);
      AppMethodBeat.o(124350);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xHR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(124350);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124350);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bxq localbxq = (bxq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124350);
          return -1;
        case 1: 
          localbxq.xHR = locala.CLY.readString();
          AppMethodBeat.o(124350);
          return 0;
        }
        localbxq.xCj = locala.CLY.sm();
        AppMethodBeat.o(124350);
        return 0;
      }
      AppMethodBeat.o(124350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxq
 * JD-Core Version:    0.7.0.1
 */