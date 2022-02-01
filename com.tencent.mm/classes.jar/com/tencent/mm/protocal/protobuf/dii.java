package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dii
  extends com.tencent.mm.bx.a
{
  public String aanS;
  public String nickname;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257382);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.xkY != null) {
        paramVarArgs.g(2, this.xkY);
      }
      if (this.aanS != null) {
        paramVarArgs.g(3, this.aanS);
      }
      AppMethodBeat.o(257382);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xkY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xkY);
      }
      i = paramInt;
      if (this.aanS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aanS);
      }
      AppMethodBeat.o(257382);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257382);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dii localdii = (dii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257382);
          return -1;
        case 1: 
          localdii.nickname = locala.ajGk.readString();
          AppMethodBeat.o(257382);
          return 0;
        case 2: 
          localdii.xkY = locala.ajGk.readString();
          AppMethodBeat.o(257382);
          return 0;
        }
        localdii.aanS = locala.ajGk.readString();
        AppMethodBeat.o(257382);
        return 0;
      }
      AppMethodBeat.o(257382);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dii
 * JD-Core Version:    0.7.0.1
 */