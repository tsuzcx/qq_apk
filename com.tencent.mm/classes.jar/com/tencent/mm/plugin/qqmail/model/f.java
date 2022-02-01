package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public int Njs;
  public long Njv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Njs);
      paramVarArgs.bv(2, this.Njv);
      AppMethodBeat.o(122661);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Njs);
      int i = i.a.a.b.b.a.q(2, this.Njv);
      AppMethodBeat.o(122661);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122661);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122661);
        return -1;
      case 1: 
        localf.Njs = locala.ajGk.aar();
        AppMethodBeat.o(122661);
        return 0;
      }
      localf.Njv = locala.ajGk.aaw();
      AppMethodBeat.o(122661);
      return 0;
    }
    AppMethodBeat.o(122661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.f
 * JD-Core Version:    0.7.0.1
 */