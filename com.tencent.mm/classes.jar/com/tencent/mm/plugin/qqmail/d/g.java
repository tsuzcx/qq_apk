package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public long Brn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Brl);
      paramVarArgs.bb(2, this.Brn);
      AppMethodBeat.o(122661);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Brl);
      int i = g.a.a.b.b.a.r(2, this.Brn);
      AppMethodBeat.o(122661);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122661);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122661);
        return -1;
      case 1: 
        localg.Brl = locala.UbS.zi();
        AppMethodBeat.o(122661);
        return 0;
      }
      localg.Brn = locala.UbS.zl();
      AppMethodBeat.o(122661);
      return 0;
    }
    AppMethodBeat.o(122661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.g
 * JD-Core Version:    0.7.0.1
 */