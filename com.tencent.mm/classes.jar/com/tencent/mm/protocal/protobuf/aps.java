package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aps
  extends com.tencent.mm.bx.a
{
  public int GlC;
  public int GlD;
  public int GlE;
  public int GlS;
  public int GlT;
  public int GnW;
  public int GnX;
  public int GnY;
  public String country;
  public String coverImgUrl;
  public int ePk;
  public String ePu;
  public String ePv;
  public String hDQ;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.d(1, this.nickname);
      }
      if (this.signature != null) {
        paramVarArgs.d(2, this.signature);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.d(3, this.coverImgUrl);
      }
      if (this.hDQ != null) {
        paramVarArgs.d(4, this.hDQ);
      }
      if (this.country != null) {
        paramVarArgs.d(5, this.country);
      }
      if (this.ePu != null) {
        paramVarArgs.d(6, this.ePu);
      }
      if (this.ePv != null) {
        paramVarArgs.d(7, this.ePv);
      }
      paramVarArgs.aS(8, this.ePk);
      paramVarArgs.aS(9, this.GlC);
      paramVarArgs.aS(10, this.GlD);
      paramVarArgs.aS(11, this.GlE);
      paramVarArgs.aS(12, this.GlS);
      paramVarArgs.aS(13, this.GlT);
      paramVarArgs.aS(14, this.GnW);
      paramVarArgs.aS(15, this.GnX);
      paramVarArgs.aS(16, this.GnY);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = f.a.a.b.b.a.e(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.signature);
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.coverImgUrl);
      }
      paramInt = i;
      if (this.hDQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDQ);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.country);
      }
      paramInt = i;
      if (this.ePu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ePu);
      }
      i = paramInt;
      if (this.ePv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ePv);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.ePk);
      int j = f.a.a.b.b.a.bz(9, this.GlC);
      int k = f.a.a.b.b.a.bz(10, this.GlD);
      int m = f.a.a.b.b.a.bz(11, this.GlE);
      int n = f.a.a.b.b.a.bz(12, this.GlS);
      int i1 = f.a.a.b.b.a.bz(13, this.GlT);
      int i2 = f.a.a.b.b.a.bz(14, this.GnW);
      int i3 = f.a.a.b.b.a.bz(15, this.GnX);
      int i4 = f.a.a.b.b.a.bz(16, this.GnY);
      AppMethodBeat.o(169015);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aps localaps = (aps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localaps.nickname = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localaps.signature = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localaps.coverImgUrl = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localaps.hDQ = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localaps.country = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localaps.ePu = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localaps.ePv = locala.NPN.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localaps.ePk = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localaps.GlC = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localaps.GlD = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localaps.GlE = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localaps.GlS = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localaps.GlT = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 14: 
          localaps.GnW = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 15: 
          localaps.GnX = locala.NPN.zc();
          AppMethodBeat.o(169015);
          return 0;
        }
        localaps.GnY = locala.NPN.zc();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aps
 * JD-Core Version:    0.7.0.1
 */