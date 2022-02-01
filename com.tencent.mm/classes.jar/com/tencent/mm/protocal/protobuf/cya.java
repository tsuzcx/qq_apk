package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cya
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String icon;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91516);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      AppMethodBeat.o(91516);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      AppMethodBeat.o(91516);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91516);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cya localcya = (cya)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91516);
          return -1;
        case 1: 
          localcya.title = locala.ajGk.readString();
          AppMethodBeat.o(91516);
          return 0;
        case 2: 
          localcya.desc = locala.ajGk.readString();
          AppMethodBeat.o(91516);
          return 0;
        case 3: 
          localcya.icon = locala.ajGk.readString();
          AppMethodBeat.o(91516);
          return 0;
        }
        localcya.url = locala.ajGk.readString();
        AppMethodBeat.o(91516);
        return 0;
      }
      AppMethodBeat.o(91516);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */