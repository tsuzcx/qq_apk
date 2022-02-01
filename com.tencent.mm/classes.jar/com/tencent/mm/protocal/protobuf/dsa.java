package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsa
  extends com.tencent.mm.bx.a
{
  public String aaXS;
  public String aaXT;
  public String aaXU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXS != null) {
        paramVarArgs.g(1, this.aaXS);
      }
      if (this.aaXT != null) {
        paramVarArgs.g(2, this.aaXT);
      }
      if (this.aaXU != null) {
        paramVarArgs.g(3, this.aaXU);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXS == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.aaXS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaXT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaXT);
      }
      i = paramInt;
      if (this.aaXU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaXU);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dsa localdsa = (dsa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localdsa.aaXS = locala.ajGk.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localdsa.aaXT = locala.ajGk.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localdsa.aaXU = locala.ajGk.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsa
 * JD-Core Version:    0.7.0.1
 */