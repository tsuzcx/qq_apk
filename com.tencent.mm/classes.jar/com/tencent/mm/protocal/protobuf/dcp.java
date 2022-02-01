package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcp
  extends com.tencent.mm.bw.a
{
  public int X;
  public int Y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209793);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.X);
      paramVarArgs.aM(2, this.Y);
      AppMethodBeat.o(209793);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.X);
      int i = g.a.a.b.b.a.bu(2, this.Y);
      AppMethodBeat.o(209793);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209793);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcp localdcp = (dcp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209793);
        return -1;
      case 1: 
        localdcp.X = locala.UbS.zi();
        AppMethodBeat.o(209793);
        return 0;
      }
      localdcp.Y = locala.UbS.zi();
      AppMethodBeat.o(209793);
      return 0;
    }
    AppMethodBeat.o(209793);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcp
 * JD-Core Version:    0.7.0.1
 */