package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwq
  extends com.tencent.mm.bv.a
{
  public String wCj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28721);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(28721);
        throw paramVarArgs;
      }
      if (this.wCj != null) {
        paramVarArgs.e(1, this.wCj);
      }
      AppMethodBeat.o(28721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wCj == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = e.a.a.b.b.a.f(1, this.wCj) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(28721);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wCj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(28721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28721);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwq localcwq = (cwq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28721);
          return -1;
        }
        localcwq.wCj = locala.CLY.readString();
        AppMethodBeat.o(28721);
        return 0;
      }
      AppMethodBeat.o(28721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwq
 * JD-Core Version:    0.7.0.1
 */