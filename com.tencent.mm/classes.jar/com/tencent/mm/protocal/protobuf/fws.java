package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fws
  extends com.tencent.mm.bx.a
{
  public int YIc;
  public String YVk;
  public String Zsa;
  public int abUy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152724);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YIc);
      if (this.Zsa != null) {
        paramVarArgs.g(2, this.Zsa);
      }
      paramVarArgs.bS(3, this.abUy);
      if (this.YVk != null) {
        paramVarArgs.g(4, this.YVk);
      }
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YIc) + 0;
      paramInt = i;
      if (this.Zsa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zsa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.abUy);
      paramInt = i;
      if (this.YVk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YVk);
      }
      AppMethodBeat.o(152724);
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
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fws localfws = (fws)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152724);
        return -1;
      case 1: 
        localfws.YIc = locala.ajGk.aar();
        AppMethodBeat.o(152724);
        return 0;
      case 2: 
        localfws.Zsa = locala.ajGk.readString();
        AppMethodBeat.o(152724);
        return 0;
      case 3: 
        localfws.abUy = locala.ajGk.aar();
        AppMethodBeat.o(152724);
        return 0;
      }
      localfws.YVk = locala.ajGk.readString();
      AppMethodBeat.o(152724);
      return 0;
    }
    AppMethodBeat.o(152724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fws
 * JD-Core Version:    0.7.0.1
 */