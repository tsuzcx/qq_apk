package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzw
  extends com.tencent.mm.bv.a
{
  public String nickname;
  public String username;
  public boolean xLw;
  public String xeE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114983);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aS(2, this.xLw);
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.xeE != null) {
        paramVarArgs.e(4, this.xeE);
      }
      AppMethodBeat.o(114983);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nickname);
      }
      i = paramInt;
      if (this.xeE != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xeE);
      }
      AppMethodBeat.o(114983);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114983);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bzw localbzw = (bzw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114983);
          return -1;
        case 1: 
          localbzw.username = locala.CLY.readString();
          AppMethodBeat.o(114983);
          return 0;
        case 2: 
          localbzw.xLw = locala.CLY.emu();
          AppMethodBeat.o(114983);
          return 0;
        case 3: 
          localbzw.nickname = locala.CLY.readString();
          AppMethodBeat.o(114983);
          return 0;
        }
        localbzw.xeE = locala.CLY.readString();
        AppMethodBeat.o(114983);
        return 0;
      }
      AppMethodBeat.o(114983);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzw
 * JD-Core Version:    0.7.0.1
 */