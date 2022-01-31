package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ayu
  extends buy
{
  public SKBuiltinBuffer_t wvN;
  public int xos;
  public SKBuiltinBuffer_t xot;
  public SKBuiltinBuffer_t xou;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72859);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xot == null)
      {
        paramVarArgs = new b("Not all required fields were included: KVBuffer");
        AppMethodBeat.o(72859);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xos);
      if (this.xot != null)
      {
        paramVarArgs.iQ(3, this.xot.computeSize());
        this.xot.writeFields(paramVarArgs);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(4, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.xou != null)
      {
        paramVarArgs.iQ(5, this.xou.computeSize());
        this.xou.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xos);
      paramInt = i;
      if (this.xot != null) {
        paramInt = i + e.a.a.a.iP(3, this.xot.computeSize());
      }
      i = paramInt;
      if (this.wvN != null) {
        i = paramInt + e.a.a.a.iP(4, this.wvN.computeSize());
      }
      paramInt = i;
      if (this.xou != null) {
        paramInt = i + e.a.a.a.iP(5, this.xou.computeSize());
      }
      AppMethodBeat.o(72859);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xot == null)
        {
          paramVarArgs = new b("Not all required fields were included: KVBuffer");
          AppMethodBeat.o(72859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ayu localayu = (ayu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72859);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localayu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72859);
          return 0;
        case 2: 
          localayu.xos = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(72859);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localayu.xot = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72859);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localayu.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72859);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localayu.xou = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72859);
        return 0;
      }
      AppMethodBeat.o(72859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayu
 * JD-Core Version:    0.7.0.1
 */