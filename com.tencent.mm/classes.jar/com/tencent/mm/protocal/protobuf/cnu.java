package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cnu
  extends com.tencent.mm.bx.a
{
  public String CLI;
  public long DYU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(117911);
        throw paramVarArgs;
      }
      if (this.CLI != null) {
        paramVarArgs.d(1, this.CLI);
      }
      paramVarArgs.aG(2, this.DYU);
      AppMethodBeat.o(117911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLI == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.CLI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.DYU);
      AppMethodBeat.o(117911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CLI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(117911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117911);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnu localcnu = (cnu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117911);
          return -1;
        case 1: 
          localcnu.CLI = locala.KhF.readString();
          AppMethodBeat.o(117911);
          return 0;
        }
        localcnu.DYU = locala.KhF.xT();
        AppMethodBeat.o(117911);
        return 0;
      }
      AppMethodBeat.o(117911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnu
 * JD-Core Version:    0.7.0.1
 */