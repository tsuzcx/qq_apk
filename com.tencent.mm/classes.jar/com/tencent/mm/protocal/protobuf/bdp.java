package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdp
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String wJp;
  public String wot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5596);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wot != null) {
        paramVarArgs.e(1, this.wot);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.wJp != null) {
        paramVarArgs.e(3, this.wJp);
      }
      AppMethodBeat.o(5596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wot == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.wot) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.wJp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJp);
      }
      AppMethodBeat.o(5596);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5596);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdp localbdp = (bdp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(5596);
          return -1;
        case 1: 
          localbdp.wot = locala.CLY.readString();
          AppMethodBeat.o(5596);
          return 0;
        case 2: 
          localbdp.jJA = locala.CLY.readString();
          AppMethodBeat.o(5596);
          return 0;
        }
        localbdp.wJp = locala.CLY.readString();
        AppMethodBeat.o(5596);
        return 0;
      }
      AppMethodBeat.o(5596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdp
 * JD-Core Version:    0.7.0.1
 */