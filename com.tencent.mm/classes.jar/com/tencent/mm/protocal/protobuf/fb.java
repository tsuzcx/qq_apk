package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fb
  extends bvk
{
  public com.tencent.mm.bv.b wre;
  public int wrj;
  public int wrk;
  public fg wrl;
  public fc wrm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28315);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28315);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wrj);
      paramVarArgs.aO(3, this.wrk);
      if (this.wre != null) {
        paramVarArgs.c(4, this.wre);
      }
      if (this.wrl != null)
      {
        paramVarArgs.iQ(5, this.wrl.computeSize());
        this.wrl.writeFields(paramVarArgs);
      }
      if (this.wrm != null)
      {
        paramVarArgs.iQ(6, this.wrm.computeSize());
        this.wrm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wrj) + e.a.a.b.b.a.bl(3, this.wrk);
      paramInt = i;
      if (this.wre != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.wre);
      }
      i = paramInt;
      if (this.wrl != null) {
        i = paramInt + e.a.a.a.iP(5, this.wrl.computeSize());
      }
      paramInt = i;
      if (this.wrm != null) {
        paramInt = i + e.a.a.a.iP(6, this.wrm.computeSize());
      }
      AppMethodBeat.o(28315);
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fb localfb = (fb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28315);
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
            localfb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28315);
          return 0;
        case 2: 
          localfb.wrj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28315);
          return 0;
        case 3: 
          localfb.wrk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28315);
          return 0;
        case 4: 
          localfb.wre = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(28315);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localfb.wrl = ((fg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28315);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localfb.wrm = ((fc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28315);
        return 0;
      }
      AppMethodBeat.o(28315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fb
 * JD-Core Version:    0.7.0.1
 */