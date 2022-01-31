package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class auk
  extends bvk
{
  public SKBuiltinBuffer_t wrK;
  public SKBuiltinBuffer_t xjv;
  public SKBuiltinBuffer_t xjw;
  public int xjx;
  public int xjy;
  public int xjz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28519);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28519);
        throw paramVarArgs;
      }
      if (this.wrK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(28519);
        throw paramVarArgs;
      }
      if (this.xjv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(28519);
        throw paramVarArgs;
      }
      if (this.xjw == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuffer");
        AppMethodBeat.o(28519);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wrK != null)
      {
        paramVarArgs.iQ(2, this.wrK.computeSize());
        this.wrK.writeFields(paramVarArgs);
      }
      if (this.xjv != null)
      {
        paramVarArgs.iQ(3, this.xjv.computeSize());
        this.xjv.writeFields(paramVarArgs);
      }
      if (this.xjw != null)
      {
        paramVarArgs.iQ(4, this.xjw.computeSize());
        this.xjw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xjx);
      paramVarArgs.aO(6, this.xjy);
      paramVarArgs.aO(7, this.xjz);
      AppMethodBeat.o(28519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1127;
      }
    }
    label1127:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrK != null) {
        paramInt = i + e.a.a.a.iP(2, this.wrK.computeSize());
      }
      i = paramInt;
      if (this.xjv != null) {
        i = paramInt + e.a.a.a.iP(3, this.xjv.computeSize());
      }
      paramInt = i;
      if (this.xjw != null) {
        paramInt = i + e.a.a.a.iP(4, this.xjw.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xjx);
      int j = e.a.a.b.b.a.bl(6, this.xjy);
      int k = e.a.a.b.b.a.bl(7, this.xjz);
      AppMethodBeat.o(28519);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(28519);
          throw paramVarArgs;
        }
        if (this.wrK == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(28519);
          throw paramVarArgs;
        }
        if (this.xjv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(28519);
          throw paramVarArgs;
        }
        if (this.xjw == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuffer");
          AppMethodBeat.o(28519);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        auk localauk = (auk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28519);
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
            localauk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28519);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauk.wrK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28519);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauk.xjv = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28519);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauk.xjw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28519);
          return 0;
        case 5: 
          localauk.xjx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28519);
          return 0;
        case 6: 
          localauk.xjy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28519);
          return 0;
        }
        localauk.xjz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28519);
        return 0;
      }
      AppMethodBeat.o(28519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auk
 * JD-Core Version:    0.7.0.1
 */