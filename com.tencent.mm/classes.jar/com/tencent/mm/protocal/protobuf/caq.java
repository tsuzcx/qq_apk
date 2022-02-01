package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caq
  extends com.tencent.mm.bw.a
{
  public long MfO;
  public int MfP;
  public long MfQ;
  public int MfR;
  public long MfS;
  public int MfT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MfO);
      paramVarArgs.aM(2, this.MfP);
      paramVarArgs.bb(3, this.MfQ);
      paramVarArgs.aM(4, this.MfR);
      paramVarArgs.bb(5, this.MfS);
      paramVarArgs.aM(6, this.MfT);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.MfO);
      int i = g.a.a.b.b.a.bu(2, this.MfP);
      int j = g.a.a.b.b.a.r(3, this.MfQ);
      int k = g.a.a.b.b.a.bu(4, this.MfR);
      int m = g.a.a.b.b.a.r(5, this.MfS);
      int n = g.a.a.b.b.a.bu(6, this.MfT);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      caq localcaq = (caq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localcaq.MfO = locala.UbS.zl();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localcaq.MfP = locala.UbS.zi();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localcaq.MfQ = locala.UbS.zl();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localcaq.MfR = locala.UbS.zi();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localcaq.MfS = locala.UbS.zl();
        AppMethodBeat.o(115845);
        return 0;
      }
      localcaq.MfT = locala.UbS.zi();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caq
 * JD-Core Version:    0.7.0.1
 */