package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brh
  extends cwj
{
  public int HeA;
  public brf Heq;
  public int drN;
  public int uoi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123603);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123603);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Heq != null)
      {
        paramVarArgs.lJ(2, this.Heq.computeSize());
        this.Heq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.drN);
      paramVarArgs.aS(4, this.uoi);
      paramVarArgs.aS(5, this.HeA);
      AppMethodBeat.o(123603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Heq != null) {
        i = paramInt + f.a.a.a.lI(2, this.Heq.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.drN);
      int j = f.a.a.b.b.a.bz(4, this.uoi);
      int k = f.a.a.b.b.a.bz(5, this.HeA);
      AppMethodBeat.o(123603);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(123603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brh localbrh = (brh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123603);
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
            localbrh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrh.Heq = ((brf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 3: 
          localbrh.drN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123603);
          return 0;
        case 4: 
          localbrh.uoi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123603);
          return 0;
        }
        localbrh.HeA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123603);
        return 0;
      }
      AppMethodBeat.o(123603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brh
 * JD-Core Version:    0.7.0.1
 */