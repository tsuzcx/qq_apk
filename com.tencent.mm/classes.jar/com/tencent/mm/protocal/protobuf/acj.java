package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acj
  extends com.tencent.mm.cd.a
{
  public int COi;
  public int HlE;
  public int RUc;
  public int SnX;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HlE);
      paramVarArgs.aY(2, this.COi);
      paramVarArgs.aY(3, this.SnX);
      paramVarArgs.aY(4, this.rVU);
      paramVarArgs.aY(5, this.RUc);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.HlE);
      int i = g.a.a.b.b.a.bM(2, this.COi);
      int j = g.a.a.b.b.a.bM(3, this.SnX);
      int k = g.a.a.b.b.a.bM(4, this.rVU);
      int m = g.a.a.b.b.a.bM(5, this.RUc);
      AppMethodBeat.o(124478);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acj localacj = (acj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localacj.HlE = locala.abFh.AK();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localacj.COi = locala.abFh.AK();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localacj.SnX = locala.abFh.AK();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localacj.rVU = locala.abFh.AK();
        AppMethodBeat.o(124478);
        return 0;
      }
      localacj.RUc = locala.abFh.AK();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acj
 * JD-Core Version:    0.7.0.1
 */