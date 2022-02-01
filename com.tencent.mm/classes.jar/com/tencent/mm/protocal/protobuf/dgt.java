package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgt
  extends erp
{
  public aeo YMR;
  public String Zke;
  public boolean aaBV;
  public boolean aaBW;
  public gjw aaLM;
  public gmb aaLN;
  public glb aaLO;
  public gnj aaLP;
  public glu aaLQ;
  public gmc aaLR;
  public int aaLS;
  public String aaLT;
  public String aaLU;
  public gmd aaLV;
  public dtu aaLW;
  public gly aaLX;
  public int aaLY;
  public int aayr;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.aaLM != null)
      {
        paramVarArgs.qD(3, this.aaLM.computeSize());
        this.aaLM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aayr);
      if (this.aaLN != null)
      {
        paramVarArgs.qD(5, this.aaLN.computeSize());
        this.aaLN.writeFields(paramVarArgs);
      }
      if (this.aaLO != null)
      {
        paramVarArgs.qD(6, this.aaLO.computeSize());
        this.aaLO.writeFields(paramVarArgs);
      }
      if (this.aaLP != null)
      {
        paramVarArgs.qD(7, this.aaLP.computeSize());
        this.aaLP.writeFields(paramVarArgs);
      }
      if (this.aaLQ != null)
      {
        paramVarArgs.qD(8, this.aaLQ.computeSize());
        this.aaLQ.writeFields(paramVarArgs);
      }
      if (this.aaLR != null)
      {
        paramVarArgs.qD(9, this.aaLR.computeSize());
        this.aaLR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.aaLS);
      if (this.aaLT != null) {
        paramVarArgs.g(11, this.aaLT);
      }
      if (this.aaLU != null) {
        paramVarArgs.g(12, this.aaLU);
      }
      paramVarArgs.di(13, this.aaBV);
      paramVarArgs.di(14, this.aaBW);
      if (this.aaLV != null)
      {
        paramVarArgs.qD(15, this.aaLV.computeSize());
        this.aaLV.writeFields(paramVarArgs);
      }
      if (this.aaLW != null)
      {
        paramVarArgs.qD(16, this.aaLW.computeSize());
        this.aaLW.writeFields(paramVarArgs);
      }
      if (this.Zke != null) {
        paramVarArgs.g(17, this.Zke);
      }
      if (this.YMR != null)
      {
        paramVarArgs.qD(18, this.YMR.computeSize());
        this.YMR.writeFields(paramVarArgs);
      }
      if (this.aaLX != null)
      {
        paramVarArgs.qD(19, this.aaLX.computeSize());
        this.aaLX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(20, this.aaLY);
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2088;
      }
    }
    label2088:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.aaLM != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaLM.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.aayr);
      paramInt = i;
      if (this.aaLN != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaLN.computeSize());
      }
      i = paramInt;
      if (this.aaLO != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaLO.computeSize());
      }
      paramInt = i;
      if (this.aaLP != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaLP.computeSize());
      }
      i = paramInt;
      if (this.aaLQ != null) {
        i = paramInt + i.a.a.a.qC(8, this.aaLQ.computeSize());
      }
      paramInt = i;
      if (this.aaLR != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaLR.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.aaLS);
      paramInt = i;
      if (this.aaLT != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaLT);
      }
      i = paramInt;
      if (this.aaLU != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaLU);
      }
      i = i + (i.a.a.b.b.a.ko(13) + 1) + (i.a.a.b.b.a.ko(14) + 1);
      paramInt = i;
      if (this.aaLV != null) {
        paramInt = i + i.a.a.a.qC(15, this.aaLV.computeSize());
      }
      i = paramInt;
      if (this.aaLW != null) {
        i = paramInt + i.a.a.a.qC(16, this.aaLW.computeSize());
      }
      paramInt = i;
      if (this.Zke != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Zke);
      }
      i = paramInt;
      if (this.YMR != null) {
        i = paramInt + i.a.a.a.qC(18, this.YMR.computeSize());
      }
      paramInt = i;
      if (this.aaLX != null) {
        paramInt = i + i.a.a.a.qC(19, this.aaLX.computeSize());
      }
      i = i.a.a.b.b.a.cJ(20, this.aaLY);
      AppMethodBeat.o(123624);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgt localdgt = (dgt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
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
            localdgt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localdgt.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjw)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLM = ((gjw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localdgt.aayr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmb)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLN = ((gmb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glb)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLO = ((glb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnj)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLP = ((gnj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glu)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLQ = ((glu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmc)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLR = ((gmc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localdgt.aaLS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localdgt.aaLT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localdgt.aaLU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localdgt.aaBV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localdgt.aaBW = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123624);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmd)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLV = ((gmd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtu)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLW = ((dtu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 17: 
          localdgt.Zke = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aeo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aeo)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.YMR = ((aeo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gly();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gly)localObject2).parseFrom((byte[])localObject1);
            }
            localdgt.aaLX = ((gly)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        }
        localdgt.aaLY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgt
 * JD-Core Version:    0.7.0.1
 */