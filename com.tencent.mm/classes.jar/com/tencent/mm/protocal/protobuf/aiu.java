package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aiu
  extends bvk
{
  public int jJS;
  public int xaA;
  public int xav;
  public int xaw;
  public int xax;
  public int xay;
  public String xaz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5584);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5584);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJS);
      paramVarArgs.aO(3, this.xav);
      paramVarArgs.aO(4, this.xaw);
      paramVarArgs.aO(5, this.xax);
      paramVarArgs.aO(6, this.xay);
      if (this.xaz != null) {
        paramVarArgs.e(7, this.xaz);
      }
      paramVarArgs.aO(8, this.xaA);
      AppMethodBeat.o(5584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJS) + e.a.a.b.b.a.bl(3, this.xav) + e.a.a.b.b.a.bl(4, this.xaw) + e.a.a.b.b.a.bl(5, this.xax) + e.a.a.b.b.a.bl(6, this.xay);
      paramInt = i;
      if (this.xaz != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xaz);
      }
      i = e.a.a.b.b.a.bl(8, this.xaA);
      AppMethodBeat.o(5584);
      return paramInt + i;
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
          AppMethodBeat.o(5584);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aiu localaiu = (aiu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5584);
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
            localaiu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5584);
          return 0;
        case 2: 
          localaiu.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5584);
          return 0;
        case 3: 
          localaiu.xav = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5584);
          return 0;
        case 4: 
          localaiu.xaw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5584);
          return 0;
        case 5: 
          localaiu.xax = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5584);
          return 0;
        case 6: 
          localaiu.xay = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5584);
          return 0;
        case 7: 
          localaiu.xaz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5584);
          return 0;
        }
        localaiu.xaA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5584);
        return 0;
      }
      AppMethodBeat.o(5584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiu
 * JD-Core Version:    0.7.0.1
 */