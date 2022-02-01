package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bfr
  extends cwj
{
  public String FKi;
  public b GUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GUz != null) {
        paramVarArgs.c(2, this.GUz);
      }
      if (this.FKi != null) {
        paramVarArgs.d(3, this.FKi);
      }
      AppMethodBeat.o(152579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GUz != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GUz);
      }
      i = paramInt;
      if (this.FKi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FKi);
      }
      AppMethodBeat.o(152579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfr localbfr = (bfr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152579);
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
            localbfr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152579);
          return 0;
        case 2: 
          localbfr.GUz = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152579);
          return 0;
        }
        localbfr.FKi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152579);
        return 0;
      }
      AppMethodBeat.o(152579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfr
 * JD-Core Version:    0.7.0.1
 */