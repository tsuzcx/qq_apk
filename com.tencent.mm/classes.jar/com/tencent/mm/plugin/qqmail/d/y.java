package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class y
  extends com.tencent.mm.bw.a
{
  public String Bru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122757);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Bru == null)
      {
        paramVarArgs = new b("Not all required fields were included: subject");
        AppMethodBeat.o(122757);
        throw paramVarArgs;
      }
      if (this.Bru != null) {
        paramVarArgs.e(1, this.Bru);
      }
      AppMethodBeat.o(122757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bru == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.f(1, this.Bru) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(122757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Bru == null)
        {
          paramVarArgs = new b("Not all required fields were included: subject");
          AppMethodBeat.o(122757);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122757);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122757);
          return -1;
        }
        localy.Bru = locala.UbS.readString();
        AppMethodBeat.o(122757);
        return 0;
      }
      AppMethodBeat.o(122757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.y
 * JD-Core Version:    0.7.0.1
 */