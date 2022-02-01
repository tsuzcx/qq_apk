package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmc
  extends com.tencent.mm.cd.a
{
  public float ScO;
  public float ScP;
  public int Sxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.ScO);
      paramVarArgs.i(2, this.ScP);
      paramVarArgs.aY(3, this.Sxt);
      AppMethodBeat.o(202633);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.Sxt);
      AppMethodBeat.o(202633);
      return paramInt + 4 + 0 + (i + 4) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(202633);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dmc localdmc = (dmc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202633);
        return -1;
      case 1: 
        localdmc.ScO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(202633);
        return 0;
      case 2: 
        localdmc.ScP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(202633);
        return 0;
      }
      localdmc.Sxt = locala.abFh.AK();
      AppMethodBeat.o(202633);
      return 0;
    }
    AppMethodBeat.o(202633);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmc
 * JD-Core Version:    0.7.0.1
 */