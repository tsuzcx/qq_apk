package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpl
  extends com.tencent.mm.bx.a
{
  public String app_id;
  public String icon_url;
  public String path;
  public String xkX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258004);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.xkX != null) {
        paramVarArgs.g(3, this.xkX);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      AppMethodBeat.o(258004);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.xkX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xkX);
      }
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon_url);
      }
      AppMethodBeat.o(258004);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258004);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bpl localbpl = (bpl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258004);
          return -1;
        case 1: 
          localbpl.app_id = locala.ajGk.readString();
          AppMethodBeat.o(258004);
          return 0;
        case 2: 
          localbpl.path = locala.ajGk.readString();
          AppMethodBeat.o(258004);
          return 0;
        case 3: 
          localbpl.xkX = locala.ajGk.readString();
          AppMethodBeat.o(258004);
          return 0;
        }
        localbpl.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(258004);
        return 0;
      }
      AppMethodBeat.o(258004);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpl
 * JD-Core Version:    0.7.0.1
 */