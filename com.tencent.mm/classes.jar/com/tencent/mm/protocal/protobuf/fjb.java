package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fjb
  extends com.tencent.mm.cd.a
{
  public String SaD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32520);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SaD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32520);
        throw paramVarArgs;
      }
      if (this.SaD != null) {
        paramVarArgs.f(1, this.SaD);
      }
      AppMethodBeat.o(32520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SaD == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = g.a.a.b.b.a.g(1, this.SaD) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SaD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32520);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32520);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fjb localfjb = (fjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32520);
          return -1;
        }
        localfjb.SaD = locala.abFh.readString();
        AppMethodBeat.o(32520);
        return 0;
      }
      AppMethodBeat.o(32520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjb
 * JD-Core Version:    0.7.0.1
 */