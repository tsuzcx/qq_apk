package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ka
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public int wwH;
  public String wwI;
  public int wwJ;
  public int wwK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151360);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      paramVarArgs.aO(2, this.wwH);
      if (this.wwI != null) {
        paramVarArgs.e(3, this.wwI);
      }
      paramVarArgs.aO(4, this.wwJ);
      paramVarArgs.aO(5, this.wwK);
      AppMethodBeat.o(151360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wwH);
      paramInt = i;
      if (this.wwI != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wwI);
      }
      i = e.a.a.b.b.a.bl(4, this.wwJ);
      int j = e.a.a.b.b.a.bl(5, this.wwK);
      AppMethodBeat.o(151360);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151360);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ka localka = (ka)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151360);
          return -1;
        case 1: 
          localka.jJA = locala.CLY.readString();
          AppMethodBeat.o(151360);
          return 0;
        case 2: 
          localka.wwH = locala.CLY.sl();
          AppMethodBeat.o(151360);
          return 0;
        case 3: 
          localka.wwI = locala.CLY.readString();
          AppMethodBeat.o(151360);
          return 0;
        case 4: 
          localka.wwJ = locala.CLY.sl();
          AppMethodBeat.o(151360);
          return 0;
        }
        localka.wwK = locala.CLY.sl();
        AppMethodBeat.o(151360);
        return 0;
      }
      AppMethodBeat.o(151360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ka
 * JD-Core Version:    0.7.0.1
 */