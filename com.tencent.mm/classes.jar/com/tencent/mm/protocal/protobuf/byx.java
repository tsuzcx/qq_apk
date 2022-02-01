package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byx
  extends com.tencent.mm.bx.a
{
  public String hAD;
  public String nZO;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nZO != null) {
        paramVarArgs.d(1, this.nZO);
      }
      if (this.hAD != null) {
        paramVarArgs.d(2, this.hAD);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      AppMethodBeat.o(72514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nZO == null) {
        break label338;
      }
    }
    label338:
    for (int i = f.a.a.b.b.a.e(1, this.nZO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hAD);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.url);
      }
      AppMethodBeat.o(72514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byx localbyx = (byx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72514);
          return -1;
        case 1: 
          localbyx.nZO = locala.NPN.readString();
          AppMethodBeat.o(72514);
          return 0;
        case 2: 
          localbyx.hAD = locala.NPN.readString();
          AppMethodBeat.o(72514);
          return 0;
        }
        localbyx.url = locala.NPN.readString();
        AppMethodBeat.o(72514);
        return 0;
      }
      AppMethodBeat.o(72514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */