package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezq
  extends com.tencent.mm.cd.a
{
  public int KyZ;
  public int UzT;
  public long UzU;
  public long UzV;
  public long UzW;
  public long UzX;
  public long UzY;
  public int UzZ;
  public long lzJ;
  public long wmw;
  public long zXq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UzT);
      paramVarArgs.aY(2, this.KyZ);
      paramVarArgs.bm(3, this.wmw);
      paramVarArgs.bm(4, this.UzU);
      paramVarArgs.bm(5, this.UzV);
      paramVarArgs.bm(6, this.UzW);
      paramVarArgs.bm(7, this.lzJ);
      paramVarArgs.bm(8, this.UzX);
      paramVarArgs.bm(9, this.zXq);
      paramVarArgs.bm(10, this.UzY);
      paramVarArgs.aY(11, this.UzZ);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UzT);
      int i = g.a.a.b.b.a.bM(2, this.KyZ);
      int j = g.a.a.b.b.a.p(3, this.wmw);
      int k = g.a.a.b.b.a.p(4, this.UzU);
      int m = g.a.a.b.b.a.p(5, this.UzV);
      int n = g.a.a.b.b.a.p(6, this.UzW);
      int i1 = g.a.a.b.b.a.p(7, this.lzJ);
      int i2 = g.a.a.b.b.a.p(8, this.UzX);
      int i3 = g.a.a.b.b.a.p(9, this.zXq);
      int i4 = g.a.a.b.b.a.p(10, this.UzY);
      int i5 = g.a.a.b.b.a.bM(11, this.UzZ);
      AppMethodBeat.o(169092);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezq localezq = (ezq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localezq.UzT = locala.abFh.AK();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localezq.KyZ = locala.abFh.AK();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localezq.wmw = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localezq.UzU = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 5: 
        localezq.UzV = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 6: 
        localezq.UzW = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 7: 
        localezq.lzJ = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 8: 
        localezq.UzX = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 9: 
        localezq.zXq = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      case 10: 
        localezq.UzY = locala.abFh.AN();
        AppMethodBeat.o(169092);
        return 0;
      }
      localezq.UzZ = locala.abFh.AK();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezq
 * JD-Core Version:    0.7.0.1
 */