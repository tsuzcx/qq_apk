package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqc
  extends com.tencent.mm.bw.a
{
  public String Eol;
  public String FDc;
  public long FDd;
  public int FDe;
  public int FDf;
  public int FDg;
  public int FDh;
  public int FDi;
  public int FDj;
  public float FDk;
  public float FDl;
  public float FDm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eol != null) {
        paramVarArgs.d(1, this.Eol);
      }
      if (this.FDc != null) {
        paramVarArgs.d(2, this.FDc);
      }
      paramVarArgs.aO(3, this.FDd);
      paramVarArgs.aR(4, this.FDe);
      paramVarArgs.aR(5, this.FDf);
      paramVarArgs.aR(6, this.FDg);
      paramVarArgs.aR(7, this.FDh);
      paramVarArgs.aR(8, this.FDi);
      paramVarArgs.aR(9, this.FDj);
      paramVarArgs.x(10, this.FDk);
      paramVarArgs.x(11, this.FDl);
      paramVarArgs.x(12, this.FDm);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eol == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eol) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FDc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FDc);
      }
      paramInt = f.a.a.b.b.a.p(3, this.FDd);
      int j = f.a.a.b.b.a.bx(4, this.FDe);
      int k = f.a.a.b.b.a.bx(5, this.FDf);
      int m = f.a.a.b.b.a.bx(6, this.FDg);
      int n = f.a.a.b.b.a.bx(7, this.FDh);
      int i1 = f.a.a.b.b.a.bx(8, this.FDi);
      int i2 = f.a.a.b.b.a.bx(9, this.FDj);
      int i3 = f.a.a.b.b.a.fK(10);
      int i4 = f.a.a.b.b.a.fK(11);
      int i5 = f.a.a.b.b.a.fK(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqc localcqc = (cqc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localcqc.Eol = locala.LVo.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localcqc.FDc = locala.LVo.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localcqc.FDd = locala.LVo.xG();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localcqc.FDe = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localcqc.FDf = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localcqc.FDg = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localcqc.FDh = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localcqc.FDi = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localcqc.FDj = locala.LVo.xF();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localcqc.FDk = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localcqc.FDl = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(87875);
          return 0;
        }
        localcqc.FDm = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */