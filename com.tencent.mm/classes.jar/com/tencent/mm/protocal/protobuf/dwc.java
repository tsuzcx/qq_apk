package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dwc
  extends esc
{
  public String UZS;
  public String UZT;
  public String UZU;
  public int UZV;
  public String UZW;
  public String Vbl;
  public dke abbO;
  public String abbP;
  public arb abbQ;
  public String abbR;
  public boolean abbS;
  public boolean abbT;
  public boolean abbU;
  public LinkedList<aku> abbV;
  public String abbW;
  public LinkedList<aey> abbX;
  public LinkedList<eir> abbY;
  public dkf ifY;
  public String wuA;
  public int wuz;
  
  public dwc()
  {
    AppMethodBeat.i(258517);
    this.abbV = new LinkedList();
    this.abbX = new LinkedList();
    this.abbY = new LinkedList();
    AppMethodBeat.o(258517);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.abbO != null)
      {
        paramVarArgs.qD(4, this.abbO.computeSize());
        this.abbO.writeFields(paramVarArgs);
      }
      if (this.UZS != null) {
        paramVarArgs.g(5, this.UZS);
      }
      if (this.UZT != null) {
        paramVarArgs.g(6, this.UZT);
      }
      if (this.UZU != null) {
        paramVarArgs.g(7, this.UZU);
      }
      paramVarArgs.bS(8, this.UZV);
      if (this.UZW != null) {
        paramVarArgs.g(9, this.UZW);
      }
      if (this.abbP != null) {
        paramVarArgs.g(10, this.abbP);
      }
      if (this.abbQ != null)
      {
        paramVarArgs.qD(11, this.abbQ.computeSize());
        this.abbQ.writeFields(paramVarArgs);
      }
      if (this.abbR != null) {
        paramVarArgs.g(12, this.abbR);
      }
      paramVarArgs.di(13, this.abbS);
      paramVarArgs.di(14, this.abbT);
      paramVarArgs.di(15, this.abbU);
      paramVarArgs.e(16, 8, this.abbV);
      if (this.abbW != null) {
        paramVarArgs.g(17, this.abbW);
      }
      paramVarArgs.e(18, 8, this.abbX);
      paramVarArgs.e(98, 8, this.abbY);
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1940;
      }
    }
    label1940:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abbO != null) {
        i = paramInt + i.a.a.a.qC(4, this.abbO.computeSize());
      }
      paramInt = i;
      if (this.UZS != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.UZS);
      }
      i = paramInt;
      if (this.UZT != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.UZT);
      }
      paramInt = i;
      if (this.UZU != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.UZU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.UZV);
      paramInt = i;
      if (this.UZW != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.UZW);
      }
      i = paramInt;
      if (this.abbP != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abbP);
      }
      paramInt = i;
      if (this.abbQ != null) {
        paramInt = i + i.a.a.a.qC(11, this.abbQ.computeSize());
      }
      i = paramInt;
      if (this.abbR != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abbR);
      }
      i = i + (i.a.a.b.b.a.ko(13) + 1) + (i.a.a.b.b.a.ko(14) + 1) + (i.a.a.b.b.a.ko(15) + 1) + i.a.a.a.c(16, 8, this.abbV);
      paramInt = i;
      if (this.abbW != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.abbW);
      }
      i = paramInt + i.a.a.a.c(18, 8, this.abbX) + i.a.a.a.c(98, 8, this.abbY);
      paramInt = i;
      if (this.ifY != null) {
        paramInt = i + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91559);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abbV.clear();
        this.abbX.clear();
        this.abbY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dwc localdwc = (dwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
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
            localdwc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localdwc.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localdwc.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dke)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.abbO = ((dke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localdwc.UZS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localdwc.UZT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localdwc.UZU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localdwc.UZV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localdwc.UZW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localdwc.abbP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arb)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.abbQ = ((arb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 12: 
          localdwc.abbR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 13: 
          localdwc.abbS = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91559);
          return 0;
        case 14: 
          localdwc.abbT = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91559);
          return 0;
        case 15: 
          localdwc.abbU = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91559);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.abbV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 17: 
          localdwc.abbW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.abbX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 98: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eir();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eir)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.abbY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 99: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localdwc.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localdwc.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwc
 * JD-Core Version:    0.7.0.1
 */