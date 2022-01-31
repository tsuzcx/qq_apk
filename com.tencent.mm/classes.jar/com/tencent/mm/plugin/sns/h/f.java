package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bv.a
{
  public int rlT;
  public long rlV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36829);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.rlV);
      paramVarArgs.aO(2, this.rlT);
      AppMethodBeat.o(36829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.rlV);
      int i = e.a.a.b.b.a.bl(2, this.rlT);
      AppMethodBeat.o(36829);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(36829);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(36829);
        return -1;
      case 1: 
        localf.rlV = locala.CLY.sm();
        AppMethodBeat.o(36829);
        return 0;
      }
      localf.rlT = locala.CLY.sl();
      AppMethodBeat.o(36829);
      return 0;
    }
    AppMethodBeat.o(36829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */