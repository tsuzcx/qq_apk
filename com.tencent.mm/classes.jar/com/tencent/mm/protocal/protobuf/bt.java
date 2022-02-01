package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bt
  extends com.tencent.mm.bw.a
{
  public long FMA;
  public long FMB;
  public long FMC;
  public long FMD;
  public float FMx;
  public float FMy;
  public float FMz;
  public long endTime;
  public long startTime;
  public int zoS;
  public int zoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.zoS);
      paramVarArgs.aS(2, this.zoT);
      paramVarArgs.y(3, this.FMx);
      paramVarArgs.y(4, this.FMy);
      paramVarArgs.y(5, this.FMz);
      paramVarArgs.aZ(6, this.startTime);
      paramVarArgs.aZ(7, this.endTime);
      paramVarArgs.aZ(8, this.FMA);
      paramVarArgs.aZ(9, this.FMB);
      paramVarArgs.aZ(10, this.FMC);
      paramVarArgs.aZ(11, this.FMD);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.zoS);
      int i = f.a.a.b.b.a.bz(2, this.zoT);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.b.b.a.amE(5);
      int n = f.a.a.b.b.a.p(6, this.startTime);
      int i1 = f.a.a.b.b.a.p(7, this.endTime);
      int i2 = f.a.a.b.b.a.p(8, this.FMA);
      int i3 = f.a.a.b.b.a.p(9, this.FMB);
      int i4 = f.a.a.b.b.a.p(10, this.FMC);
      int i5 = f.a.a.b.b.a.p(11, this.FMD);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localbt.zoS = locala.OmT.zc();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localbt.zoT = locala.OmT.zc();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localbt.FMx = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localbt.FMy = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localbt.FMz = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localbt.startTime = locala.OmT.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localbt.endTime = locala.OmT.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localbt.FMA = locala.OmT.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localbt.FMB = locala.OmT.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localbt.FMC = locala.OmT.zd();
        AppMethodBeat.o(125698);
        return 0;
      }
      localbt.FMD = locala.OmT.zd();
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