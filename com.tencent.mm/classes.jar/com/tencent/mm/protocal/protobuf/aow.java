package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aow
  extends com.tencent.mm.bx.a
{
  public int ZvX;
  public int ZvY;
  public int ZvZ;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259598);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZvX);
      paramVarArgs.bS(2, this.ZvY);
      paramVarArgs.bS(3, this.ZvZ);
      paramVarArgs.bS(4, this.count);
      AppMethodBeat.o(259598);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZvX);
      int i = i.a.a.b.b.a.cJ(2, this.ZvY);
      int j = i.a.a.b.b.a.cJ(3, this.ZvZ);
      int k = i.a.a.b.b.a.cJ(4, this.count);
      AppMethodBeat.o(259598);
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
      AppMethodBeat.o(259598);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aow localaow = (aow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259598);
        return -1;
      case 1: 
        localaow.ZvX = locala.ajGk.aar();
        AppMethodBeat.o(259598);
        return 0;
      case 2: 
        localaow.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(259598);
        return 0;
      case 3: 
        localaow.ZvZ = locala.ajGk.aar();
        AppMethodBeat.o(259598);
        return 0;
      }
      localaow.count = locala.ajGk.aar();
      AppMethodBeat.o(259598);
      return 0;
    }
    AppMethodBeat.o(259598);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aow
 * JD-Core Version:    0.7.0.1
 */