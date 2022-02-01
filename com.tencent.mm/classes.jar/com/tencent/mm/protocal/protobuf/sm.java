package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sm
  extends esc
{
  public int OjV = 0;
  public String OjW;
  public String OjX;
  public String OjY;
  public String OjZ;
  public String Oln;
  public String YGt;
  public String YGu;
  public String YXB;
  public fci YXC;
  public String YXD;
  public String YXE;
  public int YXF;
  public int YXG;
  public int YXH;
  public fnr YXI;
  public String YXJ;
  public int YXK;
  public int YXL;
  public int YXM;
  public com.tencent.mm.bx.b YXN;
  public int YXO;
  public int YXP;
  public int YXQ;
  public sf YXR;
  public eu YXS;
  public et YXT;
  public abh YXU;
  public String YXm;
  public String hMy;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
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
      if (this.hMy != null) {
        paramVarArgs.g(4, this.hMy);
      }
      if (this.YXB != null) {
        paramVarArgs.g(5, this.YXB);
      }
      if (this.YXC != null)
      {
        paramVarArgs.qD(6, this.YXC.computeSize());
        this.YXC.writeFields(paramVarArgs);
      }
      if (this.YGt != null) {
        paramVarArgs.g(7, this.YGt);
      }
      if (this.YGu != null) {
        paramVarArgs.g(8, this.YGu);
      }
      if (this.YXD != null) {
        paramVarArgs.g(9, this.YXD);
      }
      if (this.YXE != null) {
        paramVarArgs.g(10, this.YXE);
      }
      paramVarArgs.bS(11, this.YXF);
      if (this.Oln != null) {
        paramVarArgs.g(12, this.Oln);
      }
      if (this.YXm != null) {
        paramVarArgs.g(13, this.YXm);
      }
      paramVarArgs.bS(14, this.YXG);
      paramVarArgs.bS(15, this.YXH);
      if (this.YXI != null)
      {
        paramVarArgs.qD(16, this.YXI.computeSize());
        this.YXI.writeFields(paramVarArgs);
      }
      if (this.YXJ != null) {
        paramVarArgs.g(17, this.YXJ);
      }
      paramVarArgs.bS(18, this.YXK);
      paramVarArgs.bS(19, this.YXL);
      paramVarArgs.bS(20, this.YXM);
      if (this.YXN != null) {
        paramVarArgs.d(21, this.YXN);
      }
      paramVarArgs.bS(22, this.YXO);
      paramVarArgs.bS(23, this.OjV);
      if (this.OjW != null) {
        paramVarArgs.g(24, this.OjW);
      }
      if (this.OjX != null) {
        paramVarArgs.g(25, this.OjX);
      }
      paramVarArgs.bS(26, this.YXP);
      if (this.OjY != null) {
        paramVarArgs.g(27, this.OjY);
      }
      if (this.OjZ != null) {
        paramVarArgs.g(28, this.OjZ);
      }
      paramVarArgs.bS(29, this.YXQ);
      if (this.YXR != null)
      {
        paramVarArgs.qD(30, this.YXR.computeSize());
        this.YXR.writeFields(paramVarArgs);
      }
      if (this.YXS != null)
      {
        paramVarArgs.qD(31, this.YXS.computeSize());
        this.YXS.writeFields(paramVarArgs);
      }
      if (this.YXT != null)
      {
        paramVarArgs.qD(32, this.YXT.computeSize());
        this.YXT.writeFields(paramVarArgs);
      }
      if (this.YXU != null)
      {
        paramVarArgs.qD(33, this.YXU.computeSize());
        this.YXU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2556;
      }
    }
    label2556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.hMy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.hMy);
      }
      paramInt = i;
      if (this.YXB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YXB);
      }
      i = paramInt;
      if (this.YXC != null) {
        i = paramInt + i.a.a.a.qC(6, this.YXC.computeSize());
      }
      paramInt = i;
      if (this.YGt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YGt);
      }
      i = paramInt;
      if (this.YGu != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YGu);
      }
      paramInt = i;
      if (this.YXD != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YXD);
      }
      i = paramInt;
      if (this.YXE != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YXE);
      }
      i += i.a.a.b.b.a.cJ(11, this.YXF);
      paramInt = i;
      if (this.Oln != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Oln);
      }
      i = paramInt;
      if (this.YXm != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YXm);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.YXG) + i.a.a.b.b.a.cJ(15, this.YXH);
      paramInt = i;
      if (this.YXI != null) {
        paramInt = i + i.a.a.a.qC(16, this.YXI.computeSize());
      }
      i = paramInt;
      if (this.YXJ != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.YXJ);
      }
      i = i + i.a.a.b.b.a.cJ(18, this.YXK) + i.a.a.b.b.a.cJ(19, this.YXL) + i.a.a.b.b.a.cJ(20, this.YXM);
      paramInt = i;
      if (this.YXN != null) {
        paramInt = i + i.a.a.b.b.a.c(21, this.YXN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.YXO) + i.a.a.b.b.a.cJ(23, this.OjV);
      paramInt = i;
      if (this.OjW != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.OjW);
      }
      i = paramInt;
      if (this.OjX != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.OjX);
      }
      i += i.a.a.b.b.a.cJ(26, this.YXP);
      paramInt = i;
      if (this.OjY != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.OjY);
      }
      i = paramInt;
      if (this.OjZ != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.OjZ);
      }
      i += i.a.a.b.b.a.cJ(29, this.YXQ);
      paramInt = i;
      if (this.YXR != null) {
        paramInt = i + i.a.a.a.qC(30, this.YXR.computeSize());
      }
      i = paramInt;
      if (this.YXS != null) {
        i = paramInt + i.a.a.a.qC(31, this.YXS.computeSize());
      }
      paramInt = i;
      if (this.YXT != null) {
        paramInt = i + i.a.a.a.qC(32, this.YXT.computeSize());
      }
      i = paramInt;
      if (this.YXU != null) {
        i = paramInt + i.a.a.a.qC(33, this.YXU.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sm localsm = (sm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
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
            localsm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localsm.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localsm.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localsm.hMy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localsm.YXB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fci)localObject2).parseFrom((byte[])localObject1);
            }
            localsm.YXC = ((fci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localsm.YGt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localsm.YGu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localsm.YXD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localsm.YXE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localsm.YXF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localsm.Oln = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localsm.YXm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localsm.YXG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localsm.YXH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnr)localObject2).parseFrom((byte[])localObject1);
            }
            localsm.YXI = ((fnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localsm.YXJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localsm.YXK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localsm.YXL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localsm.YXM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localsm.YXN = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localsm.YXO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localsm.OjV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localsm.OjW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localsm.OjX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localsm.YXP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localsm.OjY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localsm.OjZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localsm.YXQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sf)localObject2).parseFrom((byte[])localObject1);
            }
            localsm.YXR = ((sf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eu)localObject2).parseFrom((byte[])localObject1);
            }
            localsm.YXS = ((eu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new et();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((et)localObject2).parseFrom((byte[])localObject1);
            }
            localsm.YXT = ((et)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abh)localObject2).parseFrom((byte[])localObject1);
          }
          localsm.YXU = ((abh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sm
 * JD-Core Version:    0.7.0.1
 */