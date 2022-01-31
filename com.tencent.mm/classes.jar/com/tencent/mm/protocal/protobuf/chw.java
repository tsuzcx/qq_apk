package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chw
  extends buy
{
  public String pIw;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t xSx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56541);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xSx == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(56541);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xSx != null)
      {
        paramVarArgs.iQ(2, this.xSx.computeSize());
        this.xSx.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(3, this.pIw);
      }
      if (this.wsr != null)
      {
        paramVarArgs.iQ(4, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xSx != null) {
        paramInt = i + e.a.a.a.iP(2, this.xSx.computeSize());
      }
      i = paramInt;
      if (this.pIw != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.pIw);
      }
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(4, this.wsr.computeSize());
      }
      AppMethodBeat.o(56541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xSx == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjDesc");
          AppMethodBeat.o(56541);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chw localchw = (chw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56541);
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
            localchw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56541);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchw.xSx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56541);
          return 0;
        case 3: 
          localchw.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56541);
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
          localchw.wsr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56541);
        return 0;
      }
      AppMethodBeat.o(56541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chw
 * JD-Core Version:    0.7.0.1
 */