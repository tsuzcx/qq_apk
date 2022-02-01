package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hd
  extends com.tencent.mm.bx.a
{
  public String CCb;
  public int CCc;
  public long CCd;
  public int CCe;
  public long CCf;
  public long CCg;
  public long CCh;
  public String CCi;
  public long CCj;
  public double CCk;
  public int CCl;
  public String CCm;
  public String Id;
  public int mBi;
  public String uKU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
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
      paramVarArgs.aG(10, this.CCh);
      if (this.CCi != null) {
        paramVarArgs.d(11, this.CCi);
      }
      paramVarArgs.aG(12, this.CCj);
      paramVarArgs.e(13, this.CCk);
      paramVarArgs.aR(14, this.CCl);
      if (this.CCm != null) {
        paramVarArgs.d(15, this.CCm);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label901;
      }
    }
    label901:
    for (int i = f.a.a.b.b.a.e(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uKU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uKU);
      }
      i = paramInt;
      if (this.CCb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CCb);
      }
      i = i + f.a.a.b.b.a.bA(4, this.CCc) + f.a.a.b.b.a.q(5, this.CCd) + f.a.a.b.b.a.bA(6, this.CCe) + f.a.a.b.b.a.bA(7, this.mBi) + f.a.a.b.b.a.q(8, this.CCf) + f.a.a.b.b.a.q(9, this.CCg) + f.a.a.b.b.a.q(10, this.CCh);
      paramInt = i;
      if (this.CCi != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CCi);
      }
      i = paramInt + f.a.a.b.b.a.q(12, this.CCj) + (f.a.a.b.b.a.fY(13) + 8) + f.a.a.b.b.a.bA(14, this.CCl);
      paramInt = i;
      if (this.CCm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CCm);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hd localhd = (hd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localhd.Id = locala.KhF.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localhd.uKU = locala.KhF.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localhd.CCb = locala.KhF.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localhd.CCc = locala.KhF.xS();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localhd.CCd = locala.KhF.xT();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localhd.CCe = locala.KhF.xS();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localhd.mBi = locala.KhF.xS();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localhd.CCf = locala.KhF.xT();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localhd.CCg = locala.KhF.xT();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localhd.CCh = locala.KhF.xT();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localhd.CCi = locala.KhF.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localhd.CCj = locala.KhF.xT();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localhd.CCk = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localhd.CCl = locala.KhF.xS();
          AppMethodBeat.o(87872);
          return 0;
        }
        localhd.CCm = locala.KhF.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hd
 * JD-Core Version:    0.7.0.1
 */