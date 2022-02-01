package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.cd.a
{
  public int HlE;
  public String HlF;
  public int HlG;
  public long HlH;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HlE);
      if (this.HlF != null) {
        paramVarArgs.f(2, this.HlF);
      }
      paramVarArgs.aY(3, this.rVU);
      paramVarArgs.aY(4, this.HlG);
      paramVarArgs.bm(5, this.HlH);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.HlE) + 0;
      paramInt = i;
      if (this.HlF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.HlF);
      }
      i = g.a.a.b.b.a.bM(3, this.rVU);
      int j = g.a.a.b.b.a.bM(4, this.HlG);
      int k = g.a.a.b.b.a.p(5, this.HlH);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        localf.HlE = locala.abFh.AK();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localf.HlF = locala.abFh.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localf.rVU = locala.abFh.AK();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localf.HlG = locala.abFh.AK();
        AppMethodBeat.o(122660);
        return 0;
      }
      localf.HlH = locala.abFh.AN();
      AppMethodBeat.o(122660);
      return 0;
    }
    AppMethodBeat.o(122660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.f
 * JD-Core Version:    0.7.0.1
 */