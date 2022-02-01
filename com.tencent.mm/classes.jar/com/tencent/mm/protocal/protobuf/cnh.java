package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnh
  extends com.tencent.mm.bx.a
{
  public int EhP;
  public int Timestamp;
  public int fVE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EhP);
      paramVarArgs.aR(2, this.Timestamp);
      paramVarArgs.aR(3, this.fVE);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EhP);
      int i = f.a.a.b.b.a.bA(2, this.Timestamp);
      int j = f.a.a.b.b.a.bA(3, this.fVE);
      AppMethodBeat.o(117906);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnh localcnh = (cnh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localcnh.EhP = locala.KhF.xS();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localcnh.Timestamp = locala.KhF.xS();
        AppMethodBeat.o(117906);
        return 0;
      }
      localcnh.fVE = locala.KhF.xS();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnh
 * JD-Core Version:    0.7.0.1
 */