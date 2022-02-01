package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eey
  extends com.tencent.mm.cd.a
{
  public boolean OAd;
  public String nickname;
  public String oDV;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.co(2, this.OAd);
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.oDV != null) {
        paramVarArgs.f(4, this.oDV);
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
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.nickname);
      }
      i = paramInt;
      if (this.oDV != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.oDV);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eey localeey = (eey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localeey.username = locala.abFh.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localeey.OAd = locala.abFh.AB();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localeey.nickname = locala.abFh.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localeey.oDV = locala.abFh.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eey
 * JD-Core Version:    0.7.0.1
 */