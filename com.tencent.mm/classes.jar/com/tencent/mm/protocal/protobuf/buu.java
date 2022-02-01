package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buu
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String FSC;
  public int FileSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104821);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSC != null) {
        paramVarArgs.d(1, this.FSC);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      paramVarArgs.aS(3, this.FileSize);
      AppMethodBeat.o(104821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSC == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FSC) + 0;; paramInt = 0)
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104821);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buu localbuu = (buu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104821);
          return -1;
        case 1: 
          localbuu.FSC = locala.OmT.readString();
          AppMethodBeat.o(104821);
          return 0;
        case 2: 
          localbuu.AesKey = locala.OmT.readString();
          AppMethodBeat.o(104821);
          return 0;
        }
        localbuu.FileSize = locala.OmT.zc();
        AppMethodBeat.o(104821);
        return 0;
      }
      AppMethodBeat.o(104821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buu
 * JD-Core Version:    0.7.0.1
 */