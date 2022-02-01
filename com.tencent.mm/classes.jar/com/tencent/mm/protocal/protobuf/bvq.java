package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bvq
  extends com.tencent.mm.bw.a
{
  public long FKy;
  public b HiA;
  public b HiB;
  public String HiC;
  public long HiD;
  public long HiE;
  public String HiF;
  public String Hii;
  public int Hiw;
  public int Hix;
  public int Hiy;
  public b Hiz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215588);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hiw);
      if (this.Hii != null) {
        paramVarArgs.d(2, this.Hii);
      }
      paramVarArgs.aS(3, this.Hix);
      paramVarArgs.aS(4, this.Hiy);
      if (this.Hiz != null) {
        paramVarArgs.c(5, this.Hiz);
      }
      if (this.HiA != null) {
        paramVarArgs.c(6, this.HiA);
      }
      if (this.HiB != null) {
        paramVarArgs.c(7, this.HiB);
      }
      if (this.HiC != null) {
        paramVarArgs.d(8, this.HiC);
      }
      paramVarArgs.aZ(9, this.HiD);
      paramVarArgs.aZ(10, this.HiE);
      paramVarArgs.aZ(11, this.FKy);
      if (this.HiF != null) {
        paramVarArgs.d(12, this.HiF);
      }
      AppMethodBeat.o(215588);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hiw) + 0;
      paramInt = i;
      if (this.Hii != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hii);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Hix) + f.a.a.b.b.a.bz(4, this.Hiy);
      paramInt = i;
      if (this.Hiz != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Hiz);
      }
      i = paramInt;
      if (this.HiA != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.HiA);
      }
      paramInt = i;
      if (this.HiB != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.HiB);
      }
      i = paramInt;
      if (this.HiC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HiC);
      }
      i = i + f.a.a.b.b.a.p(9, this.HiD) + f.a.a.b.b.a.p(10, this.HiE) + f.a.a.b.b.a.p(11, this.FKy);
      paramInt = i;
      if (this.HiF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HiF);
      }
      AppMethodBeat.o(215588);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(215588);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvq localbvq = (bvq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215588);
        return -1;
      case 1: 
        localbvq.Hiw = locala.OmT.zc();
        AppMethodBeat.o(215588);
        return 0;
      case 2: 
        localbvq.Hii = locala.OmT.readString();
        AppMethodBeat.o(215588);
        return 0;
      case 3: 
        localbvq.Hix = locala.OmT.zc();
        AppMethodBeat.o(215588);
        return 0;
      case 4: 
        localbvq.Hiy = locala.OmT.zc();
        AppMethodBeat.o(215588);
        return 0;
      case 5: 
        localbvq.Hiz = locala.OmT.gCk();
        AppMethodBeat.o(215588);
        return 0;
      case 6: 
        localbvq.HiA = locala.OmT.gCk();
        AppMethodBeat.o(215588);
        return 0;
      case 7: 
        localbvq.HiB = locala.OmT.gCk();
        AppMethodBeat.o(215588);
        return 0;
      case 8: 
        localbvq.HiC = locala.OmT.readString();
        AppMethodBeat.o(215588);
        return 0;
      case 9: 
        localbvq.HiD = locala.OmT.zd();
        AppMethodBeat.o(215588);
        return 0;
      case 10: 
        localbvq.HiE = locala.OmT.zd();
        AppMethodBeat.o(215588);
        return 0;
      case 11: 
        localbvq.FKy = locala.OmT.zd();
        AppMethodBeat.o(215588);
        return 0;
      }
      localbvq.HiF = locala.OmT.readString();
      AppMethodBeat.o(215588);
      return 0;
    }
    AppMethodBeat.o(215588);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvq
 * JD-Core Version:    0.7.0.1
 */