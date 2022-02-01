package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqu
  extends com.tencent.mm.bx.a
{
  public int EjG;
  public int EjH;
  public int EjI;
  public int EjJ;
  public int EjK;
  public int EjL;
  public int EjM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EjG);
      paramVarArgs.aR(2, this.EjH);
      paramVarArgs.aR(3, this.EjI);
      paramVarArgs.aR(4, this.EjJ);
      paramVarArgs.aR(5, this.EjK);
      paramVarArgs.aR(6, this.EjL);
      paramVarArgs.aR(7, this.EjM);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EjG);
      int i = f.a.a.b.b.a.bA(2, this.EjH);
      int j = f.a.a.b.b.a.bA(3, this.EjI);
      int k = f.a.a.b.b.a.bA(4, this.EjJ);
      int m = f.a.a.b.b.a.bA(5, this.EjK);
      int n = f.a.a.b.b.a.bA(6, this.EjL);
      int i1 = f.a.a.b.b.a.bA(7, this.EjM);
      AppMethodBeat.o(124550);
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
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cqu localcqu = (cqu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localcqu.EjG = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localcqu.EjH = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localcqu.EjI = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localcqu.EjJ = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localcqu.EjK = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localcqu.EjL = locala.KhF.xS();
        AppMethodBeat.o(124550);
        return 0;
      }
      localcqu.EjM = locala.KhF.xS();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqu
 * JD-Core Version:    0.7.0.1
 */