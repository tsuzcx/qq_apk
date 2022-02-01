package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hk
  extends com.tencent.mm.cd.a
{
  public String RMD;
  public String RME;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RMD != null) {
        paramVarArgs.f(1, this.RMD);
      }
      if (this.RME != null) {
        paramVarArgs.f(2, this.RME);
      }
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RMD == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.RMD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RME != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RME);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fvP);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hk localhk = (hk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localhk.RMD = locala.abFh.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localhk.RME = locala.abFh.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localhk.fvP = locala.abFh.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */