package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
  extends com.tencent.mm.bx.a
{
  public String NkS;
  public String nickname;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267029);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.NkS != null) {
        paramVarArgs.g(2, this.NkS);
      }
      paramVarArgs.bv(3, this.uin);
      AppMethodBeat.o(267029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NkS != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.NkS);
      }
      paramInt = i.a.a.b.b.a.q(3, this.uin);
      AppMethodBeat.o(267029);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267029);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(267029);
          return -1;
        case 1: 
          localak.nickname = locala.ajGk.readString();
          AppMethodBeat.o(267029);
          return 0;
        case 2: 
          localak.NkS = locala.ajGk.readString();
          AppMethodBeat.o(267029);
          return 0;
        }
        localak.uin = locala.ajGk.aaw();
        AppMethodBeat.o(267029);
        return 0;
      }
      AppMethodBeat.o(267029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ak
 * JD-Core Version:    0.7.0.1
 */