package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqe
  extends com.tencent.mm.cd.a
{
  public int TNG;
  public String UNV;
  public boolean UOa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNV != null) {
        paramVarArgs.f(1, this.UNV);
      }
      paramVarArgs.co(2, this.UOa);
      paramVarArgs.aY(3, this.TNG);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNV == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = g.a.a.b.b.a.g(1, this.UNV) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.TNG);
      AppMethodBeat.o(50127);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fqe localfqe = (fqe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localfqe.UNV = locala.abFh.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localfqe.UOa = locala.abFh.AB();
          AppMethodBeat.o(50127);
          return 0;
        }
        localfqe.TNG = locala.abFh.AK();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqe
 * JD-Core Version:    0.7.0.1
 */