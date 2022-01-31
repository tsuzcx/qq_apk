package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bps
  extends bvk
{
  public int koj;
  public String kok;
  public String xAJ;
  public String xAK;
  public np xcg;
  public avg xci;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48938);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48938);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.xci != null)
      {
        paramVarArgs.iQ(4, this.xci.computeSize());
        this.xci.writeFields(paramVarArgs);
      }
      if (this.xAJ != null) {
        paramVarArgs.e(5, this.xAJ);
      }
      if (this.xAK != null) {
        paramVarArgs.e(6, this.xAK);
      }
      if (this.xcg != null)
      {
        paramVarArgs.iQ(7, this.xcg.computeSize());
        this.xcg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xci != null) {
        i = paramInt + e.a.a.a.iP(4, this.xci.computeSize());
      }
      paramInt = i;
      if (this.xAJ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xAJ);
      }
      i = paramInt;
      if (this.xAK != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xAK);
      }
      paramInt = i;
      if (this.xcg != null) {
        paramInt = i + e.a.a.a.iP(7, this.xcg.computeSize());
      }
      AppMethodBeat.o(48938);
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
          AppMethodBeat.o(48938);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bps localbps = (bps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48938);
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
            localbps.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48938);
          return 0;
        case 2: 
          localbps.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48938);
          return 0;
        case 3: 
          localbps.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48938);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbps.xci = ((avg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48938);
          return 0;
        case 5: 
          localbps.xAJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48938);
          return 0;
        case 6: 
          localbps.xAK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48938);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new np();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbps.xcg = ((np)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48938);
        return 0;
      }
      AppMethodBeat.o(48938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bps
 * JD-Core Version:    0.7.0.1
 */