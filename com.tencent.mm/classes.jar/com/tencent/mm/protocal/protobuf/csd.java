package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class csd
  extends com.tencent.mm.bx.a
{
  public float FOA;
  public float FOB;
  public String GPO;
  public int GPP;
  public int GPQ;
  public b GPR;
  public String GPT;
  public String Gnu;
  public float bYG;
  public String country;
  public String jDf;
  public String jde;
  public int score;
  public String zSk;
  public int zSm;
  public int zSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.FOA);
      paramVarArgs.z(2, this.FOB);
      if (this.jde != null) {
        paramVarArgs.d(3, this.jde);
      }
      if (this.jDf != null) {
        paramVarArgs.d(4, this.jDf);
      }
      if (this.zSk != null) {
        paramVarArgs.d(5, this.zSk);
      }
      if (this.Gnu != null) {
        paramVarArgs.d(6, this.Gnu);
      }
      paramVarArgs.aS(7, this.zSm);
      if (this.GPO != null) {
        paramVarArgs.d(8, this.GPO);
      }
      paramVarArgs.aS(9, this.GPP);
      paramVarArgs.aS(10, this.GPQ);
      paramVarArgs.aS(11, this.zSo);
      paramVarArgs.z(12, this.bYG);
      if (this.GPR != null) {
        paramVarArgs.c(13, this.GPR);
      }
      paramVarArgs.aS(14, this.score);
      if (this.GPT != null) {
        paramVarArgs.d(15, this.GPT);
      }
      if (this.country != null) {
        paramVarArgs.d(16, this.country);
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alU(1) + 0 + f.a.a.b.b.a.alU(2);
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.jde);
      }
      i = paramInt;
      if (this.jDf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.jDf);
      }
      paramInt = i;
      if (this.zSk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zSk);
      }
      i = paramInt;
      if (this.Gnu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gnu);
      }
      i += f.a.a.b.b.a.bz(7, this.zSm);
      paramInt = i;
      if (this.GPO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GPO);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GPP) + f.a.a.b.b.a.bz(10, this.GPQ) + f.a.a.b.b.a.bz(11, this.zSo) + f.a.a.b.b.a.alU(12);
      paramInt = i;
      if (this.GPR != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.GPR);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.score);
      paramInt = i;
      if (this.GPT != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GPT);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.country);
      }
      AppMethodBeat.o(101530);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      csd localcsd = (csd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101530);
        return -1;
      case 1: 
        localcsd.FOA = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(101530);
        return 0;
      case 2: 
        localcsd.FOB = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(101530);
        return 0;
      case 3: 
        localcsd.jde = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 4: 
        localcsd.jDf = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 5: 
        localcsd.zSk = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 6: 
        localcsd.Gnu = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 7: 
        localcsd.zSm = locala.NPN.zc();
        AppMethodBeat.o(101530);
        return 0;
      case 8: 
        localcsd.GPO = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 9: 
        localcsd.GPP = locala.NPN.zc();
        AppMethodBeat.o(101530);
        return 0;
      case 10: 
        localcsd.GPQ = locala.NPN.zc();
        AppMethodBeat.o(101530);
        return 0;
      case 11: 
        localcsd.zSo = locala.NPN.zc();
        AppMethodBeat.o(101530);
        return 0;
      case 12: 
        localcsd.bYG = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(101530);
        return 0;
      case 13: 
        localcsd.GPR = locala.NPN.gxI();
        AppMethodBeat.o(101530);
        return 0;
      case 14: 
        localcsd.score = locala.NPN.zc();
        AppMethodBeat.o(101530);
        return 0;
      case 15: 
        localcsd.GPT = locala.NPN.readString();
        AppMethodBeat.o(101530);
        return 0;
      }
      localcsd.country = locala.NPN.readString();
      AppMethodBeat.o(101530);
      return 0;
    }
    AppMethodBeat.o(101530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csd
 * JD-Core Version:    0.7.0.1
 */