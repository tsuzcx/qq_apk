package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gfu
  extends com.tencent.mm.bx.a
{
  public int IMf;
  public String UserName;
  public com.tencent.mm.bx.b accH;
  public String nUB;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.vhX == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.IMf);
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.nUB != null) {
        paramVarArgs.g(4, this.nUB);
      }
      if (this.accH != null) {
        paramVarArgs.d(5, this.accH);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IMf) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUB);
      }
      i = paramInt;
      if (this.accH != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.accH);
      }
      AppMethodBeat.o(32527);
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
      if (this.UserName == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.vhX == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gfu localgfu = (gfu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localgfu.IMf = locala.ajGk.aar();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localgfu.UserName = locala.ajGk.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localgfu.vhX = locala.ajGk.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localgfu.nUB = locala.ajGk.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localgfu.accH = locala.ajGk.kFX();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfu
 * JD-Core Version:    0.7.0.1
 */