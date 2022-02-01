package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hp
  extends com.tencent.mm.bx.a
{
  public long FAb;
  public double FAc;
  public int FAd;
  public long FAf;
  public int FAg;
  public String FzS;
  public String FzT;
  public int FzU;
  public long FzV;
  public int FzW;
  public long FzX;
  public long FzY;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FAf);
      if (this.FzS != null) {
        paramVarArgs.d(2, this.FzS);
      }
      if (this.FzT != null) {
        paramVarArgs.d(3, this.FzT);
      }
      paramVarArgs.aS(4, this.FzU);
      paramVarArgs.aY(5, this.FzV);
      paramVarArgs.aS(6, this.FzW);
      paramVarArgs.aS(7, this.nDG);
      paramVarArgs.aY(8, this.FzX);
      paramVarArgs.aY(9, this.FzY);
      paramVarArgs.aS(10, this.FAg);
      paramVarArgs.aY(11, this.FAb);
      paramVarArgs.e(12, this.FAc);
      paramVarArgs.aS(13, this.FAd);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FAf) + 0;
      paramInt = i;
      if (this.FzS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FzS);
      }
      i = paramInt;
      if (this.FzT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FzT);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FzU);
      int j = f.a.a.b.b.a.p(5, this.FzV);
      int k = f.a.a.b.b.a.bz(6, this.FzW);
      int m = f.a.a.b.b.a.bz(7, this.nDG);
      int n = f.a.a.b.b.a.p(8, this.FzX);
      int i1 = f.a.a.b.b.a.p(9, this.FzY);
      int i2 = f.a.a.b.b.a.bz(10, this.FAg);
      int i3 = f.a.a.b.b.a.p(11, this.FAb);
      int i4 = f.a.a.b.b.a.alT(12);
      int i5 = f.a.a.b.b.a.bz(13, this.FAd);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hp localhp = (hp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localhp.FAf = locala.NPN.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localhp.FzS = locala.NPN.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localhp.FzT = locala.NPN.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localhp.FzU = locala.NPN.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localhp.FzV = locala.NPN.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localhp.FzW = locala.NPN.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localhp.nDG = locala.NPN.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localhp.FzX = locala.NPN.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localhp.FzY = locala.NPN.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localhp.FAg = locala.NPN.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localhp.FAb = locala.NPN.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localhp.FAc = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(87873);
        return 0;
      }
      localhp.FAd = locala.NPN.zc();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hp
 * JD-Core Version:    0.7.0.1
 */