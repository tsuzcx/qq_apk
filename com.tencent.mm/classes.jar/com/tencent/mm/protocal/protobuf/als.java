package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class als
  extends com.tencent.mm.cd.a
{
  public String SvX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32197);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SvX == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32197);
        throw paramVarArgs;
      }
      if (this.SvX != null) {
        paramVarArgs.f(1, this.SvX);
      }
      AppMethodBeat.o(32197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SvX == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = g.a.a.b.b.a.g(1, this.SvX) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SvX == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32197);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32197);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        als localals = (als)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32197);
          return -1;
        }
        localals.SvX = locala.abFh.readString();
        AppMethodBeat.o(32197);
        return 0;
      }
      AppMethodBeat.o(32197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */