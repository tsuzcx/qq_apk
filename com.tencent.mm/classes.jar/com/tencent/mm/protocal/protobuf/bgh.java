package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgh
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int xoo;
  public int xvA;
  public int xvB;
  public int xvC;
  public int xvD;
  public int xvE;
  public int xvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72861);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xoo);
      paramVarArgs.aO(2, this.xvz);
      paramVarArgs.aO(3, this.xvA);
      paramVarArgs.aO(4, this.xvB);
      paramVarArgs.aO(5, this.xvC);
      paramVarArgs.aO(6, this.xvD);
      paramVarArgs.aO(7, this.xvE);
      paramVarArgs.aO(8, this.jKs);
      AppMethodBeat.o(72861);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xoo);
      int i = e.a.a.b.b.a.bl(2, this.xvz);
      int j = e.a.a.b.b.a.bl(3, this.xvA);
      int k = e.a.a.b.b.a.bl(4, this.xvB);
      int m = e.a.a.b.b.a.bl(5, this.xvC);
      int n = e.a.a.b.b.a.bl(6, this.xvD);
      int i1 = e.a.a.b.b.a.bl(7, this.xvE);
      int i2 = e.a.a.b.b.a.bl(8, this.jKs);
      AppMethodBeat.o(72861);
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
      AppMethodBeat.o(72861);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bgh localbgh = (bgh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72861);
        return -1;
      case 1: 
        localbgh.xoo = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 2: 
        localbgh.xvz = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 3: 
        localbgh.xvA = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 4: 
        localbgh.xvB = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 5: 
        localbgh.xvC = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 6: 
        localbgh.xvD = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      case 7: 
        localbgh.xvE = locala.CLY.sl();
        AppMethodBeat.o(72861);
        return 0;
      }
      localbgh.jKs = locala.CLY.sl();
      AppMethodBeat.o(72861);
      return 0;
    }
    AppMethodBeat.o(72861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgh
 * JD-Core Version:    0.7.0.1
 */