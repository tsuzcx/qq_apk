package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ask
  extends com.tencent.mm.bx.a
{
  public int CNt;
  public long Dql;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      paramVarArgs.aR(2, this.CNt);
      paramVarArgs.aG(3, this.Dql);
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.mBH);
      int i = f.a.a.b.b.a.bA(2, this.CNt);
      int j = f.a.a.b.b.a.q(3, this.Dql);
      AppMethodBeat.o(117868);
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
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ask localask = (ask)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117868);
        return -1;
      case 1: 
        localask.mBH = locala.KhF.xS();
        AppMethodBeat.o(117868);
        return 0;
      case 2: 
        localask.CNt = locala.KhF.xS();
        AppMethodBeat.o(117868);
        return 0;
      }
      localask.Dql = locala.KhF.xT();
      AppMethodBeat.o(117868);
      return 0;
    }
    AppMethodBeat.o(117868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ask
 * JD-Core Version:    0.7.0.1
 */