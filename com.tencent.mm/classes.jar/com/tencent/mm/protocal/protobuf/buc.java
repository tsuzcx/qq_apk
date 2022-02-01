package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buc
  extends cwj
{
  public xi Hhk;
  public egy Hhq;
  public eha Hhr;
  public eki Hhs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123627);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123627);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hhq != null)
      {
        paramVarArgs.lJ(2, this.Hhq.computeSize());
        this.Hhq.writeFields(paramVarArgs);
      }
      if (this.Hhk != null)
      {
        paramVarArgs.lJ(3, this.Hhk.computeSize());
        this.Hhk.writeFields(paramVarArgs);
      }
      if (this.Hhr != null)
      {
        paramVarArgs.lJ(4, this.Hhr.computeSize());
        this.Hhr.writeFields(paramVarArgs);
      }
      if (this.Hhs != null)
      {
        paramVarArgs.lJ(5, this.Hhs.computeSize());
        this.Hhs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hhq != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hhq.computeSize());
      }
      i = paramInt;
      if (this.Hhk != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hhk.computeSize());
      }
      paramInt = i;
      if (this.Hhr != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hhr.computeSize());
      }
      i = paramInt;
      if (this.Hhs != null) {
        i = paramInt + f.a.a.a.lI(5, this.Hhs.computeSize());
      }
      AppMethodBeat.o(123627);
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
          AppMethodBeat.o(123627);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buc localbuc = (buc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123627);
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
            localbuc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuc.Hhq = ((egy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuc.Hhk = ((xi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eha();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuc.Hhr = ((eha)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eki();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eki)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuc.Hhs = ((eki)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      AppMethodBeat.o(123627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buc
 * JD-Core Version:    0.7.0.1
 */