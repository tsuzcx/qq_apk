package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ale
  extends com.tencent.mm.bw.a
{
  public long GCT;
  public long GCU;
  public long GCV;
  public String GCW;
  public long GCX;
  public String GCY;
  public String GCZ;
  public String GDa;
  public String GDb;
  public String GDc;
  public String GDd;
  public int GDe;
  public String GDf;
  public int GDg;
  public String GmU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GCT);
      paramVarArgs.aZ(2, this.GCU);
      paramVarArgs.aZ(3, this.GCV);
      if (this.GCW != null) {
        paramVarArgs.d(4, this.GCW);
      }
      paramVarArgs.aZ(5, this.GCX);
      if (this.GCY != null) {
        paramVarArgs.d(6, this.GCY);
      }
      if (this.GCZ != null) {
        paramVarArgs.d(7, this.GCZ);
      }
      if (this.GDa != null) {
        paramVarArgs.d(8, this.GDa);
      }
      if (this.GDb != null) {
        paramVarArgs.d(9, this.GDb);
      }
      if (this.GDc != null) {
        paramVarArgs.d(10, this.GDc);
      }
      if (this.GDd != null) {
        paramVarArgs.d(11, this.GDd);
      }
      paramVarArgs.aS(12, this.GDe);
      if (this.GDf != null) {
        paramVarArgs.d(13, this.GDf);
      }
      paramVarArgs.aS(14, this.GDg);
      if (this.GmU != null) {
        paramVarArgs.d(15, this.GmU);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GCT) + 0 + f.a.a.b.b.a.p(2, this.GCU) + f.a.a.b.b.a.p(3, this.GCV);
      paramInt = i;
      if (this.GCW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GCW);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.GCX);
      paramInt = i;
      if (this.GCY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GCY);
      }
      i = paramInt;
      if (this.GCZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GCZ);
      }
      paramInt = i;
      if (this.GDa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GDa);
      }
      i = paramInt;
      if (this.GDb != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GDb);
      }
      paramInt = i;
      if (this.GDc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GDc);
      }
      i = paramInt;
      if (this.GDd != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GDd);
      }
      i += f.a.a.b.b.a.bz(12, this.GDe);
      paramInt = i;
      if (this.GDf != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GDf);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.GDg);
      paramInt = i;
      if (this.GmU != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GmU);
      }
      AppMethodBeat.o(91460);
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
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ale localale = (ale)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localale.GCT = locala.OmT.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localale.GCU = locala.OmT.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localale.GCV = locala.OmT.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localale.GCW = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localale.GCX = locala.OmT.zd();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localale.GCY = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localale.GCZ = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localale.GDa = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localale.GDb = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localale.GDc = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localale.GDd = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localale.GDe = locala.OmT.zc();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localale.GDf = locala.OmT.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localale.GDg = locala.OmT.zc();
        AppMethodBeat.o(91460);
        return 0;
      }
      localale.GmU = locala.OmT.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ale
 * JD-Core Version:    0.7.0.1
 */