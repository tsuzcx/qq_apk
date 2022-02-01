package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
  extends com.tencent.mm.bw.a
{
  public String KCU;
  public int KCV;
  public int KCW;
  public int KCX;
  public int KCY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KCU != null) {
        paramVarArgs.e(1, this.KCU);
      }
      paramVarArgs.aM(2, this.KCV);
      paramVarArgs.aM(3, this.KCW);
      paramVarArgs.aM(4, this.KCX);
      paramVarArgs.aM(5, this.KCY);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KCU == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.f(1, this.KCU) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KCV);
      int j = g.a.a.b.b.a.bu(3, this.KCW);
      int k = g.a.a.b.b.a.bu(4, this.KCX);
      int m = g.a.a.b.b.a.bu(5, this.KCY);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localai.KCU = locala.UbS.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localai.KCV = locala.UbS.zi();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localai.KCW = locala.UbS.zi();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localai.KCX = locala.UbS.zi();
          AppMethodBeat.o(143961);
          return 0;
        }
        localai.KCY = locala.UbS.zi();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */