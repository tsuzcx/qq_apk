package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public int dIY;
  public int height;
  public int size;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(242829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.dIY);
      paramVarArgs.bS(2, this.size);
      paramVarArgs.bS(3, this.width);
      paramVarArgs.bS(4, this.height);
      AppMethodBeat.o(242829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.dIY);
      int i = i.a.a.b.b.a.cJ(2, this.size);
      int j = i.a.a.b.b.a.cJ(3, this.width);
      int k = i.a.a.b.b.a.cJ(4, this.height);
      AppMethodBeat.o(242829);
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
      AppMethodBeat.o(242829);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(242829);
        return -1;
      case 1: 
        localq.dIY = locala.ajGk.aar();
        AppMethodBeat.o(242829);
        return 0;
      case 2: 
        localq.size = locala.ajGk.aar();
        AppMethodBeat.o(242829);
        return 0;
      case 3: 
        localq.width = locala.ajGk.aar();
        AppMethodBeat.o(242829);
        return 0;
      }
      localq.height = locala.ajGk.aar();
      AppMethodBeat.o(242829);
      return 0;
    }
    AppMethodBeat.o(242829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.q
 * JD-Core Version:    0.7.0.1
 */