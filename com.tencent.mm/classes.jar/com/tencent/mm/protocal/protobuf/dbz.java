package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbz
  extends com.tencent.mm.bx.a
{
  public boolean aaHA;
  public long aaHB;
  public long aaHC;
  public long aaHD;
  public long aaHE;
  public int aaHF;
  public long aaHt;
  public long aaHu;
  public long aaHv;
  public boolean aaHw;
  public long aaHx;
  public long aaHy;
  public long aaHz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259347);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaHt);
      paramVarArgs.bv(2, this.aaHu);
      paramVarArgs.bv(3, this.aaHv);
      paramVarArgs.di(4, this.aaHw);
      paramVarArgs.bv(5, this.aaHx);
      paramVarArgs.bv(6, this.aaHy);
      paramVarArgs.bv(7, this.aaHz);
      paramVarArgs.di(8, this.aaHA);
      paramVarArgs.bv(9, this.aaHB);
      paramVarArgs.bv(10, this.aaHC);
      paramVarArgs.bv(11, this.aaHD);
      paramVarArgs.bv(12, this.aaHE);
      paramVarArgs.bS(13, this.aaHF);
      AppMethodBeat.o(259347);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaHt);
      int i = i.a.a.b.b.a.q(2, this.aaHu);
      int j = i.a.a.b.b.a.q(3, this.aaHv);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.q(5, this.aaHx);
      int n = i.a.a.b.b.a.q(6, this.aaHy);
      int i1 = i.a.a.b.b.a.q(7, this.aaHz);
      int i2 = i.a.a.b.b.a.ko(8);
      int i3 = i.a.a.b.b.a.q(9, this.aaHB);
      int i4 = i.a.a.b.b.a.q(10, this.aaHC);
      int i5 = i.a.a.b.b.a.q(11, this.aaHD);
      int i6 = i.a.a.b.b.a.q(12, this.aaHE);
      int i7 = i.a.a.b.b.a.cJ(13, this.aaHF);
      AppMethodBeat.o(259347);
      return paramInt + 0 + i + j + (k + 1) + m + n + i1 + (i2 + 1) + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259347);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbz localdbz = (dbz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259347);
        return -1;
      case 1: 
        localdbz.aaHt = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 2: 
        localdbz.aaHu = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 3: 
        localdbz.aaHv = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 4: 
        localdbz.aaHw = locala.ajGk.aai();
        AppMethodBeat.o(259347);
        return 0;
      case 5: 
        localdbz.aaHx = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 6: 
        localdbz.aaHy = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 7: 
        localdbz.aaHz = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 8: 
        localdbz.aaHA = locala.ajGk.aai();
        AppMethodBeat.o(259347);
        return 0;
      case 9: 
        localdbz.aaHB = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 10: 
        localdbz.aaHC = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 11: 
        localdbz.aaHD = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      case 12: 
        localdbz.aaHE = locala.ajGk.aaw();
        AppMethodBeat.o(259347);
        return 0;
      }
      localdbz.aaHF = locala.ajGk.aar();
      AppMethodBeat.o(259347);
      return 0;
    }
    AppMethodBeat.o(259347);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbz
 * JD-Core Version:    0.7.0.1
 */