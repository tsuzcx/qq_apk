package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjd
  extends com.tencent.mm.bw.a
{
  public int MoA;
  public int MoB;
  public int MoC;
  public int MoD;
  public int MoE;
  public int MoF;
  public int Mow;
  public int Mox;
  public int Moy;
  public int Moz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196384);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mow);
      paramVarArgs.aM(2, this.Mox);
      paramVarArgs.aM(3, this.Moy);
      paramVarArgs.aM(4, this.Moz);
      paramVarArgs.aM(5, this.MoA);
      paramVarArgs.aM(6, this.MoB);
      paramVarArgs.aM(7, this.MoC);
      paramVarArgs.aM(8, this.MoD);
      paramVarArgs.aM(9, this.MoE);
      paramVarArgs.aM(10, this.MoF);
      AppMethodBeat.o(196384);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Mow);
      int i = g.a.a.b.b.a.bu(2, this.Mox);
      int j = g.a.a.b.b.a.bu(3, this.Moy);
      int k = g.a.a.b.b.a.bu(4, this.Moz);
      int m = g.a.a.b.b.a.bu(5, this.MoA);
      int n = g.a.a.b.b.a.bu(6, this.MoB);
      int i1 = g.a.a.b.b.a.bu(7, this.MoC);
      int i2 = g.a.a.b.b.a.bu(8, this.MoD);
      int i3 = g.a.a.b.b.a.bu(9, this.MoE);
      int i4 = g.a.a.b.b.a.bu(10, this.MoF);
      AppMethodBeat.o(196384);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(196384);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cjd localcjd = (cjd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196384);
        return -1;
      case 1: 
        localcjd.Mow = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 2: 
        localcjd.Mox = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 3: 
        localcjd.Moy = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 4: 
        localcjd.Moz = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 5: 
        localcjd.MoA = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 6: 
        localcjd.MoB = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 7: 
        localcjd.MoC = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 8: 
        localcjd.MoD = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      case 9: 
        localcjd.MoE = locala.UbS.zi();
        AppMethodBeat.o(196384);
        return 0;
      }
      localcjd.MoF = locala.UbS.zi();
      AppMethodBeat.o(196384);
      return 0;
    }
    AppMethodBeat.o(196384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjd
 * JD-Core Version:    0.7.0.1
 */