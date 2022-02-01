package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hp
  extends com.tencent.mm.bw.a
{
  public double FSA;
  public int FSB;
  public long FSD;
  public int FSE;
  public String FSq;
  public String FSr;
  public int FSs;
  public long FSt;
  public int FSu;
  public long FSv;
  public long FSw;
  public long FSz;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FSD);
      if (this.FSq != null) {
        paramVarArgs.d(2, this.FSq);
      }
      if (this.FSr != null) {
        paramVarArgs.d(3, this.FSr);
      }
      paramVarArgs.aS(4, this.FSs);
      paramVarArgs.aZ(5, this.FSt);
      paramVarArgs.aS(6, this.FSu);
      paramVarArgs.aS(7, this.nJb);
      paramVarArgs.aZ(8, this.FSv);
      paramVarArgs.aZ(9, this.FSw);
      paramVarArgs.aS(10, this.FSE);
      paramVarArgs.aZ(11, this.FSz);
      paramVarArgs.e(12, this.FSA);
      paramVarArgs.aS(13, this.FSB);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FSD) + 0;
      paramInt = i;
      if (this.FSq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSq);
      }
      i = paramInt;
      if (this.FSr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSr);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FSs);
      int j = f.a.a.b.b.a.p(5, this.FSt);
      int k = f.a.a.b.b.a.bz(6, this.FSu);
      int m = f.a.a.b.b.a.bz(7, this.nJb);
      int n = f.a.a.b.b.a.p(8, this.FSv);
      int i1 = f.a.a.b.b.a.p(9, this.FSw);
      int i2 = f.a.a.b.b.a.bz(10, this.FSE);
      int i3 = f.a.a.b.b.a.p(11, this.FSz);
      int i4 = f.a.a.b.b.a.amD(12);
      int i5 = f.a.a.b.b.a.bz(13, this.FSB);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hp localhp = (hp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localhp.FSD = locala.OmT.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localhp.FSq = locala.OmT.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localhp.FSr = locala.OmT.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localhp.FSs = locala.OmT.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localhp.FSt = locala.OmT.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localhp.FSu = locala.OmT.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localhp.nJb = locala.OmT.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localhp.FSv = locala.OmT.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localhp.FSw = locala.OmT.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localhp.FSE = locala.OmT.zc();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localhp.FSz = locala.OmT.zd();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localhp.FSA = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(87873);
        return 0;
      }
      localhp.FSB = locala.OmT.zc();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hp
 * JD-Core Version:    0.7.0.1
 */