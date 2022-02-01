package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public String gTS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194685);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.gTS != null) {
        paramVarArgs.e(1, this.gTS);
      }
      AppMethodBeat.o(194685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gTS == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.gTS) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(194685);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194685);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194685);
          return -1;
        }
        localm.gTS = locala.UbS.readString();
        AppMethodBeat.o(194685);
        return 0;
      }
      AppMethodBeat.o(194685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.t.a.m
 * JD-Core Version:    0.7.0.1
 */