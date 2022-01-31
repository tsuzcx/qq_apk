package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aoo
  extends bvk
{
  public int nrS;
  public bpc xer;
  public bpa xes;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73712);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73712);
        throw paramVarArgs;
      }
      if (this.xer == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(73712);
        throw paramVarArgs;
      }
      if (this.xes == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(73712);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.nrS);
      if (this.xer != null)
      {
        paramVarArgs.iQ(3, this.xer.computeSize());
        this.xer.writeFields(paramVarArgs);
      }
      if (this.xes != null)
      {
        paramVarArgs.iQ(4, this.xes.computeSize());
        this.xes.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(73712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nrS);
      paramInt = i;
      if (this.xer != null) {
        paramInt = i + e.a.a.a.iP(3, this.xer.computeSize());
      }
      i = paramInt;
      if (this.xes != null) {
        i = paramInt + e.a.a.a.iP(4, this.xes.computeSize());
      }
      AppMethodBeat.o(73712);
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
          AppMethodBeat.o(73712);
          throw paramVarArgs;
        }
        if (this.xer == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(73712);
          throw paramVarArgs;
        }
        if (this.xes == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(73712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aoo localaoo = (aoo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73712);
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
            localaoo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73712);
          return 0;
        case 2: 
          localaoo.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73712);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaoo.xer = ((bpc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73712);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaoo.xes = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73712);
        return 0;
      }
      AppMethodBeat.o(73712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoo
 * JD-Core Version:    0.7.0.1
 */