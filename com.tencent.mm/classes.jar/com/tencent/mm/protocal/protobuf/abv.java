package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class abv
  extends bvk
{
  public int eeF;
  public String wQf;
  public String wot;
  public LinkedList<abw> wov;
  
  public abv()
  {
    AppMethodBeat.i(28404);
    this.wov = new LinkedList();
    AppMethodBeat.o(28404);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28405);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28405);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(2, this.wQf);
      }
      paramVarArgs.aO(3, this.eeF);
      paramVarArgs.e(4, 8, this.wov);
      if (this.wot != null) {
        paramVarArgs.e(5, this.wot);
      }
      AppMethodBeat.o(28405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label673;
      }
    }
    label673:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wQf);
      }
      i = i + e.a.a.b.b.a.bl(3, this.eeF) + e.a.a.a.c(4, 8, this.wov);
      paramInt = i;
      if (this.wot != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wot);
      }
      AppMethodBeat.o(28405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28405);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abv localabv = (abv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28405);
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
            localabv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28405);
          return 0;
        case 2: 
          localabv.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28405);
          return 0;
        case 3: 
          localabv.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28405);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localabv.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28405);
          return 0;
        }
        localabv.wot = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28405);
        return 0;
      }
      AppMethodBeat.o(28405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abv
 * JD-Core Version:    0.7.0.1
 */