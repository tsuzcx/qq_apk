package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayi
  extends cwj
{
  public cqt FZD;
  public nn GPf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124505);
        throw paramVarArgs;
      }
      if (this.FZD == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124505);
        throw paramVarArgs;
      }
      if (this.GPf == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(124505);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FZD != null)
      {
        paramVarArgs.lJ(2, this.FZD.computeSize());
        this.FZD.writeFields(paramVarArgs);
      }
      if (this.GPf != null)
      {
        paramVarArgs.lJ(3, this.GPf.computeSize());
        this.GPf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124505);
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
      if (this.FZD != null) {
        paramInt = i + f.a.a.a.lI(2, this.FZD.computeSize());
      }
      i = paramInt;
      if (this.GPf != null) {
        i = paramInt + f.a.a.a.lI(3, this.GPf.computeSize());
      }
      AppMethodBeat.o(124505);
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
          AppMethodBeat.o(124505);
          throw paramVarArgs;
        }
        if (this.FZD == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124505);
          throw paramVarArgs;
        }
        if (this.GPf == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(124505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayi localayi = (ayi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124505);
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
            localayi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124505);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayi.FZD = ((cqt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124505);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayi.GPf = ((nn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124505);
        return 0;
      }
      AppMethodBeat.o(124505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayi
 * JD-Core Version:    0.7.0.1
 */