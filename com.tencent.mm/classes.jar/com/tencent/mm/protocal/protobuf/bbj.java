package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbj
  extends cwj
{
  public com.tencent.mm.bw.b GRi;
  public int GRj;
  public com.tencent.mm.bw.b GRk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152569);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GRj);
      if (this.GRk != null) {
        paramVarArgs.c(4, this.GRk);
      }
      if (this.GRi != null) {
        paramVarArgs.c(5, this.GRi);
      }
      AppMethodBeat.o(152569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.GRj);
      paramInt = i;
      if (this.GRk != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GRk);
      }
      i = paramInt;
      if (this.GRi != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.GRi);
      }
      AppMethodBeat.o(152569);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbj localbbj = (bbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(152569);
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
            localbbj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152569);
          return 0;
        case 3: 
          localbbj.GRj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152569);
          return 0;
        case 4: 
          localbbj.GRk = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152569);
          return 0;
        }
        localbbj.GRi = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(152569);
        return 0;
      }
      AppMethodBeat.o(152569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbj
 * JD-Core Version:    0.7.0.1
 */