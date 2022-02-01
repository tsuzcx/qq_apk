package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abo
  extends com.tencent.mm.bx.a
{
  public int CZB;
  public int DbS;
  public int DbT;
  public int DbU;
  public int DbV;
  public int DbW;
  public int DbX;
  public int channels;
  public int nQI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DbS);
      paramVarArgs.aR(2, this.DbT);
      paramVarArgs.aR(3, this.channels);
      paramVarArgs.aR(4, this.DbU);
      paramVarArgs.aR(5, this.CZB);
      paramVarArgs.aR(6, this.nQI);
      paramVarArgs.aR(7, this.DbV);
      paramVarArgs.aR(8, this.DbW);
      paramVarArgs.aR(9, this.DbX);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DbS);
      int i = f.a.a.b.b.a.bA(2, this.DbT);
      int j = f.a.a.b.b.a.bA(3, this.channels);
      int k = f.a.a.b.b.a.bA(4, this.DbU);
      int m = f.a.a.b.b.a.bA(5, this.CZB);
      int n = f.a.a.b.b.a.bA(6, this.nQI);
      int i1 = f.a.a.b.b.a.bA(7, this.DbV);
      int i2 = f.a.a.b.b.a.bA(8, this.DbW);
      int i3 = f.a.a.b.b.a.bA(9, this.DbX);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      abo localabo = (abo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localabo.DbS = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localabo.DbT = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localabo.channels = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localabo.DbU = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localabo.CZB = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localabo.nQI = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localabo.DbV = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localabo.DbW = locala.KhF.xS();
        AppMethodBeat.o(90964);
        return 0;
      }
      localabo.DbX = locala.KhF.xS();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abo
 * JD-Core Version:    0.7.0.1
 */