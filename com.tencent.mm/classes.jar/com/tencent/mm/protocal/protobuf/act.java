package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class act
  extends com.tencent.mm.bw.a
{
  public int LnA;
  public int LnB;
  public int LnC;
  public int Lnz;
  public int qsR;
  public int qsS;
  public int qsT;
  public int qsU;
  public int qsV;
  public int qsW;
  public int qsX;
  public int qsY;
  public int qsZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.qsR);
      paramVarArgs.aM(2, this.Lnz);
      paramVarArgs.aM(3, this.qsS);
      paramVarArgs.aM(4, this.qsT);
      paramVarArgs.aM(5, this.qsU);
      paramVarArgs.aM(6, this.LnA);
      paramVarArgs.aM(7, this.qsV);
      paramVarArgs.aM(8, this.qsW);
      paramVarArgs.aM(9, this.LnB);
      paramVarArgs.aM(10, this.LnC);
      paramVarArgs.aM(11, this.qsX);
      paramVarArgs.aM(12, this.qsY);
      paramVarArgs.aM(13, this.qsZ);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.qsR);
      int i = g.a.a.b.b.a.bu(2, this.Lnz);
      int j = g.a.a.b.b.a.bu(3, this.qsS);
      int k = g.a.a.b.b.a.bu(4, this.qsT);
      int m = g.a.a.b.b.a.bu(5, this.qsU);
      int n = g.a.a.b.b.a.bu(6, this.LnA);
      int i1 = g.a.a.b.b.a.bu(7, this.qsV);
      int i2 = g.a.a.b.b.a.bu(8, this.qsW);
      int i3 = g.a.a.b.b.a.bu(9, this.LnB);
      int i4 = g.a.a.b.b.a.bu(10, this.LnC);
      int i5 = g.a.a.b.b.a.bu(11, this.qsX);
      int i6 = g.a.a.b.b.a.bu(12, this.qsY);
      int i7 = g.a.a.b.b.a.bu(13, this.qsZ);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      act localact = (act)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localact.qsR = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localact.Lnz = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localact.qsS = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localact.qsT = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localact.qsU = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localact.LnA = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localact.qsV = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localact.qsW = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localact.LnB = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localact.LnC = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localact.qsX = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localact.qsY = locala.UbS.zi();
        AppMethodBeat.o(90959);
        return 0;
      }
      localact.qsZ = locala.UbS.zi();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.act
 * JD-Core Version:    0.7.0.1
 */