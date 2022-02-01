package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ez
  extends com.tencent.mm.cd.a
{
  public String RJN;
  public String RJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJN != null) {
        paramVarArgs.f(1, this.RJN);
      }
      if (this.RJO != null) {
        paramVarArgs.f(2, this.RJO);
      }
      AppMethodBeat.o(125711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJN == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RJN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJO != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RJO);
      }
      AppMethodBeat.o(125711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125711);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125711);
          return -1;
        case 1: 
          localez.RJN = locala.abFh.readString();
          AppMethodBeat.o(125711);
          return 0;
        }
        localez.RJO = locala.abFh.readString();
        AppMethodBeat.o(125711);
        return 0;
      }
      AppMethodBeat.o(125711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */