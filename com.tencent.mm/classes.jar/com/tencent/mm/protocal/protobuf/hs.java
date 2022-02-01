package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hs
  extends com.tencent.mm.cd.a
{
  public String RMW;
  public String RMX;
  public int RMY;
  public long RMZ;
  public int RNa;
  public long RNb;
  public long RNc;
  public long RNf;
  public double RNg;
  public int RNh;
  public long RNj;
  public int RNk;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RNj);
      if (this.RMW != null) {
        paramVarArgs.f(2, this.RMW);
      }
      if (this.RMX != null) {
        paramVarArgs.f(3, this.RMX);
      }
      paramVarArgs.aY(4, this.RMY);
      paramVarArgs.bm(5, this.RMZ);
      paramVarArgs.aY(6, this.RNa);
      paramVarArgs.aY(7, this.rVU);
      paramVarArgs.bm(8, this.RNb);
      paramVarArgs.bm(9, this.RNc);
      paramVarArgs.aY(10, this.RNk);
      paramVarArgs.bm(11, this.RNf);
      paramVarArgs.e(12, this.RNg);
      paramVarArgs.aY(13, this.RNh);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.RNj) + 0;
      paramInt = i;
      if (this.RMW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RMW);
      }
      i = paramInt;
      if (this.RMX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMX);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.RMY);
      int j = g.a.a.b.b.a.p(5, this.RMZ);
      int k = g.a.a.b.b.a.bM(6, this.RNa);
      int m = g.a.a.b.b.a.bM(7, this.rVU);
      int n = g.a.a.b.b.a.p(8, this.RNb);
      int i1 = g.a.a.b.b.a.p(9, this.RNc);
      int i2 = g.a.a.b.b.a.bM(10, this.RNk);
      int i3 = g.a.a.b.b.a.p(11, this.RNf);
      int i4 = g.a.a.b.b.a.gL(12);
      int i5 = g.a.a.b.b.a.bM(13, this.RNh);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      hs localhs = (hs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localhs.RNj = locala.abFh.AN();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localhs.RMW = locala.abFh.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localhs.RMX = locala.abFh.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localhs.RMY = locala.abFh.AK();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localhs.RMZ = locala.abFh.AN();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localhs.RNa = locala.abFh.AK();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localhs.rVU = locala.abFh.AK();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localhs.RNb = locala.abFh.AN();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localhs.RNc = locala.abFh.AN();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localhs.RNk = locala.abFh.AK();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localhs.RNf = locala.abFh.AN();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localhs.RNg = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(87873);
        return 0;
      }
      localhs.RNh = locala.abFh.AK();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hs
 * JD-Core Version:    0.7.0.1
 */