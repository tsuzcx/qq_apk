package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dn
  extends com.tencent.mm.bx.a
{
  public int dDp;
  public String dxD;
  public String kzK;
  public String kzL;
  public String paG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dDp);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.kzK != null) {
        paramVarArgs.d(3, this.kzK);
      }
      if (this.kzL != null) {
        paramVarArgs.d(4, this.kzL);
      }
      if (this.paG != null) {
        paramVarArgs.d(5, this.paG);
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dDp) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.kzK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kzK);
      }
      paramInt = i;
      if (this.kzL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.kzL);
      }
      i = paramInt;
      if (this.paG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.paG);
      }
      AppMethodBeat.o(72416);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dn localdn = (dn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72416);
        return -1;
      case 1: 
        localdn.dDp = locala.NPN.zc();
        AppMethodBeat.o(72416);
        return 0;
      case 2: 
        localdn.dxD = locala.NPN.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 3: 
        localdn.kzK = locala.NPN.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 4: 
        localdn.kzL = locala.NPN.readString();
        AppMethodBeat.o(72416);
        return 0;
      }
      localdn.paG = locala.NPN.readString();
      AppMethodBeat.o(72416);
      return 0;
    }
    AppMethodBeat.o(72416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dn
 * JD-Core Version:    0.7.0.1
 */