package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int CrM;
  public int CrN;
  public int CrO;
  public int CrP;
  public int CrQ;
  public int CrR;
  public int CrS;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CrM);
      paramVarArgs.aR(2, this.action);
      paramVarArgs.aR(3, this.CrN);
      paramVarArgs.aR(4, this.CrO);
      paramVarArgs.aR(5, this.CrP);
      paramVarArgs.aR(6, this.CrQ);
      paramVarArgs.aR(7, this.CrR);
      paramVarArgs.aR(8, this.CrS);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CrM);
      int i = f.a.a.b.b.a.bA(2, this.action);
      int j = f.a.a.b.b.a.bA(3, this.CrN);
      int k = f.a.a.b.b.a.bA(4, this.CrO);
      int m = f.a.a.b.b.a.bA(5, this.CrP);
      int n = f.a.a.b.b.a.bA(6, this.CrQ);
      int i1 = f.a.a.b.b.a.bA(7, this.CrR);
      int i2 = f.a.a.b.b.a.bA(8, this.CrS);
      AppMethodBeat.o(143955);
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
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.CrM = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.CrN = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.CrO = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.CrP = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.CrQ = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.CrR = locala.KhF.xS();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.CrS = locala.KhF.xS();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */