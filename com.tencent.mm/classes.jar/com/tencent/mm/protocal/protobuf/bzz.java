package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzz
  extends com.tencent.mm.bx.a
{
  public String GUS;
  public int nEf;
  public String uiP;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uiP != null) {
        paramVarArgs.d(1, this.uiP);
      }
      if (this.GUS != null) {
        paramVarArgs.d(2, this.GUS);
      }
      if (this.yhw != null) {
        paramVarArgs.d(3, this.yhw);
      }
      paramVarArgs.aS(4, this.nEf);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uiP == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.uiP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GUS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GUS);
      }
      i = paramInt;
      if (this.yhw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yhw);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.nEf);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzz localbzz = (bzz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localbzz.uiP = locala.NPN.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localbzz.GUS = locala.NPN.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localbzz.yhw = locala.NPN.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localbzz.nEf = locala.NPN.zc();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzz
 * JD-Core Version:    0.7.0.1
 */