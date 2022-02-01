package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fjk
  extends com.tencent.mm.cd.a
{
  public boolean UIG;
  public String Username;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32532);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.vhq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      if (this.vhq != null) {
        paramVarArgs.f(2, this.vhq);
      }
      paramVarArgs.co(3, this.UIG);
      AppMethodBeat.o(32532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = g.a.a.b.b.a.g(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.vhq);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(32532);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        if (this.vhq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Language");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32532);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fjk localfjk = (fjk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32532);
          return -1;
        case 1: 
          localfjk.Username = locala.abFh.readString();
          AppMethodBeat.o(32532);
          return 0;
        case 2: 
          localfjk.vhq = locala.abFh.readString();
          AppMethodBeat.o(32532);
          return 0;
        }
        localfjk.UIG = locala.abFh.AB();
        AppMethodBeat.o(32532);
        return 0;
      }
      AppMethodBeat.o(32532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjk
 * JD-Core Version:    0.7.0.1
 */