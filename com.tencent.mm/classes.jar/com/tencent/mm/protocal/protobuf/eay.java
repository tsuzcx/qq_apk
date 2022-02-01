package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eay
  extends com.tencent.mm.bx.a
{
  public int LzD;
  public int LzE;
  public int LzF;
  public int LzG;
  public int LzH;
  public int LzI;
  public int LzJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202522);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.LzD);
      paramVarArgs.aR(2, this.LzE);
      paramVarArgs.aR(3, this.LzF);
      paramVarArgs.aR(4, this.LzG);
      paramVarArgs.aR(5, this.LzH);
      paramVarArgs.aR(6, this.LzI);
      paramVarArgs.aR(7, this.LzJ);
      AppMethodBeat.o(202522);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.LzD);
      int i = f.a.a.b.b.a.bA(2, this.LzE);
      int j = f.a.a.b.b.a.bA(3, this.LzF);
      int k = f.a.a.b.b.a.bA(4, this.LzG);
      int m = f.a.a.b.b.a.bA(5, this.LzH);
      int n = f.a.a.b.b.a.bA(6, this.LzI);
      int i1 = f.a.a.b.b.a.bA(7, this.LzJ);
      AppMethodBeat.o(202522);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(202522);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eay localeay = (eay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202522);
        return -1;
      case 1: 
        localeay.LzD = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      case 2: 
        localeay.LzE = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      case 3: 
        localeay.LzF = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      case 4: 
        localeay.LzG = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      case 5: 
        localeay.LzH = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      case 6: 
        localeay.LzI = locala.KhF.xS();
        AppMethodBeat.o(202522);
        return 0;
      }
      localeay.LzJ = locala.KhF.xS();
      AppMethodBeat.o(202522);
      return 0;
    }
    AppMethodBeat.o(202522);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */