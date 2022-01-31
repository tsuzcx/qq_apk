package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bkq
  extends bvk
{
  public int lGK;
  public String lGL;
  public String wXQ;
  public String wXR;
  public cvm wXW;
  public String xzr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56877);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wXR != null) {
        paramVarArgs.e(2, this.wXR);
      }
      paramVarArgs.aO(3, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(4, this.lGL);
      }
      if (this.wXQ != null) {
        paramVarArgs.e(5, this.wXQ);
      }
      if (this.xzr != null) {
        paramVarArgs.e(6, this.xzr);
      }
      if (this.wXW != null)
      {
        paramVarArgs.iQ(7, this.wXW.computeSize());
        this.wXW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wXR != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wXR);
      }
      i += e.a.a.b.b.a.bl(3, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.lGL);
      }
      i = paramInt;
      if (this.wXQ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wXQ);
      }
      paramInt = i;
      if (this.xzr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xzr);
      }
      i = paramInt;
      if (this.wXW != null) {
        i = paramInt + e.a.a.a.iP(7, this.wXW.computeSize());
      }
      AppMethodBeat.o(56877);
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
          AppMethodBeat.o(56877);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bkq localbkq = (bkq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56877);
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
            localbkq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56877);
          return 0;
        case 2: 
          localbkq.wXR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56877);
          return 0;
        case 3: 
          localbkq.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56877);
          return 0;
        case 4: 
          localbkq.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56877);
          return 0;
        case 5: 
          localbkq.wXQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56877);
          return 0;
        case 6: 
          localbkq.xzr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56877);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbkq.wXW = ((cvm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56877);
        return 0;
      }
      AppMethodBeat.o(56877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkq
 * JD-Core Version:    0.7.0.1
 */