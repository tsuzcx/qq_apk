package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wi
  extends dpc
{
  public String LhA;
  public String qwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91413);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91413);
        throw paramVarArgs;
      }
      if (this.LhA == null)
      {
        paramVarArgs = new b("Not all required fields were included: retcode");
        AppMethodBeat.o(91413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LhA != null) {
        paramVarArgs.e(2, this.LhA);
      }
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
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
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LhA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LhA);
      }
      i = paramInt;
      if (this.qwn != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qwn);
      }
      AppMethodBeat.o(91413);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91413);
          throw paramVarArgs;
        }
        if (this.LhA == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wi localwi = (wi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91413);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localwi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91413);
          return 0;
        case 2: 
          localwi.LhA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91413);
          return 0;
        }
        localwi.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91413);
        return 0;
      }
      AppMethodBeat.o(91413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wi
 * JD-Core Version:    0.7.0.1
 */