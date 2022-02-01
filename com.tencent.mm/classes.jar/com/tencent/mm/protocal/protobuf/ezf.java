package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezf
  extends com.tencent.mm.bw.a
{
  public long MKf;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32547);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32547);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.bb(2, this.MKf);
      AppMethodBeat.o(32547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.MKf);
      AppMethodBeat.o(32547);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32547);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32547);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezf localezf = (ezf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32547);
          return -1;
        case 1: 
          localezf.Username = locala.UbS.readString();
          AppMethodBeat.o(32547);
          return 0;
        }
        localezf.MKf = locala.UbS.zl();
        AppMethodBeat.o(32547);
        return 0;
      }
      AppMethodBeat.o(32547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezf
 * JD-Core Version:    0.7.0.1
 */