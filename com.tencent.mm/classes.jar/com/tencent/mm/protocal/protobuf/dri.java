package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dri
  extends dyy
{
  public int DgI;
  public String Olt;
  public String OmF;
  public dmu TLU;
  public String TXE;
  public String TXK;
  public String TXL;
  public String TXM;
  public int TXN;
  public LinkedList<aib> TXO;
  public int TXP;
  public LinkedList<aib> TXQ;
  public aib TXR;
  public LinkedList<aib> TXS;
  public aib TXT;
  public cxm TXU;
  public String TXV;
  public int TXW;
  public String TXX;
  public int TXY;
  public boolean TXZ;
  public String TYa;
  public String TYb;
  public LinkedList<dcf> TYc;
  public String TYd;
  public String TYe;
  public String TYf;
  public dcf TYg;
  public cpp TYh;
  public cpp TYi;
  public String TYj;
  public String TYk;
  public apg TYl;
  public LinkedList<dcf> TYm;
  public String TYn;
  public String TYo;
  public dcf TYp;
  public cqq TYq;
  public dcf TYr;
  public boolean TwU;
  public String Tyf;
  public String Tyg;
  public int dta;
  public ctd fZQ;
  public int gaz;
  public int tqa;
  public String tqb;
  
  public dri()
  {
    AppMethodBeat.i(91644);
    this.TXO = new LinkedList();
    this.TXQ = new LinkedList();
    this.TXS = new LinkedList();
    this.TYc = new LinkedList();
    this.TYm = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.dta);
      if (this.TXK != null) {
        paramVarArgs.f(5, this.TXK);
      }
      if (this.TXL != null) {
        paramVarArgs.f(6, this.TXL);
      }
      if (this.TXM != null) {
        paramVarArgs.f(7, this.TXM);
      }
      paramVarArgs.aY(8, this.TXN);
      paramVarArgs.e(9, 8, this.TXO);
      paramVarArgs.aY(10, this.gaz);
      paramVarArgs.aY(11, this.TXP);
      paramVarArgs.e(12, 8, this.TXQ);
      if (this.Tyg != null) {
        paramVarArgs.f(13, this.Tyg);
      }
      if (this.TXR != null)
      {
        paramVarArgs.oE(14, this.TXR.computeSize());
        this.TXR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.TXS);
      if (this.TXT != null)
      {
        paramVarArgs.oE(16, this.TXT.computeSize());
        this.TXT.writeFields(paramVarArgs);
      }
      if (this.TXU != null)
      {
        paramVarArgs.oE(17, this.TXU.computeSize());
        this.TXU.writeFields(paramVarArgs);
      }
      if (this.TXV != null) {
        paramVarArgs.f(18, this.TXV);
      }
      paramVarArgs.aY(19, this.TXW);
      if (this.TXX != null) {
        paramVarArgs.f(20, this.TXX);
      }
      if (this.TXE != null) {
        paramVarArgs.f(21, this.TXE);
      }
      paramVarArgs.aY(22, this.TXY);
      paramVarArgs.co(23, this.TXZ);
      paramVarArgs.aY(24, this.DgI);
      if (this.Tyf != null) {
        paramVarArgs.f(25, this.Tyf);
      }
      if (this.TYa != null) {
        paramVarArgs.f(26, this.TYa);
      }
      if (this.TYb != null) {
        paramVarArgs.f(27, this.TYb);
      }
      paramVarArgs.e(28, 8, this.TYc);
      if (this.TYd != null) {
        paramVarArgs.f(29, this.TYd);
      }
      if (this.TYe != null) {
        paramVarArgs.f(30, this.TYe);
      }
      if (this.TYf != null) {
        paramVarArgs.f(31, this.TYf);
      }
      if (this.Olt != null) {
        paramVarArgs.f(32, this.Olt);
      }
      if (this.TYg != null)
      {
        paramVarArgs.oE(33, this.TYg.computeSize());
        this.TYg.writeFields(paramVarArgs);
      }
      if (this.TYh != null)
      {
        paramVarArgs.oE(34, this.TYh.computeSize());
        this.TYh.writeFields(paramVarArgs);
      }
      if (this.TYi != null)
      {
        paramVarArgs.oE(35, this.TYi.computeSize());
        this.TYi.writeFields(paramVarArgs);
      }
      if (this.TYj != null) {
        paramVarArgs.f(36, this.TYj);
      }
      if (this.TYk != null) {
        paramVarArgs.f(37, this.TYk);
      }
      if (this.TYl != null)
      {
        paramVarArgs.oE(38, this.TYl.computeSize());
        this.TYl.writeFields(paramVarArgs);
      }
      paramVarArgs.co(39, this.TwU);
      if (this.TLU != null)
      {
        paramVarArgs.oE(40, this.TLU.computeSize());
        this.TLU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.TYm);
      if (this.TYn != null) {
        paramVarArgs.f(42, this.TYn);
      }
      if (this.TYo != null) {
        paramVarArgs.f(43, this.TYo);
      }
      if (this.TYp != null)
      {
        paramVarArgs.oE(44, this.TYp.computeSize());
        this.TYp.writeFields(paramVarArgs);
      }
      if (this.TYq != null)
      {
        paramVarArgs.oE(45, this.TYq.computeSize());
        this.TYq.writeFields(paramVarArgs);
      }
      if (this.TYr != null)
      {
        paramVarArgs.oE(46, this.TYr.computeSize());
        this.TYr.writeFields(paramVarArgs);
      }
      if (this.fZQ != null)
      {
        paramVarArgs.oE(99, this.fZQ.computeSize());
        this.fZQ.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4426;
      }
    }
    label4426:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.dta);
      paramInt = i;
      if (this.TXK != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TXK);
      }
      i = paramInt;
      if (this.TXL != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TXL);
      }
      paramInt = i;
      if (this.TXM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TXM);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.TXN) + g.a.a.a.c(9, 8, this.TXO) + g.a.a.b.b.a.bM(10, this.gaz) + g.a.a.b.b.a.bM(11, this.TXP) + g.a.a.a.c(12, 8, this.TXQ);
      paramInt = i;
      if (this.Tyg != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Tyg);
      }
      i = paramInt;
      if (this.TXR != null) {
        i = paramInt + g.a.a.a.oD(14, this.TXR.computeSize());
      }
      i += g.a.a.a.c(15, 8, this.TXS);
      paramInt = i;
      if (this.TXT != null) {
        paramInt = i + g.a.a.a.oD(16, this.TXT.computeSize());
      }
      i = paramInt;
      if (this.TXU != null) {
        i = paramInt + g.a.a.a.oD(17, this.TXU.computeSize());
      }
      paramInt = i;
      if (this.TXV != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TXV);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.TXW);
      paramInt = i;
      if (this.TXX != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.TXX);
      }
      i = paramInt;
      if (this.TXE != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.TXE);
      }
      i = i + g.a.a.b.b.a.bM(22, this.TXY) + (g.a.a.b.b.a.gL(23) + 1) + g.a.a.b.b.a.bM(24, this.DgI);
      paramInt = i;
      if (this.Tyf != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.Tyf);
      }
      i = paramInt;
      if (this.TYa != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.TYa);
      }
      paramInt = i;
      if (this.TYb != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.TYb);
      }
      i = paramInt + g.a.a.a.c(28, 8, this.TYc);
      paramInt = i;
      if (this.TYd != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.TYd);
      }
      i = paramInt;
      if (this.TYe != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.TYe);
      }
      paramInt = i;
      if (this.TYf != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.TYf);
      }
      i = paramInt;
      if (this.Olt != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.Olt);
      }
      paramInt = i;
      if (this.TYg != null) {
        paramInt = i + g.a.a.a.oD(33, this.TYg.computeSize());
      }
      i = paramInt;
      if (this.TYh != null) {
        i = paramInt + g.a.a.a.oD(34, this.TYh.computeSize());
      }
      paramInt = i;
      if (this.TYi != null) {
        paramInt = i + g.a.a.a.oD(35, this.TYi.computeSize());
      }
      i = paramInt;
      if (this.TYj != null) {
        i = paramInt + g.a.a.b.b.a.g(36, this.TYj);
      }
      paramInt = i;
      if (this.TYk != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.TYk);
      }
      i = paramInt;
      if (this.TYl != null) {
        i = paramInt + g.a.a.a.oD(38, this.TYl.computeSize());
      }
      i += g.a.a.b.b.a.gL(39) + 1;
      paramInt = i;
      if (this.TLU != null) {
        paramInt = i + g.a.a.a.oD(40, this.TLU.computeSize());
      }
      i = paramInt + g.a.a.a.c(41, 8, this.TYm);
      paramInt = i;
      if (this.TYn != null) {
        paramInt = i + g.a.a.b.b.a.g(42, this.TYn);
      }
      i = paramInt;
      if (this.TYo != null) {
        i = paramInt + g.a.a.b.b.a.g(43, this.TYo);
      }
      paramInt = i;
      if (this.TYp != null) {
        paramInt = i + g.a.a.a.oD(44, this.TYp.computeSize());
      }
      i = paramInt;
      if (this.TYq != null) {
        i = paramInt + g.a.a.a.oD(45, this.TYq.computeSize());
      }
      paramInt = i;
      if (this.TYr != null) {
        paramInt = i + g.a.a.a.oD(46, this.TYr.computeSize());
      }
      i = paramInt;
      if (this.fZQ != null) {
        i = paramInt + g.a.a.a.oD(99, this.fZQ.computeSize());
      }
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91645);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TXO.clear();
        this.TXQ.clear();
        this.TXS.clear();
        this.TYc.clear();
        this.TYm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dri localdri = (dri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localdri.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localdri.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localdri.dta = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localdri.TXK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localdri.TXL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localdri.TXM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localdri.TXN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localdri.gaz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localdri.TXP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localdri.Tyg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXR = ((aib)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXT = ((aib)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxm)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TXU = ((cxm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localdri.TXV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localdri.TXW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localdri.TXX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localdri.TXE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localdri.TXY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localdri.TXZ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localdri.DgI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localdri.Tyf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localdri.TYa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localdri.TYb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localdri.TYd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localdri.TYe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localdri.TYf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localdri.Olt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYg = ((dcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cpp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cpp)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYh = ((cpp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cpp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cpp)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYi = ((cpp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localdri.TYj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localdri.TYk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apg)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYl = ((apg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localdri.TwU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmu)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TLU = ((dmu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localdri.TYn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localdri.TYo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYp = ((dcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqq)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYq = ((cqq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 46: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.TYr = ((dcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctd)localObject2).parseFrom((byte[])localObject1);
            }
            localdri.fZQ = ((ctd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localdri.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dri
 * JD-Core Version:    0.7.0.1
 */