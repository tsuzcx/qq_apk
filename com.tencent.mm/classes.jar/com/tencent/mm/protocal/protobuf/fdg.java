package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fdg
  extends com.tencent.mm.cd.a
{
  public String TVX;
  public int TVY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TVX == null)
      {
        paramVarArgs = new b("Not all required fields were included: Ip");
        AppMethodBeat.o(125493);
        throw paramVarArgs;
      }
      if (this.TVX != null) {
        paramVarArgs.f(1, this.TVX);
      }
      paramVarArgs.aY(2, this.TVY);
      AppMethodBeat.o(125493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TVX == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.TVX) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TVY);
      AppMethodBeat.o(125493);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TVX == null)
        {
          paramVarArgs = new b("Not all required fields were included: Ip");
          AppMethodBeat.o(125493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125493);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fdg localfdg = (fdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125493);
          return -1;
        case 1: 
          localfdg.TVX = locala.abFh.readString();
          AppMethodBeat.o(125493);
          return 0;
        }
        localfdg.TVY = locala.abFh.AK();
        AppMethodBeat.o(125493);
        return 0;
      }
      AppMethodBeat.o(125493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdg
 * JD-Core Version:    0.7.0.1
 */