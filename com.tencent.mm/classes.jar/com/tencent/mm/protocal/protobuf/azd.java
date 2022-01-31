package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azd
  extends com.tencent.mm.bv.a
{
  public String value;
  public String xoz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(851);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xoz != null) {
        paramVarArgs.e(1, this.xoz);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      AppMethodBeat.o(851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xoz == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.xoz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.value);
      }
      AppMethodBeat.o(851);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(851);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        azd localazd = (azd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(851);
          return -1;
        case 1: 
          localazd.xoz = locala.CLY.readString();
          AppMethodBeat.o(851);
          return 0;
        }
        localazd.value = locala.CLY.readString();
        AppMethodBeat.o(851);
        return 0;
      }
      AppMethodBeat.o(851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azd
 * JD-Core Version:    0.7.0.1
 */