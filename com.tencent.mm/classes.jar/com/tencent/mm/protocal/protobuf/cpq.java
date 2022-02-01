package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpq
  extends com.tencent.mm.cd.a
{
  public String TwV;
  public int TwW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32335);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TwV != null) {
        paramVarArgs.f(1, this.TwV);
      }
      paramVarArgs.aY(2, this.TwW);
      AppMethodBeat.o(32335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TwV == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.g(1, this.TwV) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TwW);
      AppMethodBeat.o(32335);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32335);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpq localcpq = (cpq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32335);
          return -1;
        case 1: 
          localcpq.TwV = locala.abFh.readString();
          AppMethodBeat.o(32335);
          return 0;
        }
        localcpq.TwW = locala.abFh.AK();
        AppMethodBeat.o(32335);
        return 0;
      }
      AppMethodBeat.o(32335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpq
 * JD-Core Version:    0.7.0.1
 */