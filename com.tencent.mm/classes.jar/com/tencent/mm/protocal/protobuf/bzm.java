package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzm
  extends com.tencent.mm.bx.a
{
  public String FuL;
  public int GUk;
  public String nDo;
  public int yho;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuL != null) {
        paramVarArgs.d(1, this.FuL);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.GUk);
      paramVarArgs.aS(4, this.yho);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuL == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.FuL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GUk);
      int j = f.a.a.b.b.a.bz(4, this.yho);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzm localbzm = (bzm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localbzm.FuL = locala.NPN.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localbzm.nDo = locala.NPN.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localbzm.GUk = locala.NPN.zc();
          AppMethodBeat.o(101826);
          return 0;
        }
        localbzm.yho = locala.NPN.zc();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzm
 * JD-Core Version:    0.7.0.1
 */