package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ts
  extends com.tencent.mm.bx.a
{
  public String CVB;
  public double CVC;
  public double CVD;
  public double CVE;
  public double CVF;
  public double CVG;
  public int sdA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CVB != null) {
        paramVarArgs.d(1, this.CVB);
      }
      paramVarArgs.e(2, this.CVC);
      paramVarArgs.e(3, this.CVD);
      paramVarArgs.e(4, this.CVE);
      paramVarArgs.e(5, this.CVF);
      paramVarArgs.e(6, this.CVG);
      paramVarArgs.aR(7, this.sdA);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CVB == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = f.a.a.b.b.a.e(1, this.CVB) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.fY(6);
      int i1 = f.a.a.b.b.a.bA(7, this.sdA);
      AppMethodBeat.o(87874);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ts localts = (ts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localts.CVB = locala.KhF.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localts.CVC = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localts.CVD = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localts.CVE = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localts.CVF = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localts.CVG = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87874);
          return 0;
        }
        localts.sdA = locala.KhF.xS();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ts
 * JD-Core Version:    0.7.0.1
 */