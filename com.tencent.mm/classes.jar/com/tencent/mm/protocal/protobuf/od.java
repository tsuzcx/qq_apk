package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class od
  extends com.tencent.mm.bx.a
{
  public int KyM;
  public String YQI;
  public int YQJ;
  public String YQK;
  public String YQL;
  public String YQM;
  public String YQN;
  public String YQO;
  public String YQP;
  public int YQQ;
  public int YQR;
  public int YQS;
  public int YQT;
  public String YQU;
  public String YQV;
  public int YQW;
  public int YQX;
  public int YQY;
  public String YQZ;
  public String YRa;
  public int YRb;
  public String YRc;
  public int YRd;
  public int YRe;
  public b YRf;
  public int YRg;
  public edn YRh;
  public String YRi;
  public String YRj;
  public String YRk;
  public String hAP;
  public int nUA;
  public String nUB;
  public int nUt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124399);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.YQI != null) {
        paramVarArgs.g(2, this.YQI);
      }
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      paramVarArgs.bS(4, this.YQJ);
      if (this.YQK != null) {
        paramVarArgs.g(5, this.YQK);
      }
      if (this.YQL != null) {
        paramVarArgs.g(6, this.YQL);
      }
      if (this.YQM != null) {
        paramVarArgs.g(7, this.YQM);
      }
      if (this.YQN != null) {
        paramVarArgs.g(8, this.YQN);
      }
      if (this.YQO != null) {
        paramVarArgs.g(9, this.YQO);
      }
      paramVarArgs.bS(10, this.nUA);
      if (this.YQP != null) {
        paramVarArgs.g(11, this.YQP);
      }
      paramVarArgs.bS(12, this.YQQ);
      paramVarArgs.bS(13, this.YQR);
      paramVarArgs.bS(14, this.YQS);
      paramVarArgs.bS(15, this.YQT);
      if (this.YQU != null) {
        paramVarArgs.g(16, this.YQU);
      }
      if (this.YQV != null) {
        paramVarArgs.g(17, this.YQV);
      }
      paramVarArgs.bS(18, this.YQW);
      paramVarArgs.bS(19, this.YQX);
      paramVarArgs.bS(20, this.YQY);
      if (this.YQZ != null) {
        paramVarArgs.g(21, this.YQZ);
      }
      if (this.YRa != null) {
        paramVarArgs.g(22, this.YRa);
      }
      paramVarArgs.bS(23, this.YRb);
      if (this.YRc != null) {
        paramVarArgs.g(24, this.YRc);
      }
      paramVarArgs.bS(25, this.YRd);
      paramVarArgs.bS(26, this.YRe);
      if (this.YRf != null) {
        paramVarArgs.d(27, this.YRf);
      }
      paramVarArgs.bS(28, this.KyM);
      paramVarArgs.bS(29, this.YRg);
      paramVarArgs.bS(30, this.nUt);
      if (this.YRh != null)
      {
        paramVarArgs.qD(31, this.YRh.computeSize());
        this.YRh.writeFields(paramVarArgs);
      }
      if (this.YRi != null) {
        paramVarArgs.g(32, this.YRi);
      }
      if (this.YRj != null) {
        paramVarArgs.g(33, this.YRj);
      }
      if (this.YRk != null) {
        paramVarArgs.g(36, this.YRk);
      }
      AppMethodBeat.o(124399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label2076;
      }
    }
    label2076:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YQI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YQI);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      i += i.a.a.b.b.a.cJ(4, this.YQJ);
      paramInt = i;
      if (this.YQK != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YQK);
      }
      i = paramInt;
      if (this.YQL != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YQL);
      }
      paramInt = i;
      if (this.YQM != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YQM);
      }
      i = paramInt;
      if (this.YQN != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YQN);
      }
      paramInt = i;
      if (this.YQO != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YQO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.nUA);
      paramInt = i;
      if (this.YQP != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YQP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.YQQ) + i.a.a.b.b.a.cJ(13, this.YQR) + i.a.a.b.b.a.cJ(14, this.YQS) + i.a.a.b.b.a.cJ(15, this.YQT);
      paramInt = i;
      if (this.YQU != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YQU);
      }
      i = paramInt;
      if (this.YQV != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.YQV);
      }
      i = i + i.a.a.b.b.a.cJ(18, this.YQW) + i.a.a.b.b.a.cJ(19, this.YQX) + i.a.a.b.b.a.cJ(20, this.YQY);
      paramInt = i;
      if (this.YQZ != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YQZ);
      }
      i = paramInt;
      if (this.YRa != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.YRa);
      }
      i += i.a.a.b.b.a.cJ(23, this.YRb);
      paramInt = i;
      if (this.YRc != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.YRc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.YRd) + i.a.a.b.b.a.cJ(26, this.YRe);
      paramInt = i;
      if (this.YRf != null) {
        paramInt = i + i.a.a.b.b.a.c(27, this.YRf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(28, this.KyM) + i.a.a.b.b.a.cJ(29, this.YRg) + i.a.a.b.b.a.cJ(30, this.nUt);
      paramInt = i;
      if (this.YRh != null) {
        paramInt = i + i.a.a.a.qC(31, this.YRh.computeSize());
      }
      i = paramInt;
      if (this.YRi != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.YRi);
      }
      paramInt = i;
      if (this.YRj != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.YRj);
      }
      i = paramInt;
      if (this.YRk != null) {
        i = paramInt + i.a.a.b.b.a.h(36, this.YRk);
      }
      AppMethodBeat.o(124399);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124399);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        od localod = (od)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 34: 
        case 35: 
        default: 
          AppMethodBeat.o(124399);
          return -1;
        case 1: 
          localod.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 2: 
          localod.YQI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 3: 
          localod.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 4: 
          localod.YQJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 5: 
          localod.YQK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 6: 
          localod.YQL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 7: 
          localod.YQM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 8: 
          localod.YQN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 9: 
          localod.YQO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 10: 
          localod.nUA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 11: 
          localod.YQP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 12: 
          localod.YQQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 13: 
          localod.YQR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 14: 
          localod.YQS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 15: 
          localod.YQT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 16: 
          localod.YQU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 17: 
          localod.YQV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 18: 
          localod.YQW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 19: 
          localod.YQX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 20: 
          localod.YQY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 21: 
          localod.YQZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 22: 
          localod.YRa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 23: 
          localod.YRb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 24: 
          localod.YRc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 25: 
          localod.YRd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 26: 
          localod.YRe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 27: 
          localod.YRf = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(124399);
          return 0;
        case 28: 
          localod.KyM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 29: 
          localod.YRg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 30: 
          localod.nUt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124399);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            edn localedn = new edn();
            if ((localObject != null) && (localObject.length > 0)) {
              localedn.parseFrom((byte[])localObject);
            }
            localod.YRh = localedn;
            paramInt += 1;
          }
          AppMethodBeat.o(124399);
          return 0;
        case 32: 
          localod.YRi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 33: 
          localod.YRj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124399);
          return 0;
        }
        localod.YRk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124399);
        return 0;
      }
      AppMethodBeat.o(124399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.od
 * JD-Core Version:    0.7.0.1
 */