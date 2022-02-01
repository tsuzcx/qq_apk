package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ld
  extends com.tencent.mm.cd.a
{
  public int KlE;
  public long RQc = 0L;
  public long RQd = 0L;
  public long RQe = 0L;
  public long RQf = 0L;
  public int RQg;
  public int fHa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RQc);
      paramVarArgs.bm(2, this.RQd);
      paramVarArgs.bm(3, this.RQe);
      paramVarArgs.bm(4, this.RQf);
      paramVarArgs.aY(5, this.KlE);
      paramVarArgs.aY(6, this.fHa);
      paramVarArgs.aY(7, this.RQg);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.RQc);
      int i = g.a.a.b.b.a.p(2, this.RQd);
      int j = g.a.a.b.b.a.p(3, this.RQe);
      int k = g.a.a.b.b.a.p(4, this.RQf);
      int m = g.a.a.b.b.a.bM(5, this.KlE);
      int n = g.a.a.b.b.a.bM(6, this.fHa);
      int i1 = g.a.a.b.b.a.bM(7, this.RQg);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ld localld = (ld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localld.RQc = locala.abFh.AN();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localld.RQd = locala.abFh.AN();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localld.RQe = locala.abFh.AN();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localld.RQf = locala.abFh.AN();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localld.KlE = locala.abFh.AK();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localld.fHa = locala.abFh.AK();
        AppMethodBeat.o(110886);
        return 0;
      }
      localld.RQg = locala.abFh.AK();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ld
 * JD-Core Version:    0.7.0.1
 */