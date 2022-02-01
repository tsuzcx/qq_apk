package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public int MEO;
  public boolean MEP;
  public int MEQ;
  public int kYn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.kYn);
      paramVarArgs.aY(2, this.MEO);
      paramVarArgs.co(3, this.MEP);
      paramVarArgs.aY(4, this.MEQ);
      AppMethodBeat.o(243850);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.kYn);
      int i = g.a.a.b.b.a.bM(2, this.MEO);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.bM(4, this.MEQ);
      AppMethodBeat.o(243850);
      return paramInt + 0 + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(243850);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(243850);
        return -1;
      case 1: 
        locald.kYn = locala.abFh.AK();
        AppMethodBeat.o(243850);
        return 0;
      case 2: 
        locald.MEO = locala.abFh.AK();
        AppMethodBeat.o(243850);
        return 0;
      case 3: 
        locald.MEP = locala.abFh.AB();
        AppMethodBeat.o(243850);
        return 0;
      }
      locald.MEQ = locala.abFh.AK();
      AppMethodBeat.o(243850);
      return 0;
    }
    AppMethodBeat.o(243850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.d
 * JD-Core Version:    0.7.0.1
 */