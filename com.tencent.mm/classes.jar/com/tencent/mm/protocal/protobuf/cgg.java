package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgg
  extends com.tencent.mm.bv.a
{
  public String xQX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94630);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQX != null) {
        paramVarArgs.e(1, this.xQX);
      }
      AppMethodBeat.o(94630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xQX == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.xQX) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(94630);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94630);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cgg localcgg = (cgg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94630);
          return -1;
        }
        localcgg.xQX = locala.CLY.readString();
        AppMethodBeat.o(94630);
        return 0;
      }
      AppMethodBeat.o(94630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgg
 * JD-Core Version:    0.7.0.1
 */