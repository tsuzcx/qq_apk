package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aka
  extends com.tencent.mm.bx.a
{
  public String Zrf;
  public int Zrg;
  public String appid;
  public String nickname;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258367);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.Zrf != null) {
        paramVarArgs.g(3, this.Zrf);
      }
      if (this.nickname != null) {
        paramVarArgs.g(4, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.g(5, this.username);
      }
      paramVarArgs.bS(6, this.Zrg);
      AppMethodBeat.o(258367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.Zrf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zrf);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nickname);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.username);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.Zrg);
      AppMethodBeat.o(258367);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258367);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aka localaka = (aka)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258367);
          return -1;
        case 1: 
          localaka.appid = locala.ajGk.readString();
          AppMethodBeat.o(258367);
          return 0;
        case 2: 
          localaka.path = locala.ajGk.readString();
          AppMethodBeat.o(258367);
          return 0;
        case 3: 
          localaka.Zrf = locala.ajGk.readString();
          AppMethodBeat.o(258367);
          return 0;
        case 4: 
          localaka.nickname = locala.ajGk.readString();
          AppMethodBeat.o(258367);
          return 0;
        case 5: 
          localaka.username = locala.ajGk.readString();
          AppMethodBeat.o(258367);
          return 0;
        }
        localaka.Zrg = locala.ajGk.aar();
        AppMethodBeat.o(258367);
        return 0;
      }
      AppMethodBeat.o(258367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aka
 * JD-Core Version:    0.7.0.1
 */