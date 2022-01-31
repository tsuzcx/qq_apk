package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bv.a
{
  public int FileSize;
  public int jJS;
  public int pIE;
  public String pIF;
  public long pIG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(67926);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pIE);
      if (this.pIF != null) {
        paramVarArgs.e(2, this.pIF);
      }
      paramVarArgs.aO(3, this.jJS);
      paramVarArgs.aO(4, this.FileSize);
      paramVarArgs.am(5, this.pIG);
      AppMethodBeat.o(67926);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.pIE) + 0;
      paramInt = i;
      if (this.pIF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pIF);
      }
      i = e.a.a.b.b.a.bl(3, this.jJS);
      int j = e.a.a.b.b.a.bl(4, this.FileSize);
      int k = e.a.a.b.b.a.p(5, this.pIG);
      AppMethodBeat.o(67926);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(67926);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(67926);
        return -1;
      case 1: 
        localg.pIE = locala.CLY.sl();
        AppMethodBeat.o(67926);
        return 0;
      case 2: 
        localg.pIF = locala.CLY.readString();
        AppMethodBeat.o(67926);
        return 0;
      case 3: 
        localg.jJS = locala.CLY.sl();
        AppMethodBeat.o(67926);
        return 0;
      case 4: 
        localg.FileSize = locala.CLY.sl();
        AppMethodBeat.o(67926);
        return 0;
      }
      localg.pIG = locala.CLY.sm();
      AppMethodBeat.o(67926);
      return 0;
    }
    AppMethodBeat.o(67926);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.g
 * JD-Core Version:    0.7.0.1
 */