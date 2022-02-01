package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class bzz
  extends esc
{
  public String CAf;
  public String Kmq;
  public int Kos;
  public String Kot;
  public String Kou;
  public String KrL;
  public long KrS;
  public long KrT;
  public String KrU;
  public int KrW;
  public int KrX;
  public String KrY;
  public String Ksi;
  public int Ksj;
  public String Ksk;
  public String Ksm;
  public String Ksn;
  public int Ksv;
  public int KtO;
  public eme Zgn;
  public dcm ZxA;
  public LinkedList<caa> aaiU;
  public caa aaiV;
  public int aaiW;
  public bzu aaiX;
  public String aaiY;
  public String aaja;
  public dfd aajb;
  public int hAV;
  public LinkedList<bzv> hfF;
  public int ihA;
  public long ihV;
  public int ihy;
  public int ihz;
  public String wYI;
  public int wYz;
  
  public bzz()
  {
    AppMethodBeat.i(257425);
    this.hAV = 0;
    this.wYI = "ok";
    this.aaiU = new LinkedList();
    this.hfF = new LinkedList();
    AppMethodBeat.o(257425);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257432);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257432);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.CAf != null) {
        paramVarArgs.g(4, this.CAf);
      }
      paramVarArgs.bv(5, this.ihV);
      paramVarArgs.bS(6, this.KtO);
      paramVarArgs.bv(7, this.KrS);
      paramVarArgs.bS(8, this.wYz);
      paramVarArgs.bv(9, this.KrT);
      paramVarArgs.bS(10, this.ihy);
      paramVarArgs.bS(11, this.KrW);
      paramVarArgs.bS(12, this.KrX);
      paramVarArgs.bS(13, this.ihA);
      paramVarArgs.bS(14, this.ihz);
      if (this.KrL != null) {
        paramVarArgs.g(15, this.KrL);
      }
      if (this.Kmq != null) {
        paramVarArgs.g(16, this.Kmq);
      }
      if (this.KrU != null) {
        paramVarArgs.g(17, this.KrU);
      }
      if (this.KrY != null) {
        paramVarArgs.g(18, this.KrY);
      }
      paramVarArgs.e(19, 8, this.aaiU);
      paramVarArgs.e(20, 8, this.hfF);
      paramVarArgs.bS(21, this.Kos);
      if (this.Kou != null) {
        paramVarArgs.g(22, this.Kou);
      }
      if (this.Ksi != null) {
        paramVarArgs.g(23, this.Ksi);
      }
      if (this.Kot != null) {
        paramVarArgs.g(24, this.Kot);
      }
      if (this.Zgn != null)
      {
        paramVarArgs.qD(25, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      if (this.aaja != null) {
        paramVarArgs.g(26, this.aaja);
      }
      if (this.aaiY != null) {
        paramVarArgs.g(27, this.aaiY);
      }
      paramVarArgs.bS(28, this.Ksj);
      if (this.Ksk != null) {
        paramVarArgs.g(29, this.Ksk);
      }
      if (this.aajb != null)
      {
        paramVarArgs.qD(30, this.aajb.computeSize());
        this.aajb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(31, this.aaiW);
      paramVarArgs.bS(32, this.Ksv);
      if (this.ZxA != null)
      {
        paramVarArgs.qD(33, this.ZxA.computeSize());
        this.ZxA.writeFields(paramVarArgs);
      }
      if (this.Ksm != null) {
        paramVarArgs.g(34, this.Ksm);
      }
      if (this.Ksn != null) {
        paramVarArgs.g(35, this.Ksn);
      }
      if (this.aaiX != null)
      {
        paramVarArgs.qD(36, this.aaiX.computeSize());
        this.aaiX.writeFields(paramVarArgs);
      }
      if (this.aaiV != null)
      {
        paramVarArgs.qD(37, this.aaiV.computeSize());
        this.aaiV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2770;
      }
    }
    label2770:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.CAf);
      }
      i = i + i.a.a.b.b.a.q(5, this.ihV) + i.a.a.b.b.a.cJ(6, this.KtO) + i.a.a.b.b.a.q(7, this.KrS) + i.a.a.b.b.a.cJ(8, this.wYz) + i.a.a.b.b.a.q(9, this.KrT) + i.a.a.b.b.a.cJ(10, this.ihy) + i.a.a.b.b.a.cJ(11, this.KrW) + i.a.a.b.b.a.cJ(12, this.KrX) + i.a.a.b.b.a.cJ(13, this.ihA) + i.a.a.b.b.a.cJ(14, this.ihz);
      paramInt = i;
      if (this.KrL != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.KrL);
      }
      i = paramInt;
      if (this.Kmq != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.Kmq);
      }
      paramInt = i;
      if (this.KrU != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.KrU);
      }
      i = paramInt;
      if (this.KrY != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.KrY);
      }
      i = i + i.a.a.a.c(19, 8, this.aaiU) + i.a.a.a.c(20, 8, this.hfF) + i.a.a.b.b.a.cJ(21, this.Kos);
      paramInt = i;
      if (this.Kou != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.Kou);
      }
      i = paramInt;
      if (this.Ksi != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.Ksi);
      }
      paramInt = i;
      if (this.Kot != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.Kot);
      }
      i = paramInt;
      if (this.Zgn != null) {
        i = paramInt + i.a.a.a.qC(25, this.Zgn.computeSize());
      }
      paramInt = i;
      if (this.aaja != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.aaja);
      }
      i = paramInt;
      if (this.aaiY != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.aaiY);
      }
      i += i.a.a.b.b.a.cJ(28, this.Ksj);
      paramInt = i;
      if (this.Ksk != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.Ksk);
      }
      i = paramInt;
      if (this.aajb != null) {
        i = paramInt + i.a.a.a.qC(30, this.aajb.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(31, this.aaiW) + i.a.a.b.b.a.cJ(32, this.Ksv);
      paramInt = i;
      if (this.ZxA != null) {
        paramInt = i + i.a.a.a.qC(33, this.ZxA.computeSize());
      }
      i = paramInt;
      if (this.Ksm != null) {
        i = paramInt + i.a.a.b.b.a.h(34, this.Ksm);
      }
      paramInt = i;
      if (this.Ksn != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.Ksn);
      }
      i = paramInt;
      if (this.aaiX != null) {
        i = paramInt + i.a.a.a.qC(36, this.aaiX.computeSize());
      }
      paramInt = i;
      if (this.aaiV != null) {
        paramInt = i + i.a.a.a.qC(37, this.aaiV.computeSize());
      }
      AppMethodBeat.o(257432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaiU.clear();
        this.hfF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257432);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bzz localbzz = (bzz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257432);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 2: 
          localbzz.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 3: 
          localbzz.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 4: 
          localbzz.CAf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 5: 
          localbzz.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257432);
          return 0;
        case 6: 
          localbzz.KtO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 7: 
          localbzz.KrS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257432);
          return 0;
        case 8: 
          localbzz.wYz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 9: 
          localbzz.KrT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257432);
          return 0;
        case 10: 
          localbzz.ihy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 11: 
          localbzz.KrW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 12: 
          localbzz.KrX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 13: 
          localbzz.ihA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 14: 
          localbzz.ihz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 15: 
          localbzz.KrL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 16: 
          localbzz.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 17: 
          localbzz.KrU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 18: 
          localbzz.KrY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new caa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((caa)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.aaiU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzv)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.hfF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 21: 
          localbzz.Kos = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 22: 
          localbzz.Kou = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 23: 
          localbzz.Ksi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 24: 
          localbzz.Kot = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eme)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 26: 
          localbzz.aaja = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 27: 
          localbzz.aaiY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 28: 
          localbzz.Ksj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 29: 
          localbzz.Ksk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfd)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.aajb = ((dfd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 31: 
          localbzz.aaiW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 32: 
          localbzz.Ksv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257432);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcm)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.ZxA = ((dcm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        case 34: 
          localbzz.Ksm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 35: 
          localbzz.Ksn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257432);
          return 0;
        case 36: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzu)localObject2).parseFrom((byte[])localObject1);
            }
            localbzz.aaiX = ((bzu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257432);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new caa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((caa)localObject2).parseFrom((byte[])localObject1);
          }
          localbzz.aaiV = ((caa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257432);
        return 0;
      }
      AppMethodBeat.o(257432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzz
 * JD-Core Version:    0.7.0.1
 */