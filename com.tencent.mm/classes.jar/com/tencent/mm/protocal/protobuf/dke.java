package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dke
  extends com.tencent.mm.bw.a
{
  public long FTb;
  public long FTc;
  public long FTd;
  public double FTe;
  public double FTf;
  public double FTg;
  public double FTh;
  public long FTi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FTb);
      paramVarArgs.aO(2, this.FTc);
      paramVarArgs.aO(3, this.FTd);
      paramVarArgs.e(4, this.FTe);
      paramVarArgs.e(5, this.FTf);
      paramVarArgs.e(6, this.FTg);
      paramVarArgs.e(7, this.FTh);
      paramVarArgs.aO(8, this.FTi);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FTb);
      int i = f.a.a.b.b.a.p(2, this.FTc);
      int j = f.a.a.b.b.a.p(3, this.FTd);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.fK(7);
      int i2 = f.a.a.b.b.a.p(8, this.FTi);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + (k + 8) + (m + 8) + (n + 8) + (i1 + 8) + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dke localdke = (dke)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localdke.FTb = locala.LVo.xG();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localdke.FTc = locala.LVo.xG();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localdke.FTd = locala.LVo.xG();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localdke.FTe = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localdke.FTf = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localdke.FTg = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localdke.FTh = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(110914);
        return 0;
      }
      localdke.FTi = locala.LVo.xG();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dke
 * JD-Core Version:    0.7.0.1
 */