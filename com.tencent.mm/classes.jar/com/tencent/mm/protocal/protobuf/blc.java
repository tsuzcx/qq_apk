package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blc
  extends com.tencent.mm.cd.a
{
  public int SVV;
  public int SVW;
  public int SVX;
  public int SVY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SVV);
      paramVarArgs.aY(2, this.SVW);
      paramVarArgs.aY(3, this.SVX);
      paramVarArgs.aY(4, this.SVY);
      AppMethodBeat.o(197709);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SVV);
      int i = g.a.a.b.b.a.bM(2, this.SVW);
      int j = g.a.a.b.b.a.bM(3, this.SVX);
      int k = g.a.a.b.b.a.bM(4, this.SVY);
      AppMethodBeat.o(197709);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197709);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      blc localblc = (blc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(197709);
        return -1;
      case 1: 
        localblc.SVV = locala.abFh.AK();
        AppMethodBeat.o(197709);
        return 0;
      case 2: 
        localblc.SVW = locala.abFh.AK();
        AppMethodBeat.o(197709);
        return 0;
      case 3: 
        localblc.SVX = locala.abFh.AK();
        AppMethodBeat.o(197709);
        return 0;
      }
      localblc.SVY = locala.abFh.AK();
      AppMethodBeat.o(197709);
      return 0;
    }
    AppMethodBeat.o(197709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blc
 * JD-Core Version:    0.7.0.1
 */