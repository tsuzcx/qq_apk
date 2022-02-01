package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brk
  extends com.tencent.mm.bw.a
{
  public int GMw;
  public int HeB;
  public int HeC;
  public int HeD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GMw);
      paramVarArgs.aS(2, this.HeB);
      paramVarArgs.aS(3, this.HeC);
      paramVarArgs.aS(4, this.HeD);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GMw);
      int i = f.a.a.b.b.a.bz(2, this.HeB);
      int j = f.a.a.b.b.a.bz(3, this.HeC);
      int k = f.a.a.b.b.a.bz(4, this.HeD);
      AppMethodBeat.o(152617);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      brk localbrk = (brk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localbrk.GMw = locala.OmT.zc();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localbrk.HeB = locala.OmT.zc();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localbrk.HeC = locala.OmT.zc();
        AppMethodBeat.o(152617);
        return 0;
      }
      localbrk.HeD = locala.OmT.zc();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brk
 * JD-Core Version:    0.7.0.1
 */