package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eli
  extends com.tencent.mm.bx.a
{
  public String abpR;
  public String abpS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133191);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abpR != null) {
        paramVarArgs.g(1, this.abpR);
      }
      if (this.abpS != null) {
        paramVarArgs.g(2, this.abpS);
      }
      AppMethodBeat.o(133191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abpR == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abpR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abpS != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abpS);
      }
      AppMethodBeat.o(133191);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133191);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eli localeli = (eli)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133191);
          return -1;
        case 1: 
          localeli.abpR = locala.ajGk.readString();
          AppMethodBeat.o(133191);
          return 0;
        }
        localeli.abpS = locala.ajGk.readString();
        AppMethodBeat.o(133191);
        return 0;
      }
      AppMethodBeat.o(133191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eli
 * JD-Core Version:    0.7.0.1
 */