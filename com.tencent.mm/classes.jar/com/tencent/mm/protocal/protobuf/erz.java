package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class erz
  extends com.tencent.mm.bx.a
{
  public int XVH;
  public int abmA;
  public int abvM;
  public int abvO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abmA);
      paramVarArgs.bS(2, this.abvO);
      paramVarArgs.bS(3, this.abvM);
      paramVarArgs.bS(4, this.XVH);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abmA);
      int i = i.a.a.b.b.a.cJ(2, this.abvO);
      int j = i.a.a.b.b.a.cJ(3, this.abvM);
      int k = i.a.a.b.b.a.cJ(4, this.XVH);
      AppMethodBeat.o(152672);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      erz localerz = (erz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localerz.abmA = locala.ajGk.aar();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localerz.abvO = locala.ajGk.aar();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localerz.abvM = locala.ajGk.aar();
        AppMethodBeat.o(152672);
        return 0;
      }
      localerz.XVH = locala.ajGk.aar();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erz
 * JD-Core Version:    0.7.0.1
 */