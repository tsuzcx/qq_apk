package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class agx
  extends bvk
{
  public int result;
  public awa wZx;
  public String wZy;
  public avv wZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10174);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10174);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wZx != null)
      {
        paramVarArgs.iQ(2, this.wZx.computeSize());
        this.wZx.writeFields(paramVarArgs);
      }
      if (this.wZy != null) {
        paramVarArgs.e(3, this.wZy);
      }
      if (this.wZz != null)
      {
        paramVarArgs.iQ(4, this.wZz.computeSize());
        this.wZz.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.result);
      AppMethodBeat.o(10174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label785;
      }
    }
    label785:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wZx != null) {
        paramInt = i + e.a.a.a.iP(2, this.wZx.computeSize());
      }
      i = paramInt;
      if (this.wZy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wZy);
      }
      paramInt = i;
      if (this.wZz != null) {
        paramInt = i + e.a.a.a.iP(4, this.wZz.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.result);
      AppMethodBeat.o(10174);
      return paramInt + i;
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
          AppMethodBeat.o(10174);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10174);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agx localagx = (agx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10174);
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
            localagx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10174);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awa();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awa)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagx.wZx = ((awa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10174);
          return 0;
        case 3: 
          localagx.wZy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10174);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagx.wZz = ((avv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10174);
          return 0;
        }
        localagx.result = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10174);
        return 0;
      }
      AppMethodBeat.o(10174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */