package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cib
  extends bvk
{
  public int wBX;
  public SKBuiltinBuffer_t wFR;
  public ue wFU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56546);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56546);
        throw paramVarArgs;
      }
      if (this.wFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(56546);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(56546);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wFU != null)
      {
        paramVarArgs.iQ(2, this.wFU.computeSize());
        this.wFU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wBX);
      if (this.wFR != null)
      {
        paramVarArgs.iQ(4, this.wFR.computeSize());
        this.wFR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56546);
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
      if (this.wFU != null) {
        i = paramInt + e.a.a.a.iP(2, this.wFU.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.wBX);
      paramInt = i;
      if (this.wFR != null) {
        paramInt = i + e.a.a.a.iP(4, this.wFR.computeSize());
      }
      AppMethodBeat.o(56546);
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
          AppMethodBeat.o(56546);
          throw paramVarArgs;
        }
        if (this.wFU == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(56546);
          throw paramVarArgs;
        }
        if (this.wFR == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(56546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56546);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cib localcib = (cib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56546);
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
            localcib.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56546);
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
            localcib.wFU = ((ue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56546);
          return 0;
        case 3: 
          localcib.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56546);
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
          localcib.wFR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56546);
        return 0;
      }
      AppMethodBeat.o(56546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cib
 * JD-Core Version:    0.7.0.1
 */