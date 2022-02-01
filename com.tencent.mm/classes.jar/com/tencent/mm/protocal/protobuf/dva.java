package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dva
  extends esc
{
  public String ZhF;
  public LinkedList<dve> abaS;
  public String abaT;
  public boolean abaU;
  public boolean abaV;
  public boolean abaW;
  public LinkedList<dvb> abaX;
  public boolean abaY;
  public boolean abaZ;
  public dvf abba;
  public String nSt;
  public boolean rGY;
  public int rGZ;
  public int rHa;
  public String rHb;
  public String rHc;
  
  public dva()
  {
    AppMethodBeat.i(82461);
    this.abaS = new LinkedList();
    this.abaX = new LinkedList();
    AppMethodBeat.o(82461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82462);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82462);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.abaS);
      if (this.nSt != null) {
        paramVarArgs.g(4, this.nSt);
      }
      if (this.abaT != null) {
        paramVarArgs.g(5, this.abaT);
      }
      if (this.ZhF != null) {
        paramVarArgs.g(6, this.ZhF);
      }
      paramVarArgs.di(8, this.abaU);
      paramVarArgs.di(9, this.abaV);
      paramVarArgs.di(10, this.abaW);
      paramVarArgs.e(11, 8, this.abaX);
      paramVarArgs.di(12, this.abaY);
      paramVarArgs.di(13, this.rGY);
      paramVarArgs.bS(14, this.rGZ);
      paramVarArgs.bS(15, this.rHa);
      if (this.rHb != null) {
        paramVarArgs.g(16, this.rHb);
      }
      if (this.rHc != null) {
        paramVarArgs.g(17, this.rHc);
      }
      paramVarArgs.di(18, this.abaZ);
      if (this.abba != null)
      {
        paramVarArgs.qD(19, this.abba.computeSize());
        this.abba.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(3, 8, this.abaS);
      paramInt = i;
      if (this.nSt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nSt);
      }
      i = paramInt;
      if (this.abaT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abaT);
      }
      paramInt = i;
      if (this.ZhF != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZhF);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 1) + (i.a.a.b.b.a.ko(9) + 1) + (i.a.a.b.b.a.ko(10) + 1) + i.a.a.a.c(11, 8, this.abaX) + (i.a.a.b.b.a.ko(12) + 1) + (i.a.a.b.b.a.ko(13) + 1) + i.a.a.b.b.a.cJ(14, this.rGZ) + i.a.a.b.b.a.cJ(15, this.rHa);
      paramInt = i;
      if (this.rHb != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.rHb);
      }
      i = paramInt;
      if (this.rHc != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.rHc);
      }
      i += i.a.a.b.b.a.ko(18) + 1;
      paramInt = i;
      if (this.abba != null) {
        paramInt = i + i.a.a.a.qC(19, this.abba.computeSize());
      }
      AppMethodBeat.o(82462);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abaS.clear();
        this.abaX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82462);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dva localdva = (dva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(82462);
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
            localdva.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dve)localObject2).parseFrom((byte[])localObject1);
            }
            localdva.abaS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 4: 
          localdva.nSt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 5: 
          localdva.abaT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 6: 
          localdva.ZhF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 8: 
          localdva.abaU = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        case 9: 
          localdva.abaV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        case 10: 
          localdva.abaW = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvb)localObject2).parseFrom((byte[])localObject1);
            }
            localdva.abaX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 12: 
          localdva.abaY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        case 13: 
          localdva.rGY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        case 14: 
          localdva.rGZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82462);
          return 0;
        case 15: 
          localdva.rHa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82462);
          return 0;
        case 16: 
          localdva.rHb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 17: 
          localdva.rHc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 18: 
          localdva.abaZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82462);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvf)localObject2).parseFrom((byte[])localObject1);
          }
          localdva.abba = ((dvf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      AppMethodBeat.o(82462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dva
 * JD-Core Version:    0.7.0.1
 */