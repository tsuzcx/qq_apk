package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bv.a
{
  public int action;
  public int wjA;
  public int wjB;
  public int wjC;
  public int wjD;
  public int wjE;
  public int wjF;
  public int wjG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72831);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wjA);
      paramVarArgs.aO(2, this.action);
      paramVarArgs.aO(3, this.wjB);
      paramVarArgs.aO(4, this.wjC);
      paramVarArgs.aO(5, this.wjD);
      paramVarArgs.aO(6, this.wjE);
      paramVarArgs.aO(7, this.wjF);
      paramVarArgs.aO(8, this.wjG);
      AppMethodBeat.o(72831);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wjA);
      int i = e.a.a.b.b.a.bl(2, this.action);
      int j = e.a.a.b.b.a.bl(3, this.wjB);
      int k = e.a.a.b.b.a.bl(4, this.wjC);
      int m = e.a.a.b.b.a.bl(5, this.wjD);
      int n = e.a.a.b.b.a.bl(6, this.wjE);
      int i1 = e.a.a.b.b.a.bl(7, this.wjF);
      int i2 = e.a.a.b.b.a.bl(8, this.wjG);
      AppMethodBeat.o(72831);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72831);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72831);
        return -1;
      case 1: 
        locall.wjA = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 2: 
        locall.action = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 3: 
        locall.wjB = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 4: 
        locall.wjC = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 5: 
        locall.wjD = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 6: 
        locall.wjE = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      case 7: 
        locall.wjF = locala.CLY.sl();
        AppMethodBeat.o(72831);
        return 0;
      }
      locall.wjG = locala.CLY.sl();
      AppMethodBeat.o(72831);
      return 0;
    }
    AppMethodBeat.o(72831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */