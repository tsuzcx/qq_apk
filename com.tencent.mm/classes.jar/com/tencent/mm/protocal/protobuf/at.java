package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public String wmD;
  public String wmE;
  public String wmF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94489);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      if (this.wmD != null) {
        paramVarArgs.e(2, this.wmD);
      }
      if (this.wmE != null) {
        paramVarArgs.e(3, this.wmE);
      }
      if (this.wmF != null) {
        paramVarArgs.e(4, this.wmF);
      }
      AppMethodBeat.o(94489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.fKw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wmD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wmD);
      }
      i = paramInt;
      if (this.wmE != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wmE);
      }
      paramInt = i;
      if (this.wmF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wmF);
      }
      AppMethodBeat.o(94489);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94489);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94489);
          return -1;
        case 1: 
          localat.fKw = locala.CLY.readString();
          AppMethodBeat.o(94489);
          return 0;
        case 2: 
          localat.wmD = locala.CLY.readString();
          AppMethodBeat.o(94489);
          return 0;
        case 3: 
          localat.wmE = locala.CLY.readString();
          AppMethodBeat.o(94489);
          return 0;
        }
        localat.wmF = locala.CLY.readString();
        AppMethodBeat.o(94489);
        return 0;
      }
      AppMethodBeat.o(94489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.at
 * JD-Core Version:    0.7.0.1
 */