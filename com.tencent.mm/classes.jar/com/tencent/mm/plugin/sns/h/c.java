package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public LinkedList<Long> rlL;
  
  public c()
  {
    AppMethodBeat.i(36824);
    this.rlL = new LinkedList();
    AppMethodBeat.o(36824);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36825);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).e(1, 3, this.rlL);
      AppMethodBeat.o(36825);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 3, this.rlL);
      AppMethodBeat.o(36825);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rlL.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(36825);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(36825);
        return -1;
      }
      localc.rlL.add(Long.valueOf(locala.CLY.sm()));
      AppMethodBeat.o(36825);
      return 0;
    }
    AppMethodBeat.o(36825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */