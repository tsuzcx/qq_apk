package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnd
  extends com.tencent.mm.bw.a
{
  public float Mto;
  public float Mtp;
  public float Mtq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125746);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.Mto);
      paramVarArgs.E(2, this.Mtp);
      paramVarArgs.E(3, this.Mtq);
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(125746);
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
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cnd localcnd = (cnd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125746);
        return -1;
      case 1: 
        localcnd.Mto = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125746);
        return 0;
      case 2: 
        localcnd.Mtp = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125746);
        return 0;
      }
      localcnd.Mtq = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(125746);
      return 0;
    }
    AppMethodBeat.o(125746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnd
 * JD-Core Version:    0.7.0.1
 */