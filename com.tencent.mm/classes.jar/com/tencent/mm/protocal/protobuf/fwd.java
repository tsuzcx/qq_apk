package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fwd
  extends com.tencent.mm.bx.a
{
  public long YFU;
  public String psE;
  public String psp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152721);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.psp == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.psE == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_ticket");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.psp != null) {
        paramVarArgs.g(1, this.psp);
      }
      if (this.psE != null) {
        paramVarArgs.g(2, this.psE);
      }
      paramVarArgs.bv(3, this.YFU);
      AppMethodBeat.o(152721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.psp == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = i.a.a.b.b.a.h(1, this.psp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.psE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.psE);
      }
      paramInt = i.a.a.b.b.a.q(3, this.YFU);
      AppMethodBeat.o(152721);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.psp == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        if (this.psE == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_ticket");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152721);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fwd localfwd = (fwd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152721);
          return -1;
        case 1: 
          localfwd.psp = locala.ajGk.readString();
          AppMethodBeat.o(152721);
          return 0;
        case 2: 
          localfwd.psE = locala.ajGk.readString();
          AppMethodBeat.o(152721);
          return 0;
        }
        localfwd.YFU = locala.ajGk.aaw();
        AppMethodBeat.o(152721);
        return 0;
      }
      AppMethodBeat.o(152721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwd
 * JD-Core Version:    0.7.0.1
 */