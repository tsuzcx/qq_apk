package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cuw
  extends com.tencent.mm.cd.a
{
  public long aYz;
  public String path;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255148);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(255148);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.bm(2, this.start);
      paramVarArgs.bm(3, this.aYz);
      AppMethodBeat.o(255148);
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
      int i = g.a.a.b.b.a.p(2, this.start);
      int j = g.a.a.b.b.a.p(3, this.aYz);
      AppMethodBeat.o(255148);
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
          AppMethodBeat.o(255148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255148);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cuw localcuw = (cuw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255148);
          return -1;
        case 1: 
          localcuw.path = locala.abFh.readString();
          AppMethodBeat.o(255148);
          return 0;
        case 2: 
          localcuw.start = locala.abFh.AN();
          AppMethodBeat.o(255148);
          return 0;
        }
        localcuw.aYz = locala.abFh.AN();
        AppMethodBeat.o(255148);
        return 0;
      }
      AppMethodBeat.o(255148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuw
 * JD-Core Version:    0.7.0.1
 */