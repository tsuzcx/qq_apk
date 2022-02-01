package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arp
  extends com.tencent.mm.bx.a
{
  public long Gpl;
  public int Gpq;
  public int Gpr;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gpq);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      paramVarArgs.aS(3, this.Gpr);
      paramVarArgs.aY(4, this.Gpl);
      AppMethodBeat.o(209360);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gpq) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = f.a.a.b.b.a.bz(3, this.Gpr);
      int j = f.a.a.b.b.a.p(4, this.Gpl);
      AppMethodBeat.o(209360);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209360);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arp localarp = (arp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209360);
        return -1;
      case 1: 
        localarp.Gpq = locala.NPN.zc();
        AppMethodBeat.o(209360);
        return 0;
      case 2: 
        localarp.dxD = locala.NPN.readString();
        AppMethodBeat.o(209360);
        return 0;
      case 3: 
        localarp.Gpr = locala.NPN.zc();
        AppMethodBeat.o(209360);
        return 0;
      }
      localarp.Gpl = locala.NPN.zd();
      AppMethodBeat.o(209360);
      return 0;
    }
    AppMethodBeat.o(209360);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */