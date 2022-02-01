package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crd
  extends com.tencent.mm.cd.a
{
  public String RQE;
  public String RQF;
  public String RQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQF != null) {
        paramVarArgs.f(1, this.RQF);
      }
      if (this.RQE != null) {
        paramVarArgs.f(2, this.RQE);
      }
      if (this.RQG != null) {
        paramVarArgs.f(3, this.RQG);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RQF == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.RQF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RQE);
      }
      i = paramInt;
      if (this.RQG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQG);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crd localcrd = (crd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localcrd.RQF = locala.abFh.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localcrd.RQE = locala.abFh.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localcrd.RQG = locala.abFh.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crd
 * JD-Core Version:    0.7.0.1
 */