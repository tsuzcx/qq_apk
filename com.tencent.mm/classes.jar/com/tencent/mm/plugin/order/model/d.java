package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public String AON;
  public int month;
  public int year;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.year);
      paramVarArgs.aM(2, this.month);
      if (this.AON != null) {
        paramVarArgs.e(3, this.AON);
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.year) + 0 + g.a.a.b.b.a.bu(2, this.month);
      paramInt = i;
      if (this.AON != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.AON);
      }
      AppMethodBeat.o(91260);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91260);
        return -1;
      case 1: 
        locald.year = locala.UbS.zi();
        AppMethodBeat.o(91260);
        return 0;
      case 2: 
        locald.month = locala.UbS.zi();
        AppMethodBeat.o(91260);
        return 0;
      }
      locald.AON = locala.UbS.readString();
      AppMethodBeat.o(91260);
      return 0;
    }
    AppMethodBeat.o(91260);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */