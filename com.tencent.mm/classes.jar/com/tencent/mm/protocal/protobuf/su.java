package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class su
  extends cld
{
  public String CUE;
  public String nTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91413);
        throw paramVarArgs;
      }
      if (this.CUE == null)
      {
        paramVarArgs = new b("Not all required fields were included: retcode");
        AppMethodBeat.o(91413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CUE != null) {
        paramVarArgs.d(2, this.CUE);
      }
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      AppMethodBeat.o(91413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CUE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CUE);
      }
      i = paramInt;
      if (this.nTK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nTK);
      }
      AppMethodBeat.o(91413);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91413);
          throw paramVarArgs;
        }
        if (this.CUE == null)
        {
          paramVarArgs = new b("Not all required fields were included: retcode");
          AppMethodBeat.o(91413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        su localsu = (su)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91413);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91413);
          return 0;
        case 2: 
          localsu.CUE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91413);
          return 0;
        }
        localsu.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91413);
        return 0;
      }
      AppMethodBeat.o(91413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.su
 * JD-Core Version:    0.7.0.1
 */