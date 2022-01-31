package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bix
  extends bvk
{
  public SKBuiltinBuffer_t xxw;
  public ue xxx;
  public int xxy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80150);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80150);
        throw paramVarArgs;
      }
      if (this.xxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: cmd_list");
        AppMethodBeat.o(80150);
        throw paramVarArgs;
      }
      if (this.xxw == null)
      {
        paramVarArgs = new b("Not all required fields were included: key_buf");
        AppMethodBeat.o(80150);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xxx != null)
      {
        paramVarArgs.iQ(2, this.xxx.computeSize());
        this.xxx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xxy);
      if (this.xxw != null)
      {
        paramVarArgs.iQ(4, this.xxw.computeSize());
        this.xxw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80150);
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
      int i = paramInt;
      if (this.xxx != null) {
        i = paramInt + e.a.a.a.iP(2, this.xxx.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.xxy);
      paramInt = i;
      if (this.xxw != null) {
        paramInt = i + e.a.a.a.iP(4, this.xxw.computeSize());
      }
      AppMethodBeat.o(80150);
      return paramInt;
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
          AppMethodBeat.o(80150);
          throw paramVarArgs;
        }
        if (this.xxx == null)
        {
          paramVarArgs = new b("Not all required fields were included: cmd_list");
          AppMethodBeat.o(80150);
          throw paramVarArgs;
        }
        if (this.xxw == null)
        {
          paramVarArgs = new b("Not all required fields were included: key_buf");
          AppMethodBeat.o(80150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bix localbix = (bix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80150);
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
            localbix.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80150);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ue();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbix.xxx = ((ue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80150);
          return 0;
        case 3: 
          localbix.xxy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80150);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbix.xxw = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80150);
        return 0;
      }
      AppMethodBeat.o(80150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bix
 * JD-Core Version:    0.7.0.1
 */