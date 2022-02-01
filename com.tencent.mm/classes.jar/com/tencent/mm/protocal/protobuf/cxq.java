package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxq
  extends com.tencent.mm.bx.a
{
  public int EpI;
  public int EpJ;
  public int EpK;
  public int EpL;
  public int EpM;
  public int EpN;
  public int Timestamp;
  public int mBG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBG);
      paramVarArgs.aR(2, this.Timestamp);
      paramVarArgs.aR(3, this.EpI);
      paramVarArgs.aR(4, this.EpJ);
      paramVarArgs.aR(5, this.EpK);
      paramVarArgs.aR(6, this.EpL);
      paramVarArgs.aR(7, this.EpM);
      paramVarArgs.aR(8, this.EpN);
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.mBG);
      int i = f.a.a.b.b.a.bA(2, this.Timestamp);
      int j = f.a.a.b.b.a.bA(3, this.EpI);
      int k = f.a.a.b.b.a.bA(4, this.EpJ);
      int m = f.a.a.b.b.a.bA(5, this.EpK);
      int n = f.a.a.b.b.a.bA(6, this.EpL);
      int i1 = f.a.a.b.b.a.bA(7, this.EpM);
      int i2 = f.a.a.b.b.a.bA(8, this.EpN);
      AppMethodBeat.o(32457);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxq localcxq = (cxq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localcxq.mBG = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localcxq.Timestamp = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localcxq.EpI = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localcxq.EpJ = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localcxq.EpK = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localcxq.EpL = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localcxq.EpM = locala.KhF.xS();
        AppMethodBeat.o(32457);
        return 0;
      }
      localcxq.EpN = locala.KhF.xS();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxq
 * JD-Core Version:    0.7.0.1
 */