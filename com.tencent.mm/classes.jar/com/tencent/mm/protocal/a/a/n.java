package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bv.a
{
  public int type;
  public int wjK;
  public int wjL;
  public int wjM;
  public int wjN;
  public int wjO;
  public int wjP;
  public int wjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72834);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wjb);
      paramVarArgs.aO(2, this.wjK);
      paramVarArgs.aO(3, this.wjL);
      paramVarArgs.aO(4, this.wjM);
      paramVarArgs.aO(5, this.wjN);
      paramVarArgs.aO(6, this.wjO);
      paramVarArgs.aO(7, this.wjP);
      paramVarArgs.aO(8, this.type);
      AppMethodBeat.o(72834);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wjb);
      int i = e.a.a.b.b.a.bl(2, this.wjK);
      int j = e.a.a.b.b.a.bl(3, this.wjL);
      int k = e.a.a.b.b.a.bl(4, this.wjM);
      int m = e.a.a.b.b.a.bl(5, this.wjN);
      int n = e.a.a.b.b.a.bl(6, this.wjO);
      int i1 = e.a.a.b.b.a.bl(7, this.wjP);
      int i2 = e.a.a.b.b.a.bl(8, this.type);
      AppMethodBeat.o(72834);
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
      AppMethodBeat.o(72834);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72834);
        return -1;
      case 1: 
        localn.wjb = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 2: 
        localn.wjK = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 3: 
        localn.wjL = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 4: 
        localn.wjM = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 5: 
        localn.wjN = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 6: 
        localn.wjO = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      case 7: 
        localn.wjP = locala.CLY.sl();
        AppMethodBeat.o(72834);
        return 0;
      }
      localn.type = locala.CLY.sl();
      AppMethodBeat.o(72834);
      return 0;
    }
    AppMethodBeat.o(72834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */