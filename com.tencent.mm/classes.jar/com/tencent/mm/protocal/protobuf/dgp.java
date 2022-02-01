package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgp
  extends com.tencent.mm.bx.a
{
  public float HuU;
  public float HuV;
  public float HuW;
  public float HuX;
  public int HuY;
  public long HuZ;
  public long Hva;
  public float bYG;
  public int zSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.HuU);
      paramVarArgs.z(2, this.HuV);
      paramVarArgs.z(3, this.HuW);
      paramVarArgs.z(4, this.HuX);
      paramVarArgs.aS(5, this.HuY);
      paramVarArgs.aY(6, this.HuZ);
      paramVarArgs.aY(7, this.Hva);
      paramVarArgs.z(8, this.bYG);
      paramVarArgs.aS(9, this.zSo);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(1);
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.alU(4);
      int m = f.a.a.b.b.a.bz(5, this.HuY);
      int n = f.a.a.b.b.a.p(6, this.HuZ);
      int i1 = f.a.a.b.b.a.p(7, this.Hva);
      int i2 = f.a.a.b.b.a.alU(8);
      int i3 = f.a.a.b.b.a.bz(9, this.zSo);
      AppMethodBeat.o(125812);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dgp localdgp = (dgp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localdgp.HuU = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localdgp.HuV = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localdgp.HuW = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localdgp.HuX = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localdgp.HuY = locala.NPN.zc();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localdgp.HuZ = locala.NPN.zd();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localdgp.Hva = locala.NPN.zd();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localdgp.bYG = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125812);
        return 0;
      }
      localdgp.zSo = locala.NPN.zc();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgp
 * JD-Core Version:    0.7.0.1
 */