package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aro
  extends com.tencent.mm.bx.a
{
  public int height;
  public int left;
  public int top;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127468);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.left);
      paramVarArgs.bS(2, this.top);
      paramVarArgs.bS(3, this.width);
      paramVarArgs.bS(4, this.height);
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.left);
      int i = i.a.a.b.b.a.cJ(2, this.top);
      int j = i.a.a.b.b.a.cJ(3, this.width);
      int k = i.a.a.b.b.a.cJ(4, this.height);
      AppMethodBeat.o(127468);
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
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aro localaro = (aro)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127468);
        return -1;
      case 1: 
        localaro.left = locala.ajGk.aar();
        AppMethodBeat.o(127468);
        return 0;
      case 2: 
        localaro.top = locala.ajGk.aar();
        AppMethodBeat.o(127468);
        return 0;
      case 3: 
        localaro.width = locala.ajGk.aar();
        AppMethodBeat.o(127468);
        return 0;
      }
      localaro.height = locala.ajGk.aar();
      AppMethodBeat.o(127468);
      return 0;
    }
    AppMethodBeat.o(127468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aro
 * JD-Core Version:    0.7.0.1
 */