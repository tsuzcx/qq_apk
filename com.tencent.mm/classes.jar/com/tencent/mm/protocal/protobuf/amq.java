package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amq
  extends com.tencent.mm.bv.a
{
  public String xdo;
  public String xdp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94530);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xdo != null) {
        paramVarArgs.e(1, this.xdo);
      }
      if (this.xdp != null) {
        paramVarArgs.e(2, this.xdp);
      }
      AppMethodBeat.o(94530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xdo == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.xdo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xdp != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xdp);
      }
      AppMethodBeat.o(94530);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94530);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        amq localamq = (amq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94530);
          return -1;
        case 1: 
          localamq.xdo = locala.CLY.readString();
          AppMethodBeat.o(94530);
          return 0;
        }
        localamq.xdp = locala.CLY.readString();
        AppMethodBeat.o(94530);
        return 0;
      }
      AppMethodBeat.o(94530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */