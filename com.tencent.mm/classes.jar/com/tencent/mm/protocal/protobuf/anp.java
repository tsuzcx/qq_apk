package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anp
  extends com.tencent.mm.bw.a
{
  public int LyA;
  public int LyB;
  public int Lyp;
  public int Lyq;
  public int Lyr;
  public int Lys;
  public int Lyt;
  public int Lyu;
  public int Lyv;
  public int Lyw;
  public int Lyx;
  public int Lyy;
  public int Lyz;
  public int fileCount;
  public int xiP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lyp);
      paramVarArgs.aM(2, this.Lyq);
      paramVarArgs.aM(3, this.Lyr);
      paramVarArgs.aM(4, this.xiP);
      paramVarArgs.aM(5, this.Lys);
      paramVarArgs.aM(6, this.Lyt);
      paramVarArgs.aM(7, this.Lyu);
      paramVarArgs.aM(8, this.fileCount);
      paramVarArgs.aM(9, this.Lyv);
      paramVarArgs.aM(10, this.Lyw);
      paramVarArgs.aM(11, this.Lyx);
      paramVarArgs.aM(12, this.Lyy);
      paramVarArgs.aM(13, this.Lyz);
      paramVarArgs.aM(14, this.LyA);
      paramVarArgs.aM(15, this.LyB);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lyp);
      int i = g.a.a.b.b.a.bu(2, this.Lyq);
      int j = g.a.a.b.b.a.bu(3, this.Lyr);
      int k = g.a.a.b.b.a.bu(4, this.xiP);
      int m = g.a.a.b.b.a.bu(5, this.Lys);
      int n = g.a.a.b.b.a.bu(6, this.Lyt);
      int i1 = g.a.a.b.b.a.bu(7, this.Lyu);
      int i2 = g.a.a.b.b.a.bu(8, this.fileCount);
      int i3 = g.a.a.b.b.a.bu(9, this.Lyv);
      int i4 = g.a.a.b.b.a.bu(10, this.Lyw);
      int i5 = g.a.a.b.b.a.bu(11, this.Lyx);
      int i6 = g.a.a.b.b.a.bu(12, this.Lyy);
      int i7 = g.a.a.b.b.a.bu(13, this.Lyz);
      int i8 = g.a.a.b.b.a.bu(14, this.LyA);
      int i9 = g.a.a.b.b.a.bu(15, this.LyB);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      anp localanp = (anp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localanp.Lyp = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localanp.Lyq = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localanp.Lyr = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localanp.xiP = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localanp.Lys = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localanp.Lyt = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localanp.Lyu = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localanp.fileCount = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localanp.Lyv = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localanp.Lyw = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localanp.Lyx = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localanp.Lyy = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localanp.Lyz = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localanp.LyA = locala.UbS.zi();
        AppMethodBeat.o(127492);
        return 0;
      }
      localanp.LyB = locala.UbS.zi();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anp
 * JD-Core Version:    0.7.0.1
 */