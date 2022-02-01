package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cue
  extends com.tencent.mm.cd.a
{
  public String RUq;
  public boolean TBT;
  public int TBU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197284);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUq != null) {
        paramVarArgs.f(1, this.RUq);
      }
      paramVarArgs.co(2, this.TBT);
      paramVarArgs.aY(3, this.TBU);
      AppMethodBeat.o(197284);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUq == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = g.a.a.b.b.a.g(1, this.RUq) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.TBU);
      AppMethodBeat.o(197284);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197284);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cue localcue = (cue)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197284);
          return -1;
        case 1: 
          localcue.RUq = locala.abFh.readString();
          AppMethodBeat.o(197284);
          return 0;
        case 2: 
          localcue.TBT = locala.abFh.AB();
          AppMethodBeat.o(197284);
          return 0;
        }
        localcue.TBU = locala.abFh.AK();
        AppMethodBeat.o(197284);
        return 0;
      }
      AppMethodBeat.o(197284);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cue
 * JD-Core Version:    0.7.0.1
 */