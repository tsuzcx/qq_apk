package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eus
  extends com.tencent.mm.cd.a
{
  public long IcQ;
  public long duration;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255123);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(255123);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.bm(2, this.IcQ);
      paramVarArgs.bm(3, this.duration);
      AppMethodBeat.o(255123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.b.b.a.g(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.IcQ);
      int j = g.a.a.b.b.a.p(3, this.duration);
      AppMethodBeat.o(255123);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(255123);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255123);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eus localeus = (eus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255123);
          return -1;
        case 1: 
          localeus.path = locala.abFh.readString();
          AppMethodBeat.o(255123);
          return 0;
        case 2: 
          localeus.IcQ = locala.abFh.AN();
          AppMethodBeat.o(255123);
          return 0;
        }
        localeus.duration = locala.abFh.AN();
        AppMethodBeat.o(255123);
        return 0;
      }
      AppMethodBeat.o(255123);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eus
 * JD-Core Version:    0.7.0.1
 */