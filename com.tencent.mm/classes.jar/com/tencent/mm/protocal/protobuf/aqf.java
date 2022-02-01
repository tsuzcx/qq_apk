package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqf
  extends com.tencent.mm.bw.a
{
  public int GEE;
  public int GEF;
  public int GEG;
  public int GEU;
  public int GEV;
  public int GHc;
  public int GHd;
  public int GHe;
  public String country;
  public String coverImgUrl;
  public int eQV;
  public String eRf;
  public String eRg;
  public String hGI;
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
      if (this.hGI != null) {
        paramVarArgs.d(4, this.hGI);
      }
      if (this.country != null) {
        paramVarArgs.d(5, this.country);
      }
      if (this.eRf != null) {
        paramVarArgs.d(6, this.eRf);
      }
      if (this.eRg != null) {
        paramVarArgs.d(7, this.eRg);
      }
      paramVarArgs.aS(8, this.eQV);
      paramVarArgs.aS(9, this.GEE);
      paramVarArgs.aS(10, this.GEF);
      paramVarArgs.aS(11, this.GEG);
      paramVarArgs.aS(12, this.GEU);
      paramVarArgs.aS(13, this.GEV);
      paramVarArgs.aS(14, this.GHc);
      paramVarArgs.aS(15, this.GHd);
      paramVarArgs.aS(16, this.GHe);
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
      if (this.hGI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hGI);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.country);
      }
      paramInt = i;
      if (this.eRf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.eRf);
      }
      i = paramInt;
      if (this.eRg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.eRg);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.eQV);
      int j = f.a.a.b.b.a.bz(9, this.GEE);
      int k = f.a.a.b.b.a.bz(10, this.GEF);
      int m = f.a.a.b.b.a.bz(11, this.GEG);
      int n = f.a.a.b.b.a.bz(12, this.GEU);
      int i1 = f.a.a.b.b.a.bz(13, this.GEV);
      int i2 = f.a.a.b.b.a.bz(14, this.GHc);
      int i3 = f.a.a.b.b.a.bz(15, this.GHd);
      int i4 = f.a.a.b.b.a.bz(16, this.GHe);
      AppMethodBeat.o(169015);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqf localaqf = (aqf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localaqf.nickname = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localaqf.signature = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localaqf.coverImgUrl = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localaqf.hGI = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localaqf.country = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localaqf.eRf = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localaqf.eRg = locala.OmT.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localaqf.eQV = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localaqf.GEE = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localaqf.GEF = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localaqf.GEG = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localaqf.GEU = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localaqf.GEV = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 14: 
          localaqf.GHc = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        case 15: 
          localaqf.GHd = locala.OmT.zc();
          AppMethodBeat.o(169015);
          return 0;
        }
        localaqf.GHe = locala.OmT.zc();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqf
 * JD-Core Version:    0.7.0.1
 */