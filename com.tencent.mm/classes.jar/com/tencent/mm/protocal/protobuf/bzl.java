package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzl
  extends com.tencent.mm.bx.a
{
  public String FVn;
  public String FuL;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuL != null) {
        paramVarArgs.d(1, this.FuL);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.FVn != null) {
        paramVarArgs.d(3, this.FVn);
      }
      AppMethodBeat.o(101825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuL == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FuL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.FVn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVn);
      }
      AppMethodBeat.o(101825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(101825);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzl localbzl = (bzl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101825);
          return -1;
        case 1: 
          localbzl.FuL = locala.NPN.readString();
          AppMethodBeat.o(101825);
          return 0;
        case 2: 
          localbzl.nDo = locala.NPN.readString();
          AppMethodBeat.o(101825);
          return 0;
        }
        localbzl.FVn = locala.NPN.readString();
        AppMethodBeat.o(101825);
        return 0;
      }
      AppMethodBeat.o(101825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzl
 * JD-Core Version:    0.7.0.1
 */