package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caj
  extends com.tencent.mm.bx.a
{
  public int ZvY;
  public String aajr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZvY);
      if (this.aajr != null) {
        paramVarArgs.g(2, this.aajr);
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZvY) + 0;
      paramInt = i;
      if (this.aajr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aajr);
      }
      AppMethodBeat.o(155407);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      caj localcaj = (caj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155407);
        return -1;
      case 1: 
        localcaj.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(155407);
        return 0;
      }
      localcaj.aajr = locala.ajGk.readString();
      AppMethodBeat.o(155407);
      return 0;
    }
    AppMethodBeat.o(155407);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */