package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjd
  extends com.tencent.mm.cd.a
{
  public String Bvd;
  public int Bve;
  public String authIconUrl;
  public String avatar;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204621);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.f(3, this.avatar);
      }
      if (this.Bvd != null) {
        paramVarArgs.f(4, this.Bvd);
      }
      paramVarArgs.aY(5, this.Bve);
      if (this.authIconUrl != null) {
        paramVarArgs.f(6, this.authIconUrl);
      }
      AppMethodBeat.o(204621);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.avatar);
      }
      paramInt = i;
      if (this.Bvd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Bvd);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Bve);
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.authIconUrl);
      }
      AppMethodBeat.o(204621);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204621);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bjd localbjd = (bjd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(204621);
          return -1;
        case 1: 
          localbjd.username = locala.abFh.readString();
          AppMethodBeat.o(204621);
          return 0;
        case 2: 
          localbjd.nickname = locala.abFh.readString();
          AppMethodBeat.o(204621);
          return 0;
        case 3: 
          localbjd.avatar = locala.abFh.readString();
          AppMethodBeat.o(204621);
          return 0;
        case 4: 
          localbjd.Bvd = locala.abFh.readString();
          AppMethodBeat.o(204621);
          return 0;
        case 5: 
          localbjd.Bve = locala.abFh.AK();
          AppMethodBeat.o(204621);
          return 0;
        }
        localbjd.authIconUrl = locala.abFh.readString();
        AppMethodBeat.o(204621);
        return 0;
      }
      AppMethodBeat.o(204621);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjd
 * JD-Core Version:    0.7.0.1
 */