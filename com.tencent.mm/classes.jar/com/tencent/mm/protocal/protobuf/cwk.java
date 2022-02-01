package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cwk
  extends com.tencent.mm.bw.a
{
  public int ret;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127173);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(127173);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.ret);
      AppMethodBeat.o(127173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.ret);
      AppMethodBeat.o(127173);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwk localcwk = (cwk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127173);
          return -1;
        case 1: 
          localcwk.username = locala.OmT.readString();
          AppMethodBeat.o(127173);
          return 0;
        }
        localcwk.ret = locala.OmT.zc();
        AppMethodBeat.o(127173);
        return 0;
      }
      AppMethodBeat.o(127173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwk
 * JD-Core Version:    0.7.0.1
 */