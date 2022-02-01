package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bed
  extends dpc
{
  public String HIt;
  public FinderContact LAJ;
  public int LNK;
  public String LNL;
  public String LNM;
  public String LNN;
  public int LNO;
  public int LNP;
  public aet LNQ;
  public int LNR;
  public int LNS;
  public bel LNT;
  public int LNU;
  public ddl LNV;
  public int LNW;
  public String LNX;
  public String LNY;
  public ax LNZ;
  public int actionType;
  public int vIE;
  public int vMq;
  public azn verifyInfo;
  public bel wxaShopInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.ni(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.LAJ != null)
      {
        paramVarArgs.ni(4, this.LAJ.computeSize());
        this.LAJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.LNK);
      if (this.LNL != null) {
        paramVarArgs.e(6, this.LNL);
      }
      if (this.LNM != null) {
        paramVarArgs.e(7, this.LNM);
      }
      if (this.LNN != null) {
        paramVarArgs.e(8, this.LNN);
      }
      paramVarArgs.aM(9, this.LNO);
      paramVarArgs.aM(10, this.vMq);
      paramVarArgs.aM(11, this.LNP);
      paramVarArgs.aM(12, this.vIE);
      if (this.LNQ != null)
      {
        paramVarArgs.ni(13, this.LNQ.computeSize());
        this.LNQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.LNR);
      paramVarArgs.aM(15, this.LNS);
      if (this.HIt != null) {
        paramVarArgs.e(16, this.HIt);
      }
      if (this.LNT != null)
      {
        paramVarArgs.ni(17, this.LNT.computeSize());
        this.LNT.writeFields(paramVarArgs);
      }
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.ni(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(19, this.LNU);
      if (this.LNV != null)
      {
        paramVarArgs.ni(21, this.LNV.computeSize());
        this.LNV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(22, this.LNW);
      if (this.LNX != null) {
        paramVarArgs.e(23, this.LNX);
      }
      if (this.LNY != null) {
        paramVarArgs.e(25, this.LNY);
      }
      if (this.LNZ != null)
      {
        paramVarArgs.ni(26, this.LNZ.computeSize());
        this.LNZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2226;
      }
    }
    label2226:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + g.a.a.a.nh(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.LAJ != null) {
        i = paramInt + g.a.a.a.nh(4, this.LAJ.computeSize());
      }
      i += g.a.a.b.b.a.bu(5, this.LNK);
      paramInt = i;
      if (this.LNL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LNL);
      }
      i = paramInt;
      if (this.LNM != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LNM);
      }
      paramInt = i;
      if (this.LNN != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LNN);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.LNO) + g.a.a.b.b.a.bu(10, this.vMq) + g.a.a.b.b.a.bu(11, this.LNP) + g.a.a.b.b.a.bu(12, this.vIE);
      paramInt = i;
      if (this.LNQ != null) {
        paramInt = i + g.a.a.a.nh(13, this.LNQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.LNR) + g.a.a.b.b.a.bu(15, this.LNS);
      paramInt = i;
      if (this.HIt != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.HIt);
      }
      i = paramInt;
      if (this.LNT != null) {
        i = paramInt + g.a.a.a.nh(17, this.LNT.computeSize());
      }
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + g.a.a.a.nh(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.LNU);
      paramInt = i;
      if (this.LNV != null) {
        paramInt = i + g.a.a.a.nh(21, this.LNV.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.LNW);
      paramInt = i;
      if (this.LNX != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.LNX);
      }
      i = paramInt;
      if (this.LNY != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.LNY);
      }
      paramInt = i;
      if (this.LNZ != null) {
        paramInt = i + g.a.a.a.nh(26, this.LNZ.computeSize());
      }
      AppMethodBeat.o(169074);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bed localbed = (bed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 20: 
        case 24: 
        default: 
          AppMethodBeat.o(169074);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localbed.actionType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.verifyInfo = ((azn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.LAJ = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localbed.LNK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localbed.LNL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localbed.LNM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localbed.LNN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localbed.LNO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localbed.vMq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localbed.LNP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localbed.vIE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.LNQ = ((aet)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 14: 
          localbed.LNR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 15: 
          localbed.LNS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 16: 
          localbed.HIt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bel();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bel)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.LNT = ((bel)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bel();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bel)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.wxaShopInfo = ((bel)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 19: 
          localbed.LNU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbed.LNV = ((ddl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 22: 
          localbed.LNW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169074);
          return 0;
        case 23: 
          localbed.LNX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 25: 
          localbed.LNY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169074);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ax();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ax)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbed.LNZ = ((ax)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bed
 * JD-Core Version:    0.7.0.1
 */