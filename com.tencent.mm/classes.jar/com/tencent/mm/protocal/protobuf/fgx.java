package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgx
  extends com.tencent.mm.cd.a
{
  public String UHc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32509);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UHc != null) {
        paramVarArgs.f(1, this.UHc);
      }
      AppMethodBeat.o(32509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UHc == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = g.a.a.b.b.a.g(1, this.UHc) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32509);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fgx localfgx = (fgx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32509);
          return -1;
        }
        localfgx.UHc = locala.abFh.readString();
        AppMethodBeat.o(32509);
        return 0;
      }
      AppMethodBeat.o(32509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgx
 * JD-Core Version:    0.7.0.1
 */