package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bv.a
{
  public int pIE;
  public long pIG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(67927);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pIE);
      paramVarArgs.am(2, this.pIG);
      AppMethodBeat.o(67927);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.pIE);
      int i = e.a.a.b.b.a.p(2, this.pIG);
      AppMethodBeat.o(67927);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(67927);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(67927);
        return -1;
      case 1: 
        localh.pIE = locala.CLY.sl();
        AppMethodBeat.o(67927);
        return 0;
      }
      localh.pIG = locala.CLY.sm();
      AppMethodBeat.o(67927);
      return 0;
    }
    AppMethodBeat.o(67927);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.h
 * JD-Core Version:    0.7.0.1
 */