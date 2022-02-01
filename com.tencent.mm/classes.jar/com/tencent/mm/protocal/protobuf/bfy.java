package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfy
  extends com.tencent.mm.cd.a
{
  public String SQD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SQD != null) {
        paramVarArgs.f(1, this.SQD);
      }
      AppMethodBeat.o(197495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SQD == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.SQD) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(197495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197495);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfy localbfy = (bfy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197495);
          return -1;
        }
        localbfy.SQD = locala.abFh.readString();
        AppMethodBeat.o(197495);
        return 0;
      }
      AppMethodBeat.o(197495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfy
 * JD-Core Version:    0.7.0.1
 */