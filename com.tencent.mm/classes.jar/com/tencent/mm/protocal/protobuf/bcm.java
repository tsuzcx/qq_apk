package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcm
  extends com.tencent.mm.bw.a
{
  public int LLE;
  public long uOx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uOx);
      paramVarArgs.aM(2, this.LLE);
      AppMethodBeat.o(209673);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.uOx);
      int i = g.a.a.b.b.a.bu(2, this.LLE);
      AppMethodBeat.o(209673);
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
      AppMethodBeat.o(209673);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bcm localbcm = (bcm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209673);
        return -1;
      case 1: 
        localbcm.uOx = locala.UbS.zl();
        AppMethodBeat.o(209673);
        return 0;
      }
      localbcm.LLE = locala.UbS.zi();
      AppMethodBeat.o(209673);
      return 0;
    }
    AppMethodBeat.o(209673);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcm
 * JD-Core Version:    0.7.0.1
 */