package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fls
  extends com.tencent.mm.bx.a
{
  public String abMk;
  public int port;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abMk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ip_str");
        AppMethodBeat.o(32461);
        throw paramVarArgs;
      }
      if (this.abMk != null) {
        paramVarArgs.g(1, this.abMk);
      }
      paramVarArgs.bS(2, this.port);
      AppMethodBeat.o(32461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abMk == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.abMk) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.port);
      AppMethodBeat.o(32461);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abMk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ip_str");
          AppMethodBeat.o(32461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32461);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fls localfls = (fls)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32461);
          return -1;
        case 1: 
          localfls.abMk = locala.ajGk.readString();
          AppMethodBeat.o(32461);
          return 0;
        }
        localfls.port = locala.ajGk.aar();
        AppMethodBeat.o(32461);
        return 0;
      }
      AppMethodBeat.o(32461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fls
 * JD-Core Version:    0.7.0.1
 */