package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class awk
  extends com.tencent.mm.cd.a
{
  public long SJc;
  public b SJd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229614);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SJc);
      if (this.SJd != null) {
        paramVarArgs.c(2, this.SJd);
      }
      AppMethodBeat.o(229614);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SJc) + 0;
      paramInt = i;
      if (this.SJd != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SJd);
      }
      AppMethodBeat.o(229614);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229614);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      awk localawk = (awk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229614);
        return -1;
      case 1: 
        localawk.SJc = locala.abFh.AN();
        AppMethodBeat.o(229614);
        return 0;
      }
      localawk.SJd = locala.abFh.iUw();
      AppMethodBeat.o(229614);
      return 0;
    }
    AppMethodBeat.o(229614);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awk
 * JD-Core Version:    0.7.0.1
 */