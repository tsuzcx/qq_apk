package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alb
  extends com.tencent.mm.bw.a
{
  public int GCA;
  public int GCB;
  public int GCC;
  public int GCD;
  public int GCE;
  public int GCF;
  public int GCt;
  public int GCu;
  public int GCv;
  public int GCw;
  public int GCx;
  public int GCy;
  public int GCz;
  public int fileCount;
  public int tRD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GCt);
      paramVarArgs.aS(2, this.GCu);
      paramVarArgs.aS(3, this.GCv);
      paramVarArgs.aS(4, this.tRD);
      paramVarArgs.aS(5, this.GCw);
      paramVarArgs.aS(6, this.GCx);
      paramVarArgs.aS(7, this.GCy);
      paramVarArgs.aS(8, this.fileCount);
      paramVarArgs.aS(9, this.GCz);
      paramVarArgs.aS(10, this.GCA);
      paramVarArgs.aS(11, this.GCB);
      paramVarArgs.aS(12, this.GCC);
      paramVarArgs.aS(13, this.GCD);
      paramVarArgs.aS(14, this.GCE);
      paramVarArgs.aS(15, this.GCF);
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GCt);
      int i = f.a.a.b.b.a.bz(2, this.GCu);
      int j = f.a.a.b.b.a.bz(3, this.GCv);
      int k = f.a.a.b.b.a.bz(4, this.tRD);
      int m = f.a.a.b.b.a.bz(5, this.GCw);
      int n = f.a.a.b.b.a.bz(6, this.GCx);
      int i1 = f.a.a.b.b.a.bz(7, this.GCy);
      int i2 = f.a.a.b.b.a.bz(8, this.fileCount);
      int i3 = f.a.a.b.b.a.bz(9, this.GCz);
      int i4 = f.a.a.b.b.a.bz(10, this.GCA);
      int i5 = f.a.a.b.b.a.bz(11, this.GCB);
      int i6 = f.a.a.b.b.a.bz(12, this.GCC);
      int i7 = f.a.a.b.b.a.bz(13, this.GCD);
      int i8 = f.a.a.b.b.a.bz(14, this.GCE);
      int i9 = f.a.a.b.b.a.bz(15, this.GCF);
      AppMethodBeat.o(127492);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127492);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alb localalb = (alb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127492);
        return -1;
      case 1: 
        localalb.GCt = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 2: 
        localalb.GCu = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 3: 
        localalb.GCv = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 4: 
        localalb.tRD = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 5: 
        localalb.GCw = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 6: 
        localalb.GCx = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 7: 
        localalb.GCy = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 8: 
        localalb.fileCount = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 9: 
        localalb.GCz = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 10: 
        localalb.GCA = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 11: 
        localalb.GCB = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 12: 
        localalb.GCC = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 13: 
        localalb.GCD = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      case 14: 
        localalb.GCE = locala.OmT.zc();
        AppMethodBeat.o(127492);
        return 0;
      }
      localalb.GCF = locala.OmT.zc();
      AppMethodBeat.o(127492);
      return 0;
    }
    AppMethodBeat.o(127492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alb
 * JD-Core Version:    0.7.0.1
 */