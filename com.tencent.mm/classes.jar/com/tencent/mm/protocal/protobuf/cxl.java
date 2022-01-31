package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxl
  extends com.tencent.mm.bv.a
{
  public String Username;
  public long xCj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28748);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(28748);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.am(2, this.xCj);
      AppMethodBeat.o(28748);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xCj);
      AppMethodBeat.o(28748);
      return paramInt + i;
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
          AppMethodBeat.o(28748);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28748);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxl localcxl = (cxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28748);
          return -1;
        case 1: 
          localcxl.Username = locala.CLY.readString();
          AppMethodBeat.o(28748);
          return 0;
        }
        localcxl.xCj = locala.CLY.sm();
        AppMethodBeat.o(28748);
        return 0;
      }
      AppMethodBeat.o(28748);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxl
 * JD-Core Version:    0.7.0.1
 */