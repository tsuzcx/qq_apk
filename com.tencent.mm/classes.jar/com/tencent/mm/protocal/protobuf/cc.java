package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cc
  extends com.tencent.mm.bw.a
{
  public int Dvc;
  public int Dvd;
  public float KGc;
  public float KGd;
  public float KGe;
  public long KGf;
  public long KGg;
  public long KGh;
  public long KGi;
  public long endTime;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Dvc);
      paramVarArgs.aM(2, this.Dvd);
      paramVarArgs.E(3, this.KGc);
      paramVarArgs.E(4, this.KGd);
      paramVarArgs.E(5, this.KGe);
      paramVarArgs.bb(6, this.startTime);
      paramVarArgs.bb(7, this.endTime);
      paramVarArgs.bb(8, this.KGf);
      paramVarArgs.bb(9, this.KGg);
      paramVarArgs.bb(10, this.KGh);
      paramVarArgs.bb(11, this.KGi);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Dvc);
      int i = g.a.a.b.b.a.bu(2, this.Dvd);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.r(6, this.startTime);
      int i1 = g.a.a.b.b.a.r(7, this.endTime);
      int i2 = g.a.a.b.b.a.r(8, this.KGf);
      int i3 = g.a.a.b.b.a.r(9, this.KGg);
      int i4 = g.a.a.b.b.a.r(10, this.KGh);
      int i5 = g.a.a.b.b.a.r(11, this.KGi);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cc localcc = (cc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125698);
        return -1;
      case 1: 
        localcc.Dvc = locala.UbS.zi();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localcc.Dvd = locala.UbS.zi();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localcc.KGc = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localcc.KGd = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localcc.KGe = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localcc.startTime = locala.UbS.zl();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localcc.endTime = locala.UbS.zl();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localcc.KGf = locala.UbS.zl();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localcc.KGg = locala.UbS.zl();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localcc.KGh = locala.UbS.zl();
        AppMethodBeat.o(125698);
        return 0;
      }
      localcc.KGi = locala.UbS.zl();
      AppMethodBeat.o(125698);
      return 0;
    }
    AppMethodBeat.o(125698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cc
 * JD-Core Version:    0.7.0.1
 */