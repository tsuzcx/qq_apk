package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkd
  extends com.tencent.mm.bw.a
{
  public String DKT;
  public String EPH;
  public long EZG;
  public String EZI;
  public int EZK;
  public int EZL;
  public String EZM;
  public int EbF;
  public int lRv;
  public int nUh;
  public String nVJ;
  public String oGN;
  public int state;
  public String ugH;
  public String wEV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EPH != null) {
        paramVarArgs.d(1, this.EPH);
      }
      if (this.DKT != null) {
        paramVarArgs.d(2, this.DKT);
      }
      paramVarArgs.aO(3, this.EZG);
      paramVarArgs.aR(4, this.state);
      paramVarArgs.aR(5, this.EbF);
      paramVarArgs.aR(6, this.nUh);
      paramVarArgs.aR(7, this.EZK);
      paramVarArgs.aR(8, this.EZL);
      if (this.EZM != null) {
        paramVarArgs.d(9, this.EZM);
      }
      if (this.nVJ != null) {
        paramVarArgs.d(10, this.nVJ);
      }
      if (this.ugH != null) {
        paramVarArgs.d(11, this.ugH);
      }
      if (this.oGN != null) {
        paramVarArgs.d(12, this.oGN);
      }
      if (this.wEV != null) {
        paramVarArgs.d(13, this.wEV);
      }
      if (this.EZI != null) {
        paramVarArgs.d(14, this.EZI);
      }
      paramVarArgs.aR(15, this.lRv);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EPH == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.b.b.a.e(1, this.EPH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DKT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DKT);
      }
      i = i + f.a.a.b.b.a.p(3, this.EZG) + f.a.a.b.b.a.bx(4, this.state) + f.a.a.b.b.a.bx(5, this.EbF) + f.a.a.b.b.a.bx(6, this.nUh) + f.a.a.b.b.a.bx(7, this.EZK) + f.a.a.b.b.a.bx(8, this.EZL);
      paramInt = i;
      if (this.EZM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EZM);
      }
      i = paramInt;
      if (this.nVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.nVJ);
      }
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ugH);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.oGN);
      }
      paramInt = i;
      if (this.wEV != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.wEV);
      }
      i = paramInt;
      if (this.EZI != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EZI);
      }
      paramInt = f.a.a.b.b.a.bx(15, this.lRv);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkd localbkd = (bkd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localbkd.EPH = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localbkd.DKT = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localbkd.EZG = locala.LVo.xG();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localbkd.state = locala.LVo.xF();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localbkd.EbF = locala.LVo.xF();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localbkd.nUh = locala.LVo.xF();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localbkd.EZK = locala.LVo.xF();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localbkd.EZL = locala.LVo.xF();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localbkd.EZM = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localbkd.nVJ = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localbkd.ugH = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localbkd.oGN = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localbkd.wEV = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localbkd.EZI = locala.LVo.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localbkd.lRv = locala.LVo.xF();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkd
 * JD-Core Version:    0.7.0.1
 */