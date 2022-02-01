package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjc
  extends com.tencent.mm.bw.a
{
  public String DTH;
  public String DXq;
  public String EXZ;
  public String EYa;
  public int EYb;
  public int EYc;
  public int EYd;
  public int EYe;
  public String EYf;
  public String EYg;
  public String EYh;
  public String EYi;
  public int EYj;
  public String IconUrl;
  public int eNj;
  public long eNk;
  public String eNl;
  public String eNm;
  public String eNn;
  public String eNo;
  public String iJY;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXZ != null) {
        paramVarArgs.d(1, this.EXZ);
      }
      if (this.DTH != null) {
        paramVarArgs.d(2, this.DTH);
      }
      if (this.DXq != null) {
        paramVarArgs.d(3, this.DXq);
      }
      if (this.EYa != null) {
        paramVarArgs.d(4, this.EYa);
      }
      paramVarArgs.aR(5, this.EYb);
      paramVarArgs.aR(6, this.EYc);
      paramVarArgs.aR(7, this.EYd);
      paramVarArgs.aR(8, this.EYe);
      if (this.EYf != null) {
        paramVarArgs.d(9, this.EYf);
      }
      if (this.iJY != null) {
        paramVarArgs.d(10, this.iJY);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(11, this.IconUrl);
      }
      if (this.thh != null) {
        paramVarArgs.d(12, this.thh);
      }
      if (this.EYg != null) {
        paramVarArgs.d(13, this.EYg);
      }
      if (this.EYh != null) {
        paramVarArgs.d(14, this.EYh);
      }
      if (this.EYi != null) {
        paramVarArgs.d(15, this.EYi);
      }
      paramVarArgs.aR(16, this.EYj);
      paramVarArgs.aR(17, this.eNj);
      paramVarArgs.aO(18, this.eNk);
      if (this.eNl != null) {
        paramVarArgs.d(19, this.eNl);
      }
      if (this.eNm != null) {
        paramVarArgs.d(20, this.eNm);
      }
      if (this.eNn != null) {
        paramVarArgs.d(21, this.eNn);
      }
      if (this.eNo != null) {
        paramVarArgs.d(22, this.eNo);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EXZ == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = f.a.a.b.b.a.e(1, this.EXZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DTH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DTH);
      }
      i = paramInt;
      if (this.DXq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DXq);
      }
      paramInt = i;
      if (this.EYa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EYa);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EYb) + f.a.a.b.b.a.bx(6, this.EYc) + f.a.a.b.b.a.bx(7, this.EYd) + f.a.a.b.b.a.bx(8, this.EYe);
      paramInt = i;
      if (this.EYf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EYf);
      }
      i = paramInt;
      if (this.iJY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iJY);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IconUrl);
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.thh);
      }
      paramInt = i;
      if (this.EYg != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EYg);
      }
      i = paramInt;
      if (this.EYh != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EYh);
      }
      paramInt = i;
      if (this.EYi != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EYi);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.EYj) + f.a.a.b.b.a.bx(17, this.eNj) + f.a.a.b.b.a.p(18, this.eNk);
      paramInt = i;
      if (this.eNl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.eNl);
      }
      i = paramInt;
      if (this.eNm != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.eNm);
      }
      paramInt = i;
      if (this.eNn != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.eNn);
      }
      i = paramInt;
      if (this.eNo != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.eNo);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjc localbjc = (bjc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localbjc.EXZ = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localbjc.DTH = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localbjc.DXq = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localbjc.EYa = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localbjc.EYb = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localbjc.EYc = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localbjc.EYd = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localbjc.EYe = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localbjc.EYf = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localbjc.iJY = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localbjc.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localbjc.thh = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localbjc.EYg = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localbjc.EYh = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localbjc.EYi = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localbjc.EYj = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localbjc.eNj = locala.LVo.xF();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localbjc.eNk = locala.LVo.xG();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localbjc.eNl = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localbjc.eNm = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localbjc.eNn = locala.LVo.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localbjc.eNo = locala.LVo.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjc
 * JD-Core Version:    0.7.0.1
 */