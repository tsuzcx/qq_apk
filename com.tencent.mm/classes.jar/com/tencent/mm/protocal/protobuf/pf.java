package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class pf
  extends com.tencent.mm.bw.a
{
  public b KVZ;
  public int KWa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124442);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KVZ != null) {
        paramVarArgs.c(1, this.KVZ);
      }
      paramVarArgs.aM(2, this.KWa);
      AppMethodBeat.o(124442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KVZ == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.b(1, this.KVZ) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KWa);
      AppMethodBeat.o(124442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124442);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        pf localpf = (pf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124442);
          return -1;
        case 1: 
          localpf.KVZ = locala.UbS.hPo();
          AppMethodBeat.o(124442);
          return 0;
        }
        localpf.KWa = locala.UbS.zi();
        AppMethodBeat.o(124442);
        return 0;
      }
      AppMethodBeat.o(124442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */