package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bly
  extends bvk
{
  public String lGL;
  public String wXQ;
  public String wXR;
  public String woC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56912);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56912);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wXQ != null) {
        paramVarArgs.e(2, this.wXQ);
      }
      if (this.wXR != null) {
        paramVarArgs.e(3, this.wXR);
      }
      if (this.woC != null) {
        paramVarArgs.e(4, this.woC);
      }
      if (this.lGL != null) {
        paramVarArgs.e(5, this.lGL);
      }
      AppMethodBeat.o(56912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wXQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wXQ);
      }
      i = paramInt;
      if (this.wXR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wXR);
      }
      paramInt = i;
      if (this.woC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.woC);
      }
      i = paramInt;
      if (this.lGL != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.lGL);
      }
      AppMethodBeat.o(56912);
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
          AppMethodBeat.o(56912);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bly localbly = (bly)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56912);
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
            localbly.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56912);
          return 0;
        case 2: 
          localbly.wXQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56912);
          return 0;
        case 3: 
          localbly.wXR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56912);
          return 0;
        case 4: 
          localbly.woC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56912);
          return 0;
        }
        localbly.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56912);
        return 0;
      }
      AppMethodBeat.o(56912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bly
 * JD-Core Version:    0.7.0.1
 */