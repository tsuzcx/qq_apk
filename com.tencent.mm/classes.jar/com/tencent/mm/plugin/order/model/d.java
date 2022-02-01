package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public String MER;
  public int month;
  public int year;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91260);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.year);
      paramVarArgs.bS(2, this.month);
      if (this.MER != null) {
        paramVarArgs.g(3, this.MER);
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.year) + 0 + i.a.a.b.b.a.cJ(2, this.month);
      paramInt = i;
      if (this.MER != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MER);
      }
      AppMethodBeat.o(91260);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91260);
        return -1;
      case 1: 
        locald.year = locala.ajGk.aar();
        AppMethodBeat.o(91260);
        return 0;
      case 2: 
        locald.month = locala.ajGk.aar();
        AppMethodBeat.o(91260);
        return 0;
      }
      locald.MER = locala.ajGk.readString();
      AppMethodBeat.o(91260);
      return 0;
    }
    AppMethodBeat.o(91260);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */