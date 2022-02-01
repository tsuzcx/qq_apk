package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsa
  extends com.tencent.mm.bx.a
{
  public String GMS;
  public String GMU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123622);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMS != null) {
        paramVarArgs.d(1, this.GMS);
      }
      if (this.GMU != null) {
        paramVarArgs.d(2, this.GMU);
      }
      AppMethodBeat.o(123622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GMS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GMU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GMU);
      }
      AppMethodBeat.o(123622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123622);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsa localbsa = (bsa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123622);
          return -1;
        case 1: 
          localbsa.GMS = locala.NPN.readString();
          AppMethodBeat.o(123622);
          return 0;
        }
        localbsa.GMU = locala.NPN.readString();
        AppMethodBeat.o(123622);
        return 0;
      }
      AppMethodBeat.o(123622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsa
 * JD-Core Version:    0.7.0.1
 */