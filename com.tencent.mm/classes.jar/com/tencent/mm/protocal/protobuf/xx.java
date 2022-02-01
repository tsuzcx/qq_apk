package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xx
  extends com.tencent.mm.bx.a
{
  public int CZA;
  public int CZB;
  public int CZC;
  public int CZD;
  public int nQF;
  public int nQG;
  public int nQH;
  public int nQI;
  public int nQJ;
  public int nQK;
  public int nQL;
  public int nQM;
  public int nQN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.nQF);
      paramVarArgs.aR(2, this.CZA);
      paramVarArgs.aR(3, this.nQG);
      paramVarArgs.aR(4, this.nQH);
      paramVarArgs.aR(5, this.nQI);
      paramVarArgs.aR(6, this.CZB);
      paramVarArgs.aR(7, this.nQJ);
      paramVarArgs.aR(8, this.nQK);
      paramVarArgs.aR(9, this.CZC);
      paramVarArgs.aR(10, this.CZD);
      paramVarArgs.aR(11, this.nQL);
      paramVarArgs.aR(12, this.nQM);
      paramVarArgs.aR(13, this.nQN);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.nQF);
      int i = f.a.a.b.b.a.bA(2, this.CZA);
      int j = f.a.a.b.b.a.bA(3, this.nQG);
      int k = f.a.a.b.b.a.bA(4, this.nQH);
      int m = f.a.a.b.b.a.bA(5, this.nQI);
      int n = f.a.a.b.b.a.bA(6, this.CZB);
      int i1 = f.a.a.b.b.a.bA(7, this.nQJ);
      int i2 = f.a.a.b.b.a.bA(8, this.nQK);
      int i3 = f.a.a.b.b.a.bA(9, this.CZC);
      int i4 = f.a.a.b.b.a.bA(10, this.CZD);
      int i5 = f.a.a.b.b.a.bA(11, this.nQL);
      int i6 = f.a.a.b.b.a.bA(12, this.nQM);
      int i7 = f.a.a.b.b.a.bA(13, this.nQN);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xx localxx = (xx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localxx.nQF = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localxx.CZA = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localxx.nQG = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localxx.nQH = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localxx.nQI = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localxx.CZB = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localxx.nQJ = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localxx.nQK = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localxx.CZC = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localxx.CZD = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localxx.nQL = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localxx.nQM = locala.KhF.xS();
        AppMethodBeat.o(90959);
        return 0;
      }
      localxx.nQN = locala.KhF.xS();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xx
 * JD-Core Version:    0.7.0.1
 */