package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bda
  extends dpc
{
  public com.tencent.mm.bw.b LCV;
  public awu LDS;
  public String LME;
  public String LMF;
  public int LMG;
  public int LMH;
  public int LMI;
  public apt LMJ;
  public int LMK;
  public bdt LML;
  public apa LMM;
  public String LMN;
  public bcy LMO;
  public String Lme;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public baw preloadInfo;
  public int tUB;
  public bcx tUH;
  public bcc tvs;
  
  public bda()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.liveObjects = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.LME != null) {
        paramVarArgs.e(4, this.LME);
      }
      if (this.LMF != null) {
        paramVarArgs.e(5, this.LMF);
      }
      paramVarArgs.aM(6, this.tUB);
      paramVarArgs.aM(7, this.LMG);
      paramVarArgs.aM(8, this.LMH);
      paramVarArgs.aM(9, this.LMI);
      if (this.preloadInfo != null)
      {
        paramVarArgs.ni(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.LMJ != null)
      {
        paramVarArgs.ni(11, this.LMJ.computeSize());
        this.LMJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.LMK);
      paramVarArgs.e(13, 8, this.liveObjects);
      if (this.LML != null)
      {
        paramVarArgs.ni(14, this.LML.computeSize());
        this.LML.writeFields(paramVarArgs);
      }
      if (this.LMM != null)
      {
        paramVarArgs.ni(15, this.LMM.computeSize());
        this.LMM.writeFields(paramVarArgs);
      }
      if (this.LMN != null) {
        paramVarArgs.e(16, this.LMN);
      }
      if (this.tvs != null)
      {
        paramVarArgs.ni(17, this.tvs.computeSize());
        this.tvs.writeFields(paramVarArgs);
      }
      if (this.LMO != null)
      {
        paramVarArgs.ni(18, this.LMO.computeSize());
        this.LMO.writeFields(paramVarArgs);
      }
      if (this.tUH != null)
      {
        paramVarArgs.ni(19, this.tUH.computeSize());
        this.tUH.writeFields(paramVarArgs);
      }
      if (this.Lme != null) {
        paramVarArgs.e(20, this.Lme);
      }
      if (this.LDS != null)
      {
        paramVarArgs.ni(21, this.LDS.computeSize());
        this.LDS.writeFields(paramVarArgs);
      }
      if (this.LCV != null) {
        paramVarArgs.c(22, this.LCV);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2478;
      }
    }
    label2478:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.LME != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LME);
      }
      paramInt = i;
      if (this.LMF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LMF);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.tUB) + g.a.a.b.b.a.bu(7, this.LMG) + g.a.a.b.b.a.bu(8, this.LMH) + g.a.a.b.b.a.bu(9, this.LMI);
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + g.a.a.a.nh(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.LMJ != null) {
        i = paramInt + g.a.a.a.nh(11, this.LMJ.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(12, this.LMK) + g.a.a.a.c(13, 8, this.liveObjects);
      paramInt = i;
      if (this.LML != null) {
        paramInt = i + g.a.a.a.nh(14, this.LML.computeSize());
      }
      i = paramInt;
      if (this.LMM != null) {
        i = paramInt + g.a.a.a.nh(15, this.LMM.computeSize());
      }
      paramInt = i;
      if (this.LMN != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.LMN);
      }
      i = paramInt;
      if (this.tvs != null) {
        i = paramInt + g.a.a.a.nh(17, this.tvs.computeSize());
      }
      paramInt = i;
      if (this.LMO != null) {
        paramInt = i + g.a.a.a.nh(18, this.LMO.computeSize());
      }
      i = paramInt;
      if (this.tUH != null) {
        i = paramInt + g.a.a.a.nh(19, this.tUH.computeSize());
      }
      paramInt = i;
      if (this.Lme != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.Lme);
      }
      i = paramInt;
      if (this.LDS != null) {
        i = paramInt + g.a.a.a.nh(21, this.LDS.computeSize());
      }
      paramInt = i;
      if (this.LCV != null) {
        paramInt = i + g.a.a.b.b.a.b(22, this.LCV);
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.liveObjects.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bda localbda = (bda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
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
            localbda.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localbda.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localbda.LME = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localbda.LMF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localbda.tUB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localbda.LMG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localbda.LMH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localbda.LMI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.preloadInfo = ((baw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.LMJ = ((apt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localbda.LMK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.liveObjects.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.LML = ((bdt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.LMM = ((apa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localbda.LMN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.tvs = ((bcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.LMO = ((bcy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.tUH = ((bcx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 20: 
          localbda.Lme = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbda.LDS = ((awu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        localbda.LCV = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bda
 * JD-Core Version:    0.7.0.1
 */