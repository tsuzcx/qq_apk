package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tk
  extends com.tencent.mm.bx.a
{
  public String icon;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32152);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      AppMethodBeat.o(32152);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label339;
      }
    }
    label339:
    for (int i = i.a.a.b.b.a.h(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      AppMethodBeat.o(32152);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32152);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        tk localtk = (tk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32152);
          return -1;
        case 1: 
          localtk.url = locala.ajGk.readString();
          AppMethodBeat.o(32152);
          return 0;
        case 2: 
          localtk.title = locala.ajGk.readString();
          AppMethodBeat.o(32152);
          return 0;
        }
        localtk.icon = locala.ajGk.readString();
        AppMethodBeat.o(32152);
        return 0;
      }
      AppMethodBeat.o(32152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tk
 * JD-Core Version:    0.7.0.1
 */