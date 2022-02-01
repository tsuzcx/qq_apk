package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class mn
  extends com.tencent.mm.bw.a
{
  public b KQI;
  public b KQJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KQI != null) {
        paramVarArgs.c(1, this.KQI);
      }
      if (this.KQJ != null) {
        paramVarArgs.c(2, this.KQJ);
      }
      AppMethodBeat.o(104358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KQI == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.KQI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KQJ != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KQJ);
      }
      AppMethodBeat.o(104358);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104358);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mn localmn = (mn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104358);
          return -1;
        case 1: 
          localmn.KQI = locala.UbS.hPo();
          AppMethodBeat.o(104358);
          return 0;
        }
        localmn.KQJ = locala.UbS.hPo();
        AppMethodBeat.o(104358);
        return 0;
      }
      AppMethodBeat.o(104358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mn
 * JD-Core Version:    0.7.0.1
 */