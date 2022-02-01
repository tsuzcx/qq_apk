package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bee
  extends com.tencent.mm.bx.a
{
  public String AzS;
  public String title;
  public String wording;
  public String wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(2, this.wsz);
      }
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      if (this.AzS != null) {
        paramVarArgs.g(4, this.AzS);
      }
      AppMethodBeat.o(258778);
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
      if (this.wsz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsz);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wording);
      }
      paramInt = i;
      if (this.AzS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.AzS);
      }
      AppMethodBeat.o(258778);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258778);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bee localbee = (bee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258778);
          return -1;
        case 1: 
          localbee.title = locala.ajGk.readString();
          AppMethodBeat.o(258778);
          return 0;
        case 2: 
          localbee.wsz = locala.ajGk.readString();
          AppMethodBeat.o(258778);
          return 0;
        case 3: 
          localbee.wording = locala.ajGk.readString();
          AppMethodBeat.o(258778);
          return 0;
        }
        localbee.AzS = locala.ajGk.readString();
        AppMethodBeat.o(258778);
        return 0;
      }
      AppMethodBeat.o(258778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bee
 * JD-Core Version:    0.7.0.1
 */