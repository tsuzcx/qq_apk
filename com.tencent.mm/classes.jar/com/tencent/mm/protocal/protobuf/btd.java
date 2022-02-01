package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btd
  extends dpc
{
  public cqm LZN;
  public eos LZO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.LZN == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.LZO == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LZN != null)
      {
        paramVarArgs.ni(2, this.LZN.computeSize());
        this.LZN.writeFields(paramVarArgs);
      }
      if (this.LZO != null)
      {
        paramVarArgs.ni(3, this.LZO.computeSize());
        this.LZO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LZN != null) {
        paramInt = i + g.a.a.a.nh(2, this.LZN.computeSize());
      }
      i = paramInt;
      if (this.LZO != null) {
        i = paramInt + g.a.a.a.nh(3, this.LZO.computeSize());
      }
      AppMethodBeat.o(134246);
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
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.LZN == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.LZO == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfoExt");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btd localbtd = (btd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134246);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtd.LZN = ((cqm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eos();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eos)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbtd.LZO = ((eos)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      AppMethodBeat.o(134246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btd
 * JD-Core Version:    0.7.0.1
 */