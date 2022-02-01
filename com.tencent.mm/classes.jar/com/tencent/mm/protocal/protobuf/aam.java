package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aam
  extends com.tencent.mm.cd.a
{
  public int SmC;
  public int SmD;
  public int SmE;
  public boolean SmF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SmC);
      paramVarArgs.aY(2, this.SmD);
      paramVarArgs.aY(3, this.SmE);
      paramVarArgs.co(4, this.SmF);
      AppMethodBeat.o(212411);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SmC);
      int i = g.a.a.b.b.a.bM(2, this.SmD);
      int j = g.a.a.b.b.a.bM(3, this.SmE);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(212411);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(212411);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aam localaam = (aam)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212411);
        return -1;
      case 1: 
        localaam.SmC = locala.abFh.AK();
        AppMethodBeat.o(212411);
        return 0;
      case 2: 
        localaam.SmD = locala.abFh.AK();
        AppMethodBeat.o(212411);
        return 0;
      case 3: 
        localaam.SmE = locala.abFh.AK();
        AppMethodBeat.o(212411);
        return 0;
      }
      localaam.SmF = locala.abFh.AB();
      AppMethodBeat.o(212411);
      return 0;
    }
    AppMethodBeat.o(212411);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */