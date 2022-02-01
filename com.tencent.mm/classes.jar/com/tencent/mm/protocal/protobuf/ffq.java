package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ffq
  extends com.tencent.mm.cd.a
{
  public String Tsy;
  public b UGc;
  public String method;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246032);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.method != null) {
        paramVarArgs.f(1, this.method);
      }
      if (this.Tsy != null) {
        paramVarArgs.f(2, this.Tsy);
      }
      if (this.UGc != null) {
        paramVarArgs.c(3, this.UGc);
      }
      AppMethodBeat.o(246032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.method == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.method) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tsy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tsy);
      }
      i = paramInt;
      if (this.UGc != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UGc);
      }
      AppMethodBeat.o(246032);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(246032);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ffq localffq = (ffq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(246032);
          return -1;
        case 1: 
          localffq.method = locala.abFh.readString();
          AppMethodBeat.o(246032);
          return 0;
        case 2: 
          localffq.Tsy = locala.abFh.readString();
          AppMethodBeat.o(246032);
          return 0;
        }
        localffq.UGc = locala.abFh.iUw();
        AppMethodBeat.o(246032);
        return 0;
      }
      AppMethodBeat.o(246032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffq
 * JD-Core Version:    0.7.0.1
 */