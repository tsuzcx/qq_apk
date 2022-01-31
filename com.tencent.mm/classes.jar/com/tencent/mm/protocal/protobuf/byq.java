package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class byq
  extends bvk
{
  public int CreateTime;
  public String fKw;
  public int jKs;
  public String nul;
  public String num;
  public int pIE;
  public long pIG;
  public String wDo;
  public String wpS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28630);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28630);
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
      if (this.num != null) {
        paramVarArgs.e(3, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(4, this.nul);
      }
      paramVarArgs.aO(5, this.pIE);
      if (this.wpS != null) {
        paramVarArgs.e(6, this.wpS);
      }
      paramVarArgs.aO(7, this.CreateTime);
      paramVarArgs.aO(8, this.jKs);
      paramVarArgs.am(9, this.pIG);
      if (this.wDo != null) {
        paramVarArgs.e(10, this.wDo);
      }
      AppMethodBeat.o(28630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label858;
      }
    }
    label858:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.num);
      }
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nul);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.pIE);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wpS);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.CreateTime) + e.a.a.b.b.a.bl(8, this.jKs) + e.a.a.b.b.a.p(9, this.pIG);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wDo);
      }
      AppMethodBeat.o(28630);
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
          AppMethodBeat.o(28630);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byq localbyq = (byq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28630);
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
            localbyq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28630);
          return 0;
        case 2: 
          localbyq.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28630);
          return 0;
        case 3: 
          localbyq.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28630);
          return 0;
        case 4: 
          localbyq.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28630);
          return 0;
        case 5: 
          localbyq.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28630);
          return 0;
        case 6: 
          localbyq.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28630);
          return 0;
        case 7: 
          localbyq.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28630);
          return 0;
        case 8: 
          localbyq.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28630);
          return 0;
        case 9: 
          localbyq.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28630);
          return 0;
        }
        localbyq.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28630);
        return 0;
      }
      AppMethodBeat.o(28630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byq
 * JD-Core Version:    0.7.0.1
 */