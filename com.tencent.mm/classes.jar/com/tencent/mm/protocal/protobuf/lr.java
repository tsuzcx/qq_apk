package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lr
  extends cwj
{
  public int FKJ;
  public dfb FRC;
  public String FRD;
  public int FRH;
  public String FWA;
  public int FWB;
  public cxq FWC;
  public String FWD;
  public String FWE;
  public String FWF;
  public String FWG;
  public int FWH;
  public int FWo;
  public String FWp;
  public ccv FWt;
  public String FWu;
  public int FWv;
  public String FWw;
  public bpj FWx;
  public px FWy;
  public ccw FWz;
  public String Username;
  public String dqk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.dqk != null) {
        paramVarArgs.d(2, this.dqk);
      }
      if (this.FWu != null) {
        paramVarArgs.d(3, this.FWu);
      }
      paramVarArgs.aS(4, this.FWv);
      if (this.FWw != null) {
        paramVarArgs.d(5, this.FWw);
      }
      if (this.Username != null) {
        paramVarArgs.d(6, this.Username);
      }
      if (this.FWx != null)
      {
        paramVarArgs.lJ(7, this.FWx.computeSize());
        this.FWx.writeFields(paramVarArgs);
      }
      if (this.FWy != null)
      {
        paramVarArgs.lJ(8, this.FWy.computeSize());
        this.FWy.writeFields(paramVarArgs);
      }
      if (this.FWz != null)
      {
        paramVarArgs.lJ(9, this.FWz.computeSize());
        this.FWz.writeFields(paramVarArgs);
      }
      if (this.FRD != null) {
        paramVarArgs.d(10, this.FRD);
      }
      paramVarArgs.aS(11, this.FKJ);
      if (this.FWA != null) {
        paramVarArgs.d(12, this.FWA);
      }
      paramVarArgs.aS(13, this.FWB);
      if (this.FWC != null)
      {
        paramVarArgs.lJ(14, this.FWC.computeSize());
        this.FWC.writeFields(paramVarArgs);
      }
      if (this.FWD != null) {
        paramVarArgs.d(15, this.FWD);
      }
      if (this.FWE != null) {
        paramVarArgs.d(16, this.FWE);
      }
      if (this.FRC != null)
      {
        paramVarArgs.lJ(17, this.FRC.computeSize());
        this.FRC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(18, this.FRH);
      if (this.FWF != null) {
        paramVarArgs.d(19, this.FWF);
      }
      if (this.FWG != null) {
        paramVarArgs.d(20, this.FWG);
      }
      paramVarArgs.aS(21, this.FWo);
      if (this.FWp != null) {
        paramVarArgs.d(22, this.FWp);
      }
      paramVarArgs.aS(23, this.FWH);
      if (this.FWt != null)
      {
        paramVarArgs.lJ(24, this.FWt.computeSize());
        this.FWt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dqk);
      }
      i = paramInt;
      if (this.FWu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWu);
      }
      i += f.a.a.b.b.a.bz(4, this.FWv);
      paramInt = i;
      if (this.FWw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FWw);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Username);
      }
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.a.lI(7, this.FWx.computeSize());
      }
      i = paramInt;
      if (this.FWy != null) {
        i = paramInt + f.a.a.a.lI(8, this.FWy.computeSize());
      }
      paramInt = i;
      if (this.FWz != null) {
        paramInt = i + f.a.a.a.lI(9, this.FWz.computeSize());
      }
      i = paramInt;
      if (this.FRD != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FRD);
      }
      i += f.a.a.b.b.a.bz(11, this.FKJ);
      paramInt = i;
      if (this.FWA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FWA);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FWB);
      paramInt = i;
      if (this.FWC != null) {
        paramInt = i + f.a.a.a.lI(14, this.FWC.computeSize());
      }
      i = paramInt;
      if (this.FWD != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FWD);
      }
      paramInt = i;
      if (this.FWE != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FWE);
      }
      i = paramInt;
      if (this.FRC != null) {
        i = paramInt + f.a.a.a.lI(17, this.FRC.computeSize());
      }
      i += f.a.a.b.b.a.bz(18, this.FRH);
      paramInt = i;
      if (this.FWF != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FWF);
      }
      i = paramInt;
      if (this.FWG != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.FWG);
      }
      i += f.a.a.b.b.a.bz(21, this.FWo);
      paramInt = i;
      if (this.FWp != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FWp);
      }
      i = paramInt + f.a.a.b.b.a.bz(23, this.FWH);
      paramInt = i;
      if (this.FWt != null) {
        paramInt = i + f.a.a.a.lI(24, this.FWt.computeSize());
      }
      AppMethodBeat.o(134244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lr locallr = (lr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          locallr.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          locallr.FWu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          locallr.FWv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          locallr.FWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          locallr.Username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FWx = ((bpj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FWy = ((px)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FWz = ((ccw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          locallr.FRD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          locallr.FKJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          locallr.FWA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          locallr.FWB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FWC = ((cxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          locallr.FWD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          locallr.FWE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.FRC = ((dfb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          locallr.FRH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          locallr.FWF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          locallr.FWG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          locallr.FWo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          locallr.FWp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          locallr.FWH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(134244);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallr.FWt = ((ccv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lr
 * JD-Core Version:    0.7.0.1
 */