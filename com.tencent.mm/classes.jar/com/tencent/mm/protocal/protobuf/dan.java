package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dan
  extends com.tencent.mm.cd.a
{
  public long THM;
  public long THN;
  public long THO;
  public long THP;
  public long duration;
  public boolean xpx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(12, this.THM);
      paramVarArgs.bm(1, this.THN);
      paramVarArgs.bm(2, this.THO);
      paramVarArgs.bm(3, this.duration);
      paramVarArgs.bm(4, this.THP);
      paramVarArgs.co(5, this.xpx);
      AppMethodBeat.o(205504);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(12, this.THM);
      int i = g.a.a.b.b.a.p(1, this.THN);
      int j = g.a.a.b.b.a.p(2, this.THO);
      int k = g.a.a.b.b.a.p(3, this.duration);
      int m = g.a.a.b.b.a.p(4, this.THP);
      int n = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(205504);
      return paramInt + 0 + i + j + k + m + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205504);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dan localdan = (dan)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        AppMethodBeat.o(205504);
        return -1;
      case 12: 
        localdan.THM = locala.abFh.AN();
        AppMethodBeat.o(205504);
        return 0;
      case 1: 
        localdan.THN = locala.abFh.AN();
        AppMethodBeat.o(205504);
        return 0;
      case 2: 
        localdan.THO = locala.abFh.AN();
        AppMethodBeat.o(205504);
        return 0;
      case 3: 
        localdan.duration = locala.abFh.AN();
        AppMethodBeat.o(205504);
        return 0;
      case 4: 
        localdan.THP = locala.abFh.AN();
        AppMethodBeat.o(205504);
        return 0;
      }
      localdan.xpx = locala.abFh.AB();
      AppMethodBeat.o(205504);
      return 0;
    }
    AppMethodBeat.o(205504);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dan
 * JD-Core Version:    0.7.0.1
 */