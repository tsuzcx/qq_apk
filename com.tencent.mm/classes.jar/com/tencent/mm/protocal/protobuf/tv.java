package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class tv
  extends com.tencent.mm.bv.a
{
  public int wMq;
  public SKBuiltinBuffer_t wMr;
  public int wMs;
  public SKBuiltinBuffer_t wMt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(126189);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wMr == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(126189);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wMq);
      if (this.wMr != null)
      {
        paramVarArgs.iQ(2, this.wMr.computeSize());
        this.wMr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wMs);
      if (this.wMt != null)
      {
        paramVarArgs.iQ(4, this.wMt.computeSize());
        this.wMt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(126189);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wMq) + 0;
      paramInt = i;
      if (this.wMr != null) {
        paramInt = i + e.a.a.a.iP(2, this.wMr.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wMs);
      paramInt = i;
      if (this.wMt != null) {
        paramInt = i + e.a.a.a.iP(4, this.wMt.computeSize());
      }
      AppMethodBeat.o(126189);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wMr == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(126189);
        throw paramVarArgs;
      }
      AppMethodBeat.o(126189);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      tv localtv = (tv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(126189);
        return -1;
      case 1: 
        localtv.wMq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(126189);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localtv.wMr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(126189);
        return 0;
      case 3: 
        localtv.wMs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(126189);
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
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localtv.wMt = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(126189);
      return 0;
    }
    AppMethodBeat.o(126189);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */