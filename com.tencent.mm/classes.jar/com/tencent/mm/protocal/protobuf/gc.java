package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gc
  extends cwj
{
  public com.tencent.mm.bw.b FQF;
  public int FQK;
  public int FQL;
  public gh FQM;
  public gd FQN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FQK);
      paramVarArgs.aS(3, this.FQL);
      if (this.FQF != null) {
        paramVarArgs.c(4, this.FQF);
      }
      if (this.FQM != null)
      {
        paramVarArgs.lJ(5, this.FQM.computeSize());
        this.FQM.writeFields(paramVarArgs);
      }
      if (this.FQN != null)
      {
        paramVarArgs.lJ(6, this.FQN.computeSize());
        this.FQN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FQK) + f.a.a.b.b.a.bz(3, this.FQL);
      paramInt = i;
      if (this.FQF != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FQF);
      }
      i = paramInt;
      if (this.FQM != null) {
        i = paramInt + f.a.a.a.lI(5, this.FQM.computeSize());
      }
      paramInt = i;
      if (this.FQN != null) {
        paramInt = i + f.a.a.a.lI(6, this.FQN.computeSize());
      }
      AppMethodBeat.o(32119);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gc localgc = (gc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
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
            localgc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localgc.FQK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localgc.FQL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localgc.FQF = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgc.FQM = ((gh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgc.FQN = ((gd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */