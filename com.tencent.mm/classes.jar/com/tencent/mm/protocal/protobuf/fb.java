package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fb
  extends com.tencent.mm.bx.a
{
  public boolean FwU;
  public boolean FwV;
  public int FwW;
  public int FwX;
  public int FwY;
  public int FwZ;
  public int Fxa;
  public boolean Fxb;
  public boolean Fxc;
  public boolean Fxd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.FwU);
      paramVarArgs.bt(2, this.FwV);
      paramVarArgs.aS(3, this.FwW);
      paramVarArgs.aS(4, this.FwX);
      paramVarArgs.aS(5, this.FwY);
      paramVarArgs.aS(6, this.FwZ);
      paramVarArgs.aS(7, this.Fxa);
      paramVarArgs.bt(8, this.Fxb);
      paramVarArgs.bt(9, this.Fxc);
      paramVarArgs.bt(10, this.Fxd);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.bz(3, this.FwW);
      int k = f.a.a.b.b.a.bz(4, this.FwX);
      int m = f.a.a.b.b.a.bz(5, this.FwY);
      int n = f.a.a.b.b.a.bz(6, this.FwZ);
      int i1 = f.a.a.b.b.a.bz(7, this.Fxa);
      int i2 = f.a.a.b.b.a.alV(8);
      int i3 = f.a.a.b.b.a.alV(9);
      int i4 = f.a.a.b.b.a.alV(10);
      AppMethodBeat.o(124386);
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
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      fb localfb = (fb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localfb.FwU = locala.NPN.grw();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localfb.FwV = locala.NPN.grw();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localfb.FwW = locala.NPN.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localfb.FwX = locala.NPN.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localfb.FwY = locala.NPN.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localfb.FwZ = locala.NPN.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localfb.Fxa = locala.NPN.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localfb.Fxb = locala.NPN.grw();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localfb.Fxc = locala.NPN.grw();
        AppMethodBeat.o(124386);
        return 0;
      }
      localfb.Fxd = locala.NPN.grw();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fb
 * JD-Core Version:    0.7.0.1
 */