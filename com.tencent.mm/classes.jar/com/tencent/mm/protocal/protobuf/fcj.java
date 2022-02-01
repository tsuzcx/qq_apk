package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcj
  extends com.tencent.mm.bx.a
{
  public int YQB;
  public int aaJu;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153304);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.aaJu);
      paramVarArgs.bS(3, this.YQB);
      AppMethodBeat.o(153304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaJu);
      int j = i.a.a.b.b.a.cJ(3, this.YQB);
      AppMethodBeat.o(153304);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153304);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fcj localfcj = (fcj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153304);
          return -1;
        case 1: 
          localfcj.username = locala.ajGk.readString();
          AppMethodBeat.o(153304);
          return 0;
        case 2: 
          localfcj.aaJu = locala.ajGk.aar();
          AppMethodBeat.o(153304);
          return 0;
        }
        localfcj.YQB = locala.ajGk.aar();
        AppMethodBeat.o(153304);
        return 0;
      }
      AppMethodBeat.o(153304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcj
 * JD-Core Version:    0.7.0.1
 */