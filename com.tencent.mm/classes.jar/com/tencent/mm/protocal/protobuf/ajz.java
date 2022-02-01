package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajz
  extends com.tencent.mm.bx.a
{
  public int DkA;
  public int DkB;
  public int DkC;
  public int DkI;
  public int DkJ;
  public int DlO;
  public String country;
  public String coverImgUrl;
  public String evA;
  public int evp;
  public String evz;
  public String gLg;
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
      if (this.gLg != null) {
        paramVarArgs.d(4, this.gLg);
      }
      if (this.country != null) {
        paramVarArgs.d(5, this.country);
      }
      if (this.evz != null) {
        paramVarArgs.d(6, this.evz);
      }
      if (this.evA != null) {
        paramVarArgs.d(7, this.evA);
      }
      paramVarArgs.aR(8, this.evp);
      paramVarArgs.aR(9, this.DkA);
      paramVarArgs.aR(10, this.DkB);
      paramVarArgs.aR(11, this.DkC);
      paramVarArgs.aR(12, this.DkI);
      paramVarArgs.aR(13, this.DkJ);
      paramVarArgs.aR(14, this.DlO);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label914;
      }
    }
    label914:
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
      if (this.gLg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gLg);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.country);
      }
      paramInt = i;
      if (this.evz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.evz);
      }
      i = paramInt;
      if (this.evA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.evA);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.evp);
      int j = f.a.a.b.b.a.bA(9, this.DkA);
      int k = f.a.a.b.b.a.bA(10, this.DkB);
      int m = f.a.a.b.b.a.bA(11, this.DkC);
      int n = f.a.a.b.b.a.bA(12, this.DkI);
      int i1 = f.a.a.b.b.a.bA(13, this.DkJ);
      int i2 = f.a.a.b.b.a.bA(14, this.DlO);
      AppMethodBeat.o(169015);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajz localajz = (ajz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localajz.nickname = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localajz.signature = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localajz.coverImgUrl = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localajz.gLg = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localajz.country = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localajz.evz = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localajz.evA = locala.KhF.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localajz.evp = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localajz.DkA = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localajz.DkB = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localajz.DkC = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localajz.DkI = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localajz.DkJ = locala.KhF.xS();
          AppMethodBeat.o(169015);
          return 0;
        }
        localajz.DlO = locala.KhF.xS();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajz
 * JD-Core Version:    0.7.0.1
 */