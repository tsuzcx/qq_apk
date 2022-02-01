package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnk
  extends com.tencent.mm.bx.a
{
  public String FCM;
  public String Fzb;
  public int GHA;
  public String GHB;
  public String GHC;
  public String GHD;
  public String GHE;
  public int GHF;
  public String GHv;
  public String GHw;
  public int GHx;
  public int GHy;
  public int GHz;
  public String IconUrl;
  public int ffF;
  public long ffG;
  public String ffH;
  public String ffI;
  public String ffJ;
  public String ffK;
  public String jdh;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHv != null) {
        paramVarArgs.d(1, this.GHv);
      }
      if (this.Fzb != null) {
        paramVarArgs.d(2, this.Fzb);
      }
      if (this.FCM != null) {
        paramVarArgs.d(3, this.FCM);
      }
      if (this.GHw != null) {
        paramVarArgs.d(4, this.GHw);
      }
      paramVarArgs.aS(5, this.GHx);
      paramVarArgs.aS(6, this.GHy);
      paramVarArgs.aS(7, this.GHz);
      paramVarArgs.aS(8, this.GHA);
      if (this.GHB != null) {
        paramVarArgs.d(9, this.GHB);
      }
      if (this.jdh != null) {
        paramVarArgs.d(10, this.jdh);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(11, this.IconUrl);
      }
      if (this.ueY != null) {
        paramVarArgs.d(12, this.ueY);
      }
      if (this.GHC != null) {
        paramVarArgs.d(13, this.GHC);
      }
      if (this.GHD != null) {
        paramVarArgs.d(14, this.GHD);
      }
      if (this.GHE != null) {
        paramVarArgs.d(15, this.GHE);
      }
      paramVarArgs.aS(16, this.GHF);
      paramVarArgs.aS(17, this.ffF);
      paramVarArgs.aY(18, this.ffG);
      if (this.ffH != null) {
        paramVarArgs.d(19, this.ffH);
      }
      if (this.ffI != null) {
        paramVarArgs.d(20, this.ffI);
      }
      if (this.ffJ != null) {
        paramVarArgs.d(21, this.ffJ);
      }
      if (this.ffK != null) {
        paramVarArgs.d(22, this.ffK);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHv == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = f.a.a.b.b.a.e(1, this.GHv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fzb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fzb);
      }
      i = paramInt;
      if (this.FCM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FCM);
      }
      paramInt = i;
      if (this.GHw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GHw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GHx) + f.a.a.b.b.a.bz(6, this.GHy) + f.a.a.b.b.a.bz(7, this.GHz) + f.a.a.b.b.a.bz(8, this.GHA);
      paramInt = i;
      if (this.GHB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GHB);
      }
      i = paramInt;
      if (this.jdh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.jdh);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IconUrl);
      }
      i = paramInt;
      if (this.ueY != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.ueY);
      }
      paramInt = i;
      if (this.GHC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GHC);
      }
      i = paramInt;
      if (this.GHD != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GHD);
      }
      paramInt = i;
      if (this.GHE != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GHE);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GHF) + f.a.a.b.b.a.bz(17, this.ffF) + f.a.a.b.b.a.p(18, this.ffG);
      paramInt = i;
      if (this.ffH != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ffH);
      }
      i = paramInt;
      if (this.ffI != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ffI);
      }
      paramInt = i;
      if (this.ffJ != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ffJ);
      }
      i = paramInt;
      if (this.ffK != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.ffK);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnk localbnk = (bnk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localbnk.GHv = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localbnk.Fzb = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localbnk.FCM = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localbnk.GHw = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localbnk.GHx = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localbnk.GHy = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localbnk.GHz = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localbnk.GHA = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localbnk.GHB = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localbnk.jdh = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localbnk.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localbnk.ueY = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localbnk.GHC = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localbnk.GHD = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localbnk.GHE = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localbnk.GHF = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localbnk.ffF = locala.NPN.zc();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localbnk.ffG = locala.NPN.zd();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localbnk.ffH = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localbnk.ffI = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localbnk.ffJ = locala.NPN.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localbnk.ffK = locala.NPN.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnk
 * JD-Core Version:    0.7.0.1
 */