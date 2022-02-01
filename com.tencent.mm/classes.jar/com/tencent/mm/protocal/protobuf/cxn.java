package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxn
  extends com.tencent.mm.bx.a
{
  public String aaCU;
  public int aaCV;
  public int aaCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43097);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaCU != null) {
        paramVarArgs.g(1, this.aaCU);
      }
      paramVarArgs.bS(2, this.aaCV);
      paramVarArgs.bS(3, this.aaCW);
      AppMethodBeat.o(43097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaCU == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaCU) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaCV);
      int j = i.a.a.b.b.a.cJ(3, this.aaCW);
      AppMethodBeat.o(43097);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43097);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cxn localcxn = (cxn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43097);
          return -1;
        case 1: 
          localcxn.aaCU = locala.ajGk.readString();
          AppMethodBeat.o(43097);
          return 0;
        case 2: 
          localcxn.aaCV = locala.ajGk.aar();
          AppMethodBeat.o(43097);
          return 0;
        }
        localcxn.aaCW = locala.ajGk.aar();
        AppMethodBeat.o(43097);
        return 0;
      }
      AppMethodBeat.o(43097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxn
 * JD-Core Version:    0.7.0.1
 */