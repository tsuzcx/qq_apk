package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class azw
  extends com.tencent.mm.bw.a
{
  public int LJN;
  public int LJO;
  public b LJP;
  public String riB;
  public long twp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209622);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.twp);
      if (this.riB != null) {
        paramVarArgs.e(2, this.riB);
      }
      paramVarArgs.aM(3, this.LJN);
      paramVarArgs.aM(4, this.LJO);
      if (this.LJP != null) {
        paramVarArgs.c(5, this.LJP);
      }
      AppMethodBeat.o(209622);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.twp) + 0;
      paramInt = i;
      if (this.riB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.riB);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.LJN) + g.a.a.b.b.a.bu(4, this.LJO);
      paramInt = i;
      if (this.LJP != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LJP);
      }
      AppMethodBeat.o(209622);
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
      AppMethodBeat.o(209622);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azw localazw = (azw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209622);
        return -1;
      case 1: 
        localazw.twp = locala.UbS.zl();
        AppMethodBeat.o(209622);
        return 0;
      case 2: 
        localazw.riB = locala.UbS.readString();
        AppMethodBeat.o(209622);
        return 0;
      case 3: 
        localazw.LJN = locala.UbS.zi();
        AppMethodBeat.o(209622);
        return 0;
      case 4: 
        localazw.LJO = locala.UbS.zi();
        AppMethodBeat.o(209622);
        return 0;
      }
      localazw.LJP = locala.UbS.hPo();
      AppMethodBeat.o(209622);
      return 0;
    }
    AppMethodBeat.o(209622);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */