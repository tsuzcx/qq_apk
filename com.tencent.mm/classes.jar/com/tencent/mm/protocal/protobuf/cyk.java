package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyk
  extends com.tencent.mm.bx.a
{
  public String Kmn;
  public long aaDk;
  public long aaDl;
  public int aaDm;
  public String aaDn;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaDk);
      paramVarArgs.bv(2, this.aaDl);
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.Kmn != null) {
        paramVarArgs.g(4, this.Kmn);
      }
      paramVarArgs.bS(5, this.aaDm);
      if (this.username != null) {
        paramVarArgs.g(6, this.username);
      }
      if (this.aaDn != null) {
        paramVarArgs.g(7, this.aaDn);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaDk) + 0 + i.a.a.b.b.a.q(2, this.aaDl);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nickname);
      }
      i = paramInt;
      if (this.Kmn != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Kmn);
      }
      i += i.a.a.b.b.a.cJ(5, this.aaDm);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.username);
      }
      i = paramInt;
      if (this.aaDn != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaDn);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cyk localcyk = (cyk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localcyk.aaDk = locala.ajGk.aaw();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localcyk.aaDl = locala.ajGk.aaw();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localcyk.nickname = locala.ajGk.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localcyk.Kmn = locala.ajGk.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localcyk.aaDm = locala.ajGk.aar();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localcyk.username = locala.ajGk.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localcyk.aaDn = locala.ajGk.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyk
 * JD-Core Version:    0.7.0.1
 */