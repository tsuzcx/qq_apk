package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebc
  extends com.tencent.mm.bx.a
{
  public int abgH;
  public String nickname;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258158);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abgH);
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.xkY != null) {
        paramVarArgs.g(3, this.xkY);
      }
      AppMethodBeat.o(258158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abgH) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.xkY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xkY);
      }
      AppMethodBeat.o(258158);
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
      AppMethodBeat.o(258158);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ebc localebc = (ebc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258158);
        return -1;
      case 1: 
        localebc.abgH = locala.ajGk.aar();
        AppMethodBeat.o(258158);
        return 0;
      case 2: 
        localebc.nickname = locala.ajGk.readString();
        AppMethodBeat.o(258158);
        return 0;
      }
      localebc.xkY = locala.ajGk.readString();
      AppMethodBeat.o(258158);
      return 0;
    }
    AppMethodBeat.o(258158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebc
 * JD-Core Version:    0.7.0.1
 */