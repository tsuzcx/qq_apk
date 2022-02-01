package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bt
  extends com.tencent.mm.bw.a
{
  public float DOP;
  public float DOQ;
  public float DOR;
  public long DOS;
  public long DOT;
  public long DOU;
  public long DOV;
  public long endTime;
  public long startTime;
  public int xJc;
  public int xJd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.xJc);
      paramVarArgs.aR(2, this.xJd);
      paramVarArgs.x(3, this.DOP);
      paramVarArgs.x(4, this.DOQ);
      paramVarArgs.x(5, this.DOR);
      paramVarArgs.aO(6, this.startTime);
      paramVarArgs.aO(7, this.endTime);
      paramVarArgs.aO(8, this.DOS);
      paramVarArgs.aO(9, this.DOT);
      paramVarArgs.aO(10, this.DOU);
      paramVarArgs.aO(11, this.DOV);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.xJc);
      int i = f.a.a.b.b.a.bx(2, this.xJd);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.p(6, this.startTime);
      int i1 = f.a.a.b.b.a.p(7, this.endTime);
      int i2 = f.a.a.b.b.a.p(8, this.DOS);
      int i3 = f.a.a.b.b.a.p(9, this.DOT);
      int i4 = f.a.a.b.b.a.p(10, this.DOU);
      int i5 = f.a.a.b.b.a.p(11, this.DOV);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bt localbt = (bt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125698);
        return -1;
      case 1: 
        localbt.xJc = locala.LVo.xF();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localbt.xJd = locala.LVo.xF();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localbt.DOP = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localbt.DOQ = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localbt.DOR = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localbt.startTime = locala.LVo.xG();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localbt.endTime = locala.LVo.xG();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localbt.DOS = locala.LVo.xG();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localbt.DOT = locala.LVo.xG();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localbt.DOU = locala.LVo.xG();
        AppMethodBeat.o(125698);
        return 0;
      }
      localbt.DOV = locala.LVo.xG();
      AppMethodBeat.o(125698);
      return 0;
    }
    AppMethodBeat.o(125698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bt
 * JD-Core Version:    0.7.0.1
 */