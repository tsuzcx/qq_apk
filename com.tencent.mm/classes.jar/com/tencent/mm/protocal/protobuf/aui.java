package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aui
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public int dCN;
  public long dCO;
  public String dCP;
  public String dCQ;
  public String dCR;
  public String dCS;
  public String gwU;
  public String npR;
  public String wrS;
  public String wuT;
  public String xji;
  public String xjj;
  public int xjk;
  public int xjl;
  public int xjm;
  public int xjn;
  public String xjo;
  public String xjp;
  public String xjq;
  public String xjr;
  public int xjs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10190);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xji != null) {
        paramVarArgs.e(1, this.xji);
      }
      if (this.wrS != null) {
        paramVarArgs.e(2, this.wrS);
      }
      if (this.wuT != null) {
        paramVarArgs.e(3, this.wuT);
      }
      if (this.xjj != null) {
        paramVarArgs.e(4, this.xjj);
      }
      paramVarArgs.aO(5, this.xjk);
      paramVarArgs.aO(6, this.xjl);
      paramVarArgs.aO(7, this.xjm);
      paramVarArgs.aO(8, this.xjn);
      if (this.xjo != null) {
        paramVarArgs.e(9, this.xjo);
      }
      if (this.gwU != null) {
        paramVarArgs.e(10, this.gwU);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(11, this.IconUrl);
      }
      if (this.npR != null) {
        paramVarArgs.e(12, this.npR);
      }
      if (this.xjp != null) {
        paramVarArgs.e(13, this.xjp);
      }
      if (this.xjq != null) {
        paramVarArgs.e(14, this.xjq);
      }
      if (this.xjr != null) {
        paramVarArgs.e(15, this.xjr);
      }
      paramVarArgs.aO(16, this.xjs);
      paramVarArgs.aO(17, this.dCN);
      paramVarArgs.am(18, this.dCO);
      if (this.dCP != null) {
        paramVarArgs.e(19, this.dCP);
      }
      if (this.dCQ != null) {
        paramVarArgs.e(20, this.dCQ);
      }
      if (this.dCR != null) {
        paramVarArgs.e(21, this.dCR);
      }
      if (this.dCS != null) {
        paramVarArgs.e(22, this.dCS);
      }
      AppMethodBeat.o(10190);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xji == null) {
        break label1414;
      }
    }
    label1414:
    for (int i = e.a.a.b.b.a.f(1, this.xji) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrS != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wrS);
      }
      i = paramInt;
      if (this.wuT != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wuT);
      }
      paramInt = i;
      if (this.xjj != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xjj);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xjk) + e.a.a.b.b.a.bl(6, this.xjl) + e.a.a.b.b.a.bl(7, this.xjm) + e.a.a.b.b.a.bl(8, this.xjn);
      paramInt = i;
      if (this.xjo != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xjo);
      }
      i = paramInt;
      if (this.gwU != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.gwU);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.IconUrl);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.npR);
      }
      paramInt = i;
      if (this.xjp != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xjp);
      }
      i = paramInt;
      if (this.xjq != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xjq);
      }
      paramInt = i;
      if (this.xjr != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.xjr);
      }
      i = paramInt + e.a.a.b.b.a.bl(16, this.xjs) + e.a.a.b.b.a.bl(17, this.dCN) + e.a.a.b.b.a.p(18, this.dCO);
      paramInt = i;
      if (this.dCP != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.dCP);
      }
      i = paramInt;
      if (this.dCQ != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.dCQ);
      }
      paramInt = i;
      if (this.dCR != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.dCR);
      }
      i = paramInt;
      if (this.dCS != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.dCS);
      }
      AppMethodBeat.o(10190);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10190);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10190);
          return -1;
        case 1: 
          localaui.xji = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 2: 
          localaui.wrS = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 3: 
          localaui.wuT = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 4: 
          localaui.xjj = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 5: 
          localaui.xjk = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 6: 
          localaui.xjl = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 7: 
          localaui.xjm = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 8: 
          localaui.xjn = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 9: 
          localaui.xjo = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 10: 
          localaui.gwU = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 11: 
          localaui.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 12: 
          localaui.npR = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 13: 
          localaui.xjp = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 14: 
          localaui.xjq = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 15: 
          localaui.xjr = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 16: 
          localaui.xjs = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 17: 
          localaui.dCN = locala.CLY.sl();
          AppMethodBeat.o(10190);
          return 0;
        case 18: 
          localaui.dCO = locala.CLY.sm();
          AppMethodBeat.o(10190);
          return 0;
        case 19: 
          localaui.dCP = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 20: 
          localaui.dCQ = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        case 21: 
          localaui.dCR = locala.CLY.readString();
          AppMethodBeat.o(10190);
          return 0;
        }
        localaui.dCS = locala.CLY.readString();
        AppMethodBeat.o(10190);
        return 0;
      }
      AppMethodBeat.o(10190);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */