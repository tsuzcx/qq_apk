package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbp
  extends com.tencent.mm.bx.a
{
  public String ZUh;
  public int aakR;
  public int aakT;
  public int aakY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258214);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aakY);
      if (this.ZUh != null) {
        paramVarArgs.g(2, this.ZUh);
      }
      paramVarArgs.bS(3, this.aakR);
      paramVarArgs.bS(4, this.aakT);
      AppMethodBeat.o(258214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aakY) + 0;
      paramInt = i;
      if (this.ZUh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZUh);
      }
      i = i.a.a.b.b.a.cJ(3, this.aakR);
      int j = i.a.a.b.b.a.cJ(4, this.aakT);
      AppMethodBeat.o(258214);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258214);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cbp localcbp = (cbp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258214);
        return -1;
      case 1: 
        localcbp.aakY = locala.ajGk.aar();
        AppMethodBeat.o(258214);
        return 0;
      case 2: 
        localcbp.ZUh = locala.ajGk.readString();
        AppMethodBeat.o(258214);
        return 0;
      case 3: 
        localcbp.aakR = locala.ajGk.aar();
        AppMethodBeat.o(258214);
        return 0;
      }
      localcbp.aakT = locala.ajGk.aar();
      AppMethodBeat.o(258214);
      return 0;
    }
    AppMethodBeat.o(258214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbp
 * JD-Core Version:    0.7.0.1
 */