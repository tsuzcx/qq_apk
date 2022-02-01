package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class co
  extends cwj
{
  public String FNt;
  public String qkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32107);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FNt != null) {
        paramVarArgs.d(2, this.FNt);
      }
      if (this.qkR != null) {
        paramVarArgs.d(3, this.qkR);
      }
      AppMethodBeat.o(32107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label491;
      }
    }
    label491:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNt);
      }
      i = paramInt;
      if (this.qkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qkR);
      }
      AppMethodBeat.o(32107);
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
          AppMethodBeat.o(32107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32107);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32107);
          return 0;
        case 2: 
          localco.FNt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32107);
          return 0;
        }
        localco.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32107);
        return 0;
      }
      AppMethodBeat.o(32107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.co
 * JD-Core Version:    0.7.0.1
 */