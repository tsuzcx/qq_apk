package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class y
  extends com.tencent.mm.bx.a
{
  public String xbA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: subject");
        AppMethodBeat.o(122757);
        throw paramVarArgs;
      }
      if (this.xbA != null) {
        paramVarArgs.d(1, this.xbA);
      }
      AppMethodBeat.o(122757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xbA == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.xbA) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(122757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xbA == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122757);
          return -1;
        }
        localy.xbA = locala.NPN.readString();
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