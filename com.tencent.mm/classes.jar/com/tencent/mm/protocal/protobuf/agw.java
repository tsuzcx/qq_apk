package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agw
  extends com.tencent.mm.bx.a
{
  public int GeO;
  public int GeP;
  public String GeQ;
  public String dxD;
  public String pkr;
  public int uda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeO);
      paramVarArgs.aS(2, this.GeP);
      paramVarArgs.aS(3, this.uda);
      if (this.dxD != null) {
        paramVarArgs.d(4, this.dxD);
      }
      if (this.pkr != null) {
        paramVarArgs.d(5, this.pkr);
      }
      if (this.GeQ != null) {
        paramVarArgs.d(6, this.GeQ);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GeO) + 0 + f.a.a.b.b.a.bz(2, this.GeP) + f.a.a.b.b.a.bz(3, this.uda);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dxD);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pkr);
      }
      paramInt = i;
      if (this.GeQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GeQ);
      }
      AppMethodBeat.o(179487);
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
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agw localagw = (agw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localagw.GeO = locala.NPN.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localagw.GeP = locala.NPN.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localagw.uda = locala.NPN.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localagw.dxD = locala.NPN.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localagw.pkr = locala.NPN.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localagw.GeQ = locala.NPN.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agw
 * JD-Core Version:    0.7.0.1
 */