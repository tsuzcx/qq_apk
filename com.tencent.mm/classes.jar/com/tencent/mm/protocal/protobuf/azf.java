package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class azf
  extends com.tencent.mm.cd.a
{
  public b SLc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SLc != null) {
        paramVarArgs.c(1, this.SLc);
      }
      AppMethodBeat.o(197252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SLc == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.b(1, this.SLc) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(197252);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197252);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        azf localazf = (azf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197252);
          return -1;
        }
        localazf.SLc = locala.abFh.iUw();
        AppMethodBeat.o(197252);
        return 0;
      }
      AppMethodBeat.o(197252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azf
 * JD-Core Version:    0.7.0.1
 */