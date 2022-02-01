package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class edg
  extends com.tencent.mm.bx.a
{
  public long HfW;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32547);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aY(2, this.HfW);
      AppMethodBeat.o(32547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HfW);
      AppMethodBeat.o(32547);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edg localedg = (edg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32547);
          return -1;
        case 1: 
          localedg.Username = locala.NPN.readString();
          AppMethodBeat.o(32547);
          return 0;
        }
        localedg.HfW = locala.NPN.zd();
        AppMethodBeat.o(32547);
        return 0;
      }
      AppMethodBeat.o(32547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edg
 * JD-Core Version:    0.7.0.1
 */