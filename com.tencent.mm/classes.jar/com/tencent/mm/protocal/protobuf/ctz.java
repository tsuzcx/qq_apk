package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctz
  extends com.tencent.mm.bw.a
{
  public int Mzm;
  public long Mzn;
  public long Mzo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117883);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mzm);
      paramVarArgs.bb(2, this.Mzn);
      paramVarArgs.bb(3, this.Mzo);
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Mzm);
      int i = g.a.a.b.b.a.r(2, this.Mzn);
      int j = g.a.a.b.b.a.r(3, this.Mzo);
      AppMethodBeat.o(117883);
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
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ctz localctz = (ctz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117883);
        return -1;
      case 1: 
        localctz.Mzm = locala.UbS.zi();
        AppMethodBeat.o(117883);
        return 0;
      case 2: 
        localctz.Mzn = locala.UbS.zl();
        AppMethodBeat.o(117883);
        return 0;
      }
      localctz.Mzo = locala.UbS.zl();
      AppMethodBeat.o(117883);
      return 0;
    }
    AppMethodBeat.o(117883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctz
 * JD-Core Version:    0.7.0.1
 */