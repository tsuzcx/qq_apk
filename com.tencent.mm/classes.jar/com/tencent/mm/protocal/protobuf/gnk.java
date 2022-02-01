package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gnk
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int YQB;
  public int aaJu;
  public int acis;
  public int acit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaJu);
      paramVarArgs.bS(2, this.YQB);
      paramVarArgs.bS(3, this.acis);
      paramVarArgs.bS(4, this.IJG);
      paramVarArgs.bS(10, this.acit);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaJu);
      int i = i.a.a.b.b.a.cJ(2, this.YQB);
      int j = i.a.a.b.b.a.cJ(3, this.acis);
      int k = i.a.a.b.b.a.cJ(4, this.IJG);
      int m = i.a.a.b.b.a.cJ(10, this.acit);
      AppMethodBeat.o(123712);
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
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gnk localgnk = (gnk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localgnk.aaJu = locala.ajGk.aar();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localgnk.YQB = locala.ajGk.aar();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localgnk.acis = locala.ajGk.aar();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localgnk.IJG = locala.ajGk.aar();
        AppMethodBeat.o(123712);
        return 0;
      }
      localgnk.acit = locala.ajGk.aar();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnk
 * JD-Core Version:    0.7.0.1
 */