package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class bzx
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
  public int Ksf;
  public String Ksi;
  public int Ksj;
  public String Ksk;
  public String Ksm;
  public String Ksn;
  public int Ksv;
  public int KtO;
  public LinkedList<caa> aaiU;
  public caa aaiV;
  public int aaiW;
  public bzu aaiX;
  public int hAV;
  public LinkedList<bzv> hfF;
  public int ihA;
  public long ihV;
  public int ihy;
  public int ihz;
  public String wYI;
  public int wYz;
  
  public bzx()
  {
    AppMethodBeat.i(257411);
    this.hAV = 0;
    this.wYI = "ok";
    this.aaiU = new LinkedList();
    this.hfF = new LinkedList();
    AppMethodBeat.o(257411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257419);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257419);
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
      paramVarArgs.bS(4, this.KtO);
      paramVarArgs.bS(5, this.wYz);
      paramVarArgs.bv(6, this.KrT);
      if (this.CAf != null) {
        paramVarArgs.g(7, this.CAf);
      }
      paramVarArgs.bv(8, this.ihV);
      if (this.Kmq != null) {
        paramVarArgs.g(9, this.Kmq);
      }
      paramVarArgs.bS(10, this.KrW);
      if (this.KrU != null) {
        paramVarArgs.g(11, this.KrU);
      }
      paramVarArgs.e(12, 8, this.aaiU);
      paramVarArgs.bS(13, this.ihy);
      paramVarArgs.bS(14, this.KrX);
      paramVarArgs.bS(15, this.ihz);
      paramVarArgs.bS(16, this.ihA);
      if (this.KrL != null) {
        paramVarArgs.g(17, this.KrL);
      }
      if (this.KrY != null) {
        paramVarArgs.g(18, this.KrY);
      }
      paramVarArgs.bS(19, this.Ksf);
      paramVarArgs.bv(20, this.KrS);
      paramVarArgs.e(21, 8, this.hfF);
      if (this.aaiV != null)
      {
        paramVarArgs.qD(22, this.aaiV.computeSize());
        this.aaiV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.Kos);
      if (this.Kou != null) {
        paramVarArgs.g(24, this.Kou);
      }
      if (this.Ksi != null) {
        paramVarArgs.g(25, this.Ksi);
      }
      if (this.Kot != null) {
        paramVarArgs.g(26, this.Kot);
      }
      paramVarArgs.bS(27, this.Ksj);
      if (this.Ksk != null) {
        paramVarArgs.g(28, this.Ksk);
      }
      paramVarArgs.bS(29, this.aaiW);
      paramVarArgs.bS(30, this.Ksv);
      if (this.Ksm != null) {
        paramVarArgs.g(31, this.Ksm);
      }
      if (this.Ksn != null) {
        paramVarArgs.g(32, this.Ksn);
      }
      if (this.aaiX != null)
      {
        paramVarArgs.qD(33, this.aaiX.computeSize());
        this.aaiX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2296;
      }
    }
    label2296:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.KtO) + i.a.a.b.b.a.cJ(5, this.wYz) + i.a.a.b.b.a.q(6, this.KrT);
      paramInt = i;
      if (this.CAf != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.CAf);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.ihV);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Kmq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.KrW);
      paramInt = i;
      if (this.KrU != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.KrU);
      }
      i = paramInt + i.a.a.a.c(12, 8, this.aaiU) + i.a.a.b.b.a.cJ(13, this.ihy) + i.a.a.b.b.a.cJ(14, this.KrX) + i.a.a.b.b.a.cJ(15, this.ihz) + i.a.a.b.b.a.cJ(16, this.ihA);
      paramInt = i;
      if (this.KrL != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.KrL);
      }
      i = paramInt;
      if (this.KrY != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.KrY);
      }
      i = i + i.a.a.b.b.a.cJ(19, this.Ksf) + i.a.a.b.b.a.q(20, this.KrS) + i.a.a.a.c(21, 8, this.hfF);
      paramInt = i;
      if (this.aaiV != null) {
        paramInt = i + i.a.a.a.qC(22, this.aaiV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.Kos);
      paramInt = i;
      if (this.Kou != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.Kou);
      }
      i = paramInt;
      if (this.Ksi != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.Ksi);
      }
      paramInt = i;
      if (this.Kot != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.Kot);
      }
      i = paramInt + i.a.a.b.b.a.cJ(27, this.Ksj);
      paramInt = i;
      if (this.Ksk != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.Ksk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(29, this.aaiW) + i.a.a.b.b.a.cJ(30, this.Ksv);
      paramInt = i;
      if (this.Ksm != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.Ksm);
      }
      i = paramInt;
      if (this.Ksn != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.Ksn);
      }
      paramInt = i;
      if (this.aaiX != null) {
        paramInt = i + i.a.a.a.qC(33, this.aaiX.computeSize());
      }
      AppMethodBeat.o(257419);
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
          AppMethodBeat.o(257419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bzx localbzx = (bzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257419);
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
            localbzx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257419);
          return 0;
        case 2: 
          localbzx.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 3: 
          localbzx.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 4: 
          localbzx.KtO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 5: 
          localbzx.wYz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 6: 
          localbzx.KrT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257419);
          return 0;
        case 7: 
          localbzx.CAf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 8: 
          localbzx.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257419);
          return 0;
        case 9: 
          localbzx.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 10: 
          localbzx.KrW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 11: 
          localbzx.KrU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 12: 
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
            localbzx.aaiU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257419);
          return 0;
        case 13: 
          localbzx.ihy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 14: 
          localbzx.KrX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 15: 
          localbzx.ihz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 16: 
          localbzx.ihA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 17: 
          localbzx.KrL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 18: 
          localbzx.KrY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 19: 
          localbzx.Ksf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 20: 
          localbzx.KrS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257419);
          return 0;
        case 21: 
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
            localbzx.hfF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257419);
          return 0;
        case 22: 
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
            localbzx.aaiV = ((caa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257419);
          return 0;
        case 23: 
          localbzx.Kos = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 24: 
          localbzx.Kou = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 25: 
          localbzx.Ksi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 26: 
          localbzx.Kot = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 27: 
          localbzx.Ksj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 28: 
          localbzx.Ksk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 29: 
          localbzx.aaiW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 30: 
          localbzx.Ksv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257419);
          return 0;
        case 31: 
          localbzx.Ksm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        case 32: 
          localbzx.Ksn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257419);
          return 0;
        }
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
          localbzx.aaiX = ((bzu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257419);
        return 0;
      }
      AppMethodBeat.o(257419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzx
 * JD-Core Version:    0.7.0.1
 */