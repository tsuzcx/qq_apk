package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class qk
  extends com.tencent.mm.bx.a
{
  public b YVf;
  public int YVg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124442);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVf != null) {
        paramVarArgs.d(1, this.YVf);
      }
      paramVarArgs.bS(2, this.YVg);
      AppMethodBeat.o(124442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVf == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.c(1, this.YVf) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YVg);
      AppMethodBeat.o(124442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124442);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        qk localqk = (qk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124442);
          return -1;
        case 1: 
          localqk.YVf = locala.ajGk.kFX();
          AppMethodBeat.o(124442);
          return 0;
        }
        localqk.YVg = locala.ajGk.aar();
        AppMethodBeat.o(124442);
        return 0;
      }
      AppMethodBeat.o(124442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qk
 * JD-Core Version:    0.7.0.1
 */