package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aev
  extends com.tencent.mm.bv.a
{
  public String wXO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112435);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wXO != null) {
        paramVarArgs.e(1, this.wXO);
      }
      AppMethodBeat.o(112435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wXO == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.wXO) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(112435);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(112435);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aev localaev = (aev)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(112435);
          return -1;
        }
        localaev.wXO = locala.CLY.readString();
        AppMethodBeat.o(112435);
        return 0;
      }
      AppMethodBeat.o(112435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aev
 * JD-Core Version:    0.7.0.1
 */