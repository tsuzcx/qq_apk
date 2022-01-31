package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class coe
  extends bvk
{
  public int pIx;
  public int pIy;
  public String wJq;
  public String wJr;
  public String xWV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80202);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIx);
      paramVarArgs.aO(3, this.pIy);
      if (this.xWV != null) {
        paramVarArgs.e(4, this.xWV);
      }
      if (this.wJq != null) {
        paramVarArgs.e(5, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(6, this.wJr);
      }
      AppMethodBeat.o(80202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIx) + e.a.a.b.b.a.bl(3, this.pIy);
      paramInt = i;
      if (this.xWV != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xWV);
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wJr);
      }
      AppMethodBeat.o(80202);
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
          AppMethodBeat.o(80202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        coe localcoe = (coe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80202);
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
            localcoe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80202);
          return 0;
        case 2: 
          localcoe.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80202);
          return 0;
        case 3: 
          localcoe.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80202);
          return 0;
        case 4: 
          localcoe.xWV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80202);
          return 0;
        case 5: 
          localcoe.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80202);
          return 0;
        }
        localcoe.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80202);
        return 0;
      }
      AppMethodBeat.o(80202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coe
 * JD-Core Version:    0.7.0.1
 */