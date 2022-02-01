package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int Yzp;
  public int Yzq;
  public int Yzr;
  public int Yzs;
  public int Yzt;
  public int Yzu;
  public int Yzv;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Yzp);
      paramVarArgs.bS(2, this.action);
      paramVarArgs.bS(3, this.Yzq);
      paramVarArgs.bS(4, this.Yzr);
      paramVarArgs.bS(5, this.Yzs);
      paramVarArgs.bS(6, this.Yzt);
      paramVarArgs.bS(7, this.Yzu);
      paramVarArgs.bS(8, this.Yzv);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Yzp);
      int i = i.a.a.b.b.a.cJ(2, this.action);
      int j = i.a.a.b.b.a.cJ(3, this.Yzq);
      int k = i.a.a.b.b.a.cJ(4, this.Yzr);
      int m = i.a.a.b.b.a.cJ(5, this.Yzs);
      int n = i.a.a.b.b.a.cJ(6, this.Yzt);
      int i1 = i.a.a.b.b.a.cJ(7, this.Yzu);
      int i2 = i.a.a.b.b.a.cJ(8, this.Yzv);
      AppMethodBeat.o(143955);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.Yzp = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.Yzq = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.Yzr = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.Yzs = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.Yzt = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.Yzu = locala.ajGk.aar();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.Yzv = locala.ajGk.aar();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */