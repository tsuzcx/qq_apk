package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aom
  extends bvk
{
  public beq xeo;
  public cph xep;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123509);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123509);
        throw paramVarArgs;
      }
      if (this.xeo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(123509);
        throw paramVarArgs;
      }
      if (this.xep == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(123509);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xeo != null)
      {
        paramVarArgs.iQ(2, this.xeo.computeSize());
        this.xeo.writeFields(paramVarArgs);
      }
      if (this.xep != null)
      {
        paramVarArgs.iQ(3, this.xep.computeSize());
        this.xep.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xeo != null) {
        paramInt = i + e.a.a.a.iP(2, this.xeo.computeSize());
      }
      i = paramInt;
      if (this.xep != null) {
        i = paramInt + e.a.a.a.iP(3, this.xep.computeSize());
      }
      AppMethodBeat.o(123509);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123509);
          throw paramVarArgs;
        }
        if (this.xeo == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(123509);
          throw paramVarArgs;
        }
        if (this.xep == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfoExt");
          AppMethodBeat.o(123509);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aom localaom = (aom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123509);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaom.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123509);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new beq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((beq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaom.xeo = ((beq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123509);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cph();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cph)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaom.xep = ((cph)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123509);
        return 0;
      }
      AppMethodBeat.o(123509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aom
 * JD-Core Version:    0.7.0.1
 */