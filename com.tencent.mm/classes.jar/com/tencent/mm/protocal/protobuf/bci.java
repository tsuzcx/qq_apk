package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bci
  extends com.tencent.mm.bw.a
{
  public String authIconUrl;
  public String nickname;
  public String uNR;
  public String username;
  public String wDX;
  public int wDY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196093);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.uNR != null) {
        paramVarArgs.e(3, this.uNR);
      }
      if (this.wDX != null) {
        paramVarArgs.e(4, this.wDX);
      }
      paramVarArgs.aM(5, this.wDY);
      if (this.authIconUrl != null) {
        paramVarArgs.e(6, this.authIconUrl);
      }
      AppMethodBeat.o(196093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.uNR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.uNR);
      }
      paramInt = i;
      if (this.wDX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.wDX);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.wDY);
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.authIconUrl);
      }
      AppMethodBeat.o(196093);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196093);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bci localbci = (bci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196093);
          return -1;
        case 1: 
          localbci.username = locala.UbS.readString();
          AppMethodBeat.o(196093);
          return 0;
        case 2: 
          localbci.nickname = locala.UbS.readString();
          AppMethodBeat.o(196093);
          return 0;
        case 3: 
          localbci.uNR = locala.UbS.readString();
          AppMethodBeat.o(196093);
          return 0;
        case 4: 
          localbci.wDX = locala.UbS.readString();
          AppMethodBeat.o(196093);
          return 0;
        case 5: 
          localbci.wDY = locala.UbS.zi();
          AppMethodBeat.o(196093);
          return 0;
        }
        localbci.authIconUrl = locala.UbS.readString();
        AppMethodBeat.o(196093);
        return 0;
      }
      AppMethodBeat.o(196093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bci
 * JD-Core Version:    0.7.0.1
 */