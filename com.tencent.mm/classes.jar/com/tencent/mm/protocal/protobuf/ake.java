package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ake
  extends com.tencent.mm.bx.a
{
  public int Zrr;
  public int fps;
  public int hYK;
  public int height;
  public int lTH;
  public int lTI;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lTH);
      paramVarArgs.bS(2, this.fps);
      paramVarArgs.bS(3, this.lTI);
      paramVarArgs.bS(4, this.Zrr);
      paramVarArgs.bS(5, this.hYK);
      paramVarArgs.bS(6, this.width);
      paramVarArgs.bS(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.lTH);
      int i = i.a.a.b.b.a.cJ(2, this.fps);
      int j = i.a.a.b.b.a.cJ(3, this.lTI);
      int k = i.a.a.b.b.a.cJ(4, this.Zrr);
      int m = i.a.a.b.b.a.cJ(5, this.hYK);
      int n = i.a.a.b.b.a.cJ(6, this.width);
      int i1 = i.a.a.b.b.a.cJ(7, this.height);
      AppMethodBeat.o(90965);
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
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ake localake = (ake)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localake.lTH = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localake.fps = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localake.lTI = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localake.Zrr = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localake.hYK = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localake.width = locala.ajGk.aar();
        AppMethodBeat.o(90965);
        return 0;
      }
      localake.height = locala.ajGk.aar();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ake
 * JD-Core Version:    0.7.0.1
 */