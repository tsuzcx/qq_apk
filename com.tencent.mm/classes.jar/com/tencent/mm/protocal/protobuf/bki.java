package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bki
  extends com.tencent.mm.cd.a
{
  public String SVm;
  public long SVn;
  public int SVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SVm != null) {
        paramVarArgs.f(1, this.SVm);
      }
      paramVarArgs.bm(2, this.SVn);
      paramVarArgs.aY(3, this.SVo);
      AppMethodBeat.o(204709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SVm == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.SVm) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.SVn);
      int j = g.a.a.b.b.a.bM(3, this.SVo);
      AppMethodBeat.o(204709);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204709);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bki localbki = (bki)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(204709);
          return -1;
        case 1: 
          localbki.SVm = locala.abFh.readString();
          AppMethodBeat.o(204709);
          return 0;
        case 2: 
          localbki.SVn = locala.abFh.AN();
          AppMethodBeat.o(204709);
          return 0;
        }
        localbki.SVo = locala.abFh.AK();
        AppMethodBeat.o(204709);
        return 0;
      }
      AppMethodBeat.o(204709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bki
 * JD-Core Version:    0.7.0.1
 */