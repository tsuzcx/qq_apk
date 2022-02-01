package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfm
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int vhJ;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32517);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.vhX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      paramVarArgs.bS(3, this.vhJ);
      AppMethodBeat.o(32517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label423;
      }
    }
    label423:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.vhX);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhJ);
      AppMethodBeat.o(32517);
      return i + paramInt;
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
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        if (this.vhX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32517);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfm localgfm = (gfm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32517);
          return -1;
        case 1: 
          localgfm.UserName = locala.ajGk.readString();
          AppMethodBeat.o(32517);
          return 0;
        case 2: 
          localgfm.vhX = locala.ajGk.readString();
          AppMethodBeat.o(32517);
          return 0;
        }
        localgfm.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(32517);
        return 0;
      }
      AppMethodBeat.o(32517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfm
 * JD-Core Version:    0.7.0.1
 */