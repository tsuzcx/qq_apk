package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baf
  extends com.tencent.mm.bv.a
{
  public String wvA;
  public String wvB;
  public String wvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60043);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvA != null) {
        paramVarArgs.e(1, this.wvA);
      }
      if (this.wvz != null) {
        paramVarArgs.e(2, this.wvz);
      }
      if (this.wvB != null) {
        paramVarArgs.e(3, this.wvB);
      }
      AppMethodBeat.o(60043);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wvA == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.wvA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvz != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wvz);
      }
      i = paramInt;
      if (this.wvB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvB);
      }
      AppMethodBeat.o(60043);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60043);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        baf localbaf = (baf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60043);
          return -1;
        case 1: 
          localbaf.wvA = locala.CLY.readString();
          AppMethodBeat.o(60043);
          return 0;
        case 2: 
          localbaf.wvz = locala.CLY.readString();
          AppMethodBeat.o(60043);
          return 0;
        }
        localbaf.wvB = locala.CLY.readString();
        AppMethodBeat.o(60043);
        return 0;
      }
      AppMethodBeat.o(60043);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baf
 * JD-Core Version:    0.7.0.1
 */