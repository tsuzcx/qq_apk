package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehs
  extends com.tencent.mm.cd.a
{
  public String UjL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114078);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UjL != null) {
        paramVarArgs.f(1, this.UjL);
      }
      AppMethodBeat.o(114078);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UjL == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.UjL) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(114078);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114078);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehs localehs = (ehs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114078);
          return -1;
        }
        localehs.UjL = locala.abFh.readString();
        AppMethodBeat.o(114078);
        return 0;
      }
      AppMethodBeat.o(114078);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehs
 * JD-Core Version:    0.7.0.1
 */