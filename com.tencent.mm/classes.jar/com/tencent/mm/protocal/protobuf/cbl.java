package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbl
  extends com.tencent.mm.bx.a
{
  public String aakK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42647);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aakK != null) {
        paramVarArgs.g(1, this.aakK);
      }
      AppMethodBeat.o(42647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aakK == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.aakK) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(42647);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(42647);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbl localcbl = (cbl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42647);
          return -1;
        }
        localcbl.aakK = locala.ajGk.readString();
        AppMethodBeat.o(42647);
        return 0;
      }
      AppMethodBeat.o(42647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbl
 * JD-Core Version:    0.7.0.1
 */