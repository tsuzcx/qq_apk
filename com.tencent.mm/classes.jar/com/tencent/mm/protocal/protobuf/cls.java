package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cls
  extends com.tencent.mm.cd.a
{
  public long TtA;
  public long TtB;
  public boolean TtC;
  public long TtD;
  public long Ttv;
  public long Ttw;
  public long Ttx;
  public long Tty;
  public long Ttz;
  public long fmH;
  public int sessionType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Ttv);
      paramVarArgs.bm(2, this.Ttw);
      paramVarArgs.bm(3, this.Ttx);
      paramVarArgs.bm(4, this.Tty);
      paramVarArgs.bm(5, this.Ttz);
      paramVarArgs.aY(6, this.sessionType);
      paramVarArgs.bm(7, this.TtA);
      paramVarArgs.bm(8, this.fmH);
      paramVarArgs.bm(9, this.TtB);
      paramVarArgs.co(10, this.TtC);
      paramVarArgs.bm(11, this.TtD);
      AppMethodBeat.o(212732);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.Ttv);
      int i = g.a.a.b.b.a.p(2, this.Ttw);
      int j = g.a.a.b.b.a.p(3, this.Ttx);
      int k = g.a.a.b.b.a.p(4, this.Tty);
      int m = g.a.a.b.b.a.p(5, this.Ttz);
      int n = g.a.a.b.b.a.bM(6, this.sessionType);
      int i1 = g.a.a.b.b.a.p(7, this.TtA);
      int i2 = g.a.a.b.b.a.p(8, this.fmH);
      int i3 = g.a.a.b.b.a.p(9, this.TtB);
      int i4 = g.a.a.b.b.a.gL(10);
      int i5 = g.a.a.b.b.a.p(11, this.TtD);
      AppMethodBeat.o(212732);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(212732);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cls localcls = (cls)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212732);
        return -1;
      case 1: 
        localcls.Ttv = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 2: 
        localcls.Ttw = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 3: 
        localcls.Ttx = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 4: 
        localcls.Tty = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 5: 
        localcls.Ttz = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 6: 
        localcls.sessionType = locala.abFh.AK();
        AppMethodBeat.o(212732);
        return 0;
      case 7: 
        localcls.TtA = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 8: 
        localcls.fmH = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 9: 
        localcls.TtB = locala.abFh.AN();
        AppMethodBeat.o(212732);
        return 0;
      case 10: 
        localcls.TtC = locala.abFh.AB();
        AppMethodBeat.o(212732);
        return 0;
      }
      localcls.TtD = locala.abFh.AN();
      AppMethodBeat.o(212732);
      return 0;
    }
    AppMethodBeat.o(212732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cls
 * JD-Core Version:    0.7.0.1
 */