package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmi
  extends com.tencent.mm.bx.a
{
  public String GGJ;
  public int GGK;
  public int GGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGJ != null) {
        paramVarArgs.d(1, this.GGJ);
      }
      paramVarArgs.aS(2, this.GGK);
      paramVarArgs.aS(3, this.GGL);
      AppMethodBeat.o(43097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGJ == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.GGJ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GGK);
      int j = f.a.a.b.b.a.bz(3, this.GGL);
      AppMethodBeat.o(43097);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43097);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmi localbmi = (bmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43097);
          return -1;
        case 1: 
          localbmi.GGJ = locala.NPN.readString();
          AppMethodBeat.o(43097);
          return 0;
        case 2: 
          localbmi.GGK = locala.NPN.zc();
          AppMethodBeat.o(43097);
          return 0;
        }
        localbmi.GGL = locala.NPN.zc();
        AppMethodBeat.o(43097);
        return 0;
      }
      AppMethodBeat.o(43097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmi
 * JD-Core Version:    0.7.0.1
 */