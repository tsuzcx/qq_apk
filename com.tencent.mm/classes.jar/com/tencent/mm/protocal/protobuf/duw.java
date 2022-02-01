package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duw
  extends com.tencent.mm.bw.a
{
  public boolean HIl;
  public String lHM;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.cc(2, this.HIl);
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.lHM != null) {
        paramVarArgs.e(4, this.lHM);
      }
      AppMethodBeat.o(153296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nickname);
      }
      i = paramInt;
      if (this.lHM != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.lHM);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        duw localduw = (duw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localduw.username = locala.UbS.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localduw.HIl = locala.UbS.yZ();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localduw.nickname = locala.UbS.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localduw.lHM = locala.UbS.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duw
 * JD-Core Version:    0.7.0.1
 */