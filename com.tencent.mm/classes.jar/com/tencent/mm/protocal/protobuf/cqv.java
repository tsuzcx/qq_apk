package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqv
  extends com.tencent.mm.bv.a
{
  public int cxa;
  public String cxb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14759);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cxb != null) {
        paramVarArgs.e(1, this.cxb);
      }
      paramVarArgs.aO(2, this.cxa);
      AppMethodBeat.o(14759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cxb == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = e.a.a.b.b.a.f(1, this.cxb) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.cxa);
      AppMethodBeat.o(14759);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14759);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cqv localcqv = (cqv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14759);
          return -1;
        case 1: 
          localcqv.cxb = locala.CLY.readString();
          AppMethodBeat.o(14759);
          return 0;
        }
        localcqv.cxa = locala.CLY.sl();
        AppMethodBeat.o(14759);
        return 0;
      }
      AppMethodBeat.o(14759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqv
 * JD-Core Version:    0.7.0.1
 */