package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzz
  extends com.tencent.mm.bw.a
{
  public String FoU;
  public String FoV;
  public int FoW;
  public String FoX;
  public String FoY;
  public String FoZ;
  public int Fpa;
  public int Fpb;
  public int Fpc;
  public long Fpd;
  public String bkl;
  public String dol;
  public String nYx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bkl != null) {
        paramVarArgs.d(1, this.bkl);
      }
      if (this.FoU != null) {
        paramVarArgs.d(2, this.FoU);
      }
      if (this.FoV != null) {
        paramVarArgs.d(3, this.FoV);
      }
      paramVarArgs.aR(4, this.FoW);
      if (this.dol != null) {
        paramVarArgs.d(5, this.dol);
      }
      if (this.FoX != null) {
        paramVarArgs.d(6, this.FoX);
      }
      if (this.FoY != null) {
        paramVarArgs.d(7, this.FoY);
      }
      if (this.nYx != null) {
        paramVarArgs.d(8, this.nYx);
      }
      if (this.FoZ != null) {
        paramVarArgs.d(9, this.FoZ);
      }
      paramVarArgs.aR(10, this.Fpa);
      paramVarArgs.aR(11, this.Fpb);
      paramVarArgs.aR(12, this.Fpc);
      paramVarArgs.aO(13, this.Fpd);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bkl == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.b.b.a.e(1, this.bkl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FoU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FoU);
      }
      i = paramInt;
      if (this.FoV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FoV);
      }
      i += f.a.a.b.b.a.bx(4, this.FoW);
      paramInt = i;
      if (this.dol != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dol);
      }
      i = paramInt;
      if (this.FoX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FoX);
      }
      paramInt = i;
      if (this.FoY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FoY);
      }
      i = paramInt;
      if (this.nYx != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nYx);
      }
      paramInt = i;
      if (this.FoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FoZ);
      }
      i = f.a.a.b.b.a.bx(10, this.Fpa);
      int j = f.a.a.b.b.a.bx(11, this.Fpb);
      int k = f.a.a.b.b.a.bx(12, this.Fpc);
      int m = f.a.a.b.b.a.p(13, this.Fpd);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzz localbzz = (bzz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localbzz.bkl = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localbzz.FoU = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localbzz.FoV = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localbzz.FoW = locala.LVo.xF();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localbzz.dol = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localbzz.FoX = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localbzz.FoY = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localbzz.nYx = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localbzz.FoZ = locala.LVo.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localbzz.Fpa = locala.LVo.xF();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localbzz.Fpb = locala.LVo.xF();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localbzz.Fpc = locala.LVo.xF();
          AppMethodBeat.o(152632);
          return 0;
        }
        localbzz.Fpd = locala.LVo.xG();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzz
 * JD-Core Version:    0.7.0.1
 */