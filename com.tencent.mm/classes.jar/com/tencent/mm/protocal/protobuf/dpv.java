package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpv
  extends com.tencent.mm.bx.a
{
  public long HDN;
  public long HDO;
  public long HDP;
  public double HDQ;
  public double HDR;
  public double HDS;
  public double HDT;
  public long HDU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HDN);
      paramVarArgs.aY(2, this.HDO);
      paramVarArgs.aY(3, this.HDP);
      paramVarArgs.e(4, this.HDQ);
      paramVarArgs.e(5, this.HDR);
      paramVarArgs.e(6, this.HDS);
      paramVarArgs.e(7, this.HDT);
      paramVarArgs.aY(8, this.HDU);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HDN);
      int i = f.a.a.b.b.a.p(2, this.HDO);
      int j = f.a.a.b.b.a.p(3, this.HDP);
      int k = f.a.a.b.b.a.alT(4);
      int m = f.a.a.b.b.a.alT(5);
      int n = f.a.a.b.b.a.alT(6);
      int i1 = f.a.a.b.b.a.alT(7);
      int i2 = f.a.a.b.b.a.p(8, this.HDU);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpv localdpv = (dpv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localdpv.HDN = locala.NPN.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localdpv.HDO = locala.NPN.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localdpv.HDP = locala.NPN.zd();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localdpv.HDQ = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localdpv.HDR = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localdpv.HDS = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localdpv.HDT = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(110914);
        return 0;
      }
      localdpv.HDU = locala.NPN.zd();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpv
 * JD-Core Version:    0.7.0.1
 */