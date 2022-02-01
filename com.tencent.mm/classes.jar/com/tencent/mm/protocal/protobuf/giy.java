package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class giy
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public int acfo;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123680);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acfo);
      paramVarArgs.bS(2, this.Tqb);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.acfo) + 0 + i.a.a.b.b.a.cJ(2, this.Tqb);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.md5);
      }
      AppMethodBeat.o(123680);
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
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      giy localgiy = (giy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123680);
        return -1;
      case 1: 
        localgiy.acfo = locala.ajGk.aar();
        AppMethodBeat.o(123680);
        return 0;
      case 2: 
        localgiy.Tqb = locala.ajGk.aar();
        AppMethodBeat.o(123680);
        return 0;
      case 3: 
        localgiy.url = locala.ajGk.readString();
        AppMethodBeat.o(123680);
        return 0;
      }
      localgiy.md5 = locala.ajGk.readString();
      AppMethodBeat.o(123680);
      return 0;
    }
    AppMethodBeat.o(123680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.giy
 * JD-Core Version:    0.7.0.1
 */