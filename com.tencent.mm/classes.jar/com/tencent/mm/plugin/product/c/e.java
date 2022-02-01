package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bw.a
{
  public int id;
  public String name;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aM(3, this.value);
      AppMethodBeat.o(91271);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = g.a.a.b.b.a.bu(3, this.value);
      AppMethodBeat.o(91271);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91271);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91271);
        return -1;
      case 1: 
        locale.id = locala.UbS.zi();
        AppMethodBeat.o(91271);
        return 0;
      case 2: 
        locale.name = locala.UbS.readString();
        AppMethodBeat.o(91271);
        return 0;
      }
      locale.value = locala.UbS.zi();
      AppMethodBeat.o(91271);
      return 0;
    }
    AppMethodBeat.o(91271);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.e
 * JD-Core Version:    0.7.0.1
 */