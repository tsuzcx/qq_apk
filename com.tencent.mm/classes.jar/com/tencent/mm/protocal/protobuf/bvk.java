package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvk
  extends com.tencent.mm.bx.a
{
  public String HbX;
  public int HbY;
  public String authIconUrl;
  public String avatar;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258989);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(3, this.avatar);
      }
      if (this.HbX != null) {
        paramVarArgs.g(4, this.HbX);
      }
      paramVarArgs.bS(5, this.HbY);
      if (this.authIconUrl != null) {
        paramVarArgs.g(6, this.authIconUrl);
      }
      AppMethodBeat.o(258989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.avatar);
      }
      paramInt = i;
      if (this.HbX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.HbX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.HbY);
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.authIconUrl);
      }
      AppMethodBeat.o(258989);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258989);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bvk localbvk = (bvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258989);
          return -1;
        case 1: 
          localbvk.username = locala.ajGk.readString();
          AppMethodBeat.o(258989);
          return 0;
        case 2: 
          localbvk.nickname = locala.ajGk.readString();
          AppMethodBeat.o(258989);
          return 0;
        case 3: 
          localbvk.avatar = locala.ajGk.readString();
          AppMethodBeat.o(258989);
          return 0;
        case 4: 
          localbvk.HbX = locala.ajGk.readString();
          AppMethodBeat.o(258989);
          return 0;
        case 5: 
          localbvk.HbY = locala.ajGk.aar();
          AppMethodBeat.o(258989);
          return 0;
        }
        localbvk.authIconUrl = locala.ajGk.readString();
        AppMethodBeat.o(258989);
        return 0;
      }
      AppMethodBeat.o(258989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvk
 * JD-Core Version:    0.7.0.1
 */