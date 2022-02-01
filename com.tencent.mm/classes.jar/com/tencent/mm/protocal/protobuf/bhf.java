package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhf
  extends cwj
{
  public cbk GVt;
  public dut GVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.GVt == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.GVu == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GVt != null)
      {
        paramVarArgs.lJ(2, this.GVt.computeSize());
        this.GVt.writeFields(paramVarArgs);
      }
      if (this.GVu != null)
      {
        paramVarArgs.lJ(3, this.GVu.computeSize());
        this.GVu.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GVt != null) {
        paramInt = i + f.a.a.a.lI(2, this.GVt.computeSize());
      }
      i = paramInt;
      if (this.GVu != null) {
        i = paramInt + f.a.a.a.lI(3, this.GVu.computeSize());
      }
      AppMethodBeat.o(134246);
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
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.GVt == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.GVu == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhf localbhf = (bhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134246);
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
            localbhf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhf.GVt = ((cbk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dut();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dut)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhf.GVu = ((dut)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhf
 * JD-Core Version:    0.7.0.1
 */