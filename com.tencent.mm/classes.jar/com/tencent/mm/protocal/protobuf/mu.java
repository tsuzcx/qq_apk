package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mu
  extends com.tencent.mm.bw.a
{
  public float KRb;
  public float dTj;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224200);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.latitude);
      paramVarArgs.E(2, this.dTj);
      paramVarArgs.E(3, this.KRb);
      AppMethodBeat.o(224200);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(224200);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(224200);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      mu localmu = (mu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(224200);
        return -1;
      case 1: 
        localmu.latitude = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(224200);
        return 0;
      case 2: 
        localmu.dTj = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(224200);
        return 0;
      }
      localmu.KRb = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(224200);
      return 0;
    }
    AppMethodBeat.o(224200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mu
 * JD-Core Version:    0.7.0.1
 */