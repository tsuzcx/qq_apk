package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efq
  extends com.tencent.mm.bx.a
{
  public int HQR;
  public String HQS;
  public String HQT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HQR);
      if (this.HQS != null) {
        paramVarArgs.d(2, this.HQS);
      }
      if (this.HQT != null) {
        paramVarArgs.d(3, this.HQT);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HQR) + 0;
      paramInt = i;
      if (this.HQS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HQS);
      }
      i = paramInt;
      if (this.HQT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HQT);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efq localefq = (efq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localefq.HQR = locala.NPN.zc();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localefq.HQS = locala.NPN.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localefq.HQT = locala.NPN.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efq
 * JD-Core Version:    0.7.0.1
 */