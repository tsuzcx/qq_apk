package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhg
  extends com.tencent.mm.cd.a
{
  public int SRN;
  public float SRO;
  public int SRP;
  public int SRQ;
  public float SRR;
  public int SRS;
  public int zKC;
  public int zKD;
  public int zKH;
  public int zKI;
  public int zKK;
  public int zKO;
  public int zKP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.zKC);
      paramVarArgs.aY(2, this.zKD);
      paramVarArgs.aY(3, this.SRN);
      paramVarArgs.i(4, this.SRO);
      paramVarArgs.aY(5, this.SRP);
      paramVarArgs.aY(6, this.SRQ);
      paramVarArgs.aY(7, this.zKH);
      paramVarArgs.aY(8, this.zKI);
      paramVarArgs.i(9, this.SRR);
      paramVarArgs.aY(10, this.zKK);
      paramVarArgs.aY(11, this.SRS);
      paramVarArgs.aY(12, this.zKO);
      paramVarArgs.aY(13, this.zKP);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.zKC);
      int i = g.a.a.b.b.a.bM(2, this.zKD);
      int j = g.a.a.b.b.a.bM(3, this.SRN);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.bM(5, this.SRP);
      int n = g.a.a.b.b.a.bM(6, this.SRQ);
      int i1 = g.a.a.b.b.a.bM(7, this.zKH);
      int i2 = g.a.a.b.b.a.bM(8, this.zKI);
      int i3 = g.a.a.b.b.a.gL(9);
      int i4 = g.a.a.b.b.a.bM(10, this.zKK);
      int i5 = g.a.a.b.b.a.bM(11, this.SRS);
      int i6 = g.a.a.b.b.a.bM(12, this.zKO);
      int i7 = g.a.a.b.b.a.bM(13, this.zKP);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + (k + 4) + m + n + i1 + i2 + (i3 + 4) + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bhg localbhg = (bhg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localbhg.zKC = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localbhg.zKD = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localbhg.SRN = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localbhg.SRO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localbhg.SRP = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 6: 
        localbhg.SRQ = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 7: 
        localbhg.zKH = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 8: 
        localbhg.zKI = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 9: 
        localbhg.SRR = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(184205);
        return 0;
      case 10: 
        localbhg.zKK = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 11: 
        localbhg.SRS = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      case 12: 
        localbhg.zKO = locala.abFh.AK();
        AppMethodBeat.o(184205);
        return 0;
      }
      localbhg.zKP = locala.abFh.AK();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhg
 * JD-Core Version:    0.7.0.1
 */