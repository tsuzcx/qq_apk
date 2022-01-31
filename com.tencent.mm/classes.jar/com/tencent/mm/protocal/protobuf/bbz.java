package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbz
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String opC;
  public String opD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48884);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cyA != null) {
        paramVarArgs.e(1, this.cyA);
      }
      if (this.opC != null) {
        paramVarArgs.e(2, this.opC);
      }
      if (this.opD != null) {
        paramVarArgs.e(4, this.opD);
      }
      AppMethodBeat.o(48884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cyA == null) {
        break label338;
      }
    }
    label338:
    for (int i = e.a.a.b.b.a.f(1, this.cyA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.opC != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.opC);
      }
      i = paramInt;
      if (this.opD != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.opD);
      }
      AppMethodBeat.o(48884);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48884);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bbz localbbz = (bbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(48884);
          return -1;
        case 1: 
          localbbz.cyA = locala.CLY.readString();
          AppMethodBeat.o(48884);
          return 0;
        case 2: 
          localbbz.opC = locala.CLY.readString();
          AppMethodBeat.o(48884);
          return 0;
        }
        localbbz.opD = locala.CLY.readString();
        AppMethodBeat.o(48884);
        return 0;
      }
      AppMethodBeat.o(48884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbz
 * JD-Core Version:    0.7.0.1
 */