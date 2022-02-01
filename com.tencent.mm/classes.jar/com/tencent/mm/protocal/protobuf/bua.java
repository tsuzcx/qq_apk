package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bua
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String FAe;
  public int FileSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104821);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAe != null) {
        paramVarArgs.d(1, this.FAe);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      paramVarArgs.aS(3, this.FileSize);
      AppMethodBeat.o(104821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FAe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FAe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.FileSize);
      AppMethodBeat.o(104821);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104821);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bua localbua = (bua)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104821);
          return -1;
        case 1: 
          localbua.FAe = locala.NPN.readString();
          AppMethodBeat.o(104821);
          return 0;
        case 2: 
          localbua.AesKey = locala.NPN.readString();
          AppMethodBeat.o(104821);
          return 0;
        }
        localbua.FileSize = locala.NPN.zc();
        AppMethodBeat.o(104821);
        return 0;
      }
      AppMethodBeat.o(104821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bua
 * JD-Core Version:    0.7.0.1
 */