package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbz
  extends com.tencent.mm.bw.a
{
  public int FpX;
  public int FpY;
  public int FpZ;
  public int Fqa;
  public int Fqb;
  public int Fqc;
  public int Fqd;
  public int Fqe;
  public int Fqf;
  public int Fqg;
  public int Fqh;
  public int Fqi;
  public int Fqj;
  public int Fqk;
  public int Fql;
  public int Fqm;
  public int Fqn;
  public int Fqo;
  public int rxN;
  public int rxS;
  public int rxT;
  public int rxU;
  public int rxV;
  public int rxW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FpX);
      paramVarArgs.aR(2, this.FpY);
      paramVarArgs.aR(3, this.FpZ);
      paramVarArgs.aR(4, this.Fqa);
      paramVarArgs.aR(5, this.Fqb);
      paramVarArgs.aR(6, this.rxN);
      paramVarArgs.aR(7, this.Fqc);
      paramVarArgs.aR(8, this.Fqd);
      paramVarArgs.aR(9, this.Fqe);
      paramVarArgs.aR(10, this.Fqf);
      paramVarArgs.aR(11, this.Fqg);
      paramVarArgs.aR(12, this.Fqh);
      paramVarArgs.aR(13, this.Fqi);
      paramVarArgs.aR(14, this.Fqj);
      paramVarArgs.aR(15, this.Fqk);
      paramVarArgs.aR(16, this.Fql);
      paramVarArgs.aR(17, this.Fqm);
      paramVarArgs.aR(18, this.Fqn);
      paramVarArgs.aR(19, this.Fqo);
      paramVarArgs.aR(20, this.rxS);
      paramVarArgs.aR(21, this.rxT);
      paramVarArgs.aR(22, this.rxU);
      paramVarArgs.aR(23, this.rxV);
      paramVarArgs.aR(24, this.rxW);
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FpX);
      int i = f.a.a.b.b.a.bx(2, this.FpY);
      int j = f.a.a.b.b.a.bx(3, this.FpZ);
      int k = f.a.a.b.b.a.bx(4, this.Fqa);
      int m = f.a.a.b.b.a.bx(5, this.Fqb);
      int n = f.a.a.b.b.a.bx(6, this.rxN);
      int i1 = f.a.a.b.b.a.bx(7, this.Fqc);
      int i2 = f.a.a.b.b.a.bx(8, this.Fqd);
      int i3 = f.a.a.b.b.a.bx(9, this.Fqe);
      int i4 = f.a.a.b.b.a.bx(10, this.Fqf);
      int i5 = f.a.a.b.b.a.bx(11, this.Fqg);
      int i6 = f.a.a.b.b.a.bx(12, this.Fqh);
      int i7 = f.a.a.b.b.a.bx(13, this.Fqi);
      int i8 = f.a.a.b.b.a.bx(14, this.Fqj);
      int i9 = f.a.a.b.b.a.bx(15, this.Fqk);
      int i10 = f.a.a.b.b.a.bx(16, this.Fql);
      int i11 = f.a.a.b.b.a.bx(17, this.Fqm);
      int i12 = f.a.a.b.b.a.bx(18, this.Fqn);
      int i13 = f.a.a.b.b.a.bx(19, this.Fqo);
      int i14 = f.a.a.b.b.a.bx(20, this.rxS);
      int i15 = f.a.a.b.b.a.bx(21, this.rxT);
      int i16 = f.a.a.b.b.a.bx(22, this.rxU);
      int i17 = f.a.a.b.b.a.bx(23, this.rxV);
      int i18 = f.a.a.b.b.a.bx(24, this.rxW);
      AppMethodBeat.o(169089);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17 + i18;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169089);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbz localcbz = (cbz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169089);
        return -1;
      case 1: 
        localcbz.FpX = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 2: 
        localcbz.FpY = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 3: 
        localcbz.FpZ = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 4: 
        localcbz.Fqa = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 5: 
        localcbz.Fqb = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 6: 
        localcbz.rxN = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 7: 
        localcbz.Fqc = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 8: 
        localcbz.Fqd = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 9: 
        localcbz.Fqe = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 10: 
        localcbz.Fqf = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 11: 
        localcbz.Fqg = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 12: 
        localcbz.Fqh = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 13: 
        localcbz.Fqi = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 14: 
        localcbz.Fqj = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 15: 
        localcbz.Fqk = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 16: 
        localcbz.Fql = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 17: 
        localcbz.Fqm = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 18: 
        localcbz.Fqn = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 19: 
        localcbz.Fqo = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 20: 
        localcbz.rxS = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 21: 
        localcbz.rxT = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 22: 
        localcbz.rxU = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      case 23: 
        localcbz.rxV = locala.LVo.xF();
        AppMethodBeat.o(169089);
        return 0;
      }
      localcbz.rxW = locala.LVo.xF();
      AppMethodBeat.o(169089);
      return 0;
    }
    AppMethodBeat.o(169089);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */