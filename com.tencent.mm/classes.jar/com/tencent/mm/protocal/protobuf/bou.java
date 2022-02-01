package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bou
  extends com.tencent.mm.cd.a
{
  public String TaD;
  public long TaE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TaD != null) {
        paramVarArgs.f(1, this.TaD);
      }
      paramVarArgs.bm(2, this.TaE);
      AppMethodBeat.o(152555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TaD == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.TaD) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.TaE);
      AppMethodBeat.o(152555);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152555);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bou localbou = (bou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152555);
          return -1;
        case 1: 
          localbou.TaD = locala.abFh.readString();
          AppMethodBeat.o(152555);
          return 0;
        }
        localbou.TaE = locala.abFh.AN();
        AppMethodBeat.o(152555);
        return 0;
      }
      AppMethodBeat.o(152555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bou
 * JD-Core Version:    0.7.0.1
 */