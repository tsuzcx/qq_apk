package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjw
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int YQB;
  public int aaJu;
  public int aaQU;
  public int aaQV;
  public String aaQW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaJu);
      paramVarArgs.bS(2, this.YQB);
      paramVarArgs.bS(3, this.IJG);
      if (this.aaQW != null) {
        paramVarArgs.g(4, this.aaQW);
      }
      paramVarArgs.bS(5, this.aaQV);
      paramVarArgs.bS(6, this.aaQU);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaJu) + 0 + i.a.a.b.b.a.cJ(2, this.YQB) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aaQW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaQW);
      }
      i = i.a.a.b.b.a.cJ(5, this.aaQV);
      int j = i.a.a.b.b.a.cJ(6, this.aaQU);
      AppMethodBeat.o(123683);
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
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gjw localgjw = (gjw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localgjw.aaJu = locala.ajGk.aar();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localgjw.YQB = locala.ajGk.aar();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localgjw.IJG = locala.ajGk.aar();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localgjw.aaQW = locala.ajGk.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localgjw.aaQV = locala.ajGk.aar();
        AppMethodBeat.o(123683);
        return 0;
      }
      localgjw.aaQU = locala.ajGk.aar();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjw
 * JD-Core Version:    0.7.0.1
 */