package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class adt
  extends bvk
{
  public int wWI;
  public String wWJ;
  public String wWK;
  public int wWL;
  public String wWM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56797);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56797);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wWI);
      if (this.wWJ != null) {
        paramVarArgs.e(3, this.wWJ);
      }
      if (this.wWK != null) {
        paramVarArgs.e(4, this.wWK);
      }
      paramVarArgs.aO(5, this.wWL);
      if (this.wWM != null) {
        paramVarArgs.e(6, this.wWM);
      }
      AppMethodBeat.o(56797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wWI);
      paramInt = i;
      if (this.wWJ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wWJ);
      }
      i = paramInt;
      if (this.wWK != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wWK);
      }
      i += e.a.a.b.b.a.bl(5, this.wWL);
      paramInt = i;
      if (this.wWM != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wWM);
      }
      AppMethodBeat.o(56797);
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
          AppMethodBeat.o(56797);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        adt localadt = (adt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56797);
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
            localadt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56797);
          return 0;
        case 2: 
          localadt.wWI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56797);
          return 0;
        case 3: 
          localadt.wWJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56797);
          return 0;
        case 4: 
          localadt.wWK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56797);
          return 0;
        case 5: 
          localadt.wWL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56797);
          return 0;
        }
        localadt.wWM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56797);
        return 0;
      }
      AppMethodBeat.o(56797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adt
 * JD-Core Version:    0.7.0.1
 */