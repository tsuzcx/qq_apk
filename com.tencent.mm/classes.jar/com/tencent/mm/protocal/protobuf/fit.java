package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fit
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public String tsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203234);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tsk != null) {
        paramVarArgs.f(1, this.tsk);
      }
      paramVarArgs.aY(2, this.RYL);
      AppMethodBeat.o(203234);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tsk == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.tsk) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RYL);
      AppMethodBeat.o(203234);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203234);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fit localfit = (fit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203234);
          return -1;
        case 1: 
          localfit.tsk = locala.abFh.readString();
          AppMethodBeat.o(203234);
          return 0;
        }
        localfit.RYL = locala.abFh.AK();
        AppMethodBeat.o(203234);
        return 0;
      }
      AppMethodBeat.o(203234);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fit
 * JD-Core Version:    0.7.0.1
 */