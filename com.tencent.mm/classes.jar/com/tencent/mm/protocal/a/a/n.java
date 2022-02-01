package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int CrW;
  public int CrX;
  public int CrY;
  public int CrZ;
  public int Crn;
  public int Csa;
  public int Csb;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Crn);
      paramVarArgs.aR(2, this.CrW);
      paramVarArgs.aR(3, this.CrX);
      paramVarArgs.aR(4, this.CrY);
      paramVarArgs.aR(5, this.CrZ);
      paramVarArgs.aR(6, this.Csa);
      paramVarArgs.aR(7, this.Csb);
      paramVarArgs.aR(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Crn);
      int i = f.a.a.b.b.a.bA(2, this.CrW);
      int j = f.a.a.b.b.a.bA(3, this.CrX);
      int k = f.a.a.b.b.a.bA(4, this.CrY);
      int m = f.a.a.b.b.a.bA(5, this.CrZ);
      int n = f.a.a.b.b.a.bA(6, this.Csa);
      int i1 = f.a.a.b.b.a.bA(7, this.Csb);
      int i2 = f.a.a.b.b.a.bA(8, this.type);
      AppMethodBeat.o(143958);
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
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143958);
        return -1;
      case 1: 
        localn.Crn = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.CrW = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.CrX = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.CrY = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.CrZ = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.Csa = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.Csb = locala.KhF.xS();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.KhF.xS();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */