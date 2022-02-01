package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejb
  extends com.tencent.mm.bx.a
{
  public String MD5;
  public int ZvC;
  public int aajG;
  public String aajr;
  public int abnR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aajG);
      if (this.aajr != null) {
        paramVarArgs.g(2, this.aajr);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(3, this.MD5);
      }
      paramVarArgs.bS(4, this.ZvC);
      paramVarArgs.bS(5, this.abnR);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aajG) + 0;
      paramInt = i;
      if (this.aajr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aajr);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MD5);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.ZvC);
      int j = i.a.a.b.b.a.cJ(5, this.abnR);
      AppMethodBeat.o(155451);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ejb localejb = (ejb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localejb.aajG = locala.ajGk.aar();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localejb.aajr = locala.ajGk.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localejb.MD5 = locala.ajGk.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localejb.ZvC = locala.ajGk.aar();
        AppMethodBeat.o(155451);
        return 0;
      }
      localejb.abnR = locala.ajGk.aar();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejb
 * JD-Core Version:    0.7.0.1
 */