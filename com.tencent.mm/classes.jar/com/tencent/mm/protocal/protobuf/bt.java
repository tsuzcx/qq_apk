package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bt
  extends com.tencent.mm.bx.a
{
  public float FtZ;
  public float Fua;
  public float Fub;
  public long Fuc;
  public long Fud;
  public long Fue;
  public long Fuf;
  public long endTime;
  public long startTime;
  public int yYr;
  public int yYs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.yYr);
      paramVarArgs.aS(2, this.yYs);
      paramVarArgs.z(3, this.FtZ);
      paramVarArgs.z(4, this.Fua);
      paramVarArgs.z(5, this.Fub);
      paramVarArgs.aY(6, this.startTime);
      paramVarArgs.aY(7, this.endTime);
      paramVarArgs.aY(8, this.Fuc);
      paramVarArgs.aY(9, this.Fud);
      paramVarArgs.aY(10, this.Fue);
      paramVarArgs.aY(11, this.Fuf);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.yYr);
      int i = f.a.a.b.b.a.bz(2, this.yYs);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.alU(4);
      int m = f.a.a.b.b.a.alU(5);
      int n = f.a.a.b.b.a.p(6, this.startTime);
      int i1 = f.a.a.b.b.a.p(7, this.endTime);
      int i2 = f.a.a.b.b.a.p(8, this.Fuc);
      int i3 = f.a.a.b.b.a.p(9, this.Fud);
      int i4 = f.a.a.b.b.a.p(10, this.Fue);
      int i5 = f.a.a.b.b.a.p(11, this.Fuf);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localbt.yYr = locala.NPN.zc();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localbt.yYs = locala.NPN.zc();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localbt.FtZ = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localbt.Fua = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localbt.Fub = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localbt.startTime = locala.NPN.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localbt.endTime = locala.NPN.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localbt.Fuc = locala.NPN.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localbt.Fud = locala.NPN.zd();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localbt.Fue = locala.NPN.zd();
        AppMethodBeat.o(125698);
        return 0;
      }
      localbt.Fuf = locala.NPN.zd();
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