package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axd
  extends com.tencent.mm.bw.a
{
  public int KGw;
  public int LDO;
  public long pWj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LDO);
      paramVarArgs.aM(2, this.KGw);
      paramVarArgs.bb(3, this.pWj);
      AppMethodBeat.o(209556);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LDO);
      int i = g.a.a.b.b.a.bu(2, this.KGw);
      int j = g.a.a.b.b.a.r(3, this.pWj);
      AppMethodBeat.o(209556);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209556);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      axd localaxd = (axd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209556);
        return -1;
      case 1: 
        localaxd.LDO = locala.UbS.zi();
        AppMethodBeat.o(209556);
        return 0;
      case 2: 
        localaxd.KGw = locala.UbS.zi();
        AppMethodBeat.o(209556);
        return 0;
      }
      localaxd.pWj = locala.UbS.zl();
      AppMethodBeat.o(209556);
      return 0;
    }
    AppMethodBeat.o(209556);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axd
 * JD-Core Version:    0.7.0.1
 */