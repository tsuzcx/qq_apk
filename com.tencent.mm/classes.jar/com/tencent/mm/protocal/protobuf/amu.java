package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amu
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.left);
      paramVarArgs.aM(2, this.top);
      paramVarArgs.aM(3, this.width);
      paramVarArgs.aM(4, this.height);
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.left);
      int i = g.a.a.b.b.a.bu(2, this.top);
      int j = g.a.a.b.b.a.bu(3, this.width);
      int k = g.a.a.b.b.a.bu(4, this.height);
      AppMethodBeat.o(127468);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      amu localamu = (amu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127468);
        return -1;
      case 1: 
        localamu.left = locala.UbS.zi();
        AppMethodBeat.o(127468);
        return 0;
      case 2: 
        localamu.top = locala.UbS.zi();
        AppMethodBeat.o(127468);
        return 0;
      case 3: 
        localamu.width = locala.UbS.zi();
        AppMethodBeat.o(127468);
        return 0;
      }
      localamu.height = locala.UbS.zi();
      AppMethodBeat.o(127468);
      return 0;
    }
    AppMethodBeat.o(127468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amu
 * JD-Core Version:    0.7.0.1
 */