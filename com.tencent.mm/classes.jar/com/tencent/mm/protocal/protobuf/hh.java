package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hh
  extends com.tencent.mm.bw.a
{
  public long DUA;
  public int DUB;
  public long DUC;
  public long DUD;
  public long DUE;
  public String DUF;
  public long DUG;
  public double DUH;
  public int DUI;
  public String DUJ;
  public String DUy;
  public int DUz;
  public String Id;
  public int ndj;
  public String vTL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.vTL != null) {
        paramVarArgs.d(2, this.vTL);
      }
      if (this.DUy != null) {
        paramVarArgs.d(3, this.DUy);
      }
      paramVarArgs.aR(4, this.DUz);
      paramVarArgs.aO(5, this.DUA);
      paramVarArgs.aR(6, this.DUB);
      paramVarArgs.aR(7, this.ndj);
      paramVarArgs.aO(8, this.DUC);
      paramVarArgs.aO(9, this.DUD);
      paramVarArgs.aO(10, this.DUE);
      if (this.DUF != null) {
        paramVarArgs.d(11, this.DUF);
      }
      paramVarArgs.aO(12, this.DUG);
      paramVarArgs.e(13, this.DUH);
      paramVarArgs.aR(14, this.DUI);
      if (this.DUJ != null) {
        paramVarArgs.d(15, this.DUJ);
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
      if (this.vTL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vTL);
      }
      i = paramInt;
      if (this.DUy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUy);
      }
      i = i + f.a.a.b.b.a.bx(4, this.DUz) + f.a.a.b.b.a.p(5, this.DUA) + f.a.a.b.b.a.bx(6, this.DUB) + f.a.a.b.b.a.bx(7, this.ndj) + f.a.a.b.b.a.p(8, this.DUC) + f.a.a.b.b.a.p(9, this.DUD) + f.a.a.b.b.a.p(10, this.DUE);
      paramInt = i;
      if (this.DUF != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DUF);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.DUG) + (f.a.a.b.b.a.fK(13) + 8) + f.a.a.b.b.a.bx(14, this.DUI);
      paramInt = i;
      if (this.DUJ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DUJ);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hh localhh = (hh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localhh.Id = locala.LVo.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localhh.vTL = locala.LVo.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localhh.DUy = locala.LVo.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localhh.DUz = locala.LVo.xF();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localhh.DUA = locala.LVo.xG();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localhh.DUB = locala.LVo.xF();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localhh.ndj = locala.LVo.xF();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localhh.DUC = locala.LVo.xG();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localhh.DUD = locala.LVo.xG();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localhh.DUE = locala.LVo.xG();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localhh.DUF = locala.LVo.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localhh.DUG = locala.LVo.xG();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localhh.DUH = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localhh.DUI = locala.LVo.xF();
          AppMethodBeat.o(87872);
          return 0;
        }
        localhh.DUJ = locala.LVo.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hh
 * JD-Core Version:    0.7.0.1
 */