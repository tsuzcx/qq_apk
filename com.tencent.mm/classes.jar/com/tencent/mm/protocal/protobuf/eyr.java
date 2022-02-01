package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyr
  extends com.tencent.mm.bx.a
{
  public boolean Vpm;
  public String nickname;
  public String rHi;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153296);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.di(2, this.Vpm);
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.rHi != null) {
        paramVarArgs.g(4, this.rHi);
      }
      AppMethodBeat.o(153296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nickname);
      }
      i = paramInt;
      if (this.rHi != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.rHi);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eyr localeyr = (eyr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localeyr.username = locala.ajGk.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localeyr.Vpm = locala.ajGk.aai();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localeyr.nickname = locala.ajGk.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localeyr.rHi = locala.ajGk.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyr
 * JD-Core Version:    0.7.0.1
 */