package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apq
  extends com.tencent.mm.bw.a
{
  public String dMj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209356);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dMj != null) {
        paramVarArgs.e(1, this.dMj);
      }
      AppMethodBeat.o(209356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dMj == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.dMj) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209356);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        apq localapq = (apq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209356);
          return -1;
        }
        localapq.dMj = locala.UbS.readString();
        AppMethodBeat.o(209356);
        return 0;
      }
      AppMethodBeat.o(209356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apq
 * JD-Core Version:    0.7.0.1
 */