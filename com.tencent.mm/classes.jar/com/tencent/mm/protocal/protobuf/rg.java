package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rg
  extends com.tencent.mm.bx.a
{
  public int AsE;
  public int AsF;
  public int FNi;
  public int FNj;
  public int FNk;
  public int FNl;
  public int FNm;
  public int FNn;
  public int FNo;
  public int FNp;
  public int FNq;
  public int FNr;
  public int FNs;
  public String aeskey;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aeskey != null) {
        paramVarArgs.d(1, this.aeskey);
      }
      paramVarArgs.aS(2, this.FNi);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.FNj);
      paramVarArgs.aS(5, this.FNk);
      paramVarArgs.aS(6, this.FNl);
      paramVarArgs.aS(7, this.AsF);
      paramVarArgs.aS(8, this.AsE);
      if (this.md5 != null) {
        paramVarArgs.d(9, this.md5);
      }
      paramVarArgs.aS(10, this.FNm);
      paramVarArgs.aS(11, this.FNn);
      paramVarArgs.aS(12, this.FNo);
      paramVarArgs.aS(13, this.FNp);
      paramVarArgs.aS(14, this.FNq);
      paramVarArgs.aS(15, this.FNr);
      paramVarArgs.aS(16, this.FNs);
      AppMethodBeat.o(194969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = f.a.a.b.b.a.e(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FNi);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FNj) + f.a.a.b.b.a.bz(5, this.FNk) + f.a.a.b.b.a.bz(6, this.FNl) + f.a.a.b.b.a.bz(7, this.AsF) + f.a.a.b.b.a.bz(8, this.AsE);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.md5);
      }
      i = f.a.a.b.b.a.bz(10, this.FNm);
      int j = f.a.a.b.b.a.bz(11, this.FNn);
      int k = f.a.a.b.b.a.bz(12, this.FNo);
      int m = f.a.a.b.b.a.bz(13, this.FNp);
      int n = f.a.a.b.b.a.bz(14, this.FNq);
      int i1 = f.a.a.b.b.a.bz(15, this.FNr);
      int i2 = f.a.a.b.b.a.bz(16, this.FNs);
      AppMethodBeat.o(194969);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(194969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rg localrg = (rg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194969);
          return -1;
        case 1: 
          localrg.aeskey = locala.NPN.readString();
          AppMethodBeat.o(194969);
          return 0;
        case 2: 
          localrg.FNi = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 3: 
          localrg.url = locala.NPN.readString();
          AppMethodBeat.o(194969);
          return 0;
        case 4: 
          localrg.FNj = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 5: 
          localrg.FNk = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 6: 
          localrg.FNl = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 7: 
          localrg.AsF = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 8: 
          localrg.AsE = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 9: 
          localrg.md5 = locala.NPN.readString();
          AppMethodBeat.o(194969);
          return 0;
        case 10: 
          localrg.FNm = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 11: 
          localrg.FNn = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 12: 
          localrg.FNo = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 13: 
          localrg.FNp = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 14: 
          localrg.FNq = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        case 15: 
          localrg.FNr = locala.NPN.zc();
          AppMethodBeat.o(194969);
          return 0;
        }
        localrg.FNs = locala.NPN.zc();
        AppMethodBeat.o(194969);
        return 0;
      }
      AppMethodBeat.o(194969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */