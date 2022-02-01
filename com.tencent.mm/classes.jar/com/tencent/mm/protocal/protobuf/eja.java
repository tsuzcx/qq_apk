package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eja
  extends com.tencent.mm.bw.a
{
  public b KYF;
  public int KYG;
  public int NiN;
  public int NiO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(7, this.NiN);
      if (this.KYF != null) {
        paramVarArgs.c(8, this.KYF);
      }
      paramVarArgs.aM(9, this.KYG);
      paramVarArgs.aM(10, this.NiO);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(7, this.NiN) + 0;
      paramInt = i;
      if (this.KYF != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.KYF);
      }
      i = g.a.a.b.b.a.bu(9, this.KYG);
      int j = g.a.a.b.b.a.bu(10, this.NiO);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eja localeja = (eja)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localeja.NiN = locala.UbS.zi();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localeja.KYF = locala.UbS.hPo();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localeja.KYG = locala.UbS.zi();
        AppMethodBeat.o(91718);
        return 0;
      }
      localeja.NiO = locala.UbS.zi();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eja
 * JD-Core Version:    0.7.0.1
 */