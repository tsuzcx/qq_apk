package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class byv
  extends buy
{
  public auh wvw;
  public aul xLc;
  public SKBuiltinBuffer_t xjv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28631);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(28631);
        throw paramVarArgs;
      }
      if (this.xLc == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
        AppMethodBeat.o(28631);
        throw paramVarArgs;
      }
      if (this.xjv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(28631);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvw != null)
      {
        paramVarArgs.iQ(2, this.wvw.computeSize());
        this.wvw.writeFields(paramVarArgs);
      }
      if (this.xLc != null)
      {
        paramVarArgs.iQ(3, this.xLc.computeSize());
        this.xLc.writeFields(paramVarArgs);
      }
      if (this.xjv != null)
      {
        paramVarArgs.iQ(4, this.xjv.computeSize());
        this.xjv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label932;
      }
    }
    label932:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvw != null) {
        paramInt = i + e.a.a.a.iP(2, this.wvw.computeSize());
      }
      i = paramInt;
      if (this.xLc != null) {
        i = paramInt + e.a.a.a.iP(3, this.xLc.computeSize());
      }
      paramInt = i;
      if (this.xjv != null) {
        paramInt = i + e.a.a.a.iP(4, this.xjv.computeSize());
      }
      AppMethodBeat.o(28631);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(28631);
          throw paramVarArgs;
        }
        if (this.xLc == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
          AppMethodBeat.o(28631);
          throw paramVarArgs;
        }
        if (this.xjv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(28631);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byv localbyv = (byv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28631);
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
            localbyv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28631);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyv.wvw = ((auh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28631);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aul();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aul)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbyv.xLc = ((aul)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28631);
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
          localbyv.xjv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28631);
        return 0;
      }
      AppMethodBeat.o(28631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byv
 * JD-Core Version:    0.7.0.1
 */