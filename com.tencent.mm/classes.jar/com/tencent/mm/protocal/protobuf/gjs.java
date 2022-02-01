package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjs
  extends com.tencent.mm.bx.a
{
  public int aaJu;
  public String appid;
  public int xlL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258227);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.bS(2, this.xlL);
      paramVarArgs.bS(3, this.aaJu);
      AppMethodBeat.o(258227);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.xlL);
      int j = i.a.a.b.b.a.cJ(3, this.aaJu);
      AppMethodBeat.o(258227);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258227);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjs localgjs = (gjs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258227);
          return -1;
        case 1: 
          localgjs.appid = locala.ajGk.readString();
          AppMethodBeat.o(258227);
          return 0;
        case 2: 
          localgjs.xlL = locala.ajGk.aar();
          AppMethodBeat.o(258227);
          return 0;
        }
        localgjs.aaJu = locala.ajGk.aar();
        AppMethodBeat.o(258227);
        return 0;
      }
      AppMethodBeat.o(258227);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjs
 * JD-Core Version:    0.7.0.1
 */