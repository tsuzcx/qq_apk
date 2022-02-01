package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lt
  extends cwj
{
  public int FKJ;
  public int FKM;
  public SKBuiltinBuffer_t FNK;
  public SKBuiltinBuffer_t FRA;
  public SKBuiltinBuffer_t FRu;
  public cxq FWC;
  public String FWK;
  public cxn FWN;
  public SKBuiltinBuffer_t FWO;
  public int FWQ;
  public String FWR;
  public String FWS;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FWK != null) {
        paramVarArgs.d(2, this.FWK);
      }
      if (this.FNK != null)
      {
        paramVarArgs.lJ(3, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FKM);
      paramVarArgs.aS(5, this.FWQ);
      if (this.FWR != null) {
        paramVarArgs.d(6, this.FWR);
      }
      paramVarArgs.aS(7, this.nJb);
      if (this.FWS != null) {
        paramVarArgs.d(8, this.FWS);
      }
      if (this.FWN != null)
      {
        paramVarArgs.lJ(9, this.FWN.computeSize());
        this.FWN.writeFields(paramVarArgs);
      }
      if (this.FRA != null)
      {
        paramVarArgs.lJ(10, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.FWO != null)
      {
        paramVarArgs.lJ(11, this.FWO.computeSize());
        this.FWO.writeFields(paramVarArgs);
      }
      if (this.FWC != null)
      {
        paramVarArgs.lJ(12, this.FWC.computeSize());
        this.FWC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.FKJ);
      if (this.FRu != null)
      {
        paramVarArgs.lJ(14, this.FRu.computeSize());
        this.FRu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWK);
      }
      i = paramInt;
      if (this.FNK != null) {
        i = paramInt + f.a.a.a.lI(3, this.FNK.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.FKM) + f.a.a.b.b.a.bz(5, this.FWQ);
      paramInt = i;
      if (this.FWR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FWR);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.nJb);
      paramInt = i;
      if (this.FWS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWS);
      }
      i = paramInt;
      if (this.FWN != null) {
        i = paramInt + f.a.a.a.lI(9, this.FWN.computeSize());
      }
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lI(10, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.FWO != null) {
        i = paramInt + f.a.a.a.lI(11, this.FWO.computeSize());
      }
      paramInt = i;
      if (this.FWC != null) {
        paramInt = i + f.a.a.a.lI(12, this.FWC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FKJ);
      paramInt = i;
      if (this.FRu != null) {
        paramInt = i + f.a.a.a.lI(14, this.FRu.computeSize());
      }
      AppMethodBeat.o(155397);
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
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lt locallt = (lt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            locallt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          locallt.FWK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155397);
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
            locallt.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          locallt.FKM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          locallt.FWQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          locallt.FWR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          locallt.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          locallt.FWS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FWN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FRA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FWO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FWC = ((cxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          locallt.FKJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155397);
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
          locallt.FRu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lt
 * JD-Core Version:    0.7.0.1
 */