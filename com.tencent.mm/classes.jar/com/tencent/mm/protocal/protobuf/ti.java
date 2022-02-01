package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ti
  extends com.tencent.mm.bx.a
{
  public String Kmn;
  public int Tqb;
  public String YYY;
  public String appid;
  public String nickname;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.Kmn != null) {
        paramVarArgs.g(3, this.Kmn);
      }
      if (this.nickname != null) {
        paramVarArgs.g(4, this.nickname);
      }
      paramVarArgs.bS(5, this.Tqb);
      if (this.YYY != null) {
        paramVarArgs.g(6, this.YYY);
      }
      paramVarArgs.bS(7, this.version);
      AppMethodBeat.o(56244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label542;
      }
    }
    label542:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.Kmn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Kmn);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nickname);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Tqb);
      paramInt = i;
      if (this.YYY != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YYY);
      }
      i = i.a.a.b.b.a.cJ(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localti.username = locala.ajGk.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localti.appid = locala.ajGk.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localti.Kmn = locala.ajGk.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localti.nickname = locala.ajGk.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localti.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localti.YYY = locala.ajGk.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localti.version = locala.ajGk.aar();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */