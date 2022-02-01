package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bcj
  extends erp
{
  public int EIF;
  public String EIo;
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public int ZER;
  public LinkedList<byg> ZHF;
  public bgc ZKD;
  public bcl ZKE;
  public bte ZKF;
  public bfu ZKH;
  public bwt ZNq;
  public LinkedList<dmk> ZNr;
  public bnn ZNs;
  public int ZNt;
  public long ZNu;
  public int akkJ;
  public int iaK;
  public float latitude;
  public float longitude;
  
  public bcj()
  {
    AppMethodBeat.i(259402);
    this.ZNr = new LinkedList();
    this.ZHF = new LinkedList();
    AppMethodBeat.o(259402);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259411);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.l(4, this.longitude);
      paramVarArgs.l(5, this.latitude);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(6, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.ZKD != null)
      {
        paramVarArgs.qD(7, this.ZKD.computeSize());
        this.ZKD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZER);
      if (this.ZNq != null)
      {
        paramVarArgs.qD(9, this.ZNq.computeSize());
        this.ZNq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.ZNr);
      paramVarArgs.e(11, 8, this.ZHF);
      if (this.ZNs != null)
      {
        paramVarArgs.qD(12, this.ZNs.computeSize());
        this.ZNs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.iaK);
      if (this.ZKE != null)
      {
        paramVarArgs.qD(14, this.ZKE.computeSize());
        this.ZKE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.ZNt);
      if (this.ZKF != null)
      {
        paramVarArgs.qD(16, this.ZKF.computeSize());
        this.ZKF.writeFields(paramVarArgs);
      }
      if (this.EIo != null) {
        paramVarArgs.g(17, this.EIo);
      }
      paramVarArgs.bS(18, this.EIF);
      paramVarArgs.bv(19, this.ZNu);
      if (this.ZKH != null)
      {
        paramVarArgs.qD(20, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(21, this.akkJ);
      AppMethodBeat.o(259411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2078;
      }
    }
    label2078:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.ZKD != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZKD.computeSize());
      }
      i += i.a.a.b.b.a.cJ(8, this.ZER);
      paramInt = i;
      if (this.ZNq != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZNq.computeSize());
      }
      i = paramInt + i.a.a.a.c(10, 8, this.ZNr) + i.a.a.a.c(11, 8, this.ZHF);
      paramInt = i;
      if (this.ZNs != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZNs.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.iaK);
      paramInt = i;
      if (this.ZKE != null) {
        paramInt = i + i.a.a.a.qC(14, this.ZKE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.ZNt);
      paramInt = i;
      if (this.ZKF != null) {
        paramInt = i + i.a.a.a.qC(16, this.ZKF.computeSize());
      }
      i = paramInt;
      if (this.EIo != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.EIo);
      }
      i = i + i.a.a.b.b.a.cJ(18, this.EIF) + i.a.a.b.b.a.q(19, this.ZNu);
      paramInt = i;
      if (this.ZKH != null) {
        paramInt = i + i.a.a.a.qC(20, this.ZKH.computeSize());
      }
      i = i.a.a.b.b.a.cJ(21, this.akkJ);
      AppMethodBeat.o(259411);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZNr.clear();
        this.ZHF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259411);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 3: 
          localbcj.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259411);
          return 0;
        case 4: 
          localbcj.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(259411);
          return 0;
        case 5: 
          localbcj.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(259411);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgc)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZKD = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 8: 
          localbcj.ZER = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259411);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwt)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZNq = ((bwt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmk)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZNr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byg)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZHF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnn)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZNs = ((bnn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 13: 
          localbcj.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259411);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcl)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZKE = ((bcl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 15: 
          localbcj.ZNt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259411);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bte();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bte)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZKF = ((bte)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        case 17: 
          localbcj.EIo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259411);
          return 0;
        case 18: 
          localbcj.EIF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259411);
          return 0;
        case 19: 
          localbcj.ZNu = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259411);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfu)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.ZKH = ((bfu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259411);
          return 0;
        }
        localbcj.akkJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259411);
        return 0;
      }
      AppMethodBeat.o(259411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */