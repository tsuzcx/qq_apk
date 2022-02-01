package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aku
  extends com.tencent.mm.bx.a
{
  public String FUv;
  public long Gkj;
  public long Gkk;
  public long Gkl;
  public String Gkm;
  public long Gkn;
  public String Gko;
  public String Gkp;
  public String Gkq;
  public String Gkr;
  public String Gks;
  public String Gkt;
  public int Gku;
  public String Gkv;
  public int Gkw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Gkj);
      paramVarArgs.aY(2, this.Gkk);
      paramVarArgs.aY(3, this.Gkl);
      if (this.Gkm != null) {
        paramVarArgs.d(4, this.Gkm);
      }
      paramVarArgs.aY(5, this.Gkn);
      if (this.Gko != null) {
        paramVarArgs.d(6, this.Gko);
      }
      if (this.Gkp != null) {
        paramVarArgs.d(7, this.Gkp);
      }
      if (this.Gkq != null) {
        paramVarArgs.d(8, this.Gkq);
      }
      if (this.Gkr != null) {
        paramVarArgs.d(9, this.Gkr);
      }
      if (this.Gks != null) {
        paramVarArgs.d(10, this.Gks);
      }
      if (this.Gkt != null) {
        paramVarArgs.d(11, this.Gkt);
      }
      paramVarArgs.aS(12, this.Gku);
      if (this.Gkv != null) {
        paramVarArgs.d(13, this.Gkv);
      }
      paramVarArgs.aS(14, this.Gkw);
      if (this.FUv != null) {
        paramVarArgs.d(15, this.FUv);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gkj) + 0 + f.a.a.b.b.a.p(2, this.Gkk) + f.a.a.b.b.a.p(3, this.Gkl);
      paramInt = i;
      if (this.Gkm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gkm);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Gkn);
      paramInt = i;
      if (this.Gko != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gko);
      }
      i = paramInt;
      if (this.Gkp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gkp);
      }
      paramInt = i;
      if (this.Gkq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gkq);
      }
      i = paramInt;
      if (this.Gkr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gkr);
      }
      paramInt = i;
      if (this.Gks != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gks);
      }
      i = paramInt;
      if (this.Gkt != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Gkt);
      }
      i += f.a.a.b.b.a.bz(12, this.Gku);
      paramInt = i;
      if (this.Gkv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Gkv);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.Gkw);
      paramInt = i;
      if (this.FUv != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FUv);
      }
      AppMethodBeat.o(91460);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aku localaku = (aku)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localaku.Gkj = locala.NPN.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localaku.Gkk = locala.NPN.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localaku.Gkl = locala.NPN.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localaku.Gkm = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localaku.Gkn = locala.NPN.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localaku.Gko = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localaku.Gkp = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localaku.Gkq = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localaku.Gkr = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localaku.Gks = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localaku.Gkt = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localaku.Gku = locala.NPN.zc();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localaku.Gkv = locala.NPN.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localaku.Gkw = locala.NPN.zc();
        AppMethodBeat.o(91460);
        return 0;
      }
      localaku.FUv = locala.NPN.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aku
 * JD-Core Version:    0.7.0.1
 */