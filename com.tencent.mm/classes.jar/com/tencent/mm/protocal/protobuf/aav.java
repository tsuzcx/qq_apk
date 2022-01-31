package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class aav
  extends com.tencent.mm.bv.a
{
  public String wRk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28397);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wRk == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(28397);
        throw paramVarArgs;
      }
      if (this.wRk != null) {
        paramVarArgs.e(1, this.wRk);
      }
      AppMethodBeat.o(28397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wRk == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = e.a.a.b.b.a.f(1, this.wRk) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(28397);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wRk == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(28397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28397);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aav localaav = (aav)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28397);
          return -1;
        }
        localaav.wRk = locala.CLY.readString();
        AppMethodBeat.o(28397);
        return 0;
      }
      AppMethodBeat.o(28397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aav
 * JD-Core Version:    0.7.0.1
 */