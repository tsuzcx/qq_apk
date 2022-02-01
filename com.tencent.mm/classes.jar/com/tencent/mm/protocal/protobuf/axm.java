package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class axm
  extends com.tencent.mm.bx.a
{
  public int Frg;
  public long Rsc;
  public int ZIA;
  public int ZIB;
  public int ZIC;
  public int ZID;
  public int ZIE;
  public b ZIF;
  public int ZIG;
  public int ZIH;
  public int ZII;
  public long ZIJ;
  public long ZIK;
  public long ZIL;
  public long ZIM;
  public long ZIN;
  public long ZIO;
  public long ZIP;
  public int ZIy;
  public int ZIz;
  public int Znb;
  public int pullType;
  public int scene;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259772);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      paramVarArgs.bS(2, this.ZIy);
      paramVarArgs.bS(3, this.pullType);
      paramVarArgs.bS(4, this.Frg);
      paramVarArgs.bS(5, this.ZIz);
      paramVarArgs.bS(6, this.ZIA);
      paramVarArgs.bS(7, this.ZIB);
      paramVarArgs.bS(8, this.ZIC);
      paramVarArgs.bS(9, this.ZID);
      paramVarArgs.bS(10, this.ZIE);
      if (this.ZIF != null) {
        paramVarArgs.d(11, this.ZIF);
      }
      paramVarArgs.bS(12, this.ZIG);
      paramVarArgs.bS(13, this.status);
      paramVarArgs.bS(14, this.Znb);
      paramVarArgs.bS(15, this.ZIH);
      paramVarArgs.bS(16, this.ZII);
      paramVarArgs.bv(17, this.Rsc);
      paramVarArgs.bv(18, this.ZIJ);
      paramVarArgs.bv(19, this.ZIK);
      paramVarArgs.bv(20, this.ZIL);
      paramVarArgs.bv(21, this.ZIM);
      paramVarArgs.bv(22, this.ZIN);
      paramVarArgs.bv(23, this.ZIO);
      paramVarArgs.bv(24, this.ZIP);
      AppMethodBeat.o(259772);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.scene) + 0 + i.a.a.b.b.a.cJ(2, this.ZIy) + i.a.a.b.b.a.cJ(3, this.pullType) + i.a.a.b.b.a.cJ(4, this.Frg) + i.a.a.b.b.a.cJ(5, this.ZIz) + i.a.a.b.b.a.cJ(6, this.ZIA) + i.a.a.b.b.a.cJ(7, this.ZIB) + i.a.a.b.b.a.cJ(8, this.ZIC) + i.a.a.b.b.a.cJ(9, this.ZID) + i.a.a.b.b.a.cJ(10, this.ZIE);
      paramInt = i;
      if (this.ZIF != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.ZIF);
      }
      i = i.a.a.b.b.a.cJ(12, this.ZIG);
      int j = i.a.a.b.b.a.cJ(13, this.status);
      int k = i.a.a.b.b.a.cJ(14, this.Znb);
      int m = i.a.a.b.b.a.cJ(15, this.ZIH);
      int n = i.a.a.b.b.a.cJ(16, this.ZII);
      int i1 = i.a.a.b.b.a.q(17, this.Rsc);
      int i2 = i.a.a.b.b.a.q(18, this.ZIJ);
      int i3 = i.a.a.b.b.a.q(19, this.ZIK);
      int i4 = i.a.a.b.b.a.q(20, this.ZIL);
      int i5 = i.a.a.b.b.a.q(21, this.ZIM);
      int i6 = i.a.a.b.b.a.q(22, this.ZIN);
      int i7 = i.a.a.b.b.a.q(23, this.ZIO);
      int i8 = i.a.a.b.b.a.q(24, this.ZIP);
      AppMethodBeat.o(259772);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259772);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      axm localaxm = (axm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259772);
        return -1;
      case 1: 
        localaxm.scene = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 2: 
        localaxm.ZIy = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 3: 
        localaxm.pullType = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 4: 
        localaxm.Frg = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 5: 
        localaxm.ZIz = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 6: 
        localaxm.ZIA = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 7: 
        localaxm.ZIB = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 8: 
        localaxm.ZIC = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 9: 
        localaxm.ZID = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 10: 
        localaxm.ZIE = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 11: 
        localaxm.ZIF = locala.ajGk.kFX();
        AppMethodBeat.o(259772);
        return 0;
      case 12: 
        localaxm.ZIG = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 13: 
        localaxm.status = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 14: 
        localaxm.Znb = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 15: 
        localaxm.ZIH = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 16: 
        localaxm.ZII = locala.ajGk.aar();
        AppMethodBeat.o(259772);
        return 0;
      case 17: 
        localaxm.Rsc = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 18: 
        localaxm.ZIJ = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 19: 
        localaxm.ZIK = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 20: 
        localaxm.ZIL = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 21: 
        localaxm.ZIM = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 22: 
        localaxm.ZIN = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      case 23: 
        localaxm.ZIO = locala.ajGk.aaw();
        AppMethodBeat.o(259772);
        return 0;
      }
      localaxm.ZIP = locala.ajGk.aaw();
      AppMethodBeat.o(259772);
      return 0;
    }
    AppMethodBeat.o(259772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axm
 * JD-Core Version:    0.7.0.1
 */