package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  extends com.tencent.mm.cd.a
{
  public int fWh;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(227029);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      paramVarArgs.aY(2, this.fWh);
      AppMethodBeat.o(227029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.fWh);
      AppMethodBeat.o(227029);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(227029);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(227029);
          return -1;
        case 1: 
          localj.sessionId = locala.abFh.readString();
          AppMethodBeat.o(227029);
          return 0;
        }
        localj.fWh = locala.abFh.AK();
        AppMethodBeat.o(227029);
        return 0;
      }
      AppMethodBeat.o(227029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.j
 * JD-Core Version:    0.7.0.1
 */