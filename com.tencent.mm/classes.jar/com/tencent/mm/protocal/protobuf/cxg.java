package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxg
  extends com.tencent.mm.bv.a
{
  public String Username;
  public long xCj;
  public boolean yeP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28741);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(28741);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.am(2, this.xCj);
      paramVarArgs.aS(3, this.yeP);
      AppMethodBeat.o(28741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xCj);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(28741);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(28741);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28741);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxg localcxg = (cxg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28741);
          return -1;
        case 1: 
          localcxg.Username = locala.CLY.readString();
          AppMethodBeat.o(28741);
          return 0;
        case 2: 
          localcxg.xCj = locala.CLY.sm();
          AppMethodBeat.o(28741);
          return 0;
        }
        localcxg.yeP = locala.CLY.emu();
        AppMethodBeat.o(28741);
        return 0;
      }
      AppMethodBeat.o(28741);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxg
 * JD-Core Version:    0.7.0.1
 */