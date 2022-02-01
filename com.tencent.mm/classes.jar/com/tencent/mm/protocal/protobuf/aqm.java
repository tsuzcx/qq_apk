package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqm
  extends com.tencent.mm.bx.a
{
  public int GoA;
  public float GoB;
  public int GoC;
  public int GoD;
  public float GoE;
  public int slf;
  public int slg;
  public int slk;
  public int sll;
  public int sln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.slf);
      paramVarArgs.aS(2, this.slg);
      paramVarArgs.aS(3, this.GoA);
      paramVarArgs.z(4, this.GoB);
      paramVarArgs.aS(5, this.GoC);
      paramVarArgs.aS(6, this.GoD);
      paramVarArgs.aS(7, this.slk);
      paramVarArgs.aS(8, this.sll);
      paramVarArgs.z(9, this.GoE);
      paramVarArgs.aS(10, this.sln);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.slf);
      int i = f.a.a.b.b.a.bz(2, this.slg);
      int j = f.a.a.b.b.a.bz(3, this.GoA);
      int k = f.a.a.b.b.a.alU(4);
      int m = f.a.a.b.b.a.bz(5, this.GoC);
      int n = f.a.a.b.b.a.bz(6, this.GoD);
      int i1 = f.a.a.b.b.a.bz(7, this.slk);
      int i2 = f.a.a.b.b.a.bz(8, this.sll);
      int i3 = f.a.a.b.b.a.alU(9);
      int i4 = f.a.a.b.b.a.bz(10, this.sln);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqm localaqm = (aqm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localaqm.slf = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localaqm.slg = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localaqm.GoA = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localaqm.GoB = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localaqm.GoC = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 6: 
        localaqm.GoD = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 7: 
        localaqm.slk = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 8: 
        localaqm.sll = locala.NPN.zc();
        AppMethodBeat.o(184205);
        return 0;
      case 9: 
        localaqm.GoE = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(184205);
        return 0;
      }
      localaqm.sln = locala.NPN.zc();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqm
 * JD-Core Version:    0.7.0.1
 */