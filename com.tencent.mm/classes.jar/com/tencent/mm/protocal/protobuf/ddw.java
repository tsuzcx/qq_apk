package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddw
  extends com.tencent.mm.bw.a
{
  public int MIW;
  public int MIX;
  public String MIY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MIW);
      paramVarArgs.aM(2, this.MIX);
      if (this.MIY != null) {
        paramVarArgs.e(3, this.MIY);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MIW) + 0 + g.a.a.b.b.a.bu(2, this.MIX);
      paramInt = i;
      if (this.MIY != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MIY);
      }
      AppMethodBeat.o(125754);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ddw localddw = (ddw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localddw.MIW = locala.UbS.zi();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localddw.MIX = locala.UbS.zi();
        AppMethodBeat.o(125754);
        return 0;
      }
      localddw.MIY = locala.UbS.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddw
 * JD-Core Version:    0.7.0.1
 */