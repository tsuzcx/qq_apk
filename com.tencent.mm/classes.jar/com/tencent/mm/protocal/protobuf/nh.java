package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class nh
  extends com.tencent.mm.bw.a
{
  public int KSA;
  public String KSB;
  public int KSC;
  public int KSD;
  public b KSE;
  public int KSF;
  public dbo KSG;
  public String KSH;
  public String KSI;
  public String KSh;
  public int KSi;
  public String KSj;
  public String KSk;
  public String KSl;
  public String KSm;
  public String KSn;
  public String KSo;
  public int KSp;
  public int KSq;
  public int KSr;
  public int KSs;
  public String KSt;
  public String KSu;
  public int KSv;
  public int KSw;
  public int KSx;
  public String KSy;
  public String KSz;
  public String Title;
  public int iAb;
  public String iAc;
  public int izV;
  public int zbj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124399);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.KSh != null) {
        paramVarArgs.e(2, this.KSh);
      }
      if (this.iAc != null) {
        paramVarArgs.e(3, this.iAc);
      }
      paramVarArgs.aM(4, this.KSi);
      if (this.KSj != null) {
        paramVarArgs.e(5, this.KSj);
      }
      if (this.KSk != null) {
        paramVarArgs.e(6, this.KSk);
      }
      if (this.KSl != null) {
        paramVarArgs.e(7, this.KSl);
      }
      if (this.KSm != null) {
        paramVarArgs.e(8, this.KSm);
      }
      if (this.KSn != null) {
        paramVarArgs.e(9, this.KSn);
      }
      paramVarArgs.aM(10, this.iAb);
      if (this.KSo != null) {
        paramVarArgs.e(11, this.KSo);
      }
      paramVarArgs.aM(12, this.KSp);
      paramVarArgs.aM(13, this.KSq);
      paramVarArgs.aM(14, this.KSr);
      paramVarArgs.aM(15, this.KSs);
      if (this.KSt != null) {
        paramVarArgs.e(16, this.KSt);
      }
      if (this.KSu != null) {
        paramVarArgs.e(17, this.KSu);
      }
      paramVarArgs.aM(18, this.KSv);
      paramVarArgs.aM(19, this.KSw);
      paramVarArgs.aM(20, this.KSx);
      if (this.KSy != null) {
        paramVarArgs.e(21, this.KSy);
      }
      if (this.KSz != null) {
        paramVarArgs.e(22, this.KSz);
      }
      paramVarArgs.aM(23, this.KSA);
      if (this.KSB != null) {
        paramVarArgs.e(24, this.KSB);
      }
      paramVarArgs.aM(25, this.KSC);
      paramVarArgs.aM(26, this.KSD);
      if (this.KSE != null) {
        paramVarArgs.c(27, this.KSE);
      }
      paramVarArgs.aM(28, this.zbj);
      paramVarArgs.aM(29, this.KSF);
      paramVarArgs.aM(30, this.izV);
      if (this.KSG != null)
      {
        paramVarArgs.ni(31, this.KSG.computeSize());
        this.KSG.writeFields(paramVarArgs);
      }
      if (this.KSH != null) {
        paramVarArgs.e(32, this.KSH);
      }
      if (this.KSI != null) {
        paramVarArgs.e(33, this.KSI);
      }
      AppMethodBeat.o(124399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label2030;
      }
    }
    label2030:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KSh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KSh);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAc);
      }
      i += g.a.a.b.b.a.bu(4, this.KSi);
      paramInt = i;
      if (this.KSj != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KSj);
      }
      i = paramInt;
      if (this.KSk != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KSk);
      }
      paramInt = i;
      if (this.KSl != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KSl);
      }
      i = paramInt;
      if (this.KSm != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KSm);
      }
      paramInt = i;
      if (this.KSn != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KSn);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.iAb);
      paramInt = i;
      if (this.KSo != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KSo);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.KSp) + g.a.a.b.b.a.bu(13, this.KSq) + g.a.a.b.b.a.bu(14, this.KSr) + g.a.a.b.b.a.bu(15, this.KSs);
      paramInt = i;
      if (this.KSt != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KSt);
      }
      i = paramInt;
      if (this.KSu != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.KSu);
      }
      i = i + g.a.a.b.b.a.bu(18, this.KSv) + g.a.a.b.b.a.bu(19, this.KSw) + g.a.a.b.b.a.bu(20, this.KSx);
      paramInt = i;
      if (this.KSy != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KSy);
      }
      i = paramInt;
      if (this.KSz != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.KSz);
      }
      i += g.a.a.b.b.a.bu(23, this.KSA);
      paramInt = i;
      if (this.KSB != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.KSB);
      }
      i = paramInt + g.a.a.b.b.a.bu(25, this.KSC) + g.a.a.b.b.a.bu(26, this.KSD);
      paramInt = i;
      if (this.KSE != null) {
        paramInt = i + g.a.a.b.b.a.b(27, this.KSE);
      }
      i = paramInt + g.a.a.b.b.a.bu(28, this.zbj) + g.a.a.b.b.a.bu(29, this.KSF) + g.a.a.b.b.a.bu(30, this.izV);
      paramInt = i;
      if (this.KSG != null) {
        paramInt = i + g.a.a.a.nh(31, this.KSG.computeSize());
      }
      i = paramInt;
      if (this.KSH != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.KSH);
      }
      paramInt = i;
      if (this.KSI != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.KSI);
      }
      AppMethodBeat.o(124399);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124399);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124399);
          return -1;
        case 1: 
          localnh.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 2: 
          localnh.KSh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 3: 
          localnh.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 4: 
          localnh.KSi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 5: 
          localnh.KSj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 6: 
          localnh.KSk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 7: 
          localnh.KSl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 8: 
          localnh.KSm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 9: 
          localnh.KSn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 10: 
          localnh.iAb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 11: 
          localnh.KSo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 12: 
          localnh.KSp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 13: 
          localnh.KSq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 14: 
          localnh.KSr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 15: 
          localnh.KSs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 16: 
          localnh.KSt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 17: 
          localnh.KSu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 18: 
          localnh.KSv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 19: 
          localnh.KSw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 20: 
          localnh.KSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 21: 
          localnh.KSy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 22: 
          localnh.KSz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 23: 
          localnh.KSA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 24: 
          localnh.KSB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 25: 
          localnh.KSC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 26: 
          localnh.KSD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 27: 
          localnh.KSE = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(124399);
          return 0;
        case 28: 
          localnh.zbj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 29: 
          localnh.KSF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 30: 
          localnh.izV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124399);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnh.KSG = ((dbo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124399);
          return 0;
        case 32: 
          localnh.KSH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124399);
          return 0;
        }
        localnh.KSI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124399);
        return 0;
      }
      AppMethodBeat.o(124399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nh
 * JD-Core Version:    0.7.0.1
 */