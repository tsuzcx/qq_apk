package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezy
  extends com.tencent.mm.cd.a
{
  public String Tug;
  public int UAb;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82486);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tug != null) {
        paramVarArgs.f(1, this.Tug);
      }
      paramVarArgs.aY(2, this.state);
      paramVarArgs.aY(3, this.UAb);
      AppMethodBeat.o(82486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tug == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.Tug) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.state);
      int j = g.a.a.b.b.a.bM(3, this.UAb);
      AppMethodBeat.o(82486);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82486);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezy localezy = (ezy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82486);
          return -1;
        case 1: 
          localezy.Tug = locala.abFh.readString();
          AppMethodBeat.o(82486);
          return 0;
        case 2: 
          localezy.state = locala.abFh.AK();
          AppMethodBeat.o(82486);
          return 0;
        }
        localezy.UAb = locala.abFh.AK();
        AppMethodBeat.o(82486);
        return 0;
      }
      AppMethodBeat.o(82486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezy
 * JD-Core Version:    0.7.0.1
 */