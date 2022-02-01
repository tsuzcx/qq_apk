package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cir
  extends com.tencent.mm.bw.a
{
  public int MnF;
  public int hDc;
  public int hDd;
  public int hDe;
  public int hDf;
  public int hDg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MnF);
      paramVarArgs.aM(2, this.hDc);
      paramVarArgs.aM(3, this.hDd);
      paramVarArgs.aM(4, this.hDf);
      paramVarArgs.aM(5, this.hDe);
      paramVarArgs.aM(6, this.hDg);
      AppMethodBeat.o(209723);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MnF);
      int i = g.a.a.b.b.a.bu(2, this.hDc);
      int j = g.a.a.b.b.a.bu(3, this.hDd);
      int k = g.a.a.b.b.a.bu(4, this.hDf);
      int m = g.a.a.b.b.a.bu(5, this.hDe);
      int n = g.a.a.b.b.a.bu(6, this.hDg);
      AppMethodBeat.o(209723);
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
      AppMethodBeat.o(209723);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cir localcir = (cir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209723);
        return -1;
      case 1: 
        localcir.MnF = locala.UbS.zi();
        AppMethodBeat.o(209723);
        return 0;
      case 2: 
        localcir.hDc = locala.UbS.zi();
        AppMethodBeat.o(209723);
        return 0;
      case 3: 
        localcir.hDd = locala.UbS.zi();
        AppMethodBeat.o(209723);
        return 0;
      case 4: 
        localcir.hDf = locala.UbS.zi();
        AppMethodBeat.o(209723);
        return 0;
      case 5: 
        localcir.hDe = locala.UbS.zi();
        AppMethodBeat.o(209723);
        return 0;
      }
      localcir.hDg = locala.UbS.zi();
      AppMethodBeat.o(209723);
      return 0;
    }
    AppMethodBeat.o(209723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */