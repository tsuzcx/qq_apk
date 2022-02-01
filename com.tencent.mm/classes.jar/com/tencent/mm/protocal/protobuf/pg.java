package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pg
  extends cwj
{
  public ckj GcQ;
  public fb GcR;
  public pe GcS;
  public cnf GcT;
  public dwj GcU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124461);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124461);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GcQ != null)
      {
        paramVarArgs.lJ(2, this.GcQ.computeSize());
        this.GcQ.writeFields(paramVarArgs);
      }
      if (this.GcR != null)
      {
        paramVarArgs.lJ(3, this.GcR.computeSize());
        this.GcR.writeFields(paramVarArgs);
      }
      if (this.GcS != null)
      {
        paramVarArgs.lJ(4, this.GcS.computeSize());
        this.GcS.writeFields(paramVarArgs);
      }
      if (this.GcT != null)
      {
        paramVarArgs.lJ(5, this.GcT.computeSize());
        this.GcT.writeFields(paramVarArgs);
      }
      if (this.GcU != null)
      {
        paramVarArgs.lJ(6, this.GcU.computeSize());
        this.GcU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GcQ != null) {
        paramInt = i + f.a.a.a.lI(2, this.GcQ.computeSize());
      }
      i = paramInt;
      if (this.GcR != null) {
        i = paramInt + f.a.a.a.lI(3, this.GcR.computeSize());
      }
      paramInt = i;
      if (this.GcS != null) {
        paramInt = i + f.a.a.a.lI(4, this.GcS.computeSize());
      }
      i = paramInt;
      if (this.GcT != null) {
        i = paramInt + f.a.a.a.lI(5, this.GcT.computeSize());
      }
      paramInt = i;
      if (this.GcU != null) {
        paramInt = i + f.a.a.a.lI(6, this.GcU.computeSize());
      }
      AppMethodBeat.o(124461);
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
          AppMethodBeat.o(124461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pg localpg = (pg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124461);
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
            localpg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpg.GcQ = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpg.GcR = ((fb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpg.GcS = ((pe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpg.GcT = ((cnf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpg.GcU = ((dwj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      AppMethodBeat.o(124461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pg
 * JD-Core Version:    0.7.0.1
 */