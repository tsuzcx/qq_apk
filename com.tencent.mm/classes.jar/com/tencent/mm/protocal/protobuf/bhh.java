package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhh
  extends cwj
{
  public coo GVv;
  public com GVw;
  public int gvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.GVv == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.GVw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.gvx);
      if (this.GVv != null)
      {
        paramVarArgs.lJ(3, this.GVv.computeSize());
        this.GVv.writeFields(paramVarArgs);
      }
      if (this.GVw != null)
      {
        paramVarArgs.lJ(4, this.GVw.computeSize());
        this.GVw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.gvx);
      paramInt = i;
      if (this.GVv != null) {
        paramInt = i + f.a.a.a.lI(3, this.GVv.computeSize());
      }
      i = paramInt;
      if (this.GVw != null) {
        i = paramInt + f.a.a.a.lI(4, this.GVw.computeSize());
      }
      AppMethodBeat.o(155413);
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
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.GVv == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.GVw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhh localbhh = (bhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155413);
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
            localbhh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        case 2: 
          localbhh.gvx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155413);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhh.GVv = ((coo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new com();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((com)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhh.GVw = ((com)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      AppMethodBeat.o(155413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */