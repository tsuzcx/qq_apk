package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ic
  extends com.tencent.mm.bw.a
{
  public String KLZ;
  public String KMa;
  public int KMb;
  public long KMc;
  public int KMd;
  public long KMe;
  public long KMf;
  public long KMi;
  public double KMj;
  public int KMk;
  public long KMm;
  public int KMn;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KMm);
      if (this.KLZ != null) {
        paramVarArgs.e(2, this.KLZ);
      }
      if (this.KMa != null) {
        paramVarArgs.e(3, this.KMa);
      }
      paramVarArgs.aM(4, this.KMb);
      paramVarArgs.bb(5, this.KMc);
      paramVarArgs.aM(6, this.KMd);
      paramVarArgs.aM(7, this.oTW);
      paramVarArgs.bb(8, this.KMe);
      paramVarArgs.bb(9, this.KMf);
      paramVarArgs.aM(10, this.KMn);
      paramVarArgs.bb(11, this.KMi);
      paramVarArgs.e(12, this.KMj);
      paramVarArgs.aM(13, this.KMk);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KMm) + 0;
      paramInt = i;
      if (this.KLZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KLZ);
      }
      i = paramInt;
      if (this.KMa != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KMa);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.KMb);
      int j = g.a.a.b.b.a.r(5, this.KMc);
      int k = g.a.a.b.b.a.bu(6, this.KMd);
      int m = g.a.a.b.b.a.bu(7, this.oTW);
      int n = g.a.a.b.b.a.r(8, this.KMe);
      int i1 = g.a.a.b.b.a.r(9, this.KMf);
      int i2 = g.a.a.b.b.a.bu(10, this.KMn);
      int i3 = g.a.a.b.b.a.r(11, this.KMi);
      int i4 = g.a.a.b.b.a.fS(12);
      int i5 = g.a.a.b.b.a.bu(13, this.KMk);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ic localic = (ic)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localic.KMm = locala.UbS.zl();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localic.KLZ = locala.UbS.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localic.KMa = locala.UbS.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localic.KMb = locala.UbS.zi();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localic.KMc = locala.UbS.zl();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localic.KMd = locala.UbS.zi();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localic.oTW = locala.UbS.zi();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localic.KMe = locala.UbS.zl();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localic.KMf = locala.UbS.zl();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localic.KMn = locala.UbS.zi();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localic.KMi = locala.UbS.zl();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localic.KMj = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(87873);
        return 0;
      }
      localic.KMk = locala.UbS.zi();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ic
 * JD-Core Version:    0.7.0.1
 */