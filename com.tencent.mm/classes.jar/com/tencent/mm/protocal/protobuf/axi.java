package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class axi
  extends bvk
{
  public String fKw;
  public String wKV;
  public String wKW;
  public String wKX;
  public String wKY;
  public String wvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10202);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.wKV != null) {
        paramVarArgs.e(3, this.wKV);
      }
      if (this.wvC != null) {
        paramVarArgs.e(4, this.wvC);
      }
      if (this.wKW != null) {
        paramVarArgs.e(5, this.wKW);
      }
      if (this.wKX != null) {
        paramVarArgs.e(6, this.wKX);
      }
      if (this.wKY != null) {
        paramVarArgs.e(7, this.wKY);
      }
      AppMethodBeat.o(10202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label739;
      }
    }
    label739:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.wKV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wKV);
      }
      paramInt = i;
      if (this.wvC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvC);
      }
      i = paramInt;
      if (this.wKW != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKW);
      }
      paramInt = i;
      if (this.wKX != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKX);
      }
      i = paramInt;
      if (this.wKY != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKY);
      }
      AppMethodBeat.o(10202);
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
          AppMethodBeat.o(10202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axi localaxi = (axi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10202);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10202);
          return 0;
        case 2: 
          localaxi.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10202);
          return 0;
        case 3: 
          localaxi.wKV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10202);
          return 0;
        case 4: 
          localaxi.wvC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10202);
          return 0;
        case 5: 
          localaxi.wKW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10202);
          return 0;
        case 6: 
          localaxi.wKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10202);
          return 0;
        }
        localaxi.wKY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10202);
        return 0;
      }
      AppMethodBeat.o(10202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axi
 * JD-Core Version:    0.7.0.1
 */