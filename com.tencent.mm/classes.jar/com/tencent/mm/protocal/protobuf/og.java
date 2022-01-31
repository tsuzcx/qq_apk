package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class og
  extends com.tencent.mm.bv.a
{
  public String wDI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94512);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wDI != null) {
        paramVarArgs.e(1, this.wDI);
      }
      AppMethodBeat.o(94512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDI == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.wDI) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(94512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94512);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94512);
          return -1;
        }
        localog.wDI = locala.CLY.readString();
        AppMethodBeat.o(94512);
        return 0;
      }
      AppMethodBeat.o(94512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */