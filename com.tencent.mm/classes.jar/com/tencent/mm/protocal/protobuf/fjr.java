package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fjr
  extends com.tencent.mm.cd.a
{
  public long TVZ;
  public boolean UIN;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32540);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      paramVarArgs.bm(2, this.TVZ);
      paramVarArgs.co(3, this.UIN);
      AppMethodBeat.o(32540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = g.a.a.b.b.a.g(1, this.Username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.TVZ);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(32540);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32540);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fjr localfjr = (fjr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32540);
          return -1;
        case 1: 
          localfjr.Username = locala.abFh.readString();
          AppMethodBeat.o(32540);
          return 0;
        case 2: 
          localfjr.TVZ = locala.abFh.AN();
          AppMethodBeat.o(32540);
          return 0;
        }
        localfjr.UIN = locala.abFh.AB();
        AppMethodBeat.o(32540);
        return 0;
      }
      AppMethodBeat.o(32540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjr
 * JD-Core Version:    0.7.0.1
 */