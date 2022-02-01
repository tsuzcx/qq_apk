package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ss
  extends com.tencent.mm.bw.a
{
  public int LaJ;
  public b pUz;
  public int pWk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LaJ);
      paramVarArgs.aM(2, this.pWk);
      if (this.pUz != null) {
        paramVarArgs.c(3, this.pUz);
      }
      AppMethodBeat.o(226013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LaJ) + 0 + g.a.a.b.b.a.bu(2, this.pWk);
      paramInt = i;
      if (this.pUz != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.pUz);
      }
      AppMethodBeat.o(226013);
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
      AppMethodBeat.o(226013);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ss localss = (ss)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(226013);
        return -1;
      case 1: 
        localss.LaJ = locala.UbS.zi();
        AppMethodBeat.o(226013);
        return 0;
      case 2: 
        localss.pWk = locala.UbS.zi();
        AppMethodBeat.o(226013);
        return 0;
      }
      localss.pUz = locala.UbS.hPo();
      AppMethodBeat.o(226013);
      return 0;
    }
    AppMethodBeat.o(226013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ss
 * JD-Core Version:    0.7.0.1
 */