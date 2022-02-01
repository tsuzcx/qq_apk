package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezh
  extends com.tencent.mm.bx.a
{
  public int abAs;
  public int abAt;
  public int abAu;
  public int abAv;
  public int abAw;
  public int abAx;
  public int abAy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abAs);
      paramVarArgs.bS(2, this.abAt);
      paramVarArgs.bS(3, this.abAu);
      paramVarArgs.bS(4, this.abAv);
      paramVarArgs.bS(5, this.abAw);
      paramVarArgs.bS(6, this.abAx);
      paramVarArgs.bS(7, this.abAy);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abAs);
      int i = i.a.a.b.b.a.cJ(2, this.abAt);
      int j = i.a.a.b.b.a.cJ(3, this.abAu);
      int k = i.a.a.b.b.a.cJ(4, this.abAv);
      int m = i.a.a.b.b.a.cJ(5, this.abAw);
      int n = i.a.a.b.b.a.cJ(6, this.abAx);
      int i1 = i.a.a.b.b.a.cJ(7, this.abAy);
      AppMethodBeat.o(124550);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ezh localezh = (ezh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localezh.abAs = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localezh.abAt = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localezh.abAu = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localezh.abAv = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localezh.abAw = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localezh.abAx = locala.ajGk.aar();
        AppMethodBeat.o(124550);
        return 0;
      }
      localezh.abAy = locala.ajGk.aar();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezh
 * JD-Core Version:    0.7.0.1
 */