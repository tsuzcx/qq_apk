package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cns
  extends bvk
{
  public int xaA;
  public int xav;
  public int xaw;
  public int xax;
  public int xay;
  public String xaz;
  public String xts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5605);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5605);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xts != null) {
        paramVarArgs.e(2, this.xts);
      }
      if (this.xaz != null) {
        paramVarArgs.e(3, this.xaz);
      }
      paramVarArgs.aO(4, this.xay);
      paramVarArgs.aO(5, this.xav);
      paramVarArgs.aO(6, this.xaw);
      paramVarArgs.aO(7, this.xax);
      paramVarArgs.aO(8, this.xaA);
      AppMethodBeat.o(5605);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label728;
      }
    }
    label728:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xts != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xts);
      }
      i = paramInt;
      if (this.xaz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xaz);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xay);
      int j = e.a.a.b.b.a.bl(5, this.xav);
      int k = e.a.a.b.b.a.bl(6, this.xaw);
      int m = e.a.a.b.b.a.bl(7, this.xax);
      int n = e.a.a.b.b.a.bl(8, this.xaA);
      AppMethodBeat.o(5605);
      return i + paramInt + j + k + m + n;
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
          AppMethodBeat.o(5605);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5605);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cns localcns = (cns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5605);
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
            localcns.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5605);
          return 0;
        case 2: 
          localcns.xts = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5605);
          return 0;
        case 3: 
          localcns.xaz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5605);
          return 0;
        case 4: 
          localcns.xay = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5605);
          return 0;
        case 5: 
          localcns.xav = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5605);
          return 0;
        case 6: 
          localcns.xaw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5605);
          return 0;
        case 7: 
          localcns.xax = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5605);
          return 0;
        }
        localcns.xaA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5605);
        return 0;
      }
      AppMethodBeat.o(5605);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cns
 * JD-Core Version:    0.7.0.1
 */