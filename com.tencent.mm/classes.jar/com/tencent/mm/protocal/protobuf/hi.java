package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hi
  extends com.tencent.mm.bw.a
{
  public long DUA;
  public int DUB;
  public long DUC;
  public long DUD;
  public long DUG;
  public double DUH;
  public int DUI;
  public long DUK;
  public int DUL;
  public String DUy;
  public int DUz;
  public int ndj;
  public String vTL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DUK);
      if (this.vTL != null) {
        paramVarArgs.d(2, this.vTL);
      }
      if (this.DUy != null) {
        paramVarArgs.d(3, this.DUy);
      }
      paramVarArgs.aR(4, this.DUz);
      paramVarArgs.aO(5, this.DUA);
      paramVarArgs.aR(6, this.DUB);
      paramVarArgs.aR(7, this.ndj);
      paramVarArgs.aO(8, this.DUC);
      paramVarArgs.aO(9, this.DUD);
      paramVarArgs.aR(10, this.DUL);
      paramVarArgs.aO(11, this.DUG);
      paramVarArgs.e(12, this.DUH);
      paramVarArgs.aR(13, this.DUI);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DUK) + 0;
      paramInt = i;
      if (this.vTL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vTL);
      }
      i = paramInt;
      if (this.DUy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUy);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.DUz);
      int j = f.a.a.b.b.a.p(5, this.DUA);
      int k = f.a.a.b.b.a.bx(6, this.DUB);
      int m = f.a.a.b.b.a.bx(7, this.ndj);
      int n = f.a.a.b.b.a.p(8, this.DUC);
      int i1 = f.a.a.b.b.a.p(9, this.DUD);
      int i2 = f.a.a.b.b.a.bx(10, this.DUL);
      int i3 = f.a.a.b.b.a.p(11, this.DUG);
      int i4 = f.a.a.b.b.a.fK(12);
      int i5 = f.a.a.b.b.a.bx(13, this.DUI);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hi localhi = (hi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localhi.DUK = locala.LVo.xG();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localhi.vTL = locala.LVo.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localhi.DUy = locala.LVo.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localhi.DUz = locala.LVo.xF();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localhi.DUA = locala.LVo.xG();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localhi.DUB = locala.LVo.xF();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localhi.ndj = locala.LVo.xF();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localhi.DUC = locala.LVo.xG();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localhi.DUD = locala.LVo.xG();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localhi.DUL = locala.LVo.xF();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localhi.DUG = locala.LVo.xG();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localhi.DUH = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(87873);
        return 0;
      }
      localhi.DUI = locala.LVo.xF();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hi
 * JD-Core Version:    0.7.0.1
 */