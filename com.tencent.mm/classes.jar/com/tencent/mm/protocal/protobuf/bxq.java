package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxq
  extends com.tencent.mm.bx.a
{
  public int DUh;
  public int DUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DUh);
      paramVarArgs.aR(2, this.DUi);
      AppMethodBeat.o(123632);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DUh);
      int i = f.a.a.b.b.a.bA(2, this.DUi);
      AppMethodBeat.o(123632);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123632);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxq localbxq = (bxq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123632);
        return -1;
      case 1: 
        localbxq.DUh = locala.KhF.xS();
        AppMethodBeat.o(123632);
        return 0;
      }
      localbxq.DUi = locala.KhF.xS();
      AppMethodBeat.o(123632);
      return 0;
    }
    AppMethodBeat.o(123632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxq
 * JD-Core Version:    0.7.0.1
 */