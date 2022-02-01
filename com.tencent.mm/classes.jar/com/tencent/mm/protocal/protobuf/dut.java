package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dut
  extends com.tencent.mm.bw.a
{
  public int FKJ;
  public bva FNY;
  public String FVP;
  public cxq FWC;
  public int GNz;
  public String GnN;
  public String GnO;
  public int HJY;
  public dia HhA;
  public String HnU;
  public String HnV;
  public String Hoy;
  public int HzY;
  public long IaA;
  public String IaB;
  public dky IaC;
  public long IaD;
  public int IaE;
  public String IaF;
  public String IaG;
  public String Iaj;
  public String Iak;
  public int Ial;
  public int Iam;
  public int Ian;
  public String Iao;
  public int Iap;
  public cxn Iaq;
  public int Iar;
  public String Ias;
  public String Iat;
  public String Iau;
  public String Iav;
  public String Iaw;
  public cjd Iax;
  public String Iay;
  public int Iaz;
  public String eRt;
  public String jgf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HhA == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(1, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jgf != null) {
        paramVarArgs.d(2, this.jgf);
      }
      if (this.Iaj != null) {
        paramVarArgs.d(3, this.Iaj);
      }
      if (this.Iak != null) {
        paramVarArgs.d(4, this.Iak);
      }
      paramVarArgs.aS(5, this.Ial);
      paramVarArgs.aS(6, this.Iam);
      paramVarArgs.aS(7, this.Ian);
      if (this.Iao != null) {
        paramVarArgs.d(8, this.Iao);
      }
      if (this.GnN != null) {
        paramVarArgs.d(9, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(10, this.GnO);
      }
      paramVarArgs.aS(11, this.Iap);
      if (this.Iaq != null)
      {
        paramVarArgs.lJ(12, this.Iaq.computeSize());
        this.Iaq.writeFields(paramVarArgs);
      }
      if (this.FWC != null)
      {
        paramVarArgs.lJ(13, this.FWC.computeSize());
        this.FWC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FKJ);
      paramVarArgs.aS(15, this.Iar);
      if (this.FVP != null) {
        paramVarArgs.d(16, this.FVP);
      }
      if (this.HnU != null) {
        paramVarArgs.d(17, this.HnU);
      }
      if (this.HnV != null) {
        paramVarArgs.d(18, this.HnV);
      }
      if (this.Ias != null) {
        paramVarArgs.d(19, this.Ias);
      }
      if (this.Iat != null) {
        paramVarArgs.d(20, this.Iat);
      }
      if (this.Iau != null) {
        paramVarArgs.d(21, this.Iau);
      }
      if (this.Iav != null) {
        paramVarArgs.d(22, this.Iav);
      }
      if (this.FNY != null)
      {
        paramVarArgs.lJ(23, this.FNY.computeSize());
        this.FNY.writeFields(paramVarArgs);
      }
      if (this.Iaw != null) {
        paramVarArgs.d(24, this.Iaw);
      }
      if (this.Iax != null)
      {
        paramVarArgs.lJ(25, this.Iax.computeSize());
        this.Iax.writeFields(paramVarArgs);
      }
      if (this.Iay != null) {
        paramVarArgs.d(26, this.Iay);
      }
      paramVarArgs.aS(27, this.Iaz);
      if (this.eRt != null) {
        paramVarArgs.d(28, this.eRt);
      }
      paramVarArgs.aS(29, this.GNz);
      paramVarArgs.aZ(30, this.IaA);
      if (this.IaB != null) {
        paramVarArgs.d(31, this.IaB);
      }
      paramVarArgs.aS(32, this.HzY);
      if (this.IaC != null)
      {
        paramVarArgs.lJ(33, this.IaC.computeSize());
        this.IaC.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(34, this.IaD);
      paramVarArgs.aS(35, this.IaE);
      if (this.IaF != null) {
        paramVarArgs.d(36, this.IaF);
      }
      if (this.IaG != null) {
        paramVarArgs.d(37, this.IaG);
      }
      if (this.Hoy != null) {
        paramVarArgs.d(38, this.Hoy);
      }
      paramVarArgs.aS(39, this.HJY);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HhA == null) {
        break label2958;
      }
    }
    label2958:
    for (int i = f.a.a.a.lI(1, this.HhA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jgf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jgf);
      }
      i = paramInt;
      if (this.Iaj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Iaj);
      }
      paramInt = i;
      if (this.Iak != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Iak);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Ial) + f.a.a.b.b.a.bz(6, this.Iam) + f.a.a.b.b.a.bz(7, this.Ian);
      paramInt = i;
      if (this.Iao != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Iao);
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GnO);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Iap);
      paramInt = i;
      if (this.Iaq != null) {
        paramInt = i + f.a.a.a.lI(12, this.Iaq.computeSize());
      }
      i = paramInt;
      if (this.FWC != null) {
        i = paramInt + f.a.a.a.lI(13, this.FWC.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(14, this.FKJ) + f.a.a.b.b.a.bz(15, this.Iar);
      paramInt = i;
      if (this.FVP != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FVP);
      }
      i = paramInt;
      if (this.HnU != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HnU);
      }
      paramInt = i;
      if (this.HnV != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HnV);
      }
      i = paramInt;
      if (this.Ias != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Ias);
      }
      paramInt = i;
      if (this.Iat != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.Iat);
      }
      i = paramInt;
      if (this.Iau != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Iau);
      }
      paramInt = i;
      if (this.Iav != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.Iav);
      }
      i = paramInt;
      if (this.FNY != null) {
        i = paramInt + f.a.a.a.lI(23, this.FNY.computeSize());
      }
      paramInt = i;
      if (this.Iaw != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.Iaw);
      }
      i = paramInt;
      if (this.Iax != null) {
        i = paramInt + f.a.a.a.lI(25, this.Iax.computeSize());
      }
      paramInt = i;
      if (this.Iay != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Iay);
      }
      i = paramInt + f.a.a.b.b.a.bz(27, this.Iaz);
      paramInt = i;
      if (this.eRt != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.eRt);
      }
      i = paramInt + f.a.a.b.b.a.bz(29, this.GNz) + f.a.a.b.b.a.p(30, this.IaA);
      paramInt = i;
      if (this.IaB != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.IaB);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.HzY);
      paramInt = i;
      if (this.IaC != null) {
        paramInt = i + f.a.a.a.lI(33, this.IaC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(34, this.IaD) + f.a.a.b.b.a.bz(35, this.IaE);
      paramInt = i;
      if (this.IaF != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.IaF);
      }
      i = paramInt;
      if (this.IaG != null) {
        i = paramInt + f.a.a.b.b.a.e(37, this.IaG);
      }
      paramInt = i;
      if (this.Hoy != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.Hoy);
      }
      i = f.a.a.b.b.a.bz(39, this.HJY);
      AppMethodBeat.o(134260);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HhA == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dut localdut = (dut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localdut.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localdut.Iaj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localdut.Iak = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localdut.Ial = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localdut.Iam = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localdut.Ian = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localdut.Iao = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localdut.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localdut.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localdut.Iap = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.Iaq = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.FWC = ((cxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localdut.FKJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localdut.Iar = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localdut.FVP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localdut.HnU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localdut.HnV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localdut.Ias = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localdut.Iat = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localdut.Iau = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localdut.Iav = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bva();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.FNY = ((bva)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localdut.Iaw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.Iax = ((cjd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localdut.Iay = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localdut.Iaz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localdut.eRt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localdut.GNz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localdut.IaA = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localdut.IaB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localdut.HzY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.IaC = ((dky)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localdut.IaD = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(134260);
          return 0;
        case 35: 
          localdut.IaE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 36: 
          localdut.IaF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 37: 
          localdut.IaG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 38: 
          localdut.Hoy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134260);
          return 0;
        }
        localdut.HJY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dut
 * JD-Core Version:    0.7.0.1
 */