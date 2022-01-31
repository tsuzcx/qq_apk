package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bv.a
{
  public String qiO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56658);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qiO != null) {
        paramVarArgs.e(1, this.qiO);
      }
      AppMethodBeat.o(56658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qiO == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.qiO) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(56658);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56658);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56658);
          return -1;
        }
        localo.qiO = locala.CLY.readString();
        AppMethodBeat.o(56658);
        return 0;
      }
      AppMethodBeat.o(56658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.o
 * JD-Core Version:    0.7.0.1
 */