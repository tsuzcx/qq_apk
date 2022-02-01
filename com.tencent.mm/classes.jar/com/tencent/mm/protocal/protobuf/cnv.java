package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnv
  extends com.tencent.mm.bw.a
{
  public int LCO;
  public int LCP;
  public int LCQ;
  public int LCR;
  public int Muh;
  public int Mui;
  public int Muj;
  public int Muk;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209751);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.scene);
      paramVarArgs.aM(2, this.LCO);
      paramVarArgs.aM(3, this.Muh);
      paramVarArgs.aM(4, this.Mui);
      paramVarArgs.aM(5, this.LCP);
      paramVarArgs.aM(6, this.LCQ);
      paramVarArgs.aM(7, this.LCR);
      paramVarArgs.aM(8, this.Muj);
      paramVarArgs.aM(9, this.Muk);
      AppMethodBeat.o(209751);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.scene);
      int i = g.a.a.b.b.a.bu(2, this.LCO);
      int j = g.a.a.b.b.a.bu(3, this.Muh);
      int k = g.a.a.b.b.a.bu(4, this.Mui);
      int m = g.a.a.b.b.a.bu(5, this.LCP);
      int n = g.a.a.b.b.a.bu(6, this.LCQ);
      int i1 = g.a.a.b.b.a.bu(7, this.LCR);
      int i2 = g.a.a.b.b.a.bu(8, this.Muj);
      int i3 = g.a.a.b.b.a.bu(9, this.Muk);
      AppMethodBeat.o(209751);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209751);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cnv localcnv = (cnv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209751);
        return -1;
      case 1: 
        localcnv.scene = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 2: 
        localcnv.LCO = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 3: 
        localcnv.Muh = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 4: 
        localcnv.Mui = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 5: 
        localcnv.LCP = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 6: 
        localcnv.LCQ = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 7: 
        localcnv.LCR = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      case 8: 
        localcnv.Muj = locala.UbS.zi();
        AppMethodBeat.o(209751);
        return 0;
      }
      localcnv.Muk = locala.UbS.zi();
      AppMethodBeat.o(209751);
      return 0;
    }
    AppMethodBeat.o(209751);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnv
 * JD-Core Version:    0.7.0.1
 */