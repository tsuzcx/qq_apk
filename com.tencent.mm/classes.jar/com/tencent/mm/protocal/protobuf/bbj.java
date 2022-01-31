package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bbj
  extends bvk
{
  public String kVV;
  public String kVW;
  public String sign;
  public String uVJ;
  public int uVK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10217);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10217);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.uVJ != null) {
        paramVarArgs.e(2, this.uVJ);
      }
      if (this.kVV != null) {
        paramVarArgs.e(3, this.kVV);
      }
      if (this.kVW != null) {
        paramVarArgs.e(4, this.kVW);
      }
      if (this.sign != null) {
        paramVarArgs.e(5, this.sign);
      }
      paramVarArgs.aO(6, this.uVK);
      AppMethodBeat.o(10217);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uVJ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.uVJ);
      }
      i = paramInt;
      if (this.kVV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kVV);
      }
      paramInt = i;
      if (this.kVW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kVW);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.sign);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.uVK);
      AppMethodBeat.o(10217);
      return i + paramInt;
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
          AppMethodBeat.o(10217);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10217);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bbj localbbj = (bbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10217);
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
            localbbj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10217);
          return 0;
        case 2: 
          localbbj.uVJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10217);
          return 0;
        case 3: 
          localbbj.kVV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10217);
          return 0;
        case 4: 
          localbbj.kVW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10217);
          return 0;
        case 5: 
          localbbj.sign = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10217);
          return 0;
        }
        localbbj.uVK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10217);
        return 0;
      }
      AppMethodBeat.o(10217);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbj
 * JD-Core Version:    0.7.0.1
 */