package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajd
  extends com.tencent.mm.bv.a
{
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124317);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      AppMethodBeat.o(124317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(124317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124317);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ajd localajd = (ajd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124317);
          return -1;
        }
        localajd.Username = locala.CLY.readString();
        AppMethodBeat.o(124317);
        return 0;
      }
      AppMethodBeat.o(124317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajd
 * JD-Core Version:    0.7.0.1
 */