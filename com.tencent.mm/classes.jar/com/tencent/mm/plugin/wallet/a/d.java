package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bv.a
{
  public String qiO;
  public int tTX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56645);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qiO != null) {
        paramVarArgs.e(1, this.qiO);
      }
      paramVarArgs.aO(2, this.tTX);
      AppMethodBeat.o(56645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qiO == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.qiO) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.tTX);
      AppMethodBeat.o(56645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56645);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56645);
          return -1;
        case 1: 
          locald.qiO = locala.CLY.readString();
          AppMethodBeat.o(56645);
          return 0;
        }
        locald.tTX = locala.CLY.sl();
        AppMethodBeat.o(56645);
        return 0;
      }
      AppMethodBeat.o(56645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.d
 * JD-Core Version:    0.7.0.1
 */