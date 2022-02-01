package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abs
  extends com.tencent.mm.cd.a
{
  public String EAI;
  public String SnD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32168);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SnD != null) {
        paramVarArgs.f(1, this.SnD);
      }
      if (this.EAI != null) {
        paramVarArgs.f(2, this.EAI);
      }
      AppMethodBeat.o(32168);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SnD == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.g(1, this.SnD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EAI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.EAI);
      }
      AppMethodBeat.o(32168);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32168);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        abs localabs = (abs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32168);
          return -1;
        case 1: 
          localabs.SnD = locala.abFh.readString();
          AppMethodBeat.o(32168);
          return 0;
        }
        localabs.EAI = locala.abFh.readString();
        AppMethodBeat.o(32168);
        return 0;
      }
      AppMethodBeat.o(32168);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abs
 * JD-Core Version:    0.7.0.1
 */