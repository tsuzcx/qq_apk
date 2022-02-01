package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xq
  extends com.tencent.mm.bx.a
{
  public int CID;
  public int CZk;
  public int mBi;
  public int saz;
  public int uKX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uKX);
      paramVarArgs.aR(2, this.saz);
      paramVarArgs.aR(3, this.CZk);
      paramVarArgs.aR(4, this.mBi);
      paramVarArgs.aR(5, this.CID);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.uKX);
      int i = f.a.a.b.b.a.bA(2, this.saz);
      int j = f.a.a.b.b.a.bA(3, this.CZk);
      int k = f.a.a.b.b.a.bA(4, this.mBi);
      int m = f.a.a.b.b.a.bA(5, this.CID);
      AppMethodBeat.o(124478);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xq localxq = (xq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localxq.uKX = locala.KhF.xS();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localxq.saz = locala.KhF.xS();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localxq.CZk = locala.KhF.xS();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localxq.mBi = locala.KhF.xS();
        AppMethodBeat.o(124478);
        return 0;
      }
      localxq.CID = locala.KhF.xS();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xq
 * JD-Core Version:    0.7.0.1
 */