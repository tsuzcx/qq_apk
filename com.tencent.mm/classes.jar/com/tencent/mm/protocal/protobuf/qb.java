package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qb
  extends com.tencent.mm.cd.a
{
  public String RYs;
  public String RYt;
  public String RYu;
  public long RYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205377);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYs != null) {
        paramVarArgs.f(1, this.RYs);
      }
      if (this.RYt != null) {
        paramVarArgs.f(2, this.RYt);
      }
      if (this.RYu != null) {
        paramVarArgs.f(3, this.RYu);
      }
      paramVarArgs.bm(4, this.RYv);
      AppMethodBeat.o(205377);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYs == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.RYs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RYt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RYt);
      }
      i = paramInt;
      if (this.RYu != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RYu);
      }
      paramInt = g.a.a.b.b.a.p(4, this.RYv);
      AppMethodBeat.o(205377);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205377);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qb localqb = (qb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205377);
          return -1;
        case 1: 
          localqb.RYs = locala.abFh.readString();
          AppMethodBeat.o(205377);
          return 0;
        case 2: 
          localqb.RYt = locala.abFh.readString();
          AppMethodBeat.o(205377);
          return 0;
        case 3: 
          localqb.RYu = locala.abFh.readString();
          AppMethodBeat.o(205377);
          return 0;
        }
        localqb.RYv = locala.abFh.AN();
        AppMethodBeat.o(205377);
        return 0;
      }
      AppMethodBeat.o(205377);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qb
 * JD-Core Version:    0.7.0.1
 */