package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fqp
  extends com.tencent.mm.cd.a
{
  public int score;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32573);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(32573);
        throw paramVarArgs;
      }
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      paramVarArgs.aY(2, this.score);
      AppMethodBeat.o(32573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.score);
      AppMethodBeat.o(32573);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(32573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32573);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fqp localfqp = (fqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32573);
          return -1;
        case 1: 
          localfqp.title = locala.abFh.readString();
          AppMethodBeat.o(32573);
          return 0;
        }
        localfqp.score = locala.abFh.AK();
        AppMethodBeat.o(32573);
        return 0;
      }
      AppMethodBeat.o(32573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqp
 * JD-Core Version:    0.7.0.1
 */