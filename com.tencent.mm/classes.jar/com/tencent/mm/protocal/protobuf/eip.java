package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eip
  extends com.tencent.mm.bx.a
{
  public String FuU;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuU != null) {
        paramVarArgs.d(1, this.FuU);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      AppMethodBeat.o(123711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuU == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.FuU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Url);
      }
      AppMethodBeat.o(123711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123711);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eip localeip = (eip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123711);
          return -1;
        case 1: 
          localeip.FuU = locala.NPN.readString();
          AppMethodBeat.o(123711);
          return 0;
        }
        localeip.Url = locala.NPN.readString();
        AppMethodBeat.o(123711);
        return 0;
      }
      AppMethodBeat.o(123711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eip
 * JD-Core Version:    0.7.0.1
 */