package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dtd
  extends com.tencent.mm.bw.a
{
  public b LoA;
  public int MVj;
  public int MVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MVj);
      paramVarArgs.aM(2, this.MVk);
      if (this.LoA != null) {
        paramVarArgs.c(3, this.LoA);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MVj) + 0 + g.a.a.b.b.a.bu(2, this.MVk);
      paramInt = i;
      if (this.LoA != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LoA);
      }
      AppMethodBeat.o(149128);
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
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dtd localdtd = (dtd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localdtd.MVj = locala.UbS.zi();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localdtd.MVk = locala.UbS.zi();
        AppMethodBeat.o(149128);
        return 0;
      }
      localdtd.LoA = locala.UbS.hPo();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtd
 * JD-Core Version:    0.7.0.1
 */