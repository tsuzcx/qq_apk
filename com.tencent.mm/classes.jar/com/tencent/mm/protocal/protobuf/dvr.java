package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dvr
  extends cwj
{
  public SKBuiltinBuffer_t FNK;
  public SKBuiltinBuffer_t FRA;
  public SKBuiltinBuffer_t FRu;
  public String FRz;
  public cxn FWN;
  public SKBuiltinBuffer_t FWO;
  public cxn GYt;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.GYt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GYt != null)
      {
        paramVarArgs.lJ(2, this.GYt.computeSize());
        this.GYt.writeFields(paramVarArgs);
      }
      if (this.FNK != null)
      {
        paramVarArgs.lJ(3, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(4, this.xrf);
      }
      if (this.FWN != null)
      {
        paramVarArgs.lJ(5, this.FWN.computeSize());
        this.FWN.writeFields(paramVarArgs);
      }
      if (this.FRA != null)
      {
        paramVarArgs.lJ(6, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.FWO != null)
      {
        paramVarArgs.lJ(7, this.FWO.computeSize());
        this.FWO.writeFields(paramVarArgs);
      }
      if (this.FRz != null) {
        paramVarArgs.d(8, this.FRz);
      }
      if (this.FRu != null)
      {
        paramVarArgs.lJ(9, this.FRu.computeSize());
        this.FRu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GYt != null) {
        paramInt = i + f.a.a.a.lI(2, this.GYt.computeSize());
      }
      i = paramInt;
      if (this.FNK != null) {
        i = paramInt + f.a.a.a.lI(3, this.FNK.computeSize());
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xrf);
      }
      i = paramInt;
      if (this.FWN != null) {
        i = paramInt + f.a.a.a.lI(5, this.FWN.computeSize());
      }
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lI(6, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.FWO != null) {
        i = paramInt + f.a.a.a.lI(7, this.FWO.computeSize());
      }
      paramInt = i;
      if (this.FRz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FRz);
      }
      i = paramInt;
      if (this.FRu != null) {
        i = paramInt + f.a.a.a.lI(9, this.FRu.computeSize());
      }
      AppMethodBeat.o(43134);
      return i;
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
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.GYt == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvr localdvr = (dvr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43134);
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
            localdvr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvr.GYt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvr.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 4: 
          localdvr.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43134);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvr.FWN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvr.FRA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvr.FWO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 8: 
          localdvr.FRz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43134);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvr.FRu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      AppMethodBeat.o(43134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvr
 * JD-Core Version:    0.7.0.1
 */