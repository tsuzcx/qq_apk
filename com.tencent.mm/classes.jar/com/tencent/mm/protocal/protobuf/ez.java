package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ez
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wre;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28313);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wre == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Cookies");
        AppMethodBeat.o(28313);
        throw paramVarArgs;
      }
      if (this.wre != null) {
        paramVarArgs.c(1, this.wre);
      }
      AppMethodBeat.o(28313);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wre == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = e.a.a.b.b.a.b(1, this.wre) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(28313);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wre == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Cookies");
          AppMethodBeat.o(28313);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28313);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28313);
          return -1;
        }
        localez.wre = locala.CLY.eqS();
        AppMethodBeat.o(28313);
        return 0;
      }
      AppMethodBeat.o(28313);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */