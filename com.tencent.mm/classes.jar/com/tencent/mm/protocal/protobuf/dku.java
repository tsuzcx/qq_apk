package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dku
  extends com.tencent.mm.bw.a
{
  public int MON;
  public int MOO;
  public int MOP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MON);
      paramVarArgs.aM(2, this.MOO);
      paramVarArgs.aM(3, this.MOP);
      AppMethodBeat.o(212296);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MON);
      int i = g.a.a.b.b.a.bu(2, this.MOO);
      int j = g.a.a.b.b.a.bu(3, this.MOP);
      AppMethodBeat.o(212296);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212296);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dku localdku = (dku)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212296);
        return -1;
      case 1: 
        localdku.MON = locala.UbS.zi();
        AppMethodBeat.o(212296);
        return 0;
      case 2: 
        localdku.MOO = locala.UbS.zi();
        AppMethodBeat.o(212296);
        return 0;
      }
      localdku.MOP = locala.UbS.zi();
      AppMethodBeat.o(212296);
      return 0;
    }
    AppMethodBeat.o(212296);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dku
 * JD-Core Version:    0.7.0.1
 */