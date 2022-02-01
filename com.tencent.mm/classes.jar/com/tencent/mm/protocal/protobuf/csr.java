package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csr
  extends com.tencent.mm.cd.a
{
  public String TAu;
  public int end;
  public int start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240198);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TAu != null) {
        paramVarArgs.f(1, this.TAu);
      }
      paramVarArgs.aY(2, this.start);
      paramVarArgs.aY(3, this.end);
      AppMethodBeat.o(240198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TAu == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.TAu) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.start);
      int j = g.a.a.b.b.a.bM(3, this.end);
      AppMethodBeat.o(240198);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(240198);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        csr localcsr = (csr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(240198);
          return -1;
        case 1: 
          localcsr.TAu = locala.abFh.readString();
          AppMethodBeat.o(240198);
          return 0;
        case 2: 
          localcsr.start = locala.abFh.AK();
          AppMethodBeat.o(240198);
          return 0;
        }
        localcsr.end = locala.abFh.AK();
        AppMethodBeat.o(240198);
        return 0;
      }
      AppMethodBeat.o(240198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csr
 * JD-Core Version:    0.7.0.1
 */