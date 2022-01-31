package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arl
  extends com.tencent.mm.bv.a
{
  public String wys;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124318);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wys != null) {
        paramVarArgs.e(1, this.wys);
      }
      AppMethodBeat.o(124318);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wys == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.wys) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(124318);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124318);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        arl localarl = (arl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124318);
          return -1;
        }
        localarl.wys = locala.CLY.readString();
        AppMethodBeat.o(124318);
        return 0;
      }
      AppMethodBeat.o(124318);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */