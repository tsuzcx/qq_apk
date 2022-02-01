package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coh
  extends com.tencent.mm.bw.a
{
  public float LKx;
  public int MuA;
  public int Muw;
  public float Mux;
  public int Muy;
  public int Muz;
  public int uUm;
  public int uUn;
  public int uUs;
  public int uUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209766);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uUm);
      paramVarArgs.aM(2, this.uUn);
      paramVarArgs.aM(3, this.Muw);
      paramVarArgs.E(4, this.Mux);
      paramVarArgs.aM(5, this.Muy);
      paramVarArgs.aM(6, this.Muz);
      paramVarArgs.aM(7, this.MuA);
      paramVarArgs.aM(8, this.uUs);
      paramVarArgs.E(9, this.LKx);
      paramVarArgs.aM(10, this.uUu);
      AppMethodBeat.o(209766);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.uUm);
      int i = g.a.a.b.b.a.bu(2, this.uUn);
      int j = g.a.a.b.b.a.bu(3, this.Muw);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.bu(5, this.Muy);
      int n = g.a.a.b.b.a.bu(6, this.Muz);
      int i1 = g.a.a.b.b.a.bu(7, this.MuA);
      int i2 = g.a.a.b.b.a.bu(8, this.uUs);
      int i3 = g.a.a.b.b.a.fS(9);
      int i4 = g.a.a.b.b.a.bu(10, this.uUu);
      AppMethodBeat.o(209766);
      return paramInt + 0 + i + j + (k + 4) + m + n + i1 + i2 + (i3 + 4) + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209766);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      coh localcoh = (coh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209766);
        return -1;
      case 1: 
        localcoh.uUm = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 2: 
        localcoh.uUn = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 3: 
        localcoh.Muw = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 4: 
        localcoh.Mux = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209766);
        return 0;
      case 5: 
        localcoh.Muy = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 6: 
        localcoh.Muz = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 7: 
        localcoh.MuA = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 8: 
        localcoh.uUs = locala.UbS.zi();
        AppMethodBeat.o(209766);
        return 0;
      case 9: 
        localcoh.LKx = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209766);
        return 0;
      }
      localcoh.uUu = locala.UbS.zi();
      AppMethodBeat.o(209766);
      return 0;
    }
    AppMethodBeat.o(209766);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coh
 * JD-Core Version:    0.7.0.1
 */