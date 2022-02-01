package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class he
  extends com.tencent.mm.bx.a
{
  public String CCb;
  public int CCc;
  public long CCd;
  public int CCe;
  public long CCf;
  public long CCg;
  public long CCj;
  public double CCk;
  public int CCl;
  public long CCn;
  public int CCo;
  public int mBi;
  public String uKU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CCn);
      if (this.uKU != null) {
        paramVarArgs.d(2, this.uKU);
      }
      if (this.CCb != null) {
        paramVarArgs.d(3, this.CCb);
      }
      paramVarArgs.aR(4, this.CCc);
      paramVarArgs.aG(5, this.CCd);
      paramVarArgs.aR(6, this.CCe);
      paramVarArgs.aR(7, this.mBi);
      paramVarArgs.aG(8, this.CCf);
      paramVarArgs.aG(9, this.CCg);
      paramVarArgs.aR(10, this.CCo);
      paramVarArgs.aG(11, this.CCj);
      paramVarArgs.e(12, this.CCk);
      paramVarArgs.aR(13, this.CCl);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.CCn) + 0;
      paramInt = i;
      if (this.uKU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uKU);
      }
      i = paramInt;
      if (this.CCb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CCb);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.CCc);
      int j = f.a.a.b.b.a.q(5, this.CCd);
      int k = f.a.a.b.b.a.bA(6, this.CCe);
      int m = f.a.a.b.b.a.bA(7, this.mBi);
      int n = f.a.a.b.b.a.q(8, this.CCf);
      int i1 = f.a.a.b.b.a.q(9, this.CCg);
      int i2 = f.a.a.b.b.a.bA(10, this.CCo);
      int i3 = f.a.a.b.b.a.q(11, this.CCj);
      int i4 = f.a.a.b.b.a.fY(12);
      int i5 = f.a.a.b.b.a.bA(13, this.CCl);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      he localhe = (he)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localhe.CCn = locala.KhF.xT();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localhe.uKU = locala.KhF.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localhe.CCb = locala.KhF.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localhe.CCc = locala.KhF.xS();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localhe.CCd = locala.KhF.xT();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localhe.CCe = locala.KhF.xS();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localhe.mBi = locala.KhF.xS();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localhe.CCf = locala.KhF.xT();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localhe.CCg = locala.KhF.xT();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localhe.CCo = locala.KhF.xS();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localhe.CCj = locala.KhF.xT();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localhe.CCk = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(87873);
        return 0;
      }
      localhe.CCl = locala.KhF.xS();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */