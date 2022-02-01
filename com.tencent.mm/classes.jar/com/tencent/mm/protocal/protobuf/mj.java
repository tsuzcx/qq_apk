package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mj
  extends com.tencent.mm.bx.a
{
  public int YMr;
  public int YNF;
  public int YNG;
  public int YNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32145);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YMr);
      paramVarArgs.bS(2, this.YNF);
      paramVarArgs.bS(3, this.YNG);
      paramVarArgs.bS(4, this.YNH);
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YMr);
      int i = i.a.a.b.b.a.cJ(2, this.YNF);
      int j = i.a.a.b.b.a.cJ(3, this.YNG);
      int k = i.a.a.b.b.a.cJ(4, this.YNH);
      AppMethodBeat.o(32145);
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
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      mj localmj = (mj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32145);
        return -1;
      case 1: 
        localmj.YMr = locala.ajGk.aar();
        AppMethodBeat.o(32145);
        return 0;
      case 2: 
        localmj.YNF = locala.ajGk.aar();
        AppMethodBeat.o(32145);
        return 0;
      case 3: 
        localmj.YNG = locala.ajGk.aar();
        AppMethodBeat.o(32145);
        return 0;
      }
      localmj.YNH = locala.ajGk.aar();
      AppMethodBeat.o(32145);
      return 0;
    }
    AppMethodBeat.o(32145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mj
 * JD-Core Version:    0.7.0.1
 */