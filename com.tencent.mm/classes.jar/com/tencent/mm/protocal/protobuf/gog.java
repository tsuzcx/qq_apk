package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gog
  extends esc
{
  public gol YGU;
  public int Zve;
  public LinkedList<cjb> Zvf;
  public int aarD;
  public LinkedList<anp> aarE;
  public anh akkW;
  public int akkX;
  public LinkedList<anh> akkY;
  public int akkZ;
  public LinkedList<anj> akla;
  public int aklb;
  public int aklc;
  public int akld;
  public LinkedList<anj> akle;
  public String aklf;
  
  public gog()
  {
    AppMethodBeat.i(104800);
    this.Zvf = new LinkedList();
    this.akkY = new LinkedList();
    this.aarE = new LinkedList();
    this.akla = new LinkedList();
    this.akle = new LinkedList();
    AppMethodBeat.o(104800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YGU != null)
      {
        paramVarArgs.qD(2, this.YGU.computeSize());
        this.YGU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Zve);
      paramVarArgs.e(4, 8, this.Zvf);
      if (this.akkW != null)
      {
        paramVarArgs.qD(5, this.akkW.computeSize());
        this.akkW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.akkX);
      paramVarArgs.e(7, 8, this.akkY);
      paramVarArgs.bS(8, this.aarD);
      paramVarArgs.e(9, 8, this.aarE);
      paramVarArgs.bS(10, this.akkZ);
      paramVarArgs.e(11, 8, this.akla);
      paramVarArgs.bS(12, this.aklb);
      paramVarArgs.bS(13, this.aklc);
      paramVarArgs.bS(14, this.akld);
      paramVarArgs.e(15, 8, this.akle);
      if (this.aklf != null) {
        paramVarArgs.g(16, this.aklf);
      }
      AppMethodBeat.o(104801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1602;
      }
    }
    label1602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YGU != null) {
        i = paramInt + i.a.a.a.qC(2, this.YGU.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Zve) + i.a.a.a.c(4, 8, this.Zvf);
      paramInt = i;
      if (this.akkW != null) {
        paramInt = i + i.a.a.a.qC(5, this.akkW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.akkX) + i.a.a.a.c(7, 8, this.akkY) + i.a.a.b.b.a.cJ(8, this.aarD) + i.a.a.a.c(9, 8, this.aarE) + i.a.a.b.b.a.cJ(10, this.akkZ) + i.a.a.a.c(11, 8, this.akla) + i.a.a.b.b.a.cJ(12, this.aklb) + i.a.a.b.b.a.cJ(13, this.aklc) + i.a.a.b.b.a.cJ(14, this.akld) + i.a.a.a.c(15, 8, this.akle);
      paramInt = i;
      if (this.aklf != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aklf);
      }
      AppMethodBeat.o(104801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zvf.clear();
        this.akkY.clear();
        this.aarE.clear();
        this.akla.clear();
        this.akle.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        if (this.YGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gog localgog = (gog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104801);
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
            localgog.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgog.YGU = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 3: 
          localgog.Zve = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjb)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.Zvf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anh)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.akkW = ((anh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 6: 
          localgog.akkX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anh)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.akkY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 8: 
          localgog.aarD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anp)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.aarE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 10: 
          localgog.akkZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anj)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.akla.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 12: 
          localgog.aklb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 13: 
          localgog.aklc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 14: 
          localgog.akld = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104801);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anj)localObject2).parseFrom((byte[])localObject1);
            }
            localgog.akle.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        }
        localgog.aklf = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(104801);
        return 0;
      }
      AppMethodBeat.o(104801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gog
 * JD-Core Version:    0.7.0.1
 */