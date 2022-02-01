package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dyz
  extends com.tencent.mm.cd.a
{
  public int ret;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127173);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(127173);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.aY(2, this.ret);
      AppMethodBeat.o(127173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.ret);
      AppMethodBeat.o(127173);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(127173);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127173);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyz localdyz = (dyz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127173);
          return -1;
        case 1: 
          localdyz.username = locala.abFh.readString();
          AppMethodBeat.o(127173);
          return 0;
        }
        localdyz.ret = locala.abFh.AK();
        AppMethodBeat.o(127173);
        return 0;
      }
      AppMethodBeat.o(127173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyz
 * JD-Core Version:    0.7.0.1
 */