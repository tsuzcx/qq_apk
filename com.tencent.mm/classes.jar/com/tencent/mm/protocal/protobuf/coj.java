package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coj
  extends com.tencent.mm.bw.a
{
  public long MuD;
  public float MuE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209769);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MuD);
      paramVarArgs.E(2, this.MuE);
      AppMethodBeat.o(209769);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.MuD);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(209769);
      return paramInt + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209769);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      coj localcoj = (coj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209769);
        return -1;
      case 1: 
        localcoj.MuD = locala.UbS.zl();
        AppMethodBeat.o(209769);
        return 0;
      }
      localcoj.MuE = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(209769);
      return 0;
    }
    AppMethodBeat.o(209769);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coj
 * JD-Core Version:    0.7.0.1
 */