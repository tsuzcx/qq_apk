package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gge
  extends com.tencent.mm.bx.a
{
  public int IIs;
  public String Nickname;
  public long YKn;
  public long YKx;
  public String abvu;
  public boolean accT;
  public com.tencent.mm.bx.b accU;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Nickname == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.YKx);
      if (this.Nickname != null) {
        paramVarArgs.g(2, this.Nickname);
      }
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      paramVarArgs.bS(4, this.IIs);
      if (this.abvu != null) {
        paramVarArgs.g(5, this.abvu);
      }
      paramVarArgs.bv(6, this.YKn);
      paramVarArgs.di(7, this.accT);
      if (this.accU != null) {
        paramVarArgs.d(8, this.accU);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YKx) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Nickname);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      i += i.a.a.b.b.a.cJ(4, this.IIs);
      paramInt = i;
      if (this.abvu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abvu);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.YKn) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.accU != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.accU);
      }
      AppMethodBeat.o(32539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gge localgge = (gge)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localgge.YKx = locala.ajGk.aaw();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localgge.Nickname = locala.ajGk.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localgge.nUB = locala.ajGk.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localgge.IIs = locala.ajGk.aar();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localgge.abvu = locala.ajGk.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localgge.YKn = locala.ajGk.aaw();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localgge.accT = locala.ajGk.aai();
        AppMethodBeat.o(32539);
        return 0;
      }
      localgge.accU = locala.ajGk.kFX();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gge
 * JD-Core Version:    0.7.0.1
 */