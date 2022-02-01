package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boc
  extends com.tencent.mm.bx.a
{
  public long ZWv;
  public int ZWw;
  public String mdQ;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258484);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.mdQ != null) {
        paramVarArgs.g(3, this.mdQ);
      }
      paramVarArgs.bv(4, this.ZWv);
      paramVarArgs.bS(5, this.ZWw);
      AppMethodBeat.o(258484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label422;
      }
    }
    label422:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.mdQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdQ);
      }
      paramInt = i.a.a.b.b.a.q(4, this.ZWv);
      int j = i.a.a.b.b.a.cJ(5, this.ZWw);
      AppMethodBeat.o(258484);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258484);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        boc localboc = (boc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258484);
          return -1;
        case 1: 
          localboc.username = locala.ajGk.readString();
          AppMethodBeat.o(258484);
          return 0;
        case 2: 
          localboc.nickname = locala.ajGk.readString();
          AppMethodBeat.o(258484);
          return 0;
        case 3: 
          localboc.mdQ = locala.ajGk.readString();
          AppMethodBeat.o(258484);
          return 0;
        case 4: 
          localboc.ZWv = locala.ajGk.aaw();
          AppMethodBeat.o(258484);
          return 0;
        }
        localboc.ZWw = locala.ajGk.aar();
        AppMethodBeat.o(258484);
        return 0;
      }
      AppMethodBeat.o(258484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boc
 * JD-Core Version:    0.7.0.1
 */