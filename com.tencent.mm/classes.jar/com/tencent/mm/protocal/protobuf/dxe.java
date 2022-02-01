package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dxe
  extends com.tencent.mm.bx.a
{
  public long GeJ;
  public int HJW;
  public int HJX;
  public int HJY;
  public int HJZ;
  public b HKa;
  public long HyS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HyS);
      paramVarArgs.aY(2, this.GeJ);
      paramVarArgs.aS(3, this.HJW);
      paramVarArgs.aS(4, this.HJX);
      paramVarArgs.aS(5, this.HJY);
      paramVarArgs.aS(6, this.HJZ);
      if (this.HKa != null) {
        paramVarArgs.c(7, this.HKa);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.HyS) + 0 + f.a.a.b.b.a.p(2, this.GeJ) + f.a.a.b.b.a.bz(3, this.HJW) + f.a.a.b.b.a.bz(4, this.HJX) + f.a.a.b.b.a.bz(5, this.HJY) + f.a.a.b.b.a.bz(6, this.HJZ);
      paramInt = i;
      if (this.HKa != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.HKa);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxe localdxe = (dxe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localdxe.HyS = locala.NPN.zd();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localdxe.GeJ = locala.NPN.zd();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localdxe.HJW = locala.NPN.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localdxe.HJX = locala.NPN.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localdxe.HJY = locala.NPN.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localdxe.HJZ = locala.NPN.zc();
        AppMethodBeat.o(125501);
        return 0;
      }
      localdxe.HKa = locala.NPN.gxI();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */