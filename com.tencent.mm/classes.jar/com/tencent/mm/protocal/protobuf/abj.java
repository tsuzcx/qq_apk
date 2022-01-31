package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class abj
  extends bvk
{
  public int cnK;
  public String kNv;
  public String lHq;
  public String ojA;
  public String okT;
  public String okU;
  public int wRM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56787);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56787);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.ojA != null) {
        paramVarArgs.e(4, this.ojA);
      }
      if (this.lHq != null) {
        paramVarArgs.e(5, this.lHq);
      }
      paramVarArgs.aO(6, this.wRM);
      if (this.okU != null) {
        paramVarArgs.e(7, this.okU);
      }
      if (this.okT != null) {
        paramVarArgs.e(8, this.okT);
      }
      AppMethodBeat.o(56787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.ojA != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ojA);
      }
      paramInt = i;
      if (this.lHq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.lHq);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wRM);
      paramInt = i;
      if (this.okU != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.okU);
      }
      i = paramInt;
      if (this.okT != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.okT);
      }
      AppMethodBeat.o(56787);
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
          AppMethodBeat.o(56787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abj localabj = (abj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56787);
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
            localabj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56787);
          return 0;
        case 2: 
          localabj.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56787);
          return 0;
        case 3: 
          localabj.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56787);
          return 0;
        case 4: 
          localabj.ojA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56787);
          return 0;
        case 5: 
          localabj.lHq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56787);
          return 0;
        case 6: 
          localabj.wRM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56787);
          return 0;
        case 7: 
          localabj.okU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56787);
          return 0;
        }
        localabj.okT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56787);
        return 0;
      }
      AppMethodBeat.o(56787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abj
 * JD-Core Version:    0.7.0.1
 */