package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dy
  extends com.tencent.mm.bw.a
{
  public boolean KHU;
  public String KHV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.KHU);
      if (this.KHV != null) {
        paramVarArgs.e(2, this.KHV);
      }
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.KHV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KHV);
      }
      AppMethodBeat.o(123538);
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
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dy localdy = (dy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123538);
        return -1;
      case 1: 
        localdy.KHU = locala.UbS.yZ();
        AppMethodBeat.o(123538);
        return 0;
      }
      localdy.KHV = locala.UbS.readString();
      AppMethodBeat.o(123538);
      return 0;
    }
    AppMethodBeat.o(123538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dy
 * JD-Core Version:    0.7.0.1
 */