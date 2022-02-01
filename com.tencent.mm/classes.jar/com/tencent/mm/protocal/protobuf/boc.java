package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boc
  extends com.tencent.mm.bw.a
{
  public String FRz;
  public String FVh;
  public String HaX;
  public String HaY;
  public int HaZ;
  public int Hba;
  public int Hbb;
  public int Hbc;
  public String Hbd;
  public String Hbe;
  public String Hbf;
  public String Hbg;
  public int Hbh;
  public String IconUrl;
  public int fhC;
  public long fhD;
  public String fhE;
  public String fhF;
  public String fhG;
  public String fhH;
  public String jga;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HaX != null) {
        paramVarArgs.d(1, this.HaX);
      }
      if (this.FRz != null) {
        paramVarArgs.d(2, this.FRz);
      }
      if (this.FVh != null) {
        paramVarArgs.d(3, this.FVh);
      }
      if (this.HaY != null) {
        paramVarArgs.d(4, this.HaY);
      }
      paramVarArgs.aS(5, this.HaZ);
      paramVarArgs.aS(6, this.Hba);
      paramVarArgs.aS(7, this.Hbb);
      paramVarArgs.aS(8, this.Hbc);
      if (this.Hbd != null) {
        paramVarArgs.d(9, this.Hbd);
      }
      if (this.jga != null) {
        paramVarArgs.d(10, this.jga);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(11, this.IconUrl);
      }
      if (this.uqf != null) {
        paramVarArgs.d(12, this.uqf);
      }
      if (this.Hbe != null) {
        paramVarArgs.d(13, this.Hbe);
      }
      if (this.Hbf != null) {
        paramVarArgs.d(14, this.Hbf);
      }
      if (this.Hbg != null) {
        paramVarArgs.d(15, this.Hbg);
      }
      paramVarArgs.aS(16, this.Hbh);
      paramVarArgs.aS(17, this.fhC);
      paramVarArgs.aZ(18, this.fhD);
      if (this.fhE != null) {
        paramVarArgs.d(19, this.fhE);
      }
      if (this.fhF != null) {
        paramVarArgs.d(20, this.fhF);
      }
      if (this.fhG != null) {
        paramVarArgs.d(21, this.fhG);
      }
      if (this.fhH != null) {
        paramVarArgs.d(22, this.fhH);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HaX == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = f.a.a.b.b.a.e(1, this.HaX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FRz);
      }
      i = paramInt;
      if (this.FVh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVh);
      }
      paramInt = i;
      if (this.HaY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HaY);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HaZ) + f.a.a.b.b.a.bz(6, this.Hba) + f.a.a.b.b.a.bz(7, this.Hbb) + f.a.a.b.b.a.bz(8, this.Hbc);
      paramInt = i;
      if (this.Hbd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hbd);
      }
      i = paramInt;
      if (this.jga != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.jga);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IconUrl);
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.uqf);
      }
      paramInt = i;
      if (this.Hbe != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Hbe);
      }
      i = paramInt;
      if (this.Hbf != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hbf);
      }
      paramInt = i;
      if (this.Hbg != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Hbg);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.Hbh) + f.a.a.b.b.a.bz(17, this.fhC) + f.a.a.b.b.a.p(18, this.fhD);
      paramInt = i;
      if (this.fhE != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.fhE);
      }
      i = paramInt;
      if (this.fhF != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.fhF);
      }
      paramInt = i;
      if (this.fhG != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.fhG);
      }
      i = paramInt;
      if (this.fhH != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.fhH);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boc localboc = (boc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localboc.HaX = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localboc.FRz = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localboc.FVh = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localboc.HaY = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localboc.HaZ = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localboc.Hba = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localboc.Hbb = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localboc.Hbc = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localboc.Hbd = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localboc.jga = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localboc.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localboc.uqf = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localboc.Hbe = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localboc.Hbf = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localboc.Hbg = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localboc.Hbh = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localboc.fhC = locala.OmT.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localboc.fhD = locala.OmT.zd();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localboc.fhE = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localboc.fhF = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localboc.fhG = locala.OmT.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localboc.fhH = locala.OmT.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boc
 * JD-Core Version:    0.7.0.1
 */