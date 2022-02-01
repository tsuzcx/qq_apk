package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glh
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int YQB;
  public int aaJu;
  public int aaQU;
  public int aaQV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaJu);
      paramVarArgs.bS(2, this.YQB);
      paramVarArgs.bS(3, this.IJG);
      paramVarArgs.bS(5, this.aaQV);
      paramVarArgs.bS(6, this.aaQU);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaJu);
      int i = i.a.a.b.b.a.cJ(2, this.YQB);
      int j = i.a.a.b.b.a.cJ(3, this.IJG);
      int k = i.a.a.b.b.a.cJ(5, this.aaQV);
      int m = i.a.a.b.b.a.cJ(6, this.aaQU);
      AppMethodBeat.o(50118);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glh localglh = (glh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localglh.aaJu = locala.ajGk.aar();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localglh.YQB = locala.ajGk.aar();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localglh.IJG = locala.ajGk.aar();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localglh.aaQV = locala.ajGk.aar();
        AppMethodBeat.o(50118);
        return 0;
      }
      localglh.aaQU = locala.ajGk.aar();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glh
 * JD-Core Version:    0.7.0.1
 */