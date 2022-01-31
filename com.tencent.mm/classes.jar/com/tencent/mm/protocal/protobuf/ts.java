package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ts
  extends com.tencent.mm.bv.a
{
  public double latitude;
  public double longitude;
  public String wMo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134426);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wMo != null) {
        paramVarArgs.e(1, this.wMo);
      }
      paramVarArgs.f(2, this.longitude);
      paramVarArgs.f(3, this.latitude);
      AppMethodBeat.o(134426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wMo == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = e.a.a.b.b.a.f(1, this.wMo) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(134426);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134426);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ts localts = (ts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134426);
          return -1;
        case 1: 
          localts.wMo = locala.CLY.readString();
          AppMethodBeat.o(134426);
          return 0;
        case 2: 
          localts.longitude = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(134426);
          return 0;
        }
        localts.latitude = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(134426);
        return 0;
      }
      AppMethodBeat.o(134426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ts
 * JD-Core Version:    0.7.0.1
 */