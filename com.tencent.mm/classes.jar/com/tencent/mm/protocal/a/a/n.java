package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int YyQ;
  public int YzA;
  public int YzB;
  public int YzC;
  public int YzD;
  public int YzE;
  public int Yzz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YyQ);
      paramVarArgs.bS(2, this.Yzz);
      paramVarArgs.bS(3, this.YzA);
      paramVarArgs.bS(4, this.YzB);
      paramVarArgs.bS(5, this.YzC);
      paramVarArgs.bS(6, this.YzD);
      paramVarArgs.bS(7, this.YzE);
      paramVarArgs.bS(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YyQ);
      int i = i.a.a.b.b.a.cJ(2, this.Yzz);
      int j = i.a.a.b.b.a.cJ(3, this.YzA);
      int k = i.a.a.b.b.a.cJ(4, this.YzB);
      int m = i.a.a.b.b.a.cJ(5, this.YzC);
      int n = i.a.a.b.b.a.cJ(6, this.YzD);
      int i1 = i.a.a.b.b.a.cJ(7, this.YzE);
      int i2 = i.a.a.b.b.a.cJ(8, this.type);
      AppMethodBeat.o(143958);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143958);
        return -1;
      case 1: 
        localn.YyQ = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.Yzz = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.YzA = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.YzB = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.YzC = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.YzD = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.YzE = locala.ajGk.aar();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.ajGk.aar();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */