package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class epd
  extends com.tencent.mm.bw.a
{
  public int NmY;
  public b NmZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115856);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NmY);
      if (this.NmZ != null) {
        paramVarArgs.c(2, this.NmZ);
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NmY) + 0;
      paramInt = i;
      if (this.NmZ != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.NmZ);
      }
      AppMethodBeat.o(115856);
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
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epd localepd = (epd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115856);
        return -1;
      case 1: 
        localepd.NmY = locala.UbS.zi();
        AppMethodBeat.o(115856);
        return 0;
      }
      localepd.NmZ = locala.UbS.hPo();
      AppMethodBeat.o(115856);
      return 0;
    }
    AppMethodBeat.o(115856);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epd
 * JD-Core Version:    0.7.0.1
 */