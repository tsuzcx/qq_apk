package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxf
  extends com.tencent.mm.bx.a
{
  public int DTB;
  public int DTC;
  public int DTD;
  public int DTE;
  public int DTF;
  public int DTG;
  public int DTH;
  public int KVd;
  public int KVe;
  public int KVf;
  public int KVg;
  public int KVh;
  public int LAa;
  public int LzQ;
  public int LzR;
  public int LzS;
  public int LzT;
  public int LzU;
  public int LzV;
  public int LzW;
  public int LzX;
  public int LzY;
  public int LzZ;
  public int clickComment;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DTB);
      paramVarArgs.aR(2, this.DTC);
      paramVarArgs.aR(3, this.DTD);
      paramVarArgs.aR(4, this.DTE);
      paramVarArgs.aR(5, this.DTF);
      paramVarArgs.aR(6, this.clickComment);
      paramVarArgs.aR(7, this.DTG);
      paramVarArgs.aR(8, this.DTH);
      paramVarArgs.aR(9, this.LzQ);
      paramVarArgs.aR(10, this.LzR);
      paramVarArgs.aR(11, this.LzS);
      paramVarArgs.aR(12, this.LzT);
      paramVarArgs.aR(13, this.LzU);
      paramVarArgs.aR(14, this.LzV);
      paramVarArgs.aR(15, this.LzW);
      paramVarArgs.aR(16, this.LzX);
      paramVarArgs.aR(17, this.LzY);
      paramVarArgs.aR(18, this.LzZ);
      paramVarArgs.aR(19, this.LAa);
      paramVarArgs.aR(20, this.KVd);
      paramVarArgs.aR(21, this.KVe);
      paramVarArgs.aR(22, this.KVf);
      paramVarArgs.aR(23, this.KVg);
      paramVarArgs.aR(24, this.KVh);
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DTB);
      int i = f.a.a.b.b.a.bA(2, this.DTC);
      int j = f.a.a.b.b.a.bA(3, this.DTD);
      int k = f.a.a.b.b.a.bA(4, this.DTE);
      int m = f.a.a.b.b.a.bA(5, this.DTF);
      int n = f.a.a.b.b.a.bA(6, this.clickComment);
      int i1 = f.a.a.b.b.a.bA(7, this.DTG);
      int i2 = f.a.a.b.b.a.bA(8, this.DTH);
      int i3 = f.a.a.b.b.a.bA(9, this.LzQ);
      int i4 = f.a.a.b.b.a.bA(10, this.LzR);
      int i5 = f.a.a.b.b.a.bA(11, this.LzS);
      int i6 = f.a.a.b.b.a.bA(12, this.LzT);
      int i7 = f.a.a.b.b.a.bA(13, this.LzU);
      int i8 = f.a.a.b.b.a.bA(14, this.LzV);
      int i9 = f.a.a.b.b.a.bA(15, this.LzW);
      int i10 = f.a.a.b.b.a.bA(16, this.LzX);
      int i11 = f.a.a.b.b.a.bA(17, this.LzY);
      int i12 = f.a.a.b.b.a.bA(18, this.LzZ);
      int i13 = f.a.a.b.b.a.bA(19, this.LAa);
      int i14 = f.a.a.b.b.a.bA(20, this.KVd);
      int i15 = f.a.a.b.b.a.bA(21, this.KVe);
      int i16 = f.a.a.b.b.a.bA(22, this.KVf);
      int i17 = f.a.a.b.b.a.bA(23, this.KVg);
      int i18 = f.a.a.b.b.a.bA(24, this.KVh);
      AppMethodBeat.o(169089);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17 + i18;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxf localbxf = (bxf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169089);
        return -1;
      case 1: 
        localbxf.DTB = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 2: 
        localbxf.DTC = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 3: 
        localbxf.DTD = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 4: 
        localbxf.DTE = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 5: 
        localbxf.DTF = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 6: 
        localbxf.clickComment = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 7: 
        localbxf.DTG = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 8: 
        localbxf.DTH = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 9: 
        localbxf.LzQ = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 10: 
        localbxf.LzR = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 11: 
        localbxf.LzS = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 12: 
        localbxf.LzT = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 13: 
        localbxf.LzU = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 14: 
        localbxf.LzV = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 15: 
        localbxf.LzW = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 16: 
        localbxf.LzX = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 17: 
        localbxf.LzY = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 18: 
        localbxf.LzZ = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 19: 
        localbxf.LAa = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 20: 
        localbxf.KVd = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 21: 
        localbxf.KVe = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 22: 
        localbxf.KVf = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      case 23: 
        localbxf.KVg = locala.KhF.xS();
        AppMethodBeat.o(169089);
        return 0;
      }
      localbxf.KVh = locala.KhF.xS();
      AppMethodBeat.o(169089);
      return 0;
    }
    AppMethodBeat.o(169089);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxf
 * JD-Core Version:    0.7.0.1
 */